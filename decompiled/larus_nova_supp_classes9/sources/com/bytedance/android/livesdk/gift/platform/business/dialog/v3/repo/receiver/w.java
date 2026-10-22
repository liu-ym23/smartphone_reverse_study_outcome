package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.livesdk.gift.configmodel.v0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w {
    public static boolean a() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(k.class));
    L6:
        k r2 = (k) r1;
        if (r2 == null) goto L9;
        int r3 = r2.d();
    L11:
        if (d0.a(r3, 4) == false) goto L13;
    L23:
        boolean r4 = false;
    L25:
        if (((v0) nz1.b.e.getValue(null, nz1.b.a[3])).getEnable() == false) goto L29;
        if (r4 == false) goto L30;
        return true;
    L30:
        return false;
    L29:
        return false;
    L13:
        if (d0.a(r3, 1024) == true) goto L23;
        if (d0.a(r3, 2) == false) goto L17;
    L22:
        r4 = true;
        goto L25
    L17:
        if (d0.a(r3, 8) == true) goto L22;
        IRoomBase r5 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r5 == null) goto L23;
        if (x12.a.b(r5) != true) goto L23;
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    static {
    }
}
