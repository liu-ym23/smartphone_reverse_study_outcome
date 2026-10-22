package com.lynx.tasm.fontface;

import android.os.Handler;
import android.util.Pair;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import java.util.Iterator;
import zm.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f10864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f10865c;

    public e(b r5, Handler r10, i r11) {
        this.f10863a = 1;
        this.f10864b = r5;
        this.f10865c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10863a) {
            case 0: goto L16;
            default: goto L4;
        };
    L4:
        Iterator r5 = this.f10864b.f10855a.iterator();
    L6:
        if (r5.hasNext() == false) goto L15;
        Pair r10 = (Pair) r5.next();
        r5.remove();
        Object r11 = r10.first;
        if (r11 == null) goto L6;
        f0 r12 = (f0) r11;
        Integer r13 = (Integer) r10.second;
        if (r13 != null) goto L13;
        int r14 = 0;
    L14:
        LynxLog.b(2, "FontFaceManager", "Lynx load font success.");
        r12.b(this.f10865c.a(r14), r14);
        goto L6
    L13:
        r14 = r13.intValue();
        goto L14
    L15:
        return;
    L16:
        Iterator r15 = this.f10864b.f10855a.iterator();
    L18:
        if (r15.hasNext() == false) goto L23;
        Pair r16 = (Pair) r15.next();
        r15.remove();
        if (r16.first == null) goto L18;
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, "load font success");
        f0 r17 = (f0) r16.first;
        int r18 = ((Integer) r16.second).intValue();
        r17.b(this.f10865c.a(r18), ((Integer) r16.second).intValue());
        goto L18
    }

    public e(b r5, i r10, Handler r11) {
        this.f10863a = 0;
        this.f10864b = r5;
        this.f10865c = r10;
    }
}
