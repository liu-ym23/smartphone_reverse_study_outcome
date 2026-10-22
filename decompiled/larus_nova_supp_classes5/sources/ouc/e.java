package ouc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.modules.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final String f;
    public boolean g;
    public final String h;
    public final ClassDiscriminatorMode i;
    public final boolean j;
    public final boolean k;
    public boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public d q;

    public e(a r3) {
        Intrinsics.checkNotNullParameter(r3, "json");
        f r0 = r3.a;
        this.a = r0.a;
        this.b = r0.f;
        this.c = r0.b;
        this.d = r0.c;
        this.e = r0.e;
        this.f = r0.g;
        this.g = r0.h;
        this.h = r0.j;
        this.i = r0.p;
        this.j = r0.l;
        r0.getClass();
        f r1 = r3.a;
        this.k = r1.m;
        this.l = r1.n;
        this.m = r1.o;
        this.n = r1.k;
        this.o = r1.d;
        this.p = r1.i;
        this.q = r3.b;
    }
}
