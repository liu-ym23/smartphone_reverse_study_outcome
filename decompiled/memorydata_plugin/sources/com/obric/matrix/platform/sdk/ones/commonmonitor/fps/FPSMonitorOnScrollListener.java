package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0016J \u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0006\u0010\u001f\u001a\u00020\u0016J\b\u0010 \u001a\u00020\u0016H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", MemoryInfoSectionEditActivity.KIND_SCENE, "", "(Ljava/lang/String;)V", "forceCollect", "", "fpsCallBack", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;", "(Ljava/lang/String;ZLcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;)V", "curFpsBean", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "distanceX", "", "distanceY", "dragStart", "", "lastFpsBean", "mFpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "printerHasReset", "checkResetPrinter", "", "initFpsTracerCallbacks", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "removeFpsCallback", "reset", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener$Companion;", "", "()V", "FPS_BEANS", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener$initFpsTracerCallbacks$1", "Lcom/bytedance/apm/trace/fps/FpsTracer$IFPSCallBack;", "fpsCallBack", "", "fps", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.bytedance.apm.trace.fps.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FPSMonitorOnScrollListener f8084a;

        b(FPSMonitorOnScrollListener r1) {
            this.f8084a = r1;
        }

        @Override // com.bytedance.apm.trace.fps.b.d
        public void a(double r5) {
            FPSMonitorOnScrollListener.access$setLastFpsBean$p(this.f8084a, (d) ZeusTransformUtils.preCheckCast(FPSMonitorOnScrollListener.access$getFPS_BEANS$cp().poll(), d.class, "com.obric.memorydata.plugin"));
            d r4 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f8084a);
            if (r4 == null) goto L7;
            r4.a(r5);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener$initFpsTracerCallbacks$2", "Lcom/bytedance/apm/trace/fps/FpsTracer$IDropFrameCallback;", "dropFrame", "", "dropFrames", "Lorg/json/JSONObject;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements com.bytedance.apm.trace.fps.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FPSMonitorOnScrollListener f8085a;

        c(FPSMonitorOnScrollListener r1) {
            this.f8085a = r1;
        }

        @Override // com.bytedance.apm.trace.fps.b.c
        public void a(JSONObject r14) {
            if (r14 != null) goto L5;
            return;
        L5:
            if (FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f8085a) == null) goto L54;
            Iterator<String> r1 = r14.keys();     // Catch: Exception -> L40
            double r2 = 0.0d;
            int r6 = 0;
            int r7 = 0;
            int r8 = 0;
            double r4 = 0.0d;
        L8:
            if (r1.hasNext() == false) goto L22;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L40
            Intrinsics.checkNotNullExpressionValue(r9, "keyStr");     // Catch: Exception -> L40
            int r10 = Integer.parseInt(r9);     // Catch: Exception -> L40
            int r11 = r14.getInt(r9);     // Catch: Exception -> L40
            if (r10 == 0) goto L11;
            if (r10 <= 0) goto L8;
            r2 = r2 + ((double) (r10 * r11));     // Catch: Exception -> L40
            r4 = r4 + ((double) r11);     // Catch: Exception -> L40
            if (r10 < 25) goto L17;
            r8 = r8 + r11;     // Catch: Exception -> L40
        L17:
            if (r10 < 7) goto L20;
            r7 = r7 + r11;     // Catch: Exception -> L40
        L20:
            if (r10 < 3) goto L8;
            r6 = r6 + r11;     // Catch: Exception -> L40
            goto L8
        L11:
            r4 = r4 + ((double) r11);     // Catch: Exception -> L40
            goto L8
        L22:
            d r3 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f8085a);     // Catch: Exception -> L40
            if (r3 == null) goto L25;
            r3.b(g.f8099a.a(r2 / (r2 + r4)));     // Catch: Exception -> L40
            r3.h(r6);     // Catch: Exception -> L40
            r3.i(r7);     // Catch: Exception -> L40
            r3.j(r8);     // Catch: Exception -> L40
            r3.g((int) r4);     // Catch: Exception -> L40
        L25:
            com.obric.matrix.platform.sdk.ones.internal.b.b.b(FPSMonitorOnScrollListener.TAG, "dropFrame: " + r14, null, 4, null);     // Catch: Exception -> L40
            com.obric.matrix.platform.sdk.ones.internal.b.b.b(FPSMonitorOnScrollListener.TAG, "fpsCallBack: " + FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f8085a), null, 4, null);     // Catch: Exception -> L40
            d r15 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f8085a);     // Catch: Exception -> L40
            if (r15 == null) goto L28;
            JSONObject r16 = com.obric.matrix.platform.sdk.ones.commonmonitor.fps.a.f8086a.a(r15);     // Catch: Exception -> L40
        L29:
            d r0 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f8085a);     // Catch: Exception -> L40
            if (r0 == null) goto L32;
            com.obric.matrix.platform.sdk.ones.a.e.f8062a.a().a(FPSMonitorOnScrollListener.access$getScene$p(this.f8085a), (float) r0.a(), r16);     // Catch: Exception -> L40
        L32:
            e r17 = FPSMonitorOnScrollListener.access$getFpsCallBack$p(this.f8085a);     // Catch: Exception -> L40
            if (r17 == null) goto L35;
            r17.a(FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f8085a));     // Catch: Exception -> L40
        L35:
            d r18 = FPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f8085a);     // Catch: Exception -> L40
            if (r18 == null) goto L38;
            r18.f();     // Catch: Exception -> L40
        L38:
            FPSMonitorOnScrollListener.access$setLastFpsBean$p(this.f8085a, null);     // Catch: Exception -> L40
            return;
        L28:
            r16 = null;
        L55:
            return;
        }
    }

    static {
        Companion = new a(null);
        FPS_BEANS = new ConcurrentLinkedQueue();
    }

    public FPSMonitorOnScrollListener(String r3) {
        Intrinsics.checkNotNullParameter(r3, MemoryInfoSectionEditActivity.KIND_SCENE);
        this(r3, false, null);
    }

    public FPSMonitorOnScrollListener(String r3, boolean r4, e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, MemoryInfoSectionEditActivity.KIND_SCENE);
        this.scene = r3;
        this.forceCollect = r4;
        this.fpsCallBack = r6;
        this.mFpsTracer = new com.bytedance.apm.trace.fps.b(r3, r4);
        this.dragStart = -1;
        initFpsTracerCallbacks();
    }

    public /* synthetic */ FPSMonitorOnScrollListener(String r2, boolean r3, e r4, int r5, DefaultConstructorMarker r6) {
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r7 = null;
    L8:
        this(r2, r3, r7);
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getFPS_BEANS$cp() {
        return FPS_BEANS;
    }

    public static final /* synthetic */ e access$getFpsCallBack$p(FPSMonitorOnScrollListener r0) {
        return r0.fpsCallBack;
    }

    public static final /* synthetic */ d access$getLastFpsBean$p(FPSMonitorOnScrollListener r0) {
        return r0.lastFpsBean;
    }

    public static final /* synthetic */ String access$getScene$p(FPSMonitorOnScrollListener r0) {
        return r0.scene;
    }

    public static final /* synthetic */ void access$setLastFpsBean$p(FPSMonitorOnScrollListener r0, d r1) {
        r0.lastFpsBean = r1;
    }

    private final void checkResetPrinter() {
        if (this.printerHasReset == false) goto L5;
        return;
    L5:
        if (com.obric.matrix.platform.sdk.ones.commonmonitor.fps.a.f8086a.a() != null) goto L17;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a(TAG, "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r0 = f.class.getDeclaredField("b");     // Catch: Exception -> L12
        Intrinsics.checkNotNullExpressionValue(r0, "LooperPrinterUtils::clas…dField(\"sPrinterWrapper\")");     // Catch: Exception -> L12
        r0.setAccessible(true);     // Catch: Exception -> L12
        Object r1 = r0.get(null);     // Catch: Exception -> L12
        if (r1 == null) goto L11;
        Printer r2 = (Printer) ZeusTransformUtils.preCheckCast(r1, Printer.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        Looper.getMainLooper().setMessageLogging(r2);     // Catch: Exception -> L12
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
        this.mFpsTracer.a((com.bytedance.apm.trace.fps.b.d) ZeusTransformUtils.preCheckCast(new b(this), com.bytedance.apm.trace.fps.b.d.class, "com.obric.memorydata.plugin"));
        this.mFpsTracer.a((com.bytedance.apm.trace.fps.b.c) ZeusTransformUtils.preCheckCast(new c(this), com.bytedance.apm.trace.fps.b.c.class, "com.obric.memorydata.plugin"));
    }

    private final void reset() {
        this.distanceX = 0;
        this.distanceY = 0;
        this.dragStart = -1;
        d r0 = this.curFpsBean;
        if (r0 == null) goto L6;
        FPS_BEANS.add(r0);
        this.curFpsBean = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        super.onScrollStateChanged(r5, r6);
        if (r6 != 0) goto L5;
        d r7 = this.curFpsBean;
        if (r7 != null) goto L20;
    L23:
        reset();
        this.mFpsTracer.b();
        return;
    L20:
        if (this.dragStart <= 0) goto L22;
        r7.a(SystemClock.elapsedRealtime() - this.dragStart);
    L22:
        r7.e(this.distanceX);
        r7.f(this.distanceY);
        r7.c(r5.computeHorizontalScrollOffset());
        r7.d(r5.computeVerticalScrollOffset());
        goto L23
    L5:
        if (r6 == 1) goto L8;
        return;
    L8:
        if (this.dragStart < 0) goto L10;
    L16:
        checkResetPrinter();
        this.mFpsTracer.a();
        return;
    L10:
        if (this.curFpsBean != null) goto L12;
        this.curFpsBean = d.f8093a.a();
    L12:
        d r8 = this.curFpsBean;
        if (r8 == null) goto L15;
        r8.a(r5.computeHorizontalScrollOffset());
        r8.b(r5.computeVerticalScrollOffset());
    L15:
        this.dragStart = SystemClock.elapsedRealtime();
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        this.distanceX += Math.abs(r3);
        this.distanceY += Math.abs(r4);
    }

    public final void removeFpsCallback() {
        this.mFpsTracer.a(null);
    }
}
