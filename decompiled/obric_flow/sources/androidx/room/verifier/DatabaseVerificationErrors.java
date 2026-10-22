package androidx.room.verifier;

import java.sql.SQLException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/room/verifier/DatabaseVerificationErrors;", "", "()V", "CANNOT_CREATE_SQLITE_CONNECTION", "", "CANNOT_VERIFY_QUERY", "cannotCreateConnection", "exception", "", "cannotVerifyQuery", "Ljava/sql/SQLException;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseVerificationErrors {
    private static final String CANNOT_CREATE_SQLITE_CONNECTION = null;
    private static final String CANNOT_VERIFY_QUERY = null;
    public static final DatabaseVerificationErrors INSTANCE = null;

    static {
        INSTANCE = new DatabaseVerificationErrors();
        CANNOT_VERIFY_QUERY = "There is a problem with the query: %s";
        CANNOT_CREATE_SQLITE_CONNECTION = "Room cannot create an SQLite connection to verify the queries. Query verification will be disabled. Error: %s";
    }

    private DatabaseVerificationErrors() {
    }

    public final String cannotCreateConnection(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        return String.format(CANNOT_CREATE_SQLITE_CONNECTION, Arrays.copyOf(new Object[]{r5.getMessage()}, 1));
    }

    public final String cannotVerifyQuery(SQLException r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        return String.format(CANNOT_VERIFY_QUERY, Arrays.copyOf(new Object[]{r5.getMessage()}, 1));
    }
}
