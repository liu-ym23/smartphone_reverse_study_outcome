package b41;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.model.StrictMeasureData;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final b a;
    public IRenderView b;
    public RevSeiFrame c;
    public boolean d;
    public boolean e;
    public qc0.e f;
    public final c41.a g;
    public final d h;

    public final void a() {
        ALogger.e("RevPkFullFeedView", "reset");
        if (this.e == true) goto L5;
        return;
    L5:
        AbsLivePlayerView r0 = c();
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
        qc0.e r19 = this.f;
        if (r19 == null) goto L58;
        r19.onPkToNormal();
    L58:
        this.e = false;
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

    public final AbsLivePlayerView c() {
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

    public final void d() {
        if (this.d == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.player.vendor.link.a r0 = this.h.i;
        if (r0 != null) goto L8;
        return;
    L8:
        AbsLivePlayerView r1 = c();
        ViewParent r2 = null;
        if (r1 == null) goto L11;
    L18:
        d r3 = this.h;
        Matrix r4 = r3.g;
        RectF r5 = r3.e;
        RectF r6 = r3.f;
        if (r4 == null) goto L76;
        if (r5 == null) goto L76;
        if (r6 == null) goto L76;
        if (r1 != null) goto L24;
    L70:
        RevSeiFrame r7 = this.c;
        MutableLiveData<g90.a> r8 = this.g.b;
        if (r7 == null) goto L74;
        String r9 = r7.C;
        if (r9 == null) goto L74;
    L75:
        r8.setValue(new g90.a(r4, r5, r9, o51.f.k.e.b));
        this.a.a(r0);
        return;
    L74:
        r9 = "";
        goto L75
    L24:
        if ((r0 instanceof com.bytedance.android.live.revenue.common.player.vendor.link.a.C0083a) == true) goto L70;
        AbsLivePlayerView r10 = c();
        boolean r12 = false;
        if (r10 == null) goto L57;
        ViewParent r13 = r10.getParent();
        if ((r13 instanceof ViewGroup) == true) goto L32;
        r13 = null;
    L32:
        ViewGroup r14 = (ViewGroup) r13;
        IRenderView r15 = r10.getRenderView();
        if (r14 == null) goto L35;
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
    L36:
        ViewGroup.LayoutParams r17 = r10.getLayoutParams();
        ViewGroup.LayoutParams r18 = r15.getLayoutParams();
        if (Intrinsics.areEqual(r16, r17) == false) goto L39;
    L42:
        ViewGroup.LayoutParams r19 = b(r14, null);
        if (r19 == null) goto L50;
        ViewGroup.LayoutParams r110 = b(r10, null);
        if (r110 == null) goto L50;
        ViewGroup.LayoutParams r111 = b(null, r10);
        if (r111 == null) goto L50;
        if (r14 == null) goto L53;
        r14.setLayoutParams(r19);
    L53:
        r10.setLayoutParams(r110);
        r15.setLayoutParams(r111);
        boolean r20 = true;
    L54:
        if (r20 == false) goto L57;
    L56:
        r12 = true;
    L50:
        r20 = false;
        goto L54
    L39:
        if (Intrinsics.areEqual(r16, r18) == true) goto L42;
        if (Intrinsics.areEqual(r17, r18) == false) goto L56;
    L35:
        r16 = null;
    L57:
        if (r12 == true) goto L59;
        ALogger.i("RevPkFullFeedView", "prepare env failed, player = " + r1 + ", player parent = " + r1.getParent() + ", render = " + r1.getRenderView());
        goto L70
    L59:
        this.h.getClass();
        Intrinsics.checkNotNullParameter(r1, "playerView");
        ViewParent r22 = r1.getParent();
        if ((r22 instanceof ViewGroup) == false) goto L63;
        r2 = r22;
    L63:
        d.b((ViewGroup) r2);
        d.b(r1);
        d r23 = this.h;
        IRenderView r24 = r1.getRenderView();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "renderView");
        Intrinsics.checkNotNullParameter(r6, "layoutData");
        int r25 = (int) r6.width();
        int r26 = (int) r6.height();
        int r27 = (int) r6.top;
        int r28 = (int) r6.left;
        r24.setScaleType(4);
        r24.setStrictMeasureData(new StrictMeasureData(r25, r26));
        if ((r24.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L69;
        FrameLayout.LayoutParams r29 = new FrameLayout.LayoutParams(r25, r26);
        r29.gravity = 51;
        r29.topMargin = r27;
        r29.leftMargin = r28;
        if (d.a(r24.getLayoutParams(), r29) == true) goto L69;
        r24.setLayoutParams(r29);
    L69:
        this.e = true;
    L76:
        a();
        this.g.b.setValue(null);
        this.a.a(null);
        return;
    L11:
        if ((r0 instanceof com.bytedance.android.live.revenue.common.player.vendor.link.a.C0083a) == false) goto L78;
        IRenderView r30 = this.b;
        if (r30 == null) goto L15;
        ViewParent r32 = r30.getParent();
    L17:
        if ((r32 instanceof AbsLivePlayerView) == false) goto L18;
        return;
    L15:
        r32 = null;
        goto L17
    }

    public static ViewGroup.LayoutParams b(View r2, AbsLivePlayerView r3) {
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

    public e(c41.a r2, d r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "pkFeedLayout");
        this.g = r2;
        this.h = r3;
        this.a = new b(r2, r4);
    }
}
