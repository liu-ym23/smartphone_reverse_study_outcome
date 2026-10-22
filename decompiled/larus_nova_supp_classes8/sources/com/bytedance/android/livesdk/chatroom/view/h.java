package com.bytedance.android.livesdk.chatroom.view;

import android.view.View;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ f a;

    public h(f r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        SimpleMediaView r3 = this.a.b;
        if (r3 != null) goto L5;
    L7:
        this.a.a(true);
        return;
    L5:
        if (r3.h() != true) goto L7;
        this.a.b();
    }
}
