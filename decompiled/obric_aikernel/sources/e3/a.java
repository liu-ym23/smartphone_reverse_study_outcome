package e3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f8566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f8567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f8568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f8569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f8570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f8571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String[] f8572i;

    public a(boolean r10, boolean r11, String[] r12, String[] r13, String[] r14, String[] r15, String[] r16, String[] r17, String[] r18) {
        this.f8564a = r10;
        this.f8565b = r11;
        this.f8566c = r12;
        this.f8567d = r13;
        this.f8568e = r14;
        this.f8569f = r15;
        this.f8570g = r16;
        this.f8571h = r17;
        this.f8572i = r18;
    }

    public boolean a() {
        return this.f8565b;
    }

    public boolean b() {
        return this.f8564a;
    }

    public String[] c() {
        return this.f8572i;
    }

    public String[] d() {
        return this.f8568e;
    }

    public String[] e() {
        return this.f8567d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L31:
        return false;
    L8:
        if (a.class != r10.getClass()) goto L31;
        a r11 = (a) r10;
        if (this.f8564a != r11.f8564a) goto L30;
        if (this.f8565b != r11.f8565b) goto L30;
        if (Arrays.equals(this.f8566c, r11.f8566c) == false) goto L30;
        if (Arrays.equals(this.f8567d, r11.f8567d) == false) goto L30;
        if (Arrays.equals(this.f8568e, r11.f8568e) == false) goto L30;
        if (Arrays.equals(this.f8569f, r11.f8569f) == false) goto L30;
        if (Arrays.equals(this.f8570g, r11.f8570g) == false) goto L30;
        if (Arrays.equals(this.f8571h, r11.f8571h) == false) goto L30;
        if (Arrays.equals(this.f8572i, r11.f8572i) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public String[] f() {
        return this.f8569f;
    }

    public String[] g() {
        return this.f8570g;
    }

    public String[] h() {
        return this.f8566c;
    }

    public String[] i() {
        return this.f8571h;
    }
}
