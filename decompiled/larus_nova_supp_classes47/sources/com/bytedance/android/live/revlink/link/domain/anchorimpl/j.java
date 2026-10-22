package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface j {
    void a(boolean r1);

    Disposable b(String r1, String r2, Function0<Unit> r3, Function1<? super Throwable, Unit> r4);

    void d(b r1);

    Disposable e(String r1, RevLiveFollowScene r2, Function0<Unit> r3, Function1<? super Throwable, Unit> r4);

    void g();

    com.bytedance.android.live.revlink.impl.multianchor.widget.h h();

    void j(f31.f r1);
}
