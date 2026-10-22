package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.obric.common.oea.foundation.blur.BlurUtils;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "getNavigationBar", "", "radius", "", "setMaskBlurRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomNavigationBar extends OUIFrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final OBottomNavActionBar f7279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final View f7280m;

    @JvmOverloads
    public OBottomNavigationBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OBottomNavigationBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OBottomNavigationBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, null, 8, null);
        LayoutInflater.from(r10).inflate(h.layout_custom_bottom_navigation, this, true);
        View r13 = findViewById(f.bottom_nav_bar);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.bottom_nav_bar)");
        OBottomNavActionBar r14 = (OBottomNavActionBar) r13;
        this.f7279l = r14;
        View r15 = findViewById(f.mask_view);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.mask_view)");
        this.f7280m = r15;
        r14.q(r10, r11);
        TypedArray r16 = r10.obtainStyledAttributes(r11, l.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r16, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        setMaskBlurRadius(r16.getDimension(l.OTabLayout_mask_blur_radius, 0.0f));
        r16.recycle();
    }

    public /* synthetic */ OBottomNavigationBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final void c(boolean r10) {
        View r11 = this.f7280m;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 4;
        goto L6
    }

    public final OBottomNavActionBar getNavigationBar() {
        return this.f7279l;
    }

    public final void setMaskBlurRadius(float r10) {
        BlurUtils.b(this.f7280m, BlurUtils.BlurType.PROGRESS_BLUR_UP_DOWN, 8.0f);
        if (r10 == 0.0f) goto L5;
        boolean r11 = true;
    L6:
        c(r11);
        return;
    L5:
        r11 = false;
        goto L6
    }
}
