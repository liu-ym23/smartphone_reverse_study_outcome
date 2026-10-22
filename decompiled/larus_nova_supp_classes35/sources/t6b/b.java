package t6b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends a {
    public final FragmentActivity f;
    public final Fragment g;
    public final fxa.b h;
    public final m2b.a i;
    public final Boolean j;

    @Override // t6b.a
    public final fxa.b c() {
        return this.h;
    }

    @Override // t6b.a
    public final m2b.a d() {
        return this.i;
    }

    @Override // t6b.a
    public final FragmentActivity e() {
        return this.f;
    }

    @Override // t6b.a
    public final Fragment f() {
        return this.g;
    }

    @Override // t6b.a
    public final Boolean g() {
        return this.j;
    }

    public b(a r8) {
        Intrinsics.checkNotNullParameter(r8, "base");
        super(null, null, r8.c(), null, null);
        this.f = r8.e();
        this.g = r8.f();
        this.h = r8.c();
        this.i = r8.d();
        this.j = r8.g();
    }
}
