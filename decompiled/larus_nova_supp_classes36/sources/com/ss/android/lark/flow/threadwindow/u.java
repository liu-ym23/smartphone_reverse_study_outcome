package com.ss.android.lark.flow.threadwindow;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowThreadWindowActivity a;

    public u(Hilt_FlowThreadWindowActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowThreadWindowActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        a r0 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        FlowThreadWindowActivity r4 = (FlowThreadWindowActivity) UnsafeCasts.unsafeCast(r3);
        r0.o0();
        return;
    }
}
