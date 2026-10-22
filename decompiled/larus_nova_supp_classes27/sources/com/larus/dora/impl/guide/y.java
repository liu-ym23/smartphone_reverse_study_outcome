package com.larus.dora.impl.guide;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y implements by7.e {
    public final /* synthetic */ DoraConnectDeviceGuide a;

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public y(DoraConnectDeviceGuide r1) {
        this.a = r1;
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("current_page", this.a.a);
    }
}
