package com.larus.doc.impl;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DocServiceImpl$d implements by7.e {
    public final /* synthetic */ String a;

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public DocServiceImpl$d(String r1) {
        this.a = r1;
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("current_page", this.a);
    }
}
