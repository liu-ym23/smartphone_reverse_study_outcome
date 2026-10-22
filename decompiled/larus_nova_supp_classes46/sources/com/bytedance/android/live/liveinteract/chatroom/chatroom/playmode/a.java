package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends xh0.d {
    boolean b(int r1);

    void clear();

    void d(DataCenter r1);

    void f(DataCenter r1);

    void g(DataCenter r1, BaseLinkMultiControlWidget.a r2);

    boolean l(DataCenter r1);

    void m(Widget r1, SceneType r2);

    boolean n(int r1);

    void o(DataCenter r1, Widget r2, SceneType r3, ViewGroup r4);

    void p(Widget r1, SceneType r2, ne0.c r3, boolean r4);
}
