package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SupportSQLiteCompat {

    @RequiresApi(16)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api16Impl {
        public static final Api16Impl INSTANCE = null;

        static {
            INSTANCE = new Api16Impl();
        }

        private Api16Impl() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void cancel(CancellationSignal r10) {
            Intrinsics.checkNotNullParameter(r10, "cancellationSignal");
            r10.cancel();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean deleteDatabase(File r10) {
            Intrinsics.checkNotNullParameter(r10, "file");
            return SQLiteDatabase.deleteDatabase(r10);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void disableWriteAheadLogging(SQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "sQLiteDatabase");
            r10.disableWriteAheadLogging();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean isWriteAheadLoggingEnabled(SQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "sQLiteDatabase");
            return r10.isWriteAheadLoggingEnabled();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Cursor rawQueryWithFactory(SQLiteDatabase r10, String r11, String[] r12, String r13, CancellationSignal r14, SQLiteDatabase.CursorFactory r15) {
            Intrinsics.checkNotNullParameter(r10, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(r11, "sql");
            Intrinsics.checkNotNullParameter(r12, "selectionArgs");
            Intrinsics.checkNotNullParameter(r14, "cancellationSignal");
            Intrinsics.checkNotNullParameter(r15, "cursorFactory");
            Cursor r16 = r10.rawQueryWithFactory(r15, r11, r12, r13, r14);
            Intrinsics.checkNotNullExpressionValue(r16, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
            return r16;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setForeignKeyConstraintsEnabled(SQLiteDatabase r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "sQLiteDatabase");
            r10.setForeignKeyConstraintsEnabled(r11);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setWriteAheadLoggingEnabled(SQLiteOpenHelper r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "sQLiteOpenHelper");
            r10.setWriteAheadLoggingEnabled(r11);
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api19Impl {
        public static final Api19Impl INSTANCE = null;

        static {
            INSTANCE = new Api19Impl();
        }

        private Api19Impl() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Uri getNotificationUri(Cursor r10) {
            Intrinsics.checkNotNullParameter(r10, "cursor");
            Uri r11 = r10.getNotificationUri();
            Intrinsics.checkNotNullExpressionValue(r11, "cursor.notificationUri");
            return r11;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean isLowRamDevice(ActivityManager r10) {
            Intrinsics.checkNotNullParameter(r10, "activityManager");
            return r10.isLowRamDevice();
        }
    }

    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api21Impl {
        public static final Api21Impl INSTANCE = null;

        static {
            INSTANCE = new Api21Impl();
        }

        private Api21Impl() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final File getNoBackupFilesDir(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            File r11 = r10.getNoBackupFilesDir();
            Intrinsics.checkNotNullExpressionValue(r11, "context.noBackupFilesDir");
            return r11;
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api23Impl {
        public static final Api23Impl INSTANCE = null;

        static {
            INSTANCE = new Api23Impl();
        }

        private Api23Impl() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setExtras(Cursor r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, "cursor");
            Intrinsics.checkNotNullParameter(r11, "extras");
            r10.setExtras(r11);
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = null;

        static {
            INSTANCE = new Api29Impl();
        }

        private Api29Impl() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final List<Uri> getNotificationUris(Cursor r10) {
            Intrinsics.checkNotNullParameter(r10, "cursor");
            List<Uri> r11 = r10.getNotificationUris();
            Intrinsics.checkNotNull(r11);
            return r11;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setNotificationUris(Cursor r10, ContentResolver r11, List<? extends Uri> r12) {
            Intrinsics.checkNotNullParameter(r10, "cursor");
            Intrinsics.checkNotNullParameter(r11, "cr");
            Intrinsics.checkNotNullParameter(r12, "uris");
            r10.setNotificationUris(r11, r12);
        }
    }

    private SupportSQLiteCompat() {
    }
}
