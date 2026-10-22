package com.larus.browsertakeover.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u0087\u00012\u00020\u0001:\b\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ0\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020\u001b2\u0006\u0010S\u001a\u00020\u00192\u0006\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u00192\b\b\u0002\u0010V\u001a\u00020\u0007J\u0006\u0010W\u001a\u00020\u001fJ\u000e\u0010X\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020\u000bJ\u0010\u0010Z\u001a\u00020\u001f2\b\u0010[\u001a\u0004\u0018\u00010\\J\u0010\u0010]\u001a\u0004\u0018\u00010\u00162\u0006\u0010[\u001a\u00020\\J(\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0014J\b\u0010c\u001a\u00020\u001fH\u0014J\n\u0010d\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010e\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020gH\u0014J\u0010\u0010h\u001a\u00020\u000b2\u0006\u0010i\u001a\u00020jH\u0016J\u0018\u0010k\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u0019H\u0002J\"\u0010n\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00192\b\b\u0002\u0010o\u001a\u00020\u000bH\u0002J\u0010\u0010p\u001a\u00020\u00192\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010q\u001a\u00020\u00192\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010r\u001a\u00020\u00192\u0006\u0010i\u001a\u00020jH\u0002J \u0010s\u001a\u00020\u001f2\u0006\u0010t\u001a\u00020\u00192\u0006\u0010u\u001a\u00020\u00192\u0006\u0010v\u001a\u00020\u0019H\u0002J\"\u0010w\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00192\b\b\u0002\u0010o\u001a\u00020\u000bH\u0002J\u0010\u0010x\u001a\u00020\u001f2\u0006\u0010o\u001a\u00020\u000bH\u0002J\b\u0010y\u001a\u00020\u001fH\u0002J\b\u0010z\u001a\u00020\u000bH\u0016J\b\u0010{\u001a\u00020\u001fH\u0002J\b\u0010|\u001a\u00020\u001fH\u0002J\b\u0010}\u001a\u00020\u001fH\u0002J/\u0010~\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u007f2\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00192\u0007\u0010\u0080\u0001\u001a\u00020(H\u0002R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000e\"\u0004\bP\u0010\u0010R\u0017\u0010\u0081\u0001\u001a\u0002018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "usesRtsInputPacing", "getUsesRtsInputPacing", "()Z", "setUsesRtsInputPacing", "(Z)V", "bitmapPaint", "Landroid/graphics/Paint;", "viewport", "Lcom/larus/browsertakeover/render/RemoteBrowserViewport;", "viewportRect", "Landroid/graphics/RectF;", "imageRect", "touchSlop", "", "frame", "Landroid/graphics/Bitmap;", "reportedFrameAttempt", "onFirstFrameSubmitted", "Lkotlin/Function1;", "", "getOnFirstFrameSubmitted", "()Lkotlin/jvm/functions/Function1;", "setOnFirstFrameSubmitted", "(Lkotlin/jvm/functions/Function1;)V", "deviceWidth", "deviceHeight", "offsetTop", "gestureMapping", "Lcom/larus/browsertakeover/render/RemoteBrowserViewport$Mapping;", "gesture", "Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$Gesture;", "downX", "downY", "lastX", "lastY", "moved", "lastMoveSentAtNanos", "", "lastRemoteX", "lastRemoteY", "hasLastRemotePoint", "secondPointerDownTime", "twoDownX", "twoDownY", "twoStartSpan", "zoom", "zoomOffsetX", "zoomOffsetY", "pendingPanScrollX", "pendingPanScrollY", "longPressDetector", "Landroid/view/GestureDetector;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "interactionMode", "Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionMode;", "getInteractionMode", "()Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionMode;", "setInteractionMode", "(Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionMode;)V", "interactionListener", "Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionListener;", "getInteractionListener", "()Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionListener;", "setInteractionListener", "(Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionListener;)V", "inputEnabled", "getInputEnabled", "setInputEnabled", "setFrame", "bitmap", "remoteWidth", "remoteHeight", "remoteOffsetTop", "attempt", "clearFrame", "setImeVisible", "visible", "setImeVisibleBounds", "localVisibleRect", "Landroid/graphics/Rect;", "getVisibleRemoteBounds", "onSizeChanged", "w", "h", "oldw", "oldh", "onDetachedFromWindow", "currentMapping", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchDragMove", "x", "y", "dispatchScroll", "force", "centroidX", "centroidY", "span", "applyLocalScale", "factor", "focusX", "focusY", "panLocal", "flushPanScroll", "resetLocalScale", "performClick", "finishGesture", "cancelRemoteDrag", "cancelGesture", "mapPoint", "Lkotlin/Pair;", "snapshot", "movementIntervalNanos", "getMovementIntervalNanos", "()J", "InteractionMode", "InteractionListener", "Gesture", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteBrowserSurfaceView extends View {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public final GestureDetector G;
    public final ScaleGestureDetector H;
    public InteractionMode I;
    public b J;
    public boolean K;
    public boolean a;
    public final Paint b;
    public final com.larus.browsertakeover.render.c c;
    public final RectF d;
    public final RectF e;
    public final float f;
    public Bitmap g;
    public int h;
    public Function1<? super Integer, Unit> i;
    public float j;
    public float k;
    public float l;
    public com.larus.browsertakeover.render.c.b m;
    public Gesture n;
    public float o;
    public float p;
    public float q;
    public float r;
    public boolean s;
    public long t;
    public float u;
    public float v;
    public boolean w;
    public long x;
    public float y;
    public float z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$Gesture;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SINGLE", "SINGLE_SCROLL", "LOCAL_PAN", "DRAG", "TWO_PENDING", "TWO_SCROLL", "PINCH", "CANCELLED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Gesture extends Enum<Gesture> {
        public static final Gesture CANCELLED = null;
        public static final Gesture DRAG = null;
        public static final Gesture LOCAL_PAN = null;
        public static final Gesture NONE = null;
        public static final Gesture PINCH = null;
        public static final Gesture SINGLE = null;
        public static final Gesture SINGLE_SCROLL = null;
        public static final Gesture TWO_PENDING = null;
        public static final Gesture TWO_SCROLL = null;
        public static final /* synthetic */ Gesture[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Gesture> getEntries() {
            return b;
        }

        static {
            Gesture r0 = new Gesture("NONE", 0);
            NONE = r0;
            Gesture r1 = new Gesture("SINGLE", 1);
            SINGLE = r1;
            Gesture r3 = new Gesture("SINGLE_SCROLL", 2);
            SINGLE_SCROLL = r3;
            Gesture r5 = new Gesture("LOCAL_PAN", 3);
            LOCAL_PAN = r5;
            Gesture r7 = new Gesture("DRAG", 4);
            DRAG = r7;
            Gesture r9 = new Gesture("TWO_PENDING", 5);
            TWO_PENDING = r9;
            Gesture r11 = new Gesture("TWO_SCROLL", 6);
            TWO_SCROLL = r11;
            Gesture r13 = new Gesture("PINCH", 7);
            PINCH = r13;
            Gesture r15 = new Gesture("CANCELLED", 8);
            CANCELLED = r15;
            Gesture[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
            a = r14;
            b = EnumEntriesKt.enumEntries(r14);
        }

        public static Gesture[] values() {
            return (Gesture[]) a.clone();
        }

        public static Gesture valueOf(String r1) {
            return (Gesture) r27.a.a(Gesture.class, r1);
        }

        public Gesture(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionMode;", "", "<init>", "(Ljava/lang/String;I)V", "SCROLL", "DRAG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InteractionMode extends Enum<InteractionMode> {
        public static final InteractionMode DRAG = null;
        public static final InteractionMode SCROLL = null;
        public static final /* synthetic */ InteractionMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<InteractionMode> getEntries() {
            return b;
        }

        static {
            InteractionMode r0 = new InteractionMode("SCROLL", 0);
            SCROLL = r0;
            InteractionMode r1 = new InteractionMode("DRAG", 1);
            DRAG = r1;
            InteractionMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static InteractionMode[] values() {
            return (InteractionMode[]) a.clone();
        }

        public static InteractionMode valueOf(String r1) {
            return (InteractionMode) r27.a.a(InteractionMode.class, r1);
        }

        public InteractionMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void CR(float r1, float r2);

        void F80(float r1, float r2);

        void Gp(float r1, float r2, float r3, float r4);

        void O70(float r1, float r2);

        void f5(float r1, float r2);

        void p10(float r1, float r2);

        void p50(float r1, float r2);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Gesture.values().length];
            r0[Gesture.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[Gesture.SINGLE_SCROLL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[Gesture.LOCAL_PAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[Gesture.DRAG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Gesture.TWO_PENDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[Gesture.TWO_SCROLL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final class d extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ RemoteBrowserSurfaceView a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return true;
        }

        public d(RemoteBrowserSurfaceView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            if (this.a.getInputEnabled() == false) goto L19;
            RemoteBrowserSurfaceView r5 = this.a;
            if (r5.n == Gesture.SINGLE) goto L7;
            return;
        L7:
            if (r5.s == true) goto L22;
            com.larus.browsertakeover.render.c.b r0 = r5.m;
            if (r0 != null) goto L12;
            return;
        L12:
            Pair<Float, Float> r6 = r5.h(r5.o, r5.p, r0);
            if (r6 != null) goto L15;
            return;
        L15:
            RemoteBrowserSurfaceView r1 = this.a;
            r1.n = Gesture.DRAG;
            r1.u = ((Number) r6.getFirst()).floatValue();
            RemoteBrowserSurfaceView r2 = this.a;
            r2.v = ((Number) r6.getSecond()).floatValue();
            RemoteBrowserSurfaceView r3 = this.a;
            r3.w = true;
            b r7 = r3.getInteractionListener();
            if (r7 == null) goto L21;
            r7.p50(((Number) r6.getFirst()).floatValue(), ((Number) r6.getSecond()).floatValue());
            return;
        L21:
            return;
        L22:
            return;
        }
    }

    public static final class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public final /* synthetic */ RemoteBrowserSurfaceView a;

        public e(RemoteBrowserSurfaceView r1) {
            this.a = r1;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r13) {
            Intrinsics.checkNotNullParameter(r13, "detector");
            RemoteBrowserSurfaceView r0 = this.a;
            boolean r3 = false;
            if (r0.n == Gesture.PINCH) goto L5;
            return false;
        L5:
            float r1 = r13.getScaleFactor();
            float r2 = r13.getFocusX();
            float r14 = r13.getFocusY();
            r0.getClass();
            if (Float.isInfinite(r1) == false) goto L8;
        L10:
            if (r3 == true) goto L12;
        L18:
            return true;
        L12:
            if (r1 <= 0.0f) goto L18;
            com.larus.browsertakeover.render.c.b r4 = r0.c.a(r0.getWidth(), r0.getHeight(), r0.j, r0.k, r0.l);
            if (r4 == null) goto L18;
            com.larus.browsertakeover.render.c.b r6 = r4.a(r0.B, r0.C, r0.D);
            float r5 = RangesKt.coerceIn(r0.B * r1, 1.0f, 4.0f);
            float r7 = r5 / r0.B;
            com.larus.browsertakeover.render.c.a r8 = r6.a;
            float r9 = r2 - ((r2 - r8.a) * r7);
            float r15 = r14 - ((r14 - r8.b) * r7);
            com.larus.browsertakeover.render.c.a r10 = r4.a;
            float r11 = r10.c;
            float r12 = r10.a;
            float r16 = r10.d - r10.b;
            float r17 = -(r11 - r12);
            float r18 = r5 - 1.0f;
            r0.C = RangesKt.coerceIn(r9 - r12, r17 * r18, 0.0f);
            r0.D = RangesKt.coerceIn(r15 - r4.a.b, (-r16) * r18, 0.0f);
            r0.B = r5;
            r0.invalidate();
            goto L18
        L8:
            if (Float.isNaN(r1) == true) goto L10;
            r3 = true;
            goto L10
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r10) {
            Intrinsics.checkNotNullParameter(r10, "detector");
            Gesture r0 = this.a.n;
            Gesture r1 = Gesture.PINCH;
            if (r0 != r1) goto L6;
            return true;
        L6:
            if (r0 == Gesture.TWO_PENDING) goto L8;
            return false;
        L8:
            float r2 = Math.abs(r10.getCurrentSpan() - this.a.A);
            float r11 = (float) Math.hypot(r10.getFocusX() - this.a.y, r10.getFocusY() - this.a.z);
            RemoteBrowserSurfaceView r3 = this.a;
            if (r2 > (r3.f * 2.0f)) goto L11;
        L15:
            return false;
        L11:
            if (r2 <= r11) goto L15;
            r3.n = r1;
            r3.s = true;
            return true;
        }
    }

    static {
    }

    public RemoteBrowserSurfaceView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RemoteBrowserSurfaceView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final long getMovementIntervalNanos() {
        if (this.a == false) goto L5;
        return 50000000;
    L5:
        return 16000000;
    }

    public final void b() {
        if (this.n == Gesture.DRAG) goto L5;
        return;
    L5:
        if (this.w == false) goto L11;
        b r0 = this.J;
        if (r0 == null) goto L12;
        r0.CR(this.u, this.v);
        return;
    L12:
        return;
    }

    public final void e() {
        Bitmap r0 = this.g;
        this.g = null;
        a();
        this.B = 1.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        invalidate();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        r0.recycle();
        return;
    L11:
        return;
    L5:
        if (r0.isRecycled() == true) goto L7;
        r1 = true;
        goto L8
    }

    public final com.larus.browsertakeover.render.c.b f() {
        Bitmap r0 = this.g;
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.isRecycled() == true) goto L8;
        r1 = true;
    L8:
        if (r1 == true) goto L10;
        return null;
    L10:
        com.larus.browsertakeover.render.c.b r2 = this.c.a(getWidth(), getHeight(), this.j, this.k, this.l);
        if (r2 != null) goto L13;
        return null;
    L13:
        return r2.a(this.B, this.C, this.D);
    }

    public final void a() {
        b();
        this.n = Gesture.NONE;
        this.m = null;
        this.E = 0.0f;
        this.F = 0.0f;
        this.w = false;
        ViewParent r1 = getParent();
        if (r1 == null) goto L6;
        r1.requestDisallowInterceptTouchEvent(false);
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final boolean getInputEnabled() {
        return this.K;
    }

    public final b getInteractionListener() {
        return this.J;
    }

    public final InteractionMode getInteractionMode() {
        return this.I;
    }

    public final Function1<Integer, Unit> getOnFirstFrameSubmitted() {
        return this.i;
    }

    public final boolean getUsesRtsInputPacing() {
        return this.a;
    }

    public static float c(MotionEvent r2) {
        return (r2.getX(0) + r2.getX(1)) / 2.0f;
    }

    public static float d(MotionEvent r2) {
        return (r2.getY(0) + r2.getY(1)) / 2.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        Bitmap r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.browsertakeover.render.c.b r1 = f();
        if (r1 != null) goto L8;
        return;
    L8:
        com.larus.browsertakeover.render.c.a r2 = r1.a;
        this.d.set(r2.a, r2.b, r2.c, r2.d);
        float r4 = r0.getHeight() / (r0.getWidth() / this.j);
        RectF r3 = this.e;
        float r5 = r2.a;
        float r6 = r2.b;
        float r7 = this.l;
        float r8 = r1.e;
        r3.set(r5, (r7 * r8) + r6, r2.c, r6 + ((r7 + r4) * r8));
        r11.save();
        r11.clipRect(this.d);
        com.larus.browsertakeover.render.c.a r9 = r1.f;
        if (r9 == null) goto L11;
        r11.clipRect(r9.a, r9.b, r9.c, r9.d);
    L11:
        r11.drawBitmap(r0, null, this.e, this.b);
        r11.restore();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        int r1 = 0;
        if (this.K == true) goto L5;
    L156:
        return false;
    L5:
        if (this.g == null) goto L156;
        int r0 = r13.getActionMasked();
        if (r0 != 0) goto L10;
        a();
        com.larus.browsertakeover.render.c.b r2 = f();
        if (r2 != null) goto L35;
        return false;
    L35:
        Pair<Float, Float> r6 = h(r13.getX(), r13.getY(), r2);
        if (r6 != null) goto L38;
        return false;
    L38:
        this.m = r2;
        this.n = Gesture.SINGLE;
        this.o = r13.getX();
        this.p = r13.getY();
        this.q = r13.getX();
        this.r = r13.getY();
        this.s = false;
        this.t = 0;
        this.u = ((Number) r6.getFirst()).floatValue();
        this.v = ((Number) r6.getSecond()).floatValue();
        this.w = true;
        if (this.I != InteractionMode.DRAG) goto L43;
        this.n = Gesture.DRAG;
        b r3 = this.J;
        if (r3 == null) goto L43;
        r3.p50(((Number) r6.getFirst()).floatValue(), ((Number) r6.getSecond()).floatValue());
    L43:
        ViewParent r4 = getParent();
        if (r4 == null) goto L46;
        r4.requestDisallowInterceptTouchEvent(true);
    L46:
        this.G.onTouchEvent(r13);
        this.H.onTouchEvent(r13);
        int r5 = r13.getActionMasked();
        Pair<Float, Float> r7 = null;
        if (r5 != 1) goto L49;
        com.larus.browsertakeover.render.c.b r8 = this.m;
        if (r8 == null) goto L126;
        Pair<Float, Float> r9 = h(r13.getX(), r13.getY(), r8);
    L127:
        int r10 = c.a[this.n.ordinal()];
        if (r10 == 1) goto L146;
        if (r10 == 2) goto L144;
        if (r10 != 3) goto L132;
        i(r13.getX(), r13.getY(), true);
    L151:
        this.n = Gesture.NONE;
        this.m = null;
        this.E = 0.0f;
        this.F = 0.0f;
        this.w = false;
        ViewParent r14 = getParent();
        if (r14 == null) goto L154;
        r14.requestDisallowInterceptTouchEvent(false);
    L154:
        super.performClick();
    L155:
        return true;
    L132:
        if (r10 != 4) goto L151;
        if (r9 == null) goto L139;
        b r15 = this.J;
        if (r15 == null) goto L151;
        r15.f5(((Number) r9.getFirst()).floatValue(), ((Number) r9.getSecond()).floatValue());
        goto L151
    L139:
        if (this.w == false) goto L151;
        b r16 = this.J;
        if (r16 == null) goto L151;
        r16.f5(this.u, this.v);
        goto L151
    L144:
        g(r13.getX(), r13.getY(), true);
        goto L151
    L146:
        if (this.s == true) goto L151;
        if (r9 == null) goto L151;
        b r17 = this.J;
        if (r17 == null) goto L151;
        r17.O70(((Number) r9.getFirst()).floatValue(), ((Number) r9.getSecond()).floatValue());
        goto L151
    L126:
        r9 = null;
        goto L127
    L49:
        if (r5 == 2) goto L87;
        if (r5 != 3) goto L52;
        a();
        goto L155
    L52:
        if (r5 != 6) goto L155;
        if (this.n != Gesture.TWO_PENDING) goto L70;
        if (this.s == true) goto L70;
        if (r13.getPointerCount() != 2) goto L70;
        if ((r13.getEventTime() - this.x) > ViewConfiguration.getDoubleTapTimeout()) goto L70;
        com.larus.browsertakeover.render.c.b r11 = this.m;
        if (r11 == null) goto L65;
        r7 = h(c(r13), d(r13), r11);
    L65:
        if (r7 == null) goto L74;
        b r12 = this.J;
        if (r12 == null) goto L74;
        r12.F80(((Number) r7.getFirst()).floatValue(), ((Number) r7.getSecond()).floatValue());
    L74:
        b();
        if (this.n == Gesture.PINCH) goto L77;
    L84:
        this.n = Gesture.CANCELLED;
        goto L155
    L77:
        if (this.B <= 1.0f) goto L84;
        if (r13.getPointerCount() != 2) goto L84;
        if (r13.getActionIndex() != 0) goto L83;
        r1 = 1;
    L83:
        this.q = r13.getX(r1);
        this.r = r13.getY(r1);
        this.m = f();
        this.s = true;
        this.n = Gesture.LOCAL_PAN;
    L70:
        if (this.n != Gesture.TWO_SCROLL) goto L74;
        if (r13.getPointerCount() != 2) goto L74;
        g(c(r13), d(r13), true);
        goto L74
    L87:
        switch(c.a[this.n.ordinal()]) {
            case 1: goto L118;
            case 2: goto L116;
            case 3: goto L115;
            case 4: goto L102;
            case 5: goto L90;
            case 6: goto L90;
            default: goto L155;
        };
    L102:
        float r18 = r13.getX();
        float r19 = r13.getY();
        com.larus.browsertakeover.render.c.b r20 = this.m;
        if (r20 == null) goto L155;
        long r110 = System.nanoTime();
        int r21 = com.larus.browsertakeover.render.d.a;
        if (com.larus.browsertakeover.render.d.a(this.t, r110, getMovementIntervalNanos(), false) == false) goto L155;
        Pair<Float, Float> r111 = h(r18, r19, r20);
        if (r111 == null) goto L155;
        b r22 = this.J;
        if (r22 == null) goto L114;
        r22.p10(((Number) r111.getFirst()).floatValue(), ((Number) r111.getSecond()).floatValue());
    L114:
        this.u = ((Number) r111.getFirst()).floatValue();
        this.v = ((Number) r111.getSecond()).floatValue();
        this.w = true;
        this.t = r110;
        goto L155
    L115:
        i(r13.getX(), r13.getY(), false);
        goto L155
    L116:
        g(r13.getX(), r13.getY(), false);
        goto L155
    L90:
        if (r13.getPointerCount() != 2) goto L155;
        float r23 = c(r13);
        float r24 = d(r13);
        float r25 = (float) Math.hypot(r23 - this.y, r24 - this.z);
        float r112 = Math.abs(((float) Math.hypot(r13.getX(0) - r13.getX(1), r13.getY(0) - r13.getY(1))) - this.A);
        float r26 = this.f;
        if (r25 <= r26) goto L94;
    L95:
        this.s = true;
    L96:
        Gesture r27 = this.n;
        Gesture r28 = Gesture.TWO_SCROLL;
        if (r27 == r28) goto L101;
        if (r25 <= r26) goto L155;
        if (r25 < r112) goto L155;
    L101:
        this.n = r28;
        g(r23, r24, false);
        goto L155
    L94:
        if (r112 <= (r26 * 2.0f)) goto L96;
    L118:
        if (((float) Math.hypot(r13.getX() - this.o, r13.getY() - this.p)) <= this.f) goto L155;
        this.s = true;
        if (this.B <= 1.0f) goto L122;
        this.n = Gesture.LOCAL_PAN;
        i(r13.getX(), r13.getY(), false);
        goto L155
    L122:
        this.n = Gesture.SINGLE_SCROLL;
        g(r13.getX(), r13.getY(), false);
        goto L155
    L10:
        if (r0 != 5) goto L46;
        if (this.s == false) goto L15;
    L18:
        boolean r29 = true;
    L19:
        Gesture r30 = this.n;
        if (r30 != Gesture.SINGLE_SCROLL) goto L23;
        g(r13.getX(), r13.getY(), true);
    L26:
        if (r13.getPointerCount() == 2) goto L28;
    L31:
        b();
        this.n = Gesture.CANCELLED;
        goto L46
    L28:
        if (this.n == Gesture.CANCELLED) goto L31;
        b();
        this.m = f();
        this.n = Gesture.TWO_PENDING;
        this.x = r13.getEventTime();
        this.y = c(r13);
        float r31 = d(r13);
        this.z = r31;
        this.q = this.y;
        this.r = r31;
        this.A = (float) Math.hypot(r13.getX(0) - r13.getX(1), r13.getY(0) - r13.getY(1));
        this.s = r29;
        this.t = 0;
        goto L46
    L23:
        if (r30 != Gesture.LOCAL_PAN) goto L26;
        i(r13.getX(), r13.getY(), true);
        goto L26
    L15:
        if (this.n == Gesture.DRAG) goto L18;
        r29 = false;
        goto L19
    }

    public final void setImeVisible(boolean r6) {
        com.larus.browsertakeover.render.c r0 = this.c;
        int r1 = getWidth();
        int r2 = getHeight();
        boolean r4 = false;
        if (r0.a == r6) goto L16;
        r0.a = r6;
        if (r6 == true) goto L8;
        r0.b = null;
    L8:
        if (r6 == true) goto L11;
        r1 = 0;
    L11:
        r0.c = r1;
        if (r6 == true) goto L15;
        r2 = 0;
    L15:
        r0.d = r2;
        r4 = true;
    L16:
        if (r4 == false) goto L19;
        a();
        invalidate();
        return;
    }

    public final void setImeVisibleBounds(Rect r5) {
        if (r5 == null) goto L4;
        com.larus.browsertakeover.render.c.a r0 = new com.larus.browsertakeover.render.c.a(r5.left, r5.top, r5.right, r5.bottom);
    L5:
        com.larus.browsertakeover.render.c r6 = this.c;
        if (Intrinsics.areEqual(r6.b, r0) == false) goto L8;
        boolean r7 = false;
    L9:
        if (r7 == false) goto L12;
        a();
        invalidate();
        return;
    L12:
        return;
    L8:
        r6.b = r0;
        r7 = true;
        goto L9
    L4:
        r0 = null;
        goto L5
    }

    public final void setInputEnabled(boolean r1) {
        if (r1 == true) goto L4;
        a();
    L4:
        this.K = r1;
    }

    public final void setInteractionListener(b r1) {
        this.J = r1;
    }

    public final void setInteractionMode(InteractionMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.I = r2;
    }

    public final void setOnFirstFrameSubmitted(Function1<? super Integer, Unit> r1) {
        this.i = r1;
    }

    public final void setUsesRtsInputPacing(boolean r3) {
        if (this.a != r3) goto L5;
        return;
    L5:
        this.a = r3;
        this.t = 0;
    }

    public RemoteBrowserSurfaceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new Paint(3);
        this.c = new com.larus.browsertakeover.render.c();
        this.d = new RectF();
        this.e = new RectF();
        this.f = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.j = 1.0f;
        this.k = 1.0f;
        this.n = Gesture.NONE;
        this.B = 1.0f;
        this.G = new GestureDetector(r2, new d(this));
        ScaleGestureDetector r5 = new ScaleGestureDetector(r2, new e(this));
        r5.setQuickScaleEnabled(false);
        this.H = r5;
        this.I = InteractionMode.SCROLL;
        setBackgroundColor(Color.rgb(19, 21, 26));
        setFocusable(true);
    }

    public final void g(float r11, float r12, boolean r13) {
        com.larus.browsertakeover.render.c.b r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        long r8 = System.nanoTime();
        int r1 = com.larus.browsertakeover.render.d.a;
        if (com.larus.browsertakeover.render.d.a(this.t, r8, getMovementIntervalNanos(), r13) == true) goto L8;
        return;
    L8:
        Pair<Float, Float> r14 = h(r11, r12, r0);
        if (r14 != null) goto L11;
        return;
    L11:
        Pair<Float, Float> r2 = h(this.q, this.r, r0);
        if (r2 != null) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r2, r14) == true) goto L19;
        b r3 = this.J;
        if (r3 == null) goto L19;
        r3.Gp(((Number) r14.getFirst()).floatValue(), ((Number) r14.getSecond()).floatValue(), ((Number) r2.getFirst()).floatValue() - ((Number) r14.getFirst()).floatValue(), ((Number) r2.getSecond()).floatValue() - ((Number) r14.getSecond()).floatValue());
    L19:
        this.q = r11;
        this.r = r12;
        this.t = r8;
    }

    public final Pair<Float, Float> h(float r6, float r7, com.larus.browsertakeover.render.c.b r8) {
        int r0 = getWidth();
        int r1 = getHeight();
        if (r6 >= 0.0f) goto L5;
    L54:
        return null;
    L5:
        if (r6 >= r0) goto L54;
        if (r7 < 0.0f) goto L54;
        if (r7 >= r1) goto L54;
        com.larus.browsertakeover.render.c.a r2 = r8.f;
        if (r2 != null) goto L14;
    L22:
        com.larus.browsertakeover.render.c.a r3 = r8.a;
        float r4 = r3.a;
        if (r6 < r4) goto L54;
        if (r6 >= r3.c) goto L54;
        float r5 = r3.b;
        if (r7 < r5) goto L54;
        if (r7 >= r3.d) goto L54;
        float r9 = r8.e;
        float r10 = (r6 - r4) / r9;
        float r11 = (r7 - r5) / r9;
        float r12 = r8.d;
        float r13 = r11 - r12;
        float r14 = r8.c - r12;
        boolean r15 = true;
        if (Float.isInfinite(r10) == false) goto L34;
    L36:
        boolean r16 = false;
    L37:
        if (r16 == false) goto L54;
        if (Float.isInfinite(r13) == false) goto L41;
    L43:
        boolean r17 = false;
    L44:
        if (r17 == false) goto L54;
        if (0.0f <= r13) goto L48;
    L50:
        r15 = false;
    L51:
        if (r15 == false) goto L54;
        return TuplesKt.to(Float.valueOf(RangesKt.coerceIn(r10, 0.0f, r8.b)), Float.valueOf(RangesKt.coerceIn(r13, 0.0f, r14)));
    L48:
        if (r13 > r14) goto L50;
    L41:
        if (Float.isNaN(r13) == true) goto L43;
        r17 = true;
        goto L44
    L34:
        if (Float.isNaN(r10) == true) goto L36;
        r16 = true;
        goto L37
    L14:
        if (r6 < r2.a) goto L54;
        if (r6 >= r2.c) goto L54;
        if (r7 < r2.b) goto L54;
        if (r7 < r2.d) goto L22;
        goto L22
    }

    public final void i(float r19, float r20, boolean r21) {
        boolean r4 = false;
        if (Float.isInfinite(r19) == false) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
        return;
    L10:
        if (Float.isInfinite(r20) == false) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L61;
        com.larus.browsertakeover.render.c.b r6 = this.c.a(getWidth(), getHeight(), this.j, this.k, this.l);
        if (r6 != null) goto L20;
        return;
    L20:
        com.larus.browsertakeover.render.c.a r7 = r6.a;
        float r8 = r7.c - r7.a;
        float r9 = this.B - 1.0f;
        float r10 = r8 * r9;
        float r11 = (r7.d - r7.b) * r9;
        float r12 = this.C + (r19 - this.q);
        float r13 = this.D + (r20 - this.r);
        if (Float.isInfinite(r12) == false) goto L23;
    L25:
        boolean r14 = false;
    L26:
        if (r14 == true) goto L28;
        return;
    L28:
        if (Float.isInfinite(r13) == false) goto L30;
    L32:
        boolean r15 = false;
    L33:
        if (r15 == false) goto L62;
        this.C = RangesKt.coerceIn(r12, -r10, 0.0f);
        this.D = RangesKt.coerceIn(r13, -r11, 0.0f);
        this.q = r19;
        this.r = r20;
        invalidate();
        com.larus.browsertakeover.render.c.b r16 = r6.a(this.B, this.C, this.D);
        Pair<Float, Float> r1 = h(r19, r20, r16);
        if (r1 == null) goto L39;
        float r2 = this.E;
        float r17 = r12 - this.C;
        float r18 = r16.e;
        this.E = r2 - (r17 / r18);
        this.F -= (r13 - this.D) / r18;
        this.u = ((Number) r1.getFirst()).floatValue();
        this.v = ((Number) r1.getSecond()).floatValue();
        this.w = true;
    L39:
        if (this.w == true) goto L41;
        return;
    L41:
        if (this.E != 0.0f) goto L43;
        boolean r22 = true;
    L44:
        if (r22 == true) goto L46;
    L50:
        long r23 = System.nanoTime();
        int r24 = com.larus.browsertakeover.render.d.a;
        if (com.larus.browsertakeover.render.d.a(this.t, r23, getMovementIntervalNanos(), r21) == false) goto L64;
        float r25 = this.E;
        float r26 = this.F;
        this.E = 0.0f;
        this.F = 0.0f;
        this.t = r23;
        b r27 = this.J;
        if (r27 == null) goto L60;
        r27.Gp(this.u, this.v, r25, r26);
        return;
    L60:
        return;
    L64:
        return;
    L46:
        if (this.F != 0.0f) goto L48;
        r4 = true;
    L48:
        if (r4 == false) goto L50;
        return;
    L43:
        r22 = false;
        goto L44
    L62:
        return;
    L30:
        if (Float.isNaN(r13) == true) goto L32;
        r15 = true;
        goto L33
    L23:
        if (Float.isNaN(r12) == true) goto L25;
        r14 = true;
        goto L26
    L61:
        return;
    L12:
        if (Float.isNaN(r20) == true) goto L14;
        r5 = true;
        goto L15
    L5:
        if (Float.isNaN(r19) == true) goto L7;
        r3 = true;
        goto L8
    }

    public /* synthetic */ RemoteBrowserSurfaceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        a();
        com.larus.browsertakeover.render.c r5 = this.c;
        if (r5.a == true) goto L5;
    L9:
        this.B = 1.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        return;
    L5:
        if (r5.c == r1) goto L7;
    L8:
        r5.c = r1;
        r5.d = r2;
        goto L9
    L7:
        if (r5.d > 0) goto L9;
        goto L8
    }
}
