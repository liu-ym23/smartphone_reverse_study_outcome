package com.bytedance.android.annie.container.dialog;

import android.os.Bundle;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface l {
    void attach(FrameLayout r1, ia.f r10, t36.f r11, boolean r12);

    boolean getModStatusBar();

    void handlePullStateChange(int r1);

    boolean needAdapterStatusBarColor();

    void onActivityCreatedProxy(Bundle r1);

    void onDestroyProxy();

    void onDestroyViewProxy();

    void setModStatusBar(boolean r1);
}
