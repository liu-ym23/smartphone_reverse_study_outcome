package com.larus.bmhome.bot;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupRenewSection$1$1$2$1$1", f = "CommonSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$setupRenewSection$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Boolean $it;
    final /* synthetic */ ItemTextToggle $this_apply;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$setupRenewSection$1$1$2$1$1(Boolean r1, ItemTextToggle r2, CommonSettingFragment r3, Continuation<? super CommonSettingFragment$setupRenewSection$1$1$2$1$1> r4) {
        this.$it = r1;
        this.$this_apply = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommonSettingFragment$setupRenewSection$1$1$2$1$1(this.$it, this.$this_apply, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L43;
        ResultKt.throwOnFailure(r8);
        boolean r0 = false;
        BotModel r1 = null;
        if (this.$it.booleanValue() == true) goto L11;
        CustomSwitchCompat r9 = this.$this_apply.getToggleView();
        BotModel r2 = this.this$0.s;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L10:
        r9.setChecked(Intrinsics.areEqual(r1.getMessagePush(), Boxing.boxBoolean(true)));
        t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
    L41:
        return Unit.INSTANCE;
    L9:
        r1 = r2;
        goto L10
    L11:
        CommonSettingFragment r10 = this.this$0;
        boolean r3 = this.$this_apply.getToggleView().isChecked();
        BigDecimal r4 = CommonSettingFragment.k1;
        r10.getClass();
        JSONObject r5 = new JSONObject();
        if (r3 == false) goto L14;
        long r6 = 1;
    L15:
        r5.put("button_result", r6);
        ChatControlTrace r7 = ChatControlTrace.b;
        Integer r11 = Integer.valueOf(r10.m);
        BotModel r12 = r10.s;
        if (r12 == null) goto L18;
        Integer r13 = r12.getBotType();
    L19:
        BotModel r14 = r10.s;
        if (r14 == null) goto L26;
        BotCreatorInfo r15 = r14.getBotCreatorInfo();
        if (r15 == null) goto L24;
        String r16 = r15.getId();
    L25:
        r0 = Intrinsics.areEqual(r16, AccountService.a.getUserId());
        goto L26
    L24:
        r16 = null;
    L26:
        r5.put("chat_type", r7.g(r11, r13, r0));
        RecommendFrom r17 = r10.Na0();
        if (r17 == null) goto L29;
        r1 = r17.b;
    L29:
        r5.put("req_id", r1);
        BotModel r18 = r10.s;
        if (r18 != null) goto L32;
        String r19 = "";
    L33:
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r19 != null) goto L44;
    L39:
        TrackParams r20 = new TrackParams().merge(r5);
        by7.a r21 = new by7.a("botsetting_notifypush_button");
        r21.b = r10;
        r21.a.merge(r20);
        r21.b();
        goto L41
    L44:
        r5.put("bot_id", r19);     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        FLogger.a.e("BotsettingEventHelper", "error in BotsettingEventHelper botsettingNotifypushButton " + e.getLocalizedMessage());
        goto L39
    L32:
        r19 = r18.getBotId();
        goto L33
    L18:
        r13 = null;
        goto L19
    L14:
        r6 = 0;
        goto L15
    L43:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
