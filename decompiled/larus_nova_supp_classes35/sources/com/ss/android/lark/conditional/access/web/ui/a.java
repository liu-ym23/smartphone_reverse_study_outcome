package com.ss.android.lark.conditional.access.web.ui;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_UserScopeBindDeviceWebActivity a;

    public a(Hilt_UserScopeBindDeviceWebActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_UserScopeBindDeviceWebActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        c r0 = (c) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        UserScopeBindDeviceWebActivity r4 = (UserScopeBindDeviceWebActivity) UnsafeCasts.unsafeCast(r3);
        r0.N0();
        return;
    }
}
