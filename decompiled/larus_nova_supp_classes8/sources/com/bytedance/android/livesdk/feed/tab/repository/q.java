package com.bytedance.android.livesdk.feed.tab.repository;

import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface q {
    boolean a(List<com.bytedance.android.livesdk.feed.feed.e> r1);

    List<com.bytedance.android.livesdk.feed.feed.e> b();

    boolean c(com.bytedance.android.livesdk.feed.feed.f r1);

    void d();

    Observable<List<com.bytedance.android.livesdk.feed.feed.e>> e();

    com.bytedance.android.livesdk.feed.feed.e f(long r1);

    com.bytedance.android.livesdk.feed.feed.f getExtra();
}
