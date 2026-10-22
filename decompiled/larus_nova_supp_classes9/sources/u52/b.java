package u52;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends d<f> {
    public volatile String h;
    public volatile boolean i;
    public final String j;
    public final String k;
    public final String l;
    public final c m;

    @Override // u52.d
    public final boolean a() {
        if (this.i == true) goto L5;
    L7:
        return false;
    L5:
        if (d() == false) goto L7;
        return true;
    }

    public final PolarisFileWrapper k() {
        String r0 = this.h;
        if (r0 != null) goto L5;
        return null;
    L5:
        PolarisFileWrapper r2 = d.c(this.m.a);
        if (r2 != null) goto L8;
        return null;
    L8:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r2, r0);
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("getAudioFile. name=" + r1.getName() + " exists=" + r1.exists());
        return r1;
    }

    public static Pair j(byte[] r3) {
        JSONObject r0 = new JSONObject(new String(r3, Charsets.UTF_8));     // Catch: Exception -> L11
        String r4 = r0.optString("reqid");     // Catch: Exception -> L11
        JSONArray r1 = r0.optJSONArray("result");     // Catch: Exception -> L11
        if (r1 == null) goto L8;
        JSONObject r2 = JSONArrayProtectorUtils.getJSONObject(r1, 0);     // Catch: Exception -> L11
        if (r2 == null) goto L8;
        String r5 = JSONObjectProtectorUtils.getString(r2, "text");     // Catch: Exception -> L11
        if (r5 == null) goto L8;
    L9:
        return TuplesKt.to(r4, r5);
    L8:
        r5 = BuildConfig.FLAVOR;
    L11:
        e = move-exception;
        SafetyGuard.a("AnchorAsr get asr result failed", e, null);
        return null;
    }

    @Override // u52.d
    public final void g(int r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        super.g(r2, r3);
        if (r2 != 1001) goto L5;
        this.h = "recorder_" + this.b + ".aac";
        return;
    L5:
        if (r2 != 1201) goto L7;
        Pair r4 = j(r3);
        if (r4 == null) goto L24;
        f r5 = (f) this.e;
        if (r5 == null) goto L25;
        r5.b((String) r4.getFirst(), (String) r4.getSecond());
        return;
    L25:
        return;
    L24:
        return;
    L7:
        if (r2 != 1204) goto L27;
        Pair r6 = j(r3);
        if (r6 == null) goto L21;
        e("onComplete result " + ((String) r6.getFirst()));
        this.a.set(4);
        f r7 = (f) this.e;
        if (r7 == null) goto L22;
        r7.a((String) r6.getFirst(), (String) r6.getSecond());
        return;
    L22:
        return;
    L21:
        return;
    }

    public b(String r2, String r3, String r4, c r5) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appToken");
        Intrinsics.checkNotNullParameter(r4, "cluster");
        Intrinsics.checkNotNullParameter(r5, "config");
        super("AsrEngine");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
    }
}
