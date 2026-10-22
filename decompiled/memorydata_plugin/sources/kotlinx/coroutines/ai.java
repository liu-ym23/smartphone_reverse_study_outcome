package kotlinx.coroutines;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086\b\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0000¨\u0006\r"}, d2 = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ai {
    public static final Throwable a(Throwable r2, Throwable r3) {
        if (r2 != r3) goto L4;
        return r2;
    L4:
        RuntimeException r0 = new RuntimeException("Exception while trying to handle coroutine exception", r3);
        ExceptionsKt.addSuppressed((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin"), r2);
        return (Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin");
    }

    public static final void a(CoroutineContext r3, Throwable r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineExceptionHandler r0 = (CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(r5.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(CoroutineExceptionHandler.f17198b, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.handleException(r5, r4);     // Catch: Throwable -> L9
        return;
    L7:
        kotlinx.coroutines.internal.j.a(r5, r4);
        return;
    L9:
        th = move-exception;
        kotlinx.coroutines.internal.j.a(r5, a(r4, th));
    }
}
