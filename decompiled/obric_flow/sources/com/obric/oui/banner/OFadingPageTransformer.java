package com.obric.oui.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.common.oui.R$color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/banner/OFadingPageTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12019a;

    public OFadingPageTransformer() {
        this(0);
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public final void transformPage(final View r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Function0<Unit> r11 = new AnonymousClass1(r5, this);
        AnonymousClass2 r12 = AnonymousClass2.INSTANCE;
        r11.invoke();
        if (r10 >= (-1.0f)) goto L6;
        Function0<Unit> r13 = new AnonymousClass3(r5);
        new AnonymousClass4(r5);
        r13.invoke();
        return;
    L6:
        if (r10 > 1.0f) goto L8;
        final float r14 = Math.max(0.5f, 1 - Math.abs(r10));
        Function0<Unit> r15 = new AnonymousClass5(r5, r14);
        new AnonymousClass6(r5, r14);
        r15.invoke();
        return;
    L8:
        Function0<Unit> r16 = new AnonymousClass7(r5);
        new AnonymousClass8(r5);
        r16.invoke();
    }

    public OFadingPageTransformer(int r5) {
        this.f12019a = R$color.Transparent;
    }
}
