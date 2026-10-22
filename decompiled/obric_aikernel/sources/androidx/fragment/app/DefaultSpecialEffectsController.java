package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
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
            int[] r10 = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r10;
            r10[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
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

        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(@NonNull SpecialEffectsController.Operation r10, @NonNull CancellationSignal r11, boolean r12) {
            super(r10, r11);
            this.mLoadedAnim = false;
            this.mIsPop = r12;
        }

        @Nullable
        FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context r10) {
            if (this.mLoadedAnim == true) goto L5;
            Fragment r11 = getOperation().getFragment();
            if (getOperation().getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L9;
            boolean r12 = true;
        L10:
            FragmentAnim.AnimationOrAnimator r13 = FragmentAnim.loadAnimation(r10, r11, r12, this.mIsPop);
            this.mAnimation = r13;
            this.mLoadedAnim = true;
            return r13;
        L9:
            r12 = false;
            goto L10
        L5:
            return this.mAnimation;
        }
    }

    private static class SpecialEffectsInfo {

        @NonNull
        private final SpecialEffectsController.Operation mOperation;

        @NonNull
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation r10, @NonNull CancellationSignal r11) {
            this.mOperation = r10;
            this.mSignal = r11;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State r10 = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State r11 = this.mOperation.getFinalState();
            if (r10 == r11) goto L9;
            SpecialEffectsController.Operation.State r12 = SpecialEffectsController.Operation.State.VISIBLE;
            if (r10 == r12) goto L8;
            if (r11 != r12) goto L9;
        L8:
            return false;
        L9:
            return true;
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @Nullable
        private final Object mSharedElementTransition;

        @Nullable
        private final Object mTransition;

        TransitionInfo(@NonNull SpecialEffectsController.Operation r10, @NonNull CancellationSignal r11, boolean r12, boolean r13) {
            super(r10, r11);
            if (r10.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L12;
            Fragment r14 = r10.getFragment();
            if (r12 == false) goto L7;
            Object r15 = r14.getReenterTransition();
        L8:
            this.mTransition = r15;
            Fragment r16 = r10.getFragment();
            if (r12 == false) goto L11;
            boolean r17 = r16.getAllowReturnTransitionOverlap();
        L17:
            this.mOverlapAllowed = r17;
            if (r13 == false) goto L23;
            Fragment r18 = r10.getFragment();
            if (r12 == false) goto L22;
            Object r19 = r18.getSharedElementReturnTransition();
        L24:
            this.mSharedElementTransition = r19;
            return;
        L22:
            r19 = r18.getSharedElementEnterTransition();
            goto L24
        L23:
            r19 = null;
            goto L24
        L11:
            r17 = r16.getAllowEnterTransitionOverlap();
            goto L17
        L7:
            r15 = r14.getEnterTransition();
            goto L8
        L12:
            Fragment r20 = r10.getFragment();
            if (r12 == false) goto L15;
            Object r21 = r20.getReturnTransition();
        L16:
            this.mTransition = r21;
            r17 = true;
            goto L17
        L15:
            r21 = r20.getExitTransition();
            goto L16
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            FragmentTransitionImpl r11 = FragmentTransition.PLATFORM_IMPL;
            if (r11 != null) goto L8;
        L10:
            FragmentTransitionImpl r12 = FragmentTransition.SUPPORT_IMPL;
            if (r12 == null) goto L16;
            if (r12.canHandle(r10) == false) goto L16;
            return r12;
        L16:
            throw new IllegalArgumentException("Transition " + r10 + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        L8:
            if (r11.canHandle(r10) == false) goto L10;
            return r11;
        }

        @Nullable
        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl r10 = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl r11 = getHandlingImpl(this.mSharedElementTransition);
            if (r10 == null) goto L9;
            if (r11 == null) goto L9;
            if (r10 == r11) goto L9;
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        L9:
            if (r10 == null) goto L12;
            return r10;
        L12:
            return r11;
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
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

    DefaultSpecialEffectsController(@NonNull ViewGroup r10) {
        super(r10);
    }

    private void startAnimations(@NonNull List<AnimationInfo> r18, @NonNull List<SpecialEffectsController.Operation> r19, boolean r20, @NonNull Map<SpecialEffectsController.Operation, Boolean> r21) {
        final ViewGroup r10 = getContainer();
        Context r11 = r10.getContext();
        ArrayList r12 = new ArrayList();
        Iterator<AnimationInfo> r13 = r18.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L29;
        final AnimationInfo r15 = r13.next();
        if (r15.isVisibilityUnchanged() == true) goto L7;
        FragmentAnim.AnimationOrAnimator r16 = r15.getAnimation(r11);
        if (r16 == null) goto L7;
        final Animator r17 = r16.animator;
        if (r17 == null) goto L14;
        final SpecialEffectsController.Operation r22 = r15.getOperation();
        Fragment r23 = r22.getFragment();
        if (Boolean.TRUE.equals(r21.get(r22)) == true) goto L18;
        if (r22.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L24;
        final boolean r24 = true;
    L26:
        if (r24 == false) goto L28;
        r19.remove(r22);
    L28:
        final View r25 = r23.mView;
        r10.startViewTransition(r25);
        r17.addListener(new AnonymousClass2(this, r10, r25, r24, r22, r15));
        r17.setTarget(r25);
        r17.start();
        r15.getSignal().setOnCancelListener(new AnonymousClass3(this, r17));
        r14 = true;
        goto L4
    L24:
        r24 = false;
        goto L26
    L18:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L20;
        Log.v("FragmentManager", "Ignoring Animator set on " + r23 + " as this Fragment was involved in a Transition.");
    L20:
        r15.completeSpecialEffect();
        goto L4
    L14:
        r12.add(r15);
    L7:
        r15.completeSpecialEffect();
        goto L4
    L29:
        Iterator r26 = r12.iterator();
    L31:
        if (r26.hasNext() == false) goto L48;
        final AnimationInfo r27 = (AnimationInfo) r26.next();
        SpecialEffectsController.Operation r28 = r27.getOperation();
        Fragment r29 = r28.getFragment();
        if (r20 == true) goto L35;
        if (r14 == true) goto L41;
        final View r30 = r29.mView;
        Animation r110 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(r27.getAnimation(r11))).animation);
        if (r28.getFinalState() == SpecialEffectsController.Operation.State.REMOVED) goto L46;
        r30.startAnimation(r110);
        r27.completeSpecialEffect();
    L47:
        r27.getSignal().setOnCancelListener(new AnonymousClass5(this, r30, r10, r27));
        goto L31
    L46:
        r10.startViewTransition(r30);
        FragmentAnim.EndViewTransitionAnimation r31 = new FragmentAnim.EndViewTransitionAnimation(r110, r10, r30);
        r31.setAnimationListener(new AnonymousClass4(this, r10, r30, r27));
        r30.startAnimation(r31);
        goto L47
    L41:
        if (FragmentManager.isLoggingEnabled(2) == true) goto L42;
    L38:
        r27.completeSpecialEffect();
        goto L31
    L42:
        StringBuilder r32 = new StringBuilder();
        r32.append("Ignoring Animation set on ");
        r32.append(r29);
        String r33 = " as Animations cannot run alongside Animators.";
    L37:
        r32.append(r33);
        Log.v("FragmentManager", r32.toString());
        goto L38
    L35:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L38;
        r32 = new StringBuilder();
        r32.append("Ignoring Animation set on ");
        r32.append(r29);
        r33 = " as Animations cannot run alongside Transitions.";
        goto L37
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> r32, @NonNull List<SpecialEffectsController.Operation> r33, final boolean r34, @Nullable final SpecialEffectsController.Operation r35, @Nullable final SpecialEffectsController.Operation r36) {
        DefaultSpecialEffectsController r10 = this;
        SpecialEffectsController.Operation r11 = r35;
        SpecialEffectsController.Operation r12 = r36;
        HashMap r13 = new HashMap();
        Iterator<TransitionInfo> r14 = r32.iterator();
        final FragmentTransitionImpl r15 = null;
    L4:
        if (r14.hasNext() == false) goto L16;
        TransitionInfo r16 = r14.next();
        if (r16.isVisibilityUnchanged() == true) goto L4;
        FragmentTransitionImpl r17 = r16.getHandlingImpl();
        if (r15 == null) goto L10;
        if (r17 == null) goto L4;
        if (r15 == r17) goto L4;
        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r16.getOperation().getFragment() + " returned Transition " + r16.getTransition() + " which uses a different Transition  type than other Fragments.");
    L10:
        r15 = r17;
        goto L4
    L16:
        if (r15 != null) goto L22;
        Iterator<TransitionInfo> r18 = r32.iterator();
    L19:
        if (r18.hasNext() == false) goto L21;
        TransitionInfo r19 = r18.next();
        r13.put(r19.getOperation(), Boolean.FALSE);
        r19.completeSpecialEffect();
        goto L19
    L21:
        return r13;
    L22:
        View r110 = new View(getContainer().getContext());
        final Rect r111 = new Rect();
        ArrayList<View> r112 = new ArrayList();
        ArrayList<View> r20 = new ArrayList();
        ArrayMap r21 = new ArrayMap();
        Iterator<TransitionInfo> r22 = r32.iterator();
        Object r23 = null;
        View r24 = null;
        boolean r25 = false;
    L24:
        if (r22.hasNext() == false) goto L88;
        TransitionInfo r26 = r22.next();
        if (r26.hasSharedElementTransition() == false) goto L86;
        if (r11 == null) goto L86;
        if (r12 == null) goto L86;
        Object r27 = r15.wrapTransitionInSet(r15.cloneTransition(r26.getSharedElementTransition()));
        ArrayList<String> r28 = r36.getFragment().getSharedElementSourceNames();
        ArrayList<String> r29 = r35.getFragment().getSharedElementSourceNames();
        ArrayList<String> r113 = r35.getFragment().getSharedElementTargetNames();
        View r114 = r24;
        int r30 = 0;
    L31:
        if (r30 >= r113.size()) goto L36;
        int r31 = r28.indexOf(r113.get(r30));
        ArrayList<String> r115 = r113;
        if (r31 == (-1)) goto L35;
        r28.set(r31, r29.get(r30));
    L35:
        r30 = r30 + 1;
        r113 = r115;
        goto L31
    L36:
        ArrayList<String> r116 = r36.getFragment().getSharedElementTargetNames();
        Fragment r37 = r35.getFragment();
        if (r34 != 0) goto L39;
        SharedElementCallback r38 = r37.getExitTransitionCallback();
        SharedElementCallback r39 = r36.getFragment().getEnterTransitionCallback();
    L40:
        int r40 = r28.size();
        int r41 = 0;
    L41:
        if (r41 >= r40) goto L43;
        r21.put(r28.get(r41), r116.get(r41));
        r41 = r41 + 1;
        r40 = r40;
        goto L41
    L43:
        ArrayMap<String, View> r42 = new ArrayMap();
        r10.findNamedViews(r42, r35.getFragment().mView);
        r42.retainAll(r28);
        if (r38 == null) goto L55;
        r38.onMapSharedElements(r28, r42);
        int r43 = r28.size() - 1;
    L46:
        if (r43 < 0) goto L54;
        String r44 = r28.get(r43);
        View r45 = r42.get(r44);
        if (r45 != null) goto L50;
        r21.remove(r44);
        ArrayList<String> r117 = r28;
    L53:
        r43 = r43 - 1;
        r28 = r117;
        goto L46
    L50:
        r117 = r28;
        if (r44.equals(ViewCompat.getTransitionName(r45)) == true) goto L53;
        r21.put(ViewCompat.getTransitionName(r45), (String) r21.remove(r44));
        goto L53
    L54:
        ArrayList<String> r118 = r28;
    L56:
        final ArrayMap<String, View> r46 = new ArrayMap();
        r10.findNamedViews(r46, r36.getFragment().mView);
        r46.retainAll(r116);
        r46.retainAll(r21.values());
        if (r39 == null) goto L71;
        r39.onMapSharedElements(r116, r46);
        int r47 = r116.size() - 1;
    L59:
        if (r47 < 0) goto L72;
        String r48 = r116.get(r47);
        View r49 = r46.get(r48);
        if (r49 != null) goto L66;
        String r50 = FragmentTransition.findKeyForValue(r21, r48);
        if (r50 == null) goto L70;
        r21.remove(r50);
    L70:
        r47 = r47 - 1;
        goto L59
    L66:
        if (r48.equals(ViewCompat.getTransitionName(r49)) == true) goto L70;
        String r51 = FragmentTransition.findKeyForValue(r21, r48);
        if (r51 == null) goto L70;
        r21.put(r51, ViewCompat.getTransitionName(r49));
    L72:
        r10.retainMatchingViews(r42, r21.keySet());
        r10.retainMatchingViews(r46, r21.values());
        if (r21.isEmpty() == false) goto L75;
        r112.clear();
        r20.clear();
        SpecialEffectsController.Operation r52 = r35;
        ArrayList<View> r53 = r20;
        final DefaultSpecialEffectsController r54 = r10;
        View r55 = r110;
        r24 = r114;
        r23 = null;
        SpecialEffectsController.Operation r119 = r36;
    L87:
        r112 = r112;
        r10 = r54;
        r111 = r111;
        r110 = r55;
        r12 = r119;
        r21 = r21;
        r20 = r53;
        r11 = r52;
        r15 = r15;
        goto L24
    L75:
        FragmentTransition.callSharedElementStartEnd(r36.getFragment(), r35.getFragment(), r34, r42, true);
        ArrayList<String> r210 = r118;
        HashMap r211 = r13;
        View r120 = r110;
        ArrayList<View> r212 = r20;
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass6(this, r36, r35, r34, r46));
        r112.addAll(r42.values());
        if (r210.isEmpty() == true) goto L78;
        View r56 = r42.get(r210.get(0));
        r15.setEpicenter(r27, r56);
        r24 = r56;
    L79:
        r53 = r212;
        r53.addAll(r46.values());
        if (r116.isEmpty() == true) goto L84;
        final View r57 = r46.get(r116.get(0));
        if (r57 == null) goto L84;
        r54 = this;
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass7(r54, r15, r57, r111));
        r25 = true;
    L85:
        r15.setSharedElementTargets(r27, r120, r112);
        r55 = r120;
        r15.scheduleRemoveTargets(r27, null, null, null, null, r27, r53);
        Boolean r58 = Boolean.TRUE;
        r52 = r35;
        r13 = r211;
        r13.put(r52, r58);
        r119 = r36;
        r13.put(r119, r58);
        r23 = r27;
    L84:
        r54 = this;
        goto L85
    L78:
        r24 = r114;
        goto L79
    L71:
        FragmentTransition.retainValues(r21, r46);
        goto L72
    L55:
        r118 = r28;
        r21.retainAll(r42.keySet());
        goto L56
    L39:
        r38 = r37.getEnterTransitionCallback();
        r39 = r36.getFragment().getExitTransitionCallback();
    L86:
        r53 = r20;
        r54 = r10;
        r52 = r11;
        r119 = r12;
        r55 = r110;
        r24 = r24;
        goto L87
    L88:
        View r213 = r24;
        ArrayMap r214 = r21;
        ArrayList<View> r59 = r20;
        final DefaultSpecialEffectsController r60 = r10;
        SpecialEffectsController.Operation r61 = r11;
        ArrayList<View> r62 = r112;
        Rect r63 = r111;
        FragmentTransitionImpl r121 = r15;
        SpecialEffectsController.Operation r122 = r12;
        View r64 = r110;
        ArrayList r65 = new ArrayList();
        Iterator<TransitionInfo> r66 = r32.iterator();
        Object r123 = null;
        Object r124 = null;
    L90:
        if (r66.hasNext() == false) goto L128;
        TransitionInfo r215 = r66.next();
        if (r215.isVisibilityUnchanged() == true) goto L93;
        Object r67 = r121.cloneTransition(r215.getTransition());
        SpecialEffectsController.Operation r125 = r215.getOperation();
        if (r23 == null) goto L99;
        if (r125 == r61) goto L98;
        if (r125 != r122) goto L99;
    L98:
        boolean r126 = true;
    L100:
        if (r67 != null) goto L104;
        if (r126 == true) goto L103;
        r13.put(r125, Boolean.FALSE);
        r215.completeSpecialEffect();
    L103:
        ArrayList<View> r310 = r59;
        ArrayList<View> r216 = r62;
        Iterator<TransitionInfo> r311 = r66;
        View r217 = r64;
        Object r68 = r123;
        SpecialEffectsController.Operation r69 = r122;
        View r70 = r213;
    L127:
        r122 = r69;
        r123 = r68;
        r213 = r70;
        r64 = r217;
        r62 = r216;
        r59 = r310;
        r66 = r311;
        goto L90
    L104:
        r311 = r66;
        final ArrayList<View> r71 = new ArrayList();
        Object r127 = r123;
        r60.captureTransitioningViews(r71, r125.getFragment().mView);
        if (r126 == false) goto L110;
        if (r125 != r61) goto L108;
        r71.removeAll(r62);
        goto L110
    L108:
        r71.removeAll(r59);
    L110:
        if (r71.isEmpty() == false) goto L112;
        r121.addTarget(r67, r64);
        r310 = r59;
        r216 = r62;
        r217 = r64;
        SpecialEffectsController.Operation r128 = r125;
        Object r72 = r124;
        r69 = r122;
        Object r73 = r127;
    L117:
        if (r128.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) goto L122;
        r65.addAll(r71);
        if (r25 == false) goto L121;
        r121.setEpicenter(r67, r63);
    L121:
        r70 = r213;
    L123:
        r13.put(r128, Boolean.TRUE);
        if (r215.isOverlapAllowed() == false) goto L126;
        r124 = r121.mergeTransitionsTogether(r72, r67, null);
        r68 = r73;
        goto L127
    L126:
        r68 = r121.mergeTransitionsTogether(r73, r67, null);
        r124 = r72;
        goto L127
    L122:
        r70 = r213;
        r121.setEpicenter(r67, r70);
        goto L123
    L112:
        r121.addTargets(r67, r71);
        r217 = r64;
        r73 = r127;
        r216 = r62;
        r72 = r124;
        r310 = r59;
        r69 = r122;
        r121.scheduleRemoveTargets(r67, r67, r71, null, null, null, null);
        if (r125.getFinalState() != SpecialEffectsController.Operation.State.GONE) goto L115;
        r128 = r125;
        r33.remove(r128);
        ArrayList<View> r129 = new ArrayList(r71);
        r129.remove(r128.getFragment().mView);
        r121.scheduleHideFragmentView(r67, r128.getFragment().mView, r129);
        OneShotPreDrawListener.add(getContainer(), new AnonymousClass8(r60, r71));
        goto L117
    L115:
        r128 = r125;
    L99:
        r126 = false;
        goto L100
    L93:
        r13.put(r215.getOperation(), Boolean.FALSE);
        r215.completeSpecialEffect();
        goto L90
    L128:
        ArrayList<View> r312 = r59;
        ArrayList<View> r218 = r62;
        SpecialEffectsController.Operation r74 = r122;
        Object r75 = r121.mergeTransitionsInSequence(r124, r123, r23);
        Iterator<TransitionInfo> r76 = r32.iterator();
    L130:
        if (r76.hasNext() == false) goto L150;
        final TransitionInfo r77 = r76.next();
        if (r77.isVisibilityUnchanged() == true) goto L130;
        Object r78 = r77.getTransition();
        SpecialEffectsController.Operation r79 = r77.getOperation();
        if (r23 == null) goto L139;
        if (r79 == r61) goto L138;
        if (r79 != r74) goto L139;
    L138:
        boolean r130 = true;
    L140:
        if (r78 != null) goto L143;
        if (r130 == false) goto L130;
    L143:
        if (ViewCompat.isLaidOut(getContainer()) == false) goto L145;
        r121.setListenerForTransitionEnd(r77.getOperation().getFragment(), r75, r77.getSignal(), new AnonymousClass9(r60, r77));
        goto L130
    L145:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L147;
        Log.v("FragmentManager", "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + r79);
    L147:
        r77.completeSpecialEffect();
    L139:
        r130 = false;
        goto L140
    L150:
        if (ViewCompat.isLaidOut(getContainer()) == true) goto L152;
        return r13;
    L152:
        FragmentTransition.setViewVisibility(r65, 4);
        ArrayList<String> r80 = r121.prepareSetNameOverridesReordered(r312);
        r121.beginDelayedTransition(getContainer(), r75);
        r121.setNameOverridesReordered(getContainer(), r218, r312, r80, r214);
        FragmentTransition.setViewVisibility(r65, 0);
        r121.swapSharedElementTargets(r23, r218, r312);
        return r13;
    }

    void applyContainerChanges(@NonNull SpecialEffectsController.Operation r10) {
        View r11 = r10.getFragment().mView;
        r10.getFinalState().applyState(r11);
    }

    void captureTransitioningViews(ArrayList<View> r10, View r11) {
        if ((r11 instanceof ViewGroup) == false) goto L16;
        ViewGroup r12 = (ViewGroup) r11;
        if (ViewGroupCompat.isTransitionGroup(r12) == true) goto L7;
        int r13 = r12.getChildCount();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L25;
        View r15 = r12.getChildAt(r14);
        if (r15.getVisibility() != 0) goto L14;
        captureTransitioningViews(r10, r15);
    L14:
        r14 = r14 + 1;
        goto L10
    L25:
        return;
    L7:
        if (r10.contains(r11) == true) goto L22;
        r10.add(r12);
        return;
    L22:
        return;
    L16:
        if (r10.contains(r11) == true) goto L24;
        r10.add(r11);
        return;
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(@NonNull List<SpecialEffectsController.Operation> r11, boolean r12) {
        Iterator<SpecialEffectsController.Operation> r10 = r11.iterator();
        SpecialEffectsController.Operation r13 = null;
        SpecialEffectsController.Operation r14 = null;
    L4:
        if (r10.hasNext() == false) goto L21;
        SpecialEffectsController.Operation r15 = r10.next();
        SpecialEffectsController.Operation.State r16 = SpecialEffectsController.Operation.State.from(r15.getFragment().mView);
        int r17 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[r15.getFinalState().ordinal()];
        if (r17 == 1) goto L18;
        if (r17 == 2) goto L18;
        if (r17 == 3) goto L18;
        if (r17 != 4) goto L4;
        if (r16 == SpecialEffectsController.Operation.State.VISIBLE) goto L4;
        r14 = r15;
    L18:
        if (r16 != SpecialEffectsController.Operation.State.VISIBLE) goto L4;
        if (r13 != null) goto L4;
        r13 = r15;
        goto L4
    L21:
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        final ArrayList r20 = new ArrayList(r11);
        Iterator<SpecialEffectsController.Operation> r110 = r11.iterator();
    L23:
        if (r110.hasNext() == false) goto L31;
        final SpecialEffectsController.Operation r21 = r110.next();
        CancellationSignal r22 = new CancellationSignal();
        r21.markStartedSpecialEffect(r22);
        r18.add(new AnimationInfo(r21, r22, r12));
        CancellationSignal r23 = new CancellationSignal();
        r21.markStartedSpecialEffect(r23);
        boolean r24 = false;
        if (r12 == false) goto L28;
        if (r21 != r13) goto L30;
    L29:
        r24 = true;
    L30:
        r19.add(new TransitionInfo(r21, r23, r12, r24));
        r21.addCompletionListener(new AnonymousClass1(this, r20, r21));
        goto L23
    L28:
        if (r21 != r14) goto L30;
    L31:
        Map<SpecialEffectsController.Operation, Boolean> r111 = startTransitions(r19, r20, r12, r13, r14);
        startAnimations(r18, r20, r111.containsValue(Boolean.TRUE), r111);
        Iterator<SpecialEffectsController.Operation> r112 = r20.iterator();
    L33:
        if (r112.hasNext() == false) goto L35;
        applyContainerChanges(r112.next());
        goto L33
    L35:
        r20.clear();
    }

    void findNamedViews(Map<String, View> r10, @NonNull View r11) {
        String r12 = ViewCompat.getTransitionName(r11);
        if (r12 == null) goto L6;
        r10.put(r12, r11);
    L6:
        if ((r11 instanceof ViewGroup) == false) goto L13;
        ViewGroup r13 = (ViewGroup) r11;
        int r14 = r13.getChildCount();
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L17;
        View r16 = r13.getChildAt(r15);
        if (r16.getVisibility() != 0) goto L12;
        findNamedViews(r10, r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L17:
        return;
    }

    void retainMatchingViews(@NonNull ArrayMap<String, View> r10, @NonNull Collection<String> r11) {
        Iterator<Map.Entry<String, View>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r11.contains(ViewCompat.getTransitionName(r12.next().getValue())) == true) goto L4;
        r12.remove();
        goto L4
    }
}
