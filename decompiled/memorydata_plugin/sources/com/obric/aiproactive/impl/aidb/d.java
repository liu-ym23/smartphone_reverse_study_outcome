package com.obric.aiproactive.impl.aidb;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.AiRuleItemDto;
import com.obric.aiproactive.api.aa;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 r2\u00020\u0001:\u0001rBK\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J&\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a0\u00192\u0006\u0010\u001e\u001a\u00020\u001fJ(\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001c0\u0019J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001cH\u0086@¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001c0\u0019J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\u001cH\u0086@¢\u0006\u0002\u0010%J$\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\u001c2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001cH\u0086@¢\u0006\u0002\u0010%J\u000e\u0010.\u001a\u00020/H\u0086@¢\u0006\u0002\u0010%J\"\u00100\u001a\u0004\u0018\u00010-2\u0006\u00101\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u00102J,\u00103\u001a\b\u0012\u0004\u0012\u00020-0\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u00105J,\u00106\u001a\b\u0012\u0004\u0012\u00020-0\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u00105J2\u00107\u001a\b\u0012\u0004\u0012\u00020-0\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u00108\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u00109J2\u0010:\u001a\u0004\u0018\u00010-2\u0006\u0010;\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00172\u0006\u00108\u001a\u00020<2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010?J\u000e\u0010@\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010%J\u0018\u0010A\u001a\u0004\u0018\u00010#2\u0006\u0010B\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010!J4\u0010C\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u001f2\b\u0010D\u001a\u0004\u0018\u00010\u00172\b\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010G\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010HJ,\u0010I\u001a\u0004\u0018\u00010#2\u0006\u0010B\u001a\u00020\u001f2\b\u0010J\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010G\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010KJ\"\u0010L\u001a\u0004\u0018\u00010#2\u0006\u0010B\u001a\u00020\u001f2\b\b\u0002\u0010G\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010+J2\u0010M\u001a\u0004\u0018\u00010#2\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010G\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010OJ(\u0010P\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010G\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010QJJ\u0010R\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010G\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010VJ \u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020Y2\b\b\u0002\u0010G\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010ZJ \u0010[\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\\2\b\b\u0002\u0010G\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010]J2\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020F2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010`J\u001c\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J0\u0010b\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010cJ\f\u0010d\u001a\u00020\u001d*\u00020eH\u0002J\f\u0010f\u001a\u00020-*\u00020gH\u0002J\f\u0010d\u001a\u00020#*\u00020hH\u0002J\u0018\u0010i\u001a\b\u0012\u0004\u0012\u00020j0\u001c2\b\u0010k\u001a\u0004\u0018\u00010\u0017H\u0002J \u0010l\u001a\u0004\u0018\u00010h2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010cJ:\u0010m\u001a\u0004\u0018\u00010#2\u0006\u0010n\u001a\u00020h2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020j0\u001c2\u0006\u0010G\u001a\u00020\u001f2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010FH\u0082@¢\u0006\u0002\u0010qR\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/AiProactiveDbRepository;", "", "dbProvider", "Lkotlin/Function0;", "Lcom/obric/aiproactive/impl/aidb/AiProactiveDb;", "zoneId", "Ljava/time/ZoneId;", "feedbackReporter", "Lcom/obric/aiproactive/impl/aidb/AiProactiveFeedbackReporter;", "preferenceStoreProvider", "Lcom/obric/aiproactive/impl/aidb/AiProactivePreferenceStore;", "preferenceMutationEffects", "Lcom/obric/aiproactive/impl/aidb/AiProactivePreferenceMutationEffects;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/time/ZoneId;Lcom/obric/aiproactive/impl/aidb/AiProactiveFeedbackReporter;Lkotlin/jvm/functions/Function0;Lcom/obric/aiproactive/impl/aidb/AiProactivePreferenceMutationEffects;)V", "currentDb", "preferenceStore", "notifyFeedbackReportResult", "", "success", "", "shouldToast", "recommendId", "", "observeTodayEventRecords", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;", "now", "", "loadTodayEventRecords", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observePendingRecommendations", "Lcom/obric/aiproactive/api/AiProactiveRecommendationDto;", "listPendingRecommendations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAllRecommendations", "listAllRecommendations", "listRecommendationsByCreatedWindow", "earliestTimeMillis", "latestTimeMillis", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listAiRules", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "getAiRuleFollowupCounts", "Lcom/obric/aiproactive/api/AiRuleFollowupCountDto;", "addAiRule", Params.CONTENT, "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addAiGeneratedRules", "contents", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addInterviewGeneratedRules", "addGeneratedRules", "type", "(Ljava/util/List;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAiRule", "ruleId", "Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAiRule", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestAiRuleUpdateTimestamp", "getRecommendationById", "recommendationId", "updateRecommendationActionExecuteList", "actionExecuteList", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "updated", "(JLjava/lang/String;Lcom/obric/aiproactive/api/AiProactiveCardStatus;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCurrentActionInstruction", "actionExecuteInstruction", "(JLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markCurrentActionExecuted", "markActionExecuted", "actionIndex", "(JILcom/obric/aiproactive/api/AiProactiveCardStatus;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecommendationCardStatus", "(JLcom/obric/aiproactive/api/AiProactiveCardStatus;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecommendationCardStatusWithFeedback", "feedbackType", "feedbackReason", "feedbackText", "(JLcom/obric/aiproactive/api/AiProactiveCardStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecommendationFeedback", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "(Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitDirectFeedback", "Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;", "(Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportRecommendationCardAction", "db", "(Lcom/obric/aiproactive/impl/aidb/AiProactiveDb;JLcom/obric/aiproactive/api/AiProactiveCardStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dayRange", "ensureTodayFallbackEventRows", "(Lcom/obric/aiproactive/impl/aidb/AiProactiveDb;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDto", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveEventRecordEntity;", "toRuleDto", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactivePreferenceEntity;", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveRecommendationEntity;", "parseActionExecuteList", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "raw", "findRecommendationEntity", "persistActionExecuteList", "row", "nextItems", "overrideCardStatus", "(Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveRecommendationEntity;Ljava/util/List;JLcom/obric/aiproactive/api/AiProactiveCardStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<AiProactiveDb> f6309b;
    private final ZoneId c;
    private final h d;
    private final Function0<k> e;
    private final j f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/AiProactiveDbRepository$Companion;", "", "<init>", "()V", "TAG", "", "FALLBACK_EVENT_RAW_TABLE_NAME", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            String r3 = ((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")).getType().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(Boolean.valueOf(!Intrinsics.areEqual(r3, "user")), Comparable.class, "com.obric.memorydata.plugin");
            String r7 = ((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r5, com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")).getType().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
            return ComparisonsKt.compareValues(r6, (Comparable) ZeusTransformUtils.preCheckCast(Boolean.valueOf(!Intrinsics.areEqual(r7, "user")), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6310a;

        public c(Comparator r3) {
            this.f6310a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r6, T r7) {
            int r5 = this.f6310a.compare(r6, r7);
            if (r5 != 0) goto L7;
            com.obric.aiproactive.impl.aidb.a.f r8 = (com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r7, com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin");
            Comparable r9 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(Math.max(r8.e(), r8.b())), Comparable.class, "com.obric.memorydata.plugin");
            com.obric.aiproactive.impl.aidb.a.f r10 = (com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r6, com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin");
            return ComparisonsKt.compareValues(r9, (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(Math.max(r10.e(), r10.b())), Comparable.class, "com.obric.memorydata.plugin"));
        L7:
            return r5;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.aidb.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0280d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6311a;

        public C0280d(Comparator r3) {
            this.f6311a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f6311a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r5, com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements kotlinx.coroutines.flow.i<List<? extends com.obric.aiproactive.api.t>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f6312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f6313b;

        /* JADX INFO: renamed from: com.obric.aiproactive.impl.aidb.d$e$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f6314a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f6315b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, d r4) {
                this.f6314a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f6315b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r8, Continuation r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, AiProactiveDbRepository$observeAllRecommendations$$inlined$map$1$2$1.class) == false) goto L7;
                AiProactiveDbRepository$observeAllRecommendations$$inlined$map$1$2$1 r0 = (AiProactiveDbRepository$observeAllRecommendations$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r10, AiProactiveDbRepository$observeAllRecommendations$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r11 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r11);
            L22:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r12 = this.f6314a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
                Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
                Iterator<T> r14 = r13.iterator();
            L16:
                if (r14.hasNext() == false) goto L18;
                r5.add(d.a(this.f6315b, (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin")));
                goto L16
            L18:
                List r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
                r0.label = 1;
                if (r12.emit(r7, r0) != r2) goto L22;
                return r2;
            L7:
                r0 = new AiProactiveDbRepository$observeAllRecommendations$$inlined$map$1$2$1(this, r10);
                goto L8
            }
        }

        public e(kotlinx.coroutines.flow.i r3, d r4) {
            this.f6312a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f6313b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super List<? extends com.obric.aiproactive.api.t>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f6312a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f6313b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements kotlinx.coroutines.flow.i<List<? extends com.obric.aiproactive.api.t>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f6316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f6317b;

        /* JADX INFO: renamed from: com.obric.aiproactive.impl.aidb.d$f$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f6318a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f6319b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, d r4) {
                this.f6318a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f6319b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r8, Continuation r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, AiProactiveDbRepository$observePendingRecommendations$$inlined$map$1$2$1.class) == false) goto L7;
                AiProactiveDbRepository$observePendingRecommendations$$inlined$map$1$2$1 r0 = (AiProactiveDbRepository$observePendingRecommendations$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r10, AiProactiveDbRepository$observePendingRecommendations$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r11 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r11);
            L22:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r12 = this.f6318a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
                Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
                Iterator<T> r14 = r13.iterator();
            L16:
                if (r14.hasNext() == false) goto L18;
                r5.add(d.a(this.f6319b, (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin")));
                goto L16
            L18:
                List r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
                r0.label = 1;
                if (r12.emit(r7, r0) != r2) goto L22;
                return r2;
            L7:
                r0 = new AiProactiveDbRepository$observePendingRecommendations$$inlined$map$1$2$1(this, r10);
                goto L8
            }
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super List<? extends com.obric.aiproactive.api.t>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f6316a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f6317b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
        f6308a = new a(null);
    }

    public d() {
        this(null, null, null, null, null, 31, null);
    }

    public d(Function0<? extends AiProactiveDb> r3, ZoneId r4, h r5, Function0<? extends k> r6, j r7) {
        Function0<AiProactiveDb> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        Function0<k> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        j r11 = (j) ZeusTransformUtils.wrapperContextForParams(r7, j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "dbProvider");
        Intrinsics.checkNotNullParameter(r4, "zoneId");
        Intrinsics.checkNotNullParameter(r9, "feedbackReporter");
        Intrinsics.checkNotNullParameter(r11, "preferenceMutationEffects");
        this.f6309b = r8;
        this.c = r4;
        this.d = r9;
        this.e = r10;
        this.f = r11;
    }

    public /* synthetic */ d(Function0 r8, ZoneId r9, h r10, Function0 r11, j r12, int r13, DefaultConstructorMarker r14) {
        Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        h r16 = (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.memorydata.plugin");
        Function0 r17 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        j r18 = (j) ZeusTransformUtils.wrapperContextForParams(r12, j.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L5;
        r15 = $$Lambda$d$qJ37Z4TNaAfE41PlW4EnARJvM8I.INSTANCE;
    L5:
        Function0 r2 = r15;
        if ((r13 & 2) == 0) goto L8;
        r9 = ZoneId.systemDefault();
    L8:
        ZoneId r3 = r9;
        if ((r13 & 4) == 0) goto L11;
        r16 = (h) ZeusTransformUtils.preCheckCast(n.f6367b, h.class, "com.obric.memorydata.plugin");
    L11:
        h r4 = r16;
        if ((r13 & 8) == 0) goto L14;
        r17 = null;
    L14:
        Function0 r5 = r17;
        if ((r13 & 16) == 0) goto L17;
        r18 = (j) ZeusTransformUtils.preCheckCast(o.f6368a, j.class, "com.obric.memorydata.plugin");
    L17:
        this(r2, r3, r4, r5, r18);
    }

    private final AiRuleItemDto a(com.obric.aiproactive.impl.aidb.a.f r8) {
        String r1 = String.valueOf(r8.a());
        String r2 = r8.c();
        String r9 = r8.getType().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r9, "toLowerCase(...)");
        if (Intrinsics.areEqual(r9, "user") == false) goto L5;
        AiRuleItemDto.RuleType r10 = AiRuleItemDto.RuleType.CUSTOM;
    L7:
        return new AiRuleItemDto(r1, r2, r10, false, 8, null);
    L5:
        r10 = AiRuleItemDto.RuleType.AI_GENERATED;
        goto L7
    }

    private final com.obric.aiproactive.api.p a(com.obric.aiproactive.impl.aidb.a.c r15) {
        return new com.obric.aiproactive.api.p(r15.a(), r15.b(), r15.c(), r15.d(), r15.e(), r15.f(), r15.g(), r15.h(), r15.i());
    }

    public static final /* synthetic */ com.obric.aiproactive.api.p a(d r0, com.obric.aiproactive.impl.aidb.a.c r1) {
        return r0.a(r1);
    }

    private final com.obric.aiproactive.api.t a(com.obric.aiproactive.impl.aidb.a.g r27) {
        List<com.obric.aiproactive.api.b> r9 = a(r27.f());
        return new com.obric.aiproactive.api.t(r27.a(), r27.b(), r27.c(), r27.d(), r27.e(), r9, r27.g(), r27.h(), r27.i(), r27.j(), r27.k(), AiProactiveCardStatus.Companion.a(r27.l()), r27.m(), r27.n(), r27.o(), null, r27.p(), r27.q(), r27.r(), com.obric.aiproactive.api.k.a(r27.s()));
    }

    public static final /* synthetic */ com.obric.aiproactive.api.t a(d r0, com.obric.aiproactive.impl.aidb.a.g r1) {
        return r0.a(r1);
    }

    private final Object a(AiProactiveDb r25, long r26, AiProactiveCardStatus r28, String r29, Continuation<? super Unit> r30) {
        d r0 = this;
        long r1 = r26;
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r30, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AiProactiveDbRepository$reportRecommendationCardAction$1.class) == false) goto L7;
        AiProactiveDbRepository$reportRecommendationCardAction$1 r6 = (AiProactiveDbRepository$reportRecommendationCardAction$1) ZeusTransformUtils.preCheckCast(r4, AiProactiveDbRepository$reportRecommendationCardAction$1.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r6.label;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        int r12 = r6.I$0;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r6.L$2, String.class, "com.obric.memorydata.plugin");
        h r3 = (h) ZeusTransformUtils.preCheckCast(r6.L$1, h.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        h r11 = r3;
        String r17 = r9;
        int r13 = r12;
        String r14 = r2;
    L53:
        h.b.a(r11, r14, r13, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), null, null, r17, null, null, null, 472, null);
    L48:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r10 = r6.J$0;
        Long r15 = (Long) ZeusTransformUtils.preCheckCast(r6.L$4, Long.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r6.L$3, String.class, "com.obric.memorydata.plugin");
        AiProactiveCardStatus r18 = (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r6.L$2, AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
        AiProactiveDb r19 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r6.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r20 = (d) ZeusTransformUtils.preCheckCast(r6.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L36:
        String r21 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        Long r22 = r15;
        r1 = r10;
        String r23 = r21;
    L38:
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin");
        if (r110 != null) goto L41;
    L44:
        boolean r111 = true;
    L45:
        if (r111 == false) goto L49;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbRepository", "[Repository] skipRecommendationCardActionReport missingLogId recommendationId=" + r1 + " traceId=" + r22 + " cardStatus=" + r18, null, 4, null);
        goto L48
    L49:
        h r24 = r20.d;
        com.obric.aiproactive.impl.aidb.dao.g r27 = r19.recommendationDao();
        r6.L$0 = r16;
        r6.L$1 = r24;
        r6.L$2 = r23;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.I$0 = 1;
        r6.label = 3;
        r5 = r27.findRecommendTextById(r1, r6);
        if (r5 != r7) goto L52;
        return r7;
    L52:
        r14 = r23;
        r11 = r24;
        r17 = r16;
        r13 = 1;
        goto L53
    L41:
        if (StringsKt.isBlank(r110) == true) goto L44;
        r111 = false;
        goto L45
    L17:
        long r31 = r6.J$0;
        String r32 = (String) ZeusTransformUtils.preCheckCast(r6.L$3, String.class, "com.obric.memorydata.plugin");
        AiProactiveCardStatus r33 = (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r6.L$2, AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
        r19 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r6.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r34 = (d) ZeusTransformUtils.preCheckCast(r6.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        String r35 = r32;
        r1 = r31;
        r0 = r34;
    L30:
        r22 = (Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L37;
        com.obric.aiproactive.impl.aidb.dao.i r112 = r19.traceDao();
        long r113 = r22.longValue();
        r6.L$0 = r0;
        r6.L$1 = r19;
        r6.L$2 = r33;
        r6.L$3 = r35;
        r6.L$4 = r22;
        r6.J$0 = r1;
        r6.label = 2;
        Object r114 = r112.findLogIdById(r113, r6);
        if (r114 != r7) goto L35;
        return r7;
    L35:
        String r210 = r35;
        r20 = r0;
        r10 = r1;
        r15 = r22;
        r5 = r114;
        r18 = r33;
        r16 = r210;
        goto L36
    L37:
        r18 = r33;
        r16 = r35;
        r20 = r0;
        r23 = null;
        goto L38
    L18:
        ResultKt.throwOnFailure(r5);
        if (com.obric.aiproactive.impl.aidb.f.a(r28, r29) == false) goto L21;
        AwarenessManager.INSTANCE.dispatchAwarenessEvent("ai_proactive_recommendation_feedback", com.obric.aiproactive.impl.aidb.f.a(1, "ProactiveRecommendation", r1));
        if (com.obric.aiproactive.impl.aidb.f.b(r28, r29) == false) goto L25;
        r35 = com.obric.aiproactive.impl.aidb.f.a(r28);
        com.obric.aiproactive.impl.aidb.dao.g r36 = r25.recommendationDao();
        r6.L$0 = r0;
        r6.L$1 = r25;
        r6.L$2 = r28;
        r6.L$3 = r35;
        r6.J$0 = r1;
        r6.label = 1;
        r5 = r36.findTraceIdById(r1, r6);
        if (r5 != r7) goto L29;
        return r7;
    L29:
        r19 = r25;
        r33 = r28;
        goto L30
    L25:
        return Unit.INSTANCE;
    L21:
        return Unit.INSTANCE;
    L7:
        r6 = new AiProactiveDbRepository$reportRecommendationCardAction$1(r0, r4);
        goto L8
    }

    private final Object a(AiProactiveDb r10, long r11, Continuation<? super Pair<Integer, ? extends List<com.obric.aiproactive.api.p>>> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return RoomDatabaseKt.withTransaction((RoomDatabase) ZeusTransformUtils.preCheckCast(r10, RoomDatabase.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new AiProactiveDbRepository$ensureTodayFallbackEventRows$2(this, r11, r10, null), Function1.class, "com.obric.memorydata.plugin"), r14);
    }

    private final Object a(com.obric.aiproactive.impl.aidb.a.g r30, List<com.obric.aiproactive.api.b> r31, long r32, AiProactiveCardStatus r34, Continuation<? super com.obric.aiproactive.api.t> r35) {
        d r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r35, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AiProactiveDbRepository$persistActionExecuteList$1.class) == false) goto L7;
        AiProactiveDbRepository$persistActionExecuteList$1 r4 = (AiProactiveDbRepository$persistActionExecuteList$1) ZeusTransformUtils.preCheckCast(r3, AiProactiveDbRepository$persistActionExecuteList$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        AiProactiveDbRepository$persistActionExecuteList$1 r12 = r4;
        Object r5 = r12.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r12.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        long r2 = r12.J$0;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r12.L$3, String.class, "com.obric.memorydata.plugin");
        AiProactiveCardStatus r9 = (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r12.L$2, AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.impl.aidb.a.g r10 = (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r12.L$1, com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin");
        d r11 = (d) ZeusTransformUtils.preCheckCast(r12.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        long r27 = r2;
        r0 = r11;
        String r22 = r8;
        AiProactiveCardStatus r13 = r9;
        com.obric.aiproactive.impl.aidb.a.g r14 = r10;
    L33:
        return r0.a(com.obric.aiproactive.impl.aidb.a.g.a(r14, 0, 0, null, null, null, r22, null, null, null, null, null, r13.name(), null, null, null, null, 0, r27, null, 391135, null));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        if (r34 == null) goto L17;
        AiProactiveCardStatus r15 = r34;
    L24:
        String r16 = com.obric.aiproactive.api.c.a(r1);
        AiProactiveDb r17 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r0.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L28;
        return null;
    L28:
        com.obric.aiproactive.impl.aidb.dao.g r18 = r17.recommendationDao();
        long r19 = r30.a();
        String r20 = r15.name();
        r12.L$0 = r0;
        r12.L$1 = r30;
        r12.L$2 = r15;
        r12.L$3 = r16;
        r12.J$0 = r32;
        r12.label = 1;
        if (r18.updateActionExecuteList(r19, r16, r20, r32, r12) != r6) goto L31;
        return r6;
    L31:
        r22 = r16;
        r14 = r30;
        r13 = r15;
        r27 = r32;
        goto L33
    L17:
        if (r1.isEmpty() == false) goto L20;
        r15 = AiProactiveCardStatus.Companion.a(r30.l());
        goto L24
    L20:
        if (com.obric.aiproactive.api.c.e(r1) == false) goto L22;
        r15 = AiProactiveCardStatus.EXECUTED;
        goto L24
    L22:
        r15 = AiProactiveCardStatus.PENDING;
    L7:
        r4 = new AiProactiveDbRepository$persistActionExecuteList$1(r0, r3);
        goto L8
    }

    public static /* synthetic */ Object a(d r9, long r10, int r12, AiProactiveCardStatus r13, long r14, Continuation r16, int r17, Object r18) {
        Continuation<? super com.obric.aiproactive.api.t> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r16, Continuation.class, "com.obric.memorydata.plugin");
        if ((r17 & 8) == 0) goto L5;
        long r6 = System.currentTimeMillis();
    L7:
        return r9.a(r10, r12, r13, r6, r8);
    L5:
        r6 = r14;
        goto L7
    }

    public static /* synthetic */ Object a(d r6, long r7, long r9, Continuation r11, int r12, Object r13) {
        Continuation<? super com.obric.aiproactive.api.t> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 2) == 0) goto L6;
        r9 = System.currentTimeMillis();
    L6:
        return r6.b(r7, r9, r5);
    }

    public static /* synthetic */ Object a(d r7, long r8, AiProactiveCardStatus r10, long r11, Continuation r13, int r14, Object r15) {
        Continuation<? super Boolean> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if ((r14 & 4) == 0) goto L6;
        r11 = System.currentTimeMillis();
    L6:
        return r7.a(r8, r10, r11, r6);
    }

    public static /* synthetic */ Object a(d r11, long r12, AiProactiveCardStatus r14, String r15, String r16, String r17, long r18, Continuation r20, int r21, Object r22) {
        Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if ((r21 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r21 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r21 & 32) == 0) goto L13;
        long r8 = System.currentTimeMillis();
    L15:
        return r11.a(r12, r14, r15, r6, r7, r8, r10);
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public static /* synthetic */ Object a(d r7, long r8, String r10, long r11, Continuation r13, int r14, Object r15) {
        Continuation<? super com.obric.aiproactive.api.t> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if ((r14 & 4) == 0) goto L6;
        r11 = System.currentTimeMillis();
    L6:
        return r7.a(r8, r10, r11, r6);
    }

    public static /* synthetic */ Object a(d r1, com.obric.aiproactive.api.o r2, long r3, Continuation r5, int r6, Object r7) {
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = System.currentTimeMillis();
    L6:
        return r1.a(r2, r3, r8);
    }

    public static /* synthetic */ Object a(d r1, com.obric.aiproactive.api.u r2, long r3, Continuation r5, int r6, Object r7) {
        Continuation<? super Boolean> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = System.currentTimeMillis();
    L6:
        return r1.a(r2, r3, r8);
    }

    public static final /* synthetic */ Object a(d r7, AiProactiveDb r8, long r9, AiProactiveCardStatus r11, String r12, Continuation r13) {
        return r7.a(r8, r9, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object a(d r7, AiProactiveDb r8, long r9, AiProactiveCardStatus r11, String r12, Continuation r13, int r14, Object r15) {
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if ((r14 & 8) == 0) goto L6;
        r12 = null;
    L6:
        return r7.a(r8, r9, r11, r12, r6);
    }

    public static final /* synthetic */ Object a(d r2, AiProactiveDb r3, long r4, Continuation r6) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r9, com.obric.aiproactive.impl.aidb.a.g r10, List r11, long r12, AiProactiveCardStatus r14, Continuation r15) {
        return r9.a(r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), r12, r14, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object a(d r9, com.obric.aiproactive.impl.aidb.a.g r10, List r11, long r12, AiProactiveCardStatus r14, Continuation r15, int r16, Object r17) {
        List<com.obric.aiproactive.api.b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Continuation<? super com.obric.aiproactive.api.t> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if ((r16 & 8) == 0) goto L5;
        AiProactiveCardStatus r7 = null;
    L7:
        return r9.a(r10, r4, r12, r7, r8);
    L5:
        r7 = r14;
        goto L7
    }

    public static /* synthetic */ Object a(d r1, String r2, long r3, Continuation r5, int r6, Object r7) {
        Continuation<? super AiRuleItemDto> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = System.currentTimeMillis();
    L6:
        return r1.a(r2, r3, r8);
    }

    public static /* synthetic */ Object a(d r7, String r8, String r9, AiRuleItemDto.RuleType r10, long r11, Continuation r13, int r14, Object r15) {
        Continuation<? super AiRuleItemDto> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if ((r14 & 8) == 0) goto L6;
        r11 = System.currentTimeMillis();
    L6:
        return r7.a(r8, r9, r10, r11, r6);
    }

    public static /* synthetic */ Object a(d r1, List r2, long r3, Continuation r5, int r6, Object r7) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Continuation<? super List<AiRuleItemDto>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = System.currentTimeMillis();
    L6:
        return r1.a(r4, r3, r8);
    }

    private final Object a(List<String> r18, String r19, long r20, Continuation<? super List<AiRuleItemDto>> r22) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        List<com.obric.aiproactive.impl.aidb.a.f> r3 = com.obric.aiproactive.impl.aidb.e.a(r2, r19, r20);
        if (r3.isEmpty() == true) goto L5;
        k r5 = c();
        if (r5 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (r3.size() != 1) goto L13;
        List<Long> r6 = CollectionsKt.listOf(Boxing.boxLong(r5.insert((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r3), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin"))));
    L14:
        List<com.obric.aiproactive.impl.aidb.a.f> r7 = com.obric.aiproactive.impl.aidb.e.a(r3, r6);
        this.f.a();
        if (Intrinsics.areEqual(r19, "interview") == false) goto L20;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r1.hasNext() == false) goto L20;
        com.obric.aiproactive.impl.aidb.a.f r8 = (com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin");
        Iterator r110 = r1;
        this.f.a(new s(1, r8.a(), r8.c(), null, null, 24, null));
        this.f.a(r8.a(), "create", "interview");
        r1 = r110;
    L20:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L22:
        if (r11.hasNext() == false) goto L25;
        r10.add(a((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")));
        goto L22
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    L13:
        r6 = r5.a(r3);
        goto L14
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<com.obric.aiproactive.api.b> a(String r5) {
        if (r5 == null) goto L5;
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L11;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        d r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r7 = Result.m1421constructorimpl(com.obric.aiproactive.api.c.a(r6));     // Catch: Throwable -> L14
    L16:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r7);
        if (r2 == null) goto L21;
        RunLog.INSTANCE.warn("AiProactiveDbRepository", "[Repository] parseActionExecuteList failed raw=" + r6, r2);
        r7 = CollectionsKt.emptyList();
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return CollectionsKt.emptyList();
    L5:
        r6 = null;
        goto L6
    }

    public static final /* synthetic */ Pair a(d r0, long r1) {
        return r0.b(r1);
    }

    private static final Unit a(d r2, boolean r3, com.obric.aiproactive.api.u r4, boolean r5) {
        r2.a(r5, r3, String.valueOf(r4.a()));
        return Unit.INSTANCE;
    }

    private static final Unit a(d r6, boolean r7, boolean r8) {
        a(r6, r8, r7, null, 4, null);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void a(d r0, boolean r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    private static final void a(boolean r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L5;
        String r2 = "反馈成功";
    L6:
        Toast.makeText(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbRepository", "notifyFeedbackReportResult: Toast shown, success=" + r7, false, 4, null);
        return;
    L5:
        r2 = "反馈失败，请重试";
        goto L6
    }

    private final void a(final boolean r1, boolean r2, String r3) {
        if (r2 == true) goto L4;
        return;
    L4:
        new Handler(Looper.getMainLooper()).post(new $$Lambda$d$XdwJ7gh77IfDwjiubnne2tDytu4(r1));
    }

    private final Object b(AiProactiveDb r6, long r7, Continuation<? super com.obric.aiproactive.impl.aidb.a.g> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AiProactiveDbRepository$findRecommendationEntity$1.class) == false) goto L7;
        AiProactiveDbRepository$findRecommendationEntity$1 r0 = (AiProactiveDbRepository$findRecommendationEntity$1) ZeusTransformUtils.preCheckCast(r10, AiProactiveDbRepository$findRecommendationEntity$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r5);
    L23:
        return CollectionsKt.firstOrNull((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = r0.J$0;
        r6 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r0.L$0, AiProactiveDb.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L19:
        u r8 = l.a(((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r7);
        com.obric.aiproactive.impl.aidb.dao.g r12 = r6.recommendationDao();
        SupportSQLiteQuery r13 = r8.a();
        r0.L$0 = null;
        r0.label = 2;
        r5 = r12.listRecommendations(r13, r0);
        if (r5 != r11) goto L23;
        return r11;
    L16:
        ResultKt.throwOnFailure(r5);
        com.obric.aiproactive.impl.aidb.dao.g r14 = r6.recommendationDao();
        r0.L$0 = r6;
        r0.J$0 = r7;
        r0.label = 1;
        r5 = l.a(r14, r0);
        if (r5 != r11) goto L19;
        return r11;
    L7:
        r0 = new AiProactiveDbRepository$findRecommendationEntity$1(this, r10);
        goto L8
    }

    public static final /* synthetic */ Object b(d r2, AiProactiveDb r3, long r4, Continuation r6) {
        return r2.b(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object b(d r1, List r2, long r3, Continuation r5, int r6, Object r7) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Continuation<? super List<AiRuleItemDto>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = System.currentTimeMillis();
    L6:
        return r1.b(r4, r3, r8);
    }

    private final Pair<Long, Long> b(long r5) {
        LocalDate r6 = Instant.ofEpochMilli(r5).atZone(this.c).toLocalDate();
        long r0 = r6.atStartOfDay(this.c).toInstant().toEpochMilli();
        long r4 = r6.plusDays(1).atStartOfDay(this.c).toInstant().toEpochMilli();
        return TuplesKt.to(Long.valueOf(r0), Long.valueOf(r4));
    }

    private final k c() {
        Function0<k> r0 = this.e;
        if (r0 == null) goto L6;
        k r1 = (k) ZeusTransformUtils.preCheckCast(r0.invoke(), k.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        AiProactiveDb r3 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        com.obric.aiproactive.impl.aidb.dao.f r4 = r3.preferenceDao();
        if (r4 == null) goto L11;
        return (k) ZeusTransformUtils.preCheckCast(new m(r4), k.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    }

    private static final AiProactiveDb d() {
        return com.obric.aiproactive.impl.aidb.b.a(com.obric.aiproactive.impl.aidb.b.f6306a, null, 1, null);
    }

    public static /* synthetic */ Unit lambda$TCGo1qLiWMkfzPD0MKW5Bc7qrc0(d r0, boolean r1, com.obric.aiproactive.api.u r2, boolean r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$XdwJ7gh77IfDwjiubnne2tDytu4(boolean r0) {
        a(r0);
    }

    public static /* synthetic */ AiProactiveDb lambda$qJ37Z4TNaAfE41PlW4EnARJvM8I() {
        return d();
    }

    /* JADX INFO: renamed from: lambda$rfU_bMIBnqc5sATBp_Pnm-Yh5QA, reason: not valid java name */
    public static /* synthetic */ Unit m217lambda$rfU_bMIBnqc5sATBp_PnmYh5QA(d r0, boolean r1, boolean r2) {
        return a(r0, r1, r2);
    }

    public final AiProactiveDb a() {
        return (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
    }

    public final Object a(long r21, int r23, AiProactiveCardStatus r24, long r25, Continuation<? super com.obric.aiproactive.api.t> r27) {
        d r0 = this;
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AiProactiveDbRepository$markActionExecuted$1.class) == false) goto L7;
        AiProactiveDbRepository$markActionExecuted$1 r6 = (AiProactiveDbRepository$markActionExecuted$1) ZeusTransformUtils.preCheckCast(r4, AiProactiveDbRepository$markActionExecuted$1.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        AiProactiveDbRepository$markActionExecuted$1 r13 = r6;
        Object r5 = r13.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r13.label;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        com.obric.aiproactive.api.t r1 = (com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(r13.L$0, com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        return r1;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r2 = r13.J$0;
        AiProactiveDb r3 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r13.L$2, AiProactiveDb.class, "com.obric.memorydata.plugin");
        AiProactiveCardStatus r9 = (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r13.L$1, AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
        d r10 = (d) ZeusTransformUtils.preCheckCast(r13.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        long r11 = r2;
        AiProactiveCardStatus r12 = r9;
        d r14 = r10;
    L35:
        com.obric.aiproactive.api.t r15 = (com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(r5, com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin");
        r13.L$0 = r15;
        r13.L$1 = null;
        r13.L$2 = null;
        r13.label = 3;
        if (a(r14, r3, r11, r12, null, r13, 8, null) != r7) goto L39;
        return r7;
    L39:
        return r15;
    L17:
        long r16 = r13.J$1;
        int r17 = r13.I$0;
        long r18 = r13.J$0;
        AiProactiveDb r19 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r13.L$2, AiProactiveDb.class, "com.obric.memorydata.plugin");
        AiProactiveCardStatus r110 = (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r13.L$1, AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
        d r20 = (d) ZeusTransformUtils.preCheckCast(r13.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        r0 = r20;
        Object r22 = r5;
        long r26 = r16;
    L25:
        com.obric.aiproactive.impl.aidb.a.g r28 = (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r22, com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin");
        if (r28 != null) goto L28;
        return null;
    L28:
        List<com.obric.aiproactive.api.b> r111 = r0.a(r28.f());
        if (r111.isEmpty() == false) goto L31;
        return null;
    L31:
        List<com.obric.aiproactive.api.b> r29 = com.obric.aiproactive.api.c.a(r111, r17);
        r13.L$0 = r0;
        r13.L$1 = r110;
        r13.L$2 = r19;
        r13.J$0 = r18;
        r13.label = 2;
        r5 = r0.a(r28, r29, r26, r110, r13);
        if (r5 != r7) goto L34;
        return r7;
    L34:
        r3 = r19;
        r14 = r0;
        r12 = r110;
        r11 = r18;
        goto L35
    L18:
        ResultKt.throwOnFailure(r5);
        r19 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r0.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L21;
        return null;
    L21:
        r13.L$0 = r0;
        r13.L$1 = r24;
        r13.L$2 = r19;
        r13.J$0 = r21;
        r13.I$0 = r23;
        r13.J$1 = r25;
        r13.label = 1;
        Object r112 = r0.b(r19, r21, r13);
        if (r112 != r7) goto L24;
        return r7;
    L24:
        r110 = r24;
        r17 = r23;
        r22 = r112;
        r26 = r25;
        r18 = r21;
    L7:
        r6 = new AiProactiveDbRepository$markActionExecuted$1(r0, r4);
        goto L8
    }

    public final Object a(long r9, long r11, Continuation<? super List<com.obric.aiproactive.api.t>> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, AiProactiveDbRepository$listRecommendationsByCreatedWindow$1.class) == false) goto L7;
        AiProactiveDbRepository$listRecommendationsByCreatedWindow$1 r1 = (AiProactiveDbRepository$listRecommendationsByCreatedWindow$1) ZeusTransformUtils.preCheckCast(r14, AiProactiveDbRepository$listRecommendationsByCreatedWindow$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        d r8 = (d) ZeusTransformUtils.preCheckCast(r1.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L32:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r10.iterator();
    L34:
        if (r16.hasNext() == false) goto L37;
        r12.add(r8.a((com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin")));
        goto L34
    L37:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r1.J$1;
        r9 = r1.J$0;
        AiProactiveDb r17 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r1.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r0 = (d) ZeusTransformUtils.preCheckCast(r1.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L28:
        u r18 = l.a(((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r9, r11);
        com.obric.aiproactive.impl.aidb.dao.g r19 = r17.recommendationDao();
        SupportSQLiteQuery r20 = r18.a();
        r1.L$0 = r0;
        r1.L$1 = null;
        r1.label = 2;
        r15 = r19.listRecommendations(r20, r1);
        if (r15 != r3) goto L31;
        return r3;
    L31:
        r8 = r0;
        goto L32
    L16:
        ResultKt.throwOnFailure(r15);
        if (r11 < r9) goto L19;
        AiProactiveDb r110 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L23;
        com.obric.aiproactive.impl.aidb.dao.g r2 = r110.recommendationDao();
        r1.L$0 = this;
        r1.L$1 = r110;
        r1.J$0 = r9;
        r1.J$1 = r11;
        r1.label = 1;
        Object r5 = l.a(r2, r1);
        if (r5 != r3) goto L27;
        return r3;
    L27:
        r0 = this;
        r17 = r110;
        r15 = r5;
        goto L28
    L23:
        return CollectionsKt.emptyList();
    L19:
        return CollectionsKt.emptyList();
    L7:
        r1 = new AiProactiveDbRepository$listRecommendationsByCreatedWindow$1(this, r14);
        goto L8
    }

    public final Object a(long r16, AiProactiveCardStatus r18, long r19, Continuation<? super Boolean> r21) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiProactiveDbRepository$updateRecommendationCardStatus$1.class) == false) goto L7;
        AiProactiveDbRepository$updateRecommendationCardStatus$1 r3 = (AiProactiveDbRepository$updateRecommendationCardStatus$1) ZeusTransformUtils.preCheckCast(r1, AiProactiveDbRepository$updateRecommendationCardStatus$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r3.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L28:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r5 = r3.J$0;
        AiProactiveDb r0 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r3.L$2, AiProactiveDb.class, "com.obric.memorydata.plugin");
        AiProactiveCardStatus r6 = (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r3.L$1, AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
        d r7 = (d) ZeusTransformUtils.preCheckCast(r3.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        AiProactiveCardStatus r8 = r6;
        long r9 = r5;
        AiProactiveDb r10 = r0;
        d r11 = r7;
    L24:
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.label = 2;
        if (a(r11, r10, r9, r8, null, r3, 8, null) != r13) goto L28;
        return r13;
    L16:
        ResultKt.throwOnFailure(r2);
        AiProactiveDb r12 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L19;
        com.obric.aiproactive.impl.aidb.dao.g r14 = r12.recommendationDao();
        String r15 = r18.name();
        r3.L$0 = this;
        r3.L$1 = r18;
        r3.L$2 = r12;
        r3.J$0 = r16;
        r3.label = 1;
        if (r14.updateCardStatus(r16, r15, r19, r3) != r13) goto L23;
        return r13;
    L23:
        r9 = r16;
        r11 = this;
        r10 = r12;
        r8 = r18;
        goto L24
    L19:
        return Boxing.boxBoolean(false);
    L7:
        r3 = new AiProactiveDbRepository$updateRecommendationCardStatus$1(this, r1);
        goto L8
    }

    public final Object a(long r17, AiProactiveCardStatus r19, String r20, String r21, String r22, long r23, Continuation<? super Unit> r25) {
        d r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiProactiveDbRepository$updateRecommendationCardStatusWithFeedback$1.class) == false) goto L7;
        AiProactiveDbRepository$updateRecommendationCardStatusWithFeedback$1 r3 = (AiProactiveDbRepository$updateRecommendationCardStatusWithFeedback$1) ZeusTransformUtils.preCheckCast(r1, AiProactiveDbRepository$updateRecommendationCardStatusWithFeedback$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r3.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r5 = r3.J$0;
        AiProactiveDb r6 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r3.L$3, AiProactiveDb.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.L$2, String.class, "com.obric.memorydata.plugin");
        AiProactiveCardStatus r8 = (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r3.L$1, AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
        d r9 = (d) ZeusTransformUtils.preCheckCast(r3.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        AiProactiveDb r10 = r6;
        r0 = r9;
    L24:
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.label = 2;
        if (r0.a(r10, r5, r8, r7, r3) != r14) goto L28;
        return r14;
    L16:
        ResultKt.throwOnFailure(r2);
        r10 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r0.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L19;
        com.obric.aiproactive.impl.aidb.dao.g r11 = r10.recommendationDao();
        String r12 = r19.name();
        r3.L$0 = r0;
        r3.L$1 = r19;
        r3.L$2 = r20;
        r3.L$3 = r10;
        r3.J$0 = r17;
        r3.label = 1;
        if (r11.updateCardStatusAndFeedback(r17, r12, r20, r21, r22, r23, r3) != r14) goto L23;
        return r14;
    L23:
        r5 = r17;
        r7 = r20;
        r8 = r19;
        goto L24
    L19:
        return Unit.INSTANCE;
    L7:
        r3 = new AiProactiveDbRepository$updateRecommendationCardStatusWithFeedback$1(r0, r1);
        goto L8
    }

    public final Object a(long r15, String r17, long r18, Continuation<? super com.obric.aiproactive.api.t> r20) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiProactiveDbRepository$updateCurrentActionInstruction$1.class) == false) goto L7;
        AiProactiveDbRepository$updateCurrentActionInstruction$1 r3 = (AiProactiveDbRepository$updateCurrentActionInstruction$1) ZeusTransformUtils.preCheckCast(r1, AiProactiveDbRepository$updateCurrentActionInstruction$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        AiProactiveDbRepository$updateCurrentActionInstruction$1 r10 = r3;
        Object r2 = r10.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r10.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L32:
        return r2;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r8 = r10.J$0;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r10.L$1, String.class, "com.obric.memorydata.plugin");
        d r6 = (d) ZeusTransformUtils.preCheckCast(r10.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L23:
        com.obric.aiproactive.impl.aidb.a.g r7 = (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r2, com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L26;
        return null;
    L26:
        List<com.obric.aiproactive.api.b> r9 = r6.a(r7.f());
        if (r9.isEmpty() == false) goto L29;
        return null;
    L29:
        List<com.obric.aiproactive.api.b> r11 = com.obric.aiproactive.api.c.a(r9, r0);
        r10.L$0 = null;
        r10.L$1 = null;
        r10.label = 2;
        r2 = a(r6, r7, r11, r8, null, r10, 8, null);
        if (r2 != r4) goto L32;
        return r4;
    L16:
        ResultKt.throwOnFailure(r2);
        AiProactiveDb r12 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L19;
        return null;
    L19:
        r10.L$0 = this;
        r10.L$1 = r17;
        r8 = r18;
        r10.J$0 = r8;
        r10.label = 1;
        r2 = b(r12, r15, r10);
        if (r2 != r4) goto L22;
        return r4;
    L22:
        r6 = this;
        r0 = r17;
    L7:
        r3 = new AiProactiveDbRepository$updateCurrentActionInstruction$1(this, r1);
        goto L8
    }

    public final Object a(long r20, Continuation<? super Pair<Integer, ? extends List<com.obric.aiproactive.api.p>>> r22) {
        d r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AiProactiveDbRepository$loadTodayEventRecords$1.class) == false) goto L7;
        AiProactiveDbRepository$loadTodayEventRecords$1 r4 = (AiProactiveDbRepository$loadTodayEventRecords$1) ZeusTransformUtils.preCheckCast(r2, AiProactiveDbRepository$loadTodayEventRecords$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r4.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r3);
    L40:
        return r3;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r1 = r4.I$0;
        long r6 = r4.J$0;
        AiProactiveDb r7 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r4.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r8 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L29:
        List<com.obric.aiproactive.impl.aidb.a.c> r9 = com.obric.aiproactive.impl.aidb.e.c((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L37;
        Integer r10 = Boxing.boxInt(r1);
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L33:
        if (r14.hasNext() == false) goto L36;
        r13.add(r8.a((com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin")));
        goto L33
    L36:
        return TuplesKt.to(r10, (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"));
    L37:
        r4.L$0 = null;
        r4.L$1 = null;
        r4.label = 3;
        r3 = r8.a(r7, r6, r4);
        if (r3 != r11) goto L40;
        return r11;
    L17:
        long r15 = r4.J$2;
        long r16 = r4.J$1;
        long r17 = r4.J$0;
        AiProactiveDb r18 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r4.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r19 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        AiProactiveDb r21 = r18;
        r0 = r19;
        long r23 = r16;
        long r24 = r15;
    L25:
        int r25 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        com.obric.aiproactive.impl.aidb.dao.c r26 = r21.eventRecordDao();
        r4.L$0 = r0;
        r4.L$1 = r21;
        r4.J$0 = r17;
        r4.I$0 = r25;
        r4.label = 2;
        Object r27 = r26.listTodayRecords(r23, r24, r4);
        if (r27 != r11) goto L28;
        return r11;
    L28:
        r7 = r21;
        r8 = r0;
        r1 = r25;
        r3 = r27;
        r6 = r17;
        goto L29
    L18:
        ResultKt.throwOnFailure(r3);
        r21 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r0.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L21;
        Pair<Long, Long> r28 = b(r20);
        r23 = ((Number) ZeusTransformUtils.preCheckCast(r28.component1(), Number.class, "com.obric.memorydata.plugin")).longValue();
        r24 = ((Number) ZeusTransformUtils.preCheckCast(r28.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
        com.obric.aiproactive.impl.aidb.dao.c r29 = r21.eventRecordDao();
        r4.L$0 = r0;
        r4.L$1 = r21;
        r17 = r20;
        r4.J$0 = r17;
        r4.J$1 = r23;
        r4.J$2 = r24;
        r4.label = 1;
        r3 = r29.countAllRecords(r4);
        if (r3 != r11) goto L25;
        return r11;
    L21:
        return TuplesKt.to(Boxing.boxInt(0), CollectionsKt.emptyList());
    L7:
        r4 = new AiProactiveDbRepository$loadTodayEventRecords$1(r0, r2);
        goto L8
    }

    public final Object a(com.obric.aiproactive.api.o r31, long r32, Continuation<? super Unit> r34) {
        d r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r34, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AiProactiveDbRepository$submitDirectFeedback$1.class) == false) goto L7;
        AiProactiveDbRepository$submitDirectFeedback$1 r4 = (AiProactiveDbRepository$submitDirectFeedback$1) ZeusTransformUtils.preCheckCast(r2, AiProactiveDbRepository$submitDirectFeedback$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        String r8 = null;
        final boolean r9 = true;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r1 = r4.I$0;
        long r7 = r4.J$0;
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(r4.L$3, Long.class, "com.obric.memorydata.plugin");
        AiProactiveDb r11 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r4.L$2, AiProactiveDb.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.api.o r12 = (com.obric.aiproactive.api.o) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.aiproactive.api.o.class, "com.obric.memorydata.plugin");
        final d r13 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L30:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L33;
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L34:
        if (r15 != null) goto L36;
        Long r16 = r10;
        com.obric.aiproactive.api.o r17 = r12;
        d r27 = r13;
        int r18 = r1;
        r0 = r27;
        AiProactiveDb r19 = r11;
        long r110 = r7;
    L40:
        r10 = r16;
        long r111 = r110;
        com.obric.aiproactive.api.o r20 = r17;
        r11 = r19;
        int r28 = r18;
        r13 = r0;
        r1 = r28;
    L41:
        if (r8 != null) goto L43;
        r8 = UUID.randomUUID().toString();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbRepository", "[Repository] submitDirectFeedback fallbackLogId generated feedbackTraceId=" + r10 + " fallbackLogId=" + r8, null, 4, null);
        Intrinsics.checkNotNullExpressionValue(r8, "also(...)");
    L43:
        AwarenessManager.INSTANCE.dispatchAwarenessEvent("ai_proactive_recommendation_feedback", com.obric.aiproactive.impl.aidb.f.a(3, "ProactiveDirectFeedback", r11.directFeedbackDao().insert(new com.obric.aiproactive.impl.aidb.a.a(0, r111, r20.b(), r20.c(), r10, 1, null))));
        h r112 = r13.d;
        String r113 = r20.d();
        Integer r114 = com.obric.aiproactive.impl.aidb.f.a(r20.a());
        String r21 = r20.b();
        String r22 = r20.c();
        String r23 = r20.e();
        if (r1 != 0) goto L47;
        r9 = false;
    L47:
        h.b.a(r112, r8, 2, r113, r114, r21, r22, r23, null, new $$Lambda$d$rfU_bMIBnqc5sATBp_PnmYh5QA(r13, r9), 128, null);
        return Unit.INSTANCE;
    L36:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L38;
        r8 = r15;
    L38:
        r111 = r7;
        r20 = r12;
        goto L41
    L33:
        r15 = null;
        goto L34
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r24 = r4.I$0;
        r110 = r4.J$0;
        r19 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r4.L$2, AiProactiveDb.class, "com.obric.memorydata.plugin");
        r17 = (com.obric.aiproactive.api.o) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.aiproactive.api.o.class, "com.obric.memorydata.plugin");
        d r25 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r18 = r24;
        r0 = r25;
    L24:
        r16 = (Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L40;
        long r115 = ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue();
        com.obric.aiproactive.impl.aidb.dao.i r116 = r19.traceDao();
        r4.L$0 = r0;
        r4.L$1 = r17;
        r4.L$2 = r19;
        r4.L$3 = r16;
        r4.J$0 = r110;
        r4.I$0 = r18;
        r4.label = 2;
        Object r26 = r116.findLogIdById(r115, r4);
        if (r26 != r5) goto L29;
        return r5;
    L29:
        r10 = r16;
        r3 = r26;
        int r29 = r18;
        r13 = r0;
        r1 = r29;
        long r210 = r110;
        r11 = r19;
        r7 = r210;
        r12 = r17;
        goto L30
    L16:
        ResultKt.throwOnFailure(r3);
        AiProactiveDb r30 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r0.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L19;
        com.obric.aiproactive.impl.aidb.dao.g r33 = r30.recommendationDao();
        r4.L$0 = r0;
        r4.L$1 = r31;
        r4.L$2 = r30;
        r110 = r32;
        r4.J$0 = r110;
        r4.I$0 = 1;
        r4.label = 1;
        r3 = r33.findLatestTraceId(r4);
        if (r3 != r5) goto L23;
        return r5;
    L23:
        r17 = r31;
        r19 = r30;
        r18 = 1;
        goto L24
    L19:
        return Unit.INSTANCE;
    L7:
        r4 = new AiProactiveDbRepository$submitDirectFeedback$1(r0, r2);
        goto L8
    }

    public final Object a(com.obric.aiproactive.api.u r31, long r32, Continuation<? super Boolean> r34) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r34, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AiProactiveDbRepository$updateRecommendationFeedback$1.class) == false) goto L7;
        AiProactiveDbRepository$updateRecommendationFeedback$1 r4 = (AiProactiveDbRepository$updateRecommendationFeedback$1) ZeusTransformUtils.preCheckCast(r2, AiProactiveDbRepository$updateRecommendationFeedback$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r4.label;
        int r11 = 2;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        int r0 = r4.I$1;
        int r6 = r4.I$0;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.L$4, String.class, "com.obric.memorydata.plugin");
        h r8 = (h) ZeusTransformUtils.preCheckCast(r4.L$3, h.class, "com.obric.memorydata.plugin");
        t r9 = (t) ZeusTransformUtils.preCheckCast(r4.L$2, t.class, "com.obric.memorydata.plugin");
        final com.obric.aiproactive.api.u r10 = (com.obric.aiproactive.api.u) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.aiproactive.api.u.class, "com.obric.memorydata.plugin");
        final d r1 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        int r15 = r0;
        String r16 = r7;
        h r13 = r8;
        boolean r12 = false;
        final boolean r17 = true;
    L122:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        Integer r19 = com.obric.aiproactive.impl.aidb.f.a(r10.b());
        String r110 = r10.c();
        String r111 = r10.d();
        String r20 = r10.f();
        Integer r21 = r9.e();
        if (r6 != 0) goto L126;
        r17 = r12;
    L126:
        r13.a(r16, r15, r18, r19, r110, r111, r20, r21, new $$Lambda$d$TCGo1qLiWMkfzPD0MKW5Bc7qrc0(r1, r17, r10));
        return Boxing.boxBoolean(r9.b());
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        boolean r22 = r4.Z$0;
        r6 = r4.I$0;
        AiProactiveDb r23 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r4.L$3, AiProactiveDb.class, "com.obric.memorydata.plugin");
        t r24 = (t) ZeusTransformUtils.preCheckCast(r4.L$2, t.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.api.u r25 = (com.obric.aiproactive.api.u) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.aiproactive.api.u.class, "com.obric.memorydata.plugin");
        r1 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L101:
        String r26 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        r10 = r25;
        r9 = r24;
    L102:
        AiProactiveDb r29 = r23;
        String r27 = r26;
        CharSequence r28 = (CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.memorydata.plugin");
        if (r28 != null) goto L107;
    L110:
        boolean r112 = true;
    L111:
        if (r112 == false) goto L118;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbRepository", "[Repository] skipRecommendationFeedbackReport missingLogId=true valueOnly=" + r22, null, 4, null);
        if (r6 == 0) goto L115;
        boolean r113 = true;
    L116:
        r1.a(false, r113, String.valueOf(r10.a()));
        return Boxing.boxBoolean(r9.b());
    L115:
        r113 = false;
        goto L116
    L118:
        r12 = false;
        h r30 = r1.d;
        com.obric.aiproactive.impl.aidb.dao.g r33 = r29.recommendationDao();
        long r114 = r10.a();
        r4.L$0 = r1;
        r4.L$1 = r10;
        r4.L$2 = r9;
        r4.L$3 = r30;
        r4.L$4 = r27;
        r4.I$0 = r6;
        r17 = true;
        r4.I$1 = 1;
        r4.label = 4;
        r3 = r33.findRecommendTextById(r114, r4);
        if (r3 != r14) goto L121;
        return r14;
    L121:
        r13 = r30;
        r16 = r27;
        r15 = 1;
        goto L122
    L107:
        if (StringsKt.isBlank(r28) == true) goto L110;
        r112 = false;
        goto L111
    L18:
        r22 = r4.Z$0;
        r6 = r4.I$0;
        r23 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r4.L$3, AiProactiveDb.class, "com.obric.memorydata.plugin");
        r24 = (t) ZeusTransformUtils.preCheckCast(r4.L$2, t.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.api.u r35 = (com.obric.aiproactive.api.u) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.aiproactive.api.u.class, "com.obric.memorydata.plugin");
        r1 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L94:
        com.obric.aiproactive.api.u r115 = r35;
        Long r36 = (Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin");
    L96:
        if (r36 == null) goto L103;
        com.obric.aiproactive.impl.aidb.dao.i r37 = r23.traceDao();
        long r38 = r36.longValue();
        r4.L$0 = r1;
        r4.L$1 = r115;
        r4.L$2 = r24;
        r4.L$3 = r23;
        r4.I$0 = r6;
        r4.Z$0 = r22;
        r4.label = 3;
        r3 = r37.findLogIdById(r38, r4);
        if (r3 != r14) goto L100;
        return r14;
    L100:
        r25 = r115;
        goto L101
    L103:
        r26 = null;
        r9 = r24;
        r10 = r115;
        goto L102
    L19:
        boolean r39 = r4.Z$0;
        r6 = r4.I$0;
        r23 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r4.L$3, AiProactiveDb.class, "com.obric.memorydata.plugin");
        r24 = (t) ZeusTransformUtils.preCheckCast(r4.L$2, t.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.api.u r40 = (com.obric.aiproactive.api.u) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.aiproactive.api.u.class, "com.obric.memorydata.plugin");
        r1 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        boolean r116 = r39;
        r115 = r40;
    L58:
        boolean r41 = r116;
    L60:
        IRunLog r210 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        if (r41 == false) goto L64;
        boolean r211 = false;
        int r212 = 4;
        Object r213 = null;
        String r214 = "AiProactiveDbRepository";
        String r215 = "[Repository] updateRecommendationFeedback valueOnly=true hasValue=true";
    L63:
        IRunLog.a.a(r210, r214, r215, r211, r212, r213);
        if (r24.d() == true) goto L86;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbRepository", "[Repository] skipRecommendationFeedbackReport emptyContent=true", null, 4, null);
        return Boxing.boxBoolean(r24.b());
    L86:
        if (r24.c() == false) goto L88;
        AwarenessManager.INSTANCE.dispatchAwarenessEvent("ai_proactive_recommendation_feedback", com.obric.aiproactive.impl.aidb.f.a(r11, "ProactiveRecommendation", r115.a()));
    L88:
        r36 = r115.e();
        if (r36 != null) goto L95;
        com.obric.aiproactive.impl.aidb.dao.g r42 = r23.recommendationDao();
        long r43 = r115.a();
        r4.L$0 = r1;
        r4.L$1 = r115;
        r4.L$2 = r24;
        r4.L$3 = r23;
        r4.I$0 = r6;
        r4.Z$0 = r41;
        r4.label = r11;
        Object r44 = r42.findTraceIdById(r43, r4);
        if (r44 != r14) goto L93;
        return r14;
    L93:
        r35 = r115;
        boolean r216 = r41;
        r3 = r44;
        r22 = r216;
        goto L94
    L95:
        r22 = r41;
        goto L96
    L64:
        StringBuilder r45 = new StringBuilder().append("[Repository] updateRecommendationFeedback valueOnly=false hasType=");
        if (r115.b() == null) goto L67;
        boolean r117 = true;
    L68:
        StringBuilder r46 = r45.append(r117).append(" hasReason=");
        if (r115.c() == null) goto L71;
        boolean r118 = true;
    L72:
        StringBuilder r47 = r46.append(r118).append(" hasText=");
        if (r115.d() == null) goto L75;
        boolean r119 = true;
    L76:
        StringBuilder r48 = r47.append(r119).append(" hasValue=");
        if (r24.e() == null) goto L79;
        boolean r120 = true;
    L80:
        r215 = r48.append(r120).toString();
        r211 = false;
        r212 = 4;
        r213 = null;
        r214 = "AiProactiveDbRepository";
        goto L63
    L79:
        r120 = false;
        goto L80
    L75:
        r119 = false;
        goto L76
    L71:
        r118 = false;
        goto L72
    L67:
        r117 = false;
        goto L68
    L20:
        ResultKt.throwOnFailure(r3);
        t r49 = com.obric.aiproactive.impl.aidb.f.b(r31);
        if (r49.a() == false) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbRepository", "[Repository] dropRecommendationFeedback outOfRange=true", null, 4, null);
        return Boxing.boxBoolean(false);
    L24:
        AiProactiveDb r50 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r50 == null) goto L27;
        CharSequence r51 = (CharSequence) ZeusTransformUtils.preCheckCast(r31.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r51 != null) goto L31;
    L34:
        boolean r52 = true;
    L35:
        if (r52 == false) goto L46;
        CharSequence r53 = (CharSequence) ZeusTransformUtils.preCheckCast(r31.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r53 != null) goto L39;
    L42:
        boolean r54 = true;
    L43:
        if (r54 == false) goto L46;
        int r55 = 0;
    L47:
        boolean r56 = r31.i();
        if (r31.g() == null) goto L53;
        if (r49.e() != null) goto L53;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbRepository", "[Repository] ignoreInvalidMixedFeedbackValue outOfRange=true", null, 4, null);
    L53:
        if (r49.b() == false) goto L59;
        com.obric.aiproactive.impl.aidb.dao.g r57 = r50.recommendationDao();
        long r58 = r31.a();
        String r121 = r31.b();
        String r122 = r31.c();
        String r123 = r31.d();
        r4.L$0 = this;
        r115 = r31;
        r4.L$1 = r115;
        r4.L$2 = r49;
        r4.L$3 = r50;
        r4.I$0 = r55;
        r4.Z$0 = r56;
        r4.label = 1;
        r116 = r56;
        int r124 = r55;
        if (r57.updateFeedback(r58, r121, r122, r123, r32, r4) != r14) goto L57;
        return r14;
    L57:
        r24 = r49;
        r23 = r50;
        r6 = r124;
        r1 = this;
        goto L58
    L59:
        r115 = r31;
        r11 = 2;
        r24 = r49;
        r23 = r50;
        r6 = r55;
        r41 = r56;
        r1 = this;
        goto L60
    L39:
        if (StringsKt.isBlank(r53) == true) goto L42;
        r54 = false;
    L46:
        r55 = 1;
        goto L47
    L31:
        if (StringsKt.isBlank(r51) == true) goto L34;
        r52 = false;
        goto L35
    L27:
        return Boxing.boxBoolean(false);
    L7:
        r4 = new AiProactiveDbRepository$updateRecommendationFeedback$1(this, r2);
        goto L8
    }

    public final Object a(String r31, long r32, Continuation<? super AiRuleItemDto> r34) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r34, Continuation.class, "com.obric.memorydata.plugin");
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r16 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        return null;
    L9:
        k r3 = c();
        if (r3 != null) goto L12;
        return null;
    L12:
        com.obric.aiproactive.impl.aidb.a.f r15 = new com.obric.aiproactive.impl.aidb.a.f(0, r32, r8, "user", r32, r32, 1, null);
        long r4 = r3.insert(r15);
        if (r4 <= 0) goto L15;
        r16 = true;
    L15:
        if (r16 == false) goto L19;
        com.obric.aiproactive.impl.aidb.a.f r5 = com.obric.aiproactive.impl.aidb.a.f.a(r15, r4, 0, null, null, 0, 0, 62, null);
        this.f.a();
        this.f.a(new s(1, r4, r5.c(), null, null, 24, null));
        this.f.a(r4, "create", "user");
        return a(r5);
    L19:
        throw new IllegalArgumentException("Preference insert returned an invalid database id".toString());
    L5:
        r2 = false;
        goto L7
    }

    public final Object a(String r20, String r21, AiRuleItemDto.RuleType r22, long r23, Continuation<? super AiRuleItemDto> r25) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        Long r2 = StringsKt.toLongOrNull(r20);
        if (r2 == null) goto L29;
        long r4 = r2.longValue();
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        return null;
    L10:
        k r5 = c();
        if (r5 != null) goto L13;
        return null;
    L13:
        com.obric.aiproactive.impl.aidb.a.f r6 = r5.a(r4);
        if (r6 != null) goto L16;
        return null;
    L16:
        String r12 = com.obric.aiproactive.impl.aidb.e.a(r6.getType(), r22);
        boolean r7 = !Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), r11);
        boolean r8 = true ^ StringsKt.equals(r6.getType(), r12, true);
        if (r7 == true) goto L21;
        if (r8 == true) goto L21;
        return a(r6);
    L21:
        com.obric.aiproactive.impl.aidb.a.f r9 = com.obric.aiproactive.impl.aidb.a.f.a(r6, 0, 0, r11, r12, 0, r23, 19, null);
        if (r5.update(r9) > 0) goto L24;
        return null;
    L24:
        this.f.a();
        if (i.a(r6.getType(), r9.getType(), r6.c(), r9.c()) == false) goto L27;
        this.f.a(new s(2, r9.a(), null, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), 4, null));
    L27:
        this.f.a(r9.a(), "edit", com.obric.aiproactive.impl.aidb.e.a(r9.getType()));
        return a(r9);
    L7:
        r3 = false;
        goto L8
    L29:
        return null;
    }

    public final Object a(String r13, Continuation<? super Boolean> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        Long r16 = StringsKt.toLongOrNull(r13);
        boolean r17 = false;
        if (r16 == null) goto L23;
        long r2 = r16.longValue();
        k r18 = c();
        if (r18 == null) goto L7;
        com.obric.aiproactive.impl.aidb.a.f r0 = r18.a(r2);
        if (r0 != null) goto L13;
        return Boxing.boxBoolean(false);
    L13:
        if (r18.delete(r0) <= 0) goto L15;
        r17 = true;
    L15:
        if (r17 == false) goto L21;
        this.f.a();
        if (i.a(r0.getType()) == false) goto L19;
        this.f.a(new s(3, r0.a(), StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), null, null, 24, null));
    L19:
        this.f.a(r0.a(), "del", com.obric.aiproactive.impl.aidb.e.a(r0.getType()));
    L21:
        return Boxing.boxBoolean(r17);
    L7:
        return Boxing.boxBoolean(false);
    L23:
        return Boxing.boxBoolean(false);
    }

    public final Object a(List<String> r9, long r10, Continuation<? super List<AiRuleItemDto>> r12) {
        return a((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), "assistant", r10, (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object a(Continuation<? super List<com.obric.aiproactive.api.t>> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AiProactiveDbRepository$listPendingRecommendations$1.class) == false) goto L7;
        AiProactiveDbRepository$listPendingRecommendations$1 r1 = (AiProactiveDbRepository$listPendingRecommendations$1) ZeusTransformUtils.preCheckCast(r10, AiProactiveDbRepository$listPendingRecommendations$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        d r8 = (d) ZeusTransformUtils.preCheckCast(r1.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L28:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L30:
        if (r13.hasNext() == false) goto L33;
        r0.add(r8.a((com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin")));
        goto L30
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AiProactiveDb r14 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r1.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L24:
        u r15 = l.a(((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        com.obric.aiproactive.impl.aidb.dao.g r16 = r14.recommendationDao();
        SupportSQLiteQuery r17 = r15.a();
        r1.L$0 = r2;
        r1.L$1 = null;
        r1.label = 2;
        r11 = r16.listRecommendations(r17, r1);
        if (r11 != r3) goto L27;
        return r3;
    L27:
        r8 = r2;
        goto L28
    L16:
        ResultKt.throwOnFailure(r11);
        AiProactiveDb r18 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L19;
        com.obric.aiproactive.impl.aidb.dao.g r5 = r18.recommendationDao();
        r1.L$0 = this;
        r1.L$1 = r18;
        r1.label = 1;
        Object r6 = l.a(r5, r1);
        if (r6 != r3) goto L23;
        return r3;
    L23:
        r2 = this;
        r14 = r18;
        r11 = r6;
        goto L24
    L19:
        return CollectionsKt.emptyList();
    L7:
        r1 = new AiProactiveDbRepository$listPendingRecommendations$1(this, r10);
        goto L8
    }

    public final kotlinx.coroutines.flow.i<Pair<Integer, List<com.obric.aiproactive.api.p>>> a(long r11) {
        AiProactiveDb r5 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        Pair<Long, Long> r0 = b(r11);
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r0.component1(), Number.class, "com.obric.memorydata.plugin")).longValue();
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r0.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
        return kotlinx.coroutines.flow.k.b(r5.eventRecordDao().observeAllRecordCount(), r5.eventRecordDao().observeTodayRecords(r3, r1), (Function3) ZeusTransformUtils.preCheckCast(new AiProactiveDbRepository$observeTodayEventRecords$1(this, r5, r11, null), Function3.class, "com.obric.memorydata.plugin"));
    L5:
        return kotlinx.coroutines.flow.k.a(TuplesKt.to(0, CollectionsKt.emptyList()));
    }

    public final Object b(long r22, long r24, Continuation<? super com.obric.aiproactive.api.t> r26) {
        d r0 = this;
        long r1 = r22;
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AiProactiveDbRepository$markCurrentActionExecuted$1.class) == false) goto L7;
        AiProactiveDbRepository$markCurrentActionExecuted$1 r6 = (AiProactiveDbRepository$markCurrentActionExecuted$1) ZeusTransformUtils.preCheckCast(r4, AiProactiveDbRepository$markCurrentActionExecuted$1.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r6.label;
        if (r7 == 0) goto L18;
        if (r7 == 1) goto L17;
        if (r7 == 2) goto L16;
        if (r7 != 3) goto L15;
        com.obric.aiproactive.api.t r2 = (com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(r6.L$0, com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        return r2;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r3 = r6.J$0;
        AiProactiveDb r8 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r6.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r9 = (d) ZeusTransformUtils.preCheckCast(r6.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        long r10 = r3;
        AiProactiveDb r11 = r8;
        r0 = r9;
        Object r12 = r5;
        Object r13 = r15;
    L34:
        com.obric.aiproactive.api.t r14 = (com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(r12, com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin");
        AiProactiveCardStatus r16 = AiProactiveCardStatus.EXECUTED;
        r6.L$0 = r14;
        r6.L$1 = null;
        r6.label = 3;
        if (a(r0, r11, r10, r16, null, r6, 8, null) != r13) goto L38;
        return r13;
    L38:
        return r14;
    L17:
        long r17 = r6.J$1;
        long r18 = r6.J$0;
        AiProactiveDb r19 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r6.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r20 = (d) ZeusTransformUtils.preCheckCast(r6.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        AiProactiveDb r21 = r19;
        r0 = r20;
        r1 = r18;
        long r110 = r17;
    L24:
        com.obric.aiproactive.impl.aidb.a.g r23 = (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r5, com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin");
        if (r23 != null) goto L27;
        return null;
    L27:
        List<com.obric.aiproactive.api.b> r25 = r0.a(r23.f());
        if (r25.isEmpty() == false) goto L30;
        return null;
    L30:
        List<com.obric.aiproactive.api.b> r27 = com.obric.aiproactive.api.c.d(r25);
        r6.L$0 = r0;
        r6.L$1 = r21;
        r6.J$0 = r1;
        r6.label = 2;
        r13 = r15;
        r12 = a(r0, r23, r27, r110, null, r6, 8, null);
        if (r12 != r13) goto L33;
        return r13;
    L33:
        r10 = r1;
        r11 = r21;
        goto L34
    L18:
        ResultKt.throwOnFailure(r5);
        r21 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r0.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L21;
        return null;
    L21:
        r6.L$0 = r0;
        r6.L$1 = r21;
        r6.J$0 = r1;
        r110 = r24;
        r6.J$1 = r110;
        r6.label = 1;
        r5 = r0.b(r21, r1, r6);
        if (r5 != r15) goto L24;
        return r15;
    L7:
        r6 = new AiProactiveDbRepository$markCurrentActionExecuted$1(r0, r4);
        goto L8
    }

    public final Object b(long r9, Continuation<? super com.obric.aiproactive.api.t> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AiProactiveDbRepository$getRecommendationById$1.class) == false) goto L7;
        AiProactiveDbRepository$getRecommendationById$1 r0 = (AiProactiveDbRepository$getRecommendationById$1) ZeusTransformUtils.preCheckCast(r12, AiProactiveDbRepository$getRecommendationById$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d this = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L23:
        com.obric.aiproactive.impl.aidb.a.g r10 = (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r13, com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L27;
        return null;
    L27:
        return this.a(r10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (r9 > 0) goto L17;
        return null;
    L17:
        AiProactiveDb r14 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L20;
        return null;
    L20:
        r0.L$0 = this;
        r0.label = 1;
        r13 = b(r14, r9, r0);
        if (r13 != r2) goto L23;
        return r2;
    L7:
        r0 = new AiProactiveDbRepository$getRecommendationById$1(this, r12);
        goto L8
    }

    public final Object b(List<String> r9, long r10, Continuation<? super List<AiRuleItemDto>> r12) {
        return a((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), "interview", r10, (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object b(Continuation<? super List<com.obric.aiproactive.api.t>> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AiProactiveDbRepository$listAllRecommendations$1.class) == false) goto L7;
        AiProactiveDbRepository$listAllRecommendations$1 r1 = (AiProactiveDbRepository$listAllRecommendations$1) ZeusTransformUtils.preCheckCast(r10, AiProactiveDbRepository$listAllRecommendations$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        d r8 = (d) ZeusTransformUtils.preCheckCast(r1.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L28:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L30:
        if (r13.hasNext() == false) goto L33;
        r0.add(r8.a((com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin")));
        goto L30
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AiProactiveDb r14 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r1.L$1, AiProactiveDb.class, "com.obric.memorydata.plugin");
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L24:
        u r15 = l.b(((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        com.obric.aiproactive.impl.aidb.dao.g r16 = r14.recommendationDao();
        SupportSQLiteQuery r17 = r15.a();
        r1.L$0 = r2;
        r1.L$1 = null;
        r1.label = 2;
        r11 = r16.listRecommendations(r17, r1);
        if (r11 != r3) goto L27;
        return r3;
    L27:
        r8 = r2;
        goto L28
    L16:
        ResultKt.throwOnFailure(r11);
        AiProactiveDb r18 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L19;
        com.obric.aiproactive.impl.aidb.dao.g r5 = r18.recommendationDao();
        r1.L$0 = this;
        r1.L$1 = r18;
        r1.label = 1;
        Object r6 = l.a(r5, r1);
        if (r6 != r3) goto L23;
        return r3;
    L23:
        r2 = this;
        r14 = r18;
        r11 = r6;
        goto L24
    L19:
        return CollectionsKt.emptyList();
    L7:
        r1 = new AiProactiveDbRepository$listAllRecommendations$1(this, r10);
        goto L8
    }

    public final kotlinx.coroutines.flow.i<List<com.obric.aiproactive.api.t>> b() {
        AiProactiveDb r0 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return kotlinx.coroutines.flow.k.a(CollectionsKt.emptyList());
    L7:
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new e(kotlinx.coroutines.flow.k.a((Function2) ZeusTransformUtils.preCheckCast(new AiProactiveDbRepository$observeAllRecommendations$1(r0, null), Function2.class, "com.obric.memorydata.plugin")), this), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public final Object c(Continuation<? super List<AiRuleItemDto>> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        AiProactiveDb r7 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r7.preferenceDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0280d((Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L11;
        r0.add(a((com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin")));
        goto L8
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    public final Object d(Continuation<? super aa> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        AiProactiveDb r6 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        return new aa(0, 0, 0, 7, null);
    L7:
        return com.obric.aiproactive.impl.aidb.e.b(r6.preferenceDao().queryAll());
    }

    public final Object e(Continuation<? super Long> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        AiProactiveDb r8 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(this.f6309b.invoke(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L5;
        SimpleSQLiteQuery r0 = new SimpleSQLiteQuery("SELECT COALESCE(MAX(timestamp), 0)\nFROM ProactiveCompressRecord\nWHERE preference_ids IS NOT NULL\n  AND TRIM(preference_ids) <> ''");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        d r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r9 = Result.m1421constructorimpl(Boxing.boxLong(r8.preferenceDao().rawQueryForLong((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(r0, SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L9
    L11:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L14;
        RunLog.INSTANCE.warn("AiProactiveDbRepository", "[Repository] getLatestAiRuleUpdateTimestamp failed", r10);
    L14:
        Long r11 = Boxing.boxLong(0);
        if (Result.m1427isFailureimpl(r9) == true) goto L17;
        return r9;
    L17:
        return r11;
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    L5:
        return Boxing.boxLong(0);
    }
}
