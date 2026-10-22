package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "DBUtil")
public final class DBUtil {
    public static final CancellationSignal createCancellationSignal() {
        if (Build.VERSION.SDK_INT >= 16) goto L7;
        return null;
    L7:
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        List r11 = CollectionsKt.createListBuilder();
        Cursor r12 = r10.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        if (Build.VERSION.SDK_INT <= 15) goto L31;
    L29:
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L5:
        if (r12.moveToNext() == false) goto L7;
        r11.add(r12.getString(0));     // Catch: Throwable -> L9
        goto L29
    L7:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r12, null);
    L19:
        Iterator r14 = CollectionsKt.build(r11).iterator();
    L21:
        if (r14.hasNext() == false) goto L25;
        String r15 = (String) r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, "triggerName");
        if (StringsKt.startsWith$default(r15, "room_fts_content_sync_", false, 2, null) == false) goto L21;
        r10.execSQL("DROP TRIGGER IF EXISTS " + r15);
        goto L21
    L25:
        return;
    L31:
    L26:
        th = move-exception;
        r12.close();
        throw th;
    L15:
        if (r12.moveToNext() == false) goto L17;
        r11.add(r12.getString(0));     // Catch: Throwable -> L26
        goto L31
    L17:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r12.close();
        goto L19
    }

    public static final void foreignKeyCheck(SupportSQLiteDatabase r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "db");
        Intrinsics.checkNotNullParameter(r11, "tableName");
        Cursor r12 = r10.query("PRAGMA foreign_key_check(`" + r11 + "`)");
        if (Build.VERSION.SDK_INT > 15) goto L26;
    L23:
        th = move-exception;
        r12.close();
        throw th;
    L17:
        if (r12.getCount() > 0) goto L22;
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r12.close();
        return;
    L22:
        throw new SQLiteConstraintException(processForeignKeyCheckFailure(r12));     // Catch: Throwable -> L23
    L26:
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L6:
        if (r12.getCount() > 0) goto L10;
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r12, null);
        return;
    L10:
        throw new SQLiteConstraintException(processForeignKeyCheckFailure(r12));     // Catch: Throwable -> L11
    }

    private static final String processForeignKeyCheckFailure(Cursor r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.getCount();
        LinkedHashMap r13 = new LinkedHashMap();
    L4:
        if (r10.moveToNext() == false) goto L11;
        if (r10.isFirst() == false) goto L8;
        r11.append("Foreign key violation(s) detected in '");
        r11.append(r10.getString(0));
        r11.append("'.\n");
    L8:
        String r14 = r10.getString(3);
        if (r13.containsKey(r14) == true) goto L4;
        Intrinsics.checkNotNullExpressionValue(r14, "constraintIndex");
        String r15 = r10.getString(2);
        Intrinsics.checkNotNullExpressionValue(r15, "cursor.getString(2)");
        r13.put(r14, r15);
        goto L4
    L11:
        r11.append("Number of different violations discovered: ");
        r11.append(r13.keySet().size());
        r11.append("\n");
        r11.append("Number of rows in violation: ");
        r11.append(r12);
        r11.append("\n");
        r11.append("Violation(s) detected in the following constraint(s):\n");
        Iterator r16 = r13.entrySet().iterator();
    L13:
        if (r16.hasNext() == false) goto L15;
        Map.Entry r17 = (Map.Entry) r16.next();
        String r18 = (String) r17.getKey();
        String r19 = (String) r17.getValue();
        r11.append("\tParent Table = ");
        r11.append(r19);
        r11.append(", Foreign Key Constraint Index = ");
        r11.append(r18);
        r11.append("\n");
        goto L13
    L15:
        String r20 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "StringBuilder().apply(builderAction).toString()");
        return r20;
    }

    @Deprecated(message = "This is only used in the generated code and shouldn't be called directly.")
    public static final Cursor query(RoomDatabase r10, SupportSQLiteQuery r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "db");
        Intrinsics.checkNotNullParameter(r11, "sqLiteQuery");
        return query(r10, r11, r12, null);
    }

    public static final Cursor query(RoomDatabase r10, SupportSQLiteQuery r11, boolean r12, CancellationSignal r13) {
        Intrinsics.checkNotNullParameter(r10, "db");
        Intrinsics.checkNotNullParameter(r11, "sqLiteQuery");
        Cursor r14 = r10.query(r11, r13);
        if (r12 == true) goto L5;
        return r14;
    L5:
        if ((r14 instanceof AbstractWindowedCursor) == false) goto L16;
        AbstractWindowedCursor r15 = (AbstractWindowedCursor) r14;
        int r16 = r15.getCount();
        if (r15.hasWindow() == false) goto L9;
        int r17 = r15.getWindow().getNumRows();
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r17 < r16) goto L14;
        return r14;
    L14:
        return CursorUtil.copyAndClose(r14);
    L9:
        r17 = r16;
        goto L11
    L16:
        return r14;
    }

    public static final int readVersion(File r10) {
        Intrinsics.checkNotNullParameter(r10, "databaseFile");
        FileChannel r11 = new FileInputStream(r10).getChannel();
        ByteBuffer r12 = ByteBuffer.allocate(4);     // Catch: Throwable -> L10
        r11.tryLock(60, 4, true);     // Catch: Throwable -> L10
        r11.position(60);     // Catch: Throwable -> L10
        if (r11.read(r12) != 4) goto L9;
        r12.rewind();     // Catch: Throwable -> L10
        int r13 = r12.getInt();     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r11, null);
        return r13;
    L9:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }
}
