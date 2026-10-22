package com.larus.canvas.service.internal;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ny8.f;
import ny8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class GetCanvasBlockInfoProcessor extends c<i> {
    public final f d;
    public final String e;

    public final void a() {
        FLogger.a.i(this.e, "trigger , canvasId = " + this.d.canvasId + ", canvasSubId = " + this.d.canvasSubId + ", localId = " + this.d.localId);
        BuildersKt.launch$default((CoroutineScope) this.b.getValue(), null, null, new GetCanvasBlockInfoProcessor$process$1(this, null), 3, null);
    }

    public GetCanvasBlockInfoProcessor(f r2, ny8.d<i> r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        super(r3);
        this.d = r2;
        this.e = "GetCanvasBlockInfoProcessor";
    }
}
