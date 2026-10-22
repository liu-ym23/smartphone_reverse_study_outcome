package com.obric.memorydata.memory.inapptrace;

import android.content.Context;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.dao.InAppTraceUploadDao;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.cc;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.review.provider.bb;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0018J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ'\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u0007H\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020#0'2\b\b\u0002\u0010(\u001a\u00020\nH\u0000¢\u0006\u0002\b)J\r\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b,J\r\u0010-\u001a\u00020+H\u0000¢\u0006\u0002\b.J\r\u0010/\u001a\u00020\nH\u0000¢\u0006\u0002\b0J\u0010\u00101\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J.\u00102\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u0014H\u0002J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020#0'2\f\u00107\u001a\b\u0012\u0004\u0012\u00020#0'H\u0002J\f\u00108\u001a\u00020\u0014*\u00020#H\u0002J\u0016\u00109\u001a\u00020\u00142\f\u00107\u001a\b\u0012\u0004\u0012\u00020#0'H\u0002J$\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u0005H\u0002J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J \u0010=\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0002J \u0010@\u001a\u00020%2\u0006\u0010\"\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J@\u0010C\u001a\u00020%2\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020\n2\b\b\u0002\u0010F\u001a\u00020\u00072\b\b\u0002\u0010G\u001a\u00020\u0005H\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0002J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010J\u001a\u00020IH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006L"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceUploadRepository;", "", "<init>", "()V", "TAG", "", "CLAIM_LEASE_MS", "", "MAX_RETRY_DELAY_MS", "QUEUE_PROCESS_LIMIT", "", "SCREENSHOT_TRACE_LOOKBACK_MS", "SCREENSHOT_TRACE_LOOKAHEAD_MS", "MAX_FLUSH_WATERMARK_LOOKAHEAD_MS", "TRACE_FILE_RETENTION_MS", "dao", "Lcom/obric/memorydata/database/dao/InAppTraceUploadDao;", "getDao", "()Lcom/obric/memorydata/database/dao/InAppTraceUploadDao;", "enqueue", "", "completed", "Lcom/obric/memorydata/memory/inapptrace/CompletedTraceZip;", "enqueueForDebug", "enqueueForDebug$memory_obricRelease", "initialState", "processRunnable", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceUploadRunResult;", "associateWithObservation", "observationId", "screenshotTimestamp", "associationEndTimestamp", "associateWithObservation$memory_obricRelease", "bindLateTraceToScreenshot", "row", "Lcom/obric/memorydata/database/entity/InAppTraceUploadEntity;", "cleanupExpiredTraceFiles", "", "queryRecentForDebug", "", "limit", "queryRecentForDebug$memory_obricRelease", "uploadNextForDebug", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceDebugStepResult;", "uploadNextForDebug$memory_obricRelease", "reportNextForDebug", "reportNextForDebug$memory_obricRelease", "clearDebugRows", "clearDebugRows$memory_obricRelease", "processRow", "uploadTos", "successState", "failureState", "enqueueNext", "selectReportRows", "rows", "isReportCandidate", "reportBatch", "reportUri", "Lcom/obric/memorydata/memory/review/trace/InAppTraceReportResult;", "deleteAgedFile", "claim", "state", "now", "fail", "fallbackState", "message", BuildConfig.CHANNEL, "tosUri", "retryCount", "nextRetryAt", "lastError", "keepDebugCopy", "Ljava/io/File;", "file", "sha256", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10176a = null;

    static {
        f10176a = new i();
    }

    private i() {
    }

    public static /* synthetic */ int a(i r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = 2000 + r10;
    L6:
        return r7.a(r8, r10, r12);
    }

    private final long a(cc r22) {
        if (Intrinsics.areEqual(r22.j(), "WAIT_OBSERVATION") == false) goto L5;
        List<RawObservationEntity> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().queryScreenshotsInWindow(r22.e() - 2000, r22.f() + 10000);
        e r1 = e.f10167a;
        long r2 = r22.e();
        long r4 = r22.f();
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r7.add(Long.valueOf(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r8.next(), RawObservationEntity.class, "com.obric.memorydata.plugin")).getTimestamp()));
        goto L8
    L10:
        HashSet r3 = CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast(r1.a(r2, r4, (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), 10000, 2000), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r5.iterator();
    L12:
        if (r10.hasNext() == false) goto L16;
        Object r11 = r10.next();
        if (r3.contains(Long.valueOf(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r11, RawObservationEntity.class, "com.obric.memorydata.plugin")).getTimestamp())) == false) goto L12;
        r9.add(r11);
        goto L12
    L16:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        if (r12.isEmpty() == false) goto L20;
        return 0;
    L20:
        long r13 = System.currentTimeMillis();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r15 = 0;
    L22:
        if (r14.hasNext() == false) goto L25;
        RawObservationEntity r16 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r14.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        int r17 = f10176a.b().linkToObservation(CollectionsKt.listOf(Long.valueOf(r22.a())), r16.getId(), r13);
        b.f10159a.a(r16.getId(), r22);
        r15 = r15 + r17;
        goto L22
    L25:
        if (r15 <= 0) goto L28;
        RunLog.INSTANCE.info("InAppTraceUploadRepo", "late trace associated observationIds=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$i$8SNM0lqCERzfr_uI1PqGGHqTag.INSTANCE, 31, null) + " traceRowId=" + r22.a() + " traceRange=" + r22.e() + ".." + r22.f() + " screenshotTimestamps=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$i$vQGZnpNz8LEBpAC_bEvwO9lu3ME.INSTANCE, 31, null), true);
        k.f10179a.a();
    L28:
        return ((RawObservationEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r12), RawObservationEntity.class, "com.obric.memorydata.plugin")).getId();
    L5:
        return r22.r();
    }

    private final File a(File r8) {
        File r7 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "in_app_trace/debug_archive");
        if (r7.exists() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        File r1 = new File(r7, r8.getName());
        FilesKt.copyTo$default(r8, r1, true, 0, 4, null);
        return r1;
    L13:
        throw new IllegalStateException("create trace debug dir failed".toString());
    L5:
        if (r7.mkdirs() == true) goto L8;
        r0 = false;
        goto L9
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(RawObservationEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2.getId()), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final List<cc> a(List<cc> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Object r2 = r8.next();
        r1.put(Long.valueOf(((cc) ZeusTransformUtils.preCheckCast(r2, cc.class, "com.obric.memorydata.plugin")).a()), r2);
        goto L4
    L6:
        List<h> r9 = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$i$1u60Go2WGiuULc2fAwPl0PFCTg.INSTANCE), $$Lambda$i$MtKfF9nCaq6DLK2aDKyGezzQRfs.INSTANCE));
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(g.f10173a.a(r9), Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        cc r3 = (cc) ZeusTransformUtils.preCheckCast(r1.get(Long.valueOf(((h) ZeusTransformUtils.preCheckCast(r12.next(), h.class, "com.obric.memorydata.plugin")).a())), cc.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        r11.add(r3);
        goto L8
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
    }

    private final void a(cc r10, String r11, String r12) {
        int r0 = r10.l() + 1;
        update(r10, r11, r10.k(), r0, System.currentTimeMillis() + Math.min(21600000, 30000 << Math.min(r0 - 1, 10)), StringsKt.take(r12, 1000));
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceUploadRepo", "trace queue step failed id=" + r10.a() + " state=" + r11 + " retry=" + r0 + " error=" + r12, null, 4, null);
    }

    static /* synthetic */ void a(i r9, cc r10, String r11, String r12, int r13, long r14, String r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        String r4 = r10.k();
    L7:
        if ((r17 & 8) == 0) goto L9;
        int r5 = r10.l();
    L11:
        if ((r17 & 16) == 0) goto L13;
        long r6 = 0;
    L15:
        if ((r17 & 32) == 0) goto L17;
        String r8 = "";
    L18:
        r9.update(r10, r11, r4, r5, r6, r8);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    private final boolean a(cc r12, String r13, long r14) {
        if (b().claim(r12.a(), r12.j(), r12.p(), r13, r14 + 300000, r14) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean a(cc r14, String r15, String r16, boolean r17) {
        File r0 = new File(r14.d());
        if (r0.isFile() == true) goto L7;
        a(r14, r16, "zip missing: " + r14.d());
        return false;
    L7:
        if (a(r14, "TOS_UPLOADING", System.currentTimeMillis()) == true) goto L9;
        return true;
    L9:
        String r4 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L12
        i r7 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Object r1 = Result.m1421constructorimpl((com.obric.memorydata.middleware.impl.image.d) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new InAppTraceUploadRepository$uploadTos$uploadResult$1$1(r0, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), com.obric.memorydata.middleware.impl.image.d.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
    L14:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r1);
        if (r8 == null) goto L18;
        RunLog.INSTANCE.error("InAppTraceUploadRepo", "TOS upload failed safely id=" + r14.a(), r8);
    L18:
        if (Result.m1427isFailureimpl(r1) == false) goto L20;
        r1 = null;
    L20:
        com.obric.memorydata.middleware.impl.image.d r2 = (com.obric.memorydata.middleware.impl.image.d) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.middleware.impl.image.d.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L23;
        String r9 = r2.a();
    L24:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L27;
    L30:
        boolean r11 = true;
    L31:
        if (r11 == false) goto L42;
        if (r2 == null) goto L39;
        String r3 = r2.c();
        if (r3 == null) goto L39;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L38;
        r4 = r3;
    L38:
        if (r4 == null) goto L39;
    L40:
        a(r14, r16, r4);
        return false;
    L39:
        r4 = "TOS upload returned empty URI";
        goto L40
    L42:
        a(this, r14, r15, r9, 0, 0, null, 48, null);
        if (r14.r() <= 0) goto L45;
        bb.f10440a.a();
    L45:
        if (r17 == false) goto L47;
        k.f10179a.a();
    L47:
        return true;
    L27:
        if (StringsKt.isBlank(r10) == true) goto L30;
        r11 = false;
        goto L31
    L23:
        r9 = null;
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final boolean a(a r68, String r69) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L35
        i r5 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        long r28 = System.currentTimeMillis();     // Catch: Throwable -> L35
        String r36 = null;
        if (b.f10159a.a() == true) goto L45;
        File r1 = null;
    L18:
        String r9 = UUID.randomUUID().toString();     // Catch: Throwable -> L35
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");     // Catch: Throwable -> L35
        String r10 = r68.b();     // Catch: Throwable -> L35
        String r11 = r68.a().getAbsolutePath();     // Catch: Throwable -> L35
        Intrinsics.checkNotNullExpressionValue(r11, "getAbsolutePath(...)");     // Catch: Throwable -> L35
        cc r14 = new cc(0, r9, r10, r11, r68.c(), r68.d(), r68.e(), r68.a().length(), r5.b(r68.a()), r69, null, 0, 0, null, r28, r28, 0, 0, 211969, null);     // Catch: Throwable -> L35
        long r6 = r5.b().insert(r14);     // Catch: Throwable -> L35
        long r8 = 0;
        if (r6 <= 0) goto L21;
        cc r2 = cc.a(r14, r6, null, null, null, 0, 0, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 0, 262142, null);     // Catch: Throwable -> L35
    L22:
        if (r2 == null) goto L24;
        r8 = r5.a(r2);     // Catch: Throwable -> L35
    L24:
        RunLog r4 = RunLog.INSTANCE;     // Catch: Throwable -> L35
        StringBuilder r7 = new StringBuilder().append("trace zip pending row=").append(r6).append(" file=").append(r68.a().getName()).append(" events=").append(r68.e()).append(" range=").append(r68.c()).append("..").append(r68.d()).append(" observationId=").append(r8).append(" debugCopy=");     // Catch: Throwable -> L35
        if (r1 == null) goto L27;
        r36 = r1.getAbsolutePath();     // Catch: Throwable -> L35
    L27:
        if (r36 != null) goto L29;
        r36 = "";
    L29:
        String r3 = r7.append(r36).toString();     // Catch: Throwable -> L35
        boolean r12 = true;
        r4.info("InAppTraceUploadRepo", r3, true);     // Catch: Throwable -> L35
        if (r2 != null) goto L33;
        r12 = false;
    L33:
        Object r13 = Result.m1421constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L35
    L37:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r13);
        if (r15 == null) goto L41;
        RunLog.INSTANCE.error("InAppTraceUploadRepo", "enqueue trace zip failed file=" + r68.a().getName(), r15);
    L41:
        if (Result.m1427isFailureimpl(r13) == false) goto L44;
        r13 = false;
    L44:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L21:
        InAppTraceUploadDao r16 = r5.b();     // Catch: Throwable -> L35
        String r17 = r68.a().getAbsolutePath();     // Catch: Throwable -> L35
        Intrinsics.checkNotNullExpressionValue(r17, "getAbsolutePath(...)");     // Catch: Throwable -> L35
        r2 = r16.queryByLocalPath(r17);     // Catch: Throwable -> L35
        goto L22
    L45:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L8
        Object r19 = Result.m1421constructorimpl(r5.a(r68.a()));     // Catch: Throwable -> L8
    L10:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r19);     // Catch: Throwable -> L35
        if (r20 == null) goto L14;
        RunLog.INSTANCE.error("InAppTraceUploadRepo", "keep debug trace copy failed file=" + r68.a().getName(), r20);     // Catch: Throwable -> L35
    L14:
        if (Result.m1427isFailureimpl(r19) == false) goto L16;
        r19 = null;
    L16:
        r1 = (File) ZeusTransformUtils.preCheckCast(r19, File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        goto L18
    L8:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L35
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    private static final boolean a(i r1, cc r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1.c(r2);
    }

    static /* synthetic */ boolean a(i r0, cc r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = "TOS_UPLOADED";
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = "READY";
    L9:
        if ((r5 & 8) == 0) goto L12;
        r4 = true;
    L12:
        return r0.a(r1, r2, r3, r4);
    }

    private final InAppTraceUploadDao b() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getInAppTraceUploadDao();
    }

    private static final CharSequence b(RawObservationEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2.getTimestamp()), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String b(File r12) {
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r12), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r0 = (FileInputStream) ZeusTransformUtils.preCheckCast(r13, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r3 = r0.read(r2);     // Catch: Throwable -> L10
        if (r3 < 0) goto L7;
        r11.update(r2, 0, r3);     // Catch: Throwable -> L10
        goto L4
    L7:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r13, null);
        byte[] r4 = r11.digest();
        Intrinsics.checkNotNullExpressionValue(r4, "digest(...)");
        return ArraysKt.joinToString$default(r4, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$i$TCYm9SgXKfgMjQdb_3z0y3A3KaY.INSTANCE, 30, null);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    }

    private final boolean b(cc r21) {
        String r0 = r21.j();
        switch(r0.hashCode()) {
            case -2144704550: goto L17;
            case -1861691890: goto L15;
            case 77848963: goto L13;
            case 1039194503: goto L10;
            case 1607621347: goto L6;
            default: goto L26;
        };
    L10:
        String r1 = "TOS_UPLOADED";
    L11:
        r0.equals(r1);
        return true;
    L15:
        r1 = "REPORTING";
        goto L11
    L26:
        return true;
    L6:
        if (r0.equals("DELETE_PENDING") == false) goto L27;
        String r6 = null;
        int r7 = 0;
        long r8 = 0;
        String r10 = null;
        int r11 = 52;
        Object r12 = null;
        String r5 = "COMPLETED";
    L9:
        a(this, r21, r5, r6, r7, r8, r10, r11, r12);
        return true;
    L27:
        return true;
    L13:
        if (r0.equals("READY") == true) goto L20;
        return true;
    L20:
        if (r21.r() > 0) goto L23;
        r6 = null;
        r7 = 0;
        r8 = 0;
        r10 = null;
        r11 = 60;
        r12 = null;
        r5 = "WAIT_OBSERVATION";
        goto L9
    L23:
        return a(this, r21, null, null, false, 14, null);
    L17:
        if (r0.equals("TOS_UPLOADING") == true) goto L20;
        return true;
    }

    private final boolean b(List<cc> r18) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L3:
        boolean r5 = false;
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        cc r7 = (cc) ZeusTransformUtils.preCheckCast(r3, cc.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7.k(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        r5 = true;
    L9:
        if (r5 == false) goto L3;
        r2.add(r3);
        goto L3
    L8:
        f10176a.a(r7, "TOS_UPLOADED", "missing TOS URI before report");
        goto L9
    L11:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L14;
        return false;
    L14:
        long r6 = System.currentTimeMillis();
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L20;
        Object r11 = r10.next();
        if (f10176a.a((cc) ZeusTransformUtils.preCheckCast(r11, cc.class, "com.obric.memorydata.plugin"), "REPORTING", r6) == false) goto L16;
        r9.add(r11);
        goto L16
    L20:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        if (r12.isEmpty() == false) goto L23;
        return true;
    L23:
        RunLog.INSTANCE.info("InAppTraceUploadRepo", "report trace batch zipCount=" + r12.size() + " ids=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$i$rw1wV8oUvM2J88vQp9mmrnoSh4.INSTANCE, 31, null), true);
        com.obric.memorydata.memory.review.trace.g r13 = com.obric.memorydata.memory.review.trace.g.f10488a;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L25:
        if (r16.hasNext() == false) goto L27;
        cc r17 = (cc) ZeusTransformUtils.preCheckCast(r16.next(), cc.class, "com.obric.memorydata.plugin");
        r15.add(new com.obric.memorydata.memory.api.b(r17.k(), r17.e(), r17.f()));
        goto L25
    L27:
        com.obric.memorydata.memory.review.trace.b r19 = r13.b((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"));
        if (r19.a() == true) goto L34;
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r20.hasNext() == false) goto L33;
        f10176a.a((cc) ZeusTransformUtils.preCheckCast(r20.next(), cc.class, "com.obric.memorydata.plugin"), "TOS_UPLOADED", "URI report failed: code=" + r19.b() + " msg=" + r19.c());
        goto L31
    L33:
        return false;
    L34:
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L36:
        if (r21.hasNext() == false) goto L38;
        a(f10176a, (cc) ZeusTransformUtils.preCheckCast(r21.next(), cc.class, "com.obric.memorydata.plugin"), "COMPLETED", null, 0, 0, null, 52, null);
        goto L36
    L38:
        return true;
    }

    private final void c() {
        long r8 = System.currentTimeMillis();
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(b().queryTraceFilesForAging(r8 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, 20), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        cc r11 = (cc) ZeusTransformUtils.preCheckCast(r13.next(), cc.class, "com.obric.memorydata.plugin");
        e r0 = e.f10167a;
        i r12 = f10176a;
        if (r0.a(r12.b().countObservationLinks(r11.a()), r11.o(), r8, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS) == false) goto L4;
        r12.d(r11);
        goto L4
    }

    private final boolean c(cc r5) {
        if (r5.r() <= 0) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.j(), "TOS_UPLOADED") == false) goto L7;
    L8:
        return true;
    L7:
        if (Intrinsics.areEqual(r5.j(), "REPORTING") == false) goto L9;
        goto L8
    }

    private final boolean d(cc r13) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        i r3 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        File r12 = new File(r13.d());     // Catch: Throwable -> L12
        if (r12.exists() == true) goto L6;
    L10:
        a(r3, r13, "FILE_DELETED", null, 0, 0, null, 52, null);     // Catch: Throwable -> L12
        RunLog.INSTANCE.info("InAppTraceUploadRepo", "trace zip aged file deleted id=" + r13.a() + " file=" + r12.getName() + " localPathRetained=" + r13.d(), true);     // Catch: Throwable -> L12
        Object r14 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L12
    L14:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r14);
        if (r4 == null) goto L18;
        RunLog.INSTANCE.error("InAppTraceUploadRepo", "delete aged trace zip failed id=" + r13.a() + " path=" + r13.d(), r4);
    L18:
        if (Result.m1427isFailureimpl(r14) == false) goto L21;
        r14 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        if (r12.delete() == true) goto L10;
        throw new IllegalStateException(("delete zip failed: " + r12.getAbsolutePath()).toString());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private static final CharSequence e(cc r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2.a()), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final boolean f(cc r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return f10176a.c(r1);
    }

    private static final h g(cc r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return new h(r10.a(), r10.k(), r10.e(), r10.f(), r10.l());
    }

    private static final CharSequence h(cc r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2.a()), CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$1u60Go2-WGiuULc2fAwPl0PFCTg, reason: not valid java name */
    public static /* synthetic */ boolean m709lambda$1u60Go2WGiuULc2fAwPl0PFCTg(cc r0) {
        return f(r0);
    }

    public static /* synthetic */ CharSequence lambda$3PzNbMNHfRla1RlT9HY8nT7sRlI(cc r0) {
        return e(r0);
    }

    /* JADX INFO: renamed from: lambda$8SNM0lqC-ERzfr_uI1PqGGHqTag, reason: not valid java name */
    public static /* synthetic */ CharSequence m710lambda$8SNM0lqCERzfr_uI1PqGGHqTag(RawObservationEntity r0) {
        return a(r0);
    }

    public static /* synthetic */ h lambda$MtKfF9nCaq6DLK2aDKyGezzQRfs(cc r0) {
        return g(r0);
    }

    public static /* synthetic */ CharSequence lambda$TCYm9SgXKfgMjQdb_3z0y3A3KaY(byte r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$hqE700nEZ6zZiftdHJkUimc4C0Y(i r0, cc r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$rw1wV8oUvM2-J88vQp9mmrnoSh4, reason: not valid java name */
    public static /* synthetic */ CharSequence m711lambda$rw1wV8oUvM2J88vQp9mmrnoSh4(cc r0) {
        return h(r0);
    }

    public static /* synthetic */ CharSequence lambda$vQGZnpNz8LEBpAC_bEvwO9lu3ME(RawObservationEntity r0) {
        return b(r0);
    }

    private final void update(cc r12, String r13, String r14, int r15, long r16, String r18) {
        b().updateState(r12.a(), r13, r14, r15, r16, r18, System.currentTimeMillis());
    }

    public final int a(long r25, long r27, long r29) {
        if (r25 > 0) goto L5;
    L30:
        return 0;
    L5:
        if (r27 <= 0) goto L30;
        long r13 = r27 - 10000;
        long r4 = RangesKt.coerceIn(r29, r27, r27 + 10000);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(b().queryLinkableInWindow(r13, r4), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        cc r8 = (cc) ZeusTransformUtils.preCheckCast(r3, cc.class, "com.obric.memorydata.plugin");
        long r20 = r4 - r27;
        long r210 = r4;
        long r5 = r13;
        if (e.f10167a.a(r8.e(), r8.f(), r27, 10000, r20) == false) goto L13;
        r1.add(r3);
    L13:
        r13 = r5;
        r4 = r210;
        goto L9
    L14:
        long r211 = r4;
        long r6 = r13;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == false) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppTraceUploadRepo", "no trace zip in screenshot window observationId=" + r25 + " range=" + r6 + ".." + r211, false, 4, null);
        return 0;
    L18:
        InAppTraceUploadDao r7 = b();
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        r11.add(Long.valueOf(((cc) ZeusTransformUtils.preCheckCast(r12.next(), cc.class, "com.obric.memorydata.plugin")).a()));
        goto L20
    L22:
        int r14 = r7.linkToObservation((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), r25, System.currentTimeMillis());
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r15.hasNext() == false) goto L26;
        b.f10159a.a(r25, (cc) ZeusTransformUtils.preCheckCast(r15.next(), cc.class, "com.obric.memorydata.plugin"));
        goto L24
    L26:
        int r16 = b().queryLinkedByObservationIds(CollectionsKt.listOf(Long.valueOf(r25))).size();
        if (r14 <= 0) goto L29;
        RunLog.INSTANCE.info("InAppTraceUploadRepo", "trace zip associated observationId=" + r25 + " newLinks=" + r14 + " totalLinks=" + r16 + " range=" + r6 + ".." + r211 + " ids=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$i$3PzNbMNHfRla1RlT9HY8nT7sRlI.INSTANCE, 31, null), true);
        k.f10179a.a();
    L29:
        return r16;
    }

    public final j a() {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L31
        final i r12 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        r12.c();     // Catch: Throwable -> L31
        List<cc> r4 = r12.b().queryRunnable(System.currentTimeMillis(), 20);     // Catch: Throwable -> L31
        Sequence r5 = SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$i$hqE700nEZ6zZiftdHJkUimc4C0Y(r12));     // Catch: Throwable -> L31
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L31
    L5:
        if (r7.hasNext() == false) goto L7;
        r6.add(Long.valueOf(((cc) ZeusTransformUtils.preCheckCast(r7.next(), cc.class, "com.obric.memorydata.plugin")).a()));     // Catch: Throwable -> L31
        goto L5
    L7:
        HashSet r8 = (HashSet) ZeusTransformUtils.preCheckCast(r6, HashSet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        List<cc> r9 = r12.a(r4);     // Catch: Throwable -> L31
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L31
    L9:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();     // Catch: Throwable -> L31
        if (r8.contains(Long.valueOf(((cc) ZeusTransformUtils.preCheckCast(r14, cc.class, "com.obric.memorydata.plugin")).a())) == true) goto L9;
        r11.add(r14);     // Catch: Throwable -> L31
        goto L9
    L13:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L31
        int r17 = 0;
        int r18 = 0;
    L15:
        if (r16.hasNext() == false) goto L21;
        if (r12.b((cc) ZeusTransformUtils.preCheckCast(r16.next(), cc.class, "com.obric.memorydata.plugin")) == true) goto L18;
        r17 = r17 + 1;     // Catch: Throwable -> L31
        goto L15
    L18:
        r18 = r18 + 1;     // Catch: Throwable -> L31
        goto L15
    L21:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L27;
        if (r12.b(r9) == false) goto L25;
        r18 = r18 + r9.size();     // Catch: Throwable -> L31
        goto L27
    L25:
        r17 = r17 + r9.size();     // Catch: Throwable -> L31
    L27:
        if (r4.size() < 20) goto L29;
        k.f10179a.a();     // Catch: Throwable -> L31
    L29:
        Object r19 = Result.m1421constructorimpl(new j(r15.size() + r9.size(), r18, r17));     // Catch: Throwable -> L31
    L33:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r19);
        if (r20 == null) goto L37;
        RunLog.INSTANCE.error("InAppTraceUploadRepo", "process trace upload queue failed safely", r20);
    L37:
        if (Result.m1424exceptionOrNullimpl(r19) == null) goto L41;
        r19 = new j(0, 0, 1);
    L41:
        return (j) ZeusTransformUtils.preCheckCast(r19, j.class, "com.obric.memorydata.plugin");
    L31:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L33
    }

    public final boolean a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "completed");
        return a(r2, "WAIT_OBSERVATION");
    }
}
