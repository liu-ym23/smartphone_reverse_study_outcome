package com.ss.android.lark.compose.chatsetting.quit;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_QuitGroupActivity a;

    public a(Hilt_QuitGroupActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_QuitGroupActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        b r0 = (b) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        QuitGroupActivity r4 = (QuitGroupActivity) UnsafeCasts.unsafeCast(r3);
        r0.v();
        return;
    }
}
