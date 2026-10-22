package com.bytedance.android.live.broadcastgame.api.xplay;

import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public final String a;
    public boolean b;
    public Map<String, String> c;
    public final String d;
    public final boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public XplayGuestType i;
    public boolean j;
    public Long k;

    public s(boolean r7, boolean r8, Long r9, int r11) {
        String r2 = "";
        if ((r11 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r11 & 4) == 0) goto L9;
        Map<String, String> r3 = MapsKt.emptyMap();
    L11:
        if ((r11 & 8) != 0) goto L15;
        r2 = null;
    L15:
        if ((r11 & 64) == 0) goto L18;
        r7 = false;
    L18:
        if ((r11 & 128) == 0) goto L21;
        r8 = false;
    L21:
        if ((r11 & 256) == 0) goto L23;
        XplayGuestType r4 = XplayGuestType.DEFAULT;
    L25:
        if ((r11 & RomUtils.SZ) == 0) goto L27;
        r9 = null;
    L27:
        Intrinsics.checkNotNullParameter(r0, "toolbarSchema");
        Intrinsics.checkNotNullParameter(r3, "extraToServer");
        Intrinsics.checkNotNullParameter(r2, "openId");
        Intrinsics.checkNotNullParameter(r4, "roomGuestType");
        this.a = r0;
        this.b = false;
        this.c = r3;
        this.d = r2;
        this.e = false;
        this.f = false;
        this.g = r7;
        this.h = r8;
        this.i = r4;
        this.j = false;
        this.k = r9;
        return;
    L23:
        r4 = null;
        goto L25
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
