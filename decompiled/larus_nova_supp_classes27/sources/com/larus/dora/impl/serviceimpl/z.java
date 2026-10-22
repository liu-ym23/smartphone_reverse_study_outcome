package com.larus.dora.impl.serviceimpl;

import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.api.model.FlowDoraVisionConfig;
import h49.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z implements qk4.j {
    public final /* synthetic */ VisionService a;

    public final /* synthetic */ void f(byte[] r1) {
    }

    public z(VisionService r1) {
        this.a = r1;
    }

    public final void c(byte[] r3) {
        this.a.getClass();
        FlowDoraVideoRecordConfig r4 = VisionService.i(r3);
        if (r4 == null) goto L8;
        Iterator r0 = this.a.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((g) r0.next()).a(r4);
        goto L6
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [h49.g] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    public final void h(byte[] r15) {
        this.a.getClass();
        if (r15 != null) goto L5;
    L18:
        ?? r1 = CollectionsKt.emptyList();
    L19:
        boolean r16 = !((Collection) r1).isEmpty();
        ?? r2 = r1;
        if (r16 == true) goto L23;
        r2 = 0;
    L23:
        if (r2 == 0) goto L28;
        Iterator r17 = this.a.a.iterator();
    L26:
        if (r17.hasNext() == false) goto L31;
        ((g) r17.next()).b(r2);
        goto L26
    L31:
        return;
    L28:
        return;
    L5:
        if (r15.length != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L18;
        if ((r15.length % 12) != 0) goto L18;
        r1 = new ArrayList();
        int r4 = ProgressionUtilKt.getProgressionLastElement(0, r15.length - 1, 12);
        if (r4 < 0) goto L19;
        int r5 = 0;
    L15:
        byte r6 = r15[r5];
        int r7 = VisionService.o(new byte[]{r15[r5 + 1], r15[r5 + 2]});
        int r8 = VisionService.o(new byte[]{r15[r5 + 3], r15[r5 + 4]});
        byte r9 = r15[r5 + 5];
        byte r10 = r15[r5 + 6];
        byte r11 = r15[r5 + 7];
        byte r12 = r15[r5 + 8];
        byte r13 = r15[r5 + 9];
        FloatCompanionObject r14 = FloatCompanionObject.INSTANCE;
        int r18 = r10 & 255;
        r1.add(new FlowDoraVisionConfig(r6, r7, r8, r9, Float.intBitsToFloat(r18 | (((r11 & 255) << 8) | (((r12 & 255) << 16) | ((r13 & 255) << 24)))), r15[r5 + 10], r15[r5 + 11]));
        if (r5 == r4) goto L19;
        r5 = r5 + 12;
        goto L15
    L7:
        r3 = false;
        goto L8
    }
}
