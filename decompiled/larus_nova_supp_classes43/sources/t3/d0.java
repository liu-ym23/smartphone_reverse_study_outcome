package t3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d0 {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;
    public final byte[] f;
    public final List<String> g;
    public final Map<String, byte[]> h;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r11 = (d0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (((r0 + r11) * 31) + this.d) * 31;
        if (this.e == false) goto L9;
        int r13 = 1231;
    L10:
        int r14 = (r12 + r13) * 31;
        byte[] r15 = this.f;
        if (r15 == null) goto L15;
        r10 = Arrays.hashCode(r15);
    L15:
        return ((((r14 + r10) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L9:
        r13 = 1237;
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "BluetoothDeviceSnapshot(deviceId=" + this.a + ", name=" + this.b + ", localName=" + this.c + ", RSSI=" + this.d + ", connectable=" + this.e + ", advertisData=" + Arrays.toString(this.f) + ", advertisServiceUuids=" + this.g + ", serviceData=" + this.h + ')';
    }

    public d0(String r10, String r11, String r12, int r13, boolean r14, byte[] r15, List<String> r16, Map<String, byte[]> r17) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r16, "advertisServiceUuids");
        Intrinsics.checkNotNullParameter(r17, "serviceData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
    }
}
