package com.bytedance.android.live.profile.ui.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d {
    <T extends View> T a(int r1);

    void addView(View r1, ViewGroup.LayoutParams r2);

    View b(ProfilePreInflateViewInfo r1, boolean r2);

    void c(int r1);

    boolean d(int r1);

    void e(View r1);

    View f(int r1, boolean r2);

    Context getContext();

    void removeAllViews();

    void removeView(View r1);
}
