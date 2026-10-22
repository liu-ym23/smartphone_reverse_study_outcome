package com.bytedance.android.live.revlink.impl.pk.feedview.sei;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revlink.impl.pk.feedview.entrance.PkFeedEntrance;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements IRenderView.MeasureListener, ViewTreeObserver.OnGlobalLayoutListener {
    public IRoom a;
    public IRenderView b;
    public n0 c;
    public pc0.a d;
    public ViewGroup e;
    public a f;
    public PkFeedEntrance g;
    public final z31.b h;
    public final boolean i;

    public final ViewGroup a() {
        IRenderView r0 = this.b;
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof ViewGroup) == false) goto L11;
        r1 = r2;
    L11:
        return (ViewGroup) r1;
    L5:
        r2 = null;
        goto L7
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewGroup r0 = a();
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L7;
        r1.removeOnGlobalLayoutListener(this);
    L7:
        PkFeedEntrance r2 = this.g;
        int r3 = b.a[r2.ordinal()];
        if (r3 != 2) goto L10;
    L12:
        b(this.d);
        return;
    L10:
        if (r3 == 3) goto L12;
    }

    public final void b(final pc0.a r7) {
        d51.c r0 = d51.c.A0;
        r0.getClass();
        ViewGroup.LayoutParams r2 = null;
        if (((Boolean) d51.c.d.getValue(r0, d51.c.a[2])).booleanValue() == false) goto L5;
    L17:
        PkFeedEntrance r1 = this.g;
        PkFeedEntrance r3 = PkFeedEntrance.ImCardLive;
        if (r1 != r3) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L61;
        if (PadConfigUtils.a() == false) goto L25;
    L145:
        boolean r5 = false;
    L146:
        if (r5 == true) goto L149;
        this.h.a(false);
        return;
    L149:
        if (r7 == null) goto L176;
        List r6 = r7.e();
        if (r6 == null) goto L176;
        final RevSeiRegion r8 = (RevSeiRegion) ListProtector.get(r6, 0);
        if (r8 == null) goto L176;
        this.d = r7;
        IRenderView r9 = this.b;
        if (r9 == null) goto L160;
        ViewParent r10 = r9.getParent();
        if (r10 == null) goto L160;
        ViewParent r12 = r10.getParent();
    L162:
        if ((r12 instanceof ViewGroup) == true) goto L164;
        r12 = null;
    L164:
        ViewGroup r13 = (ViewGroup) r12;
        if (r13 == null) goto L175;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof FrameLayout.LayoutParams) == false) goto L170;
        r2 = r14;
    L170:
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r2;
        if (r15 == null) goto L175;
        if (r15.gravity == 1) goto L175;
        r15.gravity = 1;
        r13.setLayoutParams(r15);
    L175:
        this.h.b(new SeiHandler$handleSeiAppData$1(r8, r7));
        this.h.a(true);
    L160:
        r12 = null;
    L176:
        this.h.c();
        return;
    L25:
        if (FoldScreenUtils.f() == true) goto L145;
        IRenderView r16 = this.b;
        if (r16 == null) goto L30;
        int r17 = r16.getHeight();
    L31:
        if (r17 <= 0) goto L145;
        int r18 = e41.b.a;
        if (e41.b.a(this.a, true) == false) goto L47;
        IRoom r19 = this.a;
        if (this.g != r3) goto L38;
        boolean r20 = true;
    L40:
        if (e41.b.a(r19, r20) == true) goto L42;
    L44:
        boolean r22 = false;
    L45:
        if (r22 == true) goto L47;
    L42:
        if (this.c == null) goto L44;
        r22 = true;
        goto L45
    L38:
        r20 = false;
    L47:
        if (r7 == null) goto L53;
        List r23 = r7.e();
        if (r23 == null) goto L53;
        if (r23.size() == 0) goto L145;
    L53:
        if (r7 == null) goto L57;
        List r24 = r7.e();
        if (r24 == null) goto L57;
        RevSeiRegion r25 = (RevSeiRegion) ListProtector.get(r24, 0);
    L58:
        if (r25 == null) goto L145;
    L144:
        r5 = true;
    L57:
        r25 = null;
        goto L58
    L30:
        r17 = 0;
        goto L31
    L61:
        if (t41.a.m.b() == false) goto L145;
        if (PadConfigUtils.a() == true) goto L145;
        if (FoldScreenUtils.f() == true) goto L145;
        IRenderView r26 = this.b;
        if (r26 == null) goto L71;
        int r27 = r26.getHeight();
    L72:
        if (r27 <= 0) goto L145;
        int r28 = e41.b.a;
        IRoom r29 = this.a;
        if (this.g != r3) goto L77;
        boolean r30 = true;
    L79:
        if (e41.b.a(r29, r30) == false) goto L105;
        IRoom r32 = this.a;
        if (this.g != r3) goto L83;
        boolean r33 = true;
    L85:
        if (e41.b.a(r32, r33) == true) goto L87;
    L89:
        boolean r34 = false;
    L90:
        if (r34 == false) goto L145;
        IRoom r35 = this.a;
        if (this.g != r3) goto L94;
        boolean r36 = true;
    L96:
        if (e41.b.a(r35, r36) == false) goto L102;
        n0 r37 = this.c;
        if (r37 == null) goto L102;
        if (r37.f() < r37.e()) goto L102;
        boolean r38 = true;
    L103:
        if (r38 == false) goto L105;
    L102:
        r38 = false;
        goto L103
    L94:
        r36 = false;
        goto L96
    L87:
        if (this.c == null) goto L89;
        r34 = true;
        goto L90
    L83:
        r33 = false;
    L105:
        IRoom r39 = this.a;
        if (this.g != r3) goto L108;
        boolean r40 = true;
    L110:
        if (e41.b.a(r39, r40) == false) goto L121;
        IRenderView r42 = this.b;
        if (r42 == null) goto L114;
        int r43 = r42.getWidth();
    L115:
        IRenderView r44 = this.b;
        if (r44 == null) goto L118;
        int r45 = r44.getHeight();
    L119:
        if (r43 <= r45) goto L121;
    L118:
        r45 = 0;
        goto L119
    L114:
        r43 = 0;
    L121:
        IRoom r46 = this.a;
        if (r46 == null) goto L128;
        IRoomSpecificSceneTypeInfo r47 = r46.getSceneTypeInfo();
        if (r47 == null) goto L128;
        if (r47.isLandscapeVerticalRoom() != 1) goto L128;
        boolean r48 = true;
    L129:
        if (r48 == true) goto L131;
    L133:
        if (r7 == null) goto L145;
        List r49 = r7.e();
        if (r49 == null) goto L145;
        if (r49.size() != 1) goto L145;
        List r50 = r7.e();
        if (r50 == null) goto L142;
        RevSeiRegion r52 = (RevSeiRegion) ListProtector.get(r50, 0);
    L143:
        if (r52 == null) goto L145;
    L142:
        r52 = null;
        goto L143
    L131:
        if (this.i == false) goto L133;
    L128:
        r48 = false;
        goto L129
    L108:
        r40 = false;
        goto L110
    L77:
        r30 = false;
        goto L79
    L71:
        r27 = 0;
        goto L72
    L20:
        r4 = false;
        goto L21
    L5:
        if (r0.b() == false) goto L17;
        if (r7 == null) goto L17;
        String r53 = r7.c();
        if (r53 == null) goto L17;
        if (r53.length() <= 0) goto L12;
        boolean r54 = true;
    L13:
        if (r54 != true) goto L17;
        if ((!Intrinsics.areEqual(r7.c(), "null")) == false) goto L17;
    L12:
        r54 = false;
        goto L13
    }

    public c(z31.b r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        this.h = r2;
        this.i = r3;
        this.g = PkFeedEntrance.FullCard;
    }

    public final void onMeasureReady(int r3, int r4, int r5, int r6) {
        IRenderView r7 = this.b;
        if (r7 == null) goto L23;
        View r8 = r7.getSelfView();
        if (r8 == null) goto L24;
        int r9 = r8.getLeft();
        int r10 = r8.getTop();
        int r12 = r8.getWidth();
        int r13 = r8.getHeight();
        a r0 = this.f;
        if (r0 != null) goto L10;
    L21:
        b(this.d);
        this.f = new a(r9, r10, r12, r13);
        return;
    L10:
        if (r0.a != r9) goto L21;
        if (r0 == null) goto L21;
        if (r0.b != r10) goto L21;
        if (r0 == null) goto L21;
        if (r0.c != r12) goto L21;
        if (r0 == null) goto L21;
        if (r0.d != r13) goto L21;
        return;
    L24:
        return;
    }
}
