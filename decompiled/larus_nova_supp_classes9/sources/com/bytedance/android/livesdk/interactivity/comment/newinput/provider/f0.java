package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.input.ActivityEmojiAutoTestUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ e0.c a;

    public f0(e0.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        StringBuilder r4 = new StringBuilder("portrait send button click, panelBridge empty?");
        if (this.a.e.a != null) goto L5;
        boolean r0 = true;
    L6:
        r4.append(r0);
        i40.h.c(r4.toString(), true);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.a.e.a;
        if (r5 == null) goto L10;
        r5.p0();
    L10:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L18;
        ActivityEmojiAutoTestUtil.c.getClass();
        if (ActivityEmojiAutoTestUtil.a == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L20;
        ((com.bytedance.android.livesdk.interactivity.api.input.a) ActivityEmojiAutoTestUtil.b.getValue()).c = null;
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
