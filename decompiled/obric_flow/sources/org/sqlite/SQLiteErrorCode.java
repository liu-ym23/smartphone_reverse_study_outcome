package org.sqlite;

import androidx.constraintlayout.motion.widget.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteErrorCode extends Enum<SQLiteErrorCode> {
    public static final SQLiteErrorCode SQLITE_ABORT = null;
    public static final SQLiteErrorCode SQLITE_ABORT_ROLLBACK = null;
    public static final SQLiteErrorCode SQLITE_AUTH = null;
    public static final SQLiteErrorCode SQLITE_BUSY = null;
    public static final SQLiteErrorCode SQLITE_BUSY_RECOVERY = null;
    public static final SQLiteErrorCode SQLITE_BUSY_SNAPSHOT = null;
    public static final SQLiteErrorCode SQLITE_CANTOPEN = null;
    public static final SQLiteErrorCode SQLITE_CANTOPEN_CONVPATH = null;
    public static final SQLiteErrorCode SQLITE_CANTOPEN_FULLPATH = null;
    public static final SQLiteErrorCode SQLITE_CANTOPEN_ISDIR = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_CHECK = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_COMMITHOOK = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_FOREIGNKEY = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_FUNCTION = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_NOTNULL = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_PRIMARYKEY = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_ROWID = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_TRIGGER = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_UNIQUE = null;
    public static final SQLiteErrorCode SQLITE_CONSTRAINT_VTAB = null;
    public static final SQLiteErrorCode SQLITE_CORRUPT = null;
    public static final SQLiteErrorCode SQLITE_CORRUPT_VTAB = null;
    public static final SQLiteErrorCode SQLITE_DONE = null;
    public static final SQLiteErrorCode SQLITE_EMPTY = null;
    public static final SQLiteErrorCode SQLITE_ERROR = null;
    public static final SQLiteErrorCode SQLITE_FORMAT = null;
    public static final SQLiteErrorCode SQLITE_FULL = null;
    public static final SQLiteErrorCode SQLITE_INTERNAL = null;
    public static final SQLiteErrorCode SQLITE_INTERRUPT = null;
    public static final SQLiteErrorCode SQLITE_IOERR = null;
    public static final SQLiteErrorCode SQLITE_IOERR_ACCESS = null;
    public static final SQLiteErrorCode SQLITE_IOERR_CHECKRESERVEDLOCK = null;
    public static final SQLiteErrorCode SQLITE_IOERR_CLOSE = null;
    public static final SQLiteErrorCode SQLITE_IOERR_CONVPATH = null;
    public static final SQLiteErrorCode SQLITE_IOERR_DELETE = null;
    public static final SQLiteErrorCode SQLITE_IOERR_DELETE_NOENT = null;
    public static final SQLiteErrorCode SQLITE_IOERR_DIR_FSYNC = null;
    public static final SQLiteErrorCode SQLITE_IOERR_FSTAT = null;
    public static final SQLiteErrorCode SQLITE_IOERR_FSYNC = null;
    public static final SQLiteErrorCode SQLITE_IOERR_GETTEMPPATH = null;
    public static final SQLiteErrorCode SQLITE_IOERR_LOCK = null;
    public static final SQLiteErrorCode SQLITE_IOERR_MMAP = null;
    public static final SQLiteErrorCode SQLITE_IOERR_NOMEM = null;
    public static final SQLiteErrorCode SQLITE_IOERR_RDLOCK = null;
    public static final SQLiteErrorCode SQLITE_IOERR_READ = null;
    public static final SQLiteErrorCode SQLITE_IOERR_SEEK = null;
    public static final SQLiteErrorCode SQLITE_IOERR_SHMMAP = null;
    public static final SQLiteErrorCode SQLITE_IOERR_SHMOPEN = null;
    public static final SQLiteErrorCode SQLITE_IOERR_SHMSIZE = null;
    public static final SQLiteErrorCode SQLITE_IOERR_SHORT_READ = null;
    public static final SQLiteErrorCode SQLITE_IOERR_TRUNCATE = null;
    public static final SQLiteErrorCode SQLITE_IOERR_UNLOCK = null;
    public static final SQLiteErrorCode SQLITE_IOERR_WRITE = null;
    public static final SQLiteErrorCode SQLITE_LOCKED = null;
    public static final SQLiteErrorCode SQLITE_LOCKED_SHAREDCACHE = null;
    public static final SQLiteErrorCode SQLITE_MISMATCH = null;
    public static final SQLiteErrorCode SQLITE_MISUSE = null;
    public static final SQLiteErrorCode SQLITE_NOLFS = null;
    public static final SQLiteErrorCode SQLITE_NOMEM = null;
    public static final SQLiteErrorCode SQLITE_NOTADB = null;
    public static final SQLiteErrorCode SQLITE_NOTFOUND = null;
    public static final SQLiteErrorCode SQLITE_OK = null;
    public static final SQLiteErrorCode SQLITE_PERM = null;
    public static final SQLiteErrorCode SQLITE_PROTOCOL = null;
    public static final SQLiteErrorCode SQLITE_RANGE = null;
    public static final SQLiteErrorCode SQLITE_READONLY = null;
    public static final SQLiteErrorCode SQLITE_READONLY_CANTLOCK = null;
    public static final SQLiteErrorCode SQLITE_READONLY_DBMOVED = null;
    public static final SQLiteErrorCode SQLITE_READONLY_RECOVERY = null;
    public static final SQLiteErrorCode SQLITE_READONLY_ROLLBACK = null;
    public static final SQLiteErrorCode SQLITE_ROW = null;
    public static final SQLiteErrorCode SQLITE_SCHEMA = null;
    public static final SQLiteErrorCode SQLITE_TOOBIG = null;
    public static final SQLiteErrorCode UNKNOWN_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteErrorCode[] f21051a = null;
    public final int code;
    public final String message;

    static {
        SQLiteErrorCode r5 = new SQLiteErrorCode("UNKNOWN_ERROR", 0, -1, "unknown error");
        UNKNOWN_ERROR = r5;
        SQLiteErrorCode r10 = new SQLiteErrorCode("SQLITE_OK", 1, 0, "Successful result");
        SQLITE_OK = r10;
        SQLiteErrorCode r11 = new SQLiteErrorCode("SQLITE_ERROR", 2, 1, "SQL error or missing database");
        SQLITE_ERROR = r11;
        SQLiteErrorCode r12 = new SQLiteErrorCode("SQLITE_INTERNAL", 3, 2, "Internal logic error in SQLite");
        SQLITE_INTERNAL = r12;
        SQLiteErrorCode r13 = new SQLiteErrorCode("SQLITE_PERM", 4, 3, " Access permission denied");
        SQLITE_PERM = r13;
        SQLiteErrorCode r14 = new SQLiteErrorCode("SQLITE_ABORT", 5, 4, " Callback routine requested an abort");
        SQLITE_ABORT = r14;
        SQLiteErrorCode r15 = new SQLiteErrorCode("SQLITE_BUSY", 6, 5, " The database file is locked");
        SQLITE_BUSY = r15;
        SQLiteErrorCode r16 = new SQLiteErrorCode("SQLITE_LOCKED", 7, 6, " A table in the database is locked");
        SQLITE_LOCKED = r16;
        SQLiteErrorCode r17 = new SQLiteErrorCode("SQLITE_NOMEM", 8, 7, " A malloc() failed");
        SQLITE_NOMEM = r17;
        SQLiteErrorCode r18 = new SQLiteErrorCode("SQLITE_READONLY", 9, 8, " Attempt to write a readonly database");
        SQLITE_READONLY = r18;
        SQLiteErrorCode r19 = new SQLiteErrorCode("SQLITE_INTERRUPT", 10, 9, " Operation terminated by sqlite3_interrupt()");
        SQLITE_INTERRUPT = r19;
        SQLiteErrorCode r110 = new SQLiteErrorCode("SQLITE_IOERR", 11, 10, " Some kind of disk I/O error occurred");
        SQLITE_IOERR = r110;
        SQLiteErrorCode r111 = new SQLiteErrorCode("SQLITE_CORRUPT", 12, 11, " The database disk image is malformed");
        SQLITE_CORRUPT = r111;
        SQLiteErrorCode r20 = new SQLiteErrorCode("SQLITE_NOTFOUND", 13, 12, " NOT USED. Table or record not found");
        SQLITE_NOTFOUND = r20;
        SQLiteErrorCode r21 = new SQLiteErrorCode("SQLITE_FULL", 14, 13, " Insertion failed because database is full");
        SQLITE_FULL = r21;
        SQLiteErrorCode r22 = new SQLiteErrorCode("SQLITE_CANTOPEN", 15, 14, " Unable to open the database file");
        SQLITE_CANTOPEN = r22;
        SQLiteErrorCode r23 = new SQLiteErrorCode("SQLITE_PROTOCOL", 16, 15, " NOT USED. Database lock protocol error");
        SQLITE_PROTOCOL = r23;
        SQLiteErrorCode r24 = new SQLiteErrorCode("SQLITE_EMPTY", 17, 16, " Database is empty");
        SQLITE_EMPTY = r24;
        SQLiteErrorCode r25 = new SQLiteErrorCode("SQLITE_SCHEMA", 18, 17, " The database schema changed");
        SQLITE_SCHEMA = r25;
        SQLiteErrorCode r26 = new SQLiteErrorCode("SQLITE_TOOBIG", 19, 18, " String or BLOB exceeds size limit");
        SQLITE_TOOBIG = r26;
        SQLiteErrorCode r27 = new SQLiteErrorCode("SQLITE_CONSTRAINT", 20, 19, " Abort due to constraint violation");
        SQLITE_CONSTRAINT = r27;
        SQLiteErrorCode r28 = new SQLiteErrorCode("SQLITE_MISMATCH", 21, 20, " Data type mismatch");
        SQLITE_MISMATCH = r28;
        SQLiteErrorCode r29 = new SQLiteErrorCode("SQLITE_MISUSE", 22, 21, " Library used incorrectly");
        SQLITE_MISUSE = r29;
        SQLiteErrorCode r30 = new SQLiteErrorCode("SQLITE_NOLFS", 23, 22, " Uses OS features not supported on host");
        SQLITE_NOLFS = r30;
        SQLiteErrorCode r31 = new SQLiteErrorCode("SQLITE_AUTH", 24, 23, " Authorization denied");
        SQLITE_AUTH = r31;
        SQLiteErrorCode r32 = new SQLiteErrorCode("SQLITE_FORMAT", 25, 24, " Auxiliary database format error");
        SQLITE_FORMAT = r32;
        SQLiteErrorCode r33 = new SQLiteErrorCode("SQLITE_RANGE", 26, 25, " 2nd parameter to sqlite3_bind out of range");
        SQLITE_RANGE = r33;
        SQLiteErrorCode r34 = new SQLiteErrorCode("SQLITE_NOTADB", 27, 26, " File opened that is not a database file");
        SQLITE_NOTADB = r34;
        SQLiteErrorCode r35 = new SQLiteErrorCode("SQLITE_ROW", 28, 100, " sqlite3_step() has another row ready");
        SQLITE_ROW = r35;
        SQLiteErrorCode r36 = new SQLiteErrorCode("SQLITE_DONE", 29, 101, " sqlite3_step() has finished executing");
        SQLITE_DONE = r36;
        SQLiteErrorCode r37 = new SQLiteErrorCode("SQLITE_BUSY_RECOVERY", 30, 261, " Another process is busy recovering a WAL mode database file following a crash");
        SQLITE_BUSY_RECOVERY = r37;
        SQLiteErrorCode r38 = new SQLiteErrorCode("SQLITE_LOCKED_SHAREDCACHE", 31, 262, " Contention with a different database connection that shares the cache");
        SQLITE_LOCKED_SHAREDCACHE = r38;
        SQLiteErrorCode r39 = new SQLiteErrorCode("SQLITE_READONLY_RECOVERY", 32, 264, " The database file needs to be recovered");
        SQLITE_READONLY_RECOVERY = r39;
        SQLiteErrorCode r40 = new SQLiteErrorCode("SQLITE_IOERR_READ", 33, 266, " I/O error in the VFS layer while trying to read from a file on disk");
        SQLITE_IOERR_READ = r40;
        SQLiteErrorCode r41 = new SQLiteErrorCode("SQLITE_CORRUPT_VTAB", 34, 267, " Content in the virtual table is corrupt");
        SQLITE_CORRUPT_VTAB = r41;
        SQLiteErrorCode r42 = new SQLiteErrorCode("SQLITE_CONSTRAINT_CHECK", 35, 275, " A CHECK constraint failed");
        SQLITE_CONSTRAINT_CHECK = r42;
        SQLiteErrorCode r43 = new SQLiteErrorCode("SQLITE_ABORT_ROLLBACK", 36, 516, " The transaction that was active when the SQL statement first started was rolled back");
        SQLITE_ABORT_ROLLBACK = r43;
        SQLiteErrorCode r44 = new SQLiteErrorCode("SQLITE_BUSY_SNAPSHOT", 37, 517, " Another database connection has already written to the database");
        SQLITE_BUSY_SNAPSHOT = r44;
        SQLiteErrorCode r45 = new SQLiteErrorCode("SQLITE_READONLY_CANTLOCK", 38, 520, " The shared-memory file associated with that database is read-only");
        SQLITE_READONLY_CANTLOCK = r45;
        SQLiteErrorCode r46 = new SQLiteErrorCode("SQLITE_IOERR_SHORT_READ", 39, 522, " The VFS layer was unable to obtain as many bytes as was requested");
        SQLITE_IOERR_SHORT_READ = r46;
        SQLiteErrorCode r47 = new SQLiteErrorCode("SQLITE_CANTOPEN_ISDIR", 40, 526, " The file is really a directory");
        SQLITE_CANTOPEN_ISDIR = r47;
        SQLiteErrorCode r48 = new SQLiteErrorCode("SQLITE_CONSTRAINT_COMMITHOOK", 41, 531, " A commit hook callback returned non-zero");
        SQLITE_CONSTRAINT_COMMITHOOK = r48;
        SQLiteErrorCode r49 = new SQLiteErrorCode("SQLITE_READONLY_ROLLBACK", 42, 776, "  Hot journal needs to be rolled back");
        SQLITE_READONLY_ROLLBACK = r49;
        SQLiteErrorCode r50 = new SQLiteErrorCode("SQLITE_IOERR_WRITE", 43, 778, " I/O error in the VFS layer while trying to write to a file on disk");
        SQLITE_IOERR_WRITE = r50;
        SQLiteErrorCode r51 = new SQLiteErrorCode("SQLITE_CANTOPEN_FULLPATH", 44, 782, " The operating system was unable to convert the filename into a full pathname");
        SQLITE_CANTOPEN_FULLPATH = r51;
        SQLiteErrorCode r52 = new SQLiteErrorCode("SQLITE_CONSTRAINT_FOREIGNKEY", 45, 787, " A foreign key constraint failed");
        SQLITE_CONSTRAINT_FOREIGNKEY = r52;
        SQLiteErrorCode r53 = new SQLiteErrorCode("SQLITE_READONLY_DBMOVED", 46, 1032, " The database file has been moved since it was opened");
        SQLITE_READONLY_DBMOVED = r53;
        SQLiteErrorCode r54 = new SQLiteErrorCode("SQLITE_IOERR_FSYNC", 47, 1034, " I/O error in the VFS layer while trying to flush previously written content");
        SQLITE_IOERR_FSYNC = r54;
        SQLiteErrorCode r55 = new SQLiteErrorCode("SQLITE_CANTOPEN_CONVPATH", 48, 1038, " cygwin_conv_path() system call failed while trying to open a file");
        SQLITE_CANTOPEN_CONVPATH = r55;
        SQLiteErrorCode r56 = new SQLiteErrorCode("SQLITE_CONSTRAINT_FUNCTION", 49, 1043, " Error reported by extension function");
        SQLITE_CONSTRAINT_FUNCTION = r56;
        SQLiteErrorCode r57 = new SQLiteErrorCode("SQLITE_IOERR_DIR_FSYNC", 50, 1290, " I/O error in the VFS layer while trying to invoke fsync() on a directory");
        SQLITE_IOERR_DIR_FSYNC = r57;
        SQLiteErrorCode r58 = new SQLiteErrorCode("SQLITE_CONSTRAINT_NOTNULL", 51, 1299, " A NOT NULL constraint failed");
        SQLITE_CONSTRAINT_NOTNULL = r58;
        SQLiteErrorCode r59 = new SQLiteErrorCode("SQLITE_IOERR_TRUNCATE", 52, 1546, " I/O error in the VFS layer while trying to truncate a file to a smaller size");
        SQLITE_IOERR_TRUNCATE = r59;
        SQLiteErrorCode r60 = new SQLiteErrorCode("SQLITE_CONSTRAINT_PRIMARYKEY", 53, 1555, " A PRIMARY KEY constraint failed");
        SQLITE_CONSTRAINT_PRIMARYKEY = r60;
        SQLiteErrorCode r61 = new SQLiteErrorCode("SQLITE_IOERR_FSTAT", 54, 1802, " I/O error in the VFS layer while trying to invoke fstat()");
        SQLITE_IOERR_FSTAT = r61;
        SQLiteErrorCode r62 = new SQLiteErrorCode("SQLITE_CONSTRAINT_TRIGGER", 55, 1811, " A RAISE function within a trigger fired, causing the SQL statement to abort");
        SQLITE_CONSTRAINT_TRIGGER = r62;
        SQLiteErrorCode r63 = new SQLiteErrorCode("SQLITE_IOERR_UNLOCK", 56, 2058, " I/O error within xUnlock");
        SQLITE_IOERR_UNLOCK = r63;
        SQLiteErrorCode r64 = new SQLiteErrorCode("SQLITE_CONSTRAINT_UNIQUE", 57, 2067, " A UNIQUE constraint failed");
        SQLITE_CONSTRAINT_UNIQUE = r64;
        SQLiteErrorCode r65 = new SQLiteErrorCode("SQLITE_IOERR_RDLOCK", 58, 2314, " I/O error within xLock");
        SQLITE_IOERR_RDLOCK = r65;
        SQLiteErrorCode r66 = new SQLiteErrorCode("SQLITE_CONSTRAINT_VTAB", 59, 2323, " Error reported by application-defined virtual table");
        SQLITE_CONSTRAINT_VTAB = r66;
        SQLiteErrorCode r67 = new SQLiteErrorCode("SQLITE_IOERR_DELETE", 60, 2570, " I/O error within xDelete");
        SQLITE_IOERR_DELETE = r67;
        SQLiteErrorCode r68 = new SQLiteErrorCode("SQLITE_CONSTRAINT_ROWID", 61, 2579, " rowid is not unique");
        SQLITE_CONSTRAINT_ROWID = r68;
        SQLiteErrorCode r69 = new SQLiteErrorCode("SQLITE_IOERR_NOMEM", 62, 3082, " Unable to allocate sufficient memory");
        SQLITE_IOERR_NOMEM = r69;
        SQLiteErrorCode r70 = new SQLiteErrorCode("SQLITE_IOERR_ACCESS", 63, 3338, " I/O error within the xAccess");
        SQLITE_IOERR_ACCESS = r70;
        SQLiteErrorCode r71 = new SQLiteErrorCode("SQLITE_IOERR_CHECKRESERVEDLOCK", 64, 3594, " I/O error within xCheckReservedLock");
        SQLITE_IOERR_CHECKRESERVEDLOCK = r71;
        SQLiteErrorCode r72 = new SQLiteErrorCode("SQLITE_IOERR_LOCK", 65, 3850, " I/O error in the advisory file locking logic");
        SQLITE_IOERR_LOCK = r72;
        SQLiteErrorCode r73 = new SQLiteErrorCode("SQLITE_IOERR_CLOSE", 66, 4106, " I/O error within xClose");
        SQLITE_IOERR_CLOSE = r73;
        SQLiteErrorCode r74 = new SQLiteErrorCode("SQLITE_IOERR_SHMOPEN", 67, 4618, " I/O error within xShmMap while trying to open a new shared memory segment");
        SQLITE_IOERR_SHMOPEN = r74;
        SQLiteErrorCode r75 = new SQLiteErrorCode("SQLITE_IOERR_SHMSIZE", 68, 4874, " I/O error within xShmMap while trying to resize an existing shared memory segment");
        SQLITE_IOERR_SHMSIZE = r75;
        SQLiteErrorCode r76 = new SQLiteErrorCode("SQLITE_IOERR_SHMMAP", 69, 5386, " I/O error within xShmMap while trying to map a shared memory segment");
        SQLITE_IOERR_SHMMAP = r76;
        SQLiteErrorCode r77 = new SQLiteErrorCode("SQLITE_IOERR_SEEK", 70, 5642, " I/O error while trying to seek a file descriptor");
        SQLITE_IOERR_SEEK = r77;
        SQLiteErrorCode r78 = new SQLiteErrorCode("SQLITE_IOERR_DELETE_NOENT", 71, 5898, " The file being deleted does not exist");
        SQLITE_IOERR_DELETE_NOENT = r78;
        SQLiteErrorCode r79 = new SQLiteErrorCode("SQLITE_IOERR_MMAP", 72, 6154, " I/O error while trying to map or unmap part of the database file");
        SQLITE_IOERR_MMAP = r79;
        SQLiteErrorCode r80 = new SQLiteErrorCode("SQLITE_IOERR_GETTEMPPATH", 73, 6410, " Unable to determine a suitable directory in which to place temporary files");
        SQLITE_IOERR_GETTEMPPATH = r80;
        SQLiteErrorCode r81 = new SQLiteErrorCode("SQLITE_IOERR_CONVPATH", 74, 6666, " cygwin_conv_path() system call failed");
        SQLITE_IOERR_CONVPATH = r81;
        f21051a = new SQLiteErrorCode[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81};
    }

    public SQLiteErrorCode(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.code = r11;
        this.message = r12;
    }

    public static SQLiteErrorCode getErrorCode(int r5) {
        SQLiteErrorCode[] r10 = values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        SQLiteErrorCode r13 = r10[r12];
        if (r5 == r13.code) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return UNKNOWN_ERROR;
    }

    public static SQLiteErrorCode valueOf(String r5) {
        return (SQLiteErrorCode) Enum.valueOf(SQLiteErrorCode.class, r5);
    }

    public static SQLiteErrorCode[] values() {
        return (SQLiteErrorCode[]) f21051a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return a.p("[", name(), "] ", this.message);
    }
}
