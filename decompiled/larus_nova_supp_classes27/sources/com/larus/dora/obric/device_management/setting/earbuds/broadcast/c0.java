package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.widget.CompoundButton;
import androidx.fragment.app.FragmentManager;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.oswitch.OSwitch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ DoraObricEarbudsBroadcastSettingFragment a;

    public /* synthetic */ c0(DoraObricEarbudsBroadcastSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r4, boolean r5) {
        DoraObricEarbudsBroadcastSettingFragment r0 = this.a;
        int r1 = DoraObricEarbudsBroadcastSettingFragment.F;
        Intrinsics.checkNotNull(r4);
        if (com.larus.dora.obric.device_management.setting.earbuds.k.a(r4) == false) goto L7;
        r4.setOnCheckedChangeListener(null);
        r4.setChecked(((Boolean) DoraUserSettingsManager.g.getValue()).booleanValue());
        OSwitch r6 = r0.m;
        if (r6 == null) goto L26;
        r6.setOnCheckedChangeListener(new c0(r0));
        return;
    L26:
        return;
    L7:
        r0.getClass();
        g49.d.d("DoraObricEarbudsBroadcastSetting", "handleNotificationSwitchClick: enabled=" + r5);
        DoraUserSettingsManager r7 = DoraUserSettingsManager.a;
        boolean r8 = ((Boolean) DoraUserSettingsManager.g.getValue()).booleanValue();
        OSwitch r2 = r0.m;
        if (r2 == null) goto L12;
        r2.setOnCheckedChangeListener(null);
        r2.setChecked(r8);
        OSwitch r9 = r0.m;
        if (r9 == null) goto L12;
        r9.setOnCheckedChangeListener(new c0(r0));
    L12:
        if (r5 == true) goto L14;
        DoraUserSettingsManager.m(false);
        return;
    L14:
        if (DoraUserSettingsManager.f() == true) goto L20;
        DoraObricEarbudsPrivacySheet r10 = new DoraObricEarbudsPrivacySheet();
        FragmentManager r11 = r0.getParentFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "DoraObricEarbudsPrivacySheet", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r10, r3) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L19:
        r10.show(r11, "DoraObricEarbudsPrivacySheet");
        return;
    L30:
        return;
    L20:
        r0.ca0();
    }
}
