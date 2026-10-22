package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "limitedParallelism", "parallelism", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class db extends ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final db f17308a = null;

    static {
        f17308a = new db();
    }

    private db() {
    }

    @Override // kotlinx.coroutines.ah
    public void dispatch(CoroutineContext r2, Runnable r3) {
        CoroutineContext r1 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        df r5 = (df) ZeusTransformUtils.preCheckCast(r1.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(df.f17337a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), df.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        r5.f17338b = true;
        return;
    L7:
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.ah
    public boolean isDispatchNeeded(CoroutineContext r2) {
        CoroutineContext r1 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Override // kotlinx.coroutines.ah
    public ah limitedParallelism(int r1) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.ah
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
