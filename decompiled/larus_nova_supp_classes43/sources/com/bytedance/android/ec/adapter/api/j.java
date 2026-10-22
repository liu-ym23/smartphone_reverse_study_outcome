package com.bytedance.android.ec.adapter.api;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface j {
    void a(DialogFragment r1, FrameLayout r10, a r11);

    void b(Activity r1);

    void c(Activity r1, a r10);

    boolean checkWindowConflict();

    void d(Object r1);

    void e(Activity r1, a r10);

    Object f(com.bytedance.android.ec.model.j r1);

    void g(DialogFragment r1, FrameLayout r10);

    boolean isFloatWindowShowing();

    void setFloatWindowBottomMargin(int r1);

    void stopShowFloat();

    void stopShowFloatInNextLifecycle();

    void stopShowNow();

    void toggleLiveAudio(boolean r1);
}
