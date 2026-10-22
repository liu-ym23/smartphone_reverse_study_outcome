package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$fullRecordNormalConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$fullRecordNormalConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initFullRecordNormalConfig", "initFullRecordNormalConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m952invoke() {
        DefaultConfig r1 = (DefaultConfig) ((CallableReference) this).receiver;
        int r2 = DefaultConfig.m;
        r1.getClass();
        g r3 = new g();
        LinkedHashMap r4 = new LinkedHashMap();
        Integer r5 = Integer.valueOf(DeviceType.NORMAL_MOBILE.ordinal());
        t51.a r6 = new t51.a();
        r6.m(AdjustBase.CONTENT.ordinal());
        r6.t(LayoutScale.FIT_WIDTH.ordinal());
        r6.n(LayoutAlign.RIGHT_TOP.ordinal());
        i r7 = new i();
        r7.j(0.0f);
        r7.m(0.0f);
        r7.k(1.0f);
        r7.i(1.0f);
        Unit r8 = Unit.INSTANCE;
        r6.v(r7);
        AnchorHeightFixMode r9 = AnchorHeightFixMode.PreviewHeight;
        r6.p(r9.ordinal());
        AudienceHeightFixMode r10 = AudienceHeightFixMode.OriginContainerHeight;
        r6.r(r10.ordinal());
        r4.put(r5, r6);
        Integer r12 = Integer.valueOf(DeviceType.PAD_V.ordinal());
        t51.a r13 = new t51.a();
        AdjustBase r14 = AdjustBase.CANVAS;
        r13.m(r14.ordinal());
        LayoutScale r15 = LayoutScale.ASPECT_FIT;
        r13.t(r15.ordinal());
        r13.n(LayoutAlign.RIGHT_CENTER.ordinal());
        i r16 = new i();
        r16.j(0.0f);
        r16.m(0.0f);
        r16.k(1.0f);
        r16.i(1.0f);
        r13.v(r16);
        r13.p(r9.ordinal());
        r13.r(r10.ordinal());
        r4.put(r12, r13);
        Integer r17 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r18 = new t51.a();
        r18.m(r14.ordinal());
        r18.t(r15.ordinal());
        r18.n(LayoutAlign.CENTER.ordinal());
        i r19 = new i();
        r19.j(0.0f);
        r19.m(0.0f);
        r19.k(1.0f);
        r19.i(1.0f);
        r18.v(r19);
        r18.p(r9.ordinal());
        r18.r(r10.ordinal());
        r4.put(r17, r18);
        r3.g(r4);
        DefaultConfig$initFullRecordNormalConfig$1$2 r20 = DefaultConfig$initFullRecordNormalConfig$1$2.INSTANCE;
        r3.i(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 1, true, false, 4, null)), TuplesKt.to(2, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 2, true, false, 4, null)), TuplesKt.to(3, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 3, true, false, 4, null)), TuplesKt.to(4, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 4, true, false, 4, null))}));
        r3.j(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 1, false, false, 6, null)), TuplesKt.to(2, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 2, false, false, 6, null)), TuplesKt.to(3, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 3, false, false, 6, null)), TuplesKt.to(4, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 4, false, false, 6, null))}));
        r3.h(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 1, false, false, 6, null)), TuplesKt.to(2, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 2, false, false, 6, null)), TuplesKt.to(3, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 3, false, false, 6, null)), TuplesKt.to(4, DefaultConfig$initFullRecordNormalConfig$1$2.invoke$default(r20, 4, false, false, 6, null))}));
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m952invoke();
    }
}
