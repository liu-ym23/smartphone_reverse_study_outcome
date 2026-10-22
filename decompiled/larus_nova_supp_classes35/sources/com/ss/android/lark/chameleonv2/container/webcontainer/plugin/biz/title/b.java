package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.d;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chameleon.widgetv2.titlebar.CmlCommonTitleBar;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonFragmentV2;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import swb.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements TitleBar {
    public final a a;
    public final CmlCommonTitleBar b;
    public final d c;

    public interface a {
        FragmentActivity getActivity();
    }

    public final /* synthetic */ View a() {
        return null;
    }

    public final void b(TitleBar.TitleGravity r1) {
    }

    public final void c(TitleBar.a r1) {
    }

    public final void clearMenus() {
    }

    public final boolean e(String r1, Drawable r2) {
        return false;
    }

    public final void enableTitleBarAlwaysShowing(boolean r1) {
    }

    public final void f() {
    }

    public final View findMenuView(String r1) {
        return null;
    }

    public final void g(TitleBar.a r1) {
    }

    public final /* synthetic */ BaseTitleBar getTitleBarLayout() {
        return null;
    }

    public final void h() {
    }

    public final void hide(boolean r1) {
    }

    public final List<MenuItem> i(TitleBar.MenuType r1) {
        return null;
    }

    public final boolean isLeftIconVisible() {
        return false;
    }

    public final void j(List<MenuItem> r1, TitleBar.MenuType r2) {
    }

    public final void k(TitleBar.b r1) {
    }

    public final void setHiddenMenus(List<MenuItem> r1) {
    }

    public final void setLeftIconVisibility(boolean r1) {
    }

    public final void setMenuIconTint(int r1) {
    }

    public final void setRiskFlag(boolean r1) {
    }

    public final void setSubTitle(CharSequence r1) {
    }

    public final void invalidate() {
        this.b.invalidate();
    }

    public final void d() {
        this.b.setMainTitleColor(2131106622);
    }

    public final d getDeviceInfo() {
        return this.c;
    }

    public b(ChameleonFragmentV2.b r4) {
        d r0 = new d();
        this.c = r0;
        this.a = r4;
        CmlCommonTitleBar r1 = r4.a();
        this.b = r1;
        r1.setImmersive(true);
        if (r4.b().booleanValue() == false) goto L5;
        r1.setVisibility(0);
        r0.e = true;
        r1.setDividerVisible(false);
        r1.setTitle(BuildConfig.FLAVOR);
        r1.setLeftClickListener(new com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.a(this));
        return;
    L5:
        r1.setVisibility(8);
    }

    public final void setBackground(int r2) {
        this.b.setBackgroundColor(r2);
    }

    public final void setLeftClickListener(View.OnClickListener r2) {
        this.b.setLeftClickListener(r2);
    }

    public final void setLeftVisible(boolean r2) {
        this.b.setLeftVisible(r2);
    }

    public final void setRightVisible(boolean r2) {
        this.b.setRightVisible(r2);
    }

    public final void setTitle(CharSequence r2) {
        this.b.setTitle(r2);
    }

    public final void setTitleSize(int r3) {
        a r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getActivity() == null) goto L9;
        FragmentActivity r1 = this.a.getActivity();
        int r4 = (int) this.a.getActivity().getResources().getDimension(r3);
        p.a r2 = p.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r5 = r1.getResources();
        this.b.setMainTitleSize((int) ((r4 / WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).scaledDensity) + 0.5f));
        return;
    }

    public final void setTitleVisibility(boolean r2) {
        this.b.setMainTitleVisible(r2);
    }

    public final void setTransparent(boolean r2) {
        CmlCommonTitleBar r0 = this.b;
        if (r2 == false) goto L5;
        float r3 = 0.0f;
    L6:
        r0.setAlpha(r3);
        return;
    L5:
        r3 = 1.0f;
        goto L6
    }

    public final void show(boolean r3) {
        j.e("CML_TAG_TitleBar", "show animation:" + r3);
    }
}
