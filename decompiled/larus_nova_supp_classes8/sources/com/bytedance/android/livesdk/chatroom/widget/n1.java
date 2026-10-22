package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n1<T> implements Observer {
    public final /* synthetic */ PlayerControlWidget a;

    public n1(PlayerControlWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == true) goto L10;
        IPlayerProgressService r3 = this.a.c;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L8:
        r3.handleProgressListener(PlayerControlWidget$registerPlayerEvent$2$1.INSTANCE);
        return;
    }
}
