package com.obric.memorydata.screencapture.monitor;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\nJ\u000e\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001c\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/obric/memorydata/screencapture/monitor/InputMonitorManager;", "", "<init>", "()V", "TAG", "", "INPUT_CHANNEL_NAME", "INPUT_DISPATCHER_NAME", "inputEventListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/screencapture/monitor/InputMonitorManager$InputEventListener;", "handlerThreadMonitor", "Landroid/os/HandlerThread;", "getHandlerThreadMonitor", "()Landroid/os/HandlerThread;", "handlerThreadMonitor$delegate", "Lkotlin/Lazy;", "handlerThreadDispatcher", "getHandlerThreadDispatcher", "handlerThreadDispatcher$delegate", "handlerMonitor", "Landroid/os/Handler;", "getHandlerMonitor", "()Landroid/os/Handler;", "handlerMonitor$delegate", "inputHandler", "getInputHandler$screen_capture_obricRelease", "handlerDispatcher", "getHandlerDispatcher", "handlerDispatcher$delegate", "windowManger", "Landroid/view/WindowManager;", "getWindowManger", "()Landroid/view/WindowManager;", "windowManger$delegate", "monitorInput", "", "listener", "removeMonitor", "InputEventListener", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<a> f12806b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;
    private static final Lazy e = null;
    private static final Lazy f = null;
    private static final Lazy g = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/screencapture/monitor/InputMonitorManager$InputEventListener;", "", "onInputEvent", "", "event", "Landroid/view/InputEvent;", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void a(InputEvent r1);
    }

    static {
        f12805a = new d();
        f12806b = new CopyOnWriteArrayList();
        c = LazyKt.lazy($$Lambda$d$Jo0OJ4huwOntLRN_O23GgQUFwZw.INSTANCE);
        d = LazyKt.lazy($$Lambda$d$rBoeaYMnknvtr9ME9YzX2nGktmM.INSTANCE);
        e = LazyKt.lazy($$Lambda$d$nFGGR80dg68b79UBaRe_2EHUyM.INSTANCE);
        f = LazyKt.lazy($$Lambda$d$K4EwDyEFvpN4cqENd2_WWxYwWs0.INSTANCE);
        g = LazyKt.lazy($$Lambda$d$NkN_Nrn5p8woAYL7lcLvWt0vj08.INSTANCE);
    }

    private d() {
    }

    private static final Unit a(InputEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "inputEvent");
        final MotionEvent r3 = MotionEvent.obtain((MotionEvent) ZeusTransformUtils.preCheckCast(r2, MotionEvent.class, "com.obric.memorydata.plugin"));
        f12805a.e().post(new $$Lambda$d$YqpEXITAYkiH5sZUxT6SNfqygVo(r3));
        return Unit.INSTANCE;
    }

    private static final void a(MotionEvent r4) {
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(f12806b, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L8;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L10
        r2.a((InputEvent) ZeusTransformUtils.preCheckCast(r4, InputEvent.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        goto L5
    L8:
        r4.recycle();
        return;
    L10:
        th = move-exception;
        r4.recycle();
        throw th;
    }

    private final HandlerThread b() {
        return (HandlerThread) ZeusTransformUtils.preCheckCast(c.getValue(), HandlerThread.class, "com.obric.memorydata.plugin");
    }

    private final HandlerThread c() {
        return (HandlerThread) ZeusTransformUtils.preCheckCast(d.getValue(), HandlerThread.class, "com.obric.memorydata.plugin");
    }

    private final Handler d() {
        return (Handler) ZeusTransformUtils.preCheckCast(e.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    private final Handler e() {
        return (Handler) ZeusTransformUtils.preCheckCast(f.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    private final WindowManager f() {
        return (WindowManager) ZeusTransformUtils.preCheckCast(g.getValue(), WindowManager.class, "com.obric.memorydata.plugin");
    }

    private static final HandlerThread g() {
        HandlerThread r0 = new HandlerThread("MemoryInputMonitor");
        r0.start();
        return r0;
    }

    private static final HandlerThread h() {
        HandlerThread r0 = new HandlerThread("MemoryInputDispatcher");
        r0.start();
        return r0;
    }

    private static final Handler i() {
        return new Handler(f12805a.b().getLooper());
    }

    private static final Handler j() {
        return new Handler(f12805a.c().getLooper());
    }

    private static final WindowManager k() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.memorydata.plugin");
    }

    private static final void l() {
        b r0 = b.f12801a;
        d r1 = f12805a;
        int r2 = r1.f().getDefaultDisplay().getDisplayId();
        Looper r3 = r1.b().getLooper();
        Intrinsics.checkNotNullExpressionValue(r3, "getLooper(...)");
        Choreographer r4 = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(r4, "getInstance(...)");
        r0.a("MemoryInputMonitor", r2, r3, r4, $$Lambda$d$oC4wLvCDjCrgbzo02hZN6eRpJjI.INSTANCE);
    }

    public static /* synthetic */ void lambda$7JTLIRH3CwBOmpEVmxtLg6JlbCI() {
        l();
    }

    public static /* synthetic */ void lambda$DH0LsZj_ilC8ygVi2HsO_RtaXgs() {
        m();
    }

    public static /* synthetic */ HandlerThread lambda$Jo0OJ4huwOntLRN_O23GgQUFwZw() {
        return g();
    }

    public static /* synthetic */ Handler lambda$K4EwDyEFvpN4cqENd2_WWxYwWs0() {
        return j();
    }

    public static /* synthetic */ WindowManager lambda$NkN_Nrn5p8woAYL7lcLvWt0vj08() {
        return k();
    }

    public static /* synthetic */ void lambda$YqpEXITAYkiH5sZUxT6SNfqygVo(MotionEvent r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$nFGGR80dg68b79UBaRe_2EH-UyM, reason: not valid java name */
    public static /* synthetic */ Handler m1178lambda$nFGGR80dg68b79UBaRe_2EHUyM() {
        return i();
    }

    public static /* synthetic */ Unit lambda$oC4wLvCDjCrgbzo02hZN6eRpJjI(InputEvent r0) {
        return a(r0);
    }

    public static /* synthetic */ HandlerThread lambda$rBoeaYMnknvtr9ME9YzX2nGktmM() {
        return h();
    }

    private static final void m() {
        b.f12801a.a();
    }

    public final Handler a() {
        return e();
    }

    public final synchronized void a(a r4) {
        monitor-enter(this);
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "listener");     // Catch: Throwable -> L13
        CopyOnWriteArrayList<a> r0 = f12806b;     // Catch: Throwable -> L13
        if (r0.contains(r5) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r0.isEmpty() == false) goto L10;
        d().post($$Lambda$d$7JTLIRH3CwBOmpEVmxtLg6JlbCI.INSTANCE);     // Catch: Throwable -> L13
    L10:
        r0.add(r5);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(a r3) {
        monitor-enter(this);
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L8
        CopyOnWriteArrayList<a> r0 = f12806b;     // Catch: Throwable -> L8
        r0.remove(r4);     // Catch: Throwable -> L8
        if (r0.isEmpty() == false) goto L6;
        d().post($$Lambda$d$DH0LsZj_ilC8ygVi2HsO_RtaXgs.INSTANCE);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
