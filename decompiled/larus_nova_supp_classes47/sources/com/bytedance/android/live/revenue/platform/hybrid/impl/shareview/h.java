package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleEventObserver;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ RevShareViewServiceImpl a;
    public final /* synthetic */ Context b;

    public h(RevShareViewServiceImpl r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r5 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c) r4;
        Intrinsics.checkNotNullParameter(r5, "sharer");
        final RevShareViewServiceImpl$waitSharer$3$1 r0 = new RevShareViewServiceImpl$waitSharer$3$1(this, r5);
        LifecycleEventObserver r1 = new RevShareViewServiceImpl$waitSharer$3$observer$1(this, r0);
        if (((Activity) this.b).isDestroyed() == true) goto L6;
        r5.b();
        this.b.getLifecycle().addObserver(r1);
        this.a.b.put(this.b, new l.a(r5));
        return r5;
    L6:
        r0.m429invoke();
        throw new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "context has been destroyed");
    }
}
