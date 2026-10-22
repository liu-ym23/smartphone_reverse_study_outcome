package com.bytedance.android.livesdk.chatroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k1<T> implements Observer {
    public final /* synthetic */ PlayerControlWidget a;

    public k1(PlayerControlWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        PlayerControlWidget r0 = this.a;
        if (r0.h == false) goto L6;
        r0.h = false;
        return;
    L6:
        if ((!Intrinsics.areEqual(r4, Boolean.TRUE)) == true) goto L11;
        this.a.Iq();
        return;
    }
}
