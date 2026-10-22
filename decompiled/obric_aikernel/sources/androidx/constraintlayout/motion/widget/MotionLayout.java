package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

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
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
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
    private ArrayList<MotionHelper> mDecoratorsHelpers;
    private boolean mDelayedApply;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    private boolean mInRotation;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    private Matrix mInverseMatrix;
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
    private Runnable mOnComplete;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    HashMap<View, ViewState> mPreRotate;
    private int mPreRotateHeight;
    private int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator;
    private View mRegionView;
    int mRotatMode;
    MotionScene mScene;
    private int[] mScheduledTransitionTo;
    int mScheduledTransitions;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic;
    Rect mTempRect;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private CopyOnWriteArrayList<TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = null;

        static {
            int[] r10 = new int[TransitionState.values().length];
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = r10;
            r10[TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    class DecelerateInterpolator extends MotionInterpolator {
        float currentP;
        float initalV;
        float maxA;
        final /* synthetic */ MotionLayout this$0;

        DecelerateInterpolator(MotionLayout r10) {
            this.this$0 = r10;
            this.initalV = 0.0f;
            this.currentP = 0.0f;
        }

        public void config(float r10, float r11, float r12) {
            this.initalV = r10;
            this.currentP = r11;
            this.maxA = r12;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = this.initalV;
            if (r11 <= 0.0f) goto L10;
            float r12 = this.maxA;
            if ((r11 / r12) >= r10) goto L7;
            r10 = r11 / r12;
        L7:
            float r13 = r11 - (r12 * r10);
            this.this$0.mLastVelocity = r13;
            float r14 = (r11 * r10) - (((r12 * r10) * r10) / 2.0f);
        L9:
            return r14 + this.currentP;
        L10:
            float r15 = this.maxA;
            if (((-r11) / r15) >= r10) goto L13;
            r10 = (-r11) / r15;
        L13:
            float r16 = (r15 * r10) + r11;
            this.this$0.mLastVelocity = r16;
            r14 = (r11 * r10) + (((r15 * r10) * r10) / 2.0f);
            goto L9
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return this.this$0.mLastVelocity;
        }
    }

    private class DevModeDraw {
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
            Paint r11 = new Paint();
            this.mPaint = r11;
            r11.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(Paint.Style.STROKE);
            Paint r12 = new Paint();
            this.mPaintKeyframes = r12;
            r12.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
            Paint r13 = new Paint();
            this.mPaintGraph = r13;
            r13.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(Paint.Style.STROKE);
            Paint r14 = new Paint();
            this.mTextPaint = r14;
            r14.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(r10.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint r15 = new Paint();
            this.mFillPaint = r15;
            r15.setAntiAlias(true);
            DashPathEffect r16 = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = r16;
            this.mPaintGraph.setPathEffect(r16);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode == false) goto L6;
            this.mPaint.setStrokeWidth(8.0f);
            this.mFillPaint.setStrokeWidth(8.0f);
            this.mPaintKeyframes.setStrokeWidth(8.0f);
            this.mShadowTranslate = 4;
            return;
        }

        private void drawBasicPath(Canvas r10) {
            r10.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas r10) {
            int r11 = 0;
            boolean r12 = false;
            boolean r13 = false;
        L4:
            if (r11 >= this.mKeyFrameCount) goto L12;
            int[] r14 = this.mPathMode;
            if (r14[r11] != 1) goto L9;
            r12 = true;
        L9:
            if (r14[r11] != 0) goto L11;
            r13 = true;
        L11:
            r11 = r11 + 1;
            goto L4
        L12:
            if (r12 == false) goto L14;
            drawPathRelative(r10);
        L14:
            if (r13 == false) goto L20;
            drawPathCartesian(r10);
            return;
        }

        private void drawPathCartesian(Canvas r19) {
            float[] r10 = this.mPoints;
            float r11 = r10[0];
            float r12 = r10[1];
            float r13 = r10[r10.length - 2];
            float r14 = r10[r10.length - 1];
            r19.drawLine(Math.min(r11, r13), Math.max(r12, r14), Math.max(r11, r13), Math.max(r12, r14), this.mPaintGraph);
            r19.drawLine(Math.min(r11, r13), Math.min(r12, r14), Math.min(r11, r13), Math.max(r12, r14), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas r19, float r20, float r21) {
            float[] r10 = this.mPoints;
            float r11 = r10[0];
            float r12 = r10[1];
            float r13 = r10[r10.length - 2];
            float r14 = r10[r10.length - 1];
            float r15 = Math.min(r11, r13);
            float r16 = Math.max(r12, r14);
            float r17 = r20 - Math.min(r11, r13);
            float r18 = Math.max(r12, r14) - r21;
            String r22 = "" + (((int) (((double) ((r17 * 100.0f) / Math.abs(r13 - r11))) + 0.5d)) / 100.0f);
            getTextBounds(r22, this.mTextPaint);
            r19.drawText(r22, ((r17 / 2.0f) - (this.mBounds.width() / 2)) + r15, r21 - 20.0f, this.mTextPaint);
            r19.drawLine(r20, r21, Math.min(r11, r13), r21, this.mPaintGraph);
            String r23 = "" + (((int) (((double) ((r18 * 100.0f) / Math.abs(r14 - r12))) + 0.5d)) / 100.0f);
            getTextBounds(r23, this.mTextPaint);
            r19.drawText(r23, r20 + 5.0f, r16 - ((r18 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            r19.drawLine(r20, r21, r20, Math.max(r12, r14), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas r10) {
            float[] r11 = this.mPoints;
            r10.drawLine(r11[0], r11[1], r11[r11.length - 2], r11[r11.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas r13, float r14, float r15) {
            float[] r10 = this.mPoints;
            float r11 = r10[0];
            float r12 = r10[1];
            float r16 = r10[r10.length - 2];
            float r17 = r10[r10.length - 1];
            float r18 = (float) Math.hypot(r11 - r16, r12 - r17);
            float r19 = r16 - r11;
            float r20 = r17 - r12;
            float r21 = (((r14 - r11) * r19) + ((r15 - r12) * r20)) / (r18 * r18);
            float r22 = r11 + (r19 * r21);
            float r110 = r12 + (r21 * r20);
            Path r23 = new Path();
            r23.moveTo(r14, r15);
            r23.lineTo(r22, r110);
            float r24 = (float) Math.hypot(r22 - r14, r110 - r15);
            String r25 = "" + (((int) ((r24 * 100.0f) / r18)) / 100.0f);
            getTextBounds(r25, this.mTextPaint);
            r13.drawTextOnPath(r25, r23, (r24 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            r13.drawLine(r14, r15, r22, r110, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas r16, float r17, float r18, int r19, int r20) {
            String r10 = "" + (((int) (((double) (((r17 - (r19 / 2)) * 100.0f) / (this.this$0.getWidth() - r19))) + 0.5d)) / 100.0f);
            getTextBounds(r10, this.mTextPaint);
            r16.drawText(r10, ((r17 / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, r18 - 20.0f, this.mTextPaint);
            r16.drawLine(r17, r18, Math.min(0.0f, 1.0f), r18, this.mPaintGraph);
            String r11 = "" + (((int) (((double) (((r18 - (r20 / 2)) * 100.0f) / (this.this$0.getHeight() - r20))) + 0.5d)) / 100.0f);
            getTextBounds(r11, this.mTextPaint);
            r16.drawText(r11, r17 + 5.0f, 0.0f - ((r18 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            r16.drawLine(r17, r18, r17, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas r10, MotionController r11) {
            this.mPath.reset();
            int r12 = 0;
        L4:
            if (r12 > 50) goto L6;
            r11.buildRect(r12 / 50, this.mRectangle, 0);
            Path r13 = this.mPath;
            float[] r14 = this.mRectangle;
            r13.moveTo(r14[0], r14[1]);
            Path r15 = this.mPath;
            float[] r16 = this.mRectangle;
            r15.lineTo(r16[2], r16[3]);
            Path r17 = this.mPath;
            float[] r18 = this.mRectangle;
            r17.lineTo(r18[4], r18[5]);
            Path r19 = this.mPath;
            float[] r20 = this.mRectangle;
            r19.lineTo(r20[6], r20[7]);
            this.mPath.close();
            r12 = r12 + 1;
            goto L4
        L6:
            this.mPaint.setColor(1140850688);
            r10.translate(2.0f, 2.0f);
            r10.drawPath(this.mPath, this.mPaint);
            r10.translate(-2.0f, -2.0f);
            this.mPaint.setColor(-65536);
            r10.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas r20, int r21, int r22, MotionController r23) {
            View r10 = r23.mView;
            if (r10 == null) goto L5;
            int r11 = r10.getWidth();
            int r12 = r23.mView.getHeight();
        L6:
            int r14 = 1;
        L8:
            if (r14 >= (r22 - 1)) goto L38;
            if (r21 == 4) goto L12;
        L14:
            float[] r13 = this.mKeyFramePoints;
            int r15 = r14 * 2;
            float r16 = r13[r15];
            float r17 = r13[r15 + 1];
            this.mPath.reset();
            this.mPath.moveTo(r16, r17 + 10.0f);
            this.mPath.lineTo(r16 + 10.0f, r17);
            this.mPath.lineTo(r16, r17 - 10.0f);
            this.mPath.lineTo(r16 - 10.0f, r17);
            this.mPath.close();
            int r18 = r14 - 1;
            r23.getKeyFrame(r18);
            if (r21 != 4) goto L27;
            int[] r19 = this.mPathMode;
            if (r19[r18] != 1) goto L21;
            drawPathRelativeTicks(r20, r16 - 0.0f, r17 - 0.0f);
        L26:
            r20.drawPath(this.mPath, this.mFillPaint);
        L28:
            if (r21 != 2) goto L31;
            drawPathRelativeTicks(r20, r16 - 0.0f, r17 - 0.0f);
        L31:
            if (r21 != 3) goto L34;
            drawPathCartesianTicks(r20, r16 - 0.0f, r17 - 0.0f);
        L34:
            if (r21 != 6) goto L36;
            drawPathScreenTicks(r20, r16 - 0.0f, r17 - 0.0f, r11, r12);
        L36:
            r20.drawPath(this.mPath, this.mFillPaint);
        L37:
            r14 = r14 + 1;
            goto L8
        L21:
            if (r19[r18] != 0) goto L24;
            drawPathCartesianTicks(r20, r16 - 0.0f, r17 - 0.0f);
            goto L26
        L24:
            if (r19[r18] != 2) goto L26;
            drawPathScreenTicks(r20, r16 - 0.0f, r17 - 0.0f, r11, r12);
            goto L26
        L27:
            r17 = r17;
            r16 = r16;
            goto L28
        L12:
            if (this.mPathMode[r14 - 1] != 0) goto L14;
        L38:
            float[] r24 = this.mPoints;
            if (r24.length <= 1) goto L45;
            r20.drawCircle(r24[0], r24[1], 8.0f, this.mPaintKeyframes);
            float[] r25 = this.mPoints;
            r20.drawCircle(r25[r25.length - 2], r25[r25.length - 1], 8.0f, this.mPaintKeyframes);
            return;
        L45:
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
            MotionController r15 = r14.next();
            int r16 = r15.getDrawPath();
            if (r13 <= 0) goto L18;
            if (r16 != 0) goto L18;
            r16 = 1;
        L18:
            if (r16 == 0) goto L13;
            this.mKeyFrameCount = r15.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
            if (r16 < 1) goto L13;
            int r17 = r12 / 16;
            float[] r18 = this.mPoints;
            if (r18 != null) goto L25;
        L26:
            this.mPoints = new float[r17 * 2];
            this.mPath = new Path();
        L27:
            int r19 = this.mShadowTranslate;
            r10.translate(r19, r19);
            this.mPaint.setColor(1996488704);
            this.mFillPaint.setColor(1996488704);
            this.mPaintKeyframes.setColor(1996488704);
            this.mPaintGraph.setColor(1996488704);
            r15.buildPath(this.mPoints, r17);
            drawAll(r10, r16, this.mKeyFrameCount, r15);
            this.mPaint.setColor(-21965);
            this.mPaintKeyframes.setColor(-2067046);
            this.mFillPaint.setColor(-2067046);
            this.mPaintGraph.setColor(-13391360);
            int r20 = this.mShadowTranslate;
            r10.translate(-r20, -r20);
            drawAll(r10, r16, this.mKeyFrameCount, r15);
            if (r16 != 5) goto L13;
            drawRectangle(r10, r15);
            goto L13
        L25:
            if (r18.length == (r17 * 2)) goto L27;
        L30:
            r10.restore();
            return;
        L9:
            if ((r13 & 1) != 2) goto L11;
            String r21 = this.this$0.getContext().getResources().getResourceName(MotionLayout.access$100(this.this$0)) + ":" + this.this$0.getProgress();
            r10.drawText(r21, 10.0f, this.this$0.getHeight() - 30, this.mTextPaint);
            r10.drawText(r21, 11.0f, this.this$0.getHeight() - 29, this.mPaint);
            goto L11
        }

        public void drawAll(Canvas r10, int r11, int r12, MotionController r13) {
            if (r11 != 4) goto L6;
            drawPathAsConfigured(r10);
        L6:
            if (r11 != 2) goto L9;
            drawPathRelative(r10);
        L9:
            if (r11 != 3) goto L11;
            drawPathCartesian(r10);
        L11:
            drawBasicPath(r10);
            drawTicks(r10, r11, r12, r13);
        }

        void getTextBounds(String r10, Paint r11) {
            r11.getTextBounds(r10, 0, r10.length(), this.mBounds);
        }
    }

    class Model {
        ConstraintSet mEnd;
        int mEndId;
        ConstraintWidgetContainer mLayoutEnd;
        ConstraintWidgetContainer mLayoutStart;
        ConstraintSet mStart;
        int mStartId;
        final /* synthetic */ MotionLayout this$0;

        Model(MotionLayout r10) {
            this.this$0 = r10;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mStart = null;
            this.mEnd = null;
        }

        private void computeStartEndSize(int r10, int r11) {
            int r12 = this.this$0.getOptimizationLevel();
            MotionLayout r13 = this.this$0;
            if (r13.mCurrentState != r13.getStartState()) goto L26;
            MotionLayout r14 = this.this$0;
            ConstraintWidgetContainer r15 = this.mLayoutEnd;
            ConstraintSet r16 = this.mEnd;
            if (r16 != null) goto L7;
        L10:
            int r17 = r10;
        L11:
            if (r16 != null) goto L13;
        L16:
            int r18 = r11;
        L17:
            MotionLayout.access$1600(r14, r15, r12, r17, r18);
            ConstraintSet r19 = this.mStart;
            if (r19 == null) goto L49;
            MotionLayout r20 = this.this$0;
            ConstraintWidgetContainer r21 = this.mLayoutStart;
            int r22 = r19.mRotate;
            if (r22 != 0) goto L22;
            int r23 = r10;
        L23:
            if (r22 != 0) goto L25;
            r10 = r11;
        L25:
            MotionLayout.access$1700(r20, r21, r12, r23, r10);
            return;
        L22:
            r23 = r11;
            goto L23
        L49:
            return;
        L13:
            if (r16.mRotate == 0) goto L16;
            r18 = r10;
            goto L17
        L7:
            if (r16.mRotate == 0) goto L10;
            r17 = r11;
            goto L11
        L26:
            ConstraintSet r24 = this.mStart;
            if (r24 == null) goto L36;
            MotionLayout r25 = this.this$0;
            ConstraintWidgetContainer r26 = this.mLayoutStart;
            int r27 = r24.mRotate;
            if (r27 != 0) goto L31;
            int r28 = r10;
        L32:
            if (r27 != 0) goto L34;
            int r29 = r11;
        L35:
            MotionLayout.access$1800(r25, r26, r12, r28, r29);
            goto L36
        L34:
            r29 = r10;
            goto L35
        L31:
            r28 = r11;
        L36:
            MotionLayout r30 = this.this$0;
            ConstraintWidgetContainer r31 = this.mLayoutEnd;
            ConstraintSet r32 = this.mEnd;
            if (r32 != null) goto L39;
        L42:
            int r33 = r10;
        L43:
            if (r32 != null) goto L45;
        L46:
            r10 = r11;
        L47:
            MotionLayout.access$1900(r30, r31, r12, r33, r10);
            return;
        L45:
            if (r32.mRotate != 0) goto L47;
        L39:
            if (r32.mRotate == 0) goto L42;
            r33 = r11;
            goto L43
        }

        @SuppressLint({"LogConditional"})
        private void debugLayout(String r10, ConstraintWidgetContainer r11) {
            String r12 = r10 + " " + Debug.getName((View) r11.getCompanionWidget());
            Log.v(MotionLayout.TAG, r12 + "  ========= " + r11);
            int r13 = r11.getChildren().size();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L23;
            String r15 = r12 + "[" + r14 + "] ";
            ConstraintWidget r16 = r11.getChildren().get(r14);
            StringBuilder r17 = new StringBuilder();
            r17.append("");
            String r18 = "_";
            if (r16.mTop.mTarget == null) goto L7;
            String r19 = "T";
        L8:
            r17.append(r19);
            String r20 = r17.toString();
            StringBuilder r21 = new StringBuilder();
            r21.append(r20);
            if (r16.mBottom.mTarget == null) goto L11;
            String r22 = "B";
        L12:
            r21.append(r22);
            String r23 = r21.toString();
            StringBuilder r24 = new StringBuilder();
            r24.append(r23);
            if (r16.mLeft.mTarget == null) goto L15;
            String r25 = "L";
        L16:
            r24.append(r25);
            String r26 = r24.toString();
            StringBuilder r27 = new StringBuilder();
            r27.append(r26);
            if (r16.mRight.mTarget == null) goto L19;
            r18 = "R";
        L19:
            r27.append(r18);
            String r28 = r27.toString();
            View r29 = (View) r16.getCompanionWidget();
            String r30 = Debug.getName(r29);
            if ((r29 instanceof TextView) == false) goto L22;
            r30 = r30 + "(" + ((TextView) r29).getText() + ")";
        L22:
            Log.v(MotionLayout.TAG, r15 + "  " + r30 + " " + r16 + " " + r28);
            r14 = r14 + 1;
            goto L3
        L15:
            r25 = "_";
            goto L16
        L11:
            r22 = "_";
            goto L12
        L7:
            r19 = "_";
            goto L8
        L23:
            Log.v(MotionLayout.TAG, r12 + " done. ");
        }

        @SuppressLint({"LogConditional"})
        private void debugLayoutParam(String r10, ConstraintLayout.LayoutParams r11) {
            StringBuilder r12 = new StringBuilder();
            r12.append(" ");
            if (r11.startToStart == (-1)) goto L5;
            String r13 = "SS";
        L6:
            r12.append(r13);
            String r14 = r12.toString();
            StringBuilder r15 = new StringBuilder();
            r15.append(r14);
            String r16 = "|__";
            if (r11.startToEnd == (-1)) goto L9;
            String r17 = "|SE";
        L10:
            r15.append(r17);
            String r18 = r15.toString();
            StringBuilder r19 = new StringBuilder();
            r19.append(r18);
            if (r11.endToStart == (-1)) goto L13;
            String r20 = "|ES";
        L14:
            r19.append(r20);
            String r21 = r19.toString();
            StringBuilder r22 = new StringBuilder();
            r22.append(r21);
            if (r11.endToEnd == (-1)) goto L17;
            String r23 = "|EE";
        L18:
            r22.append(r23);
            String r24 = r22.toString();
            StringBuilder r25 = new StringBuilder();
            r25.append(r24);
            if (r11.leftToLeft == (-1)) goto L21;
            String r26 = "|LL";
        L22:
            r25.append(r26);
            String r27 = r25.toString();
            StringBuilder r28 = new StringBuilder();
            r28.append(r27);
            if (r11.leftToRight == (-1)) goto L25;
            String r29 = "|LR";
        L26:
            r28.append(r29);
            String r30 = r28.toString();
            StringBuilder r31 = new StringBuilder();
            r31.append(r30);
            if (r11.rightToLeft == (-1)) goto L29;
            String r32 = "|RL";
        L30:
            r31.append(r32);
            String r33 = r31.toString();
            StringBuilder r34 = new StringBuilder();
            r34.append(r33);
            if (r11.rightToRight == (-1)) goto L33;
            String r35 = "|RR";
        L34:
            r34.append(r35);
            String r36 = r34.toString();
            StringBuilder r37 = new StringBuilder();
            r37.append(r36);
            if (r11.topToTop == (-1)) goto L37;
            String r38 = "|TT";
        L38:
            r37.append(r38);
            String r39 = r37.toString();
            StringBuilder r40 = new StringBuilder();
            r40.append(r39);
            if (r11.topToBottom == (-1)) goto L41;
            String r41 = "|TB";
        L42:
            r40.append(r41);
            String r42 = r40.toString();
            StringBuilder r43 = new StringBuilder();
            r43.append(r42);
            if (r11.bottomToTop == (-1)) goto L45;
            String r44 = "|BT";
        L46:
            r43.append(r44);
            String r45 = r43.toString();
            StringBuilder r46 = new StringBuilder();
            r46.append(r45);
            if (r11.bottomToBottom == (-1)) goto L49;
            r16 = "|BB";
        L49:
            r46.append(r16);
            Log.v(MotionLayout.TAG, r10 + r46.toString());
            return;
        L45:
            r44 = "|__";
            goto L46
        L41:
            r41 = "|__";
            goto L42
        L37:
            r38 = "|__";
            goto L38
        L33:
            r35 = "|__";
            goto L34
        L29:
            r32 = "|__";
            goto L30
        L25:
            r29 = "|__";
            goto L26
        L21:
            r26 = "|__";
            goto L22
        L17:
            r23 = "|__";
            goto L18
        L13:
            r20 = "|__";
            goto L14
        L9:
            r17 = "|__";
            goto L10
        L5:
            r13 = "__";
            goto L6
        }

        @SuppressLint({"LogConditional"})
        private void debugWidget(String r10, ConstraintWidget r11) {
            StringBuilder r12 = new StringBuilder();
            r12.append(" ");
            String r13 = "B";
            String r14 = "__";
            if (r11.mTop.mTarget == null) goto L9;
            StringBuilder r15 = new StringBuilder();
            r15.append("T");
            if (r11.mTop.mTarget.mType != ConstraintAnchor.Type.TOP) goto L7;
            String r16 = "T";
        L8:
            r15.append(r16);
            String r17 = r15.toString();
        L10:
            r12.append(r17);
            String r18 = r12.toString();
            StringBuilder r19 = new StringBuilder();
            r19.append(r18);
            if (r11.mBottom.mTarget == null) goto L16;
            StringBuilder r20 = new StringBuilder();
            r20.append("B");
            if (r11.mBottom.mTarget.mType != ConstraintAnchor.Type.TOP) goto L15;
            r13 = "T";
        L15:
            r20.append(r13);
            String r21 = r20.toString();
        L17:
            r19.append(r21);
            String r22 = r19.toString();
            StringBuilder r23 = new StringBuilder();
            r23.append(r22);
            String r24 = "R";
            if (r11.mLeft.mTarget == null) goto L24;
            StringBuilder r25 = new StringBuilder();
            r25.append("L");
            if (r11.mLeft.mTarget.mType != ConstraintAnchor.Type.LEFT) goto L22;
            String r26 = "L";
        L23:
            r25.append(r26);
            String r27 = r25.toString();
        L25:
            r23.append(r27);
            String r28 = r23.toString();
            StringBuilder r29 = new StringBuilder();
            r29.append(r28);
            if (r11.mRight.mTarget == null) goto L31;
            StringBuilder r30 = new StringBuilder();
            r30.append("R");
            if (r11.mRight.mTarget.mType != ConstraintAnchor.Type.LEFT) goto L30;
            r24 = "L";
        L30:
            r30.append(r24);
            r14 = r30.toString();
        L31:
            r29.append(r14);
            Log.v(MotionLayout.TAG, r10 + r29.toString() + " ---  " + r11);
            return;
        L22:
            r26 = "R";
            goto L23
        L24:
            r27 = "__";
            goto L25
        L16:
            r21 = "__";
            goto L17
        L7:
            r16 = "B";
            goto L8
        L9:
            r17 = "__";
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(ConstraintWidgetContainer r14, ConstraintSet r15) {
            SparseArray<ConstraintWidget> r10 = new SparseArray();
            Constraints.LayoutParams r11 = new Constraints.LayoutParams(-2, -2);
            r10.clear();
            r10.put(0, r14);
            r10.put(this.this$0.getId(), r14);
            if (r15 != null) goto L5;
        L7:
            Iterator<ConstraintWidget> r12 = r14.getChildren().iterator();
        L9:
            if (r12.hasNext() == false) goto L11;
            ConstraintWidget r13 = r12.next();
            r13.setAnimated(true);
            r10.put(((View) r13.getCompanionWidget()).getId(), r13);
            goto L9
        L11:
            Iterator<ConstraintWidget> r16 = r14.getChildren().iterator();
        L13:
            if (r16.hasNext() == false) goto L28;
            ConstraintWidget r17 = r16.next();
            View r18 = (View) r17.getCompanionWidget();
            r15.applyToLayoutParams(r18.getId(), r11);
            r17.setWidth(r15.getWidth(r18.getId()));
            r17.setHeight(r15.getHeight(r18.getId()));
            if ((r18 instanceof ConstraintHelper) == false) goto L20;
            r15.applyToHelper((ConstraintHelper) r18, r17, r11, r10);
            if ((r18 instanceof Barrier) == false) goto L20;
            ((Barrier) r18).validateParams();
        L20:
            if (Build.VERSION.SDK_INT < 17) goto L22;
            r11.resolveLayoutDirection(this.this$0.getLayoutDirection());
        L23:
            MotionLayout.access$1100(this.this$0, false, r18, r17, r11, r10);
            if (r15.getVisibilityMode(r18.getId()) != 1) goto L26;
            int r19 = r18.getVisibility();
        L27:
            r17.setVisibility(r19);
            goto L13
        L26:
            r19 = r15.getVisibility(r18.getId());
            goto L27
        L22:
            r11.resolveLayoutDirection(0);
            goto L23
        L28:
            Iterator<ConstraintWidget> r110 = r14.getChildren().iterator();
        L30:
            if (r110.hasNext() == false) goto L34;
            ConstraintWidget r111 = r110.next();
            if ((r111 instanceof VirtualLayout) == false) goto L30;
            ConstraintHelper r20 = (ConstraintHelper) r111.getCompanionWidget();
            Helper r112 = (Helper) r111;
            r20.updatePreLayout(r14, r112, r10);
            ((VirtualLayout) r112).captureWidgets();
            goto L30
        L34:
            return;
        L5:
            if (r15.mRotate == 0) goto L7;
            MotionLayout r21 = this.this$0;
            MotionLayout.access$1000(r21, this.mLayoutEnd, r21.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(this.this$0.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.this$0.getWidth(), 1073741824));
            goto L7
        }

        public void build() {
            int r10 = this.this$0.getChildCount();
            this.this$0.mFrameArrayList.clear();
            SparseArray r11 = new SparseArray();
            int[] r12 = new int[r10];
            int r13 = 0;
        L3:
            if (r13 >= r10) goto L5;
            View r14 = this.this$0.getChildAt(r13);
            MotionController r15 = new MotionController(r14);
            int r16 = r14.getId();
            r12[r13] = r16;
            r11.put(r16, r15);
            this.this$0.mFrameArrayList.put(r14, r15);
            r13 = r13 + 1;
            goto L3
        L5:
            int r17 = 0;
        L6:
            if (r17 >= r10) goto L31;
            View r18 = this.this$0.getChildAt(r17);
            MotionController r19 = this.this$0.mFrameArrayList.get(r18);
            if (r19 != null) goto L11;
            r11 = r11;
        L30:
            r17 = r17 + 1;
            r11 = r11;
            goto L6
        L11:
            if (this.mStart == null) goto L19;
            ConstraintWidget r20 = getWidget(this.mLayoutStart, r18);
            if (r20 == null) goto L16;
            r19.setStartState(MotionLayout.access$2000(this.this$0, r20), this.mStart, this.this$0.getWidth(), this.this$0.getHeight());
        L23:
            if (this.mEnd == null) goto L30;
            ConstraintWidget r21 = getWidget(this.mLayoutEnd, r18);
            if (r21 == null) goto L28;
            r19.setEndState(MotionLayout.access$2000(this.this$0, r21), this.mEnd, this.this$0.getWidth(), this.this$0.getHeight());
            goto L30
        L28:
            if (this.this$0.mDebugPath == 0) goto L30;
            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(r18) + " (" + r18.getClass().getName() + ")");
            goto L30
        L16:
            if (this.this$0.mDebugPath == 0) goto L23;
            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(r18) + " (" + r18.getClass().getName() + ")");
            goto L23
        L19:
            if (MotionLayout.access$300(this.this$0) == false) goto L23;
            ViewState r22 = this.this$0.mPreRotate.get(r18);
            MotionLayout r23 = this.this$0;
            r19.setStartState(r22, r18, r23.mRotatMode, MotionLayout.access$2100(r23), MotionLayout.access$2200(this.this$0));
            goto L23
        L31:
            SparseArray r110 = r11;
            int r24 = 0;
        L32:
            if (r24 >= r10) goto L37;
            SparseArray r25 = r110;
            MotionController r26 = (MotionController) r25.get(r12[r24]);
            int r27 = r26.getAnimateRelativeTo();
            if (r27 == (-1)) goto L36;
            r26.setupRelative((MotionController) r25.get(r27));
        L36:
            r24 = r24 + 1;
            r110 = r25;
            goto L32
        }

        void copy(ConstraintWidgetContainer r10, ConstraintWidgetContainer r11) {
            ArrayList<ConstraintWidget> r12 = r10.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> r13 = new HashMap();
            r13.put(r10, r11);
            r11.getChildren().clear();
            r11.copy(r10, r13);
            Iterator<ConstraintWidget> r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L22;
            ConstraintWidget r15 = r14.next();
            if ((r15 instanceof androidx.constraintlayout.core.widgets.Barrier) == false) goto L9;
            ConstraintWidget r16 = new androidx.constraintlayout.core.widgets.Barrier();
        L21:
            r11.add(r16);
            r13.put(r15, r16);
            goto L4
        L9:
            if ((r15 instanceof Guideline) == false) goto L12;
            r16 = new Guideline();
            goto L21
        L12:
            if ((r15 instanceof Flow) == false) goto L15;
            r16 = new Flow();
            goto L21
        L15:
            if ((r15 instanceof Placeholder) == false) goto L18;
            r16 = new Placeholder();
            goto L21
        L18:
            if ((r15 instanceof Helper) == false) goto L20;
            r16 = new HelperWidget();
            goto L21
        L20:
            r16 = new ConstraintWidget();
            goto L21
        L22:
            Iterator<ConstraintWidget> r17 = r12.iterator();
        L24:
            if (r17.hasNext() == false) goto L26;
            ConstraintWidget r18 = r17.next();
            r13.get(r18).copy(r18, r13);
            goto L24
        }

        ConstraintWidget getWidget(ConstraintWidgetContainer r10, View r11) {
            if (r10.getCompanionWidget() != r11) goto L5;
            return r10;
        L5:
            ArrayList<ConstraintWidget> r12 = r10.getChildren();
            int r13 = r12.size();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L11;
            ConstraintWidget r15 = r12.get(r14);
            if (r15.getCompanionWidget() == r11) goto L9;
            r14 = r14 + 1;
            goto L6
        L9:
            return r15;
        L11:
            return null;
        }

        void initFrom(ConstraintWidgetContainer r10, ConstraintSet r11, ConstraintSet r12) {
            this.mStart = r11;
            this.mEnd = r12;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.access$400(this.this$0).getMeasurer());
            this.mLayoutEnd.setMeasurer(MotionLayout.access$500(this.this$0).getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(MotionLayout.access$600(this.this$0), this.mLayoutStart);
            copy(MotionLayout.access$700(this.this$0), this.mLayoutEnd);
            if (this.this$0.mTransitionLastPosition <= 0.5d) goto L7;
            if (r11 == null) goto L6;
            setupConstraintWidget(this.mLayoutStart, r11);
        L6:
            setupConstraintWidget(this.mLayoutEnd, r12);
        L10:
            this.mLayoutStart.setRtl(MotionLayout.access$800(this.this$0));
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.access$900(this.this$0));
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams r13 = this.this$0.getLayoutParams();
            if (r13 != null) goto L13;
            return;
        L13:
            if (r13.width != (-2)) goto L16;
            ConstraintWidgetContainer r14 = this.mLayoutStart;
            ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r14.setHorizontalDimensionBehaviour(r15);
            this.mLayoutEnd.setHorizontalDimensionBehaviour(r15);
        L16:
            if (r13.height != (-2)) goto L20;
            ConstraintWidgetContainer r16 = this.mLayoutStart;
            ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r16.setVerticalDimensionBehaviour(r17);
            this.mLayoutEnd.setVerticalDimensionBehaviour(r17);
            return;
        L20:
            return;
        L7:
            setupConstraintWidget(this.mLayoutEnd, r12);
            if (r11 == null) goto L10;
            setupConstraintWidget(this.mLayoutStart, r11);
            goto L10
        }

        public boolean isNotConfiguredWith(int r10, int r11) {
            if (r10 == this.mStartId) goto L5;
        L8:
            return true;
        L5:
            if (r11 != this.mEndId) goto L8;
            return false;
        }

        public void measure(int r16, int r17) {
            int r10 = View.MeasureSpec.getMode(r16);
            int r11 = View.MeasureSpec.getMode(r17);
            MotionLayout r12 = this.this$0;
            r12.mWidthMeasureMode = r10;
            r12.mHeightMeasureMode = r11;
            r12.getOptimizationLevel();
            computeStartEndSize(r16, r17);
            if ((this.this$0.getParent() instanceof MotionLayout) == true) goto L5;
        L8:
            boolean r13 = true;
        L9:
            if (r13 == false) goto L18;
            computeStartEndSize(r16, r17);
            this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
            this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
            this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
            this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
            MotionLayout r14 = this.this$0;
            if (r14.mStartWrapWidth == r14.mEndWrapWidth) goto L13;
        L16:
            boolean r15 = true;
        L17:
            r14.mMeasureDuringTransition = r15;
            goto L18
        L13:
            if (r14.mStartWrapHeight != r14.mEndWrapHeight) goto L16;
            r15 = false;
        L18:
            MotionLayout r18 = this.this$0;
            int r19 = r18.mStartWrapWidth;
            int r20 = r18.mStartWrapHeight;
            int r21 = r18.mWidthMeasureMode;
            if (r21 == Integer.MIN_VALUE) goto L21;
            if (r21 == 0) goto L21;
        L22:
            int r110 = r19;
            int r22 = r18.mHeightMeasureMode;
            if (r22 == Integer.MIN_VALUE) goto L25;
            if (r22 == 0) goto L25;
        L26:
            int r111 = r20;
            if (this.mLayoutStart.isWidthMeasuredTooSmall() == false) goto L29;
        L32:
            boolean r112 = true;
        L34:
            if (this.mLayoutStart.isHeightMeasuredTooSmall() == false) goto L36;
        L39:
            boolean r113 = true;
        L40:
            MotionLayout.access$1500(this.this$0, r16, r17, r110, r111, r112, r113);
            return;
        L36:
            if (this.mLayoutEnd.isHeightMeasuredTooSmall() == true) goto L39;
            r113 = false;
            goto L40
        L29:
            if (this.mLayoutEnd.isWidthMeasuredTooSmall() == true) goto L32;
            r112 = false;
        L25:
            r20 = (int) (r20 + (r18.mPostInterpolationPosition * (r18.mEndWrapHeight - r20)));
        L21:
            r19 = (int) (r19 + (r18.mPostInterpolationPosition * (r18.mEndWrapWidth - r19)));
            goto L22
        L5:
            if (r10 != 1073741824) goto L8;
            if (r11 != 1073741824) goto L8;
            r13 = false;
            goto L9
        }

        public void reEvaluateState() {
            measure(MotionLayout.access$1200(this.this$0), MotionLayout.access$1300(this.this$0));
            MotionLayout.access$1400(this.this$0);
        }

        public void setMeasuredId(int r10, int r11) {
            this.mStartId = r10;
            this.mEndId = r11;
        }
    }

    protected interface MotionTracker {
        void addMovement(MotionEvent r10);

        void clear();

        void computeCurrentVelocity(int r10);

        void computeCurrentVelocity(int r10, float r11);

        float getXVelocity();

        float getXVelocity(int r10);

        float getYVelocity();

        float getYVelocity(int r10);

        void recycle();
    }

    private static class MyTracker implements MotionTracker {
        private static MyTracker me;
        VelocityTracker tracker;

        static {
            me = new MyTracker();
        }

        private MyTracker() {
        }

        public static MyTracker obtain() {
            MyTracker r10 = me;
            r10.tracker = VelocityTracker.obtain();
            return me;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent r10) {
            VelocityTracker r11 = this.tracker;
            if (r11 == null) goto L6;
            r11.addMovement(r10);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker r10 = this.tracker;
            if (r10 == null) goto L6;
            r10.clear();
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r10) {
            VelocityTracker r11 = this.tracker;
            if (r11 == null) goto L6;
            r11.computeCurrentVelocity(r10);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r10, float r11) {
            VelocityTracker r12 = this.tracker;
            if (r12 == null) goto L6;
            r12.computeCurrentVelocity(r10, r11);
            return;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker r10 = this.tracker;
            if (r10 != null) goto L5;
            return 0.0f;
        L5:
            return r10.getXVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int r10) {
            VelocityTracker r11 = this.tracker;
            if (r11 != null) goto L5;
            return 0.0f;
        L5:
            return r11.getXVelocity(r10);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker r10 = this.tracker;
            if (r10 != null) goto L5;
            return 0.0f;
        L5:
            return r10.getYVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int r10) {
            if (this.tracker != null) goto L5;
            return 0.0f;
        L5:
            return getYVelocity(r10);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker r10 = this.tracker;
            if (r10 == null) goto L6;
            r10.recycle();
            this.tracker = null;
            return;
        }
    }

    class StateCache {
        final String KeyEndState;
        final String KeyProgress;
        final String KeyStartState;
        final String KeyVelocity;
        int endState;
        float mProgress;
        float mVelocity;
        int startState;
        final /* synthetic */ MotionLayout this$0;

        StateCache(MotionLayout r10) {
            this.this$0 = r10;
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
            this.KeyProgress = "motion.progress";
            this.KeyVelocity = "motion.velocity";
            this.KeyStartState = "motion.StartState";
            this.KeyEndState = "motion.EndState";
        }

        void apply() {
            int r10 = this.startState;
            if (r10 == (-1)) goto L5;
        L6:
            if (r10 != (-1)) goto L8;
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
            int r11 = this.endState;
            if (r11 != (-1)) goto L11;
            this.this$0.setState(r10, -1, -1);
            goto L12
        L11:
            this.this$0.setTransition(r10, r11);
            goto L12
        L5:
            if (this.endState == (-1)) goto L14;
            goto L6
        }

        public Bundle getTransitionState() {
            Bundle r10 = new Bundle();
            r10.putFloat("motion.progress", this.mProgress);
            r10.putFloat("motion.velocity", this.mVelocity);
            r10.putInt("motion.StartState", this.startState);
            r10.putInt("motion.EndState", this.endState);
            return r10;
        }

        public void recordState() {
            this.endState = MotionLayout.access$100(this.this$0);
            this.startState = MotionLayout.access$200(this.this$0);
            this.mVelocity = this.this$0.getVelocity();
            this.mProgress = this.this$0.getProgress();
        }

        public void setEndState(int r10) {
            this.endState = r10;
        }

        public void setProgress(float r10) {
            this.mProgress = r10;
        }

        public void setStartState(int r10) {
            this.startState = r10;
        }

        public void setTransitionState(Bundle r10) {
            this.mProgress = r10.getFloat("motion.progress");
            this.mVelocity = r10.getFloat("motion.velocity");
            this.startState = r10.getInt("motion.StartState");
            this.endState = r10.getInt("motion.EndState");
        }

        public void setVelocity(float r10) {
            this.mVelocity = r10;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout r10, int r11, int r12, float r13);

        void onTransitionCompleted(MotionLayout r10, int r11);

        void onTransitionStarted(MotionLayout r10, int r11, int r12);

        void onTransitionTrigger(MotionLayout r10, int r11, boolean r12, float r13);
    }

    static final enum TransitionState extends Enum<TransitionState> {
        private static final /* synthetic */ TransitionState[] $VALUES = null;
        public static final TransitionState FINISHED = null;
        public static final TransitionState MOVING = null;
        public static final TransitionState SETUP = null;
        public static final TransitionState UNDEFINED = null;

        private static /* synthetic */ TransitionState[] $values() {
            return new TransitionState[]{UNDEFINED, SETUP, MOVING, FINISHED};
        }

        static {
            UNDEFINED = new TransitionState("UNDEFINED", 0);
            SETUP = new TransitionState("SETUP", 1);
            MOVING = new TransitionState("MOVING", 2);
            FINISHED = new TransitionState("FINISHED", 3);
            $VALUES = $values();
        }

        private TransitionState(String r10, int r11) {
            super(r10, r11);
        }

        public static TransitionState valueOf(String r10) {
            return (TransitionState) Enum.valueOf(TransitionState.class, r10);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) $VALUES.clone();
        }
    }

    public MotionLayout(@NonNull Context r10) {
        super(r10);
        this.mProgressInterpolator = null;
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
        this.mDecoratorsHelpers = null;
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
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(null);
    }

    public MotionLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mProgressInterpolator = null;
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
        this.mDecoratorsHelpers = null;
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
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(r11);
    }

    public MotionLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mProgressInterpolator = null;
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
        this.mDecoratorsHelpers = null;
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
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(r11);
    }

    static /* synthetic */ StateCache access$000(MotionLayout r10) {
        return r10.mStateCache;
    }

    static /* synthetic */ int access$100(MotionLayout r10) {
        return r10.mEndState;
    }

    static /* synthetic */ void access$1000(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    static /* synthetic */ void access$1100(MotionLayout r10, boolean r11, View r12, ConstraintWidget r13, ConstraintLayout.LayoutParams r14, SparseArray r15) {
        r10.applyConstraintsFromLayoutParams(r11, r12, r13, r14, r15);
    }

    static /* synthetic */ int access$1200(MotionLayout r10) {
        return r10.mLastWidthMeasureSpec;
    }

    static /* synthetic */ int access$1300(MotionLayout r10) {
        return r10.mLastHeightMeasureSpec;
    }

    static /* synthetic */ void access$1400(MotionLayout r10) {
        r10.setupMotionViews();
    }

    static /* synthetic */ void access$1500(MotionLayout r10, int r11, int r12, int r13, int r14, boolean r15, boolean r16) {
        r10.resolveMeasuredDimension(r11, r12, r13, r14, r15, r16);
    }

    static /* synthetic */ void access$1600(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    static /* synthetic */ void access$1700(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    static /* synthetic */ void access$1800(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    static /* synthetic */ void access$1900(MotionLayout r10, ConstraintWidgetContainer r11, int r12, int r13, int r14) {
        r10.resolveSystem(r11, r12, r13, r14);
    }

    static /* synthetic */ int access$200(MotionLayout r10) {
        return r10.mBeginState;
    }

    static /* synthetic */ Rect access$2000(MotionLayout r10, ConstraintWidget r11) {
        return r10.toRect(r11);
    }

    static /* synthetic */ int access$2100(MotionLayout r10) {
        return r10.mPreRotateWidth;
    }

    static /* synthetic */ int access$2200(MotionLayout r10) {
        return r10.mPreRotateHeight;
    }

    static /* synthetic */ boolean access$300(MotionLayout r10) {
        return r10.mInRotation;
    }

    static /* synthetic */ boolean access$302(MotionLayout r10, boolean r11) {
        r10.mInRotation = r11;
        return r11;
    }

    static /* synthetic */ ConstraintWidgetContainer access$400(MotionLayout r10) {
        return r10.mLayoutWidget;
    }

    static /* synthetic */ ConstraintWidgetContainer access$500(MotionLayout r10) {
        return r10.mLayoutWidget;
    }

    static /* synthetic */ ConstraintWidgetContainer access$600(MotionLayout r10) {
        return r10.mLayoutWidget;
    }

    static /* synthetic */ ConstraintWidgetContainer access$700(MotionLayout r10) {
        return r10.mLayoutWidget;
    }

    static /* synthetic */ boolean access$800(MotionLayout r10) {
        return r10.isRtl();
    }

    static /* synthetic */ boolean access$900(MotionLayout r10) {
        return r10.isRtl();
    }

    private boolean callTransformedTouchEvent(View r10, MotionEvent r11, float r12, float r13) {
        Matrix r14 = r10.getMatrix();
        if (r14.isIdentity() == false) goto L6;
        r11.offsetLocation(r12, r13);
        boolean r15 = r10.onTouchEvent(r11);
        r11.offsetLocation(-r12, -r13);
        return r15;
    L6:
        MotionEvent r16 = MotionEvent.obtain(r11);
        r16.offsetLocation(r12, r13);
        if (this.mInverseMatrix != null) goto L9;
        this.mInverseMatrix = new Matrix();
    L9:
        r14.invert(this.mInverseMatrix);
        r16.transform(this.mInverseMatrix);
        boolean r17 = r10.onTouchEvent(r16);
        r16.recycle();
        return r17;
    }

    private void checkStructure() {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L6;
        Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
        return;
    L6:
        int r11 = r10.getStartId();
        MotionScene r12 = this.mScene;
        checkStructure(r11, r12.getConstraintSet(r12.getStartId()));
        SparseIntArray r13 = new SparseIntArray();
        SparseIntArray r14 = new SparseIntArray();
        Iterator<MotionScene.Transition> r15 = this.mScene.getDefinedTransitions().iterator();
    L8:
        if (r15.hasNext() == false) goto L24;
        MotionScene.Transition r16 = r15.next();
        if (r16 != this.mScene.mCurrentTransition) goto L12;
        Log.v(TAG, "CHECK: CURRENT");
    L12:
        checkStructure(r16);
        int r17 = r16.getStartConstraintSetId();
        int r18 = r16.getEndConstraintSetId();
        String r19 = Debug.getName(getContext(), r17);
        String r20 = Debug.getName(getContext(), r18);
        if (r13.get(r17) != r18) goto L16;
        Log.e(TAG, "CHECK: two transitions with the same start and end " + r19 + "->" + r20);
    L16:
        if (r14.get(r18) != r17) goto L18;
        Log.e(TAG, "CHECK: you can't have reverse transitions" + r19 + "->" + r20);
    L18:
        r13.put(r17, r18);
        r14.put(r18, r17);
        if (this.mScene.getConstraintSet(r17) != null) goto L22;
        Log.e(TAG, " no such constraintSetStart " + r19);
    L22:
        if (this.mScene.getConstraintSet(r18) != null) goto L8;
        Log.e(TAG, " no such constraintSetEnd " + r19);
        goto L8
    }

    private void checkStructure(int r11, ConstraintSet r12) {
        String r13 = Debug.getName(getContext(), r11);
        int r10 = getChildCount();
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= r10) goto L12;
        View r16 = getChildAt(r15);
        int r17 = r16.getId();
        if (r17 != (-1)) goto L9;
        Log.w(TAG, "CHECK: " + r13 + " ALL VIEWS SHOULD HAVE ID's " + r16.getClass().getName() + " does not!");
    L9:
        if (r12.getConstraint(r17) != null) goto L11;
        Log.w(TAG, "CHECK: " + r13 + " NO CONSTRAINTS for " + Debug.getName(r16));
    L11:
        r15 = r15 + 1;
        goto L4
    L12:
        int[] r18 = r12.getKnownIds();
    L14:
        if (r14 >= r18.length) goto L25;
        int r19 = r18[r14];
        String r20 = Debug.getName(getContext(), r19);
        if (findViewById(r18[r14]) != null) goto L19;
        Log.w(TAG, "CHECK: " + r13 + " NO View matches id " + r20);
    L19:
        if (r12.getHeight(r19) != (-1)) goto L22;
        Log.w(TAG, "CHECK: " + r13 + "(" + r20 + ") no LAYOUT_HEIGHT");
    L22:
        if (r12.getWidth(r19) != (-1)) goto L24;
        Log.w(TAG, "CHECK: " + r13 + "(" + r20 + ") no LAYOUT_HEIGHT");
    L24:
        r14 = r14 + 1;
        goto L14
    }

    private void checkStructure(MotionScene.Transition r10) {
        if (r10.getStartConstraintSetId() != r10.getEndConstraintSetId()) goto L6;
        Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        return;
    }

    private void computeCurrentPositions() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        View r12 = getChildAt(r11);
        MotionController r13 = this.mFrameArrayList.get(r12);
        if (r13 == null) goto L8;
        r13.setStartCurrentState(r12);
    L8:
        r11 = r11 + 1;
        goto L3
    }

    @SuppressLint({"LogConditional"})
    private void debugPos() {
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L6;
        View r11 = getChildAt(r10);
        Log.v(TAG, " " + Debug.getLocation() + " " + Debug.getName(this) + " " + Debug.getName(getContext(), this.mCurrentState) + " " + Debug.getName(r11) + r11.getLeft() + " " + r11.getTop());
        r10 = r10 + 1;
        goto L4
    }

    private void evaluateLayout() {
        float r10 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long r11 = getNanoTime();
        Interpolator r12 = this.mInterpolator;
        if ((r12 instanceof StopLogic) == true) goto L5;
        float r13 = (((r11 - this.mTransitionLastTime) * r10) * 1.0E-9f) / this.mTransitionDuration;
    L6:
        float r14 = this.mTransitionLastPosition + r13;
        if (this.mTransitionInstantly == false) goto L9;
        r14 = this.mTransitionGoalPosition;
    L9:
        int r15 = 0;
        if (r10 <= 0.0f) goto L14;
        if (r14 < this.mTransitionGoalPosition) goto L14;
    L17:
        r14 = this.mTransitionGoalPosition;
        boolean r16 = true;
    L19:
        if (r12 == null) goto L25;
        if (r16 == true) goto L25;
        if (this.mTemporalInterpolator == false) goto L24;
        r14 = r12.getInterpolation((r11 - this.mAnimationStartTime) * 1.0E-9f);
        goto L25
    L24:
        r14 = r12.getInterpolation(r14);
    L25:
        if (r10 <= 0.0f) goto L29;
        if (r14 < this.mTransitionGoalPosition) goto L29;
    L32:
        r14 = this.mTransitionGoalPosition;
    L33:
        this.mPostInterpolationPosition = r14;
        int r17 = getChildCount();
        long r18 = getNanoTime();
        Interpolator r19 = this.mProgressInterpolator;
        if (r19 == null) goto L37;
        r14 = r19.getInterpolation(r14);
    L37:
        if (r15 >= r17) goto L43;
        View r20 = getChildAt(r15);
        MotionController r21 = this.mFrameArrayList.get(r20);
        if (r21 == null) goto L41;
        r21.interpolate(r20, r14, r18, this.mKeyCache);
    L41:
        r15 = r15 + 1;
        goto L37
    L43:
        if (this.mMeasureDuringTransition == false) goto L50;
        requestLayout();
        return;
    L50:
        return;
    L29:
        if (r10 > 0.0f) goto L33;
        if (r14 > this.mTransitionGoalPosition) goto L33;
    L14:
        if (r10 <= 0.0f) goto L16;
    L18:
        r16 = false;
        goto L19
    L16:
        if (r14 > this.mTransitionGoalPosition) goto L18;
    L5:
        r13 = 0.0f;
        goto L6
    }

    private void fireTransitionChange() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<TransitionListener> r10 = this.mTransitionListeners;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.mListenerPosition != this.mTransitionPosition) goto L11;
        return;
    L11:
        if (this.mListenerState == (-1)) goto L22;
        TransitionListener r11 = this.mTransitionListener;
        if (r11 == null) goto L15;
        r11.onTransitionStarted(this, this.mBeginState, this.mEndState);
    L15:
        CopyOnWriteArrayList<TransitionListener> r12 = this.mTransitionListeners;
        if (r12 == null) goto L21;
        Iterator<TransitionListener> r13 = r12.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r13.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
    L21:
        this.mIsAnimating = true;
    L22:
        this.mListenerState = -1;
        float r14 = this.mTransitionPosition;
        this.mListenerPosition = r14;
        TransitionListener r15 = this.mTransitionListener;
        if (r15 == null) goto L25;
        r15.onTransitionChange(this, this.mBeginState, this.mEndState, r14);
    L25:
        CopyOnWriteArrayList<TransitionListener> r16 = this.mTransitionListeners;
        if (r16 == null) goto L31;
        Iterator<TransitionListener> r17 = r16.iterator();
    L29:
        if (r17.hasNext() == false) goto L31;
        r17.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
    L31:
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted(MotionLayout r10, int r11, int r12) {
        TransitionListener r13 = this.mTransitionListener;
        if (r13 == null) goto L5;
        r13.onTransitionStarted(this, r11, r12);
    L5:
        CopyOnWriteArrayList<TransitionListener> r14 = this.mTransitionListeners;
        if (r14 == null) goto L11;
        Iterator<TransitionListener> r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L13;
        r15.next().onTransitionStarted(r10, r11, r12);
        goto L9
    L13:
        return;
    }

    private boolean handlesTouchEvent(float r10, float r11, View r12, MotionEvent r13) {
        if ((r12 instanceof ViewGroup) == false) goto L10;
        ViewGroup r14 = (ViewGroup) r12;
        int r15 = r14.getChildCount() - 1;
    L5:
        if (r15 < 0) goto L10;
        View r16 = r14.getChildAt(r15);
        if (handlesTouchEvent((r16.getLeft() + r10) - r12.getScrollX(), (r16.getTop() + r11) - r12.getScrollY(), r16, r13) == true) goto L8;
        r15 = r15 - 1;
        goto L5
    L8:
        boolean r17 = true;
    L11:
        if (r17 == true) goto L20;
        this.mBoundsCheck.set(r10, r11, (r12.getRight() + r10) - r12.getLeft(), (r12.getBottom() + r11) - r12.getTop());
        if (r13.getAction() != 0) goto L17;
        if (this.mBoundsCheck.contains(r13.getX(), r13.getY()) == false) goto L20;
    L17:
        if (callTransformedTouchEvent(r12, r13, -r10, -r11) == false) goto L20;
        return true;
    L20:
        return r17;
    L10:
        r17 = false;
        goto L11
    }

    private void init(AttributeSet r10) {
        IS_IN_EDIT_MODE = isInEditMode();
        if (r10 == null) goto L37;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.MotionLayout);
        int r12 = r11.getIndexCount();
        boolean r13 = true;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L31;
        int r15 = r11.getIndex(r14);
        if (r15 != R.styleable.MotionLayout_layoutDescription) goto L10;
        this.mScene = new MotionScene(getContext(), this, r11.getResourceId(r15, -1));
    L30:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R.styleable.MotionLayout_currentState) goto L13;
        this.mCurrentState = r11.getResourceId(r15, -1);
        goto L30
    L13:
        if (r15 != R.styleable.MotionLayout_motionProgress) goto L16;
        this.mTransitionGoalPosition = r11.getFloat(r15, 0.0f);
        this.mInTransition = true;
        goto L30
    L16:
        if (r15 != R.styleable.MotionLayout_applyMotionScene) goto L19;
        r13 = r11.getBoolean(r15, r13);
        goto L30
    L19:
        if (r15 != R.styleable.MotionLayout_showPaths) goto L27;
        if (this.mDebugPath != 0) goto L30;
        if (r11.getBoolean(r15, false) == false) goto L25;
        int r16 = 2;
    L29:
        this.mDebugPath = r16;
        goto L30
    L25:
        r16 = 0;
        goto L29
    L27:
        if (r15 != R.styleable.MotionLayout_motionDebug) goto L30;
        r16 = r11.getInt(r15, 0);
        goto L29
    L31:
        r11.recycle();
        if (this.mScene != null) goto L34;
        Log.e(TAG, "WARNING NO app:layoutDescription tag");
    L34:
        if (r13 == true) goto L37;
        this.mScene = null;
    L37:
        if (this.mDebugPath == 0) goto L40;
        checkStructure();
    L40:
        if (this.mCurrentState != (-1)) goto L53;
        MotionScene r17 = this.mScene;
        if (r17 == null) goto L54;
        this.mCurrentState = r17.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
        return;
    L54:
        return;
    }

    private void processTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<TransitionListener> r10 = this.mTransitionListeners;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == false) goto L9;
        return;
    L9:
        this.mIsAnimating = false;
        Iterator<Integer> r11 = this.mTransitionCompleted.iterator();
    L11:
        if (r11.hasNext() == false) goto L21;
        Integer r12 = r11.next();
        TransitionListener r13 = this.mTransitionListener;
        if (r13 == null) goto L15;
        r13.onTransitionCompleted(this, r12.intValue());
    L15:
        CopyOnWriteArrayList<TransitionListener> r14 = this.mTransitionListeners;
        if (r14 == null) goto L11;
        Iterator<TransitionListener> r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L11;
        r15.next().onTransitionCompleted(this, r12.intValue());
        goto L19
    L21:
        this.mTransitionCompleted.clear();
    }

    private void setupMotionViews() {
        int r10 = getChildCount();
        this.mModel.build();
        boolean r11 = true;
        this.mInTransition = true;
        SparseArray r12 = new SparseArray();
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L5;
        View r15 = getChildAt(r14);
        r12.put(r15.getId(), this.mFrameArrayList.get(r15));
        r14 = r14 + 1;
        goto L3
    L5:
        int r16 = getWidth();
        int r17 = getHeight();
        int r18 = this.mScene.gatPathMotionArc();
        if (r18 == (-1)) goto L13;
        int r19 = 0;
    L8:
        if (r19 >= r10) goto L13;
        MotionController r20 = this.mFrameArrayList.get(getChildAt(r19));
        if (r20 == null) goto L12;
        r20.setPathMotionArc(r18);
    L12:
        r19 = r19 + 1;
    L13:
        SparseBooleanArray r110 = new SparseBooleanArray();
        int[] r111 = new int[this.mFrameArrayList.size()];
        int r21 = 0;
        int r112 = 0;
    L14:
        if (r21 >= r10) goto L20;
        MotionController r22 = this.mFrameArrayList.get(getChildAt(r21));
        if (r22.getAnimateRelativeTo() == (-1)) goto L18;
        r110.put(r22.getAnimateRelativeTo(), true);
        r111[r112] = r22.getAnimateRelativeTo();
        r112 = r112 + 1;
    L18:
        r21 = r21 + 1;
        goto L14
    L20:
        if (this.mDecoratorsHelpers == null) goto L39;
        int r23 = 0;
    L22:
        if (r23 >= r112) goto L28;
        MotionController r24 = this.mFrameArrayList.get(findViewById(r111[r23]));
        if (r24 == null) goto L27;
        this.mScene.getKeyFrames(r24);
    L27:
        r23 = r23 + 1;
        goto L22
    L28:
        Iterator<MotionHelper> r25 = this.mDecoratorsHelpers.iterator();
    L30:
        if (r25.hasNext() == false) goto L32;
        r25.next().onPreSetup(this, this.mFrameArrayList);
        goto L30
    L32:
        int r113 = 0;
    L33:
        if (r113 >= r112) goto L46;
        MotionController r26 = this.mFrameArrayList.get(findViewById(r111[r113]));
        if (r26 == null) goto L38;
        r26.setup(r16, r17, this.mTransitionDuration, getNanoTime());
    L38:
        r113 = r113 + 1;
    L46:
        int r114 = 0;
    L47:
        if (r114 >= r10) goto L54;
        View r27 = getChildAt(r114);
        MotionController r28 = this.mFrameArrayList.get(r27);
        if (r110.get(r27.getId()) == true) goto L53;
        if (r28 == null) goto L53;
        this.mScene.getKeyFrames(r28);
        r28.setup(r16, r17, this.mTransitionDuration, getNanoTime());
    L53:
        r114 = r114 + 1;
        goto L47
    L54:
        float r29 = this.mScene.getStaggered();
        if (r29 != 0.0f) goto L57;
        return;
    L57:
        if (r29 >= 0.0d) goto L59;
        boolean r30 = true;
    L60:
        float r31 = Math.abs(r29);
        float r32 = -3.4028235E38f;
        float r33 = Float.MAX_VALUE;
        int r34 = 0;
        float r35 = -3.4028235E38f;
        float r36 = Float.MAX_VALUE;
    L61:
        if (r34 >= r10) goto L70;
        MotionController r115 = this.mFrameArrayList.get(getChildAt(r34));
        if (Float.isNaN(r115.mMotionStagger) == false) goto L72;
        float r116 = r115.getFinalX();
        float r117 = r115.getFinalY();
        if (r30 == false) goto L68;
        float r118 = r117 - r116;
    L69:
        r36 = Math.min(r36, r118);
        r35 = Math.max(r35, r118);
        r34 = r34 + 1;
        goto L61
    L68:
        r118 = r117 + r116;
    L72:
        if (r11 == false) goto L88;
        int r37 = 0;
    L74:
        if (r37 >= r10) goto L79;
        MotionController r38 = this.mFrameArrayList.get(getChildAt(r37));
        if (Float.isNaN(r38.mMotionStagger) == true) goto L78;
        r33 = Math.min(r33, r38.mMotionStagger);
        r32 = Math.max(r32, r38.mMotionStagger);
    L78:
        r37 = r37 + 1;
    L79:
        if (r13 >= r10) goto L129;
        MotionController r39 = this.mFrameArrayList.get(getChildAt(r13));
        if (Float.isNaN(r39.mMotionStagger) == true) goto L87;
        r39.mStaggerScale = 1.0f / (1.0f - r31);
        float r40 = r39.mMotionStagger;
        if (r30 == false) goto L85;
        float r41 = ((r32 - r40) / (r32 - r33)) * r31;
    L86:
        r39.mStaggerOffset = r31 - r41;
        goto L87
    L85:
        r41 = ((r40 - r33) * r31) / (r32 - r33);
    L87:
        r13 = r13 + 1;
        goto L79
    L129:
        return;
    L88:
        if (r13 >= r10) goto L130;
        MotionController r42 = this.mFrameArrayList.get(getChildAt(r13));
        float r43 = r42.getFinalX();
        float r44 = r42.getFinalY();
        if (r30 == false) goto L92;
        float r45 = r44 - r43;
    L93:
        r42.mStaggerScale = 1.0f / (1.0f - r31);
        r42.mStaggerOffset = r31 - (((r45 - r36) * r31) / (r35 - r36));
        r13 = r13 + 1;
        goto L88
    L92:
        r45 = r44 + r43;
        goto L93
    L130:
        return;
    L70:
        r11 = false;
        goto L72
    L59:
        r30 = false;
        goto L60
    L39:
        int r119 = 0;
    L40:
        if (r119 >= r112) goto L46;
        MotionController r46 = this.mFrameArrayList.get(findViewById(r111[r119]));
        if (r46 == null) goto L45;
        this.mScene.getKeyFrames(r46);
        r46.setup(r16, r17, this.mTransitionDuration, getNanoTime());
    L45:
        r119 = r119 + 1;
        goto L40
    }

    private Rect toRect(ConstraintWidget r10) {
        Rect r11 = this.mTempRect;
        r11.top = r10.getY();
        Rect r12 = this.mTempRect;
        r12.left = r10.getX();
        Rect r13 = this.mTempRect;
        int r14 = r10.getWidth();
        Rect r15 = this.mTempRect;
        r13.right = r14 + r15.left;
        int r16 = r10.getHeight();
        Rect r17 = this.mTempRect;
        r15.bottom = r16 + r17.top;
        return r17;
    }

    private static boolean willJump(float r10, float r11, float r12) {
        if (r10 <= 0.0f) goto L9;
        float r13 = r10 / r12;
        if ((r11 + ((r10 * r13) - (((r12 * r13) * r13) / 2.0f))) <= 1.0f) goto L8;
        return true;
    L8:
        return false;
    L9:
        float r14 = (-r10) / r12;
        if ((r11 + ((r10 * r14) + (((r12 * r14) * r14) / 2.0f))) >= 0.0f) goto L13;
        return true;
    L13:
        return false;
    }

    public void addTransitionListener(TransitionListener r10) {
        if (this.mTransitionListeners != null) goto L5;
        this.mTransitionListeners = new CopyOnWriteArrayList();
    L5:
        this.mTransitionListeners.add(r10);
    }

    void animateTo(float r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L5;
        return;
    L5:
        float r12 = this.mTransitionLastPosition;
        float r13 = this.mTransitionPosition;
        if (r12 != r13) goto L8;
    L10:
        float r14 = this.mTransitionLastPosition;
        if (r14 != r10) goto L13;
        return;
    L13:
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = r10;
        this.mTransitionDuration = r11.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = null;
        this.mProgressInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = r14;
        this.mTransitionLastPosition = r14;
        invalidate();
        return;
    L8:
        if (this.mTransitionInstantly == false) goto L10;
        this.mTransitionLastPosition = r13;
        goto L10
    }

    public boolean applyViewTransition(int r10, MotionController r11) {
        MotionScene r12 = this.mScene;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.applyViewTransition(r10, r11);
    }

    public ConstraintSet cloneConstraintSet(int r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L6;
        return null;
    L6:
        ConstraintSet r12 = r11.getConstraintSet(r10);
        ConstraintSet r13 = new ConstraintSet();
        r13.clone(r12);
        return r13;
    }

    void disableAutoTransition(boolean r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.disableAutoTransition(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r10) {
        ArrayList<MotionHelper> r11 = this.mDecoratorsHelpers;
        if (r11 == null) goto L8;
        Iterator<MotionHelper> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().onPreDraw(r10);
    L8:
        evaluate(false);
        MotionScene r13 = this.mScene;
        if (r13 == null) goto L13;
        ViewTransitionController r14 = r13.mViewTransitionController;
        if (r14 == null) goto L13;
        r14.animate();
    L13:
        super.dispatchDraw(r10);
        if (this.mScene != null) goto L17;
        return;
    L17:
        if ((this.mDebugPath & 1) != 1) goto L32;
        if (isInEditMode() == true) goto L32;
        this.mFrames++;
        long r15 = getNanoTime();
        long r16 = this.mLastDrawTime;
        if (r16 == (-1)) goto L25;
        long r17 = r15 - r16;
        if (r17 <= 200000000) goto L26;
        this.mLastFps = ((int) ((this.mFrames / (r17 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.mFrames = 0;
    L26:
        Paint r18 = new Paint();
        r18.setTextSize(42.0f);
        float r19 = ((int) (getProgress() * 1000.0f)) / 10.0f;
        String r20 = this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ";
        StringBuilder r21 = new StringBuilder();
        r21.append(r20);
        r21.append(Debug.getState(this, this.mEndState));
        r21.append(" (progress: ");
        r21.append(r19);
        r21.append(" ) state=");
        int r22 = this.mCurrentState;
        if (r22 != (-1)) goto L29;
        String r23 = "undefined";
    L30:
        r21.append(r23);
        String r24 = r21.toString();
        r18.setColor(ViewCompat.MEASURED_STATE_MASK);
        r10.drawText(r24, 11.0f, getHeight() - 29, r18);
        r18.setColor(-7864184);
        r10.drawText(r24, 10.0f, getHeight() - 30, r18);
        goto L32
    L29:
        r23 = Debug.getState(this, r22);
    L25:
        this.mLastDrawTime = r15;
    L32:
        if (this.mDebugPath > 1) goto L34;
    L37:
        ArrayList<MotionHelper> r25 = this.mDecoratorsHelpers;
        if (r25 == null) goto L43;
        Iterator<MotionHelper> r26 = r25.iterator();
    L41:
        if (r26.hasNext() == false) goto L46;
        r26.next().onPostDraw(r10);
        goto L41
    L46:
        return;
    L43:
        return;
    L34:
        if (this.mDevModeDraw != null) goto L36;
        this.mDevModeDraw = new DevModeDraw(this);
    L36:
        this.mDevModeDraw.draw(r10, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        goto L37
    }

    public void enableTransition(int r10, boolean r11) {
        MotionScene.Transition r12 = getTransition(r10);
        if (r11 == false) goto L7;
        boolean r13 = true;
    L5:
        r12.setEnabled(r13);
        return;
    L7:
        MotionScene r14 = this.mScene;
        if (r12 != r14.mCurrentTransition) goto L15;
        Iterator<MotionScene.Transition> r15 = r14.getTransitionsWithState(this.mCurrentState).iterator();
    L11:
        if (r15.hasNext() == false) goto L15;
        MotionScene.Transition r16 = r15.next();
        if (r16.isEnabled() == false) goto L11;
        this.mScene.mCurrentTransition = r16;
    L15:
        r13 = false;
        goto L5
    }

    public void enableViewTransition(int r10, boolean r11) {
        MotionScene r12 = this.mScene;
        if (r12 == null) goto L6;
        r12.enableViewTransition(r10, r11);
        return;
    }

    void endTrigger(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = getChildAt(r12);
        MotionController r14 = this.mFrameArrayList.get(r13);
        if (r14 == null) goto L7;
        r14.endTrigger(r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    void evaluate(boolean r24) {
        if (this.mTransitionLastTime != (-1)) goto L5;
        this.mTransitionLastTime = getNanoTime();
    L5:
        float r10 = this.mTransitionLastPosition;
        if (r10 > 0.0f) goto L8;
    L10:
        boolean r11 = true;
        boolean r12 = false;
        if (this.mKeepAnimating == false) goto L13;
    L17:
        float r13 = Math.signum(this.mTransitionGoalPosition - r10);
        long r14 = getNanoTime();
        Interpolator r15 = this.mInterpolator;
        if ((r15 instanceof MotionInterpolator) == true) goto L20;
        float r16 = (((r14 - this.mTransitionLastTime) * r13) * 1.0E-9f) / this.mTransitionDuration;
    L21:
        float r17 = this.mTransitionLastPosition + r16;
        if (this.mTransitionInstantly == false) goto L25;
        r17 = this.mTransitionGoalPosition;
    L25:
        if (r13 <= 0.0f) goto L29;
        if (r17 < this.mTransitionGoalPosition) goto L29;
    L32:
        r17 = this.mTransitionGoalPosition;
        this.mInTransition = false;
        boolean r18 = true;
    L34:
        this.mTransitionLastPosition = r17;
        this.mTransitionPosition = r17;
        this.mTransitionLastTime = r14;
        if (r15 == null) goto L68;
        if (r18 == true) goto L68;
        if (this.mTemporalInterpolator == false) goto L63;
        float r19 = r15.getInterpolation((r14 - this.mAnimationStartTime) * 1.0E-9f);
        Interpolator r20 = this.mInterpolator;
        StopLogic r21 = this.mStopLogic;
        if (r20 == r21) goto L42;
        char r22 = 0;
    L46:
        this.mTransitionLastPosition = r19;
        this.mTransitionLastTime = r14;
        Interpolator r23 = this.mInterpolator;
        if ((r23 instanceof MotionInterpolator) == false) goto L62;
        float r25 = ((MotionInterpolator) r23).getVelocity();
        this.mLastVelocity = r25;
        if ((Math.abs(r25) * this.mTransitionDuration) > EPSILON) goto L53;
        if (r22 != 2) goto L53;
        this.mInTransition = false;
    L53:
        if (r25 <= 0.0f) goto L58;
        if (r19 < 1.0f) goto L58;
        this.mTransitionLastPosition = 1.0f;
        this.mInTransition = false;
        r19 = 1.0f;
    L58:
        if (r25 >= 0.0f) goto L62;
        if (r19 > 0.0f) goto L62;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = false;
        r17 = 0.0f;
    L71:
        if (Math.abs(this.mLastVelocity) <= EPSILON) goto L73;
        setState(TransitionState.MOVING);
    L73:
        if (r22 == 1) goto L87;
        if (r13 <= 0.0f) goto L78;
        if (r17 < this.mTransitionGoalPosition) goto L78;
    L81:
        r17 = this.mTransitionGoalPosition;
        this.mInTransition = false;
    L83:
        if (r17 < 1.0f) goto L85;
    L86:
        this.mInTransition = false;
        setState(TransitionState.FINISHED);
        goto L87
    L85:
        if (r17 > 0.0f) goto L87;
    L78:
        if (r13 > 0.0f) goto L83;
        if (r17 > this.mTransitionGoalPosition) goto L83;
    L87:
        int r26 = getChildCount();
        this.mKeepAnimating = false;
        long r27 = getNanoTime();
        this.mPostInterpolationPosition = r17;
        Interpolator r28 = this.mProgressInterpolator;
        if (r28 != null) goto L90;
        float r29 = r17;
    L91:
        Interpolator r30 = this.mProgressInterpolator;
        if (r30 == null) goto L94;
        float r31 = r30.getInterpolation((r13 / this.mTransitionDuration) + r17);
        this.mLastVelocity = r31;
        this.mLastVelocity = r31 - this.mProgressInterpolator.getInterpolation(r17);
    L94:
        int r32 = 0;
    L95:
        if (r32 >= r26) goto L100;
        View r110 = getChildAt(r32);
        MotionController r111 = this.mFrameArrayList.get(r110);
        if (r111 == null) goto L99;
        this.mKeepAnimating = r111.interpolate(r110, r29, r27, this.mKeyCache) | this.mKeepAnimating;
    L99:
        r32 = r32 + 1;
        goto L95
    L100:
        if (r13 <= 0.0f) goto L104;
        if (r17 < this.mTransitionGoalPosition) goto L104;
    L107:
        boolean r33 = true;
    L110:
        if (this.mKeepAnimating == true) goto L116;
        if (this.mInTransition == true) goto L116;
        if (r33 == false) goto L116;
        setState(TransitionState.FINISHED);
    L116:
        if (this.mMeasureDuringTransition == false) goto L118;
        requestLayout();
    L118:
        this.mKeepAnimating = (!r33) | this.mKeepAnimating;
        if (r17 > 0.0f) goto L126;
        int r34 = this.mBeginState;
        if (r34 == (-1)) goto L126;
        if (this.mCurrentState == r34) goto L126;
        this.mCurrentState = r34;
        this.mScene.getConstraintSet(r34).applyCustomAttributes(this);
        setState(TransitionState.FINISHED);
        r12 = true;
    L126:
        if (r17 < 1.0d) goto L131;
        int r35 = this.mCurrentState;
        int r36 = this.mEndState;
        if (r35 == r36) goto L131;
        this.mCurrentState = r36;
        this.mScene.getConstraintSet(r36).applyCustomAttributes(this);
        setState(TransitionState.FINISHED);
        r12 = true;
    L131:
        if (this.mKeepAnimating == false) goto L133;
    L143:
        invalidate();
    L145:
        if (this.mKeepAnimating == false) goto L147;
    L156:
        float r37 = this.mTransitionLastPosition;
        if (r37 < 1.0f) goto L164;
        int r38 = this.mCurrentState;
        int r39 = this.mEndState;
        if (r38 != r39) goto L162;
    L161:
        r11 = r12;
    L162:
        this.mCurrentState = r39;
        r12 = r11;
    L168:
        this.mNeedsFireTransitionCompleted |= r12;
        if (r12 == true) goto L171;
    L173:
        this.mTransitionPosition = this.mTransitionLastPosition;
        return;
    L171:
        if (this.mInLayout == true) goto L173;
        requestLayout();
        goto L173
    L164:
        if (r37 > 0.0f) goto L168;
        int r40 = this.mCurrentState;
        r39 = this.mBeginState;
        if (r40 == r39) goto L161;
    L147:
        if (this.mInTransition == true) goto L156;
        if (r13 <= 0.0f) goto L152;
        if (r17 != 1.0f) goto L152;
    L155:
        onNewStateAttachHandlers();
    L152:
        if (r13 >= 0.0f) goto L156;
        if (r17 != 0.0f) goto L156;
    L133:
        if (this.mInTransition == true) goto L143;
        if (r13 <= 0.0f) goto L139;
        if (r17 != 1.0f) goto L139;
    L142:
        setState(TransitionState.FINISHED);
    L139:
        if (r13 >= 0.0f) goto L145;
        if (r17 != 0.0f) goto L145;
    L104:
        if (r13 <= 0.0f) goto L106;
    L108:
        r33 = false;
        goto L110
    L106:
        if (r17 > this.mTransitionGoalPosition) goto L108;
    L90:
        r29 = r28.getInterpolation(r17);
    L62:
        r17 = r19;
        goto L71
    L42:
        if (r21.isStopped() == false) goto L44;
        r22 = 2;
        goto L46
    L44:
        r22 = 1;
        goto L46
    L63:
        float r41 = r15.getInterpolation(r17);
        Interpolator r42 = this.mInterpolator;
        if ((r42 instanceof MotionInterpolator) == false) goto L66;
        float r43 = ((MotionInterpolator) r42).getVelocity();
    L67:
        this.mLastVelocity = r43;
        r17 = r41;
    L69:
        r22 = 0;
        goto L71
    L66:
        r43 = ((r42.getInterpolation(r17 + r16) - r41) * r13) / r16;
    L68:
        this.mLastVelocity = r16;
    L29:
        if (r13 <= 0.0f) goto L31;
    L33:
        r18 = false;
        goto L34
    L31:
        if (r17 > this.mTransitionGoalPosition) goto L33;
    L20:
        r16 = 0.0f;
        goto L21
    L13:
        if (this.mInTransition == false) goto L156;
        if (r24 == true) goto L17;
        if (this.mTransitionGoalPosition == r10) goto L156;
    L8:
        if (r10 >= 1.0f) goto L10;
        this.mCurrentState = -1;
        goto L10
    }

    protected void fireTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<TransitionListener> r10 = this.mTransitionListeners;
        if (r10 != null) goto L7;
    L18:
        processTransitionCompleted();
        Runnable r11 = this.mOnComplete;
        if (r11 == null) goto L21;
        r11.run();
    L21:
        int[] r12 = this.mScheduledTransitionTo;
        if (r12 != null) goto L24;
        return;
    L24:
        if (this.mScheduledTransitions <= 0) goto L28;
        transitionToState(r12[0]);
        int[] r13 = this.mScheduledTransitionTo;
        System.arraycopy(r13, 1, r13, 0, r13.length - 1);
        this.mScheduledTransitions--;
        return;
    L28:
        return;
    L7:
        if (r10.isEmpty() == true) goto L18;
    L9:
        if (this.mListenerState != (-1)) goto L18;
        this.mListenerState = this.mCurrentState;
        if (this.mTransitionCompleted.isEmpty() == true) goto L13;
        ArrayList<Integer> r14 = this.mTransitionCompleted;
        int r15 = r14.get(r14.size() - 1).intValue();
    L14:
        int r16 = this.mCurrentState;
        if (r15 == r16) goto L18;
        if (r16 == (-1)) goto L18;
        this.mTransitionCompleted.add(Integer.valueOf(r16));
        goto L18
    L13:
        r15 = -1;
        goto L14
    }

    public void fireTrigger(int r10, boolean r11, float r12) {
        TransitionListener r13 = this.mTransitionListener;
        if (r13 == null) goto L5;
        r13.onTransitionTrigger(this, r10, r11, r12);
    L5:
        CopyOnWriteArrayList<TransitionListener> r14 = this.mTransitionListeners;
        if (r14 == null) goto L11;
        Iterator<TransitionListener> r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L13;
        r15.next().onTransitionTrigger(this, r10, r11, r12);
        goto L9
    L13:
        return;
    }

    void getAnchorDpDt(int r10, float r11, float r12, float r13, float[] r14) {
        HashMap<View, MotionController> r15 = this.mFrameArrayList;
        View r16 = getViewById(r10);
        MotionController r17 = r15.get(r16);
        if (r17 == null) goto L5;
        r17.getDpDt(r11, r12, r13, r14);
        float r18 = r16.getY();
        this.lastPos = r11;
        this.lastY = r18;
        return;
    L5:
        if (r16 != null) goto L7;
        String r19 = "" + r10;
    L8:
        Log.w(TAG, "WARNING could not find view id " + r19);
        return;
    L7:
        r19 = r16.getContext().getResources().getResourceName(r10);
        goto L8
    }

    public ConstraintSet getConstraintSet(int r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getConstraintSet(r10);
    }

    public int[] getConstraintSetIds() {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getConstraintSetIds();
    }

    String getConstraintSetNames(int r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.lookUpConstraintName(r10);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 2;
    L5:
        this.mDebugPath = r11;
        invalidate();
        return;
    L4:
        r11 = 1;
        goto L5
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getDefinedTransitions();
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

    MotionController getMotionController(int r10) {
        return this.mFrameArrayList.get(findViewById(r10));
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int r10) {
        return this.mScene.getTransitionById(r10);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new StateCache(this);
    L5:
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene r10 = this.mScene;
        if (r10 == null) goto L6;
        this.mTransitionDuration = r10.getDuration() / 1000.0f;
    L6:
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View r10, float r11, float r12, float[] r13, int r14) {
        float r15 = this.mLastVelocity;
        float r16 = this.mTransitionLastPosition;
        if (this.mInterpolator == null) goto L5;
        float r17 = Math.signum(this.mTransitionGoalPosition - r16);
        float r18 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
        float r19 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
        r15 = (r17 * ((r18 - r19) / EPSILON)) / this.mTransitionDuration;
        float r20 = r19;
    L6:
        Interpolator r21 = this.mInterpolator;
        if ((r21 instanceof MotionInterpolator) == false) goto L9;
        r15 = ((MotionInterpolator) r21).getVelocity();
    L9:
        MotionController r22 = this.mFrameArrayList.get(r10);
        if ((r14 & 1) != 0) goto L12;
        r22.getPostLayoutDvDp(r20, r10.getWidth(), r10.getHeight(), r11, r12, r13);
    L14:
        if (r14 >= 2) goto L17;
        r13[0] = r13[0] * r15;
        r13[1] = r13[1] * r15;
        return;
    L17:
        return;
    L12:
        r22.getDpDt(r20, r11, r12, r13);
        goto L14
    L5:
        r20 = r16;
        goto L6
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return super.isAttachedToWindow();
    L7:
        if (getWindowToken() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.mDelayedApply;
    }

    public boolean isInRotation() {
        return this.mInRotation;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public boolean isViewTransitionEnabled(int r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.isViewTransitionEnabled(r10);
    }

    public void jumpToState(int r10) {
        if (isAttachedToWindow() == true) goto L6;
        this.mCurrentState = r10;
    L6:
        if (this.mBeginState != r10) goto L10;
        float r11 = 0.0f;
    L8:
        setProgress(r11);
        return;
    L10:
        if (this.mEndState != r10) goto L12;
        r11 = 1.0f;
        goto L8
    L12:
        setTransition(r10, r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int r10) {
        if (r10 != 0) goto L54;
        this.mScene = null;
        return;
    L54:
        MotionScene r11 = new MotionScene(getContext(), this, r10);     // Catch: Exception -> L49
        this.mScene = r11;     // Catch: Exception -> L49
        if (this.mCurrentState != (-1)) goto L7;
        this.mCurrentState = r11.getStartId();     // Catch: Exception -> L49
        this.mBeginState = this.mScene.getStartId();     // Catch: Exception -> L49
        this.mEndState = this.mScene.getEndId();     // Catch: Exception -> L49
    L7:
        int r12 = Build.VERSION.SDK_INT;     // Catch: Exception -> L49
        if (r12 < 19) goto L15;
        if (isAttachedToWindow() == true) goto L15;
        this.mScene = null;     // Catch: Exception -> L49
        return;
    L15:
        if (r12 >= 17) goto L55;
    L21:
        MotionScene r13 = this.mScene;     // Catch: Exception -> L46
        if (r13 == null) goto L32;
        ConstraintSet r14 = r13.getConstraintSet(this.mCurrentState);     // Catch: Exception -> L46
        this.mScene.readFallback(this);     // Catch: Exception -> L46
        ArrayList<MotionHelper> r15 = this.mDecoratorsHelpers;     // Catch: Exception -> L46
        if (r15 == null) goto L29;
        Iterator<MotionHelper> r16 = r15.iterator();     // Catch: Exception -> L46
    L27:
        if (r16.hasNext() == false) goto L29;
        r16.next().onFinishedMotionScene(this);     // Catch: Exception -> L46
    L29:
        if (r14 == null) goto L31;
        r14.applyTo(this);     // Catch: Exception -> L46
    L31:
        this.mBeginState = this.mCurrentState;     // Catch: Exception -> L46
    L32:
        onNewStateAttachHandlers();     // Catch: Exception -> L46
        StateCache r17 = this.mStateCache;     // Catch: Exception -> L46
        if (r17 != null) goto L35;
        MotionScene r18 = this.mScene;     // Catch: Exception -> L46
        if (r18 == null) goto L59;
        MotionScene.Transition r19 = r18.mCurrentTransition;     // Catch: Exception -> L46
        if (r19 != null) goto L43;
        return;
    L43:
        if (r19.getAutoTransition() != 4) goto L61;
        transitionToEnd();     // Catch: Exception -> L46
        setState(TransitionState.SETUP);     // Catch: Exception -> L46
        setState(TransitionState.MOVING);     // Catch: Exception -> L46
        return;
    L61:
        return;
    L59:
        return;
    L35:
        if (this.mDelayedApply == false) goto L37;
        post(new AnonymousClass1(this));     // Catch: Exception -> L46
        return;
    L37:
        r17.apply();     // Catch: Exception -> L46
        return;
    L55:
        Display r20 = getDisplay();     // Catch: Exception -> L46
        if (r20 != null) goto L19;
        int r21 = 0;
    L20:
        this.mPreviouseRotation = r21;     // Catch: Exception -> L46
        goto L21
    L19:
        r21 = r20.getRotation();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);
    }

    int lookUpConstraintId(String r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.lookUpConstraintId(r10);
    }

    protected MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT < 17) goto L7;
        Display r10 = getDisplay();
        if (r10 == null) goto L7;
        this.mPreviouseRotation = r10.getRotation();
    L7:
        MotionScene r11 = this.mScene;
        if (r11 == null) goto L20;
        int r12 = this.mCurrentState;
        if (r12 == (-1)) goto L20;
        ConstraintSet r13 = r11.getConstraintSet(r12);
        this.mScene.readFallback(this);
        ArrayList<MotionHelper> r14 = this.mDecoratorsHelpers;
        if (r14 == null) goto L17;
        Iterator<MotionHelper> r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L17;
        r15.next().onFinishedMotionScene(this);
    L17:
        if (r13 == null) goto L19;
        r13.applyTo(this);
    L19:
        this.mBeginState = this.mCurrentState;
    L20:
        onNewStateAttachHandlers();
        StateCache r16 = this.mStateCache;
        if (r16 != null) goto L23;
        MotionScene r17 = this.mScene;
        if (r17 == null) goto L37;
        MotionScene.Transition r18 = r17.mCurrentTransition;
        if (r18 != null) goto L31;
        return;
    L31:
        if (r18.getAutoTransition() != 4) goto L39;
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L39:
        return;
    L37:
        return;
    L23:
        if (this.mDelayedApply == false) goto L25;
        post(new AnonymousClass4(this));
        return;
    L25:
        r16.apply();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L5;
    L38:
        return false;
    L5:
        if (this.mInteractionEnabled == false) goto L38;
        ViewTransitionController r12 = r11.mViewTransitionController;
        if (r12 == null) goto L10;
        r12.touchEvent(r10);
    L10:
        MotionScene.Transition r13 = this.mScene.mCurrentTransition;
        if (r13 == null) goto L38;
        if (r13.isEnabled() == false) goto L38;
        TouchResponse r14 = r13.getTouchResponse();
        if (r14 == null) goto L38;
        if (r10.getAction() != 0) goto L23;
        RectF r15 = r14.getTouchRegion(this, new RectF());
        if (r15 == null) goto L23;
        if (r15.contains(r10.getX(), r10.getY()) == true) goto L23;
        return false;
    L23:
        int r16 = r14.getTouchRegionId();
        if (r16 == (-1)) goto L38;
        View r17 = this.mRegionView;
        if (r17 != null) goto L28;
    L29:
        this.mRegionView = findViewById(r16);
    L30:
        View r18 = this.mRegionView;
        if (r18 == null) goto L38;
        this.mBoundsCheck.set(r18.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
        if (this.mBoundsCheck.contains(r10.getX(), r10.getY()) == false) goto L38;
        if (handlesTouchEvent(this.mRegionView.getLeft(), this.mRegionView.getTop(), this.mRegionView, r10) == true) goto L38;
        return onTouchEvent(r10);
    L28:
        if (r17.getId() == r16) goto L30;
        goto L29
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        this.mInLayout = true;
    L17:
        th = move-exception;
        this.mInLayout = false;
        throw th;
    L4:
        if (this.mScene != null) goto L8;
        super.onLayout(r10, r11, r12, r13, r14);     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L8:
        int r15 = r13 - r11;
        int r16 = r14 - r12;
        if (this.mLastLayoutWidth == r15) goto L12;
    L13:
        rebuildScene();     // Catch: Throwable -> L17
        evaluate(true);     // Catch: Throwable -> L17
    L14:
        this.mLastLayoutWidth = r15;     // Catch: Throwable -> L17
        this.mLastLayoutHeight = r16;     // Catch: Throwable -> L17
        this.mOldWidth = r15;     // Catch: Throwable -> L17
        this.mOldHeight = r16;     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L12:
        if (this.mLastLayoutHeight == r16) goto L14;
        goto L13
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        if (this.mScene != null) goto L6;
        super.onMeasure(r10, r11);
        return;
    L6:
        boolean r12 = false;
        if (this.mLastWidthMeasureSpec == r10) goto L9;
    L12:
        boolean r13 = true;
    L14:
        if (this.mNeedsFireTransitionCompleted == false) goto L17;
        this.mNeedsFireTransitionCompleted = false;
        onNewStateAttachHandlers();
        processTransitionCompleted();
        r13 = true;
    L17:
        if (this.mDirtyHierarchy == false) goto L19;
        r13 = true;
    L19:
        this.mLastWidthMeasureSpec = r10;
        this.mLastHeightMeasureSpec = r11;
        int r14 = this.mScene.getStartId();
        int r15 = this.mScene.getEndId();
        if (r13 == true) goto L24;
        if (this.mModel.isNotConfiguredWith(r14, r15) == true) goto L24;
    L26:
        if (r13 == false) goto L28;
        super.onMeasure(r10, r11);
    L28:
        r12 = true;
    L30:
        if (this.mMeasureDuringTransition == true) goto L32;
        if (r12 == true) goto L32;
    L41:
        evaluateLayout();
        return;
    L32:
        int r16 = getPaddingTop() + getPaddingBottom();
        int r17 = this.mLayoutWidget.getWidth() + (getPaddingLeft() + getPaddingRight());
        int r18 = this.mLayoutWidget.getHeight() + r16;
        int r19 = this.mWidthMeasureMode;
        if (r19 == Integer.MIN_VALUE) goto L35;
        if (r19 == 0) goto L35;
    L36:
        int r20 = this.mHeightMeasureMode;
        if (r20 == Integer.MIN_VALUE) goto L39;
        if (r20 == 0) goto L39;
    L40:
        setMeasuredDimension(r17, r18);
    L39:
        int r21 = this.mStartWrapHeight;
        r18 = (int) (r21 + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r21)));
        requestLayout();
    L35:
        int r22 = this.mStartWrapWidth;
        r17 = (int) (r22 + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r22)));
        requestLayout();
    L24:
        if (this.mBeginState == (-1)) goto L26;
        super.onMeasure(r10, r11);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(r14), this.mScene.getConstraintSet(r15));
        this.mModel.reEvaluateState();
        this.mModel.setMeasuredId(r14, r15);
        goto L30
    L9:
        if (this.mLastHeightMeasureSpec != r11) goto L12;
        r13 = false;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View r10, float r11, float r12, boolean r13) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View r10, float r11, float r12) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull final View r11, int r12, int r13, @NonNull int[] r14, int r15) {
        MotionScene r16 = this.mScene;
        if (r16 != null) goto L5;
        return;
    L5:
        MotionScene.Transition r10 = r16.mCurrentTransition;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.isEnabled() == false) goto L61;
        int r17 = -1;
        if (r10.isEnabled() == false) goto L20;
        TouchResponse r18 = r10.getTouchResponse();
        if (r18 == null) goto L20;
        int r19 = r18.getTouchRegionId();
        if (r19 == (-1)) goto L20;
        if (r11.getId() == r19) goto L20;
        return;
    L20:
        if (r16.getMoveWhenScrollAtTop() == false) goto L34;
        TouchResponse r20 = r10.getTouchResponse();
        if (r20 != null) goto L24;
    L26:
        float r21 = this.mTransitionPosition;
        if (r21 == 1.0f) goto L31;
        if (r21 != 0.0f) goto L34;
    L31:
        if (r11.canScrollVertically(r17) == false) goto L34;
        return;
    L24:
        if ((r20.getFlags() & 4) == 0) goto L26;
        r17 = r13;
    L34:
        if (r10.getTouchResponse() != null) goto L36;
    L49:
        float r110 = this.mTransitionPosition;
        long r22 = getNanoTime();
        float r23 = r12;
        this.mScrollTargetDX = r23;
        float r24 = r13;
        this.mScrollTargetDY = r24;
        this.mScrollTargetDT = (float) ((r22 - this.mScrollTargetTime) * 1.0E-9d);
        this.mScrollTargetTime = r22;
        r16.processScrollMove(r23, r24);
        if (r110 == this.mTransitionPosition) goto L52;
        r14[0] = r12;
        r14[1] = r13;
    L52:
        evaluate(false);
        if (r14[0] == 0) goto L55;
    L56:
        this.mUndergoingMotion = true;
        return;
    L55:
        if (r14[1] != 0) goto L56;
        return;
    L36:
        if ((r10.getTouchResponse().getFlags() & 1) == 0) goto L49;
        float r25 = r16.getProgressDirection(r12, r13);
        float r26 = this.mTransitionLastPosition;
        if (r26 > 0.0f) goto L42;
        if (r25 >= 0.0f) goto L42;
    L46:
        if (Build.VERSION.SDK_INT < 21) goto L58;
        r11.setNestedScrollingEnabled(false);
        r11.post(new AnonymousClass3(this, r11));
        return;
    L58:
        return;
    L42:
        if (r26 < 1.0f) goto L49;
        if (r25 <= 0.0f) goto L49;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, int r15) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, int r15, int[] r16) {
        if (this.mUndergoingMotion == true) goto L6;
        if (r11 != 0) goto L6;
        if (r12 != 0) goto L6;
    L7:
        this.mUndergoingMotion = false;
        return;
    L6:
        r16[0] = r16[0] + r13;
        r16[1] = r16[1] + r14;
        goto L7
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    void onNewStateAttachHandlers() {
        MotionScene r10 = this.mScene;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.autoTransition(this, this.mCurrentState) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r11 = this.mCurrentState;
        if (r11 == (-1)) goto L13;
        this.mScene.addOnClickListeners(this, r11);
    L13:
        if (this.mScene.supportTouch() == false) goto L16;
        this.mScene.setupTouch();
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r10) {
        MotionScene r11 = this.mScene;
        if (r11 == null) goto L6;
        r11.setRtl(isRtl());
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        MotionScene r14 = this.mScene;
        if (r14 == null) goto L13;
        MotionScene.Transition r15 = r14.mCurrentTransition;
        if (r15 != null) goto L7;
        return false;
    L7:
        if (r15.getTouchResponse() != null) goto L9;
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
    public void onStopNestedScroll(@NonNull View r10, int r11) {
        MotionScene r12 = this.mScene;
        if (r12 == null) goto L9;
        float r13 = this.mScrollTargetDT;
        if (r13 == 0.0f) goto L10;
        r12.processScrollUp(this.mScrollTargetDX / r13, this.mScrollTargetDY / r13);
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        MotionScene r11 = this.mScene;
        if (r11 == null) goto L21;
        if (this.mInteractionEnabled == false) goto L21;
        if (r11.supportTouch() == false) goto L21;
        MotionScene.Transition r12 = this.mScene.mCurrentTransition;
        if (r12 != null) goto L11;
    L14:
        this.mScene.processTouchEvent(r10, getCurrentState(), this);
        if (this.mScene.mCurrentTransition.isTransitionFlag(4) == true) goto L17;
        return true;
    L17:
        return this.mScene.mCurrentTransition.getTouchResponse().isDragStarted();
    L11:
        if (r12.isEnabled() == true) goto L14;
        return super.onTouchEvent(r10);
    L21:
        return super.onTouchEvent(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View r10) {
        super.onViewAdded(r10);
        if ((r10 instanceof MotionHelper) == false) goto L26;
        MotionHelper r11 = (MotionHelper) r10;
        if (this.mTransitionListeners != null) goto L7;
        this.mTransitionListeners = new CopyOnWriteArrayList();
    L7:
        this.mTransitionListeners.add(r11);
        if (r11.isUsedOnShow() == false) goto L14;
        if (this.mOnShowHelpers != null) goto L12;
        this.mOnShowHelpers = new ArrayList();
    L12:
        this.mOnShowHelpers.add(r11);
    L14:
        if (r11.isUseOnHide() == false) goto L20;
        if (this.mOnHideHelpers != null) goto L18;
        this.mOnHideHelpers = new ArrayList();
    L18:
        this.mOnHideHelpers.add(r11);
    L20:
        if (r11.isDecorator() == true) goto L22;
        return;
    L22:
        if (this.mDecoratorsHelpers != null) goto L24;
        this.mDecoratorsHelpers = new ArrayList();
    L24:
        this.mDecoratorsHelpers.add(r11);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        ArrayList<MotionHelper> r11 = this.mOnShowHelpers;
        if (r11 == null) goto L5;
        r11.remove(r10);
    L5:
        ArrayList<MotionHelper> r12 = this.mOnHideHelpers;
        if (r12 == null) goto L9;
        r12.remove(r10);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int r10) {
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

    public boolean removeTransitionListener(TransitionListener r10) {
        CopyOnWriteArrayList<TransitionListener> r11 = this.mTransitionListeners;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.remove(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mMeasureDuringTransition == false) goto L5;
    L19:
        super.requestLayout();
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L19;
        MotionScene r10 = this.mScene;
        if (r10 == null) goto L19;
        MotionScene.Transition r11 = r10.mCurrentTransition;
        if (r11 == null) goto L19;
        int r12 = r11.getLayoutDuringTransition();
        if (r12 != 0) goto L14;
        return;
    L14:
        if (r12 != 2) goto L19;
        int r13 = getChildCount();
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L18;
        View r15 = getChildAt(r14);
        this.mFrameArrayList.get(r15).remeasure();
        r14 = r14 + 1;
        goto L16
    }

    @RequiresApi(api = 17)
    public void rotateTo(int r10, int r11) {
        int r12 = 1;
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int r13 = getDisplay().getRotation();
        if (((r13 + 1) % 4) > ((this.mPreviouseRotation + 1) % 4)) goto L6;
        r12 = 2;
    L6:
        this.mRotatMode = r12;
        this.mPreviouseRotation = r13;
        int r14 = getChildCount();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L12;
        View r16 = getChildAt(r15);
        ViewState r17 = this.mPreRotate.get(r16);
        if (r17 != null) goto L11;
        r17 = new ViewState();
        this.mPreRotate.put(r16, r17);
    L11:
        r17.getState(r16);
        r15 = r15 + 1;
        goto L7
    L12:
        this.mBeginState = -1;
        this.mEndState = r10;
        this.mScene.setTransition(-1, r10);
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(this.mEndState));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new AnonymousClass2(this));
        if (r11 <= 0) goto L19;
        this.mTransitionDuration = r11 / 1000.0f;
        return;
    }

    public void scheduleTransitionTo(int r10) {
        if (getCurrentState() != (-1)) goto L5;
        transitionToState(r10);
        return;
    L5:
        int[] r11 = this.mScheduledTransitionTo;
        if (r11 != null) goto L9;
        this.mScheduledTransitionTo = new int[4];
    L11:
        int[] r12 = this.mScheduledTransitionTo;
        int r13 = this.mScheduledTransitions;
        this.mScheduledTransitions = r13 + 1;
        r12[r13] = r10;
        return;
    L9:
        if (r11.length > this.mScheduledTransitions) goto L11;
        this.mScheduledTransitionTo = Arrays.copyOf(r11, r11.length * 2);
        goto L11
    }

    public void setDebugMode(int r10) {
        this.mDebugPath = r10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean r10) {
        this.mDelayedApply = r10;
    }

    public void setInteractionEnabled(boolean r10) {
        this.mInteractionEnabled = r10;
    }

    public void setInterpolatedProgress(float r10) {
        if (this.mScene == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r11 = this.mScene.getInterpolator();
        if (r11 == null) goto L8;
        setProgress(r11.getInterpolation(r10));
        return;
    L8:
        setProgress(r10);
    }

    public void setOnHide(float r10) {
        ArrayList<MotionHelper> r11 = this.mOnHideHelpers;
        if (r11 == null) goto L7;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        this.mOnHideHelpers.get(r13).setProgress(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r10) {
        ArrayList<MotionHelper> r11 = this.mOnShowHelpers;
        if (r11 == null) goto L7;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        this.mOnShowHelpers.get(r13).setProgress(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setProgress(float r10) {
        if (r10 >= 0.0f) goto L5;
    L6:
        Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    L8:
        if (isAttachedToWindow() == false) goto L10;
        if (r10 > 0.0f) goto L24;
        if (this.mTransitionLastPosition == 1.0f) goto L18;
    L20:
        this.mCurrentState = this.mBeginState;
        if (this.mTransitionLastPosition != 0.0f) goto L36;
    L22:
        TransitionState r11 = TransitionState.FINISHED;
    L34:
        setState(r11);
    L36:
        if (this.mScene != null) goto L38;
        return;
    L38:
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = r10;
        this.mTransitionPosition = r10;
        this.mTransitionLastTime = -1;
        this.mAnimationStartTime = -1;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
        return;
    L18:
        if (this.mCurrentState != this.mEndState) goto L20;
        setState(TransitionState.MOVING);
        goto L20
    L24:
        if (r10 >= 1.0f) goto L26;
        this.mCurrentState = -1;
        r11 = TransitionState.MOVING;
        goto L34
    L26:
        if (this.mTransitionLastPosition == 0.0f) goto L28;
    L30:
        this.mCurrentState = this.mEndState;
        if (this.mTransitionLastPosition != 1.0f) goto L36;
    L28:
        if (this.mCurrentState != this.mBeginState) goto L30;
        setState(TransitionState.MOVING);
        goto L30
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

    public void setProgress(float r10, float r11) {
        if (isAttachedToWindow() == false) goto L5;
        setProgress(r10);
        setState(TransitionState.MOVING);
        this.mLastVelocity = r11;
        float r12 = 0.0f;
        if (r11 == 0.0f) goto L15;
        if (r11 <= 0.0f) goto L13;
    L12:
        r12 = 1.0f;
    L13:
        animateTo(r12);
        return;
    L15:
        if (r10 != 0.0f) goto L17;
        return;
    L17:
        if (r10 != 1.0f) goto L19;
        return;
    L19:
        if (r10 <= 0.5f) goto L13;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setProgress(r10);
        this.mStateCache.setVelocity(r11);
    }

    public void setScene(MotionScene r10) {
        this.mScene = r10;
        r10.setRtl(isRtl());
        rebuildScene();
    }

    void setStartState(int r10) {
        if (isAttachedToWindow() == false) goto L5;
        this.mCurrentState = r10;
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setStartState(r10);
        this.mStateCache.setEndState(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int r10, int r11, int r12) {
        setState(TransitionState.SETUP);
        this.mCurrentState = r10;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates r13 = this.mConstraintLayoutSpec;
        if (r13 == null) goto L5;
        r13.updateConstraints(r10, r11, r12);
        return;
    L5:
        MotionScene r14 = this.mScene;
        if (r14 == null) goto L10;
        r14.getConstraintSet(r10).applyTo(this);
        return;
    }

    void setState(TransitionState r10) {
        TransitionState r11 = TransitionState.FINISHED;
        if (r10 == r11) goto L5;
    L7:
        TransitionState r12 = this.mTransitionState;
        this.mTransitionState = r10;
        TransitionState r13 = TransitionState.MOVING;
        if (r12 != r13) goto L11;
        if (r10 != r13) goto L11;
        fireTransitionChange();
    L11:
        int r14 = AnonymousClass5.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[r12.ordinal()];
        if (r14 != 1) goto L14;
    L20:
        if (r10 != r13) goto L22;
        fireTransitionChange();
    L22:
        if (r10 != r11) goto L26;
    L19:
        fireTransitionCompleted();
        return;
    L26:
        return;
    L14:
        if (r14 == 2) goto L20;
        if (r14 != 3) goto L27;
        if (r10 == r11) goto L19;
        return;
    L27:
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L7;
    }

    public void setTransition(int r10) {
        if (this.mScene == null) goto L35;
        MotionScene.Transition r11 = getTransition(r10);
        this.mBeginState = r11.getStartConstraintSetId();
        this.mEndState = r11.getEndConstraintSetId();
        if (isAttachedToWindow() == false) goto L7;
        float r12 = Float.NaN;
        int r13 = this.mCurrentState;
        float r14 = 0.0f;
        if (r13 != this.mBeginState) goto L15;
        r12 = 0.0f;
    L17:
        this.mScene.setTransition(r11);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
        if (this.mTransitionLastPosition == r12) goto L27;
        if (r12 != 0.0f) goto L24;
        endTrigger(true);
        MotionScene r15 = this.mScene;
        int r16 = this.mBeginState;
    L22:
        r15.getConstraintSet(r16).applyTo(this);
        goto L27
    L24:
        if (r12 != 1.0f) goto L27;
        endTrigger(false);
        r15 = this.mScene;
        r16 = this.mEndState;
    L27:
        if (Float.isNaN(r12) == true) goto L30;
        r14 = r12;
    L30:
        this.mTransitionLastPosition = r14;
        if (Float.isNaN(r12) == false) goto L33;
        Log.v(TAG, Debug.getLocation() + " transitionToStart ");
        transitionToStart();
        return;
    L33:
        setProgress(r12);
        return;
    L15:
        if (r13 != this.mEndState) goto L17;
        r12 = 1.0f;
        goto L17
    L7:
        if (this.mStateCache != null) goto L9;
        this.mStateCache = new StateCache(this);
    L9:
        this.mStateCache.setStartState(this.mBeginState);
        this.mStateCache.setEndState(this.mEndState);
        return;
    }

    public void setTransition(int r10, int r11) {
        if (isAttachedToWindow() == false) goto L5;
        MotionScene r12 = this.mScene;
        if (r12 == null) goto L13;
        this.mBeginState = r10;
        this.mEndState = r11;
        r12.setTransition(r10, r11);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(r10), this.mScene.getConstraintSet(r11));
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
        this.mStateCache.setStartState(r10);
        this.mStateCache.setEndState(r11);
    }

    protected void setTransition(MotionScene.Transition r10) {
        this.mScene.setTransition(r10);
        setState(TransitionState.SETUP);
        if (this.mCurrentState != this.mScene.getEndId()) goto L5;
        float r11 = 1.0f;
    L6:
        this.mTransitionLastPosition = r11;
        this.mTransitionPosition = r11;
        this.mTransitionGoalPosition = r11;
        if (r10.isTransitionFlag(1) == false) goto L9;
        long r12 = -1;
    L10:
        this.mTransitionLastTime = r12;
        int r13 = this.mScene.getStartId();
        int r14 = this.mScene.getEndId();
        if (r13 == this.mBeginState) goto L13;
    L15:
        this.mBeginState = r13;
        this.mEndState = r14;
        this.mScene.setTransition(r13, r14);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
        return;
    L13:
        if (r14 != this.mEndState) goto L15;
        return;
    L9:
        r12 = getNanoTime();
        goto L10
    L5:
        r11 = 0.0f;
        goto L6
    }

    public void setTransitionDuration(int r10) {
        MotionScene r11 = this.mScene;
        if (r11 != null) goto L6;
        Log.e(TAG, "MotionScene not defined");
        return;
    L6:
        r11.setDuration(r10);
    }

    public void setTransitionListener(TransitionListener r10) {
        this.mTransitionListener = r10;
    }

    public void setTransitionState(Bundle r10) {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new StateCache(this);
    L5:
        this.mStateCache.setTransitionState(r10);
        if (isAttachedToWindow() == false) goto L9;
        this.mStateCache.apply();
        return;
    }

    @Override // android.view.View
    public String toString() {
        Context r10 = getContext();
        return Debug.getName(r10, this.mBeginState) + "->" + Debug.getName(r10, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int r10, float r11, float r12) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mTransitionLastPosition != r11) goto L8;
        return;
    L8:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = r11;
        this.mInTransition = true;
        if (r10 == 0) goto L26;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L26;
        if (r10 != 4) goto L15;
    L24:
        this.mDecelerateLogic.config(r12, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
        Interpolator r13 = this.mDecelerateLogic;
    L25:
        this.mInterpolator = r13;
    L37:
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
        return;
    L15:
        if (r10 == 5) goto L20;
        if (r10 == 6) goto L26;
        if (r10 == 7) goto L26;
    L20:
        if (willJump(r12, this.mTransitionLastPosition, this.mScene.getMaxAcceleration()) == true) goto L24;
        this.mStopLogic.config(this.mTransitionLastPosition, r11, r12, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
        this.mLastVelocity = 0.0f;
    L23:
        int r14 = this.mCurrentState;
        this.mTransitionGoalPosition = r11;
        this.mCurrentState = r14;
        r13 = this.mStopLogic;
    L26:
        if (r10 == 1) goto L32;
        if (r10 == 7) goto L32;
        if (r10 == 2) goto L31;
        if (r10 == 6) goto L31;
    L33:
        int r15 = this.mScene.getAutoCompleteMode();
        StopLogic r16 = this.mStopLogic;
        float r17 = this.mTransitionLastPosition;
        if (r15 != 0) goto L36;
        r16.config(r17, r11, r12, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
        goto L23
    L36:
        r16.springConfig(r17, r11, r12, this.mScene.getSpringMass(), this.mScene.getSpringStiffiness(), this.mScene.getSpringDamping(), this.mScene.getSpringStopThreshold(), this.mScene.getSpringBoundary());
    L31:
        r11 = 1.0f;
    L32:
        r11 = 0.0f;
        goto L33
    }

    public void touchSpringTo(float r12, float r13) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mTransitionLastPosition != r12) goto L8;
        return;
    L8:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = r12;
        this.mInTransition = true;
        this.mStopLogic.springConfig(this.mTransitionLastPosition, r12, r13, this.mScene.getSpringMass(), this.mScene.getSpringStiffiness(), this.mScene.getSpringDamping(), this.mScene.getSpringStopThreshold(), this.mScene.getSpringBoundary());
        int r14 = this.mCurrentState;
        this.mTransitionGoalPosition = r12;
        this.mCurrentState = r14;
        this.mInterpolator = this.mStopLogic;
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToEnd(Runnable r10) {
        animateTo(1.0f);
        this.mOnComplete = r10;
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int r10) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r10, -1, -1);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setEndState(r10);
    }

    public void transitionToState(int r10, int r11) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r10, -1, -1, r11);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setEndState(r10);
    }

    public void transitionToState(int r10, int r11, int r12) {
        transitionToState(r10, r11, r12, -1);
    }

    public void transitionToState(int r11, int r12, int r13, int r14) {
        MotionScene r10 = this.mScene;
        if (r10 == null) goto L9;
        StateSet r15 = r10.mStateSet;
        if (r15 == null) goto L9;
        int r16 = r15.convertToConstraintSet(this.mCurrentState, r11, r12, r13);
        if (r16 == (-1)) goto L9;
        r11 = r16;
    L9:
        int r17 = this.mCurrentState;
        if (r17 != r11) goto L13;
        return;
    L13:
        if (this.mBeginState != r11) goto L19;
        animateTo(0.0f);
        if (r14 <= 0) goto L91;
        this.mTransitionDuration = r14 / 1000.0f;
        return;
    L91:
        return;
    L19:
        if (this.mEndState != r11) goto L24;
        animateTo(1.0f);
        if (r14 <= 0) goto L92;
        this.mTransitionDuration = r14 / 1000.0f;
        return;
    L92:
        return;
    L24:
        this.mEndState = r11;
        if (r17 == (-1)) goto L30;
        setTransition(r17, r11);
        animateTo(1.0f);
        this.mTransitionLastPosition = 0.0f;
        transitionToEnd();
        if (r14 <= 0) goto L93;
        this.mTransitionDuration = r14 / 1000.0f;
        return;
    L93:
        return;
    L30:
        int r18 = 0;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        if (r14 != (-1)) goto L33;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
    L33:
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        SparseArray r19 = new SparseArray();
        if (r14 != 0) goto L37;
        r14 = this.mScene.getDuration();
    L36:
        this.mTransitionDuration = r14 / 1000.0f;
    L39:
        int r110 = getChildCount();
        this.mFrameArrayList.clear();
        int r20 = 0;
    L40:
        if (r20 >= r110) goto L42;
        View r21 = getChildAt(r20);
        this.mFrameArrayList.put(r21, new MotionController(r21));
        r19.put(r21.getId(), this.mFrameArrayList.get(r21));
        r20 = r20 + 1;
        goto L40
    L42:
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(r11));
        rebuildScene();
        this.mModel.build();
        computeCurrentPositions();
        int r111 = getWidth();
        int r112 = getHeight();
        if (this.mDecoratorsHelpers == null) goto L62;
        int r22 = 0;
    L45:
        if (r22 >= r110) goto L51;
        MotionController r23 = this.mFrameArrayList.get(getChildAt(r22));
        if (r23 == null) goto L50;
        this.mScene.getKeyFrames(r23);
    L50:
        r22 = r22 + 1;
        goto L45
    L51:
        Iterator<MotionHelper> r24 = this.mDecoratorsHelpers.iterator();
    L53:
        if (r24.hasNext() == false) goto L55;
        r24.next().onPreSetup(this, this.mFrameArrayList);
        goto L53
    L55:
        int r25 = 0;
    L56:
        if (r25 >= r110) goto L69;
        MotionController r26 = this.mFrameArrayList.get(getChildAt(r25));
        if (r26 == null) goto L61;
        r26.setup(r111, r112, this.mTransitionDuration, getNanoTime());
    L61:
        r25 = r25 + 1;
    L69:
        float r113 = this.mScene.getStaggered();
        if (r113 == 0.0f) goto L76;
        float r114 = Float.MAX_VALUE;
        float r27 = -3.4028235E38f;
        int r28 = 0;
    L72:
        if (r28 >= r110) goto L74;
        MotionController r29 = this.mFrameArrayList.get(getChildAt(r28));
        float r30 = r29.getFinalY() + r29.getFinalX();
        r114 = Math.min(r114, r30);
        r27 = Math.max(r27, r30);
        r28 = r28 + 1;
    L74:
        if (r18 >= r110) goto L76;
        MotionController r31 = this.mFrameArrayList.get(getChildAt(r18));
        float r32 = r31.getFinalX();
        float r33 = r31.getFinalY();
        r31.mStaggerScale = 1.0f / (1.0f - r113);
        r31.mStaggerOffset = r113 - ((((r32 + r33) - r114) * r113) / (r27 - r114));
        r18 = r18 + 1;
    L76:
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
        return;
    L62:
        int r34 = 0;
    L63:
        if (r34 >= r110) goto L69;
        MotionController r35 = this.mFrameArrayList.get(getChildAt(r34));
        if (r35 == null) goto L68;
        this.mScene.getKeyFrames(r35);
        r35.setup(r111, r112, this.mTransitionDuration, getNanoTime());
    L68:
        r34 = r34 + 1;
        goto L63
    L37:
        if (r14 <= 0) goto L39;
        goto L39
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void updateState(int r10, ConstraintSet r11) {
        MotionScene r12 = this.mScene;
        if (r12 == null) goto L5;
        r12.setConstraintSet(r10, r11);
    L5:
        updateState();
        if (this.mCurrentState != r10) goto L9;
        r11.applyTo(this);
        return;
    }

    public void updateStateAnimate(int r10, ConstraintSet r11, int r12) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mCurrentState != r10) goto L9;
        int r13 = R.id.view_transition;
        updateState(r13, getConstraintSet(r10));
        setState(r13, -1, -1);
        updateState(r10, r11);
        MotionScene.Transition r14 = new MotionScene.Transition(-1, this.mScene, r13, r10);
        r14.setDuration(r12);
        setTransition(r14);
        transitionToEnd();
        return;
    }

    public void viewTransition(int r10, View... r11) {
        MotionScene r12 = this.mScene;
        if (r12 == null) goto L5;
        r12.viewTransition(r10, r11);
        return;
    L5:
        Log.e(TAG, " no motionScene");
    }
}
