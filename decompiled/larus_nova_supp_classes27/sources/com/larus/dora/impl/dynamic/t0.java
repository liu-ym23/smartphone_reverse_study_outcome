package com.larus.dora.impl.dynamic;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t0 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ DoraDynamicFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        DoraDynamicFragment r0 = this.a;
        DoraDevice r1 = this.b;
        int r2 = DoraDynamicFragment.C;
        r0.fa0(r1);
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }

    public t0(DoraDynamicFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
