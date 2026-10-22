package com.bytedance.forest.model;

import ai.j0;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4371b;

    public d(int r5, com.bytedance.forest.utils.e r10) {
        this.f4370a = 0;
        super(r5);
        this.f4371b = r10;
    }

    public void b() {
        int r5 = ((ByteArrayOutputStream) this).buf.length;
        int r10 = ((ByteArrayOutputStream) this).count;
        if (r10 <= r5) goto L6;
        com.bytedance.forest.utils.d.b(((com.bytedance.forest.utils.e) this.f4371b).g, 6, ForestBuffer.TAG, "unexpected count is larger than the size of buf, count=" + ((ByteArrayOutputStream) this).count + ", bufSize=" + r5, true, null, null, 48);
        return;
    L6:
        if (r10 >= r5) goto L9;
        com.bytedance.forest.utils.d r11 = ((com.bytedance.forest.utils.e) this.f4371b).g;
        StringBuilder r12 = com.lynx.tasm.p.d(r5, "trim buf from ", " to ");
        r12.append(((ByteArrayOutputStream) this).count);
        com.bytedance.forest.utils.d.b(r11, 3, ForestBuffer.TAG, r12.toString(), true, null, null, 48);
        ((ByteArrayOutputStream) this).buf = Arrays.copyOf(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count);
        return;
    }

    public void d(int r10, byte[] r11, int r12, int r13) {
        if (r10 < 0) goto L13;
        if ((r12 + r13) <= r11.length) goto L6;
        StringBuilder r14 = j0.v("can not copy bytes from ", r12, r13, " to ", ", input bytearray size is ");
        r14.append(r11.length);
        throw new IllegalArgumentException(r14.toString());
    L6:
        if (r10 < ((ByteArrayOutputStream) this).buf.length) goto L8;
        com.bytedance.forest.utils.d r5 = ((com.bytedance.forest.utils.e) this.f4371b).g;
        StringBuilder r15 = com.lynx.tasm.p.d(r10, "startPos ", " larger than cached data size, count=");
        r15.append(((ByteArrayOutputStream) this).count);
        r15.append(", buf size=");
        r15.append(((ByteArrayOutputStream) this).buf.length);
        com.bytedance.forest.utils.d.b(r5, 6, ForestBuffer.TAG, r15.toString(), false, null, null, 48);
    L8:
        ((ByteArrayOutputStream) this).count = r10;
        write(r11, r12, r13);
        return;
    L13:
        throw new IllegalArgumentException("startPos less than zero");
    }

    public byte[] e() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int f() {
        return ((ByteArrayOutputStream) this).count;
    }

    @Override // java.io.ByteArrayOutputStream
    public String toString() {
        switch(this.f4370a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        int r5 = ((ByteArrayOutputStream) this).count;
        if (r5 > 0) goto L9;
    L16:
        return new String(((ByteArrayOutputStream) this).buf, 0, r5, ((w.d) this.f4371b).f22668b.name());
    L13:
        e = move-exception;
        throw new AssertionError(e);
    L9:
        if (((ByteArrayOutputStream) this).buf[r5 - 1] != 13) goto L16;
        r5 = r5 - 1;
        goto L16
    L5:
        return super.toString();
    }

    public d(w.d r5, int r10) {
        this.f4370a = 1;
        this.f4371b = r5;
        super(r10);
    }
}
