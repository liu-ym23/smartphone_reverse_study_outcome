package org.threeten.bp.format;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f21211a;

    public e(char r5) {
        this.f21211a = r5;
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r5, CharSequence r10, int r11) {
        if (r11 == r10.length()) goto L5;
        char r12 = r10.charAt(r11);
        if (r5.a(this.f21211a, r12) == true) goto L11;
        return ~r11;
    L11:
        return r11 + 1;
    L5:
        return ~r11;
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r5, StringBuilder r10) {
        r10.append(this.f21211a);
        return true;
    }

    public final String toString() {
        char r5 = this.f21211a;
        if (r5 != '\'') goto L7;
        return "''";
    L7:
        return "'" + r5 + "'";
    }
}
