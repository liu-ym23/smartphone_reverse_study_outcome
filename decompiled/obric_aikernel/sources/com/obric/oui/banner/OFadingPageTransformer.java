package com.obric.oui.banner;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u0011\u0012\b\b\u0003\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0007\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0003J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0017R\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/banner/OFadingPageTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "Lkotlin/Function0;", "", "actionWithTargetApi", "actionWithLowerApi", "checkSdk", "Landroid/view/View;", "view", "", "position", "transformPage", "", "transformColor", "I", "getTransformColor", "()I", "<init>", "(I)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {
    public static final a Companion = null;
    private static final int FOREGROUND_ALPHA = 255;
    private static final float MIN_ALPHA = 0.5f;
    private final int transformColor;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public OFadingPageTransformer() {
        this(0, 1, null);
    }

    public OFadingPageTransformer(@ColorRes int r10) {
        this.transformColor = r10;
    }

    public /* synthetic */ OFadingPageTransformer(int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = u8.c.Transparent;
    L5:
        this(r10);
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private final void checkSdk(Function0<Unit> r10, Function0<Unit> r11) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r10.invoke();
        return;
    L5:
        r11.invoke();
    }

    public final int getTransformColor() {
        return this.transformColor;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    @SuppressLint({"AnnotateVersionCheck"})
    public void transformPage(final View r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        checkSdk(new AnonymousClass1(this, r10), AnonymousClass2.INSTANCE);
        if (r11 >= (-1)) goto L6;
        Function0<Unit> r12 = new AnonymousClass3(r10);
        Function0<Unit> r13 = new AnonymousClass4(r10);
    L5:
        checkSdk(r12, r13);
        return;
    L6:
        float r14 = 1;
        if (r11 > r14) goto L9;
        final float r15 = Math.max(0.5f, r14 - Math.abs(r11));
        checkSdk(new AnonymousClass5(r10, r15), new AnonymousClass6(r10, r15));
        return;
    L9:
        r12 = new AnonymousClass7(r10);
        r13 = new AnonymousClass8(r10);
        goto L5
    }
}
