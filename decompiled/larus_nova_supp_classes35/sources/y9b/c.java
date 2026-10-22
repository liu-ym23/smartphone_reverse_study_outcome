package y9b;

import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends y9b.a {
    public static final List<CommonPrefixSpan.Type> d = null;

    public static final class a {
    }

    static {
        d = CollectionsKt.listOf(new CommonPrefixSpan.Type[]{CommonPrefixSpan.Type.FILL_CIRCLE, CommonPrefixSpan.Type.HOLLOW_CIRCLE, CommonPrefixSpan.Type.FILL_RECT});
    }

    public c() {
        CommonPrefixSpan.c r0 = new CommonPrefixSpan.c();
        r0.b = true;
        super(r0);
        j("- ");
        h(0);
        i(CommonPrefixSpan.Type.FILL_CIRCLE);
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
    public final CommonPrefixSpan.Type d() {
        return super.d();
    }

    @Override // y9b.a
    public final void f(int r3) {
        super.f(r3);
        CommonPrefixSpan.c r4 = this.a;
        int r0 = r4.h;
        CommonPrefixSpan.Type r1 = (CommonPrefixSpan.Type) CollectionsKt.getOrNull(d, r0 % 3);
        if (r1 != null) goto L5;
        r1 = CommonPrefixSpan.Type.FILL_CIRCLE;
    L5:
        r4.a = r1;
    }

    @Override // y9b.a
    public final void h(int r2) {
        this.a.i = 0;
    }

    @Override // y9b.a
    public final void i(CommonPrefixSpan.Type r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        super.i(r2);
    }

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter("- ", "_");
        this.a.f = "- ";
    }
}
