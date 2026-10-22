package com.obric.memorydata.memory.review.a;

import androidx.room.RoomDatabase;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.datatransport.api.d;
import com.obric.memorydata.datatransport.utils.i;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nJ\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/review/export/MemoryReviewFeedbackCsvExporter;", "", "<init>", "()V", "TAG", "", "EXPORT_DIR_PREFIX", "EXPORT_RETENTION_MILLIS", "", "EXPORT_TABLE_LIST", "", "exportCsvFiles", "scheduleExpiredExportCleanup", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10374a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f10375b = null;

    static {
        f10374a = new a();
        f10375b = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.datatransport.api.a.f9723a.c(), Collection.class, "com.obric.memorydata.plugin"), "RawAuditoryRecordingEntity"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }

    private static final void a(File r10, long r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L32
        File[] r12 = r10.listFiles();     // Catch: Throwable -> L32
        List r1 = null;
        int r2 = 0;
        if (r12 == null) goto L19;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        int r4 = r12.length;     // Catch: Throwable -> L32
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L18;
        File r6 = r12[r5];     // Catch: Throwable -> L32
        if (r6.isDirectory() == false) goto L14;
        String r7 = r6.getName();     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r7, "getName(...)");     // Catch: Throwable -> L32
        if (StringsKt.startsWith$default(r7, "memory_review_feedback_csv_", false, 2, null) == false) goto L14;
        if (r6.lastModified() >= r11) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        r3.add(r6);     // Catch: Throwable -> L32
    L17:
        r5 = r5 + 1;     // Catch: Throwable -> L32
    L14:
        r8 = false;
        goto L15
    L18:
        r1 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
    L19:
        if (r1 != null) goto L21;
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L32
    L21:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L32
    L23:
        if (r13.hasNext() == false) goto L28;
        File r14 = (File) ZeusTransformUtils.preCheckCast(r13.next(), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L32
        if (FilesKt.deleteRecursively(r14) == true) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewFeedbackCsvExporter", "delete expired export directory failed: " + r14.getName(), null, 4, null);     // Catch: Throwable -> L32
        goto L23
    L26:
        r2 = r2 + 1;     // Catch: Throwable -> L32
        goto L23
    L28:
        if (r2 <= 0) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewFeedbackCsvExporter", "deleted expired memory review export directories count=" + r2, false, 4, null);     // Catch: Throwable -> L32
    L30:
        Object r15 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L49;
        RunLog.INSTANCE.error("MemoryReviewFeedbackCsvExporter", "cleanup expired memory review export directories failed", r16);
        return;
    L49:
        return;
    L32:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    private final void b() {
        final File r4 = d.f9726a.c();
        final long r0 = System.currentTimeMillis() - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        ThreadPoolContainer.Companion.execute(new $$Lambda$a$wzZ_OW5gvdtmQAQKw6ecyWrdQ4I(r4, r0));
    }

    public static /* synthetic */ void lambda$wzZ_OW5gvdtmQAQKw6ecyWrdQ4I(File r0, long r1) {
        a(r0, r1);
    }

    public final List<String> a() {
        b();
        File r7 = new File(d.f9726a.c(), "memory_review_feedback_csv_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()));
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(i.a(i.f9844a, (RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.datatransport.api.a.f9723a.a(), Collection.class, "com.obric.memorydata.plugin"), r7, false, 8, null), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(i.f9844a.a((RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.datatransport.api.a.f9723a.b(), Collection.class, "com.obric.memorydata.plugin"), r7, false), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r0.add(((File) ZeusTransformUtils.preCheckCast(r10.next(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath());
        goto L4
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewFeedbackCsvExporter", "export memory review csv files count=" + ((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin")).size() + ", dir=" + r7.getAbsolutePath(), false, 4, null);
        return CollectionsKt.listOf(r7.getAbsolutePath());
    }
}
