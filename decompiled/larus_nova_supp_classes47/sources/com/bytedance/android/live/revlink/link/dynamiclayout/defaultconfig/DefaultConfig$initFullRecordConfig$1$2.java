package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import t51.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "count", "", "forLayer", "forStreamMix", "", "Lt51/e;", "invoke", "(IZZ)Ljava/util/List;", "genOtherSmallConfig"}, k = 3, mv = {1, 5, 1})
final class DefaultConfig$initFullRecordConfig$1$2 extends Lambda implements Function3<Integer, Boolean, Boolean, List<? extends e>> {
    public static final DefaultConfig$initFullRecordConfig$1$2 INSTANCE = null;

    static {
        INSTANCE = new DefaultConfig$initFullRecordConfig$1$2();
    }

    public DefaultConfig$initFullRecordConfig$1$2() {
        super(3);
    }

    public final List<e> invoke(int r9, boolean r10, boolean r12) {
        e r13 = new e();
        r13.m(0.0f);
        r13.n(0.0f);
        r13.l(1.0f);
        r13.h(1.0f);
        r13.i(0);
        IAnchorUpdateLayoutContent.AnchorLayoutRange r1 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r2 = Integer.valueOf(r1.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.q r3 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.c;
        r13.t(MapsKt.mapOf(TuplesKt.to(r2, 7)));
        Integer r4 = Integer.valueOf(r1.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.p r5 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.p.c;
        r13.r(MapsKt.mapOf(TuplesKt.to(r4, 6)));
        r13.k();
        ArrayList r6 = new ArrayList();
        r6.add(r13);
        if (r10 == false) goto L5;
        Number r14 = Double.valueOf(0.09d);
    L6:
        float r15 = r14.floatValue();
        int r0 = 1;
    L7:
        if (r0 >= r9) goto L9;
        e r7 = new e();
        r7.m((float) 0.7222d);
        r7.l((float) 0.25d);
        r7.h((float) 0.2d);
        r7.n(((float) (((double) (1 - (r0 * r7.a()))) - 0.1d)) + r15);
        r7.i(r0);
        r7.o();
        IAnchorUpdateLayoutContent.AnchorLayoutRange r8 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        Integer r16 = Integer.valueOf(r8.ordinal());
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.q r17 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.q.c;
        r7.t(MapsKt.mapOf(TuplesKt.to(r16, 7)));
        r7.r(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r8.ordinal()), 7)));
        Unit r18 = Unit.INSTANCE;
        r6.add(r7);
        r0 = r0 + 1;
        goto L7
    L9:
        return r6;
    L5:
        r14 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Number) r1).intValue(), ((Boolean) r2).booleanValue(), ((Boolean) r3).booleanValue());
    }

    public static /* synthetic */ List invoke$default(DefaultConfig$initFullRecordConfig$1$2 r1, int r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return r1.invoke(r2, r3, r4);
    }
}
