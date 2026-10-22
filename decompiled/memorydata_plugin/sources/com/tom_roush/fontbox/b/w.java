package com.tom_roush.fontbox.b;

import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15950b;
    private List<Object> c;
    private final String d;
    private final String e;

    public w(String r3, int r4) {
        this.f15949a = 0;
        this.f15950b = 0;
        this.c = null;
        this.d = r3;
        this.e = String.format(Locale.US, "%04x", new Object[]{Integer.valueOf(r4)});
    }

    public w(String r2, String r3) {
        this.f15949a = 0;
        this.f15950b = 0;
        this.c = null;
        this.d = r2;
        this.e = r3;
    }

    private int a() {
        int r0 = this.f15949a + this.f15950b;
        int r1 = r0 / 8;
        if ((r0 % 8) > 0) goto L5;
        return r1;
    L5:
        return r1 + 1;
    }

    private p a(int r6, r r7) {
        int r2 = 1;
        if (r6 != 1) goto L5;
    L14:
        this.f15949a += b().size() / 2;
    L16:
        if (r6 == 12) goto L18;
        if (r6 == 19) goto L24;
        if (r6 == 20) goto L24;
        return new p(r6);
    L24:
        int r5 = a() + 1;
        int[] r0 = new int[r5];
        r0[0] = r6;
    L25:
        if (r2 >= r5) goto L28;
        r0[r2] = r7.h();
        r2 = r2 + 1;
        goto L25
    L28:
        return new p(r0);
    L18:
        return new p(r6, r7.h());
    L5:
        if (r6 == 18) goto L14;
        if (r6 == 3) goto L13;
        if (r6 == 19) goto L13;
        if (r6 == 20) goto L13;
        if (r6 != 23) goto L16;
    L13:
        this.f15950b += b().size() / 2;
        goto L16
    }

    private List<Object> a(byte[] r17, byte[][] r18, byte[][] r19, boolean r20) {
        if (r20 == false) goto L5;
        this.f15949a = 0;
        this.f15950b = 0;
        this.c = new ArrayList();
    L5:
        r r4 = new r(r17);
        if (r19 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r18 != null) goto L13;
    L15:
        boolean r7 = false;
    L17:
        if (r4.e() == false) goto L68;
        int r8 = r4.h();
        int r12 = 32768;
        if (r8 != 10) goto L34;
        if (r6 == false) goto L34;
        List<Object> r9 = this.c;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r9.remove(r9.size() - 1), Integer.class, "com.obric.memorydata.plugin");
        int r11 = r19.length;
        if (r11 >= 1240) goto L24;
        r12 = 107;
    L26:
        int r13 = r12 + r10.intValue();
        if (r13 >= r19.length) goto L17;
        a(r19[r13], r18, r19, false);
        List<Object> r14 = this.c;
        Object r15 = r14.get(r14.size() - 1);
        if (ZeusTransformUtils.instanceOf(r15, p.class) == false) goto L17;
        if (((p) ZeusTransformUtils.preCheckCast(r15, p.class, "com.obric.memorydata.plugin")).a().a()[0] != 11) goto L17;
    L32:
        List<Object> r16 = this.c;
        r16.remove(r16.size() - 1);
        goto L17
    L24:
        if (r11 >= 33900) goto L26;
        r12 = 1131;
    L34:
        if (r8 != 29) goto L48;
        if (r7 == false) goto L48;
        List<Object> r21 = this.c;
        Integer r22 = (Integer) ZeusTransformUtils.preCheckCast(r21.remove(r21.size() - 1), Integer.class, "com.obric.memorydata.plugin");
        int r23 = r18.length;
        if (r23 >= 1240) goto L39;
        r12 = 107;
    L41:
        int r110 = r12 + r22.intValue();
        if (r110 >= r18.length) goto L17;
        a(r18[r110], r18, r19, false);
        List<Object> r24 = this.c;
        Object r25 = r24.get(r24.size() - 1);
        if (ZeusTransformUtils.instanceOf(r25, p.class) == false) goto L17;
        if (((p) ZeusTransformUtils.preCheckCast(r25, p.class, "com.obric.memorydata.plugin")).a().a()[0] != 11) goto L17;
    L39:
        if (r23 >= 33900) goto L41;
        r12 = 1131;
    L48:
        if (r8 < 0) goto L53;
        if (r8 > 27) goto L53;
    L51:
        List<Object> r26 = this.c;
        Object r27 = a(r8, r4);
    L55:
        r26.add(r27);
    L53:
        if (r8 != 28) goto L56;
    L54:
        r26 = this.c;
        r27 = b(r8, r4);
        goto L55
    L56:
        if (r8 < 29) goto L61;
        if (r8 <= 31) goto L51;
    L61:
        if (r8 < 32) goto L66;
        if (r8 <= 255) goto L54;
    L66:
        throw new IllegalArgumentException();
    L68:
        return this.c;
    L13:
        if (r18.length <= 0) goto L15;
        r7 = true;
        goto L17
    L8:
        if (r19.length <= 0) goto L10;
        r6 = true;
        goto L11
    }

    private Number b(int r3, r r4) {
        if (r3 != 28) goto L7;
        return Integer.valueOf(r4.i());
    L7:
        if (r3 < 32) goto L13;
        if (r3 > 246) goto L13;
        return Integer.valueOf(r3 + NetError.ERR_TEMPORARILY_THROTTLED);
    L13:
        if (r3 < 247) goto L19;
        if (r3 > 250) goto L19;
        return Integer.valueOf((((r3 - 247) * 256) + r4.h()) + 108);
    L19:
        if (r3 < 251) goto L25;
        if (r3 > 254) goto L25;
        return Integer.valueOf((((-(r3 - 251)) * 256) - r4.h()) + NetError.ERR_ADDRESS_INVALID);
    L25:
        if (r3 != 255) goto L29;
        return Double.valueOf(r4.i() + (((double) r4.j()) / 65535.0d));
    L29:
        throw new IllegalArgumentException();
    }

    private List<Number> b() {
        ArrayList r0 = new ArrayList();
        int r1 = this.c.size();
    L3:
        r1 = r1 - 1;
        if (r1 <= (-1)) goto L9;
        Object r2 = this.c.get(r1);
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L7;
        r0.add(0, (Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin"));
        goto L3
    L7:
        return r0;
    L9:
        return r0;
    }

    public List<Object> a(byte[] r2, byte[][] r3, byte[][] r4) {
        return a(r2, r3, r4, true);
    }
}
