package com.larus.doc.impl.offline;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements by7.e {
    public final /* synthetic */ TrackParams a;

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public i(TrackParams r1) {
        this.a = r1;
    }

    public final void fillTrackParams(TrackParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.merge(this.a);
    }
}
