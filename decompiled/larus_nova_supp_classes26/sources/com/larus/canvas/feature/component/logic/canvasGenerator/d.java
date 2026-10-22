package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.ICanvasRepoService;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements ny8.c {
    public final /* synthetic */ ky8.c a;
    public final /* synthetic */ ny8.c b;

    @Override // ny8.c
    public final void onCancel() {
        FLogger.a.i("CanvasGenerator", "onCancel, localId = " + this.a.c);
        this.b.onCancel();
    }

    @Override // ny8.c
    public final void a(List<CanvasBlock> r4) {
        Intrinsics.checkNotNullParameter(r4, "canvasBlocks");
        FLogger.a.i("CanvasGenerator", "onUpdate, localId = " + this.a.c);
        this.b.a(r4);
    }

    @Override // ny8.c
    public final void b(List<CanvasBlock> r4) {
        Intrinsics.checkNotNullParameter(r4, "canvasBlocks");
        FLogger.a.i("CanvasGenerator", "onFinish, localId = " + this.a.c);
        h r0 = h.a;
        h.d(this.a.c, this.b, r4);
    }

    public d(ky8.c r1, CanvasGenerator$startStreamGenerate$1.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // ny8.c
    public final void onError(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        FLogger r0 = FLogger.a;
        r0.e("CanvasGenerator", "onError, localId = " + this.a.c + ", code = " + r6 + ", msg = " + r7);
        h r8 = h.a;
        ky8.c r1 = this.a;
        ky8.d r9 = new ky8.d(r1.c, r1.d, r1.e, this.b);
        StringBuilder r2 = new StringBuilder("continueGenerate trigger, localId = ");
        r2.append(r9.a);
        r0.i("CanvasGenerator", r2.toString());
        ICanvasRepoService.a.b(new ny8.f(r9.a, 3), new f(r9));
    }
}
