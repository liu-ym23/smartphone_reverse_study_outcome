package com.larus.uaigc.spring.utils;

import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.spring.utils.SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2", f = "SpringMainVenueAIVideoExt.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<com.larus.uaigc.api.a> $aiReplicaInfo;
    int label;

    public SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2(Ref.ObjectRef<com.larus.uaigc.api.a> r1, Continuation<? super SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2> r2) {
        this.$aiReplicaInfo = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2(this.$aiReplicaInfo, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        Ref.ObjectRef<com.larus.uaigc.api.a> r5 = this.$aiReplicaInfo;
        DigitalAvatarInfoManager.a.getClass();
        r5.element = DigitalAvatarInfoManager.i;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DigitalAvatarInfoManager r6 = DigitalAvatarInfoManager.a;
        this.label = 1;
        if (DigitalAvatarInfoManager.d(r6, this) != r0) goto L11;
        return r0;
    }
}
