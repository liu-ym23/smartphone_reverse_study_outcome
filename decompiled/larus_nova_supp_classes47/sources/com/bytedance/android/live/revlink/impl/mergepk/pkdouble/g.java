package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.w2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public o9 a;
    public p b;
    public final PkDoubleAnchorDataContext.d c;
    public final int d;
    public int e;
    public final w2 f;
    public final boolean g;
    public final IBattleConfigSetting h;
    public p0 i;

    public g(PkDoubleAnchorDataContext.d r6, int r7, w2 r8, boolean r9, IBattleConfigSetting r10, int r12) {
        if ((r12 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r12 & 16) == 0) goto L8;
        r7 = 0;
    L8:
        String r3 = "";
        if ((r12 & 32) == 0) goto L11;
        Object r0 = "";
    L13:
        if ((r12 & 64) != 0) goto L17;
        r3 = null;
    L17:
        if ((r12 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L20;
        r8 = null;
    L20:
        if ((r12 & 4096) == 0) goto L23;
        r9 = false;
    L23:
        if ((r12 & 8192) == 0) goto L25;
        r10 = null;
    L25:
        Intrinsics.checkNotNullParameter(r0, "linkmicID");
        Intrinsics.checkNotNullParameter(r3, "linkConnectionType");
        this.a = null;
        this.b = null;
        this.c = r6;
        this.d = r7;
        this.e = 0;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = null;
        return;
    L11:
        r0 = null;
        goto L13
    }
}
