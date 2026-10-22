package com.bytedance.android.livesdk.interactivity.seek.v2;

import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements amc.i {
    public g() {
    }

    public final lmc.h c() {
        return null;
    }

    public final boolean enable() {
        return true;
    }

    public final String e() {
        return "https://" + k.n(IHostNetwork.class).getHostDomain() + "/webcast/im/gw/uplink/message/";
    }

    public final long a() {
        return ac2.k.a();
    }

    public final boolean b() {
        return ac2.k.d();
    }

    public final boolean d() {
        return ac2.k.b();
    }
}
