package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.NotificationApi$updateReadNotification$2", f = "NotificationApi.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationApi$updateReadNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Long $lastReadTime;
    final /* synthetic */ Integer $markCount;
    final /* synthetic */ int $noticeGroup;
    final /* synthetic */ Long $noticeId;
    int label;

    public NotificationApi$updateReadNotification$2(int r1, Long r2, Long r3, Integer r4, Continuation<? super NotificationApi$updateReadNotification$2> r5) {
        this.$noticeGroup = r1;
        this.$noticeId = r2;
        this.$lastReadTime = r3;
        this.$markCount = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new NotificationApi$updateReadNotification$2(this.$noticeGroup, this.$noticeId, this.$lastReadTime, this.$markCount, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
        Object r1 = r14;
    L19:
        return ((a) r1).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        FLogger.a.i("NotificationApi", "updateReadNotification: noticeGroup = " + this.$noticeGroup + ", noticeId = " + this.$noticeId);
        JSONObject r4 = new JSONObject();
        int r5 = this.$noticeGroup;
        Long r6 = this.$noticeId;
        Long r7 = this.$lastReadTime;
        Integer r8 = this.$markCount;
        r4.put("group", r5);
        if (r6 == null) goto L11;
        r4.put("notice_id", r6.longValue());
    L11:
        if (r7 == null) goto L13;
        r4.put("last_read_time", r7.longValue());
    L13:
        if (r8 == null) goto L15;
        r4.put("mark_count", r8.intValue());
    L15:
        Unit r9 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Basic", String.class, "/alice/notice/mark_read", r4, null, null, false, null, null, null, this, 1008);
        if (r1 != r12) goto L19;
        return r12;
    }
}
