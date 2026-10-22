package com.bytedance.ai.model;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2253b;

    public /* synthetic */ l(Object r5, int r10) {
        this.f2252a = r10;
        this.f2253b = r5;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        switch(this.f2252a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        z4.b r5 = (z4.b) this.f2253b;
        r5.getClass();
        int r10 = 4;
        r5.f23394c.submit(new com.bytedance.iesgurd.settings.b(r10, false, r5));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L10:
        AppletRuntime r11 = (AppletRuntime) this.f2253b;
        if (r11.f2205p.get() == false) goto L21;
        r11.f2205p.set(false);
        String r12 = ug.a.c(new StringBuilder(), r11.f2197h.F, " cancel alive", "WorkerRuntime");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L16;
        r13.d("WorkerRuntime", r12);
    L16:
        r11.h();
        return;
    }
}
