package androidx.sqlite.db;

import ai.j0;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Ljava/io/Closeable;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "close", "", "setWriteAheadLoggingEnabled", "enabled", "", "Callback", "Configuration", "Factory", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SupportSQLiteOpenHelper extends Closeable {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "", "version", "", "(I)V", "deleteDatabaseFile", "", "fileName", "", "onConfigure", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onCorruption", "onCreate", "onDowngrade", "oldVersion", "newVersion", "onOpen", "onUpgrade", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Callback {
        public static final Companion Companion = null;
        private static final String TAG = "SupportSQLite";

        @JvmField
        public final int version;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback$Companion;", "", "()V", "TAG", "", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Callback(int r5) {
            this.version = r5;
        }

        private final void deleteDatabaseFile(String r10) {
            if (StringsKt.l(r10, ":memory:") == true) goto L41;
            int r11 = r10.length() - 1;
            int r5 = 0;
            boolean r12 = false;
        L5:
            if (r5 > r11) goto L21;
            if (r12 == true) goto L8;
            int r13 = r5;
        L10:
            if (Intrinsics.compare(r10.charAt(r13), 32) > 0) goto L12;
            boolean r14 = true;
        L13:
            if (r12 == false) goto L14;
            if (r14 == false) goto L21;
            r11 = r11 - 1;
            goto L5
        L14:
            if (r14 == false) goto L15;
            r5 = r5 + 1;
            goto L5
        L15:
            r12 = true;
            goto L5
        L12:
            r14 = false;
            goto L13
        L8:
            r13 = r11;
        L21:
            if (r10.subSequence(r5, r11 + 1).toString().length() == 0) goto L42;
            Log.w(TAG, "deleting the database file: ".concat(r10));
            SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(r10));     // Catch: Exception -> L26
            return;
        L26:
            e = move-exception;
            Log.w(TAG, "delete failed: ", e);
            return;
        L42:
            return;
        }

        public void onConfigure(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
        }

        public void onCorruption(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
            Log.e(TAG, "Corruption reported by sqlite on database: " + r5 + ".path");
            if (r5.isOpen() == true) goto L8;
            String r10 = r5.getPath();
            if (r10 == null) goto L41;
            deleteDatabaseFile(r10);
            return;
        L41:
            return;
        L8:
            List<Pair<String, String>> r11 = null;
            r11 = r5.getAttachedDbs();     // Catch: Throwable -> L11 SQLiteException -> L33
        L11:
            th = move-exception;
            if (r11 == null) goto L20;
            Iterator<T> r12 = r11.iterator();
        L18:
            if (r12.hasNext() == false) goto L23;
            deleteDatabaseFile((String) ((Pair) r12.next()).second);
        L23:
            throw th;
        L20:
            String r13 = r5.getPath();
            if (r13 == null) goto L23;
            deleteDatabaseFile(r13);
        L38:
            r5.close();     // Catch: Throwable -> L11 IOException -> L34
        L24:
            if (r11 == null) goto L29;
            Iterator<T> r14 = r11.iterator();
        L27:
            if (r14.hasNext() == false) goto L43;
            deleteDatabaseFile((String) ((Pair) r14.next()).second);
            goto L27
        L43:
            return;
        L29:
            String r15 = r5.getPath();
            if (r15 == null) goto L42;
            deleteDatabaseFile(r15);
            return;
        }

        public abstract void onCreate(SupportSQLiteDatabase r5);

        public void onDowngrade(SupportSQLiteDatabase r5, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r5, "db");
            throw new SQLiteException(j0.f(r10, r11, "Can't downgrade database from version ", " to "));
        }

        public void onOpen(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
        }

        public abstract void onUpgrade(SupportSQLiteDatabase r5, int r10, int r11);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "", "context", "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "Builder", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Configuration {
        public static final Companion Companion = null;

        @JvmField
        public final boolean allowDataLossOnRecovery;

        @JvmField
        public final Callback callback;

        @JvmField
        public final Context context;

        @JvmField
        public final String name;

        @JvmField
        public final boolean useNoBackupDirectory;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowDataLossOnRecovery", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "name", "", "useNoBackupDirectory", "build", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "noBackupDirectory", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context r5) {
                Intrinsics.checkNotNullParameter(r5, "context");
                this.context = r5;
            }

            public Builder allowDataLossOnRecovery(boolean r5) {
                this.allowDataLossOnRecovery = r5;
                return this;
            }

            public Configuration build() {
                Callback r5 = this.callback;
                if (r5 == null) goto L16;
                if (this.useNoBackupDirectory == false) goto L14;
                String r10 = this.name;
                if (r10 == null) goto L12;
                if (r10.length() != 0) goto L14;
            L12:
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            L14:
                return new Configuration(this.context, this.name, r5, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
            L16:
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public Builder callback(Callback r5) {
                Intrinsics.checkNotNullParameter(r5, "callback");
                this.callback = r5;
                return this;
            }

            public Builder name(String r5) {
                this.name = r5;
                return this;
            }

            public Builder noBackupDirectory(boolean r5) {
                this.useNoBackupDirectory = r5;
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Companion;", "", "()V", "builder", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "context", "Landroid/content/Context;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            @JvmStatic
            public final Builder builder(Context r5) {
                Intrinsics.checkNotNullParameter(r5, "context");
                return new Builder(r5);
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Configuration(Context r5, String r10, Callback r11, boolean r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r11, "callback");
            this.context = r5;
            this.name = r10;
            this.callback = r11;
            this.useNoBackupDirectory = r12;
            this.allowDataLossOnRecovery = r13;
        }

        @JvmStatic
        public static final Builder builder(Context r5) {
            return Companion.builder(r5);
        }

        public /* synthetic */ Configuration(Context r10, String r11, Callback r12, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
            if ((r15 & 8) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r15 & 16) == 0) goto L9;
            boolean r17 = false;
        L10:
            this(r10, r11, r12, r5, r17);
            return;
        L9:
            r17 = r14;
            goto L10
        L5:
            r5 = r13;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration r5);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean r5);
}
