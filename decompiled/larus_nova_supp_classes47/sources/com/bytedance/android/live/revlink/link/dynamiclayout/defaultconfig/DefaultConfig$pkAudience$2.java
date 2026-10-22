package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.impl.multianchor.model.WindowType;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.ranges.IntRange;
import t51.b;
import t51.e;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$pkAudience$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$pkAudience$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initPkAudienceConfig", "initPkAudienceConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m956invoke() {
        DefaultConfig r1 = (DefaultConfig) ((CallableReference) this).receiver;
        int r2 = DefaultConfig.m;
        r1.getClass();
        g r3 = new g();
        LinkedHashMap r4 = new LinkedHashMap();
        Integer r5 = Integer.valueOf(DeviceType.NORMAL_MOBILE.ordinal());
        t51.a r6 = new t51.a();
        AdjustBase r7 = AdjustBase.CONTENT;
        r6.m(r7.ordinal());
        r6.t(LayoutScale.FIT_WIDTH.ordinal());
        r6.n(LayoutAlign.CENTER_TOP.ordinal());
        i r8 = new i();
        r8.j(0.0f);
        r8.m(0.19f);
        r8.k(1.0f);
        r8.i(0.59625f);
        Unit r12 = Unit.INSTANCE;
        r6.v(r8);
        r6.q(4);
        AnchorHeightFixMode r9 = AnchorHeightFixMode.RationTransformHeight;
        r6.p(r9.ordinal());
        AudienceHeightFixMode r13 = AudienceHeightFixMode.OriginContainerHeight;
        r6.r(r13.ordinal());
        r4.put(r5, r6);
        Integer r10 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r14 = new t51.a();
        r14.m(r7.ordinal());
        r14.t(LayoutScale.ASPECT_FIT.ordinal());
        r14.n(LayoutAlign.CENTER.ordinal());
        i r15 = new i();
        r15.j(0.0f);
        r15.m(0.0f);
        r15.k(1.0f);
        r15.i(1.0f);
        r14.v(r15);
        r14.p(r9.ordinal());
        r14.r(r13.ordinal());
        r4.put(r10, r14);
        r3.g(r4);
        Map<Integer, ? extends List<e>> r16 = MapsKt.toMutableMap(r1.c().e());
        e r17 = new e();
        r17.m(0.0f);
        r17.n(0.19f);
        r17.l(0.5f);
        r17.h(0.265625f);
        r17.i(30000);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r18 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r19 = Integer.valueOf(r18.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.r r110 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.r.c;
        r17.t(MapsKt.mapOf(TuplesKt.to(r19, 100)));
        r17.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r18.ordinal()), 100)));
        e r20 = new e();
        r20.m(0.5f);
        r20.n(0.19f);
        r20.l(0.5f);
        r20.h(0.265625f);
        r20.i(30001);
        r20.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r18.ordinal()), 100)));
        r20.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r18.ordinal()), 100)));
        List r22 = CollectionsKt.listOf(new e[]{r17, r20});
        e r23 = new e();
        r23.m(0.0f);
        r23.n(0.19f);
        r23.l(0.5f);
        r23.h(0.40625f);
        r23.i(0);
        Integer r111 = Integer.valueOf(r18.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.C0204a r112 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.C0204a.c;
        r23.t(MapsKt.mapOf(TuplesKt.to(r111, 5)));
        r23.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r18.ordinal()), 5)));
        e r24 = new e();
        r24.m(0.5f);
        r24.n(0.19f);
        r24.l(0.5f);
        r24.h(0.40625f);
        r24.i(1);
        r24.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r18.ordinal()), 5)));
        r24.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r18.ordinal()), 5)));
        List r25 = CollectionsKt.listOf(new e[]{r23, r24});
        IntRange r26 = new IntRange(0, 3);
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        IntIterator r28 = r26.iterator();
    L4:
        if (r28.hasNext() == false) goto L6;
        int r29 = r28.nextInt();
        e r113 = new e();
        r113.m((r29 * 4.5f) / 18.0f);
        r113.n(0.455625f);
        r113.l(0.25f);
        r113.h(0.140625f);
        r113.i(r29 + 20000);
        r113.j(WindowType.Guest.ordinal());
        r27.add(r113);
        goto L4
    L6:
        ArrayList r30 = new ArrayList();
        r30.addAll(r22);
        r30.addAll(r25);
        r30.addAll(r27);
        Unit r32 = Unit.INSTANCE;
        r16.put(2, r30);
        r3.i(r16);
        Map<Integer, ? extends List<? extends b>> r33 = MapsKt.toMutableMap(r1.c().e());
        DefaultConfig$initPkAudienceConfig$1$3$1 r34 = DefaultConfig$initPkAudienceConfig$1$3$1.INSTANCE;
        List<e> r35 = r34.invoke(0, false);
        List<e> r36 = r34.invoke(30000, true);
        ArrayList r37 = new ArrayList();
        r37.addAll(r36);
        r37.addAll(r35);
        r33.put(2, r37);
        r3.j(r33);
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m956invoke();
    }
}
