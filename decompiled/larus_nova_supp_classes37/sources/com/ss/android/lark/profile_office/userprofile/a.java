package com.ss.android.lark.profile_office.userprofile;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_OfficeProfileActivity a;

    public a(Hilt_OfficeProfileActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_OfficeProfileActivity r3 = this.a;
        if (r3.c == true) goto L6;
        r3.c = true;
        c r0 = (c) r3.generatedComponent();
        OfficeProfileActivity r4 = (OfficeProfileActivity) UnsafeCasts.unsafeCast(r3);
        r0.b();
        return;
    }
}
