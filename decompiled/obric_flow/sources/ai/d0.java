package ai;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends fi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fi.j f185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f186b;

    public d0(fi.j r5, String r10) {
        this.f185a = r5;
        this.f186b = r10;
    }

    @Override // fi.j
    public final String a() {
        return this.f186b;
    }

    @Override // fi.j
    public final String b() {
        return this.f185a.b();
    }

    @Override // fi.j
    public final String d() {
        return this.f185a.d();
    }

    @Override // fi.a
    public final boolean e() {
        fi.j r5 = this.f185a;
        if ((r5 instanceof fi.a) == true) goto L5;
        return false;
    L5:
        return ((fi.a) r5).e();
    }

    @Override // fi.j
    public final long length() {
        return this.f185a.length();
    }

    @Override // fi.j
    public final void writeTo(OutputStream r5) {
        this.f185a.writeTo(r5);
    }
}
