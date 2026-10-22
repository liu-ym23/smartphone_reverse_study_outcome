package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public t(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if ((!Intrinsics.areEqual((Boolean) r3, Boolean.TRUE)) == true) goto L7;
        long r0 = this.a.U2.x();
        boolean r4 = this.a.U2.isPseudo();
        LivePlatformPlayerManager.c = r0;
        LivePlatformPlayerManager.d = r4;
        return;
    }
}
