package com.obric.miniapp.alarm;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u implements m {
    public u() {
    }

    @Override // com.obric.miniapp.alarm.m
    public final void report(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        TrackParams r4 = new TrackParams().merge(r3);
        by7.a r0 = new by7.a(r2);
        r0.a.merge(r4);
        r0.b();
    }
}
