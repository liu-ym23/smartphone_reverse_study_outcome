package com.larus.uaigc.music.template;

import com.larus.bmhome.music.protocol.ListMusicGenTemplateApi;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/music/protocol/ListMusicGenTemplateData;", "Lcom/larus/bmhome/music/protocol/ListMusicGenTemplateApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateModel$preFetch$result$1", f = "MusicTemplateRepository.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class MusicTemplateModel$preFetch$result$1 extends SuspendLambda implements Function2<ListMusicGenTemplateApi, Continuation<? super BizResponse<com.larus.bmhome.music.protocol.c>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MusicTemplateModel this$0;

    public MusicTemplateModel$preFetch$result$1(MusicTemplateModel r1, Continuation<? super MusicTemplateModel$preFetch$result$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MusicTemplateModel$preFetch$result$1 r0 = new MusicTemplateModel$preFetch$result$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ListMusicGenTemplateApi r1, Continuation<? super BizResponse<com.larus.bmhome.music.protocol.c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ListMusicGenTemplateApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ListMusicGenTemplateApi r11 = (ListMusicGenTemplateApi) this.L$0;
        com.larus.bmhome.music.protocol.d r2 = new com.larus.bmhome.music.protocol.d(this.this$0.a, 0, 20, true);
        this.label = 1;
        r10 = r11.listMusicGenTemplate(r2, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
