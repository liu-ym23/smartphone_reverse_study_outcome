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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "androidx/paging/FlowExtKt$simpleFlatMapLatest$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 0}, l = {232, 99}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock_u24default$iv$iv", "generationId"}, s = {"L$1", "L$2", "I$0"})
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 extends SuspendLambda implements Function3<j<? super GenerationalViewportHint>, Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadType $loadType$inlined;
    int I$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot this$0;

    public PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(Continuation r3, PageFetcherSnapshot r4, LoadType r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r4;
        this.$loadType$inlined = r5;
        super(3, r6);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(j<? super GenerationalViewportHint> r3, Integer r4, Continuation<? super Unit> r5) {
        return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(j<? super GenerationalViewportHint> r3, Integer r4, Continuation<? super Unit> r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 r0 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"), this.this$0, this.$loadType$inlined);
        r0.L$0 = r6;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r3 = 1;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        final int r2 = this.I$0;
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.L$2, a.class, "com.obric.memorydata.plugin");
        PageFetcherSnapshotState.Holder r7 = (PageFetcherSnapshotState.Holder) ZeusTransformUtils.preCheckCast(this.L$1, PageFetcherSnapshotState.Holder.class, "com.obric.memorydata.plugin");
        j r8 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L33:
        PageFetcherSnapshotState r14 = PageFetcherSnapshotState.Holder.access$getState$p(r7);     // Catch: Throwable -> L30
        if (Intrinsics.areEqual(r14.getSourceLoadStates$paging_common().get(this.$loadType$inlined), LoadState.NotLoading.Companion.getComplete$paging_common()) == false) goto L18;
        i r15 = k.a(new GenerationalViewportHint[0]);     // Catch: Throwable -> L30
        r6.b(null);
    L25:
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        if (k.a(r8, r15, r4) != r0) goto L29;
        return r0;
    L18:
        if (ZeusTransformUtils.instanceOf(r14.getSourceLoadStates$paging_common().get(this.$loadType$inlined), LoadState.Error.class) == true) goto L20;
        r14.getSourceLoadStates$paging_common().set(this.$loadType$inlined, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
    L20:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L30
        r6.b(null);
        i<ViewportHint> r17 = PageFetcherSnapshot.access$getHintHandler$p(this.this$0).hintFor(this.$loadType$inlined);
        if (r2 != 0) goto L24;
        r3 = 0;
    L24:
        final i r18 = k.a(r17, r3);
        r15 = (i) ZeusTransformUtils.preCheckCast(new PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1(r18, r2), i.class, "com.obric.memorydata.plugin");
    L30:
        th = move-exception;
        r6.b(null);
        throw th;
    L10:
        ResultKt.throwOnFailure(r13);
        r8 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        Object r19 = this.L$1;
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).intValue();
        r7 = PageFetcherSnapshot.access$getStateHolder$p(this.this$0);
        r6 = PageFetcherSnapshotState.Holder.access$getLock$p(r7);
        this.L$0 = r8;
        this.L$1 = r7;
        this.L$2 = r6;
        this.I$0 = r2;
        this.label = 1;
        if (r6.a(null, this) != r0) goto L33;
        return r0;
    }
}
