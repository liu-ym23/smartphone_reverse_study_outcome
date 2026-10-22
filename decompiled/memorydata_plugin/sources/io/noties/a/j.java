package io.noties.a;

/* JADX INFO: loaded from: classes6.dex */
public class j implements h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16386a;

    public j(String r1) {
        this.f16386a = r1;
    }

    @Override // io.noties.a.h.b
    public int a() {
        return this.f16386a.length();
    }

    @Override // io.noties.a.h.b
    public final boolean b() {
        return false;
    }

    @Override // io.noties.a.h.e
    public String c() {
        return this.f16386a;
    }

    public String toString() {
        return "TextImpl{literal='" + this.f16386a + "'}";
    }
}
