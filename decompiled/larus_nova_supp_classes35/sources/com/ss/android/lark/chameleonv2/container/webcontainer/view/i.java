package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_ChameleonActivity a;

    public i(Hilt_ChameleonActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_ChameleonActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        a r0 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        ChameleonActivity r4 = (ChameleonActivity) UnsafeCasts.unsafeCast(r3);
        r0.y();
        return;
    }
}
