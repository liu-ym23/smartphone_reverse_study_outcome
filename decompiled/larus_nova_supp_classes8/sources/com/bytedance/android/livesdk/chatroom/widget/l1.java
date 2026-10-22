package com.bytedance.android.livesdk.chatroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l1<T> implements Observer {
    public final /* synthetic */ PlayerControlWidget a;

    public l1(PlayerControlWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        if (((Boolean) r1).booleanValue() == false) goto L7;
        this.a.Iq();
        return;
    }
}
