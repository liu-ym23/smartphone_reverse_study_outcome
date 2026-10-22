package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
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
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.widget.Barrier;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.Constraints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
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
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private a mDecelerateLogic;
    private ArrayList<MotionHelper> mDecoratorsHelpers;
    private boolean mDelayedApply;
    private com.obric.oui.constraintlayout.motion.widget.b mDesignTool;
    b mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    boolean mFirstDown;
    HashMap<View, m> mFrameArrayList;
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
    private com.obric.oui.constraintlayout.core.motion.a.d mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    private float mLastPos;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mLastY;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    c mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private Runnable mOnComplete;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    HashMap<View, com.obric.oui.constraintlayout.motion.a.e> mPreRotate;
    private int mPreRotateHeight;
    private int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator;
    private View mRegionView;
    int mRotatMode;
    q mScene;
    private int[] mScheduledTransitionTo;
    int mScheduledTransitions;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private f mStateCache;
    private com.obric.oui.constraintlayout.motion.a.b mStopLogic;
    Rect mTempRect;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private g mTransitionListener;
    private CopyOnWriteArrayList<g> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.motion.widget.MotionLayout$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13672a = null;

        static {
            int[] r0 = new int[TransitionState.values().length];
            f13672a = r0;
            r0[TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f13672a[TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f13672a[TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f13672a[TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final enum TransitionState extends Enum<TransitionState> {
        private static final /* synthetic */ TransitionState[] $VALUES = null;
        public static final TransitionState FINISHED = null;
        public static final TransitionState MOVING = null;
        public static final TransitionState SETUP = null;
        public static final TransitionState UNDEFINED = null;

        static {
            TransitionState r0 = new TransitionState("UNDEFINED", 0);
            UNDEFINED = r0;
            TransitionState r1 = new TransitionState("SETUP", 1);
            SETUP = r1;
            TransitionState r3 = new TransitionState("MOVING", 2);
            MOVING = r3;
            TransitionState r5 = new TransitionState("FINISHED", 3);
            FINISHED = r5;
            $VALUES = new TransitionState[]{r0, r1, r3, r5};
        }

        private TransitionState(String r1, int r2) {
            super(r1, r2);
        }

        public static TransitionState valueOf(String r2) {
            return (TransitionState) ZeusTransformUtils.preCheckCast(Enum.valueOf(TransitionState.class, r2), TransitionState.class, "com.obric.memorydata.plugin");
        }

        public static TransitionState[] values() {
            return (TransitionState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TransitionState[].class, "com.obric.memorydata.plugin");
        }
    }

    class a extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f13673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f13674b;
        float c;
        final /* synthetic */ MotionLayout d;

        a(MotionLayout r1) {
            this.d = r1;
            this.f13673a = 0.0f;
            this.f13674b = 0.0f;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.o
        public float a() {
            return this.d.mLastVelocity;
        }

        public void a(float r1, float r2, float r3) {
            this.f13673a = r1;
            this.f13674b = r2;
            this.c = r3;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r5) {
            float r0 = this.f13673a;
            if (r0 <= 0.0f) goto L10;
            float r1 = this.c;
            if ((r0 / r1) >= r5) goto L7;
            r5 = r0 / r1;
        L7:
            float r2 = r0 - (r1 * r5);
            this.d.mLastVelocity = r2;
            float r3 = (this.f13673a * r5) - (((this.c * r5) * r5) / 2.0f);
        L9:
            return r3 + this.f13674b;
        L10:
            float r4 = this.c;
            if (((-r0) / r4) >= r5) goto L13;
            r5 = (-r0) / r4;
        L13:
            float r6 = r0 + (r4 * r5);
            this.d.mLastVelocity = r6;
            r3 = (this.f13673a * r5) + (((this.c * r5) * r5) / 2.0f);
            goto L9
        }
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float[] f13675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int[] f13676b;
        float[] c;
        Path d;
        Paint e;
        Paint f;
        Paint g;
        Paint h;
        Paint i;
        final int j;
        final int k;
        final int l;
        final int m;
        final int n;
        DashPathEffect o;
        int p;
        Rect q;
        boolean r;
        int s;
        final /* synthetic */ MotionLayout t;
        private float[] u;

        b(MotionLayout r7) {
            this.t = r7;
            this.j = -21965;
            this.k = -2067046;
            this.l = -13391360;
            this.m = 1996488704;
            this.n = 10;
            this.q = new Rect();
            this.r = false;
            this.s = 1;
            Paint r4 = new Paint();
            this.e = r4;
            r4.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            this.e.setStyle(Paint.Style.STROKE);
            Paint r0 = new Paint();
            this.f = r0;
            r0.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(Paint.Style.STROKE);
            Paint r1 = new Paint();
            this.g = r1;
            r1.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(Paint.Style.STROKE);
            Paint r2 = new Paint();
            this.h = r2;
            r2.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().density * 12.0f);
            this.u = new float[8];
            Paint r8 = new Paint();
            this.i = r8;
            r8.setAntiAlias(true);
            DashPathEffect r9 = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.o = r9;
            this.g.setPathEffect(r9);
            this.c = new float[100];
            this.f13676b = new int[50];
            if (this.r == false) goto L6;
            this.e.setStrokeWidth(8.0f);
            this.i.setStrokeWidth(8.0f);
            this.f.setStrokeWidth(8.0f);
            this.s = 4;
            return;
        }

        private void a(Canvas r2) {
            r2.drawLines(this.f13675a, this.e);
        }

        private void a(Canvas r13, float r14, float r15) {
            float[] r0 = this.f13675a;
            float r1 = r0[0];
            float r3 = r0[1];
            float r4 = r0[r0.length - 2];
            float r2 = r0[r0.length - 1];
            float r5 = (float) Math.hypot(r1 - r4, r3 - r2);
            float r6 = r4 - r1;
            float r7 = r2 - r3;
            float r8 = (((r14 - r1) * r6) + ((r15 - r3) * r7)) / (r5 * r5);
            float r9 = r1 + (r6 * r8);
            float r10 = r3 + (r8 * r7);
            Path r11 = new Path();
            r11.moveTo(r14, r15);
            r11.lineTo(r9, r10);
            float r12 = (float) Math.hypot(r9 - r14, r10 - r15);
            String r16 = "" + (((int) ((r12 * 100.0f) / r5)) / 100.0f);
            a(r16, this.h);
            r13.drawTextOnPath(r16, r11, (r12 / 2.0f) - (this.q.width() / 2), -20.0f, this.h);
            r13.drawLine(r14, r15, r9, r10, this.g);
        }

        private void a(Canvas r8, float r9, float r10, float r11, float r12) {
            r8.drawRect(r9, r10, r11, r12, this.g);
            r8.drawLine(r9, r10, r11, r12, this.g);
        }

        private void a(Canvas r16, float r17, float r18, int r19, int r20) {
            String r1 = "" + (((int) (((double) (((r17 - (r19 / 2)) * 100.0f) / (this.t.getWidth() - r19))) + 0.5d)) / 100.0f);
            a(r1, this.h);
            r16.drawText(r1, ((r17 / 2.0f) - (this.q.width() / 2)) + 0.0f, r18 - 20.0f, this.h);
            r16.drawLine(r17, r18, Math.min(0.0f, 1.0f), r18, this.g);
            String r2 = "" + (((int) (((double) (((r18 - (r20 / 2)) * 100.0f) / (this.t.getHeight() - r20))) + 0.5d)) / 100.0f);
            a(r2, this.h);
            r16.drawText(r2, r17 + 5.0f, 0.0f - ((r18 / 2.0f) - (this.q.height() / 2)), this.h);
            r16.drawLine(r17, r18, r17, Math.max(0.0f, 1.0f), this.g);
        }

        private void a(Canvas r7, m r8) {
            this.d.reset();
            int r1 = 0;
        L4:
            if (r1 > 50) goto L6;
            r8.a(r1 / 50, this.u, 0);
            Path r2 = this.d;
            float[] r3 = this.u;
            r2.moveTo(r3[0], r3[1]);
            Path r4 = this.d;
            float[] r5 = this.u;
            r4.lineTo(r5[2], r5[3]);
            Path r6 = this.d;
            float[] r9 = this.u;
            r6.lineTo(r9[4], r9[5]);
            Path r10 = this.d;
            float[] r11 = this.u;
            r10.lineTo(r11[6], r11[7]);
            this.d.close();
            r1 = r1 + 1;
            goto L4
        L6:
            this.e.setColor(1140850688);
            r7.translate(2.0f, 2.0f);
            r7.drawPath(this.d, this.e);
            r7.translate(-2.0f, -2.0f);
            this.e.setColor(-65536);
            r7.drawPath(this.d, this.e);
        }

        private void b(Canvas r9) {
            float[] r0 = this.f13675a;
            r9.drawLine(r0[0], r0[1], r0[r0.length - 2], r0[r0.length - 1], this.g);
        }

        private void b(Canvas r19, float r20, float r21) {
            float[] r1 = this.f13675a;
            float r2 = r1[0];
            float r8 = r1[1];
            float r4 = r1[r1.length - 2];
            float r9 = r1[r1.length - 1];
            float r3 = Math.min(r2, r4);
            float r10 = Math.max(r8, r9);
            float r5 = r20 - Math.min(r2, r4);
            float r11 = Math.max(r8, r9) - r21;
            String r6 = "" + (((int) (((double) ((r5 * 100.0f) / Math.abs(r4 - r2))) + 0.5d)) / 100.0f);
            a(r6, this.h);
            r19.drawText(r6, ((r5 / 2.0f) - (this.q.width() / 2)) + r3, r21 - 20.0f, this.h);
            r19.drawLine(r20, r21, Math.min(r2, r4), r21, this.g);
            String r7 = "" + (((int) (((double) ((r11 * 100.0f) / Math.abs(r9 - r8))) + 0.5d)) / 100.0f);
            a(r7, this.h);
            r19.drawText(r7, r20 + 5.0f, r10 - ((r11 / 2.0f) - (this.q.height() / 2)), this.h);
            r19.drawLine(r20, r21, r20, Math.max(r8, r9), this.g);
        }

        private void b(Canvas r20, int r21, int r22, m r23) {
            if (r23.f13698b == null) goto L5;
            int r11 = r23.f13698b.getWidth();
            int r12 = r23.f13698b.getHeight();
        L6:
            int r14 = 1;
        L8:
            if (r14 >= (r22 - 1)) goto L38;
            if (r21 == 4) goto L12;
        L14:
            float[] r1 = this.c;
            int r2 = r14 * 2;
            float r5 = r1[r2];
            float r4 = r1[r2 + 1];
            this.d.reset();
            this.d.moveTo(r5, r4 + 10.0f);
            this.d.lineTo(r5 + 10.0f, r4);
            this.d.lineTo(r5, r4 - 10.0f);
            this.d.lineTo(r5 - 10.0f, r4);
            this.d.close();
            int r3 = r14 - 1;
            r23.a(r3);
            if (r21 != 4) goto L27;
            int[] r0 = this.f13676b;
            if (r0[r3] != 1) goto L21;
            a(r20, r5 - 0.0f, r4 - 0.0f);
        L26:
            r20.drawPath(this.d, this.i);
        L28:
            if (r21 != 2) goto L31;
            a(r20, r5 - 0.0f, r4 - 0.0f);
        L31:
            if (r21 != 3) goto L34;
            b(r20, r5 - 0.0f, r4 - 0.0f);
        L34:
            if (r21 != 6) goto L36;
            a(r20, r5 - 0.0f, r4 - 0.0f, r11, r12);
        L36:
            r20.drawPath(this.d, this.i);
        L37:
            r14 = r14 + 1;
            goto L8
        L21:
            if (r0[r3] != 0) goto L24;
            b(r20, r5 - 0.0f, r4 - 0.0f);
            goto L26
        L24:
            if (r0[r3] != 2) goto L26;
            a(r20, r5 - 0.0f, r4 - 0.0f, r11, r12);
            goto L26
        L27:
            r4 = r4;
            r5 = r5;
            goto L28
        L12:
            if (this.f13676b[r14 - 1] != 0) goto L14;
        L38:
            float[] r6 = this.f13675a;
            if (r6.length <= 1) goto L45;
            r20.drawCircle(r6[0], r6[1], 8.0f, this.f);
            float[] r7 = this.f13675a;
            r20.drawCircle(r7[r7.length - 2], r7[r7.length - 1], 8.0f, this.f);
            return;
        L45:
            return;
        L5:
            r11 = 0;
            r12 = 0;
            goto L6
        }

        private void c(Canvas r7) {
            int r0 = 0;
            boolean r1 = false;
            boolean r2 = false;
        L4:
            if (r0 >= this.p) goto L12;
            int[] r3 = this.f13676b;
            if (r3[r0] != 1) goto L9;
            r1 = true;
        L9:
            if (r3[r0] != 0) goto L11;
            r2 = true;
        L11:
            r0 = r0 + 1;
            goto L4
        L12:
            if (r1 == false) goto L14;
            b(r7);
        L14:
            if (r2 == false) goto L20;
            d(r7);
            return;
        }

        private void d(Canvas r19) {
            float[] r1 = this.f13675a;
            float r2 = r1[0];
            float r4 = r1[1];
            float r5 = r1[r1.length - 2];
            float r3 = r1[r1.length - 1];
            r19.drawLine(Math.min(r2, r5), Math.max(r4, r3), Math.max(r2, r5), Math.max(r4, r3), this.g);
            r19.drawLine(Math.min(r2, r5), Math.min(r4, r3), Math.min(r2, r5), Math.max(r4, r3), this.g);
        }

        public void a(Canvas r2, int r3, int r4, m r5) {
            if (r3 != 4) goto L6;
            c(r2);
        L6:
            if (r3 != 2) goto L9;
            b(r2);
        L9:
            if (r3 != 3) goto L11;
            d(r2);
        L11:
            a(r2);
            b(r2, r3, r4, r5);
        }

        public void a(Canvas r7, HashMap<View, m> r8, int r9, int r10) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (r8.size() == 0) goto L42;
            r7.save();
            if (this.t.isInEditMode() == false) goto L9;
        L11:
            Iterator<m> r11 = r8.values().iterator();
        L13:
            if (r11.hasNext() == false) goto L30;
            m r0 = (m) ZeusTransformUtils.preCheckCast(r11.next(), m.class, "com.obric.memorydata.plugin");
            int r2 = r0.j();
            if (r10 <= 0) goto L18;
            if (r2 != 0) goto L18;
            r2 = 1;
        L18:
            if (r2 == 0) goto L13;
            this.p = r0.a(this.c, this.f13676b);
            if (r2 < 1) goto L13;
            int r3 = r9 / 16;
            float[] r4 = this.f13675a;
            if (r4 != null) goto L25;
        L26:
            this.f13675a = new float[r3 * 2];
            this.d = new Path();
        L27:
            int r5 = this.s;
            r7.translate(r5, r5);
            this.e.setColor(1996488704);
            this.i.setColor(1996488704);
            this.f.setColor(1996488704);
            this.g.setColor(1996488704);
            r0.a(this.f13675a, r3);
            a(r7, r2, this.p, r0);
            this.e.setColor(-21965);
            this.f.setColor(-2067046);
            this.i.setColor(-2067046);
            this.g.setColor(-13391360);
            int r6 = this.s;
            r7.translate(-r6, -r6);
            a(r7, r2, this.p, r0);
            if (r2 != 5) goto L13;
            a(r7, r0);
            goto L13
        L25:
            if (r4.length == (r3 * 2)) goto L27;
        L30:
            r7.restore();
            return;
        L9:
            if ((r10 & 1) != 2) goto L11;
            String r1 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.t.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceName(MotionLayout.access$100(this.t)) + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.t.getProgress();
            r7.drawText(r1, 10.0f, this.t.getHeight() - 30, this.h);
            r7.drawText(r1, 11.0f, this.t.getHeight() - 29, this.e);
            goto L11
        }

        void a(String r3, Paint r4) {
            r4.getTextBounds(r3, 0, r3.length(), this.q);
        }
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.obric.oui.constraintlayout.core.widgets.d f13677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.obric.oui.constraintlayout.core.widgets.d f13678b;
        com.obric.oui.constraintlayout.widget.b c;
        com.obric.oui.constraintlayout.widget.b d;
        int e;
        int f;
        final /* synthetic */ MotionLayout g;

        c(MotionLayout r1) {
            this.g = r1;
            this.f13677a = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f13678b = new com.obric.oui.constraintlayout.core.widgets.d();
            this.c = null;
            this.d = null;
        }

        private void a(com.obric.oui.constraintlayout.core.widgets.d r14, com.obric.oui.constraintlayout.widget.b r15) {
            SparseArray<ConstraintWidget> r6 = new SparseArray();
            Constraints.LayoutParams r7 = new Constraints.LayoutParams(-2, -2);
            r6.clear();
            r6.put(0, r14);
            r6.put(this.g.getId(), r14);
            if (r15 != null) goto L5;
        L7:
            Iterator<ConstraintWidget> r0 = r14.ak().iterator();
        L9:
            if (r0.hasNext() == false) goto L11;
            ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
            r1.f(true);
            r6.put(((View) ZeusTransformUtils.preCheckCast(r1.T(), View.class, "com.obric.memorydata.plugin")).getId(), r1);
            goto L9
        L11:
            Iterator<ConstraintWidget> r10 = r14.ak().iterator();
        L13:
            if (r10.hasNext() == false) goto L24;
            ConstraintWidget r11 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
            View r12 = (View) ZeusTransformUtils.preCheckCast(r11.T(), View.class, "com.obric.memorydata.plugin");
            r15.a(r12.getId(), r7);
            r11.q(r15.e(r12.getId()));
            r11.r(r15.d(r12.getId()));
            if (ZeusTransformUtils.instanceOf(r12, ConstraintHelper.class) == false) goto L19;
            r15.a((ConstraintHelper) ZeusTransformUtils.preCheckCast(r12, ConstraintHelper.class, "com.obric.memorydata.plugin"), r11, r7, r6);
            if (ZeusTransformUtils.instanceOf(r12, Barrier.class) == false) goto L19;
            ((Barrier) ZeusTransformUtils.preCheckCast(r12, Barrier.class, "com.obric.memorydata.plugin")).d();
        L19:
            r7.resolveLayoutDirection(this.g.getLayoutDirection());
            MotionLayout.access$1100(this.g, false, r12, r11, r7, r6);
            if (r15.b(r12.getId()) != 1) goto L22;
            int r2 = r12.getVisibility();
        L23:
            r11.l(r2);
            goto L13
        L22:
            r2 = r15.c(r12.getId());
            goto L23
        L24:
            Iterator<ConstraintWidget> r13 = r14.ak().iterator();
        L26:
            if (r13.hasNext() == false) goto L30;
            ConstraintWidget r16 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r13.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r16, com.obric.oui.constraintlayout.core.widgets.k.class) == false) goto L26;
            ConstraintHelper r3 = (ConstraintHelper) ZeusTransformUtils.preCheckCast(r16.T(), ConstraintHelper.class, "com.obric.memorydata.plugin");
            com.obric.oui.constraintlayout.core.widgets.g r17 = (com.obric.oui.constraintlayout.core.widgets.g) ZeusTransformUtils.preCheckCast(r16, com.obric.oui.constraintlayout.core.widgets.g.class, "com.obric.memorydata.plugin");
            r3.a(r14, r17, r6);
            ((com.obric.oui.constraintlayout.core.widgets.k) ZeusTransformUtils.preCheckCast(r17, com.obric.oui.constraintlayout.core.widgets.k.class, "com.obric.memorydata.plugin")).i();
            goto L26
        L30:
            return;
        L5:
            if (r15.c == 0) goto L7;
            MotionLayout r4 = this.g;
            MotionLayout.access$1000(r4, this.f13678b, r4.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(this.g.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.g.getWidth(), 1073741824));
            goto L7
        }

        private void d(int r6, int r7) {
            int r0 = this.g.getOptimizationLevel();
            if (this.g.mCurrentState != this.g.getStartState()) goto L28;
            MotionLayout r1 = this.g;
            com.obric.oui.constraintlayout.core.widgets.d r2 = this.f13678b;
            com.obric.oui.constraintlayout.widget.b r3 = this.d;
            if (r3 != null) goto L7;
        L10:
            int r4 = r6;
        L11:
            com.obric.oui.constraintlayout.widget.b r5 = this.d;
            if (r5 != null) goto L14;
        L17:
            int r8 = r7;
        L18:
            MotionLayout.access$1600(r1, r2, r0, r4, r8);
            com.obric.oui.constraintlayout.widget.b r9 = this.c;
            if (r9 == null) goto L53;
            MotionLayout r10 = this.g;
            com.obric.oui.constraintlayout.core.widgets.d r11 = this.f13677a;
            if (r9.c != 0) goto L23;
            int r12 = r6;
        L25:
            if (this.c.c != 0) goto L27;
            r6 = r7;
        L27:
            MotionLayout.access$1700(r10, r11, r0, r12, r6);
            return;
        L23:
            r12 = r7;
            goto L25
        L53:
            return;
        L14:
            if (r5.c == 0) goto L17;
            r8 = r6;
            goto L18
        L7:
            if (r3.c == 0) goto L10;
            r4 = r7;
            goto L11
        L28:
            com.obric.oui.constraintlayout.widget.b r13 = this.c;
            if (r13 == null) goto L39;
            MotionLayout r14 = this.g;
            com.obric.oui.constraintlayout.core.widgets.d r15 = this.f13677a;
            if (r13.c != 0) goto L33;
            int r16 = r6;
        L35:
            if (this.c.c != 0) goto L37;
            int r17 = r7;
        L38:
            MotionLayout.access$1800(r14, r15, r0, r16, r17);
            goto L39
        L37:
            r17 = r6;
            goto L38
        L33:
            r16 = r7;
        L39:
            MotionLayout r18 = this.g;
            com.obric.oui.constraintlayout.core.widgets.d r19 = this.f13678b;
            com.obric.oui.constraintlayout.widget.b r20 = this.d;
            if (r20 != null) goto L42;
        L45:
            int r21 = r6;
        L46:
            com.obric.oui.constraintlayout.widget.b r22 = this.d;
            if (r22 != null) goto L49;
        L50:
            r6 = r7;
        L51:
            MotionLayout.access$1900(r18, r19, r0, r21, r6);
            return;
        L49:
            if (r22.c != 0) goto L51;
        L42:
            if (r20.c == 0) goto L45;
            r21 = r7;
            goto L46
        }

        ConstraintWidget a(com.obric.oui.constraintlayout.core.widgets.d r5, View r6) {
            if (r5.T() != r6) goto L5;
            return r5;
        L5:
            ArrayList<ConstraintWidget> r4 = r5.ak();
            int r7 = r4.size();
            int r0 = 0;
        L6:
            if (r0 >= r7) goto L11;
            ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r0), ConstraintWidget.class, "com.obric.memorydata.plugin");
            if (r1.T() == r6) goto L9;
            r0 = r0 + 1;
            goto L6
        L9:
            return r1;
        L11:
            return null;
        }

        public void a() {
            a(MotionLayout.access$1200(this.g), MotionLayout.access$1300(this.g));
            MotionLayout.access$1400(this.g);
        }

        public void a(int r14, int r15) {
            int r0 = View.MeasureSpec.getMode(r14);
            int r1 = View.MeasureSpec.getMode(r15);
            this.g.mWidthMeasureMode = r0;
            this.g.mHeightMeasureMode = r1;
            d(r14, r15);
            if (ZeusTransformUtils.instanceOf(this.g.getParent(), MotionLayout.class) == true) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L18;
            d(r14, r15);
            this.g.mStartWrapWidth = this.f13677a.F();
            this.g.mStartWrapHeight = this.f13677a.G();
            this.g.mEndWrapWidth = this.f13678b.F();
            this.g.mEndWrapHeight = this.f13678b.G();
            MotionLayout r3 = this.g;
            if (r3.mStartWrapWidth == this.g.mEndWrapWidth) goto L13;
        L16:
            boolean r4 = true;
        L17:
            r3.mMeasureDuringTransition = r4;
            goto L18
        L13:
            if (this.g.mStartWrapHeight != this.g.mEndWrapHeight) goto L16;
            r4 = false;
        L18:
            int r5 = this.g.mStartWrapWidth;
            int r6 = this.g.mStartWrapHeight;
            if (this.g.mWidthMeasureMode != Integer.MIN_VALUE) goto L21;
        L22:
            r5 = (int) (this.g.mStartWrapWidth + (this.g.mPostInterpolationPosition * (this.g.mEndWrapWidth - this.g.mStartWrapWidth)));
        L23:
            int r9 = r5;
            if (this.g.mHeightMeasureMode != Integer.MIN_VALUE) goto L26;
        L27:
            r6 = (int) (this.g.mStartWrapHeight + (this.g.mPostInterpolationPosition * (this.g.mEndWrapHeight - this.g.mStartWrapHeight)));
        L28:
            int r10 = r6;
            if (this.f13677a.i() == false) goto L31;
        L34:
            boolean r11 = true;
        L36:
            if (this.f13677a.af() == false) goto L38;
        L41:
            boolean r12 = true;
        L42:
            MotionLayout.access$1500(this.g, r14, r15, r9, r10, r11, r12);
            return;
        L38:
            if (this.f13678b.af() == true) goto L41;
            r12 = false;
            goto L42
        L31:
            if (this.f13678b.i() == true) goto L34;
            r11 = false;
            goto L36
        L26:
            if (this.g.mHeightMeasureMode != 0) goto L28;
        L21:
            if (this.g.mWidthMeasureMode != 0) goto L23;
        L5:
            if (r0 != 1073741824) goto L8;
            if (r1 != 1073741824) goto L8;
            r2 = false;
            goto L9
        }

        void a(com.obric.oui.constraintlayout.core.widgets.d r5, com.obric.oui.constraintlayout.core.widgets.d r6) {
            ArrayList<ConstraintWidget> r4 = r5.ak();
            HashMap<ConstraintWidget, ConstraintWidget> r0 = new HashMap();
            r0.put(r5, r6);
            r6.ak().clear();
            r6.a(r5, r0);
            Iterator<ConstraintWidget> r7 = r4.iterator();
        L4:
            if (r7.hasNext() == false) goto L22;
            ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r7.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L9;
            ConstraintWidget r2 = new com.obric.oui.constraintlayout.core.widgets.a();
        L21:
            r6.b(r2);
            r0.put(r1, r2);
            goto L4
        L9:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L12;
            r2 = new com.obric.oui.constraintlayout.core.widgets.f();
            goto L21
        L12:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.constraintlayout.core.widgets.e.class) == false) goto L15;
            r2 = new com.obric.oui.constraintlayout.core.widgets.e();
            goto L21
        L15:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.constraintlayout.core.widgets.j.class) == false) goto L18;
            r2 = new com.obric.oui.constraintlayout.core.widgets.j();
            goto L21
        L18:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.constraintlayout.core.widgets.h.class) == false) goto L20;
            r2 = new com.obric.oui.constraintlayout.core.widgets.h();
            goto L21
        L20:
            r2 = new ConstraintWidget();
            goto L21
        L22:
            Iterator<ConstraintWidget> r8 = r4.iterator();
        L24:
            if (r8.hasNext() == false) goto L26;
            ConstraintWidget r9 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r8.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
            ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.get(r9), ConstraintWidget.class, "com.obric.memorydata.plugin")).a(r9, r0);
            goto L24
        }

        void a(com.obric.oui.constraintlayout.core.widgets.d r5, com.obric.oui.constraintlayout.widget.b r6, com.obric.oui.constraintlayout.widget.b r7) {
            this.c = r6;
            this.d = r7;
            this.f13677a = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f13678b = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f13677a.a(MotionLayout.access$400(this.g).g());
            this.f13678b.a(MotionLayout.access$500(this.g).g());
            this.f13677a.al();
            this.f13678b.al();
            a(MotionLayout.access$600(this.g), this.f13677a);
            a(MotionLayout.access$700(this.g), this.f13678b);
            if (this.g.mTransitionLastPosition <= 0.5d) goto L7;
            if (r6 == null) goto L6;
            a(this.f13677a, r6);
        L6:
            a(this.f13678b, r7);
        L10:
            this.f13677a.h(MotionLayout.access$800(this.g));
            this.f13677a.f();
            this.f13678b.h(MotionLayout.access$900(this.g));
            this.f13678b.f();
            ViewGroup.LayoutParams r8 = this.g.getLayoutParams();
            if (r8 != null) goto L13;
            return;
        L13:
            if (r8.width != (-2)) goto L16;
            this.f13677a.a(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            this.f13678b.a(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        L16:
            if (r8.height != (-2)) goto L20;
            this.f13677a.b(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            this.f13678b.b(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        L20:
            return;
        L7:
            a(this.f13678b, r7);
            if (r6 == null) goto L10;
            a(this.f13677a, r6);
            goto L10
        }

        public void b() {
            int r1 = this.g.getChildCount();
            this.g.mFrameArrayList.clear();
            SparseArray r2 = new SparseArray();
            int[] r3 = new int[r1];
            int r5 = 0;
        L3:
            if (r5 >= r1) goto L5;
            View r6 = this.g.getChildAt(r5);
            m r7 = new m(r6);
            int r8 = r6.getId();
            r3[r5] = r8;
            r2.put(r8, r7);
            this.g.mFrameArrayList.put(r6, r7);
            r5 = r5 + 1;
            goto L3
        L5:
            int r9 = 0;
        L7:
            if (r9 >= r1) goto L32;
            View r10 = this.g.getChildAt(r9);
            m r14 = (m) ZeusTransformUtils.preCheckCast(this.g.mFrameArrayList.get(r10), m.class, "com.obric.memorydata.plugin");
            if (r14 != null) goto L12;
            r2 = r2;
        L31:
            r9 = r9 + 1;
            r2 = r2;
            goto L7
        L12:
            if (this.c == null) goto L20;
            ConstraintWidget r11 = a(this.f13677a, r10);
            if (r11 == null) goto L17;
            r14.a(MotionLayout.access$2000(this.g, r11), this.c, this.g.getWidth(), this.g.getHeight());
        L24:
            if (this.d == null) goto L31;
            ConstraintWidget r12 = a(this.f13678b, r10);
            if (r12 == null) goto L29;
            r14.b(MotionLayout.access$2000(this.g, r12), this.d, this.g.getWidth(), this.g.getHeight());
            goto L31
        L29:
            if (this.g.mDebugPath == 0) goto L31;
            Log.e(MotionLayout.TAG, com.obric.oui.constraintlayout.motion.widget.a.a() + "no widget for  " + com.obric.oui.constraintlayout.motion.widget.a.a(r10) + " (" + r10.getClass().getName() + ")");
            goto L31
        L17:
            if (this.g.mDebugPath == 0) goto L24;
            Log.e(MotionLayout.TAG, com.obric.oui.constraintlayout.motion.widget.a.a() + "no widget for  " + com.obric.oui.constraintlayout.motion.widget.a.a(r10) + " (" + r10.getClass().getName() + ")");
            goto L24
        L20:
            if (MotionLayout.access$300(this.g) == false) goto L24;
            r14.a((com.obric.oui.constraintlayout.motion.a.e) ZeusTransformUtils.preCheckCast(this.g.mPreRotate.get(r10), com.obric.oui.constraintlayout.motion.a.e.class, "com.obric.memorydata.plugin"), r10, this.g.mRotatMode, MotionLayout.access$2100(this.g), MotionLayout.access$2200(this.g));
            goto L24
        L32:
            SparseArray r16 = r2;
            int r4 = 0;
        L33:
            if (r4 >= r1) goto L38;
            SparseArray r13 = r16;
            m r0 = (m) ZeusTransformUtils.preCheckCast(r13.get(r3[r4]), m.class, "com.obric.memorydata.plugin");
            int r15 = r0.e();
            if (r15 == (-1)) goto L37;
            r0.a((m) ZeusTransformUtils.preCheckCast(r13.get(r15), m.class, "com.obric.memorydata.plugin"));
        L37:
            r4 = r4 + 1;
            r16 = r13;
            goto L33
        }

        public void b(int r1, int r2) {
            this.e = r1;
            this.f = r2;
        }

        public boolean c(int r2, int r3) {
            if (r2 == this.e) goto L5;
        L8:
            return true;
        L5:
            if (r3 != this.f) goto L8;
            return false;
        }
    }

    protected interface d {
        void a();

        void a(int r1);

        void a(MotionEvent r1);

        float b();

        float c();
    }

    private static class e implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static e f13679b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        VelocityTracker f13680a;

        static {
            f13679b = new e();
        }

        private e() {
        }

        public static e d() {
            e r0 = f13679b;
            r0.f13680a = VelocityTracker.obtain();
            return f13679b;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.d
        public void a() {
            VelocityTracker r0 = this.f13680a;
            if (r0 == null) goto L6;
            r0.recycle();
            this.f13680a = null;
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.d
        public void a(int r1) {
            VelocityTracker r0 = this.f13680a;
            if (r0 == null) goto L6;
            r0.computeCurrentVelocity(r1);
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.d
        public void a(MotionEvent r1) {
            VelocityTracker r0 = this.f13680a;
            if (r0 == null) goto L6;
            r0.addMovement(r1);
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.d
        public float b() {
            VelocityTracker r0 = this.f13680a;
            if (r0 != null) goto L5;
            return 0.0f;
        L5:
            return r0.getXVelocity();
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.d
        public float c() {
            VelocityTracker r0 = this.f13680a;
            if (r0 != null) goto L5;
            return 0.0f;
        L5:
            return r0.getYVelocity();
        }
    }

    class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f13681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f13682b;
        int c;
        int d;
        final String e;
        final String f;
        final String g;
        final String h;
        final /* synthetic */ MotionLayout i;

        f(MotionLayout r1) {
            this.i = r1;
            this.f13681a = Float.NaN;
            this.f13682b = Float.NaN;
            this.c = -1;
            this.d = -1;
            this.e = "motion.progress";
            this.f = "motion.velocity";
            this.g = "motion.StartState";
            this.h = "motion.EndState";
        }

        void a() {
            int r0 = this.c;
            if (r0 == (-1)) goto L5;
        L6:
            if (r0 != (-1)) goto L8;
            this.i.transitionToState(this.d);
        L12:
            this.i.setState(TransitionState.SETUP);
        L14:
            if (Float.isNaN(this.f13682b) == true) goto L16;
            this.i.setProgress(this.f13681a, this.f13682b);
            this.f13681a = Float.NaN;
            this.f13682b = Float.NaN;
            this.c = -1;
            this.d = -1;
            return;
        L16:
            if (Float.isNaN(this.f13681a) == false) goto L18;
            return;
        L18:
            this.i.setProgress(this.f13681a);
            return;
        L8:
            int r2 = this.d;
            if (r2 != (-1)) goto L11;
            this.i.setState(r0, -1, -1);
            goto L12
        L11:
            this.i.setTransition(r0, r2);
            goto L12
        L5:
            if (this.d == (-1)) goto L14;
            goto L6
        }

        public void a(float r1) {
            this.f13681a = r1;
        }

        public void a(int r1) {
            this.d = r1;
        }

        public void a(Bundle r2) {
            this.f13681a = r2.getFloat("motion.progress");
            this.f13682b = r2.getFloat("motion.velocity");
            this.c = r2.getInt("motion.StartState");
            this.d = r2.getInt("motion.EndState");
        }

        public Bundle b() {
            Bundle r0 = new Bundle();
            r0.putFloat("motion.progress", this.f13681a);
            r0.putFloat("motion.velocity", this.f13682b);
            r0.putInt("motion.StartState", this.c);
            r0.putInt("motion.EndState", this.d);
            return r0;
        }

        public void b(float r1) {
            this.f13682b = r1;
        }

        public void b(int r1) {
            this.c = r1;
        }

        public void c() {
            this.d = MotionLayout.access$100(this.i);
            this.c = MotionLayout.access$200(this.i);
            this.f13682b = this.i.getVelocity();
            this.f13681a = this.i.getProgress();
        }
    }

    public interface g {
        void a(MotionLayout r1, int r2);

        void a(MotionLayout r1, int r2, int r3);

        void a(MotionLayout r1, int r2, int r3, float r4);

        void a(MotionLayout r1, int r2, boolean r3, float r4);
    }

    public MotionLayout(Context r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"));
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
        this.mStopLogic = new com.obric.oui.constraintlayout.motion.a.b();
        this.mDecelerateLogic = new a(this);
        this.mFirstDown = true;
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
        this.mKeyCache = new com.obric.oui.constraintlayout.core.motion.a.d();
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
        this.mModel = new c(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(null);
    }

    public MotionLayout(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r8, r9);
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
        this.mStopLogic = new com.obric.oui.constraintlayout.motion.a.b();
        this.mDecelerateLogic = new a(this);
        this.mFirstDown = true;
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
        this.mKeyCache = new com.obric.oui.constraintlayout.core.motion.a.d();
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
        this.mModel = new c(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(r9);
    }

    public MotionLayout(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r8, r9, r7);
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
        this.mStopLogic = new com.obric.oui.constraintlayout.motion.a.b();
        this.mDecelerateLogic = new a(this);
        this.mFirstDown = true;
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
        this.mKeyCache = new com.obric.oui.constraintlayout.core.motion.a.d();
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
        this.mModel = new c(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(r9);
    }

    static /* synthetic */ f access$000(MotionLayout r0) {
        return r0.mStateCache;
    }

    static /* synthetic */ int access$100(MotionLayout r0) {
        return r0.mEndState;
    }

    static /* synthetic */ void access$1000(MotionLayout r0, com.obric.oui.constraintlayout.core.widgets.d r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1100(MotionLayout r0, boolean r1, View r2, ConstraintWidget r3, ConstraintLayout.LayoutParams r4, SparseArray r5) {
        r0.applyConstraintsFromLayoutParams(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ int access$1200(MotionLayout r0) {
        return r0.mLastWidthMeasureSpec;
    }

    static /* synthetic */ int access$1300(MotionLayout r0) {
        return r0.mLastHeightMeasureSpec;
    }

    static /* synthetic */ void access$1400(MotionLayout r0) {
        r0.setupMotionViews();
    }

    static /* synthetic */ void access$1500(MotionLayout r0, int r1, int r2, int r3, int r4, boolean r5, boolean r6) {
        r0.resolveMeasuredDimension(r1, r2, r3, r4, r5, r6);
    }

    static /* synthetic */ void access$1600(MotionLayout r0, com.obric.oui.constraintlayout.core.widgets.d r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1700(MotionLayout r0, com.obric.oui.constraintlayout.core.widgets.d r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1800(MotionLayout r0, com.obric.oui.constraintlayout.core.widgets.d r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1900(MotionLayout r0, com.obric.oui.constraintlayout.core.widgets.d r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ int access$200(MotionLayout r0) {
        return r0.mBeginState;
    }

    static /* synthetic */ Rect access$2000(MotionLayout r0, ConstraintWidget r1) {
        return r0.toRect(r1);
    }

    static /* synthetic */ int access$2100(MotionLayout r0) {
        return r0.mPreRotateWidth;
    }

    static /* synthetic */ int access$2200(MotionLayout r0) {
        return r0.mPreRotateHeight;
    }

    static /* synthetic */ boolean access$300(MotionLayout r0) {
        return r0.mInRotation;
    }

    static /* synthetic */ boolean access$302(MotionLayout r0, boolean r1) {
        r0.mInRotation = r1;
        return r1;
    }

    static /* synthetic */ com.obric.oui.constraintlayout.core.widgets.d access$400(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ com.obric.oui.constraintlayout.core.widgets.d access$500(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ com.obric.oui.constraintlayout.core.widgets.d access$600(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ com.obric.oui.constraintlayout.core.widgets.d access$700(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ boolean access$800(MotionLayout r0) {
        return r0.isRtl();
    }

    static /* synthetic */ boolean access$900(MotionLayout r0) {
        return r0.isRtl();
    }

    private boolean callTransformedTouchEvent(View r3, MotionEvent r4, float r5, float r6) {
        Matrix r0 = r3.getMatrix();
        if (r0.isIdentity() == false) goto L6;
        r4.offsetLocation(r5, r6);
        boolean r2 = r3.onTouchEvent(r4);
        r4.offsetLocation(-r5, -r6);
        return r2;
    L6:
        MotionEvent r7 = MotionEvent.obtain(r4);
        r7.offsetLocation(r5, r6);
        if (this.mInverseMatrix != null) goto L9;
        this.mInverseMatrix = new Matrix();
    L9:
        r0.invert(this.mInverseMatrix);
        r7.transform(this.mInverseMatrix);
        boolean r8 = r3.onTouchEvent(r7);
        r7.recycle();
        return r8;
    }

    private void checkStructure() {
        q r0 = this.mScene;
        if (r0 != null) goto L6;
        Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
        return;
    L6:
        int r1 = r0.d();
        q r2 = this.mScene;
        checkStructure(r1, r2.d(r2.d()));
        SparseIntArray r3 = new SparseIntArray();
        SparseIntArray r4 = new SparseIntArray();
        Iterator<q.a> r5 = this.mScene.a().iterator();
    L8:
        if (r5.hasNext() == false) goto L24;
        q.a r6 = (q.a) ZeusTransformUtils.preCheckCast(r5.next(), q.a.class, "com.obric.memorydata.plugin");
        if (r6 != this.mScene.f13703b) goto L12;
        Log.v(TAG, "CHECK: CURRENT");
    L12:
        checkStructure(r6);
        int r7 = r6.d();
        int r8 = r6.c();
        String r9 = com.obric.oui.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7);
        String r10 = com.obric.oui.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8);
        if (r3.get(r7) != r8) goto L16;
        Log.e(TAG, "CHECK: two transitions with the same start and end " + r9 + "->" + r10);
    L16:
        if (r4.get(r8) != r7) goto L18;
        Log.e(TAG, "CHECK: you can't have reverse transitions" + r9 + "->" + r10);
    L18:
        r3.put(r7, r8);
        r4.put(r8, r7);
        if (this.mScene.d(r7) != null) goto L22;
        Log.e(TAG, " no such constraintSetStart " + r9);
    L22:
        if (this.mScene.d(r8) != null) goto L8;
        Log.e(TAG, " no such constraintSetEnd " + r9);
        goto L8
    }

    private void checkStructure(int r12, com.obric.oui.constraintlayout.widget.b r13) {
        String r14 = com.obric.oui.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r12);
        int r0 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L12;
        View r7 = getChildAt(r3);
        int r8 = r7.getId();
        if (r8 != (-1)) goto L9;
        Log.w(TAG, "CHECK: " + r14 + " ALL VIEWS SHOULD HAVE ID's " + r7.getClass().getName() + " does not!");
    L9:
        if (r13.f(r8) != null) goto L11;
        Log.w(TAG, "CHECK: " + r14 + " NO CONSTRAINTS for " + com.obric.oui.constraintlayout.motion.widget.a.a(r7));
    L11:
        r3 = r3 + 1;
        goto L4
    L12:
        int[] r1 = r13.b();
    L14:
        if (r2 >= r1.length) goto L25;
        int r4 = r1[r2];
        String r9 = com.obric.oui.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        if (findViewById(r1[r2]) != null) goto L19;
        Log.w(TAG, "CHECK: " + r14 + " NO View matches id " + r9);
    L19:
        if (r13.d(r4) != (-1)) goto L22;
        Log.w(TAG, "CHECK: " + r14 + "(" + r9 + ") no LAYOUT_HEIGHT");
    L22:
        if (r13.e(r4) != (-1)) goto L24;
        Log.w(TAG, "CHECK: " + r14 + "(" + r9 + ") no LAYOUT_HEIGHT");
    L24:
        r2 = r2 + 1;
        goto L14
    }

    private void checkStructure(q.a r1) {
        if (r1.d() != r1.c()) goto L6;
        Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        return;
    }

    private void computeCurrentPositions() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = getChildAt(r1);
        m r3 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r2), m.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        r3.b(r2);
    L8:
        r1 = r1 + 1;
        goto L3
    }

    private void debugPos() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L6;
        View r1 = getChildAt(r0);
        Log.v(TAG, " " + com.obric.oui.constraintlayout.motion.widget.a.a() + " " + com.obric.oui.constraintlayout.motion.widget.a.a(this) + " " + com.obric.oui.constraintlayout.motion.widget.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mCurrentState) + " " + com.obric.oui.constraintlayout.motion.widget.a.a(r1) + r1.getLeft() + " " + r1.getTop());
        r0 = r0 + 1;
        goto L4
    }

    private void evaluateLayout() {
        float r0 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long r1 = getNanoTime();
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, com.obric.oui.constraintlayout.motion.a.b.class) == true) goto L5;
        float r3 = (((r1 - this.mTransitionLastTime) * r0) * 1.0E-9f) / this.mTransitionDuration;
    L6:
        float r6 = this.mTransitionLastPosition + r3;
        if (this.mTransitionInstantly == false) goto L9;
        r6 = this.mTransitionGoalPosition;
    L9:
        int r7 = 0;
        if (r0 <= 0.0f) goto L14;
        if (r6 < this.mTransitionGoalPosition) goto L14;
    L17:
        r6 = this.mTransitionGoalPosition;
        boolean r8 = true;
    L19:
        Interpolator r9 = this.mInterpolator;
        if (r9 == null) goto L26;
        if (r8 == true) goto L26;
        if (this.mTemporalInterpolator == false) goto L25;
        r6 = r9.getInterpolation((r1 - this.mAnimationStartTime) * 1.0E-9f);
        goto L26
    L25:
        r6 = r9.getInterpolation(r6);
    L26:
        if (r0 <= 0.0f) goto L30;
        if (r6 < this.mTransitionGoalPosition) goto L30;
    L33:
        r6 = this.mTransitionGoalPosition;
    L34:
        this.mPostInterpolationPosition = r6;
        int r2 = getChildCount();
        long r4 = getNanoTime();
        Interpolator r5 = this.mProgressInterpolator;
        if (r5 == null) goto L38;
        r6 = r5.getInterpolation(r6);
    L38:
        if (r7 >= r2) goto L44;
        View r10 = getChildAt(r7);
        m r11 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r10), m.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L42;
        r11.a(r10, r6, r4, this.mKeyCache);
    L42:
        r7 = r7 + 1;
        goto L38
    L44:
        if (this.mMeasureDuringTransition == false) goto L51;
        requestLayout();
        return;
    L51:
        return;
    L30:
        if (r0 > 0.0f) goto L34;
        if (r6 > this.mTransitionGoalPosition) goto L34;
    L14:
        if (r0 <= 0.0f) goto L16;
    L18:
        r8 = false;
        goto L19
    L16:
        if (r6 > this.mTransitionGoalPosition) goto L18;
    L5:
        r3 = 0.0f;
        goto L6
    }

    private void fireTransitionChange() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<g> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.mListenerPosition != this.mTransitionPosition) goto L11;
        return;
    L11:
        if (this.mListenerState == (-1)) goto L13;
        fireTransitionStarted();
        this.mIsAnimating = true;
    L13:
        this.mListenerState = -1;
        float r1 = this.mTransitionPosition;
        this.mListenerPosition = r1;
        g r2 = this.mTransitionListener;
        if (r2 == null) goto L16;
        r2.a(this, this.mBeginState, this.mEndState, r1);
    L16:
        CopyOnWriteArrayList<g> r3 = this.mTransitionListeners;
        if (r3 == null) goto L22;
        Iterator<g> r4 = r3.iterator();
    L20:
        if (r4.hasNext() == false) goto L22;
        ((g) ZeusTransformUtils.preCheckCast(r4.next(), g.class, "com.obric.memorydata.plugin")).a(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
    L22:
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted() {
        g r0 = this.mTransitionListener;
        if (r0 == null) goto L5;
        r0.a(this, this.mBeginState, this.mEndState);
    L5:
        CopyOnWriteArrayList<g> r1 = this.mTransitionListeners;
        if (r1 == null) goto L11;
        Iterator<g> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        ((g) ZeusTransformUtils.preCheckCast(r2.next(), g.class, "com.obric.memorydata.plugin")).a(this, this.mBeginState, this.mEndState);
        goto L9
    L13:
        return;
    }

    private boolean handlesTouchEvent(float r8, float r9, View r10, MotionEvent r11) {
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.class) == false) goto L10;
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin");
        int r2 = r0.getChildCount() - 1;
    L5:
        if (r2 < 0) goto L10;
        View r3 = r0.getChildAt(r2);
        if (handlesTouchEvent((r3.getLeft() + r8) - r10.getScrollX(), (r3.getTop() + r9) - r10.getScrollY(), r3, r11) == true) goto L8;
        r2 = r2 - 1;
        goto L5
    L8:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L20;
        this.mBoundsCheck.set(r8, r9, (r10.getRight() + r8) - r10.getLeft(), (r10.getBottom() + r9) - r10.getTop());
        if (r11.getAction() != 0) goto L17;
        if (this.mBoundsCheck.contains(r11.getX(), r11.getY()) == false) goto L20;
    L17:
        if (callTransformedTouchEvent(r10, r11, -r8, -r9) == false) goto L20;
        return true;
    L20:
        return r1;
    L10:
        r1 = false;
        goto L11
    }

    private void init(AttributeSet r12) {
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        IS_IN_EDIT_MODE = isInEditMode();
        if (r13 == null) goto L37;
        TypedArray r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r13, R.styleable.MotionLayout);
        int r2 = r14.getIndexCount();
        boolean r6 = true;
        int r5 = 0;
    L5:
        if (r5 >= r2) goto L31;
        int r7 = r14.getIndex(r5);
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_layoutDescription, "styleable", "MotionLayout_layoutDescription")) goto L10;
        this.mScene = new q((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, r14.getResourceId(r7, -1));
    L30:
        r5 = r5 + 1;
        goto L5
    L10:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_currentState, "styleable", "MotionLayout_currentState")) goto L13;
        this.mCurrentState = r14.getResourceId(r7, -1);
        goto L30
    L13:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_motionProgress, "styleable", "MotionLayout_motionProgress")) goto L16;
        this.mTransitionGoalPosition = r14.getFloat(r7, 0.0f);
        this.mInTransition = true;
        goto L30
    L16:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_applyMotionScene, "styleable", "MotionLayout_applyMotionScene")) goto L19;
        r6 = r14.getBoolean(r7, r6);
        goto L30
    L19:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_showPaths, "styleable", "MotionLayout_showPaths")) goto L27;
        if (this.mDebugPath != 0) goto L30;
        if (r14.getBoolean(r7, false) == false) goto L25;
        int r8 = 2;
    L29:
        this.mDebugPath = r8;
        goto L30
    L25:
        r8 = 0;
        goto L29
    L27:
        if (r7 != ZeusTransformUtils.mapRes(R.styleable.MotionLayout_motionDebug, "styleable", "MotionLayout_motionDebug")) goto L30;
        r8 = r14.getInt(r7, 0);
        goto L29
    L31:
        r14.recycle();
        if (this.mScene != null) goto L34;
        Log.e(TAG, "WARNING NO app:layoutDescription tag");
    L34:
        if (r6 == true) goto L37;
        this.mScene = null;
    L37:
        if (this.mDebugPath == 0) goto L40;
        checkStructure();
    L40:
        if (this.mCurrentState != (-1)) goto L53;
        q r15 = this.mScene;
        if (r15 == null) goto L54;
        this.mCurrentState = r15.d();
        this.mBeginState = this.mScene.d();
        this.mEndState = this.mScene.e();
        return;
    L54:
        return;
    }

    private void processTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<g> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return;
    L9:
        this.mIsAnimating = false;
        Iterator<Integer> r1 = this.mTransitionCompleted.iterator();
    L11:
        if (r1.hasNext() == false) goto L21;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin");
        g r3 = this.mTransitionListener;
        if (r3 == null) goto L15;
        r3.a(this, r2.intValue());
    L15:
        CopyOnWriteArrayList<g> r4 = this.mTransitionListeners;
        if (r4 == null) goto L11;
        Iterator<g> r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L11;
        ((g) ZeusTransformUtils.preCheckCast(r5.next(), g.class, "com.obric.memorydata.plugin")).a(this, r2.intValue());
        goto L19
    L21:
        this.mTransitionCompleted.clear();
    }

    private void setupMotionViews() {
        int r1 = getChildCount();
        this.mModel.b();
        boolean r2 = true;
        this.mInTransition = true;
        SparseArray r3 = new SparseArray();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r5 >= r1) goto L6;
        View r7 = getChildAt(r5);
        r3.put(r7.getId(), (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r7), m.class, "com.obric.memorydata.plugin"));
        r5 = r5 + 1;
        goto L4
    L6:
        int r6 = getWidth();
        int r8 = getHeight();
        int r9 = this.mScene.h();
        if (r9 == (-1)) goto L14;
        int r10 = 0;
    L9:
        if (r10 >= r1) goto L14;
        m r11 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r10)), m.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L13;
        r11.b(r9);
    L13:
        r10 = r10 + 1;
    L14:
        SparseBooleanArray r13 = new SparseBooleanArray();
        int[] r14 = new int[this.mFrameArrayList.size()];
        int r12 = 0;
        int r15 = 0;
    L15:
        if (r12 >= r1) goto L21;
        m r16 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r12)), m.class, "com.obric.memorydata.plugin");
        if (r16.e() == (-1)) goto L19;
        r13.put(r16.e(), true);
        r14[r15] = r16.e();
        r15 = r15 + 1;
    L19:
        r12 = r12 + 1;
        goto L15
    L21:
        if (this.mDecoratorsHelpers == null) goto L40;
        int r17 = 0;
    L23:
        if (r17 >= r15) goto L29;
        m r18 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(findViewById(r14[r17])), m.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L28;
        this.mScene.a(r18);
    L28:
        r17 = r17 + 1;
        goto L23
    L29:
        Iterator<MotionHelper> r19 = this.mDecoratorsHelpers.iterator();
    L31:
        if (r19.hasNext() == false) goto L33;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r19.next(), MotionHelper.class, "com.obric.memorydata.plugin")).a(this, this.mFrameArrayList);
        goto L31
    L33:
        int r110 = 0;
    L34:
        if (r110 >= r15) goto L47;
        m r20 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(findViewById(r14[r110])), m.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L39;
        r20.a(r6, r8, this.mTransitionDuration, getNanoTime());
    L39:
        r110 = r110 + 1;
    L47:
        int r111 = 0;
    L48:
        if (r111 >= r1) goto L55;
        View r21 = getChildAt(r111);
        m r22 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r21), m.class, "com.obric.memorydata.plugin");
        if (r13.get(r21.getId()) == true) goto L54;
        if (r22 == null) goto L54;
        this.mScene.a(r22);
        r22.a(r6, r8, this.mTransitionDuration, getNanoTime());
    L54:
        r111 = r111 + 1;
        goto L48
    L55:
        float r23 = this.mScene.i();
        if (r23 != 0.0f) goto L58;
        return;
    L58:
        if (r23 >= 0.0d) goto L60;
        boolean r24 = true;
    L61:
        float r25 = Math.abs(r23);
        float r26 = -3.4028235E38f;
        float r27 = Float.MAX_VALUE;
        int r28 = 0;
        float r112 = -3.4028235E38f;
        float r113 = Float.MAX_VALUE;
    L62:
        if (r28 >= r1) goto L71;
        m r114 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r28)), m.class, "com.obric.memorydata.plugin");
        if (Float.isNaN(r114.f) == false) goto L73;
        float r115 = r114.c();
        float r116 = r114.d();
        if (r24 == false) goto L69;
        float r117 = r116 - r115;
    L70:
        r113 = Math.min(r113, r117);
        r112 = Math.max(r112, r117);
        r28 = r28 + 1;
        goto L62
    L69:
        r117 = r116 + r115;
    L73:
        if (r2 == false) goto L89;
        int r29 = 0;
    L75:
        if (r29 >= r1) goto L80;
        m r118 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r29)), m.class, "com.obric.memorydata.plugin");
        if (Float.isNaN(r118.f) == true) goto L79;
        r27 = Math.min(r27, r118.f);
        r26 = Math.max(r26, r118.f);
    L79:
        r29 = r29 + 1;
    L80:
        if (r4 >= r1) goto L130;
        m r30 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r4)), m.class, "com.obric.memorydata.plugin");
        if (Float.isNaN(r30.f) == true) goto L88;
        r30.h = 1.0f / (1.0f - r25);
        float r119 = r30.f;
        if (r24 == false) goto L86;
        float r120 = ((r26 - r119) / (r26 - r27)) * r25;
    L87:
        r30.g = r25 - r120;
        goto L88
    L86:
        r120 = ((r119 - r27) * r25) / (r26 - r27);
    L88:
        r4 = r4 + 1;
        goto L80
    L130:
        return;
    L89:
        if (r4 >= r1) goto L131;
        m r31 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r4)), m.class, "com.obric.memorydata.plugin");
        float r32 = r31.c();
        float r33 = r31.d();
        if (r24 == false) goto L93;
        float r34 = r33 - r32;
    L94:
        r31.h = 1.0f / (1.0f - r25);
        r31.g = r25 - (((r34 - r113) * r25) / (r112 - r113));
        r4 = r4 + 1;
        goto L89
    L93:
        r34 = r33 + r32;
        goto L94
    L131:
        return;
    L71:
        r2 = false;
        goto L73
    L60:
        r24 = false;
        goto L61
    L40:
        int r121 = 0;
    L41:
        if (r121 >= r15) goto L47;
        m r35 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(findViewById(r14[r121])), m.class, "com.obric.memorydata.plugin");
        if (r35 == null) goto L46;
        this.mScene.a(r35);
        r35.a(r6, r8, this.mTransitionDuration, getNanoTime());
    L46:
        r121 = r121 + 1;
        goto L41
    }

    private Rect toRect(ConstraintWidget r4) {
        Rect r0 = this.mTempRect;
        r0.top = r4.E();
        Rect r1 = this.mTempRect;
        r1.left = r4.D();
        Rect r2 = this.mTempRect;
        r2.right = r4.F() + this.mTempRect.left;
        Rect r3 = this.mTempRect;
        r3.bottom = r4.G() + this.mTempRect.top;
        return this.mTempRect;
    }

    private static boolean willJump(float r5, float r6, float r7) {
        if (r5 <= 0.0f) goto L9;
        float r0 = r5 / r7;
        if ((r6 + ((r5 * r0) - (((r7 * r0) * r0) / 2.0f))) <= 1.0f) goto L8;
        return true;
    L8:
        return false;
    L9:
        float r1 = (-r5) / r7;
        if ((r6 + ((r5 * r1) + (((r7 * r1) * r1) / 2.0f))) >= 0.0f) goto L13;
        return true;
    L13:
        return false;
    }

    public void addTransitionListener(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        if (this.mTransitionListeners != null) goto L5;
        this.mTransitionListeners = new CopyOnWriteArrayList();
    L5:
        this.mTransitionListeners.add(r4);
    }

    void animateTo(float r5) {
        q r0 = this.mScene;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = this.mTransitionLastPosition;
        float r2 = this.mTransitionPosition;
        if (r1 != r2) goto L8;
    L10:
        float r3 = this.mTransitionLastPosition;
        if (r3 != r5) goto L13;
        return;
    L13:
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = r5;
        this.mTransitionDuration = r0.g() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = null;
        this.mProgressInterpolator = this.mScene.f();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = r3;
        this.mTransitionLastPosition = r3;
        invalidate();
        return;
    L8:
        if (this.mTransitionInstantly == false) goto L10;
        this.mTransitionLastPosition = r2;
        goto L10
    }

    public boolean applyViewTransition(int r1, m r2) {
        q r0 = this.mScene;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a(r1, r2);
    }

    public com.obric.oui.constraintlayout.widget.b cloneConstraintSet(int r1) {
        q r0 = this.mScene;
        if (r0 != null) goto L6;
        return null;
    L6:
        com.obric.oui.constraintlayout.widget.b r2 = r0.d(r1);
        com.obric.oui.constraintlayout.widget.b r3 = new com.obric.oui.constraintlayout.widget.b();
        r3.c(r2);
        return r3;
    }

    void disableAutoTransition(boolean r1) {
        q r0 = this.mScene;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r1);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r11) {
        ArrayList<MotionHelper> r0 = this.mDecoratorsHelpers;
        if (r0 == null) goto L8;
        Iterator<MotionHelper> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r1.next(), MotionHelper.class, "com.obric.memorydata.plugin")).a(r11);
    L8:
        evaluate(false);
        q r2 = this.mScene;
        if (r2 != null) goto L11;
    L13:
        super.dispatchDraw(r11);
        if (this.mScene != null) goto L17;
        return;
    L17:
        if ((this.mDebugPath & 1) != 1) goto L32;
        if (isInEditMode() == true) goto L32;
        this.mFrames++;
        long r4 = getNanoTime();
        long r6 = this.mLastDrawTime;
        if (r6 == (-1)) goto L25;
        long r7 = r4 - r6;
        if (r7 <= 200000000) goto L26;
        this.mLastFps = ((int) ((this.mFrames / (r7 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.mFrames = 0;
    L26:
        Paint r3 = new Paint();
        r3.setTextSize(42.0f);
        StringBuilder r5 = new StringBuilder().append(this.mLastFps + " fps " + com.obric.oui.constraintlayout.motion.widget.a.a(this, this.mBeginState) + " -> ").append(com.obric.oui.constraintlayout.motion.widget.a.a(this, this.mEndState)).append(" (progress: ").append(((int) (getProgress() * 1000.0f)) / 10.0f).append(" ) state=");
        int r8 = this.mCurrentState;
        if (r8 != (-1)) goto L29;
        String r9 = "undefined";
    L30:
        String r10 = r5.append(r9).toString();
        r3.setColor(ViewCompat.MEASURED_STATE_MASK);
        r11.drawText(r10, 11.0f, getHeight() - 29, r3);
        r3.setColor(-7864184);
        r11.drawText(r10, 10.0f, getHeight() - 30, r3);
        goto L32
    L29:
        r9 = com.obric.oui.constraintlayout.motion.widget.a.a(this, r8);
    L25:
        this.mLastDrawTime = r4;
    L32:
        if (this.mDebugPath > 1) goto L34;
    L37:
        ArrayList<MotionHelper> r12 = this.mDecoratorsHelpers;
        if (r12 == null) goto L43;
        Iterator<MotionHelper> r13 = r12.iterator();
    L41:
        if (r13.hasNext() == false) goto L46;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r13.next(), MotionHelper.class, "com.obric.memorydata.plugin")).b(r11);
        goto L41
    L46:
        return;
    L43:
        return;
    L34:
        if (this.mDevModeDraw != null) goto L36;
        this.mDevModeDraw = new b(this);
    L36:
        this.mDevModeDraw.a(r11, this.mFrameArrayList, this.mScene.g(), this.mDebugPath);
        goto L37
    L11:
        if (r2.c == null) goto L13;
        this.mScene.c.a();
        goto L13
    }

    public void enableTransition(int r4, boolean r5) {
        q.a r6 = getTransition(r4);
        if (r5 == false) goto L8;
        boolean r3 = true;
    L5:
        r6.a(r3);
        return;
    L8:
        if (r6 != this.mScene.f13703b) goto L15;
        Iterator<q.a> r7 = this.mScene.a(this.mCurrentState).iterator();
    L11:
        if (r7.hasNext() == false) goto L15;
        q.a r0 = (q.a) ZeusTransformUtils.preCheckCast(r7.next(), q.a.class, "com.obric.memorydata.plugin");
        if (r0.f() == false) goto L11;
        this.mScene.f13703b = r0;
    L15:
        r3 = false;
        goto L5
    }

    public void enableViewTransition(int r1, boolean r2) {
        q r0 = this.mScene;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    void endTrigger(boolean r6) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = getChildAt(r1);
        m r3 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r2), m.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        r3.a(r6);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    void evaluate(boolean r24) {
        if (this.mTransitionLastTime != (-1)) goto L5;
        this.mTransitionLastTime = getNanoTime();
    L5:
        float r1 = this.mTransitionLastPosition;
        if (r1 > 0.0f) goto L8;
    L10:
        boolean r7 = false;
        if (this.mKeepAnimating == false) goto L13;
    L19:
        float r2 = Math.signum(this.mTransitionGoalPosition - r1);
        long r8 = getNanoTime();
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, o.class) == true) goto L22;
        float r3 = (((r8 - this.mTransitionLastTime) * r2) * 1.0E-9f) / this.mTransitionDuration;
    L23:
        float r11 = this.mTransitionLastPosition + r3;
        if (this.mTransitionInstantly == false) goto L27;
        r11 = this.mTransitionGoalPosition;
    L27:
        if (r2 <= 0.0f) goto L31;
        if (r11 < this.mTransitionGoalPosition) goto L31;
    L34:
        r11 = this.mTransitionGoalPosition;
        this.mInTransition = false;
        boolean r13 = true;
    L36:
        this.mTransitionLastPosition = r11;
        this.mTransitionPosition = r11;
        this.mTransitionLastTime = r8;
        Interpolator r15 = this.mInterpolator;
        if (r15 == null) goto L70;
        if (r13 == true) goto L70;
        if (this.mTemporalInterpolator == false) goto L65;
        float r4 = r15.getInterpolation((r8 - this.mAnimationStartTime) * 1.0E-9f);
        Interpolator r5 = this.mInterpolator;
        com.obric.oui.constraintlayout.motion.a.b r6 = this.mStopLogic;
        if (r5 == r6) goto L44;
        char r9 = 0;
    L48:
        this.mTransitionLastPosition = r4;
        this.mTransitionLastTime = r8;
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, o.class) == false) goto L64;
        float r10 = ((o) ZeusTransformUtils.preCheckCast(this.mInterpolator, o.class, "com.obric.memorydata.plugin")).a();
        this.mLastVelocity = r10;
        if ((Math.abs(r10) * this.mTransitionDuration) > EPSILON) goto L55;
        if (r9 != 2) goto L55;
        this.mInTransition = false;
    L55:
        if (r10 <= 0.0f) goto L60;
        if (r4 < 1.0f) goto L60;
        this.mTransitionLastPosition = 1.0f;
        this.mInTransition = false;
        r4 = 1.0f;
    L60:
        if (r10 >= 0.0f) goto L64;
        if (r4 > 0.0f) goto L64;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = false;
        r11 = 0.0f;
    L73:
        if (Math.abs(this.mLastVelocity) <= EPSILON) goto L76;
        setState(TransitionState.MOVING);
    L76:
        if (r9 == 1) goto L90;
        if (r2 <= 0.0f) goto L81;
        if (r11 < this.mTransitionGoalPosition) goto L81;
    L84:
        r11 = this.mTransitionGoalPosition;
        this.mInTransition = false;
    L86:
        if (r11 < 1.0f) goto L88;
    L89:
        this.mInTransition = false;
        setState(TransitionState.FINISHED);
        goto L90
    L88:
        if (r11 > 0.0f) goto L90;
    L81:
        if (r2 > 0.0f) goto L86;
        if (r11 > this.mTransitionGoalPosition) goto L86;
    L90:
        int r12 = getChildCount();
        this.mKeepAnimating = false;
        long r14 = getNanoTime();
        this.mPostInterpolationPosition = r11;
        Interpolator r16 = this.mProgressInterpolator;
        if (r16 != null) goto L93;
        float r17 = r11;
    L94:
        Interpolator r18 = this.mProgressInterpolator;
        if (r18 == null) goto L97;
        float r19 = r18.getInterpolation((r2 / this.mTransitionDuration) + r11);
        this.mLastVelocity = r19;
        this.mLastVelocity = r19 - this.mProgressInterpolator.getInterpolation(r11);
    L97:
        int r20 = 0;
    L98:
        if (r20 >= r12) goto L103;
        View r110 = getChildAt(r20);
        m r111 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r110), m.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L102;
        this.mKeepAnimating = r111.a(r110, r17, r14, this.mKeyCache) | this.mKeepAnimating;
    L102:
        r20 = r20 + 1;
        goto L98
    L103:
        if (r2 <= 0.0f) goto L107;
        if (r11 < this.mTransitionGoalPosition) goto L107;
    L110:
        boolean r21 = true;
    L113:
        if (this.mKeepAnimating == true) goto L119;
        if (this.mInTransition == true) goto L119;
        if (r21 == false) goto L119;
        setState(TransitionState.FINISHED);
    L119:
        if (this.mMeasureDuringTransition == false) goto L121;
        requestLayout();
    L121:
        boolean r22 = true;
        this.mKeepAnimating = (!r21) | this.mKeepAnimating;
        if (r11 > 0.0f) goto L129;
        int r23 = this.mBeginState;
        if (r23 == (-1)) goto L129;
        if (this.mCurrentState == r23) goto L129;
        this.mCurrentState = r23;
        this.mScene.d(r23).d(this);
        setState(TransitionState.FINISHED);
        r7 = true;
    L129:
        if (r11 < 1.0d) goto L134;
        int r25 = this.mCurrentState;
        int r26 = this.mEndState;
        if (r25 == r26) goto L134;
        this.mCurrentState = r26;
        this.mScene.d(r26).d(this);
        setState(TransitionState.FINISHED);
        r7 = true;
    L134:
        if (this.mKeepAnimating == false) goto L136;
    L146:
        invalidate();
    L148:
        if (this.mKeepAnimating == false) goto L150;
    L159:
        float r27 = this.mTransitionLastPosition;
        if (r27 < 1.0f) goto L167;
        int r28 = this.mCurrentState;
        int r29 = this.mEndState;
        if (r28 == r29) goto L164;
    L163:
        boolean r30 = r22;
    L165:
        this.mCurrentState = r29;
        r7 = r30;
    L171:
        this.mNeedsFireTransitionCompleted |= r7;
        if (r7 == true) goto L174;
    L176:
        this.mTransitionPosition = this.mTransitionLastPosition;
        return;
    L174:
        if (this.mInLayout == true) goto L176;
        requestLayout();
    L164:
        r30 = r7;
        goto L165
    L167:
        if (r27 > 0.0f) goto L171;
        int r31 = this.mCurrentState;
        r29 = this.mBeginState;
        if (r31 == r29) goto L164;
    L150:
        if (this.mInTransition == true) goto L159;
        if (r2 <= 0.0f) goto L155;
        if (r11 != 1.0f) goto L155;
    L158:
        onNewStateAttachHandlers();
    L155:
        if (r2 >= 0.0f) goto L159;
        if (r11 != 0.0f) goto L159;
    L136:
        if (this.mInTransition == true) goto L146;
        if (r2 <= 0.0f) goto L142;
        if (r11 != 1.0f) goto L142;
    L145:
        setState(TransitionState.FINISHED);
    L142:
        if (r2 >= 0.0f) goto L148;
        if (r11 != 0.0f) goto L148;
    L107:
        if (r2 <= 0.0f) goto L109;
    L111:
        r21 = false;
        goto L113
    L109:
        if (r11 > this.mTransitionGoalPosition) goto L111;
    L93:
        r17 = r16.getInterpolation(r11);
    L64:
        r11 = r4;
        goto L73
    L44:
        if (r6.b() == false) goto L46;
        r9 = 2;
        goto L48
    L46:
        r9 = 1;
        goto L48
    L65:
        float r32 = r15.getInterpolation(r11);
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, o.class) == false) goto L68;
        this.mLastVelocity = ((o) ZeusTransformUtils.preCheckCast(this.mInterpolator, o.class, "com.obric.memorydata.plugin")).a();
    L69:
        r11 = r32;
    L71:
        r9 = 0;
        goto L73
    L68:
        this.mLastVelocity = ((this.mInterpolator.getInterpolation(r11 + r3) - r32) * r2) / r3;
    L70:
        this.mLastVelocity = r3;
    L31:
        if (r2 <= 0.0f) goto L33;
    L35:
        r13 = false;
        goto L36
    L33:
        if (r11 > this.mTransitionGoalPosition) goto L35;
    L22:
        r3 = 0.0f;
        goto L23
    L13:
        if (this.mInTransition == false) goto L18;
        if (r24 == true) goto L19;
        if (this.mTransitionGoalPosition != r1) goto L19;
    L18:
        r22 = true;
        goto L159
    L8:
        if (r1 >= 1.0f) goto L10;
        this.mCurrentState = -1;
        goto L10
    }

    public void fireTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<g> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
    L18:
        processTransitionCompleted();
        Runnable r1 = this.mOnComplete;
        if (r1 == null) goto L21;
        r1.run();
        this.mOnComplete = null;
    L21:
        int[] r2 = this.mScheduledTransitionTo;
        if (r2 != null) goto L24;
        return;
    L24:
        if (this.mScheduledTransitions <= 0) goto L28;
        transitionToState(r2[0]);
        int[] r3 = this.mScheduledTransitionTo;
        System.arraycopy(r3, 1, r3, 0, r3.length - 1);
        this.mScheduledTransitions--;
        return;
    L28:
        return;
    L7:
        if (r0.isEmpty() == true) goto L18;
    L9:
        if (this.mListenerState != (-1)) goto L18;
        this.mListenerState = this.mCurrentState;
        if (this.mTransitionCompleted.isEmpty() == true) goto L13;
        ArrayList<Integer> r4 = this.mTransitionCompleted;
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r4.get(r4.size() - 1), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L14:
        int r6 = this.mCurrentState;
        if (r5 == r6) goto L18;
        if (r6 == (-1)) goto L18;
        this.mTransitionCompleted.add(Integer.valueOf(r6));
        goto L18
    L13:
        r5 = -1;
        goto L14
    }

    public void fireTrigger(int r5, boolean r6, float r7) {
        g r0 = this.mTransitionListener;
        if (r0 == null) goto L5;
        r0.a(this, r5, r6, r7);
    L5:
        CopyOnWriteArrayList<g> r1 = this.mTransitionListeners;
        if (r1 == null) goto L11;
        Iterator<g> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        ((g) ZeusTransformUtils.preCheckCast(r2.next(), g.class, "com.obric.memorydata.plugin")).a(this, r5, r6, r7);
        goto L9
    L13:
        return;
    }

    void getAnchorDpDt(int r5, float r6, float r7, float r8, float[] r9) {
        HashMap<View, m> r0 = this.mFrameArrayList;
        View r1 = getViewById(r5);
        m r2 = (m) ZeusTransformUtils.preCheckCast(r0.get(r1), m.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        r2.a(r6, r7, r8, r9);
        float r10 = r1.getY();
        int r11 = ((r6 - this.mLastPos) > 0.0f ? 1 : ((r6 - this.mLastPos) == 0.0f ? 0 : -1));
        this.mLastPos = r6;
        this.mLastY = r10;
        return;
    L5:
        if (r1 != null) goto L7;
        String r4 = "" + r5;
    L8:
        Log.w(TAG, "WARNING could not find view id " + r4);
        return;
    L7:
        r4 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceName(r5);
        goto L8
    }

    public com.obric.oui.constraintlayout.widget.b getConstraintSet(int r1) {
        q r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d(r1);
    }

    public int[] getConstraintSetIds() {
        q r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    String getConstraintSetNames(int r1) {
        q r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f(r1);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public ArrayList<q.a> getDefinedTransitions() {
        q r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public com.obric.oui.constraintlayout.motion.widget.b getDesignTool() {
        if (this.mDesignTool != null) goto L6;
        this.mDesignTool = new com.obric.oui.constraintlayout.motion.widget.b(this);
    L6:
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public int[] getMatchingConstraintSetIds(String... r1) {
        q r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r1);
    }

    m getMotionController(int r2) {
        return (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(findViewById(r2)), m.class, "com.obric.memorydata.plugin");
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public q getScene() {
        return this.mScene;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public q.a getTransition(int r1) {
        return this.mScene.b(r1);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new f(this);
    L5:
        this.mStateCache.c();
        return this.mStateCache.b();
    }

    public long getTransitionTimeMs() {
        q r0 = this.mScene;
        if (r0 == null) goto L6;
        this.mTransitionDuration = r0.g() / 1000.0f;
    L6:
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View r9, float r10, float r11, float[] r12, int r13) {
        float r0 = this.mLastVelocity;
        float r1 = this.mTransitionLastPosition;
        if (this.mInterpolator == null) goto L5;
        float r2 = Math.signum(this.mTransitionGoalPosition - r1);
        float r3 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
        float r4 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
        r0 = (r2 * ((r3 - r4) / EPSILON)) / this.mTransitionDuration;
        float r5 = r4;
    L7:
        if (ZeusTransformUtils.instanceOf(this.mInterpolator, o.class) == false) goto L9;
        r0 = ((o) ZeusTransformUtils.preCheckCast(this.mInterpolator, o.class, "com.obric.memorydata.plugin")).a();
    L9:
        m r6 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r9), m.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) != 0) goto L12;
        r6.a(r5, r9.getWidth(), r9.getHeight(), r10, r11, r12);
    L14:
        if (r13 >= 2) goto L17;
        r12[0] = r12[0] * r0;
        r12[1] = r12[1] * r0;
        return;
    L17:
        return;
    L12:
        r6.a(r5, r10, r11, r12);
        goto L14
    L5:
        r5 = r1;
        goto L7
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

    public boolean isViewTransitionEnabled(int r1) {
        q r0 = this.mScene;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.c(r1);
    }

    public void jumpToState(int r2) {
        if (isAttachedToWindow() == true) goto L6;
        this.mCurrentState = r2;
    L6:
        if (this.mBeginState != r2) goto L10;
        float r3 = 0.0f;
    L8:
        setProgress(r3);
        return;
    L10:
        if (this.mEndState != r2) goto L12;
        r3 = 1.0f;
        goto L8
    L12:
        setTransition(r2, r2);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int r7) {
        if (r7 != 0) goto L50;
        this.mScene = null;
        return;
    L50:
        q r3 = new q((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, r7);     // Catch: Exception -> L44
        this.mScene = r3;     // Catch: Exception -> L44
        if (this.mCurrentState != (-1)) goto L9;
        if (r3 == null) goto L9;
        this.mCurrentState = r3.d();     // Catch: Exception -> L44
        this.mBeginState = this.mScene.d();     // Catch: Exception -> L44
        this.mEndState = this.mScene.e();     // Catch: Exception -> L44
    L9:
        if (isAttachedToWindow() == true) goto L49;
        this.mScene = null;     // Catch: Exception -> L44
        return;
    L49:
        Display r8 = getDisplay();     // Catch: Exception -> L39
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        this.mPreviouseRotation = r9;     // Catch: Exception -> L39
        q r10 = this.mScene;     // Catch: Exception -> L39
        if (r10 == null) goto L25;
        com.obric.oui.constraintlayout.widget.b r11 = r10.d(this.mCurrentState);     // Catch: Exception -> L39
        this.mScene.a(this);     // Catch: Exception -> L39
        ArrayList<MotionHelper> r2 = this.mDecoratorsHelpers;     // Catch: Exception -> L39
        if (r2 == null) goto L22;
        Iterator<MotionHelper> r4 = r2.iterator();     // Catch: Exception -> L39
    L20:
        if (r4.hasNext() == false) goto L22;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r4.next(), MotionHelper.class, "com.obric.memorydata.plugin")).a(this);     // Catch: Exception -> L39
    L22:
        if (r11 == null) goto L24;
        r11.c(this);     // Catch: Exception -> L39
    L24:
        this.mBeginState = this.mCurrentState;     // Catch: Exception -> L39
    L25:
        onNewStateAttachHandlers();     // Catch: Exception -> L39
        f r12 = this.mStateCache;     // Catch: Exception -> L39
        if (r12 != null) goto L28;
        q r13 = this.mScene;     // Catch: Exception -> L39
        if (r13 != null) goto L34;
        return;
    L34:
        if (r13.f13703b != null) goto L36;
        return;
    L36:
        if (this.mScene.f13703b.b() != 4) goto L56;
        transitionToEnd();     // Catch: Exception -> L39
        setState(TransitionState.SETUP);     // Catch: Exception -> L39
        setState(TransitionState.MOVING);     // Catch: Exception -> L39
        return;
    L56:
        return;
    L28:
        if (this.mDelayedApply == false) goto L30;
        post(new AnonymousClass1(this));     // Catch: Exception -> L39
        return;
    L30:
        r12.a();     // Catch: Exception -> L39
        return;
    L13:
        r9 = r8.getRotation();     // Catch: Exception -> L39
    L39:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);     // Catch: Exception -> L44
    L44:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);
    }

    int lookUpConstraintId(String r1) {
        q r0 = this.mScene;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b(r1);
    }

    public d obtainVelocityTracker() {
        return e.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display r0 = getDisplay();
        if (r0 == null) goto L5;
        this.mPreviouseRotation = r0.getRotation();
    L5:
        q r1 = this.mScene;
        if (r1 == null) goto L18;
        int r2 = this.mCurrentState;
        if (r2 == (-1)) goto L18;
        com.obric.oui.constraintlayout.widget.b r3 = r1.d(r2);
        this.mScene.a(this);
        ArrayList<MotionHelper> r4 = this.mDecoratorsHelpers;
        if (r4 == null) goto L15;
        Iterator<MotionHelper> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r5.next(), MotionHelper.class, "com.obric.memorydata.plugin")).a(this);
    L15:
        if (r3 == null) goto L17;
        r3.c(this);
    L17:
        this.mBeginState = this.mCurrentState;
    L18:
        onNewStateAttachHandlers();
        f r6 = this.mStateCache;
        if (r6 != null) goto L21;
        q r7 = this.mScene;
        if (r7 != null) goto L27;
        return;
    L27:
        if (r7.f13703b != null) goto L29;
        return;
    L29:
        if (this.mScene.f13703b.b() != 4) goto L37;
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L37:
        return;
    L21:
        if (this.mDelayedApply == false) goto L23;
        post(new AnonymousClass4(this));
        return;
    L23:
        r6.a();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        q r0 = this.mScene;
        if (r0 != null) goto L5;
    L38:
        return false;
    L5:
        if (this.mInteractionEnabled == false) goto L38;
        if (r0.c == null) goto L10;
        this.mScene.c.a(r7);
    L10:
        q.a r1 = this.mScene.f13703b;
        if (r1 == null) goto L38;
        if (r1.f() == false) goto L38;
        r r2 = r1.e();
        if (r2 == null) goto L38;
        if (r7.getAction() != 0) goto L23;
        RectF r3 = r2.a(this, new RectF());
        if (r3 == null) goto L23;
        if (r3.contains(r7.getX(), r7.getY()) == true) goto L23;
        return false;
    L23:
        int r4 = r2.f();
        if (r4 == (-1)) goto L38;
        View r5 = this.mRegionView;
        if (r5 != null) goto L28;
    L29:
        this.mRegionView = findViewById(r4);
    L30:
        View r6 = this.mRegionView;
        if (r6 == null) goto L38;
        this.mBoundsCheck.set(r6.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
        if (this.mBoundsCheck.contains(r7.getX(), r7.getY()) == false) goto L38;
        if (handlesTouchEvent(this.mRegionView.getLeft(), this.mRegionView.getTop(), this.mRegionView, r7) == true) goto L38;
        return onTouchEvent(r7);
    L28:
        if (r5.getId() == r4) goto L30;
        goto L29
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        this.mInLayout = true;
    L17:
        th = move-exception;
        this.mInLayout = false;
        throw th;
    L4:
        if (this.mScene != null) goto L8;
        super.onLayout(r4, r5, r6, r7, r8);     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L8:
        int r9 = r7 - r5;
        int r10 = r8 - r6;
        if (this.mLastLayoutWidth == r9) goto L12;
    L13:
        rebuildScene();     // Catch: Throwable -> L17
        evaluate(true);     // Catch: Throwable -> L17
    L14:
        this.mLastLayoutWidth = r9;     // Catch: Throwable -> L17
        this.mLastLayoutHeight = r10;     // Catch: Throwable -> L17
        this.mOldWidth = r9;     // Catch: Throwable -> L17
        this.mOldHeight = r10;     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L12:
        if (this.mLastLayoutHeight == r10) goto L14;
        goto L13
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        if (this.mScene != null) goto L6;
        super.onMeasure(r8, r9);
        return;
    L6:
        boolean r1 = false;
        if (this.mLastWidthMeasureSpec == r8) goto L9;
    L12:
        boolean r0 = true;
    L14:
        if (this.mNeedsFireTransitionCompleted == false) goto L17;
        this.mNeedsFireTransitionCompleted = false;
        onNewStateAttachHandlers();
        processTransitionCompleted();
        r0 = true;
    L17:
        if (this.mDirtyHierarchy == false) goto L19;
        r0 = true;
    L19:
        this.mLastWidthMeasureSpec = r8;
        this.mLastHeightMeasureSpec = r9;
        int r3 = this.mScene.d();
        int r4 = this.mScene.e();
        if (r0 == true) goto L24;
        if (this.mModel.c(r3, r4) == true) goto L24;
    L26:
        if (r0 == false) goto L28;
        super.onMeasure(r8, r9);
    L28:
        r1 = true;
    L30:
        if (this.mMeasureDuringTransition == true) goto L32;
        if (r1 == true) goto L32;
    L41:
        evaluateLayout();
        return;
    L32:
        int r10 = getPaddingTop() + getPaddingBottom();
        int r2 = this.mLayoutWidget.F() + (getPaddingLeft() + getPaddingRight());
        int r11 = this.mLayoutWidget.G() + r10;
        int r12 = this.mWidthMeasureMode;
        if (r12 == Integer.MIN_VALUE) goto L35;
        if (r12 == 0) goto L35;
    L36:
        int r13 = this.mHeightMeasureMode;
        if (r13 == Integer.MIN_VALUE) goto L39;
        if (r13 == 0) goto L39;
    L40:
        setMeasuredDimension(r2, r11);
    L39:
        int r14 = this.mStartWrapHeight;
        r11 = (int) (r14 + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r14)));
        requestLayout();
    L35:
        int r15 = this.mStartWrapWidth;
        r2 = (int) (r15 + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r15)));
        requestLayout();
    L24:
        if (this.mBeginState == (-1)) goto L26;
        super.onMeasure(r8, r9);
        this.mModel.a(this.mLayoutWidget, this.mScene.d(r3), this.mScene.d(r4));
        this.mModel.a();
        this.mModel.b(r3, r4);
        goto L30
    L9:
        if (this.mLastHeightMeasureSpec != r9) goto L12;
        r0 = false;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View r11, int r12, int r13, int[] r14, int r15) {
        q r16 = this.mScene;
        if (r16 != null) goto L5;
        return;
    L5:
        q.a r0 = r16.f13703b;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.f() == false) goto L58;
        int r2 = -1;
        if (r0.f() == false) goto L20;
        r r1 = r0.e();
        if (r1 == null) goto L20;
        int r3 = r1.f();
        if (r3 == (-1)) goto L20;
        if (r11.getId() == r3) goto L20;
        return;
    L20:
        if (r16.s() == false) goto L34;
        r r4 = r0.e();
        if (r4 != null) goto L24;
    L26:
        float r5 = this.mTransitionPosition;
        if (r5 == 1.0f) goto L31;
        if (r5 != 0.0f) goto L34;
    L31:
        if (r11.canScrollVertically(r2) == false) goto L34;
        return;
    L24:
        if ((r4.g() & 4) == 0) goto L26;
        r2 = r13;
    L34:
        if (r0.e() != null) goto L36;
    L47:
        float r17 = this.mTransitionPosition;
        long r6 = getNanoTime();
        float r7 = r12;
        this.mScrollTargetDX = r7;
        float r8 = r13;
        this.mScrollTargetDY = r8;
        this.mScrollTargetDT = (float) ((r6 - this.mScrollTargetTime) * 1.0E-9d);
        this.mScrollTargetTime = r6;
        r16.a(r7, r8);
        if (r17 == this.mTransitionPosition) goto L50;
        r14[0] = r12;
        r14[1] = r13;
    L50:
        evaluate(false);
        if (r14[0] == 0) goto L53;
    L54:
        this.mUndergoingMotion = true;
        return;
    L53:
        if (r14[1] != 0) goto L54;
        return;
    L36:
        if ((r0.e().g() & 1) == 0) goto L47;
        float r9 = r16.c(r12, r13);
        float r10 = this.mTransitionLastPosition;
        if (r10 > 0.0f) goto L42;
        if (r9 >= 0.0f) goto L42;
    L45:
        r11.setNestedScrollingEnabled(false);
        r11.post(new AnonymousClass3(this, r11));
        return;
    L42:
        if (r10 < 1.0f) goto L47;
        if (r9 <= 0.0f) goto L47;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        if (this.mUndergoingMotion == true) goto L6;
        if (r2 != 0) goto L6;
        if (r3 != 0) goto L6;
    L7:
        this.mUndergoingMotion = false;
        return;
    L6:
        r7[0] = r7[0] + r4;
        r7[1] = r7[1] + r5;
        goto L7
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r1, View r2, int r3, int r4) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    void onNewStateAttachHandlers() {
        q r0 = this.mScene;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.b(this, this.mCurrentState) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r1 = this.mCurrentState;
        if (r1 == (-1)) goto L13;
        this.mScene.a(this, r1);
    L13:
        if (this.mScene.c() == false) goto L16;
        this.mScene.r();
        return;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r1) {
        q r2 = this.mScene;
        if (r2 == null) goto L6;
        r2.a(isRtl());
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        q r5 = this.mScene;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.f13703b != null) goto L7;
        return false;
    L7:
        if (this.mScene.f13703b.e() != null) goto L9;
        return false;
    L9:
        if ((this.mScene.f13703b.e().g() & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r2, int r3) {
        q r4 = this.mScene;
        if (r4 == null) goto L9;
        float r5 = this.mScrollTargetDT;
        if (r5 == 0.0f) goto L10;
        r4.b(this.mScrollTargetDX / r5, this.mScrollTargetDY / r5);
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        q r0 = this.mScene;
        if (r0 == null) goto L21;
        if (this.mInteractionEnabled == false) goto L21;
        if (r0.c() == false) goto L21;
        q.a r1 = this.mScene.f13703b;
        if (r1 != null) goto L11;
    L14:
        this.mScene.a(r3, getCurrentState(), this);
        if (this.mScene.f13703b.c(4) == true) goto L17;
        return true;
    L17:
        return this.mScene.f13703b.e().m();
    L11:
        if (r1.f() == true) goto L14;
        return super.onTouchEvent(r3);
    L21:
        return super.onTouchEvent(r3);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View r3) {
        super.onViewAdded(r3);
        if (ZeusTransformUtils.instanceOf(r3, MotionHelper.class) == false) goto L26;
        MotionHelper r4 = (MotionHelper) ZeusTransformUtils.preCheckCast(r3, MotionHelper.class, "com.obric.memorydata.plugin");
        if (this.mTransitionListeners != null) goto L7;
        this.mTransitionListeners = new CopyOnWriteArrayList();
    L7:
        this.mTransitionListeners.add(r4);
        if (r4.b() == false) goto L14;
        if (this.mOnShowHelpers != null) goto L12;
        this.mOnShowHelpers = new ArrayList();
    L12:
        this.mOnShowHelpers.add(r4);
    L14:
        if (r4.c() == false) goto L20;
        if (this.mOnHideHelpers != null) goto L18;
        this.mOnHideHelpers = new ArrayList();
    L18:
        this.mOnHideHelpers.add(r4);
    L20:
        if (r4.a() == true) goto L22;
        return;
    L22:
        if (this.mDecoratorsHelpers != null) goto L24;
        this.mDecoratorsHelpers = new ArrayList();
    L24:
        this.mDecoratorsHelpers.add(r4);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r2) {
        super.onViewRemoved(r2);
        ArrayList<MotionHelper> r0 = this.mOnShowHelpers;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        ArrayList<MotionHelper> r1 = this.mOnHideHelpers;
        if (r1 == null) goto L9;
        r1.remove(r2);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int r1) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.a();
        invalidate();
    }

    public boolean removeTransitionListener(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        CopyOnWriteArrayList<g> r2 = this.mTransitionListeners;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.remove(r4);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mMeasureDuringTransition == false) goto L5;
    L19:
        super.requestLayout();
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L19;
        q r0 = this.mScene;
        if (r0 == null) goto L19;
        if (r0.f13703b == null) goto L19;
        int r1 = this.mScene.f13703b.a();
        if (r1 != 0) goto L14;
        return;
    L14:
        if (r1 != 2) goto L19;
        int r2 = getChildCount();
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L18;
        View r4 = getChildAt(r3);
        ((m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r4), m.class, "com.obric.memorydata.plugin")).h();
        r3 = r3 + 1;
        goto L16
    }

    public void rotateTo(int r7, int r8) {
        int r0 = 1;
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int r1 = getDisplay().getRotation();
        if (((r1 + 1) % 4) > ((this.mPreviouseRotation + 1) % 4)) goto L6;
        r0 = 2;
    L6:
        this.mRotatMode = r0;
        this.mPreviouseRotation = r1;
        int r2 = getChildCount();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        View r4 = getChildAt(r3);
        com.obric.oui.constraintlayout.motion.a.e r5 = (com.obric.oui.constraintlayout.motion.a.e) ZeusTransformUtils.preCheckCast(this.mPreRotate.get(r4), com.obric.oui.constraintlayout.motion.a.e.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L11;
        r5 = new com.obric.oui.constraintlayout.motion.a.e();
        this.mPreRotate.put(r4, r5);
    L11:
        r5.a(r4);
        r3 = r3 + 1;
        goto L7
    L12:
        this.mBeginState = -1;
        this.mEndState = r7;
        this.mScene.a(-1, r7);
        this.mModel.a(this.mLayoutWidget, null, this.mScene.d(this.mEndState));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new AnonymousClass2(this));
        if (r8 <= 0) goto L19;
        this.mTransitionDuration = r8 / 1000.0f;
        return;
    }

    public void scheduleTransitionTo(int r4) {
        if (getCurrentState() != (-1)) goto L5;
        transitionToState(r4);
        return;
    L5:
        int[] r0 = this.mScheduledTransitionTo;
        if (r0 != null) goto L9;
        this.mScheduledTransitionTo = new int[4];
    L11:
        int[] r1 = this.mScheduledTransitionTo;
        int r2 = this.mScheduledTransitions;
        this.mScheduledTransitions = r2 + 1;
        r1[r2] = r4;
        return;
    L9:
        if (r0.length > this.mScheduledTransitions) goto L11;
        this.mScheduledTransitionTo = Arrays.copyOf(r0, r0.length * 2);
        goto L11
    }

    public void setDebugMode(int r1) {
        this.mDebugPath = r1;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean r1) {
        this.mDelayedApply = r1;
    }

    public void setInteractionEnabled(boolean r1) {
        this.mInteractionEnabled = r1;
    }

    public void setInterpolatedProgress(float r2) {
        if (this.mScene == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r0 = this.mScene.f();
        if (r0 == null) goto L8;
        setProgress(r0.getInterpolation(r2));
        return;
    L8:
        setProgress(r2);
    }

    public void setOnHide(float r6) {
        ArrayList<MotionHelper> r0 = this.mOnHideHelpers;
        if (r0 == null) goto L7;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(this.mOnHideHelpers.get(r2), MotionHelper.class, "com.obric.memorydata.plugin")).setProgress(r6);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r6) {
        ArrayList<MotionHelper> r0 = this.mOnShowHelpers;
        if (r0 == null) goto L7;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(this.mOnShowHelpers.get(r2), MotionHelper.class, "com.obric.memorydata.plugin")).setProgress(r6);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public void setProgress(float r6) {
        if (r6 >= 0.0f) goto L5;
    L6:
        Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    L8:
        if (isAttachedToWindow() == false) goto L10;
        if (r6 > 0.0f) goto L24;
        if (this.mTransitionLastPosition == 1.0f) goto L18;
    L20:
        this.mCurrentState = this.mBeginState;
        if (this.mTransitionLastPosition != 0.0f) goto L36;
    L22:
        TransitionState r0 = TransitionState.FINISHED;
    L34:
        setState(r0);
    L36:
        if (this.mScene != null) goto L38;
        return;
    L38:
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = r6;
        this.mTransitionPosition = r6;
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
        if (r6 >= 1.0f) goto L26;
        this.mCurrentState = -1;
        r0 = TransitionState.MOVING;
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
        this.mStateCache = new f(this);
    L12:
        this.mStateCache.a(r6);
        return;
    L5:
        if (r6 <= 1.0f) goto L8;
        goto L6
    }

    public void setProgress(float r3, float r4) {
        if (isAttachedToWindow() == false) goto L5;
        setProgress(r3);
        setState(TransitionState.MOVING);
        this.mLastVelocity = r4;
        float r0 = 0.0f;
        if (r4 == 0.0f) goto L15;
        if (r4 <= 0.0f) goto L13;
    L12:
        r0 = 1.0f;
    L13:
        animateTo(r0);
        return;
    L15:
        if (r3 != 0.0f) goto L17;
        return;
    L17:
        if (r3 != 1.0f) goto L19;
        return;
    L19:
        if (r3 <= 0.5f) goto L13;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new f(this);
    L7:
        this.mStateCache.a(r3);
        this.mStateCache.b(r4);
    }

    public void setScene(q r2) {
        this.mScene = r2;
        r2.a(isRtl());
        rebuildScene();
    }

    void setStartState(int r2) {
        if (isAttachedToWindow() == false) goto L5;
        this.mCurrentState = r2;
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new f(this);
    L7:
        this.mStateCache.b(r2);
        this.mStateCache.a(r2);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    public void setState(int r2, int r3, int r4) {
        setState(TransitionState.SETUP);
        this.mCurrentState = r2;
        this.mBeginState = -1;
        this.mEndState = -1;
        if (this.mConstraintLayoutSpec == null) goto L5;
        this.mConstraintLayoutSpec.a(r2, r3, r4);
        return;
    L5:
        q r5 = this.mScene;
        if (r5 == null) goto L10;
        r5.d(r2).c(this);
        return;
    }

    void setState(TransitionState r3) {
        if (r3 == TransitionState.FINISHED) goto L5;
    L7:
        TransitionState r0 = this.mTransitionState;
        this.mTransitionState = r3;
        if (r0 == TransitionState.MOVING) goto L10;
    L12:
        int r1 = AnonymousClass5.f13672a[r0.ordinal()];
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L20;
        return;
    L20:
        if (r3 != TransitionState.FINISHED) goto L28;
    L21:
        fireTransitionCompleted();
        return;
    L28:
        return;
    L23:
        if (r3 != TransitionState.MOVING) goto L26;
        fireTransitionChange();
    L26:
        if (r3 == TransitionState.FINISHED) goto L21;
        return;
    L10:
        if (r3 != TransitionState.MOVING) goto L12;
        fireTransitionChange();
        goto L12
    L5:
        if (this.mCurrentState != (-1)) goto L7;
    }

    public void setTransition(int r8) {
        if (this.mScene == null) goto L35;
        q.a r9 = getTransition(r8);
        this.mBeginState = r9.d();
        this.mEndState = r9.c();
        if (isAttachedToWindow() == false) goto L7;
        float r0 = Float.NaN;
        int r1 = this.mCurrentState;
        float r4 = 0.0f;
        if (r1 != this.mBeginState) goto L15;
        r0 = 0.0f;
    L17:
        this.mScene.a(r9);
        this.mModel.a(this.mLayoutWidget, this.mScene.d(this.mBeginState), this.mScene.d(this.mEndState));
        rebuildScene();
        if (this.mTransitionLastPosition == r0) goto L27;
        if (r0 != 0.0f) goto L24;
        endTrigger(true);
        q r10 = this.mScene;
        int r2 = this.mBeginState;
    L22:
        r10.d(r2).c(this);
        goto L27
    L24:
        if (r0 != 1.0f) goto L27;
        endTrigger(false);
        r10 = this.mScene;
        r2 = this.mEndState;
    L27:
        if (Float.isNaN(r0) == true) goto L30;
        r4 = r0;
    L30:
        this.mTransitionLastPosition = r4;
        if (Float.isNaN(r0) == false) goto L33;
        Log.v(TAG, com.obric.oui.constraintlayout.motion.widget.a.a() + " transitionToStart ");
        transitionToStart();
        return;
    L33:
        setProgress(r0);
        return;
    L15:
        if (r1 != this.mEndState) goto L17;
        r0 = 1.0f;
        goto L17
    L7:
        if (this.mStateCache != null) goto L9;
        this.mStateCache = new f(this);
    L9:
        this.mStateCache.b(this.mBeginState);
        this.mStateCache.a(this.mEndState);
        return;
    }

    public void setTransition(int r4, int r5) {
        if (isAttachedToWindow() == false) goto L5;
        q r0 = this.mScene;
        if (r0 == null) goto L13;
        this.mBeginState = r4;
        this.mEndState = r5;
        r0.a(r4, r5);
        this.mModel.a(this.mLayoutWidget, this.mScene.d(r4), this.mScene.d(r5));
        rebuildScene();
        this.mTransitionLastPosition = 0.0f;
        transitionToStart();
        return;
    L13:
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new f(this);
    L7:
        this.mStateCache.b(r4);
        this.mStateCache.a(r5);
    }

    public void setTransition(q.a r5) {
        this.mScene.a(r5);
        setState(TransitionState.SETUP);
        if (this.mCurrentState != this.mScene.e()) goto L5;
        float r0 = 1.0f;
    L6:
        this.mTransitionLastPosition = r0;
        this.mTransitionPosition = r0;
        this.mTransitionGoalPosition = r0;
        if (r5.c(1) == false) goto L9;
        long r1 = -1;
    L10:
        this.mTransitionLastTime = r1;
        int r6 = this.mScene.d();
        int r2 = this.mScene.e();
        if (r6 == this.mBeginState) goto L13;
    L15:
        this.mBeginState = r6;
        this.mEndState = r2;
        this.mScene.a(r6, r2);
        this.mModel.a(this.mLayoutWidget, this.mScene.d(this.mBeginState), this.mScene.d(this.mEndState));
        this.mModel.b(this.mBeginState, this.mEndState);
        this.mModel.a();
        rebuildScene();
        return;
    L13:
        if (r2 != this.mEndState) goto L15;
        return;
    L9:
        r1 = getNanoTime();
        goto L10
    L5:
        r0 = 0.0f;
        goto L6
    }

    public void setTransitionDuration(int r1) {
        q r0 = this.mScene;
        if (r0 != null) goto L6;
        Log.e(TAG, "MotionScene not defined");
        return;
    L6:
        r0.e(r1);
    }

    public void setTransitionListener(g r3) {
        this.mTransitionListener = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
    }

    public void setTransitionState(Bundle r2) {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new f(this);
    L5:
        this.mStateCache.a(r2);
        if (isAttachedToWindow() == false) goto L9;
        this.mStateCache.a();
        return;
    }

    @Override // android.view.View
    public String toString() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        return com.obric.oui.constraintlayout.motion.widget.a.a(r0, this.mBeginState) + "->" + com.obric.oui.constraintlayout.motion.widget.a.a(r0, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
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
        this.mTransitionDuration = this.mScene.g() / 1000.0f;
        this.mTransitionGoalPosition = r11;
        this.mInTransition = true;
        if (r10 == 0) goto L26;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L26;
        if (r10 != 4) goto L15;
    L24:
        this.mDecelerateLogic.a(r12, this.mTransitionLastPosition, this.mScene.j());
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
        if (willJump(r12, this.mTransitionLastPosition, this.mScene.j()) == true) goto L24;
        this.mStopLogic.a(this.mTransitionLastPosition, r11, r12, this.mTransitionDuration, this.mScene.j(), this.mScene.k());
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
        int r15 = this.mScene.q();
        com.obric.oui.constraintlayout.motion.a.b r0 = this.mStopLogic;
        float r1 = this.mTransitionLastPosition;
        if (r15 != 0) goto L36;
        r0.a(r1, r11, r12, this.mTransitionDuration, this.mScene.j(), this.mScene.k());
        goto L23
    L36:
        r0.a(r1, r11, r12, this.mScene.m(), this.mScene.l(), this.mScene.n(), this.mScene.o(), this.mScene.p());
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
        this.mTransitionDuration = this.mScene.g() / 1000.0f;
        this.mTransitionGoalPosition = r12;
        this.mInTransition = true;
        this.mStopLogic.a(this.mTransitionLastPosition, r12, r13, this.mScene.m(), this.mScene.l(), this.mScene.n(), this.mScene.o(), this.mScene.p());
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

    public void transitionToEnd(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        animateTo(1.0f);
        this.mOnComplete = r4;
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToStart(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        animateTo(0.0f);
        this.mOnComplete = r4;
    }

    public void transitionToState(int r2) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r2, -1, -1);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new f(this);
    L7:
        this.mStateCache.a(r2);
    }

    public void transitionToState(int r2, int r3) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r2, -1, -1, r3);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new f(this);
    L7:
        this.mStateCache.a(r2);
    }

    public void transitionToState(int r2, int r3, int r4) {
        transitionToState(r2, r3, r4, -1);
    }

    public void transitionToState(int r12, int r13, int r14, int r15) {
        q r0 = this.mScene;
        if (r0 != null) goto L5;
    L9:
        int r16 = this.mCurrentState;
        if (r16 != r12) goto L13;
        return;
    L13:
        if (this.mBeginState != r12) goto L19;
        animateTo(0.0f);
        if (r15 <= 0) goto L92;
        this.mTransitionDuration = r15 / 1000.0f;
        return;
    L92:
        return;
    L19:
        if (this.mEndState != r12) goto L24;
        animateTo(1.0f);
        if (r15 <= 0) goto L93;
        this.mTransitionDuration = r15 / 1000.0f;
        return;
    L93:
        return;
    L24:
        this.mEndState = r12;
        if (r16 == (-1)) goto L30;
        setTransition(r16, r12);
        animateTo(1.0f);
        this.mTransitionLastPosition = 0.0f;
        transitionToEnd();
        if (r15 <= 0) goto L94;
        this.mTransitionDuration = r15 / 1000.0f;
        return;
    L94:
        return;
    L30:
        int r17 = 0;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        if (r15 != (-1)) goto L33;
        this.mTransitionDuration = this.mScene.g() / 1000.0f;
    L33:
        this.mBeginState = -1;
        this.mScene.a(-1, this.mEndState);
        SparseArray r1 = new SparseArray();
        if (r15 != 0) goto L37;
        r15 = this.mScene.g();
    L36:
        this.mTransitionDuration = r15 / 1000.0f;
    L39:
        int r18 = getChildCount();
        this.mFrameArrayList.clear();
        int r2 = 0;
    L41:
        if (r2 >= r18) goto L43;
        View r5 = getChildAt(r2);
        this.mFrameArrayList.put(r5, new m(r5));
        r1.put(r5.getId(), (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(r5), m.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L41
    L43:
        this.mInTransition = true;
        this.mModel.a(this.mLayoutWidget, null, this.mScene.d(r12));
        rebuildScene();
        this.mModel.b();
        computeCurrentPositions();
        int r19 = getWidth();
        int r110 = getHeight();
        if (this.mDecoratorsHelpers == null) goto L63;
        int r3 = 0;
    L46:
        if (r3 >= r18) goto L52;
        m r6 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r3)), m.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L51;
        this.mScene.a(r6);
    L51:
        r3 = r3 + 1;
        goto L46
    L52:
        Iterator<MotionHelper> r4 = this.mDecoratorsHelpers.iterator();
    L54:
        if (r4.hasNext() == false) goto L56;
        ((MotionHelper) ZeusTransformUtils.preCheckCast(r4.next(), MotionHelper.class, "com.obric.memorydata.plugin")).a(this, this.mFrameArrayList);
        goto L54
    L56:
        int r7 = 0;
    L57:
        if (r7 >= r18) goto L70;
        m r8 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r7)), m.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L62;
        r8.a(r19, r110, this.mTransitionDuration, getNanoTime());
    L62:
        r7 = r7 + 1;
    L70:
        float r111 = this.mScene.i();
        if (r111 == 0.0f) goto L77;
        float r112 = Float.MAX_VALUE;
        float r9 = -3.4028235E38f;
        int r10 = 0;
    L73:
        if (r10 >= r18) goto L75;
        m r11 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r10)), m.class, "com.obric.memorydata.plugin");
        float r20 = r11.d() + r11.c();
        r112 = Math.min(r112, r20);
        r9 = Math.max(r9, r20);
        r10 = r10 + 1;
    L75:
        if (r17 >= r18) goto L77;
        m r21 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r17)), m.class, "com.obric.memorydata.plugin");
        float r22 = r21.c();
        float r23 = r21.d();
        r21.h = 1.0f / (1.0f - r111);
        r21.g = r111 - ((((r22 + r23) - r112) * r111) / (r9 - r112));
        r17 = r17 + 1;
    L77:
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
        return;
    L63:
        int r24 = 0;
    L64:
        if (r24 >= r18) goto L70;
        m r25 = (m) ZeusTransformUtils.preCheckCast(this.mFrameArrayList.get(getChildAt(r24)), m.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L69;
        this.mScene.a(r25);
        r25.a(r19, r110, this.mTransitionDuration, getNanoTime());
    L69:
        r24 = r24 + 1;
        goto L64
    L37:
        if (r15 <= 0) goto L39;
    L5:
        if (r0.f13702a == null) goto L9;
        int r113 = this.mScene.f13702a.a(this.mCurrentState, r12, r13, r14);
        if (r113 == (-1)) goto L9;
        r12 = r113;
        goto L9
    }

    public void updateState() {
        this.mModel.a(this.mLayoutWidget, this.mScene.d(this.mBeginState), this.mScene.d(this.mEndState));
        rebuildScene();
    }

    public void updateState(int r2, com.obric.oui.constraintlayout.widget.b r3) {
        q r0 = this.mScene;
        if (r0 == null) goto L5;
        r0.a(r2, r3);
    L5:
        updateState();
        if (this.mCurrentState != r2) goto L9;
        r3.c(this);
        return;
    }

    public void updateStateAnimate(int r6, com.obric.oui.constraintlayout.widget.b r7, int r8) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mCurrentState != r6) goto L9;
        updateState(ZeusTransformUtils.mapRes(R.id.view_transition, OaidModel.KEY_ID, "view_transition"), getConstraintSet(r6));
        setState(ZeusTransformUtils.mapRes(R.id.view_transition, OaidModel.KEY_ID, "view_transition"), -1, -1);
        updateState(r6, r7);
        q.a r9 = new q.a(-1, this.mScene, ZeusTransformUtils.mapRes(R.id.view_transition, OaidModel.KEY_ID, "view_transition"), r6);
        r9.a(r8);
        setTransition(r9);
        transitionToEnd();
        return;
    }

    public void viewTransition(int r1, View... r2) {
        q r0 = this.mScene;
        if (r0 == null) goto L5;
        r0.a(r1, r2);
        return;
    L5:
        Log.e(TAG, " no motionScene");
    }
}
