package com.larus.dora.impl.device;

import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ DoraDeviceFragment a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        DoraDeviceFragment r0 = this.a;
        int r1 = DoraDeviceFragment.z;
        r0.ea0().disconnectSpp();
        FragmentActivity r2 = this.a.getActivity();
        if (r2 == null) goto L6;
        r2.finish();
        return;
    }

    public x(DoraDeviceFragment r1) {
        this.a = r1;
    }
}
