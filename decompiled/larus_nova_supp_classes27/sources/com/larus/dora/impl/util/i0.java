package com.larus.dora.impl.util;

import com.ixigua.lib.track.TrackParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i0 implements Function0 {
    public final /* synthetic */ double a;

    public /* synthetic */ i0(double r1) {
        this.a = r1;
    }

    public final Object invoke() {
        double r0 = this.a;
        JSONObject r2 = new JSONObject();
        r2.put("volume", r0);
        TrackParams r1 = new TrackParams().merge(r2);
        by7.a r3 = new by7.a("flow_adjust_system_stream_volume");
        r3.a.merge(r1);
        r3.b();
        return Unit.INSTANCE;
    }
}
