package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p1<T> implements Observer {
    public final /* synthetic */ PlayerControlWidget a;

    public p1(PlayerControlWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == true) goto L13;
        ILivePlayerClient r3 = PlayerControlWidget.xq(this.a);
        if (r3 == null) goto L8;
        r3.resume();
    L8:
        IPlayerProgressService r4 = this.a.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L11:
        r4.handleProgressListener(PlayerControlWidget$registerPlayerEvent$4$1.INSTANCE);
        return;
    }
}
