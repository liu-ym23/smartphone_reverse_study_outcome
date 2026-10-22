package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FragmentTransitionCompat21 extends FragmentTransitionImpl {

    static class Api19Impl {
        private Api19Impl() {
        }

        static void addListener(Transition r2, Transition.TransitionListener r3) {
            r2.addListener((Transition.TransitionListener) ZeusTransformUtils.wrapperContextForParams(r3, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        }

        static void removeListener(Transition r2, Transition.TransitionListener r3) {
            r2.removeListener((Transition.TransitionListener) ZeusTransformUtils.wrapperContextForParams(r3, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        }
    }

    FragmentTransitionCompat21() {
    }

    private static boolean hasSimpleTarget(Transition r1) {
        if (isNullOrEmpty(r1.getTargetIds()) == true) goto L5;
    L10:
        return true;
    L5:
        if (isNullOrEmpty(r1.getTargetNames()) == false) goto L10;
        if (isNullOrEmpty(r1.getTargetTypes()) == false) goto L10;
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object r2, View r3) {
        if (r2 == null) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(r2, Transition.class, "com.obric.memorydata.plugin")).addTarget(r3);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object r5, ArrayList<View> r6) {
        Transition r7 = (Transition) ZeusTransformUtils.preCheckCast(r5, Transition.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r7, TransitionSet.class) == false) goto L11;
        TransitionSet r8 = (TransitionSet) ZeusTransformUtils.preCheckCast(r7, TransitionSet.class, "com.obric.memorydata.plugin");
        int r0 = r8.getTransitionCount();
    L8:
        if (r2 >= r0) goto L21;
        addTargets(r8.getTransitionAt(r2), r6);
        r2 = r2 + 1;
        goto L8
    L21:
        return;
    L11:
        if (hasSimpleTarget(r7) == false) goto L13;
        return;
    L13:
        if (isNullOrEmpty(r7.getTargets()) == false) goto L20;
        int r4 = r6.size();
    L15:
        if (r2 >= r4) goto L22;
        r7.addTarget((View) ZeusTransformUtils.preCheckCast(r6.get(r2), View.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L15
    L22:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup r2, Object r3) {
        TransitionManager.beginDelayedTransition(r2, (Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, Transition.class);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((Transition) ZeusTransformUtils.preCheckCast(r2, Transition.class, "com.obric.memorydata.plugin")).clone();
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object r2, Object r3, Object r4) {
        Transition r1 = (Transition) ZeusTransformUtils.preCheckCast(r2, Transition.class, "com.obric.memorydata.plugin");
        Transition r5 = (Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin");
        Transition r6 = (Transition) ZeusTransformUtils.preCheckCast(r4, Transition.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        if (r5 == null) goto L6;
        r1 = new TransitionSet().addTransition(r1).addTransition(r5).setOrdering(1);
    L11:
        if (r6 == null) goto L17;
        TransitionSet r7 = new TransitionSet();
        if (r1 == null) goto L15;
        r7.addTransition(r1);
    L15:
        r7.addTransition(r6);
        return r7;
    L17:
        return r1;
    L6:
        if (r1 != null) goto L11;
        if (r5 == null) goto L10;
        r1 = r5;
        goto L11
    L10:
        r1 = null;
        goto L11
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object r3, Object r4, Object r5) {
        TransitionSet r2 = new TransitionSet();
        if (r3 == null) goto L5;
        r2.addTransition((Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin"));
    L5:
        if (r4 == null) goto L7;
        r2.addTransition((Transition) ZeusTransformUtils.preCheckCast(r4, Transition.class, "com.obric.memorydata.plugin"));
    L7:
        if (r5 == null) goto L9;
        r2.addTransition((Transition) ZeusTransformUtils.preCheckCast(r5, Transition.class, "com.obric.memorydata.plugin"));
    L9:
        return r2;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object r2, View r3) {
        if (r2 == null) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(r2, Transition.class, "com.obric.memorydata.plugin")).removeTarget(r3);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object r5, ArrayList<View> r6, ArrayList<View> r7) {
        Transition r8 = (Transition) ZeusTransformUtils.preCheckCast(r5, Transition.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r8, TransitionSet.class) == false) goto L8;
        TransitionSet r9 = (TransitionSet) ZeusTransformUtils.preCheckCast(r8, TransitionSet.class, "com.obric.memorydata.plugin");
        int r0 = r9.getTransitionCount();
    L5:
        if (r2 >= r0) goto L31;
        replaceTargets(r9.getTransitionAt(r2), r6, r7);
        r2 = r2 + 1;
        goto L5
    L31:
        return;
    L8:
        if (hasSimpleTarget(r8) == true) goto L23;
        List<View> r4 = r8.getTargets();
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.size() == r6.size()) goto L14;
        return;
    L14:
        if (r4.containsAll(r6) == false) goto L30;
        if (r7 != null) goto L17;
        int r10 = 0;
    L18:
        if (r2 >= r10) goto L20;
        r8.addTarget((View) ZeusTransformUtils.preCheckCast(r7.get(r2), View.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L18
    L20:
        int r11 = r6.size() - 1;
    L21:
        if (r11 < 0) goto L32;
        r8.removeTarget((View) ZeusTransformUtils.preCheckCast(r6.get(r11), View.class, "com.obric.memorydata.plugin"));
        r11 = r11 - 1;
        goto L21
    L32:
        return;
    L17:
        r10 = r7.size();
        goto L18
    L30:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object r3, final View r4, final ArrayList<View> r5) {
        ((Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin")).addListener(new AnonymousClass2(this, r4, r5));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object r11, final Object r12, final ArrayList<View> r13, final Object r14, final ArrayList<View> r15, final Object r16, final ArrayList<View> r17) {
        ((Transition) ZeusTransformUtils.preCheckCast(r11, Transition.class, "com.obric.memorydata.plugin")).addListener(new AnonymousClass3(this, r12, r13, r14, r15, r16, r17));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object r3, final Rect r4) {
        if (r3 == null) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin")).setEpicenterCallback(new AnonymousClass5(this, r4));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object r3, View r4) {
        if (r4 == null) goto L5;
        Transition r5 = (Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin");
        final Rect r0 = new Rect();
        getBoundsOnScreen(r4, r0);
        r5.setEpicenterCallback(new AnonymousClass1(this, r0));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(Fragment r1, Object r2, CancellationSignal r3, Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        ((Transition) ZeusTransformUtils.preCheckCast(r2, Transition.class, "com.obric.memorydata.plugin")).addListener(new AnonymousClass4(this, r5));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object r7, View r8, ArrayList<View> r9) {
        TransitionSet r10 = (TransitionSet) ZeusTransformUtils.preCheckCast(r7, TransitionSet.class, "com.obric.memorydata.plugin");
        List<View> r0 = r10.getTargets();
        r0.clear();
        int r2 = r9.size();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        bfsAddViewChildren(r0, (View) ZeusTransformUtils.preCheckCast(r9.get(r3), View.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L3
    L5:
        r0.add(r8);
        r9.add(r8);
        addTargets(r10, r9);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object r3, ArrayList<View> r4, ArrayList<View> r5) {
        TransitionSet r6 = (TransitionSet) ZeusTransformUtils.preCheckCast(r3, TransitionSet.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L6;
        r6.getTargets().clear();
        r6.getTargets().addAll(r5);
        replaceTargets(r6, r4, r5);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        TransitionSet r2 = new TransitionSet();
        r2.addTransition((Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin"));
        return r2;
    }
}
