package com.ss.android.lark.compose.chatsetting.add_chatter;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowAddMemberActivity a;

    public b(Hilt_FlowAddMemberActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowAddMemberActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        a r0 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        FlowAddMemberActivity r4 = (FlowAddMemberActivity) UnsafeCasts.unsafeCast(r3);
        r0.B();
        return;
    }
}
