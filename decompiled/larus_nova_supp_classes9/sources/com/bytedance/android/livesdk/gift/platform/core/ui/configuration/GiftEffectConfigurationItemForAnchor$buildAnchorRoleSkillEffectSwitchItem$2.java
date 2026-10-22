package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"doCheckStateChanged", BuildConfig.FLAVOR, "currentState", BuildConfig.FLAVOR, "onSuccessAction", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$2 extends Lambda implements Function2<Boolean, Function0<? extends Unit>, Unit> {
    final /* synthetic */ GiftEffectConfigurationItemForAnchor this$0;

    public GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$2(GiftEffectConfigurationItemForAnchor r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Boolean) r1).booleanValue(), (Function0) r2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r2, Function0<Unit> r3) {
        ay1.d.f(r2);
        GiftEffectConfigurationViewModelForAnchor r0 = this.this$0.b;
        if (r0 == null) goto L6;
        r0.updateRoleSkillEffectSwitch(r2, r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void invoke$default(GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$2 r0, boolean r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.invoke(r1, r2);
    }
}
