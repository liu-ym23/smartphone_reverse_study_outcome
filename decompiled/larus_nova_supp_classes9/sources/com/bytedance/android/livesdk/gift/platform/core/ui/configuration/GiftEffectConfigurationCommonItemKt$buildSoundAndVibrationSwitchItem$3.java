package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"onCheckStateChanged", BuildConfig.FLAVOR, "switch", "Landroid/widget/Switch;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$3 extends Lambda implements Function1<Switch, Unit> {
    final /* synthetic */ boolean $isAnchor;
    final /* synthetic */ GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2 $showCloseEffectConfirmDialog$2;

    public GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$3(boolean r1, GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2 r2) {
        this.$isAnchor = r1;
        this.$showCloseEffectConfirmDialog$2 = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Switch) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(final Switch r6) {
        Intrinsics.checkNotNullParameter(r6, "switch");
        final boolean r0 = r6.isChecked();
        if (r0 == true) goto L12;
        if (this.$isAnchor == false) goto L8;
        this.$showCloseEffectConfirmDialog$2.invoke(new AnonymousClass1(r6));
        return;
    L8:
        if (((Boolean) ay1.b.W.getValue(null, ay1.b.a[60])).booleanValue() == true) goto L10;
        this.$showCloseEffectConfirmDialog$2.invoke(new AnonymousClass2(r6, r0));
        return;
    L10:
        int r2 = p.a;
        p.e("gift_voice_switch", Boolean.FALSE);
        GiftEffectConfigurationCommonItemKt.b(r0);
        ay1.b.A(r6.isChecked());
        return;
    L12:
        if (this.$isAnchor == true) goto L14;
        ay1.b.A(true);
        GiftEffectConfigurationCommonItemKt.b(r0);
        int r7 = p.a;
        p.e("gift_voice_switch", Boolean.TRUE);
        return;
    L14:
        ay1.b.B(true);
        int r8 = p.a;
        ClickType r9 = ClickType.GiftVoice;
        p.b(r9, Boolean.TRUE);
        p.c(r9, true, true);
    }
}
