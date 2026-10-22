package com.bytedance.android.livesdk.dislike.preload.context;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.revenue.platform.api.core.rx.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {
    void a();

    ActionsManager b();

    n c();

    void d(boolean r1);

    DataCenter getDataCenter();

    Fragment getFragment();
}
