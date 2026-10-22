package com.larus.vesdk.impl;

import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VELogProtocol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f implements VELogProtocol {
    public final /* synthetic */ boolean a;

    public f(boolean r1) {
        this.a = r1;
    }

    public final void logToLocal(int r3, String r4) {
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L11;
        FLogger.a.w("VE_SDK_LOG", r4);
        return;
    L11:
        if (r3 != 4) goto L32;
        FLogger.a.e("VE_SDK_LOG", r4);
        return;
    L32:
        return;
    L16:
        if (this.a == false) goto L27;
        FLogger.a.i("VE_SDK_LOG", r4);
        return;
    L27:
        return;
    L19:
        if (this.a == false) goto L29;
        FLogger.a.d("VE_SDK_LOG", r4);
        return;
    L29:
        return;
    L22:
        if (this.a == false) goto L31;
        FLogger.a.v("VE_SDK_LOG", r4);
        return;
    }
}
