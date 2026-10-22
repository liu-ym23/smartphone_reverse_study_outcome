package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabaseConfiguration;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Ljava/io/Closeable;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", IslandSession.REOPEN_VALUE_CLOSE, "", "setWriteAheadLoggingEnabled", "enabled", "", "Callback", "Configuration", "Factory", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SupportSQLiteOpenHelper extends Closeable {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "", "version", "", "(I)V", "deleteDatabaseFile", "", "fileName", "", "onConfigure", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onCorruption", "onCreate", "onDowngrade", "oldVersion", "newVersion", "onOpen", "onUpgrade", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Callback {
        public static final Companion Companion = null;
        private static final String TAG = "SupportSQLite";
        public final int version;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback$Companion;", "", "()V", "TAG", "", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Callback(int r1) {
            this.version = r1;
        }

        private final void deleteDatabaseFile(String r9) {
            boolean r0 = true;
            if (StringsKt.equals(r9, SQLiteDatabaseConfiguration.MEMORY_DB_PATH, true) == true) goto L57;
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
            int r2 = r8.length() - 1;
            int r4 = 0;
            boolean r5 = false;
        L5:
            if (r4 > r2) goto L21;
            if (r5 == true) goto L8;
            int r6 = r4;
        L10:
            if (Intrinsics.compare(r8.charAt(r6), 32) > 0) goto L12;
            boolean r7 = true;
        L13:
            if (r5 == false) goto L14;
            if (r7 == false) goto L21;
            r2 = r2 - 1;
            goto L5
        L14:
            if (r7 == false) goto L15;
            r4 = r4 + 1;
            goto L5
        L15:
            r5 = true;
            goto L5
        L12:
            r7 = false;
            goto L13
        L8:
            r6 = r2;
        L21:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r8.subSequence(r4, r2 + 1).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L24;
            r0 = false;
        L24:
            if (r0 == true) goto L58;
            Log.w(TAG, "deleting the database file: " + r9);
        L38:
            e = move-exception;
            Log.w(TAG, "delete failed: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return;
        L28:
            if (Build.VERSION.SDK_INT < 16) goto L41;
            SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(r9));     // Catch: Exception -> L38
        L43:
            return;
        L41:
        L35:
            e = move-exception;
            Log.e(TAG, "error while deleting corrupted database file", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L38
            goto L43
        L32:
            if (new File(r9).delete() == true) goto L43;
            Log.e(TAG, "Could not delete the database file " + r9);     // Catch: Exception -> L35
        L58:
            return;
        }

        public void onConfigure(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "db");
        }

        public void onCorruption(SupportSQLiteDatabase r6) {
            SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "db");
            Log.e(TAG, "Corruption reported by sqlite on database: " + r7 + ".path");
            if (r7.isOpen() == true) goto L8;
            String r8 = r7.getPath();
            if (r8 == null) goto L41;
            deleteDatabaseFile(r8);
            return;
        L41:
            return;
        L8:
            List<Pair<String, String>> r1 = null;
            r1 = r7.getAttachedDbs();     // Catch: Throwable -> L11 SQLiteException -> L33
        L11:
            th = move-exception;
            if (r1 == null) goto L20;
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L18:
            if (r9.hasNext() == false) goto L23;
            Object r2 = ((Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin")).second;
            Intrinsics.checkNotNullExpressionValue(r2, "p.second");
            deleteDatabaseFile((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
        L23:
            throw th;
        L20:
            String r10 = r7.getPath();
            if (r10 == null) goto L23;
            deleteDatabaseFile(r10);
        L37:
            r7.close();     // Catch: Throwable -> L11 IOException -> L34
        L24:
            if (r1 == null) goto L29;
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L27:
            if (r11.hasNext() == false) goto L43;
            Object r3 = ((Pair) ZeusTransformUtils.preCheckCast(r11.next(), Pair.class, "com.obric.memorydata.plugin")).second;
            Intrinsics.checkNotNullExpressionValue(r3, "p.second");
            deleteDatabaseFile((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
            goto L27
        L43:
            return;
        L29:
            String r12 = r7.getPath();
            if (r12 == null) goto L42;
            deleteDatabaseFile(r12);
            return;
        }

        public abstract void onCreate(SupportSQLiteDatabase r1);

        public void onDowngrade(SupportSQLiteDatabase r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "db");
            throw new SQLiteException("Can't downgrade database from version " + r3 + " to " + r4);
        }

        public void onOpen(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "db");
        }

        public abstract void onUpgrade(SupportSQLiteDatabase r1, int r2, int r3);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "", "context", "Landroid/content/Context;", ActivityLifecycle.NAME, "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "Builder", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Configuration {
        public static final Companion Companion = null;
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowDataLossOnRecovery", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", ActivityLifecycle.NAME, "", "useNoBackupDirectory", "build", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "noBackupDirectory", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context r3) {
                Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "context");
                this.context = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
            }

            public Builder allowDataLossOnRecovery(boolean r4) {
                ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).allowDataLossOnRecovery = r4;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            }

            public Configuration build() {
                Callback r3 = this.callback;
                if (r3 == null) goto L21;
                boolean r1 = false;
                if (this.useNoBackupDirectory == false) goto L14;
                CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.name, CharSequence.class, "com.obric.memorydata.plugin");
                if (r0 != null) goto L9;
            L12:
                boolean r2 = true;
            L13:
                if (r2 == false) goto L14;
            L15:
                if (r1 == false) goto L19;
                return new Configuration(this.context, this.name, r3, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
            L19:
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
            L9:
                if (r0.length() == 0) goto L12;
                r2 = false;
            L14:
                r1 = true;
                goto L15
            L21:
                throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
            }

            public Builder callback(Callback r4) {
                Intrinsics.checkNotNullParameter(r4, "callback");
                ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).callback = r4;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            }

            public Builder name(String r4) {
                ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).name = r4;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            }

            public Builder noBackupDirectory(boolean r4) {
                ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).useNoBackupDirectory = r4;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Companion;", "", "()V", "builder", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "context", "Landroid/content/Context;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            @JvmStatic
            public final Builder builder(Context r2) {
                Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r1, "context");
                return new Builder(r1);
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Configuration(Context r3, String r4, Callback r5, boolean r6, boolean r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r5, "callback");
            this.context = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
            this.name = r4;
            this.callback = r5;
            this.useNoBackupDirectory = r6;
            this.allowDataLossOnRecovery = r7;
        }

        public /* synthetic */ Configuration(Context r7, String r8, Callback r9, boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
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

        @JvmStatic
        public static final Builder builder(Context r2) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return Companion.builder(r3);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean r1);
}
