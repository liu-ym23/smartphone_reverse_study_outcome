package com.larus.dora.impl.guide;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0 implements by7.e {
    public final /* synthetic */ DoraKeepAliveGuide a;

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public g0(DoraKeepAliveGuide r1) {
        this.a = r1;
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("current_page", this.a.a);
    }
}
