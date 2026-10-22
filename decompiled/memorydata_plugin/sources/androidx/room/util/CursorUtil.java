package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a#\u0010\u0003\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001a/\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"copyAndClose", "Landroid/database/Cursor;", "c", "findColumnIndexBySuffix", "", "cursor", ActivityLifecycle.NAME, "", "columnNames", "", "([Ljava/lang/String;Ljava/lang/String;)I", "getColumnIndex", "getColumnIndexOrThrow", "wrapMappedColumns", "mapping", "", "(Landroid/database/Cursor;[Ljava/lang/String;[I)Landroid/database/Cursor;", "useCursor", "R", "block", "Lkotlin/Function1;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor r15) {
        Cursor r16 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r15, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "c");
        if (Build.VERSION.SDK_INT <= 15) goto L63;
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r8 = (Cursor) ZeusTransformUtils.preCheckCast(r0, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        MatrixCursor r9 = new MatrixCursor(r8.getColumnNames(), r8.getCount());     // Catch: Throwable -> L27
    L7:
        if (r8.moveToNext() == false) goto L26;
        Object[] r10 = new Object[r8.getColumnCount()];     // Catch: Throwable -> L27
        int r11 = r16.getColumnCount();     // Catch: Throwable -> L27
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L24;
        int r13 = r8.getType(r12);     // Catch: Throwable -> L27
        if (r13 == 0) goto L22;
        if (r13 == 1) goto L21;
        if (r13 == 2) goto L20;
        if (r13 == 3) goto L19;
        if (r13 != 4) goto L18;
        r10[r12] = r8.getBlob(r12);     // Catch: Throwable -> L27
    L23:
        r12 = r12 + 1;     // Catch: Throwable -> L27
        goto L9
    L18:
        throw new IllegalStateException();     // Catch: Throwable -> L27
    L19:
        r10[r12] = r8.getString(r12);     // Catch: Throwable -> L27
        goto L23
    L20:
        r10[r12] = Double.valueOf(r8.getDouble(r12));     // Catch: Throwable -> L27
        goto L23
    L21:
        r10[r12] = Long.valueOf(r8.getLong(r12));     // Catch: Throwable -> L27
        goto L23
    L22:
        r10[r12] = null;     // Catch: Throwable -> L27
        goto L23
    L24:
        r9.addRow(r10);     // Catch: Throwable -> L27
        goto L7
    L26:
        CloseableKt.closeFinally(r0, null);
    L55:
        return (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin");
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    L63:
        r9 = new MatrixCursor(r16.getColumnNames(), r16.getCount());     // Catch: Throwable -> L56
    L34:
        if (r16.moveToNext() == false) goto L53;
        Object[] r1 = new Object[r16.getColumnCount()];     // Catch: Throwable -> L56
        int r14 = r16.getColumnCount();     // Catch: Throwable -> L56
        int r17 = 0;
    L36:
        if (r17 >= r14) goto L51;
        int r18 = r16.getType(r17);     // Catch: Throwable -> L56
        if (r18 == 0) goto L49;
        if (r18 == 1) goto L48;
        if (r18 == 2) goto L47;
        if (r18 == 3) goto L46;
        if (r18 != 4) goto L45;
        r1[r17] = r16.getBlob(r17);     // Catch: Throwable -> L56
    L50:
        r17 = r17 + 1;     // Catch: Throwable -> L56
        goto L36
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L56
    L46:
        r1[r17] = r16.getString(r17);     // Catch: Throwable -> L56
        goto L50
    L47:
        r1[r17] = Double.valueOf(r16.getDouble(r17));     // Catch: Throwable -> L56
        goto L50
    L48:
        r1[r17] = Long.valueOf(r16.getLong(r17));     // Catch: Throwable -> L56
        goto L50
    L49:
        r1[r17] = null;     // Catch: Throwable -> L56
        goto L50
    L51:
        r9.addRow(r1);     // Catch: Throwable -> L56
        goto L34
    L53:
        r16.close();
    L56:
        th = move-exception;
        r16.close();
        throw th;
    }

    private static final int findColumnIndexBySuffix(Cursor r4, String r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT <= 25) goto L6;
        return -1;
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return -1;
    L11:
        String[] r7 = r6.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(r7, "columnNames");
        return findColumnIndexBySuffix(r7, r5);
    L8:
        r0 = false;
        goto L9
    }

    public static final int findColumnIndexBySuffix(String[] r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "columnNames");
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        String r0 = '.' + r13;
        String r1 = '.' + r13 + '`';
        int r3 = r12.length;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= r3) goto L15;
        String r7 = r12[r5];
        int r8 = r6 + 1;
        if (r7.length() < (r13.length() + 2)) goto L14;
        if (StringsKt.endsWith$default(r7, r0, false, 2, null) == true) goto L8;
        if (r7.charAt(0) != '`') goto L14;
        if (StringsKt.endsWith$default(r7, r1, false, 2, null) == false) goto L14;
        return r6;
    L8:
        return r6;
    L14:
        r5 = r5 + 1;
        r6 = r8;
        goto L3
    L15:
        return -1;
    }

    public static final int getColumnIndex(Cursor r2, String r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "c");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        int r0 = r4.getColumnIndex(r3);
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r4.getColumnIndex('`' + r3 + '`');
        if (r1 < 0) goto L9;
        return r1;
    L9:
        return findColumnIndexBySuffix(r4, r3);
    }

    public static final int getColumnIndexOrThrow(Cursor r11, String r12) {
        Cursor r13 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r11, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "c");
        Intrinsics.checkNotNullParameter(r12, ActivityLifecycle.NAME);
        int r0 = getColumnIndex(r13, r12);
        if (r0 < 0) goto L11;
        return r0;
    L11:
        String[] r14 = r13.getColumnNames();     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r14, "c.columnNames");     // Catch: Exception -> L7
        String r15 = ArraysKt.joinToString$default((Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null);     // Catch: Exception -> L7
    L10:
        throw new IllegalArgumentException("column '" + r12 + "' does not exist. Available columns: " + r15);
    L7:
        e = move-exception;
        Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r15 = "unknown";
        goto L10
    }

    public static final <R> R useCursor(Cursor r4, Function1<? super Cursor, ? extends R> r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "block");
        if (Build.VERSION.SDK_INT <= 15) goto L19;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");
        R r9 = (R) r7.invoke(r8);
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r8, null);
        InlineMarker.finallyEnd(1);
        return r9;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r8, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L19:
        R r10 = (R) r7.invoke(r6);
        InlineMarker.finallyStart(1);
        r6.close();
        InlineMarker.finallyEnd(1);
        return r10;
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r6.close();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final Cursor wrapMappedColumns(Cursor r3, final String[] r4, final int[] r5) {
        final Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "cursor");
        Intrinsics.checkNotNullParameter(r4, "columnNames");
        Intrinsics.checkNotNullParameter(r5, "mapping");
        if (r4.length != r5.length) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return (Cursor) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r6, r4, r5), Cursor.class, "com.obric.memorydata.plugin");
    L10:
        throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
    L5:
        r0 = false;
        goto L6
    }
}
