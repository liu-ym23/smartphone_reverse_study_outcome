package com.obric.memorydata.migration.sdk;

import android.content.Context;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationAddon;", "", OaidModel.KEY_ID, "", "getId", "()Ljava/lang/String;", "displayName", "getDisplayName", "onBackup", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "context", "Landroid/content/Context;", "addonDir", "Ljava/io/File;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Landroid/content/Context;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRestore", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface k {
    Object a(Context r1, File r2, m r3, Continuation<? super z<Unit>> r4);

    String a();

    Object b(Context r1, File r2, m r3, Continuation<? super z<Unit>> r4);
}
