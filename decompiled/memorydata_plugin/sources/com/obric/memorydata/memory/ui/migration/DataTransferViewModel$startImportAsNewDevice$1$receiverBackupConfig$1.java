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
@DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferViewModel$startImportAsNewDevice$1$receiverBackupConfig$1", f = "DataTransferViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DataTransferViewModel$startImportAsNewDevice$1$receiverBackupConfig$1 extends SuspendLambda implements Function2<al, Continuation<? super com.obric.memorydata.migration.sdk.b>, Object> {
    final /* synthetic */ boolean $autoEnabled;
    final /* synthetic */ com.obric.memorydata.migration.sdk.b $baseBackupConfig;
    final /* synthetic */ boolean $screenEnabled;
    int label;
    final /* synthetic */ DataTransferViewModel this$0;

    DataTransferViewModel$startImportAsNewDevice$1$receiverBackupConfig$1(DataTransferViewModel r3, com.obric.memorydata.migration.sdk.b r4, boolean r5, boolean r6, Continuation<? super DataTransferViewModel$startImportAsNewDevice$1$receiverBackupConfig$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$baseBackupConfig = r4;
        this.$screenEnabled = r5;
        this.$autoEnabled = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DataTransferViewModel$startImportAsNewDevice$1$receiverBackupConfig$1(this.this$0, this.$baseBackupConfig, this.$screenEnabled, this.$autoEnabled, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super com.obric.memorydata.migration.sdk.b> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super com.obric.memorydata.migration.sdk.b> r4) {
        return ((DataTransferViewModel$startImportAsNewDevice$1$receiverBackupConfig$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataTransferViewModel$startImportAsNewDevice$1$receiverBackupConfig$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return DataTransferViewModel.access$buildReceiverBackupConfig(this.this$0, this.$baseBackupConfig, this.$screenEnabled, this.$autoEnabled);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
