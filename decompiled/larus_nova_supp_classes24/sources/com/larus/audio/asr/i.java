package com.larus.audio.asr;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.audio.audiov3.config.task.sami.asr.ReportType;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.asr.sami.data.SamiAsrDataBin;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import y58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements h68.d {
    public final /* synthetic */ h68.d a;

    public i(h68.d r1) {
        this.a = r1;
    }

    public final void a(b r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        h68.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        b r1 = b.a(r4, g2a.d.b(r4.d));
        int r2 = c68.b.a;
        j r3 = j.a;
        c68.b.a("AsrManager", "onResult => audioState:" + r4.g + ", errCode:" + r4.b + ",errorMessage:" + r4.c + ",result:" + r1);
    }

    public final void b(h68.b r5) {
        Intrinsics.checkNotNullParameter(r5, "asrStreamSentenceResp");
        a0 r0 = j.d;
        if (r0 == null) goto L6;
        r0.a(new b0(r5.a, r5.b, r5.c));
        return;
    }

    public final void c(final SamiAsrDataBin r2) {
        h68.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.c(r2);
    L5:
        String r3 = (String) com.larus.utils.l0.a(null, new h(r2));
        if (r3 == null) goto L9;
        j.c.invoke(r3);
        return;
    }

    public final void e(AsrState r3) {
        Intrinsics.checkNotNullParameter(r3, "asrState");
        h68.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.e(r3);
    L5:
        int r1 = c68.b.a;
        j r2 = j.a;
        c68.b.a("AsrManager", "onStateChange => asrState: " + r3);
    }

    public void onEvent(AsrEventEnum r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        h68.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.onEvent(r2);
        return;
    }

    public final void f(b r2, ReportType r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "type");
        h68.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.f(r2, r3);
        return;
    }

    public final void d(AsrLifeState r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "lifeState");
        h68.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.d(r3, r4, r5);
    L5:
        int r1 = c68.b.a;
        j r2 = j.a;
        c68.b.a("AsrManager", "onLifeStateChange lifeState=" + r3 + " taskId=" + r4 + " extraMap=" + g2a.d.c(GsonProtectorUtils.toJson(new Gson(), r5)));
    }
}
