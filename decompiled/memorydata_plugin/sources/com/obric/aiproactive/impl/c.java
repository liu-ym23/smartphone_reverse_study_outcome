package com.obric.aiproactive.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.aiproactive.api.ProactiveDayHeaderDto;
import com.obric.aiproactive.api.ProactiveDayPageResult;
import com.obric.aiproactive.api.ProactiveInspirationDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.ProactiveSubscriptionTaskDto;
import com.obric.aiproactive.api.ProactiveUserSubscriptionDto;
import com.obric.aiproactive.api.s;
import com.obric.aiproactive.api.t;
import com.obric.aiproactive.api.x;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.et;
import com.obric.memorydata.database.entity.ez;
import com.obric.memorydata.database.entity.fc;
import com.obric.memorydata.database.entity.fd;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\rH\u0000\u001a2\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0000\u001a$\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u001aH\u0002\u001a,\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010 \u001a\u00020\u0003H\u0000\u001a\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0003H\u0000\u001a\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e*\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0002\u001a\u0012\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e*\u00020'H\u0002\u001a2\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u0006\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0000\u001aB\u00101\u001a\u0002022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u0002002\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u00106\u001a\u00020\u0018H\u0000\u001a,\u00107\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u0006\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0018H\u0000\u001a\u0018\u0010:\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0018H\u0002\u001a2\u0010;\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u0006\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0000\u001a.\u0010<\u001a\u0002022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u0006\u00106\u001a\u00020\u00182\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u000200H\u0000\u001a2\u0010=\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020>0\u001e2\u0006\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0000\u001a@\u0010?\u001a\u0002022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020>0\u001e2\u0006\u00106\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u0002002\b\b\u0002\u0010-\u001a\u00020.H\u0000\u001a\u0016\u0010@\u001a\u00020\u00182\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001eH\u0000\u001a\u0016\u0010A\u001a\u00020\u00182\f\u0010*\u001a\b\u0012\u0004\u0012\u00020>0\u001eH\u0002\u001a\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001eH\u0002\u001a\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020>0\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020>0\u001eH\u0002\u001a\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001eH\u0000\u001a\u0018\u0010E\u001a\b\u0012\u0004\u0012\u00020+0\u001e*\b\u0012\u0004\u0012\u00020+0\u001eH\u0002\u001a\u0018\u0010F\u001a\b\u0012\u0004\u0012\u00020>0\u001e*\b\u0012\u0004\u0012\u00020>0\u001eH\u0002\u001a*\u0010G\u001a\b\u0012\u0004\u0012\u00020>0\u001e2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020>0\u001e2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020>0\u001eH\u0000\u001a\u0018\u0010J\u001a\u0004\u0018\u00010+2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001eH\u0000\u001a\u0018\u0010K\u001a\b\u0012\u0004\u0012\u00020>0\u001e*\b\u0012\u0004\u0012\u00020L0\u001eH\u0000\u001a\f\u0010M\u001a\u00020>*\u00020LH\u0002\u001a\u0014\u00103\u001a\u00020\u0003*\u00020>2\u0006\u0010-\u001a\u00020.H\u0002\u001a\f\u0010N\u001a\u00020\u0018*\u00020>H\u0002\u001a\f\u0010O\u001a\u00020\u0003*\u00020>H\u0002\u001a\u0012\u0010P\u001a\u0004\u0018\u00010\u00032\u0006\u0010Q\u001a\u00020RH\u0000\u001a\f\u0010S\u001a\u00020>*\u00020+H\u0000\u001a\u001a\u0010T\u001a\u00020\u00032\b\u0010U\u001a\u0004\u0018\u00010\u00032\u0006\u0010V\u001a\u00020\u0003H\u0000\u001a\u000e\u0010W\u001a\u00020\u000b*\u0004\u0018\u00010\u0003H\u0002\u001a\u0014\u00103\u001a\u00020\u0003*\u00020+2\u0006\u0010-\u001a\u00020.H\u0002\u001a\f\u0010[\u001a\u00020\u0018*\u00020+H\u0002\u001a\u0014\u0010\\\u001a\u00020]*\u00020^2\u0006\u0010_\u001a\u00020\u0018H\u0002\u001a\f\u0010`\u001a\u00020^*\u00020]H\u0002\u001a\u0014\u0010\\\u001a\u00020a*\u00020b2\u0006\u0010_\u001a\u00020\u0018H\u0002\u001a\f\u0010`\u001a\u00020b*\u00020aH\u0002\u001a\u0014\u0010\\\u001a\u00020L*\u00020>2\u0006\u0010_\u001a\u00020\u0018H\u0002\u001a.\u0010\\\u001a\u00020\u001a*\u00020c2\u0006\u0010d\u001a\u00020\u00182\u0006\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\u00182\b\u0010g\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e*\u0004\u0018\u00010\u0003H\u0002\u001a\u0010\u0010i\u001a\u00020$2\u0006\u0010j\u001a\u00020\u0003H\u0000\u001a\u001c\u0010k\u001a\u0004\u0018\u00010\u00032\u0006\u0010l\u001a\u00020m2\b\b\u0002\u0010n\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010Y\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"AI_PROACTIVE_DAY_KEY_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "DOUBAO_GLASSES_STATE_KEY_CONNECTED_STATE", "", "DOUBAO_GLASSES_STATE_KEY_PHYSICAL_CONNECTION_STATE", "DOUBAO_GLASSES_STATE_KEY_ENVIRONMENT_MEMORY_ENABLED", "DOUBAO_GLASSES_CONNECTED_STATE_CONNECTED", "DOUBAO_GLASSES_CONNECTED_STATE_DISCONNECTED", "requestAllRecommendationsRefreshAfterClientWrite", "", "wrote", "", "requestRefresh", "Lkotlin/Function1;", "applyEnvironmentMemoryEnabledState", "enabled", "updateRuntimeState", "markConfigured", "Lkotlin/Function0;", "resolveInspirationFeedbackBase", "Lcom/obric/aiproactive/impl/InspirationFeedbackBase;", "existingByInspirationId", "latestByRecommendId", "requestCreated", "", "toFeedbackBase", "Lcom/obric/memorydata/database/entity/ProactiveInspirationEntity;", "buildAiProactiveLabelingFeedbackConfig", "Lcom/obric/aiproactive/api/AiProactiveLabelingFeedbackConfigDto;", "positiveReasons", "", "negativeReasons", "placeholder", "parseAiProactiveFeedbackSettings", "raw", "optStringList", "Lorg/json/JSONObject;", ActivityLifecycle.NAME, "toStringList", "Lorg/json/JSONArray;", "buildAiProactiveAllPageSnapshot", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "recommendations", "Lcom/obric/aiproactive/api/AiProactiveRecommendationDto;", "nowMillis", "zoneId", "Ljava/time/ZoneId;", "firstPageLimit", "", "buildAiProactiveDayPageResult", "Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "dayKey", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "batchId", "filterAiProactiveRecommendationsByCreatedWindow", "earliestTimeMillis", "latestTimeMillis", "isValidLabelingWindow", "buildAiProactiveWindowPageSnapshot", "buildAiProactiveWindowPageResult", "buildCompatAllPageSnapshot", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "buildCompatDayPageResult", "computeAiProactiveBatchId", "computeCompatBatchId", "sortAiProactiveRecommendations", "sortCompatRecommendations", "pickLatestAiRecommendationBatch", "filterDisplayableAiRecommendations", "filterDisplayableCompatRecommendations", "mergeLabelingCompatRows", "aiRows", "legacyRows", "selectLatestAiRecommendationTop1", "toLegacyLabelingCompatDtos", "Lcom/obric/memorydata/database/entity/ProactiveRecommendationEntity;", "toLegacyLabelingCompatDto", "proactiveStableIdHash", "proactiveIdentity", "mapAiCardStatusToLiveCardFeedbackAction", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "toCompatRecommendationDto", "buildAiProactiveDisplayMarkdown", "recommendTitle", "recommendText", "isVoteOnlyAiFeedback", "AI_PROACTIVE_LIVE_CARD_FEEDBACK_IGNORE", "AI_PROACTIVE_LIVE_CARD_FEEDBACK_GET", "AI_PROACTIVE_LIVE_CARD_FEEDBACK_EXECUTE_NOW", "effectiveCreatedAt", "toEntity", "Lcom/obric/memorydata/database/entity/ProactiveUserSubscriptionEntity;", "Lcom/obric/aiproactive/api/ProactiveUserSubscriptionDto;", "now", "toDto", "Lcom/obric/memorydata/database/entity/ProactiveSubscriptionTaskEntity;", "Lcom/obric/aiproactive/api/ProactiveSubscriptionTaskDto;", "Lcom/obric/aiproactive/api/ProactiveInspirationDto;", "created", "updated", "timestamp", "recommendationSnapshot", "toStringListFromJsonArray", "parseInvokeTaskJson", "jsonString", "validateAiProactiveUserRequirement", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;", "normalizedContent", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateTimeFormatter f6434a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6435a = null;

        static {
            int[] r0 = new int[AiProactiveCardStatus.values().length];
            r0[AiProactiveCardStatus.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AiProactiveCardStatus.DISMISSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AiProactiveCardStatus.ACKNOWLEDGED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AiProactiveCardStatus.EXECUTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f6435a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r7, T r8) {
            Iterator<T> r6 = ((Iterable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r8, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            Comparable r1 = null;
            if (r6.hasNext() == true) goto L5;
            Comparable r9 = null;
        L11:
            Long r10 = (Long) ZeusTransformUtils.preCheckCast(r9, Long.class, "com.obric.memorydata.plugin");
            long r2 = 0;
            if (r10 == null) goto L14;
            long r4 = r10.longValue();
        L15:
            Comparable r11 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r4), Comparable.class, "com.obric.memorydata.plugin");
            Iterator<T> r12 = ((Iterable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            if (r12.hasNext() == false) goto L25;
            Comparable r13 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(c.b((t) ZeusTransformUtils.preCheckCast(r12.next(), t.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin");
        L19:
            r1 = r13;
        L21:
            if (r12.hasNext() == false) goto L25;
            r13 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(c.b((t) ZeusTransformUtils.preCheckCast(r12.next(), t.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin");
            if (r1.compareTo(r13) >= 0) goto L21;
        L25:
            Long r14 = (Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L29;
            r2 = r14.longValue();
        L29:
            return ComparisonsKt.compareValues(r11, (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r2), Comparable.class, "com.obric.memorydata.plugin"));
        L14:
            r4 = 0;
            goto L15
        L5:
            r9 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(c.b((t) ZeusTransformUtils.preCheckCast(r6.next(), t.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin");
        L7:
            if (r6.hasNext() == false) goto L11;
            Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(c.b((t) ZeusTransformUtils.preCheckCast(r6.next(), t.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin");
            if (r9.compareTo(r3) >= 0) goto L7;
            r9 = r3;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0284c<T> implements Comparator {
        public C0284c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r7, T r8) {
            Iterator<T> r6 = ((Iterable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r8, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            Comparable r1 = null;
            if (r6.hasNext() == true) goto L5;
            Comparable r9 = null;
        L11:
            Long r10 = (Long) ZeusTransformUtils.preCheckCast(r9, Long.class, "com.obric.memorydata.plugin");
            long r2 = 0;
            if (r10 == null) goto L14;
            long r4 = r10.longValue();
        L15:
            Comparable r11 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r4), Comparable.class, "com.obric.memorydata.plugin");
            Iterator<T> r12 = ((Iterable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            if (r12.hasNext() == false) goto L25;
            Comparable r13 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r12.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin");
        L19:
            r1 = r13;
        L21:
            if (r12.hasNext() == false) goto L25;
            r13 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r12.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin");
            if (r1.compareTo(r13) >= 0) goto L21;
        L25:
            Long r14 = (Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L29;
            r2 = r14.longValue();
        L29:
            return ComparisonsKt.compareValues(r11, (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r2), Comparable.class, "com.obric.memorydata.plugin"));
        L14:
            r4 = 0;
            goto L15
        L5:
            r9 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r6.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin");
        L7:
            if (r6.hasNext() == false) goto L11;
            Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r6.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin");
            if (r9.compareTo(r3) >= 0) goto L7;
            r9 = r3;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6436a;

        public e(Comparator r3) {
            this.f6436a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r2 = this.f6436a.compare(r3, r4);
            if (r2 != 0) goto L15;
            int r5 = ((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).i();
            if (r5 != null) goto L9;
            r5 = Integer.MIN_VALUE;
        L9:
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin");
            int r7 = ((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin")).i();
            if (r7 != null) goto L14;
            r7 = Integer.MIN_VALUE;
        L14:
            return ComparisonsKt.compareValues(r6, (Comparable) ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.memorydata.plugin"));
        L15:
            return r2;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6437a;

        public f(Comparator r3) {
            this.f6437a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6437a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class g<T> implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r2, t.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class h<T> implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            Integer r2 = ((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).i();
            if (r2 == null) goto L5;
            Object r5 = ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.memorydata.plugin");
        L6:
            Comparable r6 = (Comparable) r5;
            Integer r7 = ((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin")).i();
            if (r7 == null) goto L9;
            Object r8 = ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.memorydata.plugin");
        L11:
            return ComparisonsKt.compareValues(r6, (Comparable) r8);
        L9:
            r8 = ZeusTransformUtils.preCheckCast(Integer.MIN_VALUE, Comparable.class, "com.obric.memorydata.plugin");
            goto L11
        L5:
            r5 = ZeusTransformUtils.preCheckCast(Integer.MIN_VALUE, Comparable.class, "com.obric.memorydata.plugin");
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class i<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6438a;

        public i(Comparator r3) {
            this.f6438a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6438a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class j<T> implements Comparator {
        public j() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class k<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6439a;

        public k(Comparator r3) {
            this.f6439a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r2 = this.f6439a.compare(r3, r4);
            if (r2 != 0) goto L15;
            int r5 = ((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).i();
            if (r5 != null) goto L9;
            r5 = Integer.MIN_VALUE;
        L9:
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin");
            int r7 = ((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin")).i();
            if (r7 != null) goto L14;
            r7 = Integer.MIN_VALUE;
        L14:
            return ComparisonsKt.compareValues(r6, (Comparable) ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.memorydata.plugin"));
        L15:
            return r2;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class l<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6440a;

        public l(Comparator r3) {
            this.f6440a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6440a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class m<T> implements Comparator {
        public m() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getCreated()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class n<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6441a;

        public n(Comparator r3) {
            this.f6441a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6441a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getScore()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getScore()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class o<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6442a;

        public o(Comparator r3) {
            this.f6442a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6442a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(c.a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(c.a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r4, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin"))), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        DateTimeFormatter r0 = DateTimeFormatter.ISO_LOCAL_DATE;
        Intrinsics.checkNotNullExpressionValue(r0, "ISO_LOCAL_DATE");
        f6434a = r0;
    }

    public static final /* synthetic */ long a(ProactiveRecommendationDto r2) {
        return b(r2);
    }

    public static final long a(List<t> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "recommendations");
        if (r11.isEmpty() == false) goto L5;
        return 0;
    L5:
        long r4 = 1125899906842597L;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new f((Comparator) ZeusTransformUtils.preCheckCast(new e((Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r12.hasNext() == false) goto L18;
        t r0 = (t) ZeusTransformUtils.preCheckCast(r12.next(), t.class, "com.obric.memorydata.plugin");
        long r6 = 31;
        long r5 = ((((((((r4 * r6) + r0.a()) * r6) + r0.s()) * r6) + ((long) r0.l().ordinal())) * r6) + r0.r()) * r6;
        String r8 = r0.m();
        if (r8 == null) goto L11;
        long r9 = r8.hashCode();
    L12:
        long r7 = (r5 + r9) * r6;
        com.obric.aiproactive.api.b r1 = (com.obric.aiproactive.api.b) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r0.f()), com.obric.aiproactive.api.b.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L15;
        long r13 = r1.hashCode();
    L16:
        r4 = r7 + r13;
        goto L7
    L15:
        r13 = 0;
        goto L16
    L11:
        r9 = 0;
        goto L12
    L18:
        if (r4 != Long.MIN_VALUE) goto L21;
        return 0;
    L21:
        return Math.abs(r4);
    }

    public static final ProactiveAllPageSnapshot a(List<t> r9, long r10, ZoneId r12, int r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "recommendations");
        Intrinsics.checkNotNullParameter(r12, "zoneId");
        List<t> r14 = h(j(r11));
        long r1 = a(r14);
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L9;
        Object r3 = r16.next();
        String r4 = a((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin"), r12);
        Object r5 = r0.get(r4);
        if (r5 != null) goto L8;
        r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r0.put(r4, r5);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).add(r3);
        goto L4
    L9:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r0.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L11:
        if (r18.hasNext() == false) goto L13;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.preCheckCast(r6.getValue(), List.class, "com.obric.memorydata.plugin");
        r2.add(new ProactiveDayHeaderDto(r7, LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), f6434a).atStartOfDay(r12).toInstant().toEpochMilli(), r8.size()));
        goto L11
    L13:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), r13), Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r110.iterator();
    L15:
        if (r111.hasNext() == false) goto L17;
        r20.add(a((t) ZeusTransformUtils.preCheckCast(r111.next(), t.class, "com.obric.memorydata.plugin")));
        goto L15
    L17:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin");
        if (r14.size() <= r13) goto L20;
        boolean r22 = true;
    L22:
        return new ProactiveAllPageSnapshot(r1, r19, r21, r22);
    L20:
        r22 = false;
        goto L22
    }

    public static final ProactiveDayPageResult a(List<t> r10, long r11, int r13, int r14) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "recommendations");
        if (r14 <= 0) goto L17;
        if (r13 < 0) goto L17;
        List<t> r3 = h(j(r2));
        List r1 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), r13), Iterable.class, "com.obric.memorydata.plugin"), r14);
        if ((r13 + r1.size()) >= r3.size()) goto L9;
        boolean r0 = true;
    L10:
        boolean r8 = r0;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L12:
        if (r6.hasNext() == false) goto L15;
        r5.add(a((t) ZeusTransformUtils.preCheckCast(r6.next(), t.class, "com.obric.memorydata.plugin")));
        goto L12
    L15:
        return new ProactiveDayPageResult(r11, "window", r8, (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));
    L9:
        r0 = false;
    L17:
        return new ProactiveDayPageResult(r11, "window", false, CollectionsKt.emptyList());
    }

    public static final ProactiveDayPageResult a(List<ProactiveRecommendationDto> r9, long r10, String r12, int r13, int r14, ZoneId r15) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "recommendations");
        Intrinsics.checkNotNullParameter(r12, "dayKey");
        Intrinsics.checkNotNullParameter(r15, "zoneId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L20;
        if (r14 <= 0) goto L20;
        if (r13 < 0) goto L20;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(i(k(r4)), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r8, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin"), r15), r12) == false) goto L9;
        r6.add(r8);
        goto L9
    L13:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        List r11 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), r13), Iterable.class, "com.obric.memorydata.plugin"), r14);
        if ((r13 + r11.size()) >= r2.size()) goto L16;
        boolean r0 = true;
    L18:
        return new ProactiveDayPageResult(r10, r12, r0, r11);
    L16:
        r0 = false;
    L20:
        return new ProactiveDayPageResult(r10, r12, false, CollectionsKt.emptyList());
    }

    public static final ProactiveRecommendationDto a(t r39) {
        Intrinsics.checkNotNullParameter(r39, "<this>");
        com.obric.aiproactive.api.n r0 = com.obric.aiproactive.api.c.c(r39.f());
        String r2 = r0.c();
        if (r2 == null) goto L9;
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r3 == null) goto L9;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        String r14 = r3;
    L10:
        boolean r7 = false;
        if (r39.l() == AiProactiveCardStatus.PENDING) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L19;
    L17:
        AiProactiveCardStatus r6 = AiProactiveCardStatus.PENDING;
    L24:
        if (r4 == false) goto L28;
    L25:
        String r5 = r39.m();
    L26:
        String r28 = r5;
    L34:
        String r8 = r39.n();
        if (r8 == null) goto L41;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r9 == null) goto L41;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L41;
        String r30 = r9;
    L42:
        String r10 = r39.o();
        if (r10 == null) goto L49;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r11 == null) goto L49;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L49;
        String r31 = r11;
    L50:
        List r12 = CollectionsKt.listOfNotNull(new String[]{r30, r31});
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L54;
        r12 = null;
    L54:
        if (r12 == null) goto L56;
        String r29 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L57:
        String r13 = String.valueOf(r39.a());
        String r15 = a(r39.d(), r39.c());
        String r16 = r39.g();
        if (r16 != null) goto L60;
        String r17 = "";
    L61:
        String r18 = com.obric.aiproactive.api.c.a(r0);
        List r19 = CollectionsKt.emptyList();
        long r110 = c(r39);
        Integer r1 = r39.i();
        if (r1 == null) goto L64;
        int r20 = r1.intValue();
    L65:
        double r21 = r20;
        String r22 = r39.j();
        if (r22 != null) goto L70;
        r22 = r39.k();
        if (r22 != null) goto L70;
        String r23 = "";
    L71:
        String r24 = r39.k();
        int r25 = a.f6435a[r6.ordinal()];
        if (r25 != 1) goto L74;
        int r26 = 1;
    L84:
        String r27 = r6.name();
        Integer r32 = r39.h();
        if (r32 != null) goto L87;
    L94:
        Long r210 = null;
    L96:
        return new ProactiveRecommendationDto(r13, "", "", r15, r17, r18, r14, null, r19, r110, r21, r23, r24, r26, r27, AutoMemoryViewModel.SOURCE_AI_PROACTIVE, r210, String.valueOf(r39.a()), r28, r29, r30, r31, r39.p(), r39.s(), r39.b(), r39.q(), r39.t());
    L87:
        if (((Number) ZeusTransformUtils.preCheckCast(r32, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L89;
        r7 = true;
    L89:
        if (r7 == true) goto L92;
        r32 = null;
    L92:
        if (r32 == null) goto L94;
        r210 = Long.valueOf(c(r39) + (((long) ((Number) ZeusTransformUtils.preCheckCast(r32, Number.class, "com.obric.memorydata.plugin")).intValue()) * 1000));
        goto L96
    L74:
        if (r25 != 2) goto L76;
    L82:
        r26 = 2;
        goto L84
    L76:
        if (r25 == 3) goto L82;
        if (r25 == 4) goto L82;
        throw new NoWhenBranchMatchedException();
    L70:
        r23 = r22;
        goto L71
    L64:
        r20 = 0;
        goto L65
    L60:
        r17 = r16;
        goto L61
    L56:
        r29 = null;
    L49:
        r31 = null;
    L41:
        r30 = null;
        goto L42
    L28:
        if (c(r39.m()) == true) goto L25;
        if (r6 != AiProactiveCardStatus.DISMISSED) goto L33;
        r5 = "ignore";
        goto L26
    L33:
        r28 = null;
        goto L34
    L19:
        if (r39.l() == AiProactiveCardStatus.DISMISSED) goto L21;
    L23:
        r6 = r39.l();
        goto L24
    L21:
        if (c(r39.m()) == false) goto L23;
    L13:
        if (StringsKt.equals(r39.m(), "auto_dismiss", true) == false) goto L15;
        r4 = true;
    L9:
        r14 = null;
        goto L10
    }

    private static final ProactiveRecommendationDto a(ez r36) {
        if (r36.o() <= 0) goto L7;
        long r0 = r36.o();
    L5:
        long r12 = r0;
        return new ProactiveRecommendationDto(r36.a(), r36.b(), r36.c(), r36.d(), r36.e(), null, r36.f(), r36.g(), d(r36.h()), r12, r36.l(), r36.m(), null, 1, r36.n(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE, Long.valueOf(r12 + ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS), r36.a(), null, null, null, null, null, r36.j(), r36.o(), null, null, 108003328, null);
    L7:
        if (r36.i() <= 0) goto L9;
        r0 = r36.i();
        goto L5
    L9:
        r0 = r36.j();
        goto L5
    }

    public static final /* synthetic */ ProactiveSubscriptionTaskDto a(fc r0) {
        return b(r0);
    }

    public static final /* synthetic */ ProactiveUserSubscriptionDto a(fd r0) {
        return b(r0);
    }

    public static final s a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "raw");
        JSONObject r0 = new JSONObject(r3);
        List<String> r4 = a(r0, "like_reasons");
        List<String> r1 = a(r0, "dislike_reasons");
        String r2 = r0.optString("feedback_placeholder");
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return a(r4, r1, r2);
    }

    public static final s a(List<String> r8, List<String> r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "positiveReasons");
        Intrinsics.checkNotNullParameter(r12, "negativeReasons");
        Intrinsics.checkNotNullParameter(r10, "placeholder");
        Collection r0 = CollectionsKt.listOf(new String[]{"提醒及时", "符合偏好", "判断合理", "建议有效", IRecommendSettings.ProfileTag.OTHER});
        Collection r2 = CollectionsKt.listOf(new String[]{"时机不对", "不够重要", "类似过多", "不合理", "不够有效", IRecommendSettings.ProfileTag.OTHER});
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin");
        if (r13.isEmpty() == true) goto L6;
        r0 = r13;
    L6:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin");
        if (r15.isEmpty() == true) goto L10;
        r2 = r15;
    L10:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r17) == false) goto L14;
        r17 = "请补充这条提醒为什么值得保留或为什么不合适，方便后续优化。";
    L14:
        return new s(r14, r16, (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin"));
    }

    public static final com.obric.aiproactive.impl.b a(com.obric.aiproactive.impl.b r0, com.obric.aiproactive.impl.b r1, long r2) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L6;
        return new com.obric.aiproactive.impl.b(r2, null);
    L6:
        return r1;
    L7:
        return r0;
    }

    public static final /* synthetic */ com.obric.aiproactive.impl.b a(et r0) {
        return b(r0);
    }

    public static final /* synthetic */ et a(ProactiveInspirationDto r0, long r1, long r3, long r5, String r7) {
        return b(r0, r1, r3, r5, r7);
    }

    public static final /* synthetic */ ez a(ProactiveRecommendationDto r0, long r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ fc a(ProactiveSubscriptionTaskDto r0, long r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ fd a(ProactiveUserSubscriptionDto r0, long r1) {
        return b(r0, r1);
    }

    public static final String a(AiProactiveCardStatus r1) {
        Intrinsics.checkNotNullParameter(r1, "cardStatus");
        int r2 = a.f6435a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return null;
    L5:
        if (r2 != 2) goto L7;
        return "ignore";
    L7:
        if (r2 != 3) goto L9;
        return "get";
    L9:
        if (r2 != 4) goto L12;
        return "execute_now";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    private static final String a(ProactiveRecommendationDto r2, ZoneId r3) {
        String r4 = LocalDate.ofInstant(Instant.ofEpochMilli(r2.getCreated()), r3).format(f6434a);
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return r4;
    }

    private static final String a(t r2, ZoneId r3) {
        String r4 = LocalDate.ofInstant(Instant.ofEpochMilli(c(r2)), r3).format(f6434a);
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return r4;
    }

    public static final String a(x r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r5, "normalizedContent");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L9;
        return "invalid_content";
    L9:
        if (r4.b() > 0) goto L12;
        return "invalid_request_id";
    L12:
        if (r4.c() > 0) goto L15;
        return "invalid_submitted_at";
    L15:
        if (Intrinsics.areEqual(r4.d(), "proactive_home_input") == true) goto L17;
        return "invalid_source";
    L17:
        return null;
    L5:
        r6 = false;
        goto L6
    }

    public static final String a(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "recommendText");
        if (r12 == null) goto L37;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r14 == null) goto L37;
        Object r3 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r14 = null;
    L10:
        if (r14 == null) goto L37;
        String r0 = StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"**" + r14 + "**", r14}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r5.hasNext() == false) goto L26;
        Object r6 = r5.next();
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r0, r9) == false) goto L18;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L14;
        r3 = r6;
        goto L26
    L18:
        if (StringsKt.startsWith$default(r0, r9 + '\n', false, 2, null) == true) goto L23;
        if (StringsKt.startsWith$default(r0, r9 + "\r\n", false, 2, null) == true) goto L23;
        r10 = false;
    L26:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L32;
        String r1 = StringsKt.trimStart(StringsKt.removePrefix(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")), new char[]{'\n', '\r', ' '});
        if (r1 == null) goto L32;
        r13 = r1;
    L32:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L34;
        StringBuilder r15 = new StringBuilder().append("**").append(r14).append("**");
    L36:
        return r15.toString();
    L34:
        r15 = new StringBuilder().append("**").append(r14).append("**\n").append(r13);
    L37:
        return r13;
    }

    public static final List<t> a(List<t> r7, long r8, long r10) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "recommendations");
        if (b(r8, r10) == false) goto L5;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L17;
        Object r2 = r12.next();
        long r3 = c((t) ZeusTransformUtils.preCheckCast(r2, t.class, "com.obric.memorydata.plugin"));
        boolean r6 = false;
        if (r8 <= r3) goto L12;
    L14:
        if (r6 == false) goto L8;
        r0.add(r2);
        goto L8
    L12:
        if (r3 > r10) goto L14;
        r6 = true;
        goto L14
    L17:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    public static final List<ProactiveRecommendationDto> a(List<ProactiveRecommendationDto> r5, List<ProactiveRecommendationDto> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "aiRows");
        Intrinsics.checkNotNullParameter(r8, "legacyRows");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        ProactiveRecommendationDto r2 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r9.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(c(r2), r2);
        goto L4
    L6:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        ProactiveRecommendationDto r11 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r10.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(c(r11), r11);
        goto L8
    L10:
        Collection r12 = r0.values();
        Intrinsics.checkNotNullExpressionValue(r12, "<get-values>(...)");
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final List<String> a(JSONArray r6) {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = r6.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        String r4 = r6.optString(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L10;
        r0.add(r5);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return r0;
    }

    private static final List<String> a(JSONObject r0, String r1) {
        JSONArray r2 = r0.optJSONArray(r1);
        if (r2 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a(r2);
    }

    public static final void a(boolean r2, Function1<? super String, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "requestRefresh");
        if (r2 == false) goto L6;
        r4.invoke("client_write");
        return;
    }

    public static final void a(boolean r2, Function1<? super Boolean, Unit> r3, Function0<Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "updateRuntimeState");
        Intrinsics.checkNotNullParameter(r6, "markConfigured");
        r5.invoke(Boolean.valueOf(r2));
        if (r2 == false) goto L6;
        r6.invoke();
        return;
    }

    public static final /* synthetic */ boolean a(long r0, long r2) {
        return b(r0, r2);
    }

    private static final long b(ProactiveRecommendationDto r2) {
        return c(r2).hashCode();
    }

    public static final /* synthetic */ long b(t r2) {
        return c(r2);
    }

    public static final ProactiveAllPageSnapshot b(List<ProactiveRecommendationDto> r9, long r10, ZoneId r12, int r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "recommendations");
        Intrinsics.checkNotNullParameter(r12, "zoneId");
        List<ProactiveRecommendationDto> r14 = i(k(r11));
        long r3 = g(r14);
        String r15 = LocalDate.ofInstant(Instant.ofEpochMilli(r10), r12).format(f6434a);
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L4:
        if (r18.hasNext() == false) goto L9;
        Object r0 = r18.next();
        String r2 = a((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r0, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin"), r12);
        Object r5 = r17.get(r2);
        if (r5 != null) goto L8;
        r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r17.put(r2, r5);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).add(r0);
        goto L4
    L9:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r17.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0284c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r19.iterator();
    L11:
        if (r20.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.memorydata.plugin");
        r1.add(new ProactiveDayHeaderDto(r6, LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), f6434a).atStartOfDay(r12).toInstant().toEpochMilli(), r7.size()));
        goto L11
    L13:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        List r21 = (List) ZeusTransformUtils.preCheckCast(r17.get(r15), List.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L16;
        r21 = CollectionsKt.emptyList();
    L16:
        List r22 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin"), r13);
        if (r21.size() <= r13) goto L19;
        boolean r23 = true;
    L21:
        return new ProactiveAllPageSnapshot(r3, r8, r22, r23);
    L19:
        r23 = false;
        goto L21
    }

    private static final ProactiveSubscriptionTaskDto b(fc r13) {
        return new ProactiveSubscriptionTaskDto(r13.a(), r13.b(), r13.c(), r13.d(), r13.e(), null, "", r13.f(), r13.g());
    }

    private static final ProactiveUserSubscriptionDto b(fd r10) {
        return new ProactiveUserSubscriptionDto(r10.a(), r10.b(), r10.c(), r10.d(), r10.e(), r10.f());
    }

    private static final com.obric.aiproactive.impl.b b(et r3) {
        return new com.obric.aiproactive.impl.b(r3.h(), r3.g());
    }

    private static final et b(ProactiveInspirationDto r20, long r21, long r23, long r25, String r27) {
        return new et(r20.getInspirationId(), r20.getTaskId(), r20.getRecommendId(), r20.getRecommendStatus(), r20.getFeedbackAction(), r20.getUserFeedback(), r27, r21, r23, false, r25, 0, 2048, null);
    }

    private static final ez b(ProactiveRecommendationDto r26, long r27) {
        return new ez(r26.getRecommendId(), r26.getTaskId(), r26.getSubscriptionId(), r26.getRecommendText(), r26.getEmoji(), r26.getActionExecuteInstruction(), r26.getActionContext(), new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r26.getSourcePackages(), Collection.class, "com.obric.memorydata.plugin")).toString(), r26.getCreated(), r27, false, r26.getScore(), r26.getReason(), r26.getStatus(), r26.getType(), r27, 0, 65536, null);
    }

    private static final fc b(ProactiveSubscriptionTaskDto r18, long r19) {
        return new fc(r18.getTaskId(), r18.getTaskDescription(), r18.getTaskState(), r18.getSourceTaskId(), r18.getSubscriptionId(), r18.getCreated(), r19, false, 0, 0, 768, null);
    }

    private static final fd b(ProactiveUserSubscriptionDto r17, long r18) {
        return new fd(r17.getSubscriptionId(), r17.getContent(), r17.getUiData(), r17.isActive(), r17.getCreated(), r18, !r17.isActive(), 0, 0, 384, null);
    }

    public static final List<t> b(List<t> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "recommendations");
        if (r6.isEmpty() == true) goto L5;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Long r3 = ((t) ZeusTransformUtils.preCheckCast(r1.next(), t.class, "com.obric.memorydata.plugin")).q();
        if (r3 == null) goto L8;
        r2.add(r3);
        goto L8
    L12:
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Long.class, "com.obric.memorydata.plugin");
        t r7 = (t) ZeusTransformUtils.preCheckCast(CollectionsKt.maxWithOrNull((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new g(), Comparator.class, "com.obric.memorydata.plugin")), t.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        if (r4 == null) goto L24;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((t) ZeusTransformUtils.preCheckCast(r11, t.class, "com.obric.memorydata.plugin")).q(), r4) == false) goto L19;
        r9.add(r11);
        goto L19
    L23:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    L25:
        List<t> r13 = j(r12);
        if (r13.isEmpty() == false) goto L30;
        return CollectionsKt.emptyList();
    L30:
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new i((Comparator) ZeusTransformUtils.preCheckCast(new h(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
    L24:
        r12 = CollectionsKt.listOf(r7);
        goto L25
    L15:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public static final JSONObject b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "jsonString");
        return new JSONObject(r1);
    }

    private static final boolean b(long r2, long r4) {
        if (r2 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r4 < r2) goto L7;
        return true;
    }

    private static final long c(t r4) {
        if (r4.b() <= 0) goto L6;
        return r4.b();
    L6:
        if (r4.r() <= 0) goto L9;
        return r4.r();
    L9:
        return r4.s();
    }

    private static final String c(ProactiveRecommendationDto r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5.getInspirationId(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5.getRecommendId(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L5:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r1) == false) goto L8;
        r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5.getTaskId(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L8:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r2) == false) goto L12;
        r2 = "created:" + r5.getCreated();
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    }

    public static final List<ProactiveRecommendationDto> c(List<ez> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        Object r2 = r9.next();
        ez r3 = (ez) ZeusTransformUtils.preCheckCast(r2, ez.class, "com.obric.memorydata.plugin");
        boolean r5 = true;
        if (r3.k() == false) goto L8;
    L10:
        r5 = false;
    L11:
        if (r5 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.d(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L10;
    L13:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L18;
        r1.add(a((ez) ZeusTransformUtils.preCheckCast(r11.next(), ez.class, "com.obric.memorydata.plugin")));
        goto L15
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    private static final boolean c(String r1) {
        if (Intrinsics.areEqual(r1, "LIKE") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "DISLIKE") == true) goto L8;
        return false;
    }

    public static final /* synthetic */ long d(List r2) {
        return g((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    private static final List<String> d(String r8) {
        if (r8 == null) goto L5;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L11;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        JSONArray r3 = new JSONArray(r9);     // Catch: Throwable -> L25
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r3.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L25
    L14:
        if (r11.hasNext() == false) goto L23;
        String r5 = r3.optString(((IntIterator) ZeusTransformUtils.preCheckCast(r11, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());     // Catch: Throwable -> L25
        if (r5 != null) goto L18;
    L20:
        r5 = null;
    L21:
        if (r5 == null) goto L14;
        r4.add(r5);     // Catch: Throwable -> L25
        goto L14
    L18:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L20;
    L23:
        Object r12 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
    L27:
        Throwable r0 = Result.m1424exceptionOrNullimpl(r12);
        if (r0 == null) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveService", "sourcePackages parse failed: " + r0.getMessage(), null, 4, null);
        r12 = CollectionsKt.emptyList();
    L32:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    L25:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L27
    L11:
        return CollectionsKt.emptyList();
    L5:
        r9 = null;
        goto L6
    }

    public static final /* synthetic */ List e(List r2) {
        return k((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ List f(List r2) {
        return j((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    private static final long g(List<ProactiveRecommendationDto> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == false) goto L5;
        return 0;
    L5:
        long r4 = 1125899906842597L;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(i(r11), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r12.hasNext() == false) goto L50;
        ProactiveRecommendationDto r0 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r12.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        long r6 = 31;
        long r5 = ((((((((((r4 * r6) + ((long) r0.getRecommendId().hashCode())) * r6) + ((long) r0.getTaskId().hashCode())) * r6) + ((long) r0.getSubscriptionId().hashCode())) * r6) + ((long) r0.getRecommendText().hashCode())) * r6) + ((long) r0.getEmoji().hashCode())) * r6;
        String r8 = r0.getActionCondition();
        if (r8 == null) goto L11;
        long r9 = r8.hashCode();
    L12:
        long r7 = (r5 + r9) * r6;
        String r13 = r0.getActionExecuteInstruction();
        if (r13 == null) goto L15;
        long r14 = r13.hashCode();
    L16:
        long r15 = (r7 + r14) * r6;
        String r16 = r0.getActionContext();
        if (r16 == null) goto L19;
        long r17 = r16.hashCode();
    L20:
        long r18 = (((((((((r15 + r17) * r6) + ((long) r0.getSourcePackages().hashCode())) * r6) + r0.getCreated()) * r6) + Double.doubleToLongBits(r0.getScore())) * r6) + ((long) r0.getReason().hashCode())) * r6;
        String r19 = r0.getEvidence();
        if (r19 == null) goto L23;
        long r20 = r19.hashCode();
    L24:
        long r21 = (((((((r18 + r20) * r6) + ((long) r0.getRecommendStatus())) * r6) + ((long) r0.getStatus().hashCode())) * r6) + ((long) r0.getType().hashCode())) * r6;
        Long r22 = r0.getExpireAtMs();
        if (r22 == null) goto L27;
        long r23 = r22.longValue();
    L28:
        long r24 = (((r21 + r23) * r6) + ((long) r0.getInspirationId().hashCode())) * r6;
        String r25 = r0.getInspirationFeedbackAction();
        if (r25 == null) goto L31;
        long r26 = r25.hashCode();
    L32:
        long r27 = (r24 + r26) * r6;
        String r28 = r0.getInspirationUserFeedback();
        if (r28 == null) goto L35;
        long r29 = r28.hashCode();
    L36:
        long r30 = (r27 + r29) * r6;
        String r31 = r0.getInspirationFeedbackReason();
        if (r31 == null) goto L39;
        long r32 = r31.hashCode();
    L40:
        long r33 = (r30 + r32) * r6;
        String r34 = r0.getInspirationFeedbackText();
        if (r34 == null) goto L43;
        long r35 = r34.hashCode();
    L44:
        long r36 = (r33 + r35) * r6;
        Integer r37 = r0.getInspirationFeedbackValue();
        if (r37 == null) goto L47;
        long r38 = r37.intValue();
    L48:
        r4 = ((((r36 + r38) * r6) + r0.getInspirationUpdated()) * r6) + r0.getInspirationTimestamp();
        goto L7
    L47:
        r38 = 0;
        goto L48
    L43:
        r35 = 0;
        goto L44
    L39:
        r32 = 0;
        goto L40
    L35:
        r29 = 0;
        goto L36
    L31:
        r26 = 0;
        goto L32
    L27:
        r23 = 0;
        goto L28
    L23:
        r20 = 0;
        goto L24
    L19:
        r17 = 0;
        goto L20
    L15:
        r14 = 0;
        goto L16
    L11:
        r9 = 0;
        goto L12
    L50:
        if (r4 != Long.MIN_VALUE) goto L53;
        return 0;
    L53:
        return Math.abs(r4);
    }

    private static final List<t> h(List<t> r3) {
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new l((Comparator) ZeusTransformUtils.preCheckCast(new k((Comparator) ZeusTransformUtils.preCheckCast(new j(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
    }

    private static final List<ProactiveRecommendationDto> i(List<ProactiveRecommendationDto> r3) {
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new o((Comparator) ZeusTransformUtils.preCheckCast(new n((Comparator) ZeusTransformUtils.preCheckCast(new m(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
    }

    private static final List<t> j(List<t> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r2 = r7.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((t) ZeusTransformUtils.preCheckCast(r2, t.class, "com.obric.memorydata.plugin")).c(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final List<ProactiveRecommendationDto> k(List<ProactiveRecommendationDto> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r2 = r7.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r2, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendText(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }
}
