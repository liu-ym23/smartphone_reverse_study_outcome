package com.obric.aiagent.product.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001b\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001d\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u000fJ&\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0004\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0086\bø\u0001\u0000J&\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0004\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0086\bø\u0001\u0000J\u001c\u0010\u001d\u001a\u00020\u00152\u000e\b\u0004\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0086\bø\u0001\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"Lcom/obric/aiagent/product/utils/ThreadUtils;", "", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "handlerThreadLazy", "Lkotlin/Lazy;", "Landroid/os/HandlerThread;", "handlerThread", "getHandlerThread", "()Landroid/os/HandlerThread;", "isShutdown", "", "backgroundHandler", "getBackgroundHandler", "backgroundHandler$delegate", "Lkotlin/Lazy;", "shutdown", "", "postInBackground", "runnable", "Ljava/lang/Runnable;", "delayMillis", "", "postInForeground", "postInForegroundAtFrontOfQueue", "runInMain", "sleep", OaidModel.KEY_TIME, "isOnBackgroundThread", "action", "Lkotlin/Function0;", "SafeWrapper", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f5970b = null;
    private static final Lazy<HandlerThread> c = null;
    private static final Lazy d = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/aiagent/product/utils/ThreadUtils$SafeWrapper;", "Ljava/lang/Runnable;", TypedValues.AttributesType.S_TARGET, "<init>", "(Ljava/lang/Runnable;)V", "getTarget", "()Ljava/lang/Runnable;", "run", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f5971a;

        public a(Runnable r3) {
            this.f5971a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r0 = this.f5971a;
            if (r0 != null) goto L12;
            return;
        L12:
            r0.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (ZeusTransformUtils.instanceOf(th, Error.class) == true) goto L10;
            com.obric.aiagent.platform.a.d.f5954a.d("SafeWrapper", "fail to execute runnable = " + this.f5971a + " error = " + Log.getStackTraceString(th));
            return;
        L10:
            throw th;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f5972a;

        public b(Function0<Unit> r3) {
            this.f5972a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f5972a.invoke();
        }
    }

    static {
        f5969a = new d();
        f5970b = new Handler(Looper.getMainLooper());
        c = LazyKt.lazy($$Lambda$d$ciwSUuCN8HlT7epXIkEu2pJLqkA.INSTANCE);
        d = LazyKt.lazy($$Lambda$d$k1OtnJ4w_4PRKbltL1y1xM_hDww.INSTANCE);
    }

    private d() {
    }

    private final HandlerThread c() {
        return (HandlerThread) ZeusTransformUtils.preCheckCast(c.getValue(), HandlerThread.class, "com.obric.memorydata.plugin");
    }

    private static final HandlerThread d() {
        HandlerThread r0 = new HandlerThread("background_thread_utils");
        r0.start();
        com.obric.aiagent.platform.a.d.f5954a.b("ThreadUtils", "ThreadUtils inited，currentThread = " + Thread.currentThread());
        return r0;
    }

    private static final Handler e() {
        return new Handler(f5969a.c().getLooper());
    }

    public static /* synthetic */ HandlerThread lambda$ciwSUuCN8HlT7epXIkEu2pJLqkA() {
        return d();
    }

    public static /* synthetic */ Handler lambda$k1OtnJ4w_4PRKbltL1y1xM_hDww() {
        return e();
    }

    public final Handler a() {
        return f5970b;
    }

    public final void a(Runnable r3) {
        Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        f5970b.post((Runnable) ZeusTransformUtils.preCheckCast(new a(r2), Runnable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(Runnable r3, long r4) {
        Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        f5970b.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(new a(r2), Runnable.class, "com.obric.memorydata.plugin"), r4);
    }

    public final Handler b() {
        return (Handler) ZeusTransformUtils.preCheckCast(d.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    public final void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L8;
        r4.run();
        return;
    L8:
        a(r4);
    }
}
