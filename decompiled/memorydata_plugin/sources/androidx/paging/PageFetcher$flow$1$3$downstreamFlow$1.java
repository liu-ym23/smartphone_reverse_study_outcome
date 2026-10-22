package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$3$downstreamFlow$1", f = "PageFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PageFetcher$flow$1$3$downstreamFlow$1<Value> extends SuspendLambda implements Function2<PageEvent<Value>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    PageFetcher$flow$1$3$downstreamFlow$1(Continuation<? super PageFetcher$flow$1$3$downstreamFlow$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        PageFetcher$flow$1$3$downstreamFlow$1 r4 = new PageFetcher$flow$1$3$downstreamFlow$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    public final Object invoke(PageEvent<Value> r3, Continuation<? super Unit> r4) {
        return ((PageFetcher$flow$1$3$downstreamFlow$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PageFetcher$flow$1$3$downstreamFlow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((PageEvent) ZeusTransformUtils.preCheckCast(r3, PageEvent.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r6);
        PageEvent r5 = (PageEvent) ZeusTransformUtils.preCheckCast(this.L$0, PageEvent.class, "com.obric.memorydata.plugin");
        Logger r1 = LoggerKt.getLOGGER();
        boolean r2 = true;
        if (r1 != null) goto L7;
    L9:
        r2 = false;
    L10:
        if (r2 == false) goto L13;
        r1.log(2, "Sent " + r5, null);
    L13:
        return Unit.INSTANCE;
    L7:
        if (r1.isLoggable(2) != true) goto L9;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
