package com.larus.uaigc.music.template;

import com.larus.bmhome.music.protocol.UpdateMusicGenTemplateCountApi;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateRepository$countMusicTemplateUse$1", f = "MusicTemplateRepository.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
public final class MusicTemplateRepository$countMusicTemplateUse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $templateId;
    int label;

    public MusicTemplateRepository$countMusicTemplateUse$1(long r1, Continuation<? super MusicTemplateRepository$countMusicTemplateUse$1> r3) {
        this.$templateId = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MusicTemplateRepository$countMusicTemplateUse$1(this.$templateId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        dm9.a.b r14 = (dm9.a) r13;
        if ((r14 instanceof dm9.a.b) == false) goto L18;
        dm9.a.b r15 = r14;
        if (r15.a.isSuccess() == false) goto L16;
        FLogger.a.i("MusicTemplateRepository", "success in count music template ");
    L21:
        return Unit.INSTANCE;
    L16:
        FLogger.a.e("MusicTemplateRepository", "failed in count music template code " + r15.a.getCode() + " message " + r15.a.getMsg());
        goto L21
    L18:
        if ((r14 instanceof dm9.a.a) == false) goto L21;
        FLogger.a.e("MusicTemplateRepository", "failed in count music template list remote " + ((dm9.a.a) r14).c);
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        UpdateMusicGenTemplateCountApi.a r16 = UpdateMusicGenTemplateCountApi.a;
        MusicTemplateRepository$countMusicTemplateUse$1$result$1 r5 = new MusicTemplateRepository$countMusicTemplateUse$1$result$1(this.$templateId, null);
        this.label = 1;
        r16.getClass();
        FlowHttpConnection r17 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("Social", UpdateMusicGenTemplateCountApi.class, r5, false, null, null, null, this, 248);
        if (r13 != r0) goto L11;
        return r0;
    }
}
