package com.larus.bmhome.clarification;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i2 {
    public static final void a(String r1, JSONObject r2, by7.e r3) {
        by7.a r0 = new by7.a(r1);
        if (r3 == null) goto L5;
        r0.b = r3;
    L5:
        TrackParams r4 = new TrackParams().merge(r2);
        r0.a.merge(r4);
        r0.b();
    }
}
