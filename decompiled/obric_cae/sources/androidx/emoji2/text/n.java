package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0.b f1796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f1797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f1798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Typeface f1799d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f1800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f1801b;

        public a() {
            this(1);
        }

        public final void a(i r8, int r10, int r11) {
            int r12 = r8.a(r10);
            SparseArray<a> r13 = this.f1800a;
            if (r13 != null) goto L5;
            a r14 = null;
        L6:
            if (r14 != null) goto L8;
            r14 = new a();
            r13.put(r8.a(r10), r14);
        L8:
            if (r11 <= r10) goto L10;
            r14.a(r8, r10 + 1, r11);
            return;
        L10:
            r14.f1801b = r8;
            return;
        L5:
            r14 = r13.get(r12);
            goto L6
        }

        public a(int r8) {
            this.f1800a = new SparseArray(r8);
        }
    }

    public n(Typeface r8, p0.b r10) {
        this.f1799d = r8;
        this.f1796a = r10;
        this.f1798c = new a(1024);
        int r11 = r10.a(6);
        if (r11 == 0) goto L5;
        int r12 = r11 + r10.f9912a;
        int r13 = r10.f9913b.getInt(r10.f9913b.getInt(r12) + r12);
    L6:
        this.f1797b = new char[r13 * 2];
        int r14 = r10.a(6);
        if (r14 == 0) goto L9;
        int r15 = r14 + r10.f9912a;
        int r16 = r10.f9913b.getInt(r10.f9913b.getInt(r15) + r15);
    L10:
        int r17 = 0;
    L11:
        if (r17 >= r16) goto L21;
        i r18 = new i(this, r17);
        p0.a r19 = r18.c();
        int r20 = r19.a(4);
        if (r20 == 0) goto L15;
        int r21 = r19.f9913b.getInt(r20 + r19.f9912a);
    L16:
        Character.toChars(r21, this.f1797b, r17 * 2);
        if (r18.b() <= 0) goto L19;
        boolean r22 = true;
    L20:
        t2.b.l("invalid metadata codepoint length", r22);
        this.f1798c.a(r18, 0, r18.b() - 1);
        r17 = r17 + 1;
        goto L11
    L19:
        r22 = false;
        goto L20
    L15:
        r21 = 0;
        goto L16
    L21:
        return;
    L9:
        r16 = 0;
        goto L10
    L5:
        r13 = 0;
        goto L6
    }
}
