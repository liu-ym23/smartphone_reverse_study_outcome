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
public final /* synthetic */ class DefaultConfig$fullRecordConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$fullRecordConfig$2(DefaultConfig r8) {
        super(0, r8, DefaultConfig.class, "initFullRecordConfig", "initFullRecordConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m951invoke() {
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
        LayoutAlign r8 = LayoutAlign.CENTER_TOP;
        r6.n(r8.ordinal());
        i r9 = new i();
        r9.j(0.0f);
        r9.m(0.19f);
        r9.k(1.0f);
        r9.i(1.0f);
        Unit r12 = Unit.INSTANCE;
        r6.v(r9);
        AnchorHeightFixMode r10 = AnchorHeightFixMode.PreviewHeight;
        r6.p(r10.ordinal());
        AudienceHeightFixMode r13 = AudienceHeightFixMode.OriginContainerHeight;
        r6.r(r13.ordinal());
        r4.put(r5, r6);
        Integer r14 = Integer.valueOf(DeviceType.PAD_V.ordinal());
        t51.a r15 = new t51.a();
        r15.m(r7.ordinal());
        LayoutScale r16 = LayoutScale.ASPECT_FIT;
        r15.t(r16.ordinal());
        r15.n(r8.ordinal());
        i r17 = new i();
        r17.j(0.0f);
        r17.m(0.19f);
        r17.k(1.0f);
        r17.i(1.0f);
        r15.v(r17);
        r15.p(r10.ordinal());
        r15.r(r13.ordinal());
        r4.put(r14, r15);
        Integer r18 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r19 = new t51.a();
        r19.m(AdjustBase.CANVAS.ordinal());
        r19.t(r16.ordinal());
        r19.n(LayoutAlign.CENTER.ordinal());
        i r20 = new i();
        r20.j(0.0f);
        r20.m(0.0f);
        r20.k(1.0f);
        r20.i(1.0f);
        r19.v(r20);
        r19.p(r10.ordinal());
        r19.r(r13.ordinal());
        r4.put(r18, r19);
        r3.g(r4);
        DefaultConfig$initFullRecordConfig$1$2 r22 = DefaultConfig$initFullRecordConfig$1$2.INSTANCE;
        r3.i(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 1, true, false, 4, null)), TuplesKt.to(2, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 2, true, false, 4, null)), TuplesKt.to(3, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 3, true, false, 4, null)), TuplesKt.to(4, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 4, true, false, 4, null))}));
        r3.j(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 1, false, false, 6, null)), TuplesKt.to(2, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 2, false, false, 6, null)), TuplesKt.to(3, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 3, false, false, 6, null)), TuplesKt.to(4, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 4, false, false, 6, null))}));
        r3.h(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 1, false, false, 6, null)), TuplesKt.to(2, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 2, false, false, 6, null)), TuplesKt.to(3, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 3, false, false, 6, null)), TuplesKt.to(4, DefaultConfig$initFullRecordConfig$1$2.invoke$default(r22, 4, false, false, 6, null))}));
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m951invoke();
    }
}
