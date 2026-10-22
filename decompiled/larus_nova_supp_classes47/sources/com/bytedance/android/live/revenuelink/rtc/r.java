package com.bytedance.android.live.revenuelink.rtc;

import android.view.SurfaceView;
import android.view.TextureView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public static final void a(AnchorRtcManager r3, String r4, Object r5, int r6, int r7, List<? extends g> r8) {
        Intrinsics.checkNotNullParameter(r3, "$this$onViewFirstRemoteVideoFrame");
        Intrinsics.checkNotNullParameter(r4, "interactId");
        Intrinsics.checkNotNullParameter(r8, "rtcListeners");
        boolean r9 = r5 instanceof SurfaceView;
        if (r9 == false) goto L12;
        Iterator r10 = ((CopyOnWriteArrayList) r8).iterator();
    L6:
        if (r10.hasNext() == false) goto L29;
        g r1 = (g) r10.next();
        if (r9 == true) goto L10;
        Object r2 = null;
    L11:
        r1.h1(r4, (SurfaceView) r2, r7, r6);
        goto L6
    L10:
        r2 = r5;
        goto L11
    L29:
        return;
    L12:
        boolean r12 = r5 instanceof TextureView;
        if (r12 == false) goto L22;
        Iterator r13 = ((CopyOnWriteArrayList) r8).iterator();
    L16:
        if (r13.hasNext() == false) goto L30;
        g r14 = (g) r13.next();
        if (r12 == true) goto L20;
        Object r15 = null;
    L21:
        r14.L0(r4, (TextureView) r15, r7, r6);
        goto L16
    L20:
        r15 = r5;
        goto L21
    L30:
        return;
    }

    public static final void b(AnchorRtcManager r3, String r4, Object r5, int r6, int r7, List<? extends g> r8) {
        Intrinsics.checkNotNullParameter(r3, "$this$onViewFirstRemoteVideoFrameRender");
        Intrinsics.checkNotNullParameter(r4, "interactId");
        Intrinsics.checkNotNullParameter(r8, "rtcListeners");
        boolean r9 = r5 instanceof SurfaceView;
        if (r9 == false) goto L12;
        Iterator r10 = ((CopyOnWriteArrayList) r8).iterator();
    L6:
        if (r10.hasNext() == false) goto L29;
        g r1 = (g) r10.next();
        if (r9 == true) goto L10;
        Object r2 = null;
    L11:
        r1.y0(r4, (SurfaceView) r2, r7, r6);
        goto L6
    L10:
        r2 = r5;
        goto L11
    L29:
        return;
    L12:
        boolean r12 = r5 instanceof TextureView;
        if (r12 == false) goto L22;
        Iterator r13 = ((CopyOnWriteArrayList) r8).iterator();
    L16:
        if (r13.hasNext() == false) goto L30;
        g r14 = (g) r13.next();
        if (r12 == true) goto L20;
        Object r15 = null;
    L21:
        r14.j0(r4, (TextureView) r15, r7, r6);
        goto L16
    L20:
        r15 = r5;
        goto L21
    L30:
        return;
    }
}
