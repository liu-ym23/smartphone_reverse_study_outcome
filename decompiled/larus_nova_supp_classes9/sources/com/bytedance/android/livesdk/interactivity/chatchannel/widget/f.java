package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.LoadMoreLayout;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements LoadMoreLayout.a {
    public final /* synthetic */ ChannelMemberManagerDialog a;

    public final void a() {
        View r0 = this.a.P;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.a.findViewById(2131379052).c();
    }

    public final void b() {
        View r0 = this.a.P;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        this.a.findViewById(2131379052).b();
    }

    public final void c() {
        ChannelMemberManagerDialog r0 = this.a;
        if (r0.Q == false) goto L5;
        return;
    L5:
        if (((TextView) r0.findViewById(2131380931)).getVisibility() != 0) goto L9;
        r3.g(this.a.findViewById(2131380931), ((TextView) this.a.findViewById(2131380931)).getText());
        return;
    }

    public final void onLoading() {
        ChannelMemberManagerDialog r0 = this.a;
        int r1 = ChannelMemberManagerDialog.k0;
        r0.Z0(false);
    }

    public f(ChannelMemberManagerDialog r1) {
        this.a = r1;
    }
}
