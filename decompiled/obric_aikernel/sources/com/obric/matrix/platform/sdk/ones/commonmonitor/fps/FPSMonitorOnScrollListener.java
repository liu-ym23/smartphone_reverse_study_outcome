package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class FPSMonitorOnScrollListener extends RecyclerView.OnScrollListener {
    public static final a Companion = null;
    private static final ConcurrentLinkedQueue<d> FPS_BEANS = null;
    private static final String TAG = "FPSMonitorOnScrollListener";
    private d curFpsBean;
    private int distanceX;
    private int distanceY;
    private long dragStart;
    private final boolean forceCollect;
    private final e fpsCallBack;
    private d lastFpsBean;
    private final com.bytedance.apm.trace.fps.b mFpsTracer;
    private boolean printerHasReset;
    private final String scene;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements com.bytedance.apm.trace.fps.b.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FPSMonitorOnScrollListener f5853a;

        b(FPSMonitorOnScrollListener r10) {
            this.f5853a = r10;
        }

        @Override // com.bytedance.apm.trace.fps.b.g
        public void a(double r10) {
            FPSMonitorOnScrollListener.access$setLastFpsBean$p(this.f5853a, (d) FPSMonitorOnScrollListener.access$getFPS_BEANS$cp().poll());
            d r11 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f5853a);
            if (r11 == null) goto L7;
            r11.q(r10);
            return;
        }
    }

    public static final class c implements com.bytedance.apm.trace.fps.b.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FPSMonitorOnScrollListener f5854a;

        c(FPSMonitorOnScrollListener r10) {
            this.f5854a = r10;
        }

        @Override // com.bytedance.apm.trace.fps.b.f
        public void a(JSONObject r14) {
            if (r14 != null) goto L5;
            return;
        L5:
            if (FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f5854a) == null) goto L54;
            Iterator<String> r10 = r14.keys();     // Catch: Exception -> L40
            double r11 = 0.0d;
            int r12 = 0;
            int r13 = 0;
            int r15 = 0;
            double r16 = 0.0d;
        L8:
            if (r10.hasNext() == false) goto L22;
            String r17 = r10.next();     // Catch: Exception -> L40
            Intrinsics.checkNotNullExpressionValue(r17, "keyStr");     // Catch: Exception -> L40
            int r18 = Integer.parseInt(r17);     // Catch: Exception -> L40
            int r19 = r14.getInt(r17);     // Catch: Exception -> L40
            if (r18 == 0) goto L11;
            if (r18 <= 0) goto L8;
            r11 = r11 + ((double) (r18 * r19));     // Catch: Exception -> L40
            r16 = r16 + ((double) r19);     // Catch: Exception -> L40
            if (r18 < 25) goto L17;
            r15 = r15 + r19;     // Catch: Exception -> L40
        L17:
            if (r18 < 7) goto L20;
            r13 = r13 + r19;     // Catch: Exception -> L40
        L20:
            if (r18 < 3) goto L8;
            r12 = r12 + r19;     // Catch: Exception -> L40
            goto L8
        L11:
            r16 = r16 + ((double) r19);     // Catch: Exception -> L40
            goto L8
        L22:
            d r20 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f5854a);     // Catch: Exception -> L40
            if (r20 == null) goto L25;
            r20.m(g.f5882a.a(r11 / (r11 + r16)));     // Catch: Exception -> L40
            r20.k(r12);     // Catch: Exception -> L40
            r20.l(r13);     // Catch: Exception -> L40
            r20.j(r15);     // Catch: Exception -> L40
            r20.r((int) r16);     // Catch: Exception -> L40
        L25:
            e9.b.f(FPSMonitorOnScrollListener.TAG, "dropFrame: " + r14, null, 4, null);     // Catch: Exception -> L40
            e9.b.f(FPSMonitorOnScrollListener.TAG, "fpsCallBack: " + FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f5854a), null, 4, null);     // Catch: Exception -> L40
            d r110 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f5854a);     // Catch: Exception -> L40
            if (r110 == null) goto L28;
            JSONObject r111 = com.obric.matrix.platform.sdk.ones.commonmonitor.fps.a.f5855a.b(r110);     // Catch: Exception -> L40
        L29:
            d r21 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f5854a);     // Catch: Exception -> L40
            if (r21 == null) goto L32;
            c9.g.f656l.a().s(FPSMonitorOnScrollListener.access$getScene$p(this.f5854a), (float) r21.f(), r111);     // Catch: Exception -> L40
        L32:
            e r112 = FPSMonitorOnScrollListener.access$getFpsCallBack$p(this.f5854a);     // Catch: Exception -> L40
            if (r112 == null) goto L35;
            r112.a(FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f5854a));     // Catch: Exception -> L40
        L35:
            d r113 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f5854a);     // Catch: Exception -> L40
            if (r113 == null) goto L38;
            r113.g();     // Catch: Exception -> L40
        L38:
            FPSMonitorOnScrollListener.access$setLastFpsBean$p(this.f5854a, null);     // Catch: Exception -> L40
            return;
        L28:
            r111 = null;
        L55:
            return;
        }
    }

    static {
        Companion = new a(null);
        FPS_BEANS = new ConcurrentLinkedQueue();
    }

    public FPSMonitorOnScrollListener(String r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        this(r10, false, null);
    }

    public FPSMonitorOnScrollListener(String r10, boolean r11, e r12) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        this.scene = r10;
        this.forceCollect = r11;
        this.fpsCallBack = r12;
        this.mFpsTracer = new com.bytedance.apm.trace.fps.b(r10, r11);
        this.dragStart = -1;
        initFpsTracerCallbacks();
    }

    public /* synthetic */ FPSMonitorOnScrollListener(String r10, boolean r11, e r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getFPS_BEANS$cp() {
        return FPS_BEANS;
    }

    public static final /* synthetic */ e access$getFpsCallBack$p(FPSMonitorOnScrollListener r10) {
        return r10.fpsCallBack;
    }

    public static final /* synthetic */ d access$getLastFpsBean$p(FPSMonitorOnScrollListener r10) {
        return r10.lastFpsBean;
    }

    public static final /* synthetic */ String access$getScene$p(FPSMonitorOnScrollListener r10) {
        return r10.scene;
    }

    public static final /* synthetic */ void access$setLastFpsBean$p(FPSMonitorOnScrollListener r10, d r11) {
        r10.lastFpsBean = r11;
    }

    private final void checkResetPrinter() {
        if (this.printerHasReset == false) goto L5;
        return;
    L5:
        if (com.obric.matrix.platform.sdk.ones.commonmonitor.fps.a.f5855a.a() != null) goto L17;
        e9.b.b(TAG, "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r10 = f.class.getDeclaredField("a");     // Catch: Exception -> L12
        Intrinsics.checkNotNullExpressionValue(r10, "LooperPrinterUtils::clas…dField(\"sPrinterWrapper\")");     // Catch: Exception -> L12
        r10.setAccessible(true);     // Catch: Exception -> L12
        Object r11 = r10.get(null);     // Catch: Exception -> L12
        if (r11 == null) goto L11;
        Looper r12 = Looper.getMainLooper();     // Catch: Exception -> L12
        r12.setMessageLogging((Printer) r11);     // Catch: Exception -> L12
        this.printerHasReset = true;     // Catch: Exception -> L12
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private final void initFpsTracerCallbacks() {
        this.mFpsTracer.L(new b(this));
        this.mFpsTracer.J(new c(this));
    }

    private final void reset() {
        this.distanceX = 0;
        this.distanceY = 0;
        this.dragStart = -1;
        d r10 = this.curFpsBean;
        if (r10 == null) goto L6;
        FPS_BEANS.add(r10);
        this.curFpsBean = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        super.onScrollStateChanged(r10, r11);
        if (r11 != 0) goto L5;
        d r12 = this.curFpsBean;
        if (r12 != null) goto L20;
    L23:
        reset();
        this.mFpsTracer.Q();
        return;
    L20:
        if (this.dragStart <= 0) goto L22;
        r12.n(SystemClock.elapsedRealtime() - this.dragStart);
    L22:
        r12.h(this.distanceX);
        r12.i(this.distanceY);
        r12.o(r10.computeHorizontalScrollOffset());
        r12.p(r10.computeVerticalScrollOffset());
        goto L23
    L5:
        if (r11 == 1) goto L8;
        return;
    L8:
        if (this.dragStart < 0) goto L10;
    L16:
        checkResetPrinter();
        this.mFpsTracer.M();
        return;
    L10:
        if (this.curFpsBean != null) goto L12;
        this.curFpsBean = d.f5866n.a();
    L12:
        d r13 = this.curFpsBean;
        if (r13 == null) goto L15;
        r13.s(r10.computeHorizontalScrollOffset());
        r13.t(r10.computeVerticalScrollOffset());
    L15:
        this.dragStart = SystemClock.elapsedRealtime();
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        super.onScrolled(r10, r11, r12);
        this.distanceX += Math.abs(r11);
        this.distanceY += Math.abs(r12);
    }

    public final void removeFpsCallback() {
        this.mFpsTracer.L(null);
    }
}
