package com.obric.memorydata.union.build.export;

import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.union.build.export.MemoryBuildDataPackageExporter", f = "MemoryBuildDataPackageExporter.kt", i = {0, 0, 0, 1}, l = {BDVideoUploaderBase.KeyIsEnableLogicalPart, 98}, m = "exportPackageWithConfig", n = {"this", "outputDir", "callback", "plan"}, s = {"L$0", "L$1", "L$2", "L$0"})
final class MemoryBuildDataPackageExporter$exportPackageWithConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    MemoryBuildDataPackageExporter$exportPackageWithConfig$1(d r3, Continuation<? super MemoryBuildDataPackageExporter$exportPackageWithConfig$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
