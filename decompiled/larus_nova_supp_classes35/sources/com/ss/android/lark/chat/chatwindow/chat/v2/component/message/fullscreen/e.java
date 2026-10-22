package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_MessageFullScreenActivity a;

    public e(Hilt_MessageFullScreenActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_MessageFullScreenActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        g r0 = (g) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        MessageFullScreenActivity r4 = (MessageFullScreenActivity) UnsafeCasts.unsafeCast(r3);
        r0.W0();
        return;
    }
}
