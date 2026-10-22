package com.larus.dora.impl.device.manage.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.databinding.LarusDoraPageDeviceSettingsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/impl/device/manage/settings/DoraDeviceSettingsFragment$localReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceSettingsFragment$localReceiver$1 extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final /* synthetic */ DoraDeviceSettingsFragment a;

    public DoraDeviceSettingsFragment$localReceiver$1(DoraDeviceSettingsFragment r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r9, Intent r10) {
        String r11 = "";
        if (r10 == null) goto L6;
        String r0 = r10.getAction();
        if (r0 == null) goto L6;
    L7:
        String r6 = null;
        switch(r0.hashCode()) {
            case -1789750617: goto L31;
            case -1400478214: goto L22;
            case 1157480080: goto L14;
            case 1330375556: goto L11;
            default: goto L52;
        };
    L52:
        g49.d.d("DoraDeviceSettingsFragment", "onReceive : unknown action : ".concat(r0));
    L53:
        if (r10 == null) goto L55;
        String r12 = r10.getAction();
    L57:
        if (Intrinsics.areEqual(r12, "action.DEVICE_UNBIND") == true) goto L63;
        if (r10 == null) goto L61;
        r6 = r10.getAction();
    L61:
        if (Intrinsics.areEqual(r6, "action.DEVICE_UPDATE_DYNAMIC") == true) goto L63;
        return;
    L63:
        if (Intrinsics.areEqual(r10.getAction(), "action.DEVICE_UPDATE_DYNAMIC") == false) goto L69;
        DoraDeviceSettingsFragment r13 = this.a;
        int r14 = DoraDeviceSettingsFragment.w;
        r13.getClass();
        DoraDevice r15 = kj4.a.g().c();
        if (r15 == null) goto L70;
        this.a.Z90(r15.mac, false);
        return;
    L70:
        return;
    L69:
        return;
    L55:
        r12 = null;
        goto L57
    L11:
        if (r0.equals("action.DEVICE_ENTER_SIMUL_INTERPRET") == true) goto L53;
    L14:
        if (r0.equals("action.DEVICE_UPDATE_NAME") == false) goto L52;
        LarusDoraPageDeviceSettingsBinding r16 = this.a.f;
        if (r16 == null) goto L53;
        ConstraintLayout r17 = r16.a;
        if (r17 == null) goto L53;
        r17.post(new q());
        goto L53
    L22:
        if (r0.equals("action.DEVICE_UPDATE_DYNAMIC") == false) goto L52;
        DoraDevice r18 = com.larus.dora.impl.dynamic.i.b();
        if (r18 != null) goto L29;
        FragmentActivity r20 = this.a.getActivity();
        if (r20 == null) goto L53;
        r20.finish();
        goto L53
    L29:
        DoraDeviceSettingsFragment r1 = this.a;
        String r21 = r18.mac;
        int r2 = DoraDeviceSettingsFragment.w;
        r1.Z90(r21, false);
        goto L53
    L31:
        if (r0.equals("action.DEVICE_UNBIND") == false) goto L52;
        if (r10 == null) goto L35;
        String r3 = r10.getStringExtra("mac");
    L36:
        g49.d.d("DoraDeviceSettingsFragment", "onReceive : device unbind action. intentMac : " + r3);
        if (r3 == null) goto L53;
        DoraDeviceSettingsFragment r4 = this.a;
        int r5 = DoraDeviceSettingsFragment.w;
        r4.getClass();
        r4.Y90().updateRemoveBarData(r3);
        DoraDevice r7 = r4.p;
        if (r7 == null) goto L45;
        String r8 = r7.mac;
        if (r8 == null) goto L45;
        r11 = r8;
    L45:
        if (TextUtils.equals(r3, r11) == false) goto L53;
        DoraDevice r22 = com.larus.dora.impl.dynamic.i.b();
        if (r22 != null) goto L51;
        FragmentActivity r23 = r4.getActivity();
        if (r23 == null) goto L53;
        r23.finish();
        goto L53
    L51:
        r4.Z90(r22.mac, false);
        goto L53
    L35:
        r3 = null;
    L6:
        r0 = "";
        goto L7
    }
}
