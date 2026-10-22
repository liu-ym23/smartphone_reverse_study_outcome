package j3b;

import b3b.f;
import i3b.d;
import kotlin.jvm.internal.Intrinsics;
import v4b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements d {
    public final m2b.a a;
    public final f b;
    public final v4b.d c;
    public final c d;

    @Override // i3b.d
    public final m2b.a a() {
        return this.a;
    }

    @Override // i3b.d
    public final c b() {
        return this.d;
    }

    public final Class c() {
        return d.class;
    }

    @Override // i3b.d
    public final f g() {
        return this.b;
    }

    @Override // i3b.d
    public final v4b.d j() {
        return this.c;
    }

    public a(m2b.a r2, f r3, v4b.d r4, c r5) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
