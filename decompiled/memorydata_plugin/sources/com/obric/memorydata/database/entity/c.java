package com.obric.memorydata.database.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "", "<init>", "()V", "getRawDbEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getHistoryDbId", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class c {
    public c() {
    }

    public abstract long getHistoryDbId();

    public abstract d getRawDbEntity();
}
