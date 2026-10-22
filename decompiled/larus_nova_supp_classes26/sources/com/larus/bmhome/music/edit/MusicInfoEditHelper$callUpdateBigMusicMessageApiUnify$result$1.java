package com.larus.bmhome.music.edit;

import com.larus.bmhome.music.protocol.UpdateBigMusicMessageApi;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/bmhome/music/protocol/UpdateBigMusicMessageApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1", f = "MusicInfoEditHelper.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
final class MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1 extends SuspendLambda implements Function2<UpdateBigMusicMessageApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ Image $image;
    final /* synthetic */ String $messageId;
    final /* synthetic */ MusicCreationContent $musicContent;
    private /* synthetic */ Object L$0;
    int label;

    public MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1(String r1, Image r2, MusicCreationContent r3, Continuation<? super MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1> r4) {
        this.$messageId = r1;
        this.$image = r2;
        this.$musicContent = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1 r0 = new MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1(this.$messageId, this.$image, this.$musicContent, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(UpdateBigMusicMessageApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((UpdateBigMusicMessageApi) r1, (Continuation) r2);
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
        UpdateBigMusicMessageApi r11 = (UpdateBigMusicMessageApi) this.L$0;
        UpdateBigMusicMessageApi.b r2 = new UpdateBigMusicMessageApi.b(this.$messageId, null, this.$image.key, this.$musicContent.getPlayList().getItemId(), 2);
        this.label = 1;
        r10 = r11.updateBigMusicMessage(r2, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
