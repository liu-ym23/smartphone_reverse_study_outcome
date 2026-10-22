package com.bytedance.android.live.profile.model;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends ta1.a<f> {
    public f c;

    public g() {
    }

    public final void a(Map<String, String> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        TokenCert r0 = j0.c;
        if (H() == true) goto L7;
        ALogger.w("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L7:
        r4.putAll(this.b);
        I(r4, this.c);
    }

    public final void setData(Object r1) {
        this.c = (f) r1;
    }

    public final void I(Map<String, String> r4, f r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        TokenCert r0 = j0.c;
        if (H() == true) goto L7;
        ALogger.w("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L7:
        r4.putAll(this.b);
        if (r5 == null) goto L11;
        r4.put("request_page", r5.a);
        r4.put("room_layout", r5.b);
        r4.put("to_user_id", r5.c);
        r4.put("new_profile_card_v", String.valueOf(r5.d));
        r4.put("user_id", r5.e);
        return;
    }

    public final /* bridge */ /* synthetic */ void u(Map r1, Object r2) {
        I(r1, (f) r2);
    }
}
