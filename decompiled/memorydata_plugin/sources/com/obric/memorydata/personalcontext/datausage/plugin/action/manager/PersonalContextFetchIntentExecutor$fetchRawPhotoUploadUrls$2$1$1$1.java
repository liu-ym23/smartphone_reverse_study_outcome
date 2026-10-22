package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.hb;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.datausage.plugin.action.manager.PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1$1$1", f = "PersonalContextFetchIntentExecutor.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
    final /* synthetic */ AppEntity $entity;
    final /* synthetic */ Map<String, hb> $rawPhotoByEntityId;
    int label;

    PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1$1$1(Map<String, hb> r3, AppEntity r4, Continuation<? super PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1$1$1> r5) {
        Map<String, hb> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$rawPhotoByEntityId = r6;
        this.$entity = r4;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1$1$1(this.$rawPhotoByEntityId, this.$entity, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super String> r4) {
        return ((PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        h r8 = h.f12090a;
        Map<String, hb> r2 = this.$rawPhotoByEntityId;
        AppEntity r3 = this.$entity;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r7 = h.a(r8, r2, r3, r4);
        if (r7 != r0) goto L11;
        return r0;
    }
}
