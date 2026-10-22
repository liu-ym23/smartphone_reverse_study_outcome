package y0a;

import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import gd9.v;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m0a.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e implements m {
    public final v a;

    public static final class a {
    }

    static {
    }

    public e(v r2) {
        Intrinsics.checkNotNullParameter(r2, "networkDepend");
        this.a = r2;
    }

    @Override // m0a.m
    public final Object a(int r12, boolean r13) {
        if (r13 == true) goto L6;
        c0.b.d("TabListRepositoryKmp", "fetchTabList non-multi-tab, return placeholder");
        return CollectionsKt.listOf(new TabItemInfoKmp(null, null, null, null, null, 31, null));
    L6:
        y0a.a r5 = new y0a.a(r12);
        c0 r14 = c0.b;
        r14.d("TabListRepositoryKmp", "fetchTabList: recommendType=" + r12);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L31
        gd9.e r16 = this.a.h().d("/creativity/community/creation/tab_list", r5, null, null, null);     // Catch: Throwable -> L31
        if (r16.c() == true) goto L11;
        r14.i("TabListRepositoryKmp", "fetchTabList http failed, status=" + r16.b + ", msg=" + r16.e);     // Catch: Throwable -> L31
        List<TabItemInfoKmp> r17 = CollectionsKt.emptyList();     // Catch: Throwable -> L31
    L29:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L31
    L33:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L40;
        c0.b.e("TabListRepositoryKmp", "fetchTabList exception: " + r19);
        return CollectionsKt.emptyList();
    L40:
        return r18;
    L11:
        String r110 = r16.d;     // Catch: Throwable -> L31
        if (r110 != null) goto L14;
    L17:
        boolean r1 = true;
    L18:
        if (r1 == false) goto L20;
        r14.i("TabListRepositoryKmp", "fetchTabList empty body");     // Catch: Throwable -> L31
        r17 = CollectionsKt.emptyList();     // Catch: Throwable -> L31
        goto L29
    L20:
        b r111 = (b) xt7.d.b.c(b.Companion.serializer(), r110);     // Catch: Throwable -> L31
        if (r111.a == 0) goto L23;
        r14.i("TabListRepositoryKmp", "fetchTabList biz failed, code=" + r111.a + ", msg=" + r111.b);     // Catch: Throwable -> L31
        r17 = CollectionsKt.emptyList();     // Catch: Throwable -> L31
        goto L29
    L23:
        d r112 = r111.c;     // Catch: Throwable -> L31
        if (r112 == null) goto L26;
        r17 = r112.a;     // Catch: Throwable -> L31
    L27:
        if (r17 != null) goto L29;
        r17 = CollectionsKt.emptyList();     // Catch: Throwable -> L31
        goto L29
    L26:
        r17 = null;
        goto L27
    L14:
        if (r110.length() == 0) goto L17;
        r1 = false;
    L31:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }
}
