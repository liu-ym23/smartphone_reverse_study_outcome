package org.threeten.bp.format;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g[] f21212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21213b;

    public f(boolean r5, ArrayList r10) {
        this((g[]) r10.toArray(new g[r10.size()]), r5);
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r10, CharSequence r11, int r12) {
        boolean r5 = this.f21213b;
        g[] r13 = this.f21212a;
        int r14 = 0;
        if (r5 == false) goto L13;
        t r15 = r10.b();
        t r16 = new t(r15.g);
        r16.f21247a = r15.f21247a;
        r16.f21248b = r15.f21248b;
        r16.f21249c.putAll(r15.f21249c);
        r16.d = r15.d;
        ArrayList r17 = r10.f;
        r17.add(r16);
        int r18 = r13.length;
        int r19 = r12;
    L5:
        if (r14 >= r18) goto L11;
        r19 = r13[r14].parse(r10, r11, r19);
        if (r19 < 0) goto L8;
        r14 = r14 + 1;
        goto L5
    L8:
        r17.remove(r17.size() - 1);
        return r12;
    L11:
        r17.remove(r17.size() - 2);
        return r19;
    L13:
        int r20 = r13.length;
    L14:
        if (r14 >= r20) goto L19;
        r12 = r13[r14].parse(r10, r11, r12);
        if (r12 < 0) goto L19;
        r14 = r14 + 1;
    L19:
        return r12;
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r10, StringBuilder r11) {
        int r5 = r11.length();
        boolean r12 = this.f21213b;
        if (r12 == false) goto L22;
        r10.d++;
    L22:
        g[] r13 = this.f21212a;     // Catch: Throwable -> L13
        int r14 = r13.length;     // Catch: Throwable -> L13
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L16;
        if (r13[r15].print(r10, r11) == false) goto L9;
        r15 = r15 + 1;
        goto L6
    L9:
        r11.setLength(r5);     // Catch: Throwable -> L13
        if (r12 == false) goto L12;
        r10.d--;
    L12:
        return true;
    L16:
        if (r12 == false) goto L18;
        r10.d--;
    L18:
        return true;
    L13:
        th = move-exception;
        if (r12 == false) goto L21;
        r10.d--;
    L21:
        throw th;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        g[] r10 = this.f21212a;
        if (r10 == null) goto L16;
        boolean r11 = this.f21213b;
        if (r11 == false) goto L7;
        String r12 = "[";
    L8:
        r5.append(r12);
        int r13 = r10.length;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L11;
        r5.append(r10[r14]);
        r14 = r14 + 1;
        goto L9
    L11:
        if (r11 == false) goto L13;
        String r15 = "]";
    L14:
        r5.append(r15);
        goto L16
    L13:
        r15 = ")";
        goto L14
    L7:
        r12 = "(";
    L16:
        return r5.toString();
    }

    public f(g[] r5, boolean r10) {
        this.f21212a = r5;
        this.f21213b = r10;
    }
}
