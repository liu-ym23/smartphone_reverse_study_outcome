package com.larus.bmhome.music.edit;

import com.larus.bmhome.music.protocol.UpdateBigMusicMessageApi;
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
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicNameEditSheetDialogFragment$editName$2$result$1", f = "MusicNameEditSheetDialogFragment.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
public final class MusicNameEditSheetDialogFragment$editName$2$result$1 extends SuspendLambda implements Function2<UpdateBigMusicMessageApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ String $name;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MusicNameEditSheetDialogFragment this$0;

    public MusicNameEditSheetDialogFragment$editName$2$result$1(MusicNameEditSheetDialogFragment r1, String r2, Continuation<? super MusicNameEditSheetDialogFragment$editName$2$result$1> r3) {
        this.this$0 = r1;
        this.$name = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MusicNameEditSheetDialogFragment$editName$2$result$1 r0 = new MusicNameEditSheetDialogFragment$editName$2$result$1(this.this$0, this.$name, r5);
        r0.L$0 = r4;
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
        MusicNameEditSheetDialogFragment r3 = this.this$0;
        UpdateBigMusicMessageApi.b r2 = new UpdateBigMusicMessageApi.b(r3.e, this.$name, null, r3.d.getPlayList().getItemId(), 4);
        this.label = 1;
        r10 = r11.updateBigMusicMessage(r2, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
