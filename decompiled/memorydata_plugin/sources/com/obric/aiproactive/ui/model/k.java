package com.obric.aiproactive.ui.model;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aiproactive.api.ProactiveDayHeaderDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.n;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jh\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b Jt\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u001fJ)\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\n2\u0006\u0010*\u001a\u00020\u0005H\u0000¢\u0006\u0002\b+J)\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\n2\u0006\u0010*\u001a\u00020\u0005H\u0000¢\u0006\u0002\b.J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010(\u001a\u00020\u001fH\u0002J(\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002JQ\u00106\u001a\u000207*\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u00108\u001a\u00020\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0000¢\u0006\u0002\b:J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020#0\n*\b\u0012\u0004\u0012\u00020#0\nH\u0002J\f\u0010>\u001a\u00020\u001f*\u00020#H\u0002J\f\u0010?\u001a\u00020\u001f*\u00020#H\u0002J\f\u0010@\u001a\u00020\u001f*\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/obric/aiproactive/ui/model/ProactiveMappers;", "", "<init>", "()V", "TAG", "", "timeFormatter", "Ljava/time/format/DateTimeFormatter;", "dateFormatter", "buildAllItems", "", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "state", "Lcom/obric/aiproactive/ui/model/AllPageUiState;", "nowMillis", "", "zoneId", "Ljava/time/ZoneId;", "tipText", "todayText", "yesterdayText", "adoptedText", "ignoredText", "executeNowText", "knownText", "endText", "resolveHistoryDisplayCount", "", "headerCount", "loadedCount", "isFullyLoaded", "", "resolveHistoryDisplayCount$ai_proactive_ui_obricRelease", "buildNowItems", "recommendations", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "pinnedInspirationIds", "", "minCreatedMillis", "nowProcessedText", "showGuidedPreferenceEntry", "buildAgentRunRecommendationMarkdown", "traceId", "buildAgentRunRecommendationMarkdown$ai_proactive_ui_obricRelease", "buildAgentRunCanonicalArtifacts", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "buildAgentRunCanonicalArtifacts$ai_proactive_ui_obricRelease", "buildGuidedPreferenceOnlyItems", "formatDayTitle", "date", "Ljava/time/LocalDate;", "nowDate", "formatTime", "createdMillis", "toListItem", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "timeText", "dayKey", "toListItem$ai_proactive_ui_obricRelease", "isKnownActionText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "filterDisplayableRecommendations", "hasDisplayableNowActionButtons", "isPendingAiRecommendationWithExecutedAction", "isAutoDismissedRecommendation", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f6745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DateTimeFormatter f6746b = null;
    private static final DateTimeFormatter c = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getScore()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getScore()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6747a;

        public b(Comparator r3) {
            this.f6747a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6747a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r6, T r7) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r7, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated() / 60000), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r6, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated() / 60000), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6748a;

        public d(Comparator r3) {
            this.f6748a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6748a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getScore()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getScore()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6749a;

        public e(Comparator r3) {
            this.f6749a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6749a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getScore()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getScore()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6750a;

        public g(Comparator r3) {
            this.f6750a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6750a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f6745a = new k();
        DateTimeFormatter r0 = DateTimeFormatter.ofPattern("HH:mm");
        Intrinsics.checkNotNullExpressionValue(r0, "ofPattern(...)");
        f6746b = r0;
        DateTimeFormatter r1 = DateTimeFormatter.ofPattern("MM/dd");
        Intrinsics.checkNotNullExpressionValue(r1, "ofPattern(...)");
        c = r1;
    }

    private k() {
    }

    public static /* synthetic */ j.f a(k r10, ProactiveRecommendationDto r11, ZoneId r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19, Object r20) {
        if ((r19 & 1) == 0) goto L5;
        ZoneId r3 = ZoneId.systemDefault();
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        return r10.a(r11, r3, r4, r5, r15, r16, r17, r18);
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    private final String a(long r1, ZoneId r3) {
        String r0 = Instant.ofEpochMilli(r1).atZone(r3).format(f6746b);
        Intrinsics.checkNotNullExpressionValue(r0, "format(...)");
        return r0;
    }

    private final String a(LocalDate r3, LocalDate r4, String r5, String r6) {
        if (Intrinsics.areEqual(r3, r4) == false) goto L6;
        return r5;
    L6:
        if (Intrinsics.areEqual(r3, r4.minusDays(1)) == true) goto L10;
        String r7 = r3.format(c);
        Intrinsics.checkNotNullExpressionValue(r7, "format(...)");
        return r7;
    L10:
        return r6;
    }

    public static /* synthetic */ List a(k r14, com.obric.aiproactive.ui.model.f r15, long r16, ZoneId r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, int r27, Object r28) {
        if ((r27 & 4) == 0) goto L5;
        ZoneId r5 = ZoneId.systemDefault();
    L7:
        if ((r27 & 8) == 0) goto L9;
        String r6 = "";
    L11:
        return r14.a(r15, r16, r5, r6, r20, r21, r22, r23, r24, r25, r26);
    L9:
        r6 = r19;
        goto L11
    L5:
        r5 = r18;
        goto L7
    }

    private final List<ProactiveRecommendationDto> a(List<ProactiveRecommendationDto> r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r1 = r7.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r1, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r6.add(r1);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    }

    private final List<j> a(boolean r1) {
        if (r1 == false) goto L5;
        return CollectionsKt.listOf(j.c.f6735a);
    L5:
        return CollectionsKt.emptyList();
    }

    private static final boolean a(long r2, ProactiveRecommendationDto r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Long r5 = r4.getTraceId();
        if (r5 != null) goto L6;
    L8:
        return false;
    L6:
        if (r5.longValue() != r2) goto L8;
        return true;
    }

    private final boolean a(ProactiveRecommendationDto r6) {
        n r5 = com.obric.aiproactive.api.c.b(r6.getActionCondition());
        if (r5 == null) goto L5;
        String r7 = r5.a();
    L6:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.api.c.a(r7), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L9;
    L11:
        Iterator r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L30;
        com.obric.aiproactive.api.b r10 = (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == false) goto L13;
        return true;
    L17:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L20;
        r11 = false;
        goto L21
    L30:
        return false;
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
        return false;
    L5:
        r7 = null;
        goto L6
    }

    private static final boolean a(Set r2, ProactiveRecommendationDto r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dto");
        if (r3.getRecommendStatus() == 2) goto L6;
        return true;
    L6:
        String r5 = l.a(r3);
        if (r5 != null) goto L11;
        return false;
    L11:
        return r4.contains(r5);
    }

    private static final boolean b(long r2, ProactiveRecommendationDto r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Long r5 = r4.getTraceId();
        if (r5 != null) goto L6;
    L8:
        return false;
    L6:
        if (r5.longValue() != r2) goto L8;
        return true;
    }

    private final boolean b(ProactiveRecommendationDto r5) {
        if (r5.getRecommendStatus() == 1) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r5.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == true) goto L8;
        return false;
    L8:
        n r4 = com.obric.aiproactive.api.c.b(r5.getActionCondition());
        if (r4 == null) goto L11;
        String r6 = r4.a();
    L12:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.api.c.a(r6), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L15;
    L17:
        Iterator r8 = r7.iterator();
    L19:
        if (r8.hasNext() == false) goto L22;
        if ((!((com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin")).h()) == false) goto L19;
        return true;
    L22:
        return false;
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L17;
    L11:
        r6 = null;
        goto L12
    }

    private final boolean c(ProactiveRecommendationDto r2) {
        return StringsKt.equals(r2.getInspirationFeedbackAction(), "auto_dismiss", true);
    }

    private static final boolean d(ProactiveRecommendationDto r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return f6745a.c(r1);
    }

    private static final boolean e(ProactiveRecommendationDto r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2.getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private static final String f(ProactiveRecommendationDto r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2.getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private static final Sequence g(ProactiveRecommendationDto r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r2.getArtifacts(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ boolean lambda$13zDJ_VwitURAWzWscSZkUFzhro(Set r0, ProactiveRecommendationDto r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$Kk1Il2tP7ETjcvfv46rFa3Y4HIg(long r0, ProactiveRecommendationDto r2) {
        return b(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$Pvl5Y_gCTIHfy3Ey-lug068f9aY, reason: not valid java name */
    public static /* synthetic */ boolean m311lambda$Pvl5Y_gCTIHfy3Eylug068f9aY(ProactiveRecommendationDto r0) {
        return e(r0);
    }

    public static /* synthetic */ boolean lambda$TFnSCRHBCJ6T5XfmK167gsN5J7I(ProactiveRecommendationDto r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$VQ00o26vqPPyLtL8ePJWle-phfc, reason: not valid java name */
    public static /* synthetic */ Sequence m312lambda$VQ00o26vqPPyLtL8ePJWlephfc(ProactiveRecommendationDto r0) {
        return g(r0);
    }

    public static /* synthetic */ boolean lambda$_tKBLzO1JNF7lAAGq_VcRYkkkgw(long r0, ProactiveRecommendationDto r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ String lambda$gtSKPLKvQxrHCmQ66YHUE5KSvHU(ProactiveRecommendationDto r0) {
        return f(r0);
    }

    public final int a(int r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        return r2;
    L5:
        return Math.max(r1, r2);
    }

    public final j.f a(ProactiveRecommendationDto r17, ZoneId r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "zoneId");
        Intrinsics.checkNotNullParameter(r19, "timeText");
        Intrinsics.checkNotNullParameter(r21, "adoptedText");
        Intrinsics.checkNotNullParameter(r22, "ignoredText");
        Intrinsics.checkNotNullParameter(r23, "executeNowText");
        Intrinsics.checkNotNullParameter(r24, "knownText");
        boolean r0 = Intrinsics.areEqual(r17.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE);
        n r7 = com.obric.aiproactive.api.c.b(r17.getActionCondition());
        if (r7 == null) goto L5;
        String r9 = r7.a();
    L6:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r11 = false;
        if (r10 != null) goto L9;
    L12:
        boolean r12 = true;
    L13:
        if (r12 == false) goto L35;
        if (r7 == null) goto L16;
        String r8 = r7.c();
    L17:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L20;
    L23:
        boolean r14 = true;
    L24:
        if (r14 == false) goto L35;
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getActionExecuteInstruction(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L28;
    L31:
        boolean r16 = true;
    L32:
        if (r16 == false) goto L35;
        boolean r25 = false;
    L37:
        if (r17.getRecommendStatus() == 1) goto L39;
    L41:
        boolean r26 = false;
    L43:
        if (r17.getRecommendStatus() == 2) goto L45;
        if (r0 == false) goto L66;
        if (r25 == false) goto L66;
    L76:
        String r27 = r23;
    L79:
        if (r17.getRecommendStatus() != 2) goto L82;
        Integer r1 = null;
    L96:
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r17.getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r2 = r17.getReason();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L99;
        String r6 = r2;
    L101:
        return new j.f(r17, r20, r19, r5, r6, r27, r1);
    L99:
        r6 = null;
        goto L101
    L82:
        if (r0 == false) goto L86;
        if (r25 == false) goto L86;
    L84:
        int r3 = ZeusTransformUtils.mapRes(R.drawable.union, "drawable", "union");
    L95:
        r1 = Integer.valueOf(r3);
    L86:
        if (r0 == false) goto L88;
    L87:
        r3 = ZeusTransformUtils.mapRes(R.drawable.oic_checkmark_circle_fill, "drawable", "oic_checkmark_circle_fill");
        goto L95
    L88:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getActionExecuteInstruction(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L91;
    L92:
        r11 = true;
    L93:
        if (r11 == true) goto L87;
    L91:
        if (StringsKt.isBlank(r4) == false) goto L93;
    L66:
        if (r0 == true) goto L77;
        CharSequence r28 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getActionExecuteInstruction(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r28 != null) goto L71;
    L74:
        boolean r29 = true;
    L75:
        if (r29 == true) goto L77;
    L71:
        if (StringsKt.isBlank(r28) == true) goto L74;
        r29 = false;
    L77:
        r27 = r24;
        goto L79
    L45:
        if (StringsKt.equals(r17.getInspirationFeedbackAction(), "ignore", true) == false) goto L47;
        r27 = r22;
        goto L79
    L47:
        if (r26 == false) goto L62;
        if (r0 == false) goto L51;
        if (r25 == true) goto L76;
    L51:
        if (r0 == true) goto L77;
        CharSequence r30 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getActionExecuteInstruction(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r30 != null) goto L56;
    L59:
        boolean r31 = true;
    L60:
        if (r31 == true) goto L77;
    L56:
        if (StringsKt.isBlank(r30) == true) goto L59;
        r31 = false;
        goto L60
    L62:
        r27 = r21;
        goto L79
    L39:
        if (StringsKt.equals(r17.getInspirationFeedbackAction(), "auto_dismiss", true) == false) goto L41;
        r26 = true;
        goto L43
    L28:
        if (StringsKt.isBlank(r15) == true) goto L31;
        r16 = false;
        goto L32
    L20:
        if (StringsKt.isBlank(r13) == true) goto L23;
        r14 = false;
        goto L24
    L16:
        r8 = null;
    L35:
        r25 = true;
        goto L37
    L9:
        if (StringsKt.isBlank(r10) == true) goto L12;
        r12 = false;
        goto L13
    L5:
        r9 = null;
        goto L6
    }

    public final List<j> a(com.obric.aiproactive.ui.model.f r25, long r26, ZoneId r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36) {
        String r10 = r30;
        String r11 = r31;
        Intrinsics.checkNotNullParameter(r25, "state");
        Intrinsics.checkNotNullParameter(r28, "zoneId");
        Intrinsics.checkNotNullParameter(r29, "tipText");
        Intrinsics.checkNotNullParameter(r10, "todayText");
        Intrinsics.checkNotNullParameter(r11, "yesterdayText");
        Intrinsics.checkNotNullParameter(r32, "adoptedText");
        Intrinsics.checkNotNullParameter(r33, "ignoredText");
        Intrinsics.checkNotNullParameter(r34, "executeNowText");
        Intrinsics.checkNotNullParameter(r35, "knownText");
        Intrinsics.checkNotNullParameter(r36, "endText");
        LocalDate r7 = Instant.ofEpochMilli(r26).atZone(r28).toLocalDate();
        ArrayList r6 = new ArrayList();
        if (r25.d() == false) goto L5;
        r6.add(new j.g(r29));
    L5:
        String r5 = "com.obric.memorydata.plugin";
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r25.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r16.hasNext() == false) goto L33;
        ProactiveDayHeaderDto r17 = (ProactiveDayHeaderDto) ZeusTransformUtils.preCheckCast(r16.next(), ProactiveDayHeaderDto.class, r5);
        LocalDate r1 = Instant.ofEpochMilli(r17.getDayStartMillis()).atZone(r28).toLocalDate();
        boolean r2 = r25.f().contains(r17.getDayKey());
        k r4 = f6745a;
        List<ProactiveRecommendationDto> r3 = (List) ZeusTransformUtils.preCheckCast(r25.g().get(r17.getDayKey()), List.class, r5);
        if (r3 != null) goto L11;
        r3 = CollectionsKt.emptyList();
    L11:
        List<ProactiveRecommendationDto> r8 = r4.a(r3);
        com.obric.aiproactive.ui.model.c r9 = (com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(r25.h().get(r17.getDayKey()), com.obric.aiproactive.ui.model.c.class, r5);
        if (r9 != null) goto L14;
    L18:
        boolean r12 = false;
    L19:
        int r22 = r4.a(r17.getCount(), r8.size(), r12);
        String r19 = r17.getDayKey();
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r7);
        r6.add(new j.a(r19, r1, r4.a(r1, r7, r10, r11), r22, r2));
        if (r2 == false) goto L32;
        Long r13 = null;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, r5), (Comparator) ZeusTransformUtils.preCheckCast(new e((Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, r5)), Comparator.class, r5)), Comparator.class, r5)), Iterable.class, r5)).iterator();
    L23:
        if (r14.hasNext() == false) goto L32;
        ProactiveRecommendationDto r15 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r14.next(), ProactiveRecommendationDto.class, r5);
        long r18 = r15.getCreated() / 60000;
        if (r13 != null) goto L28;
    L29:
        r6.add(new j.d(r18, f6745a.a(r15.getCreated(), r28)));
        Long r110 = Long.valueOf(r18);
    L31:
        ArrayList r20 = r6;
        r20.add(f6745a.a(r15, r28, "", r17.getDayKey(), r32, r33, r34, r35));
        r6 = r20;
        r5 = r5;
        r13 = r110;
        r7 = r7;
        goto L23
    L28:
        if (r13.longValue() != r18) goto L29;
        r110 = r13;
    L32:
        r6 = r6;
        r5 = r5;
        r7 = r7;
        r10 = r30;
        r11 = r31;
        goto L7
    L14:
        if (r9.b() == true) goto L18;
        if (r9.a() == true) goto L18;
        r12 = true;
        goto L19
    L33:
        String r111 = r5;
        ArrayList r112 = r6;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r25.g().values(), Iterable.class, r111)).iterator();
        int r21 = 0;
    L35:
        if (r0.hasNext() == false) goto L37;
        r21 = r21 + ((List) ZeusTransformUtils.preCheckCast(r0.next(), List.class, r111)).size();
        goto L35
    L37:
        Map<String, com.obric.aiproactive.ui.model.c> r23 = r25.h();
        if (r23.isEmpty() == false) goto L40;
        int r24 = 0;
    L46:
        Map<String, com.obric.aiproactive.ui.model.c> r27 = r25.h();
        if (r27.isEmpty() == false) goto L49;
        int r37 = 0;
    L55:
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, r111);
        if (ZeusTransformUtils.instanceOf(r38, Collection.class) == true) goto L58;
    L60:
        Iterator r39 = r38.iterator();
    L62:
        if (r39.hasNext() == false) goto L59;
        if (ZeusTransformUtils.instanceOf((j) ZeusTransformUtils.preCheckCast(r39.next(), j.class, r111), j.f.class) == false) goto L62;
        boolean r40 = true;
    L66:
        if (r40 == false) goto L74;
        r112.add(new j.b(r36));
    L74:
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L70
        k r42 = (k) ZeusTransformUtils.preCheckCast(this, k.class, r111);     // Catch: Throwable -> L70
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r111), "ProactiveMappers", "[Mappers] buildAllItems batchId=" + r25.a() + " headers=" + r25.e().size() + " expanded=" + r25.f().size() + " loaded=" + r21 + " loadingDays=" + r24 + " hasNextDays=" + r37, false, 4, null);     // Catch: Throwable -> L70
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L73:
        return (List) ZeusTransformUtils.preCheckCast(r112, List.class, r111);
    L70:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L59:
        r40 = false;
        goto L66
    L58:
        if (((Collection) ZeusTransformUtils.preCheckCast(r38, Collection.class, r111)).isEmpty() == false) goto L60;
    L49:
        Iterator<Map.Entry<String, com.obric.aiproactive.ui.model.c>> r44 = r27.entrySet().iterator();
        r37 = 0;
    L51:
        if (r44.hasNext() == false) goto L55;
        if (((com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r44.next(), Map.Entry.class, r111)).getValue(), com.obric.aiproactive.ui.model.c.class, r111)).b() == false) goto L51;
        r37 = r37 + 1;
        goto L51
    L40:
        Iterator<Map.Entry<String, com.obric.aiproactive.ui.model.c>> r45 = r23.entrySet().iterator();
        r24 = 0;
    L42:
        if (r45.hasNext() == false) goto L46;
        if (((com.obric.aiproactive.ui.model.c) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r45.next(), Map.Entry.class, r111)).getValue(), com.obric.aiproactive.ui.model.c.class, r111)).a() == false) goto L42;
        r24 = r24 + 1;
        goto L42
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v69 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    public final List<j> a(List<ProactiveRecommendationDto> r26, long r27, ZoneId r29, Set<String> r30, long r31, String r33, String r34, String r35, String r36, String r37, boolean r38) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        final Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r30, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "recommendations");
        Intrinsics.checkNotNullParameter(r29, "zoneId");
        Intrinsics.checkNotNullParameter(r5, "pinnedInspirationIds");
        Intrinsics.checkNotNullParameter(r33, "nowProcessedText");
        Intrinsics.checkNotNullParameter(r34, "adoptedText");
        Intrinsics.checkNotNullParameter(r35, "ignoredText");
        Intrinsics.checkNotNullParameter(r36, "executeNowText");
        Intrinsics.checkNotNullParameter(r37, "knownText");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L6;
        if (f6745a.c((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r7.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")) == false) goto L9;
        ?? r8 = true;
    L13:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L15:
        if (r11.hasNext() == false) goto L20;
        Object r12 = r11.next();
        Iterator r28 = r11;
        if (f6745a.c((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r12, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")) == true) goto L19;
        r10.add(r12);
    L19:
        r11 = r28;
        goto L15
    L20:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L22:
        if (r15.hasNext() == false) goto L27;
        Object r16 = r15.next();
        Iterator r210 = r15;
        if (f6745a.b((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r16, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")) == true) goto L26;
        r14.add(r16);
    L26:
        r15 = r210;
        goto L22
    L27:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(a((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L29:
        if (r19.hasNext() == false) goto L34;
        Object r20 = r19.next();
        Iterator r211 = r19;
        if (f6745a.a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r20, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")) == false) goto L33;
        r18.add(r20);
    L33:
        r19 = r211;
        goto L29
    L34:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        if (r8 == true) goto L37;
    L44:
        List r4 = SequencesKt.toList(SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$k$13zDJ_VwitURAWzWscSZkUFzhro(r5)), (Comparator) ZeusTransformUtils.preCheckCast(new g((Comparator) ZeusTransformUtils.preCheckCast(new f(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")));
        String r111 = " ids=";
        if (r4.isEmpty() == true) goto L47;
        ArrayList r21 = new ArrayList(r4.size() + (r38 ? 1 : 0));
        if (r38 == false) goto L102;
        r21.add(j.c.f6735a);
    L102:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        String r212 = " adopted=";
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r2.iterator();
    L104:
        if (r23.hasNext() == false) goto L106;
        String r24 = r212;
        Collection r25 = r22;
        r25.add(f6745a.a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r23.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin"), r29, "", null, r34, r35, r36, r37));
        r110 = r110;
        r111 = r111;
        r22 = r25;
        r23 = r23;
        r212 = r24;
        goto L104
    L106:
        String r213 = r212;
        List r214 = r110;
        String r32 = r111;
        r21.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L129
        k r0 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L129
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L129
        StringBuilder r40 = new StringBuilder().append("[Mappers] buildNowItems input=").append(r214.size()).append(" pinned=").append(r5.size()).append(r213);     // Catch: Throwable -> L129
        Iterable r41 = (Iterable) ZeusTransformUtils.preCheckCast(r214, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L129
        if (ZeusTransformUtils.instanceOf(r41, Collection.class) == true) goto L110;
    L112:
        Iterator r42 = r41.iterator();     // Catch: Throwable -> L129
        int r43 = 0;
    L114:
        if (r42.hasNext() == false) goto L123;
        if (((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r42.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus() != 2) goto L118;
        ?? r44 = true;
    L119:
        if (r44 == false) goto L114;
        r43 = r43 + 1;     // Catch: Throwable -> L129
        if (r43 >= 0) goto L114;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L129
        goto L114
    L118:
        r44 = false;
    L123:
        StringBuilder r45 = r40.append(r43).append(" result=").append(r21.size()).append(r32);     // Catch: Throwable -> L129
        Iterable r46 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), 5), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L129
        Collection r47 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r46, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L129
        Iterator r48 = r46.iterator();     // Catch: Throwable -> L129
    L125:
        if (r48.hasNext() == false) goto L127;
        ProactiveRecommendationDto r49 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r48.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L129
        r47.add(TuplesKt.to(r49.getRecommendId(), Integer.valueOf(r49.getRecommendStatus())));     // Catch: Throwable -> L129
        goto L125
    L127:
        IRunLog.a.a(r1, "ProactiveMappers", r45.append((List) ZeusTransformUtils.preCheckCast(r47, List.class, "com.obric.memorydata.plugin")).toString(), false, 4, null);     // Catch: Throwable -> L129
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L129
    L132:
        return (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin");
    L110:
        if (((Collection) ZeusTransformUtils.preCheckCast(r41, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L112;
        r43 = 0;
    L129:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L132
    L47:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L133;
        Iterable r51 = (Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r51, Collection.class) == true) goto L51;
    L53:
        Iterator r52 = r51.iterator();
    L55:
        if (r52.hasNext() == false) goto L52;
        if (((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r52.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus() != 2) goto L59;
        ?? r53 = true;
    L60:
        if (r53 == true) goto L55;
        ?? r54 = false;
    L62:
        if (r54 == false) goto L133;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L69
        k r56 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        IRunLog r57 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        StringBuilder r58 = new StringBuilder().append("[Mappers] buildNowItems allProcessed input=").append(r110.size()).append(" ids=");     // Catch: Throwable -> L69
        Iterable r59 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin"), 5), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        Collection r60 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r59, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        Iterator r61 = r59.iterator();     // Catch: Throwable -> L69
    L65:
        if (r61.hasNext() == false) goto L67;
        ProactiveRecommendationDto r62 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r61.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        r60.add(TuplesKt.to(r62.getRecommendId(), Integer.valueOf(r62.getRecommendStatus())));     // Catch: Throwable -> L69
        goto L65
    L67:
        IRunLog.a.a(r57, "ProactiveMappers", r58.append((List) ZeusTransformUtils.preCheckCast(r60, List.class, "com.obric.memorydata.plugin")).toString(), false, 4, null);     // Catch: Throwable -> L69
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L72:
        return a(r38);
    L69:
        th = move-exception;
        Result.Companion r63 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L72
    L59:
        r53 = false;
    L52:
        r54 = true;
        goto L62
    L51:
        if (((Collection) ZeusTransformUtils.preCheckCast(r51, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L53;
    L133:
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L95
        k r65 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        IRunLog r66 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        StringBuilder r67 = new StringBuilder().append("[Mappers] buildNowItems empty input=").append(r110.size()).append(" pinned=").append(r5.size()).append(" adopted=");     // Catch: Throwable -> L95
        Iterable r68 = (Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        if (ZeusTransformUtils.instanceOf(r68, Collection.class) == true) goto L76;
    L78:
        Iterator r69 = r68.iterator();     // Catch: Throwable -> L95
        int r70 = 0;
    L80:
        if (r69.hasNext() == false) goto L89;
        if (((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r69.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendStatus() != 2) goto L84;
        ?? r71 = true;
    L85:
        if (r71 == false) goto L80;
        r70 = r70 + 1;     // Catch: Throwable -> L95
        if (r70 >= 0) goto L80;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L95
        goto L80
    L84:
        r71 = false;
    L89:
        StringBuilder r72 = r67.append(r70).append(" ids=");     // Catch: Throwable -> L95
        Iterable r73 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin"), 5), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        Collection r74 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r73, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        Iterator r75 = r73.iterator();     // Catch: Throwable -> L95
    L91:
        if (r75.hasNext() == false) goto L93;
        ProactiveRecommendationDto r76 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r75.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        r74.add(TuplesKt.to(r76.getRecommendId(), Integer.valueOf(r76.getRecommendStatus())));     // Catch: Throwable -> L95
        goto L91
    L93:
        IRunLog.a.a(r66, "ProactiveMappers", r72.append((List) ZeusTransformUtils.preCheckCast(r74, List.class, "com.obric.memorydata.plugin")).toString(), false, 4, null);     // Catch: Throwable -> L95
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L95
    L98:
        return a(r38);
    L76:
        if (((Collection) ZeusTransformUtils.preCheckCast(r68, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L78;
        r70 = 0;
    L95:
        th = move-exception;
        Result.Companion r77 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L98
    L37:
        if (r110.isEmpty() == false) goto L44;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L40
        k r79 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveMappers", "[Mappers] buildNowItems autoDismissEmpty input=" + r3.size() + " visible=" + r110.size(), false, 4, null);     // Catch: Throwable -> L40
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L43:
        return a(r38);
    L40:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L6:
        r8 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public final List<String> a(List<ProactiveRecommendationDto> r3, String r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "recommendations");
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Long r5 = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r5 == null) goto L7;
        final long r6 = r5.longValue();
        return SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.filter(SequencesKt.filterNot(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$k$_tKBLzO1JNF7lAAGq_VcRYkkkgw(r6)), $$Lambda$k$TFnSCRHBCJ6T5XfmK167gsN5J7I.INSTANCE), $$Lambda$k$Pvl5Y_gCTIHfy3Eylug068f9aY.INSTANCE), (Comparator) ZeusTransformUtils.preCheckCast(new b((Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), $$Lambda$k$gtSKPLKvQxrHCmQ66YHUE5KSvHU.INSTANCE));
    L7:
        return CollectionsKt.emptyList();
    }

    public final List<com.obric.aiproactive.api.j> b(List<ProactiveRecommendationDto> r3, String r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "recommendations");
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Long r5 = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r5 == null) goto L7;
        final long r6 = r5.longValue();
        return SequencesKt.toList(SequencesKt.distinctBy(SequencesKt.flatMap(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$k$Kk1Il2tP7ETjcvfv46rFa3Y4HIg(r6)), $$Lambda$k$VQ00o26vqPPyLtL8ePJWlephfc.INSTANCE), (Function1) ZeusTransformUtils.preCheckCast(ProactiveMappers$buildAgentRunCanonicalArtifacts$3.INSTANCE, Function1.class, "com.obric.memorydata.plugin")));
    L7:
        return CollectionsKt.emptyList();
    }
}
