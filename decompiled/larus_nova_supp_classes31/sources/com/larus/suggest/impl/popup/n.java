package com.larus.suggest.impl.popup;

import com.larus.platform.api.n0;
import com.larus.utils.logger.FLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n implements n0 {
    public final /* synthetic */ NexPulseDialog a;

    @Override // com.larus.platform.api.n0
    public final void b(Integer r1, Integer r2) {
    }

    @Override // com.larus.platform.api.n0
    public final void c(int r1) {
    }

    @Override // com.larus.platform.api.n0
    public final void d(int r1) {
    }

    @Override // com.larus.platform.api.n0
    public final void onCompletion() {
    }

    @Override // com.larus.platform.api.n0
    public final void onPrepare() {
    }

    @Override // com.larus.platform.api.n0
    public final void onPrepared() {
    }

    @Override // com.larus.platform.api.n0
    public final void onVideoStatusException(int r1) {
    }

    @Override // com.larus.platform.api.n0
    public final void onRenderStart() {
        FLogger.a.i("NexPulseDialog", "onFirstFrame");
        NexPulseDialog r0 = this.a;
        long r1 = System.currentTimeMillis();
        NexPulseDialog r3 = this.a;
        r0.s = r1 - r3.r;
        int r2 = v.a;
        long r4 = r3.s;
        Boolean r5 = r3.t;
        JSONObject r6 = new JSONObject();
        r6.put("first_frame_time", r4);
        r6.put("hit_mdl_cache", r5);
        r6.put("event_type", "video_play_success");
        com.larus.platform.service.o.a.reportEvent("dev_nex_pulse_dialog_monitor", r6);
    }

    public n(NexPulseDialog r1) {
        this.a = r1;
    }

    @Override // com.larus.platform.api.n0
    public final void a(Integer r6, Integer r7) {
        FLogger.a.e("NexPulseDialog", "onError " + r6 + ", " + r7);
        int r0 = v.a;
        if (r6 == null) goto L5;
        int r8 = r6.intValue();
    L6:
        String r9 = String.valueOf(r7);
        NexPulseDialog r1 = this.a;
        long r2 = r1.s;
        Boolean r3 = r1.t;
        JSONObject r4 = new JSONObject();
        r4.put("error_code", r8);
        r4.put("error_msg", r9);
        r4.put("first_frame_time", r2);
        r4.put("hit_mdl_cache", r3);
        r4.put("event_type", "video_play_error");
        com.larus.platform.service.o.a.reportEvent("dev_nex_pulse_dialog_monitor", r4);
        return;
    L5:
        r8 = 0;
        goto L6
    }
}
