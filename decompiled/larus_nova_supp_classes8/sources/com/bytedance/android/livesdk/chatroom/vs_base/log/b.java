package com.bytedance.android.livesdk.chatroom.vs_base.log;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ReplayDurationLogger a;

    public b(ReplayDurationLogger r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == true) goto L7;
        this.a.b();
        return;
    }
}
