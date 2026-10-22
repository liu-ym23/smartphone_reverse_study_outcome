package com.obric.memorydata.union.build.export;

import android.util.EventsUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.union.build.export.MemoryBuildDataPackageExporter", f = "MemoryBuildDataPackageExporter.kt", i = {0, 0}, l = {EventsUtils.FEAT_TYPE_ACTIVITY_PAUSED_TIMEOUT}, m = "exportPreviewPackage", n = {"this", "outputDir"}, s = {"L$0", "L$1"})
final class MemoryBuildDataPackageExporter$exportPreviewPackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    MemoryBuildDataPackageExporter$exportPreviewPackage$1(d r3, Continuation<? super MemoryBuildDataPackageExporter$exportPreviewPackage$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
