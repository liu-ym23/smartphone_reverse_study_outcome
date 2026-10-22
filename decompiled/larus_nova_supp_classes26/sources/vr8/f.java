package vr8;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements b {
    public final int a;
    public final vr8.a b;
    public final Lazy c;
    public int d;
    public int e;
    public final d f;
    public final e g;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [vr8.d] */
    /* JADX WARN: Type inference failed for: r2v4, types: [vr8.e] */
    public f(vr8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        this.a = 30;
        this.b = r2;
        this.c = LazyKt.lazy(new c(this));
        this.f = new d(this);
        this.g = new e(this);
    }

    @Override // vr8.b
    public final void b(com.larus.bmhome.social.page.datasource.event.e.a r4) {
        Intrinsics.checkNotNullParameter(r4, "operation");
        FLogger.a.i("SimplePagingPrefetch", "onFailed——operation(" + r4 + ')');
        c(r4, 0, 0);
    }

    @Override // vr8.b
    public final void a(com.larus.bmhome.social.page.datasource.event.e.a r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "operation");
        FLogger.a.i("SimplePagingPrefetch", "onSuccess——operation(" + r4 + "), complete(" + r6 + ')');
        if (r6 == false) goto L5;
        int r7 = 2;
    L6:
        c(r4, r5, r7);
        return;
    L5:
        r7 = 0;
        goto L6
    }

    public final void c(com.larus.bmhome.social.page.datasource.event.e.a r8, int r9, int r10) {
        if ((r8 instanceof com.larus.bmhome.social.page.datasource.event.e.a.b) == false) goto L9;
        if (this.e == 2) goto L9;
        this.e = r10;
        FLogger.a.i("SimplePagingPrefetch", "resetFetchType——operation:(" + r8 + "), fetch_type(" + this.e + "), fetch_size(" + r9 + ')');
        return;
    L9:
        if ((r8 instanceof com.larus.bmhome.social.page.datasource.event.e.a.C0035a) == true) goto L11;
        return;
    L11:
        if (this.d == 2) goto L15;
        this.d = r10;
        FLogger.a.i("SimplePagingPrefetch", "resetFetchType——operation:(" + r8 + "), fetch_type(" + this.d + "), fetch_size(" + r9 + ')');
        return;
    }
}
