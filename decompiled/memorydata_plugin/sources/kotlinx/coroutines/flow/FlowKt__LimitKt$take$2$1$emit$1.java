package kotlinx.coroutines.flow;

import android.util.EventsUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1", f = "Limit.kt", i = {}, l = {58, EventsUtils.FEAT_TYPE_ACTIVITY_PAUSED_TIMEOUT}, m = "emit", n = {}, s = {})
final class FlowKt__LimitKt$take$2$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ v.g<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$take$2$1$emit$1(v.g<? super T> r3, Continuation<? super FlowKt__LimitKt$take$2$1$emit$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
