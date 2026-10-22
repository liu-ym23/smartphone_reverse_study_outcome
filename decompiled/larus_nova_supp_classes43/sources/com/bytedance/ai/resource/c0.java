package com.bytedance.ai.resource;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0 implements k5.j {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.e("cost", this.a);
        r10.f(com.bytedance.android.ec.core.event.a.KEY_URL, this.b);
        r10.d(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, this.c);
        String r0 = this.d;
        if (r0 == null) goto L5;
        r10.f(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r0);
    L5:
        String r1 = this.e;
        if (r1 == null) goto L9;
        r10.f("res_from", r1);
        return;
    }

    public c0(long r1, String r10, int r11, String r12, String r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }
}
