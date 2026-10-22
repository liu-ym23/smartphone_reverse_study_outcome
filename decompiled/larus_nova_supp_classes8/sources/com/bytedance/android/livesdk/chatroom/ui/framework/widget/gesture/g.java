package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import android.view.View;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements GestureDetectLayout.a {
    public final /* synthetic */ GestureWidget a;

    public g(GestureWidget r1) {
        this.a = r1;
    }

    public final void a(int r3) {
        GestureWidget r0 = this.a;
        float r4 = r3;
        View r1 = r0.Gq();
        if (r1 == null) goto L7;
        r0.Cq(r4, r1.getTranslationX());
        return;
    }
}
