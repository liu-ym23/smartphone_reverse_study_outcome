package com.loc;

import com.ttnet.org.chromium.net.NetError;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public final class db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5429b;
    public int c;
    public int d;
    public long e;
    public long f;
    public short g;
    public boolean h;

    public db(boolean r3) {
        this.c = NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
        this.f = 0;
        this.h = r3;
    }

    public static long a(String r15) {
        if (r15 != null) goto L5;
    L35:
        return 0;
    L5:
        if (r15.length() == 0) goto L35;
        int r2 = 0;
        int r3 = r15.length() - 1;
        long r4 = 0;
    L8:
        if (r3 < 0) goto L32;
        long r6 = r15.charAt(r3);
        if (r6 >= 48) goto L12;
    L15:
        long r8 = 97;
        if (r6 >= 97) goto L18;
    L20:
        r8 = 65;
        if (r6 < 65) goto L26;
        if (r6 > 70) goto L26;
    L19:
        long r7 = (r6 - r8) + 10;
    L14:
        r4 = r4 + (r7 << r2);
        r2 = r2 + 4;
    L30:
        r3 = r3 - 1;
    L26:
        if (r6 == 58) goto L30;
        if (r6 == 124) goto L30;
        return 0;
    L18:
        if (r6 > 102) goto L20;
    L12:
        if (r6 > 57) goto L15;
        r7 = r6 - 48;
        goto L14
    L32:
        if (r2 == 48) goto L34;
        return 0;
    L34:
        return r4;
    }

    public static String a(long r2) {
        if (r2 >= 0) goto L5;
        return null;
    L5:
        if (r2 <= 281474976710655L) goto L8;
        return null;
    L8:
        return dj.a(dj.a(r2), ParameterizedMessage.ERROR_MSG_SEPARATOR);
    }

    private db b() {
        db r0 = new db(this.h);
        r0.f5428a = this.f5428a;
        r0.f5429b = this.f5429b;
        r0.c = this.c;
        r0.d = this.d;
        r0.e = this.e;
        r0.f = this.f;
        r0.g = this.g;
        r0.h = this.h;
        return r0;
    }

    public final String a() {
        return this.h + "#" + this.f5428a;
    }

    public final /* synthetic */ Object clone() {
        return b();
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f5428a + ", ssid='" + this.f5429b + "', rssi=" + this.c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + this.g + ", connected=" + this.h + '}';
    }
}
