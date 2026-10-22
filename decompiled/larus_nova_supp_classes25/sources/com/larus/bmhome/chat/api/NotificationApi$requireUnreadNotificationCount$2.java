package com.larus.bmhome.chat.api;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.resp.UnreadNotificationCount;
import com.larus.network.http.a;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/resp/UnreadNotificationCount;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.NotificationApi$requireUnreadNotificationCount$2", f = "NotificationApi.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationApi$requireUnreadNotificationCount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UnreadNotificationCount>, Object> {
    final /* synthetic */ List<Integer> $notificationGroups;
    final /* synthetic */ String $source;
    int label;

    public NotificationApi$requireUnreadNotificationCount$2(List<Integer> r1, String r2, Continuation<? super NotificationApi$requireUnreadNotificationCount$2> r3) {
        this.$notificationGroups = r1;
        this.$source = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NotificationApi$requireUnreadNotificationCount$2(this.$notificationGroups, this.$source, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UnreadNotificationCount> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
        Object r1 = r14;
    L16:
        return ((a) r1).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        FLogger.a.i("NotificationApi", "requireUnreadNotificationCount: " + this.$notificationGroups);
        JSONArray r2 = new JSONArray();
        Iterator<T> r3 = this.$notificationGroups.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r2.put(((Number) r3.next()).intValue());
        goto L10
    L12:
        FlowDowngradeServiceDelegate r4 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r6 = new JSONObject();
        r6.put("groups", r2);
        Unit r5 = Unit.INSTANCE;
        Map r10 = MapsKt.mapOf(TuplesKt.to("source", this.$source));
        this.label = 1;
        r1 = IFlowDowngradeService.a.b(r4, "Basic", UnreadNotificationCount.class, "/alice/notice/get_unread_count", r6, null, false, null, r10, this, 1008);
        if (r1 != r11) goto L16;
        return r11;
    }
}
