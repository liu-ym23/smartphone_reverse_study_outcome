package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.ICanvasRepoService;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements ny8.d<ny8.i> {
    public final /* synthetic */ ky8.d a;

    public f(ky8.d r1) {
        this.a = r1;
    }

    @Override // ny8.d
    public final void a(ny8.b r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("CanvasGenerator", "getCanvasBlockInfo onFailure, localId = " + this.a.a + ", error = " + r4);
        ny8.c r0 = this.a.d;
        Integer r1 = r4.a;
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        String r5 = r4.b;
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r0.onError(r2, r5);
        return;
    L5:
        r2 = -1;
        goto L6
    }

    @Override // ny8.d
    public final void onSuccess(ny8.i r21) {
        ny8.i r1 = r21;
        Intrinsics.checkNotNullParameter(r1, "result");
        FLogger.a.i("CanvasGenerator", "getCanvasBlockInfo onSuccess, localId = " + this.a.a + ", isFinish = " + r1.isFinish);
        if (Intrinsics.areEqual(r1.isFinish, Boolean.TRUE) == false) goto L9;
        ny8.c r2 = this.a.d;
        List<CanvasBlock> r3 = (List) r1.a.getValue();
        if (r3 != null) goto L7;
        r3 = CollectionsKt.emptyList();
    L7:
        r2.b(r3);
        return;
    L9:
        if (((List) r1.a.getValue()) == null) goto L14;
        ny8.c r4 = this.a.d;
        List<CanvasBlock> r5 = (List) r1.a.getValue();
        if (r5 != null) goto L13;
        r5 = CollectionsKt.emptyList();
    L13:
        r4.a(r5);
    L14:
        ICanvasRepoService.Companion r6 = ICanvasRepoService.a;
        ky8.d r7 = this.a;
        h.d.put(this.a.a, r6.a(new ny8.k(null, null, r7.a, null, null, null, null, null, r1.lastSeq, r7.b, r7.c, null, null, null, 30971), new e(this.a)));
    }
}
