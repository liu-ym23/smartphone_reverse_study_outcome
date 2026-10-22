package com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.k;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.ui.s;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rc0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiPlayUiResolver {
    public final d a;
    public final h b;
    public final Lazy c;
    public final Context d;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.player.b e;

    public FeedMultiPlayUiResolver(Context r2, com.bytedance.android.live.revlink.impl.multianchor.feed.player.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedMultiLayout");
        this.d = r2;
        this.e = r3;
        this.a = new d();
        this.b = new h();
        this.c = LazyKt.lazy(FeedMultiPlayUiResolver$isOpen$2.INSTANCE);
    }

    public final e a(boolean r33, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r34, k31.f r35, Function1<? super k, Boolean> r36) {
        Intrinsics.checkNotNullParameter(r34, "frameState");
        Intrinsics.checkNotNullParameter(r35, "seiCache");
        Intrinsics.checkNotNullParameter(r36, "localLoadCheck");
        e r7 = new e();
        r7.a = Boolean.valueOf(r33);
        com.bytedance.android.live.revlink.impl.multianchor.feed.player.b r8 = this.e;
        k31.h r9 = r8.d;
        if (r9 != null) goto L5;
        b31.e r10 = null;
    L35:
        r7.b = r10;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r5 = r34.e;
        if (this.e.i == false) goto L39;
    L45:
        boolean r12 = true;
    L47:
        if (r12 == true) goto L49;
    L115:
        b r6 = null;
    L116:
        r7.c = r6;
        b31.e r3 = r7.b;
        f r13 = new f();
        HashMap r14 = new HashMap();
        int r15 = n11.a.a;
        p0 r16 = r35.b;
        if (r16 == null) goto L119;
        List r17 = r16.e();
    L120:
        if (r17 == null) goto L135;
        List r18 = CollectionsKt.filterNotNull(r17);
        if (r18 == null) goto L135;
        Iterator r19 = r18.iterator();
    L125:
        if (r19.hasNext() == false) goto L135;
        RevSeiRegion r20 = (RevSeiRegion) r19.next();
        String r110 = r20.getInteractId();
        if (r110 == null) goto L125;
        if (r110.length() <= 0) goto L131;
        boolean r111 = true;
    L133:
        if (r111 != true) goto L125;
        g r112 = new g();
        r112.a = Double.valueOf(r20.getWidth());
        r112.b = Double.valueOf(r20.getHeight());
        r112.c = Double.valueOf(r20.getX());
        r112.d = Double.valueOf(r20.getY());
        Unit r22 = Unit.INSTANCE;
        r14.put(r110, r112);
        goto L125
    L131:
        r111 = false;
    L135:
        r13.a = r14;
        if (r3 == null) goto L156;
        int r113 = r3.b;
        int r114 = r3.c;
        Collection r23 = r14.values();
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r24 = r23.iterator();
    L140:
        if (r24.hasNext() == false) goto L149;
        g r116 = (g) r24.next();
        if (Intrinsics.areEqual(r116.a, 0.0d) == false) goto L144;
    L147:
        Double r117 = null;
    L148:
        r115.add(r117);
        goto L140
    L144:
        if (Intrinsics.areEqual(r116.b, 0.0d) == true) goto L147;
        r117 = r116.d;
        goto L148
    L149:
        Double r25 = (Double) CollectionsKt.firstOrNull(CollectionsKt.sorted(CollectionsKt.filterNotNull(r115)));
        if (r25 == null) goto L156;
        double r118 = (r25.doubleValue() * ((double) r113)) + ((double) r114);
        Activity r26 = ContextUtil.contextToActivity(this.d);
        if (r26 == null) goto L155;
        int r27 = r26.getWindow().getAttributes().flags;
    L155:
        Integer r28 = Integer.valueOf((int) (r118 + ((double) 0)));
    L157:
        r13.b = r28;
        if (r28 == null) goto L160;
        int r29 = r28.intValue();
    L161:
        Map<String, g> r119 = r13.a;
        if (r119 == null) goto L197;
        if (r3 == null) goto L197;
        int r4 = r3.b;
        Collection<g> r120 = r119.values();
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator<T> r122 = r120.iterator();
    L168:
        if (r122.hasNext() == false) goto L177;
        g r123 = (g) r122.next();
        if (Intrinsics.areEqual(r123.a, 0.0d) == false) goto L172;
    L175:
        Double r124 = null;
    L176:
        r121.add(r124);
        goto L168
    L172:
        if (Intrinsics.areEqual(r123.b, 0.0d) == true) goto L175;
        r124 = r123.d;
        goto L176
    L177:
        Double r125 = (Double) CollectionsKt.firstOrNull(CollectionsKt.sorted(CollectionsKt.filterNotNull(r121)));
        if (r125 == null) goto L197;
        double r126 = r125.doubleValue();
        Collection<g> r127 = r119.values();
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator<T> r129 = r127.iterator();
    L181:
        if (r129.hasNext() == false) goto L194;
        g r130 = (g) r129.next();
        if (Intrinsics.areEqual(r130.a, 0.0d) == false) goto L185;
    L192:
        Double r131 = null;
    L193:
        r128.add(r131);
        goto L181
    L185:
        if (Intrinsics.areEqual(r130.b, 0.0d) == true) goto L192;
        Double r132 = r130.d;
        if (r132 == null) goto L192;
        double r210 = r132.doubleValue();
        Double r133 = r130.b;
        if (r133 == null) goto L192;
        r131 = Double.valueOf(r210 + r133.doubleValue());
        goto L193
    L194:
        Double r30 = (Double) CollectionsKt.lastOrNull(CollectionsKt.sorted(CollectionsKt.filterNotNull(r128)));
        if (r30 == null) goto L197;
        Integer r32 = Integer.valueOf((int) ((r30.doubleValue() - r126) * ((double) r4)));
    L198:
        if (r32 == null) goto L200;
        int r37 = r32.intValue();
    L201:
        r13.c = Integer.valueOf(r29 + r37);
        r7.d = r13;
        a r38 = new a();
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L210;
        p0 r2 = r35.b;
        if (r2 == null) goto L209;
        m0 r39 = r2.f();
        if (r39 == null) goto L209;
        if (r39.c() == UILayout.FULL.ordinal()) goto L210;
    L209:
        boolean r134 = true;
    L211:
        r38.a = Boolean.valueOf(r134);
        r7.e = r38;
        FeedMultiPlayMode r40 = r34.d;
        FeedMultiPlayMode r42 = FeedMultiPlayMode.BREAK_THROUGH;
        if (r40 != r42) goto L236;
        d r43 = this.a;
        boolean r44 = this.e.i;
        r43.getClass();
        Intrinsics.checkNotNullParameter(r34, "frameState");
        c r135 = new c();
        if (r44 == false) goto L217;
    L223:
        boolean r136 = false;
    L224:
        r135.a = r136;
        int r1 = i.b(16);
        int r45 = i.b(30);
        if (r33 == true) goto L229;
        b03.a r46 = b03.a.a;
        if (b03.a.b() == false) goto L229;
        int r211 = -100;
    L230:
        if (r33 == true) goto L234;
        b03.a r47 = b03.a.a;
        if (b03.a.b() == false) goto L234;
        int r48 = 25;
    L235:
        r135.b = new s(r211, -2, true, new com.bytedance.android.live.revlink.impl.multianchor.ui.c(r45, r1), new com.bytedance.android.live.revlink.impl.multianchor.ui.f(i.b(r48)), i.b(16), i.b(250));
    L237:
        r7.f = r135;
        return r7;
    L234:
        r48 = -2;
    L229:
        r211 = -1;
        goto L230
    L217:
        if (r34.d != r42) goto L223;
        x21.d r49 = r34.c;
        if ((r49 instanceof x21.d.c) == false) goto L221;
    L222:
        r136 = true;
        goto L224
    L221:
        if ((r49 instanceof x21.d.b) == false) goto L223;
    L236:
        r135 = null;
    L210:
        r134 = false;
        goto L211
    L200:
        r37 = 0;
    L197:
        r32 = null;
        goto L198
    L160:
        r29 = 0;
    L156:
        r28 = null;
        goto L157
    L119:
        r17 = null;
        goto L120
    L49:
        if ((r5 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) == false) goto L115;
        h r50 = this.b;
        boolean r52 = this.e.i;
        r50.getClass();
        Intrinsics.checkNotNullParameter(r34, "frameState");
        Intrinsics.checkNotNullParameter(r36, "localLoadCheck");
        r6 = new b();
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r53 = r34.e;
        if ((r53 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) == true) goto L53;
        r53 = null;
    L53:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h r54 = (com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) r53;
        if (r54 == null) goto L85;
        x21.d r55 = r34.c;
        Boolean r137 = r54.e;
        if (r34.d == FeedMultiPlayMode.BREAK_THROUGH) goto L85;
        if (r137 == null) goto L81;
        if (Intrinsics.areEqual(r137, Boolean.FALSE) == true) goto L81;
        if ((r55 instanceof x21.d.c) == false) goto L67;
    L86:
        boolean r56 = true;
    L87:
        if (r56 == true) goto L89;
    L91:
        boolean r57 = false;
    L92:
        r6.a = r57;
        if (r52 == false) goto L95;
        com.bytedance.android.live.revlink.impl.global.b.k();
        int r58 = i.b(7);
        int r59 = i.b(7);
        s r60 = new s(-1, r59, false, new com.bytedance.android.live.revlink.impl.multianchor.ui.c(r59, r58), new com.bytedance.android.live.revlink.impl.multianchor.ui.e(r59, r58, i.b(41)), 0, 0);
    L114:
        r6.b = r60;
        goto L116
    L95:
        com.bytedance.android.live.revlink.impl.global.c r62 = com.bytedance.android.live.revlink.impl.global.b.k();
        b03.a r63 = b03.a.a;
        if (b03.a.b() == false) goto L99;
        if (r33 == true) goto L99;
        boolean r212 = true;
    L100:
        int r64 = i.b(16);
        int r65 = i.b(30);
        if (r212 == false) goto L103;
        int r213 = -100;
    L105:
        if (r62 == null) goto L107;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r66 = r62.Ig();
    L108:
        if (r66 != null) goto L110;
    L112:
        int r214 = r65;
    L113:
        r60 = new s(r213, r214, r212, new com.bytedance.android.live.revlink.impl.multianchor.ui.c(r65, r64), new com.bytedance.android.live.revlink.impl.multianchor.ui.e(r65, r64, i.b(41)), i.b(16), i.b(250));
        goto L114
    L110:
        if (r66.isInBreakThrough() != true) goto L112;
        r214 = -2;
        goto L113
    L107:
        r66 = null;
        goto L108
    L103:
        r213 = -1;
    L99:
        r212 = false;
        goto L100
    L89:
        if (((Boolean) r36.invoke(k.b.b)).booleanValue() == false) goto L91;
        r57 = true;
        goto L92
    L67:
        if ((r55 instanceof x21.d.b) == false) goto L85;
        Integer r67 = r34.f;
        if (r67 == null) goto L86;
        int r68 = r67.intValue();
        Integer r69 = r54.f;
        if (r69 == null) goto L86;
        int r70 = r69.intValue();
        Integer r138 = r34.g;
        if (r138 == null) goto L86;
        int r139 = r138.intValue();
        if (r70 < 0) goto L85;
        if (r139 < (r68 - r70)) goto L85;
    L81:
        if ((r55 instanceof x21.d.c) == true) goto L86;
        if ((r55 instanceof x21.d.b) == true) goto L86;
    L85:
        r56 = false;
        goto L87
    L39:
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L44;
        if (r33 == true) goto L45;
        if (n.a(rc0.b.a()) == false) goto L45;
    L44:
        r12 = false;
        goto L47
    L5:
        int r72 = r8.f.b;
        b31.e.g.getClass();
        Intrinsics.checkNotNullParameter(r9, "seiLayout");
        Intrinsics.checkNotNullParameter(r35, "seiCache");
        p0 r73 = r35.b;
        if (r73 == null) goto L11;
        List r74 = r73.e();
        if (r74 == null) goto L11;
        int r75 = (int) (((double) r9.a) * n11.a.d(r74));
    L12:
        int r140 = r75;
        p0 r76 = r35.b;
        if (r76 == null) goto L19;
        m0 r77 = r76.f();
        if (r77 == null) goto L19;
        if (r77.c() != UILayout.FULL.ordinal()) goto L19;
        boolean r78 = true;
    L20:
        p0 r141 = r35.b;
        if (r141 == null) goto L27;
        m0 r142 = r141.f();
        if (r142 == null) goto L27;
        if (r142.c() != UILayout.FULL_RECORD.ordinal()) goto L27;
        boolean r143 = true;
    L28:
        int r144 = r9.a;
        int r145 = r9.b;
        int r146 = r9.c;
        if (r78 == true) goto L33;
        if (r143 == true) goto L33;
        int r79 = (r72 - r144) / 2;
    L34:
        r10 = new b31.e(r144, r145, r146, r79, r140, r72);
    L33:
        r79 = r9.d;
    L27:
        r143 = false;
    L19:
        r78 = false;
    L11:
        r75 = r9.a;
        goto L12
    }
}
