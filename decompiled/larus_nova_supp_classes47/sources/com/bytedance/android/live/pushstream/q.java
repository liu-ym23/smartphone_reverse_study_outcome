package com.bytedance.android.live.pushstream;

import com.bytedance.android.livesdk.config.i60;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ d0 b;
    public final /* synthetic */ ei6.a c;

    public q(String r1, d0 r2, ei6.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Unit r4 = (Unit) r3;
        String r5 = this.a + "audio_metrics_v1.3.model";
        d0 r0 = this.b;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        ei6.a r1 = this.c;
        if (r1 == null) goto L11;
        ri6.b r2 = r1.r();
        if (r2 == null) goto L12;
        r2.u(r5, (String) i60.a.getValue());
        return;
    L12:
        return;
    }
}
