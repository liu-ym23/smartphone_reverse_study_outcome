package com.obric.memorydata.datatransport.utils;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0002J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomTableCsvExporter;", "", "<init>", "()V", "TAG", "", "exportTables", "", "Ljava/io/File;", "roomDb", "Landroidx/room/RoomDatabase;", "tableNames", "", "targetDir", "clearTargetDir", "", "exportTable", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "queryTableColumns", "cursorValue", "cursor", "Landroid/database/Cursor;", "index", "", "appendCsvLine", "", "Ljava/io/BufferedWriter;", "values", "csvEscape", "raw", "quoteIdentifier", ActivityLifecycle.NAME, "safeFileName", "clearCsvFiles", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f9844a = null;

    static {
        f9844a = new i();
    }

    private i() {
    }

    private final File a(SupportSQLiteDatabase r11, String r12, File r13) {
        SupportSQLiteDatabase r14 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<String> r0 = a(r14, r12);
        if (r0.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomTableCsvExporter", "skip missing or empty-schema table: " + r12, null, 4, null);
        return null;
    L6:
        File r2 = new File(r13, c(r12) + ".csv");
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedWriter((Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2), OutputStream.class, "com.obric.memorydata.plugin"), StandardCharsets.UTF_8), Writer.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        BufferedWriter r15 = (BufferedWriter) ZeusTransformUtils.preCheckCast(r10, BufferedWriter.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        i r4 = f9844a;     // Catch: Throwable -> L25
        r4.a(r15, r0);     // Catch: Throwable -> L25
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r14.query("SELECT * FROM " + r4.b(r12)), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r16, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
    L10:
        if (r5.moveToNext() == false) goto L16;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Iterator r8 = r6.iterator();     // Catch: Throwable -> L20
    L13:
        if (r8.hasNext() == false) goto L15;
        r7.add(f9844a.a(r5, ((IntIterator) ZeusTransformUtils.preCheckCast(r8, IntIterator.class, "com.obric.memorydata.plugin")).nextInt()));     // Catch: Throwable -> L20
        goto L13
    L15:
        f9844a.a(r15, (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        goto L10
    L16:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L25
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r10, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomTableCsvExporter", "export table " + r12 + " to " + r2.getAbsolutePath(), false, 4, null);
        return r2;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private final String a(Cursor r3, int r4) {
        Cursor r2 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        int r5 = r2.getType(r4);
        if (r5 != 0) goto L5;
        return "";
    L5:
        if (r5 == 1) goto L26;
        if (r5 == 2) goto L30;
        if (r5 != 3) goto L11;
        String r6 = r2.getString(r4);
        if (r6 != null) goto L29;
        return "";
    L29:
        return r6;
    L11:
        if (r5 == 4) goto L15;
        r6 = r2.getString(r4);
        if (r6 != null) goto L29;
        return "";
    L15:
        StringBuilder r7 = new StringBuilder().append("[BLOB ");
        byte[] r8 = r2.getBlob(r4);
        if (r8 == null) goto L18;
        int r9 = r8.length;
    L28:
        return r7.append(r9).append(" bytes]").toString();
    L18:
        r9 = 0;
        goto L28
    L30:
        return String.valueOf(r2.getDouble(r4));
    L26:
        return String.valueOf(r2.getLong(r4));
    }

    private final String a(String r11) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r1 >= r10.length()) goto L18;
        char r2 = r10.charAt(r1);
        if (r2 == ',') goto L14;
        if (r2 == '\"') goto L14;
        if (r2 == '\n') goto L14;
        if (r2 == '\r') goto L14;
        boolean r3 = false;
    L15:
        if (r3 == true) goto L16;
        r1 = r1 + 1;
        goto L4
    L16:
        r0 = true;
    L14:
        r3 = true;
    L18:
        if (r0 == true) goto L21;
        return r11;
    L21:
        return Typography.quote + StringsKt.replace$default(r11, "\"", "\"\"", false, 4, null) + Typography.quote;
    }

    private final List<String> a(SupportSQLiteDatabase r5, String r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r7.query("PRAGMA table_info(" + b(r6) + ')'), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r8 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        int r9 = r8.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L10
    L5:
        if (r8.moveToNext() == false) goto L7;
        String r1 = r8.getString(r9);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");     // Catch: Throwable -> L10
        r0.add(r1);     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r4, null);
        return r0;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    public static /* synthetic */ List a(i r1, RoomDatabase r2, Collection r3, File r4, boolean r5, int r6, Object r7) {
        Collection<String> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L6;
        r5 = true;
    L6:
        return r1.a(r2, r8, r4, r5);
    }

    private final void a(BufferedWriter r11, List<String> r12) {
        r11.append((CharSequence) ZeusTransformUtils.preCheckCast(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$i$ep1Sd0eZGP2D8FSQulApGm9cn1o.INSTANCE, 30, null), CharSequence.class, "com.obric.memorydata.plugin"));
        r11.append('\n');
    }

    private final void a(File r4) {
        File[] r3 = r4.listFiles($$Lambda$i$F5ScNfBYWE1dhQjqIvbScMD8sQc.INSTANCE);
        if (r3 == null) goto L12;
        int r5 = 0;
        int r0 = r3.length;
    L5:
        if (r5 >= r0) goto L18;
        File r1 = r3[r5];
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        Result.m1421constructorimpl(Boolean.valueOf(r1.delete()));     // Catch: Throwable -> L9
    L11:
        r5 = r5 + 1;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    L18:
        return;
    }

    private final String b(String r8) {
        return '`' + StringsKt.replace$default(r8, "`", "``", false, 4, null) + '`';
    }

    private static final boolean b(File r2) {
        if (r2.isFile() == false) goto L7;
        String r3 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "getName(...)");
        if (StringsKt.endsWith(r3, ".csv", true) == false) goto L7;
        return true;
    L7:
        return false;
    }

    private final String c(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return new Regex("[^A-Za-z0-9._-]").replace(r1, "_");
    }

    private static final CharSequence d(String r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        return (CharSequence) ZeusTransformUtils.preCheckCast(f9844a.a(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ boolean lambda$F5ScNfBYWE1dhQjqIvbScMD8sQc(File r0) {
        return b(r0);
    }

    public static /* synthetic */ CharSequence lambda$ep1Sd0eZGP2D8FSQulApGm9cn1o(String r0) {
        return d(r0);
    }

    public final List<File> a(RoomDatabase r11, Collection<String> r12, File r13, boolean r14) {
        Collection r15 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "roomDb");
        Intrinsics.checkNotNullParameter(r15, "tableNames");
        Intrinsics.checkNotNullParameter(r13, "targetDir");
        if (r13.exists() == false) goto L5;
    L9:
        if (r14 == false) goto L11;
        a(r13);
    L11:
        SupportSQLiteDatabase r10 = r11.getOpenHelper().getReadableDatabase();
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L13:
        if (r18.hasNext() == false) goto L29;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin");
        i r0 = f9844a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        Object r1 = Result.m1421constructorimpl(r0.a(r10, r19, r13));     // Catch: Throwable -> L17
    L19:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r1);
        if (r3 == null) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomTableCsvExporter", "export table " + r19 + " failed: " + r3.getMessage(), null, 4, null);
    L23:
        if (Result.m1427isFailureimpl(r1) == false) goto L25;
        r1 = null;
    L25:
        File r110 = (File) ZeusTransformUtils.preCheckCast(r1, File.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L13;
        r17.add(r110);
    L17:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    L29:
        return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    L5:
        if (r13.mkdirs() == true) goto L9;
        throw new IllegalStateException("create csv export dir failed: " + r13.getAbsolutePath());
    }
}
