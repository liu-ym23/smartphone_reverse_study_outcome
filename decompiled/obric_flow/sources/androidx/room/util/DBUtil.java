package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.a;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"createCancellationSignal", "Landroid/os/CancellationSignal;", "dropFtsSyncTriggers", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "foreignKeyCheck", "tableName", "", "processForeignKeyCheckFailure", "cursor", "Landroid/database/Cursor;", "query", "Landroidx/room/RoomDatabase;", "sqLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "maybeCopy", "", "signal", "readVersion", "", "databaseFile", "Ljava/io/File;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "DBUtil")
public final class DBUtil {
    public static final CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "db");
        List r10 = CollectionsKt.createListBuilder();
        Cursor r11 = r5.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    L22:
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L4:
        if (r11.moveToNext() == false) goto L8;
        r10.add(r11.getString(0));     // Catch: Throwable -> L6
        goto L22
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        Iterator r13 = CollectionsKt.build(r10).iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        String r14 = (String) r13.next();
        if (StringsKt.P(r14, "room_fts_content_sync_") == false) goto L11;
        r5.execSQL("DROP TRIGGER IF EXISTS " + r14);
        goto L11
    }

    public static final void foreignKeyCheck(SupportSQLiteDatabase r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "db");
        Intrinsics.checkNotNullParameter(r10, "tableName");
        Cursor r11 = r5.query("PRAGMA foreign_key_check(`" + r10 + "`)");
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L4:
        if (r11.getCount() > 0) goto L11;
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r11, null);
        return;
    L11:
        throw new SQLiteConstraintException(processForeignKeyCheckFailure(r11));     // Catch: Throwable -> L8
    }

    private static final String processForeignKeyCheckFailure(Cursor r5) {
        StringBuilder r10 = new StringBuilder();
        int r11 = r5.getCount();
        LinkedHashMap r12 = new LinkedHashMap();
    L4:
        if (r5.moveToNext() == false) goto L11;
        if (r5.isFirst() == false) goto L8;
        r10.append("Foreign key violation(s) detected in '");
        r10.append(r5.getString(0));
        r10.append("'.\n");
    L8:
        String r13 = r5.getString(3);
        if (r12.containsKey(r13) == true) goto L4;
        r12.put(r13, r5.getString(2));
        goto L4
    L11:
        r10.append("Number of different violations discovered: ");
        r10.append(r12.keySet().size());
        r10.append("\nNumber of rows in violation: ");
        r10.append(r11);
        r10.append("\nViolation(s) detected in the following constraint(s):\n");
        Iterator r14 = r12.entrySet().iterator();
    L13:
        if (r14.hasNext() == false) goto L16;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = (String) r15.getKey();
        a.C(r10, "\tParent Table = ", (String) r15.getValue(), ", Foreign Key Constraint Index = ", r16);
        r10.append("\n");
        goto L13
    L16:
        return r10.toString();
    }

    @Deprecated(message = "This is only used in the generated code and shouldn't be called directly.")
    public static final Cursor query(RoomDatabase r5, SupportSQLiteQuery r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "db");
        Intrinsics.checkNotNullParameter(r10, "sqLiteQuery");
        return query(r5, r10, r11, null);
    }

    public static final int readVersion(File r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "databaseFile");
        FileChannel r11 = new FileInputStream(r10).getChannel();
        ByteBuffer r12 = ByteBuffer.allocate(4);     // Catch: Throwable -> L8
        r11.tryLock(60, 4, true);     // Catch: Throwable -> L8
        r11.position(60);     // Catch: Throwable -> L8
        if (r11.read(r12) != 4) goto L11;
        r12.rewind();     // Catch: Throwable -> L8
        int r5 = r12.getInt();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r11, null);
        return r5;
    L11:
        throw new IOException("Bad database header, unable to read 4 bytes at offset 60");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static final Cursor query(RoomDatabase r5, SupportSQLiteQuery r10, boolean r11, CancellationSignal r12) {
        Intrinsics.checkNotNullParameter(r5, "db");
        Intrinsics.checkNotNullParameter(r10, "sqLiteQuery");
        Cursor r13 = r5.query(r10, r12);
        if (r11 == true) goto L5;
        return r13;
    L5:
        if ((r13 instanceof AbstractWindowedCursor) == false) goto L14;
        AbstractWindowedCursor r14 = (AbstractWindowedCursor) r13;
        int r15 = r14.getCount();
        if (r14.hasWindow() == false) goto L9;
        int r16 = r14.getWindow().getNumRows();
    L10:
        if (r16 < r15) goto L12;
        return r13;
    L12:
        return CursorUtil.copyAndClose(r13);
    L9:
        r16 = r15;
        goto L10
    L14:
        return r13;
    }
}
