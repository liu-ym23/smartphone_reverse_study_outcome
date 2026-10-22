package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tH\u0017R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "context", "Landroid/content/Context;", ActivityLifecycle.NAME, "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "delegate", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "getDelegate$delegate", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;)Ljava/lang/Object;", "getDelegate", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "lazyDelegate", "Lkotlin/Lazy;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "writeAheadLoggingEnabled", IslandSession.REOPEN_VALUE_CLOSE, "", "setWriteAheadLoggingEnabled", "enabled", "Companion", "DBRefHolder", "OpenHelper", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$Companion;", "", "()V", "TAG", "", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "", "db", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "(Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;)V", "getDb", "()Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "setDb", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class DBRefHolder {
        private FrameworkSQLiteDatabase db;

        public DBRefHolder(FrameworkSQLiteDatabase r1) {
            this.db = r1;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.db;
        }

        public final void setDb(FrameworkSQLiteDatabase r1) {
            this.db = r1;
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 /2\u00020\u0001:\u0003-./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J \u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J \u0010,\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", ActivityLifecycle.NAME, "", "dbRef", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "allowDataLossOnRecovery", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;Z)V", "getAllowDataLossOnRecovery", "()Z", "getCallback", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "getContext", "()Landroid/content/Context;", "getDbRef", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "lock", "Landroidx/sqlite/util/ProcessLock;", "migrated", "opened", IslandSession.REOPEN_VALUE_CLOSE, "", "getSupportDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "writable", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getWritableOrReadableDatabase", "innerGetDatabase", "onConfigure", "db", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "CallbackException", "CallbackName", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class OpenHelper extends SQLiteOpenHelper {
        public static final Companion Companion = null;
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "cause", "", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "getCallbackName", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        private static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            public CallbackException(CallbackName r2, Throwable r3) {
                Intrinsics.checkNotNullParameter(r2, "callbackName");
                Intrinsics.checkNotNullParameter(r3, "cause");
                super(r3);
                this.callbackName = r2;
                this.cause = r3;
            }

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "(Ljava/lang/String;I)V", "ON_CONFIGURE", "ON_CREATE", "ON_UPGRADE", "ON_DOWNGRADE", "ON_OPEN", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

            private CallbackName(String r1, int r2) {
                super(r1, r2);
            }

            public static CallbackName valueOf(String r2) {
                return (CallbackName) ZeusTransformUtils.preCheckCast(Enum.valueOf(CallbackName.class, r2), CallbackName.class, "com.obric.memorydata.plugin");
            }

            public static CallbackName[] values() {
                return (CallbackName[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CallbackName[].class, "com.obric.memorydata.plugin");
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$Companion;", "", "()V", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "refHolder", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder r2, SQLiteDatabase r3) {
                Intrinsics.checkNotNullParameter(r2, "refHolder");
                Intrinsics.checkNotNullParameter(r3, "sqLiteDatabase");
                FrameworkSQLiteDatabase r1 = r2.getDb();
                if (r1 != null) goto L5;
            L6:
                FrameworkSQLiteDatabase r4 = new FrameworkSQLiteDatabase(r3);
                r2.setDb(r4);
                return r4;
            L5:
                if (r1.isDelegate(r3) == false) goto L6;
                return r1;
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[CallbackName.values().length];
                r0[CallbackName.ON_CONFIGURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[CallbackName.ON_CREATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[CallbackName.ON_UPGRADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[CallbackName.ON_DOWNGRADE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[CallbackName.ON_OPEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                $EnumSwitchMapping$0 = r0;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public OpenHelper(Context r9, String r10, final DBRefHolder r11, final SupportSQLiteOpenHelper.Callback r12, boolean r13) {
            Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "context");
            Intrinsics.checkNotNullParameter(r11, "dbRef");
            Intrinsics.checkNotNullParameter(r12, "callback");
            super(r14, r10, null, r12.version, new $$Lambda$FrameworkSQLiteOpenHelper$OpenHelper$wesXNSdtx2gMKZWCPManFjtpLB8(r12, r11));
            Context r15 = ZeusTransformUtils.wrapperContext(r14, "com.obric.memorydata.plugin");
            this.context = r15;
            this.dbRef = r11;
            this.callback = r12;
            this.allowDataLossOnRecovery = r13;
            if (r10 != null) goto L5;
            r10 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r10, "randomUUID().toString()");
        L5:
            this.lock = new ProcessLock(r10, r15.getCacheDir(), false);
        }

        private static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback r2, DBRefHolder r3, SQLiteDatabase r4) {
            Intrinsics.checkNotNullParameter(r2, "$callback");
            Intrinsics.checkNotNullParameter(r3, "$dbRef");
            Companion r0 = Companion;
            Intrinsics.checkNotNullExpressionValue(r4, "dbObj");
            r2.onCorruption((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r0.getWrappedDb(r3, r4), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean r2) {
            if (r2 == false) goto L5;
            SQLiteDatabase r1 = super.getWritableDatabase();
        L6:
            Intrinsics.checkNotNullExpressionValue(r1, "{\n                super.…eDatabase()\n            }");
            return r1;
        L5:
            r1 = super.getReadableDatabase();
            goto L6
        }

        private final SQLiteDatabase innerGetDatabase(boolean r6) {
            String r0 = getDatabaseName();
            boolean r1 = this.opened;
            if (r0 == null) goto L52;
            if (r1 == true) goto L52;
            File r2 = this.context.getDatabasePath(r0).getParentFile();
            if (r2 == null) goto L52;
            r2.mkdirs();
            if (r2.isDirectory() == true) goto L52;
            Log.w(FrameworkSQLiteOpenHelper.TAG, "Invalid database parent file, not a directory: " + r2);
        L52:
            return getWritableOrReadableDatabase(r6);
        L12:
            super.close();
            Thread.sleep(500);     // Catch: InterruptedException -> L45
        L50:
            return getWritableOrReadableDatabase(r6);
        L16:
            th = move-exception;
            super.close();
            if (ZeusTransformUtils.instanceOf(th, CallbackException.class) == false) goto L33;
            Throwable r3 = ((CallbackException) ZeusTransformUtils.preCheckCast(th, CallbackException.class, "com.obric.memorydata.plugin")).getCause();
            int r4 = WhenMappings.$EnumSwitchMapping$0[((CallbackException) ZeusTransformUtils.preCheckCast(th, CallbackException.class, "com.obric.memorydata.plugin")).getCallbackName().ordinal()];
            if (r4 != 1) goto L22;
            throw r3;
        L22:
            if (r4 != 2) goto L24;
            throw r3;
        L24:
            if (r4 != 3) goto L26;
            throw r3;
        L26:
            if (r4 != 4) goto L28;
            throw r3;
        L28:
            if (ZeusTransformUtils.instanceOf(r3, SQLiteException.class) == true) goto L37;
            throw r3;
        L37:
            this.context.deleteDatabase(r0);
            return getWritableOrReadableDatabase(r6);
        L40:
            e = move-exception;
            throw e.getCause();
        L33:
            if (ZeusTransformUtils.instanceOf(th, SQLiteException.class) == false) goto L44;
            if (r0 != null) goto L36;
        L43:
            throw th;
        L36:
            if (this.allowDataLossOnRecovery == false) goto L43;
        L44:
            throw th;
        }

        public static /* synthetic */ void lambda$wesXNSdtx2gMKZWCPManFjtpLB8(SupportSQLiteOpenHelper.Callback r0, DBRefHolder r1, SQLiteDatabase r2) {
            _init_$lambda$0(r0, r1, r2);
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

        public final SupportSQLiteDatabase getSupportDatabase(boolean r4) {
            ProcessLock r0 = this.lock;     // Catch: Throwable -> L16
            if (this.opened == false) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.lock(r1);     // Catch: Throwable -> L16
            this.migrated = false;     // Catch: Throwable -> L16
            SQLiteDatabase r2 = innerGetDatabase(r4);     // Catch: Throwable -> L16
            if (this.migrated == false) goto L13;
            close();     // Catch: Throwable -> L16
            SupportSQLiteDatabase r5 = getSupportDatabase(r4);     // Catch: Throwable -> L16
            this.lock.unlock();
            return r5;
        L13:
            SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(getWrappedDb(r2), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            this.lock.unlock();
            return r6;
        L5:
            if (getDatabaseName() == null) goto L7;
            r1 = true;
        L16:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter(r2, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, r2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r3) {
            Intrinsics.checkNotNullParameter(r3, "db");
            if (this.migrated == false) goto L5;
        L12:
            this.callback.onConfigure((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(getWrappedDb(r3), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CONFIGURE, th);
        L5:
            if (this.callback.version == r3.getVersion()) goto L12;
            r3.setMaxSqlCacheSize(1);
            goto L12
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r3) {
            Intrinsics.checkNotNullParameter(r3, "sqLiteDatabase");
            this.callback.onCreate((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(getWrappedDb(r3), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_CREATE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "db");
            this.migrated = true;
            this.callback.onDowngrade((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(getWrappedDb(r3), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), r4, r5);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r4) {
            Intrinsics.checkNotNullParameter(r4, "db");
            if (this.migrated == false) goto L11;
        L9:
            this.opened = true;
            return;
        L11:
            this.callback.onOpen((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(getWrappedDb(r4), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_OPEN, th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "sqLiteDatabase");
            this.migrated = true;
            this.callback.onUpgrade((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(getWrappedDb(r3), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), r4, r5);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            throw new CallbackException(CallbackName.ON_UPGRADE, th);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FrameworkSQLiteOpenHelper(Context r9, String r10, SupportSQLiteOpenHelper.Callback r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r11, "callback");
        this(r1, r10, r11, false, false, 24, null);
    }

    public FrameworkSQLiteOpenHelper(Context r9, String r10, SupportSQLiteOpenHelper.Callback r11, boolean r12) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r11, "callback");
        this(r1, r10, r11, r12, false, 16, null);
    }

    public FrameworkSQLiteOpenHelper(Context r3, String r4, SupportSQLiteOpenHelper.Callback r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.context = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.name = r4;
        this.callback = r5;
        this.useNoBackupDirectory = r6;
        this.allowDataLossOnRecovery = r7;
        this.lazyDelegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context r7, String r8, SupportSQLiteOpenHelper.Callback r9, boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if ((r12 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r12 & 16) == 0) goto L9;
        boolean r5 = false;
    L10:
        this(r1, r8, r9, r4, r5);
        return;
    L9:
        r5 = r11;
        goto L10
    L5:
        r4 = r10;
        goto L7
    }

    public static final /* synthetic */ boolean access$getAllowDataLossOnRecovery$p(FrameworkSQLiteOpenHelper r0) {
        return r0.allowDataLossOnRecovery;
    }

    public static final /* synthetic */ SupportSQLiteOpenHelper.Callback access$getCallback$p(FrameworkSQLiteOpenHelper r0) {
        return r0.callback;
    }

    public static final /* synthetic */ Context access$getContext$p(FrameworkSQLiteOpenHelper r0) {
        return r0.context;
    }

    public static final /* synthetic */ String access$getName$p(FrameworkSQLiteOpenHelper r0) {
        return r0.name;
    }

    public static final /* synthetic */ boolean access$getUseNoBackupDirectory$p(FrameworkSQLiteOpenHelper r0) {
        return r0.useNoBackupDirectory;
    }

    public static final /* synthetic */ boolean access$getWriteAheadLoggingEnabled$p(FrameworkSQLiteOpenHelper r0) {
        return r0.writeAheadLoggingEnabled;
    }

    private final OpenHelper getDelegate() {
        return (OpenHelper) ZeusTransformUtils.preCheckCast(this.lazyDelegate.getValue(), OpenHelper.class, "com.obric.memorydata.plugin");
    }

    private static Object getDelegate$delegate(FrameworkSQLiteOpenHelper r0) {
        return r0.lazyDelegate;
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
    public void setWriteAheadLoggingEnabled(boolean r4) {
        if (this.lazyDelegate.isInitialized() == false) goto L5;
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled((SQLiteOpenHelper) ZeusTransformUtils.preCheckCast(getDelegate(), SQLiteOpenHelper.class, "com.obric.memorydata.plugin"), r4);
    L5:
        this.writeAheadLoggingEnabled = r4;
    }
}
