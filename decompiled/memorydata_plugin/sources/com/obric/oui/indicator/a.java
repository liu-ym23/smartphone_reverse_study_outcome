package com.obric.oui.indicator;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\u0012\u0012\u0004\u0012\u0002H\u00060\u0007j\b\u0012\u0004\u0012\u0002H\u0006`\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\n\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\r2\u0006\u0010\u0010\u001a\u00020\n\u001a\u0012\u0010\u0011\u001a\u00020\f*\u00020\r2\u0006\u0010\u0012\u001a\u00020\n\"\u0017\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u0013"}, d2 = {"isEmpty", "", "Landroidx/viewpager/widget/ViewPager;", "(Landroidx/viewpager/widget/ViewPager;)Z", "isNotEmpty", "isInBounds", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "", "setHorizontalMargin", "", "Landroid/view/View;", "margin", "setMarginBottom", "marginBottom", "setWidth", "width", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class a {
    public static final void a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.getLayoutParams().width = r2;
        r1.requestLayout();
    }

    public static final boolean a(ViewPager r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        PagerAdapter r2 = r1.getAdapter();
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        if (r3 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = r2.getCount();
        goto L6
    }

    public static final void b(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(r5);
        r1.setMarginEnd(r5);
        r4.requestLayout();
        r3 = r1;
    L9:
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
