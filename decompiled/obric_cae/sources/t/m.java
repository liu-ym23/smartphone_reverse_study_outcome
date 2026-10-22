package t;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f12183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<p> f12184b;

    public m(p r8) {
        this.f12183a = null;
        this.f12184b = new ArrayList();
        this.f12183a = r8;
    }

    public static long a(f r10, long r11) {
        p r8 = r10.f12162d;
        if ((r8 instanceof k) == false) goto L5;
        return r11;
    L5:
        ArrayList r12 = r10.f12169k;
        int r13 = r12.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        d r16 = (d) r12.get(r14);
        if ((r16 instanceof f) == false) goto L13;
        f r17 = (f) r16;
        if (r17.f12162d == r8) goto L13;
        r15 = Math.min(r15, a(r17, ((long) r17.f12164f) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r8.f12201i) goto L22;
        long r18 = r8.j();
        f r19 = r8.f12200h;
        long r110 = r11 - r18;
        return Math.min(Math.min(r15, a(r19, r110)), r110 - ((long) r19.f12164f));
    L22:
        return r15;
    }

    public static long b(f r10, long r11) {
        p r8 = r10.f12162d;
        if ((r8 instanceof k) == false) goto L5;
        return r11;
    L5:
        ArrayList r12 = r10.f12169k;
        int r13 = r12.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        d r16 = (d) r12.get(r14);
        if ((r16 instanceof f) == false) goto L13;
        f r17 = (f) r16;
        if (r17.f12162d == r8) goto L13;
        r15 = Math.max(r15, b(r17, ((long) r17.f12164f) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r8.f12200h) goto L22;
        long r18 = r8.j();
        f r19 = r8.f12201i;
        long r110 = r11 + r18;
        return Math.max(Math.max(r15, b(r19, r110)), r110 - ((long) r19.f12164f));
    L22:
        return r15;
    }
}
