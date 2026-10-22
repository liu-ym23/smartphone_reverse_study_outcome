package com.larus.dora.impl.log;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import kotlin.jvm.internal.Intrinsics;
import t39.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i$a implements u {
    public i$a() {
    }

    public final void b() {
        DoraLogManager r0 = DoraLogManager.a;
    }

    public final void a(boolean r9, String r10, final String r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        DoraLogManager r1 = DoraLogManager.a;
        g49.d.d("DoraLogManager", "autoGetLogCallback onGetLogResult, success " + r9 + ", msg " + r10);
        DoraLogManager r14 = DoraLogManager.a;
        if (r13 == 2) goto L5;
        g49.d.d("DoraLogManager", "onAutoGetLogResult ban startUploadLog " + r11 + ". success: " + r9 + ", curLogType: " + r13);
        final String r15 = DoraLogManager.q(r13);
        m r2 = new m(r11);
        Intrinsics.checkNotNullParameter(r11, "filePath");
        Intrinsics.checkNotNullParameter(r15, "logType");
        Intrinsics.checkNotNullParameter(r2, "callback");
        DoraLogManager.g = r2;
        DoraLogManager.z(new b(r11, r15));
    L5:
        if (r12 == true) goto L34;
        boolean r16 = true;
        if (r9 == false) goto L27;
        int r17 = DoraLogManager.v;
        if (r17 != 1) goto L13;
        DoraLogManager.k(2, 0, false);
        return;
    L13:
        if (r17 == 2) goto L15;
        if (r17 != 3) goto L32;
        DoraLogManager.k(2, 14400000, false);
        return;
    L32:
        return;
    L15:
        if (DoraConfig.a.getBoolean("key_enable_auto_get_buds_log", !AppHost.a.isDebug()) == false) goto L19;
        if ((System.currentTimeMillis() - ((Keva) DoraLogManager.h.getValue()).getLong(DoraLogManager.n().concat("_GetLogTime"), 0)) < 115200000) goto L19;
    L22:
        if (r16 == false) goto L24;
        DoraLogManager.k(3, 0, false);
        DoraLogManager.w = false;
        return;
    L24:
        DoraLogManager.k(2, 14400000, false);
        return;
    L19:
        if (DoraLogManager.w == true) goto L22;
        r16 = false;
        goto L22
    L27:
        DoraLogManager.k(DoraLogManager.v, 300000, true);
        return;
    }
}
