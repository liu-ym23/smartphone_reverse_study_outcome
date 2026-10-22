package com.obric.memorydata.memory.review.trace;

import com.obric.memorydata.database.entity.AuditoryAsrTaskEntity;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bJ\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportAudioUrlReader;", "", "audioUrlLookup", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "readAudioUrls", "", "rawObservations", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "loadAudioUrls", "", "taskIds", "taskId", "entity", "isAuditory", "", "taskIdFromJson", "rawJson", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10486a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<String, String> f10487b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportAudioUrlReader$Companion;", "", "<init>", "()V", "TAG", "", "KEY_TASK_ID", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10486a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public f(Function1<? super String, String> r3) {
        Function1<String, String> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "audioUrlLookup");
        this.f10487b = r4;
    }

    public /* synthetic */ f(Function1 r2, int r3, DefaultConstructorMarker r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$f$68RUFJRLQjBSQAr3EzYD9wuJjdc.INSTANCE;
    L5:
        this(r5);
    }

    private final String a(RawObservationEntity r4) {
        if (b(r4) == true) goto L6;
        return "";
    L6:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(a(r4.getPayload()), CharSequence.class, "com.obric.memorydata.plugin");
        if (r0.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        r0 = a(r4.getMeta());
    L13:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L9:
        r1 = false;
        goto L10
    }

    private final String a(String r3) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        return "";
    L8:
        String r2 = new JSONObject(r3).optString("task_id");     // Catch: JSONException -> L7
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");     // Catch: JSONException -> L7
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L10:
        return "";
    }

    private static final String b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        AuditoryAsrTaskEntity r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao().queryByTaskId(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getTosKey();
    }

    private final Map<String, String> b(List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        f r8 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));     // Catch: Throwable -> L15
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L15
    L5:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();     // Catch: Throwable -> L15
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        String r6 = (String) ZeusTransformUtils.preCheckCast(r8.f10487b.invoke((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r6 == null) goto L9;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L15
    L10:
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        r5.put(r4, r7);     // Catch: Throwable -> L15
        goto L5
    L9:
        r7 = null;
        goto L10
    L13:
        Object r11 = Result.m1421constructorimpl((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    L17:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportAudioUrlReader", "read auditory audio urls failed, taskCount=" + r10.size() + ", errorType=" + r12.getClass().getSimpleName(), null, 4, null);
        r11 = MapsKt.emptyMap();
    L22:
        return (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin");
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final boolean b(RawObservationEntity r1) {
        return Intrinsics.areEqual(r1.getSource(), "auditory");
    }

    public static /* synthetic */ String lambda$68RUFJRLQjBSQAr3EzYD9wuJjdc(String r0) {
        return b(r0);
    }

    public final List<String> a(List<RawObservationEntity> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "rawObservations");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (b((RawObservationEntity) ZeusTransformUtils.preCheckCast(r1.next(), RawObservationEntity.class, "com.obric.memorydata.plugin")) == false) goto L9;
        boolean r2 = false;
    L13:
        if (r2 == true) goto L15;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L20;
        r3.add(a((RawObservationEntity) ZeusTransformUtils.preCheckCast(r13.next(), RawObservationEntity.class, "com.obric.memorydata.plugin")));
        goto L18
    L20:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L22;
        r5.add(r7);
        goto L22
    L26:
        r8 = false;
        goto L27
    L29:
        Map<String, String> r9 = b(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L31:
        if (r17.hasNext() == false) goto L37;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r9.get((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L35;
        r18 = "";
    L35:
        r16.add(r18);
        goto L31
    L37:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    L15:
        return CollectionsKt.emptyList();
    L6:
        r2 = true;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }
}
