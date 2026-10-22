package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.DeviceInfo;
import com.ss.android.lark.chameleon.pluginsystem.plugin.MenuItem;
import com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar;
import com.ss.android.lark.chameleon.util.UiUtils;
import com.ss.android.lark.chameleon.widget.titlebar.CommonTitleBar;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class WebContainerTitleBar implements TitleBar {
    private static final String TAG = "CML_TAG_TitleBar";
    private Delegate delegate;
    private DeviceInfo mDeviceInfo;
    private CommonTitleBar titleBarLayout;
    private TitleBar.TitleGravity titleGravity;

    public interface Delegate {
        FragmentActivity getActivity();

        CommonTitleBar getTitleBarLayout();

        LifecycleOwner getTitleBarLifecycleOwner();

        Boolean showTitlebar();
    }

    public static /* synthetic */ void a(WebContainerTitleBar r0, View r1) {
        r0.lambda$initTitleBarLayout$0(r1);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void addCustomSecondRightView(View r1, ViewGroup.LayoutParams r2) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void addTitleBarStateChangedListener(TitleBar.OnTitleBarStateChangedListener r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void clearMenus() {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void enableTitleBarAlwaysShowing(boolean r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public View findMenuView(String r1) {
        return null;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public List<MenuItem> getMenus(TitleBar.MenuType r1) {
        return null;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public CharSequence getTitle() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public CommonTitleBar getTitleBarLayout() {
        return null;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void hide(boolean r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public boolean isLeftIconVisible() {
        return false;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void removeTitleBarStateChangedListener(TitleBar.OnTitleBarStateChangedListener r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setExternalTagEnabled(boolean r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setHiddenMenus(List<MenuItem> r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setLeftIconTint(int r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setLeftIconVisibility(boolean r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setMenuIconTint(int r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setMenus(List<MenuItem> r1, TitleBar.MenuType r2) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setRiskFlag(boolean r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setSecondTitle(CharSequence r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setSecondTitleLeftDrawable(Drawable r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setSpaceTagTitleBarEnabled(TitleBar.SpaceTagInfoChangeListener r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setSpaceTagTitleBarEnabled(boolean r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setStatusBarTransparent(boolean r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setSubTitle(CharSequence r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setSubTitleSuffix(CharSequence r1) {
    }

    private void initTitleBarLayout() {
        this.titleBarLayout.setVisibility(0);
        this.mDeviceInfo.titleBarVisible = true;
        this.titleBarLayout.setDividerVisible(false);
        this.titleBarLayout.setTitle(BuildConfig.FLAVOR);
        this.titleBarLayout.setLeftClickListener(new b(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void invalidate() {
        this.titleBarLayout.invalidate();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public DeviceInfo getDeviceInfo() {
        return this.mDeviceInfo;
    }

    public WebContainerTitleBar(Delegate r3) {
        this.titleGravity = TitleBar.TitleGravity.Center;
        this.mDeviceInfo = new DeviceInfo();
        this.delegate = r3;
        CommonTitleBar r0 = r3.getTitleBarLayout();
        this.titleBarLayout = r0;
        r0.setImmersive(false);
        if (r3.showTitlebar().booleanValue() == false) goto L5;
        initTitleBarLayout();
        return;
    L5:
        this.titleBarLayout.setVisibility(8);
    }

    private /* synthetic */ void lambda$initTitleBarLayout$0(View r1) {
        if (UiUtils.isActivityRunning(this.delegate.getActivity()) == false) goto L6;
        this.delegate.getActivity().onBackPressed();
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setBackground(int r2) {
        this.titleBarLayout.setBackgroundColor(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setDividerVisible(boolean r2) {
        this.titleBarLayout.setDividerVisible(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setLeftClickListener(View.OnClickListener r2) {
        this.titleBarLayout.setLeftClickListener(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setLeftVisible(boolean r2) {
        this.titleBarLayout.setLeftVisible(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setRightVisible(boolean r2) {
        this.titleBarLayout.setRightVisible(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setSecondTitleVisibility(boolean r2) {
        this.titleBarLayout.setSubTitleVisible(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setTitle(CharSequence r3) {
        if (this.titleGravity != TitleBar.TitleGravity.Center) goto L5;
        this.titleBarLayout.setTitle(r3);
        return;
    L5:
        this.titleBarLayout.setLeftText(r3);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setTitleGravity(TitleBar.TitleGravity r1) {
        this.titleGravity = r1;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setTitleSize(int r2) {
        Delegate r0 = this.delegate;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getActivity() == null) goto L9;
        this.titleBarLayout.setMainTitleSize(UiUtils.px2sp((int) this.delegate.getActivity().getResources().getDimension(r2)));
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setTitleTextColor(int r2) {
        this.titleBarLayout.setMainTitleColor(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setTitleVisibility(boolean r2) {
        this.titleBarLayout.setMainTitleVisible(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void setTransparent(boolean r2) {
        CommonTitleBar r0 = this.titleBarLayout;
        if (r2 == false) goto L5;
        float r3 = 0.0f;
    L6:
        r0.setAlpha(r3);
        return;
    L5:
        r3 = 1.0f;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar
    public void show(boolean r3) {
        Log.i(TAG, "show animation:" + r3);
    }
}
