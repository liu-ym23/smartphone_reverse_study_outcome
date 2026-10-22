package com.obric.memorydata.memory.ui.migration;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferViewModel$startExportAsOldDevice$1$backupConfig$1", f = "DataTransferViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DataTransferViewModel$startExportAsOldDevice$1$backupConfig$1 extends SuspendLambda implements Function2<al, Continuation<? super com.obric.memorydata.migration.sdk.b>, Object> {
    final /* synthetic */ a $exportSelection;
    int label;
    final /* synthetic */ DataTransferViewModel this$0;

    DataTransferViewModel$startExportAsOldDevice$1$backupConfig$1(a r3, DataTransferViewModel r4, Continuation<? super DataTransferViewModel$startExportAsOldDevice$1$backupConfig$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$exportSelection = r3;
        this.this$0 = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DataTransferViewModel$startExportAsOldDevice$1$backupConfig$1(this.$exportSelection, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super com.obric.memorydata.migration.sdk.b> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super com.obric.memorydata.migration.sdk.b> r4) {
        return ((DataTransferViewModel$startExportAsOldDevice$1$backupConfig$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataTransferViewModel$startExportAsOldDevice$1$backupConfig$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r7);
        if (this.$exportSelection.b() == false) goto L8;
        return DataTransferViewModel.access$buildMigrationBackupConfig(this.this$0);
    L8:
        return new com.obric.memorydata.migration.sdk.b(null, null, null, 7, null);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
