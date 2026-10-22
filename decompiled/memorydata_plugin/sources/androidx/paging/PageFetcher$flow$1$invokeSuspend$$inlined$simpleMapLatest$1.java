package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "androidx/paging/FlowExtKt$simpleMapLatest$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1", f = "PageFetcher.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1<Key, Value> extends SuspendLambda implements Function3<j<? super PagingData<Value>>, PageFetcher.GenerationInfo<Key, Value>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RemoteMediatorAccessor $remoteMediatorAccessor$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ PageFetcher this$0;

    public PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(Continuation r3, PageFetcher r4, RemoteMediatorAccessor r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        RemoteMediatorAccessor r7 = (RemoteMediatorAccessor) ZeusTransformUtils.wrapperContextForParams(r5, RemoteMediatorAccessor.class, "com.obric.memorydata.plugin");
        this.this$0 = r4;
        this.$remoteMediatorAccessor$inlined = r7;
        super(3, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(Object r3, Object r4, Continuation<? super Unit> r5) {
        return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(j<? super PagingData<Value>> r3, PageFetcher.GenerationInfo<Key, Value> r4, Continuation<? super Unit> r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1 r0 = new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"), this.this$0, this.$remoteMediatorAccessor$inlined);
        r0.L$0 = r6;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        j r15 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        Object r2 = this.L$1;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        PageFetcher.GenerationInfo r3 = (PageFetcher.GenerationInfo) ZeusTransformUtils.preCheckCast(r2, PageFetcher.GenerationInfo.class, "com.obric.memorydata.plugin");
        i r7 = k.f(PageFetcher.access$injectRemoteEvents(this.this$0, r3.getSnapshot(), r3.getJob(), this.$remoteMediatorAccessor$inlined), (Function2) ZeusTransformUtils.preCheckCast(new PageFetcher$flow$1$3$downstreamFlow$1(null), Function2.class, "com.obric.memorydata.plugin"));
        PageFetcher r6 = this.this$0;
        PagingData r5 = new PagingData(r7, (UiReceiver) ZeusTransformUtils.preCheckCast(new PageFetcher.PagerUiReceiver(r6, PageFetcher.access$getRetryEvents$p(r6)), UiReceiver.class, "com.obric.memorydata.plugin"), (HintReceiver) ZeusTransformUtils.preCheckCast(new PageFetcher.PagerHintReceiver(this.this$0, r3.getSnapshot()), HintReceiver.class, "com.obric.memorydata.plugin"), null, 8, null);
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r15.emit(r5, r8) != r0) goto L12;
        return r0;
    }
}
