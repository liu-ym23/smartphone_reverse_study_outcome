package t6b;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n extends m {
    public final a1 e;
    public final s0 f;
    public final w0 g;
    public final boolean h;

    @Override // t6b.m
    public final s0 c() {
        return this.f;
    }

    @Override // t6b.m
    public final w0 d() {
        return this.g;
    }

    @Override // t6b.m
    public final a1 e() {
        return this.e;
    }

    @Override // t6b.m
    public final boolean f() {
        return this.h;
    }

    public n(m r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(0);
        this.e = r2.e();
        this.f = r2.c();
        this.g = r2.d();
        this.h = r2.f();
    }
}
