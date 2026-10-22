package com.bytedance.android.live.platformplayer.layout;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public z(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == true) goto L7;
        LivePlayerWidget r3 = this.a;
        int r0 = LivePlayerWidget.V2;
        r3.fs();
        return;
    }
}
