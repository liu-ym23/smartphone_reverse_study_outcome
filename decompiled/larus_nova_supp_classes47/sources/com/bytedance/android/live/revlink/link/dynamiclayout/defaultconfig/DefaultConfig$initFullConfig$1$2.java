package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import t51.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "count", "", "forLayer", "", "Lt51/e;", "invoke", "(IZ)Ljava/util/List;", "genOtherSmallConfig"}, k = 3, mv = {1, 5, 1})
final class DefaultConfig$initFullConfig$1$2 extends Lambda implements Function2<Integer, Boolean, List<? extends e>> {
    public static final DefaultConfig$initFullConfig$1$2 INSTANCE = null;

    static {
        INSTANCE = new DefaultConfig$initFullConfig$1$2();
    }

    public DefaultConfig$initFullConfig$1$2() {
        super(2);
    }

    public final List<e> invoke(int r12, boolean r13) {
        e r0 = new e();
        r0.m(0.0f);
        r0.n(0.0f);
        r0.l(1.0f);
        r0.h(1.0f);
        r0.i(0);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r4 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r5 = Integer.valueOf(r4.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.q r6 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.c;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r7 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        Integer r8 = Integer.valueOf(r7.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.p r9 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.p.c;
        r0.t(MapsKt.mapOf(new Pair[]{TuplesKt.to(r5, 7), TuplesKt.to(r8, 6)}));
        r0.r(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r4.ordinal()), 6), TuplesKt.to(Integer.valueOf(r7.ordinal()), 6)}));
        ArrayList r2 = new ArrayList();
        r2.add(r0);
        if (r13 == false) goto L5;
        Number r14 = Double.valueOf(0.09d);
    L6:
        float r15 = r14.floatValue();
        int r1 = 1;
    L7:
        if (r1 >= r12) goto L9;
        e r3 = new e();
        r3.m((float) 0.7222d);
        r3.l((float) 0.25d);
        r3.h((float) 0.2d);
        r3.n(((float) (((double) (1 - (r1 * r3.a()))) - 0.1d)) + r15);
        r3.i(r1);
        r3.o();
        IAnchorUpdateLayoutContent.AnchorLayoutRange r10 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r16 = Integer.valueOf(r10.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.q r17 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.c;
        r3.t(MapsKt.mapOf(TuplesKt.to(r16, 7)));
        r3.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r10.ordinal()), 7)));
        Unit r18 = Unit.INSTANCE;
        r2.add(r3);
        r1 = r1 + 1;
        goto L7
    L9:
        return r2;
    L5:
        r14 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), ((Boolean) r2).booleanValue());
    }

    public static /* synthetic */ List invoke$default(DefaultConfig$initFullConfig$1$2 r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.invoke(r1, r2);
    }
}
