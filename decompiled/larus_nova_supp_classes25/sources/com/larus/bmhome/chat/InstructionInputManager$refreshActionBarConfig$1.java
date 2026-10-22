package com.larus.bmhome.chat;

import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.UserSettingRepoDelegate;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.InstructionInputManager$refreshActionBarConfig$1", f = "InstructionInputManager.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
public final class InstructionInputManager$refreshActionBarConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $source;
    int label;

    public InstructionInputManager$refreshActionBarConfig$1(String r1, Continuation<? super InstructionInputManager$refreshActionBarConfig$1> r2) {
        this.$source = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputManager$refreshActionBarConfig$1(this.$source, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L15:
        hq9.y4 r10 = (hq9.y4) r9;
        if (r10 == null) goto L21;
        ArrayList r11 = r10.a();
        if (r11 == null) goto L21;
        UserSettingDelegate.b.c(r11);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        if (FeatureKitDelegate.b.W().b() == false) goto L11;
        List r12 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(UserConfigKey.DEFAULT_REPLY_MODE.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_MODEL_ITEM_KEY.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_REPLY_OPTION.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_ACTIVE_MODE_MENU.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_ACTIVE_MODE_APP.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_ACTIVE_MODEL_MENU.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_ACTIVE_MODEL_APP.getValue())});
    L12:
        UserSettingRepoDelegate r2 = UserSettingRepoDelegate.b;
        int r3 = UserConfigPullReason.NOTIFIED.getValue();
        String r4 = this.$source;
        this.label = 1;
        r9 = r2.e(r12, r3, r4, this);
        if (r9 != r0) goto L15;
        return r0;
    L11:
        r12 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(UserConfigKey.DEFAULT_REPLY_MODE.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_REPLY_MODE_MENU.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_MODEL_ITEM_KEY.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_REPLY_OPTION.getValue()), Boxing.boxInt(UserConfigKey.DEFAULT_REPLY_MODE_MENU_V2.getValue())});
        goto L12
    }
}
