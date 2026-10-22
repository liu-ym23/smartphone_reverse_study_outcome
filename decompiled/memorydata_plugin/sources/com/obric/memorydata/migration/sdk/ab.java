package com.obric.memorydata.migration.sdk;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/migration/sdk/PostRestoreHook;", "", "onPostRestore", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "context", "Landroid/content/Context;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Landroid/content/Context;Lcom/obric/memorydata/migration/sdk/BackupConfig;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ab {
    Object a(Context r1, b r2, m r3, Continuation<? super z<Unit>> r4);
}
