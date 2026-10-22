package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends c<f> {
    public volatile boolean f;

    public static final class a {
    }

    static {
    }

    public final void e() {
        c("finishTalking come");
        if (b() == false) goto L9;
        int r0 = this.b.sendDirective(1100, "");
        if (r0 != 0) goto L7;
        this.a.compareAndSet(3, 4);
        return;
    L7:
        d("finish talking failed. ret=" + r0);
        return;
    }

    public h() {
    }

    public static Pair f(byte[] r3) {
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
        r5 = "";
    L11:
        e = move-exception;
        SafetyGuard.a("AnchorAsr get asr result failed", e, null);
        return null;
    }
}
