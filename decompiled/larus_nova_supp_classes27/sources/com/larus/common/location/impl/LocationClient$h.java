package com.larus.common.location.impl;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LocationClient$h implements p0 {
    public final /* synthetic */ FragmentActivity a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        Intent r0 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        r0.addFlags(268435456);
        this.a.startActivity(r0);
    }

    public LocationClient$h(FragmentActivity r1) {
        this.a = r1;
    }
}
