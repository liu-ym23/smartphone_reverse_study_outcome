package t6b;

import com.ss.android.lark.biz.im.extension.PageType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class g implements s6b.b<g, h> {
    public final List<yya.l> a;
    public final boolean b;
    public final List<Integer> c;
    public final boolean d;
    public final yya.f e;
    public final PageType f;

    public g() {
        List r2 = null;
        this(r2, false, r2, 63);
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new h(this);
    }

    public List<yya.l> c() {
        return this.a;
    }

    public yya.f d() {
        return this.e;
    }

    public List<Integer> e() {
        return this.c;
    }

    public PageType f() {
        return this.f;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.d;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r9) {
        g r10 = (g) r9;
        Intrinsics.checkNotNullParameter(r10, "patch");
        return new g(r10.c(), r10.g(), r10.e(), r10.h(), r10.d(), r10.f());
    }

    public /* synthetic */ g(List r8, boolean r9, List r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r8 = CollectionsKt.emptyList();
    L5:
        List r1 = r8;
        if ((r11 & 2) == 0) goto L8;
        boolean r2 = true;
    L10:
        if ((r11 & 4) == 0) goto L12;
        r10 = CollectionsKt.emptyList();
    L12:
        List r3 = r10;
        if ((r11 & 32) == 0) goto L15;
        PageType r12 = PageType.CHAT_WINDOW;
    L16:
        this(r1, r2, r3, false, null, r12);
        return;
    L15:
        r12 = null;
        goto L16
    L8:
        r2 = r9;
        goto L10
    }

    public g(List<? extends yya.l> r2, boolean r3, List<Integer> r4, boolean r5, yya.f r6, PageType r7) {
        Intrinsics.checkNotNullParameter(r2, "actionInterceptorList");
        Intrinsics.checkNotNullParameter(r4, "messageActionHandlerKeys");
        Intrinsics.checkNotNullParameter(r7, "pageType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
