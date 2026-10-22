package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    private ArrayList<Transition> mTransitions;

    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet r10) {
            this.mTransitionSet = r10;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r10) {
            TransitionSet r11 = this.mTransitionSet;
            int r12 = r11.mCurrentListeners - 1;
            r11.mCurrentListeners = r12;
            if (r12 != 0) goto L5;
            r11.mStarted = false;
            r11.end();
        L5:
            r10.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r10) {
            TransitionSet r11 = this.mTransitionSet;
            if (r11.mStarted == true) goto L6;
            r11.start();
            this.mTransitionSet.mStarted = true;
            return;
        }
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(r12, (XmlResourceParser) r11, "transitionOrdering", 0, 0));
        r12.recycle();
    }

    private void addTransitionInternal(@NonNull Transition r10) {
        this.mTransitions.add(r10);
        r10.mParent = this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener r10 = new TransitionSetListener(this);
        Iterator<Transition> r11 = this.mTransitions.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().addListener(r10);
        goto L4
    L6:
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addListener(@NonNull Transition.TransitionListener r10) {
        return addListener(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener r10) {
        return (TransitionSet) super.addListener(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@IdRes int r10) {
        return addTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull View r10) {
        return addTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull Class r10) {
        return addTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull String r10) {
        return addTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).addTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).addTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).addTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).addTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r10);
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition r10) {
        addTransitionInternal(r10);
        long r11 = this.mDuration;
        if (r11 < 0) goto L6;
        r10.setDuration(r11);
    L6:
        if ((this.mChangeFlags & 1) == 0) goto L9;
        r10.setInterpolator(getInterpolator());
    L9:
        if ((this.mChangeFlags & 2) == 0) goto L12;
        r10.setPropagation(getPropagation());
    L12:
        if ((this.mChangeFlags & 4) == 0) goto L15;
        r10.setPathMotion(getPathMotion());
    L15:
        if ((this.mChangeFlags & 8) == 0) goto L17;
        r10.setEpicenterCallback(getEpicenterCallback());
    L17:
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void cancel() {
        super.cancel();
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mTransitions.get(r11).cancel();
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r10) {
        if (isValidTarget(r10.view) == false) goto L10;
        Iterator<Transition> r11 = this.mTransitions.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        Transition r12 = r11.next();
        if (r12.isValidTarget(r10.view) == false) goto L6;
        r12.captureEndValues(r10);
        r10.mTargetedTransitions.add(r12);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    void capturePropagationValues(TransitionValues r10) {
        super.capturePropagationValues(r10);
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mTransitions.get(r12).capturePropagationValues(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        if (isValidTarget(r10.view) == false) goto L10;
        Iterator<Transition> r11 = this.mTransitions.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        Transition r12 = r11.next();
        if (r12.isValidTarget(r10.view) == false) goto L6;
        r12.captureStartValues(r10);
        r10.mTargetedTransitions.add(r12);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    public Transition clone() {
        TransitionSet r10 = (TransitionSet) super.clone();
        r10.mTransitions = new ArrayList();
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.addTransitionInternal(this.mTransitions.get(r12).clone());
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo9clone() {
        return clone();
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void createAnimators(ViewGroup r13, TransitionValuesMaps r14, TransitionValuesMaps r15, ArrayList<TransitionValues> r16, ArrayList<TransitionValues> r17) {
        long r10 = getStartDelay();
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        Transition r18 = this.mTransitions.get(r12);
        if (r10 <= 0) goto L13;
        if (this.mPlayTogether == true) goto L9;
        if (r12 != 0) goto L13;
    L9:
        long r19 = r18.getStartDelay();
        if (r19 <= 0) goto L12;
        r18.setStartDelay(r19 + r10);
        goto L13
    L12:
        r18.setStartDelay(r10);
    L13:
        r18.createAnimators(r13, r14, r15, r16, r17);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int r10, boolean r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r12).excludeTarget(r10, r11);
        r12 = r12 + 1;
        goto L4
    L7:
        return super.excludeTarget(r10, r11);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View r10, boolean r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r12).excludeTarget(r10, r11);
        r12 = r12 + 1;
        goto L4
    L7:
        return super.excludeTarget(r10, r11);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> r10, boolean r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r12).excludeTarget(r10, r11);
        r12 = r12 + 1;
        goto L4
    L7:
        return super.excludeTarget(r10, r11);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String r10, boolean r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r12).excludeTarget(r10, r11);
        r12 = r12 + 1;
        goto L4
    L7:
        return super.excludeTarget(r10, r11);
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void forceToEnd(ViewGroup r10) {
        super.forceToEnd(r10);
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mTransitions.get(r12).forceToEnd(r10);
        r12 = r12 + 1;
        goto L3
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int r10) {
        if (r10 >= 0) goto L4;
        return null;
    L4:
        if (r10 < this.mTransitions.size()) goto L7;
        return null;
    L7:
        return this.mTransitions.get(r10);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View r10) {
        super.pause(r10);
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mTransitions.get(r12).pause(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeListener(@NonNull Transition.TransitionListener r10) {
        return removeListener(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener r10) {
        return (TransitionSet) super.removeListener(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@IdRes int r10) {
        return removeTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull View r10) {
        return removeTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull Class r10) {
        return removeTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull String r10) {
        return removeTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).removeTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).removeTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).removeTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).removeTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r10);
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition r10) {
        this.mTransitions.remove(r10);
        r10.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View r10) {
        super.resume(r10);
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mTransitions.get(r12).resume(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void runAnimators() {
        if (this.mTransitions.isEmpty() == false) goto L6;
        start();
        end();
        return;
    L6:
        setupStartEndListeners();
        if (this.mPlayTogether == true) goto L15;
        int r10 = 1;
    L10:
        if (r10 >= this.mTransitions.size()) goto L12;
        Transition r11 = this.mTransitions.get(r10 - 1);
        final Transition r12 = this.mTransitions.get(r10);
        r11.addListener(new AnonymousClass1(this, r12));
        r10 = r10 + 1;
        goto L10
    L12:
        Transition r13 = this.mTransitions.get(0);
        if (r13 == null) goto L19;
        r13.runAnimators();
        return;
    L19:
        return;
    L15:
        Iterator<Transition> r14 = this.mTransitions.iterator();
    L17:
        if (r14.hasNext() == false) goto L23;
        r14.next().runAnimators();
        goto L17
    }

    @Override // androidx.transition.Transition
    void setCanRemoveViews(boolean r10) {
        super.setCanRemoveViews(r10);
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mTransitions.get(r12).setCanRemoveViews(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition setDuration(long r10) {
        return setDuration(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setDuration(long r10) {
        super.setDuration(r10);
        if (this.mDuration < 0) goto L9;
        ArrayList<Transition> r11 = this.mTransitions;
        if (r11 == null) goto L9;
        int r12 = r11.size();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        this.mTransitions.get(r13).setDuration(r10);
        r13 = r13 + 1;
    L9:
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback r10) {
        super.setEpicenterCallback(r10);
        this.mChangeFlags |= 8;
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mTransitions.get(r12).setEpicenterCallback(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition setInterpolator(@Nullable TimeInterpolator r10) {
        return setInterpolator(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator r10) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> r11 = this.mTransitions;
        if (r11 == null) goto L8;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L8;
        this.mTransitions.get(r13).setInterpolator(r10);
        r13 = r13 + 1;
    L8:
        return (TransitionSet) super.setInterpolator(r10);
    }

    @NonNull
    public TransitionSet setOrdering(int r10) {
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        this.mPlayTogether = false;
    L9:
        return this;
    L7:
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + r10);
    L8:
        this.mPlayTogether = true;
        goto L9
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion r10) {
        super.setPathMotion(r10);
        this.mChangeFlags |= 4;
        if (this.mTransitions == null) goto L8;
        int r11 = 0;
    L6:
        if (r11 >= this.mTransitions.size()) goto L10;
        this.mTransitions.get(r11).setPathMotion(r10);
        r11 = r11 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation r10) {
        super.setPropagation(r10);
        this.mChangeFlags |= 2;
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mTransitions.get(r12).setPropagation(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    /* bridge */ /* synthetic */ Transition setSceneRoot(ViewGroup r10) {
        return setSceneRoot(r10);
    }

    @Override // androidx.transition.Transition
    TransitionSet setSceneRoot(ViewGroup r10) {
        super.setSceneRoot(r10);
        int r11 = this.mTransitions.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mTransitions.get(r12).setSceneRoot(r10);
        r12 = r12 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition setStartDelay(long r10) {
        return setStartDelay(r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long r10) {
        return (TransitionSet) super.setStartDelay(r10);
    }

    @Override // androidx.transition.Transition
    String toString(String r10) {
        String r11 = super.toString(r10);
        int r12 = 0;
    L4:
        if (r12 >= this.mTransitions.size()) goto L6;
        StringBuilder r13 = new StringBuilder();
        r13.append(r11);
        r13.append("\n");
        r13.append(this.mTransitions.get(r12).toString(r10 + "  "));
        r11 = r13.toString();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }
}
