package com.larus.bmhome.chat.list.cell.search;

import com.larus.bmhome.chat.bean.FpaCommonParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.z3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.search.SearchListCell$firstShowVideoItem$1", f = "SearchListCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchListCell$firstShowVideoItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Message $chatMessage;
    final /* synthetic */ VideoInfo $itemData;
    final /* synthetic */ int $position;
    int label;

    public SearchListCell$firstShowVideoItem$1(Message r1, int r2, String r3, VideoInfo r4, Continuation<? super SearchListCell$firstShowVideoItem$1> r5) {
        this.$chatMessage = r1;
        this.$position = r2;
        this.$botId = r3;
        this.$itemData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SearchListCell$firstShowVideoItem$1(this.$chatMessage, this.$position, this.$botId, this.$itemData, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r9);
        JSONObject r5 = new JSONObject();
        VideoInfo r10 = this.$itemData;
        Message r0 = this.$chatMessage;
        r5.put("item_id", r10.getItemId());
        String r11 = com.larus.bmhome.chat.bean.d.x(r0).getVideoSource();
        String r1 = "";
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r5.put("show_source", r11);
        FpaCommonParam r12 = com.larus.bmhome.chat.bean.d.z(r0);
        if (r12 == null) goto L13;
        String r13 = r12.getAgentId();
        if (r13 == null) goto L13;
        r1 = r13;
    L13:
        r5.put("agent_id", r1);
        String r3 = this.$chatMessage.getMessageId();
        long r2 = ((long) this.$position) + 1;
        z3.a(this.$botId, "search_slide_card", r3, Boxing.boxLong(r2), r5, 32);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
