package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import d51.c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import r41.f;
import t51.d;
import t51.e;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$pkConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$pkConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initPkConfig", "initPkConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m957invoke() {
        DefaultConfig r1 = (DefaultConfig) ((CallableReference) this).receiver;
        int r2 = DefaultConfig.m;
        r1.getClass();
        g r3 = new g();
        LinkedHashMap r4 = new LinkedHashMap();
        Integer r5 = Integer.valueOf(DeviceType.NORMAL_MOBILE.ordinal());
        t51.a r6 = new t51.a();
        AdjustBase r7 = AdjustBase.CONTENT;
        r6.m(r7.ordinal());
        r6.t(LayoutScale.FIT_HEIGHT.ordinal());
        LayoutAlign r8 = LayoutAlign.CENTER_TOP;
        r6.n(r8.ordinal());
        i r9 = new i();
        r9.j(0.0f);
        r9.m(0.19f);
        r9.k(1.0f);
        r9.i(0.59625f);
        Unit r13 = Unit.INSTANCE;
        r6.v(r9);
        boolean r10 = f.a;
        if (r10 == true) goto L5;
    L7:
        int r14 = 4;
    L8:
        r6.q(r14);
        if (r10 == true) goto L11;
    L13:
        int r15 = 0;
    L14:
        r6.u(r15);
        c r16 = c.A0;
        r16.getClass();
        if (((Boolean) c.w0.getValue(r16, c.a[73])).booleanValue() == false) goto L17;
        int r17 = 12;
    L22:
        r6.u(r17);
        d r12 = new d();
        r12.c();
        r12.d();
        r6.o(r12);
        AnchorHeightFixMode r18 = AnchorHeightFixMode.RationTransformHeight;
        r6.p(r18.ordinal());
        AudienceHeightFixMode r19 = AudienceHeightFixMode.OriginContainerHeight;
        r6.r(r19.ordinal());
        r4.put(r5, r6);
        Integer r20 = Integer.valueOf(DeviceType.PAD_V.ordinal());
        t51.a r22 = new t51.a();
        r22.m(r7.ordinal());
        r22.t(LayoutScale.FIT_WIDTH.ordinal());
        r22.n(r8.ordinal());
        i r23 = new i();
        r23.j(0.0f);
        r23.m(0.19f);
        r23.k(1.0f);
        r23.i(0.59625f);
        r22.v(r23);
        r22.p(r18.ordinal());
        r22.r(r19.ordinal());
        r4.put(r20, r22);
        Integer r24 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r25 = new t51.a();
        r25.m(r7.ordinal());
        r25.t(LayoutScale.ASPECT_FIT.ordinal());
        r25.n(LayoutAlign.CENTER.ordinal());
        i r26 = new i();
        r26.j(0.0f);
        r26.m(0.0f);
        r26.k(1.0f);
        r26.i(1.0f);
        r25.v(r26);
        r25.p(r18.ordinal());
        r25.r(r19.ordinal());
        r4.put(r24, r25);
        r3.g(r4);
        Map<Integer, ? extends List<e>> r27 = MapsKt.toMutableMap(r1.c().e());
        e r28 = new e();
        r28.m(0.0f);
        r28.n(0.19f);
        r28.l(0.5f);
        r28.h(0.40625f);
        r28.i(0);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r29 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r30 = Integer.valueOf(r29.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.C0204a r110 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.C0204a.c;
        r28.t(MapsKt.mapOf(TuplesKt.to(r30, 5)));
        r28.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r29.ordinal()), 5)));
        e r32 = new e();
        r32.m(0.5f);
        r32.n(0.19f);
        r32.l(0.5f);
        r32.h(0.40625f);
        r32.i(1);
        r32.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r29.ordinal()), 5)));
        r32.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r29.ordinal()), 5)));
        r27.put(2, CollectionsKt.listOf(new e[]{r28, r32}));
        r3.i(r27);
        return r3;
    L17:
        if (r10 == true) goto L19;
    L21:
        r17 = 0;
        goto L22
    L19:
        if (y41.f.N.e() == true) goto L21;
        r17 = 16;
        goto L22
    L11:
        if (y41.f.N.e() == true) goto L13;
        r15 = 12;
        goto L14
    L5:
        if (y41.f.N.e() == true) goto L7;
        r14 = 20;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m957invoke();
    }
}
