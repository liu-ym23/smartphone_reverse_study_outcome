package com.larus.camera.impl.vlm;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import ix8.g;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final VLMIntentTrackSource a;
    public final ix8.a b;
    public final AtomicBoolean c;
    public final long d;
    public volatile long e;
    public volatile g f;

    /* JADX INFO: renamed from: com.larus.camera.impl.vlm.a$a, reason: collision with other inner class name */
    public static final class C0085a {
    }

    static {
    }

    public a(VLMIntentTrackSource r2, ix8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicBoolean(false);
        this.d = System.currentTimeMillis();
    }

    public final void a(String r13, int r14, String r15, int r16, String r17) {
        VLMIntentTrackSource r1 = this.a;
        if (r1 != null) goto L5;
        return;
    L5:
        boolean r3 = false;
        if (this.c.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        long r5 = System.currentTimeMillis();
        Long r2 = Long.valueOf(this.e);
        if (r2.longValue() <= 0) goto L12;
        r3 = true;
    L12:
        if (r3 == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L17;
        Long r4 = Long.valueOf(r5 - r2.longValue());
    L18:
        JSONObject r6 = new JSONObject();
        r6.put("status", r13);
        r6.put(MusicAppletPage.KEY_SOURCE, r1.getValue());
        r6.put("duration", r5 - this.d);
        if (r4 == null) goto L21;
        r6.put("network_duration", r4.longValue());
    L21:
        r6.put("is_edu_intent", r14);
        g r7 = this.f;
        if (r7 == null) goto L24;
        r6.put("pre_process_duration", r7.a);
    L24:
        r6.put("error_type", r15);
        r6.put("error_code", r16);
        r6.put("error_msg", r17);
        r6.put("need_intent", this.b.d ? 1 : 0);
        r6.put("need_detection", this.b.f ? 1 : 0);
        r6.put("need_dewarp", this.b.e ? 1 : 0);
        FLogger.a.i("VLMIntentDetectTracker", "[track] " + r6);
        o.a.reportEvent("vlm_intent_detect", r6);
        com.larus.platform.service.g.a.monitorEventForSlardar("vlm_intent_detect", r6, null, null);
        return;
    L17:
        r4 = null;
        goto L18
    }
}
