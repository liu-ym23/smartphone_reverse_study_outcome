package com.obric.oui.sheet.v2;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.obric.oui.dialog.alert.view.RadiusLayout;

/* JADX INFO: loaded from: classes3.dex */
public interface e {
    void a();

    boolean b();

    boolean d();

    boolean e();

    View f(int r5);

    void g();

    boolean getAutoAddBodyPaddingTopWhenOverlay();

    int getBgColor();

    FrameLayout getBodyContainer();

    int getBodyContentPaddingBottom();

    int getBodyContentPaddingTop();

    ComponentCallbacks getConfigurationCallback();

    boolean getConfigurationCallbackRegistered();

    View getDimView();

    boolean getEnableMaterial();

    FrameLayout getFooterContainer();

    Size getFullWindowSize();

    FrameLayout getHeaderContainer();

    OSheet$HeightMode getHeightStyle();

    boolean getIgnoreInsetBottom();

    RadiusLayout getRootContainer();

    jp.d getRunningAnim();

    ViewGroup getScaffoldContainer();

    m getScaffoldController();

    Context getSheetContext();

    boolean getShowing();

    int getUserWindowHeight();

    int getUserWindowWidth();

    Window h();

    void i();

    void j();

    void k();

    void setAutoAddBodyPaddingTopWhenOverlay(boolean r5);

    void setBgColor(int r5);

    void setBodyContainer(FrameLayout r5);

    void setBodyContentPaddingBottom(int r5);

    void setBodyContentPaddingTop(int r5);

    void setConfigurationCallbackRegistered(boolean r5);

    void setFooterContainer(FrameLayout r5);

    void setFullWindowSize(Size r5);

    void setHeaderContainer(FrameLayout r5);

    void setHeightStyle(OSheet$HeightMode r5);

    void setMCancelable(boolean r5);

    void setRootContainer(RadiusLayout r5);

    void setRunningAnim(jp.d r5);

    void setScaffoldContainer(ViewGroup r5);

    void setScaffoldController(m r5);

    void setupDimView(Context r5);
}
