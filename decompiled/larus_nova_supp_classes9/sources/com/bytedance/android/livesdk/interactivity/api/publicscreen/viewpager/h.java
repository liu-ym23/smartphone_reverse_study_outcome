package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ PublicScreenAreaPagerIndicatorV2 a;
    public final /* synthetic */ PublicScreenAreaPagerIndicatorV2.TabView b;

    public h(PublicScreenAreaPagerIndicatorV2 r1, PublicScreenAreaPagerIndicatorV2.TabView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        PublicScreenAreaPageType r4 = this.b.e;
        ViewPager r0 = this.a.c;
        if ((r0 instanceof PublicScreenAreaPagerLayout) == true) goto L5;
        r0 = null;
    L5:
        PublicScreenAreaPagerLayout r1 = (PublicScreenAreaPagerLayout) r0;
        if (r1 == null) goto L9;
        r1.k(r4, PublicScreenAreaPageChangeSource.TabClick);
        return;
    }
}
