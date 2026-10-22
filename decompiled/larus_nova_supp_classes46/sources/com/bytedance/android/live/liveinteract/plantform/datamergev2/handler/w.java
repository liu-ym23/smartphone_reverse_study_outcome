package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w<T, R> implements Function {
    public final /* synthetic */ p a;

    public w(p r1) {
        this.a = r1;
    }

    public final Object apply(Object r13) {
        SeiAppData r14 = (SeiAppData) r13;
        Intrinsics.checkNotNullParameter(r14, "curr");
        p r0 = this.a;
        SeiAppData r1 = r0.f;
        r0.f = r14;
        if (r1 == null) goto L37;
        int r7 = 0;
        if (r1.getTimestamp() != r14.getTimestamp()) goto L10;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b r2 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b(r1, r14, false, false);
    L45:
        return r2;
    L10:
        if (r1.getGrids().size() == r14.getGrids().size()) goto L13;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b r3 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b(r1, r14, true, true);
    L46:
        return r3;
    L13:
        int r4 = r14.getGrids().size();
        boolean r5 = false;
        boolean r6 = false;
    L14:
        if (r7 >= r4) goto L36;
        SeiRegion r8 = (SeiRegion) ListProtector.get(r14.getGrids(), r7);
        Iterator<T> r9 = r1.getGrids().iterator();
    L17:
        if (r9.hasNext() == false) goto L21;
        T r10 = r9.next();
        if (Intrinsics.areEqual(((SeiRegion) r10).getInteractId(), r8.getInteractId()) == false) goto L17;
    L22:
        SeiRegion r11 = (SeiRegion) r10;
        if (r11 == null) goto L24;
        if (r8.getType() == r11.getType()) goto L28;
    L31:
        r5 = true;
    L33:
        if (r8.isTalking() == r11.isTalking()) goto L35;
        r6 = true;
    L35:
        r7 = r7 + 1;
        goto L14
    L28:
        if (r8.position != r11.position) goto L31;
        if (r8.isVisible() == r11.isVisible()) goto L33;
    L24:
        r3 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b(r1, r14, true, true);
        goto L46
    L21:
        r10 = null;
        goto L22
    L36:
        r2 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b(r1, r14, r5, r6);
        goto L45
    L37:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b(null, r14, true, true);
    }
}
