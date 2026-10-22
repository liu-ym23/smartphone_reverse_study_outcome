package t6b;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class m implements s6b.b<m, n> {
    public final a1 a;
    public final s0 b;
    public final w0 c;
    public final boolean d;

    public m() {
        this(0);
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new n(this);
    }

    public s0 c() {
        return this.b;
    }

    public w0 d() {
        return this.c;
    }

    public a1 e() {
        return this.a;
    }

    public boolean f() {
        return this.d;
    }

    public /* synthetic */ m(int r2) {
        this(null, null, null, false);
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r5) {
        m r6 = (m) r5;
        Intrinsics.checkNotNullParameter(r6, "patch");
        return new m(r6.e(), r6.c(), r6.d(), r6.f());
    }

    public m(a1 r1, s0 r2, w0 r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
