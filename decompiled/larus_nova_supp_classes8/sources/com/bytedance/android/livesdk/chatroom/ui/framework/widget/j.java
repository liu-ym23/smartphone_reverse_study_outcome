package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements com.bytedance.android.livesdk.chatroom.game.a {
    public final /* synthetic */ GameDelegateWidget a;

    public FragmentActivity getActivity() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p0();
    }

    public Context getContext() {
        return this.a.getContext();
    }

    public j(GameDelegateWidget r1) {
        this.a = r1;
    }
}
