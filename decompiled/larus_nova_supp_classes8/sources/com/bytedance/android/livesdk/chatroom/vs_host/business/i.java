package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.text.TextUtils;
import android.view.KeyEvent;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.replay.input.ReplayEmojiInputDialogFragment;
import vr1.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements com.bytedance.android.livesdk.interactivity.api.expression.k {
    public final /* synthetic */ d0 a;

    public final void a() {
        ReplayEmojiInputDialogFragment.b r0 = this.a;
        if (r0 == null) goto L6;
        KeyEvent r1 = new KeyEvent(0, 67);
        r0.a.n.dispatchKeyEvent(r1);
        return;
    }

    public i(ReplayEmojiInputDialogFragment.b r1) {
        this.a = r1;
    }

    public final void b(BaseEmoji r7) {
        ReplayEmojiInputDialogFragment.b r0 = this.a;
        if (r0 == null) goto L18;
        ReplayEmojiInputDialogFragment.b r1 = r0;
        r1.a.n.getText().length();
        ReplayEmojiInputDialogFragment r2 = r1.a;
        int r3 = r2.f + 1;
        boolean r4 = r2.s;
        if (r4 == false) goto L7;
        int r5 = 15;
    L8:
        if (r3 <= r5) goto L14;
        if (r4 == false) goto L11;
        String r8 = r2.getString(2131922120);
    L12:
        com.bytedance.android.livesdk.chatroom.vs_base.util.y.b(r8, 1);
        return;
    L11:
        r8 = r2.getString(2131922118, new Object[]{Integer.valueOf(r2.e)});
        goto L12
    L14:
        if (TextUtils.isEmpty(r7.getDescription()) == true) goto L20;
        r1.a.n.getText().insert(r1.a.n.getSelectionStart(), com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.e().c(r7.getDescription(), r1.a.G));
        return;
    L20:
        return;
    L7:
        r5 = r2.e;
        goto L8
    }
}
