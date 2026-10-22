package com.ss.ugc.live.sdk.msg.data;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vlc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends a {
    public final i g;

    public b(SdkResponse r2, List<? extends d> r3, i r4) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r3, "decodeMessages");
        Intrinsics.checkNotNullParameter(r4, "listener");
        super(r2, r3);
        this.g = r4;
    }
}
