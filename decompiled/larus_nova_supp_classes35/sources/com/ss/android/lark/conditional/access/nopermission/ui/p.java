package com.ss.android.lark.conditional.access.nopermission.ui;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_NoPermissionActivity a;

    public p(Hilt_NoPermissionActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_NoPermissionActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        ((v) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent()).t1((NoPermissionActivity) UnsafeCasts.unsafeCast(r3));
        return;
    }
}
