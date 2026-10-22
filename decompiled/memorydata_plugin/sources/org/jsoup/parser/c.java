package org.jsoup.parser;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f18287b;
    private String c;

    c(a r2, String r3) {
        this.f18286a = r2.b();
        this.f18287b = r2.f();
        this.c = r3;
    }

    c(a r2, String r3, Object... r4) {
        this.f18286a = r2.b();
        this.f18287b = r2.f();
        this.c = String.format(r3, r4);
    }

    public String toString() {
        return "<" + this.f18287b + ">: " + this.c;
    }
}
