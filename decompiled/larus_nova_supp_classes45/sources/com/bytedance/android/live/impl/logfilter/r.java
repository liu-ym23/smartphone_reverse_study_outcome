package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.impl.service.FeatureManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements f {
    public static final r a = null;

    public r() {
    }

    static {
        a = new r();
    }

    @Override // com.bytedance.android.live.impl.logfilter.f
    public final void onEvent(String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        int r0 = r4.hashCode();
        if (r0 == (-1235807369)) goto L11;
        if (r0 == (-692878481)) goto L8;
        return;
    L8:
        if (r4.equals("livesdk_live_user_tone_report") == false) goto L14;
    L12:
        String r1 = r5.get("audio_render_rms_db");
        String r2 = r5.get("audio_decoder_rms_db");
        FeatureManager r3 = FeatureManager.u;
        z90.a.C0301a.a(r3, "audio_render_rms_db", r5.get("audio_render_rms_db"));
        z90.a.C0301a.a(r3, "audio_decoder_rms_db", r5.get("audio_decoder_rms_db"));
        return;
    L14:
        return;
    L11:
        if (r4.equals("livesdk_performance_monitor_base_new") == true) goto L12;
    }
}
