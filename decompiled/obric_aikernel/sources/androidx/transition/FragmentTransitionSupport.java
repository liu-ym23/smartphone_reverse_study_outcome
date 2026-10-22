package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    public FragmentTransitionSupport() {
    }

    private static boolean hasSimpleTarget(Transition r10) {
        if (FragmentTransitionImpl.isNullOrEmpty(r10.getTargetIds()) == true) goto L5;
    L10:
        return true;
    L5:
        if (FragmentTransitionImpl.isNullOrEmpty(r10.getTargetNames()) == false) goto L10;
        if (FragmentTransitionImpl.isNullOrEmpty(r10.getTargetTypes()) == false) goto L10;
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object r10, View r11) {
        if (r10 == null) goto L5;
        ((Transition) r10).addTarget(r11);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object r10, ArrayList<View> r11) {
        Transition r12 = (Transition) r10;
        if (r12 != null) goto L5;
        return;
    L5:
        int r13 = 0;
        if ((r12 instanceof TransitionSet) == false) goto L11;
        TransitionSet r14 = (TransitionSet) r12;
        int r15 = r14.getTransitionCount();
    L8:
        if (r13 >= r15) goto L21;
        addTargets(r14.getTransitionAt(r13), r11);
        r13 = r13 + 1;
        goto L8
    L21:
        return;
    L11:
        if (hasSimpleTarget(r12) == false) goto L13;
        return;
    L13:
        if (FragmentTransitionImpl.isNullOrEmpty(r12.getTargets()) == false) goto L20;
        int r16 = r11.size();
    L15:
        if (r13 >= r16) goto L22;
        r12.addTarget(r11.get(r13));
        r13 = r13 + 1;
        goto L15
    L22:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup r10, Object r11) {
        TransitionManager.beginDelayedTransition(r10, (Transition) r11);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object r10) {
        return r10 instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return ((Transition) r10).clone();
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object r10, Object r11, Object r12) {
        Transition r13 = (Transition) r10;
        Transition r14 = (Transition) r11;
        Transition r15 = (Transition) r12;
        if (r13 == null) goto L6;
        if (r14 == null) goto L6;
        r13 = new TransitionSet().addTransition(r13).addTransition(r14).setOrdering(1);
    L11:
        if (r15 == null) goto L17;
        TransitionSet r16 = new TransitionSet();
        if (r13 == null) goto L15;
        r16.addTransition(r13);
    L15:
        r16.addTransition(r15);
        return r16;
    L17:
        return r13;
    L6:
        if (r13 != null) goto L11;
        if (r14 == null) goto L10;
        r13 = r14;
        goto L11
    L10:
        r13 = null;
        goto L11
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object r10, Object r11, Object r12) {
        TransitionSet r13 = new TransitionSet();
        if (r10 == null) goto L5;
        r13.addTransition((Transition) r10);
    L5:
        if (r11 == null) goto L7;
        r13.addTransition((Transition) r11);
    L7:
        if (r12 == null) goto L9;
        r13.addTransition((Transition) r12);
    L9:
        return r13;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object r10, View r11) {
        if (r10 == null) goto L5;
        ((Transition) r10).removeTarget(r11);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object r10, ArrayList<View> r11, ArrayList<View> r12) {
        Transition r13 = (Transition) r10;
        int r14 = 0;
        if ((r13 instanceof TransitionSet) == false) goto L8;
        TransitionSet r15 = (TransitionSet) r13;
        int r16 = r15.getTransitionCount();
    L5:
        if (r14 >= r16) goto L28;
        replaceTargets(r15.getTransitionAt(r14), r11, r12);
        r14 = r14 + 1;
        goto L5
    L28:
        return;
    L8:
        if (hasSimpleTarget(r13) == true) goto L21;
        List<View> r17 = r13.getTargets();
        if (r17.size() == r11.size()) goto L12;
        return;
    L12:
        if (r17.containsAll(r11) == false) goto L27;
        if (r12 != null) goto L15;
        int r18 = 0;
    L16:
        if (r14 >= r18) goto L18;
        r13.addTarget(r12.get(r14));
        r14 = r14 + 1;
        goto L16
    L18:
        int r19 = r11.size() - 1;
    L19:
        if (r19 < 0) goto L29;
        r13.removeTarget(r11.get(r19));
        r19 = r19 - 1;
        goto L19
    L29:
        return;
    L15:
        r18 = r12.size();
        goto L16
    L27:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object r10, final View r11, final ArrayList<View> r12) {
        ((Transition) r10).addListener(new AnonymousClass2(this, r11, r12));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object r11, final Object r12, final ArrayList<View> r13, final Object r14, final ArrayList<View> r15, final Object r16, final ArrayList<View> r17) {
        ((Transition) r11).addListener(new AnonymousClass3(this, r12, r13, r14, r15, r16, r17));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object r10, final Rect r11) {
        if (r10 == null) goto L5;
        ((Transition) r10).setEpicenterCallback(new AnonymousClass4(this, r11));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object r10, View r11) {
        if (r11 == null) goto L5;
        final Rect r12 = new Rect();
        getBoundsOnScreen(r11, r12);
        ((Transition) r10).setEpicenterCallback(new AnonymousClass1(this, r12));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object r10, View r11, ArrayList<View> r12) {
        TransitionSet r13 = (TransitionSet) r10;
        List<View> r14 = r13.getTargets();
        r14.clear();
        int r15 = r12.size();
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        FragmentTransitionImpl.bfsAddViewChildren(r14, r12.get(r16));
        r16 = r16 + 1;
        goto L3
    L5:
        r14.add(r11);
        r12.add(r11);
        addTargets(r13, r12);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object r10, ArrayList<View> r11, ArrayList<View> r12) {
        TransitionSet r13 = (TransitionSet) r10;
        if (r13 == null) goto L6;
        r13.getTargets().clear();
        r13.getTargets().addAll(r12);
        replaceTargets(r13, r11, r12);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        TransitionSet r11 = new TransitionSet();
        r11.addTransition((Transition) r10);
        return r11;
    }
}
