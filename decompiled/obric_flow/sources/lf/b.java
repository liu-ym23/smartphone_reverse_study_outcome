package lf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19605c;
    public int d;
    public int e;
    public final /* synthetic */ int f;
    public final c g;

    public b(boolean r5, c r10, int r11) {
        this.f = r11;
        switch(r11) {
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        this.f19603a = r5;
        this.g = r10;
        ByteBuffer r12 = ByteBuffer.allocate(4);
        if (r5 == false) goto L7;
        ByteOrder r13 = ByteOrder.BIG_ENDIAN;
    L8:
        r12.order(r13);
        r10.e(r12, 16);
        this.f19604b = r10.f(r12, 28);
        this.f19605c = r10.f(r12, 32);
        this.d = r10.e(r12, 42);
        this.e = r10.e(r12, 44);
        r10.e(r12, 46);
        r10.e(r12, 48);
        r10.e(r12, 50);
        return;
    L7:
        r13 = ByteOrder.LITTLE_ENDIAN;
        goto L8
    L10:
        this.f19603a = r5;
        this.g = r10;
        ByteBuffer r14 = ByteBuffer.allocate(8);
        if (r5 == false) goto L13;
        ByteOrder r15 = ByteOrder.BIG_ENDIAN;
    L14:
        r14.order(r15);
        r10.e(r14, 16);
        r10.d(32, r14, 8);
        this.f19604b = r14.getLong();
        r10.d(40, r14, 8);
        this.f19605c = r14.getLong();
        this.d = r10.e(r14, 54);
        this.e = r10.e(r14, 56);
        r10.e(r14, 58);
        r10.e(r14, 60);
        r10.e(r14, 62);
        return;
    L13:
        r15 = ByteOrder.LITTLE_ENDIAN;
        goto L14
    }

    public final d a(long r10) {
        switch(this.f) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        d r5 = new d();
        ByteBuffer r11 = ByteBuffer.allocate(8);
        if (this.f19603a == false) goto L7;
        ByteOrder r12 = ByteOrder.BIG_ENDIAN;
    L8:
        r11.order(r12);
        long r13 = this.f19604b;
        long r14 = (r10 * ((long) this.d)) + r13;
        c r15 = this.g;
        r5.f19607a = r15.f(r11, r14);
        r15.d(8 + r14, r11, 8);
        r5.f19608b = r11.getLong();
        r15.d(16 + r14, r11, 8);
        r5.f19609c = r11.getLong();
        r15.d(r14 + 40, r11, 8);
        r5.d = r11.getLong();
        return r5;
    L7:
        r12 = ByteOrder.LITTLE_ENDIAN;
        goto L8
    L10:
        d r16 = new d();
        ByteBuffer r17 = ByteBuffer.allocate(4);
        if (this.f19603a == false) goto L13;
        ByteOrder r18 = ByteOrder.BIG_ENDIAN;
    L14:
        r17.order(r18);
        long r19 = this.f19604b;
        long r20 = (r10 * ((long) this.d)) + r19;
        c r21 = this.g;
        r16.f19607a = r21.f(r17, r20);
        r16.f19608b = r21.f(r17, 4 + r20);
        r16.f19609c = r21.f(r17, 8 + r20);
        r16.d = r21.f(r17, r20 + 20);
        return r16;
    L13:
        r18 = ByteOrder.LITTLE_ENDIAN;
        goto L14
    }
}
