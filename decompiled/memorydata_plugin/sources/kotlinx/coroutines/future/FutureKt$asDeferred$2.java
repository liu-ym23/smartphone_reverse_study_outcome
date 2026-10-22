package kotlinx.coroutines.future;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CompletionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.w;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00032\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u0001H\u0003H\u00032\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "invoke", "(Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class FutureKt$asDeferred$2<T> extends Lambda implements Function2<T, Throwable, Object> {
    final /* synthetic */ w<T> $result;

    FutureKt$asDeferred$2(w<T> r3) {
        this.$result = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin");
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Throwable r4) {
        return invoke2(r3, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T r2, Throwable r3) {
        if (r3 != null) goto L5;
        boolean r1 = this.$result.a(r2);     // Catch: Throwable -> L17
    L15:
        return Boolean.valueOf(r1);
    L5:
        w<T> r4 = this.$result;     // Catch: Throwable -> L17
        if (ZeusTransformUtils.instanceOf(r3, CompletionException.class) == false) goto L8;
        CompletionException r5 = (CompletionException) ZeusTransformUtils.preCheckCast(r3, CompletionException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
    L9:
        if (r5 == null) goto L14;
        Throwable r6 = r5.getCause();     // Catch: Throwable -> L17
        if (r6 == null) goto L14;
        r3 = r6;
    L14:
        r1 = r4.a(r3);     // Catch: Throwable -> L17
        goto L15
    L8:
        r5 = null;
    L17:
        th = move-exception;
        ai.a((CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin"), th);
        return Unit.INSTANCE;
    }
}
