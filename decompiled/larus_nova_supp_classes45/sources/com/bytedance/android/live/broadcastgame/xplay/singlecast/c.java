package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements qz.a {
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b a;
    public final com.bytedance.android.live.broadcastgame.xplay.servermergecast.a b;

    public static final class a {
    }

    static {
    }

    public c(com.bytedance.android.live.broadcastgame.xplay.littlewindow.b r2, com.bytedance.android.live.broadcastgame.xplay.servermergecast.a r3) {
        Intrinsics.checkNotNullParameter(r2, "littleWindowService");
        Intrinsics.checkNotNullParameter(r3, "xplayLittleWindowCastManager");
        this.a = r2;
        this.b = r3;
        new CompositeDisposable();
    }
}
