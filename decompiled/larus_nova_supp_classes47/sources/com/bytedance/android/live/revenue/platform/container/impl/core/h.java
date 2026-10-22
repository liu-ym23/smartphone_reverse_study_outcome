package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface h {
    zy0.b D();

    BehaviorSubject a();

    void b(NotifyServiceCenterStateRequest r1);

    RevenueJsDriver c();

    void d();

    String getServiceVersion();

    void onStart();

    void onWidgetLoaded();
}
