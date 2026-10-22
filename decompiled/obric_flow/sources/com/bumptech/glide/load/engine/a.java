package com.bumptech.glide.load.engine;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1439a;

    public /* synthetic */ a(int r5) {
        this.f1439a = r5;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        switch(this.f1439a) {
            case 0: goto L15;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        Thread r10 = new Thread(r5);
        r10.setName("gecko-update-thread");
        r10.setPriority(3);
        return r10;
    L8:
        Thread r11 = new Thread(r5);
        Process.setThreadPriority(-20);
        r11.setName("lock_stack_fetch");
        return r11;
    L10:
        Thread r12 = new Thread(r5);
        r12.setName("lock_handler_time");
        return r12;
    L12:
        Thread r13 = new Thread(r5);
        r13.setName("launch_sleep_detector");
        return r13;
    L5:
        return new Thread(r5, "Apm_Normal");
    L15:
        return new Thread(new c1.a(r5, 1, false), "glide-active-resources");
    }
}
