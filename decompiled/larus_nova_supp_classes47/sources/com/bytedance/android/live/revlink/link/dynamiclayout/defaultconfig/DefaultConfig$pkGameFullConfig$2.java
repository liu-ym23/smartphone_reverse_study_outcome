package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t51.e;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$pkGameFullConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$pkGameFullConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initPkGameFullConfig", "initPkGameFullConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m959invoke() {
        DefaultConfig r0 = (DefaultConfig) ((CallableReference) this).receiver;
        int r1 = DefaultConfig.m;
        r0.getClass();
        g r2 = new g();
        LinkedHashMap r3 = new LinkedHashMap();
        Integer r4 = Integer.valueOf(DeviceType.NORMAL_MOBILE.ordinal());
        t51.a r5 = new t51.a();
        AdjustBase r6 = AdjustBase.CANVAS;
        r5.m(r6.ordinal());
        LayoutScale r7 = LayoutScale.FIT_WIDTH;
        r5.t(r7.ordinal());
        LayoutAlign r8 = LayoutAlign.CENTER;
        r5.n(r8.ordinal());
        i r9 = new i();
        r9.j(0.0f);
        r9.m(0.0f);
        r9.k(1.0f);
        r9.i(1.0f);
        Unit r12 = Unit.INSTANCE;
        r5.v(r9);
        AnchorHeightFixMode r10 = AnchorHeightFixMode.RationTransformHeight;
        r5.p(r10.ordinal());
        AudienceHeightFixMode r13 = AudienceHeightFixMode.OriginContainerHeight;
        r5.r(r13.ordinal());
        r3.put(r4, r5);
        Integer r14 = Integer.valueOf(DeviceType.PAD_V.ordinal());
        t51.a r15 = new t51.a();
        r15.m(r6.ordinal());
        r15.t(r7.ordinal());
        r15.n(r8.ordinal());
        i r16 = new i();
        r16.j(0.0f);
        r16.m(0.0f);
        r16.k(1.0f);
        r16.i(1.0f);
        r15.v(r16);
        r15.p(r10.ordinal());
        r15.r(r13.ordinal());
        r3.put(r14, r15);
        Integer r17 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r18 = new t51.a();
        r18.m(r6.ordinal());
        r18.t(LayoutScale.ASPECT_FIT.ordinal());
        r18.n(LayoutAlign.CENTER_TOP.ordinal());
        i r19 = new i();
        r19.j(0.0f);
        r19.m(0.0f);
        r19.k(1.0f);
        r19.i(1.0f);
        r18.v(r19);
        r18.p(r10.ordinal());
        r18.r(r13.ordinal());
        r3.put(r17, r18);
        r2.g(r3);
        Map<Integer, ? extends List<e>> r20 = MapsKt.toMutableMap(r0.c().e());
        e r22 = new e();
        r22.m(0.0f);
        r22.n(0.19f);
        r22.l(0.5f);
        r22.h(0.25f);
        r22.i(0);
        e r23 = new e();
        r23.m(0.5f);
        r23.n(0.19f);
        r23.l(0.5f);
        r23.h(0.25f);
        r23.i(1);
        e r24 = new e();
        r24.m(0.0f);
        r24.n(0.44f);
        r24.l(1.0f);
        r24.h(0.31640625f);
        r24.i(10001);
        e r25 = new e();
        r25.m(0.0f);
        r25.n(0.0f);
        r25.l(1.0f);
        r25.h(1.0f);
        r25.i(10002);
        r20.put(2, CollectionsKt.listOf(new e[]{r22, r23, r24, r25}));
        r2.i(r20);
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m959invoke();
    }
}
