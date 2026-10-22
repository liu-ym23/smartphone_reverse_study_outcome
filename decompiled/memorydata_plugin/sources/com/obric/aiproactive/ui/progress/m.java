package com.obric.aiproactive.ui.progress;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0000\u001a*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001H\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0014*\u00020\u000bH\u0002\u001a\u0012\u0010\u0015\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u000b0\u0001H\u0000\u001a\u001e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a\u0016\u0010\u0019\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001a.\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a\u0016\u0010\"\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a \u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a2\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\b\u0012\u0004\u0012\u00020\u000b0\u0001H\u0002\u001a&\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u00012\b\b\u0002\u0010,\u001a\u00020-H\u0002\u001a\f\u0010.\u001a\u00020-*\u00020\u0018H\u0000\u001a\u0014\u0010/\u001a\u0004\u0018\u00010\u000f*\b\u0012\u0004\u0012\u00020\u000b0\u0001H\u0000\u001a\u0012\u00100\u001a\u0004\u0018\u00010\u000f2\u0006\u00101\u001a\u00020\u000fH\u0000\u001a\u0012\u00102\u001a\u0004\u0018\u00010\u000f2\u0006\u00101\u001a\u00020\u000fH\u0000\u001a\f\u00103\u001a\u00020\u0014*\u00020\u000fH\u0000\u001a\"\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u00020\u000fH\u0000\u001a8\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u00142\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000fH\u0002\u001a \u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000fH\u0000\u001a\u0014\u0010@\u001a\u00020\u0014*\u0002092\u0006\u0010?\u001a\u00020\u000fH\u0002\u001a \u0010A\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000fH\u0000\u001a\f\u0010B\u001a\u00020\u001e*\u00020\u0018H\u0002\u001a\f\u0010C\u001a\u00020\u000f*\u00020\u0018H\u0002\u001a\u0012\u0010D\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a\u0018\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a\u001a\u0010F\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00180\u00012\u0006\u0010G\u001a\u00020\u000fH\u0002\u001a\u001a\u0010H\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00180\u00012\u0006\u0010G\u001a\u00020\u000fH\u0002\u001a\u0012\u0010I\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\u001a\u0016\u00106\u001a\u00020\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0002\"\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0KX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000f0KX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000f0KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"buildAgentRunUiSteps", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "mergeAgentRunTerminalOutcomeSteps", "conclusion", "result", "suggestionCount", "", "mergeAgentRunOutcomeGroups", "Lcom/obric/aiproactive/ui/progress/AgentRunUiGroup;", "conclusionGroups", "resultGroups", "mergeAgentRunOutcomeMarkdown", "", "conclusionMarkdown", "resultMarkdown", "withoutDuplicateTitleDetails", "dropPromotedJudgment", "", "isSingleJudgmentNarrative", "buildObservationStep", "observationSteps", "Lcom/obric/aiproactive/api/AiProactiveAgentRunStepDto;", "buildToolStage", "rawSteps", "fallbackGenericToolStageTitle", "stage", "state", "Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "buildTransientJudgmentStep", "planningSteps", "allSteps", "buildConclusionStep", "conclusionSteps", "buildResultStep", "resultSteps", "buildCompressSteps", "compressSteps", "sortedSteps", "withoutGroupTitles", "groupsFromPresentation", "steps", "listStyle", "Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;", "secondaryListStyle", "singleNarrativeTitle", "normalizeAgentRunNarrativeTitle", EventBody.KEY_VALUE, "normalizeAgentRunStageDisplayTitle", "isLegacyAgentRunStageContainerTitle", "fallbackAgentRunPhaseTitle", "stageType", "rawState", "toUiItem", "Lcom/obric/aiproactive/ui/progress/AgentRunUiItem;", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDisplayItemDto;", OaidModel.KEY_ID, "showState", "title", "description", "normalizeAgentRunItemTitle", "groupKey", "isOverflowExplanation", "normalizeAgentRunItemDescription", "toUiState", "semanticStageId", "semanticStageOrder", "latestByStepId", "lastSummaryOr", "fallback", "lastDisplaySubtitleOr", "lastDisplayMarkdown", "LEGACY_STAGE_CONTAINER_TITLES", "", "OBSERVATION_GROUP_KEYS", "SINGLE_NARRATIVE_GROUP_KEYS", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f6831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f6832b = null;
    private static final Set<String> c = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6833a = null;

        static {
            int[] r0 = new int[AgentRunUiState.values().length];
            r0[AgentRunUiState.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[AgentRunUiState.CANCELLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[AgentRunUiState.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[AgentRunUiState.PENDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[AgentRunUiState.COMPLETED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[AgentRunUiState.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f6833a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(m.c((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(m.c((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class e<T> implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J(\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"com/obric/aiproactive/ui/progress/AgentRunUiMapperKt$groupsFromPresentation$Bucket", "", "title", "", "items", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiItem;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/obric/aiproactive/ui/progress/AgentRunUiMapperKt$groupsFromPresentation$Bucket;", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<l> f6835b;

        public g(String r3, List<l> r4) {
            List<l> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r5, "items");
            this.f6834a = r3;
            this.f6835b = r5;
        }

        public final String a() {
            return this.f6834a;
        }

        public final List<l> b() {
            return this.f6835b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6834a, r6.f6834a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6835b, r6.f6835b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f6834a.hashCode() * 31) + this.f6835b.hashCode();
        }

        public String toString() {
            return "Bucket(title=" + this.f6834a + ", items=" + this.f6835b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class h<T> implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class i<T> implements Comparator {
        public i() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class j<T> implements Comparator {
        public j() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class k<T> implements Comparator {
        public k() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f6831a = SetsKt.setOf(new String[]{"我做了哪些核对", "技术详情", "我是怎么判断的", "我得出的结论", "现在需要你做什么"});
        f6832b = SetsKt.setOf(new String[]{"recent_activity", "current_state", "user_profile", "preference", "task"});
        c = SetsKt.setOf(new String[]{"judgment", "conclusion", "next_action"});
    }

    public static final AgentRunSecondaryListStyle a(com.obric.aiproactive.api.i r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3.w(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        switch(r0.hashCode()) {
            case -1643376751: goto L17;
            case -1207109523: goto L13;
            case 106748362: goto L9;
            case 504691636: goto L6;
            default: goto L21;
        };
    L6:
        if (r0.equals("unordered") == false) goto L21;
    L26:
        return AgentRunSecondaryListStyle.UNORDERED;
    L9:
        if (r0.equals("plain") == false) goto L21;
        return AgentRunSecondaryListStyle.PLAIN;
    L13:
        if (r0.equals("ordered") == false) goto L21;
    L28:
        return AgentRunSecondaryListStyle.ORDERED;
    L17:
        if (r0.equals("key_value") == false) goto L21;
        return AgentRunSecondaryListStyle.KEY_VALUE;
    L21:
        if (r3.j() >= 5) goto L26;
        if (Intrinsics.areEqual(r3.f(), "GeneralSearch") == false) goto L26;
        goto L26
    }

    private static final l a(com.obric.aiproactive.api.f r11, String r12, AgentRunUiState r13, boolean r14, String r15, String r16) {
        return new l(r12, r15, r16, r11.e(), r13, r14, r11.f(), r11.g());
    }

    private static final n a(com.obric.aiproactive.api.g r19, List<com.obric.aiproactive.api.i> r20) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r2.hasNext() == true) goto L5;
        Object r3 = null;
    L15:
        com.obric.aiproactive.api.i r4 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        AgentRunUiState r5 = b(r4);
    L18:
        AgentRunUiState r8 = r5;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r6.iterator();
    L28:
        if (r9.hasNext() == false) goto L30;
        CollectionsKt.addAll(r7, (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).y(), Iterable.class, "com.obric.memorydata.plugin"));
        goto L28
    L30:
        List<com.obric.aiproactive.ui.progress.k> r10 = com.obric.aiproactive.ui.progress.c.a("phase-observation", (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), r8);
        if (r4 == null) goto L34;
        String r11 = r4.d();
        if (r11 == null) goto L34;
    L35:
        String r12 = a("observation", r8, r11);
        switch(a.f6833a[r8.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L43;
            case 5: goto L43;
            case 6: goto L39;
            default: goto L38;
        };
    L39:
        String r1 = "暂时无法确认状态";
    L42:
        String r13 = r1;
    L45:
        return new n("phase-observation", r12, r13, r8, r10, "", false, null, null, null, null, null, 4032, null);
    L40:
        r1 = a(r0, "最近的信息没有读取完");
        goto L42
    L41:
        r1 = "本轮任务已停止";
        goto L42
    L43:
        r13 = "";
        goto L45
    L38:
        throw new NoWhenBranchMatchedException();
    L34:
        r11 = r19.c();
        goto L35
    L20:
        if (Intrinsics.areEqual(r19.c(), "failed") == false) goto L23;
        r5 = AgentRunUiState.FAILED;
        goto L18
    L23:
        if (Intrinsics.areEqual(r19.c(), "succeeded") == false) goto L25;
        r5 = AgentRunUiState.COMPLETED;
        goto L18
    L25:
        r5 = AgentRunUiState.RUNNING;
        goto L18
    L5:
        Object r14 = r2.next();
        if (r2.hasNext() == true) goto L8;
    L7:
        r3 = r14;
        goto L15
    L8:
        int r15 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r14, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
    L9:
        Object r16 = r2.next();
        int r17 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r16, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
        if (r15 >= r17) goto L13;
        r14 = r16;
        r15 = r17;
    L13:
        if (r2.hasNext() == true) goto L9;
        goto L7
    }

    private static final n a(com.obric.aiproactive.api.g r22, List<com.obric.aiproactive.api.i> r23, List<com.obric.aiproactive.api.i> r24) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r22.c(), "running") == true) goto L5;
        return null;
    L5:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r3.hasNext() == true) goto L8;
        Object r4 = null;
    L17:
        com.obric.aiproactive.api.i r5 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L21;
        return null;
    L21:
        if (StringsKt.startsWith$default(r5.c(), "planning_", false, 2, null) == true) goto L23;
        return null;
    L23:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r7.hasNext() == true) goto L26;
        Object r1 = null;
    L35:
        com.obric.aiproactive.api.i r6 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r1, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L38;
        return null;
    L38:
        AgentRunUiState r11 = b(r6);
        List r8 = a(CollectionsKt.listOf(r6), null, 2, null);
        String r9 = b(r8);
        if (r9 != null) goto L53;
        String r10 = b(r6.s());
        if (r10 != null) goto L52;
        int r12 = a.f6833a[r11.ordinal()];
        if (r12 == 1) goto L51;
        if (r12 == 2) goto L50;
        if (r12 == 3) goto L49;
        if (r12 == 6) goto L48;
        r10 = "已确定下一步";
        goto L52
    L48:
        r10 = "本轮判断状态未知";
        goto L52
    L49:
        r10 = "本轮判断没有完成";
        goto L52
    L50:
        r10 = "本轮判断已取消";
        goto L52
    L51:
        r10 = "分析下一步";
    L52:
        String r13 = r10;
    L54:
        if (r9 == null) goto L57;
        String r14 = "";
    L56:
        String r15 = r14;
        if (r9 != null) goto L73;
        List r16 = r8;
    L75:
        return new n("phase-current-judgment", r13, r15, r11, r16, r6.u(), false, null, null, null, null, null, 4032, null);
    L73:
        r16 = CollectionsKt.emptyList();
        goto L75
    L57:
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.t(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r17) == false) goto L70;
        int r18 = a.f6833a[r11.ordinal()];
        if (r18 == 1) goto L68;
        if (r18 == 2) goto L67;
        if (r18 == 3) goto L66;
        if (r18 == 6) goto L65;
        String r19 = "准备继续处理";
    L69:
        r17 = r19;
        goto L70
    L65:
        r19 = "暂时无法确认状态";
        goto L69
    L66:
        r19 = "稍后会重新尝试";
        goto L69
    L67:
        r19 = "本轮任务已停止";
        goto L69
    L68:
        r19 = "正在结合已有信息判断";
    L70:
        r14 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
        goto L56
    L53:
        r13 = r9;
        goto L54
    L26:
        r1 = r7.next();
        if (r7.hasNext() == false) goto L35;
        int r20 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r1, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
    L30:
        Object r21 = r7.next();
        int r25 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r21, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
        if (r20 >= r25) goto L34;
        r1 = r21;
        r20 = r25;
    L34:
        if (r7.hasNext() == true) goto L30;
    L8:
        r4 = r3.next();
        if (r3.hasNext() == false) goto L17;
        int r26 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
    L12:
        Object r27 = r3.next();
        int r28 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r27, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
        if (r26 >= r28) goto L16;
        r4 = r27;
        r26 = r28;
    L16:
        if (r3.hasNext() == true) goto L12;
        goto L17
    }

    public static final n a(n r20, n r21, int r22) {
        Intrinsics.checkNotNullParameter(r20, "conclusion");
        Intrinsics.checkNotNullParameter(r21, "result");
        if (r22 <= 0) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        n r5 = r21;
    L12:
        List<com.obric.aiproactive.ui.progress.k> r10 = a(r20.e(), r21.e());
        String r11 = a(r20.f(), r21.f());
        if (r20.g() == false) goto L15;
    L18:
        boolean r12 = true;
    L20:
        return a(n.a(r5, "phase-result", null, null, null, r10, r11, r12, null, null, null, null, null, 3982, null), false, 1, null);
    L15:
        if (r21.g() == true) goto L18;
        r12 = false;
        goto L20
    L11:
        r5 = r20;
        goto L12
    L5:
        if (r21.d() != AgentRunUiState.COMPLETED) goto L8;
        r4 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final n a(n r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r22, "<this>");
        String r0 = com.obric.aiproactive.ui.progress.i.b(r22.b());
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r22.e(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L3:
        Object r6 = null;
        if (r4.hasNext() == false) goto L45;
        com.obric.aiproactive.ui.progress.k r7 = (com.obric.aiproactive.ui.progress.k) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.aiproactive.ui.progress.k.class, "com.obric.memorydata.plugin");
        if (r23 == true) goto L8;
    L10:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r7.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r5.iterator();
    L12:
        if (r9.hasNext() == false) goto L40;
        l r10 = (l) ZeusTransformUtils.preCheckCast(r9.next(), l.class, "com.obric.memorydata.plugin");
        if (r10.d() == null) goto L17;
    L38:
        if (r10 == null) goto L12;
        r8.add(r10);
        goto L12
    L17:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10.c(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L38;
        String r11 = com.obric.aiproactive.ui.progress.i.b(r10.a());
        String r12 = com.obric.aiproactive.ui.progress.i.b(r10.b());
        if (Intrinsics.areEqual(r11, r0) == false) goto L27;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L24;
    L25:
        r10 = null;
        goto L38
    L24:
        if (Intrinsics.areEqual(r12, r0) == true) goto L25;
    L27:
        if (Intrinsics.areEqual(r11, r0) == false) goto L31;
        String r13 = null;
        String r14 = null;
        long r15 = 0;
        AgentRunUiState r16 = null;
        boolean r17 = false;
        String r18 = null;
        com.obric.aiproactive.api.d r19 = null;
        int r20 = 253;
        Object r21 = null;
        String r110 = "";
    L29:
        r10 = l.a(r10, r13, r110, r14, r15, r16, r17, r18, r19, r20, r21);
        goto L38
    L31:
        if (Intrinsics.areEqual(r12, r0) == false) goto L36;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L25;
    L36:
        if (Intrinsics.areEqual(r12, r0) == false) goto L38;
        r13 = null;
        r110 = null;
        r15 = 0;
        r16 = null;
        r17 = false;
        r18 = null;
        r19 = null;
        r20 = 251;
        r21 = null;
        r14 = "";
        goto L29
    L40:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.progress.k r25 = com.obric.aiproactive.ui.progress.k.a(r7, null, null, r24, null, 11, null);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L43;
        r6 = r25;
    L43:
        if (r6 == null) goto L3;
        r3.add(r6);
        goto L3
    L8:
        if (a(r7) == false) goto L10;
    L45:
        List r26 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        String r27 = r22.f();
        if (Intrinsics.areEqual(com.obric.aiproactive.ui.progress.i.b(r27), r0) == true) goto L48;
        r6 = r27;
    L48:
        if (r6 != null) goto L50;
        Object r1 = "";
    L52:
        return n.a(r22, null, null, null, null, r26, r1, false, null, null, null, null, null, 4047, null);
    L50:
        r1 = r6;
        goto L52
    }

    public static /* synthetic */ n a(n r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return a(r0, r1);
    }

    private static final String a(com.obric.aiproactive.api.i r3, AgentRunUiState r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.n(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = ChatMessage.TYPE_QUERY;
    L5:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (r3.p() == true) goto L8;
    L13:
        String r5 = r3.d();
        switch(r5.hashCode()) {
            case -1281977283: goto L59;
            case -682587753: goto L52;
            case 40661574: goto L45;
            case 476588369: goto L38;
            case 945734241: goto L31;
            case 1116313165: goto L24;
            case 1550783935: goto L17;
            default: goto L66;
        };
    L17:
        if (r5.equals("running") == false) goto L66;
        if (Intrinsics.areEqual(r1, "execute") == false) goto L22;
        return "正在执行一项操作";
    L22:
        return "正在查询信息";
    L24:
        if (r5.equals("waiting") == false) goto L66;
        if (Intrinsics.areEqual(r1, "execute") == false) goto L29;
        return "等待继续操作";
    L29:
        return "等待继续查询";
    L31:
        if (r5.equals("succeeded") == false) goto L66;
        if (Intrinsics.areEqual(r1, "execute") == false) goto L36;
        return "已完成一项操作";
    L36:
        return "已完成信息查询";
    L38:
        if (r5.equals("cancelled") == false) goto L66;
        if (Intrinsics.areEqual(r1, "execute") == false) goto L43;
        return "操作已取消";
    L43:
        return "信息查询已取消";
    L45:
        if (r5.equals("timed_out") == false) goto L66;
        if (Intrinsics.areEqual(r1, "execute") == false) goto L50;
        return "操作已超时";
    L50:
        return "信息查询已超时";
    L52:
        if (r5.equals("pending") == false) goto L66;
        if (Intrinsics.areEqual(r1, "execute") == false) goto L57;
        return "等待执行操作";
    L57:
        return "等待查询信息";
    L59:
        if (r5.equals("failed") == false) goto L66;
        if (Intrinsics.areEqual(r1, "execute") == false) goto L64;
        return "操作未完成";
    L64:
        return "信息查询未完成";
    L66:
        switch(a.f6833a[r4.ordinal()]) {
            case 1: goto L74;
            case 2: goto L73;
            case 3: goto L72;
            case 4: goto L71;
            case 5: goto L70;
            case 6: goto L69;
            default: goto L68;
        };
    L69:
        return "步骤状态未知";
    L70:
        return "已完成一个步骤";
    L71:
        return "等待处理";
    L72:
        return "一个步骤未完成";
    L73:
        return "步骤已取消";
    L74:
        return "正在处理";
    L68:
        throw new NoWhenBranchMatchedException();
    L8:
        if (r4 != AgentRunUiState.RUNNING) goto L10;
        return "等待你确认";
    L10:
        if (r4 != AgentRunUiState.PENDING) goto L13;
        return "等待你确认";
    }

    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (Intrinsics.areEqual(r3, "现有信息已足够，准备形成本轮结论") == false) goto L6;
        r3 = "现有信息已足够";
    L6:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        return null;
    L10:
        return r3;
    }

    public static final String a(String r7, AgentRunUiState r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "stageType");
        Intrinsics.checkNotNullParameter(r8, "state");
        Intrinsics.checkNotNullParameter(r9, "rawState");
        int r0 = r7.hashCode();
        if (r0 == (-1731259873)) goto L45;
        if (r0 == (-934426595)) goto L27;
        if (r0 != 122345516) goto L47;
        if (r7.equals("observation") == false) goto L47;
        if (Intrinsics.areEqual(r9, "cancelled") == false) goto L15;
        return "任务上下文准备已取消";
    L15:
        if (Intrinsics.areEqual(r9, "timed_out") == false) goto L18;
        return "任务上下文准备已超时";
    L18:
        switch(a.f6833a[r8.ordinal()]) {
            case 1: goto L25;
            case 2: goto L73;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            default: goto L20;
        };
    L21:
        return "任务上下文状态未知";
    L22:
        return "已准备任务上下文";
    L23:
        return "等待准备任务上下文";
    L24:
        return "任务上下文准备未完成";
    L25:
        return "正在准备任务上下文";
    L73:
        return "任务上下文准备已取消";
    L20:
        throw new NoWhenBranchMatchedException();
    L47:
        switch(a.f6833a[r8.ordinal()]) {
            case 1: goto L55;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L50;
            default: goto L49;
        };
    L50:
        return "步骤状态未知";
    L51:
        return "已完成一个步骤";
    L52:
        return "等待处理";
    L53:
        return "一个步骤未完成";
    L54:
        return "步骤已取消";
    L55:
        return "正在处理";
    L49:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r7.equals("result") == false) goto L47;
        if (Intrinsics.areEqual(r9, "cancelled") == false) goto L33;
    L79:
        return "任务结果生成已取消";
    L33:
        if (Intrinsics.areEqual(r9, "timed_out") == false) goto L36;
        return "任务结果生成已超时";
    L36:
        switch(a.f6833a[r8.ordinal()]) {
            case 1: goto L43;
            case 2: goto L79;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            default: goto L38;
        };
    L39:
        return "任务结果状态未知";
    L40:
        return "已生成任务结果";
    L41:
        return "等待生成任务结果";
    L42:
        return "任务结果生成未完成";
    L43:
        return "正在生成任务结果";
    L38:
        throw new NoWhenBranchMatchedException();
    L45:
        if (r7.equals("conclusion") == false) goto L47;
        if (Intrinsics.areEqual(r9, "cancelled") == false) goto L60;
    L92:
        return "任务结果整理已取消";
    L60:
        if (Intrinsics.areEqual(r9, "timed_out") == false) goto L63;
        return "任务结果整理已超时";
    L63:
        switch(a.f6833a[r8.ordinal()]) {
            case 1: goto L70;
            case 2: goto L92;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L67;
            case 6: goto L66;
            default: goto L65;
        };
    L66:
        return "任务结果整理状态未知";
    L67:
        return "已整理任务结果";
    L68:
        return "等待整理任务结果";
    L69:
        return "任务结果整理未完成";
    L70:
        return "正在整理任务结果";
    L65:
        throw new NoWhenBranchMatchedException();
    }

    private static final String a(String r11, String r12) {
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{r11, r12}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L4
    L6:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L13;
        Object r2 = r16.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        r1.add(r2);
        goto L8
    L13:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    public static final String a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "groupKey");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "description");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (Intrinsics.areEqual(r2, "conclusion") == false) goto L8;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        return r5;
    L8:
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private static final String a(List<com.obric.aiproactive.api.i> r4, String r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new j(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).e(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
    L9:
        com.obric.aiproactive.api.i r7 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        String r8 = r7.e();
        if (r8 != null) goto L14;
        return r5;
    L14:
        return r8;
    L18:
        return r5;
    L8:
        r0 = null;
        goto L9
    }

    public static final List<n> a(com.obric.aiproactive.api.g r16) {
        Intrinsics.checkNotNullParameter(r16, "run");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r16.g(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L6;
        if (((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).j() < 3) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L9;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L18;
        List<com.obric.aiproactive.api.i> r5 = h(r16.g());
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L20:
        n r9 = null;
        if (r8.hasNext() == false) goto L25;
        Object r10 = r8.next();
        if (StringsKt.startsWith$default(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r10, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).c(), "compress_", false, 2, null) == false) goto L20;
        r7.add(r10);
        goto L20
    L25:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L28;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L31:
        if (r14.hasNext() == false) goto L35;
        Object r15 = r14.next();
        if (StringsKt.startsWith$default(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r15, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).c(), "observation_", false, 2, null) == false) goto L31;
        r13.add(r15);
        goto L31
    L35:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L37:
        if (r20.hasNext() == false) goto L41;
        Object r110 = r20.next();
        if (StringsKt.startsWith$default(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r110, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).c(), "planning_", false, 2, null) == false) goto L37;
        r19.add(r110);
        goto L37
    L41:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r22.iterator();
    L43:
        if (r23.hasNext() == false) goto L54;
        Object r112 = r23.next();
        com.obric.aiproactive.api.i r113 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r112, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r113.f(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L47;
    L51:
        boolean r114 = false;
    L52:
        if (r114 == false) goto L43;
        r111.add(r112);
        goto L43
    L47:
        if (Intrinsics.areEqual(r113.f(), "Finish") == true) goto L51;
        if (StringsKt.startsWith$default(r113.c(), "tool_", false, 2, null) == false) goto L51;
        r114 = true;
        goto L52
    L54:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin");
        Iterable r115 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r116 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r117 = r115.iterator();
    L56:
        if (r117.hasNext() == false) goto L67;
        Object r118 = r117.next();
        com.obric.aiproactive.api.i r119 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r118, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default(r119.c(), "finish_", false, 2, null) == false) goto L60;
    L63:
        boolean r25 = true;
    L64:
        if (r25 == false) goto L56;
        r116.add(r118);
        goto L56
    L60:
        if (Intrinsics.areEqual(r119.f(), "Finish") == true) goto L63;
        r25 = false;
        goto L64
    L67:
        List r26 = (List) ZeusTransformUtils.preCheckCast(r116, List.class, "com.obric.memorydata.plugin");
        Iterable r120 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r121 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r122 = r120.iterator();
    L69:
        if (r122.hasNext() == false) goto L85;
        Object r123 = r122.next();
        com.obric.aiproactive.api.i r124 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r123, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default(r124.c(), "persist_", false, 2, null) == false) goto L73;
    L82:
        boolean r125 = true;
    L83:
        if (r125 == false) goto L69;
        r121.add(r123);
        goto L69
    L73:
        if (Intrinsics.areEqual(r124.c(), "run_succeeded") == true) goto L82;
        if (Intrinsics.areEqual(r124.c(), "run_failed") == true) goto L82;
        if (Intrinsics.areEqual(r124.c(), "run_cancelled") == true) goto L82;
        if (Intrinsics.areEqual(r124.c(), "run_timed_out") == true) goto L82;
        r125 = false;
        goto L83
    L85:
        List r27 = (List) ZeusTransformUtils.preCheckCast(r121, List.class, "com.obric.memorydata.plugin");
        boolean r28 = !Intrinsics.areEqual(r16.c(), "running");
        List<n> r126 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r28 == true) goto L88;
    L89:
        ((Collection) ZeusTransformUtils.preCheckCast(r126, Collection.class, "com.obric.memorydata.plugin")).add(a(r16, r17));
    L90:
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin");
        Map r30 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L92:
        if (r31.hasNext() == false) goto L97;
        Object r32 = r31.next();
        String r127 = c((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r32, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin"));
        Object r128 = r30.get(r127);
        if (r128 != null) goto L96;
        r128 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r30.put(r127, r128);
    L96:
        ((List) ZeusTransformUtils.preCheckCast(r128, List.class, "com.obric.memorydata.plugin")).add(r32);
        goto L92
    L97:
        Iterator r33 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r30.values(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L99:
        if (r33.hasNext() == false) goto L101;
        ((Collection) ZeusTransformUtils.preCheckCast(r126, Collection.class, "com.obric.memorydata.plugin")).add(d((List) ZeusTransformUtils.preCheckCast(r33.next(), List.class, "com.obric.memorydata.plugin")));
        goto L99
    L101:
        Collection r34 = (Collection) ZeusTransformUtils.preCheckCast(r126, Collection.class, "com.obric.memorydata.plugin");
        n r35 = a(r16, r21, r5);
        if (r35 == null) goto L105;
        r126.add(r35);
    L105:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r26, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L108;
        r26 = null;
    L108:
        if (r26 == null) goto L110;
        r9 = e(r26);
    L110:
        n r36 = b(r16, r27);
        if (r9 == null) goto L114;
        if (r36 == null) goto L114;
        ((Collection) ZeusTransformUtils.preCheckCast(r126, Collection.class, "com.obric.memorydata.plugin")).add(a(r9, r36, r16.f()));
    L118:
        return r126;
    L114:
        if (r9 == null) goto L116;
        ((Collection) ZeusTransformUtils.preCheckCast(r126, Collection.class, "com.obric.memorydata.plugin")).add(r9);
        goto L118
    L116:
        if (r36 == null) goto L118;
        ((Collection) ZeusTransformUtils.preCheckCast(r126, Collection.class, "com.obric.memorydata.plugin")).add(r36);
        goto L118
    L88:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L90;
    L28:
        return b(r16, r11, r5);
    L18:
        return o.a(r16);
    L13:
        r3 = false;
    L6:
        r4 = false;
        goto L16
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private static final List<com.obric.aiproactive.ui.progress.k> a(List<com.obric.aiproactive.api.i> r17, AgentRunSecondaryListStyle r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        LinkedHashMap r2 = new LinkedHashMap();
        HashSet r3 = new HashSet();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new f(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L35;
        com.obric.aiproactive.api.i r4 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        AgentRunUiState r11 = b(r4);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.y(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        char r13 = 0;
        int r5 = 0;
    L7:
        if (r12.hasNext() == false) goto L4;
        Object r6 = r12.next();
        int r14 = r5 + 1;
        if (r5 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        com.obric.aiproactive.api.f r7 = (com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r6, com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r8) == false) goto L14;
        r8 = "details";
    L14:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r10) == false) goto L17;
        r10 = com.obric.aiproactive.ui.progress.c.a(r9);
    L17:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
        if (a(r7, r9) == true) goto L32;
        String r16 = a(r9, r7.c(), r7.d());
        String r19 = b(r9, r16, r7.d());
        Iterator r110 = r1;
        StringBuilder r20 = new StringBuilder().append(r9).append(r13).append(r16).append(r13).append(r19).append(r13).append(r7.f()).append(r13);
        com.obric.aiproactive.api.d r111 = r7.g();
        if (r111 == null) goto L22;
        String r112 = r111.a();
    L23:
        if (r112 != null) goto L26;
        r112 = "";
    L26:
        if (r3.add(r20.append(r112).toString()) == false) goto L33;
        Map r21 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");
        Object r113 = r21.get(r9);
        if (r113 != null) goto L31;
        r113 = new g(r15, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        r21.put(r9, r113);
    L31:
        ((Collection) ZeusTransformUtils.preCheckCast(((g) ZeusTransformUtils.preCheckCast(r113, g.class, "com.obric.memorydata.plugin")).b(), Collection.class, "com.obric.memorydata.plugin")).add(a(r7, r4.a() + '-' + r5, r11, false, r16, r19));
    L34:
        r1 = r110;
        r5 = r14;
        r3 = r3;
        r13 = 0;
    L33:
        r3 = r3;
        goto L34
    L22:
        r112 = null;
        goto L23
    L32:
        r110 = r1;
        goto L33
    L35:
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r22.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.entrySet().iterator();
    L37:
        if (r24.hasNext() == false) goto L40;
        Map.Entry r25 = (Map.Entry) ZeusTransformUtils.preCheckCast(r24.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r26 = (String) ZeusTransformUtils.preCheckCast(r25.getKey(), String.class, "com.obric.memorydata.plugin");
        g r27 = (g) ZeusTransformUtils.preCheckCast(r25.getValue(), g.class, "com.obric.memorydata.plugin");
        r23.add(new com.obric.aiproactive.ui.progress.k(r26, r27.a(), r27.b(), r18));
        goto L37
    L40:
        return (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ List a(List r1, AgentRunSecondaryListStyle r2, int r3, Object r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L6;
        r2 = AgentRunSecondaryListStyle.UNORDERED;
    L6:
        return a(r5, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<com.obric.aiproactive.ui.progress.k> a(List<com.obric.aiproactive.ui.progress.k> r18, List<com.obric.aiproactive.ui.progress.k> r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        HashSet r3 = new HashSet();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r1.iterator();
    L4:
        if (r5.hasNext() == false) goto L22;
        com.obric.aiproactive.ui.progress.k r6 = (com.obric.aiproactive.ui.progress.k) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.aiproactive.ui.progress.k.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L6:
        Object r12 = null;
        if (r9.hasNext() == false) goto L16;
        Object r10 = r9.next();
        l r11 = (l) ZeusTransformUtils.preCheckCast(r10, l.class, "com.obric.memorydata.plugin");
        String[] r13 = new String[4];
        r13[0] = r11.a();
        r13[1] = r11.b();
        r13[2] = r11.c();
        com.obric.aiproactive.api.d r14 = r11.d();
        if (r14 == null) goto L11;
        r12 = r14.a();
    L11:
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        r13[3] = r12;
        if (r3.add(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r13), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\u0000", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$m$j3h1TkI0utyYHodncbIAzqh2u8.INSTANCE, 30, null)) == false) goto L6;
        r8.add(r10);
        goto L6
    L16:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        Object r16 = com.obric.aiproactive.ui.progress.k.a(r6, null, "", r15, null, 9, null);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
        r12 = r16;
    L19:
        if (r12 == null) goto L4;
        r4.add(r12);
        goto L4
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    }

    private static final boolean a(com.obric.aiproactive.api.f r5, String r6) {
        if (f6832b.contains(r6) == true) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r5.c(), "另有 ", false, 2, null) == true) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("参与了本轮判断", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static final boolean a(com.obric.aiproactive.ui.progress.k r6) {
        String r2 = null;
        if (Intrinsics.areEqual(r6.a(), "judgment") == false) goto L5;
    L6:
        l r7 = (l) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(r6.c()), l.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L9;
        r2 = r7.c();
    L9:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        if (r9 == false) goto L19;
        return true;
    L19:
        return false;
    L12:
        if (StringsKt.isBlank(r8) == true) goto L15;
        r9 = false;
        goto L16
    L5:
        if (StringsKt.endsWith$default(r6.a(), "-judgment", false, 2, null) == false) goto L19;
        goto L6
    }

    public static final boolean a(List<com.obric.aiproactive.ui.progress.k> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.obric.aiproactive.ui.progress.k r4 = (com.obric.aiproactive.ui.progress.k) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(r3), com.obric.aiproactive.ui.progress.k.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        if (a(r4) != true) goto L8;
        return true;
    L8:
        return false;
    }

    private static final AgentRunUiState b(com.obric.aiproactive.api.i r1) {
        String r2 = r1.d();
        switch(r2.hashCode()) {
            case -2146525273: goto L31;
            case -1281977283: goto L27;
            case -896145315: goto L25;
            case -682587753: goto L23;
            case 40661574: goto L20;
            case 476588369: goto L16;
            case 945734241: goto L13;
            case 1116313165: goto L10;
            case 1550783935: goto L6;
            default: goto L35;
        };
    L25:
        r2.equals("outcome_unknown");
        goto L35
    L6:
        if (r2.equals("running") == false) goto L35;
        return AgentRunUiState.RUNNING;
    L10:
        if (r2.equals("waiting") == false) goto L35;
    L40:
        return AgentRunUiState.PENDING;
    L13:
        if (r2.equals("succeeded") == false) goto L35;
        return AgentRunUiState.COMPLETED;
    L16:
        if (r2.equals("cancelled") == false) goto L35;
        return AgentRunUiState.CANCELLED;
    L20:
        if (r2.equals("timed_out") == false) goto L35;
    L39:
        return AgentRunUiState.FAILED;
    L23:
        if (r2.equals("pending") == true) goto L40;
    L27:
        if (r2.equals("failed") == true) goto L39;
    L31:
        if (r2.equals("accepted") == true) goto L40;
    L35:
        return AgentRunUiState.UNKNOWN;
    }

    private static final n b(com.obric.aiproactive.api.g r21, List<com.obric.aiproactive.api.i> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r2.hasNext() == true) goto L5;
        Object r3 = null;
    L14:
        com.obric.aiproactive.api.i r4 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L17;
        String r5 = r4.c();
    L19:
        if (Intrinsics.areEqual(r5, "run_cancelled") == false) goto L21;
    L44:
        AgentRunUiState r6 = AgentRunUiState.CANCELLED;
    L45:
        AgentRunUiState r10 = r6;
        if (Intrinsics.areEqual(r21.c(), "succeeded") == true) goto L48;
    L50:
        boolean r7 = false;
    L52:
        if (r10 == AgentRunUiState.PENDING) goto L56;
        if (r7 == true) goto L56;
        List<com.obric.aiproactive.ui.progress.k> r8 = f(a(r0, null, 2, null));
    L57:
        String r9 = b(r8);
        if (r4 == null) goto L62;
        String r11 = r4.s();
        if (r11 == null) goto L62;
        String r12 = b(r11);
    L63:
        String r13 = i(r0);
        if (r12 == null) goto L66;
    L99:
        boolean r14 = true;
    L101:
        if (r10 != AgentRunUiState.COMPLETED) goto L106;
        if (r7 == true) goto L106;
        if (r14 == true) goto L106;
        return null;
    L106:
        if (r9 != null) goto L114;
        if (r12 != null) goto L113;
        if (r4 == null) goto L111;
        String r15 = r4.d();
        if (r15 == null) goto L111;
    L112:
        String r16 = a("result", r10, r15);
    L115:
        if (r9 == null) goto L119;
        String r1 = "";
    L117:
        String r17 = r1;
        if (r9 != null) goto L137;
        List<com.obric.aiproactive.ui.progress.k> r18 = r8;
    L139:
        return new n("phase-result", r16, r17, r10, r18, r13, false, null, null, null, null, null, 4032, null);
    L137:
        r18 = CollectionsKt.emptyList();
        goto L139
    L119:
        if (r10 != AgentRunUiState.RUNNING) goto L123;
        String r19 = "正在形成处理结果";
    L121:
        r1 = b(r0, r19);
        goto L117
    L123:
        if (r10 != AgentRunUiState.PENDING) goto L126;
        r1 = "等待前面的步骤完成";
        goto L117
    L126:
        if (r10 != AgentRunUiState.CANCELLED) goto L130;
        String r20 = "本轮任务已停止";
    L128:
        r1 = a(r0, r20);
        goto L117
    L130:
        if (r10 != AgentRunUiState.FAILED) goto L132;
        r20 = "本轮没有完成，稍后会再次尝试";
        goto L128
    L132:
        if (r7 == false) goto L134;
        r1 = 26377 + r21.f() + "个值得关注的事情";
        goto L117
    L134:
        r19 = "暂时不需要你处理";
    L111:
        r15 = r21.c();
        goto L112
    L113:
        r16 = r12;
        goto L115
    L114:
        r16 = r9;
        goto L115
    L66:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L99;
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r110, Collection.class) == true) goto L70;
    L72:
        Iterator r111 = r110.iterator();
    L74:
        if (r111.hasNext() == false) goto L71;
        Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.ui.progress.k) ZeusTransformUtils.preCheckCast(r111.next(), com.obric.aiproactive.ui.progress.k.class, "com.obric.memorydata.plugin")).c(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r112, Collection.class) == true) goto L78;
    L80:
        Iterator r113 = r112.iterator();
    L82:
        if (r113.hasNext() == false) goto L79;
        l r114 = (l) ZeusTransformUtils.preCheckCast(r113.next(), l.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r114.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L86;
    L91:
        boolean r23 = true;
    L92:
        if (r23 == false) goto L82;
        boolean r24 = true;
    L94:
        if (r24 == false) goto L74;
        boolean r25 = true;
    L96:
        if (r25 == true) goto L99;
        r14 = false;
        goto L101
    L86:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r114.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L91;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r114.c(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L91;
        r23 = false;
    L79:
        r24 = false;
        goto L94
    L78:
        if (((Collection) ZeusTransformUtils.preCheckCast(r112, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L80;
    L71:
        r25 = false;
        goto L96
    L70:
        if (((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L72;
    L62:
        r12 = null;
    L56:
        r8 = CollectionsKt.emptyList();
        goto L57
    L48:
        if (r21.f() <= 0) goto L50;
        r7 = true;
        goto L52
    L21:
        if (Intrinsics.areEqual(r21.c(), "cancelled") == true) goto L44;
        if (r4 == null) goto L25;
        String r26 = r4.c();
    L27:
        if (Intrinsics.areEqual(r26, "run_failed") == false) goto L29;
    L43:
        r6 = AgentRunUiState.FAILED;
        goto L45
    L29:
        if (Intrinsics.areEqual(r21.c(), "failed") == true) goto L43;
        if (r4 == null) goto L33;
        String r27 = r4.c();
    L35:
        if (Intrinsics.areEqual(r27, "run_succeeded") == false) goto L37;
    L42:
        r6 = AgentRunUiState.COMPLETED;
        goto L45
    L37:
        if (Intrinsics.areEqual(r21.c(), "succeeded") == true) goto L42;
        if (r4 == null) goto L41;
        r6 = b(r4);
        goto L45
    L41:
        r6 = AgentRunUiState.PENDING;
        goto L45
    L33:
        r27 = null;
        goto L35
    L25:
        r26 = null;
        goto L27
    L17:
        r5 = null;
        goto L19
    L5:
        r3 = r2.next();
        if (r2.hasNext() == false) goto L14;
        int r28 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
    L9:
        Object r29 = r2.next();
        int r30 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r29, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
        if (r28 >= r30) goto L13;
        r3 = r29;
        r28 = r30;
    L13:
        if (r2.hasNext() == true) goto L9;
        goto L14
    }

    public static final String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        String r3 = a(r2);
        if (r3 == null) goto L8;
        if (f6831a.contains(r3) == true) goto L8;
        return r3;
    L8:
        return null;
    }

    public static final String b(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "groupKey");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "description");
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
    L15:
        return "";
    L9:
        if (Intrinsics.areEqual(r6, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == true) goto L15;
        if (Intrinsics.areEqual(r3, "conclusion") == false) goto L14;
        return "";
    L14:
        return r6;
    L5:
        r0 = false;
        goto L7
    }

    public static final String b(List<com.obric.aiproactive.ui.progress.k> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        com.obric.aiproactive.ui.progress.k r12 = (com.obric.aiproactive.ui.progress.k) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(r11), com.obric.aiproactive.ui.progress.k.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
        return null;
    L5:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        boolean r7 = false;
        if (Intrinsics.areEqual(r12.a(), r5) == false) goto L11;
    L12:
        r7 = true;
    L13:
        if (r7 == false) goto L7;
    L16:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L19;
        return null;
    L19:
        l r13 = (l) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(r12.c()), l.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L23;
        return null;
    L23:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13.c(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L26;
        return null;
    L26:
        if (Intrinsics.areEqual(r4, "judgment") == false) goto L30;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.b(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L34;
        r0 = r13.a();
    L34:
        return a((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
    L30:
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L34;
        r0 = r13.b();
        goto L34
    L11:
        if (StringsKt.endsWith$default(r12.a(), '-' + r5, false, 2, null) == false) goto L13;
    L15:
        r3 = null;
        goto L16
    }

    private static final String b(List<com.obric.aiproactive.api.i> r4, String r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new i(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).t(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
    L9:
        com.obric.aiproactive.api.i r7 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        String r8 = r7.t();
        if (r8 != null) goto L14;
        return r5;
    L14:
        return r8;
    L18:
        return r5;
    L8:
        r0 = null;
        goto L9
    }

    private static final List<n> b(com.obric.aiproactive.api.g r20, List<com.obric.aiproactive.api.i> r21, List<com.obric.aiproactive.api.i> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r3.hasNext() == true) goto L5;
        Object r4 = null;
    L15:
        com.obric.aiproactive.api.i r5 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L20;
        AgentRunUiState r6 = b(r5);
    L18:
        AgentRunUiState r9 = r6;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L28:
        if (r10.hasNext() == false) goto L30;
        CollectionsKt.addAll(r8, (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).y(), Iterable.class, "com.obric.memorydata.plugin"));
        goto L28
    L30:
        List<com.obric.aiproactive.ui.progress.k> r11 = com.obric.aiproactive.ui.progress.c.a("phase-compress", (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), r9);
        List r12 = CollectionsKt.createListBuilder();
        if (r5 == null) goto L34;
        String r13 = r5.d();
        if (r13 == null) goto L34;
    L35:
        String r14 = a("observation", r9, r13);
        switch(a.f6833a[r9.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L43;
            case 5: goto L43;
            case 6: goto L39;
            default: goto L38;
        };
    L39:
        String r1 = "暂时无法确认状态";
    L42:
        String r15 = r1;
    L44:
        r12.add(new n("phase-compress", r14, r15, r9, r11, "", false, null, null, null, null, null, 4032, null));
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L46:
        if (r18.hasNext() == false) goto L56;
        Object r19 = r18.next();
        com.obric.aiproactive.api.i r23 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r19, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r23.c(), "run_succeeded") == false) goto L50;
    L53:
        boolean r24 = true;
    L54:
        if (r24 == false) goto L46;
        r17.add(r19);
        goto L46
    L50:
        if (Intrinsics.areEqual(r23.c(), "run_failed") == true) goto L53;
        r24 = false;
        goto L54
    L56:
        n r25 = b(r20, (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"));
        if (r25 == null) goto L60;
        r12.add(r25);
    L60:
        return CollectionsKt.build(r12);
    L40:
        r1 = a(r0, "已有上下文没有整理完");
        goto L42
    L41:
        r1 = "本轮任务已停止";
        goto L42
    L43:
        r15 = "";
        goto L44
    L38:
        throw new NoWhenBranchMatchedException();
    L34:
        r13 = r20.c();
        goto L35
    L20:
        if (Intrinsics.areEqual(r20.c(), "failed") == false) goto L23;
        r6 = AgentRunUiState.FAILED;
        goto L18
    L23:
        if (Intrinsics.areEqual(r20.c(), "succeeded") == false) goto L25;
        r6 = AgentRunUiState.COMPLETED;
        goto L18
    L25:
        r6 = AgentRunUiState.RUNNING;
        goto L18
    L5:
        Object r26 = r3.next();
        if (r3.hasNext() == true) goto L8;
    L7:
        r4 = r26;
        goto L15
    L8:
        int r27 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r26, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
    L9:
        Object r28 = r3.next();
        int r29 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r28, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
        if (r27 >= r29) goto L13;
        r26 = r28;
        r27 = r29;
    L13:
        if (r3.hasNext() == true) goto L9;
        goto L9
    }

    public static final /* synthetic */ int c(List r2) {
        return g((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    private static final String c(com.obric.aiproactive.api.i r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.k(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L6;
        r0 = r3.a();
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    public static final boolean c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return f6831a.contains(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString());
    }

    private static final n d(List<com.obric.aiproactive.api.i> r18) {
        List r0 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new e(), Comparator.class, "com.obric.memorydata.plugin"));
        com.obric.aiproactive.api.i r2 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        AgentRunUiState r7 = j(r0);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.asReversed(r0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        String r5 = null;
        if (r3.hasNext() == false) goto L11;
        String r4 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).q();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L3;
    L12:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.asReversed(r0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        String r8 = b(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).s());
        if (r8 == null) goto L14;
        r5 = r8;
    L19:
        if (r2.p() == true) goto L21;
    L26:
        if (r5 != null) goto L30;
        String r1 = a(r2, r7);
    L28:
        r5 = r1;
    L30:
        if (r2.p() == false) goto L35;
        if (r7 != AgentRunUiState.RUNNING) goto L35;
        String r9 = "确认后再继续";
    L50:
        return new n("stage-" + c(r2), r5, r9, r7, a(r0, a(r2)), i(r0), false, null, null, null, null, null, 4032, null);
    L35:
        if (r7 != AgentRunUiState.RUNNING) goto L40;
        String r10 = "正在补充相关信息";
    L37:
        r9 = b(r0, r10);
        goto L50
    L40:
        if (r7 != AgentRunUiState.CANCELLED) goto L43;
        r10 = "本次处理已停止";
        goto L37
    L43:
        if (r7 != AgentRunUiState.FAILED) goto L46;
        r10 = "本次核对没有完成";
        goto L37
    L46:
        if (r7 != AgentRunUiState.PENDING) goto L48;
        r9 = "等待开始";
        goto L50
    L48:
        r10 = "已完成信息核对";
        goto L37
    L21:
        if (r7 != AgentRunUiState.RUNNING) goto L26;
        if (r4 == null) goto L25;
        r1 = "需要你确认：" + r4;
        if (r1 != null) goto L28;
    L25:
        r1 = "等待你确认";
        goto L28
    L11:
        r4 = null;
        goto L12
    }

    private static final CharSequence d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.ui.progress.i.b(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final n e(List<com.obric.aiproactive.api.i> r19) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r0.hasNext() == true) goto L5;
        Object r2 = null;
    L14:
        if (r2 == null) goto L46;
        com.obric.aiproactive.api.i r1 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        AgentRunUiState r8 = b(r1);
        List<com.obric.aiproactive.ui.progress.k> r3 = f(a(CollectionsKt.listOf(r1), null, 2, null));
        String r4 = b(r3);
        if (r4 != null) goto L21;
        String r5 = b(r1.s());
        if (r5 != null) goto L20;
        r5 = a("conclusion", r8, r1.d());
    L20:
        String r6 = r5;
    L22:
        if (r4 == null) goto L26;
        String r7 = "";
    L24:
        String r9 = r7;
        if (r4 != null) goto L42;
        List<com.obric.aiproactive.ui.progress.k> r10 = r3;
    L44:
        return new n("phase-conclusion", r6, r9, r8, r10, r1.u(), false, null, null, null, null, null, 4032, null);
    L42:
        r10 = CollectionsKt.emptyList();
        goto L44
    L26:
        switch(a.f6833a[r8.ordinal()]) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L30;
            case 6: goto L29;
            default: goto L28;
        };
    L29:
        r7 = "暂时无法确认状态";
        goto L24
    L30:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.t(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r11) == false) goto L37;
        r11 = "已完成是否提醒的判断";
    L37:
        r7 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
        goto L24
    L33:
        r7 = "等待信息核对完成";
        goto L24
    L34:
        r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.t(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r11) == false) goto L37;
        r11 = "本轮结论还需要重新整理";
        goto L37
    L38:
        r7 = "本轮任务已停止";
        goto L24
    L39:
        r7 = "正在形成是否需要提醒你的结论";
        goto L24
    L28:
        throw new NoWhenBranchMatchedException();
    L21:
        r6 = r4;
        goto L22
    L46:
        throw new IllegalStateException("conclusion steps must not be empty".toString());
    L5:
        r2 = r0.next();
        if (r0.hasNext() == false) goto L14;
        int r12 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
    L9:
        Object r13 = r0.next();
        int r14 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r13, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
        if (r12 >= r14) goto L13;
        r2 = r13;
        r12 = r14;
    L13:
        if (r0.hasNext() == true) goto L9;
        goto L14
    }

    private static final List<com.obric.aiproactive.ui.progress.k> f(List<com.obric.aiproactive.ui.progress.k> r10) {
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r0.add(com.obric.aiproactive.ui.progress.k.a((com.obric.aiproactive.ui.progress.k) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.aiproactive.ui.progress.k.class, "com.obric.memorydata.plugin"), null, "", null, null, 13, null));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final int g(List<com.obric.aiproactive.api.i> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L3:
        Comparable r4 = null;
        if (r1.hasNext() == false) goto L13;
        Integer r3 = Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).l());
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        r4 = r3;
    L11:
        if (r4 == null) goto L3;
        r2.add(r4);
        goto L3
    L8:
        r5 = false;
        goto L9
    L13:
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L39;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r9.hasNext() == false) goto L26;
        Comparable r10 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin");
    L20:
        r4 = r10;
    L22:
        if (r9.hasNext() == false) goto L26;
        r10 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h()), Comparable.class, "com.obric.memorydata.plugin");
        if (r4.compareTo(r10) <= 0) goto L22;
    L26:
        Integer r11 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L40;
        return Integer.MAX_VALUE;
    L40:
        return r11.intValue();
    L39:
        return r8.intValue();
    }

    private static final List<com.obric.aiproactive.api.i> h(List<com.obric.aiproactive.api.i> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Object r2 = r9.next();
        String r3 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).a();
        Object r4 = r0.get(r3);
        if (r4 != null) goto L8;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r0.put(r3, r4);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).add(r2);
        goto L4
    L9:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r0.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L29;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11.next(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r5.hasNext() == true) goto L15;
        Object r6 = null;
    L25:
        com.obric.aiproactive.api.i r12 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r6, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L11;
        r1.add(r12);
        goto L11
    L15:
        Object r13 = r5.next();
        if (r5.hasNext() == true) goto L18;
    L17:
        r6 = r13;
        goto L25
    L18:
        int r14 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r13, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
    L19:
        Object r15 = r5.next();
        int r16 = ((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r15, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).h();
        if (r14 >= r16) goto L23;
        r13 = r15;
        r14 = r16;
    L23:
        if (r5.hasNext() == true) goto L19;
    L29:
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new k(), Comparator.class, "com.obric.memorydata.plugin"));
    }

    private static final String i(List<com.obric.aiproactive.api.i> r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new h(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        String r2 = null;
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).u(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L3;
    L9:
        com.obric.aiproactive.api.i r7 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r0, com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L12;
        r2 = r7.u();
    L12:
        if (r2 != null) goto L18;
        return "";
    L18:
        return r2;
    L8:
        r0 = null;
        goto L9
    }

    private static final AgentRunUiState j(List<com.obric.aiproactive.api.i> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (Intrinsics.areEqual(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).d(), "running") == false) goto L9;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L97;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L18;
    L20:
        Iterator r4 = r3.iterator();
    L22:
        if (r4.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).d(), "cancelled") == false) goto L22;
        boolean r5 = true;
    L26:
        if (r5 == true) goto L98;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L31;
    L33:
        Iterator r9 = r6.iterator();
    L35:
        if (r9.hasNext() == false) goto L32;
        com.obric.aiproactive.api.i r10 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10.d(), "failed") == false) goto L39;
    L42:
        boolean r11 = true;
    L43:
        if (r11 == false) goto L35;
        boolean r12 = true;
    L45:
        if (r12 == true) goto L99;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L50;
    L52:
        Iterator r14 = r13.iterator();
    L54:
        if (r14.hasNext() == false) goto L51;
        com.obric.aiproactive.api.i r15 = (com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r15.d(), "pending") == false) goto L58;
    L61:
        boolean r16 = true;
    L62:
        if (r16 == false) goto L54;
        boolean r17 = true;
    L64:
        if (r17 == true) goto L100;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L69;
    L71:
        Iterator r19 = r18.iterator();
    L73:
        if (r19.hasNext() == false) goto L77;
        if (Intrinsics.areEqual(((com.obric.aiproactive.api.i) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.aiproactive.api.i.class, "com.obric.memorydata.plugin")).d(), "succeeded") == false) goto L73;
    L77:
        return AgentRunUiState.COMPLETED;
    L69:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L71;
    L100:
        return AgentRunUiState.PENDING;
    L58:
        if (Intrinsics.areEqual(r15.d(), "waiting") == true) goto L61;
        r16 = false;
    L51:
        r17 = false;
        goto L64
    L50:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L52;
    L99:
        return AgentRunUiState.FAILED;
    L39:
        if (Intrinsics.areEqual(r10.d(), "timed_out") == true) goto L42;
        r11 = false;
    L32:
        r12 = false;
        goto L45
    L31:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L33;
    L98:
        return AgentRunUiState.CANCELLED;
    L19:
        r5 = false;
        goto L26
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L20;
    L97:
        return AgentRunUiState.RUNNING;
    L6:
        r2 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$j3h1TkI0utyYHodnc-bIAzqh2u8, reason: not valid java name */
    public static /* synthetic */ CharSequence m341lambda$j3h1TkI0utyYHodncbIAzqh2u8(String r0) {
        return d(r0);
    }
}
