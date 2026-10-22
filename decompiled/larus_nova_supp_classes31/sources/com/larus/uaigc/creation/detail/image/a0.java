package com.larus.uaigc.creation.detail.image;

import android.net.Uri;
import android.view.View;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 implements com.larus.bmhome.bigimg.widget.j {
    public final /* synthetic */ BigImageDetailFragment a;

    public final void c() {
    }

    public final void d() {
    }

    public final void g() {
    }

    public final void h() {
    }

    public final void j() {
    }

    public final void k() {
    }

    public final void a() {
        BigImageDetailFragment r0 = this.a;
        Function1 r1 = r0.F.r.b;
        ImageAdapter r2 = r0.d;
        if (r2 == null) goto L7;
        Uri r3 = r2.A2(r0.l);
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L8:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        n1 r5 = (n1) CollectionsKt.firstOrNull(this.a.F.f);
        if (r5 == null) goto L15;
        Long r6 = r5.f;
        if (r6 == null) goto L15;
        Integer r7 = Integer.valueOf((int) r6.longValue());
    L16:
        n1 r8 = (n1) CollectionsKt.firstOrNull(this.a.F.f);
        if (r8 == null) goto L21;
        Long r9 = r8.g;
        if (r9 == null) goto L21;
        Integer r10 = Integer.valueOf((int) r9.longValue());
    L22:
        r1.invoke(new ic8.f(r4, null, null, r7, r10, 38));
        return;
    L21:
        r10 = null;
    L15:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final void b() {
        BigImageDetailFragment r0 = this.a;
        Function1 r1 = r0.F.s.b;
        ImageAdapter r2 = r0.d;
        if (r2 == null) goto L7;
        Uri r3 = r2.A2(r0.l);
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L8:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        n1 r5 = (n1) CollectionsKt.firstOrNull(this.a.F.f);
        if (r5 == null) goto L15;
        Long r6 = r5.f;
        if (r6 == null) goto L15;
        Integer r7 = Integer.valueOf((int) r6.longValue());
    L16:
        n1 r8 = (n1) CollectionsKt.firstOrNull(this.a.F.f);
        if (r8 == null) goto L21;
        Long r9 = r8.g;
        if (r9 == null) goto L21;
        Integer r10 = Integer.valueOf((int) r9.longValue());
    L22:
        r1.invoke(new ic8.f(r4, null, null, r7, r10, 38));
        return;
    L21:
        r10 = null;
    L15:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final void f() {
        BigImageDetailFragment r0 = this.a;
        int r1 = BigImageDetailFragment.I;
        r0.la0();
    }

    public final void i() {
        BigImageDetailFragment r0 = this.a;
        int r1 = BigImageDetailFragment.I;
        r0.ja0();
    }

    public a0(BigImageDetailFragment r1) {
        this.a = r1;
    }

    public final void e(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        BigImageDetailFragment r0 = this.a;
        int r1 = BigImageDetailFragment.I;
        r0.ka0(r3);
    }
}
