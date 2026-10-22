package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        TransitionSetListener(TransitionSet r1) {
            this.mTransitionSet = r1;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r3) {
            this.mTransitionSet.mCurrentListeners--;
            if (this.mTransitionSet.mCurrentListeners != 0) goto L5;
            this.mTransitionSet.mStarted = false;
            this.mTransitionSet.end();
        L5:
            r3.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r1) {
            if (this.mTransitionSet.mStarted == true) goto L6;
            this.mTransitionSet.start();
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

    public TransitionSet(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7);
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray r8 = r6.obtainStyledAttributes(r7, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(r8, (XmlResourceParser) ZeusTransformUtils.preCheckCast(r7, XmlResourceParser.class, "com.obric.memorydata.plugin"), "transitionOrdering", 0, 0));
        r8.recycle();
    }

    private void addTransitionInternal(Transition r2) {
        this.mTransitions.add(r2);
        r2.mParent = this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener r0 = new TransitionSetListener(this);
        Iterator<Transition> r1 = this.mTransitions.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((Transition) ZeusTransformUtils.preCheckCast(r1.next(), Transition.class, "com.obric.memorydata.plugin")).addListener(r0);
        goto L4
    L6:
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition addListener(Transition.TransitionListener r3) {
        return addListener((Transition.TransitionListener) ZeusTransformUtils.wrapperContextForParams(r3, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.transition.Transition
    public TransitionSet addListener(Transition.TransitionListener r3) {
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.addListener((Transition.TransitionListener) ZeusTransformUtils.wrapperContextForParams(r3, Transition.TransitionListener.class, "com.obric.memorydata.plugin")), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(int r1) {
        return addTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(View r1) {
        return addTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(Class r1) {
        return addTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(String r1) {
        return addTarget(r1);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).addTarget(r5);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.addTarget(r5), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(View r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).addTarget(r5);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.addTarget(r5), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(Class<?> r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).addTarget(r5);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.addTarget(r5), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(String r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).addTarget(r5);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.addTarget(r5), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    public TransitionSet addTransition(Transition r5) {
        addTransitionInternal(r5);
        if (this.mDuration < 0) goto L6;
        r5.setDuration(this.mDuration);
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
    public void cancel() {
        super.cancel();
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).cancel();
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r4) {
        if (isValidTarget(r4.view) == false) goto L10;
        Iterator<Transition> r3 = this.mTransitions.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        Transition r0 = (Transition) ZeusTransformUtils.preCheckCast(r3.next(), Transition.class, "com.obric.memorydata.plugin");
        if (r0.isValidTarget(r4.view) == false) goto L6;
        r0.captureEndValues(r4);
        r4.mTargetedTransitions.add(r0);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    void capturePropagationValues(TransitionValues r6) {
        super.capturePropagationValues(r6);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).capturePropagationValues(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r4) {
        if (isValidTarget(r4.view) == false) goto L10;
        Iterator<Transition> r3 = this.mTransitions.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        Transition r0 = (Transition) ZeusTransformUtils.preCheckCast(r3.next(), Transition.class, "com.obric.memorydata.plugin");
        if (r0.isValidTarget(r4.view) == false) goto L6;
        r0.captureStartValues(r4);
        r4.mTargetedTransitions.add(r0);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    public Transition clone() {
        TransitionSet r0 = (TransitionSet) ZeusTransformUtils.preCheckCast(super.clone(), TransitionSet.class, "com.obric.memorydata.plugin");
        r0.mTransitions = new ArrayList();
        int r1 = this.mTransitions.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.addTransitionInternal(((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r3), Transition.class, "com.obric.memorydata.plugin")).clone());
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo66clone() {
        return clone();
    }

    @Override // androidx.transition.Transition
    public void createAnimators(ViewGroup r13, TransitionValuesMaps r14, TransitionValuesMaps r15, ArrayList<TransitionValues> r16, ArrayList<TransitionValues> r17) {
        long r1 = getStartDelay();
        int r3 = this.mTransitions.size();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L14;
        Transition r6 = (Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r4), Transition.class, "com.obric.memorydata.plugin");
        if (r1 <= 0) goto L13;
        if (this.mPlayTogether == true) goto L9;
        if (r4 != 0) goto L13;
    L9:
        long r9 = r6.getStartDelay();
        if (r9 <= 0) goto L12;
        r6.setStartDelay(r9 + r1);
        goto L13
    L12:
        r6.setStartDelay(r1);
    L13:
        r6.createAnimators(r13, r14, r15, r16, r17);
        r4 = r4 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int r5, boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).excludeTarget(r5, r6);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.excludeTarget(r5, r6);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View r5, boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).excludeTarget(r5, r6);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.excludeTarget(r5, r6);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class<?> r5, boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).excludeTarget(r5, r6);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.excludeTarget(r5, r6);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String r5, boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).excludeTarget(r5, r6);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.excludeTarget(r5, r6);
    }

    @Override // androidx.transition.Transition
    void forceToEnd(ViewGroup r6) {
        super.forceToEnd(r6);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).forceToEnd(r6);
        r1 = r1 + 1;
        goto L3
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    public Transition getTransitionAt(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.mTransitions.size()) goto L7;
        return null;
    L7:
        return (Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r2), Transition.class, "com.obric.memorydata.plugin");
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    public void pause(View r6) {
        super.pause(r6);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).pause(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition removeListener(Transition.TransitionListener r3) {
        return removeListener((Transition.TransitionListener) ZeusTransformUtils.wrapperContextForParams(r3, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeListener(Transition.TransitionListener r3) {
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.removeListener((Transition.TransitionListener) ZeusTransformUtils.wrapperContextForParams(r3, Transition.TransitionListener.class, "com.obric.memorydata.plugin")), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(int r1) {
        return removeTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(View r1) {
        return removeTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(Class r1) {
        return removeTarget(r1);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(String r1) {
        return removeTarget(r1);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).removeTarget(r5);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.removeTarget(r5), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(View r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).removeTarget(r5);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.removeTarget(r5), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(Class<?> r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).removeTarget(r5);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.removeTarget(r5), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(String r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTransitions.size()) goto L7;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).removeTarget(r5);
        r0 = r0 + 1;
        goto L4
    L7:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.removeTarget(r5), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    public TransitionSet removeTransition(Transition r2) {
        this.mTransitions.remove(r2);
        r2.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    public void resume(View r6) {
        super.resume(r6);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).resume(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void runAnimators() {
        if (this.mTransitions.isEmpty() == false) goto L6;
        start();
        end();
        return;
    L6:
        setupStartEndListeners();
        if (this.mPlayTogether == true) goto L15;
        int r0 = 1;
    L10:
        if (r0 >= this.mTransitions.size()) goto L12;
        Transition r2 = (Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0 - 1), Transition.class, "com.obric.memorydata.plugin");
        final Transition r3 = (Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin");
        r2.addListener(new AnonymousClass1(this, r3));
        r0 = r0 + 1;
        goto L10
    L12:
        Transition r5 = (Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(0), Transition.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L19;
        r5.runAnimators();
        return;
    L19:
        return;
    L15:
        Iterator<Transition> r6 = this.mTransitions.iterator();
    L17:
        if (r6.hasNext() == false) goto L23;
        ((Transition) ZeusTransformUtils.preCheckCast(r6.next(), Transition.class, "com.obric.memorydata.plugin")).runAnimators();
        goto L17
    }

    @Override // androidx.transition.Transition
    void setCanRemoveViews(boolean r6) {
        super.setCanRemoveViews(r6);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).setCanRemoveViews(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setDuration(long r1) {
        return setDuration(r1);
    }

    @Override // androidx.transition.Transition
    public TransitionSet setDuration(long r6) {
        super.setDuration(r6);
        if (this.mDuration < 0) goto L9;
        ArrayList<Transition> r0 = this.mTransitions;
        if (r0 == null) goto L9;
        int r1 = r0.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r2), Transition.class, "com.obric.memorydata.plugin")).setDuration(r6);
        r2 = r2 + 1;
    L9:
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback r6) {
        super.setEpicenterCallback(r6);
        this.mChangeFlags |= 8;
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).setEpicenterCallback(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public /* synthetic */ Transition setInterpolator(TimeInterpolator r3) {
        return setInterpolator((TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, TimeInterpolator.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.transition.Transition
    public TransitionSet setInterpolator(TimeInterpolator r6) {
        TimeInterpolator r7 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r6, TimeInterpolator.class, "com.obric.memorydata.plugin");
        this.mChangeFlags |= 1;
        ArrayList<Transition> r0 = this.mTransitions;
        if (r0 == null) goto L8;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L8;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r2), Transition.class, "com.obric.memorydata.plugin")).setInterpolator(r7);
        r2 = r2 + 1;
    L8:
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.setInterpolator(r7), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    public TransitionSet setOrdering(int r3) {
        if (r3 == 0) goto L8;
        if (r3 != 1) goto L7;
        this.mPlayTogether = false;
    L9:
        return this;
    L7:
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + r3);
    L8:
        this.mPlayTogether = true;
        goto L9
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion r5) {
        super.setPathMotion(r5);
        this.mChangeFlags |= 4;
        if (this.mTransitions == null) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= this.mTransitions.size()) goto L10;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r0), Transition.class, "com.obric.memorydata.plugin")).setPathMotion(r5);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation r6) {
        super.setPropagation(r6);
        this.mChangeFlags |= 2;
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).setPropagation(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    /* bridge */ /* synthetic */ Transition setSceneRoot(ViewGroup r1) {
        return setSceneRoot(r1);
    }

    @Override // androidx.transition.Transition
    TransitionSet setSceneRoot(ViewGroup r6) {
        super.setSceneRoot(r6);
        int r0 = this.mTransitions.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).setSceneRoot(r6);
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setStartDelay(long r1) {
        return setStartDelay(r1);
    }

    @Override // androidx.transition.Transition
    public TransitionSet setStartDelay(long r1) {
        return (TransitionSet) ZeusTransformUtils.preCheckCast(super.setStartDelay(r1), TransitionSet.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.Transition
    String toString(String r6) {
        String r0 = super.toString(r6);
        int r1 = 0;
    L4:
        if (r1 >= this.mTransitions.size()) goto L6;
        r0 = r0 + "\n" + ((Transition) ZeusTransformUtils.preCheckCast(this.mTransitions.get(r1), Transition.class, "com.obric.memorydata.plugin")).toString(r6 + "  ");
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
