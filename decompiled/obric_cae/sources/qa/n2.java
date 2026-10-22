package qa;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes.dex */
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f10856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short f10857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10858h;

    public n2(boolean r8) {
        this.f10853c = NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
        this.f10856f = 0;
        this.f10858h = r8;
    }

    public static long a(String r15) {
        if (r15 != null) goto L5;
    L35:
        return 0;
    L5:
        if (r15.length() == 0) goto L35;
        int r8 = r15.length() - 1;
        int r10 = 0;
        long r11 = 0;
    L8:
        if (r8 < 0) goto L32;
        long r12 = r15.charAt(r8);
        if (r12 >= 48) goto L12;
    L15:
        long r13 = 97;
        if (r12 >= 97) goto L18;
    L20:
        r13 = 65;
        if (r12 < 65) goto L26;
        if (r12 > 70) goto L26;
    L19:
        long r14 = (r12 - r13) + 10;
    L14:
        r11 = r11 + (r14 << r10);
        r10 = r10 + 4;
    L30:
        r8 = r8 - 1;
    L26:
        if (r12 == 58) goto L30;
        if (r12 == 124) goto L30;
        return 0;
    L18:
        if (r12 > 102) goto L20;
    L12:
        if (r12 > 57) goto L15;
        r14 = r12 - 48;
        goto L14
    L32:
        if (r10 == 48) goto L34;
        return 0;
    L34:
        return r11;
    }

    public static String b(long r8) {
        if (r8 >= 0) goto L5;
        return null;
    L5:
        if (r8 > 281474976710655L) goto L27;
        byte[] r10 = new byte[6];
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r12 >= 6) goto L10;
        r10[r12] = (byte) ((r8 >> (((6 - r12) - 1) * 8)) & 255);
        r12 = r12 + 1;
        goto L8
    L10:
        StringBuilder r13 = new StringBuilder();
    L11:
        if (r11 >= 6) goto L20;
        String r14 = Integer.toHexString(r10[r11] & 255);
        if (r14.length() >= 2) goto L15;
        r13.append("0");
    L15:
        r13.append(r14);
        if (r11 >= 5) goto L18;
        r13.append(BdimCategoryConstants.SEPARATOR_COLON);
    L18:
        r11 = r11 + 1;
        goto L11
    L20:
        return r13.toString();
    L27:
        return null;
    }

    public final Object clone() {
        boolean r8 = this.f10858h;
        n2 r10 = new n2(r8);
        r10.f10851a = this.f10851a;
        r10.f10852b = this.f10852b;
        r10.f10853c = this.f10853c;
        r10.f10854d = this.f10854d;
        r10.f10855e = this.f10855e;
        r10.f10856f = this.f10856f;
        r10.f10857g = this.f10857g;
        r10.f10858h = r8;
        return r10;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f10851a + ", ssid='" + this.f10852b + "', rssi=" + this.f10853c + ", frequency=" + this.f10854d + ", timestamp=" + this.f10855e + ", lastUpdateUtcMills=" + this.f10856f + ", freshness=" + this.f10857g + ", connected=" + this.f10858h + '}';
    }
}
