package com.obric.aiproactive.impl.now;

import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.memorydata.database.dao.ProactiveInspirationRecommendationRow;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.impl.TaskResult;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a\u001d\u0010\f\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0002\u0010\r\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\nH\u0000\u001a\u0016\u0010\u0010\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u001a\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0016\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0000\u001a\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u001a\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0002\u001a\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0002\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"NOW_HUB_TAG", "", "NOW_STORE_REPO", "CANDIDATE_ID_LIST_KEY", "REGISTER_REFRESH_RETRY_COUNT", "", "orderRowsByRequestedIds", "", "Lcom/obric/memorydata/database/dao/ProactiveInspirationRecommendationRow;", "requestedRowIds", "", "rows", "resolveTopInspirationRowId", "(Ljava/util/List;)Ljava/lang/Long;", "filterExpiredRows", "now", "computeContentSignature", "isRefreshTaskSuccessful", "", "result", "Lcom/obric/memorydata/task/impl/TaskResult;", "buildCandidateIdListKey", "uid", "buildCandidateSetKey", "rowIds", "parseCandidateRowIdsFromStore", "raw", "restoreCandidateRowIdsFromStore", "persistCandidateRowIdsToStore", "", "toDto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final /* synthetic */ ProactiveRecommendationDto a(ProactiveInspirationRecommendationRow r0) {
        return b(r0);
    }

    public static final Long a(List<ProactiveInspirationRecommendationRow> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rows");
        ProactiveInspirationRecommendationRow r4 = (ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r3), ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r4.getInspirationRowId());
    }

    public static final String a(String r2) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "candidate_id_list_key";
    L12:
        return r2 + "_candidate_id_list_key";
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ List a() {
        return b();
    }

    public static final List<ProactiveInspirationRecommendationRow> a(List<ProactiveInspirationRecommendationRow> r5, long r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "rows");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L15;
        Object r2 = r9.next();
        Long r3 = ((ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r2, ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin")).getExpireAtMs();
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        if (r3.longValue() > r6) goto L11;
        r4 = false;
        goto L12
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final List<ProactiveInspirationRecommendationRow> a(List<Long> r5, List<ProactiveInspirationRecommendationRow> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "requestedRowIds");
        Intrinsics.checkNotNullParameter(r8, "rows");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Object r2 = r10.next();
        r0.put(Long.valueOf(((ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r2, ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin")).getInspirationRowId()), r2);
        goto L4
    L6:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L13;
        ProactiveInspirationRecommendationRow r3 = (ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r0.get(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).longValue())), ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        r12.add(r3);
        goto L8
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    }

    public static final boolean a(TaskResult r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.getCode() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    private static final ProactiveRecommendationDto b(ProactiveInspirationRecommendationRow r35) {
        String r1 = r35.getRecommendId();
        String r2 = r35.getTaskId();
        String r3 = r35.getSubscriptionId();
        String r4 = r35.getRecommendText();
        String r5 = r35.getEmoji();
        String r7 = r35.getActionExecuteInstruction();
        String r8 = r35.getActionContext();
        String r0 = r35.getSourcePackages();
        if (r0 == null) goto L9;
        JSONArray r6 = new JSONArray(r0);
        List r9 = CollectionsKt.createListBuilder(r6.length());
        int r10 = r6.length();
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L7;
        String r12 = r6.optString(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");
        r9.add(r12);
        r11 = r11 + 1;
        goto L5
    L7:
        List r13 = CollectionsKt.build(r9);
        if (r13 == null) goto L9;
    L10:
        List r14 = r13;
        long r15 = r35.getInspirationCreated();
        double r16 = r35.getScore();
        String r17 = r35.getReason();
        int r18 = r35.getRecommendStatus();
        String r19 = r35.getStatus();
        String r110 = r35.getType();
        Long r20 = r35.getExpireAtMs();
        if (r20 == null) goto L13;
        long r111 = r20.longValue();
    L15:
        return new ProactiveRecommendationDto(r1, r2, r3, r4, r5, null, r7, r8, r14, r15, r16, r17, null, r18, r19, r110, Long.valueOf(r111), r35.getInspirationId(), r35.getInspirationFeedbackAction(), r35.getInspirationUserFeedback(), null, null, null, r35.getInspirationUpdated(), r35.getInspirationTimestamp(), null, null, 108007424, null);
    L13:
        r111 = System.currentTimeMillis() + ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    L9:
        r13 = CollectionsKt.emptyList();
        goto L10
    }

    public static final String b(List<Long> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rowIds");
        if (r4.isEmpty() == false) goto L6;
        return "";
    L6:
        String r5 = new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }

    private static final List<Long> b() {
        String r0 = AppContext.INSTANCE.getUserId();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        String r1 = a(r0);
        String r2 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(r1, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        List<Long> r4 = b(r2);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "restoreCandidateRowIdsFromStore key=" + r1 + " size=" + r4.size(), false, 4, null);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
    L13:
        return r4;
    L9:
        if (r4.isEmpty() == false) goto L13;
        if (Intrinsics.areEqual(r2, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "restoreCandidateRowIdsFromStore parseEmpty key=" + r1 + " raw=" + r2, null, 4, null);
        goto L13
    }

    public static final List<Long> b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "raw");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        JSONArray r1 = new JSONArray(r9);     // Catch: Throwable -> L14
        List r2 = CollectionsKt.createListBuilder(r1.length());     // Catch: Throwable -> L14
        int r3 = r1.length();     // Catch: Throwable -> L14
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        long r7 = r1.optLong(r4, Long.MIN_VALUE);     // Catch: Throwable -> L14
        if (r7 == Long.MIN_VALUE) goto L11;
        r2.add(Long.valueOf(r7));     // Catch: Throwable -> L14
    L11:
        r4 = r4 + 1;     // Catch: Throwable -> L14
        goto L7
    L12:
        Object r5 = Result.m1421constructorimpl(CollectionsKt.build(r2));     // Catch: Throwable -> L14
    L16:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L20;
        RunLog.INSTANCE.warn("NowRecommendationsHub", "parseCandidateRowIdsFromStore failed raw=" + r9, r6);
    L20:
        if (Result.m1424exceptionOrNullimpl(r5) == null) goto L24;
        r5 = CollectionsKt.emptyList();
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ long c(List r2) {
        return d((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    private static final long d(List<ProactiveInspirationRecommendationRow> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == false) goto L5;
        return 0;
    L5:
        long r4 = 1125899906842597L;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r12.hasNext() == false) goto L10;
        ProactiveInspirationRecommendationRow r0 = (ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r12.next(), ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin");
        long r6 = 31;
        r4 = (((((((((r4 * r6) + r0.getInspirationRowId()) * r6) + ((long) r0.getRecommendId().hashCode())) * r6) + r0.getInspirationUpdated()) * r6) + r0.getRecommendationUpdated()) * r6) + ((long) r0.getRecommendStatus());
        goto L7
    L10:
        if (r4 != Long.MIN_VALUE) goto L13;
        return 0;
    L13:
        return Math.abs(r4);
    }
}
