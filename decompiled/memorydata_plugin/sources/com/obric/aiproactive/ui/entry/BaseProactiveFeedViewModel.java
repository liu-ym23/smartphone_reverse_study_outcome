package com.obric.aiproactive.ui.entry;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.AiProactiveRecommendationFeedbackClassification;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveInspirationDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.an;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000×\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001&\b&\u0018\u0000 \u0085\u00012\u00020\u0001:\u0004\u0085\u0001\u0086\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020<J\u0010\u0010>\u001a\u00020<2\b\u0010?\u001a\u0004\u0018\u00010\u0017J\u000e\u0010@\u001a\u00020<2\u0006\u0010?\u001a\u00020\u0017J\u0018\u0010A\u001a\u00020<2\u0006\u0010?\u001a\u00020\u00172\b\u0010B\u001a\u0004\u0018\u00010\u0017J\u000e\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020\u0017J \u0010E\u001a\u00020<2\u0006\u0010?\u001a\u00020\u00172\u0006\u0010F\u001a\u0002002\b\b\u0002\u0010G\u001a\u00020HJ\u0018\u0010I\u001a\u00020<2\u0006\u0010?\u001a\u00020\u00172\b\u0010J\u001a\u0004\u0018\u00010\u0017J\u0018\u0010K\u001a\u00020<2\u0006\u0010?\u001a\u00020\u00172\b\u0010L\u001a\u0004\u0018\u00010\u0017J$\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020\u001e2\u0014\b\u0002\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020<0PJ4\u0010Q\u001a\u00020<2\u0006\u0010N\u001a\u00020\u001e2\u0006\u0010R\u001a\u0002002\u0006\u0010S\u001a\u00020T2\u0014\b\u0002\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020<0PJ\u000e\u0010U\u001a\u00020<2\u0006\u0010V\u001a\u00020WJ\u0016\u0010X\u001a\u00020<2\u0006\u0010Y\u001a\u00020#2\u0006\u0010S\u001a\u00020TJ\u000e\u0010Z\u001a\u00020<2\u0006\u0010[\u001a\u00020\\J\u000e\u0010]\u001a\u00020<2\u0006\u0010[\u001a\u00020^J\u0010\u0010_\u001a\u00020<2\u0006\u0010`\u001a\u00020\u0010H\u0004J\u0010\u0010a\u001a\u00020<2\u0006\u0010?\u001a\u00020\u0017H\u0016J\u0010\u0010b\u001a\u00020<2\u0006\u0010D\u001a\u00020\u0017H\u0016J\u0012\u0010c\u001a\u00020\u00172\b\b\u0001\u0010d\u001a\u000200H\u0004J\u000e\u0010e\u001a\u00020<H¤@¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020<H$J$\u0010h\u001a\u00020H2\u0006\u0010?\u001a\u00020\u00172\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0PH$J\b\u0010j\u001a\u00020<H$J\u0010\u0010k\u001a\u00020<2\u0006\u0010?\u001a\u00020\u0017H\u0014J\b\u0010l\u001a\u00020<H\u0002J\u0010\u0010m\u001a\u00020<2\u0006\u0010n\u001a\u00020oH\u0002J\u0010\u0010p\u001a\u00020<2\u0006\u0010n\u001a\u00020oH\u0002J\u0016\u0010q\u001a\u00020<2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0004J.\u0010s\u001a\u00020H2\u0006\u0010t\u001a\u00020#2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00172\f\u0010x\u001a\b\u0012\u0004\u0012\u00020<0yH\u0004J8\u0010z\u001a\u00020H2\u0006\u0010t\u001a\u00020#2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00172\b\b\u0002\u0010{\u001a\u00020H2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020<0yH\u0004J\b\u0010\"\u001a\u00020#H\u0004J\u0018\u0010|\u001a\u00020<2\u0006\u0010u\u001a\u00020v2\u0006\u0010}\u001a\u00020~H\u0004J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0004J\u0011\u0010\u0081\u0001\u001a\u0002002\u0006\u0010S\u001a\u00020TH\u0002J!\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0014\u0010(\u001a\u00020)X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00178DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u0002008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b4\u00102R\u0014\u00105\u001a\u0002068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0019¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001b¨\u0006\u0087\u0001"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "timeProvider", "Lcom/obric/aiproactive/ui/model/TimeProvider;", "statsStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveRecommendationStatsStore;", "<init>", "(Lcom/obric/aiproactive/ui/data/ProactiveRepository;Lcom/obric/aiproactive/ui/model/TimeProvider;Lcom/obric/aiproactive/ui/feedback/ProactiveRecommendationStatsStore;)V", "getRepository", "()Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "getTimeProvider", "()Lcom/obric/aiproactive/ui/model/TimeProvider;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "_selectedInspirationId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "selectedInspirationId", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedInspirationId", "()Lkotlinx/coroutines/flow/StateFlow;", "_recommendationIndex", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "refreshJob", "Lkotlinx/coroutines/Job;", "patchJob", "currentBatchId", "", "instanceId", "aiProactiveActionCommandWriter", "com/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$aiProactiveActionCommandWriter$1", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$aiProactiveActionCommandWriter$1;", "zoneId", "Ljava/time/ZoneId;", "getZoneId", "()Ljava/time/ZoneId;", "logTag", "getLogTag", "()Ljava/lang/String;", "nowPageLimit", "", "getNowPageLimit", "()I", "allDayPageLimit", "getAllDayPageLimit", "dayKeyFormatter", "Ljava/time/format/DateTimeFormatter;", "getDayKeyFormatter", "()Ljava/time/format/DateTimeFormatter;", "selectedRecommendation", "getSelectedRecommendation", "startIfNeeded", "", "refresh", "selectInspiration", "inspirationId", "notifyVoteChanged", "requestEditActionExecuteInstruction", "currentText", "requestCopyDebugLogId", "recommendId", "optimisticallyUpdateRecommendStatus", "recommendStatus", "isIgnored", "", "optimisticallyUpdateFeedbackAction", "feedbackAction", "updateActionExecuteInstruction", "actionExecuteInstruction", "markAiRecommendationCurrentActionExecuted", NotificationCompat.CATEGORY_RECOMMENDATION, "onCommandAccepted", "Lkotlin/Function1;", "markAiRecommendationActionExecuted", "actionIndex", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "updateInspiration", "dto", "Lcom/obric/aiproactive/api/ProactiveInspirationDto;", "updateAiRecommendationCardStatus", "recommendationId", "updateAiRecommendationFeedback", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "submitAiDirectFeedback", "Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;", "tryEmitUiEvent", "event", "onRecommendationAdoptedFromDetail", "onRecommendationDismissedFromSync", TypedValues.Custom.S_STRING, "resId", "observeFeed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBeforeRefresh", "updateRecommendationInLocalState", "transform", "rebuildPageItemsAfterLocalMutation", "pinNowAdopted", "ensurePatchSubscription", "applyAndBroadcastPatch", "patch", "Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;", "applyPatchLocally", "publishRecommendationIndex", Constants.KEY_LIST, "acceptBatch", "newBatchId", "pageType", "Lcom/obric/aiproactive/api/PageType;", InfoRequestQPSOptTraceLogger.REASON, "onAccepted", "Lkotlin/Function0;", "acceptStrictlyNewerBatch", "isEmptyReset", "handleObserverError", "throwable", "", "currentDate", "Ljava/time/LocalDate;", "mapAiCardStatusToRecommendStatus", "buildAiUserFeedback", "feedbackReason", "feedbackText", "Companion", "UiEvent", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseProactiveFeedViewModel extends ViewModel {
    public static final a Companion = null;
    private static final kotlinx.coroutines.flow.ad<com.obric.aiproactive.ui.model.h> recommendationPatchBus = null;
    private final kotlinx.coroutines.flow.ae<List<ProactiveRecommendationDto>> _recommendationIndex;
    private final kotlinx.coroutines.flow.ae<String> _selectedInspirationId;
    private final kotlinx.coroutines.flow.ad<b> _uiEvent;
    private final d aiProactiveActionCommandWriter;
    private long currentBatchId;
    private final String instanceId;
    private bx patchJob;
    private bx refreshJob;
    private final com.obric.aiproactive.ui.data.b repository;
    private final ar<String> selectedInspirationId;
    private final ar<ProactiveRecommendationDto> selectedRecommendation;
    private final com.obric.aiproactive.ui.feedback.g statsStore;
    private final com.obric.aiproactive.ui.model.m timeProvider;
    private final ai<b> uiEvent;
    private final ZoneId zoneId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$Companion;", "", "<init>", "()V", "recommendationPatchBus", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent;", "", "<init>", "()V", "VoteChanged", "RequestEditInstruction", "CopyDebugLogId", "Toast", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent$CopyDebugLogId;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent$RequestEditInstruction;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent$Toast;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent$VoteChanged;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class b {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent$CopyDebugLogId;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent;", "recommendId", "", "debugLogId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRecommendId", "()Ljava/lang/String;", "getDebugLogId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f6576a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f6577b;

            public a(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "recommendId");
                Intrinsics.checkNotNullParameter(r3, "debugLogId");
                super(null);
                this.f6576a = r2;
                this.f6577b = r3;
            }

            public final String a() {
                return this.f6577b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f6576a, r6.f6576a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f6577b, r6.f6577b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f6576a.hashCode() * 31) + this.f6577b.hashCode();
            }

            public String toString() {
                return "CopyDebugLogId(recommendId=" + this.f6576a + ", debugLogId=" + this.f6577b + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent$RequestEditInstruction;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent;", "inspirationId", "", "currentText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getInspirationId", "()Ljava/lang/String;", "getCurrentText", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0299b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f6578a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f6579b;

            public C0299b(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "inspirationId");
                super(null);
                this.f6578a = r2;
                this.f6579b = r3;
            }

            public final String a() {
                return this.f6578a;
            }

            public final String b() {
                return this.f6579b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0299b.class) == true) goto L8;
                return false;
            L8:
                C0299b r6 = (C0299b) ZeusTransformUtils.preCheckCast(r5, C0299b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f6578a, r6.f6578a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f6579b, r6.f6579b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = this.f6578a.hashCode() * 31;
                String r1 = this.f6579b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "RequestEditInstruction(inspirationId=" + this.f6578a + ", currentText=" + this.f6579b + ')';
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent$Toast;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f6580a;

            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "message");
                super(null);
                this.f6580a = r2;
            }

            public final String a() {
                return this.f6580a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
                return false;
            L8:
                c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f6580a, r6.f6580a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f6580a.hashCode();
            }

            public String toString() {
                return "Toast(message=" + this.f6580a + ')';
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent$VoteChanged;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent;", "inspirationId", "", "<init>", "(Ljava/lang/String;)V", "getInspirationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f6581a;

            public d(String r2) {
                Intrinsics.checkNotNullParameter(r2, "inspirationId");
                super(null);
                this.f6581a = r2;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
                return false;
            L8:
                d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f6581a, r6.f6581a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f6581a.hashCode();
            }

            public String toString() {
                return "VoteChanged(inspirationId=" + this.f6581a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6582a = null;

        static {
            int[] r0 = new int[AiProactiveCardStatus.values().length];
            r0[AiProactiveCardStatus.DISMISSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AiProactiveCardStatus.PENDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AiProactiveCardStatus.ACKNOWLEDGED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AiProactiveCardStatus.EXECUTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f6582a = r0;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$aiProactiveActionCommandWriter$1", "Lcom/obric/aiproactive/ui/model/AiProactiveActionCommandWriter;", "markCurrentActionExecuted", "", "recommendationId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markActionExecuted", "actionIndex", "", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "(JILcom/obric/aiproactive/api/AiProactiveCardStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.aiproactive.ui.model.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProactiveFeedViewModel f6583a;

        d(BaseProactiveFeedViewModel r1) {
            this.f6583a = r1;
        }

        @Override // com.obric.aiproactive.ui.model.a
        public Object a(long r7, int r9, AiProactiveCardStatus r10, Continuation<? super Unit> r11) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            Object r6 = this.f6583a.getRepository().a(r7, r9, r10, r5);
            if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r6;
        L6:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aiproactive.ui.model.a
        public Object a(long r3, Continuation<? super Unit> r5) {
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f6583a.getRepository().a(r3, r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$ensurePatchSubscription$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$ensurePatchSubscription$1", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {564}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        AnonymousClass1(BaseProactiveFeedViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ad r7 = BaseProactiveFeedViewModel.access$getRecommendationPatchBus$cp();
            final BaseProactiveFeedViewModel r3 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C03001(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$markAiRecommendationActionExecuted$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$markAiRecommendationActionExecuted$3", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {382}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $actionIndex;
        final /* synthetic */ AiProactiveCardStatus $cardStatus;
        final /* synthetic */ com.obric.aiproactive.ui.model.b $executionPlan;
        final /* synthetic */ Function1<ProactiveRecommendationDto, Unit> $onCommandAccepted;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        AnonymousClass3(com.obric.aiproactive.ui.model.b r3, BaseProactiveFeedViewModel r4, Function1<? super ProactiveRecommendationDto, Unit> r5, int r6, AiProactiveCardStatus r7, Continuation<? super AnonymousClass3> r8) {
            Function1<ProactiveRecommendationDto, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$executionPlan = r3;
            this.this$0 = r4;
            this.$onCommandAccepted = r9;
            this.$actionIndex = r6;
            this.$cardStatus = r7;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass3 r12 = new AnonymousClass3(this.$executionPlan, this.this$0, this.$onCommandAccepted, this.$actionIndex, this.$cardStatus, r8);
            r12.L$0 = r10;
            return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L15
        L13:
            Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            com.obric.aiproactive.ui.model.b r2 = this.$executionPlan;
            Function1<ProactiveRecommendationDto, Unit> r3 = this.$onCommandAccepted;
            if (Result.m1428isSuccessimpl(r10) == false) goto L22;
            Unit r4 = (Unit) ZeusTransformUtils.preCheckCast(r10, Unit.class, "com.obric.memorydata.plugin");
            ProactiveRecommendationDto r5 = r2.e();
            if (r5 == null) goto L22;
            r3.invoke(r5);
        L22:
            BaseProactiveFeedViewModel r6 = this.this$0;
            com.obric.aiproactive.ui.model.b r7 = this.$executionPlan;
            int r8 = this.$actionIndex;
            AiProactiveCardStatus r11 = this.$cardStatus;
            Throwable r12 = Result.m1424exceptionOrNullimpl(r10);
            if (r12 == null) goto L26;
            RunLog.INSTANCE.error(r6.getLogTag(), "[BaseViewModel] markAiRecommendationActionExecuted failed id=" + r7.a() + " actionIndex=" + r8 + " cardStatus=" + r11, r12);
            r6.refresh();
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
            al r13 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            com.obric.aiproactive.ui.model.b r14 = this.$executionPlan;
            BaseProactiveFeedViewModel r15 = this.this$0;
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L15
            com.obric.aiproactive.ui.model.a r17 = (com.obric.aiproactive.ui.model.a) ZeusTransformUtils.preCheckCast(BaseProactiveFeedViewModel.access$getAiProactiveActionCommandWriter$p(r15), com.obric.aiproactive.ui.model.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            if (com.obric.aiproactive.ui.model.l.a(r14, r17, this) != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$markAiRecommendationCurrentActionExecuted$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$markAiRecommendationCurrentActionExecuted$3", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {354}, m = "invokeSuspend", n = {}, s = {})
    static final class C10513 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.aiproactive.ui.model.b $executionPlan;
        final /* synthetic */ Function1<ProactiveRecommendationDto, Unit> $onCommandAccepted;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        C10513(com.obric.aiproactive.ui.model.b r3, BaseProactiveFeedViewModel r4, Function1<? super ProactiveRecommendationDto, Unit> r5, Continuation<? super C10513> r6) {
            Function1<ProactiveRecommendationDto, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$executionPlan = r3;
            this.this$0 = r4;
            this.$onCommandAccepted = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            C10513 r0 = new C10513(this.$executionPlan, this.this$0, this.$onCommandAccepted, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10513) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10513.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
        L13:
            Object r8 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            com.obric.aiproactive.ui.model.b r2 = this.$executionPlan;
            Function1<ProactiveRecommendationDto, Unit> r3 = this.$onCommandAccepted;
            if (Result.m1428isSuccessimpl(r8) == false) goto L22;
            Unit r4 = (Unit) ZeusTransformUtils.preCheckCast(r8, Unit.class, "com.obric.memorydata.plugin");
            ProactiveRecommendationDto r5 = r2.e();
            if (r5 == null) goto L22;
            r3.invoke(r5);
        L22:
            BaseProactiveFeedViewModel r6 = this.this$0;
            com.obric.aiproactive.ui.model.b r9 = this.$executionPlan;
            Throwable r10 = Result.m1424exceptionOrNullimpl(r8);
            if (r10 == null) goto L26;
            RunLog.INSTANCE.error(r6.getLogTag(), "[BaseViewModel] markAiRecommendationCurrentActionExecuted failed id=" + r9.a(), r10);
            r6.refresh();
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
            al r11 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            com.obric.aiproactive.ui.model.b r12 = this.$executionPlan;
            BaseProactiveFeedViewModel r13 = this.this$0;
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L15
            com.obric.aiproactive.ui.model.a r15 = (com.obric.aiproactive.ui.model.a) ZeusTransformUtils.preCheckCast(BaseProactiveFeedViewModel.access$getAiProactiveActionCommandWriter$p(r13), com.obric.aiproactive.ui.model.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            if (com.obric.aiproactive.ui.model.l.a(r12, r15, this) != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$requestCopyDebugLogId$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$requestCopyDebugLogId$1", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {247, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 253}, m = "invokeSuspend", n = {}, s = {})
    static final class C10521 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $recommendId;
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        C10521(BaseProactiveFeedViewModel r3, String r4, Continuation<? super C10521> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$recommendId = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10521(this.this$0, this.$recommendId, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10521) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10521.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = true;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r13);
        L29:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r13);
        L15:
            String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L18;
        L21:
            if (r4 == false) goto L25;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[BaseViewModel] requestCopyDebugLogId notFound id=" + this.$recommendId, null, 4, null);
            kotlinx.coroutines.flow.ad r15 = BaseProactiveFeedViewModel.access$get_uiEvent$p(this.this$0);
            b.c r3 = new b.c(this.this$0.string(ZeusTransformUtils.mapRes(R.string.proactive_debug_log_not_found, TypedValues.Custom.S_STRING, "proactive_debug_log_not_found")));
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (r15.emit(r3, r5) != r0) goto L29;
            return r0;
        L25:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[BaseViewModel] requestCopyDebugLogId success id=" + this.$recommendId + " debugLogId=" + r14, false, 4, null);
            kotlinx.coroutines.flow.ad r6 = BaseProactiveFeedViewModel.access$get_uiEvent$p(this.this$0);
            b.a r7 = new b.a(this.$recommendId, r14);
            Continuation<? super Unit> r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 3;
            if (r6.emit(r7, r16) != r0) goto L29;
            return r0;
        L18:
            if (StringsKt.isBlank(r2) == true) goto L21;
            r4 = false;
            goto L21
        L12:
            ResultKt.throwOnFailure(r13);
            com.obric.aiproactive.ui.data.b r17 = this.this$0.getRepository();
            String r8 = this.$recommendId;
            Continuation<? super String> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r13 = r17.b(r8, r9);
            if (r13 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$submitAiDirectFeedback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$submitAiDirectFeedback$1", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {521}, m = "invokeSuspend", n = {}, s = {})
    static final class C10531 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.aiproactive.api.o $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        C10531(BaseProactiveFeedViewModel r3, com.obric.aiproactive.api.o r4, Continuation<? super C10531> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$request = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            C10531 r0 = new C10531(this.this$0, this.$request, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10531) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10531.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L7
        L22:
            Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L26:
            if (Result.m1428isSuccessimpl(r12) == false) goto L28;
            Unit r2 = (Unit) ZeusTransformUtils.preCheckCast(r12, Unit.class, "com.obric.memorydata.plugin");
        L28:
            BaseProactiveFeedViewModel r3 = this.this$0;
            com.obric.aiproactive.api.o r10 = this.$request;
            Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
            if (r13 == null) goto L32;
            RunLog.INSTANCE.error(r3.getLogTag(), "[BaseViewModel] submitAiDirectFeedback failed type=" + r10.a(), r13);
            kotlinx.coroutines.flow.ad r14 = BaseProactiveFeedViewModel.access$get_uiEvent$p(r3);
            String r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_feedback_failed, TypedValues.Custom.S_STRING, "proactive_feedback_failed"));
            Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
            r14.a(new b.c(r4));
        L32:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r11);
            al r15 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            String r6 = this.this$0.getLogTag();
            StringBuilder r16 = new StringBuilder().append("[BaseViewModel] submitAiDirectFeedback type=").append(this.$request.a()).append(" related=");
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(this.$request.d(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L14;
        L17:
            boolean r8 = true;
        L18:
            IRunLog.a.a(r5, r6, r16.append(!r8).toString(), false, 4, null);
            BaseProactiveFeedViewModel r17 = this.this$0;
            com.obric.aiproactive.api.o r9 = this.$request;
            Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L7
            com.obric.aiproactive.ui.data.b r19 = r17.getRepository();     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r19.a(r9, this) != r0) goto L22;
            return r0;
        L14:
            if (StringsKt.isBlank(r7) == true) goto L17;
            r8 = false;
        L7:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L26
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$updateActionExecuteInstruction$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$updateActionExecuteInstruction$2", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {325, 330, 337, 340}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $aiRecommendationId;
        final /* synthetic */ String $normalized;
        final /* synthetic */ String $recommendId;
        final /* synthetic */ ProactiveRecommendationDto $targetDto;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        AnonymousClass2(ProactiveRecommendationDto r3, BaseProactiveFeedViewModel r4, Long r5, String r6, String r7, Continuation<? super AnonymousClass2> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$targetDto = r3;
            this.this$0 = r4;
            this.$aiRecommendationId = r5;
            this.$normalized = r6;
            this.$recommendId = r7;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r12 = new AnonymousClass2(this.$targetDto, this.this$0, this.$aiRecommendationId, this.$normalized, this.$recommendId, r8);
            r12.L$0 = r10;
            return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            BaseProactiveFeedViewModel r13 = (BaseProactiveFeedViewModel) ZeusTransformUtils.preCheckCast(this.L$1, BaseProactiveFeedViewModel.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);
        L40:
            r13.refresh();
        L42:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r14);
        L34:
            BaseProactiveFeedViewModel r15 = this.this$0;
            String r4 = this.$recommendId;
            Throwable r5 = Result.m1424exceptionOrNullimpl(r2);
            if (r5 == null) goto L42;
            RunLog.INSTANCE.error(r15.getLogTag(), "[BaseViewModel] updateActionExecuteInstruction failed id=" + r4, r5);
            kotlinx.coroutines.flow.ad r6 = BaseProactiveFeedViewModel.access$get_uiEvent$p(r15);
            b.c r7 = new b.c(r15.string(ZeusTransformUtils.mapRes(R.string.proactive_save_failed, TypedValues.Custom.S_STRING, "proactive_save_failed")));
            this.L$0 = r2;
            this.L$1 = r15;
            this.label = 4;
            if (r6.emit(r7, this) != r0) goto L39;
            return r0;
        L39:
            r13 = r15;
        L12:
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L27
        L25:
            Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L29:
            r2 = r16;
            BaseProactiveFeedViewModel r17 = this.this$0;
            String r8 = this.$recommendId;
            if (Result.m1428isSuccessimpl(r2) == false) goto L34;
            Unit r9 = (Unit) ZeusTransformUtils.preCheckCast(r2, Unit.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r17.getLogTag(), "[BaseViewModel] updateActionExecuteInstruction success id=" + r8, false, 4, null);
            kotlinx.coroutines.flow.ad r10 = BaseProactiveFeedViewModel.access$get_uiEvent$p(r17);
            b.c r11 = new b.c(r17.string(ZeusTransformUtils.mapRes(R.string.proactive_saved, TypedValues.Custom.S_STRING, "proactive_saved")));
            this.L$0 = r2;
            this.label = 3;
            if (r10.emit(r11, this) != r0) goto L34;
            return r0;
        L14:
            ResultKt.throwOnFailure(r14);
            al r18 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            ProactiveRecommendationDto r19 = this.$targetDto;
            BaseProactiveFeedViewModel r3 = this.this$0;
            Long r12 = this.$aiRecommendationId;
            String r20 = this.$normalized;
            String r110 = this.$recommendId;
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
            if (Intrinsics.areEqual(r19.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == false) goto L22;
            com.obric.aiproactive.ui.data.b r112 = r3.getRepository();     // Catch: Throwable -> L27
            if (r12 == null) goto L25;
            long r113 = r12.longValue();     // Catch: Throwable -> L27
            this.label = 1;     // Catch: Throwable -> L27
            if (r112.a(r113, r20, this) != r0) goto L25;
            return r0;
        L22:
            com.obric.aiproactive.ui.data.b r114 = r3.getRepository();     // Catch: Throwable -> L27
            this.label = 2;     // Catch: Throwable -> L27
            if (r114.a(r110, r20, this) != r0) goto L25;
            return r0;
        L27:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L29
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$updateAiRecommendationCardStatus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$updateAiRecommendationCardStatus$1", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {BDVideoUploaderBase.KeyIsVideoMetaData}, m = "invokeSuspend", n = {}, s = {})
    static final class C10541 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ AiProactiveCardStatus $cardStatus;
        final /* synthetic */ long $recommendationId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        C10541(BaseProactiveFeedViewModel r3, long r4, AiProactiveCardStatus r6, Continuation<? super C10541> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$recommendationId = r4;
            this.$cardStatus = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            C10541 r11 = new C10541(this.this$0, this.$recommendationId, this.$cardStatus, r7);
            r11.L$0 = r9;
            return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10541) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10541.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
        L13:
            Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            BaseProactiveFeedViewModel r2 = this.this$0;
            long r3 = this.$recommendationId;
            Throwable r9 = Result.m1424exceptionOrNullimpl(r11);
            if (r9 == null) goto L21;
            RunLog.INSTANCE.error(r2.getLogTag(), "[BaseViewModel] updateAiRecommendationCardStatus failed id=" + r3, r9);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            al r12 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[BaseViewModel] updateAiRecommendationCardStatus id=" + this.$recommendationId + " cardStatus=" + this.$cardStatus, false, 4, null);
            BaseProactiveFeedViewModel r13 = this.this$0;
            long r4 = this.$recommendationId;
            AiProactiveCardStatus r5 = this.$cardStatus;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
            com.obric.aiproactive.ui.data.b r14 = r13.getRepository();     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            if (r14.a(r4, r5, this) != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$updateAiRecommendationFeedback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$updateAiRecommendationFeedback$1", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {498}, m = "invokeSuspend", n = {}, s = {})
    static final class C10551 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.aiproactive.api.u $request;
        final /* synthetic */ boolean $valueOnly;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        C10551(boolean r3, BaseProactiveFeedViewModel r4, com.obric.aiproactive.api.u r5, Continuation<? super C10551> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$valueOnly = r3;
            this.this$0 = r4;
            this.$request = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            C10551 r0 = new C10551(this.$valueOnly, this.this$0, this.$request, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10551) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10551.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L7
        L31:
            Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L35:
            if (Result.m1428isSuccessimpl(r12) == false) goto L37;
            Unit r2 = (Unit) ZeusTransformUtils.preCheckCast(r12, Unit.class, "com.obric.memorydata.plugin");
        L37:
            boolean r3 = this.$valueOnly;
            BaseProactiveFeedViewModel r4 = this.this$0;
            com.obric.aiproactive.api.u r10 = this.$request;
            Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
            if (r13 == null) goto L46;
            if (r3 == false) goto L41;
            String r5 = "[BaseViewModel] updateAiRecommendationFeedback failed valueOnly=true";
        L42:
            RunLog.INSTANCE.error(r4.getLogTag(), r5, r13);
            if (com.obric.aiproactive.ui.entry.c.a(r10) == false) goto L46;
            kotlinx.coroutines.flow.ad r14 = BaseProactiveFeedViewModel.access$get_uiEvent$p(r4);
            String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_feedback_failed, TypedValues.Custom.S_STRING, "proactive_feedback_failed"));
            Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
            r14.a(new b.c(r6));
            goto L46
        L41:
            r5 = "[BaseViewModel] updateAiRecommendationFeedback failed valueOnly=false";
        L46:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r11);
            al r15 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            if (this.$valueOnly == false) goto L15;
            IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            String r8 = this.this$0.getLogTag();
            boolean r9 = false;
            int r16 = 4;
            Object r17 = null;
            String r18 = "[BaseViewModel] updateAiRecommendationFeedback valueOnly=true";
        L14:
            IRunLog.a.a(r7, r8, r18, r9, r16, r17);
            BaseProactiveFeedViewModel r19 = this.this$0;
            com.obric.aiproactive.api.u r20 = this.$request;
            Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L7
            com.obric.aiproactive.ui.data.b r110 = r19.getRepository();     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r110.a(r20, this) != r0) goto L31;
            return r0;
        L15:
            r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r8 = this.this$0.getLogTag();
            StringBuilder r111 = new StringBuilder().append("[BaseViewModel] updateAiRecommendationFeedback valueOnly=false hasType=");
            boolean r22 = false;
            if (this.$request.b() == null) goto L18;
            boolean r23 = true;
        L19:
            StringBuilder r112 = r111.append(r23).append(" hasReason=");
            if (this.$request.c() == null) goto L22;
            boolean r24 = true;
        L23:
            StringBuilder r113 = r112.append(r24).append(" hasText=");
            if (this.$request.d() == null) goto L26;
            r22 = true;
        L26:
            r18 = r113.append(r22).toString();
            r9 = false;
            r16 = 4;
            r17 = null;
            goto L14
        L22:
            r24 = false;
            goto L23
        L18:
            r23 = false;
        L7:
            th = move-exception;
            Result.Companion r25 = Result.Companion;
            r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L35
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$updateInspiration$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel$updateInspiration$1", f = "BaseProactiveFeedViewModel.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
    static final class C10561 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProactiveInspirationDto $dto;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseProactiveFeedViewModel this$0;

        C10561(BaseProactiveFeedViewModel r3, ProactiveInspirationDto r4, Continuation<? super C10561> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$dto = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            C10561 r0 = new C10561(this.this$0, this.$dto, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10561) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10561.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
        L13:
            Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            BaseProactiveFeedViewModel r2 = this.this$0;
            ProactiveInspirationDto r9 = this.$dto;
            Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
            if (r12 == null) goto L21;
            RunLog.INSTANCE.error(r2.getLogTag(), "[BaseViewModel] updateInspiration failed recommendId=" + r9.getRecommendId(), r12);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            al r13 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[BaseViewModel] updateInspiration recommendId=" + this.$dto.getRecommendId() + " inspirationId=" + this.$dto.getInspirationId() + " status=" + this.$dto.getRecommendStatus() + " action=" + this.$dto.getFeedbackAction(), false, 4, null);
            BaseProactiveFeedViewModel r14 = this.this$0;
            ProactiveInspirationDto r3 = this.$dto;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
            com.obric.aiproactive.ui.data.b r15 = r14.getRepository();     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            if (r15.a(r3, this) != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L17
        }
    }

    static {
        Companion = new a(null);
        recommendationPatchBus = ak.a(0, 32, null, 4, null);
    }

    public BaseProactiveFeedViewModel(com.obric.aiproactive.ui.data.b r8, com.obric.aiproactive.ui.model.m r9, com.obric.aiproactive.ui.feedback.g r10) {
        com.obric.aiproactive.ui.data.b r11 = (com.obric.aiproactive.ui.data.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.aiproactive.ui.data.b.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.m r12 = (com.obric.aiproactive.ui.model.m) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.aiproactive.ui.model.m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "repository");
        Intrinsics.checkNotNullParameter(r12, "timeProvider");
        Intrinsics.checkNotNullParameter(r10, "statsStore");
        this.repository = r11;
        this.timeProvider = r12;
        this.statsStore = r10;
        kotlinx.coroutines.flow.ad<b> r13 = ak.a(0, 16, null, 4, null);
        this._uiEvent = r13;
        this.uiEvent = kotlinx.coroutines.flow.k.a(r13);
        kotlinx.coroutines.flow.ae<String> r14 = at.a(null);
        this._selectedInspirationId = r14;
        this.selectedInspirationId = kotlinx.coroutines.flow.k.a(r14);
        kotlinx.coroutines.flow.ae<List<ProactiveRecommendationDto>> r15 = at.a(CollectionsKt.emptyList());
        this._recommendationIndex = r15;
        this.instanceId = getClass().getName() + '@' + System.identityHashCode(this);
        this.aiProactiveActionCommandWriter = new d(this);
        ZoneId r0 = ZoneId.systemDefault();
        Intrinsics.checkNotNullExpressionValue(r0, "systemDefault(...)");
        this.zoneId = r0;
        this.selectedRecommendation = kotlinx.coroutines.flow.k.a(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r15, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r14, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new BaseProactiveFeedViewModel$selectedRecommendation$1(null), Function3.class, "com.obric.memorydata.plugin")), ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), an.a.a(an.f17422a, 5000, 0, 2, null), null);
    }

    public static /* synthetic */ boolean acceptStrictlyNewerBatch$default(BaseProactiveFeedViewModel r7, long r8, PageType r10, String r11, boolean r12, Function0 r13, int r14, Object r15) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L10;
        if ((r14 & 8) == 0) goto L8;
        r12 = false;
    L8:
        return r7.acceptStrictlyNewerBatch(r8, r10, r11, r12, r6);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: acceptStrictlyNewerBatch");
    }

    public static final /* synthetic */ void access$applyPatchLocally(BaseProactiveFeedViewModel r0, com.obric.aiproactive.ui.model.h r1) {
        r0.applyPatchLocally(r1);
    }

    public static final /* synthetic */ d access$getAiProactiveActionCommandWriter$p(BaseProactiveFeedViewModel r0) {
        return r0.aiProactiveActionCommandWriter;
    }

    public static final /* synthetic */ String access$getInstanceId$p(BaseProactiveFeedViewModel r0) {
        return r0.instanceId;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ad access$getRecommendationPatchBus$cp() {
        return recommendationPatchBus;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ad access$get_uiEvent$p(BaseProactiveFeedViewModel r0) {
        return r0._uiEvent;
    }

    private final void applyAndBroadcastPatch(com.obric.aiproactive.ui.model.h r19) {
        com.obric.aiproactive.ui.model.h r1 = com.obric.aiproactive.ui.model.h.a(r19, null, this.instanceId, null, false, null, false, null, false, null, false, null, false, null, null, 16381, null);
        applyPatchLocally(r1);
        recommendationPatchBus.a(r1);
    }

    private final void applyPatchLocally(final com.obric.aiproactive.ui.model.h r20) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r20.a(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] ignoreLocalPatch blankInspirationId type=" + getClass().getSimpleName(), null, 4, null);
        return;
    L6:
        com.obric.aiproactive.ui.model.i.f6729a.a(r20.a(), r20.c());
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        if (updateRecommendationInLocalState(r20.a(), new $$Lambda$BaseProactiveFeedViewModel$PYQZ17VWAmlA3X80An1oYHu9Y(r1, r20, r2)) == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] ignoreLocalPatch type=" + getClass().getSimpleName() + " batchId=" + this.currentBatchId + " inspirationId=" + r20.a() + " patchFlags={status=" + r20.c() + " actionIns=" + r20.d() + " feedback=" + r20.h() + " userFeedback=" + r20.j() + '}', false, 4, null);
        return;
    L9:
        if (com.obric.aiproactive.ui.entry.c.a(r20.c()) == false) goto L11;
        pinNowAdopted(r20.a());
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] applyLocalPatch type=" + getClass().getSimpleName() + " batchId=" + this.currentBatchId + " inspirationId=" + r20.a() + " status=" + r1.element + "->" + r2.element + " source=" + r20.b() + " patchFlags={status=" + r20.c() + " actionIns=" + r20.d() + " feedback=" + r20.h() + " userFeedback=" + r20.j() + '}', false, 4, null);
        rebuildPageItemsAfterLocalMutation();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Integer] */
    private static final ProactiveRecommendationDto applyPatchLocally$lambda$9(Ref.ObjectRef r1, com.obric.aiproactive.ui.model.h r2, Ref.ObjectRef r3, ProactiveRecommendationDto r4) {
        Intrinsics.checkNotNullParameter(r4, "dto");
        r1.element = Integer.valueOf(r4.getRecommendStatus());
        ProactiveRecommendationDto r5 = com.obric.aiproactive.ui.model.l.a(r4, r2);
        r3.element = Integer.valueOf(r5.getRecommendStatus());
        return r5;
    }

    private final String buildAiUserFeedback(String r12, String r13) {
        String[] r11 = new String[2];
        if (r12 != null) goto L5;
    L7:
        r12 = null;
    L8:
        r11[0] = r12;
        if (r13 != null) goto L11;
    L13:
        r13 = null;
    L14:
        r11[1] = r13;
        List r14 = CollectionsKt.listOfNotNull(r11);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L18;
        r14 = null;
    L18:
        if (r14 != null) goto L20;
        return null;
    L20:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        goto L7
    }

    private final void ensurePatchSubscription() {
        if (this.patchJob == null) goto L5;
        return;
    L5:
        this.patchJob = kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static /* synthetic */ Unit lambda$96L6UIRxvdUVi5VeVxlnSY7Yu1Q(ProactiveRecommendationDto r0) {
        return markAiRecommendationActionExecuted$lambda$6(r0);
    }

    public static /* synthetic */ Unit lambda$AOYcntpq_Cb6A6j26vesY3n4RDo(ProactiveRecommendationDto r0) {
        return markAiRecommendationCurrentActionExecuted$lambda$4(r0);
    }

    /* JADX INFO: renamed from: lambda$PYQZ17VW-AmlA3X80An-1oYHu9Y, reason: not valid java name */
    public static /* synthetic */ ProactiveRecommendationDto m267lambda$PYQZ17VWAmlA3X80An1oYHu9Y(Ref.ObjectRef r0, com.obric.aiproactive.ui.model.h r1, Ref.ObjectRef r2, ProactiveRecommendationDto r3) {
        return applyPatchLocally$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$jDoa5IevmL85JtDD1cjByIb5GrQ(BaseProactiveFeedViewModel r0, bx r1, Throwable r2) {
        return refresh$lambda$0(r0, r1, r2);
    }

    private final int mapAiCardStatusToRecommendStatus(AiProactiveCardStatus r2) {
        int r1 = c.f6582a[r2.ordinal()];
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L8;
        return 2;
    L8:
        if (r1 != 4) goto L11;
        return 2;
    L11:
        throw new NoWhenBranchMatchedException();
    L13:
        return 1;
    L14:
        return 2;
    }

    public static /* synthetic */ void markAiRecommendationActionExecuted$default(BaseProactiveFeedViewModel r2, ProactiveRecommendationDto r3, int r4, AiProactiveCardStatus r5, Function1 r6, int r7, Object r8) {
        Function1<? super ProactiveRecommendationDto, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L10;
        if ((r7 & 8) == 0) goto L7;
        r9 = $$Lambda$BaseProactiveFeedViewModel$96L6UIRxvdUVi5VeVxlnSY7Yu1Q.INSTANCE;
    L7:
        r2.markAiRecommendationActionExecuted(r3, r4, r5, r9);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markAiRecommendationActionExecuted");
    }

    private static final Unit markAiRecommendationActionExecuted$lambda$6(ProactiveRecommendationDto r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void markAiRecommendationCurrentActionExecuted$default(BaseProactiveFeedViewModel r2, ProactiveRecommendationDto r3, Function1 r4, int r5, Object r6) {
        Function1<? super ProactiveRecommendationDto, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r7 = $$Lambda$BaseProactiveFeedViewModel$AOYcntpq_Cb6A6j26vesY3n4RDo.INSTANCE;
    L7:
        r2.markAiRecommendationCurrentActionExecuted(r3, r7);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markAiRecommendationCurrentActionExecuted");
    }

    private static final Unit markAiRecommendationCurrentActionExecuted$lambda$4(ProactiveRecommendationDto r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void optimisticallyUpdateRecommendStatus$default(BaseProactiveFeedViewModel r0, String r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.optimisticallyUpdateRecommendStatus(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: optimisticallyUpdateRecommendStatus");
    }

    private static final Unit refresh$lambda$0(BaseProactiveFeedViewModel r9, bx r10, Throwable r11) {
        bx r12 = (bx) ZeusTransformUtils.wrapperContextForParams(r10, bx.class, "com.obric.memorydata.plugin");
        String r2 = null;
        if (r9.refreshJob != r12) goto L5;
        r9.refreshJob = null;
    L5:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r4 = r9.getLogTag();
        StringBuilder r13 = new StringBuilder().append("[BaseViewModel] refresh completed type=").append(r9.getClass().getSimpleName()).append(" cancelled=").append(r12.r_()).append(" throwable=");
        if (r11 == null) goto L10;
        Class<?> r14 = r11.getClass();
        if (r14 == null) goto L10;
        r2 = r14.getSimpleName();
    L10:
        IRunLog.a.a(r3, r4, r13.append(r2).toString(), false, 4, null);
        return Unit.INSTANCE;
    }

    public final boolean acceptBatch(long r14, PageType r16, String r17, Function0<Unit> r18) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "pageType");
        Intrinsics.checkNotNullParameter(r17, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r4, "onAccepted");
        if (r14 > 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] ignoreInvalidBatch listenerType=" + r16.getListenerType() + " batchId=" + r14 + " reason=" + r17, null, 4, null);
        return false;
    L6:
        long r10 = this.currentBatchId;
        if (r10 != r14) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] ignoreSameBatch " + r14, false, 4, null);
        return false;
    L10:
        this.currentBatchId = r14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] resetBatch listenerType=" + r16.getListenerType() + " oldBatchId=" + r10 + " newBatchId=" + r14 + " reason=" + r17 + " type=" + getClass().getSimpleName(), false, 4, null);
        r4.invoke();
        return true;
    }

    public final boolean acceptStrictlyNewerBatch(long r14, PageType r16, String r17, boolean r18, Function0<Unit> r19) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "pageType");
        Intrinsics.checkNotNullParameter(r17, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r4, "onAccepted");
        if (com.obric.aiproactive.ui.entry.c.a(this.currentBatchId, r14, r18) == false) goto L5;
        long r9 = this.currentBatchId;
        this.currentBatchId = r14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] resetBatch listenerType=" + r16.getListenerType() + " oldBatchId=" + r9 + " newBatchId=" + r14 + " reason=" + r17 + " strict=true type=" + getClass().getSimpleName(), false, 4, null);
        r4.invoke();
        return true;
    L5:
        if (r14 > 0) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] ignoreInvalidBatch listenerType=" + r16.getListenerType() + " batchId=" + r14 + " reason=" + r17 + " strict=true", null, 4, null);
        return false;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] ignoreOldOrSameBatch listenerType=" + r16.getListenerType() + " current=" + this.currentBatchId + " new=" + r14 + " reason=" + r17 + " strict=true", false, 4, null);
        return false;
    }

    public final long currentBatchId() {
        return this.currentBatchId;
    }

    public final LocalDate currentDate() {
        LocalDate r2 = Instant.ofEpochMilli(this.timeProvider.nowMillis()).atZone(this.zoneId).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r2, "toLocalDate(...)");
        return r2;
    }

    public final int getAllDayPageLimit() {
        return 50;
    }

    public final DateTimeFormatter getDayKeyFormatter() {
        return com.obric.aiproactive.ui.entry.c.a();
    }

    public final String getLogTag() {
        return "ProactiveUI";
    }

    public final int getNowPageLimit() {
        return 50;
    }

    public final com.obric.aiproactive.ui.data.b getRepository() {
        return this.repository;
    }

    public final ar<String> getSelectedInspirationId() {
        return this.selectedInspirationId;
    }

    public final ar<ProactiveRecommendationDto> getSelectedRecommendation() {
        return this.selectedRecommendation;
    }

    public final com.obric.aiproactive.ui.model.m getTimeProvider() {
        return this.timeProvider;
    }

    public final ai<b> getUiEvent() {
        return this.uiEvent;
    }

    public final ZoneId getZoneId() {
        return this.zoneId;
    }

    public final void handleObserverError(PageType r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r5, "pageType");
        Intrinsics.checkNotNullParameter(r6, "throwable");
        RunLog.INSTANCE.error(getLogTag(), "[BaseViewModel] observerFailed listenerType=" + r5.getListenerType() + " type=" + getClass().getSimpleName(), r6);
    }

    public final void markAiRecommendationActionExecuted(ProactiveRecommendationDto r15, int r16, AiProactiveCardStatus r17, Function1<? super ProactiveRecommendationDto, Unit> r18) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, NotificationCompat.CATEGORY_RECOMMENDATION);
        Intrinsics.checkNotNullParameter(r17, "cardStatus");
        Intrinsics.checkNotNullParameter(r3, "onCommandAccepted");
        com.obric.aiproactive.ui.model.b r1 = com.obric.aiproactive.ui.model.l.b(r15, r16, r17);
        if (r1 != null) goto L5;
        return;
    L5:
        com.obric.aiproactive.ui.model.h r0 = r1.d();
        if (r0 == null) goto L8;
        applyAndBroadcastPatch(r0);
    L8:
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r1, this, r3, r16, r17, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void markAiRecommendationCurrentActionExecuted(ProactiveRecommendationDto r9, Function1<? super ProactiveRecommendationDto, Unit> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_RECOMMENDATION);
        Intrinsics.checkNotNullParameter(r11, "onCommandAccepted");
        com.obric.aiproactive.ui.model.b r12 = com.obric.aiproactive.ui.model.l.d(r9);
        if (r12 != null) goto L5;
        return;
    L5:
        com.obric.aiproactive.ui.model.h r0 = r12.d();
        if (r0 == null) goto L8;
        applyAndBroadcastPatch(r0);
    L8:
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10513(r12, this, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void notifyVoteChanged(String r8) {
        Intrinsics.checkNotNullParameter(r8, "inspirationId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] notifyVoteChanged id=" + r8, false, 4, null);
        this._uiEvent.a(new b.d(r8));
    }

    public abstract Object observeFeed(Continuation<? super Unit> r1);

    public abstract void onBeforeRefresh();

    public void onRecommendationAdoptedFromDetail(String r1) {
        Intrinsics.checkNotNullParameter(r1, "inspirationId");
    }

    public void onRecommendationDismissedFromSync(String r1) {
        Intrinsics.checkNotNullParameter(r1, "recommendId");
    }

    public final void optimisticallyUpdateFeedbackAction(String r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "inspirationId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] optimisticallyUpdateFeedbackAction id=" + r19 + " action=" + r20 + " type=" + getClass().getSimpleName(), false, 4, null);
        applyAndBroadcastPatch(new com.obric.aiproactive.ui.model.h(r19, null, null, false, null, false, null, true, r20, false, null, false, null, null, 15998, null));
    }

    public final void optimisticallyUpdateRecommendStatus(String r20, int r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r20, "inspirationId");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this._recommendationIndex.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r5 = r3.next();
        if (Intrinsics.areEqual(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getInspirationId(), r20) == false) goto L4;
    L9:
        ProactiveRecommendationDto r4 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] optimisticallyUpdateRecommendStatus id=" + r20 + " old=" + r4.getRecommendStatus() + " new=" + r21 + " isIgnored=" + r22 + " type=" + getClass().getSimpleName(), false, 4, null);
        if (r21 != 2) goto L15;
        if (r22 == true) goto L15;
        this.statsStore.a(r20, this.timeProvider.nowMillis());
    L15:
        applyAndBroadcastPatch(new com.obric.aiproactive.ui.model.h(r20, null, Integer.valueOf(r21), false, null, false, null, false, null, false, null, false, null, null, 16378, null));
        return;
    L20:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public void pinNowAdopted(String r1) {
        Intrinsics.checkNotNullParameter(r1, "inspirationId");
    }

    public final void publishRecommendationIndex(List<ProactiveRecommendationDto> r3) {
        List<ProactiveRecommendationDto> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, Constants.KEY_LIST);
        this._recommendationIndex.b(r4);
    }

    public abstract void rebuildPageItemsAfterLocalMutation();

    public final void refresh() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] refresh type=" + getClass().getSimpleName(), false, 4, null);
        bx r0 = this.refreshJob;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        onBeforeRefresh();
        final bx r1 = kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new BaseProactiveFeedViewModel$refresh$job$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        this.refreshJob = r1;
        r1.a(new $$Lambda$BaseProactiveFeedViewModel$jDoa5IevmL85JtDD1cjByIb5GrQ(this, r1));
    }

    public final void requestCopyDebugLogId(String r9) {
        Intrinsics.checkNotNullParameter(r9, "recommendId");
        if (AppContext.INSTANCE.isDebug() == true) goto L5;
        return;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] requestCopyDebugLogId id=" + r9, false, 4, null);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10521(this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    }

    public final void requestEditActionExecuteInstruction(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "inspirationId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r2 = getLogTag();
        StringBuilder r0 = new StringBuilder().append("[BaseViewModel] requestEditActionExecuteInstruction inspirationId=").append(r8).append(" currentLen=");
        if (r9 == null) goto L8;
        int r3 = r9.length();
    L9:
        IRunLog.a.a(r1, r2, r0.append(r3).toString(), false, 4, null);
        this._uiEvent.a(new b.C0299b(r8, r9));
        return;
    L8:
        r3 = 0;
        goto L9
    }

    public final void selectInspiration(String r10) {
        kotlinx.coroutines.flow.ae<String> r0 = this._selectedInspirationId;
        String r1 = null;
        if (r10 == null) goto L5;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if ((!r4) == false) goto L16;
        r1 = r11;
    L16:
        r0.b(r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] selectInspiration id=" + ((String) ZeusTransformUtils.preCheckCast(this._selectedInspirationId.c(), String.class, "com.obric.memorydata.plugin")) + " type=" + getClass().getSimpleName(), false, 4, null);
        return;
    L9:
        if (StringsKt.isBlank(r3) == true) goto L12;
        r4 = false;
        goto L14
    L5:
        r11 = null;
        goto L6
    }

    public final void startIfNeeded() {
        ensurePatchSubscription();
        bx r0 = this.refreshJob;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        RunLog.INSTANCE.debug(getLogTag(), "[BaseViewModel] startIfNeeded ignored type=" + getClass().getSimpleName() + " running=true");
        return;
    L11:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r4 = getLogTag();
        StringBuilder r5 = new StringBuilder().append("[BaseViewModel] startIfNeeded type=").append(getClass().getSimpleName()).append(" running=false hadJob=");
        if (this.refreshJob != null) goto L15;
        r1 = false;
    L15:
        IRunLog.a.a(r3, r4, r5.append(r1).toString(), false, 4, null);
        refresh();
        return;
    L5:
        if (r0.a() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final String string(int r3) {
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        return r2;
    }

    public final void submitAiDirectFeedback(com.obric.aiproactive.api.o r9) {
        Intrinsics.checkNotNullParameter(r9, Ext.KEY_REQUEST);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10531(this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void tryEmitUiEvent(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this._uiEvent.a(r2);
    }

    public final void updateActionExecuteInstruction(String r28, String r29) {
        Intrinsics.checkNotNullParameter(r28, "inspirationId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        Long r3 = null;
        if (r29 == null) goto L8;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L9:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r7 = 0;
        if (r5 != null) goto L12;
    L15:
        boolean r6 = true;
    L17:
        if ((!r6) == true) goto L20;
        r4 = null;
    L20:
        ProactiveRecommendationDto r15 = com.obric.aiproactive.ui.entry.c.a(r28, (List) ZeusTransformUtils.preCheckCast(this._recommendationIndex.c(), List.class, "com.obric.memorydata.plugin"));
        if (r15 != null) goto L23;
        return;
    L23:
        String r14 = r15.getRecommendId();
        if (Intrinsics.areEqual(r15.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == false) goto L29;
        Long r8 = StringsKt.toLongOrNull(r14);
        if (r8 == null) goto L28;
        r3 = Long.valueOf(r8.longValue());
        goto L29
    L28:
        return;
    L29:
        Long r20 = r3;
        IRunLog r21 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r22 = getLogTag();
        StringBuilder r9 = new StringBuilder().append("[BaseViewModel] updateActionExecuteInstruction inspirationId=").append(r28).append(" recommendId=").append(r14).append(" rawLen=");
        if (r29 == null) goto L32;
        int r1 = r29.length();
    L33:
        StringBuilder r2 = r9.append(r1).append(" normalizedLen=");
        if (r4 == null) goto L36;
        r7 = r4.length();
    L36:
        IRunLog.a.a(r21, r22, r2.append(r7).toString(), false, 4, null);
        if (Intrinsics.areEqual(r15.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == false) goto L39;
        com.obric.aiproactive.ui.model.h r10 = com.obric.aiproactive.ui.model.l.a(r15, r4);
        String r23 = r4;
    L40:
        if (r10 == null) goto L42;
        applyAndBroadcastPatch(r10);
    L42:
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, r8)), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r15, this, r20, r23, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L39:
        r23 = r4;
        r10 = new com.obric.aiproactive.ui.model.h(r28, null, null, true, r23, false, null, false, null, false, null, false, null, null, 16358, null);
        goto L40
    L32:
        r1 = 0;
        goto L33
    L12:
        if (StringsKt.isBlank(r5) == true) goto L15;
        r6 = false;
        goto L17
    L8:
        r4 = null;
        goto L9
    }

    public final void updateAiRecommendationCardStatus(long r23, AiProactiveCardStatus r25) {
        Intrinsics.checkNotNullParameter(r25, "cardStatus");
        if (r23 > 0) goto L5;
        return;
    L5:
        String r6 = String.valueOf(r23);
        Integer r8 = Integer.valueOf(mapAiCardStatusToRecommendStatus(r25));
        int r2 = c.f6582a[r25.ordinal()];
        if (r2 != 1) goto L8;
        String r3 = "ignore";
    L18:
        applyAndBroadcastPatch(new com.obric.aiproactive.ui.model.h(r6, null, r8, false, null, false, null, true, r3, false, null, false, null, null, 15994, null));
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10541(this, r23, r25, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L8:
        if (r2 != 2) goto L10;
    L16:
        r3 = null;
        goto L18
    L10:
        if (r2 == 3) goto L16;
        if (r2 == 4) goto L16;
        throw new NoWhenBranchMatchedException();
    }

    public final void updateAiRecommendationFeedback(com.obric.aiproactive.api.u r24) {
        Intrinsics.checkNotNullParameter(r24, Ext.KEY_REQUEST);
        if (r24.a() > 0) goto L5;
        return;
    L5:
        AiProactiveRecommendationFeedbackClassification r2 = r24.h();
        if (com.obric.aiproactive.ui.entry.c.c(r24) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[BaseViewModel] dropRecommendationFeedback outOfRange=true", null, 4, null);
        return;
    L10:
        if (r2 != AiProactiveRecommendationFeedbackClassification.VALID_VALUE_ONLY) goto L12;
        boolean r3 = true;
    L14:
        if (com.obric.aiproactive.ui.entry.c.b(r24) == false) goto L16;
        String r17 = buildAiUserFeedback(r24.c(), r24.d());
        applyAndBroadcastPatch(new com.obric.aiproactive.ui.model.h(String.valueOf(r24.a()), null, null, false, null, false, null, true, r24.b(), true, r17, true, r24.c(), r24.d(), WebSocketProtocol.PAYLOAD_SHORT, null));
    L16:
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10551(r3, this, r24, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L12:
        r3 = false;
        goto L14
    }

    public final void updateInspiration(ProactiveInspirationDto r23) {
        Intrinsics.checkNotNullParameter(r23, "dto");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r23.getInspirationId(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
        applyAndBroadcastPatch(new com.obric.aiproactive.ui.model.h(r23.getInspirationId(), null, Integer.valueOf(r23.getRecommendStatus()), false, null, false, null, true, r23.getFeedbackAction(), true, r23.getUserFeedback(), false, null, null, 14458, null));
    L5:
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10561(this, r23, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public abstract boolean updateRecommendationInLocalState(String r1, Function1<? super ProactiveRecommendationDto, ProactiveRecommendationDto> r2);
}
