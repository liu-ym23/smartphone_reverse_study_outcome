package com.bytedance.android.live.pushstream;

import com.bytedance.android.livesdkapi.service.IPushStreamDataManager;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements IPushStreamDataManager {
    public final /* synthetic */ LiveStream4 a;

    public final Map<String, Double> getEffectInfo() {
        this.a.K.getClass();     // Catch: JSONException -> L7
        d0 r0 = this.a.h;     // Catch: JSONException -> L7
        if (r0 == null) goto L5;
        r0.D();     // Catch: JSONException -> L7
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        LiveStream4.w(this.a, "processTextureTime");
        r1.put("processTextureTime", Double.valueOf(-1.0d));
        LiveStream4.w(this.a, "pureRenderTime");
        r1.put("pureRenderTime", Double.valueOf(-1.0d));
        LiveStream4.w(this.a, "waitAlgorithmTime");
        r1.put("waitAlgorithmTime", Double.valueOf(-1.0d));
        LiveStream4.w(this.a, "pureAlgorithmTime");
        r1.put("pureAlgorithmTime", Double.valueOf(-1.0d));
        return r1;
    }

    public final String getEffectParams() {
        this.a.K.getClass();
        d0 r0 = this.a.h;
        if (r0 == null) goto L7;
        r0.D();
        return "";
    L7:
        return "";
    }

    public final Map<String, String> getPerfToolsNormalData() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("data_push_client_bitrate", String.valueOf(this.a.l));
        d0 r1 = this.a.h;
        if (r1 == null) goto L7;
        z r2 = r1.C();
        if (r2 == null) goto L7;
        String r3 = String.valueOf(r2.a());
    L8:
        r0.put("data_push_client_fps", r3);
        return r0;
    L7:
        r3 = null;
        goto L8
    }

    public final Map<String, Double> getPushStreamInfo() {
        LinkedHashMap r0 = new LinkedHashMap();
        y r1 = this.a.v;
        double r2 = -1.0d;
        if (r1 == null) goto L5;
        double r4 = r1.a();
    L6:
        r0.put("videoCaptureFps", Double.valueOf(r4));
        r0.put("streamFps", Double.valueOf(this.a.k));
        d0 r3 = this.a.h;
        if (r3 == null) goto L11;
        z r5 = r3.C();
        if (r5 == null) goto L11;
        r2 = r5.a();
    L11:
        r0.put("previewFps", Double.valueOf(r2));
        return r0;
    L5:
        r4 = -1.0d;
        goto L6
    }

    public s(LiveStream4 r1) {
        this.a = r1;
    }
}
