package com.ss.android.lark.flow.chat.page;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowChatActivity a;

    public c(Hilt_FlowChatActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowChatActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        b r0 = (b) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        FlowChatActivity r4 = (FlowChatActivity) UnsafeCasts.unsafeCast(r3);
        r0.K0();
        return;
    }
}
