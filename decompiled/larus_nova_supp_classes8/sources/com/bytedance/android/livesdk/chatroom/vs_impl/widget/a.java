package com.bytedance.android.livesdk.chatroom.vs_impl.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessScreenBarConfigure;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends BaseAnimationListener {
    public final /* synthetic */ BusinessScreenBarWidget.f a;

    public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
    }

    public final void onAnimationStop(AnimatedDrawable2 r1) {
    }

    public a(BusinessScreenBarWidget.f r1) {
        this.a = r1;
    }

    public final void onAnimationStart(AnimatedDrawable2 r4) {
        BusinessScreenBarWidget.xq(this.a.b, true);
        int r5 = sr1.a.a;
        k r2 = null;
        sr1.a.c("activity_ad_show", "video_bottom", this.a.b.k, null);
        BusinessScreenBarWidget.f r6 = this.a;
        BusinessScreenBarWidget.wq(r6.b, Integer.valueOf(r6.a.displaySecond));
        StringBuilder r7 = new StringBuilder("start show dynamic screen bar ");
        BusinessResourceConfigure r0 = this.a.a.resourceConfig;
        if (r0 == null) goto L7;
        BusinessScreenBarConfigure r1 = r0.screenBarConfigure;
        if (r1 == null) goto L7;
        r2 = r1.getImage();
    L7:
        r7.append(r2);
        ALogger.i("BusinessConfigure", r7.toString());
    }
}
