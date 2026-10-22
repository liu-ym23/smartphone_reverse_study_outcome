package com.bytedance.android.live.anchormodelink.livelink;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import kotlin.jvm.internal.Intrinsics;
import ny.o;
import yb6.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements f {
    public final /* synthetic */ LiveLinkWrapper a;
    public final /* synthetic */ String b;
    public final /* synthetic */ o c;

    public final ec6.a O2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "liveCoreSetting");
        Object r4 = this.a.u.u4(r3, this.c);
        if ((r4 instanceof ec6.a) == true) goto L6;
        r4 = null;
    L6:
        return (ec6.a) r4;
    }

    public c(LiveLinkWrapper r1, o r2) {
        this.a = r1;
        this.b = "Lynx JSB";
        this.c = r2;
    }

    public final void lf(long r8, Throwable r11) {
        Intrinsics.checkNotNullParameter(r11, "throwable");
        LinkMonitor.a(this.a.a, "startInitLiveClient", "OnLiveClientInitFailed " + r11, null, null, true, 56);
    }

    public final void u4(long r8, ec6.a r11) {
        Intrinsics.checkNotNullParameter(r11, "client");
        LinkMonitor.a(this.a.a, "startInitLiveClient", "[source] " + this.b + " [duration] OnLiveClientInitSuccess " + r8, null, null, true, 56);
        InteractLinkFullLinkMonitor.k(r8);
    }
}
