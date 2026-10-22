package com.larus.bmhome.chat.api;

import android.text.TextUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.resp.NotificationList;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/chat/resp/NotificationList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.NotificationApi$requireAggNotificationList$2", f = "NotificationApi.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
final class NotificationApi$requireAggNotificationList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends NotificationList>>, Object> {
    final /* synthetic */ long $aggNoticeId;
    final /* synthetic */ long $botId;
    final /* synthetic */ int $count;
    final /* synthetic */ long $maxCursor;
    final /* synthetic */ long $minCursor;
    final /* synthetic */ boolean $needReadTime;
    final /* synthetic */ long $noticeGroup;
    final /* synthetic */ String $type;
    int label;

    public NotificationApi$requireAggNotificationList$2(long r1, long r3, int r5, String r6, boolean r7, long r8, long r10, long r12, Continuation<? super NotificationApi$requireAggNotificationList$2> r14) {
        this.$minCursor = r1;
        this.$maxCursor = r3;
        this.$count = r5;
        this.$type = r6;
        this.$needReadTime = r7;
        this.$aggNoticeId = r8;
        this.$noticeGroup = r10;
        this.$botId = r12;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r18, Continuation<?> r19) {
        return new NotificationApi$requireAggNotificationList$2(this.$minCursor, this.$maxCursor, this.$count, this.$type, this.$needReadTime, this.$aggNoticeId, this.$noticeGroup, this.$botId, r19);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<NotificationList>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r1 = r20;
    L15:
        return (a) r1;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        FLogger.a.i("NotificationApi", "requireNotificationList: minCursor = " + this.$minCursor + ", maxCursor = " + this.$maxCursor + ", count = " + this.$count + ", type = " + this.$type);
        JSONObject r4 = new JSONObject();
        long r5 = this.$minCursor;
        long r7 = this.$maxCursor;
        int r9 = this.$count;
        boolean r10 = this.$needReadTime;
        long r14 = this.$aggNoticeId;
        long r2 = this.$noticeGroup;
        long r3 = this.$botId;
        String r6 = this.$type;
        r4.put("min_cursor", r5);
        r4.put("max_cursor", r7);
        r4.put("count", r9);
        r4.put("need_read_time", r10);
        r4.put("notice_id", r14);
        r4.put("notice_group", r2);
        r4.put("bot_id", r3);
        if (TextUtils.isEmpty(r6) == true) goto L11;
        r4.put("notice_type", StringsKt.toIntOrNull(r6));
    L11:
        Unit r8 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Basic", NotificationList.class, "/alice/notice/agg_list", r4, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L15;
        return r13;
    }
}
