package com.tom_roush.harmony.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f16041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16042b;
    private ArrayList<byte[]> c;

    public d() {
        this.f16042b = 0;
        this.c = new ArrayList();
    }

    private void b(long r5) {
        int r0 = (((int) (r5 >> 9)) - this.c.size()) + 1;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.c.add(new byte[512]);
        r1 = r1 + 1;
        goto L3
    L5:
        this.f16041a = r5 + 1;
    }

    public int a(long r3) {
        if (r3 < this.f16041a) goto L7;
        return -1;
    L7:
        return ((byte[]) ZeusTransformUtils.preCheckCast(this.c.get((int) (r3 >> 9)), byte[].class, "com.obric.memorydata.plugin"))[(int) (r3 & 511)] & 255;
    }

    public int a(InputStream r8, int r9) {
        if (r9 > 0) goto L5;
        return 0;
    L5:
        long r1 = this.f16041a;
        b((((long) r9) + r1) - 1);
        int r3 = (int) (r1 >> 9);
        int r2 = (int) (r1 & 511);
        int r4 = 0;
    L6:
        if (r9 <= 0) goto L15;
        byte[] r5 = (byte[]) ZeusTransformUtils.preCheckCast(this.c.get(r3), byte[].class, "com.obric.memorydata.plugin");
        int r6 = Math.min(512 - r2, r9);
        r9 = r9 - r6;
        r4 = r4 + r6;
    L8:
        if (r6 <= 0) goto L14;
        int r7 = r8.read(r5, r2, r6);
        if (r7 < 0) goto L11;
        r6 = r6 - r7;
        r2 = r2 + r7;
        goto L8
    L11:
        this.f16041a -= (long) (r9 - r4);
        return r4;
    L14:
        r3 = r3 + 1;
        r2 = 0;
        goto L6
    L15:
        return r4;
    }

    public int a(byte[] r5, int r6, int r7, long r8) {
        if (r7 > (r5.length - r6)) goto L19;
        if (r7 < 0) goto L19;
        if (r6 < 0) goto L19;
        if (r7 != 0) goto L9;
        return 0;
    L9:
        long r0 = this.f16041a;
        if (r8 < r0) goto L14;
        return -1;
    L14:
        if ((((long) r7) + r8) <= r0) goto L16;
        r7 = (int) (r0 - r8);
    L16:
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(this.c.get((int) (r8 >> 9)), byte[].class, "com.obric.memorydata.plugin");
        int r9 = (int) (r8 & 511);
        int r10 = Math.min(r7, 512 - r9);
        System.arraycopy(r4, r9, r5, r6, r10);
        return r10;
    L19:
        throw new IndexOutOfBoundsException();
    }

    public long a() {
        return this.f16041a;
    }

    public void b() {
        this.c.clear();
        this.f16041a = 0;
    }
}
