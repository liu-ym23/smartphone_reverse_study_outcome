package com.larus.bmhome.chat.model.irepo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/model/irepo/SqlExceptionCategory;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SQL_LITE_EXCEPTION", "SQL_LITE_ABORT_EXCEPTION", "SQL_LITE_ACCESS_PERM", "SQL_LITE_BIND_OR_COLUMN_INDEX_OUT_OF_RANGE", "SQL_LITE_BLOB_TOO_BIG", "SQL_LITE_CANT_OPEN_DATABASE", "SQL_LITE_CONSTRAINT", "SQL_LITE_DATABASE_CORRUPT", "SQL_LITE_DATABASE_LOCKED", "SQL_LITE_DATA_TYPE_MISMATCH", "SQL_LITE_DISK_IO", "SQL_LITE_DONE", "SQL_LITE_FULL_EXCEPTION", "SQL_LITE_MIS_USE", "SQL_LITE_OUT_OF_MEMORY", "SQL_LITE_READ_ONLY_DATABASE", "SQL_LITE_TABLE_LOCKED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SqlExceptionCategory extends Enum<SqlExceptionCategory> {
    public static final SqlExceptionCategory SQL_LITE_ABORT_EXCEPTION = null;
    public static final SqlExceptionCategory SQL_LITE_ACCESS_PERM = null;
    public static final SqlExceptionCategory SQL_LITE_BIND_OR_COLUMN_INDEX_OUT_OF_RANGE = null;
    public static final SqlExceptionCategory SQL_LITE_BLOB_TOO_BIG = null;
    public static final SqlExceptionCategory SQL_LITE_CANT_OPEN_DATABASE = null;
    public static final SqlExceptionCategory SQL_LITE_CONSTRAINT = null;
    public static final SqlExceptionCategory SQL_LITE_DATABASE_CORRUPT = null;
    public static final SqlExceptionCategory SQL_LITE_DATABASE_LOCKED = null;
    public static final SqlExceptionCategory SQL_LITE_DATA_TYPE_MISMATCH = null;
    public static final SqlExceptionCategory SQL_LITE_DISK_IO = null;
    public static final SqlExceptionCategory SQL_LITE_DONE = null;
    public static final SqlExceptionCategory SQL_LITE_EXCEPTION = null;
    public static final SqlExceptionCategory SQL_LITE_FULL_EXCEPTION = null;
    public static final SqlExceptionCategory SQL_LITE_MIS_USE = null;
    public static final SqlExceptionCategory SQL_LITE_OUT_OF_MEMORY = null;
    public static final SqlExceptionCategory SQL_LITE_READ_ONLY_DATABASE = null;
    public static final SqlExceptionCategory SQL_LITE_TABLE_LOCKED = null;
    public static final /* synthetic */ SqlExceptionCategory[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<SqlExceptionCategory> getEntries() {
        return b;
    }

    static {
        SqlExceptionCategory r0 = new SqlExceptionCategory("SQL_LITE_EXCEPTION", 0, "sql_lite_exception");
        SQL_LITE_EXCEPTION = r0;
        SqlExceptionCategory r1 = new SqlExceptionCategory("SQL_LITE_ABORT_EXCEPTION", 1, "sql_lite_abort_exception");
        SQL_LITE_ABORT_EXCEPTION = r1;
        SqlExceptionCategory r2 = new SqlExceptionCategory("SQL_LITE_ACCESS_PERM", 2, "sql_lite_access_perm_exception");
        SQL_LITE_ACCESS_PERM = r2;
        SqlExceptionCategory r4 = new SqlExceptionCategory("SQL_LITE_BIND_OR_COLUMN_INDEX_OUT_OF_RANGE", 3, "sql_lite_bind_or_column_index_out_of_range");
        SQL_LITE_BIND_OR_COLUMN_INDEX_OUT_OF_RANGE = r4;
        SqlExceptionCategory r6 = new SqlExceptionCategory("SQL_LITE_BLOB_TOO_BIG", 4, "sql_lite_blob_too_big");
        SQL_LITE_BLOB_TOO_BIG = r6;
        SqlExceptionCategory r8 = new SqlExceptionCategory("SQL_LITE_CANT_OPEN_DATABASE", 5, "sql_lite_cant_open_database");
        SQL_LITE_CANT_OPEN_DATABASE = r8;
        SqlExceptionCategory r10 = new SqlExceptionCategory("SQL_LITE_CONSTRAINT", 6, "sql_lite_constraint");
        SQL_LITE_CONSTRAINT = r10;
        SqlExceptionCategory r12 = new SqlExceptionCategory("SQL_LITE_DATABASE_CORRUPT", 7, "sql_lite_database_corrupt");
        SQL_LITE_DATABASE_CORRUPT = r12;
        SqlExceptionCategory r14 = new SqlExceptionCategory("SQL_LITE_DATABASE_LOCKED", 8, "sql_lite_database_locked");
        SQL_LITE_DATABASE_LOCKED = r14;
        SqlExceptionCategory r13 = new SqlExceptionCategory("SQL_LITE_DATA_TYPE_MISMATCH", 9, "sql_lite_data_type_mismatch");
        SQL_LITE_DATA_TYPE_MISMATCH = r13;
        SqlExceptionCategory r11 = new SqlExceptionCategory("SQL_LITE_DISK_IO", 10, "sql_lite_disk_io");
        SQL_LITE_DISK_IO = r11;
        SqlExceptionCategory r9 = new SqlExceptionCategory("SQL_LITE_DONE", 11, "sql_lite_done");
        SQL_LITE_DONE = r9;
        SqlExceptionCategory r7 = new SqlExceptionCategory("SQL_LITE_FULL_EXCEPTION", 12, "sql_lite_full");
        SQL_LITE_FULL_EXCEPTION = r7;
        SqlExceptionCategory r5 = new SqlExceptionCategory("SQL_LITE_MIS_USE", 13, "sql_lite_mis_use");
        SQL_LITE_MIS_USE = r5;
        SqlExceptionCategory r3 = new SqlExceptionCategory("SQL_LITE_OUT_OF_MEMORY", 14, "sql_lite_out_of_memory");
        SQL_LITE_OUT_OF_MEMORY = r3;
        SqlExceptionCategory r15 = new SqlExceptionCategory("SQL_LITE_READ_ONLY_DATABASE", 15, "sql_lite_read_only_database");
        SQL_LITE_READ_ONLY_DATABASE = r15;
        SqlExceptionCategory r16 = new SqlExceptionCategory("SQL_LITE_TABLE_LOCKED", 16, "sql_lite_table_locked");
        SQL_LITE_TABLE_LOCKED = r16;
        SqlExceptionCategory[] r17 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
    }

    public static SqlExceptionCategory[] values() {
        return (SqlExceptionCategory[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SqlExceptionCategory valueOf(String r1) {
        return (SqlExceptionCategory) a.a(SqlExceptionCategory.class, r1);
    }

    public SqlExceptionCategory(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
