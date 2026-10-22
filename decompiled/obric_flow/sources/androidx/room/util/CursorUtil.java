package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.a;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a#\u0010\u0003\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001a/\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"copyAndClose", "Landroid/database/Cursor;", "c", "findColumnIndexBySuffix", "", "cursor", "name", "", "columnNames", "", "([Ljava/lang/String;Ljava/lang/String;)I", "getColumnIndex", "getColumnIndexOrThrow", "wrapMappedColumns", "mapping", "", "(Landroid/database/Cursor;[Ljava/lang/String;[I)Landroid/database/Cursor;", "useCursor", "R", "block", "Lkotlin/Function1;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "CursorUtil")
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor r10) {
        Intrinsics.checkNotNullParameter(r10, "c");
        MatrixCursor r5 = new MatrixCursor(r10.getColumnNames(), r10.getCount());     // Catch: Throwable -> L19
    L5:
        if (r10.moveToNext() == false) goto L30;
        Object[] r11 = new Object[r10.getColumnCount()];     // Catch: Throwable -> L19
        int r12 = r10.getColumnCount();     // Catch: Throwable -> L19
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L28;
        int r14 = r10.getType(r13);     // Catch: Throwable -> L19
        if (r14 != 0) goto L11;
        r11[r13] = null;     // Catch: Throwable -> L19
    L27:
        r13 = r13 + 1;     // Catch: Throwable -> L19
        goto L7
    L11:
        if (r14 != 1) goto L13;
        r11[r13] = Long.valueOf(r10.getLong(r13));     // Catch: Throwable -> L19
        goto L27
    L13:
        if (r14 != 2) goto L15;
        r11[r13] = Double.valueOf(r10.getDouble(r13));     // Catch: Throwable -> L19
        goto L27
    L15:
        if (r14 != 3) goto L17;
        r11[r13] = r10.getString(r13);     // Catch: Throwable -> L19
        goto L27
    L17:
        if (r14 != 4) goto L22;
        r11[r13] = r10.getBlob(r13);     // Catch: Throwable -> L19
        goto L27
    L22:
        throw new IllegalStateException();     // Catch: Throwable -> L19
    L28:
        r5.addRow(r11);     // Catch: Throwable -> L19
        goto L5
    L30:
        CloseableKt.closeFinally(r10, null);
        return r5;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private static final int findColumnIndexBySuffix(Cursor r5, String r10) {
        return -1;
    }

    public static final int getColumnIndex(Cursor r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "name");
        int r11 = r5.getColumnIndex(r10);
        if (r11 < 0) goto L5;
        return r11;
    L5:
        int r12 = r5.getColumnIndex("`" + r10 + '`');
        if (r12 < 0) goto L9;
        return r12;
    L9:
        return findColumnIndexBySuffix(r5, r10);
    }

    public static final int getColumnIndexOrThrow(Cursor r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "name");
        int r5 = getColumnIndex(r10, r11);
        if (r5 < 0) goto L11;
        return r5;
    L11:
        String r12 = ArraysKt.l(r10.getColumnNames(), null, null, null, null, 63);     // Catch: Exception -> L7
    L10:
        throw new IllegalArgumentException(a.p("column '", r11, "' does not exist. Available columns: ", r12));
    L7:
        e = move-exception;
        Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
        r12 = "unknown";
        goto L10
    }

    public static final <R> R useCursor(Cursor r5, Function1<? super Cursor, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "block");
        R r11 = r10.invoke(r5);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r5, null);
        InlineMarker.finallyEnd(1);
        return r11;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r5, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final Cursor wrapMappedColumns(final Cursor r5, final String[] r10, final int[] r11) {
        Intrinsics.checkNotNullParameter(r5, "cursor");
        Intrinsics.checkNotNullParameter(r10, "columnNames");
        Intrinsics.checkNotNullParameter(r11, "mapping");
        if (r10.length != r11.length) goto L7;
        return new AnonymousClass2(r5, r10, r11);
    L7:
        throw new IllegalStateException("Expected columnNames.length == mapping.length");
    }

    @VisibleForTesting(otherwise = 2)
    public static final int findColumnIndexBySuffix(String[] r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "columnNames");
        Intrinsics.checkNotNullParameter(r12, "name");
        String r5 = "." + r12;
        String r10 = androidx.room.jarjarred.org.antlr.runtime.a.p(".", '`', r12);
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L15;
        String r16 = r11[r14];
        int r17 = r15 + 1;
        if (r16.length() < (r12.length() + 2)) goto L14;
        if (StringsKt.k(r16, r5) == true) goto L8;
        if (r16.charAt(0) != '`') goto L14;
        if (StringsKt.k(r16, r10) == false) goto L14;
        return r15;
    L8:
        return r15;
    L14:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L15:
        return -1;
    }
}
