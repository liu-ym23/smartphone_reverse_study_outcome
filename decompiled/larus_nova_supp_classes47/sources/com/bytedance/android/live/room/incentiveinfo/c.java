package com.bytedance.android.live.room.incentiveinfo;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements u81.e {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // u81.e
    public final void a() {
    }

    @Override // u81.e
    public final void b() {
    }

    @Override // u81.e
    public final Animation c() {
        TranslateAnimation r9 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.0f, 1, -1.0f);
        r9.setDuration(500);
        r9.setFillAfter(true);
        return r9;
    }

    @Override // u81.e
    public final Animation d() {
        TranslateAnimation r9 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 1.0f, 1, 0.0f);
        r9.setDuration(500);
        r9.setFillAfter(true);
        return r9;
    }

    public final void e(View r3, b r4) {
        Intrinsics.checkNotNullParameter(r3, "enterView");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r3, "enterView");
        Intrinsics.checkNotNullParameter(r4, "listener");
    }
}
