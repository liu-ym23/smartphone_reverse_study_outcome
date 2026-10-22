package com.bytedance.android.live.platformplayer.layout;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public s0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if ((!Intrinsics.areEqual((Boolean) r3, Boolean.TRUE)) == true) goto L7;
        this.a.Er("player widget @" + this.a.hashCode() + " onPlaying() after observe");
        this.a.Qr();
        return;
    }
}
