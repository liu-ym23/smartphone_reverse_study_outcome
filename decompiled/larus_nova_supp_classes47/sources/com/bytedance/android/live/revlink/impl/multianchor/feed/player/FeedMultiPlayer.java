package com.bytedance.android.live.revlink.impl.multianchor.feed.player;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import b31.c;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.model.StrictMeasureData;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import k31.h;
import kc0.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiPlayer {
    public final Lazy a;
    public IRenderView b;
    public boolean c;
    public boolean d;
    public final b e;
    public final d f;

    public final void a() {
        if (this.c == true) goto L5;
        return;
    L5:
        AbsLivePlayerView r0 = d();
        if (r0 != null) goto L8;
        return;
    L8:
        h r1 = this.e.c;
        if (r1 == null) goto L56;
        AbsLivePlayerView r2 = d();
        boolean r3 = false;
        ViewParent r5 = null;
        if (r2 == null) goto L41;
        ViewParent r6 = r2.getParent();
        if ((r6 instanceof ViewGroup) == true) goto L16;
        r6 = null;
    L16:
        ViewGroup r7 = (ViewGroup) r6;
        IRenderView r8 = r2.getRenderView();
        if (r7 == null) goto L19;
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
    L20:
        ViewGroup.LayoutParams r10 = r2.getLayoutParams();
        ViewGroup.LayoutParams r12 = r8.getLayoutParams();
        if (Intrinsics.areEqual(r9, r10) == false) goto L23;
    L26:
        ViewGroup.LayoutParams r13 = c(r7, null);
        if (r13 == null) goto L34;
        ViewGroup.LayoutParams r14 = c(r2, null);
        if (r14 == null) goto L34;
        ViewGroup.LayoutParams r15 = c(null, r2);
        if (r15 == null) goto L34;
        if (r7 == null) goto L37;
        r7.setLayoutParams(r13);
    L37:
        r2.setLayoutParams(r14);
        r8.setLayoutParams(r15);
        boolean r4 = true;
    L38:
        if (r4 == false) goto L41;
    L40:
        r3 = true;
    L34:
        r4 = false;
        goto L38
    L23:
        if (Intrinsics.areEqual(r9, r12) == true) goto L26;
        if (Intrinsics.areEqual(r10, r12) == false) goto L40;
    L19:
        r9 = null;
    L41:
        if (r3 == true) goto L43;
        ALogger.i("MultiAnchorFeedView", "prepare env failed, player = " + r0 + ", player parent = " + r0.getParent() + ", render = " + r0.getRenderView());
        return;
    L43:
        this.e.getClass();
        Intrinsics.checkNotNullParameter(r0, "playerView");
        ViewParent r16 = r0.getParent();
        if ((r16 instanceof ViewGroup) == false) goto L47;
        r5 = r16;
    L47:
        b.d((ViewGroup) r5);
        b.d(r0);
        b r17 = this.e;
        IRenderView r18 = r0.getRenderView();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "renderView");
        Intrinsics.checkNotNullParameter(r1, "layoutData");
        r18.setScaleType(4);
        r18.setStrictMeasureData(new StrictMeasureData(r1.a, r1.b));
        if ((r18.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L54;
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(r1.a, r1.b);
        r19.gravity = c.a(r1.e);
        r19.topMargin = r1.c;
        r19.leftMargin = r1.d;
        if (b.c(r18.getLayoutParams(), r19) == true) goto L54;
        r18.setLayoutParams(r19);
    L54:
        if (this.d == true) goto L59;
        ((rc0.d) this.a.getValue()).a();
        this.d = true;
        return;
    L59:
        return;
    L56:
        b();
    }

    public final void b() {
        ALogger.e("MultiAnchorFeedView", "reset");
        if (this.d == true) goto L5;
        return;
    L5:
        AbsLivePlayerView r0 = d();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L8;
        ViewParent r2 = r0.getParent();
    L10:
        if ((r2 instanceof ViewGroup) == true) goto L12;
        r2 = null;
    L12:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L15;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L17:
        if ((r4 instanceof FrameLayout.LayoutParams) == true) goto L19;
        r4 = null;
    L19:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r4;
        if (r5 == null) goto L39;
        r5.gravity = 17;
        if (PadConfigUtils.a() == true) goto L24;
    L33:
        ViewParent r6 = r0.getParent();
        if ((r6 instanceof ViewGroup) == true) goto L36;
        r6 = null;
    L36:
        ViewGroup r7 = (ViewGroup) r6;
        if (r7 == null) goto L39;
        r7.setLayoutParams(r5);
        goto L39
    L24:
        if (e5.n() == false) goto L33;
        ILivePlayerClient r8 = r0.getClient();
        if (r8 == null) goto L29;
        Pair r9 = r8.getVideoSize();
        if (r9 == null) goto L29;
    L30:
        int r10 = ((Number) r9.component1()).intValue();
        int r12 = ((Number) r9.component2()).intValue();
        if (r12 == 0) goto L33;
        r5.width = (int) ((p.a.d() * r10) / r12);
    L29:
        r9 = new Pair(0, 0);
    L39:
        if (r0 == null) goto L41;
        ViewGroup.LayoutParams r13 = r0.getLayoutParams();
    L43:
        if ((r13 instanceof FrameLayout.LayoutParams) == false) goto L46;
        r1 = r13;
    L46:
        FrameLayout.LayoutParams r14 = (FrameLayout.LayoutParams) r1;
        if (r14 == null) goto L49;
        r14.gravity = 17;
        r0.setLayoutParams(r14);
    L49:
        IRenderView r15 = this.b;
        if (r15 == null) goto L52;
        r15.setScaleType(2);
    L52:
        IRenderView r16 = this.b;
        if (r16 == null) goto L55;
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-1, -1);
        r17.gravity = 17;
        Unit r18 = Unit.INSTANCE;
        r16.setLayoutParams(r17);
    L55:
        ((rc0.d) this.a.getValue()).c();
        this.d = false;
        return;
    L41:
        r13 = null;
        goto L43
    L15:
        r4 = null;
        goto L17
    L8:
        r2 = null;
        goto L10
    }

    public final AbsLivePlayerView d() {
        IRenderView r0 = this.b;
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof AbsLivePlayerView) == false) goto L11;
        r1 = r2;
    L11:
        return (AbsLivePlayerView) r1;
    L5:
        r2 = null;
        goto L7
    }

    public FeedMultiPlayer(b r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "feedMultiLayout");
        this.e = r2;
        this.f = r3;
        this.a = LazyKt.lazy(FeedMultiPlayer$multiPlayerMonitor$2.INSTANCE);
    }

    public static ViewGroup.LayoutParams c(View r2, AbsLivePlayerView r3) {
        if (r3 != null) goto L8;
        if (r2 == null) goto L6;
        r3 = r2.getParent();
        goto L8
    L6:
        r3 = null;
    L8:
        if ((r3 instanceof FrameLayout) == false) goto L12;
        return new FrameLayout.LayoutParams(-1, -1);
    L12:
        if ((r3 instanceof RelativeLayout) == true) goto L14;
        return null;
    L14:
        return new RelativeLayout.LayoutParams(-1, -1);
    }
}
