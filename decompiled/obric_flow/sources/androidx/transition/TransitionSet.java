package androidx.transition;

import ai.j0;
import android.animation.TimeInterpolator;
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
import androidx.annotation.RequiresApi;
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
    ArrayList<Transition> mTransitions;

    public static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        public TransitionSetListener(TransitionSet r5) {
            this.mTransitionSet = r5;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
            TransitionSet r10 = this.mTransitionSet;
            int r11 = r10.mCurrentListeners - 1;
            r10.mCurrentListeners = r11;
            if (r11 != 0) goto L5;
            r10.mStarted = false;
            r10.end();
        L5:
            r5.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5) {
            TransitionSet r10 = this.mTransitionSet;
            if (r10.mStarted == true) goto L6;
            r10.start();
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

    private void addTransitionInternal(@NonNull Transition r5) {
        this.mTransitions.add(r5);
        r5.mParent = this;
    }

    private int indexOfTransition(long r5) {
        int r10 = 1;
    L4:
        if (r10 >= this.mTransitions.size()) goto L11;
        if (this.mTransitions.get(r10).mSeekOffsetInParent > r5) goto L8;
        r10 = r10 + 1;
        goto L4
    L8:
        return r10 - 1;
    L11:
        return this.mTransitions.size() - 1;
    }

    private void setupStartEndListeners() {
        TransitionSetListener r5 = new TransitionSetListener(this);
        Iterator<Transition> r10 = this.mTransitions.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().addListener(r5);
        goto L4
    L6:
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addListener(@NonNull Transition.TransitionListener r5) {
        return addListener(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@IdRes int r5) {
        return addTarget(r5);
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition r5) {
        addTransitionInternal(r5);
        long r10 = this.mDuration;
        if (r10 < 0) goto L6;
        r5.setDuration(r10);
    L6:
        if ((this.mChangeFlags & 1) == 0) goto L9;
        r5.setInterpolator(getInterpolator());
    L9:
        if ((this.mChangeFlags & 2) == 0) goto L12;
        r5.setPropagation(getPropagation());
    L12:
        if ((this.mChangeFlags & 4) == 0) goto L15;
        r5.setPathMotion(getPathMotion());
    L15:
        if ((this.mChangeFlags & 8) == 0) goto L17;
        r5.setEpicenterCallback(getEpicenterCallback());
    L17:
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int r5 = this.mTransitions.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        this.mTransitions.get(r10).cancel();
        r10 = r10 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        if (isValidTarget(r5.view) == false) goto L10;
        Iterator<Transition> r10 = this.mTransitions.iterator();
    L6:
        if (r10.hasNext() == false) goto L16;
        Transition r11 = r10.next();
        if (r11.isValidTarget(r5.view) == false) goto L6;
        r11.captureEndValues(r5);
        r5.mTargetedTransitions.add(r11);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(TransitionValues r5) {
        super.capturePropagationValues(r5);
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mTransitions.get(r11).capturePropagationValues(r5);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        if (isValidTarget(r5.view) == false) goto L10;
        Iterator<Transition> r10 = this.mTransitions.iterator();
    L6:
        if (r10.hasNext() == false) goto L16;
        Transition r11 = r10.next();
        if (r11.isValidTarget(r5.view) == false) goto L6;
        r11.captureStartValues(r5);
        r5.mTargetedTransitions.add(r11);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo82clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.transition.Transition
    public void createAnimators(@NonNull ViewGroup r13, @NonNull TransitionValuesMaps r14, @NonNull TransitionValuesMaps r15, @NonNull ArrayList<TransitionValues> r16, @NonNull ArrayList<TransitionValues> r17) {
        long r5 = getStartDelay();
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        Transition r12 = this.mTransitions.get(r11);
        if (r5 <= 0) goto L13;
        if (this.mPlayTogether == true) goto L9;
        if (r11 != 0) goto L13;
    L9:
        long r18 = r12.getStartDelay();
        if (r18 <= 0) goto L12;
        r12.setStartDelay(r18 + r5);
        goto L13
    L12:
        r12.setStartDelay(r5);
    L13:
        r12.createAnimators(r13, r14, r15, r16, r17);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View r5, boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).excludeTarget(r5, r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return super.excludeTarget(r5, r10);
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup r5) {
        super.forceToEnd(r5);
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mTransitions.get(r11).forceToEnd(r5);
        r11 = r11 + 1;
        goto L3
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int r5) {
        if (r5 >= 0) goto L4;
        return null;
    L4:
        if (r5 < this.mTransitions.size()) goto L7;
        return null;
    L7:
        return this.mTransitions.get(r5);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    public boolean hasAnimators() {
        int r5 = 0;
    L4:
        if (r5 >= this.mTransitions.size()) goto L10;
        if (this.mTransitions.get(r5).hasAnimators() == true) goto L7;
        r5 = r5 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        int r5 = this.mTransitions.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        if (this.mTransitions.get(r10).isSeekingSupported() == false) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(@Nullable View r5) {
        super.pause(r5);
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mTransitions.get(r11).pause(r5);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @RequiresApi(34)
    public void prepareAnimatorsForSeeking() {
        this.mTotalDuration = 0;
        TransitionListenerAdapter r5 = new AnonymousClass2(this);
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L10;
        Transition r11 = this.mTransitions.get(r10);
        r11.addListener(r5);
        r11.prepareAnimatorsForSeeking();
        long r12 = r11.getTotalDurationMillis();
        if (this.mPlayTogether == false) goto L8;
        this.mTotalDuration = Math.max(this.mTotalDuration, r12);
    L9:
        r10 = r10 + 1;
        goto L4
    L8:
        long r13 = this.mTotalDuration;
        r11.mSeekOffsetInParent = r13;
        this.mTotalDuration = r13 + r12;
        goto L9
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeListener(@NonNull Transition.TransitionListener r5) {
        return removeListener(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@IdRes int r5) {
        return removeTarget(r5);
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition r5) {
        this.mTransitions.remove(r5);
        r5.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(@Nullable View r5) {
        super.resume(r5);
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mTransitions.get(r11).resume(r5);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        if (this.mTransitions.isEmpty() == false) goto L6;
        start();
        end();
        return;
    L6:
        setupStartEndListeners();
        if (this.mPlayTogether == true) goto L15;
        int r5 = 1;
    L10:
        if (r5 >= this.mTransitions.size()) goto L12;
        Transition r10 = this.mTransitions.get(r5 - 1);
        final Transition r11 = this.mTransitions.get(r5);
        r10.addListener(new AnonymousClass1(this, r11));
        r5 = r5 + 1;
        goto L10
    L12:
        Transition r12 = this.mTransitions.get(0);
        if (r12 == null) goto L19;
        r12.runAnimators();
        return;
    L19:
        return;
    L15:
        Iterator<Transition> r13 = this.mTransitions.iterator();
    L17:
        if (r13.hasNext() == false) goto L23;
        r13.next().runAnimators();
        goto L17
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean r5) {
        super.setCanRemoveViews(r5);
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mTransitions.get(r11).setCanRemoveViews(r5);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @RequiresApi(34)
    public void setCurrentPlayTimeMillis(long r19, long r21) {
        long r5 = getTotalDurationMillis();
        if (this.mParent != null) goto L5;
    L13:
        int r10 = 0;
        if (r19 >= r21) goto L16;
        boolean r12 = true;
    L18:
        if (r19 < 0) goto L22;
        if (r21 >= 0) goto L22;
    L25:
        this.mEnded = false;
        notifyListeners(Transition.TransitionNotification.ON_START, r12);
    L27:
        if (this.mPlayTogether == true) goto L29;
        int r11 = indexOfTransition(r21);
        if (r19 >= r21) goto L35;
        boolean r16 = r12;
    L41:
        if (r11 < 0) goto L47;
        Transition r13 = this.mTransitions.get(r11);
        long r14 = r13.mSeekOffsetInParent;
        long r15 = r19 - r14;
        r13.setCurrentPlayTimeMillis(r15, r21 - r14);
        if (r15 >= 0) goto L47;
        r11 = r11 - 1;
    L47:
        if (this.mParent != null) goto L49;
        return;
    L49:
        if (r19 > r5) goto L51;
    L52:
        if (r19 < 0) goto L54;
        return;
    L54:
        if (r21 < 0) goto L67;
    L55:
        if (r19 <= r5) goto L57;
        this.mEnded = true;
    L57:
        notifyListeners(Transition.TransitionNotification.ON_END, r16);
        return;
    L67:
        return;
    L51:
        if (r21 <= r5) goto L55;
    L35:
        if (r11 >= this.mTransitions.size()) goto L31;
        Transition r17 = this.mTransitions.get(r11);
        long r18 = r17.mSeekOffsetInParent;
        r16 = r12;
        long r110 = r19 - r18;
        if (r110 < 0) goto L47;
        r17.setCurrentPlayTimeMillis(r110, r21 - r18);
        r11 = r11 + 1;
        r12 = r16;
    L31:
        r16 = r12;
    L29:
        if (r10 >= this.mTransitions.size()) goto L31;
        this.mTransitions.get(r10).setCurrentPlayTimeMillis(r19, r21);
        r10 = r10 + 1;
    L22:
        if (r19 > r5) goto L27;
        if (r21 <= r5) goto L27;
    L16:
        r12 = false;
        goto L18
    L5:
        if (r19 >= 0) goto L9;
        if (r21 >= 0) goto L9;
        return;
    L9:
        if (r19 <= r5) goto L13;
        if (r21 <= r5) goto L13;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition setDuration(long r5) {
        return setDuration(r5);
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(@Nullable Transition.EpicenterCallback r5) {
        super.setEpicenterCallback(r5);
        this.mChangeFlags |= 8;
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mTransitions.get(r11).setEpicenterCallback(r5);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition setInterpolator(@Nullable TimeInterpolator r5) {
        return setInterpolator(r5);
    }

    @NonNull
    public TransitionSet setOrdering(int r5) {
        if (r5 == 0) goto L8;
        if (r5 != 1) goto L7;
        this.mPlayTogether = false;
    L9:
        return this;
    L7:
        throw new AndroidRuntimeException(j0.g(r5, "Invalid parameter for TransitionSet ordering: "));
    L8:
        this.mPlayTogether = true;
        goto L9
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(@Nullable PathMotion r5) {
        super.setPathMotion(r5);
        this.mChangeFlags |= 4;
        if (this.mTransitions == null) goto L8;
        int r10 = 0;
    L6:
        if (r10 >= this.mTransitions.size()) goto L10;
        this.mTransitions.get(r10).setPathMotion(r5);
        r10 = r10 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.transition.Transition
    public void setPropagation(@Nullable TransitionPropagation r5) {
        super.setPropagation(r5);
        this.mChangeFlags |= 2;
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mTransitions.get(r11).setPropagation(r5);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition setStartDelay(long r5) {
        return setStartDelay(r5);
    }

    @Override // androidx.transition.Transition
    public String toString(String r10) {
        String r5 = super.toString(r10);
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L6;
        StringBuilder r12 = j0.w(r5, "\n");
        r12.append(this.mTransitions.get(r11).toString(r10 + "  "));
        r5 = r12.toString();
        r11 = r11 + 1;
        goto L4
    L6:
        return r5;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener r5) {
        return (TransitionSet) super.addListener(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull View r5) {
        return addTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition clone() {
        TransitionSet r5 = (TransitionSet) super.clone();
        r5.mTransitions = new ArrayList();
        int r10 = this.mTransitions.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5.addTransitionInternal(this.mTransitions.get(r11).clone());
        r11 = r11 + 1;
        goto L3
    L5:
        return r5;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener r5) {
        return (TransitionSet) super.removeListener(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull View r5) {
        return removeTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setDuration(long r5) {
        super.setDuration(r5);
        if (this.mDuration < 0) goto L9;
        ArrayList<Transition> r10 = this.mTransitions;
        if (r10 == null) goto L9;
        int r11 = r10.size();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        this.mTransitions.get(r12).setDuration(r5);
        r12 = r12 + 1;
    L9:
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator r5) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> r10 = this.mTransitions;
        if (r10 == null) goto L8;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L8;
        this.mTransitions.get(r12).setInterpolator(r5);
        r12 = r12 + 1;
    L8:
        return (TransitionSet) super.setInterpolator(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long r5) {
        return (TransitionSet) super.setStartDelay(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull Class r5) {
        return addTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull Class r5) {
        return removeTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull String r5) {
        return addTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String r5, boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).excludeTarget(r5, r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return super.excludeTarget(r5, r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull String r5) {
        return removeTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r10).addTarget(r5);
        r10 = r10 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r10).removeTarget(r5);
        r10 = r10 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r5);
    }

    public TransitionSet(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray r11 = r5.obtainStyledAttributes(r10, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(r11, (XmlResourceParser) r10, "transitionOrdering", 0, 0));
        r11.recycle();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int r5, boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).excludeTarget(r5, r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return super.excludeTarget(r5, r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r10).addTarget(r5);
        r10 = r10 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r10).removeTarget(r5);
        r10 = r10 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> r5, boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r11).excludeTarget(r5, r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return super.excludeTarget(r5, r10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r10).addTarget(r5);
        r10 = r10 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r10).removeTarget(r5);
        r10 = r10 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r10).addTarget(r5);
        r10 = r10 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTransitions.size()) goto L7;
        this.mTransitions.get(r10).removeTarget(r5);
        r10 = r10 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r5);
    }
}
