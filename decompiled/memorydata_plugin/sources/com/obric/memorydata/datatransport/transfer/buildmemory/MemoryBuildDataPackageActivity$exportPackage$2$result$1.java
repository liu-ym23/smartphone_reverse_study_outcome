package com.obric.memorydata.datatransport.transfer.buildmemory;

import com.obric.memorydata.datatransport.api.MemoryBuildExportRequest;
import com.obric.memorydata.migration.sdk.m;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.transfer.buildmemory.MemoryBuildDataPackageActivity$exportPackage$2$result$1", f = "MemoryBuildDataPackageActivity.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
final class MemoryBuildDataPackageActivity$exportPackage$2$result$1 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends File>>, Object> {
    final /* synthetic */ MemoryBuildExportRequest $exportRequest;
    int label;
    final /* synthetic */ MemoryBuildDataPackageActivity this$0;

    MemoryBuildDataPackageActivity$exportPackage$2$result$1(MemoryBuildExportRequest r3, MemoryBuildDataPackageActivity r4, Continuation<? super MemoryBuildDataPackageActivity$exportPackage$2$result$1> r5) {
        MemoryBuildDataPackageActivity r6 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r4, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$exportRequest = r3;
        this.this$0 = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryBuildDataPackageActivity$exportPackage$2$result$1(this.$exportRequest, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends File>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends File>> r4) {
        return ((MemoryBuildDataPackageActivity$exportPackage$2$result$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryBuildDataPackageActivity$exportPackage$2$result$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
        b r8 = b.f9812a;
        MemoryBuildExportRequest r2 = this.$exportRequest;
        m r3 = MemoryBuildDataPackageActivity.access$migrationCallback(this.this$0);
        Continuation<? super z<? extends File>> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r7 = r8.a(r2, r3, r4);
        if (r7 != r0) goto L11;
        return r0;
    }
}
