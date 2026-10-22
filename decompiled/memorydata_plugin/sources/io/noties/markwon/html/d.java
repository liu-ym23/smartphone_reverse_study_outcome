package io.noties.markwon.html;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16563b;

    d() {
    }

    public String a() {
        return this.f16562a;
    }

    void a(String r1, String r2) {
        this.f16562a = r1;
        this.f16563b = r2;
    }

    public String b() {
        return this.f16563b;
    }

    public String toString() {
        return "CssProperty{key='" + this.f16562a + "', value='" + this.f16563b + "'}";
    }
}
