package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
public final class z implements Appendable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f1593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1594b;

    public z(Appendable r5) {
        this.f1594b = true;
        this.f1593a = r5;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char r5) {
        boolean r10 = this.f1594b;
        Appendable r11 = this.f1593a;
        boolean r12 = false;
        if (r10 == false) goto L6;
        this.f1594b = false;
        r11.append("  ");
    L6:
        if (r5 != '\n') goto L8;
        r12 = true;
    L8:
        this.f1594b = r12;
        r11.append(r5);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence r5) {
        if (r5 != null) goto L4;
        r5 = "";
    L4:
        append(r5, 0, r5.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence r5, int r10, int r11) {
        if (r5 != null) goto L4;
        r5 = "";
    L4:
        boolean r12 = this.f1594b;
        Appendable r13 = this.f1593a;
        boolean r14 = false;
        if (r12 == false) goto L8;
        this.f1594b = false;
        r13.append("  ");
    L8:
        if (r5.length() > 0) goto L10;
    L12:
        this.f1594b = r14;
        r13.append(r5, r10, r11);
        return this;
    L10:
        if (r5.charAt(r11 - 1) != '\n') goto L12;
        r14 = true;
        goto L12
    }
}
