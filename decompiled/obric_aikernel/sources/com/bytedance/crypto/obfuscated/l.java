package com.bytedance.crypto.obfuscated;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile l f1503c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1505b;

    public l(Context r10) {
        this.f1505b = r10;
        this.f1504a = k.a(r10);
    }

    public static i a(i r10) {
        i r11 = new i();
        r11.f1488a = r10.f1488a;
        r11.f1489b = r10.f1489b;
        r11.f1490c = r10.f1490c;
        r11.f1491d = r10.f1491d;
        r11.f1492e = r10.f1492e;
        r11.f1493f = r10.f1493f;
        r11.f1494g = r10.f1494g;
        r11.f1495h = r10.f1495h;
        r11.f1496i = r10.f1496i;
        r11.f1497j = r10.f1497j;
        r11.f1498k = r10.f1498k;
        r11.f1499l = r10.f1499l;
        r11.f1500m = r10.f1500m;
        return r11;
    }

    public static l a(Context r10) {
        if (f1503c != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1503c != null) goto L9;
        f1503c = new l(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f1503c;
    }
}
