package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ FollowMVIView a;
    public final /* synthetic */ long b;

    public g(FollowMVIView r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r5, Throwable r6) {
        long r0 = SystemClock.uptimeMillis() - this.b;
        com.bytedance.android.live.profit.privilege.e r7 = com.bytedance.android.live.profit.privilege.e.a;
        Integer r8 = null;
        if (r6 == null) goto L5;
        String r2 = q0.a(r6);
    L6:
        if (r6 == null) goto L8;
        r8 = Integer.valueOf(r0.a(r6));
    L8:
        JSONObject r9 = com.bytedance.android.live.profit.privilege.e.k(false, r2, r8);
        JSONObject r10 = com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r0));
        JSONObject r1 = new JSONObject();
        com.bytedance.android.live.profit.privilege.e.p("ttilive_tick_anim_status_all", r9, r10, r1);
        com.bytedance.android.live.profit.privilege.e.p("ttilive_tick_anim_status_error", r9, r10, r1);
        FollowMVIView r12 = this.a;
        r12.o(new eu0.a0(r12.r));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
        ImageInfo r6 = (ImageInfo) r4;
        Intrinsics.checkNotNullParameter(r3, "id");
        if ((r5 instanceof AnimatedDrawable2) == false) goto L6;
        long r7 = SystemClock.uptimeMillis() - this.b;
        com.bytedance.android.live.profit.privilege.e r0 = com.bytedance.android.live.profit.privilege.e.a;
        com.bytedance.android.live.profit.privilege.e.p("ttilive_tick_anim_status_all", com.bytedance.android.live.profit.privilege.e.k(true, null, null), com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r7)), new JSONObject());
        ((AnimatedDrawable2) r5).setAnimationListener(new f(this));
        return;
    }
}
