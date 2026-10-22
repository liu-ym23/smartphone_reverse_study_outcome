package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<p0.a> f1770d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f1772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f1773c;

    static {
        f1770d = new ThreadLocal();
    }

    public i(n r8, int r10) {
        this.f1773c = 0;
        this.f1772b = r8;
        this.f1771a = r10;
    }

    public final int a(int r8) {
        p0.a r10 = c();
        int r11 = r10.a(16);
        if (r11 == 0) goto L5;
        ByteBuffer r12 = r10.f9913b;
        int r13 = r11 + r10.f9912a;
        int r14 = r8 * 4;
        return r12.getInt(r14 + ((r12.getInt(r13) + r13) + 4));
    L5:
        return 0;
    }

    public final int b() {
        p0.a r8 = c();
        int r10 = r8.a(16);
        if (r10 == 0) goto L5;
        int r11 = r10 + r8.f9912a;
        int r12 = r8.f9913b.getInt(r11) + r11;
        return r8.f9913b.getInt(r12);
    L5:
        return 0;
    }

    public final p0.a c() {
        ThreadLocal<p0.a> r8 = f1770d;
        p0.a r10 = r8.get();
        if (r10 != null) goto L5;
        r10 = new p0.a();
        r8.set(r10);
    L5:
        p0.b r11 = this.f1772b.f1796a;
        int r12 = r11.a(6);
        if (r12 == 0) goto L12;
        int r13 = r12 + r11.f9912a;
        int r14 = (r11.f9913b.getInt(r13) + r13) + 4;
        int r15 = (this.f1771a * 4) + r14;
        int r16 = r11.f9913b.getInt(r15) + r15;
        ByteBuffer r17 = r11.f9913b;
        r10.f9913b = r17;
        if (r17 == null) goto L10;
        r10.f9912a = r16;
        int r18 = r16 - r17.getInt(r16);
        r10.f9914c = r18;
        short r19 = r10.f9913b.getShort(r18);
    L11:
        r10.f9915d = r19;
        goto L12
    L10:
        r19 = 0;
        r10.f9912a = 0;
        r10.f9914c = 0;
    L12:
        return r10;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        r8.append(super.toString());
        r8.append(", id:");
        p0.a r10 = c();
        int r11 = r10.a(4);
        int r12 = 0;
        if (r11 == 0) goto L5;
        int r13 = r10.f9913b.getInt(r11 + r10.f9912a);
    L6:
        r8.append(Integer.toHexString(r13));
        r8.append(", codepoints:");
        int r14 = b();
    L7:
        if (r12 >= r14) goto L10;
        r8.append(Integer.toHexString(a(r12)));
        r8.append(" ");
        r12 = r12 + 1;
        goto L7
    L10:
        return r8.toString();
    L5:
        r13 = 0;
        goto L6
    }
}
