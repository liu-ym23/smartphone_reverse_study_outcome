package t6b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a implements s6b.b<a, b> {
    public final FragmentActivity a;
    public final Fragment b;
    public final fxa.b c;
    public final m2b.a d;
    public final Boolean e;

    @Override // s6b.b
    public final s6b.b a() {
        return new b(this);
    }

    public fxa.b c() {
        return this.c;
    }

    public m2b.a d() {
        return this.d;
    }

    public FragmentActivity e() {
        return this.a;
    }

    public Fragment f() {
        return this.b;
    }

    public Boolean g() {
        return this.e;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r8) {
        a r9 = (a) r8;
        Intrinsics.checkNotNullParameter(r9, "patch");
        return new a(r9.e(), r9.f(), r9.c(), r9.d(), r9.g());
    }

    public a(FragmentActivity r2, Fragment r3, fxa.b r4, m2b.a r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "chatBundle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
