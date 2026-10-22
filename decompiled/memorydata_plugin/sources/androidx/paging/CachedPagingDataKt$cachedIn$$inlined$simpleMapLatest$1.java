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
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.j;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "androidx/paging/FlowExtKt$simpleMapLatest$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1", f = "CachedPagingData.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1<T> extends SuspendLambda implements Function3<j<? super MulticastedPagingData<T>>, PagingData<T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ al $scope$inlined;
    final /* synthetic */ ActiveFlowTracker $tracker$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(Continuation r3, al r4, ActiveFlowTracker r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        ActiveFlowTracker r8 = (ActiveFlowTracker) ZeusTransformUtils.wrapperContextForParams(r5, ActiveFlowTracker.class, "com.obric.memorydata.plugin");
        this.$scope$inlined = r7;
        this.$tracker$inlined = r8;
        super(3, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(Object r3, Object r4, Continuation<? super Unit> r5) {
        return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(j<? super MulticastedPagingData<T>> r3, PagingData<T> r4, Continuation<? super Unit> r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1 r0 = new CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"), this.$scope$inlined, this.$tracker$inlined);
        r0.L$0 = r6;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        j r9 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        Object r2 = this.L$1;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        PagingData r3 = (PagingData) ZeusTransformUtils.preCheckCast(r2, PagingData.class, "com.obric.memorydata.plugin");
        MulticastedPagingData r5 = new MulticastedPagingData(this.$scope$inlined, r3, this.$tracker$inlined);
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r9.emit(r5, r6) != r0) goto L12;
        return r0;
    }
}
