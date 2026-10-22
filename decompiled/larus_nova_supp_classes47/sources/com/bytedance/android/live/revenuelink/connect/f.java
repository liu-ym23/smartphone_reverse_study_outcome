package com.bytedance.android.live.revenuelink.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdk.link.model.bridge.r1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface f {
    void addLinkInListener(int r1, i r2);

    void addLinkOutListener(int r1, m r2);

    LiveData<ey.f> connectState();

    void fetchMultiChannelInfo(int r1, boolean r2, String r3, String r4, Function1<? super r1, Unit> r5, Function1<? super Throwable, Unit> r6);

    l linkInManager();

    n linkOutManager();

    void registerRefuseStrategy(int r1, q r2);

    void removeLinkInListener(int r1, i r2);

    void removeLinkOutListener(int r1, m r2);
}
