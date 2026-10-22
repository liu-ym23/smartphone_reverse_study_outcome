package com.obric.memorydata.database.account_split.spliter;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitMigrationTimeoutException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", TypedValues.CycleType.S_WAVE_PHASE, "", "tableName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalDbSplitMigrationTimeoutException extends IllegalStateException {
    public PersonalDbSplitMigrationTimeoutException(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r4, "tableName");
        super("personal db split migration timeout, phase=" + r3 + ", table=" + r4);
    }
}
