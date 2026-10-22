package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements ny8.c {
    public final /* synthetic */ ky8.d a;

    @Override // ny8.c
    public final void onCancel() {
        FLogger.a.i("CanvasGenerator", "onCancel, localId = " + this.a.a);
        this.a.d.onCancel();
    }

    public e(ky8.d r1) {
        this.a = r1;
    }

    @Override // ny8.c
    public final void a(List<CanvasBlock> r4) {
        Intrinsics.checkNotNullParameter(r4, "canvasBlocks");
        FLogger.a.i("CanvasGenerator", "onUpdate, localId = " + this.a.a);
        this.a.d.a(r4);
    }

    @Override // ny8.c
    public final void b(List<CanvasBlock> r4) {
        Intrinsics.checkNotNullParameter(r4, "canvasBlocks");
        FLogger.a.i("CanvasGenerator", "onFinish, localId = " + this.a.a);
        h r0 = h.a;
        ky8.d r1 = this.a;
        h.d(r1.a, r1.d, r4);
    }

    @Override // ny8.c
    public final void onError(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        FLogger.a.i("CanvasGenerator", "onError, localId = " + this.a.a + ", code = " + r4 + ", msg = " + r5);
        this.a.d.onError(r4, r5);
    }
}
