package com.larus.uaigc.music.template;

import com.larus.bmhome.music.protocol.UpdateMusicGenTemplateCountApi;
import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/bmhome/music/protocol/UpdateMusicGenTemplateCountApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateRepository$countMusicTemplateUse$1$result$1", f = "MusicTemplateRepository.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
public final class MusicTemplateRepository$countMusicTemplateUse$1$result$1 extends SuspendLambda implements Function2<UpdateMusicGenTemplateCountApi, Continuation<? super BizResponse<Unit>>, Object> {
    final /* synthetic */ long $templateId;
    private /* synthetic */ Object L$0;
    int label;

    public MusicTemplateRepository$countMusicTemplateUse$1$result$1(long r1, Continuation<? super MusicTemplateRepository$countMusicTemplateUse$1$result$1> r3) {
        this.$templateId = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MusicTemplateRepository$countMusicTemplateUse$1$result$1 r0 = new MusicTemplateRepository$countMusicTemplateUse$1$result$1(this.$templateId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(UpdateMusicGenTemplateCountApi r1, Continuation<? super BizResponse<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((UpdateMusicGenTemplateCountApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        UpdateMusicGenTemplateCountApi r7 = (UpdateMusicGenTemplateCountApi) this.L$0;
        com.larus.bmhome.music.protocol.q r2 = new com.larus.bmhome.music.protocol.q(String.valueOf(this.$templateId));
        this.label = 1;
        r6 = r7.updateMusicGenTemplateCount(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
