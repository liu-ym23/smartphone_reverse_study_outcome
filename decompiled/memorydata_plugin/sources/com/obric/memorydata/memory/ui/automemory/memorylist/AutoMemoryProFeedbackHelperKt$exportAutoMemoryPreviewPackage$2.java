package com.obric.memorydata.memory.ui.automemory.memorylist;

import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.datatransport.api.MemoryBuildExportRequest;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "dir"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryProFeedbackHelperKt$exportAutoMemoryPreviewPackage$2", f = "AutoMemoryProFeedbackHelper.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryProFeedbackHelperKt$exportAutoMemoryPreviewPackage$2 extends SuspendLambda implements Function3<MemoryBuildExportRequest, File, Continuation<? super z<? extends File>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    AutoMemoryProFeedbackHelperKt$exportAutoMemoryPreviewPackage$2(Continuation<? super AutoMemoryProFeedbackHelperKt$exportAutoMemoryPreviewPackage$2> r3) {
        super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MemoryBuildExportRequest r2, File r3, Continuation<? super z<? extends File>> r4) {
        AutoMemoryProFeedbackHelperKt$exportAutoMemoryPreviewPackage$2 r5 = new AutoMemoryProFeedbackHelperKt$exportAutoMemoryPreviewPackage$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        r5.L$0 = r2;
        r5.L$1 = r3;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(MemoryBuildExportRequest r3, File r4, Continuation<? super z<? extends File>> r5) {
        return invoke2((MemoryBuildExportRequest) ZeusTransformUtils.preCheckCast(r3, MemoryBuildExportRequest.class, "com.obric.memorydata.plugin"), (File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MemoryBuildExportRequest r8 = (MemoryBuildExportRequest) ZeusTransformUtils.preCheckCast(this.L$0, MemoryBuildExportRequest.class, "com.obric.memorydata.plugin");
        File r2 = (File) ZeusTransformUtils.preCheckCast(this.L$1, File.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.union.build.export.d r4 = com.obric.memorydata.union.build.export.d.f13079a;
        Continuation<? super z<? extends File>> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.label = 1;
        r7 = r4.a(r8, r2, r3);
        if (r7 != r0) goto L11;
        return r0;
    }
}
