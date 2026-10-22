package com.larus.dora.impl.guide.strategy;

import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.util.b0;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final String a;
    public final List<String> b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    public final Object a() {
        if (this.c == false) goto L18;
        g49.d.d("ChannelStrategy", "channel strategy blocked: already hit, key=" + this.a);
        return Boxing.boxBoolean(false);
    L18:
        b0.a.getClass();     // Catch: Exception -> L8
        boolean r0 = b0.j().getBoolean(this.a, false);     // Catch: Exception -> L8
    L10:
        if (r0 == false) goto L13;
        g49.d.d("ChannelStrategy", "channel strategy blocked: already consumed, key=" + this.a);
        return Boxing.boxBoolean(false);
    L13:
        List<String> r1 = this.b;
        AppHost.Companion r2 = AppHost.a;
        boolean r3 = r1.contains(r2.getBuildChannel());
        g49.d.d("ChannelStrategy", "channel check: channel=" + r2.getBuildChannel() + ", targets=" + this.b + ", allowed=" + r3);
        if (r3 == false) goto L17;
        this.c = true;
        g49.d.d("ChannelStrategy", "channel strategy hit set to true, key=" + this.a);
    L17:
        return Boxing.boxBoolean(r3);
    L8:
        e = move-exception;
        g49.d.c("ChannelStrategy", "read consumed flag failed for key=" + this.a + ", error=" + e.getMessage(), e);
        r0 = false;
        goto L10
    }

    public final Unit b() {
    L8:
        e = move-exception;
        g49.d.c("ChannelStrategy", "markAsShown failed for key=" + this.a + ", error=" + e.getMessage(), e);
    L11:
        return Unit.INSTANCE;
    L4:
        if (this.c == false) goto L6;
        b0.a.getClass();     // Catch: Exception -> L8
        b0.j().storeBoolean(this.a, true);     // Catch: Exception -> L8
        g49.d.d("ChannelStrategy", "markAsShown success, key=" + this.a);     // Catch: Exception -> L8
    L12:
        goto L11
    L6:
        g49.d.d("ChannelStrategy", "markAsShown skipped: not consumed, key=" + this.a);     // Catch: Exception -> L8
        goto L12
    }

    public b(String r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "kevaKey");
        Intrinsics.checkNotNullParameter(r3, "targetChannels");
        this.a = r2;
        this.b = r3;
    }
}
