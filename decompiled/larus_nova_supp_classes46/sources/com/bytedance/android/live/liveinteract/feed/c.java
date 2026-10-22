package com.bytedance.android.live.liveinteract.feed;

import android.graphics.Path;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ CommonMultiLinkFeedView a;

    public c(CommonMultiLinkFeedView r1) {
        this.a = r1;
    }

    public final void a() {
        int r0 = this.a.getContainerWidth();
        int r1 = this.a.getContainerHeight();
        CommonMultiLinkFeedView r2 = this.a;
        r2.getClass();
        if ((!(r2 instanceof MultiLinkGameFeedView)) == false) goto L36;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = r2.g;
        if (r3 == null) goto L8;
        int r4 = r3.q(r1);
    L9:
        MultiLinkFrequencyOptConfig r5 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.o(r2.V, r0, r1) == false) goto L21;
        int r6 = c1.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r7 = r2.g;
        Integer r8 = null;
        if (r7 == null) goto L14;
        Integer r9 = Integer.valueOf(r7.m());
    L15:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r10 = r2.g;
        if (r10 == null) goto L19;
        r8 = Integer.valueOf(r10.getUiLayout());
    L19:
        if (c1.a(r9, r8) == true) goto L21;
        int r11 = (int) (r1 * 0.5625f);
    L22:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12 = r2.g;
        if (r12 == null) goto L25;
        float r13 = r12.s(r11, r1);
    L26:
        Path r14 = new Path();
        float r15 = r4;
        r14.addRect(0.0f, r15, r11, r15 + r13, Path.Direction.CW);
        d0 r16 = r2.D;
        if (r16 == null) goto L29;
        r16.o(r14);
    L29:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r17 = r2.g;
        if (r17 == null) goto L32;
        r2.B = r2.o(r17, r0, r1);
    L32:
        if (r11 <= 0) goto L35;
        r2.N = true;
        return;
    L35:
        return;
    L25:
        r13 = 0.0f;
        goto L26
    L14:
        r9 = null;
    L21:
        r11 = r0;
        goto L22
    L8:
        r4 = 0;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
