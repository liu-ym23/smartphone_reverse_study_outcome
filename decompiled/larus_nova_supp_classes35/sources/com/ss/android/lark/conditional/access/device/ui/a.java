package com.ss.android.lark.conditional.access.device.ui;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_UserScopeDeviceDeclareActivity a;

    public a(Hilt_UserScopeDeviceDeclareActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_UserScopeDeviceDeclareActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        d r0 = (d) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        UserScopeDeviceDeclareActivity r4 = (UserScopeDeviceDeclareActivity) UnsafeCasts.unsafeCast(r3);
        r0.F0();
        return;
    }
}
