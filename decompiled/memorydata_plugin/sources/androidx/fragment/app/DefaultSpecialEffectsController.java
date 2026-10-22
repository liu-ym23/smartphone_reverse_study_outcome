package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = null;

        static {
            int[] r0 = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r0;
            r0[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(SpecialEffectsController.Operation r1, CancellationSignal r2, boolean r3) {
            super(r1, r2);
            this.mLoadedAnim = false;
            this.mIsPop = r3;
        }

        FragmentAnim.AnimationOrAnimator getAnimation(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            if (this.mLoadedAnim == true) goto L5;
            Fragment r0 = getOperation().getFragment();
            if (getOperation().getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L9;
            boolean r1 = true;
        L10:
            FragmentAnim.AnimationOrAnimator r7 = FragmentAnim.loadAnimation(r6, r0, r1, this.mIsPop);
            this.mAnimation = r7;
            this.mLoadedAnim = true;
            return r7;
        L9:
            r1 = false;
            goto L10
        L5:
            return this.mAnimation;
        }
    }

    private static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation mOperation;
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(SpecialEffectsController.Operation r1, CancellationSignal r2) {
            this.mOperation = r1;
            this.mSignal = r2;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State r0 = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State r2 = this.mOperation.getFinalState();
            if (r0 != r2) goto L5;
        L10:
            return true;
        L5:
            if (r0 != SpecialEffectsController.Operation.State.VISIBLE) goto L7;
        L9:
            return false;
        L7:
            if (r2 == SpecialEffectsController.Operation.State.VISIBLE) goto L9;
            goto L9
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final Object mSharedElementTransition;
        private final Object mTransition;

        TransitionInfo(SpecialEffectsController.Operation r2, CancellationSignal r3, boolean r4, boolean r5) {
            super(r2, r3);
            if (r2.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L12;
            Fragment r6 = r2.getFragment();
            if (r4 == false) goto L7;
            Object r7 = r6.getReenterTransition();
        L8:
            this.mTransition = r7;
            Fragment r8 = r2.getFragment();
            if (r4 == false) goto L11;
            boolean r9 = r8.getAllowReturnTransitionOverlap();
        L17:
            this.mOverlapAllowed = r9;
            if (r5 == false) goto L23;
            Fragment r10 = r2.getFragment();
            if (r4 == false) goto L22;
            Object r11 = r10.getSharedElementReturnTransition();
        L24:
            this.mSharedElementTransition = r11;
            return;
        L22:
            r11 = r10.getSharedElementEnterTransition();
            goto L24
        L23:
            r11 = null;
            goto L24
        L11:
            r9 = r8.getAllowEnterTransitionOverlap();
            goto L17
        L7:
            r7 = r6.getEnterTransition();
            goto L8
        L12:
            Fragment r12 = r2.getFragment();
            if (r4 == false) goto L15;
            Object r13 = r12.getReturnTransition();
        L16:
            this.mTransition = r13;
            r9 = true;
            goto L17
        L15:
            r13 = r12.getExitTransition();
            goto L16
        }

        private FragmentTransitionImpl getHandlingImpl(Object r4) {
            if (r4 != null) goto L6;
            return null;
        L6:
            if (FragmentTransition.PLATFORM_IMPL == null) goto L12;
            if (FragmentTransition.PLATFORM_IMPL.canHandle(r4) == false) goto L12;
            return FragmentTransition.PLATFORM_IMPL;
        L12:
            if (FragmentTransition.SUPPORT_IMPL == null) goto L18;
            if (FragmentTransition.SUPPORT_IMPL.canHandle(r4) == false) goto L18;
            return FragmentTransition.SUPPORT_IMPL;
        L18:
            throw new IllegalArgumentException("Transition " + r4 + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }

        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl r0 = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl r1 = getHandlingImpl(this.mSharedElementTransition);
            if (r0 == null) goto L9;
            if (r1 == null) goto L9;
            if (r0 == r1) goto L9;
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        L9:
            if (r0 == null) goto L12;
            return r0;
        L12:
            return r1;
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            if (this.mSharedElementTransition == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }
    }

    DefaultSpecialEffectsController(ViewGroup r1) {
        super(r1);
    }

    private void startAnimations(List<AnimationInfo> r22, List<SpecialEffectsController.Operation> r23, boolean r24, Map<SpecialEffectsController.Operation, Boolean> r25) {
        String r1 = "com.obric.memorydata.plugin";
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        final ViewGroup r11 = getContainer();
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        ArrayList r13 = new ArrayList();
        Iterator r4 = r0.iterator();
        boolean r10 = false;
    L4:
        if (r4.hasNext() == false) goto L30;
        final AnimationInfo r7 = (AnimationInfo) ZeusTransformUtils.preCheckCast(r4.next(), AnimationInfo.class, "com.obric.memorydata.plugin");
        if (r7.isVisibilityUnchanged() == true) goto L7;
        FragmentAnim.AnimationOrAnimator r5 = r7.getAnimation(r12);
        if (r5 == null) goto L7;
        final Animator r6 = r5.animator;
        if (r6 != null) goto L14;
        r13.add(r7);
        goto L4
    L14:
        final SpecialEffectsController.Operation r8 = r7.getOperation();
        Fragment r9 = r8.getFragment();
        if (Boolean.TRUE.equals(r3.get(r8)) == true) goto L17;
        if (r8.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L25;
        r2.remove(r8);
    L25:
        final View r15 = r9.mView;
        r11.startViewTransition(r15);
        Iterator r17 = r4;
        List r19 = r2;
        final boolean r16 = r14;
        Map r20 = r3;
        r6.addListener(new AnonymousClass2(this, r11, r15, r16, r8, r7));
        r6.setTarget(r15);
        r6.start();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L28;
        final SpecialEffectsController.Operation r18 = r8;
        Log.v(FragmentManager.TAG, "Animator from operation " + r18 + " has started.");
    L29:
        r7.getSignal().setOnCancelListener(new AnonymousClass3(this, r6, r18));
        r4 = r17;
        r2 = r19;
        r3 = r20;
        r10 = true;
        goto L4
    L28:
        r18 = r8;
        goto L29
    L22:
        r14 = false;
        goto L23
    L17:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        Log.v(FragmentManager.TAG, "Ignoring Animator set on " + r9 + " as this Fragment was involved in a Transition.");
    L7:
        r7.completeSpecialEffect();
        goto L4
    L30:
        Iterator r21 = r13.iterator();
    L32:
        if (r21.hasNext() == false) goto L51;
        final AnimationInfo r110 = (AnimationInfo) ZeusTransformUtils.preCheckCast(r21.next(), AnimationInfo.class, r1);
        final SpecialEffectsController.Operation r111 = r110.getOperation();
        Fragment r26 = r111.getFragment();
        if (r24 == true) goto L36;
        if (r10 == true) goto L42;
        final View r27 = r26.mView;
        Animation r28 = (Animation) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r110.getAnimation(r12)), FragmentAnim.AnimationOrAnimator.class, r1)).animation), Animation.class, r1);
        if (r111.getFinalState() == SpecialEffectsController.Operation.State.REMOVED) goto L47;
        r27.startAnimation(r28);
        r110.completeSpecialEffect();
        Iterator r29 = r21;
        String r112 = r1;
        boolean r210 = r10;
        View r113 = r27;
    L50:
        final View r30 = r113;
        r110.getSignal().setOnCancelListener(new AnonymousClass5(this, r30, r11, r110, r111));
        r21 = r29;
        r10 = r210;
        r1 = r112;
        goto L32
    L47:
        r11.startViewTransition(r27);
        FragmentAnim.EndViewTransitionAnimation r31 = new FragmentAnim.EndViewTransitionAnimation(r28, r11, r27);
        r29 = r21;
        r112 = r1;
        r210 = r10;
        r113 = r27;
        r31.setAnimationListener(new AnonymousClass4(this, r111, r11, r27, r110));
        r113.startAnimation(r31);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L50;
        Log.v(FragmentManager.TAG, "Animation from operation " + r111 + " has started.");
        goto L50
    L42:
        if (FragmentManager.isLoggingEnabled(2) == true) goto L43;
    L39:
        r110.completeSpecialEffect();
        goto L32
    L43:
        StringBuilder r32 = new StringBuilder().append("Ignoring Animation set on ").append(r26);
        String r33 = " as Animations cannot run alongside Animators.";
    L38:
        Log.v(FragmentManager.TAG, r32.append(r33).toString());
        goto L39
    L36:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L39;
        r32 = new StringBuilder().append("Ignoring Animation set on ").append(r26);
        r33 = " as Animations cannot run alongside Transitions.";
        goto L38
    }

    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> r35, List<SpecialEffectsController.Operation> r36, final boolean r37, final SpecialEffectsController.Operation r38, final SpecialEffectsController.Operation r39) {
        SpecialEffectsController.Operation r8 = r38;
        SpecialEffectsController.Operation r9 = r39;
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r36, List.class, "com.obric.memorydata.plugin");
        HashMap r13 = new HashMap();
        Iterator r0 = r11.iterator();
        FragmentTransitionImpl r15 = null;
    L4:
        if (r0.hasNext() == false) goto L17;
        TransitionInfo r1 = (TransitionInfo) ZeusTransformUtils.preCheckCast(r0.next(), TransitionInfo.class, "com.obric.memorydata.plugin");
        if (r1.isVisibilityUnchanged() == true) goto L4;
        FragmentTransitionImpl r2 = r1.getHandlingImpl();
        if (r15 == null) goto L10;
        if (r2 == null) goto L4;
        if (r15 == r2) goto L4;
        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r1.getOperation().getFragment() + " returned Transition " + r1.getTransition() + " which uses a different Transition  type than other Fragments.");
    L10:
        r15 = r2;
        goto L4
    L17:
        if (r15 != null) goto L23;
        Iterator r3 = r11.iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        TransitionInfo r4 = (TransitionInfo) ZeusTransformUtils.preCheckCast(r3.next(), TransitionInfo.class, "com.obric.memorydata.plugin");
        r13.put(r4.getOperation(), false);
        r4.completeSpecialEffect();
        goto L20
    L22:
        return r13;
    L23:
        View r5 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContainer().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        Rect r6 = new Rect();
        ArrayList<View> r7 = new ArrayList();
        ArrayList<View> r10 = new ArrayList();
        ArrayMap r14 = new ArrayMap();
        Iterator r23 = r11.iterator();
        boolean r24 = false;
        Object r16 = null;
        View r17 = null;
    L24:
        boolean r18 = r23.hasNext();
        View r26 = r17;
        String r19 = FragmentManager.TAG;
        if (r18 == false) goto L105;
        Rect r110 = r6;
        View r111 = r5;
        TransitionInfo r20 = (TransitionInfo) ZeusTransformUtils.preCheckCast(r23.next(), TransitionInfo.class, "com.obric.memorydata.plugin");
        if (r20.hasSharedElementTransition() == false) goto L103;
        if (r8 == null) goto L103;
        if (r9 == null) goto L103;
        Object r21 = r15.wrapTransitionInSet(r15.cloneTransition(r20.getSharedElementTransition()));
        ArrayList<String> r22 = r39.getFragment().getSharedElementSourceNames();
        ArrayList<String> r25 = r38.getFragment().getSharedElementSourceNames();
        ArrayList<String> r27 = r38.getFragment().getSharedElementTargetNames();
        List r28 = r11;
        List r29 = r12;
        int r112 = 0;
    L32:
        if (r112 >= r27.size()) goto L38;
        int r113 = r22.indexOf(r27.get(r112));
        ArrayList<String> r114 = r27;
        if (r113 == (-1)) goto L37;
        r22.set(r113, (String) ZeusTransformUtils.preCheckCast(r25.get(r112), String.class, "com.obric.memorydata.plugin"));
    L37:
        r112 = r112 + 1;
        r27 = r114;
        r25 = r25;
        goto L32
    L38:
        ArrayList<String> r115 = r39.getFragment().getSharedElementTargetNames();
        Fragment r30 = r38.getFragment();
        if (r37 == true) goto L41;
        SharedElementCallback r31 = r30.getExitTransitionCallback();
        SharedElementCallback r32 = r39.getFragment().getEnterTransitionCallback();
    L42:
        int r116 = r22.size();
        HashMap r210 = r13;
        int r117 = 0;
    L43:
        if (r117 >= r116) goto L45;
        r14.put((String) ZeusTransformUtils.preCheckCast(r22.get(r117), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r115.get(r117), String.class, "com.obric.memorydata.plugin"));
        r117 = r117 + 1;
        r116 = r116;
        r15 = r15;
        goto L43
    L45:
        FragmentTransitionImpl r211 = r15;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L55;
        Log.v(FragmentManager.TAG, ">>> entering view names <<<");
        Iterator<String> r33 = r115.iterator();
    L49:
        if (r33.hasNext() == false) goto L51;
        Log.v(FragmentManager.TAG, "Name: " + ((String) ZeusTransformUtils.preCheckCast(r33.next(), String.class, "com.obric.memorydata.plugin")));
        goto L49
    L51:
        Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
        Iterator<String> r34 = r22.iterator();
    L53:
        if (r34.hasNext() == false) goto L55;
        Log.v(FragmentManager.TAG, "Name: " + ((String) ZeusTransformUtils.preCheckCast(r34.next(), String.class, "com.obric.memorydata.plugin")));
    L55:
        ArrayMap<String, View> r40 = new ArrayMap();
        findNamedViews(r40, r38.getFragment().mView);
        r40.retainAll(r22);
        if (r31 != null) goto L58;
        r14.retainAll(r40.keySet());
    L70:
        final ArrayMap<String, View> r118 = new ArrayMap();
        findNamedViews(r118, r39.getFragment().mView);
        r118.retainAll(r115);
        r118.retainAll(r14.values());
        if (r32 != null) goto L73;
        FragmentTransition.retainValues(r14, r118);
    L89:
        retainMatchingViews(r40, r14.keySet());
        retainMatchingViews(r118, r14.values());
        if (r14.isEmpty() == false) goto L92;
        r7.clear();
        r10.clear();
        ArrayList<View> r119 = r7;
        SpecialEffectsController.Operation r41 = r8;
        final Rect r120 = r110;
        View r121 = r111;
        FragmentTransitionImpl r42 = r211;
        r17 = r26;
        HashMap r43 = r210;
        r16 = null;
        ArrayList<View> r44 = r10;
    L104:
        r8 = r41;
        r10 = r44;
        r15 = r42;
        r5 = r121;
        r7 = r119;
        r6 = r120;
        r12 = r29;
        r11 = r28;
        r14 = r14;
        r13 = r43;
        goto L24
    L92:
        FragmentTransition.callSharedElementStartEnd(r39.getFragment(), r38.getFragment(), r37, r40, true);
        ArrayList<View> r45 = r10;
        ArrayList<View> r46 = r7;
        r120 = r110;
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass6(this, r39, r38, r37, r118));
        r46.addAll(r40.values());
        if (r22.isEmpty() == true) goto L95;
        View r47 = (View) ZeusTransformUtils.preCheckCast(r40.get((String) ZeusTransformUtils.preCheckCast(r22.get(0), String.class, "com.obric.memorydata.plugin")), View.class, "com.obric.memorydata.plugin");
        final FragmentTransitionImpl r122 = r211;
        Object r48 = r21;
        r122.setEpicenter(r48, r47);
        r17 = r47;
    L96:
        r44 = r45;
        r44.addAll(r118.values());
        if (r115.isEmpty() == true) goto L102;
        final View r49 = (View) ZeusTransformUtils.preCheckCast(r118.get((String) ZeusTransformUtils.preCheckCast(r115.get(0), String.class, "com.obric.memorydata.plugin")), View.class, "com.obric.memorydata.plugin");
        if (r49 == null) goto L102;
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass7(this, r122, r49, r120));
        r24 = true;
    L102:
        r122.setSharedElementTargets(r48, r25, r46);
        r42 = r122;
        r122.scheduleRemoveTargets(r48, null, null, null, null, r48, r44);
        r121 = r111;
        r43 = r210;
        r41 = r38;
        r43.put(r41, true);
        r119 = r46;
        r9 = r39;
        r43.put(r9, true);
        r16 = r48;
        goto L104
    L95:
        r122 = r211;
        r48 = r21;
        r17 = r26;
        goto L96
    L73:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L75;
        Log.v(FragmentManager.TAG, "Executing enter callback for operation " + r9);
    L75:
        r32.onMapSharedElements(r115, r118);
        int r50 = r115.size() - 1;
    L76:
        if (r50 < 0) goto L89;
        String r51 = (String) ZeusTransformUtils.preCheckCast(r115.get(r50), String.class, "com.obric.memorydata.plugin");
        View r123 = (View) ZeusTransformUtils.preCheckCast(r118.get(r51), View.class, "com.obric.memorydata.plugin");
        if (r123 != null) goto L83;
        String r52 = FragmentTransition.findKeyForValue(r14, r51);
        if (r52 == null) goto L87;
        r14.remove(r52);
    L87:
        r50 = r50 - 1;
        goto L76
    L83:
        if (r51.equals(ViewCompat.getTransitionName(r123)) == true) goto L87;
        String r53 = FragmentTransition.findKeyForValue(r14, r51);
        if (r53 == null) goto L87;
        r14.put(r53, ViewCompat.getTransitionName(r123));
        goto L87
    L58:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L60;
        Log.v(FragmentManager.TAG, "Executing exit callback for operation " + r8);
    L60:
        r31.onMapSharedElements(r22, r40);
        int r54 = r22.size() - 1;
    L61:
        if (r54 < 0) goto L70;
        String r124 = (String) ZeusTransformUtils.preCheckCast(r22.get(r54), String.class, "com.obric.memorydata.plugin");
        View r125 = (View) ZeusTransformUtils.preCheckCast(r40.get(r124), View.class, "com.obric.memorydata.plugin");
        if (r125 != null) goto L66;
        r14.remove(r124);
    L68:
        r54 = r54 - 1;
        goto L61
    L66:
        if (r124.equals(ViewCompat.getTransitionName(r125)) == true) goto L68;
        r14.put(ViewCompat.getTransitionName(r125), (String) ZeusTransformUtils.preCheckCast(r14.remove(r124), String.class, "com.obric.memorydata.plugin"));
        goto L68
    L41:
        r31 = r30.getEnterTransitionCallback();
        r32 = r39.getFragment().getExitTransitionCallback();
    L103:
        r41 = r8;
        r28 = r11;
        r29 = r12;
        r43 = r13;
        r42 = r15;
        r120 = r110;
        r121 = r111;
        r119 = r7;
        r44 = r10;
        r17 = r26;
        goto L104
    L105:
        ArrayMap r310 = r14;
        SpecialEffectsController.Operation r55 = r8;
        List r212 = r11;
        List r213 = r12;
        HashMap r56 = r13;
        ArrayList<View> r126 = r7;
        Rect r127 = r6;
        View r128 = r5;
        FragmentTransitionImpl r57 = r15;
        ArrayList<View> r58 = r10;
        ArrayList r59 = new ArrayList();
        Iterator r60 = r212.iterator();
        Object r129 = null;
        Object r311 = null;
    L107:
        if (r60.hasNext() == false) goto L148;
        r60 = r60;
        TransitionInfo r61 = (TransitionInfo) ZeusTransformUtils.preCheckCast(r60.next(), TransitionInfo.class, "com.obric.memorydata.plugin");
        if (r61.isVisibilityUnchanged() == false) goto L112;
        r56.put(r61.getOperation(), false);
        r61.completeSpecialEffect();
        r129 = r129;
        goto L107
    L112:
        Object r312 = r129;
        Object r62 = r57.cloneTransition(r61.getTransition());
        SpecialEffectsController.Operation r130 = r61.getOperation();
        if (r16 == null) goto L117;
        if (r130 == r55) goto L116;
        if (r130 != r9) goto L117;
    L116:
        boolean r131 = true;
    L118:
        String r214 = r19;
        if (r62 != null) goto L123;
        if (r131 == true) goto L122;
        r56.put(r130, false);
        r61.completeSpecialEffect();
    L122:
        r129 = r312;
        View r132 = r128;
        r126 = r126;
        View r133 = r26;
    L147:
        r9 = r39;
        r26 = r133;
        r126 = r126;
        r128 = r132;
        r19 = r214;
        goto L107
    L123:
        final ArrayList<View> r134 = new ArrayList();
        captureTransitioningViews(r134, r130.getFragment().mView);
        if (r131 == false) goto L129;
        if (r130 != r55) goto L127;
        r134.removeAll(r126);
        goto L129
    L127:
        r134.removeAll(r58);
    L129:
        if (r134.isEmpty() == false) goto L131;
        r57.addTarget(r62, r128);
        Object r63 = r312;
        r132 = r128;
    L137:
        if (r130.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L142;
        r59.addAll(r134);
        if (r24 == false) goto L141;
        r57.setEpicenter(r62, r127);
    L141:
        r133 = r26;
    L143:
        r56.put(r130, true);
        if (r61.isOverlapAllowed() == false) goto L146;
        r129 = r57.mergeTransitionsTogether(r63, r62, null);
        goto L147
    L146:
        r311 = r57.mergeTransitionsTogether(r311, r62, null);
        r129 = r63;
        goto L147
    L142:
        r133 = r26;
        r57.setEpicenter(r62, r133);
        goto L143
    L131:
        r57.addTargets(r62, r134);
        r63 = r312;
        r57.scheduleRemoveTargets(r62, r62, r134, null, null, null, null);
        r132 = r128;
        if (r130.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L134;
        r130 = r130;
        r213.remove(r130);
        ArrayList<View> r135 = new ArrayList(r134);
        r135.remove(r130.getFragment().mView);
        r57.scheduleHideFragmentView(r62, r130.getFragment().mView, r135);
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass8(this, r134));
        goto L137
    L134:
        r130 = r130;
    L117:
        r131 = false;
        goto L118
    L148:
        ArrayList<View> r136 = r126;
        String r215 = r19;
        boolean r137 = true;
        Object r64 = r57.mergeTransitionsInSequence(r129, r311, r16);
        if (r64 != null) goto L151;
        return r56;
    L151:
        Iterator r65 = r212.iterator();
    L153:
        if (r65.hasNext() == false) goto L176;
        final TransitionInfo r66 = (TransitionInfo) ZeusTransformUtils.preCheckCast(r65.next(), TransitionInfo.class, "com.obric.memorydata.plugin");
        if (r66.isVisibilityUnchanged() == true) goto L153;
        Object r138 = r66.getTransition();
        final SpecialEffectsController.Operation r139 = r66.getOperation();
        if (r16 == null) goto L162;
        if (r139 == r55) goto L161;
        if (r139 != r39) goto L162;
    L161:
        boolean r140 = r137;
    L163:
        if (r138 != null) goto L168;
        if (r140 == true) goto L168;
        String r141 = r215;
    L175:
        r55 = r38;
        r215 = r141;
        r137 = true;
    L168:
        if (ViewCompat.isLaidOut(getContainer()) == false) goto L170;
        r141 = r215;
        r57.setListenerForTransitionEnd(r66.getOperation().getFragment(), r64, r66.getSignal(), new AnonymousClass9(this, r66, r139));
        goto L175
    L170:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L172;
        r141 = r215;
        Log.v(r141, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + r139);
    L173:
        r66.completeSpecialEffect();
        goto L175
    L172:
        r141 = r215;
    L162:
        r140 = false;
        goto L163
    L176:
        String r142 = r215;
        if (ViewCompat.isLaidOut(getContainer()) == true) goto L179;
        return r56;
    L179:
        FragmentTransition.setViewVisibility(r59, 4);
        ArrayList<String> r67 = r57.prepareSetNameOverridesReordered(r58);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L189;
        Log.v(r142, ">>>>> Beginning transition <<<<<");
        Log.v(r142, ">>>>> SharedElementFirstOutViews <<<<<");
        Iterator<View> r68 = r136.iterator();
    L183:
        if (r68.hasNext() == false) goto L185;
        View r69 = (View) ZeusTransformUtils.preCheckCast(r68.next(), View.class, "com.obric.memorydata.plugin");
        Log.v(r142, "View: " + r69 + " Name: " + ViewCompat.getTransitionName(r69));
        goto L183
    L185:
        Log.v(r142, ">>>>> SharedElementLastInViews <<<<<");
        Iterator<View> r70 = r58.iterator();
    L187:
        if (r70.hasNext() == false) goto L189;
        View r71 = (View) ZeusTransformUtils.preCheckCast(r70.next(), View.class, "com.obric.memorydata.plugin");
        Log.v(r142, "View: " + r71 + " Name: " + ViewCompat.getTransitionName(r71));
    L189:
        r57.beginDelayedTransition(getContainer(), r64);
        r57.setNameOverridesReordered(getContainer(), r136, r58, r67, r310);
        FragmentTransition.setViewVisibility(r59, 0);
        r57.swapSharedElementTargets(r16, r136, r58);
        return r56;
    }

    void applyContainerChanges(SpecialEffectsController.Operation r1) {
        View r0 = r1.getFragment().mView;
        r1.getFinalState().applyState(r0);
    }

    void captureTransitioningViews(ArrayList<View> r5, View r6) {
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L16;
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin");
        if (ViewGroupCompat.isTransitionGroup(r0) == true) goto L7;
        int r7 = r0.getChildCount();
        int r1 = 0;
    L10:
        if (r1 >= r7) goto L25;
        View r2 = r0.getChildAt(r1);
        if (r2.getVisibility() != 0) goto L14;
        captureTransitioningViews(r5, r2);
    L14:
        r1 = r1 + 1;
        goto L10
    L25:
        return;
    L7:
        if (r5.contains(r6) == true) goto L22;
        r5.add(r0);
        return;
    L22:
        return;
    L16:
        if (r5.contains(r6) == true) goto L24;
        r5.add(r6);
        return;
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(List<SpecialEffectsController.Operation> r18, boolean r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
        SpecialEffectsController.Operation r8 = null;
        SpecialEffectsController.Operation r9 = null;
    L4:
        if (r1.hasNext() == false) goto L21;
        SpecialEffectsController.Operation r2 = (SpecialEffectsController.Operation) ZeusTransformUtils.preCheckCast(r1.next(), SpecialEffectsController.Operation.class, "com.obric.memorydata.plugin");
        SpecialEffectsController.Operation.State r4 = SpecialEffectsController.Operation.State.from(r2.getFragment().mView);
        int r5 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[r2.getFinalState().ordinal()];
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L4;
        if (r4 == SpecialEffectsController.Operation.State.VISIBLE) goto L4;
        r9 = r2;
    L17:
        if (r4 != SpecialEffectsController.Operation.State.VISIBLE) goto L4;
        if (r8 != null) goto L4;
        r8 = r2;
        goto L4
    L21:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L23;
        Log.v(FragmentManager.TAG, "Executing operations from " + r8 + " to " + r9);
    L23:
        ArrayList r14 = new ArrayList();
        ArrayList r3 = new ArrayList();
        final ArrayList r15 = new ArrayList(r0);
        Iterator r6 = r0.iterator();
    L25:
        if (r6.hasNext() == false) goto L34;
        final SpecialEffectsController.Operation r7 = (SpecialEffectsController.Operation) ZeusTransformUtils.preCheckCast(r6.next(), SpecialEffectsController.Operation.class, "com.obric.memorydata.plugin");
        CancellationSignal r10 = new CancellationSignal();
        r7.markStartedSpecialEffect(r10);
        r14.add(new AnimationInfo(r7, r10, r19));
        CancellationSignal r11 = new CancellationSignal();
        r7.markStartedSpecialEffect(r11);
        if (r19 == false) goto L30;
        if (r7 == r8) goto L31;
    L32:
        boolean r12 = false;
    L33:
        r3.add(new TransitionInfo(r7, r11, r19, r12));
        r7.addCompletionListener(new AnonymousClass1(this, r15, r7));
    L31:
        r12 = true;
        goto L33
    L30:
        if (r7 != r9) goto L32;
    L34:
        Map<SpecialEffectsController.Operation, Boolean> r13 = startTransitions(r3, r15, r19, r8, r9);
        startAnimations(r14, r15, r13.containsValue(true), r13);
        Iterator<SpecialEffectsController.Operation> r16 = r15.iterator();
    L36:
        if (r16.hasNext() == false) goto L38;
        applyContainerChanges((SpecialEffectsController.Operation) ZeusTransformUtils.preCheckCast(r16.next(), SpecialEffectsController.Operation.class, "com.obric.memorydata.plugin"));
        goto L36
    L38:
        r15.clear();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L62;
        Log.v(FragmentManager.TAG, "Completed executing operations from " + r8 + " to " + r9);
        return;
    }

    void findNamedViews(Map<String, View> r5, View r6) {
        Map<String, View> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        String r0 = ViewCompat.getTransitionName(r6);
        if (r0 == null) goto L6;
        r7.put(r0, r6);
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L13;
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin");
        int r1 = r8.getChildCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        View r3 = r8.getChildAt(r2);
        if (r3.getVisibility() != 0) goto L12;
        findNamedViews(r7, r3);
    L12:
        r2 = r2 + 1;
        goto L8
    L17:
        return;
    }

    void retainMatchingViews(ArrayMap<String, View> r3, Collection<String> r4) {
        Collection r2 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, View>> r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r2.contains(ViewCompat.getTransitionName((View) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), View.class, "com.obric.memorydata.plugin"))) == true) goto L4;
        r5.remove();
        goto L4
    }
}
