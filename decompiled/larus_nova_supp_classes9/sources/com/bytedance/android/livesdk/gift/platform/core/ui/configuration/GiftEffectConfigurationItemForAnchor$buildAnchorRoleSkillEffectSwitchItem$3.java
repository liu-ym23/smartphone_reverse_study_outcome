package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"onCheckStateChanged", BuildConfig.FLAVOR, "switch", "Landroid/widget/Switch;", "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$3 extends Lambda implements Function1<Switch, Unit> {
    final /* synthetic */ GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$2 $doCheckStateChanged$2;
    final /* synthetic */ GiftEffectConfigurationItemForAnchor this$0;

    public GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$3(GiftEffectConfigurationItemForAnchor r1, GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$2 r2) {
        this.this$0 = r1;
        this.$doCheckStateChanged$2 = r2;
        super(1);
    }

    public final void invoke(final Switch r6) {
        Intrinsics.checkNotNullParameter(r6, "switch");
        boolean r0 = r6.isChecked();
        GiftEffectConfigurationViewModelForAnchor r1 = this.this$0.b;
        if (r1 == null) goto L5;
        r1.logConfigDialogClick(ClickType.RoleSkill, Boolean.valueOf(!r6.isChecked()));
    L5:
        if (r0 == true) goto L12;
        GiftEffectConfigurationViewModelForAnchor r2 = this.this$0.b;
        if (r2 != null) goto L9;
    L11:
        this.$doCheckStateChanged$2.invoke(false, AnonymousClass2.INSTANCE);
        return;
    L9:
        if (r2.isBeforeLive() != true) goto L11;
        GiftEffectConfigurationItemForAnchor.d(this.this$0, "关闭后，直播间将不展示角色专属效果", new AnonymousClass1(this, r6));
        return;
    L12:
        GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$2.invoke$default(this.$doCheckStateChanged$2, true, null, 2, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Switch) r1);
        return Unit.INSTANCE;
    }
}
