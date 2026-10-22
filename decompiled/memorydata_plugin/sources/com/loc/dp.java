package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes3.dex */
public final class dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    es f5456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f5457b;
    long c;
    int d;
    long e;
    AMapLocation f;
    long g;
    private boolean h;

    public dp() {
        this.f5456a = null;
        this.f5457b = 0;
        this.c = 0;
        this.h = true;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = 0;
    }

    private es b(es r3) {
        if (fd.a(r3) == true) goto L5;
    L15:
        return r3;
    L5:
        if (this.h == true) goto L7;
    L13:
        int r2 = this.d;
    L14:
        r3.setLocationType(r2);
        goto L15
    L7:
        if (eu.a(r3.getTime()) == false) goto L13;
        if (r3.getLocationType() != 5) goto L11;
    L12:
        r2 = 4;
        goto L14
    L11:
        if (r3.getLocationType() != 6) goto L15;
        goto L12
    }

    public final AMapLocation a(AMapLocation r6) {
        if (fd.a(r6) == true) goto L5;
        return r6;
    L5:
        long r0 = fd.b() - this.g;
        this.g = fd.b();
        if (r0 <= 5000) goto L8;
        return r6;
    L8:
        AMapLocation r1 = this.f;
        if (r1 != null) goto L13;
        this.f = r6;
        return r6;
    L13:
        if (1 == r1.getLocationType()) goto L19;
        if ("gps".equalsIgnoreCase(this.f.getProvider()) == true) goto L19;
        this.f = r6;
        return r6;
    L19:
        if (this.f.getAltitude() == r6.getAltitude()) goto L21;
    L24:
        long r2 = Math.abs(r6.getTime() - this.f.getTime());
        if (30000 >= r2) goto L29;
        this.f = r6;
        return r6;
    L29:
        if (fd.a(r6, this.f) > (((((this.f.getSpeed() + r6.getSpeed()) * r2) / 2000.0f) + ((this.f.getAccuracy() + r6.getAccuracy()) * 2.0f)) + 3000.0f)) goto L31;
        this.f = r6;
        return r6;
    L31:
        return this.f;
    L21:
        if (this.f.getLongitude() != r6.getLongitude()) goto L24;
        this.f = r6;
        return r6;
    }

    public final es a(es r21) {
        if ((fd.b() - this.e) <= 30000) goto L6;
        this.f5456a = r21;
        this.e = fd.b();
        return this.f5456a;
    L6:
        this.e = fd.b();
        if (fd.a(this.f5456a) == true) goto L9;
    L91:
        this.f5457b = fd.b();
        this.f5456a = r21;
        return r21;
    L9:
        if (fd.a(r21) == false) goto L91;
        if (r21.getTime() != this.f5456a.getTime()) goto L17;
        if (r21.getAccuracy() >= 300.0f) goto L17;
        return r21;
    L17:
        if ("gps".equals(r21.getProvider()) == false) goto L21;
        this.f5457b = fd.b();
        this.f5456a = r21;
        return r21;
    L21:
        if (r21.c() == this.f5456a.c()) goto L25;
        this.f5457b = fd.b();
        this.f5456a = r21;
        return r21;
    L25:
        if (r21.getBuildingId() != null) goto L27;
    L32:
        this.d = r21.getLocationType();
        float r2 = fd.a(r21, this.f5456a);
        float r6 = this.f5456a.getAccuracy();
        float r7 = r21.getAccuracy();
        float r8 = r7 - r6;
        long r9 = fd.b();
        long r11 = r9 - this.f5457b;
        boolean r15 = true;
        if (r6 <= 100.0f) goto L35;
    L37:
        boolean r14 = false;
    L39:
        if (r6 > 299.0f) goto L41;
    L43:
        r15 = false;
    L45:
        if (r14 == true) goto L82;
        if (r15 == true) goto L82;
        if (r7 >= 100.0f) goto L54;
        if (r6 <= 299.0f) goto L54;
        this.f5457b = r9;
        this.f5456a = r21;
        this.c = 0;
        return r21;
    L54:
        if (r7 > 299.0f) goto L57;
        this.c = 0;
    L57:
        if (r2 >= 10.0f) goto L73;
        if (r2 <= 0.1d) goto L73;
        if (r7 <= 5.0f) goto L73;
        if (r8 < (-300.0f)) goto L67;
        es r1 = b(this.f5456a);
        this.f5456a = r1;
        return r1;
    L67:
        if ((r6 / r7) < 2.0f) goto L70;
        this.f5457b = r9;
        this.f5456a = r21;
        return r21;
    L70:
        es r3 = b(this.f5456a);
        this.f5456a = r3;
        return r3;
    L73:
        if (r8 >= 300.0f) goto L75;
        this.f5457b = fd.b();
        this.f5456a = r21;
        return r21;
    L75:
        if (r11 < 30000) goto L78;
        this.f5457b = fd.b();
        this.f5456a = r21;
        return r21;
    L78:
        es r4 = b(this.f5456a);
        this.f5456a = r4;
        return r4;
    L82:
        long r5 = this.c;
        if (r5 != 0) goto L86;
        this.c = r9;
    L89:
        es r10 = b(this.f5456a);
        this.f5456a = r10;
        return r10;
    L86:
        if ((r9 - r5) <= 30000) goto L89;
        this.f5457b = r9;
        this.f5456a = r21;
        this.c = 0;
        return r21;
    L41:
        if (r7 <= 299.0f) goto L43;
    L35:
        if (r7 <= 299.0f) goto L37;
        r14 = true;
        goto L39
    L27:
        if (r21.getBuildingId().equals(this.f5456a.getBuildingId()) == true) goto L32;
        if (TextUtils.isEmpty(r21.getBuildingId()) == true) goto L32;
        this.f5457b = fd.b();
        this.f5456a = r21;
        return r21;
    }

    public final void a() {
        this.f5456a = null;
        this.f5457b = 0;
        this.c = 0;
        this.f = null;
        this.g = 0;
    }

    public final void a(boolean r1) {
        this.h = r1;
    }
}
