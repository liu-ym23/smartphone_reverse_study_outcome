package com.bytedance.android.live.room.incentiveinfo;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements u81.g<w81.b> {
    public final /* synthetic */ g a;

    public i(g r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u81.g
    public final void c(w81.b r6) {
        w81.b r7 = r6;
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        g r0 = this.a;
        r0.getClass();
        ALogger.d("IncentiveInfoManager", "change tab dataSet.the operate is " + r7.c + "\tthe tabData is " + r7.d);
        int r1 = h.a[r7.c.ordinal()];
        if (r1 == 1) goto L29;
        if (r1 != 2) goto L7;
        ((ArrayList) r0.d).remove(r7.d);
        r0.b();
        d r2 = r0.b;
        if (r2 == null) goto L18;
        com.bytedance.android.live.room.incentiveinfo.datamonitor.d<w81.a> r3 = r2.b;
        if (r3 == null) goto L18;
        r3.onChange();
    L18:
        x81.b<u81.d> r4 = r0.c;
        int r8 = r4.a(r7.d.e.getValue(), r7.d.d);
        if (r8 == (-1)) goto L41;
        Pair r5 = r4.a[r8];
        if (r5 == null) goto L27;
        u81.d r9 = (u81.d) r5.getSecond();
        if (r9 == null) goto L27;
        IncentiveInfoLayout.LayoutParams r10 = x81.a.a(r9.a());
        if (r10 == null) goto L27;
        r10.a = null;
        r10.b = null;
    L27:
        r4.a[r8] = 0;
        return;
    L41:
        return;
    L7:
        if (r1 == 3) goto L10;
        return;
    L10:
        if (((ArrayList) r0.d).contains(r7.d) == false) goto L12;
        List<w81.a> r12 = r0.d;
        ((w81.a) ListProtector.get(r12, ((ArrayList) r12).indexOf(r7.d))).a = r7.d.a;
        r0.b();
    L12:
        r0.a.d(((ArrayList) r0.d).indexOf(r7.d));
        return;
    L29:
        if (((ArrayList) r0.d).contains(r7.d) == false) goto L31;
        List<w81.a> r13 = r0.d;
        ((w81.a) ListProtector.get(r13, ((ArrayList) r13).indexOf(r7.d))).a = r7.d.a;
        r0.b();
    L37:
        if (r7.a == false) goto L43;
        r0.a.c(((ArrayList) r0.d).indexOf(r7.d), r7.b);
        return;
    L43:
        return;
    L31:
        List<w81.a> r14 = r0.d;
        w81.a r15 = new w81.a(r7.d.e);
        w81.a r16 = r7.d;
        r15.b = r16.b;
        r15.a = r16.a;
        r15.c = r16.c;
        r15.d = r16.d;
        Unit r17 = Unit.INSTANCE;
        ((ArrayList) r14).add(r15);
        d r18 = r0.b;
        if (r18 == null) goto L37;
        com.bytedance.android.live.room.incentiveinfo.datamonitor.d<w81.a> r19 = r18.b;
        if (r19 == null) goto L37;
        r19.onChange();
        goto L37
    }
}
