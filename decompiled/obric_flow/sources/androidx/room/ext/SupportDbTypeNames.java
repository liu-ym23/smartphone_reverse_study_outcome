package androidx.room.ext;

import ai.j0;
import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/room/ext/SupportDbTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "DB", "Lcom/squareup/javapoet/e;", "getDB", "()Lcom/squareup/javapoet/e;", "SQLITE_STMT", "getSQLITE_STMT", "SQLITE_OPEN_HELPER", "getSQLITE_OPEN_HELPER", "SQLITE_OPEN_HELPER_CALLBACK", "getSQLITE_OPEN_HELPER_CALLBACK", "SQLITE_OPEN_HELPER_CONFIG", "getSQLITE_OPEN_HELPER_CONFIG", "QUERY", "getQUERY", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SupportDbTypeNames {
    private static final e DB = null;
    public static final SupportDbTypeNames INSTANCE = null;
    private static final e QUERY = null;
    private static final e SQLITE_OPEN_HELPER = null;
    private static final e SQLITE_OPEN_HELPER_CALLBACK = null;
    private static final e SQLITE_OPEN_HELPER_CONFIG = null;
    private static final e SQLITE_STMT = null;

    static {
        INSTANCE = new SupportDbTypeNames();
        DB = e.o(j0.j(Package_extKt.getSQLITE_PACKAGE(), ".db"), "SupportSQLiteDatabase", new String[0]);
        SQLITE_STMT = e.o(j0.j(Package_extKt.getSQLITE_PACKAGE(), ".db"), "SupportSQLiteStatement", new String[0]);
        SQLITE_OPEN_HELPER = e.o(j0.j(Package_extKt.getSQLITE_PACKAGE(), ".db"), "SupportSQLiteOpenHelper", new String[0]);
        SQLITE_OPEN_HELPER_CALLBACK = e.o(j0.j(Package_extKt.getSQLITE_PACKAGE(), ".db"), "SupportSQLiteOpenHelper.Callback", new String[0]);
        SQLITE_OPEN_HELPER_CONFIG = e.o(j0.j(Package_extKt.getSQLITE_PACKAGE(), ".db"), "SupportSQLiteOpenHelper.Configuration", new String[0]);
        QUERY = e.o(j0.j(Package_extKt.getSQLITE_PACKAGE(), ".db"), "SupportSQLiteQuery", new String[0]);
    }

    private SupportDbTypeNames() {
    }

    public final e getDB() {
        return DB;
    }

    public final e getQUERY() {
        return QUERY;
    }

    public final e getSQLITE_OPEN_HELPER() {
        return SQLITE_OPEN_HELPER;
    }

    public final e getSQLITE_OPEN_HELPER_CALLBACK() {
        return SQLITE_OPEN_HELPER_CALLBACK;
    }

    public final e getSQLITE_OPEN_HELPER_CONFIG() {
        return SQLITE_OPEN_HELPER_CONFIG;
    }

    public final e getSQLITE_STMT() {
        return SQLITE_STMT;
    }
}
