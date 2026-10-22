package com.bytedance.android.live.profile.ui.component;

import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.utils.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x implements a1.c {
    public final /* synthetic */ View a;

    public final void onFail() {
    }

    public x(View r1) {
        this.a = r1;
    }

    public final void a(NinePatchDrawable r2) {
        this.a.setBackgroundDrawable(r2);
    }
}
