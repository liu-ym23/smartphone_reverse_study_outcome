package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import com.bytedance.crash.d;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.essentialtask.base.ExecuteResult;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.datatransfer.client.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$internalExecute$2$1", "Lcom/obric/datatransfer/client/DataTransferClient$TransferCallback;", "onProgress", "", WindowEvent.WindowOpenPerfResult.SUCCESS, "", "failed", "onComplete", "successCount", "failedCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataMigrationTask$internalExecute$2$1 implements b.InterfaceC0039b {
    final /* synthetic */ i<ExecuteResult> $continuation;
    final /* synthetic */ DataMigrationTask this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DataMigrationTask$internalExecute$2$1(DataMigrationTask r1, i<? super ExecuteResult> r2) {
        this.this$0 = r1;
        this.$continuation = r2;
    }

    @Override // com.obric.datatransfer.client.b.InterfaceC0039b
    public void onComplete(int r4, int r5) {
        FLogger.a.i("data_migration", "Migration completed for " + DataMigrationTask.access$getPluginPkg$p(this.this$0) + ". Success: " + r4 + ", Failed: " + r5);
        DataMigrationTask.access$startMigrationHost(this.this$0, r4);
        DataMigrationTask r0 = this.this$0;
        DataMigrationTask.access$updateMigrationStatus(r0, DataMigrationTask.access$getPluginPkg$p(r0), MigrationStatus.FINISHED);
        if (r5 <= 0) goto L6;
        d.b("OTA Error: some files migration failed for " + DataMigrationTask.access$getPluginPkg$p(this.this$0) + ", successCount=" + r4 + ", failedCount=" + r5);
    L6:
        if (this.$continuation.isCancelled() == false) goto L8;
        return;
    L8:
        i<ExecuteResult> r6 = this.$continuation;
        Result.Companion r7 = Result.Companion;
        r6.resumeWith(Result.constructor-impl(new ExecuteResult.Succeed()));
    }

    @Override // com.obric.datatransfer.client.b.InterfaceC0039b
    public void onProgress(int r4, int r5) {
        FLogger.a.d("data_migration", "Migration in process success = " + r4 + ", failed = " + r5);
    }
}
