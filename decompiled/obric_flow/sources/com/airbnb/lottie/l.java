package com.airbnb.lottie;

import android.content.Context;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1280c;
    public final Object d;

    public l(String r5, int r10, yf.b r11) {
        this.f1278a = 1;
        this.f1280c = r5;
        this.f1279b = r10;
        this.d = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f1278a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        long r5 = SystemClock.uptimeMillis();
        yf.b r10 = (yf.b) this.d;
        r10.e = r5;
        ConcurrentHashMap r11 = r10.f23254a;
        r11.put("scc_cloudservice_prefetch_check_delta", "-1");
        r11.put("scc_cloudservice_prefetch_ttnet_code", "-1");
        bi.e r12 = new bi.e((String) this.f1280c, 5);
        r12.e = "GET";
        r12.d = new HashMap();
        r12.f930b = this.f1279b;
        com.bytedance.salamander.anniex.n r13 = vf.a.a().a(r12);
        int r14 = r13.f7268b;
        long r15 = SystemClock.uptimeMillis() - r10.e;
        ConcurrentHashMap r16 = r10.f23254a;
        r16.put("scc_cloudservice_prefetch_check_delta", r15 + "");
        r16.put("scc_cloudservice_prefetch_ttnet_code", r14 + "");
        return r13;
    L6:
        Context r17 = (Context) ((WeakReference) this.f1280c).get();
        if (r17 != null) goto L10;
        r17 = (Context) this.d;
    L10:
        int r18 = this.f1279b;
        return n.b(r17.getResources().openRawResource(r18), n.e(r18, r17));
    L13:
        e = move-exception;
        return new a0(e);
    }

    public l(WeakReference r5, Context r10, int r11) {
        this.f1278a = 0;
        this.f1280c = r5;
        this.d = r10;
        this.f1279b = r11;
    }
}
