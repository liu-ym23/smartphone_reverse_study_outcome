package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Carousel extends MotionHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "Carousel";
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private int backwardTransition;
    private float dampening;
    private int emptyViewBehavior;
    private int firstViewReference;
    private int forwardTransition;
    private boolean infiniteCarousel;
    private Adapter mAdapter;
    private int mAnimateTargetDelay;
    private int mIndex;
    int mLastStartId;
    private final ArrayList<View> mList;
    private MotionLayout mMotionLayout;
    private int mPreviousIndex;
    private int mTargetIndex;
    Runnable mUpdateRunnable;
    private int nextState;
    private int previousState;
    private int startIndex;
    private int touchUpMode;
    private float velocityThreshold;

    public interface Adapter {
        int count();

        void onNewItem(int r10);

        void populate(View r10, int r11);
    }

    public Carousel(Context r10) {
        super(r10);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.firstViewReference = -1;
        this.infiniteCarousel = false;
        this.backwardTransition = -1;
        this.forwardTransition = -1;
        this.previousState = -1;
        this.nextState = -1;
        this.dampening = 0.9f;
        this.startIndex = 0;
        this.emptyViewBehavior = 4;
        this.touchUpMode = 1;
        this.velocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
    }

    public Carousel(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.firstViewReference = -1;
        this.infiniteCarousel = false;
        this.backwardTransition = -1;
        this.forwardTransition = -1;
        this.previousState = -1;
        this.nextState = -1;
        this.dampening = 0.9f;
        this.startIndex = 0;
        this.emptyViewBehavior = 4;
        this.touchUpMode = 1;
        this.velocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
        init(r10, r11);
    }

    public Carousel(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.firstViewReference = -1;
        this.infiniteCarousel = false;
        this.backwardTransition = -1;
        this.forwardTransition = -1;
        this.previousState = -1;
        this.nextState = -1;
        this.dampening = 0.9f;
        this.startIndex = 0;
        this.emptyViewBehavior = 4;
        this.touchUpMode = 1;
        this.velocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
        init(r10, r11);
    }

    public static /* synthetic */ void a(Carousel r10) {
        r10.lambda$updateItems$0();
    }

    static /* synthetic */ MotionLayout access$000(Carousel r10) {
        return r10.mMotionLayout;
    }

    static /* synthetic */ void access$100(Carousel r10) {
        r10.updateItems();
    }

    static /* synthetic */ int access$200(Carousel r10) {
        return r10.mIndex;
    }

    static /* synthetic */ Adapter access$300(Carousel r10) {
        return r10.mAdapter;
    }

    static /* synthetic */ int access$400(Carousel r10) {
        return r10.touchUpMode;
    }

    static /* synthetic */ float access$500(Carousel r10) {
        return r10.velocityThreshold;
    }

    static /* synthetic */ float access$600(Carousel r10) {
        return r10.dampening;
    }

    static /* synthetic */ int access$700(Carousel r10) {
        return r10.mPreviousIndex;
    }

    private void enableAllTransitions(boolean r10) {
        Iterator<MotionScene.Transition> r11 = this.mMotionLayout.getDefinedTransitions().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setEnabled(r10);
        goto L4
    }

    private boolean enableTransition(int r10, boolean r11) {
        if (r10 != (-1)) goto L5;
        return false;
    L5:
        MotionLayout r12 = this.mMotionLayout;
        if (r12 != null) goto L8;
        return false;
    L8:
        MotionScene.Transition r13 = r12.getTransition(r10);
        if (r13 != null) goto L12;
        return false;
    L12:
        if (r11 != r13.isEnabled()) goto L14;
        return false;
    L14:
        r13.setEnabled(r11);
        return true;
    }

    private void init(Context r10, AttributeSet r11) {
        if (r11 == null) goto L50;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Carousel);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L36;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.Carousel_carousel_firstView) goto L9;
        this.firstViewReference = r12.getResourceId(r15, this.firstViewReference);
    L35:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R.styleable.Carousel_carousel_backwardTransition) goto L12;
        this.backwardTransition = r12.getResourceId(r15, this.backwardTransition);
        goto L35
    L12:
        if (r15 != R.styleable.Carousel_carousel_forwardTransition) goto L15;
        this.forwardTransition = r12.getResourceId(r15, this.forwardTransition);
        goto L35
    L15:
        if (r15 != R.styleable.Carousel_carousel_emptyViewsBehavior) goto L18;
        this.emptyViewBehavior = r12.getInt(r15, this.emptyViewBehavior);
        goto L35
    L18:
        if (r15 != R.styleable.Carousel_carousel_previousState) goto L21;
        this.previousState = r12.getResourceId(r15, this.previousState);
        goto L35
    L21:
        if (r15 != R.styleable.Carousel_carousel_nextState) goto L24;
        this.nextState = r12.getResourceId(r15, this.nextState);
        goto L35
    L24:
        if (r15 != R.styleable.Carousel_carousel_touchUp_dampeningFactor) goto L27;
        this.dampening = r12.getFloat(r15, this.dampening);
        goto L35
    L27:
        if (r15 != R.styleable.Carousel_carousel_touchUpMode) goto L30;
        this.touchUpMode = r12.getInt(r15, this.touchUpMode);
        goto L35
    L30:
        if (r15 != R.styleable.Carousel_carousel_touchUp_velocityThreshold) goto L33;
        this.velocityThreshold = r12.getFloat(r15, this.velocityThreshold);
        goto L35
    L33:
        if (r15 != R.styleable.Carousel_carousel_infinite) goto L35;
        this.infiniteCarousel = r12.getBoolean(r15, this.infiniteCarousel);
        goto L35
    L36:
        r12.recycle();
        return;
    }

    private /* synthetic */ void lambda$updateItems$0() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (this.mTargetIndex >= this.mIndex) goto L5;
        MotionLayout r10 = this.mMotionLayout;
        int r11 = this.previousState;
    L6:
        r10.transitionToState(r11, this.mAnimateTargetDelay);
        return;
    L5:
        r10 = this.mMotionLayout;
        r11 = this.nextState;
        goto L6
    }

    private void updateItems() {
        Adapter r10 = this.mAdapter;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.mMotionLayout != null) goto L9;
        return;
    L9:
        if (r10.count() != 0) goto L11;
        return;
    L11:
        int r11 = this.mList.size();
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L44;
        View r13 = this.mList.get(r12);
        int r14 = (this.mIndex + r12) - this.startIndex;
        if (this.infiniteCarousel == true) goto L16;
        if (r14 >= 0) goto L39;
    L37:
        updateViewVisibility(r13, this.emptyViewBehavior);
    L43:
        r12 = r12 + 1;
        goto L12
    L39:
        if (r14 >= this.mAdapter.count()) goto L37;
    L41:
        updateViewVisibility(r13, 0);
    L42:
        this.mAdapter.populate(r13, r14);
        goto L43
    L16:
        if (r14 >= 0) goto L26;
        int r15 = this.emptyViewBehavior;
        if (r15 == 4) goto L20;
        updateViewVisibility(r13, r15);
    L22:
        if ((r14 % this.mAdapter.count()) != 0) goto L24;
        this.mAdapter.populate(r13, 0);
        goto L43
    L24:
        Adapter r16 = this.mAdapter;
        r16.populate(r13, r16.count() + (r14 % this.mAdapter.count()));
        goto L43
    L20:
        updateViewVisibility(r13, 0);
        goto L22
    L26:
        if (r14 < this.mAdapter.count()) goto L41;
        if (r14 != this.mAdapter.count()) goto L31;
        r14 = 0;
    L33:
        int r17 = this.emptyViewBehavior;
        if (r17 == 4) goto L41;
        updateViewVisibility(r13, r17);
        goto L42
    L31:
        if (r14 <= this.mAdapter.count()) goto L33;
        r14 = r14 % this.mAdapter.count();
        goto L33
    L44:
        int r18 = this.mTargetIndex;
        if (r18 == (-1)) goto L50;
        if (r18 == this.mIndex) goto L50;
        this.mMotionLayout.post(new a(this));
    L53:
        if (this.backwardTransition != (-1)) goto L55;
    L69:
        Log.w(TAG, "No backward or forward transitions defined for Carousel!");
        return;
    L55:
        if (this.forwardTransition == (-1)) goto L69;
        if (this.infiniteCarousel == false) goto L60;
        return;
    L60:
        int r19 = this.mAdapter.count();
        if (this.mIndex != 0) goto L63;
        enableTransition(this.backwardTransition, false);
    L65:
        if (this.mIndex != (r19 - 1)) goto L67;
        enableTransition(this.forwardTransition, false);
        return;
    L67:
        enableTransition(this.forwardTransition, true);
        this.mMotionLayout.setTransition(this.forwardTransition);
        return;
    L63:
        enableTransition(this.backwardTransition, true);
        this.mMotionLayout.setTransition(this.backwardTransition);
    L50:
        if (r18 != this.mIndex) goto L53;
        this.mTargetIndex = -1;
        goto L53
    }

    private boolean updateViewVisibility(int r10, View r11, int r12) {
        ConstraintSet r13 = this.mMotionLayout.getConstraintSet(r10);
        if (r13 != null) goto L5;
        return false;
    L5:
        ConstraintSet.Constraint r14 = r13.getConstraint(r11.getId());
        if (r14 != null) goto L8;
        return false;
    L8:
        r14.propertySet.mVisibilityMode = 1;
        r11.setVisibility(r12);
        return true;
    }

    private boolean updateViewVisibility(View r10, int r11) {
        MotionLayout r12 = this.mMotionLayout;
        int r13 = 0;
        if (r12 != null) goto L5;
        return false;
    L5:
        int[] r14 = r12.getConstraintSetIds();
        boolean r15 = false;
    L7:
        if (r13 >= r14.length) goto L9;
        r15 = r15 | updateViewVisibility(r14[r13], r10, r11);
        r13 = r13 + 1;
        goto L7
    L9:
        return r15;
    }

    public int getCount() {
        Adapter r10 = this.mAdapter;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.count();
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public void jumpToIndex(int r10) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, r10));
        refresh();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @RequiresApi(api = 17)
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof MotionLayout) == false) goto L24;
        MotionLayout r10 = (MotionLayout) getParent();
        int r11 = 0;
    L6:
        if (r11 >= this.mCount) goto L11;
        int r12 = this.mIds[r11];
        View r13 = r10.getViewById(r12);
        if (this.firstViewReference != r12) goto L10;
        this.startIndex = r11;
    L10:
        this.mList.add(r13);
        r11 = r11 + 1;
        goto L6
    L11:
        this.mMotionLayout = r10;
        if (this.touchUpMode != 2) goto L19;
        MotionScene.Transition r14 = r10.getTransition(this.forwardTransition);
        if (r14 == null) goto L16;
        r14.setOnTouchUp(5);
    L16:
        MotionScene.Transition r15 = this.mMotionLayout.getTransition(this.backwardTransition);
        if (r15 == null) goto L19;
        r15.setOnTouchUp(5);
    L19:
        updateItems();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout r10, int r11, int r12, float r13) {
        this.mLastStartId = r11;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout r10, int r11) {
        int r12 = this.mIndex;
        this.mPreviousIndex = r12;
        if (r11 != this.nextState) goto L7;
        int r13 = r12 + 1;
    L5:
        this.mIndex = r13;
    L10:
        if (this.infiniteCarousel == false) goto L18;
        if (this.mIndex < this.mAdapter.count()) goto L15;
        this.mIndex = 0;
    L15:
        if (this.mIndex >= 0) goto L24;
        this.mIndex = this.mAdapter.count() - 1;
    L24:
        if (this.mPreviousIndex == this.mIndex) goto L27;
        this.mMotionLayout.post(this.mUpdateRunnable);
        return;
    L27:
        return;
    L18:
        if (this.mIndex < this.mAdapter.count()) goto L21;
        this.mIndex = this.mAdapter.count() - 1;
    L21:
        if (this.mIndex >= 0) goto L24;
        this.mIndex = 0;
        goto L24
    L7:
        if (r11 != this.previousState) goto L10;
        r13 = r12 - 1;
        goto L5
    }

    public void refresh() {
        int r10 = this.mList.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        View r12 = this.mList.get(r11);
        if (this.mAdapter.count() != 0) goto L7;
        updateViewVisibility(r12, this.emptyViewBehavior);
    L8:
        r11 = r11 + 1;
        goto L3
    L7:
        updateViewVisibility(r12, 0);
        goto L8
    L9:
        this.mMotionLayout.rebuildScene();
        updateItems();
    }

    public void setAdapter(Adapter r10) {
        this.mAdapter = r10;
    }

    public void transitionToIndex(int r10, int r11) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, r10));
        int r12 = Math.max(0, r11);
        this.mAnimateTargetDelay = r12;
        this.mMotionLayout.setTransitionDuration(r12);
        if (r10 >= this.mIndex) goto L5;
        MotionLayout r13 = this.mMotionLayout;
        int r14 = this.previousState;
    L6:
        r13.transitionToState(r14, this.mAnimateTargetDelay);
        return;
    L5:
        r13 = this.mMotionLayout;
        r14 = this.nextState;
        goto L6
    }
}
