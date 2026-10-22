package io.noties.markwon.html.jsoup.parser;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16591b;

    b(int r1, String r2) {
        this.f16590a = r1;
        this.f16591b = r2;
    }

    b(int r1, String r2, Object... r3) {
        this.f16591b = String.format(r2, r3);
        this.f16590a = r1;
    }

    public String toString() {
        return this.f16590a + ": " + this.f16591b;
    }
}
