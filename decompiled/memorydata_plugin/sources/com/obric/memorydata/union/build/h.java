package com.obric.memorydata.union.build;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eJ+\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/union/build/OAutoMemoryIslandGate;", "", "<init>", "()V", "TAG", "", "MAX_DONATION_AGE_MS", "", "shownSessions", "", "shouldShow", "", ObricMemoryConstants.KEY_SESSION_ID, "sourceRawRefIds", "", "donationTimestamp", "extractionTimestamp", "shouldShow$memory_build_obricRelease", "(Ljava/lang/String;Ljava/lang/Long;J)Z", "resetForTest", "", "resetForTest$memory_build_obricRelease", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f13092b = null;

    static {
        f13091a = new h();
        f13092b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private h() {
    }

    private static final boolean a(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean a(long r2, Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<destruct>");
        if ((r2 - ((Number) ZeusTransformUtils.preCheckCast(r5.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue()) <= 180000) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean a(RawObservationEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (Intrinsics.areEqual(r2.getSource(), "oauto") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.getSource(), "agent") == true) goto L8;
        return false;
    }

    private static final long b(RawObservationEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.getTimestamp();
    }

    /* JADX INFO: renamed from: lambda$H6Sp0yxTADB3QRk7nyb-6Ttk5jU, reason: not valid java name */
    public static /* synthetic */ boolean m1233lambda$H6Sp0yxTADB3QRk7nyb6Ttk5jU(long r0, Map.Entry r2) {
        return a(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$KCIq0FTlpCtoWxelf3n-Xl62_P0, reason: not valid java name */
    public static /* synthetic */ boolean m1234lambda$KCIq0FTlpCtoWxelf3nXl62_P0(long r0) {
        return a(r0);
    }

    public static /* synthetic */ long lambda$ehkbbgGeJXaODaXjYjmhePDRdXQ(RawObservationEntity r2) {
        return b(r2);
    }

    public static /* synthetic */ boolean lambda$l5effcIRjIszGWFkYxzZUSRGw14(RawObservationEntity r0) {
        return a(r0);
    }

    public final synchronized boolean a(String r9, Long r10, final long r11) {
        monitor-enter(this);
        if (r9 != null) goto L39;
    L37:
        monitor-exit(this);
        return false;
    L39:
    L34:
        th = move-exception;
        throw th;
    L6:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        r9 = null;
    L9:
        if (r9 == null) goto L37;
        if (r10 != null) goto L13;
    L32:
        monitor-exit(this);
        return false;
    L13:
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L32;
        if (Math.abs(r11 - r10.longValue()) <= 180000) goto L25;
        monitor-exit(this);
        return false;
    L25:
        Map<String, Long> r12 = f13092b;     // Catch: Throwable -> L34
        CollectionsKt.removeAll((Iterable) ZeusTransformUtils.preCheckCast(r12.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), new $$Lambda$h$H6Sp0yxTADB3QRk7nyb6Ttk5jU(r11));     // Catch: Throwable -> L34
        if (r12.containsKey(r9) == false) goto L29;
        monitor-exit(this);
        return false;
    L29:
        r12.put(r9, Long.valueOf(r11));     // Catch: Throwable -> L34
        monitor-exit(this);
        return true;
    L15:
        r1 = false;
        goto L16
    }

    public final boolean a(String r7, List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        Long r2 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L7;
        r0.add(r2);
        goto L7
    L11:
        List<Long> r12 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r12.isEmpty() == false) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OAutoMemoryIslandGate", "skip OAuto island: raw observation id missing", null, 4, null);
        return false;
    L29:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        h r3 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Object r13 = Result.m1421constructorimpl((Long) ZeusTransformUtils.preCheckCast(SequencesKt.maxOrNull(SequencesKt.filter(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().queryByIds(r12), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$h$l5effcIRjIszGWFkYxzZUSRGw14.INSTANCE), $$Lambda$h$ehkbbgGeJXaODaXjYjmhePDRdXQ.INSTANCE), $$Lambda$h$KCIq0FTlpCtoWxelf3nXl62_P0.INSTANCE)), Long.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
    L19:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r13);
        if (r4 == null) goto L23;
        RunLog.INSTANCE.error("OAutoMemoryIslandGate", "resolve OAuto donation timestamp failed", r4);
    L23:
        if (Result.m1427isFailureimpl(r13) == false) goto L25;
        r13 = null;
    L25:
        boolean r6 = a(r7, (Long) ZeusTransformUtils.preCheckCast(r13, Long.class, "com.obric.memorydata.plugin"), System.currentTimeMillis());
        if (r6 == true) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OAutoMemoryIslandGate", "skip OAuto island: freshness or task dedup gate rejected", false, 4, null);
    L28:
        return r6;
    L17:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
