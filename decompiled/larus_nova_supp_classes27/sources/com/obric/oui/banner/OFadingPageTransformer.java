package com.obric.oui.banner;

import android.os.Build;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/banner/OFadingPageTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {
    public final int a;

    public static final class a {
    }

    static {
    }

    public OFadingPageTransformer() {
        this(0);
    }

    public OFadingPageTransformer(int r1) {
        this.a = 2131100067;
    }

    public final void a(Function0<Unit> r3, Function0<Unit> r4) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r3.invoke();
        return;
    L5:
        r4.invoke();
    }

    public final void transformPage(final View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        a(new AnonymousClass1(r3, this), AnonymousClass2.INSTANCE);
        if (r4 >= (-1.0f)) goto L6;
        a(new AnonymousClass3(r3), new AnonymousClass4(r3));
        return;
    L6:
        if (r4 > 1.0f) goto L8;
        final float r5 = Math.max(0.5f, 1 - Math.abs(r4));
        a(new AnonymousClass5(r3, r5), new AnonymousClass6(r3, r5));
        return;
    L8:
        a(new AnonymousClass7(r3), new AnonymousClass8(r3));
    }
}
