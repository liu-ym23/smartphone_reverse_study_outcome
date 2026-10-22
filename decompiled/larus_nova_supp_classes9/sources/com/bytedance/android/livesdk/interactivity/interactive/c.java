package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final IBannerInfo a;
    public boolean b;
    public final Object c;

    public c(IBannerInfo r2, boolean r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "bannerInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
