package t6b;

import com.ss.android.lark.biz.im.extension.PageType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends g {
    public boolean g;
    public final List<yya.l> h;
    public final List<Integer> i;
    public boolean j;
    public yya.f k;
    public PageType l;

    @Override // t6b.g
    public final List<yya.l> c() {
        return this.h;
    }

    @Override // t6b.g
    public final yya.f d() {
        return this.k;
    }

    @Override // t6b.g
    public final List<Integer> e() {
        return this.i;
    }

    @Override // t6b.g
    public final PageType f() {
        return this.l;
    }

    @Override // t6b.g
    public final boolean g() {
        return this.g;
    }

    @Override // t6b.g
    public final boolean h() {
        return this.j;
    }

    public h(g r4) {
        Intrinsics.checkNotNullParameter(r4, "base");
        super(null, false, null, 63);
        this.g = r4.g();
        this.h = CollectionsKt.toMutableList(r4.c());
        this.i = CollectionsKt.toMutableList(r4.e());
        this.j = r4.h();
        this.k = r4.d();
        this.l = r4.f();
    }
}
