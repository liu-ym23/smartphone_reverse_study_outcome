package com.ss.android.lark.compose.chat_member_list;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowChatMembersListActivity a;

    public h(Hilt_FlowChatMembersListActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowChatMembersListActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        g r0 = (g) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        FlowChatMembersListActivity r4 = (FlowChatMembersListActivity) UnsafeCasts.unsafeCast(r3);
        r0.F();
        return;
    }
}
