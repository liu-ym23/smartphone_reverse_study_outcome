package com.obric.aikernel.res.update;

import android.util.EventsUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "attempt", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequest$requestOutcome$2$1", f = "MetadataRequest.kt", i = {}, l = {EventsUtils.FEAT_TYPE_ACTIVITY_PAUSED_TIMEOUT}, m = "invokeSuspend", n = {}, s = {})
final class MetadataRequest$requestOutcome$2$1 extends SuspendLambda implements Function2<Integer, Continuation<? super List<? extends com.obric.aikernel.res.metadata.config.k>>, Object> {
    final /* synthetic */ com.obric.aikernel.res.legacy.a $adapter;
    final /* synthetic */ Map<String, d.b> $bizMap;
    final /* synthetic */ d $this_runCatching;
    final /* synthetic */ boolean $updateAll;
    /* synthetic */ int I$0;
    int label;

    MetadataRequest$requestOutcome$2$1(boolean r3, Map<String, ? extends d.b> r4, d r5, com.obric.aikernel.res.legacy.a r6, Continuation<? super MetadataRequest$requestOutcome$2$1> r7) {
        Map<String, d.b> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$updateAll = r3;
        this.$bizMap = r8;
        this.$this_runCatching = r5;
        this.$adapter = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        MetadataRequest$requestOutcome$2$1 r11 = new MetadataRequest$requestOutcome$2$1(this.$updateAll, this.$bizMap, this.$this_runCatching, this.$adapter, r7);
        r11.I$0 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    public final Object invoke(int r3, Continuation<? super List<? extends com.obric.aikernel.res.metadata.config.k>> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((MetadataRequest$requestOutcome$2$1) ZeusTransformUtils.preCheckCast(create(Integer.valueOf(r3), r5), MetadataRequest$requestOutcome$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Integer r3, Continuation<? super List<? extends com.obric.aikernel.res.metadata.config.k>> r4) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        com.obric.aikernel.runtime.utils.d.f6216a.b("MetadataRequest", "request attempt=" + this.I$0 + " updateAll=" + this.$updateAll + " bizCount=" + this.$bizMap.size());
        d r9 = this.$this_runCatching;
        boolean r2 = this.$updateAll;
        Map<String, d.b> r3 = this.$bizMap;
        com.obric.aikernel.res.legacy.a r4 = this.$adapter;
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r8 = d.a(r9, r2, r3, r4, r5);
        if (r8 != r0) goto L11;
        return r0;
    }
}
