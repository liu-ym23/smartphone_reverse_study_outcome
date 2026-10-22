package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FragmentTransition {
    private static final int[] INVERSE_OPS = null;
    static final FragmentTransitionImpl PLATFORM_IMPL = null;
    static final FragmentTransitionImpl SUPPORT_IMPL = null;

    interface Callback {
        void onComplete(@NonNull Fragment r10, @NonNull CancellationSignal r11);

        void onStart(@NonNull Fragment r10, @NonNull CancellationSignal r11);
    }

    static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    static {
        INVERSE_OPS = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
        if (Build.VERSION.SDK_INT < 21) goto L5;
        FragmentTransitionCompat21 r10 = new FragmentTransitionCompat21();
    L6:
        PLATFORM_IMPL = r10;
        SUPPORT_IMPL = resolveSupportImpl();
        return;
    L5:
        r10 = null;
        goto L6
    }

    private FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> r10, ArrayMap<String, View> r11, Collection<String> r12) {
        int r13 = r11.size() - 1;
    L3:
        if (r13 < 0) goto L8;
        View r14 = r11.valueAt(r13);
        if (r12.contains(ViewCompat.getTransitionName(r14)) == false) goto L7;
        r10.add(r14);
    L7:
        r13 = r13 - 1;
        goto L3
    }

    private static void addToFirstInLastOut(BackStackRecord r10, FragmentTransaction.Op r11, SparseArray<FragmentContainerTransition> r12, boolean r13, boolean r14) {
        Fragment r15 = r11.mFragment;
        if (r15 != null) goto L5;
        return;
    L5:
        int r16 = r15.mContainerId;
        if (r16 != 0) goto L8;
        return;
    L8:
        if (r13 == false) goto L10;
        int r17 = INVERSE_OPS[r11.mCmd];
    L11:
        boolean r18 = false;
        boolean r19 = true;
        if (r17 != 1) goto L14;
    L62:
        if (r14 == false) goto L65;
        boolean r20 = r15.mIsNewlyAdded;
    L70:
        boolean r21 = false;
        r18 = r20;
        boolean r22 = false;
    L71:
        FragmentContainerTransition r23 = r12.get(r16);
        if (r18 == false) goto L75;
        r23 = ensureContainer(r23, r12, r16);
        r23.lastIn = r15;
        r23.lastInIsPop = r13;
        r23.lastInTransaction = r10;
    L75:
        if (r14 == true) goto L84;
        if (r19 == false) goto L84;
        if (r23 == null) goto L82;
        if (r23.firstOut != r15) goto L82;
        r23.firstOut = null;
    L82:
        if (r10.mReorderingAllowed == true) goto L84;
        FragmentManager r24 = r10.mManager;
        r24.getFragmentStore().makeActive(r24.createOrGetFragmentStateManager(r15));
        r24.moveToState(r15);
    L84:
        if (r21 == false) goto L89;
        if (r23 != null) goto L87;
    L88:
        r23 = ensureContainer(r23, r12, r16);
        r23.firstOut = r15;
        r23.firstOutIsPop = r13;
        r23.firstOutTransaction = r10;
        goto L89
    L87:
        if (r23.firstOut == null) goto L88;
    L89:
        if (r14 == true) goto L96;
        if (r22 == false) goto L97;
        if (r23 != null) goto L93;
        return;
    L93:
        if (r23.lastIn != r15) goto L99;
        r23.lastIn = null;
        return;
    L99:
        return;
    L97:
        return;
    L96:
        return;
    L65:
        if (r15.mAdded == false) goto L67;
    L69:
        r20 = false;
        goto L70
    L67:
        if (r15.mHidden == true) goto L69;
    L68:
        r20 = true;
        goto L70
    L14:
        if (r17 != 3) goto L16;
    L46:
        boolean r25 = r15.mAdded;
        if (r14 == false) goto L57;
        if (r25 == true) goto L56;
        View r26 = r15.mView;
        if (r26 == null) goto L56;
        if (r26.getVisibility() != 0) goto L56;
        if (r15.mPostponedAlpha < 0.0f) goto L56;
    L55:
        boolean r27 = true;
    L61:
        r21 = r27;
        r22 = true;
        r19 = false;
    L56:
        r27 = false;
        goto L61
    L57:
        if (r25 == false) goto L56;
        if (r15.mHidden == true) goto L56;
    L16:
        if (r17 != 4) goto L18;
        if (r14 == false) goto L42;
        if (r15.mHiddenChanged == false) goto L56;
        if (r15.mAdded == false) goto L56;
        if (r15.mHidden == false) goto L56;
    L42:
        if (r15.mAdded == false) goto L56;
        if (r15.mHidden == true) goto L56;
    L18:
        if (r17 != 5) goto L20;
        if (r14 == true) goto L26;
        r20 = r15.mHidden;
        goto L70
    L26:
        if (r15.mHiddenChanged == false) goto L69;
        if (r15.mHidden == true) goto L69;
        if (r15.mAdded == false) goto L69;
    L20:
        if (r17 == 6) goto L46;
        if (r17 == 7) goto L62;
        r22 = false;
        r19 = false;
        r21 = false;
        goto L71
    L10:
        r17 = r11.mCmd;
        goto L11
    }

    public static void calculateFragments(BackStackRecord r10, SparseArray<FragmentContainerTransition> r11, boolean r12) {
        int r13 = r10.mOps.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        addToFirstInLastOut(r10, r10.mOps.get(r14), r11, false, r12);
        r14 = r14 + 1;
        goto L3
    }

    private static ArrayMap<String, String> calculateNameOverrides(int r10, ArrayList<BackStackRecord> r11, ArrayList<Boolean> r12, int r13, int r14) {
        ArrayMap<String, String> r15 = new ArrayMap();
        int r16 = r14 - 1;
    L3:
        if (r16 < r13) goto L21;
        BackStackRecord r17 = r11.get(r16);
        if (r17.interactsWith(r10) == false) goto L20;
        boolean r18 = r12.get(r16).booleanValue();
        ArrayList<String> r19 = r17.mSharedElementSourceNames;
        if (r19 == null) goto L20;
        int r20 = r19.size();
        if (r18 == false) goto L12;
        ArrayList<String> r21 = r17.mSharedElementSourceNames;
        ArrayList<String> r22 = r17.mSharedElementTargetNames;
    L13:
        int r23 = 0;
    L14:
        if (r23 >= r20) goto L20;
        String r24 = r22.get(r23);
        String r25 = r21.get(r23);
        String r26 = r15.remove(r25);
        if (r26 == null) goto L18;
        r15.put(r24, r26);
    L19:
        r23 = r23 + 1;
        goto L14
    L18:
        r15.put(r24, r25);
        goto L19
    L12:
        ArrayList<String> r27 = r17.mSharedElementSourceNames;
        r21 = r17.mSharedElementTargetNames;
        r22 = r27;
    L20:
        r16 = r16 - 1;
        goto L3
    L21:
        return r15;
    }

    public static void calculatePopFragments(BackStackRecord r10, SparseArray<FragmentContainerTransition> r11, boolean r12) {
        if (r10.mManager.getContainer().onHasView() == true) goto L5;
        return;
    L5:
        int r13 = r10.mOps.size() - 1;
    L6:
        if (r13 < 0) goto L8;
        addToFirstInLastOut(r10, r10.mOps.get(r13), r11, true, r12);
        r13 = r13 - 1;
        goto L6
    }

    static void callSharedElementStartEnd(Fragment r10, Fragment r11, boolean r12, ArrayMap<String, View> r13, boolean r14) {
        if (r12 == false) goto L4;
        SharedElementCallback r15 = r11.getEnterTransitionCallback();
    L5:
        if (r15 == null) goto L19;
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        int r18 = 0;
        if (r13 != null) goto L9;
        int r19 = 0;
    L10:
        if (r18 >= r19) goto L13;
        r17.add(r13.keyAt(r18));
        r16.add(r13.valueAt(r18));
        r18 = r18 + 1;
        goto L10
    L13:
        if (r14 == false) goto L15;
        r15.onSharedElementStart(r17, r16, null);
        return;
    L15:
        r15.onSharedElementEnd(r17, r16, null);
        return;
    L9:
        r19 = r13.size();
        goto L10
    L19:
        return;
    L4:
        r15 = r10.getEnterTransitionCallback();
        goto L5
    }

    private static boolean canHandleAll(FragmentTransitionImpl r10, List<Object> r11) {
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r10.canHandle(r11.get(r13)) == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl r10, ArrayMap<String, String> r11, Object r12, FragmentContainerTransition r13) {
        Fragment r14 = r13.lastIn;
        View r15 = r14.getView();
        if (r11.isEmpty() == true) goto L29;
        if (r12 == null) goto L29;
        if (r15 == null) goto L29;
        ArrayMap<String, View> r16 = new ArrayMap();
        r10.findNamedViews(r16, r15);
        BackStackRecord r17 = r13.lastInTransaction;
        if (r13.lastInIsPop == false) goto L10;
        SharedElementCallback r18 = r14.getExitTransitionCallback();
        ArrayList<String> r19 = r17.mSharedElementSourceNames;
    L11:
        if (r19 == null) goto L13;
        r16.retainAll(r19);
        r16.retainAll(r11.values());
    L13:
        if (r18 == null) goto L27;
        r18.onMapSharedElements(r19, r16);
        int r20 = r19.size() - 1;
    L15:
        if (r20 < 0) goto L28;
        String r21 = r19.get(r20);
        View r22 = r16.get(r21);
        if (r22 != null) goto L22;
        String r23 = findKeyForValue(r11, r21);
        if (r23 == null) goto L26;
        r11.remove(r23);
    L26:
        r20 = r20 - 1;
        goto L15
    L22:
        if (r21.equals(ViewCompat.getTransitionName(r22)) == true) goto L26;
        String r24 = findKeyForValue(r11, r21);
        if (r24 == null) goto L26;
        r11.put(r24, ViewCompat.getTransitionName(r22));
    L28:
        return r16;
    L27:
        retainValues(r11, r16);
        goto L28
    L10:
        r18 = r14.getEnterTransitionCallback();
        r19 = r17.mSharedElementTargetNames;
    L29:
        r11.clear();
        return null;
    }

    private static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl r10, ArrayMap<String, String> r11, Object r12, FragmentContainerTransition r13) {
        if (r11.isEmpty() == true) goto L24;
        if (r12 == null) goto L24;
        Fragment r14 = r13.firstOut;
        ArrayMap<String, View> r15 = new ArrayMap();
        r10.findNamedViews(r15, r14.requireView());
        BackStackRecord r16 = r13.firstOutTransaction;
        if (r13.firstOutIsPop == false) goto L9;
        SharedElementCallback r17 = r14.getEnterTransitionCallback();
        ArrayList<String> r18 = r16.mSharedElementTargetNames;
    L10:
        if (r18 == null) goto L12;
        r15.retainAll(r18);
    L12:
        if (r17 == null) goto L22;
        r17.onMapSharedElements(r18, r15);
        int r19 = r18.size() - 1;
    L14:
        if (r19 < 0) goto L23;
        String r20 = r18.get(r19);
        View r21 = r15.get(r20);
        if (r21 != null) goto L19;
        r11.remove(r20);
    L21:
        r19 = r19 - 1;
        goto L14
    L19:
        if (r20.equals(ViewCompat.getTransitionName(r21)) == true) goto L21;
        r11.put(ViewCompat.getTransitionName(r21), r11.remove(r20));
    L23:
        return r15;
    L22:
        r11.retainAll(r15.keySet());
        goto L23
    L9:
        r17 = r14.getExitTransitionCallback();
        r18 = r16.mSharedElementSourceNames;
    L24:
        r11.clear();
        return null;
    }

    private static FragmentTransitionImpl chooseImpl(Fragment r10, Fragment r11) {
        ArrayList r12 = new ArrayList();
        if (r10 == null) goto L13;
        Object r13 = r10.getExitTransition();
        if (r13 == null) goto L7;
        r12.add(r13);
    L7:
        Object r14 = r10.getReturnTransition();
        if (r14 == null) goto L10;
        r12.add(r14);
    L10:
        Object r15 = r10.getSharedElementReturnTransition();
        if (r15 == null) goto L13;
        r12.add(r15);
    L13:
        if (r11 == null) goto L24;
        Object r16 = r11.getEnterTransition();
        if (r16 == null) goto L17;
        r12.add(r16);
    L17:
        Object r17 = r11.getReenterTransition();
        if (r17 == null) goto L20;
        r12.add(r17);
    L20:
        Object r18 = r11.getSharedElementEnterTransition();
        if (r18 == null) goto L24;
        r12.add(r18);
    L24:
        if (r12.isEmpty() == false) goto L26;
        return null;
    L26:
        FragmentTransitionImpl r19 = PLATFORM_IMPL;
        if (r19 != null) goto L29;
    L31:
        FragmentTransitionImpl r20 = SUPPORT_IMPL;
        if (r20 != null) goto L34;
    L36:
        if (r19 != null) goto L40;
        if (r20 != null) goto L40;
        return null;
    L40:
        throw new IllegalArgumentException("Invalid Transition types");
    L34:
        if (canHandleAll(r20, r12) == false) goto L36;
        return r20;
    L29:
        if (canHandleAll(r19, r12) == false) goto L31;
        return r19;
    }

    static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl r10, Object r11, Fragment r12, ArrayList<View> r13, View r14) {
        if (r11 == null) goto L11;
        ArrayList<View> r15 = new ArrayList();
        View r16 = r12.getView();
        if (r16 == null) goto L6;
        r10.captureTransitioningViews(r15, r16);
    L6:
        if (r13 == null) goto L9;
        r15.removeAll(r13);
    L9:
        if (r15.isEmpty() == true) goto L13;
        r15.add(r14);
        r10.addTargets(r11, r15);
        return r15;
    L13:
        return r15;
    L11:
        return null;
    }

    private static Object configureSharedElementsOrdered(final FragmentTransitionImpl r17, ViewGroup r18, final View r19, final ArrayMap<String, String> r20, final FragmentContainerTransition r21, final ArrayList<View> r22, final ArrayList<View> r23, final Object r24, Object r25) {
        final Fragment r10 = r21.lastIn;
        final Fragment r11 = r21.firstOut;
        if (r10 == null) goto L26;
        if (r11 == null) goto L26;
        final boolean r12 = r21.lastInIsPop;
        if (r20.isEmpty() == false) goto L9;
        Object r13 = null;
    L10:
        ArrayMap<String, View> r14 = captureOutSharedElements(r17, r20, r13, r21);
        if (r20.isEmpty() == false) goto L13;
        Object r15 = null;
    L14:
        if (r24 != null) goto L18;
        if (r25 != null) goto L18;
        if (r15 != null) goto L18;
        return null;
    L18:
        callSharedElementStartEnd(r10, r11, r12, r14, true);
        if (r15 == null) goto L23;
        Rect r16 = new Rect();
        r17.setSharedElementTargets(r15, r19, r22);
        setOutEpicenter(r17, r15, r25, r14, r21.firstOutIsPop, r21.firstOutTransaction);
        if (r24 == null) goto L24;
        r17.setEpicenter(r24, r16);
    L24:
        final Object r26 = r15;
        final Rect r110 = r16;
        OneShotPreDrawListener.add(r18, new AnonymousClass6(r17, r20, r26, r21, r23, r19, r10, r11, r12, r22, r24, r110));
        return r15;
    L23:
        r16 = null;
        goto L24
    L13:
        r22.addAll(r14.values());
        r15 = r13;
        goto L14
    L9:
        r13 = getSharedElementTransition(r17, r10, r11, r12);
    L26:
        return null;
    }

    private static Object configureSharedElementsReordered(final FragmentTransitionImpl r15, ViewGroup r16, View r17, ArrayMap<String, String> r18, FragmentContainerTransition r19, ArrayList<View> r20, ArrayList<View> r21, Object r22, Object r23) {
        final Fragment r10 = r19.lastIn;
        final Fragment r11 = r19.firstOut;
        if (r10 == null) goto L6;
        r10.requireView().setVisibility(0);
    L6:
        if (r10 == null) goto L34;
        if (r11 == null) goto L34;
        final boolean r12 = r19.lastInIsPop;
        if (r18.isEmpty() == false) goto L12;
        Object r13 = null;
    L13:
        ArrayMap<String, View> r14 = captureOutSharedElements(r15, r18, r13, r19);
        final ArrayMap<String, View> r110 = captureInSharedElements(r15, r18, r13, r19);
        if (r18.isEmpty() == false) goto L20;
        if (r14 == null) goto L17;
        r14.clear();
    L17:
        if (r110 == null) goto L19;
        r110.clear();
    L19:
        Object r111 = null;
    L21:
        if (r22 != null) goto L25;
        if (r23 != null) goto L25;
        if (r111 != null) goto L25;
        return null;
    L25:
        callSharedElementStartEnd(r10, r11, r12, r14, true);
        if (r111 == null) goto L31;
        r21.add(r17);
        r15.setSharedElementTargets(r111, r17, r20);
        setOutEpicenter(r15, r111, r23, r14, r19.firstOutIsPop, r19.firstOutTransaction);
        Rect r24 = new Rect();
        View r25 = getInEpicenterView(r110, r19, r22, r12);
        if (r25 == null) goto L30;
        r15.setEpicenter(r22, r24);
    L30:
        final Rect r26 = r24;
        final View r27 = r25;
    L32:
        OneShotPreDrawListener.add(r16, new AnonymousClass5(r10, r11, r12, r110, r27, r15, r26));
        return r111;
    L31:
        r27 = null;
        r26 = null;
        goto L32
    L20:
        addSharedElementsWithMatchingNames(r20, r14, r18.keySet());
        addSharedElementsWithMatchingNames(r21, r110, r18.values());
        r111 = r13;
        goto L21
    L12:
        r13 = getSharedElementTransition(r15, r10, r11, r12);
    L34:
        return null;
    }

    private static void configureTransitionsOrdered(@NonNull ViewGroup r20, FragmentContainerTransition r21, View r22, ArrayMap<String, String> r23, final Callback r24) {
        Fragment r14 = r21.lastIn;
        final Fragment r15 = r21.firstOut;
        FragmentTransitionImpl r10 = chooseImpl(r15, r14);
        if (r10 != null) goto L5;
        return;
    L5:
        boolean r11 = r21.lastInIsPop;
        boolean r12 = r21.firstOutIsPop;
        Object r13 = getEnterTransition(r10, r14, r11);
        Object r16 = getExitTransition(r10, r15, r12);
        ArrayList r17 = new ArrayList();
        ArrayList<View> r18 = new ArrayList();
        Object r19 = configureSharedElementsOrdered(r10, r20, r22, r23, r21, r17, r18, r13, r16);
        if (r13 != null) goto L11;
        if (r19 != null) goto L11;
        Object r25 = r16;
        if (r25 != null) goto L12;
        return;
    L12:
        ArrayList<View> r110 = configureEnteringExitingViews(r10, r25, r15, r17, r22);
        if (r110 != null) goto L15;
    L16:
        r25 = null;
    L17:
        Object r111 = r25;
        r10.addTarget(r13, r22);
        Object r112 = mergeTransitions(r10, r13, r111, r19, r14, r21.lastInIsPop);
        if (r15 == null) goto L25;
        if (r110 == null) goto L25;
        if (r110.size() <= 0) goto L23;
    L24:
        final CancellationSignal r26 = new CancellationSignal();
        r24.onStart(r15, r26);
        r10.setListenerForTransitionEnd(r15, r112, r26, new AnonymousClass3(r24, r15, r26));
        goto L25
    L23:
        if (r17.size() > 0) goto L24;
    L25:
        if (r112 == null) goto L28;
        ArrayList<View> r113 = new ArrayList();
        r10.scheduleRemoveTargets(r112, r13, r113, r111, r110, r19, r18);
        scheduleTargetChange(r10, r20, r14, r22, r18, r13, r113, r111, r110);
        r10.setNameOverridesOrdered(r20, r18, r23);
        r10.beginDelayedTransition(r20, r112);
        r10.scheduleNameReset(r20, r18, r23);
        return;
    L28:
        return;
    L15:
        if (r110.isEmpty() == false) goto L17;
    L11:
        r25 = r16;
        goto L12
    }

    private static void configureTransitionsReordered(@NonNull ViewGroup r17, FragmentContainerTransition r18, View r19, ArrayMap<String, String> r20, final Callback r21) {
        Fragment r11 = r18.lastIn;
        final Fragment r12 = r18.firstOut;
        FragmentTransitionImpl r13 = chooseImpl(r12, r11);
        if (r13 != null) goto L5;
        return;
    L5:
        boolean r14 = r18.lastInIsPop;
        boolean r10 = r18.firstOutIsPop;
        ArrayList<View> r15 = new ArrayList();
        ArrayList<View> r16 = new ArrayList();
        Object r22 = getEnterTransition(r13, r11, r14);
        Object r23 = getExitTransition(r13, r12, r10);
        Object r24 = configureSharedElementsReordered(r13, r17, r19, r20, r18, r16, r15, r22, r23);
        if (r22 != null) goto L11;
        if (r24 != null) goto L11;
        Object r25 = r23;
        if (r25 != null) goto L12;
        return;
    L12:
        ArrayList<View> r26 = configureEnteringExitingViews(r13, r25, r12, r16, r19);
        ArrayList<View> r27 = configureEnteringExitingViews(r13, r22, r11, r15, r19);
        setViewVisibility(r27, 4);
        Object r110 = mergeTransitions(r13, r22, r25, r24, r11, r14);
        if (r12 == null) goto L20;
        if (r26 == null) goto L20;
        if (r26.size() <= 0) goto L18;
    L19:
        final CancellationSignal r28 = new CancellationSignal();
        r21.onStart(r12, r28);
        r13.setListenerForTransitionEnd(r12, r110, r28, new AnonymousClass1(r21, r12, r28));
        goto L20
    L18:
        if (r16.size() > 0) goto L19;
    L20:
        if (r110 == null) goto L23;
        replaceHide(r13, r25, r12, r26);
        ArrayList<String> r111 = r13.prepareSetNameOverridesReordered(r15);
        r13.scheduleRemoveTargets(r110, r22, r27, r25, r26, r24, r15);
        r13.beginDelayedTransition(r17, r110);
        r13.setNameOverridesReordered(r17, r16, r15, r111, r20);
        setViewVisibility(r27, 0);
        r13.swapSharedElementTargets(r24, r16, r15);
        return;
    L23:
        return;
    L11:
        r25 = r23;
        goto L12
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition r10, SparseArray<FragmentContainerTransition> r11, int r12) {
        if (r10 != null) goto L5;
        FragmentContainerTransition r13 = new FragmentContainerTransition();
        r11.put(r12, r13);
        return r13;
    L5:
        return r10;
    }

    static String findKeyForValue(ArrayMap<String, String> r10, String r11) {
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.equals(r10.valueAt(r13)) == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return r10.keyAt(r13);
    L9:
        return null;
    }

    private static Object getEnterTransition(FragmentTransitionImpl r10, Fragment r11, boolean r12) {
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r12 == false) goto L7;
        Object r13 = r11.getReenterTransition();
    L9:
        return r10.cloneTransition(r13);
    L7:
        r13 = r11.getEnterTransition();
        goto L9
    }

    private static Object getExitTransition(FragmentTransitionImpl r10, Fragment r11, boolean r12) {
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r12 == false) goto L7;
        Object r13 = r11.getReturnTransition();
    L9:
        return r10.cloneTransition(r13);
    L7:
        r13 = r11.getExitTransition();
        goto L9
    }

    static View getInEpicenterView(ArrayMap<String, View> r10, FragmentContainerTransition r11, Object r12, boolean r13) {
        BackStackRecord r14 = r11.lastInTransaction;
        if (r12 == null) goto L15;
        if (r10 == null) goto L17;
        ArrayList<String> r15 = r14.mSharedElementSourceNames;
        if (r15 != null) goto L8;
        return null;
    L8:
        if (r15.isEmpty() == false) goto L10;
        return null;
    L10:
        if (r13 == false) goto L12;
        ArrayList<String> r16 = r14.mSharedElementSourceNames;
    L14:
        return r10.get(r16.get(0));
    L12:
        r16 = r14.mSharedElementTargetNames;
        goto L14
    L17:
        return null;
    L15:
        return null;
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl r10, Fragment r11, Fragment r12, boolean r13) {
        if (r11 == null) goto L10;
        if (r12 == null) goto L12;
        if (r13 == false) goto L7;
        Object r14 = r12.getSharedElementReturnTransition();
    L9:
        return r10.wrapTransitionInSet(r10.cloneTransition(r14));
    L7:
        r14 = r11.getSharedElementEnterTransition();
        goto L9
    L12:
        return null;
    L10:
        return null;
    }

    private static Object mergeTransitions(FragmentTransitionImpl r10, Object r11, Object r12, Object r13, Fragment r14, boolean r15) {
        if (r11 == null) goto L8;
        if (r12 == null) goto L8;
        if (r14 == null) goto L8;
        if (r15 == false) goto L7;
        boolean r16 = r14.getAllowReturnTransitionOverlap();
    L9:
        if (r16 == false) goto L12;
        return r10.mergeTransitionsTogether(r12, r11, r13);
    L12:
        return r10.mergeTransitionsInSequence(r12, r11, r13);
    L7:
        r16 = r14.getAllowEnterTransitionOverlap();
    L8:
        r16 = true;
        goto L9
    }

    private static void replaceHide(FragmentTransitionImpl r10, Object r11, Fragment r12, final ArrayList<View> r13) {
        if (r12 == null) goto L12;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r12.mAdded == true) goto L7;
        return;
    L7:
        if (r12.mHidden == true) goto L9;
        return;
    L9:
        if (r12.mHiddenChanged == false) goto L16;
        r12.setHideReplaced(true);
        r10.scheduleHideFragmentView(r11, r12.getView(), r13);
        OneShotPreDrawListener.add(r12.mContainer, new AnonymousClass2(r13));
        return;
    L16:
        return;
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        return (FragmentTransitionImpl) FragmentTransitionSupport.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        return null;
    }

    static void retainValues(@NonNull ArrayMap<String, String> r10, @NonNull ArrayMap<String, View> r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L8;
        if (r11.containsKey(r10.valueAt(r12)) == true) goto L7;
        r10.removeAt(r12);
    L7:
        r12 = r12 - 1;
        goto L3
    }

    private static void scheduleTargetChange(final FragmentTransitionImpl r10, ViewGroup r11, final Fragment r12, final View r13, final ArrayList<View> r14, final Object r15, final ArrayList<View> r16, final Object r17, final ArrayList<View> r18) {
        OneShotPreDrawListener.add(r11, new AnonymousClass4(r15, r10, r13, r12, r14, r16, r18, r17));
    }

    private static void setOutEpicenter(FragmentTransitionImpl r10, Object r11, Object r12, ArrayMap<String, View> r13, boolean r14, BackStackRecord r15) {
        ArrayList<String> r16 = r15.mSharedElementSourceNames;
        if (r16 != null) goto L5;
        return;
    L5:
        if (r16.isEmpty() == false) goto L7;
        return;
    L7:
        if (r14 == false) goto L9;
        ArrayList<String> r17 = r15.mSharedElementTargetNames;
    L10:
        View r18 = r13.get(r17.get(0));
        r10.setEpicenter(r11, r18);
        if (r12 == null) goto L16;
        r10.setEpicenter(r12, r18);
        return;
    L16:
        return;
    L9:
        r17 = r15.mSharedElementSourceNames;
        goto L10
    }

    static void setViewVisibility(ArrayList<View> r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = r10.size() - 1;
    L5:
        if (r12 < 0) goto L7;
        r10.get(r12).setVisibility(r11);
        r12 = r12 - 1;
        goto L5
    }

    static void startTransitions(@NonNull Context r10, @NonNull FragmentContainer r11, ArrayList<BackStackRecord> r12, ArrayList<Boolean> r13, int r14, int r15, boolean r16, Callback r17) {
        SparseArray r18 = new SparseArray();
        int r19 = r14;
    L3:
        if (r19 >= r15) goto L10;
        BackStackRecord r20 = r12.get(r19);
        if (r13.get(r19).booleanValue() == false) goto L7;
        calculatePopFragments(r20, r18, r16);
    L8:
        r19 = r19 + 1;
        goto L3
    L7:
        calculateFragments(r20, r18, r16);
        goto L8
    L10:
        if (r18.size() == 0) goto L22;
        View r21 = new View(r10);
        int r22 = r18.size();
        int r23 = 0;
    L12:
        if (r23 >= r22) goto L31;
        int r24 = r18.keyAt(r23);
        ArrayMap<String, String> r25 = calculateNameOverrides(r24, r12, r13, r14, r15);
        FragmentContainerTransition r26 = (FragmentContainerTransition) r18.valueAt(r23);
        if (r11.onHasView() == false) goto L21;
        ViewGroup r27 = (ViewGroup) r11.onFindViewById(r24);
        if (r27 == null) goto L21;
        if (r16 == false) goto L20;
        configureTransitionsReordered(r27, r26, r21, r25, r17);
        goto L21
    L20:
        configureTransitionsOrdered(r27, r26, r21, r25, r17);
    L21:
        r23 = r23 + 1;
        goto L12
    L31:
        return;
    }

    static boolean supportsTransition() {
        if (PLATFORM_IMPL == null) goto L5;
    L8:
        return true;
    L5:
        if (SUPPORT_IMPL != null) goto L8;
        return false;
    }
}
