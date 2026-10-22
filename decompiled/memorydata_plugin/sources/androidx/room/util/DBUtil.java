package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"createCancellationSignal", "Landroid/os/CancellationSignal;", "dropFtsSyncTriggers", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "foreignKeyCheck", "tableName", "", "processForeignKeyCheckFailure", "cursor", "Landroid/database/Cursor;", ChatMessage.TYPE_QUERY, "Landroidx/room/RoomDatabase;", "sqLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "maybeCopy", "", "signal", "readVersion", "", "databaseFile", "Ljava/io/File;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DBUtil {
    public static final CancellationSignal createCancellationSignal() {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    L6:
        return (CancellationSignal) ZeusTransformUtils.preCheckCast(null, CancellationSignal.class, "com.obric.memorydata.plugin");
    }

    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "db");
        List r0 = CollectionsKt.createListBuilder();
        Cursor r2 = r8.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        if (Build.VERSION.SDK_INT <= 15) goto L35;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L7:
        if (r4.moveToNext() == false) goto L9;
        r0.add(r4.getString(0));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r3, null);
    L21:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r1.hasNext() == false) goto L27;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "triggerName");
        if (StringsKt.startsWith$default(r6, "room_fts_content_sync_", false, 2, null) == false) goto L23;
        r8.execSQL("DROP TRIGGER IF EXISTS " + r6);
        goto L23
    L27:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L35:
    L28:
        th = move-exception;
        r2.close();
        throw th;
    L17:
        if (r2.moveToNext() == false) goto L19;
        r0.add(r2.getString(0));     // Catch: Throwable -> L28
        goto L35
    L19:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r2.close();
        goto L21
    }

    public static final void foreignKeyCheck(SupportSQLiteDatabase r3, String r4) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "db");
        Intrinsics.checkNotNullParameter(r4, "tableName");
        Cursor r6 = r5.query("PRAGMA foreign_key_check(`" + r4 + "`)");
        if (Build.VERSION.SDK_INT <= 15) goto L28;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r0.getCount() > 0) goto L10;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r7, null);
        return;
    L10:
        throw new SQLiteConstraintException(processForeignKeyCheckFailure(r0));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L28:
    L23:
        th = move-exception;
        r6.close();
        throw th;
    L17:
        if (r6.getCount() > 0) goto L22;
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r6.close();
        return;
    L22:
        throw new SQLiteConstraintException(processForeignKeyCheckFailure(r6));     // Catch: Throwable -> L23
    }

    private static final String processForeignKeyCheckFailure(Cursor r7) {
        Cursor r8 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r7, Cursor.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        int r2 = r8.getCount();
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L4:
        if (r8.moveToNext() == false) goto L11;
        if (r8.isFirst() == false) goto L8;
        r0.append("Foreign key violation(s) detected in '");
        r0.append(r8.getString(0)).append("'.\n");
    L8:
        String r4 = r8.getString(3);
        if (r3.containsKey(r4) == true) goto L4;
        Intrinsics.checkNotNullExpressionValue(r4, "constraintIndex");
        String r5 = r8.getString(2);
        Intrinsics.checkNotNullExpressionValue(r5, "cursor.getString(2)");
        r3.put(r4, r5);
        goto L4
    L11:
        r0.append("Number of different violations discovered: ");
        r0.append(r3.keySet().size()).append("\n");
        r0.append("Number of rows in violation: ");
        r0.append(r2).append("\n");
        r0.append("Violation(s) detected in the following constraint(s):\n");
        Iterator r9 = r3.entrySet().iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin");
        r0.append("\tParent Table = ");
        r0.append(r11);
        r0.append(", Foreign Key Constraint Index = ");
        r0.append(r10).append("\n");
        goto L13
    L15:
        String r12 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    }

    @Deprecated(message = "This is only used in the generated code and shouldn't be called directly.")
    public static final Cursor query(RoomDatabase r2, SupportSQLiteQuery r3, boolean r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "db");
        Intrinsics.checkNotNullParameter(r5, "sqLiteQuery");
        return query(r2, r5, r4, null);
    }

    public static final Cursor query(RoomDatabase r2, SupportSQLiteQuery r3, boolean r4, CancellationSignal r5) {
        SupportSQLiteQuery r6 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "db");
        Intrinsics.checkNotNullParameter(r6, "sqLiteQuery");
        Cursor r7 = r2.query(r6, r5);
        if (r4 == true) goto L5;
        return r7;
    L5:
        if (ZeusTransformUtils.instanceOf(r7, AbstractWindowedCursor.class) == false) goto L16;
        int r8 = ((AbstractWindowedCursor) ZeusTransformUtils.preCheckCast(r7, AbstractWindowedCursor.class, "com.obric.memorydata.plugin")).getCount();
        if (((AbstractWindowedCursor) ZeusTransformUtils.preCheckCast(r7, AbstractWindowedCursor.class, "com.obric.memorydata.plugin")).hasWindow() == false) goto L9;
        int r9 = ((AbstractWindowedCursor) ZeusTransformUtils.preCheckCast(r7, AbstractWindowedCursor.class, "com.obric.memorydata.plugin")).getWindow().getNumRows();
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r9 < r8) goto L14;
        return r7;
    L14:
        return CursorUtil.copyAndClose(r7);
    L9:
        r9 = r8;
        goto L11
    L16:
        return r7;
    }

    public static final int readVersion(File r9) {
        Intrinsics.checkNotNullParameter(r9, "databaseFile");
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r9).getChannel(), Closeable.class, "com.obric.memorydata.plugin");
        FileChannel r0 = (FileChannel) ZeusTransformUtils.preCheckCast(r10, FileChannel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        ByteBuffer r8 = ByteBuffer.allocate(4);     // Catch: Throwable -> L10
        r0.tryLock(60, 4, true);     // Catch: Throwable -> L10
        r0.position(60);     // Catch: Throwable -> L10
        if (r0.read(r8) != 4) goto L9;
        r8.rewind();     // Catch: Throwable -> L10
        int r1 = r8.getInt();     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r10, null);
        return r1;
    L9:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }
}
