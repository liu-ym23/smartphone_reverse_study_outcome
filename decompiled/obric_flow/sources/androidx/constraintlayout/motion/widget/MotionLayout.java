package androidx.constraintlayout.motion.widget;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.solver.CodeGenScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private DecelerateInterpolator mDecelerateLogic;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    private View mRegionView;
    MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private ArrayList<TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = null;

        static {
            int[] r5 = new int[TransitionState.values().length];
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = r5;
            r5[TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class DecelerateInterpolator extends MotionInterpolator {
        float currentP;
        float initalV;
        float maxA;
        final /* synthetic */ MotionLayout this$0;

        public DecelerateInterpolator(MotionLayout r5) {
            this.this$0 = r5;
            this.initalV = 0.0f;
            this.currentP = 0.0f;
        }

        public void config(float r5, float r10, float r11) {
            this.initalV = r5;
            this.currentP = r10;
            this.maxA = r11;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r5 = this.initalV;
            if (r5 <= 0.0f) goto L9;
            float r11 = this.maxA;
            if ((r5 / r11) >= r10) goto L7;
            r10 = r5 / r11;
        L7:
            float r12 = r5 - (r11 * r10);
            this.this$0.mLastVelocity = r12;
            return ((r5 * r10) - (((r11 * r10) * r10) / 2.0f)) + this.currentP;
        L9:
            float r13 = this.maxA;
            if (((-r5) / r13) >= r10) goto L12;
            r10 = (-r5) / r13;
        L12:
            float r14 = (r13 * r10) + r5;
            this.this$0.mLastVelocity = r14;
            float r15 = ((r13 * r10) * r10) / 2.0f;
            return (r15 + (r5 * r10)) + this.currentP;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return this.this$0.mLastVelocity;
        }
    }

    public class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        final int DIAMOND_SIZE;
        final int GRAPH_COLOR;
        final int KEYFRAME_COLOR;
        final int RED_COLOR;
        final int SHADOW_COLOR;
        Rect mBounds;
        DashPathEffect mDashPathEffect;
        Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        boolean mPresentationMode;
        private float[] mRectangle;
        int mShadowTranslate;
        Paint mTextPaint;
        final /* synthetic */ MotionLayout this$0;

        public DevModeDraw(MotionLayout r10) {
            this.this$0 = r10;
            this.RED_COLOR = -21965;
            this.KEYFRAME_COLOR = -2067046;
            this.GRAPH_COLOR = -13391360;
            this.SHADOW_COLOR = 1996488704;
            this.DIAMOND_SIZE = 10;
            this.mBounds = new Rect();
            this.mPresentationMode = false;
            this.mShadowTranslate = 1;
            Paint r5 = new Paint();
            this.mPaint = r5;
            r5.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            Paint r11 = this.mPaint;
            Paint.Style r12 = Paint.Style.STROKE;
            r11.setStyle(r12);
            Paint r13 = new Paint();
            this.mPaintKeyframes = r13;
            r13.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(r12);
            Paint r14 = new Paint();
            this.mPaintGraph = r14;
            r14.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(r12);
            Paint r15 = new Paint();
            this.mTextPaint = r15;
            r15.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(r10.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint r16 = new Paint();
            this.mFillPaint = r16;
            r16.setAntiAlias(true);
            DashPathEffect r17 = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = r17;
            this.mPaintGraph.setPathEffect(r17);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode == false) goto L6;
            this.mPaint.setStrokeWidth(8.0f);
            this.mFillPaint.setStrokeWidth(8.0f);
            this.mPaintKeyframes.setStrokeWidth(8.0f);
            this.mShadowTranslate = 4;
            return;
        }

        private void drawBasicPath(Canvas r5) {
            r5.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas r10) {
            int r5 = 0;
            boolean r11 = false;
            boolean r12 = false;
        L4:
            if (r5 >= this.mKeyFrameCount) goto L12;
            int r13 = this.mPathMode[r5];
            if (r13 != 1) goto L9;
            r11 = true;
        L9:
            if (r13 != 2) goto L11;
            r12 = true;
        L11:
            r5 = r5 + 1;
            goto L4
        L12:
            if (r11 == false) goto L14;
            drawPathRelative(r10);
        L14:
            if (r12 == false) goto L20;
            drawPathCartesian(r10);
            return;
        }

        private void drawPathCartesian(Canvas r19) {
            float[] r5 = this.mPoints;
            float r10 = r5[0];
            float r11 = r5[1];
            float r12 = r5[r5.length - 2];
            float r13 = r5[r5.length - 1];
            r19.drawLine(Math.min(r10, r12), Math.max(r11, r13), Math.max(r10, r12), Math.max(r11, r13), this.mPaintGraph);
            r19.drawLine(Math.min(r10, r12), Math.min(r11, r13), Math.min(r10, r12), Math.max(r11, r13), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas r19, float r20, float r21) {
            float[] r5 = this.mPoints;
            float r10 = r5[0];
            float r11 = r5[1];
            float r12 = r5[r5.length - 2];
            float r13 = r5[r5.length - 1];
            float r14 = Math.min(r10, r12);
            float r15 = Math.max(r11, r13);
            float r16 = r20 - Math.min(r10, r12);
            float r17 = Math.max(r11, r13) - r21;
            String r18 = "" + (((int) (((double) ((r16 * 100.0f) / Math.abs(r12 - r10))) + 0.5d)) / 100.0f);
            getTextBounds(r18, this.mTextPaint);
            r19.drawText(r18, ((r16 / 2.0f) - (this.mBounds.width() / 2)) + r14, r21 - 20.0f, this.mTextPaint);
            r19.drawLine(r20, r21, Math.min(r10, r12), r21, this.mPaintGraph);
            String r22 = "" + (((int) (((double) ((r17 * 100.0f) / Math.abs(r13 - r11))) + 0.5d)) / 100.0f);
            getTextBounds(r22, this.mTextPaint);
            r19.drawText(r22, r20 + 5.0f, r15 - ((r17 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            r19.drawLine(r20, r21, r20, Math.max(r11, r13), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas r10) {
            float[] r5 = this.mPoints;
            r10.drawLine(r5[0], r5[1], r5[r5.length - 2], r5[r5.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas r14, float r15, float r16) {
            float[] r5 = this.mPoints;
            float r10 = r5[0];
            float r11 = r5[1];
            float r12 = r5[r5.length - 2];
            float r13 = r5[r5.length - 1];
            float r17 = (float) Math.hypot(r10 - r12, r11 - r13);
            float r18 = r12 - r10;
            float r19 = r13 - r11;
            float r20 = (((r16 - r11) * r19) + ((r15 - r10) * r18)) / (r17 * r17);
            float r21 = r10 + (r18 * r20);
            float r22 = r11 + (r20 * r19);
            Path r23 = new Path();
            r23.moveTo(r15, r16);
            r23.lineTo(r21, r22);
            float r24 = (float) Math.hypot(r21 - r15, r22 - r16);
            String r25 = "" + (((int) ((r24 * 100.0f) / r17)) / 100.0f);
            getTextBounds(r25, this.mTextPaint);
            r14.drawTextOnPath(r25, r23, (r24 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            r14.drawLine(r15, r16, r21, r22, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas r16, float r17, float r18, int r19, int r20) {
            String r5 = "" + (((int) (((double) (((r17 - (r19 / 2)) * 100.0f) / (this.this$0.getWidth() - r19))) + 0.5d)) / 100.0f);
            getTextBounds(r5, this.mTextPaint);
            r16.drawText(r5, ((r17 / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, r18 - 20.0f, this.mTextPaint);
            r16.drawLine(r17, r18, Math.min(0.0f, 1.0f), r18, this.mPaintGraph);
            String r10 = "" + (((int) (((double) (((r18 - (r20 / 2)) * 100.0f) / (this.this$0.getHeight() - r20))) + 0.5d)) / 100.0f);
            getTextBounds(r10, this.mTextPaint);
            r16.drawText(r10, r17 + 5.0f, 0.0f - ((r18 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            r16.drawLine(r17, r18, r17, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas r10, MotionController r11) {
            this.mPath.reset();
            int r5 = 0;
        L4:
            if (r5 > 50) goto L6;
            r11.buildRect(r5 / 50, this.mRectangle, 0);
            Path r12 = this.mPath;
            float[] r13 = this.mRectangle;
            r12.moveTo(r13[0], r13[1]);
            Path r14 = this.mPath;
            float[] r15 = this.mRectangle;
            r14.lineTo(r15[2], r15[3]);
            Path r16 = this.mPath;
            float[] r17 = this.mRectangle;
            r16.lineTo(r17[4], r17[5]);
            Path r18 = this.mPath;
            float[] r19 = this.mRectangle;
            r18.lineTo(r19[6], r19[7]);
            this.mPath.close();
            r5 = r5 + 1;
            goto L4
        L6:
            this.mPaint.setColor(1140850688);
            r10.translate(2.0f, 2.0f);
            r10.drawPath(this.mPath, this.mPaint);
            r10.translate(-2.0f, -2.0f);
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            r10.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas r20, int r21, int r22, MotionController r23) {
            View r5 = r23.mView;
            if (r5 == null) goto L5;
            int r11 = r5.getWidth();
            int r12 = r23.mView.getHeight();
        L6:
            int r14 = 1;
        L8:
            if (r14 >= (r22 - 1)) goto L35;
            if (r21 == 4) goto L12;
        L14:
            float[] r10 = this.mKeyFramePoints;
            int r13 = r14 * 2;
            float r15 = r10[r13];
            float r16 = r10[r13 + 1];
            this.mPath.reset();
            this.mPath.moveTo(r15, r16 + 10.0f);
            this.mPath.lineTo(r15 + 10.0f, r16);
            this.mPath.lineTo(r15, r16 - 10.0f);
            this.mPath.lineTo(r15 - 10.0f, r16);
            this.mPath.close();
            int r17 = r14 - 1;
            r23.getKeyFrame(r17);
            int r18 = 3;
            if (r21 != 4) goto L25;
            int r19 = this.mPathMode[r17];
            if (r19 != 1) goto L20;
            drawPathRelativeTicks(r20, r15 - 0.0f, r16 - 0.0f);
        L24:
            r20.drawPath(this.mPath, this.mFillPaint);
        L26:
            if (r21 != 2) goto L28;
            drawPathRelativeTicks(r20, r15 - 0.0f, r16 - 0.0f);
        L28:
            if (r21 != r18) goto L31;
            drawPathCartesianTicks(r20, r15 - 0.0f, r16 - 0.0f);
        L31:
            if (r21 != 6) goto L33;
            drawPathScreenTicks(r20, r15 - 0.0f, r16 - 0.0f, r11, r12);
        L33:
            r20.drawPath(this.mPath, this.mFillPaint);
        L34:
            r14 = r14 + 1;
            goto L8
        L20:
            if (r19 != 2) goto L22;
            drawPathCartesianTicks(r20, r15 - 0.0f, r16 - 0.0f);
            goto L24
        L22:
            if (r19 != 3) goto L24;
            drawPathScreenTicks(r20, r15 - 0.0f, r16 - 0.0f, r11, r12);
            goto L24
        L25:
            r18 = 3;
            r16 = r16;
            r15 = r15;
            goto L26
        L12:
            if (this.mPathMode[r14 - 1] != 0) goto L14;
        L35:
            float[] r24 = this.mPoints;
            if (r24.length <= 1) goto L42;
            r20.drawCircle(r24[0], r24[1], 8.0f, this.mPaintKeyframes);
            float[] r25 = this.mPoints;
            r20.drawCircle(r25[r25.length - 2], r25[r25.length - 1], 8.0f, this.mPaintKeyframes);
            return;
        L42:
            return;
        L5:
            r11 = 0;
            r12 = 0;
            goto L6
        }

        private void drawTranslation(Canvas r10, float r11, float r12, float r13, float r14) {
            r10.drawRect(r11, r12, r13, r14, this.mPaintGraph);
            r10.drawLine(r11, r12, r13, r14, this.mPaintGraph);
        }

        public void draw(Canvas r10, HashMap<View, MotionController> r11, int r12, int r13) {
            if (r11 != null) goto L4;
            return;
        L4:
            if (r11.size() == 0) goto L42;
            r10.save();
            if (this.this$0.isInEditMode() == false) goto L9;
        L11:
            Iterator<MotionController> r14 = r11.values().iterator();
        L13:
            if (r14.hasNext() == false) goto L30;
            MotionController r5 = r14.next();
            int r15 = r5.getDrawPath();
            if (r13 <= 0) goto L18;
            if (r15 != 0) goto L18;
            r15 = 1;
        L18:
            if (r15 == 0) goto L13;
            this.mKeyFrameCount = r5.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
            if (r15 < 1) goto L13;
            int r16 = r12 / 16;
            float[] r17 = this.mPoints;
            if (r17 != null) goto L25;
        L26:
            this.mPoints = new float[r16 * 2];
            this.mPath = new Path();
        L27:
            int r18 = this.mShadowTranslate;
            r10.translate(r18, r18);
            this.mPaint.setColor(1996488704);
            this.mFillPaint.setColor(1996488704);
            this.mPaintKeyframes.setColor(1996488704);
            this.mPaintGraph.setColor(1996488704);
            r5.buildPath(this.mPoints, r16);
            drawAll(r10, r15, this.mKeyFrameCount, r5);
            this.mPaint.setColor(-21965);
            this.mPaintKeyframes.setColor(-2067046);
            this.mFillPaint.setColor(-2067046);
            this.mPaintGraph.setColor(-13391360);
            int r19 = this.mShadowTranslate;
            r10.translate(-r19, -r19);
            drawAll(r10, r15, this.mKeyFrameCount, r5);
            if (r15 != 5) goto L13;
            drawRectangle(r10, r5);
            goto L13
        L25:
            if (r17.length == (r16 * 2)) goto L27;
        L30:
            r10.restore();
            return;
        L9:
            if ((r13 & 1) != 2) goto L11;
            String r20 = this.this$0.getContext().getResources().getResourceName(MotionLayout.access$000(this.this$0)) + ":" + this.this$0.getProgress();
            r10.drawText(r20, 10.0f, this.this$0.getHeight() - 30, this.mTextPaint);
            r10.drawText(r20, 11.0f, this.this$0.getHeight() - 29, this.mPaint);
            goto L11
        }

        public void drawAll(Canvas r5, int r10, int r11, MotionController r12) {
            if (r10 != 4) goto L6;
            drawPathAsConfigured(r5);
        L6:
            if (r10 != 2) goto L9;
            drawPathRelative(r5);
        L9:
            if (r10 != 3) goto L11;
            drawPathCartesian(r5);
        L11:
            drawBasicPath(r5);
            drawTicks(r5, r10, r11, r12);
        }

        public void getTextBounds(String r5, Paint r10) {
            r10.getTextBounds(r5, 0, r5.length(), this.mBounds);
        }
    }

    public class Model {
        ConstraintSet mEnd;
        int mEndId;
        ConstraintWidgetContainer mLayoutEnd;
        ConstraintWidgetContainer mLayoutStart;
        ConstraintSet mStart;
        int mStartId;
        final /* synthetic */ MotionLayout this$0;

        public Model(MotionLayout r5) {
            this.this$0 = r5;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mStart = null;
            this.mEnd = null;
        }

        private void debugLayout(String r10, ConstraintWidgetContainer r11) {
            View r12 = (View) r11.getCompanionWidget();
            StringBuilder r13 = j0.w(r10, " ");
            r13.append(Debug.getName(r12));
            String r14 = r13.toString();
            Log.v(MotionLayout.TAG, r14 + "  ========= " + r11);
            int r15 = r11.getChildren().size();
            int r5 = 0;
        L3:
            if (r5 >= r15) goto L23;
            String r16 = r14 + "[" + r5 + "] ";
            ConstraintWidget r17 = r11.getChildren().get(r5);
            String r18 = "_";
            if (r17.mTop.mTarget == null) goto L7;
            String r19 = ExifInterface.GPS_DIRECTION_TRUE;
        L8:
            StringBuilder r20 = j0.u(r19);
            if (r17.mBottom.mTarget == null) goto L11;
            String r21 = "B";
        L12:
            r20.append(r21);
            StringBuilder r22 = j0.u(r20.toString());
            if (r17.mLeft.mTarget == null) goto L15;
            String r23 = "L";
        L16:
            r22.append(r23);
            StringBuilder r24 = j0.u(r22.toString());
            if (r17.mRight.mTarget == null) goto L19;
            r18 = "R";
        L19:
            r24.append(r18);
            String r25 = r24.toString();
            View r26 = (View) r17.getCompanionWidget();
            String r27 = Debug.getName(r26);
            if ((r26 instanceof TextView) == false) goto L22;
            StringBuilder r28 = j0.w(r27, "(");
            r28.append(((TextView) r26).getText());
            r28.append(")");
            r27 = r28.toString();
        L22:
            Log.v(MotionLayout.TAG, r16 + "  " + r27 + " " + r17 + " " + r25);
            r5 = r5 + 1;
            goto L3
        L15:
            r23 = "_";
            goto L16
        L11:
            r21 = "_";
            goto L12
        L7:
            r19 = "_";
            goto L8
        L23:
            Log.v(MotionLayout.TAG, r14 + " done. ");
        }

        private void debugLayoutParam(String r5, ConstraintLayout.LayoutParams r10) {
            if (r10.startToStart == (-1)) goto L5;
            String r11 = "SS";
        L6:
            StringBuilder r12 = j0.u(" ".concat(r11));
            String r13 = "|__";
            if (r10.startToEnd == (-1)) goto L9;
            String r14 = "|SE";
        L10:
            r12.append(r14);
            StringBuilder r15 = j0.u(r12.toString());
            if (r10.endToStart == (-1)) goto L13;
            String r16 = "|ES";
        L14:
            r15.append(r16);
            StringBuilder r17 = j0.u(r15.toString());
            if (r10.endToEnd == (-1)) goto L17;
            String r18 = "|EE";
        L18:
            r17.append(r18);
            StringBuilder r19 = j0.u(r17.toString());
            if (r10.leftToLeft == (-1)) goto L21;
            String r20 = "|LL";
        L22:
            r19.append(r20);
            StringBuilder r21 = j0.u(r19.toString());
            if (r10.leftToRight == (-1)) goto L25;
            String r22 = "|LR";
        L26:
            r21.append(r22);
            StringBuilder r23 = j0.u(r21.toString());
            if (r10.rightToLeft == (-1)) goto L29;
            String r24 = "|RL";
        L30:
            r23.append(r24);
            StringBuilder r25 = j0.u(r23.toString());
            if (r10.rightToRight == (-1)) goto L33;
            String r26 = "|RR";
        L34:
            r25.append(r26);
            StringBuilder r27 = j0.u(r25.toString());
            if (r10.topToTop == (-1)) goto L37;
            String r28 = "|TT";
        L38:
            r27.append(r28);
            StringBuilder r29 = j0.u(r27.toString());
            if (r10.topToBottom == (-1)) goto L41;
            String r30 = "|TB";
        L42:
            r29.append(r30);
            StringBuilder r31 = j0.u(r29.toString());
            if (r10.bottomToTop == (-1)) goto L45;
            String r32 = "|BT";
        L46:
            r31.append(r32);
            StringBuilder r33 = j0.u(r31.toString());
            if (r10.bottomToBottom == (-1)) goto L49;
            r13 = "|BB";
        L49:
            r33.append(r13);
            Log.v(MotionLayout.TAG, r5 + r33.toString());
            return;
        L45:
            r32 = "|__";
            goto L46
        L41:
            r30 = "|__";
            goto L42
        L37:
            r28 = "|__";
            goto L38
        L33:
            r26 = "|__";
            goto L34
        L29:
            r24 = "|__";
            goto L30
        L25:
            r22 = "|__";
            goto L26
        L21:
            r20 = "|__";
            goto L22
        L17:
            r18 = "|__";
            goto L18
        L13:
            r16 = "|__";
            goto L14
        L9:
            r14 = "|__";
            goto L10
        L5:
            r11 = CodeGenScope.CLASS_PROPERTY_PREFIX;
            goto L6
        }

        private void debugWidget(String r10, ConstraintWidget r11) {
            StringBuilder r5 = new StringBuilder(" ");
            ConstraintAnchor r12 = r11.mTop.mTarget;
            String r13 = ExifInterface.GPS_DIRECTION_TRUE;
            String r14 = CodeGenScope.CLASS_PROPERTY_PREFIX;
            if (r12 != null) goto L5;
            String r15 = CodeGenScope.CLASS_PROPERTY_PREFIX;
        L10:
            r5.append(r15);
            StringBuilder r16 = j0.u(r5.toString());
            ConstraintAnchor r17 = r11.mBottom.mTarget;
            if (r17 != null) goto L13;
            String r18 = CodeGenScope.CLASS_PROPERTY_PREFIX;
        L18:
            r16.append(r18);
            StringBuilder r19 = j0.u(r16.toString());
            ConstraintAnchor r20 = r11.mLeft.mTarget;
            String r21 = "L";
            if (r20 != null) goto L21;
            String r22 = CodeGenScope.CLASS_PROPERTY_PREFIX;
        L26:
            r19.append(r22);
            StringBuilder r23 = j0.u(r19.toString());
            ConstraintAnchor r24 = r11.mRight.mTarget;
            if (r24 != null) goto L29;
        L33:
            r23.append(r14);
            Log.v(MotionLayout.TAG, r10 + r23.toString() + " ---  " + r11);
            return;
        L29:
            if (r24.mType == ConstraintAnchor.Type.LEFT) goto L32;
            r21 = "R";
        L32:
            r14 = "R".concat(r21);
            goto L33
        L21:
            if (r20.mType != ConstraintAnchor.Type.LEFT) goto L23;
            String r25 = "L";
        L24:
            r22 = "L".concat(r25);
            goto L26
        L23:
            r25 = "R";
            goto L24
        L13:
            if (r17.mType == ConstraintAnchor.Type.TOP) goto L16;
            r13 = "B";
        L16:
            r18 = "B".concat(r13);
            goto L18
        L5:
            if (r12.mType != ConstraintAnchor.Type.TOP) goto L7;
            String r26 = ExifInterface.GPS_DIRECTION_TRUE;
        L8:
            r15 = ExifInterface.GPS_DIRECTION_TRUE.concat(r26);
            goto L10
        L7:
            r26 = "B";
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(ConstraintWidgetContainer r12, ConstraintSet r13) {
            SparseArray<ConstraintWidget> r10 = new SparseArray();
            Constraints.LayoutParams r11 = new Constraints.LayoutParams(-2, -2);
            r10.clear();
            r10.put(0, r12);
            r10.put(this.this$0.getId(), r12);
            Iterator<ConstraintWidget> r5 = r12.getChildren().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ConstraintWidget r14 = r5.next();
            r10.put(((View) r14.getCompanionWidget()).getId(), r14);
            goto L4
        L6:
            Iterator<ConstraintWidget> r15 = r12.getChildren().iterator();
        L8:
            if (r15.hasNext() == false) goto L18;
            ConstraintWidget r16 = r15.next();
            View r17 = (View) r16.getCompanionWidget();
            r13.applyToLayoutParams(r17.getId(), r11);
            r16.setWidth(r13.getWidth(r17.getId()));
            r16.setHeight(r13.getHeight(r17.getId()));
            if ((r17 instanceof ConstraintHelper) == false) goto L14;
            r13.applyToHelper((ConstraintHelper) r17, r16, r11, r10);
            if ((r17 instanceof Barrier) == false) goto L14;
            ((Barrier) r17).validateParams();
        L14:
            r11.resolveLayoutDirection(this.this$0.getLayoutDirection());
            MotionLayout.access$800(this.this$0, false, r17, r16, r11, r10);
            if (r13.getVisibilityMode(r17.getId()) == 1) goto L16;
            r16.setVisibility(r13.getVisibility(r17.getId()));
            goto L8
        L16:
            r16.setVisibility(r17.getVisibility());
            goto L8
        L18:
            Iterator<ConstraintWidget> r18 = r12.getChildren().iterator();
        L20:
            if (r18.hasNext() == false) goto L24;
            ConstraintWidget r19 = r18.next();
            if ((r19 instanceof VirtualLayout) == false) goto L20;
            ConstraintHelper r20 = (ConstraintHelper) r19.getCompanionWidget();
            Helper r110 = (Helper) r19;
            r20.updatePreLayout(r12, r110, r10);
            ((VirtualLayout) r110).captureWidgets();
            goto L20
        }

        public void build() {
            int r5 = this.this$0.getChildCount();
            this.this$0.mFrameArrayList.clear();
            int r10 = 0;
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L5;
            View r12 = this.this$0.getChildAt(r11);
            this.this$0.mFrameArrayList.put(r12, new MotionController(r12));
            r11 = r11 + 1;
        L5:
            if (r10 >= r5) goto L26;
            View r13 = this.this$0.getChildAt(r10);
            MotionController r14 = this.this$0.mFrameArrayList.get(r13);
            if (r14 == null) goto L25;
            if (this.mStart == null) goto L18;
            ConstraintWidget r15 = getWidget(this.mLayoutStart, r13);
            if (r15 == null) goto L15;
            r14.setStartState(r15, this.mStart);
            goto L18
        L15:
            if (this.this$0.mDebugPath == 0) goto L18;
            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(r13) + " (" + r13.getClass().getName() + ")");
        L18:
            if (this.mEnd == null) goto L25;
            ConstraintWidget r16 = getWidget(this.mLayoutEnd, r13);
            if (r16 == null) goto L23;
            r14.setEndState(r16, this.mEnd);
            goto L25
        L23:
            if (this.this$0.mDebugPath == 0) goto L25;
            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(r13) + " (" + r13.getClass().getName() + ")");
        L25:
            r10 = r10 + 1;
            goto L5
        }

        public void copy(ConstraintWidgetContainer r5, ConstraintWidgetContainer r10) {
            ArrayList<ConstraintWidget> r11 = r5.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> r12 = new HashMap();
            r12.put(r5, r10);
            r10.getChildren().clear();
            r10.copy(r5, r12);
            Iterator<ConstraintWidget> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L19;
            ConstraintWidget r14 = r13.next();
            if ((r14 instanceof androidx.constraintlayout.solver.widgets.Barrier) == false) goto L9;
            ConstraintWidget r15 = new androidx.constraintlayout.solver.widgets.Barrier();
        L18:
            r10.add(r15);
            r12.put(r14, r15);
            goto L4
        L9:
            if ((r14 instanceof Guideline) == false) goto L12;
            r15 = new Guideline();
            goto L18
        L12:
            if ((r14 instanceof Flow) == false) goto L15;
            r15 = new Flow();
            goto L18
        L15:
            if ((r14 instanceof Helper) == false) goto L17;
            r15 = new HelperWidget();
            goto L18
        L17:
            r15 = new ConstraintWidget();
            goto L18
        L19:
            Iterator<ConstraintWidget> r16 = r11.iterator();
        L21:
            if (r16.hasNext() == false) goto L23;
            ConstraintWidget r17 = r16.next();
            r12.get(r17).copy(r17, r12);
            goto L21
        }

        public ConstraintWidget getWidget(ConstraintWidgetContainer r5, View r10) {
            if (r5.getCompanionWidget() != r10) goto L5;
            return r5;
        L5:
            ArrayList<ConstraintWidget> r11 = r5.getChildren();
            int r12 = r11.size();
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L11;
            ConstraintWidget r14 = r11.get(r13);
            if (r14.getCompanionWidget() == r10) goto L9;
            r13 = r13 + 1;
            goto L6
        L9:
            return r14;
        L11:
            return null;
        }

        public void initFrom(ConstraintWidgetContainer r5, ConstraintSet r10, ConstraintSet r11) {
            this.mStart = r10;
            this.mEnd = r11;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.access$200(this.this$0).getMeasurer());
            this.mLayoutEnd.setMeasurer(MotionLayout.access$300(this.this$0).getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(MotionLayout.access$400(this.this$0), this.mLayoutStart);
            copy(MotionLayout.access$500(this.this$0), this.mLayoutEnd);
            if (this.this$0.mTransitionLastPosition <= 0.5d) goto L7;
            if (r10 == null) goto L6;
            setupConstraintWidget(this.mLayoutStart, r10);
        L6:
            setupConstraintWidget(this.mLayoutEnd, r11);
        L10:
            this.mLayoutStart.setRtl(MotionLayout.access$600(this.this$0));
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.access$700(this.this$0));
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams r12 = this.this$0.getLayoutParams();
            if (r12 != null) goto L13;
            return;
        L13:
            if (r12.width != (-2)) goto L16;
            ConstraintWidgetContainer r13 = this.mLayoutStart;
            ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r13.setHorizontalDimensionBehaviour(r14);
            this.mLayoutEnd.setHorizontalDimensionBehaviour(r14);
        L16:
            if (r12.height != (-2)) goto L20;
            ConstraintWidgetContainer r15 = this.mLayoutStart;
            ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r15.setVerticalDimensionBehaviour(r16);
            this.mLayoutEnd.setVerticalDimensionBehaviour(r16);
            return;
        L20:
            return;
        L7:
            setupConstraintWidget(this.mLayoutEnd, r11);
            if (r10 == null) goto L10;
            setupConstraintWidget(this.mLayoutStart, r10);
            goto L10
        }

        public boolean isNotConfiguredWith(int r5, int r10) {
            if (r5 == this.mStartId) goto L5;
        L8:
            return true;
        L5:
            if (r10 != this.mEndId) goto L8;
            return false;
        }

        public void measure(int r13, int r14) {
            int r5 = View.MeasureSpec.getMode(r13);
            int r10 = View.MeasureSpec.getMode(r14);
            MotionLayout r11 = this.this$0;
            r11.mWidthMeasureMode = r5;
            r11.mHeightMeasureMode = r10;
            int r12 = r11.getOptimizationLevel();
            MotionLayout r15 = this.this$0;
            if (r15.mCurrentState != r15.getStartState()) goto L8;
            MotionLayout.access$1200(this.this$0, this.mLayoutEnd, r12, r13, r14);
            if (this.mStart == null) goto L11;
            MotionLayout.access$1300(this.this$0, this.mLayoutStart, r12, r13, r14);
        L11:
            boolean r16 = true;
            if ((this.this$0.getParent() instanceof MotionLayout) == true) goto L14;
        L17:
            MotionLayout r17 = this.this$0;
            r17.mWidthMeasureMode = r5;
            r17.mHeightMeasureMode = r10;
            if (r17.mCurrentState != r17.getStartState()) goto L23;
            MotionLayout.access$1600(this.this$0, this.mLayoutEnd, r12, r13, r14);
            if (this.mStart == null) goto L26;
            MotionLayout.access$1700(this.this$0, this.mLayoutStart, r12, r13, r14);
        L26:
            this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
            this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
            this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
            this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
            MotionLayout r18 = this.this$0;
            if (r18.mStartWrapWidth == r18.mEndWrapWidth) goto L29;
        L32:
            boolean r19 = true;
        L33:
            r18.mMeasureDuringTransition = r19;
        L34:
            MotionLayout r20 = this.this$0;
            int r21 = r20.mStartWrapWidth;
            int r22 = r20.mStartWrapHeight;
            int r23 = r20.mWidthMeasureMode;
            if (r23 == Integer.MIN_VALUE) goto L37;
            if (r23 == 0) goto L37;
        L38:
            int r24 = r20.mHeightMeasureMode;
            if (r24 == Integer.MIN_VALUE) goto L41;
            if (r24 == 0) goto L41;
        L43:
            if (this.mLayoutStart.isWidthMeasuredTooSmall() == false) goto L45;
        L48:
            boolean r25 = true;
        L50:
            if (this.mLayoutStart.isHeightMeasuredTooSmall() == false) goto L52;
        L55:
            MotionLayout.access$2000(this.this$0, r13, r14, r21, r22, r25, r16);
            return;
        L52:
            if (this.mLayoutEnd.isHeightMeasuredTooSmall() == true) goto L55;
            r16 = false;
            goto L55
        L45:
            if (this.mLayoutEnd.isWidthMeasuredTooSmall() == true) goto L48;
            r25 = false;
        L41:
            r22 = (int) ((r20.mPostInterpolationPosition * (r20.mEndWrapHeight - r22)) + r22);
        L37:
            r21 = (int) ((r20.mPostInterpolationPosition * (r20.mEndWrapWidth - r21)) + r21);
            goto L38
        L29:
            if (r18.mStartWrapHeight != r18.mEndWrapHeight) goto L32;
            r19 = false;
            goto L33
        L23:
            if (this.mStart == null) goto L25;
            MotionLayout.access$1800(this.this$0, this.mLayoutStart, r12, r13, r14);
        L25:
            MotionLayout.access$1900(this.this$0, this.mLayoutEnd, r12, r13, r14);
            goto L26
        L14:
            if (r5 != 1073741824) goto L17;
            if (r10 != 1073741824) goto L17;
        L8:
            if (this.mStart == null) goto L10;
            MotionLayout.access$1400(this.this$0, this.mLayoutStart, r12, r13, r14);
        L10:
            MotionLayout.access$1500(this.this$0, this.mLayoutEnd, r12, r13, r14);
            goto L11
        }

        public void reEvaluateState() {
            measure(MotionLayout.access$900(this.this$0), MotionLayout.access$1000(this.this$0));
            MotionLayout.access$1100(this.this$0);
        }

        public void setMeasuredId(int r5, int r10) {
            this.mStartId = r5;
            this.mEndId = r10;
        }
    }

    public interface MotionTracker {
        void addMovement(MotionEvent r5);

        void clear();

        void computeCurrentVelocity(int r5);

        void computeCurrentVelocity(int r5, float r10);

        float getXVelocity();

        float getXVelocity(int r5);

        float getYVelocity();

        float getYVelocity(int r5);

        void recycle();
    }

    public static class MyTracker implements MotionTracker {

        /* JADX INFO: renamed from: me, reason: collision with root package name */
        private static MyTracker f434me;
        VelocityTracker tracker;

        static {
            f434me = new MyTracker();
        }

        private MyTracker() {
        }

        public static MyTracker obtain() {
            MyTracker r5 = f434me;
            r5.tracker = VelocityTracker.obtain();
            return f434me;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent r5) {
            VelocityTracker r10 = this.tracker;
            if (r10 == null) goto L6;
            r10.addMovement(r5);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker r5 = this.tracker;
            if (r5 == null) goto L6;
            r5.clear();
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r5) {
            VelocityTracker r10 = this.tracker;
            if (r10 == null) goto L6;
            r10.computeCurrentVelocity(r5);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker r5 = this.tracker;
            if (r5 != null) goto L5;
            return 0.0f;
        L5:
            return r5.getXVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker r5 = this.tracker;
            if (r5 != null) goto L5;
            return 0.0f;
        L5:
            return r5.getYVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker r5 = this.tracker;
            if (r5 == null) goto L6;
            r5.recycle();
            this.tracker = null;
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r5, float r10) {
            VelocityTracker r11 = this.tracker;
            if (r11 == null) goto L6;
            r11.computeCurrentVelocity(r5, r10);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int r5) {
            VelocityTracker r10 = this.tracker;
            if (r10 != null) goto L5;
            return 0.0f;
        L5:
            return r10.getXVelocity(r5);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int r5) {
            if (this.tracker != null) goto L5;
            return 0.0f;
        L5:
            return getYVelocity(r5);
        }
    }

    public class StateCache {
        final String KeyEndState;
        final String KeyProgress;
        final String KeyStartState;
        final String KeyVelocity;
        int endState;
        float mProgress;
        float mVelocity;
        int startState;
        final /* synthetic */ MotionLayout this$0;

        public StateCache(MotionLayout r5) {
            this.this$0 = r5;
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
            this.KeyProgress = "motion.progress";
            this.KeyVelocity = "motion.velocity";
            this.KeyStartState = "motion.StartState";
            this.KeyEndState = "motion.EndState";
        }

        public void apply() {
            int r5 = this.startState;
            if (r5 == (-1)) goto L5;
        L6:
            if (r5 != (-1)) goto L8;
            this.this$0.transitionToState(this.endState);
        L12:
            this.this$0.setState(TransitionState.SETUP);
        L14:
            if (Float.isNaN(this.mVelocity) == true) goto L16;
            this.this$0.setProgress(this.mProgress, this.mVelocity);
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
            return;
        L16:
            if (Float.isNaN(this.mProgress) == false) goto L18;
            return;
        L18:
            this.this$0.setProgress(this.mProgress);
            return;
        L8:
            int r10 = this.endState;
            if (r10 != (-1)) goto L11;
            this.this$0.setState(r5, -1, -1);
            goto L12
        L11:
            this.this$0.setTransition(r5, r10);
            goto L12
        L5:
            if (this.endState == (-1)) goto L14;
            goto L6
        }

        public Bundle getTransitionState() {
            Bundle r5 = new Bundle();
            r5.putFloat("motion.progress", this.mProgress);
            r5.putFloat("motion.velocity", this.mVelocity);
            r5.putInt("motion.StartState", this.startState);
            r5.putInt("motion.EndState", this.endState);
            return r5;
        }

        public void recordState() {
            this.endState = MotionLayout.access$000(this.this$0);
            this.startState = MotionLayout.access$100(this.this$0);
            this.mVelocity = this.this$0.getVelocity();
            this.mProgress = this.this$0.getProgress();
        }

        public void setEndState(int r5) {
            this.endState = r5;
        }

        public void setProgress(float r5) {
            this.mProgress = r5;
        }

        public void setStartState(int r5) {
            this.startState = r5;
        }

        public void setTransitionState(Bundle r5) {
            this.mProgress = r5.getFloat("motion.progress");
            this.mVelocity = r5.getFloat("motion.velocity");
            this.startState = r5.getInt("motion.StartState");
            this.endState = r5.getInt("motion.EndState");
        }

        public void setVelocity(float r5) {
            this.mVelocity = r5;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout r5, int r10, int r11, float r12);

        void onTransitionCompleted(MotionLayout r5, int r10);

        void onTransitionStarted(MotionLayout r5, int r10, int r11);

        void onTransitionTrigger(MotionLayout r5, int r10, boolean r11, float r12);
    }

    public static final enum TransitionState extends Enum<TransitionState> {
        private static final /* synthetic */ TransitionState[] $VALUES = null;
        public static final TransitionState FINISHED = null;
        public static final TransitionState MOVING = null;
        public static final TransitionState SETUP = null;
        public static final TransitionState UNDEFINED = null;

        static {
            TransitionState r5 = new TransitionState("UNDEFINED", 0);
            UNDEFINED = r5;
            TransitionState r10 = new TransitionState("SETUP", 1);
            SETUP = r10;
            TransitionState r11 = new TransitionState("MOVING", 2);
            MOVING = r11;
            TransitionState r12 = new TransitionState("FINISHED", 3);
            FINISHED = r12;
            $VALUES = new TransitionState[]{r5, r10, r11, r12};
        }

        private TransitionState(String r5, int r10) {
            super(r5, r10);
        }

        public static TransitionState valueOf(String r5) {
            return (TransitionState) Enum.valueOf(TransitionState.class, r5);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) $VALUES.clone();
        }
    }

    public MotionLayout(@NonNull Context r5) {
        super(r5);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        init(null);
    }

    public static /* synthetic */ int access$000(MotionLayout r5) {
        return r5.mEndState;
    }

    public static /* synthetic */ int access$100(MotionLayout r5) {
        return r5.mBeginState;
    }

    public static /* synthetic */ int access$1000(MotionLayout r5) {
        return r5.mLastHeightMeasureSpec;
    }

    public static /* synthetic */ void access$1100(MotionLayout r5) {
        r5.setupMotionViews();
    }

    public static /* synthetic */ void access$1200(MotionLayout r5, ConstraintWidgetContainer r10, int r11, int r12, int r13) {
        r5.resolveSystem(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$1300(MotionLayout r5, ConstraintWidgetContainer r10, int r11, int r12, int r13) {
        r5.resolveSystem(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$1400(MotionLayout r5, ConstraintWidgetContainer r10, int r11, int r12, int r13) {
        r5.resolveSystem(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$1500(MotionLayout r5, ConstraintWidgetContainer r10, int r11, int r12, int r13) {
        r5.resolveSystem(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$1600(MotionLayout r5, ConstraintWidgetContainer r10, int r11, int r12, int r13) {
        r5.resolveSystem(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$1700(MotionLayout r5, ConstraintWidgetContainer r10, int r11, int r12, int r13) {
        r5.resolveSystem(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$1800(MotionLayout r5, ConstraintWidgetContainer r10, int r11, int r12, int r13) {
        r5.resolveSystem(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$1900(MotionLayout r5, ConstraintWidgetContainer r10, int r11, int r12, int r13) {
        r5.resolveSystem(r10, r11, r12, r13);
    }

    public static /* synthetic */ ConstraintWidgetContainer access$200(MotionLayout r5) {
        return r5.mLayoutWidget;
    }

    public static /* synthetic */ void access$2000(MotionLayout r5, int r10, int r11, int r12, int r13, boolean r14, boolean r15) {
        r5.resolveMeasuredDimension(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ ConstraintWidgetContainer access$300(MotionLayout r5) {
        return r5.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer access$400(MotionLayout r5) {
        return r5.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer access$500(MotionLayout r5) {
        return r5.mLayoutWidget;
    }

    public static /* synthetic */ boolean access$600(MotionLayout r5) {
        return r5.isRtl();
    }

    public static /* synthetic */ boolean access$700(MotionLayout r5) {
        return r5.isRtl();
    }

    public static /* synthetic */ void access$800(MotionLayout r5, boolean r10, View r11, ConstraintWidget r12, ConstraintLayout.LayoutParams r13, SparseArray r14) {
        r5.applyConstraintsFromLayoutParams(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ int access$900(MotionLayout r5) {
        return r5.mLastWidthMeasureSpec;
    }

    private void checkStructure() {
        MotionScene r5 = this.mScene;
        if (r5 != null) goto L6;
        Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
        return;
    L6:
        int r10 = r5.getStartId();
        MotionScene r11 = this.mScene;
        checkStructure(r10, r11.getConstraintSet(r11.getStartId()));
        SparseIntArray r12 = new SparseIntArray();
        SparseIntArray r13 = new SparseIntArray();
        Iterator<MotionScene.Transition> r14 = this.mScene.getDefinedTransitions().iterator();
    L8:
        if (r14.hasNext() == false) goto L24;
        MotionScene.Transition r15 = r14.next();
        if (r15 != this.mScene.mCurrentTransition) goto L12;
        Log.v(TAG, "CHECK: CURRENT");
    L12:
        checkStructure(r15);
        int r16 = r15.getStartConstraintSetId();
        int r17 = r15.getEndConstraintSetId();
        String r18 = Debug.getName(getContext(), r16);
        String r19 = Debug.getName(getContext(), r17);
        if (r12.get(r16) != r17) goto L16;
        Log.e(TAG, "CHECK: two transitions with the same start and end " + r18 + "->" + r19);
    L16:
        if (r13.get(r17) != r16) goto L18;
        Log.e(TAG, "CHECK: you can't have reverse transitions" + r18 + "->" + r19);
    L18:
        r12.put(r16, r17);
        r13.put(r17, r16);
        if (this.mScene.getConstraintSet(r16) != null) goto L22;
        Log.e(TAG, " no such constraintSetStart " + r18);
    L22:
        if (this.mScene.getConstraintSet(r17) != null) goto L8;
        Log.e(TAG, " no such constraintSetEnd " + r18);
        goto L8
    }

    private void computeCurrentPositions() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L9;
        View r11 = getChildAt(r10);
        MotionController r12 = this.mFrameArrayList.get(r11);
        if (r12 == null) goto L8;
        r12.setStartCurrentState(r11);
    L8:
        r10 = r10 + 1;
        goto L3
    }

    private void debugPos() {
        int r5 = 0;
    L4:
        if (r5 >= getChildCount()) goto L6;
        View r10 = getChildAt(r5);
        Log.v(TAG, " " + Debug.getLocation() + " " + Debug.getName(this) + " " + Debug.getName(getContext(), this.mCurrentState) + " " + Debug.getName(r10) + r10.getLeft() + " " + r10.getTop());
        r5 = r5 + 1;
        goto L4
    }

    private void evaluateLayout() {
        float r5 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long r10 = getNanoTime();
        Interpolator r11 = this.mInterpolator;
        if ((r11 instanceof StopLogic) == true) goto L5;
        float r12 = (((r10 - this.mTransitionLastTime) * r5) * 1.0E-9f) / this.mTransitionDuration;
    L6:
        float r13 = this.mTransitionLastPosition + r12;
        if (this.mTransitionInstantly == false) goto L9;
        r13 = this.mTransitionGoalPosition;
    L9:
        int r14 = 0;
        if (r5 <= 0.0f) goto L14;
        if (r13 < this.mTransitionGoalPosition) goto L14;
    L17:
        r13 = this.mTransitionGoalPosition;
        boolean r15 = true;
    L19:
        if (r11 == null) goto L25;
        if (r15 == true) goto L25;
        if (this.mTemporalInterpolator == false) goto L24;
        r13 = r11.getInterpolation((r10 - this.mAnimationStartTime) * 1.0E-9f);
        goto L25
    L24:
        r13 = r11.getInterpolation(r13);
    L25:
        if (r5 <= 0.0f) goto L29;
        if (r13 < this.mTransitionGoalPosition) goto L29;
    L32:
        r13 = this.mTransitionGoalPosition;
    L33:
        this.mPostInterpolationPosition = r13;
        int r16 = getChildCount();
        long r17 = getNanoTime();
    L34:
        if (r14 >= r16) goto L40;
        View r18 = getChildAt(r14);
        MotionController r19 = this.mFrameArrayList.get(r18);
        if (r19 == null) goto L38;
        r19.interpolate(r18, r13, r17, this.mKeyCache);
    L38:
        r14 = r14 + 1;
        goto L34
    L40:
        if (this.mMeasureDuringTransition == false) goto L46;
        requestLayout();
        return;
    L46:
        return;
    L29:
        if (r5 > 0.0f) goto L33;
        if (r13 > this.mTransitionGoalPosition) goto L33;
    L14:
        if (r5 <= 0.0f) goto L16;
    L18:
        r15 = false;
        goto L19
    L16:
        if (r13 > this.mTransitionGoalPosition) goto L18;
    L5:
        r12 = 0.0f;
        goto L6
    }

    private void fireTransitionChange() {
        if (this.mTransitionListener != null) goto L9;
        ArrayList<TransitionListener> r5 = this.mTransitionListeners;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.mListenerPosition != this.mTransitionPosition) goto L11;
        return;
    L11:
        if (this.mListenerState == (-1)) goto L22;
        TransitionListener r10 = this.mTransitionListener;
        if (r10 == null) goto L15;
        r10.onTransitionStarted(this, this.mBeginState, this.mEndState);
    L15:
        ArrayList<TransitionListener> r11 = this.mTransitionListeners;
        if (r11 == null) goto L21;
        Iterator<TransitionListener> r12 = r11.iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        r12.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
    L21:
        this.mIsAnimating = true;
    L22:
        this.mListenerState = -1;
        float r13 = this.mTransitionPosition;
        this.mListenerPosition = r13;
        TransitionListener r14 = this.mTransitionListener;
        if (r14 == null) goto L25;
        r14.onTransitionChange(this, this.mBeginState, this.mEndState, r13);
    L25:
        ArrayList<TransitionListener> r15 = this.mTransitionListeners;
        if (r15 == null) goto L31;
        Iterator<TransitionListener> r16 = r15.iterator();
    L29:
        if (r16.hasNext() == false) goto L31;
        r16.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
    L31:
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted(MotionLayout r5, int r10, int r11) {
        TransitionListener r12 = this.mTransitionListener;
        if (r12 == null) goto L5;
        r12.onTransitionStarted(this, r10, r11);
    L5:
        ArrayList<TransitionListener> r13 = this.mTransitionListeners;
        if (r13 == null) goto L11;
        Iterator<TransitionListener> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        r14.next().onTransitionStarted(r5, r10, r11);
        goto L9
    L13:
        return;
    }

    private boolean handlesTouchEvent(float r10, float r11, View r12, MotionEvent r13) {
        if ((r12 instanceof ViewGroup) == false) goto L10;
        ViewGroup r5 = (ViewGroup) r12;
        int r14 = r5.getChildCount();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L10;
        if (handlesTouchEvent(r12.getLeft() + r10, r12.getTop() + r11, r5.getChildAt(r15), r13) == true) goto L8;
        r15 = r15 + 1;
        goto L5
    L8:
        return true;
    L10:
        this.mBoundsCheck.set(r12.getLeft() + r10, r12.getTop() + r11, r10 + r12.getRight(), r11 + r12.getBottom());
        if (r13.getAction() != 0) goto L18;
        if (this.mBoundsCheck.contains(r13.getX(), r13.getY()) == true) goto L15;
    L20:
        return false;
    L15:
        if (r12.onTouchEvent(r13) == false) goto L20;
        return true;
    L18:
        if (r12.onTouchEvent(r13) == false) goto L20;
        return true;
    }

    private void init(AttributeSet r10) {
        IS_IN_EDIT_MODE = isInEditMode();
        if (r10 == null) goto L37;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.MotionLayout);
        int r5 = r11.getIndexCount();
        boolean r12 = true;
        int r13 = 0;
    L5:
        if (r13 >= r5) goto L31;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.MotionLayout_layoutDescription) goto L10;
        this.mScene = new MotionScene(getContext(), this, r11.getResourceId(r14, -1));
    L30:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R.styleable.MotionLayout_currentState) goto L13;
        this.mCurrentState = r11.getResourceId(r14, -1);
        goto L30
    L13:
        if (r14 != R.styleable.MotionLayout_motionProgress) goto L16;
        this.mTransitionGoalPosition = r11.getFloat(r14, 0.0f);
        this.mInTransition = true;
        goto L30
    L16:
        if (r14 != R.styleable.MotionLayout_applyMotionScene) goto L19;
        r12 = r11.getBoolean(r14, r12);
        goto L30
    L19:
        if (r14 != R.styleable.MotionLayout_showPaths) goto L28;
        if (this.mDebugPath != 0) goto L30;
        if (r11.getBoolean(r14, false) == false) goto L25;
        int r15 = 2;
    L26:
        this.mDebugPath = r15;
        goto L30
    L25:
        r15 = 0;
        goto L26
    L28:
        if (r14 != R.styleable.MotionLayout_motionDebug) goto L30;
        this.mDebugPath = r11.getInt(r14, 0);
        goto L30
    L31:
        r11.recycle();
        if (this.mScene != null) goto L34;
        Log.e(TAG, "WARNING NO app:layoutDescription tag");
    L34:
        if (r12 == true) goto L37;
        this.mScene = null;
    L37:
        if (this.mDebugPath == 0) goto L40;
        checkStructure();
    L40:
        if (this.mCurrentState != (-1)) goto L54;
        MotionScene r16 = this.mScene;
        if (r16 == null) goto L55;
        this.mCurrentState = r16.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
        return;
    L55:
        return;
    }

    private void processTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        ArrayList<TransitionListener> r5 = this.mTransitionListeners;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.isEmpty() == false) goto L9;
        return;
    L9:
        this.mIsAnimating = false;
        Iterator<Integer> r10 = this.mTransitionCompleted.iterator();
    L11:
        if (r10.hasNext() == false) goto L21;
        Integer r11 = r10.next();
        TransitionListener r12 = this.mTransitionListener;
        if (r12 == null) goto L15;
        r12.onTransitionCompleted(this, r11.intValue());
    L15:
        ArrayList<TransitionListener> r13 = this.mTransitionListeners;
        if (r13 == null) goto L11;
        Iterator<TransitionListener> r14 = r13.iterator();
    L19:
        if (r14.hasNext() == false) goto L11;
        r14.next().onTransitionCompleted(this, r11.intValue());
        goto L19
    L21:
        this.mTransitionCompleted.clear();
    }

    private void setupMotionViews() {
        int r5 = getChildCount();
        this.mModel.build();
        boolean r10 = true;
        this.mInTransition = true;
        int r11 = getWidth();
        int r12 = getHeight();
        int r13 = this.mScene.gatPathMotionArc();
        int r14 = 0;
        if (r13 == (-1)) goto L10;
        int r15 = 0;
    L5:
        if (r15 >= r5) goto L10;
        MotionController r16 = this.mFrameArrayList.get(getChildAt(r15));
        if (r16 == null) goto L9;
        r16.setPathMotionArc(r13);
    L9:
        r15 = r15 + 1;
    L10:
        int r17 = 0;
    L11:
        if (r17 >= r5) goto L16;
        MotionController r18 = this.mFrameArrayList.get(getChildAt(r17));
        if (r18 == null) goto L15;
        this.mScene.getKeyFrames(r18);
        r18.setup(r11, r12, this.mTransitionDuration, getNanoTime());
    L15:
        r17 = r17 + 1;
        goto L11
    L16:
        float r19 = this.mScene.getStaggered();
        if (r19 != 0.0f) goto L19;
        return;
    L19:
        if (r19 < 0.0d) goto L22;
        r10 = false;
    L22:
        float r20 = Math.abs(r19);
        float r21 = -3.4028235E38f;
        float r22 = Float.MAX_VALUE;
        float r23 = -3.4028235E38f;
        float r24 = Float.MAX_VALUE;
        int r25 = 0;
    L24:
        if (r25 >= r5) goto L46;
        MotionController r26 = this.mFrameArrayList.get(getChildAt(r25));
        if (Float.isNaN(r26.mMotionStagger) == false) goto L27;
        float r27 = r26.getFinalX();
        float r28 = r26.getFinalY();
        if (r10 == false) goto L44;
        float r29 = r28 - r27;
    L45:
        r24 = Math.min(r24, r29);
        r23 = Math.max(r23, r29);
        r25 = r25 + 1;
        goto L24
    L44:
        r29 = r28 + r27;
        goto L45
    L27:
        int r30 = 0;
    L28:
        if (r30 >= r5) goto L33;
        MotionController r31 = this.mFrameArrayList.get(getChildAt(r30));
        if (Float.isNaN(r31.mMotionStagger) == true) goto L32;
        r22 = Math.min(r22, r31.mMotionStagger);
        r21 = Math.max(r21, r31.mMotionStagger);
    L32:
        r30 = r30 + 1;
    L33:
        if (r14 >= r5) goto L73;
        MotionController r32 = this.mFrameArrayList.get(getChildAt(r14));
        if (Float.isNaN(r32.mMotionStagger) == true) goto L40;
        r32.mStaggerScale = 1.0f / (1.0f - r20);
        if (r10 == false) goto L39;
        r32.mStaggerOffset = r20 - (((r21 - r32.mMotionStagger) / (r21 - r22)) * r20);
        goto L40
    L39:
        r32.mStaggerOffset = r20 - (((r32.mMotionStagger - r22) * r20) / (r21 - r22));
    L40:
        r14 = r14 + 1;
        goto L33
    L73:
        return;
    L46:
        if (r14 >= r5) goto L74;
        MotionController r33 = this.mFrameArrayList.get(getChildAt(r14));
        float r34 = r33.getFinalX();
        float r35 = r33.getFinalY();
        if (r10 == false) goto L50;
        float r36 = r35 - r34;
    L51:
        r33.mStaggerScale = 1.0f / (1.0f - r20);
        r33.mStaggerOffset = r20 - (((r36 - r24) * r20) / (r23 - r24));
        r14 = r14 + 1;
        goto L46
    L50:
        r36 = r35 + r34;
        goto L51
    }

    private static boolean willJump(float r5, float r10, float r11) {
        if (r5 <= 0.0f) goto L8;
        float r12 = r5 / r11;
        if ((((r5 * r12) - (((r11 * r12) * r12) / 2.0f)) + r10) > 1.0f) goto L7;
        return false;
    L7:
        return true;
    L8:
        float r13 = (-r5) / r11;
        float r14 = ((r11 * r13) * r13) / 2.0f;
        if (((r14 + (r5 * r13)) + r10) < 0.0f) goto L11;
        return false;
    L11:
        return true;
    }

    public void addTransitionListener(TransitionListener r5) {
        if (this.mTransitionListeners != null) goto L5;
        this.mTransitionListeners = new ArrayList();
    L5:
        this.mTransitionListeners.add(r5);
    }

    public void animateTo(float r5) {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L5;
        return;
    L5:
        float r11 = this.mTransitionLastPosition;
        float r12 = this.mTransitionPosition;
        if (r11 != r12) goto L8;
    L10:
        float r13 = this.mTransitionLastPosition;
        if (r13 != r5) goto L13;
        return;
    L13:
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = r5;
        this.mTransitionDuration = r10.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = r13;
        this.mTransitionLastPosition = r13;
        invalidate();
        return;
    L8:
        if (this.mTransitionInstantly == false) goto L10;
        this.mTransitionLastPosition = r12;
        goto L10
    }

    public void disableAutoTransition(boolean r5) {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.disableAutoTransition(r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        evaluate(false);
        super.dispatchDraw(r10);
        if (this.mScene != null) goto L6;
        return;
    L6:
        if ((this.mDebugPath & 1) != 1) goto L21;
        if (isInEditMode() == true) goto L21;
        this.mFrames++;
        long r5 = getNanoTime();
        long r11 = this.mLastDrawTime;
        if (r11 == (-1)) goto L14;
        long r12 = r5 - r11;
        if (r12 <= 200000000) goto L15;
        this.mLastFps = ((int) ((this.mFrames / (r12 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.mFrames = 0;
        this.mLastDrawTime = r5;
    L15:
        Paint r13 = new Paint();
        r13.setTextSize(42.0f);
        float r14 = ((int) (getProgress() * 1000.0f)) / 10.0f;
        StringBuilder r15 = j0.u(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
        r15.append(Debug.getState(this, this.mEndState));
        r15.append(" (progress: ");
        r15.append(r14);
        r15.append(" ) state=");
        int r16 = this.mCurrentState;
        if (r16 != (-1)) goto L18;
        String r17 = "undefined";
    L19:
        r15.append(r17);
        String r18 = r15.toString();
        r13.setColor(ViewCompat.MEASURED_STATE_MASK);
        r10.drawText(r18, 11.0f, getHeight() - 29, r13);
        r13.setColor(-7864184);
        r10.drawText(r18, 10.0f, getHeight() - 30, r13);
        goto L21
    L18:
        r17 = Debug.getState(this, r16);
        goto L19
    L14:
        this.mLastDrawTime = r5;
    L21:
        if (this.mDebugPath > 1) goto L23;
        return;
    L23:
        if (this.mDevModeDraw != null) goto L25;
        this.mDevModeDraw = new DevModeDraw(this);
    L25:
        this.mDevModeDraw.draw(r10, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
    }

    public void enableTransition(int r5, boolean r10) {
        MotionScene.Transition r11 = getTransition(r5);
        if (r10 == false) goto L6;
        r11.setEnable(true);
        return;
    L6:
        MotionScene r12 = this.mScene;
        if (r11 != r12.mCurrentTransition) goto L14;
        Iterator<MotionScene.Transition> r13 = r12.getTransitionsWithState(this.mCurrentState).iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        MotionScene.Transition r14 = r13.next();
        if (r14.isEnabled() == false) goto L10;
        this.mScene.mCurrentTransition = r14;
    L14:
        r11.setEnable(false);
    }

    public void evaluate(boolean r23) {
        if (this.mTransitionLastTime != (-1)) goto L5;
        this.mTransitionLastTime = getNanoTime();
    L5:
        float r5 = this.mTransitionLastPosition;
        if (r5 > 0.0f) goto L8;
    L10:
        boolean r10 = true;
        boolean r11 = false;
        if (this.mKeepAnimating == false) goto L13;
    L17:
        float r12 = Math.signum(this.mTransitionGoalPosition - r5);
        long r13 = getNanoTime();
        Interpolator r14 = this.mInterpolator;
        if ((r14 instanceof MotionInterpolator) == true) goto L20;
        float r15 = (((r13 - this.mTransitionLastTime) * r12) * 1.0E-9f) / this.mTransitionDuration;
        this.mLastVelocity = r15;
    L21:
        float r16 = this.mTransitionLastPosition + r15;
        if (this.mTransitionInstantly == false) goto L25;
        r16 = this.mTransitionGoalPosition;
    L25:
        if (r12 <= 0.0f) goto L29;
        if (r16 < this.mTransitionGoalPosition) goto L29;
    L32:
        r16 = this.mTransitionGoalPosition;
        this.mInTransition = false;
        boolean r17 = true;
    L34:
        this.mTransitionLastPosition = r16;
        this.mTransitionPosition = r16;
        this.mTransitionLastTime = r13;
        if (r14 == null) goto L60;
        if (r17 == true) goto L60;
        if (this.mTemporalInterpolator == false) goto L54;
        float r18 = r14.getInterpolation((r13 - this.mAnimationStartTime) * 1.0E-9f);
        this.mTransitionLastPosition = r18;
        this.mTransitionLastTime = r13;
        Interpolator r19 = this.mInterpolator;
        if ((r19 instanceof MotionInterpolator) == false) goto L58;
        float r20 = ((MotionInterpolator) r19).getVelocity();
        this.mLastVelocity = r20;
        if ((Math.abs(r20) * this.mTransitionDuration) > EPSILON) goto L45;
        this.mInTransition = false;
    L45:
        if (r20 <= 0.0f) goto L50;
        if (r18 < 1.0f) goto L50;
        this.mTransitionLastPosition = 1.0f;
        this.mInTransition = false;
        r18 = 1.0f;
    L50:
        if (r20 >= 0.0f) goto L58;
        if (r18 > 0.0f) goto L58;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = false;
        r16 = 0.0f;
    L58:
        r16 = r18;
        goto L60
    L54:
        r18 = r14.getInterpolation(r16);
        Interpolator r21 = this.mInterpolator;
        if ((r21 instanceof MotionInterpolator) == false) goto L57;
        this.mLastVelocity = ((MotionInterpolator) r21).getVelocity();
        goto L58
    L57:
        this.mLastVelocity = ((r21.getInterpolation(r16 + r15) - r18) * r12) / r15;
    L60:
        if (Math.abs(this.mLastVelocity) <= EPSILON) goto L62;
        setState(TransitionState.MOVING);
    L62:
        if (r12 <= 0.0f) goto L66;
        if (r16 < this.mTransitionGoalPosition) goto L66;
    L69:
        r16 = this.mTransitionGoalPosition;
        this.mInTransition = false;
    L71:
        if (r16 < 1.0f) goto L73;
    L74:
        this.mInTransition = false;
        setState(TransitionState.FINISHED);
    L75:
        int r22 = getChildCount();
        this.mKeepAnimating = false;
        long r24 = getNanoTime();
        this.mPostInterpolationPosition = r16;
        int r25 = 0;
    L76:
        if (r25 >= r22) goto L81;
        View r110 = getChildAt(r25);
        MotionController r111 = this.mFrameArrayList.get(r110);
        if (r111 == null) goto L80;
        this.mKeepAnimating = r111.interpolate(r110, r16, r24, this.mKeyCache) | this.mKeepAnimating;
    L80:
        r25 = r25 + 1;
        goto L76
    L81:
        if (r12 <= 0.0f) goto L85;
        if (r16 < this.mTransitionGoalPosition) goto L85;
    L88:
        boolean r26 = true;
    L91:
        if (this.mKeepAnimating == true) goto L97;
        if (this.mInTransition == true) goto L97;
        if (r26 == false) goto L97;
        setState(TransitionState.FINISHED);
    L97:
        if (this.mMeasureDuringTransition == false) goto L99;
        requestLayout();
    L99:
        this.mKeepAnimating = (!r26) | this.mKeepAnimating;
        if (r16 > 0.0f) goto L107;
        int r27 = this.mBeginState;
        if (r27 == (-1)) goto L107;
        if (this.mCurrentState == r27) goto L107;
        this.mCurrentState = r27;
        this.mScene.getConstraintSet(r27).applyCustomAttributes(this);
        setState(TransitionState.FINISHED);
        r11 = true;
    L107:
        if (r16 < 1.0d) goto L112;
        int r28 = this.mCurrentState;
        int r29 = this.mEndState;
        if (r28 == r29) goto L112;
        this.mCurrentState = r29;
        this.mScene.getConstraintSet(r29).applyCustomAttributes(this);
        setState(TransitionState.FINISHED);
        r11 = true;
    L112:
        if (this.mKeepAnimating == false) goto L114;
    L123:
        invalidate();
    L125:
        if (this.mKeepAnimating == true) goto L131;
        if (this.mInTransition == false) goto L131;
        if (r12 <= 0.0f) goto L131;
        if (r16 != 1.0f) goto L131;
    L134:
        onNewStateAttachHandlers();
    L135:
        float r30 = this.mTransitionLastPosition;
        if (r30 < 1.0f) goto L144;
        int r31 = this.mCurrentState;
        int r32 = this.mEndState;
        if (r31 != r32) goto L141;
        r10 = r11;
    L141:
        this.mCurrentState = r32;
    L142:
        r11 = r10;
    L150:
        this.mNeedsFireTransitionCompleted |= r11;
        if (r11 == true) goto L153;
    L155:
        this.mTransitionPosition = this.mTransitionLastPosition;
        return;
    L153:
        if (this.mInLayout == true) goto L155;
        requestLayout();
        goto L155
    L144:
        if (r30 > 0.0f) goto L150;
        int r33 = this.mCurrentState;
        int r34 = this.mBeginState;
        if (r33 != r34) goto L149;
        r10 = r11;
    L149:
        this.mCurrentState = r34;
    L131:
        if (r12 >= 0.0f) goto L135;
        if (r16 != 0.0f) goto L135;
    L114:
        if (this.mInTransition == true) goto L123;
        if (r12 <= 0.0f) goto L119;
        if (r16 != 1.0f) goto L119;
    L122:
        setState(TransitionState.FINISHED);
    L119:
        if (r12 >= 0.0f) goto L125;
        if (r16 != 0.0f) goto L125;
    L85:
        if (r12 <= 0.0f) goto L87;
    L89:
        r26 = false;
        goto L91
    L87:
        if (r16 > this.mTransitionGoalPosition) goto L89;
    L73:
        if (r16 > 0.0f) goto L75;
    L66:
        if (r12 > 0.0f) goto L71;
        if (r16 > this.mTransitionGoalPosition) goto L71;
    L29:
        if (r12 <= 0.0f) goto L31;
    L33:
        r17 = false;
        goto L34
    L31:
        if (r16 > this.mTransitionGoalPosition) goto L33;
    L20:
        r15 = 0.0f;
        goto L21
    L13:
        if (this.mInTransition == false) goto L135;
        if (r23 == true) goto L17;
        if (this.mTransitionGoalPosition == r5) goto L135;
    L8:
        if (r5 >= 1.0f) goto L10;
        this.mCurrentState = -1;
        goto L10
    }

    public void fireTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        ArrayList<TransitionListener> r5 = this.mTransitionListeners;
        if (r5 != null) goto L7;
    L18:
        processTransitionCompleted();
        return;
    L7:
        if (r5.isEmpty() == true) goto L18;
    L9:
        if (this.mListenerState != (-1)) goto L18;
        this.mListenerState = this.mCurrentState;
        if (this.mTransitionCompleted.isEmpty() == true) goto L13;
        int r10 = ((Integer) a.h(this.mTransitionCompleted, 1)).intValue();
    L14:
        int r11 = this.mCurrentState;
        if (r10 == r11) goto L18;
        if (r11 == (-1)) goto L18;
        this.mTransitionCompleted.add(Integer.valueOf(r11));
        goto L18
    L13:
        r10 = -1;
        goto L14
    }

    public void fireTrigger(int r5, boolean r10, float r11) {
        TransitionListener r12 = this.mTransitionListener;
        if (r12 == null) goto L5;
        r12.onTransitionTrigger(this, r5, r10, r11);
    L5:
        ArrayList<TransitionListener> r13 = this.mTransitionListeners;
        if (r13 == null) goto L11;
        Iterator<TransitionListener> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        r14.next().onTransitionTrigger(this, r5, r10, r11);
        goto L9
    L13:
        return;
    }

    public void getAnchorDpDt(int r5, float r10, float r11, float r12, float[] r13) {
        HashMap<View, MotionController> r14 = this.mFrameArrayList;
        View r15 = getViewById(r5);
        MotionController r16 = r14.get(r15);
        if (r16 == null) goto L5;
        r16.getDpDt(r10, r11, r12, r13);
        float r17 = r15.getY();
        this.lastPos = r10;
        this.lastY = r17;
        return;
    L5:
        if (r15 != null) goto L7;
        String r18 = j0.g(r5, "");
    L8:
        Log.w(TAG, "WARNING could not find view id " + r18);
        return;
    L7:
        r18 = r15.getContext().getResources().getResourceName(r5);
        goto L8
    }

    public ConstraintSet getConstraintSet(int r5) {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getConstraintSet(r5);
    }

    public int[] getConstraintSetIds() {
        MotionScene r5 = this.mScene;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getConstraintSetIds();
    }

    public String getConstraintSetNames(int r5) {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.lookUpConstraintName(r5);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean r5) {
        if (r5 == false) goto L4;
        int r10 = 2;
    L5:
        this.mDebugPath = r10;
        invalidate();
        return;
    L4:
        r10 = 1;
        goto L5
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene r5 = this.mScene;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool != null) goto L6;
        this.mDesignTool = new DesignTool(this);
    L6:
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int r5) {
        return this.mScene.getTransitionById(r5);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new StateCache(this);
    L5:
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene r5 = this.mScene;
        if (r5 == null) goto L6;
        this.mTransitionDuration = r5.getDuration() / 1000.0f;
    L6:
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View r10, float r11, float r12, float[] r13, int r14) {
        float r5 = this.mLastVelocity;
        float r15 = this.mTransitionLastPosition;
        if (this.mInterpolator == null) goto L5;
        float r16 = Math.signum(this.mTransitionGoalPosition - r15);
        float r17 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
        float r18 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
        r5 = (((r17 - r18) / EPSILON) * r16) / this.mTransitionDuration;
    L6:
        Interpolator r19 = this.mInterpolator;
        if ((r19 instanceof MotionInterpolator) == false) goto L9;
        r5 = ((MotionInterpolator) r19).getVelocity();
    L9:
        MotionController r20 = this.mFrameArrayList.get(r10);
        if ((r14 & 1) != 0) goto L12;
        r20.getPostLayoutDvDp(r18, r10.getWidth(), r10.getHeight(), r11, r12, r13);
    L14:
        if (r14 >= 2) goto L17;
        r13[0] = r13[0] * r5;
        r13[1] = r13[1] * r5;
        return;
    L17:
        return;
    L12:
        r20.getDpDt(r18, r11, r12, r13);
        goto L14
    L5:
        r18 = r15;
        goto L6
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int r5) {
        if (r5 != 0) goto L12;
        this.mScene = null;
        return;
    L12:
        this.mScene = new MotionScene(getContext(), this, r5);     // Catch: Exception -> L7
        if (isAttachedToWindow() == false) goto L14;
        this.mScene.readFallback(this);     // Catch: Exception -> L7
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));     // Catch: Exception -> L7
        rebuildScene();     // Catch: Exception -> L7
        this.mScene.setRtl(isRtl());     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);
    }

    public int lookUpConstraintId(String r5) {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.lookUpConstraintId(r5);
    }

    public MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MotionScene r5 = this.mScene;
        if (r5 == null) goto L10;
        int r10 = this.mCurrentState;
        if (r10 == (-1)) goto L10;
        ConstraintSet r11 = r5.getConstraintSet(r10);
        this.mScene.readFallback(this);
        if (r11 == null) goto L9;
        r11.applyTo(this);
    L9:
        this.mBeginState = this.mCurrentState;
    L10:
        onNewStateAttachHandlers();
        StateCache r12 = this.mStateCache;
        if (r12 == null) goto L13;
        r12.apply();
        return;
    L13:
        MotionScene r13 = this.mScene;
        if (r13 == null) goto L22;
        MotionScene.Transition r14 = r13.mCurrentTransition;
        if (r14 != null) goto L18;
        return;
    L18:
        if (r14.getAutoTransition() != 4) goto L24;
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L24:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        MotionScene r5 = this.mScene;
        if (r5 != null) goto L5;
    L35:
        return false;
    L5:
        if (this.mInteractionEnabled == false) goto L35;
        MotionScene.Transition r11 = r5.mCurrentTransition;
        if (r11 == null) goto L35;
        if (r11.isEnabled() == false) goto L35;
        TouchResponse r12 = r11.getTouchResponse();
        if (r12 == null) goto L35;
        if (r10.getAction() != 0) goto L20;
        RectF r13 = r12.getTouchRegion(this, new RectF());
        if (r13 == null) goto L20;
        if (r13.contains(r10.getX(), r10.getY()) == true) goto L20;
        return false;
    L20:
        int r14 = r12.getTouchRegionId();
        if (r14 == (-1)) goto L35;
        View r15 = this.mRegionView;
        if (r15 != null) goto L25;
    L26:
        this.mRegionView = findViewById(r14);
    L27:
        View r16 = this.mRegionView;
        if (r16 == null) goto L35;
        this.mBoundsCheck.set(r16.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
        if (this.mBoundsCheck.contains(r10.getX(), r10.getY()) == false) goto L35;
        if (handlesTouchEvent(0.0f, 0.0f, this.mRegionView, r10) == true) goto L35;
        return onTouchEvent(r10);
    L25:
        if (r15.getId() == r14) goto L27;
        goto L26
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        this.mInLayout = true;
    L8:
        th = move-exception;
        this.mInLayout = false;
        throw th;
    L4:
        if (this.mScene != null) goto L10;
        super.onLayout(r5, r10, r11, r12, r13);     // Catch: Throwable -> L8
        this.mInLayout = false;
        return;
    L10:
        int r14 = r12 - r10;
        int r15 = r13 - r11;
        if (this.mLastLayoutWidth == r14) goto L14;
    L15:
        rebuildScene();     // Catch: Throwable -> L8
        evaluate(true);     // Catch: Throwable -> L8
    L16:
        this.mLastLayoutWidth = r14;     // Catch: Throwable -> L8
        this.mLastLayoutHeight = r15;     // Catch: Throwable -> L8
        this.mOldWidth = r14;     // Catch: Throwable -> L8
        this.mOldHeight = r15;     // Catch: Throwable -> L8
        this.mInLayout = false;
        return;
    L14:
        if (this.mLastLayoutHeight == r15) goto L16;
        goto L15
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.mScene != null) goto L6;
        super.onMeasure(r10, r11);
        return;
    L6:
        boolean r5 = false;
        if (this.mLastWidthMeasureSpec == r10) goto L9;
    L12:
        boolean r12 = true;
    L14:
        if (this.mNeedsFireTransitionCompleted == false) goto L17;
        this.mNeedsFireTransitionCompleted = false;
        onNewStateAttachHandlers();
        processTransitionCompleted();
        r12 = true;
    L17:
        if (this.mDirtyHierarchy == false) goto L19;
        r12 = true;
    L19:
        this.mLastWidthMeasureSpec = r10;
        this.mLastHeightMeasureSpec = r11;
        int r13 = this.mScene.getStartId();
        int r14 = this.mScene.getEndId();
        if (r12 == true) goto L24;
        if (this.mModel.isNotConfiguredWith(r13, r14) == true) goto L24;
    L26:
        r5 = true;
    L28:
        if (this.mMeasureDuringTransition == true) goto L30;
        if (r5 == true) goto L30;
    L39:
        evaluateLayout();
        return;
    L30:
        int r15 = getPaddingBottom() + getPaddingTop();
        int r16 = this.mLayoutWidget.getWidth() + (getPaddingRight() + getPaddingLeft());
        int r17 = this.mLayoutWidget.getHeight() + r15;
        int r18 = this.mWidthMeasureMode;
        if (r18 == Integer.MIN_VALUE) goto L33;
        if (r18 == 0) goto L33;
    L34:
        int r19 = this.mHeightMeasureMode;
        if (r19 == Integer.MIN_VALUE) goto L37;
        if (r19 == 0) goto L37;
    L38:
        setMeasuredDimension(r16, r17);
    L37:
        int r20 = this.mStartWrapHeight;
        r17 = (int) ((this.mPostInterpolationPosition * (this.mEndWrapHeight - r20)) + r20);
        requestLayout();
    L33:
        int r21 = this.mStartWrapWidth;
        r16 = (int) ((this.mPostInterpolationPosition * (this.mEndWrapWidth - r21)) + r21);
        requestLayout();
    L24:
        if (this.mBeginState == (-1)) goto L26;
        super.onMeasure(r10, r11);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(r13), this.mScene.getConstraintSet(r14));
        this.mModel.reEvaluateState();
        this.mModel.setMeasuredId(r13, r14);
        goto L28
    L9:
        if (this.mLastHeightMeasureSpec != r11) goto L12;
        r12 = false;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r5, float r10, float r11) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View r10, int r11, int r12, int[] r13, int r14) {
        MotionScene r15 = this.mScene;
        if (r15 == null) goto L55;
        MotionScene.Transition r16 = r15.mCurrentTransition;
        if (r16 != null) goto L8;
        return;
    L8:
        if (r16.isEnabled() == true) goto L10;
        return;
    L10:
        MotionScene.Transition r17 = this.mScene.mCurrentTransition;
        if (r17 != null) goto L13;
    L21:
        MotionScene r5 = this.mScene;
        if (r5 == null) goto L33;
        if (r5.getMoveWhenScrollAtTop() == false) goto L33;
        float r18 = this.mTransitionPosition;
        if (r18 == 1.0f) goto L30;
        if (r18 != 0.0f) goto L33;
    L30:
        if (r10.canScrollVertically(-1) == false) goto L33;
        return;
    L33:
        if (r17.getTouchResponse() != null) goto L35;
    L46:
        float r19 = this.mTransitionPosition;
        long r20 = getNanoTime();
        float r110 = r11;
        this.mScrollTargetDX = r110;
        float r21 = r12;
        this.mScrollTargetDY = r21;
        this.mScrollTargetDT = (float) ((r20 - this.mScrollTargetTime) * 1.0E-9d);
        this.mScrollTargetTime = r20;
        this.mScene.processScrollMove(r110, r21);
        if (r19 == this.mTransitionPosition) goto L49;
        r13[0] = r11;
        r13[1] = r12;
    L49:
        evaluate(false);
        if (r13[0] == 0) goto L52;
    L53:
        this.mUndergoingMotion = true;
        return;
    L52:
        if (r13[1] != 0) goto L53;
        return;
    L35:
        if ((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) == 0) goto L46;
        float r111 = this.mScene.getProgressDirection(r11, r12);
        float r22 = this.mTransitionLastPosition;
        if (r22 > 0.0f) goto L41;
        if (r111 >= 0.0f) goto L41;
    L44:
        r10.setNestedScrollingEnabled(false);
        r10.post(new AnonymousClass1(this, r10));
        return;
    L41:
        if (r22 < 1.0f) goto L46;
        if (r111 <= 0.0f) goto L46;
    L13:
        if (r17.isEnabled() == false) goto L21;
        TouchResponse r23 = r17.getTouchResponse();
        if (r23 == null) goto L21;
        int r24 = r23.getTouchRegionId();
        if (r24 == (-1)) goto L21;
        if (r10.getId() == r24) goto L21;
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
    }

    public void onNewStateAttachHandlers() {
        MotionScene r5 = this.mScene;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.autoTransition(this, this.mCurrentState) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r10 = this.mCurrentState;
        if (r10 == (-1)) goto L13;
        this.mScene.addOnClickListeners(this, r10);
    L13:
        if (this.mScene.supportTouch() == false) goto L16;
        this.mScene.setupTouch();
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r5) {
        MotionScene r10 = this.mScene;
        if (r10 == null) goto L6;
        r10.setRtl(isRtl());
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        MotionScene r13 = this.mScene;
        if (r13 == null) goto L13;
        MotionScene.Transition r14 = r13.mCurrentTransition;
        if (r14 != null) goto L7;
        return false;
    L7:
        if (r14.getTouchResponse() != null) goto L9;
        return false;
    L9:
        if ((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    L13:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r5, int r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L5;
        return;
    L5:
        float r12 = this.mScrollTargetDX;
        float r13 = this.mScrollTargetDT;
        r11.processScrollUp(r12 / r13, this.mScrollTargetDY / r13);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        MotionScene r10 = this.mScene;
        if (r10 == null) goto L17;
        if (this.mInteractionEnabled == false) goto L17;
        if (r10.supportTouch() == false) goto L17;
        MotionScene.Transition r11 = this.mScene.mCurrentTransition;
        if (r11 != null) goto L11;
    L14:
        this.mScene.processTouchEvent(r5, getCurrentState(), this);
        return true;
    L11:
        if (r11.isEnabled() == true) goto L14;
        return super.onTouchEvent(r5);
    L17:
        return super.onTouchEvent(r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View r5) {
        super.onViewAdded(r5);
        if ((r5 instanceof MotionHelper) == false) goto L20;
        MotionHelper r10 = (MotionHelper) r5;
        if (this.mTransitionListeners != null) goto L7;
        this.mTransitionListeners = new ArrayList();
    L7:
        this.mTransitionListeners.add(r10);
        if (r10.isUsedOnShow() == false) goto L14;
        if (this.mOnShowHelpers != null) goto L12;
        this.mOnShowHelpers = new ArrayList();
    L12:
        this.mOnShowHelpers.add(r10);
    L14:
        if (r10.isUseOnHide() == true) goto L16;
        return;
    L16:
        if (this.mOnHideHelpers != null) goto L18;
        this.mOnHideHelpers = new ArrayList();
    L18:
        this.mOnHideHelpers.add(r10);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        ArrayList<MotionHelper> r10 = this.mOnShowHelpers;
        if (r10 == null) goto L5;
        r10.remove(r5);
    L5:
        ArrayList<MotionHelper> r11 = this.mOnHideHelpers;
        if (r11 == null) goto L9;
        r11.remove(r5);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int r5) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener r5) {
        ArrayList<TransitionListener> r10 = this.mTransitionListeners;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.remove(r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mMeasureDuringTransition == false) goto L5;
    L13:
        super.requestLayout();
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L13;
        MotionScene r5 = this.mScene;
        if (r5 == null) goto L13;
        MotionScene.Transition r10 = r5.mCurrentTransition;
        if (r10 == null) goto L13;
        if (r10.getLayoutDuringTransition() != 0) goto L13;
    }

    public void setDebugMode(int r5) {
        this.mDebugPath = r5;
        invalidate();
    }

    public void setInteractionEnabled(boolean r5) {
        this.mInteractionEnabled = r5;
    }

    public void setInterpolatedProgress(float r5) {
        if (this.mScene == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r10 = this.mScene.getInterpolator();
        if (r10 == null) goto L8;
        setProgress(r10.getInterpolation(r5));
        return;
    L8:
        setProgress(r5);
    }

    public void setOnHide(float r5) {
        ArrayList<MotionHelper> r10 = this.mOnHideHelpers;
        if (r10 == null) goto L7;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        this.mOnHideHelpers.get(r12).setProgress(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r5) {
        ArrayList<MotionHelper> r10 = this.mOnShowHelpers;
        if (r10 == null) goto L7;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        this.mOnShowHelpers.get(r12).setProgress(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setProgress(float r5, float r10) {
        if (isAttachedToWindow() == false) goto L5;
        setProgress(r5);
        setState(TransitionState.MOVING);
        this.mLastVelocity = r10;
        animateTo(1.0f);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setProgress(r5);
        this.mStateCache.setVelocity(r10);
    }

    public void setScene(MotionScene r5) {
        this.mScene = r5;
        r5.setRtl(isRtl());
        rebuildScene();
    }

    public void setState(TransitionState r5) {
        TransitionState r10 = TransitionState.FINISHED;
        if (r5 == r10) goto L5;
    L7:
        TransitionState r11 = this.mTransitionState;
        this.mTransitionState = r5;
        TransitionState r12 = TransitionState.MOVING;
        if (r11 != r12) goto L11;
        if (r5 != r12) goto L11;
        fireTransitionChange();
    L11:
        int r13 = AnonymousClass2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[r11.ordinal()];
        if (r13 != 1) goto L14;
    L20:
        if (r5 != r12) goto L22;
        fireTransitionChange();
    L22:
        if (r5 != r10) goto L27;
        fireTransitionCompleted();
        return;
    L27:
        return;
    L14:
        if (r13 == 2) goto L20;
        if (r13 != 3) goto L28;
        if (r5 != r10) goto L25;
        fireTransitionCompleted();
        return;
    L25:
        return;
    L28:
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L7;
    }

    public void setTransition(int r5, int r10) {
        if (isAttachedToWindow() == false) goto L5;
        MotionScene r11 = this.mScene;
        if (r11 == null) goto L13;
        this.mBeginState = r5;
        this.mEndState = r10;
        r11.setTransition(r5, r10);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(r5), this.mScene.getConstraintSet(r10));
        rebuildScene();
        this.mTransitionLastPosition = 0.0f;
        transitionToStart();
        return;
    L13:
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setStartState(r5);
        this.mStateCache.setEndState(r10);
    }

    public void setTransitionDuration(int r5) {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L6;
        Log.e(TAG, "MotionScene not defined");
        return;
    L6:
        r10.setDuration(r5);
    }

    public void setTransitionListener(TransitionListener r5) {
        this.mTransitionListener = r5;
    }

    public void setTransitionState(Bundle r5) {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new StateCache(this);
    L5:
        this.mStateCache.setTransitionState(r5);
        if (isAttachedToWindow() == false) goto L9;
        this.mStateCache.apply();
        return;
    }

    @Override // android.view.View
    public String toString() {
        Context r5 = getContext();
        return Debug.getName(r5, this.mBeginState) + "->" + Debug.getName(r5, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int r11, float r12, float r13) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mTransitionLastPosition != r12) goto L8;
        return;
    L8:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        float r10 = this.mScene.getDuration() / 1000.0f;
        this.mTransitionDuration = r10;
        this.mTransitionGoalPosition = r12;
        this.mInTransition = true;
        if (r11 == 0) goto L22;
        if (r11 == 1) goto L22;
        if (r11 == 2) goto L22;
        if (r11 != 4) goto L15;
        this.mDecelerateLogic.config(r13, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
        this.mInterpolator = this.mDecelerateLogic;
    L27:
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
        return;
    L15:
        if (r11 != 5) goto L27;
        if (willJump(r13, this.mTransitionLastPosition, this.mScene.getMaxAcceleration()) == false) goto L20;
        this.mDecelerateLogic.config(r13, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
        this.mInterpolator = this.mDecelerateLogic;
        goto L27
    L20:
        this.mStopLogic.config(this.mTransitionLastPosition, r12, r13, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
        this.mLastVelocity = 0.0f;
        int r14 = this.mCurrentState;
        this.mTransitionGoalPosition = r12;
        this.mCurrentState = r14;
        this.mInterpolator = this.mStopLogic;
    L22:
        if (r11 != 1) goto L24;
        r12 = 0.0f;
    L26:
        this.mStopLogic.config(this.mTransitionLastPosition, r12, r13, r10, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
        int r15 = this.mCurrentState;
        this.mTransitionGoalPosition = r12;
        this.mCurrentState = r15;
        this.mInterpolator = this.mStopLogic;
        goto L27
    L24:
        if (r11 != 2) goto L26;
        r12 = 1.0f;
        goto L26
    }

    public void transitionToEnd() {
        animateTo(1.0f);
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int r5) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r5, -1, -1);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setEndState(r5);
    }

    public void updateState(int r5, ConstraintSet r10) {
        MotionScene r11 = this.mScene;
        if (r11 == null) goto L5;
        r11.setConstraintSet(r5, r10);
    L5:
        updateState();
        if (this.mCurrentState != r5) goto L9;
        r10.applyTo(this);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        if (this.mUndergoingMotion == true) goto L6;
        if (r10 != 0) goto L6;
        if (r11 != 0) goto L6;
    L7:
        this.mUndergoingMotion = false;
        return;
    L6:
        r15[0] = r15[0] + r12;
        r15[1] = r15[1] + r13;
        goto L7
    }

    public void transitionToState(int r12, int r13, int r14) {
        MotionScene r5 = this.mScene;
        if (r5 == null) goto L9;
        StateSet r10 = r5.mStateSet;
        if (r10 == null) goto L9;
        int r15 = r10.convertToConstraintSet(this.mCurrentState, r12, r13, r14);
        if (r15 == (-1)) goto L9;
        r12 = r15;
    L9:
        int r16 = this.mCurrentState;
        if (r16 != r12) goto L13;
        return;
    L13:
        if (this.mBeginState != r12) goto L17;
        animateTo(0.0f);
        return;
    L17:
        if (this.mEndState != r12) goto L20;
        animateTo(1.0f);
        return;
    L20:
        this.mEndState = r12;
        if (r16 == (-1)) goto L24;
        setTransition(r16, r12);
        animateTo(1.0f);
        this.mTransitionLastPosition = 0.0f;
        transitionToEnd();
        return;
    L24:
        int r17 = 0;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        this.mScene.getStartId();
        int r11 = getChildCount();
        this.mFrameArrayList.clear();
        int r18 = 0;
    L25:
        if (r18 >= r11) goto L27;
        View r19 = getChildAt(r18);
        this.mFrameArrayList.put(r19, new MotionController(r19));
        r18 = r18 + 1;
        goto L25
    L27:
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(r12));
        rebuildScene();
        this.mModel.build();
        computeCurrentPositions();
        int r110 = getWidth();
        int r111 = getHeight();
        int r112 = 0;
    L28:
        if (r112 >= r11) goto L30;
        MotionController r20 = this.mFrameArrayList.get(getChildAt(r112));
        this.mScene.getKeyFrames(r20);
        r20.setup(r110, r111, this.mTransitionDuration, getNanoTime());
        r112 = r112 + 1;
        goto L28
    L30:
        float r113 = this.mScene.getStaggered();
        if (r113 == 0.0f) goto L37;
        float r114 = Float.MAX_VALUE;
        float r21 = -3.4028235E38f;
        int r22 = 0;
    L33:
        if (r22 >= r11) goto L35;
        MotionController r23 = this.mFrameArrayList.get(getChildAt(r22));
        float r24 = r23.getFinalY() + r23.getFinalX();
        r114 = Math.min(r114, r24);
        r21 = Math.max(r21, r24);
        r22 = r22 + 1;
    L35:
        if (r17 >= r11) goto L37;
        MotionController r25 = this.mFrameArrayList.get(getChildAt(r17));
        float r26 = r25.getFinalX();
        float r27 = r25.getFinalY();
        r25.mStaggerScale = 1.0f / (1.0f - r113);
        r25.mStaggerOffset = r113 - ((((r26 + r27) - r114) * r113) / (r21 - r114));
        r17 = r17 + 1;
    L37:
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void setProgress(float r10) {
        if (r10 >= 0.0f) goto L5;
    L6:
        Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    L8:
        if (isAttachedToWindow() == false) goto L10;
        if (r10 > 0.0f) goto L19;
        this.mCurrentState = this.mBeginState;
        if (this.mTransitionLastPosition != 0.0f) goto L25;
        setState(TransitionState.FINISHED);
    L25:
        if (this.mScene != null) goto L27;
        return;
    L27:
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = r10;
        this.mTransitionPosition = r10;
        this.mTransitionLastTime = -1;
        this.mAnimationStartTime = -1;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
        return;
    L19:
        if (r10 < 1.0f) goto L23;
        this.mCurrentState = this.mEndState;
        if (this.mTransitionLastPosition != 1.0f) goto L25;
        setState(TransitionState.FINISHED);
        goto L25
    L23:
        this.mCurrentState = -1;
        setState(TransitionState.MOVING);
        goto L25
    L10:
        if (this.mStateCache != null) goto L12;
        this.mStateCache = new StateCache(this);
    L12:
        this.mStateCache.setProgress(r10);
        return;
    L5:
        if (r10 <= 1.0f) goto L8;
        goto L6
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int r5, int r10, int r11) {
        setState(TransitionState.SETUP);
        this.mCurrentState = r5;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates r12 = this.mConstraintLayoutSpec;
        if (r12 == null) goto L5;
        r12.updateConstraints(r5, r10, r11);
        return;
    L5:
        MotionScene r13 = this.mScene;
        if (r13 == null) goto L10;
        r13.getConstraintSet(r5).applyTo(this);
        return;
    }

    public void setTransition(int r10) {
        if (this.mScene == null) goto L27;
        MotionScene.Transition r11 = getTransition(r10);
        this.mBeginState = r11.getStartConstraintSetId();
        this.mEndState = r11.getEndConstraintSetId();
        if (isAttachedToWindow() == false) goto L7;
        int r5 = this.mCurrentState;
        float r12 = 0.0f;
        if (r5 != this.mBeginState) goto L15;
        float r13 = 0.0f;
    L18:
        this.mScene.setTransition(r11);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
        if (Float.isNaN(r13) == true) goto L22;
        r12 = r13;
    L22:
        this.mTransitionLastPosition = r12;
        if (Float.isNaN(r13) == false) goto L25;
        Log.v(TAG, Debug.getLocation() + " transitionToStart ");
        transitionToStart();
        return;
    L25:
        setProgress(r13);
        return;
    L15:
        if (r5 != this.mEndState) goto L17;
        r13 = 1.0f;
        goto L18
    L17:
        r13 = Float.NaN;
        goto L18
    L7:
        if (this.mStateCache != null) goto L9;
        this.mStateCache = new StateCache(this);
    L9:
        this.mStateCache.setStartState(this.mBeginState);
        this.mStateCache.setEndState(this.mEndState);
        return;
    }

    private void checkStructure(int r11, ConstraintSet r12) {
        String r13 = Debug.getName(getContext(), r11);
        int r5 = getChildCount();
        int r10 = 0;
        int r14 = 0;
    L4:
        if (r14 >= r5) goto L12;
        View r15 = getChildAt(r14);
        int r16 = r15.getId();
        if (r16 != (-1)) goto L9;
        StringBuilder r17 = j0.x("CHECK: ", r13, " ALL VIEWS SHOULD HAVE ID's ");
        r17.append(r15.getClass().getName());
        r17.append(" does not!");
        Log.w(TAG, r17.toString());
    L9:
        if (r12.getConstraint(r16) != null) goto L11;
        StringBuilder r18 = j0.x("CHECK: ", r13, " NO CONSTRAINTS for ");
        r18.append(Debug.getName(r15));
        Log.w(TAG, r18.toString());
    L11:
        r14 = r14 + 1;
        goto L4
    L12:
        int[] r19 = r12.getKnownIds();
    L14:
        if (r10 >= r19.length) goto L25;
        int r20 = r19[r10];
        String r21 = Debug.getName(getContext(), r20);
        if (findViewById(r19[r10]) != null) goto L19;
        Log.w(TAG, "CHECK: " + r13 + " NO View matches id " + r21);
    L19:
        if (r12.getHeight(r20) != (-1)) goto L22;
        Log.w(TAG, j0.l("CHECK: ", r13, "(", r21, ") no LAYOUT_HEIGHT"));
    L22:
        if (r12.getWidth(r20) != (-1)) goto L24;
        Log.w(TAG, j0.l("CHECK: ", r13, "(", r21, ") no LAYOUT_HEIGHT"));
    L24:
        r10 = r10 + 1;
        goto L14
    }

    public void setTransition(MotionScene.Transition r5) {
        this.mScene.setTransition(r5);
        setState(TransitionState.SETUP);
        if (this.mCurrentState != this.mScene.getEndId()) goto L5;
        this.mTransitionLastPosition = 1.0f;
        this.mTransitionPosition = 1.0f;
        this.mTransitionGoalPosition = 1.0f;
    L7:
        if (r5.isTransitionFlag(1) == false) goto L9;
        long r10 = -1;
    L10:
        this.mTransitionLastTime = r10;
        int r11 = this.mScene.getStartId();
        int r12 = this.mScene.getEndId();
        if (r11 == this.mBeginState) goto L13;
    L15:
        this.mBeginState = r11;
        this.mEndState = r12;
        this.mScene.setTransition(r11, r12);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
        return;
    L13:
        if (r12 != this.mEndState) goto L15;
        return;
    L9:
        r10 = getNanoTime();
        goto L10
    L5:
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        goto L7
    }

    public MotionLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        init(r10);
    }

    private void checkStructure(MotionScene.Transition r5) {
        Log.v(TAG, "CHECK: transition = " + r5.debugString(getContext()));
        Log.v(TAG, "CHECK: transition.setDuration = " + r5.getDuration());
        if (r5.getStartConstraintSetId() != r5.getEndConstraintSetId()) goto L6;
        Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        return;
    }

    public MotionLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        init(r10);
    }
}
