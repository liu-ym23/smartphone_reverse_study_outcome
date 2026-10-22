package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.bean.GetAudioFileDetailData;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentUtil", f = "AttachmentUtil.kt", i = {}, l = {MessageCellStateTransformerType.EXPERT_CARD}, m = "getAudioDetailUrl", n = {}, s = {})
final class AttachmentUtil$getAudioDetailUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AttachmentUtil this$0;

    public AttachmentUtil$getAudioDetailUrl$1(AttachmentUtil r1, Continuation<? super AttachmentUtil$getAudioDetailUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r15) {
        this.result = r15;
        this.label |= Integer.MIN_VALUE;
        AttachmentUtil r16 = this.this$0;
        r16.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        AttachmentUtil$getAudioDetailUrl$1 r11 = this;
    L6:
        Object r17 = r11.result;
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r11.label;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L11;
        ResultKt.throwOnFailure(r17);
    L15:
        com.larus.network.http.y r18 = (com.larus.network.http.a) r17;
        if ((r18 instanceof com.larus.network.http.y) == false) goto L20;
        GetAudioFileDetailData r19 = (GetAudioFileDetailData) ((com.larus.network.http.a) r18).b;
        if (r19 == null) goto L22;
        return r19.a();
    L22:
        return null;
    L20:
        boolean r110 = r18 instanceof com.larus.network.http.f;
        goto L22
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r17);
        JSONObject r4 = new JSONObject();
        r4.put("bot_id", null);
        r4.put("user_id", null);
        r4.put("uris", new JSONArray(null));
        Unit r5 = Unit.INSTANCE;
        r11.label = 1;
        r17 = HttpExtKt.k("AISDK", GetAudioFileDetailData.class, "/alice/resource/get_audio_file_detail", r4, null, null, false, null, null, null, r11, 1008);
        if (r17 != r0) goto L15;
        return r0;
    L5:
        r11 = new AttachmentUtil$getAudioDetailUrl$1(r16, this);
        goto L6
    }
}
