package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    public FragmentTransitionSupport() {
    }

    public static /* synthetic */ void a(Runnable r5, Transition r10, Runnable r11) {
        lambda$setListenerForTransitionEnd$0(r5, r10, r11);
    }

    private static boolean hasSimpleTarget(Transition r5) {
        if (FragmentTransitionImpl.isNullOrEmpty(r5.getTargetIds()) == true) goto L5;
    L10:
        return true;
    L5:
        if (FragmentTransitionImpl.isNullOrEmpty(r5.getTargetNames()) == false) goto L10;
        if (FragmentTransitionImpl.isNullOrEmpty(r5.getTargetTypes()) == false) goto L10;
        return false;
    }

    private static /* synthetic */ void lambda$setListenerForTransitionEnd$0(Runnable r5, Transition r10, Runnable r11) {
        if (r5 != null) goto L4;
        r10.cancel();
        r11.run();
        return;
    L4:
        r5.run();
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(@NonNull Object r5, @NonNull View r10) {
        if (r5 == null) goto L5;
        ((Transition) r5).addTarget(r10);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(@NonNull Object r5, @NonNull ArrayList<View> r10) {
        Transition r11 = (Transition) r5;
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = 0;
        if ((r11 instanceof TransitionSet) == false) goto L11;
        TransitionSet r13 = (TransitionSet) r11;
        int r14 = r13.getTransitionCount();
    L8:
        if (r12 >= r14) goto L21;
        addTargets(r13.getTransitionAt(r12), r10);
        r12 = r12 + 1;
        goto L8
    L21:
        return;
    L11:
        if (hasSimpleTarget(r11) == false) goto L13;
        return;
    L13:
        if (FragmentTransitionImpl.isNullOrEmpty(r11.getTargets()) == false) goto L20;
        int r15 = r10.size();
    L15:
        if (r12 >= r15) goto L22;
        r11.addTarget(r10.get(r12));
        r12 = r12 + 1;
        goto L15
    L22:
        return;
    }

    public void animateToEnd(@NonNull Object r5) {
        ((TransitionSeekController) r5).animateToEnd();
    }

    public void animateToStart(@NonNull Object r5, @NonNull Runnable r10) {
        ((TransitionSeekController) r5).animateToStart(r10);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(@NonNull ViewGroup r5, @Nullable Object r10) {
        TransitionManager.beginDelayedTransition(r5, (Transition) r10);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(@NonNull Object r5) {
        return r5 instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    @Nullable
    public Object cloneTransition(@Nullable Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ((Transition) r5).clone();
    }

    @Nullable
    public Object controlDelayedTransition(@NonNull ViewGroup r5, @NonNull Object r10) {
        return TransitionManager.controlDelayedTransition(r5, (Transition) r10);
    }

    public boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    @Nullable
    public Object mergeTransitionsInSequence(@Nullable Object r5, @Nullable Object r10, @Nullable Object r11) {
        Transition r12 = (Transition) r5;
        Transition r13 = (Transition) r10;
        Transition r14 = (Transition) r11;
        if (r12 == null) goto L6;
        if (r13 == null) goto L6;
        r12 = new TransitionSet().addTransition(r12).addTransition(r13).setOrdering(1);
    L11:
        if (r14 == null) goto L17;
        TransitionSet r15 = new TransitionSet();
        if (r12 == null) goto L15;
        r15.addTransition(r12);
    L15:
        r15.addTransition(r14);
        return r15;
    L17:
        return r12;
    L6:
        if (r12 != null) goto L11;
        if (r13 == null) goto L10;
        r12 = r13;
        goto L11
    L10:
        r12 = null;
        goto L11
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    @NonNull
    public Object mergeTransitionsTogether(@Nullable Object r5, @Nullable Object r10, @Nullable Object r11) {
        TransitionSet r12 = new TransitionSet();
        if (r5 == null) goto L5;
        r12.addTransition((Transition) r5);
    L5:
        if (r10 == null) goto L7;
        r12.addTransition((Transition) r10);
    L7:
        if (r11 == null) goto L9;
        r12.addTransition((Transition) r11);
    L9:
        return r12;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(@NonNull Object r5, @NonNull View r10) {
        if (r5 == null) goto L5;
        ((Transition) r5).removeTarget(r10);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(@NonNull Object r5, @SuppressLint({"UnknownNullness"}) ArrayList<View> r10, @SuppressLint({"UnknownNullness"}) ArrayList<View> r11) {
        Transition r12 = (Transition) r5;
        int r13 = 0;
        if ((r12 instanceof TransitionSet) == false) goto L8;
        TransitionSet r14 = (TransitionSet) r12;
        int r15 = r14.getTransitionCount();
    L5:
        if (r13 >= r15) goto L28;
        replaceTargets(r14.getTransitionAt(r13), r10, r11);
        r13 = r13 + 1;
        goto L5
    L28:
        return;
    L8:
        if (hasSimpleTarget(r12) == true) goto L21;
        List<View> r16 = r12.getTargets();
        if (r16.size() == r10.size()) goto L12;
        return;
    L12:
        if (r16.containsAll(r10) == false) goto L27;
        if (r11 != null) goto L15;
        int r17 = 0;
    L16:
        if (r13 >= r17) goto L18;
        r12.addTarget(r11.get(r13));
        r13 = r13 + 1;
        goto L16
    L18:
        int r18 = r10.size() - 1;
    L19:
        if (r18 < 0) goto L29;
        r12.removeTarget(r10.get(r18));
        r18 = r18 - 1;
        goto L19
    L29:
        return;
    L15:
        r17 = r11.size();
        goto L16
    L27:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(@NonNull Object r5, @NonNull final View r10, @NonNull final ArrayList<View> r11) {
        ((Transition) r5).addListener(new AnonymousClass2(this, r10, r11));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(@NonNull Object r11, @Nullable final Object r12, @Nullable final ArrayList<View> r13, @Nullable final Object r14, @Nullable final ArrayList<View> r15, @Nullable final Object r16, @Nullable final ArrayList<View> r17) {
        ((Transition) r11).addListener(new AnonymousClass3(this, r12, r13, r14, r15, r16, r17));
    }

    public void setCurrentPlayTime(@NonNull Object r10, float r11) {
        TransitionSeekController r12 = (TransitionSeekController) r10;
        if (r12.isReady() == false) goto L12;
        long r5 = (long) (r11 * r12.getDurationMillis());
        if (r5 != 0) goto L8;
        r5 = 1;
    L8:
        if (r5 != r12.getDurationMillis()) goto L10;
        r5 = r12.getDurationMillis() - 1;
    L10:
        r12.setCurrentPlayTimeMillis(r5);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(@NonNull Object r5, @Nullable View r10) {
        if (r10 == null) goto L5;
        final Rect r11 = new Rect();
        getBoundsOnScreen(r10, r11);
        ((Transition) r5).setEpicenterCallback(new AnonymousClass1(this, r11));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(@NonNull Fragment r10, @NonNull Object r11, @NonNull CancellationSignal r12, @NonNull Runnable r13) {
        setListenerForTransitionEnd(r10, r11, r12, null, r13);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(@NonNull Object r5, @NonNull View r10, @NonNull ArrayList<View> r11) {
        TransitionSet r12 = (TransitionSet) r5;
        List<View> r13 = r12.getTargets();
        r13.clear();
        int r14 = r11.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        FragmentTransitionImpl.bfsAddViewChildren(r13, r11.get(r15));
        r15 = r15 + 1;
        goto L3
    L5:
        r13.add(r10);
        r11.add(r10);
        addTargets(r12, r11);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(@Nullable Object r5, @Nullable ArrayList<View> r10, @Nullable ArrayList<View> r11) {
        TransitionSet r12 = (TransitionSet) r5;
        if (r12 == null) goto L6;
        r12.getTargets().clear();
        r12.getTargets().addAll(r11);
        replaceTargets(r12, r10, r11);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    @Nullable
    public Object wrapTransitionInSet(@Nullable Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        TransitionSet r10 = new TransitionSet();
        r10.addTransition((Transition) r5);
        return r10;
    }

    public boolean isSeekingSupported(@NonNull Object r5) {
        boolean r10 = ((Transition) r5).isSeekingSupported();
        if (r10 == true) goto L5;
        Log.v(FragmentManager.TAG, "Predictive back not available for AndroidX Transition " + r5 + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
    L5:
        return r10;
    }

    public void setListenerForTransitionEnd(@NonNull Fragment r5, @NonNull Object r10, @NonNull CancellationSignal r11, @Nullable final Runnable r12, @NonNull final Runnable r13) {
        final Transition r14 = (Transition) r10;
        r11.setOnCancelListener(new a(r12, r14, r13));
        r14.addListener(new AnonymousClass4(this, r13));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(@NonNull Object r5, @NonNull final Rect r10) {
        if (r5 == null) goto L5;
        ((Transition) r5).setEpicenterCallback(new AnonymousClass5(this, r10));
        return;
    }
}
