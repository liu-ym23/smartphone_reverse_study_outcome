package com.obric.memorydata.memory.contextsync;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.AtomicFile;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.n;
import com.obric.memorydata.middleware.api.logging.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationSync;", "", "<init>", "()V", "JOURNAL_DIRECTORY", "", "executionLock", "serialized", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "begin", "userId", "isRestoring", "", "restored", "token", "abortBeforeRestore", "prepareIfRequired", "firstBatchToken", "confirmFirstBatch", "currentUserId", "journal", "Lcom/obric/memorydata/memory/contextsync/MemoryContextMigrationJournal;", "journalForKnownUser", "fileLock", "writeJournal", "file", "Landroid/util/AtomicFile;", EventBody.KEY_VALUE, "trace", "", "message", "event", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f10096b = null;
    private static final Object c = null;

    static {
        f10095a = new c();
        f10096b = new Object();
        c = new Object();
    }

    private c() {
    }

    private static final void a(PersonalMemoryFrameDb r3) {
        r3.getMemoryContextSyncDao().clearPending();
        r3.getMemoryContextSyncDao().insertFullPending(System.currentTimeMillis());
        r3.getMemoryContextSyncDao().clearState();
    }

    private final void a(String r9, String r10, String r11) {
        o.a((o) ZeusTransformUtils.preCheckCast(n.f11627a, o.class, "com.obric.memorydata.plugin"), r9, r10, new com.obric.memorydata.middleware.api.logging.e("memory_context_sync", r11, null, 4, null), null, null, 24, null);
    }

    private final boolean a(AtomicFile r8, String r9) {
        Object r7 = c;
        monitor-enter(r7);
        FileOutputStream r0 = null;
        FileOutputStream r1 = r8.startWrite();     // Catch: Throwable -> L21 IOException -> L31
        byte[] r2 = r9.getBytes(Charsets.UTF_8);     // Catch: IOException -> L20 Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r2, "getBytes(...)");     // Catch: IOException -> L20 Throwable -> L21
        r1.write(r2);     // Catch: IOException -> L20 Throwable -> L21
        r1.getFD().sync();     // Catch: IOException -> L20 Throwable -> L21
        r8.finishWrite(r1);     // Catch: IOException -> L20 Throwable -> L21
        FileInputStream r3 = r8.openRead();     // Catch: Throwable -> L21 IOException -> L31
        Intrinsics.checkNotNullExpressionValue(r3, "openRead(...)");     // Catch: Throwable -> L21 IOException -> L31
        Reader r4 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21 IOException -> L31
        if (ZeusTransformUtils.instanceOf(r4, BufferedReader.class) == false) goto L10;
        BufferedReader r5 = (BufferedReader) ZeusTransformUtils.preCheckCast(r4, BufferedReader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21 IOException -> L31
    L11:
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21 IOException -> L31
        String r10 = TextStreamsKt.readText((Reader) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast(r6, BufferedReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L21 IOException -> L31
        boolean r11 = Intrinsics.areEqual(r10, r9);     // Catch: Throwable -> L21 IOException -> L31
    L27:
        monitor-exit(r7);
        return r11;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L21 IOException -> L31
        throw th;     // Catch: Throwable -> L21 IOException -> L31
    L10:
        r5 = new BufferedReader(r4, 8192);     // Catch: Throwable -> L21 IOException -> L31
    L20:
        r0 = r1;
    L21:
        th = move-exception;
        throw th;
    L23:
        if (r0 == null) goto L25;
        r8.failWrite(r0);     // Catch: Throwable -> L21
    L25:
        ((o) ZeusTransformUtils.preCheckCast(n.f11627a, o.class, "com.obric.memorydata.plugin")).a("context_journal_write_failed", "迁移同步进度落盘失败，保留重试", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());     // Catch: Throwable -> L21
        r11 = false;
        goto L27
    }

    private final String b() {
        String r5 = AppContext.INSTANCE.getUserId();
        if (AppContext.INSTANCE.isLogin() == false) goto L11;
        Long r0 = StringsKt.toLongOrNull(r5);
        if (r0 == null) goto L7;
        long r3 = r0.longValue();
    L9:
        if (r3 <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L16;
        return null;
    L16:
        return r5;
    L7:
        r3 = 0;
    L11:
        r1 = false;
        goto L12
    }

    private static final String b(AtomicFile r10, String r11) {
        Object r0 = c;
        monitor-enter(r0);
        FileInputStream r2 = r10.openRead();     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
        Intrinsics.checkNotNullExpressionValue(r2, "openRead(...)");     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
        Reader r3 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(r2, InputStream.class, "com.obric.memorydata.plugin"), Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
        if (ZeusTransformUtils.instanceOf(r3, BufferedReader.class) == false) goto L8;
        BufferedReader r4 = (BufferedReader) ZeusTransformUtils.preCheckCast(r3, BufferedReader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
    L9:
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
        String r6 = TextStreamsKt.readText((Reader) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast(r5, BufferedReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
    L52:
        monitor-exit(r0);
        return r6;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
        throw th;     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
    L8:
        r4 = new BufferedReader(r3, 8192);     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L21
    L18:
        th = move-exception;
        throw th;
    L21:
        File r7 = r10.getBaseFile().getParentFile();     // Catch: Throwable -> L18
        if (r7 == null) goto L24;
        File[] r8 = r7.listFiles();     // Catch: Throwable -> L18
    L25:
        boolean r9 = true;
        if (r8 == null) goto L42;
        int r12 = r8.length;     // Catch: Throwable -> L18
        int r13 = 0;
    L28:
        if (r13 >= r12) goto L39;
        File r14 = (File) ZeusTransformUtils.preCheckCast(r8[r13], File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r14.getName(), r11) == true) goto L35;
        String r15 = r14.getName();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r15, "getName(...)");     // Catch: Throwable -> L18
        if (StringsKt.startsWith$default(r15, r11 + '.', false, 2, null) == true) goto L35;
        boolean r16 = false;
    L36:
        if (r16 == true) goto L37;
        r13 = r13 + 1;     // Catch: Throwable -> L18
        goto L28
    L37:
        boolean r17 = false;
    L40:
        if (r17 == false) goto L42;
    L41:
        String r18 = "";
    L51:
        r6 = r18;
    L35:
        r16 = true;
        goto L36
    L39:
        r17 = true;
    L42:
        File r19 = r10.getBaseFile().getParentFile();     // Catch: Throwable -> L18
        if (r19 != null) goto L45;
    L47:
        r9 = false;
    L48:
        if (r9 == true) goto L41;
        r18 = "unreadable";
        goto L51
    L45:
        if (r19.exists() == true) goto L47;
    L24:
        r8 = null;
    L20:
        r6 = "unreadable";
        goto L52
    }

    private static final boolean c(AtomicFile r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return f10095a.a(r1, r2);
    }

    private final MemoryContextMigrationJournal d(String r2) {
        if (Intrinsics.areEqual(b(), r2) == true) goto L7;
        return null;
    L7:
        return e(r2);
    }

    private static final boolean d(String r3, String r4) {
        c r0 = f10095a;
        MemoryContextMigrationJournal r1 = r0.d(r3);
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.b(r4) == true) goto L9;
        return false;
    L9:
        return r0.b(r3);
    }

    private final MemoryContextMigrationJournal e(final String r6) {
        Long r5 = StringsKt.toLongOrNull(r6);
        if (r5 == null) goto L5;
        long r2 = r5.longValue();
    L7:
        if (r2 > 0) goto L10;
        return null;
    L10:
        final AtomicFile r7 = new AtomicFile(new File(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "memory_context_migration"), r6));
        return new MemoryContextMigrationJournal(new $$Lambda$c$GVoXchSWNbAczZA0jqz12PjorI(r7, r6), new $$Lambda$c$eOoSkkYvGR0jYAp5CreYN8LuxF4(r7));
    L5:
        r2 = 0;
        goto L7
    }

    private static final boolean e(String r2, String r3) {
        c r0 = f10095a;
        MemoryContextMigrationJournal r4 = r0.e(r2);
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.d(r3) == true) goto L8;
        return false;
    L8:
        r0.a("迁移在恢复前终止，Context 同步解除暂停", "context_sync_pause_aborted", r3);
        return true;
    }

    private static final String f(String r4) {
        c r0 = f10095a;
        MemoryContextMigrationJournal r5 = r0.d(r4);
        if (r5 != null) goto L5;
        return null;
    L5:
        String r2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        if (r5.a(r2) == true) goto L8;
        return null;
    L8:
        r0.a("迁移期间暂停 Context 同步", "context_sync_paused", r2);
        return r2;
    }

    /* JADX INFO: renamed from: lambda$GVoXchSWNbAczZ-A0jqz12PjorI, reason: not valid java name */
    public static /* synthetic */ String m691lambda$GVoXchSWNbAczZA0jqz12PjorI(AtomicFile r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$GaXL7pn_Lo3uTSjTQQs13Je3hXk(String r0, String r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ String lambda$QbfaTighgVcfOv38gGqgNjz0AT8(String r0) {
        return f(r0);
    }

    public static /* synthetic */ boolean lambda$eOoSkkYvGR0jYAp5CreYN8LuxF4(AtomicFile r0, String r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ boolean lambda$pCw_vVSrhGBkIRMtZZvLN1nUB9M(String r0, String r1) {
        return e(r0, r1);
    }

    public static /* synthetic */ void lambda$r1TkwyetZL0IpxRgJtiVZ1R_RdI(PersonalMemoryFrameDb r0) {
        a(r0);
    }

    public final <T> T a(Function0<? extends T> r2) {
        Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "block");
        Object r3 = f10096b;
        monitor-enter(r3);
        T r4 = (T) r1.invoke();
        monitor-exit(r3);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public final String a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return (String) ZeusTransformUtils.preCheckCast(a(new $$Lambda$c$QbfaTighgVcfOv38gGqgNjz0AT8(r2)), String.class, "com.obric.memorydata.plugin");
    }

    public final boolean a() {
        String r0 = b();
        if (r0 != null) goto L5;
        return false;
    L5:
        MemoryContextMigrationJournal r2 = d(r0);
        if (r2 == null) goto L10;
        MemoryContextMigrationJournal.a r3 = r2.a();
        if (r3 == null) goto L10;
        MemoryContextMigrationJournal.Phase r4 = r3.b();
    L12:
        if (r4 != MemoryContextMigrationJournal.Phase.RESTORING) goto L15;
        return true;
    L15:
        return false;
    L10:
        r4 = null;
        goto L12
    }

    public final boolean a(final String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "token");
        return ((Boolean) ZeusTransformUtils.preCheckCast(a(new $$Lambda$c$GaXL7pn_Lo3uTSjTQQs13Je3hXk(r2, r3)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        MemoryContextMigrationJournal r0 = d(r9);
        if (r0 != null) goto L5;
        return false;
    L5:
        MemoryContextMigrationJournal.a r2 = r0.a();
        if (r2 != null) goto L9;
        return true;
    L9:
        if (r2.b() != MemoryContextMigrationJournal.Phase.RESTORING) goto L12;
        return false;
    L12:
        if (r2.b() == MemoryContextMigrationJournal.Phase.PREPARING) goto L14;
        return true;
    L14:
        final PersonalMemoryFrameDb r4 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        r4.runInTransaction(new $$Lambda$c$r1TkwyetZL0IpxRgJtiVZ1R_RdI(r4));     // Catch: SQLiteException -> L24
        if (Intrinsics.areEqual(b(), r9) == true) goto L19;
    L23:
        return false;
    L19:
        if (r0.c(r2.a()) == false) goto L23;
        a("迁移后 Pending 已重建，等待首批 FULL", "context_pending_prepared", r2.a());
        return true;
    L24:
        ((o) ZeusTransformUtils.preCheckCast(n.f11627a, o.class, "com.obric.memorydata.plugin")).a("context_pending_rebuild_failed", "迁移后 Pending 重建失败，保留重试意图", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        return false;
    }

    public final boolean b(final String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "token");
        return ((Boolean) ZeusTransformUtils.preCheckCast(a(new $$Lambda$c$pCw_vVSrhGBkIRMtZZvLN1nUB9M(r2, r3)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final String c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        MemoryContextMigrationJournal r2 = d(r3);
        if (r2 == null) goto L16;
        MemoryContextMigrationJournal.a r4 = r2.a();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.b() != MemoryContextMigrationJournal.Phase.FIRST_BATCH) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r4 = null;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        return r4.a();
    L9:
        r0 = false;
        goto L10
    L16:
        return null;
    }

    public final boolean c(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "token");
        MemoryContextMigrationJournal r5 = d(r3);
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
        return false;
    L10:
        a("首批 FULL 已确认，后续使用增量续传", "context_full_confirmed", r4);
        return true;
    L5:
        if (r5.e(r4) != true) goto L7;
        r6 = true;
        goto L8
    }
}
