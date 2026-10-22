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
import android.security.obric.guard.ObricSecurityGuardStub;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat;", "", "()V", "Api16Impl", "Api19Impl", "Api21Impl", "Api23Impl", "Api29Impl", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SupportSQLiteCompat {

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007JI\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\tH\u0007J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0007¨\u0006 "}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api16Impl;", "", "()V", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "cancellationSignal", "Landroid/os/CancellationSignal;", "createCancellationSignal", "deleteDatabase", "", "file", "Ljava/io/File;", "disableWriteAheadLogging", "sQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "isWriteAheadLoggingEnabled", "rawQueryWithFactory", "Landroid/database/Cursor;", "sql", "", "selectionArgs", "", "editTable", "cursorFactory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enable", "setWriteAheadLoggingEnabled", "sQLiteOpenHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "enabled", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api16Impl {
        public static final Api16Impl INSTANCE = null;

        static {
            INSTANCE = new Api16Impl();
        }

        private Api16Impl() {
        }

        @JvmStatic
        public static final void cancel(CancellationSignal r1) {
            Intrinsics.checkNotNullParameter(r1, "cancellationSignal");
            r1.cancel();
        }

        @JvmStatic
        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        @JvmStatic
        public static final boolean deleteDatabase(File r1) {
            Intrinsics.checkNotNullParameter(r1, "file");
            return SQLiteDatabase.deleteDatabase(r1);
        }

        @JvmStatic
        public static final void disableWriteAheadLogging(SQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, "sQLiteDatabase");
            r1.disableWriteAheadLogging();
        }

        @JvmStatic
        public static final boolean isWriteAheadLoggingEnabled(SQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, "sQLiteDatabase");
            return r1.isWriteAheadLoggingEnabled();
        }

        @JvmStatic
        public static final Cursor rawQueryWithFactory(SQLiteDatabase r6, String r7, String[] r8, String r9, CancellationSignal r10, SQLiteDatabase.CursorFactory r11) {
            SQLiteDatabase.CursorFactory r1 = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r11, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(r7, "sql");
            Intrinsics.checkNotNullParameter(r8, "selectionArgs");
            Intrinsics.checkNotNullParameter(r10, "cancellationSignal");
            Intrinsics.checkNotNullParameter(r1, "cursorFactory");
            Cursor r12 = r6.rawQueryWithFactory(r1, r7, r8, r9, r10);
            Intrinsics.checkNotNullExpressionValue(r12, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
            return r12;
        }

        @JvmStatic
        public static final void setForeignKeyConstraintsEnabled(SQLiteDatabase r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "sQLiteDatabase");
            r1.setForeignKeyConstraintsEnabled(r2);
        }

        @JvmStatic
        public static final void setWriteAheadLoggingEnabled(SQLiteOpenHelper r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "sQLiteOpenHelper");
            r1.setWriteAheadLoggingEnabled(r2);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api19Impl;", "", "()V", "getNotificationUri", "Landroid/net/Uri;", "cursor", "Landroid/database/Cursor;", "isLowRamDevice", "", "activityManager", "Landroid/app/ActivityManager;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api19Impl {
        public static final Api19Impl INSTANCE = null;

        static {
            INSTANCE = new Api19Impl();
        }

        private Api19Impl() {
        }

        @JvmStatic
        public static final Uri getNotificationUri(Cursor r2) {
            Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "cursor");
            Uri r4 = r3.getNotificationUri();
            Intrinsics.checkNotNullExpressionValue(r4, "cursor.notificationUri");
            return r4;
        }

        @JvmStatic
        public static final boolean isLowRamDevice(ActivityManager r1) {
            Intrinsics.checkNotNullParameter(r1, "activityManager");
            return r1.isLowRamDevice();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api21Impl;", "", "()V", "getNoBackupFilesDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api21Impl {
        public static final Api21Impl INSTANCE = null;

        static {
            INSTANCE = new Api21Impl();
        }

        private Api21Impl() {
        }

        @JvmStatic
        public static final File getNoBackupFilesDir(Context r2) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            File r4 = r3.getNoBackupFilesDir();
            Intrinsics.checkNotNullExpressionValue(r4, "context.noBackupFilesDir");
            return r4;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api23Impl;", "", "()V", "setExtras", "", "cursor", "Landroid/database/Cursor;", "extras", "Landroid/os/Bundle;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api23Impl {
        public static final Api23Impl INSTANCE = null;

        static {
            INSTANCE = new Api23Impl();
        }

        private Api23Impl() {
        }

        @JvmStatic
        public static final void setExtras(Cursor r2, Bundle r3) {
            Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "cursor");
            Intrinsics.checkNotNullParameter(r3, "extras");
            r4.setExtras(r3);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0007¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api29Impl;", "", "()V", "getNotificationUris", "", "Landroid/net/Uri;", "cursor", "Landroid/database/Cursor;", "setNotificationUris", "", "cr", "Landroid/content/ContentResolver;", "uris", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = null;

        static {
            INSTANCE = new Api29Impl();
        }

        private Api29Impl() {
        }

        @JvmStatic
        public static final List<Uri> getNotificationUris(Cursor r2) {
            Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "cursor");
            List<Uri> r4 = r3.getNotificationUris();
            Intrinsics.checkNotNull(r4);
            return r4;
        }

        @JvmStatic
        public static final void setNotificationUris(Cursor r2, ContentResolver r3, List<? extends Uri> r4) {
            Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
            List<Uri> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "cursor");
            Intrinsics.checkNotNullParameter(r3, "cr");
            Intrinsics.checkNotNullParameter(r6, "uris");
            r5.setNotificationUris(r3, r6);
        }
    }

    private SupportSQLiteCompat() {
    }
}
