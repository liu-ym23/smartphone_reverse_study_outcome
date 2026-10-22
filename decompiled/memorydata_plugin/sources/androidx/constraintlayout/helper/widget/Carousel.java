package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        void onNewItem(int r1);

        void populate(View r1, int r2);
    }

    public Carousel(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
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

    public Carousel(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7);
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
        init(r6, r7);
    }

    public Carousel(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
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
        init(r6, r7);
    }

    static /* synthetic */ MotionLayout access$000(Carousel r0) {
        return r0.mMotionLayout;
    }

    static /* synthetic */ void access$100(Carousel r0) {
        r0.updateItems();
    }

    static /* synthetic */ int access$200(Carousel r0) {
        return r0.mIndex;
    }

    static /* synthetic */ Adapter access$300(Carousel r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$400(Carousel r0) {
        return r0.touchUpMode;
    }

    static /* synthetic */ float access$500(Carousel r0) {
        return r0.velocityThreshold;
    }

    static /* synthetic */ float access$600(Carousel r0) {
        return r0.dampening;
    }

    static /* synthetic */ int access$700(Carousel r0) {
        return r0.mPreviousIndex;
    }

    private void enableAllTransitions(boolean r4) {
        Iterator<MotionScene.Transition> r3 = this.mMotionLayout.getDefinedTransitions().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((MotionScene.Transition) ZeusTransformUtils.preCheckCast(r3.next(), MotionScene.Transition.class, "com.obric.memorydata.plugin")).setEnabled(r4);
        goto L4
    }

    private boolean enableTransition(int r3, boolean r4) {
        if (r3 != (-1)) goto L5;
        return false;
    L5:
        MotionLayout r2 = this.mMotionLayout;
        if (r2 != null) goto L8;
        return false;
    L8:
        MotionScene.Transition r5 = r2.getTransition(r3);
        if (r5 != null) goto L12;
        return false;
    L12:
        if (r4 != r5.isEnabled()) goto L14;
        return false;
    L14:
        r5.setEnabled(r4);
        return true;
    }

    private void init(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L51;
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.Carousel);
        int r11 = r10.getIndexCount();
        int r0 = 0;
    L5:
        if (r0 >= r11) goto L37;
        int r1 = r10.getIndex(r0);
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_firstView, "styleable", "Carousel_carousel_firstView")) goto L10;
        this.firstViewReference = r10.getResourceId(r1, this.firstViewReference);
    L36:
        r0 = r0 + 1;
        goto L5
    L10:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_backwardTransition, "styleable", "Carousel_carousel_backwardTransition")) goto L13;
        this.backwardTransition = r10.getResourceId(r1, this.backwardTransition);
        goto L36
    L13:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_forwardTransition, "styleable", "Carousel_carousel_forwardTransition")) goto L16;
        this.forwardTransition = r10.getResourceId(r1, this.forwardTransition);
        goto L36
    L16:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_emptyViewsBehavior, "styleable", "Carousel_carousel_emptyViewsBehavior")) goto L19;
        this.emptyViewBehavior = r10.getInt(r1, this.emptyViewBehavior);
        goto L36
    L19:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_previousState, "styleable", "Carousel_carousel_previousState")) goto L22;
        this.previousState = r10.getResourceId(r1, this.previousState);
        goto L36
    L22:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_nextState, "styleable", "Carousel_carousel_nextState")) goto L25;
        this.nextState = r10.getResourceId(r1, this.nextState);
        goto L36
    L25:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUp_dampeningFactor, "styleable", "Carousel_carousel_touchUp_dampeningFactor")) goto L28;
        this.dampening = r10.getFloat(r1, this.dampening);
        goto L36
    L28:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUpMode, "styleable", "Carousel_carousel_touchUpMode")) goto L31;
        this.touchUpMode = r10.getInt(r1, this.touchUpMode);
        goto L36
    L31:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUp_velocityThreshold, "styleable", "Carousel_carousel_touchUp_velocityThreshold")) goto L34;
        this.velocityThreshold = r10.getFloat(r1, this.velocityThreshold);
        goto L36
    L34:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_infinite, "styleable", "Carousel_carousel_infinite")) goto L36;
        this.infiniteCarousel = r10.getBoolean(r1, this.infiniteCarousel);
        goto L36
    L37:
        r10.recycle();
        return;
    }

    private void updateItems() {
        Adapter r0 = this.mAdapter;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mMotionLayout != null) goto L9;
        return;
    L9:
        if (r0.count() != 0) goto L11;
        return;
    L11:
        int r1 = this.mList.size();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L44;
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.mList.get(r2), View.class, "com.obric.memorydata.plugin");
        int r4 = (this.mIndex + r2) - this.startIndex;
        if (this.infiniteCarousel == true) goto L16;
        if (r4 >= 0) goto L39;
    L37:
        updateViewVisibility(r3, this.emptyViewBehavior);
    L43:
        r2 = r2 + 1;
        goto L12
    L39:
        if (r4 >= this.mAdapter.count()) goto L37;
    L41:
        updateViewVisibility(r3, 0);
    L42:
        this.mAdapter.populate(r3, r4);
        goto L43
    L16:
        if (r4 >= 0) goto L26;
        int r6 = this.emptyViewBehavior;
        if (r6 == 4) goto L20;
        updateViewVisibility(r3, r6);
    L22:
        if ((r4 % this.mAdapter.count()) != 0) goto L24;
        this.mAdapter.populate(r3, 0);
        goto L43
    L24:
        Adapter r5 = this.mAdapter;
        r5.populate(r3, r5.count() + (r4 % this.mAdapter.count()));
        goto L43
    L20:
        updateViewVisibility(r3, 0);
        goto L22
    L26:
        if (r4 < this.mAdapter.count()) goto L41;
        if (r4 != this.mAdapter.count()) goto L31;
        r4 = 0;
    L33:
        int r7 = this.emptyViewBehavior;
        if (r7 == 4) goto L41;
        updateViewVisibility(r3, r7);
        goto L42
    L31:
        if (r4 <= this.mAdapter.count()) goto L33;
        r4 = r4 % this.mAdapter.count();
        goto L33
    L44:
        int r8 = this.mTargetIndex;
        if (r8 == (-1)) goto L50;
        if (r8 == this.mIndex) goto L50;
        this.mMotionLayout.post(new $$Lambda$Carousel$NfsCQvYOydIR2JH7qqFadhs0gY(this));
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
        int r9 = this.mAdapter.count();
        if (this.mIndex != 0) goto L63;
        enableTransition(this.backwardTransition, false);
    L65:
        if (this.mIndex != (r9 - 1)) goto L67;
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
        if (r8 != this.mIndex) goto L53;
        this.mTargetIndex = -1;
        goto L53
    }

    private boolean updateViewVisibility(int r2, View r3, int r4) {
        ConstraintSet r1 = this.mMotionLayout.getConstraintSet(r2);
        if (r1 != null) goto L5;
        return false;
    L5:
        ConstraintSet.Constraint r5 = r1.getConstraint(r3.getId());
        if (r5 != null) goto L8;
        return false;
    L8:
        r5.propertySet.mVisibilityMode = 1;
        r3.setVisibility(r4);
        return true;
    }

    private boolean updateViewVisibility(View r5, int r6) {
        MotionLayout r0 = this.mMotionLayout;
        int r1 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        int[] r2 = r0.getConstraintSetIds();
        boolean r3 = false;
    L7:
        if (r1 >= r2.length) goto L9;
        r3 = r3 | updateViewVisibility(r2[r1], r5, r6);
        r1 = r1 + 1;
        goto L7
    L9:
        return r3;
    }

    public int getCount() {
        Adapter r0 = this.mAdapter;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.count();
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public void jumpToIndex(int r2) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, r2));
        refresh();
    }

    public /* synthetic */ void lambda$updateItems$0$Carousel() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (this.mTargetIndex >= this.mIndex) goto L5;
        MotionLayout r0 = this.mMotionLayout;
        int r1 = this.previousState;
    L6:
        r0.transitionToState(r1, this.mAnimateTargetDelay);
        return;
    L5:
        r0 = this.mMotionLayout;
        r1 = this.nextState;
        goto L6
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (ZeusTransformUtils.instanceOf(getParent(), MotionLayout.class) == false) goto L24;
        MotionLayout r0 = (MotionLayout) ZeusTransformUtils.preCheckCast(getParent(), MotionLayout.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L6:
        if (r1 >= this.mCount) goto L11;
        int r2 = this.mIds[r1];
        View r3 = r0.getViewById(r2);
        if (this.firstViewReference != r2) goto L10;
        this.startIndex = r1;
    L10:
        this.mList.add(r3);
        r1 = r1 + 1;
        goto L6
    L11:
        this.mMotionLayout = r0;
        if (this.touchUpMode != 2) goto L19;
        MotionScene.Transition r4 = r0.getTransition(this.forwardTransition);
        if (r4 == null) goto L16;
        r4.setOnTouchUp(5);
    L16:
        MotionScene.Transition r5 = this.mMotionLayout.getTransition(this.backwardTransition);
        if (r5 == null) goto L19;
        r5.setOnTouchUp(5);
    L19:
        updateItems();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout r1, int r2, int r3, float r4) {
        this.mLastStartId = r2;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout r2, int r3) {
        int r4 = this.mIndex;
        this.mPreviousIndex = r4;
        if (r3 != this.nextState) goto L7;
        int r5 = r4 + 1;
    L5:
        this.mIndex = r5;
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
        if (r3 != this.previousState) goto L10;
        r5 = r4 - 1;
        goto L5
    }

    public void refresh() {
        int r0 = this.mList.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.mList.get(r2), View.class, "com.obric.memorydata.plugin");
        if (this.mAdapter.count() != 0) goto L7;
        updateViewVisibility(r3, this.emptyViewBehavior);
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        updateViewVisibility(r3, 0);
        goto L8
    L9:
        this.mMotionLayout.rebuildScene();
        updateItems();
    }

    public void setAdapter(Adapter r3) {
        this.mAdapter = (Adapter) ZeusTransformUtils.wrapperContextForParams(r3, Adapter.class, "com.obric.memorydata.plugin");
    }

    public void transitionToIndex(int r3, int r4) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, r3));
        int r5 = Math.max(0, r4);
        this.mAnimateTargetDelay = r5;
        this.mMotionLayout.setTransitionDuration(r5);
        if (r3 >= this.mIndex) goto L5;
        MotionLayout r6 = this.mMotionLayout;
        int r7 = this.previousState;
    L6:
        r6.transitionToState(r7, this.mAnimateTargetDelay);
        return;
    L5:
        r6 = this.mMotionLayout;
        r7 = this.nextState;
        goto L6
    }
}
