package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.common.intent.PCGlobalSearchIntentParams;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantIntentSearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.datausage.plugin.action.manager.GlobalSearchForAppIntentIntent$doAction$response$1", f = "GlobalSearchForAppIntentIntent.kt", i = {0}, l = {53}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
final class GlobalSearchForAppIntentIntent$doAction$response$1 extends SuspendLambda implements Function2<al, Continuation<? super GlobalAssistantIntentSearchResponse>, Object> {
    final /* synthetic */ String $logId;
    final /* synthetic */ PCGlobalSearchIntentParams $params;
    final /* synthetic */ String $quResult;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.datausage.plugin.action.manager.GlobalSearchForAppIntentIntent$doAction$response$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.datausage.plugin.action.manager.GlobalSearchForAppIntentIntent$doAction$response$1$1", f = "GlobalSearchForAppIntentIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super GlobalAssistantIntentSearchResponse>, Object> {
        final /* synthetic */ String $logId;
        final /* synthetic */ PCGlobalSearchIntentParams $params;
        final /* synthetic */ String $quResult;
        int label;

        AnonymousClass1(String r3, String r4, PCGlobalSearchIntentParams r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$quResult = r3;
            this.$logId = r4;
            this.$params = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$quResult, this.$logId, this.$params, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super GlobalAssistantIntentSearchResponse> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super GlobalAssistantIntentSearchResponse> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            com.obric.memorydata.personalcontext.search.global.f r4 = com.obric.memorydata.personalcontext.search.global.f.f12331a;
            String r0 = this.$quResult;
            String r1 = this.$logId;
            String r2 = this.$params.getMeta();
            if (r2 != null) goto L8;
            r2 = "";
        L8:
            return r4.a(r0, r1, r2);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    GlobalSearchForAppIntentIntent$doAction$response$1(String r3, String r4, PCGlobalSearchIntentParams r5, Continuation<? super GlobalSearchForAppIntentIntent$doAction$response$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$quResult = r3;
        this.$logId = r4;
        this.$params = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        GlobalSearchForAppIntentIntent$doAction$response$1 r0 = new GlobalSearchForAppIntentIntent$doAction$response$1(this.$quResult, this.$logId, this.$params, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super GlobalAssistantIntentSearchResponse> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super GlobalAssistantIntentSearchResponse> r4) {
        return ((GlobalSearchForAppIntentIntent$doAction$response$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), GlobalSearchForAppIntentIntent$doAction$response$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L11:
        GlobalAssistantIntentSearchResponse r12 = (GlobalAssistantIntentSearchResponse) ZeusTransformUtils.preCheckCast(r11, GlobalAssistantIntentSearchResponse.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L14;
        return r12;
    L14:
        return new GlobalAssistantIntentSearchResponse(1007, LocationMonitorConst.TIMEOUT, null, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        al r13 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$quResult, this.$logId, this.$params, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r13;
        this.label = 1;
        r11 = da.b(180000, r2, r7);
        if (r11 != r0) goto L11;
        return r0;
    }
}
