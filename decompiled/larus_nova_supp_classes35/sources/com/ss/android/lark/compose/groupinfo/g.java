package com.ss.android.lark.compose.groupinfo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowGroupInfoActivity a;

    public g(Hilt_FlowGroupInfoActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowGroupInfoActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        a r0 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        FlowGroupInfoActivity r4 = (FlowGroupInfoActivity) UnsafeCasts.unsafeCast(r3);
        r0.A0();
        return;
    }
}
