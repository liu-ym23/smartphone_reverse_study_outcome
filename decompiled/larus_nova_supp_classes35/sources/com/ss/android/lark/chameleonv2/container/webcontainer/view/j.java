package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_ModelChameleonActivity a;

    public j(Hilt_ModelChameleonActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_ModelChameleonActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        k r0 = (k) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        ModelChameleonActivity r4 = (ModelChameleonActivity) UnsafeCasts.unsafeCast(r3);
        r0.E();
        return;
    }
}
