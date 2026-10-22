package com.obric.oui.indicator;

import ai.j0;
import com.zte.miboard.cards.common.views.CardPagerLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.core.view.inputmethod.a f13494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r6.a f13495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13496c;
    public int d;
    public final /* synthetic */ OBaseIndicator e;

    public k(OBaseIndicator r5, int r10, int r11, androidx.core.view.inputmethod.a r12) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        this.e = r5;
        this.f13494a = r12;
        if (r10 <= 0) goto L9;
        if (r11 < 0) goto L7;
        if (r11 < r10) goto L9;
    L7:
        String r13 = j0.f(r11, r10, "setManualPager requires currentItem in 0 until pageCount, currentItem=", " pageCount=");
        ps.a.g(r5.f13441a, r13);
        throw new IllegalArgumentException(r13);
    L9:
        this.f13496c = r10;
        this.d = r11;
    }

    @Override // com.obric.oui.indicator.l
    public final int a() {
        return this.d;
    }

    public final boolean b(int r5) {
        int r10 = this.f13496c;
        OBaseIndicator r11 = this.e;
        if (r10 > 0) goto L8;
        if (r5 == 0) goto L8;
        String r12 = "ManualPager requires currentItem=0 when pageCount=" + this.f13496c + ", currentItem=" + r5;
        ps.a.g(r11.f13441a, r12);
        throw new IllegalArgumentException(r12);
    L8:
        if (r10 <= 0) goto L15;
        if (r5 < 0) goto L12;
        if (r5 < r10) goto L15;
    L12:
        StringBuilder r13 = j0.s(r5, "ManualPager requires currentItem in 0 until pageCount, currentItem=", " pageCount=");
        r13.append(this.f13496c);
        String r14 = r13.toString();
        ps.a.g(r11.f13441a, r14);
        throw new IllegalArgumentException(r14);
    L15:
        if (this.d != r5) goto L18;
        return false;
    L18:
        this.d = r5;
        return true;
    }

    @Override // com.obric.oui.indicator.l
    public final void c(int r5) {
        if (b(r5) == true) goto L5;
        return;
    L5:
        r6.a r10 = this.f13495b;
        if (r10 != null) goto L8;
    L10:
        this.e.h();
    L11:
        androidx.core.view.inputmethod.a r11 = this.f13494a;
        if (r11 == null) goto L16;
        int r12 = this.d;
        CardPagerLayout.a((CardPagerLayout) r11.f497b, r12);
        return;
    L16:
        return;
    L8:
        if (d() == false) goto L10;
        r10.l(0.0f, this.d);
        goto L11
    }

    @Override // com.obric.oui.indicator.l
    public final boolean d() {
        if (this.f13496c <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.indicator.l
    public final void e() {
        this.f13495b = null;
    }

    @Override // com.obric.oui.indicator.l
    public final void f(r6.a r5) {
        Intrinsics.checkNotNullParameter(r5, "onPageChangeListenerHelper");
        this.f13495b = r5;
    }

    @Override // com.obric.oui.indicator.l
    public final int getCount() {
        return this.f13496c;
    }
}
