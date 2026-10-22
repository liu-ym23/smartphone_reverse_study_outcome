package n4a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v2 {
    public long a;
    public String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public short g;
    public boolean h;

    public v2(boolean r3) {
        this.c = -113;
        this.f = 0;
        this.h = r3;
    }

    public static long a(String r15) {
        if (r15 != null) goto L5;
    L35:
        return 0;
    L5:
        if (r15.length() == 0) goto L35;
        int r2 = r15.length() - 1;
        int r3 = 0;
        long r4 = 0;
    L8:
        if (r2 < 0) goto L32;
        long r6 = r15.charAt(r2);
        if (r6 >= 48) goto L12;
    L15:
        long r10 = 97;
        if (r6 >= 97) goto L18;
    L20:
        r10 = 65;
        if (r6 < 65) goto L26;
        if (r6 > 70) goto L26;
    L19:
        long r7 = (r6 - r10) + 10;
    L14:
        r4 = r4 + (r7 << r3);
        r3 = r3 + 4;
    L30:
        r2 = r2 - 1;
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
        if (r3 == 48) goto L34;
        return 0;
    L34:
        return r4;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.a + ", ssid='" + this.b + "', rssi=" + this.c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + this.g + ", connected=" + this.h + '}';
    }

    public final Object clone() throws CloneNotSupportedException {
        boolean r1 = this.h;
        v2 r0 = new v2(r1);
        r0.a = this.a;
        r0.b = this.b;
        r0.c = this.c;
        r0.d = this.d;
        r0.e = this.e;
        r0.f = this.f;
        r0.g = this.g;
        r0.h = r1;
        return r0;
    }

    public static String b(long r8) {
        if (r8 >= 0) goto L5;
        return null;
    L5:
        if (r8 > 281474976710655L) goto L27;
        byte[] r1 = new byte[6];
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r3 >= 6) goto L10;
        r1[r3] = (byte) ((r8 >> (((6 - r3) - 1) * 8)) & 255);
        r3 = r3 + 1;
        goto L8
    L10:
        StringBuilder r9 = new StringBuilder();
    L11:
        if (r2 >= 6) goto L20;
        String r10 = Integer.toHexString(r1[r2] & 255);
        if (r10.length() >= 2) goto L15;
        r9.append("0");
    L15:
        r9.append(r10);
        if (r2 >= 5) goto L18;
        r9.append(":");
    L18:
        r2 = r2 + 1;
        goto L11
    L20:
        return r9.toString();
    L27:
        return null;
    }
}
