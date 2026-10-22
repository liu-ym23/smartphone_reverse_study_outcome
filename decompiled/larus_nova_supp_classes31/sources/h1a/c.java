package h1a;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final Gson a = null;

    static {
        a = new Gson();
    }

    public static void a(d r4, com.larus.ugc.perf.impl.e r5, by7.e r6) {
        Intrinsics.checkNotNullParameter(r4, "mobData");
        Gson r0 = a;
        String r1 = GsonProtectorUtils.toJson(r0, r4);
        TrackParams r2 = new TrackParams().merge(new JSONObject(r1));
        if (r5 == null) goto L5;
        r2 = r2.merge(GsonProtectorUtils.toJson(r0, r5));
    L5:
        String r7 = r4.a();
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        by7.a r8 = new by7.a(r7);
        if (r6 == null) goto L11;
        r8.b = r6;
    L11:
        r8.a.merge(r2);
        r8.b();
    }
}
