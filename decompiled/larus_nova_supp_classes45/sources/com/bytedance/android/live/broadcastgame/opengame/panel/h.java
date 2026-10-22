package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel$initPanelAndHide$3;
import com.bytedance.android.live.broadcastgame.opengame.runtime.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface h extends s<i> {
    void F();

    Context J();

    void K(boolean r1);

    void L0();

    void M(int r1);

    void V(boolean r1);

    void addTopMessageView(View r1);

    void addTopRightBtnView(View r1);

    OpenPanelType c();

    void dismiss();

    ViewGroup getContentView();

    PanelType getPanelType();

    void h();

    ViewGroup h0();

    void hide();

    void i();

    void i1(boolean r1);

    void init();

    boolean isShowing();

    void p(int r1);

    void r(PanelType r1);

    void show();

    void u0(Bitmap r1);

    Window v0();

    void z(LiveBasePluginWithPanel$initPanelAndHide$3.a r1);
}
