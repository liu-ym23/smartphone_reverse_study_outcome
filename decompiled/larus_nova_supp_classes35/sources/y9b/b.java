package y9b;

import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.coremd.utils.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends y9b.a {

    public static final class a {
    }

    static {
    }

    public b() {
        CommonPrefixSpan.c r0 = new CommonPrefixSpan.c();
        r0.b = true;
        super(r0);
        i(CommonPrefixSpan.Type.LIST_NUM);
        h(1);
    }

    @Override // y9b.a
    public final int b() {
        return this.a.h;
    }

    @Override // y9b.a
    public final int c() {
        return this.a.i;
    }

    @Override // y9b.a
    public final String e() {
        return this.a.f;
    }

    @Override // y9b.a
    public final void f(int r2) {
        super.f(r2);
        String[] r3 = d.a;
        CommonPrefixSpan.c r4 = this.a;
        j(d.c(r4.i, r4.h));
    }

    @Override // y9b.a
    public final void h(int r3) {
        CommonPrefixSpan.c r0 = this.a;
        r0.i = r3;
        String[] r1 = d.a;
        j(d.c(r3, r0.h));
    }

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.f = r2;
    }
}
