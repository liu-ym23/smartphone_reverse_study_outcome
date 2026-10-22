package com.larus.bmhome.chat.manager.settings;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionCompose$appendAllowMessagePushToggle$1$2$1$1", f = "SettingOptionCompose.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
final class SettingOptionCompose$appendAllowMessagePushToggle$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Boolean $it;
    final /* synthetic */ SettingOptionViewModel $this_run;
    final /* synthetic */ ItemTextToggle $toggle;
    Object L$0;
    int label;
    final /* synthetic */ o this$0;

    public SettingOptionCompose$appendAllowMessagePushToggle$1$2$1$1(Boolean r1, o r2, SettingOptionViewModel r3, ItemTextToggle r4, Continuation<? super SettingOptionCompose$appendAllowMessagePushToggle$1$2$1$1> r5) {
        this.$it = r1;
        this.this$0 = r2;
        this.$this_run = r3;
        this.$toggle = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SettingOptionCompose$appendAllowMessagePushToggle$1$2$1$1(this.$it, this.this$0, this.$this_run, this.$toggle, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o r2 = (o) this.L$0;
        ResultKt.throwOnFailure(r5);
    L20:
        BotModel r6 = (BotModel) r5;
        if (r6 == null) goto L23;
        r2.d = r6;
        o r7 = this.this$0;
        BotModel r3 = r7.d;
        if (r3 == null) goto L35;
        Function1<? super BotModel, Unit> r8 = r7.f;
        if (r8 == null) goto L35;
        r8.invoke(r3);
    L35:
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.$it.booleanValue() == false) goto L29;
        o r9 = this.this$0;
        SettingOptionViewModel r4 = this.$this_run;
        BotModel r10 = r9.d;
        if (r10 == null) goto L13;
        String r11 = r10.getBotId();
    L14:
        if (r11 != null) goto L16;
        r11 = "";
    L16:
        this.L$0 = r9;
        this.label = 1;
        Object r12 = r4.findBot(r11, this);
        if (r12 != r0) goto L19;
        return r0;
    L19:
        r2 = r9;
        r5 = r12;
        goto L20
    L13:
        r11 = null;
        goto L14
    L29:
        CustomSwitchCompat r13 = this.$toggle.getToggleView();
        BotModel r14 = this.this$0.d;
        if (r14 == null) goto L32;
        boolean r15 = Intrinsics.areEqual(r14.getMessagePush(), Boxing.boxBoolean(true));
    L33:
        r13.setChecked(r15);
        t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
        goto L35
    L32:
        r15 = false;
        goto L33
    }
}
