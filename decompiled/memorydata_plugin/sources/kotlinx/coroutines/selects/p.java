package kotlinx.coroutines.selects;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ah;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0081H¢\u0006\u0002\u0010\u0007\u001a5\u0010\b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0081H¢\u0006\u0002\u0010\u0007\u001a%\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0002¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"selectOld", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUnbiasedOld", "resumeUndispatched", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuation;", "result", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "resumeUndispatchedWithException", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class p {
    public static final /* synthetic */ void a(kotlinx.coroutines.n r2, Object r3) {
        b((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final /* synthetic */ void a(kotlinx.coroutines.n r2, Throwable r3) {
        b((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final <T> void b(kotlinx.coroutines.n<? super T> r4, T r5) {
        kotlinx.coroutines.n r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        ah r0 = (ah) ZeusTransformUtils.preCheckCast(r6.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ah.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ah.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r6.a(r0, r5);
        return;
    L5:
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r1 = Result.Companion;
        r7.resumeWith(Result.m1421constructorimpl(r5));
    }

    private static final void b(kotlinx.coroutines.n<?> r4, Throwable r5) {
        kotlinx.coroutines.n r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        ah r0 = (ah) ZeusTransformUtils.preCheckCast(r6.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ah.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ah.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r6.a(r0, r5);
        return;
    L5:
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r1 = Result.Companion;
        r7.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(r5)));
    }
}
