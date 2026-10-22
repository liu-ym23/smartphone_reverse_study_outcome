package y9b;

import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a extends CommonPrefixSpan {
    public ListHeadType c;

    /* JADX INFO: renamed from: y9b.a$a, reason: collision with other inner class name */
    public static final class C0323a {
    }

    static {
    }

    public int b() {
        return this.a.h;
    }

    public int c() {
        return this.a.i;
    }

    public CommonPrefixSpan.Type d() {
        return this.a.getType();
    }

    public String e() {
        return this.a.f;
    }

    public a(CommonPrefixSpan.c r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        super(r2);
        this.c = ListHeadType.None;
        i(CommonPrefixSpan.Type.NONE);
        f(0);
    }

    public void f(int r2) {
        this.a.h = Math.min(Math.max(r2, 0), 5);
    }

    public final void g(ListHeadType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public void h(int r2) {
        this.a.i = r2;
    }

    public void i(CommonPrefixSpan.Type r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.a = r2;
    }
}
