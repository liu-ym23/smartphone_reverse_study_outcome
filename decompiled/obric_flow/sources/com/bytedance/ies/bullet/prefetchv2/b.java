package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f5836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f5837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5838c;

    public b(Uri r5, f r10, String r11) {
        this.f5836a = r5;
        this.f5837b = r10;
        this.f5838c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r5 = System.nanoTime();
        a r10 = a.f5833a;
        Uri r11 = this.f5836a;
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);
        final f r12 = this.f5837b;
        Intrinsics.checkNotNullParameter(r12, "config");
        String r13 = this.f5838c;
        Intrinsics.checkNotNullParameter(r13, "bid");
        String r14 = a.b(r10, r11);
        c.h("Put config cache by url: " + r11 + ", configKey: " + r14);
        a.f5834b.put(r14, r12);
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r13, "bid");
        Lazy r15 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r16 = av.i.e();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r11, "url");
        Uri r17 = (Uri) new vd.a(r16.a(r13, r11, false), "url", 8).f22372b;
        if (r17 == null) goto L6;
        String r18 = new ad.a(r17).a();
        if (r18 == null) goto L6;
    L7:
        c.h("Put config cache by identifier: " + r18);
        a.f5835c.put(r18, r12);
        final long r19 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r5);
        c.i(new InternalConfigLoader$loadConfigFromRL$2$1(r12, r19));
        return;
    L6:
        r18 = r11.toString();
        goto L7
    }
}
