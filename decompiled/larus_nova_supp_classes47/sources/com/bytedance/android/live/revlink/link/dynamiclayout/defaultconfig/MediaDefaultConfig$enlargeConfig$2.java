package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
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
import t51.e;
import t51.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", "invoke", "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MediaDefaultConfig$enlargeConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public MediaDefaultConfig$enlargeConfig$2(MediaDefaultConfig r8) {
        super(0, r8, MediaDefaultConfig.class, "initEnlargeConfig", "initEnlargeConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final g m961invoke() {
        MediaDefaultConfig r1 = (MediaDefaultConfig) ((CallableReference) this).receiver;
        int r2 = MediaDefaultConfig.d;
        r1.getClass();
        g r3 = new g();
        r3.g(((g) r1.b.getValue()).b());
        Map<Integer, ? extends List<e>> r4 = MapsKt.toMutableMap(((g) r1.b.getValue()).e());
        e r5 = new e();
        r5.m(0.0f);
        double r6 = s11.a.a;
        float r8 = (float) r6;
        r5.n(r8);
        r5.l((float) 0.6613333333333333d);
        r5.h((float) 0.693d);
        r5.i(0);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r10 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r12 = Integer.valueOf(r10.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.c r13 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.c.c;
        r5.t(MapsKt.mapOf(TuplesKt.to(r12, 3)));
        r5.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r10.ordinal()), 3)));
        Unit r14 = Unit.INSTANCE;
        e r7 = new e();
        float r9 = (float) 0.6641111111111111d;
        r7.m(r9);
        r7.n(r8);
        float r15 = (float) 0.3358888888888889d;
        r7.l(r15);
        float r16 = (float) 0.2299583333333333d;
        r7.h(r16);
        r7.i(1);
        Integer r17 = Integer.valueOf(r10.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.d r18 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.d.c;
        r7.t(MapsKt.mapOf(TuplesKt.to(r17, 4)));
        r7.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r10.ordinal()), 4)));
        e r19 = new e();
        r19.m(r9);
        r19.n((float) ((0.2299583333333333d + r6) + 0.0015625d));
        r19.l(r15);
        r19.h(r16);
        r19.i(2);
        r19.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r10.ordinal()), 3)));
        r19.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r10.ordinal()), 3)));
        e r20 = new e();
        r20.m(r9);
        r20.n((float) (r6 + 0.4630416666666666d));
        r20.l(r15);
        r20.h(r16);
        r20.i(3);
        r20.t(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r10.ordinal()), 3)));
        r20.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r10.ordinal()), 3)));
        r4.put(4, CollectionsKt.listOf(new e[]{r5, r7, r19, r20}));
        r3.i(r4);
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m961invoke();
    }
}
