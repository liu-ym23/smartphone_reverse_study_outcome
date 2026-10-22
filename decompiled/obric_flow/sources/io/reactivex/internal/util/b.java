package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f18169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f18170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18171c;

    public b() {
        Object[] r5 = new Object[5];
        this.f18169a = r5;
        this.f18170b = r5;
    }

    public final void a(Object r5) {
        int r10 = this.f18171c;
        if (r10 != 4) goto L5;
        Object[] r11 = new Object[5];
        this.f18170b[4] = r11;
        this.f18170b = r11;
        r10 = 0;
    L5:
        this.f18170b[r10] = r5;
        this.f18171c = r10 + 1;
    }

    public final void b(a r5) {
        Object[] r10 = this.f18169a;
    L3:
        if (r10 == null) goto L15;
        int r11 = 0;
    L6:
        if (r11 >= 4) goto L14;
        Object r12 = r10[r11];
        if (r12 == null) goto L14;
        if (r5.test(r12) == true) goto L12;
        r11 = r11 + 1;
        goto L6
    L12:
        return;
    L14:
        r10 = r10[4];
        goto L3
    }
}
