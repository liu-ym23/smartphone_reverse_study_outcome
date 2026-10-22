package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import r41.f;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$gameLandscapeConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$gameLandscapeConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initGameLinkLandScapeConfig", "initGameLinkLandScapeConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m954invoke() {
        DefaultConfig r1 = (DefaultConfig) ((CallableReference) this).receiver;
        int r2 = DefaultConfig.m;
        r1.getClass();
        g r3 = new g();
        LinkedHashMap r4 = new LinkedHashMap();
        DeviceType r5 = DeviceType.NORMAL_MOBILE;
        Integer r6 = Integer.valueOf(r5.ordinal());
        t51.a r7 = new t51.a();
        AdjustBase r8 = AdjustBase.CONTENT;
        r7.m(r8.ordinal());
        LayoutScale r9 = LayoutScale.FIT_WIDTH;
        r7.t(r9.ordinal());
        LayoutAlign r10 = LayoutAlign.CENTER_TOP;
        r7.n(r10.ordinal());
        i r12 = new i();
        r12.j(0.0f);
        r12.m(0.16f);
        r12.k(1.0f);
        r12.i(1.0f);
        Unit r13 = Unit.INSTANCE;
        r7.v(r12);
        AnchorHeightFixMode r14 = AnchorHeightFixMode.RationTransformHeight;
        r7.p(r14.ordinal());
        int r15 = 16;
        r7.u(16);
        r7.q(16);
        r4.put(r6, r7);
        Integer r16 = Integer.valueOf(DeviceType.PAD_V.ordinal());
        t51.a r17 = new t51.a();
        r17.m(r8.ordinal());
        r17.t(r9.ordinal());
        r17.n(r10.ordinal());
        i r18 = new i();
        r18.j(0.0f);
        r18.l();
        r18.k(1.0f);
        r18.i(1.0f);
        r17.v(r18);
        r17.p(r14.ordinal());
        r17.u(16);
        r4.put(r16, r17);
        Integer r19 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r20 = new t51.a();
        r20.m(r8.ordinal());
        LayoutScale r22 = LayoutScale.FIT_HEIGHT;
        r20.t(r22.ordinal());
        r20.n(LayoutAlign.CENTER.ordinal());
        i r110 = new i();
        r110.j(0.0f);
        r110.m(0.0f);
        r110.k(1.0f);
        r110.i(1.0f);
        r20.v(r110);
        r20.p(r14.ordinal());
        AudienceHeightFixMode r111 = AudienceHeightFixMode.OriginContainerHeight;
        r20.r(r111.ordinal());
        r4.put(r19, r20);
        Integer r23 = Integer.valueOf(DeviceType.FOLD_FULL.ordinal());
        t51.a r24 = new t51.a();
        r24.m(r8.ordinal());
        r24.t(LayoutScale.ASPECT_FIT.ordinal());
        r24.n(r10.ordinal());
        i r112 = new i();
        r112.j(0.2f);
        r112.m(0.19f);
        r112.k(0.8f);
        r112.i(1.0f);
        r24.v(r112);
        r24.p(r14.ordinal());
        r24.r(r111.ordinal());
        r24.u(16);
        r24.q(16);
        r4.put(r23, r24);
        Integer r25 = Integer.valueOf(r5.ordinal() + com.bytedance.android.live.saas.middleware.fresco.DefaultConfig.MAX_CACHE_ENTRIES);
        t51.a r26 = new t51.a();
        r26.m(r8.ordinal());
        r26.t(r22.ordinal());
        r26.n(r10.ordinal());
        i r27 = new i();
        r27.j(0.0f);
        r27.m(0.19f);
        r27.k(1.0f);
        r27.i(0.59625f);
        r26.v(r27);
        boolean r28 = f.a;
        if (r28 == true) goto L5;
    L7:
        int r29 = 4;
    L8:
        r26.q(r29);
        if (r28 == true) goto L11;
    L13:
        r15 = 0;
    L14:
        r26.u(r15);
        r26.p(r14.ordinal());
        r26.r(r111.ordinal());
        r4.put(r25, r26);
        r3.g(r4);
        r3.i(r1.c().e());
        return r3;
    L11:
        if (y41.f.N.e() == true) goto L13;
    L5:
        if (y41.f.N.e() == true) goto L7;
        r29 = 20;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m954invoke();
    }
}
