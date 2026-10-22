package com.larus.bmhome.chat.trace;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public i0() {
    }

    public static void a(String r1, JSONObject r2, by7.e r3) {
        TrackParams r4 = new TrackParams().merge(r2);
        by7.a r0 = new by7.a(r1);
        if (r3 == null) goto L5;
        r0.b = r3;
    L5:
        r0.a.merge(r4);
        r0.b();
    }
}
