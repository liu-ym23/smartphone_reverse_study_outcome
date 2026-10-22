package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.widget.ImageView;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ ChatMatchDialog a;

    public k(ChatMatchDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        final b1 r4 = (b1) r3;
        if (r4 == null) goto L5;
        ChatMatchDialog r0 = this.a;
        int r1 = ik0.g.b;
        int r2 = ChatMatchDialog.V;
        r0.Y90(2);
        ChatMatchDialog.T90(this.a, r4, new ChatMatchDialog$matchDataObserver$$inlined$let$lambda$1$1(this, r4));
        return;
    L5:
        ChatMatchDialog r5 = this.a;
        int r6 = ChatMatchDialog.V;
        r5.W90();
        ImageView r7 = this.a.B;
        if (r7 == null) goto L10;
        r7.setVisibility(4);
        return;
    }
}
