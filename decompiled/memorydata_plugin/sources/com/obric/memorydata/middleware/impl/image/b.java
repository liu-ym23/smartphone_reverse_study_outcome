package com.obric.memorydata.middleware.impl.image;

import com.bytedance.obric.memory.model.GetImageUploadTokenRequest;
import com.bytedance.obric.memory.model.GetImageUploadTokenResponse;
import com.bytedance.obric.memory.model.ImageXToken;
import com.bytedance.rpc.RpcException;
import com.bytedance.rpc.model.rpc.MemoryGatewayService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\nJ5\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0015H\u0000¢\u0006\u0002\b\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\nJ\u001d\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010#\u001a\u00020\bH\u0000¢\u0006\u0002\b$J\u000e\u0010%\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXAuthManager;", "", "<init>", "()V", "TAG", "", "imageXTokenMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/middleware/impl/image/ImageXToken;", "lastErrorMessageMap", "Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;", "lock", "locks", "mExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "getLock", "bizType", "getAuthParams", "nowSeconds", "Lkotlin/Function0;", "", "refresh", "getAuthParams$middleware_impl_obricRelease", "updateAuthParams", "fetchAuthToken", "fetchRecommenderAuthToken", "fetchDoubaoAuthToken", "handleAuthRpcException", "error", "Lcom/bytedance/rpc/RpcException;", "getLastErrorMessage", "invalidateAuthParams", "", "rejectedToken", "invalidateAuthParams$middleware_impl_obricRelease", "clearAuthParams", "clearAllAuthParams", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, i> f11719b = null;
    private static final ConcurrentHashMap<ImageXBizType, String> c = null;
    private static final Object d = null;
    private static final ConcurrentHashMap<ImageXBizType, Object> e = null;
    private static final ExecutorService f = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11720a = null;

        static {
            int[] r0 = new int[ImageXBizType.values().length];
            r0[ImageXBizType.RECOMMENDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ImageXBizType.DOUBAO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ImageXBizType.O_ASSISTANT_FEEDBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ImageXBizType.O_ASSISTANT_FEEDBACK_FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ImageXBizType.AUDITORY_MEMORY_FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f11720a = r0;
        }
    }

    static {
        f11718a = new b();
        f11719b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new Object();
        e = new ConcurrentHashMap();
        f = Executors.newCachedThreadPool();
    }

    private b() {
    }

    private final i a() {
        GetImageUploadTokenResponse r0 = com.bytedance.obric.memory.a.a.a(new GetImageUploadTokenRequest());     // Catch: RpcException -> L4
        i.a r1 = i.f11735a;     // Catch: RpcException -> L4
        ImageXToken r2 = r0.data;     // Catch: RpcException -> L4
        Intrinsics.checkNotNullExpressionValue(r2, "data");     // Catch: RpcException -> L4
        return r1.a(r2);
    L4:
        e = move-exception;
        return a(ImageXBizType.RECOMMENDER, e);
    }

    private final i a(ImageXBizType r4, RpcException r5) {
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r4, "auth rpc exception: " + r5.getClass().getSimpleName());
        RunLog.INSTANCE.error("ImageXAuthManager", "Update auth failed for " + r4.name() + ": RpcException", (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final i b() {
        com.bytedance.rpc.model.GetImageUploadTokenResponse r0 = MemoryGatewayService.getImageUploadTokenDoubaoSync(new com.bytedance.rpc.model.GetImageUploadTokenRequest());     // Catch: RpcException -> L4
        i.a r1 = i.f11735a;     // Catch: RpcException -> L4
        com.bytedance.rpc.model.ImageXToken r2 = r0.data;     // Catch: RpcException -> L4
        Intrinsics.checkNotNullExpressionValue(r2, "data");     // Catch: RpcException -> L4
        return r1.a(r2);
    L4:
        e = move-exception;
        return a(ImageXBizType.DOUBAO, e);
    }

    private final Object b(ImageXBizType r3) {
        ConcurrentMap r2 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(e, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r0 = r2.get(r3);
        if (r0 != null) goto L8;
        r0 = new Object();
        Object r4 = r2.putIfAbsent(r3, r0);
        if (r4 == null) goto L8;
        r0 = r4;
    L8:
        Intrinsics.checkNotNullExpressionValue(r0, "getOrPut(...)");
        return r0;
    }

    private static final long c() {
        return System.currentTimeMillis() / ((long) 1000);
    }

    private final i c(final ImageXBizType r13) {
        ConcurrentHashMap<ImageXBizType, String> r0 = c;
        r0.remove(r13);
        Future r1 = f.submit(new $$Lambda$b$vQ7McBNYsLc5enB7R7OD7T8it8A(r13));
        i r2 = (i) ZeusTransformUtils.preCheckCast(r1.get(5, TimeUnit.SECONDS), i.class, "com.obric.memorydata.plugin");     // Catch: ExecutionException -> L8 InterruptedException -> L13 TimeoutException -> L15
        if (r2 == null) goto L19;
        r0.remove(r13);     // Catch: ExecutionException -> L8 InterruptedException -> L13 TimeoutException -> L15
        RunLog.INSTANCE.debug("ImageXAuthManager", "Updated " + r13.name() + " token, expires at " + r2.d());     // Catch: ExecutionException -> L8 InterruptedException -> L13 TimeoutException -> L15
    L7:
        return r2;
    L19:
        return null;
    L13:
        r1.cancel(true);
        Thread.currentThread().interrupt();
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r13, "auth interrupted");
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("Update auth interrupted for ");
        String r14 = r13.name();
    L14:
        IRunLog.a.b(r5, "ImageXAuthManager", r12.append(r14).toString(), null, 4, null);
    L16:
        return null;
    L8:
        e = move-exception;
        Throwable r3 = e.getCause();
        if (r3 != null) goto L12;
        r3 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
    L12:
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r13, "auth exception: " + r3.getClass().getSimpleName());
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r12 = new StringBuilder().append("Update auth failed: ").append(r3.getClass().getSimpleName()).append(" - ");
        r14 = r3.getMessage();
    L15:
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r13, "auth timeout");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageXAuthManager", "Update auth timeout for " + r13.name(), null, 4, null);
        r1.cancel(true);
        goto L16
    }

    private final i d(ImageXBizType r7) {
        int r1 = a.f11720a[r7.ordinal()];
        if (r1 == 1) goto L34;
        if (r1 == 2) goto L37;
        String r4 = "prepare_upload returned no token";
        if (r1 != 3) goto L9;
        i r2 = f.f11730a.b();
        if (r2 != null) goto L36;
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin");
        String r0 = f.f11730a.a();
        if (r0 == null) goto L30;
    L29:
        r4 = r0;
    L30:
        r8.put(r7, r4);
        return null;
    L36:
        return r2;
    L9:
        if (r1 != 4) goto L11;
        r2 = f.f11730a.c();
        if (r2 != null) goto L36;
        b r9 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        r8 = (Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin");
        r0 = f.f11730a.a();
        if (r0 != null) goto L29;
    L11:
        if (r1 != 5) goto L18;
        r2 = f.f11730a.d();
        if (r2 != null) goto L36;
        b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        r8 = (Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin");
        r0 = f.f11730a.a();
        if (r0 != null) goto L29;
    L18:
        throw new NoWhenBranchMatchedException();
    L37:
        return b();
    L34:
        return a();
    }

    private static final i e(ImageXBizType r1) {
        return f11718a.c(r1);
    }

    private static final i f(ImageXBizType r1) {
        return f11718a.d(r1);
    }

    public static /* synthetic */ i lambda$pgDjK0VRGlWCbanz6u08Ty0433c(ImageXBizType r0) {
        return e(r0);
    }

    public static /* synthetic */ long lambda$v7nSiWmkD99FkdMetvnmBHCwG3U() {
        return c();
    }

    public static /* synthetic */ i lambda$vQ7McBNYsLc5enB7R7OD7T8it8A(ImageXBizType r0) {
        return f(r0);
    }

    public final i a(final ImageXBizType r3) {
        Intrinsics.checkNotNullParameter(r3, "bizType");
        return a(r3, $$Lambda$b$v7nSiWmkD99FkdMetvnmBHCwG3U.INSTANCE, new $$Lambda$b$pgDjK0VRGlWCbanz6u08Ty0433c(r3));
    }

    public final i a(ImageXBizType r9, Function0<Long> r10, Function0<i> r11) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "bizType");
        Intrinsics.checkNotNullParameter(r12, "nowSeconds");
        Intrinsics.checkNotNullParameter(r13, "refresh");
        Object r8 = b(r9);
        monitor-enter(r8);
        ConcurrentHashMap<String, i> r0 = f11719b;     // Catch: Throwable -> L25
        i r1 = (i) ZeusTransformUtils.preCheckCast(r0.get(r9.name()), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1 != null) goto L7;
    L8:
        i r14 = (i) ZeusTransformUtils.preCheckCast(r13.invoke(), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r14 == null) goto L11;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r9.name(), r14);     // Catch: Throwable -> L25
    L11:
        i r15 = (i) ZeusTransformUtils.preCheckCast(r0.get(r9.name()), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r15 != null) goto L17;
        monitor-exit(r8);
        return null;
    L17:
        if (r9 == ImageXBizType.AUDITORY_MEMORY_FILE) goto L19;
    L23:
        monitor-exit(r8);
        return r15;
    L19:
        if (r15.d() > ((Number) ZeusTransformUtils.preCheckCast(r12.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue()) goto L23;
        r0.remove(r9.name());     // Catch: Throwable -> L25
        c.putIfAbsent(r9, "UPLOAD_AUTH_EXPIRED");     // Catch: Throwable -> L25
        monitor-exit(r8);
        return null;
    L7:
        if (((Number) ZeusTransformUtils.preCheckCast(r12.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() < (r1.d() - ((long) 300))) goto L11;
    L25:
        th = move-exception;
        throw th;
    }

    public final void a(ImageXBizType r3, i r4) {
        Intrinsics.checkNotNullParameter(r3, "bizType");
        Intrinsics.checkNotNullParameter(r4, "rejectedToken");
        Object r2 = b(r3);
        monitor-enter(r2);
        ConcurrentHashMap<String, i> r0 = f11719b;     // Catch: Throwable -> L10
        if (r0.get(r3.name()) != r4) goto L7;
        r0.remove(r3.name());     // Catch: Throwable -> L10
    L7:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r2);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
