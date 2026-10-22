package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ao {
    public static final String a(Object r0) {
        return Integer.toHexString(System.identityHashCode(r0));
    }

    public static final String a(Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.internal.l.class) == false) goto L16;
        return r5.toString();
    L16:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.m1421constructorimpl(r5 + '@' + a(r5));     // Catch: Throwable -> L8
    L11:
        if (Result.m1424exceptionOrNullimpl(r3) == null) goto L15;
        r3 = r5.getClass().getName() + '@' + a(r5);
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final String b(Object r0) {
        return r0.getClass().getSimpleName();
    }
}
