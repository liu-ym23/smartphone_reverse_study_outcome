package com.obric.memorydata.middleware.database;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "dbName", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getDbName", "()Ljava/lang/String;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatabaseException extends RuntimeException {
    private final String dbName;

    public DatabaseException(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "dbName");
        Intrinsics.checkNotNullParameter(r4, "cause");
        super("DatabaseCrash: name=" + r3 + ", message=" + r4.getMessage(), r4);
        this.dbName = r3;
    }

    public final String getDbName() {
        return this.dbName;
    }
}
