package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "CursorUtil")
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor r12) {
        Intrinsics.checkNotNullParameter(r12, "c");
        if (Build.VERSION.SDK_INT > 15) goto L59;
        MatrixCursor r10 = new MatrixCursor(r12.getColumnNames(), r12.getCount());     // Catch: Throwable -> L54
    L33:
        if (r12.moveToNext() == false) goto L52;
        Object[] r11 = new Object[r12.getColumnCount()];     // Catch: Throwable -> L54
        int r13 = r12.getColumnCount();     // Catch: Throwable -> L54
        int r14 = 0;
    L35:
        if (r14 >= r13) goto L50;
        int r15 = r12.getType(r14);     // Catch: Throwable -> L54
        if (r15 == 0) goto L48;
        if (r15 == 1) goto L47;
        if (r15 == 2) goto L46;
        if (r15 == 3) goto L45;
        if (r15 != 4) goto L44;
        r11[r14] = r12.getBlob(r14);     // Catch: Throwable -> L54
    L49:
        r14 = r14 + 1;     // Catch: Throwable -> L54
        goto L35
    L44:
        throw new IllegalStateException();     // Catch: Throwable -> L54
    L45:
        r11[r14] = r12.getString(r14);     // Catch: Throwable -> L54
        goto L49
    L46:
        r11[r14] = Double.valueOf(r12.getDouble(r14));     // Catch: Throwable -> L54
        goto L49
    L47:
        r11[r14] = Long.valueOf(r12.getLong(r14));     // Catch: Throwable -> L54
        goto L49
    L48:
        r11[r14] = null;     // Catch: Throwable -> L54
        goto L49
    L50:
        r10.addRow(r11);     // Catch: Throwable -> L54
        goto L33
    L52:
        r12.close();
    L53:
        return r10;
    L54:
        th = move-exception;
        r12.close();
        throw th;
    L59:
        r10 = new MatrixCursor(r12.getColumnNames(), r12.getCount());     // Catch: Throwable -> L26
    L6:
        if (r12.moveToNext() == false) goto L25;
        Object[] r16 = new Object[r12.getColumnCount()];     // Catch: Throwable -> L26
        int r17 = r12.getColumnCount();     // Catch: Throwable -> L26
        int r18 = 0;
    L8:
        if (r18 >= r17) goto L23;
        int r19 = r12.getType(r18);     // Catch: Throwable -> L26
        if (r19 == 0) goto L21;
        if (r19 == 1) goto L20;
        if (r19 == 2) goto L19;
        if (r19 == 3) goto L18;
        if (r19 != 4) goto L17;
        r16[r18] = r12.getBlob(r18);     // Catch: Throwable -> L26
    L22:
        r18 = r18 + 1;     // Catch: Throwable -> L26
        goto L8
    L17:
        throw new IllegalStateException();     // Catch: Throwable -> L26
    L18:
        r16[r18] = r12.getString(r18);     // Catch: Throwable -> L26
        goto L22
    L19:
        r16[r18] = Double.valueOf(r12.getDouble(r18));     // Catch: Throwable -> L26
        goto L22
    L20:
        r16[r18] = Long.valueOf(r12.getLong(r18));     // Catch: Throwable -> L26
        goto L22
    L21:
        r16[r18] = null;     // Catch: Throwable -> L26
        goto L22
    L23:
        r10.addRow(r16);     // Catch: Throwable -> L26
        goto L6
    L25:
        CloseableKt.closeFinally(r12, null);
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    private static final int findColumnIndexBySuffix(Cursor r10, String r11) {
        if (Build.VERSION.SDK_INT <= 25) goto L6;
        return -1;
    L6:
        if (r11.length() != 0) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        return -1;
    L11:
        String[] r13 = r10.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(r13, "columnNames");
        return findColumnIndexBySuffix(r13, r11);
    L8:
        r12 = false;
        goto L9
    }

    @VisibleForTesting(otherwise = 2)
    public static final int findColumnIndexBySuffix(String[] r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "columnNames");
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        String r10 = '.' + r13;
        String r11 = '.' + r13 + '`';
        int r14 = r12.length;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r14) goto L15;
        String r17 = r12[r15];
        int r18 = r16 + 1;
        if (r17.length() < (r13.length() + 2)) goto L14;
        if (StringsKt.endsWith$default(r17, r10, false, 2, null) == true) goto L8;
        if (r17.charAt(0) != '`') goto L14;
        if (StringsKt.endsWith$default(r17, r11, false, 2, null) == false) goto L14;
        return r16;
    L8:
        return r16;
    L14:
        r15 = r15 + 1;
        r16 = r18;
        goto L3
    L15:
        return -1;
    }

    public static final int getColumnIndex(Cursor r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        int r12 = r10.getColumnIndex(r11);
        if (r12 < 0) goto L5;
        return r12;
    L5:
        int r13 = r10.getColumnIndex('`' + r11 + '`');
        if (r13 < 0) goto L9;
        return r13;
    L9:
        return findColumnIndexBySuffix(r10, r11);
    }

    public static final int getColumnIndexOrThrow(Cursor r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        int r12 = getColumnIndex(r10, r11);
        if (r12 < 0) goto L11;
        return r12;
    L11:
        String[] r13 = r10.getColumnNames();     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r13, "c.columnNames");     // Catch: Exception -> L7
        String r14 = ArraysKt.joinToString$default(r13, null, null, null, 0, null, null, 63, null);     // Catch: Exception -> L7
    L10:
        throw new IllegalArgumentException("column '" + r11 + "' does not exist. Available columns: " + r14);
    L7:
        e = move-exception;
        Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
        r14 = "unknown";
        goto L10
    }

    public static final <R> R useCursor(Cursor r10, Function1<? super Cursor, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        if (Build.VERSION.SDK_INT > 15) goto L19;
        R r12 = r11.invoke(r10);     // Catch: Throwable -> L16
        InlineMarker.finallyStart(1);
        r10.close();
        InlineMarker.finallyEnd(1);
        return r12;
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.close();
        InlineMarker.finallyEnd(1);
        throw th;
    L19:
        R r13 = r11.invoke(r10);     // Catch: Throwable -> L8
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r10, null);
        InlineMarker.finallyEnd(1);
        return r13;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r10, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final Cursor wrapMappedColumns(final Cursor r10, final String[] r11, final int[] r12) {
        Intrinsics.checkNotNullParameter(r10, "cursor");
        Intrinsics.checkNotNullParameter(r11, "columnNames");
        Intrinsics.checkNotNullParameter(r12, "mapping");
        if (r11.length != r12.length) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        return new AnonymousClass2(r10, r11, r12);
    L10:
        throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
    L5:
        r13 = false;
        goto L6
    }
}
