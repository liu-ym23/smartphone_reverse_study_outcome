package com.larus.bmhome.bot;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.UserConfigItem;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$bindStartupOpenNewChatToggle$1$1$1", f = "CommonSettingFragment.kt", i = {}, l = {2300}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$bindStartupOpenNewChatToggle$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $confirmedChecked;
    final /* synthetic */ UserConfigItem $confirmedSetting;
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ ItemTextToggle $settingItem;
    final /* synthetic */ ItemTextToggle $this_apply;
    final /* synthetic */ Lifecycle $viewLifecycle;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$bindStartupOpenNewChatToggle$1$1$1(boolean r1, UserConfigItem r2, CommonSettingFragment r3, ItemTextToggle r4, ItemTextToggle r5, boolean r6, Lifecycle r7, Continuation<? super CommonSettingFragment$bindStartupOpenNewChatToggle$1$1$1> r8) {
        this.$isChecked = r1;
        this.$confirmedSetting = r2;
        this.this$0 = r3;
        this.$settingItem = r4;
        this.$this_apply = r5;
        this.$confirmedChecked = r6;
        this.$viewLifecycle = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CommonSettingFragment$bindStartupOpenNewChatToggle$1$1$1(this.$isChecked, this.$confirmedSetting, this.this$0, this.$settingItem, this.$this_apply, this.$confirmedChecked, this.$viewLifecycle, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        UserConfigItem r3 = null;
        Object r4 = null;
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L14;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
    L28:
        List r10 = (List) r9;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
    L32:
        if (r10 == null) goto L46;
        Iterator r2 = r10.iterator();     // Catch: Throwable -> L7
    L35:
        if (r2.hasNext() == false) goto L45;
        Object r5 = r2.next();     // Catch: Throwable -> L7
        Integer r6 = ((UserConfigItem) r5).b();     // Catch: Throwable -> L7
        int r7 = UserConfigKey.STARTUP_OPEN_NEW_CHAT.getValue();     // Catch: Throwable -> L7
        if (r6 != null) goto L40;
    L42:
        boolean r8 = false;
    L43:
        if (r8 == false) goto L35;
        r4 = r5;
        goto L45
    L40:
        if (r6.intValue() != r7) goto L42;
        r8 = true;
    L45:
        r3 = (UserConfigItem) r4;     // Catch: Throwable -> L7
    L46:
        if (r3 != null) goto L52;
        this.$settingItem.setRestoring(true);     // Catch: Throwable -> L7
        this.$this_apply.getToggleView().setChecked(this.$confirmedChecked);     // Catch: Throwable -> L7
        this.$settingItem.setRestoring(false);     // Catch: Throwable -> L7
        t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);     // Catch: Throwable -> L7
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (this.$viewLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L51;
        this.$settingItem.setEnabled(true);
    L51:
        return r11;
    L52:
        UserSettingDelegate.b.c(r10);     // Catch: Throwable -> L7
        this.$settingItem.setRestoring(true);     // Catch: Throwable -> L7
        this.$this_apply.getToggleView().setChecked(Intrinsics.areEqual(r3.c(), "1"));     // Catch: Throwable -> L7
        this.$settingItem.setRestoring(false);     // Catch: Throwable -> L7
        com.larus.platform.service.o r12 = com.larus.platform.service.o.a;     // Catch: Throwable -> L7
        Pair[] r13 = new Pair[1];     // Catch: Throwable -> L7
        if (Intrinsics.areEqual(r3.c(), "1") == false) goto L55;
        String r14 = "on";
    L56:
        r13[0] = TuplesKt.to("to_status", r14);     // Catch: Throwable -> L7
        r12.b("click_launch_new_chat_switch", com.larus.utils.f.c(r13));     // Catch: Throwable -> L7
        if (this.$viewLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L61;
        this.$settingItem.setEnabled(true);
    L61:
        return Unit.INSTANCE;
    L55:
        r14 = "off";
        goto L56
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        Integer r15 = Boxing.boxInt(UserConfigKey.STARTUP_OPEN_NEW_CHAT.getValue());     // Catch: Throwable -> L7
        if (this.$isChecked == false) goto L19;
        String r16 = "1";
    L20:
        Long r17 = this.$confirmedSetting.d();     // Catch: Throwable -> L7
        if (r17 == null) goto L23;
        long r18 = r17.longValue();     // Catch: Throwable -> L7
    L24:
        UserConfigItem r19 = new UserConfigItem(r15, r16, Boxing.boxLong(r18));     // Catch: Throwable -> L7
        UserSettingDelegate r20 = UserSettingDelegate.b;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        List r21 = CollectionsKt.listOf(r19);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        this.label = 1;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        r9 = r20.a(r21, this);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        if (r9 != r0) goto L28;
        return r0;
    L23:
        r18 = 1;
        goto L24
    L19:
        r16 = "0";
    L7:
        th = move-exception;
        if (this.$viewLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L66;
        this.$settingItem.setEnabled(true);
    L66:
        throw th;
    L11:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L9:
        e = move-exception;
        FLogger.a.w(this.this$0.e, "sync startup open new chat setting failed", e);     // Catch: Throwable -> L7
        r10 = null;
        goto L32
    }
}
