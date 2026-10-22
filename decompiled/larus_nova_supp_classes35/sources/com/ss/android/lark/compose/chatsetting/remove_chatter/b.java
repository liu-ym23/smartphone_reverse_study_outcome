package com.ss.android.lark.compose.chatsetting.remove_chatter;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowRemoveGroupMemberActivity a;

    public b(Hilt_FlowRemoveGroupMemberActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowRemoveGroupMemberActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        a r0 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        FlowRemoveGroupMemberActivity r4 = (FlowRemoveGroupMemberActivity) UnsafeCasts.unsafeCast(r3);
        r0.B0();
        return;
    }
}
