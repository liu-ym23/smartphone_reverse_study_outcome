package com.bytedance.android.live.core.privacy.av.impl;

import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements Runnable {
    public final /* synthetic */ AudioAndVideoCallbackSystemImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ String d;

    public a(AudioAndVideoCallbackSystemImpl r1, String r2, Map r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        long r8 = System.currentTimeMillis() / ((long) 1000);     // Catch: Exception -> L7
        long r6 = r8 - ((long) 600);     // Catch: Exception -> L7
        IHostMonitor r5 = k.f(IHostMonitor.class);     // Catch: Exception -> L7
        if (r5 == null) goto L12;
        r5.uploadALog(r6, r8, "audio_and_video_" + this.b + '-' + this.d);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        this.a.e.b("upload alog failed:" + e.getMessage(), null);
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
