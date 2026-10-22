package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0<T, R> implements Function {
    public final /* synthetic */ y a;

    public d0(y r1) {
        this.a = r1;
    }

    public final Object apply(Object r12) {
        SeiAppData r13 = (SeiAppData) r12;
        Intrinsics.checkNotNullParameter(r13, "curr");
        y r0 = this.a;
        SeiAppData r1 = r0.e;
        r0.e = r13;
        if (r1 != null) goto L6;
        return new b.C0054b(null, r13, true, true);
    L6:
        if (r1.getTimestamp() != r13.getTimestamp()) goto L10;
        b.C0054b r2 = new b.C0054b(r1, r13, false, false);
    L52:
        return r2;
    L10:
        if (r1.getGrids().size() == r13.getGrids().size()) goto L13;
        b.C0054b r3 = new b.C0054b(r1, r13, true, true);
    L53:
        return r3;
    L13:
        int r4 = r13.getGrids().size();
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L43;
        SeiRegion r6 = (SeiRegion) ListProtector.get(r13.getGrids(), r5);
        Iterator<T> r7 = r1.getGrids().iterator();
    L17:
        if (r7.hasNext() == false) goto L21;
        T r8 = r7.next();
        if (Intrinsics.areEqual(((SeiRegion) r8).getInteractId(), r6.getInteractId()) == false) goto L17;
    L22:
        SeiRegion r9 = (SeiRegion) r8;
        if (r9 == null) goto L24;
        if (r6.getType() == r9.getType()) goto L28;
    L33:
        boolean r10 = true;
    L35:
        if (r6.isTalking() == r9.isTalking()) goto L37;
        boolean r11 = true;
    L38:
        if (r10 == true) goto L42;
        if (r11 == true) goto L42;
        r5 = r5 + 1;
    L42:
        r2 = new b.C0054b(r1, r13, r10, r11);
        goto L52
    L37:
        r11 = false;
        goto L38
    L28:
        if (r6.position != r9.position) goto L33;
        if (r6.isVisible() != r9.isVisible()) goto L33;
        r10 = false;
        goto L35
    L24:
        r3 = new b.C0054b(r1, r13, true, true);
        goto L53
    L21:
        r8 = null;
        goto L22
    L43:
        r2 = new b.C0054b(r1, r13, false, false);
        goto L52
    }
}
