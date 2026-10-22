package kotlinx.coroutines.internal;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"handleUncaughtCoroutineException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class j {
    public static final void a(CoroutineContext r4, Throwable r5) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        Iterator<CoroutineExceptionHandler> r0 = i.a().iterator();
    L4:
        if (r0.hasNext() == true) goto L17;
        ExceptionsKt.addSuppressed(r5, (Throwable) ZeusTransformUtils.preCheckCast(new DiagnosticCoroutineContextException(r6), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L12:
        i.a(r5);
        return;
    L17:
        ((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(r0.next(), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin")).handleException(r6, r5);     // Catch: Throwable -> L8 ExceptionSuccessfullyProcessed -> L10
    L10:
        return;
    L8:
        th = move-exception;
        i.a(kotlinx.coroutines.ai.a(r5, th));
        goto L4
    }
}
