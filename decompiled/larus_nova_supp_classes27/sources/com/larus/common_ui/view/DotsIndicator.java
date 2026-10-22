package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/common_ui/view/DotsIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linearLayout", "Landroid/widget/LinearLayout;", "dotsSize", "dotsSpacing", "dots", "", "Landroid/widget/ImageView;", "init", "", "addDots", "size", "initIndex", "addDot", "clearDots", "refreshDotColor", "index", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DotsIndicator extends FrameLayout {
    public LinearLayout a;
    public final int b;
    public final int c;
    public final List<ImageView> d;

    public DotsIndicator(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DotsIndicator(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a(int r5) {
        int r0 = this.d.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r1 != r5) goto L6;
        ((ImageView) ListProtector.get(this.d, r1)).setImageResource(2131242794);
    L7:
        r1 = r1 + 1;
        goto L3
    L6:
        ((ImageView) ListProtector.get(this.d, r1)).setImageResource(2131242861);
        goto L7
    }

    public DotsIndicator(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        AppHost.Companion r7 = AppHost.a;
        LinearLayout r2 = null;
        this.b = r7.getApplication().getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462));
        this.c = r7.getApplication().getResources().getDimensionPixelSize(v19.c.b(2130971367, null, 2131167105));
        this.d = new ArrayList();
        LinearLayout r8 = new LinearLayout(getContext());
        this.a = r8;
        r8.setOrientation(0);
        LinearLayout r9 = this.a;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L6:
        addView(r2, -2, -2);
        if (r5 == null) goto L10;
        getContext().obtainStyledAttributes(r5, new int[0]).recycle();
        return;
    L10:
        return;
    L5:
        r2 = r9;
        goto L6
    }

    public /* synthetic */ DotsIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
