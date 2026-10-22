package org.sqlite;

import av.f;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$Pragma extends Enum<SQLiteConfig$Pragma> {
    public static final SQLiteConfig$Pragma APPLICATION_ID = null;
    public static final SQLiteConfig$Pragma BUSY_TIMEOUT = null;
    public static final SQLiteConfig$Pragma CACHE_SIZE = null;
    public static final SQLiteConfig$Pragma CASE_SENSITIVE_LIKE = null;
    public static final SQLiteConfig$Pragma COUNT_CHANGES = null;
    public static final SQLiteConfig$Pragma DATE_CLASS = null;
    public static final SQLiteConfig$Pragma DATE_PRECISION = null;
    public static final SQLiteConfig$Pragma DATE_STRING_FORMAT = null;
    public static final SQLiteConfig$Pragma DEFAULT_CACHE_SIZE = null;
    public static final SQLiteConfig$Pragma DEFER_FOREIGN_KEYS = null;
    public static final SQLiteConfig$Pragma EMPTY_RESULT_CALLBACKS = null;
    public static final SQLiteConfig$Pragma ENCODING = null;
    public static final SQLiteConfig$Pragma FOREIGN_KEYS = null;
    public static final SQLiteConfig$Pragma FULL_COLUMN_NAMES = null;
    public static final SQLiteConfig$Pragma FULL_SYNC = null;
    public static final SQLiteConfig$Pragma HEXKEY_MODE = null;
    public static final SQLiteConfig$Pragma INCREMENTAL_VACUUM = null;
    public static final SQLiteConfig$Pragma JOURNAL_MODE = null;
    public static final SQLiteConfig$Pragma JOURNAL_SIZE_LIMIT = null;
    public static final SQLiteConfig$Pragma LEGACY_FILE_FORMAT = null;
    public static final SQLiteConfig$Pragma LIMIT_ATTACHED = null;
    public static final SQLiteConfig$Pragma LIMIT_COLUMN = null;
    public static final SQLiteConfig$Pragma LIMIT_COMPOUND_SELECT = null;
    public static final SQLiteConfig$Pragma LIMIT_EXPR_DEPTH = null;
    public static final SQLiteConfig$Pragma LIMIT_FUNCTION_ARG = null;
    public static final SQLiteConfig$Pragma LIMIT_LENGTH = null;
    public static final SQLiteConfig$Pragma LIMIT_LIKE_PATTERN_LENGTH = null;
    public static final SQLiteConfig$Pragma LIMIT_PAGE_COUNT = null;
    public static final SQLiteConfig$Pragma LIMIT_SQL_LENGTH = null;
    public static final SQLiteConfig$Pragma LIMIT_TRIGGER_DEPTH = null;
    public static final SQLiteConfig$Pragma LIMIT_VARIABLE_NUMBER = null;
    public static final SQLiteConfig$Pragma LIMIT_VDBE_OP = null;
    public static final SQLiteConfig$Pragma LIMIT_WORKER_THREADS = null;
    public static final SQLiteConfig$Pragma LOAD_EXTENSION = null;
    public static final SQLiteConfig$Pragma LOCKING_MODE = null;
    public static final SQLiteConfig$Pragma MAX_PAGE_COUNT = null;
    public static final SQLiteConfig$Pragma MMAP_SIZE = null;
    public static final SQLiteConfig$Pragma OPEN_MODE = null;
    public static final SQLiteConfig$Pragma PAGE_SIZE = null;
    public static final SQLiteConfig$Pragma PASSWORD = null;
    public static final SQLiteConfig$Pragma READ_UNCOMMITTED = null;
    public static final SQLiteConfig$Pragma RECURSIVE_TRIGGERS = null;
    public static final SQLiteConfig$Pragma REVERSE_UNORDERED_SELECTS = null;
    public static final SQLiteConfig$Pragma SECURE_DELETE = null;
    public static final SQLiteConfig$Pragma SHARED_CACHE = null;
    public static final SQLiteConfig$Pragma SHORT_COLUMN_NAMES = null;
    public static final SQLiteConfig$Pragma SYNCHRONOUS = null;
    public static final SQLiteConfig$Pragma TEMP_STORE = null;
    public static final SQLiteConfig$Pragma TEMP_STORE_DIRECTORY = null;
    public static final SQLiteConfig$Pragma TRANSACTION_MODE = null;
    public static final SQLiteConfig$Pragma USER_VERSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$Pragma[] f21047a = null;
    public final String[] choices;
    public final String description;
    public final String pragmaName;

    static {
        SQLiteConfig$Pragma r10 = new SQLiteConfig$Pragma("OPEN_MODE", 0, "open_mode", "Database open-mode flag", null);
        OPEN_MODE = r10;
        String[] r5 = f.e;
        SQLiteConfig$Pragma r11 = new SQLiteConfig$Pragma("SHARED_CACHE", 1, "shared_cache", "Enable SQLite Shared-Cache mode, native driver only", r5);
        SHARED_CACHE = r11;
        SQLiteConfig$Pragma r12 = new SQLiteConfig$Pragma("LOAD_EXTENSION", 2, "enable_load_extension", "Enable SQLite load_extention() function, native driver only", r5);
        LOAD_EXTENSION = r12;
        SQLiteConfig$Pragma r13 = new SQLiteConfig$Pragma("CACHE_SIZE", 3, "cache_size");
        CACHE_SIZE = r13;
        SQLiteConfig$Pragma r14 = new SQLiteConfig$Pragma("MMAP_SIZE", 4, "mmap_size");
        MMAP_SIZE = r14;
        SQLiteConfig$Pragma r15 = new SQLiteConfig$Pragma("CASE_SENSITIVE_LIKE", 5, "case_sensitive_like", null, r5);
        CASE_SENSITIVE_LIKE = r15;
        SQLiteConfig$Pragma r16 = new SQLiteConfig$Pragma("COUNT_CHANGES", 6, "count_changes", null, r5);
        COUNT_CHANGES = r16;
        SQLiteConfig$Pragma r17 = new SQLiteConfig$Pragma("DEFAULT_CACHE_SIZE", 7, "default_cache_size");
        DEFAULT_CACHE_SIZE = r17;
        SQLiteConfig$Pragma r18 = new SQLiteConfig$Pragma("DEFER_FOREIGN_KEYS", 8, "defer_foreign_keys", null, r5);
        DEFER_FOREIGN_KEYS = r18;
        SQLiteConfig$Pragma r19 = new SQLiteConfig$Pragma("EMPTY_RESULT_CALLBACKS", 9, "empty_result_callback", null, r5);
        EMPTY_RESULT_CALLBACKS = r19;
        SQLiteConfig$Pragma r23 = new SQLiteConfig$Pragma("ENCODING", 10, "encoding", null, f.a(SQLiteConfig$Encoding.values()));
        ENCODING = r23;
        SQLiteConfig$Pragma r110 = new SQLiteConfig$Pragma("FOREIGN_KEYS", 11, "foreign_keys", null, r5);
        FOREIGN_KEYS = r110;
        SQLiteConfig$Pragma r111 = new SQLiteConfig$Pragma("FULL_COLUMN_NAMES", 12, "full_column_names", null, r5);
        FULL_COLUMN_NAMES = r111;
        SQLiteConfig$Pragma r112 = new SQLiteConfig$Pragma("FULL_SYNC", 13, "fullsync", null, r5);
        FULL_SYNC = r112;
        SQLiteConfig$Pragma r113 = new SQLiteConfig$Pragma("INCREMENTAL_VACUUM", 14, "incremental_vacuum");
        INCREMENTAL_VACUUM = r113;
        SQLiteConfig$Pragma r20 = new SQLiteConfig$Pragma("JOURNAL_MODE", 15, "journal_mode", null, f.a(SQLiteConfig$JournalMode.values()));
        JOURNAL_MODE = r20;
        SQLiteConfig$Pragma r114 = new SQLiteConfig$Pragma("JOURNAL_SIZE_LIMIT", 16, "journal_size_limit");
        JOURNAL_SIZE_LIMIT = r114;
        SQLiteConfig$Pragma r21 = new SQLiteConfig$Pragma("LEGACY_FILE_FORMAT", 17, "legacy_file_format", null, r5);
        LEGACY_FILE_FORMAT = r21;
        SQLiteConfig$Pragma r31 = new SQLiteConfig$Pragma("LOCKING_MODE", 18, "locking_mode", null, f.a(SQLiteConfig$LockingMode.values()));
        LOCKING_MODE = r31;
        SQLiteConfig$Pragma r115 = new SQLiteConfig$Pragma("PAGE_SIZE", 19, "page_size");
        PAGE_SIZE = r115;
        SQLiteConfig$Pragma r116 = new SQLiteConfig$Pragma("MAX_PAGE_COUNT", 20, "max_page_count");
        MAX_PAGE_COUNT = r116;
        SQLiteConfig$Pragma r25 = new SQLiteConfig$Pragma("READ_UNCOMMITTED", 21, "read_uncommitted", null, r5);
        READ_UNCOMMITTED = r25;
        SQLiteConfig$Pragma r28 = new SQLiteConfig$Pragma("RECURSIVE_TRIGGERS", 22, "recursive_triggers", null, r5);
        RECURSIVE_TRIGGERS = r28;
        SQLiteConfig$Pragma r29 = new SQLiteConfig$Pragma("REVERSE_UNORDERED_SELECTS", 23, "reverse_unordered_selects", null, r5);
        REVERSE_UNORDERED_SELECTS = r29;
        SQLiteConfig$Pragma r30 = new SQLiteConfig$Pragma("SECURE_DELETE", 24, "secure_delete", null, new String[]{"true", "false", "fast"});
        SECURE_DELETE = r30;
        SQLiteConfig$Pragma r32 = new SQLiteConfig$Pragma("SHORT_COLUMN_NAMES", 25, "short_column_names", null, r5);
        SHORT_COLUMN_NAMES = r32;
        SQLiteConfig$Pragma r39 = new SQLiteConfig$Pragma("SYNCHRONOUS", 26, "synchronous", null, f.a(SQLiteConfig$SynchronousMode.values()));
        SYNCHRONOUS = r39;
        SQLiteConfig$Pragma r33 = new SQLiteConfig$Pragma("TEMP_STORE", 27, "temp_store", null, f.a(SQLiteConfig$TempStore.values()));
        TEMP_STORE = r33;
        SQLiteConfig$Pragma r117 = new SQLiteConfig$Pragma("TEMP_STORE_DIRECTORY", 28, "temp_store_directory");
        TEMP_STORE_DIRECTORY = r117;
        SQLiteConfig$Pragma r118 = new SQLiteConfig$Pragma("USER_VERSION", 29, "user_version");
        USER_VERSION = r118;
        SQLiteConfig$Pragma r119 = new SQLiteConfig$Pragma("APPLICATION_ID", 30, "application_id");
        APPLICATION_ID = r119;
        SQLiteConfig$Pragma r34 = new SQLiteConfig$Pragma("LIMIT_LENGTH", 31, "limit_length", "The maximum size of any string or BLOB or table row, in bytes.", null);
        LIMIT_LENGTH = r34;
        SQLiteConfig$Pragma r35 = new SQLiteConfig$Pragma("LIMIT_SQL_LENGTH", 32, "limit_sql_length", "The maximum length of an SQL statement, in bytes.", null);
        LIMIT_SQL_LENGTH = r35;
        SQLiteConfig$Pragma r36 = new SQLiteConfig$Pragma("LIMIT_COLUMN", 33, "limit_column", "The maximum number of columns in a table definition or in the result set of a SELECT or the maximum number of columns in an index or in an ORDER BY or GROUP BY clause.", null);
        LIMIT_COLUMN = r36;
        SQLiteConfig$Pragma r37 = new SQLiteConfig$Pragma("LIMIT_EXPR_DEPTH", 34, "limit_expr_depth", "The maximum depth of the parse tree on any expression.", null);
        LIMIT_EXPR_DEPTH = r37;
        SQLiteConfig$Pragma r38 = new SQLiteConfig$Pragma("LIMIT_COMPOUND_SELECT", 35, "limit_compound_select", "The maximum number of terms in a compound SELECT statement.", null);
        LIMIT_COMPOUND_SELECT = r38;
        SQLiteConfig$Pragma r40 = new SQLiteConfig$Pragma("LIMIT_VDBE_OP", 36, "limit_vdbe_op", "The maximum number of instructions in a virtual machine program used to implement an SQL statement. If sqlite3_prepare_v2() or the equivalent tries to allocate space for more than this many opcodes in a single prepared statement, an SQLITE_NOMEM error is returned.", null);
        LIMIT_VDBE_OP = r40;
        SQLiteConfig$Pragma r47 = new SQLiteConfig$Pragma("LIMIT_FUNCTION_ARG", 37, "limit_function_arg", "The maximum number of arguments on a function.", null);
        LIMIT_FUNCTION_ARG = r47;
        SQLiteConfig$Pragma r41 = new SQLiteConfig$Pragma("LIMIT_ATTACHED", 38, "limit_attached", "The maximum number of attached databases.", null);
        LIMIT_ATTACHED = r41;
        SQLiteConfig$Pragma r42 = new SQLiteConfig$Pragma("LIMIT_LIKE_PATTERN_LENGTH", 39, "limit_like_pattern_length", "The maximum length of the pattern argument to the LIKE or GLOB operators.", null);
        LIMIT_LIKE_PATTERN_LENGTH = r42;
        SQLiteConfig$Pragma r43 = new SQLiteConfig$Pragma("LIMIT_VARIABLE_NUMBER", 40, "limit_variable_number", "The maximum index number of any parameter in an SQL statement.", null);
        LIMIT_VARIABLE_NUMBER = r43;
        SQLiteConfig$Pragma r44 = new SQLiteConfig$Pragma("LIMIT_TRIGGER_DEPTH", 41, "limit_trigger_depth", "The maximum depth of recursion for triggers.", null);
        LIMIT_TRIGGER_DEPTH = r44;
        SQLiteConfig$Pragma r45 = new SQLiteConfig$Pragma("LIMIT_WORKER_THREADS", 42, "limit_worker_threads", "The maximum number of auxiliary worker threads that a single prepared statement may start.", null);
        LIMIT_WORKER_THREADS = r45;
        SQLiteConfig$Pragma r46 = new SQLiteConfig$Pragma("LIMIT_PAGE_COUNT", 43, "limit_page_count", "The maximum number of pages allowed in a single database file.", null);
        LIMIT_PAGE_COUNT = r46;
        SQLiteConfig$Pragma r54 = new SQLiteConfig$Pragma("TRANSACTION_MODE", 44, "transaction_mode", null, f.a(SQLiteConfig$TransactionMode.values()));
        TRANSACTION_MODE = r54;
        SQLiteConfig$Pragma r48 = new SQLiteConfig$Pragma("DATE_PRECISION", 45, "date_precision", "\"seconds\": Read and store integer dates as seconds from the Unix Epoch (SQLite standard).\n\"milliseconds\": (DEFAULT) Read and store integer dates as milliseconds from the Unix Epoch (Java standard).", f.a(SQLiteConfig$DatePrecision.values()));
        DATE_PRECISION = r48;
        SQLiteConfig$Pragma r49 = new SQLiteConfig$Pragma("DATE_CLASS", 46, "date_class", "\"integer\": (Default) store dates as number of seconds or milliseconds from the Unix Epoch\n\"text\": store dates as a string of text\n\"real\": store dates as Julian Dates", f.a(SQLiteConfig$DateClass.values()));
        DATE_CLASS = r49;
        SQLiteConfig$Pragma r50 = new SQLiteConfig$Pragma("DATE_STRING_FORMAT", 47, "date_string_format", "Format to store and retrieve dates stored as text. Defaults to \"yyyy-MM-dd HH:mm:ss.SSS\"", null);
        DATE_STRING_FORMAT = r50;
        SQLiteConfig$Pragma r51 = new SQLiteConfig$Pragma("BUSY_TIMEOUT", 48, "busy_timeout", null, null);
        BUSY_TIMEOUT = r51;
        SQLiteConfig$Pragma r52 = new SQLiteConfig$Pragma("HEXKEY_MODE", 49, "hexkey_mode", null, f.a(SQLiteConfig$HexKeyMode.values()));
        HEXKEY_MODE = r52;
        SQLiteConfig$Pragma r53 = new SQLiteConfig$Pragma("PASSWORD", 50, "password", null, null);
        PASSWORD = r53;
        f21047a = new SQLiteConfig$Pragma[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r23, r110, r111, r112, r113, r20, r114, r21, r31, r115, r116, r25, r28, r29, r30, r32, r39, r33, r117, r118, r119, r34, r35, r36, r37, r38, r40, r47, r41, r42, r43, r44, r45, r46, r54, r48, r49, r50, r51, r52, r53};
    }

    public SQLiteConfig$Pragma(String r10, int r11, String r12) {
        this(r10, r11, r12, null, null);
    }

    public static SQLiteConfig$Pragma valueOf(String r5) {
        return (SQLiteConfig$Pragma) Enum.valueOf(SQLiteConfig$Pragma.class, r5);
    }

    public static SQLiteConfig$Pragma[] values() {
        return (SQLiteConfig$Pragma[]) f21047a.clone();
    }

    public final String getPragmaName() {
        return this.pragmaName;
    }

    public SQLiteConfig$Pragma(String r5, int r10, String r11, String r12, String[] r13) {
        super(r5, r10);
        this.pragmaName = r11;
        this.description = r12;
        this.choices = r13;
    }
}
