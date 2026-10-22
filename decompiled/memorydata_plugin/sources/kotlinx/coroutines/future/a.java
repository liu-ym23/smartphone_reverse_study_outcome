package kotlinx.coroutines.future;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/future/ContinuationHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/function/BiFunction;", "", "", "cont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "apply", "result", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class a<T> implements BiFunction<T, Throwable, Unit> {
    public volatile Continuation<? super T> cont;

    public void a(T r2, Throwable r3) {
        Continuation<? super T> r1 = this.cont;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L9;
        Result.Companion r4 = Result.Companion;
    L7:
        r1.resumeWith(Result.m1421constructorimpl(r2));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, CompletionException.class) == false) goto L11;
        CompletionException r5 = (CompletionException) ZeusTransformUtils.preCheckCast(r3, CompletionException.class, "com.obric.memorydata.plugin");
    L12:
        if (r5 == null) goto L17;
        Throwable r6 = r5.getCause();
        if (r6 == null) goto L17;
        r3 = r6;
    L17:
        Result.Companion r7 = Result.Companion;
        r2 = (T) ResultKt.createFailure(r3);
        goto L7
    L11:
        r5 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* synthetic */ Unit apply(Object r3, Throwable r4) {
        a(r3, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }
}
