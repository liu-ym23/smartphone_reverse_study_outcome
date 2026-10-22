package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    public static abstract class Callback {
        public static final Companion Companion = null;
        private static final String TAG = "SupportSQLite";

        @JvmField
        public final int version;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Callback(int r10) {
            this.version = r10;
        }

        private final void deleteDatabaseFile(String r10) {
            boolean r11 = true;
            if (StringsKt.equals(r10, ":memory:", true) == true) goto L57;
            int r12 = r10.length() - 1;
            int r13 = 0;
            boolean r14 = false;
        L5:
            if (r13 > r12) goto L21;
            if (r14 == true) goto L8;
            int r15 = r13;
        L10:
            if (Intrinsics.compare(r10.charAt(r15), 32) > 0) goto L12;
            boolean r16 = true;
        L13:
            if (r14 == false) goto L14;
            if (r16 == false) goto L21;
            r12 = r12 - 1;
            goto L5
        L14:
            if (r16 == false) goto L15;
            r13 = r13 + 1;
            goto L5
        L15:
            r14 = true;
            goto L5
        L12:
            r16 = false;
            goto L13
        L8:
            r15 = r12;
        L21:
            if (r10.subSequence(r13, r12 + 1).toString().length() == 0) goto L24;
            r11 = false;
        L24:
            if (r11 == true) goto L58;
            Log.w(TAG, "deleting the database file: " + r10);
        L38:
            e = move-exception;
            Log.w(TAG, "delete failed: ", e);
            return;
        L28:
            if (Build.VERSION.SDK_INT < 16) goto L41;
            SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(r10));     // Catch: Exception -> L38
        L43:
            return;
        L41:
        L35:
            e = move-exception;
            Log.e(TAG, "error while deleting corrupted database file", e);     // Catch: Exception -> L38
            goto L43
        L32:
            if (new File(r10).delete() == true) goto L43;
            Log.e(TAG, "Could not delete the database file " + r10);     // Catch: Exception -> L35
        L58:
            return;
        }

        public void onConfigure(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
        }

        public void onCorruption(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
            Log.e(TAG, "Corruption reported by sqlite on database: " + r10 + ".path");
            if (r10.isOpen() == true) goto L8;
            String r11 = r10.getPath();
            if (r11 == null) goto L41;
            deleteDatabaseFile(r11);
            return;
        L41:
            return;
        L8:
            List<Pair<String, String>> r12 = null;
            r12 = r10.getAttachedDbs();     // Catch: Throwable -> L11 SQLiteException -> L33
        L11:
            th = move-exception;
            if (r12 == null) goto L20;
            Iterator<T> r13 = r12.iterator();
        L18:
            if (r13.hasNext() == false) goto L23;
            Object r14 = ((Pair) r13.next()).second;
            Intrinsics.checkNotNullExpressionValue(r14, "p.second");
            deleteDatabaseFile((String) r14);
        L23:
            throw th;
        L20:
            String r15 = r10.getPath();
            if (r15 == null) goto L23;
            deleteDatabaseFile(r15);
        L37:
            r10.close();     // Catch: Throwable -> L11 IOException -> L34
        L24:
            if (r12 == null) goto L29;
            Iterator<T> r16 = r12.iterator();
        L27:
            if (r16.hasNext() == false) goto L43;
            Object r17 = ((Pair) r16.next()).second;
            Intrinsics.checkNotNullExpressionValue(r17, "p.second");
            deleteDatabaseFile((String) r17);
            goto L27
        L43:
            return;
        L29:
            String r18 = r10.getPath();
            if (r18 == null) goto L42;
            deleteDatabaseFile(r18);
            return;
        }

        public abstract void onCreate(SupportSQLiteDatabase r10);

        public void onDowngrade(SupportSQLiteDatabase r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "db");
            throw new SQLiteException("Can't downgrade database from version " + r11 + " to " + r12);
        }

        public void onOpen(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
        }

        public abstract void onUpgrade(SupportSQLiteDatabase r10, int r11, int r12);
    }

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

        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context r10) {
                Intrinsics.checkNotNullParameter(r10, "context");
                this.context = r10;
            }

            public Builder allowDataLossOnRecovery(boolean r10) {
                this.allowDataLossOnRecovery = r10;
                return this;
            }

            public Configuration build() {
                Callback r10 = this.callback;
                if (r10 == null) goto L21;
                boolean r11 = false;
                if (this.useNoBackupDirectory == false) goto L14;
                String r12 = this.name;
                if (r12 != null) goto L9;
            L12:
                boolean r13 = true;
            L13:
                if (r13 == false) goto L14;
            L15:
                if (r11 == false) goto L19;
                return new Configuration(this.context, this.name, r10, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
            L19:
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
            L9:
                if (r12.length() == 0) goto L12;
                r13 = false;
            L14:
                r11 = true;
                goto L15
            L21:
                throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
            }

            public Builder callback(Callback r10) {
                Intrinsics.checkNotNullParameter(r10, "callback");
                this.callback = r10;
                return this;
            }

            public Builder name(String r10) {
                this.name = r10;
                return this;
            }

            public Builder noBackupDirectory(boolean r10) {
                this.useNoBackupDirectory = r10;
                return this;
            }
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            @JvmStatic
            public final Builder builder(Context r10) {
                Intrinsics.checkNotNullParameter(r10, "context");
                return new Builder(r10);
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Configuration(Context r10, String r11, Callback r12, boolean r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r12, "callback");
            this.context = r10;
            this.name = r11;
            this.callback = r12;
            this.useNoBackupDirectory = r13;
            this.allowDataLossOnRecovery = r14;
        }

        public /* synthetic */ Configuration(Context r10, String r11, Callback r12, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
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

        @JvmStatic
        public static final Builder builder(Context r10) {
            return Companion.builder(r10);
        }
    }

    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration r10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean r10);
}
