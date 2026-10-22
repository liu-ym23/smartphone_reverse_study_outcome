package com.larus.canvas.feature.component.logic;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class t0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ GenImagePlannerComponent b;

    public /* synthetic */ t0(String r1, GenImagePlannerComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        GenImagePlannerComponent r1 = this.b;
        int r2 = GenImagePlannerComponent.W;
        FLogger.a.d("GenImagePlannerComponent", "onListSubmitRunnable trigger, localId = " + r0);
        Iterator<T> r3 = ((ky8.g) r1.m.getValue()).a.values().iterator();
        int r4 = -1;
        int r6 = 0;
    L3:
        boolean r8 = true;
        if (r3.hasNext() == false) goto L17;
        Object r7 = r3.next();
        if (r6 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ky8.h r9 = (ky8.h) r7;
        if ((r9 instanceof ky8.f) == true) goto L11;
    L13:
        r8 = false;
    L14:
        if (r8 == false) goto L16;
        r4 = r6;
    L16:
        r6 = r6 + 1;
        goto L3
    L11:
        if (Intrinsics.areEqual(((ky8.f) r9).a, r0) == false) goto L13;
    L17:
        if (r4 < 0) goto L27;
        FLogger.a.d("GenImagePlannerComponent", "onListSubmitRunnable - ScrollToPosition, " + r4 + ", localId = " + r0);
        com.larus.canvas.feature.component.resultdisplay.image.r r5 = r1.Z3();
        if (r5 == null) goto L26;
        r5.yS(new com.larus.canvas.feature.component.resultdisplay.image.t.a(r4, true));
        return;
    L26:
        return;
    }
}
