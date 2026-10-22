package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public static final Companion Companion = null;
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;
    private final SupportSQLiteOpenHelper.Callback callback;
    private final Context context;
    private final Lazy<OpenHelper> lazyDelegate;
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final class DBRefHolder {

        /* JADX INFO: renamed from: db, reason: collision with root package name */
        private FrameworkSQLiteDatabase f446db;

        public DBRefHolder(FrameworkSQLiteDatabase r10) {
            this.f446db = r10;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.f446db;
        }

        public final void setDb(FrameworkSQLiteDatabase r10) {
            this.f446db = r10;
        }
    }

    private static final class OpenHelper extends SQLiteOpenHelper {
        public static final Companion Companion = null;
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        private static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            public CallbackException(CallbackName r10, Throwable r11) {
                Intrinsics.checkNotNullParameter(r10, "callbackName");
                Intrinsics.checkNotNullParameter(r11, "cause");
                super(r11);
                this.callbackName = r10;
                this.cause = r11;
            }

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }
        }

        public static final enum CallbackName extends Enum<CallbackName> {
            private static final /* synthetic */ CallbackName[] $VALUES = null;
            public static final CallbackName ON_CONFIGURE = null;
            public static final CallbackName ON_CREATE = null;
            public static final CallbackName ON_DOWNGRADE = null;
            public static final CallbackName ON_OPEN = null;
            public static final CallbackName ON_UPGRADE = null;

            private static final /* synthetic */ CallbackName[] $values() {
                return new CallbackName[]{ON_CONFIGURE, ON_CREATE, ON_UPGRADE, ON_DOWNGRADE, ON_OPEN};
            }

            static {
                ON_CONFIGURE = new CallbackName("ON_CONFIGURE", 0);
                ON_CREATE = new CallbackName("ON_CREATE", 1);
                ON_UPGRADE = new CallbackName("ON_UPGRADE", 2);
                ON_DOWNGRADE = new CallbackName("ON_DOWNGRADE", 3);
                ON_OPEN = new CallbackName("ON_OPEN", 4);
                $VALUES = $values();
            }

            private CallbackName(String r10, int r11) {
                super(r10, r11);
            }

            public static CallbackName valueOf(String r10) {
                return (CallbackName) Enum.valueOf(CallbackName.class, r10);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) $VALUES.clone();
            }
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder r10, SQLiteDatabase r11) {
                Intrinsics.checkNotNullParameter(r10, "refHolder");
                Intrinsics.checkNotNullParameter(r11, "sqLiteDatabase");
                FrameworkSQLiteDatabase r12 = r10.getDb();
                if (r12 != null) goto L5;
            L6:
                FrameworkSQLiteDatabase r13 = new FrameworkSQLiteDatabase(r11);
                r10.setDb(r13);
                return r13;
            L5:
                if (r12.isDelegate(r11) == false) goto L6;
                return r12;
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r10 = new int[CallbackName.values().length];
                r10[CallbackName.ON_CONFIGURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r10[CallbackName.ON_CREATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r10[CallbackName.ON_UPGRADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r10[CallbackName.ON_DOWNGRADE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r10[CallbackName.ON_OPEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                $EnumSwitchMapping$0 = r10;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public OpenHelper(Context r10, String r11, final DBRefHolder r12, final SupportSQLiteOpenHelper.Callback r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r12, "dbRef");
            Intrinsics.checkNotNullParameter(r13, "callback");
            super(r10, r11, null, r13.version, new c(r13, r12));
            this.context = r10;
            this.dbRef = r12;
            this.callback = r13;
            this.allowDataLossOnRecovery = r14;
            if (r11 != null) goto L5;
            r11 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r11, "randomUUID().toString()");
        L5:
            File r15 = r10.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(r15, "context.cacheDir");
            this.lock = new ProcessLock(r11, r15, false);
        }

        private static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback r10, DBRefHolder r11, SQLiteDatabase r12) {
            Intrinsics.checkNotNullParameter(r10, "$callback");
            Intrinsics.checkNotNullParameter(r11, "$dbRef");
            Companion r13 = Companion;
            Intrinsics.checkNotNullExpressionValue(r12, "dbObj");
            r10.onCorruption(r13.getWrappedDb(r11, r12));
        }

        public static /* synthetic */ void a(SupportSQLiteOpenHelper.Callback r10, DBRefHolder r11, SQLiteDatabase r12) {
            _init_$lambda$0(r10, r11, r12);
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean r10) {
            if (r10 == false) goto L5;
            SQLiteDatabase r11 = super.getWritableDatabase();
        L6:
            Intrinsics.checkNotNullExpressionValue(r11, "{\n                super.…eDatabase()\n            }");
            return r11;
        L5:
            r11 = super.getReadableDatabase();
            goto L6
        }

        private final SQLiteDatabase innerGetDatabase(boolean r10) {
            String r11 = getDatabaseName();
            if (r11 == null) goto L47;
            File r12 = this.context.getDatabasePath(r11).getParentFile();
            if (r12 == null) goto L47;
            r12.mkdirs();
            if (r12.isDirectory() == true) goto L47;
            Log.w(FrameworkSQLiteOpenHelper.TAG, "Invalid database parent file, not a directory: " + r12);
        L47:
            return getWritableOrReadableDatabase(r10);
        L11:
            super.close();
            Thread.sleep(500);     // Catch: InterruptedException -> L44
        L45:
            return getWritableOrReadableDatabase(r10);
        L15:
            th = move-exception;
            super.close();
            if ((th instanceof CallbackException) == false) goto L32;
            CallbackException r13 = th;
            Throwable r14 = r13.getCause();
            int r15 = WhenMappings.$EnumSwitchMapping$0[r13.getCallbackName().ordinal()];
            if (r15 != 1) goto L21;
            throw r14;
        L21:
            if (r15 != 2) goto L23;
            throw r14;
        L23:
            if (r15 != 3) goto L25;
            throw r14;
        L25:
            if (r15 != 4) goto L27;
            throw r14;
        L27:
            if ((r14 instanceof SQLiteException) == true) goto L36;
            throw r14;
        L36:
            this.context.deleteDatabase(r11);
            return getWritableOrReadableDatabase(r10);
        L39:
            e = move-exception;
            throw e.getCause();
        L32:
            if ((th instanceof SQLiteException) == false) goto L43;
            if (r11 != null) goto L35;
        L42:
            throw th;
        L35:
            if (this.allowDataLossOnRecovery == false) goto L42;
        L43:
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            ProcessLock.lock$default(this.lock, false, 1, null);     // Catch: Throwable -> L5
            super.close();     // Catch: Throwable -> L5
            this.dbRef.setDb(null);     // Catch: Throwable -> L5
            this.opened = false;     // Catch: Throwable -> L5
            this.lock.unlock();
            return;
        L5:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        public final Context getContext() {
            return this.context;
        }

        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean r10) {
            ProcessLock r11 = this.lock;     // Catch: Throwable -> L16
            if (this.opened == false) goto L5;
        L7:
            boolean r12 = false;
        L8:
            r11.lock(r12);     // Catch: Throwable -> L16
            this.migrated = false;     // Catch: Throwable -> L16
            SQLiteDatabase r13 = innerGetDatabase(r10);     // Catch: Throwable -> L16
            if (this.migrated == false) goto L13;
            close();     // Catch: Throwable -> L16
            SupportSQLiteDatabase r14 = getSupportDatabase(r10);     // Catch: Throwable -> L16
            this.lock.unlock();
            return r14;
        L13:
            FrameworkSQLiteDatabase r15 = getWrappedDb(r13);     // Catch: Throwable -> L16
            this.lock.unlock();
            return r15;
        L5:
            if (getDatabaseName() == null) goto L7;
            r12 = true;
        L16:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, r10);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
            this.callback.onConfigure(getWrappedDb(r10));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CONFIGURE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "sqLiteDatabase");
            this.callback.onCreate(getWrappedDb(r10));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CREATE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "db");
            this.migrated = true;
            this.callback.onDowngrade(getWrappedDb(r10), r11, r12);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
            if (this.migrated == false) goto L11;
        L9:
            this.opened = true;
            return;
        L11:
            this.callback.onOpen(getWrappedDb(r10));     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_OPEN, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "sqLiteDatabase");
            this.migrated = true;
            this.callback.onUpgrade(getWrappedDb(r10), r11, r12);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_UPGRADE, th);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmOverloads
    public FrameworkSQLiteOpenHelper(Context r10, String r11, SupportSQLiteOpenHelper.Callback r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this(r10, r11, r12, false, false, 24, null);
    }

    @JvmOverloads
    public FrameworkSQLiteOpenHelper(Context r10, String r11, SupportSQLiteOpenHelper.Callback r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this(r10, r11, r12, r13, false, 16, null);
    }

    @JvmOverloads
    public FrameworkSQLiteOpenHelper(Context r10, String r11, SupportSQLiteOpenHelper.Callback r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this.context = r10;
        this.name = r11;
        this.callback = r12;
        this.useNoBackupDirectory = r13;
        this.allowDataLossOnRecovery = r14;
        this.lazyDelegate = LazyKt.lazy(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this));
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context r10, String r11, SupportSQLiteOpenHelper.Callback r12, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 8) == 0) goto L5;
        boolean r17 = false;
    L7:
        if ((r15 & 16) == 0) goto L9;
        boolean r18 = false;
    L10:
        this(r10, r11, r12, r17, r18);
        return;
    L9:
        r18 = r14;
        goto L10
    L5:
        r17 = r13;
        goto L7
    }

    public static final /* synthetic */ boolean access$getAllowDataLossOnRecovery$p(FrameworkSQLiteOpenHelper r10) {
        return r10.allowDataLossOnRecovery;
    }

    public static final /* synthetic */ SupportSQLiteOpenHelper.Callback access$getCallback$p(FrameworkSQLiteOpenHelper r10) {
        return r10.callback;
    }

    public static final /* synthetic */ Context access$getContext$p(FrameworkSQLiteOpenHelper r10) {
        return r10.context;
    }

    public static final /* synthetic */ String access$getName$p(FrameworkSQLiteOpenHelper r10) {
        return r10.name;
    }

    public static final /* synthetic */ boolean access$getUseNoBackupDirectory$p(FrameworkSQLiteOpenHelper r10) {
        return r10.useNoBackupDirectory;
    }

    public static final /* synthetic */ boolean access$getWriteAheadLoggingEnabled$p(FrameworkSQLiteOpenHelper r10) {
        return r10.writeAheadLoggingEnabled;
    }

    private final OpenHelper getDelegate() {
        return this.lazyDelegate.getValue();
    }

    private static Object getDelegate$delegate(FrameworkSQLiteOpenHelper r10) {
        return r10.lazyDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.lazyDelegate.isInitialized() == false) goto L6;
        getDelegate().close();
        return;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean r10) {
        if (this.lazyDelegate.isInitialized() == false) goto L5;
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(getDelegate(), r10);
    L5:
        this.writeAheadLoggingEnabled = r10;
    }
}
