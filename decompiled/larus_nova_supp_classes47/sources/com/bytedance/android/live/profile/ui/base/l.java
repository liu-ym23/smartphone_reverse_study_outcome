package com.bytedance.android.live.profile.ui.base;

import androidx.fragment.app.Fragment;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface l {
    NewProfileInfoViewModel a();

    com.bytedance.android.live.profile.profilecontext.a b();

    int c();

    Fragment getHostFragment();

    int getTargetType();

    boolean isVertical();
}
