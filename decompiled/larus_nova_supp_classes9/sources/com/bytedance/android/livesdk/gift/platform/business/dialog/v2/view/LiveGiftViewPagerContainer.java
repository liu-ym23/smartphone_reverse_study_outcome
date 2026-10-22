package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.util.c;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/LiveGiftViewPagerContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftViewPagerContainer extends FrameLayout {
    public int a;

    public LiveGiftViewPagerContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveGiftViewPagerContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (c.b() == true) goto L5;
        return;
    L5:
        if (c.a() >= 1) goto L7;
        return;
    L7:
        if (this.a <= 0) goto L9;
        return;
    L9:
        if (v.e() == true) goto L19;
        this.a = (int) (i.a(110) * c.a());
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L18;
        r0.height += this.a;
        return;
    L18:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        if (FoldScreenUtils.f() == true) goto L5;
        return;
    L5:
        if (nz1.a.q().b() == true) goto L7;
        return;
    L7:
        if (FoldScreenUtils.a() != 0) goto L9;
        a();
        return;
    L9:
        if (this.a > 0) goto L11;
        return;
    L11:
        if (v.e() == true) goto L20;
        ViewGroup.LayoutParams r4 = getLayoutParams();
        if (r4 == null) goto L21;
        r4.height -= this.a;
        this.a = 0;
        return;
    L21:
        return;
    }

    public LiveGiftViewPagerContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ LiveGiftViewPagerContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
