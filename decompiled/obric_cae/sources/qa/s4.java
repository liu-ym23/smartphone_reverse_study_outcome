package qa;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@w(a = "a")
public final class s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x(a = "a1", b = 6)
    public final String f11091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @x(a = "a2", b = 6)
    public final String f11092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @x(a = "a6", b = 2)
    public int f11093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @x(a = "a4", b = 6)
    public final String f11094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @x(a = "a5", b = 6)
    public final String f11095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String[] f11100j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11103c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f11104d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String[] f11105e;

        public a(String r8, String r10, String r11) {
            this.f11105e = null;
            this.f11101a = r10;
            this.f11102b = r10;
            this.f11104d = r11;
            this.f11103c = r8;
        }

        public final s4 a() {
            if (this.f11105e == null) goto L7;
            return new s4(this);
        L7:
            throw new g4("sdk packages is null");
        }
    }

    public s4() {
        this.f11093c = 1;
        this.f11100j = null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f11098h) == false) goto L8;
        String r8 = this.f11091a;
        if (TextUtils.isEmpty(r8) == true) goto L8;
        this.f11098h = t4.n(r8);
    L8:
        return this.f11098h;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f11097g) == false) goto L8;
        String r8 = this.f11092b;
        if (TextUtils.isEmpty(r8) == true) goto L8;
        this.f11097g = t4.n(r8);
    L8:
        return this.f11097g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.f11099i) == false) goto L8;
        String r8 = this.f11095e;
        if (TextUtils.isEmpty(r8) == true) goto L8;
        this.f11099i = t4.n(r8);
    L8:
        if (TextUtils.isEmpty(this.f11099i) == false) goto L11;
        this.f11099i = "standard";
    L11:
        return this.f11099i;
    }

    public final String[] d() {
        String[] r8 = this.f11100j;
        if (r8 != null) goto L5;
    L6:
        String r10 = this.f11094d;
        if (TextUtils.isEmpty(r10) == false) goto L16;
    L15:
        return (String[]) this.f11100j.clone();
    L16:
        String[] r11 = t4.n(r10).split(";");     // Catch: Throwable -> L11
    L13:
        this.f11100j = r11;
    L11:
        th = move-exception;
        th.printStackTrace();
        r11 = null;
        goto L13
    L5:
        if (r8.length != 0) goto L15;
        goto L6
    }

    public final boolean equals(Object r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8 != this) goto L9;
        return true;
    L9:
        if (s4.class == r8.getClass()) goto L20;
        return false;
    L20:
        if (this.f11098h.equals(((s4) r8).f11098h) == false) goto L18;
        if (this.f11096f.equals(((s4) r8).f11096f) == false) goto L18;
        if (this.f11097g.equals(((s4) r8).f11097g) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public s4(a r8) {
        this.f11093c = 1;
        String r10 = null;
        this.f11100j = null;
        this.f11096f = r8.f11101a;
        String r11 = r8.f11102b;
        this.f11097g = r11;
        this.f11098h = r8.f11103c;
        this.f11093c = 1;
        this.f11099i = "standard";
        this.f11100j = r8.f11105e;
        this.f11092b = t4.j(r11);
        this.f11091a = t4.j(this.f11098h);
        t4.j(r8.f11104d);
        String[] r12 = this.f11100j;
        if (r12 != null) goto L14;
    L12:
        this.f11094d = t4.j(r10);
        this.f11095e = t4.j(this.f11099i);
        return;
    L14:
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L10
        int r14 = r12.length;     // Catch: Throwable -> L10
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L8;
        r13.append(r12[r15]);     // Catch: Throwable -> L10
        r13.append(";");     // Catch: Throwable -> L10
        r15 = r15 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        r10 = r13.toString();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }
}
