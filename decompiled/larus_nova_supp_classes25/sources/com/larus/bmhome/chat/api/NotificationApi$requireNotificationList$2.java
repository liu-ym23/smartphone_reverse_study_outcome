package com.larus.bmhome.chat.api;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.resp.NotificationList;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.a;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/chat/resp/NotificationList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.NotificationApi$requireNotificationList$2", f = "NotificationApi.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
final class NotificationApi$requireNotificationList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends NotificationList>>, Object> {
    final /* synthetic */ int $count;
    final /* synthetic */ boolean $isFirstLoad;
    final /* synthetic */ long $maxCursor;
    final /* synthetic */ long $minCursor;
    final /* synthetic */ boolean $needReadTime;
    final /* synthetic */ DowngradeSource $source;
    int label;

    public NotificationApi$requireNotificationList$2(long r1, long r3, int r5, boolean r6, boolean r7, DowngradeSource r8, Continuation<? super NotificationApi$requireNotificationList$2> r9) {
        this.$minCursor = r1;
        this.$maxCursor = r3;
        this.$count = r5;
        this.$needReadTime = r6;
        this.$isFirstLoad = r7;
        this.$source = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new NotificationApi$requireNotificationList$2(this.$minCursor, this.$maxCursor, this.$count, this.$needReadTime, this.$isFirstLoad, this.$source, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<NotificationList>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L31:
        return (a) r1;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        FLogger.a.i("NotificationApi", "requireNotificationList: minCursor = " + this.$minCursor + ", maxCursor = " + this.$maxCursor + ", count = " + this.$count);
        FlowDowngradeServiceDelegate r2 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r5 = new JSONObject();
        long r6 = this.$minCursor;
        long r8 = this.$maxCursor;
        int r10 = this.$count;
        boolean r13 = this.$needReadTime;
        boolean r14 = this.$isFirstLoad;
        r5.put("min_cursor", r6);
        r5.put("max_cursor", r8);
        r5.put("count", r10);
        r5.put("need_read_time", r13);
        r5.put("is_first_load", r14);
        Unit r7 = Unit.INSTANCE;
        LinkedHashMap r9 = new LinkedHashMap();
        DowngradeSource r11 = this.$source;
        z2 r15 = z2.a;
        FlowDowngradeToastConfig r16 = r15.getFlowDowngradeToastConfig();
        String r18 = null;
        if (r16 == null) goto L11;
        String r19 = r16.getTrafficDegradationLoadingFailureCn();
    L12:
        if (r19 != null) goto L14;
    L17:
        boolean r110 = true;
    L18:
        if (r110 == false) goto L20;
        String r111 = AppHost.a.getApplication().getString(2131910603);
    L24:
        Intrinsics.checkNotNull(r111);
        r9.put("toast_text", r111);
        if (r11 == null) goto L27;
        r9.put("source", r11.getValue());
    L27:
        this.label = 1;
        r1 = IFlowDowngradeService.a.b(r2, "Basic", NotificationList.class, "/alice/notice/list", r5, null, false, null, r9, this, 1008);
        if (r1 != r12) goto L31;
        return r12;
    L20:
        FlowDowngradeToastConfig r112 = r15.getFlowDowngradeToastConfig();
        if (r112 == null) goto L23;
        r18 = r112.getTrafficDegradationLoadingFailureCn();
    L23:
        r111 = String.valueOf(r18);
        goto L24
    L14:
        if (r19.length() == 0) goto L17;
        r110 = false;
        goto L18
    L11:
        r19 = null;
        goto L12
    }
}
