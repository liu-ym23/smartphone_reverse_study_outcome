package com.bytedance.android.live.revlink.impl.multianchor.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorLinkOptUtils {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final com.bytedance.android.livesdk.revenue.service.room.c d;

    public final r11.b b() {
        return (r11.b) this.b.getValue();
    }

    public final boolean c() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    public final boolean a() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.d;
        if (r0 == null) goto L15;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L15;
        if (r1.getCommonIsAnchor() != true) goto L15;
        if (c() == true) goto L11;
        return false;
    L11:
        if (b().h0() == false) goto L21;
        return true;
    L21:
        return false;
    L15:
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L17;
        return false;
    L17:
        if (b().h0() == false) goto L23;
        return true;
    L23:
        return false;
    }

    public final boolean e() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.d;
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L11;
        if (r1.getCommonIsAnchor() != true) goto L11;
        return c();
    L11:
        return b().C6();
    }

    public final boolean d() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (b().o1() == false) goto L7;
        return true;
    }

    public AnchorLinkOptUtils(com.bytedance.android.livesdk.revenue.service.room.c r1) {
        this.d = r1;
        this.a = LazyKt.lazy(AnchorLinkOptUtils$enable$2.INSTANCE);
        this.b = LazyKt.lazy(AnchorLinkOptUtils$config$2.INSTANCE);
        this.c = LazyKt.lazy(AnchorLinkOptUtils$audienceOpt$2.INSTANCE);
    }
}
