package com.obric.memorydata.aikernelcore.bridge;

import android.database.Cursor;
import android.database.SQLException;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\"\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/DatabaseExecutor;", "", "<init>", "()V", "TAG", "", "ERROR_SUCCESS", "", "ERROR_FAILED", BuildConfig.CHANNEL, "Lcom/obric/memorydata/aikernelcore/bridge/SQLResult;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "timing", "Lcom/obric/memorydata/aikernelcore/bridge/SqlCallTiming;", "insert", "", ChatMessage.TYPE_QUERY, "parse", "", "Lcom/obric/memorydata/aikernelcore/bridge/SQLColumn;", "cursor", "Landroid/database/Cursor;", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8471a = null;

    static {
        f8471a = new c();
    }

    private c() {
    }

    private static final Unit a(Cursor r2, List r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    L4:
        if (r4.isAfterLast() == true) goto L10;
        List<d> r0 = f8471a.a(r4);
        if (r0 == null) goto L8;
        r5.add(r0);
    L8:
        r4.moveToNext();
        goto L4
    L10:
        return Unit.INSTANCE;
    }

    private static final Unit a(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).beginTransaction();
        return Unit.INSTANCE;
    }

    private static final Unit a(SupportSQLiteDatabase r2, String r3) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL(r3);
        return Unit.INSTANCE;
    }

    private static final Unit a(SupportSQLiteDatabase r3, Ref.LongRef r4) {
        Cursor r5 = ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("SELECT last_insert_rowid()", new Object[0]);
        if (r5.moveToFirst() == false) goto L5;
        r4.element = r5.getLong(0);
    L5:
        r5.close();
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.ObjectRef r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r2.element, Cursor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        r3.close();
        return Unit.INSTANCE;
    L5:
        return null;
    }

    private static final Unit b(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).setTransactionSuccessful();
        return Unit.INSTANCE;
    }

    private static final Unit b(SupportSQLiteDatabase r2, String r3) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL(r3);
        return Unit.INSTANCE;
    }

    private static final boolean b(Cursor r2) {
        return ((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin")).moveToFirst();
    }

    private static final Cursor c(SupportSQLiteDatabase r2, String r3) {
        return ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query(r3);
    }

    private static final Unit c(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).endTransaction();
        return Unit.INSTANCE;
    }

    private final long insert(SupportSQLiteDatabase r10, final String r11, f r12) {
        final SupportSQLiteDatabase r13 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r10, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        final Ref.LongRef r0 = new Ref.LongRef();
        r0.element = -1;
        r12.a("beginTxMs", new $$Lambda$c$hfI27TiHsDBTrcJKwm_2TJV7rG8(r13));     // Catch: Throwable -> L6 SQLException -> L8
        r12.a("executeMs", new $$Lambda$c$HaVpANVaWVA32Wd9qx4s2Ha7Fcg(r13, r11));     // Catch: Throwable -> L6 SQLException -> L8
        r12.a("insertIdMs", new $$Lambda$c$PqDNRQqPKKkTK4ox5gD4tfOrWnY(r13, r0));     // Catch: Throwable -> L6 SQLException -> L8
        r12.a("markTxMs", new $$Lambda$c$Tk4bgvW25oGQRKUysCqsfx4E1CY(r13));     // Catch: Throwable -> L6 SQLException -> L8
        Function0 r14 = new $$Lambda$c$i0z6Sn5GK_Ix9NgIwtHWIdYhrs0(r13);
    L5:
        r12.a("endTxMs", r14);
        return r0.element;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        if (AppContext.INSTANCE.isDebug() == false) goto L12;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DatabaseExecutor", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);     // Catch: Throwable -> L6
    L13:
        r14 = new $$Lambda$c$i0z6Sn5GK_Ix9NgIwtHWIdYhrs0(r13);
        goto L5
    L12:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DatabaseExecutor", String.valueOf(e.getMessage()), null, 4, null);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r12.a("endTxMs", new $$Lambda$c$i0z6Sn5GK_Ix9NgIwtHWIdYhrs0(r13));
        throw th;
    }

    public static /* synthetic */ boolean lambda$EqTe6mcFcN6aQ1TZ6GhGbhsJoas(Cursor r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$HaVpANVaWVA32Wd9qx4s2Ha7Fcg(SupportSQLiteDatabase r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ Unit lambda$PqDNRQqPKKkTK4ox5gD4tfOrWnY(SupportSQLiteDatabase r0, Ref.LongRef r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$Tk4bgvW25oGQRKUysCqsfx4E1CY(SupportSQLiteDatabase r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$UNuN4klF0lge_YiRK3CMac8tV54(Ref.ObjectRef r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$_brqo8KidWocXY4-u1KZtZebFxE, reason: not valid java name */
    public static /* synthetic */ Unit m468lambda$_brqo8KidWocXY4u1KZtZebFxE(Cursor r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$hfI27TiHsDBTrcJKwm_2TJV7rG8(SupportSQLiteDatabase r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$i0z6Sn5GK_Ix9NgIwtHWIdYhrs0(SupportSQLiteDatabase r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$tLa-RrZNk20SlGrldVEneOa9F9g, reason: not valid java name */
    public static /* synthetic */ Unit m469lambda$tLaRrZNk20SlGrldVEneOa9F9g(SupportSQLiteDatabase r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Cursor lambda$xhaBJ73K9AIEmu0uKtk0K9eQUKs(SupportSQLiteDatabase r0, String r1) {
        return c(r0, r1);
    }

    public final List<d> a(Cursor r15) {
        Cursor r14 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r15, Cursor.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L6;
        return null;
    L6:
        String[] r16 = r14.getColumnNames();
        List<d> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r17 = ArrayIteratorKt.iterator(r16);
    L8:
        if (r17.hasNext() == false) goto L26;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        int r2 = r14.getColumnIndex(r4);
        if (r2 == (-1)) goto L8;
        int r3 = r14.getType(r2);
        if (r3 == 1) goto L22;
        if (r3 == 2) goto L21;
        if (r3 != 3) goto L8;
        d r13 = new d(r4, 3, 0.0d, 0, r14.getString(r2), 12, null);     // Catch: JSONException -> L24
    L20:
        r1.add(r13);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DatabaseExecutor", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        goto L8
    L21:
        r13 = new d(r4, 2, r14.getDouble(r2), 0, null, 24, null);     // Catch: JSONException -> L24
        goto L20
    L22:
        r13 = new d(r4, 1, 0.0d, r14.getLong(r2), null, 20, null);     // Catch: JSONException -> L24
        goto L20
    L26:
        return r1;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [T, android.database.Cursor] */
    public final e query(SupportSQLiteDatabase r21, final String r22, f r23) {
        final SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r21, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r22, "sql");
        Intrinsics.checkNotNullParameter(r23, "timing");
        if (r3 == null) goto L5;
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        boolean r6 = true;
        StringBuilder r7 = new StringBuilder();
        final List r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        boolean r8 = false;
        final ?? r0 = (Cursor) ZeusTransformUtils.preCheckCast(r23.a("queryMs", new $$Lambda$c$xhaBJ73K9AIEmu0uKtk0K9eQUKs(r3, r22)), Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        r5.element = r0;     // Catch: Throwable -> L17
        r23.a("firstRowMs", new $$Lambda$c$EqTe6mcFcN6aQ1TZ6GhGbhsJoas(r0));     // Catch: Throwable -> L17
        r23.a("traverseMs", new $$Lambda$c$_brqo8KidWocXY4u1KZtZebFxE(r0, r13));     // Catch: Throwable -> L17
        r23.a("closeCursorMs", new $$Lambda$c$UNuN4klF0lge_YiRK3CMac8tV54(r5));     // Catch: Throwable -> L10
    L16:
        r8 = r6;
    L33:
        if (r8 == false) goto L35;
        e r1 = new e(true, 0, "", r13, null, 16, null);
    L36:
        return r1;
    L35:
        String r4 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        r1 = new e(false, -1, r4, null, null, 16, null);
    L10:
        th = move-exception;
        th.printStackTrace();
        if (AppContext.INSTANCE.isDebug() == false) goto L14;
        IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r16 = ExceptionsKt.stackTraceToString(th);
    L15:
        IRunLog.a.b(r14, "DatabaseExecutor", r16, null, 4, null);
        r7.append(th.toString());
        r6 = false;
        goto L16
    L14:
        r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r16 = String.valueOf(th.getMessage());
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L37
        if (AppContext.INSTANCE.isDebug() == false) goto L22;
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        String r17 = "DatabaseExecutor";
        String r18 = ExceptionsKt.stackTraceToString(th);     // Catch: Throwable -> L37
    L21:
        IRunLog.a.b(r15, r17, r18, null, 4, null);     // Catch: Throwable -> L37
        r7.append(th.toString());     // Catch: Throwable -> L37
        r23.a("closeCursorMs", new $$Lambda$c$UNuN4klF0lge_YiRK3CMac8tV54(r5));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        if (AppContext.INSTANCE.isDebug() == false) goto L30;
        IRunLog r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r110 = ExceptionsKt.stackTraceToString(th);
    L31:
        IRunLog.a.b(r19, "DatabaseExecutor", r110, null, 4, null);
        r7.append(th.toString());
        goto L33
    L30:
        r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r110 = String.valueOf(th.getMessage());
        goto L31
    L22:
        r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        r17 = "DatabaseExecutor";
        r18 = String.valueOf(th.getMessage());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r23.a("closeCursorMs", new $$Lambda$c$UNuN4klF0lge_YiRK3CMac8tV54(r5));     // Catch: Throwable -> L41
        throw th;
    L41:
        th = move-exception;
        th.printStackTrace();
        if (AppContext.INSTANCE.isDebug() == false) goto L45;
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r10 = ExceptionsKt.stackTraceToString(th);
    L46:
        IRunLog.a.b(r9, "DatabaseExecutor", r10, null, 4, null);
        r7.append(th.toString());
        throw th;
    L45:
        r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = String.valueOf(th.getMessage());
        goto L46
    L5:
        return new e(false, -1, "db is not exists", null, null, 16, null);
    }

    public final e update(SupportSQLiteDatabase r23, final String r24, f r25) {
        final SupportSQLiteDatabase r2 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r23, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r24, "sql");
        Intrinsics.checkNotNullParameter(r25, "timing");
        if (r2 == null) goto L5;
        StringBuilder r4 = new StringBuilder();
        boolean r5 = true;
    L16:
        th = move-exception;
        r5 = false;
        r4.append(th.toString());
        if (AppContext.INSTANCE.isDebug() == false) goto L20;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r8 = ExceptionsKt.stackTraceToString(th);
    L21:
        IRunLog.a.b(r6, "DatabaseExecutor", r8, null, 4, null);
    L23:
        if (r5 == false) goto L25;
        e r0 = new e(true, 0, "", null, null, 16, null);
    L26:
        return r0;
    L25:
        String r1 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        r0 = new e(false, -1, r1, null, null, 16, null);
        goto L26
    L20:
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r8 = String.valueOf(th.getMessage());
        goto L21
    L8:
        if (StringsKt.startsWith(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "INSERT", true) == false) goto L14;
        long r3 = insert(r2, r24, r25);     // Catch: Throwable -> L16
        if (r3 != (-1)) goto L13;
        return new e(false, -1, "insert failed return -1", null, null, 16, null);
    L13:
        return new e(true, 0, "success", null, Long.valueOf(r3));
    L14:
        r25.a("executeMs", new $$Lambda$c$tLaRrZNk20SlGrldVEneOa9F9g(r2, r24));     // Catch: Throwable -> L16
        goto L23
    L5:
        return new e(false, -1, "db is not exists", null, null, 16, null);
    }
}
