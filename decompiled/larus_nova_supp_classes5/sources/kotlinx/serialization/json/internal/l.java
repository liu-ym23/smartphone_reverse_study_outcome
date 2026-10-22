package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class l {
    public final q a;
    public boolean b;

    public void a() {
        this.b = true;
    }

    public void b() {
        this.b = false;
    }

    public void c() {
        this.b = false;
    }

    public void k() {
    }

    public void l() {
    }

    public l(q r2) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        this.a = r2;
        this.b = true;
    }

    public void d(byte r4) {
        this.a.writeLong(r4);
    }

    public final void e(char r2) {
        this.a.a(r2);
    }

    public void f(int r4) {
        this.a.writeLong(r4);
    }

    public void g(long r2) {
        this.a.writeLong(r2);
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.b(r2);
    }

    public void i(short r4) {
        this.a.writeLong(r4);
    }

    public void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.c(r2);
    }
}
