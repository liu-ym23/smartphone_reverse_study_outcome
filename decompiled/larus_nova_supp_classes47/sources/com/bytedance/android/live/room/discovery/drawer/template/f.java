package com.bytedance.android.live.room.discovery.drawer.template;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdkapi.depend.model.live.DrawerConfig;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends BaseControllerListener<Object> {
    public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

    public f(LiveDrawerEntranceCommonWidget r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        DrawerConfig r5 = this.a.b;
        if (r5 == null) goto L11;
        DrawerConfig.EntranceIcon r6 = r5.getEntranceIcon();
        if (r6 == null) goto L11;
        if (r6.getAnimShowMethod() != 2) goto L11;
        LiveDrawerEntranceCommonWidget r7 = this.a;
        r7.getClass();
        if ((r4 instanceof AnimatedDrawable2) == false) goto L11;
        ((AnimatedDrawable2) r4).setAnimationListener(new a(r7, r4));
    L11:
        if (r4 == null) goto L14;
        r4.start();
        return;
    }
}
