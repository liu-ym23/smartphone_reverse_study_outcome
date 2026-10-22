package androidx.room.ext;

import ai.j0;
import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b9\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\bR\u0017\u0010\u001d\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\bR\u0017\u0010\u001f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\bR\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\bR\u0017\u0010#\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\bR\u0017\u0010%\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\bR\u0017\u0010'\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\bR\u0017\u0010)\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010\bR\u0017\u0010+\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010\bR\u0017\u0010-\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\bR\u0017\u0010/\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b/\u0010\u0006\u001a\u0004\b0\u0010\bR\u0017\u00101\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u0010\bR\u0017\u00103\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b3\u0010\u0006\u001a\u0004\b4\u0010\bR\u0017\u00105\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b5\u0010\u0006\u001a\u0004\b6\u0010\bR\u0017\u00107\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\bR\u0017\u00109\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b9\u0010\u0006\u001a\u0004\b:\u0010\bR\u0017\u0010;\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b;\u0010\u0006\u001a\u0004\b<\u0010\b¨\u0006="}, d2 = {"Landroidx/room/ext/RoomTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "STRING_UTIL", "Lcom/squareup/javapoet/e;", "getSTRING_UTIL", "()Lcom/squareup/javapoet/e;", "ROOM_DB", "getROOM_DB", "ROOM_DB_KT", "getROOM_DB_KT", "ROOM_DB_CONFIG", "getROOM_DB_CONFIG", "INSERTION_ADAPTER", "getINSERTION_ADAPTER", "UPSERTION_ADAPTER", "getUPSERTION_ADAPTER", "DELETE_OR_UPDATE_ADAPTER", "getDELETE_OR_UPDATE_ADAPTER", "SHARED_SQLITE_STMT", "getSHARED_SQLITE_STMT", "INVALIDATION_TRACKER", "getINVALIDATION_TRACKER", "INVALIDATION_OBSERVER", "getINVALIDATION_OBSERVER", "ROOM_SQL_QUERY", "getROOM_SQL_QUERY", "OPEN_HELPER", "getOPEN_HELPER", "OPEN_HELPER_DELEGATE", "getOPEN_HELPER_DELEGATE", "OPEN_HELPER_VALIDATION_RESULT", "getOPEN_HELPER_VALIDATION_RESULT", "TABLE_INFO", "getTABLE_INFO", "TABLE_INFO_COLUMN", "getTABLE_INFO_COLUMN", "TABLE_INFO_FOREIGN_KEY", "getTABLE_INFO_FOREIGN_KEY", "TABLE_INFO_INDEX", "getTABLE_INFO_INDEX", "FTS_TABLE_INFO", "getFTS_TABLE_INFO", "VIEW_INFO", "getVIEW_INFO", "LIMIT_OFFSET_DATA_SOURCE", "getLIMIT_OFFSET_DATA_SOURCE", "DB_UTIL", "getDB_UTIL", "CURSOR_UTIL", "getCURSOR_UTIL", "MIGRATION", "getMIGRATION", "AUTO_MIGRATION_SPEC", "getAUTO_MIGRATION_SPEC", "UUID_UTIL", "getUUID_UTIL", "AMBIGUOUS_COLUMN_RESOLVER", "getAMBIGUOUS_COLUMN_RESOLVER", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoomTypeNames {
    private static final e AMBIGUOUS_COLUMN_RESOLVER = null;
    private static final e AUTO_MIGRATION_SPEC = null;
    private static final e CURSOR_UTIL = null;
    private static final e DB_UTIL = null;
    private static final e DELETE_OR_UPDATE_ADAPTER = null;
    private static final e FTS_TABLE_INFO = null;
    private static final e INSERTION_ADAPTER = null;
    public static final RoomTypeNames INSTANCE = null;
    private static final e INVALIDATION_OBSERVER = null;
    private static final e INVALIDATION_TRACKER = null;
    private static final e LIMIT_OFFSET_DATA_SOURCE = null;
    private static final e MIGRATION = null;
    private static final e OPEN_HELPER = null;
    private static final e OPEN_HELPER_DELEGATE = null;
    private static final e OPEN_HELPER_VALIDATION_RESULT = null;
    private static final e ROOM_DB = null;
    private static final e ROOM_DB_CONFIG = null;
    private static final e ROOM_DB_KT = null;
    private static final e ROOM_SQL_QUERY = null;
    private static final e SHARED_SQLITE_STMT = null;
    private static final e STRING_UTIL = null;
    private static final e TABLE_INFO = null;
    private static final e TABLE_INFO_COLUMN = null;
    private static final e TABLE_INFO_FOREIGN_KEY = null;
    private static final e TABLE_INFO_INDEX = null;
    private static final e UPSERTION_ADAPTER = null;
    private static final e UUID_UTIL = null;
    private static final e VIEW_INFO = null;

    static {
        INSTANCE = new RoomTypeNames();
        STRING_UTIL = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "StringUtil", new String[0]);
        ROOM_DB = e.o(Package_extKt.getROOM_PACKAGE(), "RoomDatabase", new String[0]);
        ROOM_DB_KT = e.o(Package_extKt.getROOM_PACKAGE(), "RoomDatabaseKt", new String[0]);
        ROOM_DB_CONFIG = e.o(Package_extKt.getROOM_PACKAGE(), "DatabaseConfiguration", new String[0]);
        INSERTION_ADAPTER = e.o(Package_extKt.getROOM_PACKAGE(), "EntityInsertionAdapter", new String[0]);
        UPSERTION_ADAPTER = e.o(Package_extKt.getROOM_PACKAGE(), "EntityUpsertionAdapter", new String[0]);
        DELETE_OR_UPDATE_ADAPTER = e.o(Package_extKt.getROOM_PACKAGE(), "EntityDeletionOrUpdateAdapter", new String[0]);
        SHARED_SQLITE_STMT = e.o(Package_extKt.getROOM_PACKAGE(), "SharedSQLiteStatement", new String[0]);
        INVALIDATION_TRACKER = e.o(Package_extKt.getROOM_PACKAGE(), "InvalidationTracker", new String[0]);
        INVALIDATION_OBSERVER = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".InvalidationTracker"), "Observer", new String[0]);
        ROOM_SQL_QUERY = e.o(Package_extKt.getROOM_PACKAGE(), "RoomSQLiteQuery", new String[0]);
        OPEN_HELPER = e.o(Package_extKt.getROOM_PACKAGE(), "RoomOpenHelper", new String[0]);
        OPEN_HELPER_DELEGATE = e.o(Package_extKt.getROOM_PACKAGE(), "RoomOpenHelper.Delegate", new String[0]);
        OPEN_HELPER_VALIDATION_RESULT = e.o(Package_extKt.getROOM_PACKAGE(), "RoomOpenHelper.ValidationResult", new String[0]);
        TABLE_INFO = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "TableInfo", new String[0]);
        TABLE_INFO_COLUMN = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "TableInfo.Column", new String[0]);
        TABLE_INFO_FOREIGN_KEY = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "TableInfo.ForeignKey", new String[0]);
        TABLE_INFO_INDEX = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "TableInfo.Index", new String[0]);
        FTS_TABLE_INFO = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "FtsTableInfo", new String[0]);
        VIEW_INFO = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "ViewInfo", new String[0]);
        LIMIT_OFFSET_DATA_SOURCE = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".paging"), "LimitOffsetDataSource", new String[0]);
        DB_UTIL = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "DBUtil", new String[0]);
        CURSOR_UTIL = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "CursorUtil", new String[0]);
        MIGRATION = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".migration"), "Migration", new String[0]);
        AUTO_MIGRATION_SPEC = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".migration"), "AutoMigrationSpec", new String[0]);
        UUID_UTIL = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".util"), "UUIDUtil", new String[0]);
        AMBIGUOUS_COLUMN_RESOLVER = e.o(Package_extKt.getROOM_PACKAGE(), "AmbiguousColumnResolver", new String[0]);
    }

    private RoomTypeNames() {
    }

    public final e getAMBIGUOUS_COLUMN_RESOLVER() {
        return AMBIGUOUS_COLUMN_RESOLVER;
    }

    public final e getAUTO_MIGRATION_SPEC() {
        return AUTO_MIGRATION_SPEC;
    }

    public final e getCURSOR_UTIL() {
        return CURSOR_UTIL;
    }

    public final e getDB_UTIL() {
        return DB_UTIL;
    }

    public final e getDELETE_OR_UPDATE_ADAPTER() {
        return DELETE_OR_UPDATE_ADAPTER;
    }

    public final e getFTS_TABLE_INFO() {
        return FTS_TABLE_INFO;
    }

    public final e getINSERTION_ADAPTER() {
        return INSERTION_ADAPTER;
    }

    public final e getINVALIDATION_OBSERVER() {
        return INVALIDATION_OBSERVER;
    }

    public final e getINVALIDATION_TRACKER() {
        return INVALIDATION_TRACKER;
    }

    public final e getLIMIT_OFFSET_DATA_SOURCE() {
        return LIMIT_OFFSET_DATA_SOURCE;
    }

    public final e getMIGRATION() {
        return MIGRATION;
    }

    public final e getOPEN_HELPER() {
        return OPEN_HELPER;
    }

    public final e getOPEN_HELPER_DELEGATE() {
        return OPEN_HELPER_DELEGATE;
    }

    public final e getOPEN_HELPER_VALIDATION_RESULT() {
        return OPEN_HELPER_VALIDATION_RESULT;
    }

    public final e getROOM_DB() {
        return ROOM_DB;
    }

    public final e getROOM_DB_CONFIG() {
        return ROOM_DB_CONFIG;
    }

    public final e getROOM_DB_KT() {
        return ROOM_DB_KT;
    }

    public final e getROOM_SQL_QUERY() {
        return ROOM_SQL_QUERY;
    }

    public final e getSHARED_SQLITE_STMT() {
        return SHARED_SQLITE_STMT;
    }

    public final e getSTRING_UTIL() {
        return STRING_UTIL;
    }

    public final e getTABLE_INFO() {
        return TABLE_INFO;
    }

    public final e getTABLE_INFO_COLUMN() {
        return TABLE_INFO_COLUMN;
    }

    public final e getTABLE_INFO_FOREIGN_KEY() {
        return TABLE_INFO_FOREIGN_KEY;
    }

    public final e getTABLE_INFO_INDEX() {
        return TABLE_INFO_INDEX;
    }

    public final e getUPSERTION_ADAPTER() {
        return UPSERTION_ADAPTER;
    }

    public final e getUUID_UTIL() {
        return UUID_UTIL;
    }

    public final e getVIEW_INFO() {
        return VIEW_INFO;
    }
}
