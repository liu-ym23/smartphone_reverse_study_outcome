package com.ss.android.lark.flow.chat.creategroup.page;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowGroupCreateActivity a;

    public i(Hilt_FlowGroupCreateActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowGroupCreateActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        d r0 = (d) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        FlowGroupCreateActivity r4 = (FlowGroupCreateActivity) UnsafeCasts.unsafeCast(r3);
        r0.O();
        return;
    }
}
