package com.bytedance.android.live.anchormodelink.impl;

import android.view.SurfaceView;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.ies.sdk.widgets.Widget;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ny.o;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements js0.b {
    public final /* synthetic */ AnchorModeLinkDynamicWidget.f a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ String c;
    public final /* synthetic */ o d;

    public final void onSuccess(String r9) {
        Intrinsics.checkNotNullParameter(r9, "track");
        Ref.ObjectRef r11 = this.b;
        AnchorModeLinkDynamicWidget.f r0 = this.a;
        String r3 = this.c;
        o r1 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "setupLiveLinkParams");
        m00.g r2 = ((IMiddlewareBroadcastService) k.n(IMiddlewareBroadcastService.class)).createVideoTalkView(((Widget) r0.a).context, r3, false, true, false, new g());
        if (r2 == null) goto L5;
        r2.h();
    L6:
        AnchorModeLinkDynamicWidget r4 = r0.a;
        if (r4.e == null) goto L13;
        SurfaceView r5 = (SurfaceView) r4.l.getValue();
        boolean r6 = iy.b.a;
        iy.b.d("[SingleSurfaceViewManager] setDisplay，liveVideoClient=" + r2 + "，singleViewContainer=" + r5);
        if (r2 == null) goto L13;
        d0 r7 = r2.getLiveCore();
        if (r7 == null) goto L13;
        r7.x();
    L13:
        r11.element = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public f(AnchorModeLinkDynamicWidget.f r1, Ref.ObjectRef r2, String r3, o r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
