package com.larus.bmhome.chat.detail.code;

import android.os.SystemClock;
import com.larus.im.callback.IMError;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 implements mf9.a<mf9.c> {
    public final /* synthetic */ h0 a;

    public k0(h0 r1) {
        this.a = r1;
    }

    public final void a(IMError r7) {
        Intrinsics.checkNotNullParameter(r7, "error");
        Intrinsics.checkNotNullParameter(r7, "error");
        FLogger.a.e("DeepResearchFetchCodeHelper", "get deep research code failure errorcode = " + r7.getCode() + " msg = " + r7.getTips() + ", pastTime[" + (SystemClock.elapsedRealtime() - this.a.b) + ']');
        n0 r8 = this.a.c;
        if (r8 == null) goto L6;
        r8.a();
        return;
    }

    public final void b(mf9.c r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        FLogger.a.i("DeepResearchFetchCodeHelper", "get deep research code from local");
    }

    public final void onSuccess(Object r7) {
        mf9.c r8 = (mf9.c) r7;
        Intrinsics.checkNotNullParameter(r8, "result");
        FLogger.a.i("DeepResearchFetchCodeHelper", "get deep research code success, isFinish[" + r8.b + "], pastTime[" + (SystemClock.elapsedRealtime() - this.a.b) + ']');
        if (r8.b == true) goto L12;
        h0 r0 = this.a;
        String r1 = r0.a;
        Integer r2 = r8.c;
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        List r9 = r8.a;
        com.larus.im.internal.research.d.a r4 = r0.d;
        if (r4 == null) goto L11;
        r4.a();
    L11:
        com.larus.im.e r5 = com.larus.im.c.a;
        r0.d = com.larus.im.internal.research.a.a.b(new mf9.f(r1, r3, r9, new j0(r0, r1, r3)));
        return;
    L7:
        r3 = 0;
        goto L8
    L12:
        h0 r6 = this.a;
        List r10 = r8.a;
        n0 r11 = r6.c;
        if (r11 == null) goto L15;
        r11.c(h0.a(r10), true);
    L15:
        n0 r12 = this.a.c;
        if (r12 == null) goto L20;
        r12.d();
        return;
    }
}
