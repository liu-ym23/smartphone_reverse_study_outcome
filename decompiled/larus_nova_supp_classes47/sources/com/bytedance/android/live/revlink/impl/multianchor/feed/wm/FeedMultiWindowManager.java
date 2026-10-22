package com.bytedance.android.live.revlink.impl.multianchor.feed.wm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import b31.d;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.g;
import com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough.FeedMultiBreakThroughBarManager;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.FeedMultiPlayUiResolver;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.e;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.FeedMultiLynxContainer;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.a;
import com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h;
import com.bytedance.android.live.revlink.impl.multianchor.ui.b;
import com.bytedance.android.live.revlink.impl.multianchor.ui.s;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiFeedUtils;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import f31.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k31.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiWindowManager implements b {
    public final MutableLiveData<List<k>> a;
    public final Context b;
    public final FeedMultiPlayUiResolver c;
    public final a d;
    public final w21.a e;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.b f;
    public final ArrayList<com.bytedance.android.live.revlink.impl.multianchor.feed.b> g;
    public IRoom h;
    public boolean i;
    public final FeedMultiLynxContainer j;
    public com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b k;
    public f l;
    public g m;
    public View n;
    public FeedMultiBreakThroughBarManager o;
    public final FrameLayout p;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.player.b q;
    public final c r;
    public final boolean s;

    public final void a() {
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r0 = this.k;
        FrameLayout r1 = null;
        if (r0 == null) goto L5;
        FeedMultiPlayMode r2 = r0.d;
    L6:
        boolean r3 = false;
        if (r2 != FeedMultiPlayMode.BREAK_THROUGH) goto L17;
        FeedMultiBreakThroughBarManager r4 = this.o;
        if (r4 == null) goto L12;
        r1 = r4.b;
    L12:
        if (b(com.bytedance.android.live.revlink.impl.multianchor.dynamic.k.a.b) == false) goto L14;
    L15:
        r3 = true;
    L16:
        c(r1, r3);
        return;
    L14:
        if (z41.g.o.a() == false) goto L16;
    L17:
        c(null, false);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void d() {
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r1 = this.k;
        if (r1 != null) goto L5;
        return;
    L5:
        f r2 = this.l;
        if (r2 != null) goto L9;
        return;
    L9:
        if (this.i == false) goto L145;
        UtilityKotlinExtentionsKt.w(this.p);
        e r3 = this.c.a(this.q.f.a, r1, r2, new FeedMultiWindowManager$updateLayout$layoutState$1(this));
        ArrayList r4 = null;
        if (this.s == false) goto L69;
        w21.a r5 = this.e;
        com.bytedance.android.live.revlink.impl.multianchor.feed.player.a r7 = this.q.f;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r1, "frameState");
        Intrinsics.checkNotNullParameter(r3, "layoutState");
        Intrinsics.checkNotNullParameter(r7, "containerSize");
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.b r8 = r3.c;
        int r9 = 0;
        if (r8 != null) goto L15;
    L17:
        boolean r10 = false;
    L18:
        if (r10 == true) goto L24;
        IMProgressBarLayout r6 = r5.b;
        if (r6 == null) goto L22;
        r5.d.removeView(r6);
    L22:
        r5.b = null;
    L106:
        FeedMultiLynxContainer r12 = this.j;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r3, "layoutState");
        b31.e r13 = r3.b;
        if (r13 == null) goto L150;
        int r14 = r13.a;
        int r15 = r13.b;
        int r16 = r13.c;
        int r17 = r13.d;
        if (r12.b == true) goto L119;
        FrameLayout r18 = (FrameLayout) r12.a.getValue();
        if (r18 == null) goto L118;
        ViewParent r19 = r18.getParent();
        if (r19 == null) goto L118;
        if ((r19 instanceof ViewGroup) == false) goto L118;
        ((ViewGroup) r19).removeView(r18);
    L118:
        r12.d.addView((FrameLayout) r12.a.getValue(), -1, -1);
        r12.b = true;
    L119:
        MutableLiveData<List<k>> r20 = r12.e;
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f r22 = r3.d;
        if (r22 == null) goto L143;
        Map<String, com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.g> r23 = r22.a;
        if (r23 == null) goto L143;
        r4 = new ArrayList(r23.size());
        Iterator<Map.Entry<String, com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.g>> r24 = r23.entrySet().iterator();
    L125:
        if (r24.hasNext() == false) goto L143;
        Map.Entry<String, com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.g> r25 = r24.next();
        String r110 = r25.getKey();
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.g r26 = r25.getValue();
        Double r111 = r26.c;
        if (r111 == null) goto L129;
        float r112 = (float) r111.doubleValue();
    L130:
        float r113 = r14;
        int r114 = ((int) (r112 * r113)) + r17;
        Double r115 = r26.d;
        if (r115 == null) goto L133;
        float r116 = (float) r115.doubleValue();
    L134:
        float r117 = r15;
        int r118 = ((int) (r116 * r117)) + r16;
        Double r119 = r26.a;
        if (r119 == null) goto L137;
        float r27 = (float) r119.doubleValue();
    L138:
        int r28 = (int) (r27 * r113);
        Double r29 = r26.b;
        if (r29 == null) goto L141;
        float r120 = (float) r29.doubleValue();
    L142:
        r4.add(new k(r110, "", r114, r118, r28, (int) (r120 * r117), false, true, 0, 768, 0));
        r17 = r17;
        r24 = r24;
        r14 = r14;
        goto L125
    L141:
        r120 = 0.0f;
        goto L142
    L137:
        r27 = 0.0f;
        goto L138
    L133:
        r116 = 0.0f;
        goto L134
    L129:
        r112 = 0.0f;
    L143:
        r20.setValue(r4);
        return;
    L150:
        return;
    L24:
        if (r5.b != null) goto L27;
        IMProgressBarLayout r30 = new IMProgressBarLayout(r5.c);
        r30.a(false, 0, 0);
        r30.setLayerType(1, null);
        r5.d.addView(r30);
        r5.b = r30;
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r32 = r1.e;
        if ((r32 instanceof h) == true) goto L30;
        r32 = null;
    L30:
        h r33 = (h) r32;
        if (r33 == null) goto L50;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.f r34 = r33.c;
        if (r1.d != FeedMultiPlayMode.VOTE) goto L36;
        boolean r121 = true;
    L37:
        IMProgressBarLayout r122 = r5.b;
        if (r122 == null) goto L50;
        if (r34 == null) goto L43;
        Integer r35 = r34.b;
        if (r35 == null) goto L43;
        int r36 = r35.intValue();
    L44:
        long r123 = r36;
        if (r34 == null) goto L49;
        Integer r37 = r34.c;
        if (r37 == null) goto L49;
        r9 = r37.intValue();
    L49:
        r122.a(r121, r123, r9);
    L43:
        r36 = 0;
        goto L44
    L36:
        r121 = false;
    L50:
        Boolean r38 = r3.a;
        if (r38 == null) goto L106;
        r38.booleanValue();
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.b r39 = r3.c;
        if (r39 == null) goto L106;
        s r40 = r39.b;
        if (r40 == null) goto L106;
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f r42 = r3.d;
        if (r42 == null) goto L106;
        Integer r43 = r42.b;
        if (r43 == null) goto L106;
        int r44 = r43.intValue();
        b31.e r45 = r3.b;
        if (r45 == null) goto L106;
        int r46 = r45.e;
        int r47 = r45.f;
        r5.a.getClass();
        b31.a r48 = d.a(r40, r44, r46, r47);
        if (r48 == null) goto L106;
        IMProgressBarLayout r49 = r5.b;
        if (r49 == null) goto L106;
        b31.c.b(r49, new b31.a(r48.a, p.a.a(7.0f), r48.c, r48.d, r48.e, r48.f));
        goto L106
    L15:
        if (r8.a != true) goto L17;
        r10 = true;
        goto L18
    L69:
        this.f.a(r3);
        a r50 = this.d;
        r50.getClass();
        Intrinsics.checkNotNullParameter(r3, "layoutState");
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.a r52 = r3.e;
        if (r52 == null) goto L72;
        Boolean r53 = r52.a;
    L74:
        if (Intrinsics.areEqual(r53, Boolean.TRUE) == true) goto L76;
        int r54 = MultiFeedUtils.a;
        MultiFeedUtils.b(r50.g);
        goto L106
    L76:
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f r55 = r3.d;
        if (r55 == null) goto L106;
        Integer r56 = r55.b;
        if (r56 == null) goto L106;
        int r57 = r56.intValue();
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f r58 = r3.d;
        if (r58 == null) goto L106;
        Integer r59 = r58.c;
        if (r59 == null) goto L106;
        int r124 = r59.intValue();
        String r60 = r50.a;
        if (r60 != null) goto L87;
        r60 = d51.c.A0.k();
    L87:
        String r125 = r60;
        String r62 = r50.b;
        if (r62 != null) goto L90;
        r62 = d51.c.A0.j();
    L90:
        String r126 = r62;
        if (t41.a.m.a() == true) goto L93;
    L105:
        int r63 = MultiFeedUtils.a;
        MultiFeedUtils.e(r50.g, r57, r124, MultiFeedUtils.ViewIndex.INDEX_0, r125, r126);
        r50.c = r125;
        r50.d = r126;
        r50.e = r57;
        r50.f = r124;
        goto L106
    L93:
        if (Intrinsics.areEqual(r125, r50.c) == false) goto L105;
        if (Intrinsics.areEqual(r126, r50.d) == false) goto L105;
        if (r50.e != r57) goto L105;
        if (r50.f != r124) goto L105;
        if (r50.g.findViewById(2131389668) == null) goto L105;
        if (r50.g.findViewById(2131389666) == null) goto L105;
    L72:
        r53 = null;
        goto L74
    L145:
        UtilityKotlinExtentionsKt.u(this.p);
    }

    public final boolean b(com.bytedance.android.live.revlink.impl.multianchor.dynamic.k r5) {
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        if (r0.a().R8() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return true;
    L10:
        if (this.s == true) goto L20;
        g r2 = this.m;
        if (r2 != null) goto L15;
    L17:
        return false;
    L15:
        if (r2.d(r5.a) != true) goto L17;
        return true;
    L20:
        return true;
    L5:
        if (r0.a().h7() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.b
    public final void requestLayout(String r2) {
        Intrinsics.checkNotNullParameter("updateTopReserve", "source");
        d();
        a();
    }

    public final void c(View r6, boolean r7) {
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        f r1 = this.l;
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r2 = this.q.f.a;
        e r3 = this.c.a(r2, r0, r1, new FeedMultiWindowManager$setBreakThroughBar$layoutState$1(this));
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.b r4 = this.f;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "layoutState");
        if (PadConfigUtils.a() == false) goto L11;
    L44:
        this.n = r6;
        return;
    L11:
        if (FoldScreenUtils.f() == true) goto L44;
        if (r6 != null) goto L21;
        View r8 = r4.b;
        if (r8 == null) goto L20;
        FrameLayout r5 = r4.c;
        if (r5 == null) goto L20;
        r5.removeView(r8);
    L20:
        r4.b = null;
        goto L44
    L21:
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.c r9 = r3.f;
        if (r9 == null) goto L27;
        boolean r10 = true;
        if (r9.a != true) goto L27;
        if (r7 == false) goto L27;
    L28:
        if (r10 == true) goto L35;
        View r12 = r4.b;
        if (r12 == null) goto L34;
        FrameLayout r13 = r4.c;
        if (r13 == null) goto L34;
        r13.removeView(r12);
    L34:
        r4.b = null;
        goto L44
    L35:
        View r14 = r4.b;
        if (r14 == null) goto L40;
        FrameLayout r15 = r4.c;
        if (r15 == null) goto L40;
        r15.removeView(r14);
    L40:
        FrameLayout r16 = r4.c;
        if (r16 == null) goto L43;
        r16.addView(r6);
    L43:
        r4.b = r6;
        r4.a(r3);
    L27:
        r10 = false;
        goto L28
    }

    public FeedMultiWindowManager(FrameLayout r2, com.bytedance.android.live.revlink.impl.multianchor.feed.player.b r3, c r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "feedMultiLayout");
        Intrinsics.checkNotNullParameter(r4, "machine");
        this.p = r2;
        this.q = r3;
        this.r = r4;
        this.s = r5;
        MutableLiveData<List<k>> r6 = new MutableLiveData();
        this.a = r6;
        Context r7 = r2.getContext();
        if (r7 != null) goto L5;
        r7 = s1.getContext();
    L5:
        this.b = r7;
        this.c = new FeedMultiPlayUiResolver(r7, r3);
        this.d = new a(r2);
        this.e = new w21.a(r7, r2);
        this.f = new com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.b(r2);
        this.g = new ArrayList();
        this.j = new FeedMultiLynxContainer(r7, r2, r6);
    }
}
