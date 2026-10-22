package com.lynx.xelement.viewpager.viewpager;

import android.content.Context;
import com.lynx.xelement.viewpager.Pager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import x6a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends Pager<CustomViewPager> {
    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        d.k(this, r1);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        d.l(this, r1);
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(new CustomViewPager(r2), r2);
    }

    public final void setForceCanScroll(boolean r2) {
        getMViewPager().setMForceCanScroll(r2);
    }

    public final void setPagerChangeAnimation(boolean r2) {
        getMViewPager().setMPagerChangeAnimation(r2);
    }

    public final void setViewPagerOverScrollMode(boolean r2) {
        if (r2 == false) goto L4;
        ((CustomViewPager) getMViewPager()).setOverScrollMode(0);
        return;
    L4:
        ((CustomViewPager) getMViewPager()).setOverScrollMode(2);
    }
}
