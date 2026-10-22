package com.loc;

import android.net.wifi.WifiInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WifiInfo f5483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5484b;
    private String c;
    private int d;

    public ef(WifiInfo r2) {
        this.d = -1;
        this.f5483a = r2;
    }

    public final String a() {
        if (this.c != null) goto L6;
        this.c = ed.a(this.f5483a);
    L6:
        return this.c;
    }

    public final String b() {
        if (this.f5484b != null) goto L6;
        this.f5484b = ed.b(this.f5483a);
    L6:
        return this.f5484b;
    }

    public final int c() {
        if (this.d != (-1)) goto L6;
        this.d = ed.c(this.f5483a);
    L6:
        return this.d;
    }

    public final boolean d() {
        if (this.f5483a != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(b()) == false) goto L9;
        return false;
    L9:
        if (fd.a(a()) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
