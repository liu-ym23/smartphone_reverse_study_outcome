package com.bytedance.geckox.utils;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f4788b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f4789c = null;
    public static final b d = null;
    public static final b e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4790a;

    static {
        f4788b = new b(0);
        f4789c = new b(1);
        d = new b(2);
        e = new b(3);
    }

    public /* synthetic */ b(int r5) {
        this.f4790a = r5;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        switch(this.f4790a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Thread r10 = new Thread(r5);
        r10.setName("gecko-io-thread");
        r10.setPriority(3);
        return r10;
    L6:
        Thread r11 = new Thread(r5);
        r11.setName("gecko-check-update-thread");
        r11.setPriority(3);
        return r11;
    L8:
        Thread r12 = new Thread(r5);
        r12.setName("gecko-callback-thread");
        r12.setPriority(3);
        return r12;
    L10:
        Thread r13 = new Thread(r5);
        r13.setName("gecko-access-thread");
        r13.setPriority(3);
        return r13;
    }
}
