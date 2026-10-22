package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/chat/resp/Notice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.NotificationApi$deleteNotification$2", f = "NotificationApi.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationApi$deleteNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends Notice>>, Object> {
    final /* synthetic */ List<Long> $noticeIdList;
    int label;

    public NotificationApi$deleteNotification$2(List<Long> r1, Continuation<? super NotificationApi$deleteNotification$2> r2) {
        this.$noticeIdList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new NotificationApi$deleteNotification$2(this.$noticeIdList, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<Notice>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
        Object r1 = r14;
    L12:
        return (a) r1;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        FLogger.a.i("NotificationApi", "deleteNotification:  noticeIdList = " + this.$noticeIdList);
        JSONObject r4 = new JSONObject();
        r4.put("notice_id_list", new JSONArray(this.$noticeIdList));
        Unit r5 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Basic", Notice.class, "/alice/notice/delete", r4, null, null, false, null, null, null, this, 1008);
        if (r1 != r12) goto L12;
        return r12;
    }
}
