package com.obric.aiproactive.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.GravityCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.ProactiveInspirationDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.u;
import com.obric.aiproactive.api.x;
import com.obric.aiproactive.api.y;
import com.obric.aiproactive.api.z;
import com.obric.aiproactive.ui.databinding.ActivityRecommendationDetailBinding;
import com.obric.aiproactive.ui.entry.AllFeedViewModel;
import com.obric.aiproactive.ui.entry.BaseProactiveActivity;
import com.obric.aiproactive.ui.entry.BaseProactiveFeedViewModel;
import com.obric.aiproactive.ui.entry.NowFeedViewModel;
import com.obric.aiproactive.ui.entry.ProactiveFeedPageViewModelFactory;
import com.obric.aiproactive.ui.feedback.ProactiveFeedbackSheet;
import com.obric.aiproactive.ui.feedback.ProactiveValueAmountSource;
import com.obric.aiproactive.ui.feedback.ProactiveValueQuickSelection;
import com.obric.aiproactive.ui.feedback.ProactiveValueSubmissionTrigger;
import com.obric.aiproactive.ui.feedback.ProactiveValueSubmitType;
import com.obric.aiproactive.ui.feedback.ProactiveVoteStore;
import com.obric.aiproactive.ui.feedback.f;
import com.obric.aiproactive.ui.feedback.n;
import com.obric.aiproactive.ui.feedback.p;
import com.obric.aiproactive.ui.model.l;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.aiproactive.ui.util.g;
import com.obric.aiproactive.ui.util.h;
import com.obric.aiproactive.ui.util.j;
import com.obric.aiproactive.ui.util.o;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ~2\u00020\u0001:\u0001~B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010B\u001a\u00020\u0010H\u0014J\b\u0010C\u001a\u00020\u0010H\u0014J\u0012\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\b\u0010H\u001a\u00020EH\u0016J\b\u0010I\u001a\u00020EH\u0002J\u0010\u0010J\u001a\u00020E2\u0006\u0010\b\u001a\u00020\tH\u0002J\n\u0010K\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010L\u001a\u00020EH\u0002J\u0018\u0010M\u001a\u00020E2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000bH\u0002J\b\u0010O\u001a\u00020EH\u0002J\u0010\u0010P\u001a\u00020E2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u00020\rH\u0002J\u0018\u0010S\u001a\u00020E2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020UH\u0002J$\u0010V\u001a\u00020E2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000b2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u001f\u0010W\u001a\u00020E2\u0006\u0010\b\u001a\u00020\t2\b\u0010X\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010YJ\u0018\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\u0018\u0010]\u001a\u00020E2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000bH\u0002J\u0018\u0010^\u001a\u00020E2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000bH\u0002J\b\u0010_\u001a\u00020EH\u0002J\u0014\u0010`\u001a\u00020E2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010b\u001a\u00020E2\u0006\u0010c\u001a\u00020dH\u0002J\u0018\u0010e\u001a\u00020E2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000bH\u0002J\u0018\u0010f\u001a\u00020E2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000bH\u0002J \u0010g\u001a\u00020E2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010j\u001a\u00020E2\u0006\u0010k\u001a\u00020lH\u0002J \u0010m\u001a\u00020E2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\r2\u0006\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020EH\u0002J\u0018\u0010r\u001a\u00020E2\u0006\u0010n\u001a\u00020\r2\u0006\u0010s\u001a\u00020\u001eH\u0002J\u0010\u0010t\u001a\u00020\r2\u0006\u0010u\u001a\u00020\rH\u0002J\u0010\u0010v\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u000bH\u0002J\"\u0010w\u001a\u00020E2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020\u001e2\b\u0010x\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010y\u001a\u00020\u001e2\u0006\u0010z\u001a\u00020{H\u0002J\u0010\u0010|\u001a\u00020E2\u0006\u0010N\u001a\u00020\u000bH\u0002J\b\u0010}\u001a\u00020EH\u0014R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010$\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010$\u001a\u0004\b5\u00106R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010$\u001a\u0004\b:\u0010;R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010$\u001a\u0004\b?\u0010@¨\u0006\u007f"}, d2 = {"Lcom/obric/aiproactive/ui/detail/RecommendationDetailActivity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "<init>", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/obric/aiproactive/ui/databinding/ActivityRecommendationDetailBinding;", "currentDto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "currentRank", "", "Ljava/lang/Integer;", "suppressValueRatingTabCallback", "", "likeButton", "Lcom/obric/oui/button/OIconButton;", "dislikeButton", "scrollIdleRunnable", "Ljava/lang/Runnable;", "userScrollInProgress", "userScrollObserved", "executor", "Lcom/obric/aiproactive/ui/task/ProactiveTaskExecutor;", "voteStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;", "continueSubmissionsInFlight", "", "", "repository", "Lcom/obric/aiproactive/ui/data/DefaultProactiveRepository;", "getRepository", "()Lcom/obric/aiproactive/ui/data/DefaultProactiveRepository;", "repository$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Lcom/obric/aiproactive/ui/entry/ProactiveFeedPageViewModelFactory;", "getViewModelFactory", "()Lcom/obric/aiproactive/ui/entry/ProactiveFeedPageViewModelFactory;", "viewModelFactory$delegate", "sourcePage", "getSourcePage", "()Ljava/lang/String;", "sourcePage$delegate", "viewModel", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "getViewModel", "()Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "viewModel$delegate", "feedbackSheet", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackSheet;", "getFeedbackSheet", "()Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackSheet;", "feedbackSheet$delegate", "valueRatingStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingStore;", "getValueRatingStore", "()Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingStore;", "valueRatingStore$delegate", "valueRatingSheet", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingSheet;", "getValueRatingSheet", "()Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingSheet;", "valueRatingSheet$delegate", "needLoginCheckOnCreate", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "bindBackNavigation", "bindScrollTracking", "recommendationExtra", "reportDetailBackClick", "bindDto", "dto", "showValueRatingSheet", "bindValueRatingActions", "saveQuickValueRating", "amount", "reportValueRating", "rating", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRating;", "bindValueRating", "renderValueQuickTabs", "selectedIndex", "(Lcom/obric/aiproactive/ui/databinding/ActivityRecommendationDetailBinding;Ljava/lang/Integer;)V", "bindActionResult", AILabCheckPermissionTask.KEY_SOURCE, "updated", "bindBadge", "bindPrimaryAction", "handlePrimaryAction", "handleExecute", "overrideQuery", "handleVote", "vote", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore$Vote;", "bindVote", "bindSources", "bindExecuteInstruction", "uiState", "Lcom/obric/aiproactive/ui/detail/RecommendationDetailUiState;", "handleInlineAction", "actionItem", "Lcom/obric/aiproactive/ui/detail/RecommendationActionItemUiState;", "submitContinueAction", "actionIndex", "action", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "reportInlineActionClick", "handleExecuteActionAt", ChatMessage.TYPE_QUERY, "dp", EventBody.KEY_VALUE, "mapRecommendStatus", "report", "userFeedback", "buildUserFeedback", "result", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackResult;", "updateRecommendStatusToAdopted", "onDestroy", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommendationDetailActivity extends BaseProactiveActivity {
    public static final a Companion = null;
    private static final String EXTRA_ENTER_FROM = "enter_from";
    private static final String EXTRA_INSPIRATION_ID = "inspiration_id";
    private static final String EXTRA_RANK = "rank";
    private static final String EXTRA_RECOMMENDATION = "recommendation";
    private static final String EXTRA_SOURCE_PAGE = "source_page";
    private static final int NO_RANK = Integer.MIN_VALUE;
    private static final long PAGE_SCROLL_IDLE_DELAY_MS = 200;
    private static final int[] QUICK_VALUE_AMOUNTS = null;
    private static final int[] QUICK_VALUE_LABELS = null;
    private static final String TAG = "ProactiveUI";
    private ActivityRecommendationDetailBinding binding;
    private final Set<String> continueSubmissionsInFlight;
    private ProactiveRecommendationDto currentDto;
    private Integer currentRank;
    private OIconButton dislikeButton;
    private final com.obric.aiproactive.ui.task.a executor;
    private final Lazy feedbackSheet$delegate;
    private OIconButton likeButton;
    private final Lazy repository$delegate;
    private Runnable scrollIdleRunnable;
    private final Lazy sourcePage$delegate;
    private boolean suppressValueRatingTabCallback;
    private boolean userScrollInProgress;
    private boolean userScrollObserved;
    private final Lazy valueRatingSheet$delegate;
    private final Lazy valueRatingStore$delegate;
    private final Lazy viewModel$delegate;
    private final Lazy viewModelFactory$delegate;
    private final ProactiveVoteStore voteStore;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/ui/detail/RecommendationDetailActivity$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SCROLL_IDLE_DELAY_MS", "", "QUICK_VALUE_AMOUNTS", "", "QUICK_VALUE_LABELS", "EXTRA_RECOMMENDATION", "EXTRA_INSPIRATION_ID", "EXTRA_ENTER_FROM", "EXTRA_SOURCE_PAGE", "EXTRA_RANK", "NO_RANK", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "inspirationId", "recommendation", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "enterFrom", "sourcePage", RecommendationDetailActivity.EXTRA_RANK, "(Landroid/content/Context;Ljava/lang/String;Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroid/content/Intent;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Intent a(Context r3, String r4, ProactiveRecommendationDto r5, String r6, String r7, Integer r8) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "inspirationId");
            Intrinsics.checkNotNullParameter(r6, "enterFrom");
            Intrinsics.checkNotNullParameter(r7, "sourcePage");
            Intent r9 = new Intent(r2, RecommendationDetailActivity.class);
            r9.putExtra(RecommendationDetailActivity.EXTRA_INSPIRATION_ID, r4);
            r9.putExtra("recommendation", (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.memorydata.plugin"));
            r9.putExtra(RecommendationDetailActivity.EXTRA_ENTER_FROM, r6);
            r9.putExtra(RecommendationDetailActivity.EXTRA_SOURCE_PAGE, r7);
            if (r8 == null) goto L5;
            int r10 = r8.intValue();
        L6:
            r9.putExtra(RecommendationDetailActivity.EXTRA_RANK, r10);
            return r9;
        L5:
            r10 = Integer.MIN_VALUE;
            goto L6
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6558a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6559b = null;

        static {
            int[] r0 = new int[ProactiveValueQuickSelection.values().length];
            r0[ProactiveValueQuickSelection.ZERO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[ProactiveValueQuickSelection.ONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L41:
            r0[ProactiveValueQuickSelection.FIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L31:
            r0[ProactiveValueQuickSelection.TEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[ProactiveValueQuickSelection.TWENTY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L25:
            r0[ProactiveValueQuickSelection.OTHER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L35:
            r0[ProactiveValueQuickSelection.NONE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L11:
            f6558a = r0;
            int[] r1 = new int[ProactiveVoteStore.Vote.values().length];
            r1[ProactiveVoteStore.Vote.LIKE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L27:
            r1[ProactiveVoteStore.Vote.DISLIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L14:
            f6559b = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/ui/detail/RecommendationDetailActivity$bindValueRatingActions$1", "Lcom/obric/oui/tab/OTabLayoutBase$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "onTabUnselected", "onTabReselected", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements OTabLayoutBase.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecommendationDetailActivity f6560a;

        c(RecommendationDetailActivity r3) {
            this.f6560a = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void a(OTabLayoutBase.g r2) {
            if (RecommendationDetailActivity.access$getSuppressValueRatingTabCallback$p(this.f6560a) == false) goto L5;
            return;
        L5:
            int[] r0 = RecommendationDetailActivity.access$getQUICK_VALUE_AMOUNTS$cp();
            if (r2 == null) goto L8;
            int r3 = r2.c();
        L9:
            Integer r4 = ArraysKt.getOrNull(r0, r3);
            if (r4 == null) goto L13;
            int r5 = r4.intValue();
            RecommendationDetailActivity.access$saveQuickValueRating(this.f6560a, r5);
            return;
        L13:
            return;
        L8:
            r3 = -1;
            goto L9
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void b(OTabLayoutBase.g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void c(OTabLayoutBase.g r1) {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.detail.RecommendationDetailActivity$handleExecute$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.detail.RecommendationDetailActivity$handleExecute$1", f = "RecommendationDetailActivity.kt", i = {}, l = {600, 613}, m = "invokeSuspend", n = {}, s = {})
    static final class C10471 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProactiveRecommendationDto $dto;
        final /* synthetic */ String $targetQuery;
        int label;
        final /* synthetic */ RecommendationDetailActivity this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.detail.RecommendationDetailActivity$handleExecute$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.detail.RecommendationDetailActivity$handleExecute$1$2", f = "RecommendationDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RecommendationDetailActivity this$0;

            AnonymousClass2(RecommendationDetailActivity r3, Continuation<? super AnonymousClass2> r4) {
                RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r5);
                Toast.makeText((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RecommendationDetailActivity.access$getActivity(this.this$0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RecommendationDetailActivity.access$getActivity(this.this$0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_execute_failed, TypedValues.Custom.S_STRING, "proactive_execute_failed")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C10471(ProactiveRecommendationDto r3, String r4, RecommendationDetailActivity r5, Continuation<? super C10471> r6) {
            RecommendationDetailActivity r7 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r5, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$dto = r3;
            this.$targetQuery = r4;
            this.this$0 = r7;
            super(2, r8);
        }

        private static final Unit invokeSuspend$lambda$0(RecommendationDetailActivity r2, ProactiveRecommendationDto r3, ProactiveRecommendationDto r4) {
            RecommendationDetailActivity.access$bindActionResult((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin"), r3, r4);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: lambda$bgYuQd-gwOGwd3kNhyvRKkOFNic, reason: not valid java name */
        public static /* synthetic */ Unit m257lambda$bgYuQdgwOGwd3kNhyvRKkOFNic(RecommendationDetailActivity r0, ProactiveRecommendationDto r1, ProactiveRecommendationDto r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10471(this.$dto, this.$targetQuery, this.this$0, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10471) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10471.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
        L34:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
        L24:
            boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RecommendationDetailActivity.TAG, "[DetailPage] handleExecute result id=" + this.$dto.getRecommendId() + " ok=" + r13, false, 4, null);
            if (r13 == true) goto L27;
            CoroutineContext r14 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (i.a(r14, r2, r3) != r0) goto L34;
            return r0;
        L27:
            if (com.obric.aiproactive.ui.detail.b.c(this.$dto) == false) goto L29;
            BaseProactiveFeedViewModel r15 = RecommendationDetailActivity.access$getViewModel(this.this$0);
            final ProactiveRecommendationDto r4 = this.$dto;
            final RecommendationDetailActivity r11 = this.this$0;
            r15.markAiRecommendationCurrentActionExecuted(r4, new $$Lambda$RecommendationDetailActivity$handleExecute$1$bgYuQdgwOGwd3kNhyvRKkOFNic(r11, r4));
            goto L34
        L29:
            RecommendationDetailActivity.access$getViewModel(this.this$0).onRecommendationAdoptedFromDetail(this.$dto.getInspirationId());
            BaseProactiveFeedViewModel.optimisticallyUpdateRecommendStatus$default(RecommendationDetailActivity.access$getViewModel(this.this$0), this.$dto.getInspirationId(), 2, false, 4, null);
            RecommendationDetailActivity.access$updateRecommendStatusToAdopted(this.this$0, this.$dto);
            goto L34
        L10:
            ResultKt.throwOnFailure(r12);
            if (com.obric.aiproactive.ui.detail.b.c(this.$dto) == false) goto L21;
            CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(this.$targetQuery, CharSequence.class, "com.obric.memorydata.plugin");
            if (r16 != null) goto L15;
        L18:
            boolean r17 = true;
        L19:
            if (r17 == true) goto L21;
            RecommendationDetailActivity.access$getViewModel(this.this$0).updateActionExecuteInstruction(this.$dto.getInspirationId(), this.$targetQuery);
            goto L21
        L15:
            if (StringsKt.isBlank(r16) == true) goto L18;
            r17 = false;
        L21:
            com.obric.aiproactive.ui.task.a r18 = RecommendationDetailActivity.access$getExecutor$p(this.this$0);
            Context r5 = (Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RecommendationDetailActivity.access$getActivity(this.this$0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            ProactiveRecommendationDto r6 = this.$dto;
            String r7 = this.$targetQuery;
            Continuation<? super Boolean> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r12 = r18.a(r5, r6, r7, r8);
            if (r12 != r0) goto L24;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.detail.RecommendationDetailActivity$handleExecuteActionAt$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.detail.RecommendationDetailActivity$handleExecuteActionAt$1", f = "RecommendationDetailActivity.kt", i = {}, l = {979, 989}, m = "invokeSuspend", n = {}, s = {})
    static final class C10481 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $actionIndex;
        final /* synthetic */ ProactiveRecommendationDto $dto;
        final /* synthetic */ String $targetQuery;
        int label;
        final /* synthetic */ RecommendationDetailActivity this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.detail.RecommendationDetailActivity$handleExecuteActionAt$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.detail.RecommendationDetailActivity$handleExecuteActionAt$1$2", f = "RecommendationDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RecommendationDetailActivity this$0;

            AnonymousClass2(RecommendationDetailActivity r3, Continuation<? super AnonymousClass2> r4) {
                RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r5);
                Toast.makeText((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RecommendationDetailActivity.access$getActivity(this.this$0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RecommendationDetailActivity.access$getActivity(this.this$0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_execute_failed, TypedValues.Custom.S_STRING, "proactive_execute_failed")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C10481(RecommendationDetailActivity r3, ProactiveRecommendationDto r4, String r5, int r6, Continuation<? super C10481> r7) {
            RecommendationDetailActivity r8 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r8;
            this.$dto = r4;
            this.$targetQuery = r5;
            this.$actionIndex = r6;
            super(2, r9);
        }

        private static final Unit invokeSuspend$lambda$0(RecommendationDetailActivity r2, ProactiveRecommendationDto r3, ProactiveRecommendationDto r4) {
            RecommendationDetailActivity.access$bindActionResult((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin"), r3, r4);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: lambda$DrlIDMUZ-ut_TMnPvKQdjvI2K8U, reason: not valid java name */
        public static /* synthetic */ Unit m258lambda$DrlIDMUZut_TMnPvKQdjvI2K8U(RecommendationDetailActivity r0, ProactiveRecommendationDto r1, ProactiveRecommendationDto r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10481(this.this$0, this.$dto, this.$targetQuery, this.$actionIndex, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10481) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10481.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
        L13:
            boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RecommendationDetailActivity.TAG, "[DetailPage] handleExecuteActionAt result id=" + this.$dto.getRecommendId() + " ok=" + r13, false, 4, null);
            if (r13 == false) goto L16;
            RecommendationDetailActivity.access$getViewModel(this.this$0).onRecommendationAdoptedFromDetail(this.$dto.getInspirationId());
            BaseProactiveFeedViewModel r14 = RecommendationDetailActivity.access$getViewModel(this.this$0);
            ProactiveRecommendationDto r2 = this.$dto;
            int r3 = this.$actionIndex;
            AiProactiveCardStatus r4 = AiProactiveCardStatus.EXECUTED;
            final RecommendationDetailActivity r5 = this.this$0;
            final ProactiveRecommendationDto r11 = this.$dto;
            r14.markAiRecommendationActionExecuted(r2, r3, r4, new $$Lambda$RecommendationDetailActivity$handleExecuteActionAt$1$DrlIDMUZut_TMnPvKQdjvI2K8U(r5, r11));
            goto L20
        L16:
            CoroutineContext r15 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (i.a(r15, r6, r7) != r0) goto L20;
            return r0;
        L10:
            ResultKt.throwOnFailure(r12);
            com.obric.aiproactive.ui.task.a r16 = RecommendationDetailActivity.access$getExecutor$p(this.this$0);
            Context r8 = (Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RecommendationDetailActivity.access$getActivity(this.this$0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            ProactiveRecommendationDto r9 = this.$dto;
            String r10 = this.$targetQuery;
            Continuation<? super Boolean> r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r12 = r16.a(r8, r9, r10, r17);
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.detail.RecommendationDetailActivity$onCreateChecked$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.detail.RecommendationDetailActivity$onCreateChecked$5", f = "RecommendationDetailActivity.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RecommendationDetailActivity this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.detail.RecommendationDetailActivity$onCreateChecked$5$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.detail.RecommendationDetailActivity$onCreateChecked$5$1", f = "RecommendationDetailActivity.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RecommendationDetailActivity this$0;

            /* JADX INFO: renamed from: com.obric.aiproactive.ui.detail.RecommendationDetailActivity$onCreateChecked$5$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "dto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.aiproactive.ui.detail.RecommendationDetailActivity$onCreateChecked$5$1$1", f = "RecommendationDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C02931 extends SuspendLambda implements Function2<ProactiveRecommendationDto, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ RecommendationDetailActivity this$0;

                C02931(RecommendationDetailActivity r3, Continuation<? super C02931> r4) {
                    RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r5;
                    super(2, r6);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    C02931 r0 = new C02931(this.this$0, r5);
                    r0.L$0 = r3;
                    return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(ProactiveRecommendationDto r3, Continuation<? super Unit> r4) {
                    return ((C02931) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C02931.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(ProactiveRecommendationDto r3, Continuation<? super Unit> r4) {
                    return invoke2((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r3, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r8) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L14;
                    ResultKt.throwOnFailure(r8);
                    ProactiveRecommendationDto r9 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(this.L$0, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
                    if (r9 == null) goto L7;
                    RecommendationDetailActivity.access$setCurrentDto$p(this.this$0, r9);
                    IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RecommendationDetailActivity.TAG, "[DetailPage] selectedRecommendation id=" + r9.getRecommendId() + " status=" + r9.getRecommendStatus() + " hasInstruction=" + d.g(r9), false, 4, null);
                    ActivityRecommendationDetailBinding r0 = RecommendationDetailActivity.access$getBinding$p(this.this$0);
                    if (r0 == null) goto L12;
                    RecommendationDetailActivity.access$bindDto(this.this$0, r0, r9);
                L12:
                    return Unit.INSTANCE;
                L7:
                    return Unit.INSTANCE;
                L14:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(RecommendationDetailActivity r3, Continuation<? super AnonymousClass1> r4) {
                RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
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
            public final Object invokeSuspend(Object r7) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r7);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r7);
                kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(RecommendationDetailActivity.access$getViewModel(this.this$0).getSelectedRecommendation(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C02931(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
                Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (k.a(r8, r2, r3) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass5(RecommendationDetailActivity r3, Continuation<? super AnonymousClass5> r4) {
            RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(this.this$0, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r9, r2, r4, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.detail.RecommendationDetailActivity$submitContinueAction$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.detail.RecommendationDetailActivity$submitContinueAction$1", f = "RecommendationDetailActivity.kt", i = {0, 1, 1, 1, 2}, l = {892, 901, TypedValues.Custom.TYPE_DIMENSION}, m = "invokeSuspend", n = {"accepted", Ext.KEY_REQUEST, "recommendationId", "accepted", "accepted"}, s = {"I$0", "L$0", "L$1", "I$0", "I$0"})
    static final class C10491 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.aiproactive.api.b $action;
        final /* synthetic */ int $actionIndex;
        final /* synthetic */ ProactiveRecommendationDto $dto;
        final /* synthetic */ String $recommendationKey;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RecommendationDetailActivity this$0;

        C10491(RecommendationDetailActivity r3, String r4, com.obric.aiproactive.api.b r5, int r6, ProactiveRecommendationDto r7, Continuation<? super C10491> r8) {
            RecommendationDetailActivity r9 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r9;
            this.$recommendationKey = r4;
            this.$action = r5;
            this.$actionIndex = r6;
            this.$dto = r7;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10491(this.this$0, this.$recommendationKey, this.$action, this.$actionIndex, this.$dto, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10491) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10491.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            int r2 = 0;
            int r5 = 1;
            if (r1 == 0) goto L28;
            if (r1 == 1) goto L21;
            if (r1 == 2) goto L18;
            if (r1 != 3) goto L17;
            r5 = this.I$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
        L98:
        L54:
            r1 = r5;
        L60:
            if (r1 != 0) goto L68;
        L61:
            RecommendationDetailActivity.access$getContinueSubmissionsInFlight$p(this.this$0).remove(this.$recommendationKey);
        L68:
            if (this.this$0.isFinishing() == true) goto L87;
            if (this.this$0.isDestroyed() == true) goto L87;
            if (r1 != 0) goto L100;
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RecommendationDetailActivity.access$getActivity(this.this$0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RecommendationDetailActivity.access$getActivity(this.this$0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_user_requirement_failure, TypedValues.Custom.S_STRING, "ai_proactive_user_requirement_failure")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        L85:
            return Unit.INSTANCE;
        L100:
            RecommendationDetailActivity.access$getViewModel(this.this$0).onRecommendationAdoptedFromDetail(this.$dto.getInspirationId());     // Catch: RuntimeException -> L79 CancellationException -> L81
            com.obric.aiproactive.ui.model.b r16 = l.b(this.$dto, this.$actionIndex, AiProactiveCardStatus.ACKNOWLEDGED);     // Catch: RuntimeException -> L79 CancellationException -> L81
            if (r16 == null) goto L85;
            ProactiveRecommendationDto r17 = r16.e();     // Catch: RuntimeException -> L79 CancellationException -> L81
            if (r17 == null) goto L85;
            RecommendationDetailActivity.access$bindActionResult(this.this$0, this.$dto, r17);     // Catch: RuntimeException -> L79 CancellationException -> L81
            Unit r14 = Unit.INSTANCE;     // Catch: RuntimeException -> L79 CancellationException -> L81
        L81:
            e = move-exception;
            throw e;
        L79:
            e = move-exception;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RecommendationDetailActivity.TAG, "[DetailPage] continueAction localProjectionFailed type=" + e.getClass().getSimpleName(), null, 4, null);
            Unit r18 = Unit.INSTANCE;
        L87:
            return Unit.INSTANCE;
        L58:
            e = move-exception;
            throw e;     // Catch: Throwable -> L62
        L57:
            r1 = r5;
            goto L65
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            r1 = this.I$0;
            Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.L$1, Long.class, "com.obric.memorydata.plugin");
            x r7 = (x) ZeusTransformUtils.preCheckCast(this.L$0, x.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
        L46:
            z r19 = (z) ZeusTransformUtils.preCheckCast(r15, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            if (r19.a() == false) goto L60;
            goto L65
        L50:
            if (r19.c() != r7.b()) goto L60;
            com.obric.aiproactive.ui.data.a r8 = RecommendationDetailActivity.access$getRepository(this.this$0);     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            long r9 = r4.longValue();     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            int r10 = this.$actionIndex;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            AiProactiveCardStatus r11 = AiProactiveCardStatus.ACKNOWLEDGED;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            Continuation<? super Unit> r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            this.L$0 = null;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            this.L$1 = null;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            this.I$0 = 1;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            this.label = 3;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            if (r8.a(r9, r10, r11, r12) != r0) goto L98;
            return r0;
        L21:
            r1 = this.I$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
        L37:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L60;
            r7 = y.a(this.$action, y.a(), System.currentTimeMillis());     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            Long r110 = StringsKt.toLongOrNull(this.$recommendationKey);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            if (r7 == null) goto L60;
            if (r110 == null) goto L60;
            com.obric.aiproactive.ui.data.a r13 = RecommendationDetailActivity.access$getRepository(this.this$0);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            Continuation<? super z> r20 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            this.L$0 = r7;     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            this.L$1 = r110;     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            this.I$0 = r1;     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            this.label = 2;     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            Object r6 = r13.a(r7, r20);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L93
            if (r6 != r0) goto L45;
            return r0;
        L45:
            r4 = r110;
            r15 = r6;
            goto L46
        L28:
            ResultKt.throwOnFailure(r15);
            if (RecommendationDetailActivity.access$getContinueSubmissionsInFlight$p(this.this$0).add(this.$recommendationKey) == false) goto L31;
            com.obric.aiproactive.ui.data.a r111 = RecommendationDetailActivity.access$getRepository(this.this$0);     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L88
            Continuation<? super Boolean> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L88
            this.I$0 = 0;     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L88
            this.label = 1;     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L88
            r15 = r111.a(r3);     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L88
            if (r15 != r0) goto L35;
            return r0;
        L35:
            r1 = 0;
            goto L37
        L88:
            e = move-exception;
            throw e;     // Catch: Throwable -> L62
        L64:
            r1 = 0;
            goto L65
        L31:
            return Unit.INSTANCE;
        L62:
            th = th;
        L90:
            if (r2 != 0) goto L92;
            RecommendationDetailActivity.access$getContinueSubmissionsInFlight$p(this.this$0).remove(this.$recommendationKey);
        L92:
            throw th;
        L10:
            th = th;
            r2 = 1;
        L14:
            e = move-exception;
            throw e;     // Catch: Throwable -> L10 RuntimeException -> L57 CancellationException -> L58
        L12:
            e = move-exception;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RecommendationDetailActivity.TAG, "[DetailPage] continueAction localMarkFailed type=" + e.getClass().getSimpleName(), null, 4, null);     // Catch: Throwable -> L10 RuntimeException -> L57 CancellationException -> L58
        L26:
            e = move-exception;
            throw e;     // Catch: Throwable -> L62
        L24:
            th = th;
            r2 = r1;
        L65:
            if (r1 != 0) goto L68;
            goto L61
        }
    }

    static {
        Companion = new a(null);
        QUICK_VALUE_AMOUNTS = new int[]{0, 1, 5, 10, 20};
        QUICK_VALUE_LABELS = new int[]{ZeusTransformUtils.mapRes(R.string.proactive_value_quick_0, TypedValues.Custom.S_STRING, "proactive_value_quick_0"), ZeusTransformUtils.mapRes(R.string.proactive_value_quick_1, TypedValues.Custom.S_STRING, "proactive_value_quick_1"), ZeusTransformUtils.mapRes(R.string.proactive_value_quick_5, TypedValues.Custom.S_STRING, "proactive_value_quick_5"), ZeusTransformUtils.mapRes(R.string.proactive_value_quick_10, TypedValues.Custom.S_STRING, "proactive_value_quick_10"), ZeusTransformUtils.mapRes(R.string.proactive_value_quick_20, TypedValues.Custom.S_STRING, "proactive_value_quick_20")};
    }

    public RecommendationDetailActivity() {
        this.executor = new com.obric.aiproactive.ui.task.a(null, 1, null);
        this.voteStore = new ProactiveVoteStore();
        this.continueSubmissionsInFlight = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.repository$delegate = LazyKt.lazy($$Lambda$RecommendationDetailActivity$SQhqe5x1f5c35rst1sdp71Mw.INSTANCE);
        this.viewModelFactory$delegate = LazyKt.lazy(new $$Lambda$RecommendationDetailActivity$bYtDOm1GIsJK8_01vDWlK_QDYDA(this));
        this.sourcePage$delegate = LazyKt.lazy(new $$Lambda$RecommendationDetailActivity$a7zIpGiZY2bDOZ8oNv_KAKPfi48(this));
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$RecommendationDetailActivity$st_77bRBTxHtTfrYgpqx3mSkUI(this));
        this.feedbackSheet$delegate = LazyKt.lazy(new $$Lambda$RecommendationDetailActivity$yHlVBcyVPLVLPVdUuJ_lRsjZ6w(this));
        this.valueRatingStore$delegate = LazyKt.lazy(new $$Lambda$RecommendationDetailActivity$9E4GguVGxrpzAzGePVuhCxwYlCg(this));
        this.valueRatingSheet$delegate = LazyKt.lazy(new $$Lambda$RecommendationDetailActivity$tIWnjPZ4WOKfQC41m3g8uL0o0uk(this));
    }

    public static final /* synthetic */ void access$bindActionResult(RecommendationDetailActivity r2, ProactiveRecommendationDto r3, ProactiveRecommendationDto r4) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).bindActionResult(r3, r4);
    }

    public static final /* synthetic */ void access$bindDto(RecommendationDetailActivity r2, ActivityRecommendationDetailBinding r3, ProactiveRecommendationDto r4) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).bindDto(r3, r4);
    }

    public static final /* synthetic */ Activity access$getActivity(RecommendationDetailActivity r2) {
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ActivityRecommendationDetailBinding access$getBinding$p(RecommendationDetailActivity r2) {
        return ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ Set access$getContinueSubmissionsInFlight$p(RecommendationDetailActivity r2) {
        return ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).continueSubmissionsInFlight;
    }

    public static final /* synthetic */ com.obric.aiproactive.ui.task.a access$getExecutor$p(RecommendationDetailActivity r2) {
        return ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).executor;
    }

    public static final /* synthetic */ int[] access$getQUICK_VALUE_AMOUNTS$cp() {
        return QUICK_VALUE_AMOUNTS;
    }

    public static final /* synthetic */ com.obric.aiproactive.ui.data.a access$getRepository(RecommendationDetailActivity r2) {
        return ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).getRepository();
    }

    public static final /* synthetic */ boolean access$getSuppressValueRatingTabCallback$p(RecommendationDetailActivity r2) {
        return ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).suppressValueRatingTabCallback;
    }

    public static final /* synthetic */ BaseProactiveFeedViewModel access$getViewModel(RecommendationDetailActivity r2) {
        return ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$reportDetailBackClick(RecommendationDetailActivity r2) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).reportDetailBackClick();
    }

    public static final /* synthetic */ void access$saveQuickValueRating(RecommendationDetailActivity r2, int r3) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).saveQuickValueRating(r3);
    }

    public static final /* synthetic */ void access$setCurrentDto$p(RecommendationDetailActivity r2, ProactiveRecommendationDto r3) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).currentDto = r3;
    }

    public static final /* synthetic */ void access$updateRecommendStatusToAdopted(RecommendationDetailActivity r2, ProactiveRecommendationDto r3) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).updateRecommendStatusToAdopted(r3);
    }

    private final void bindActionResult(ProactiveRecommendationDto r2, ProactiveRecommendationDto r3) {
        ProactiveRecommendationDto r4 = com.obric.aiproactive.ui.detail.b.a(this.currentDto, r2, r3);
        if (r4 != null) goto L5;
        return;
    L5:
        this.currentDto = r4;
        ActivityRecommendationDetailBinding r5 = this.binding;
        if (r5 == null) goto L9;
        bindDto(r5, r4);
        return;
    }

    private final void bindBackNavigation() {
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"), (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), OnBackPressedCallback.class, "com.obric.memorydata.plugin"));
    }

    private final void bindBadge(ActivityRecommendationDetailBinding r8, ProactiveRecommendationDto r9) {
        List<String> r0 = r9.getSourcePackages();
        boolean r3 = true;
        Drawable r4 = null;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        r0 = o.f6895a.a(r9.getActionContext());
    L8:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r1.hasNext() == false) goto L23;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.m1421constructorimpl(((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((RecommendationDetailActivity) ZeusTransformUtils.preCheckCast(this, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationIcon(r2));     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r6) == false) goto L19;
        r6 = null;
    L19:
        Drawable r7 = (Drawable) ZeusTransformUtils.preCheckCast(r6, Drawable.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L10;
        r4 = r7;
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L23:
        if (r4 == null) goto L25;
        r8.tvDetailBadgeEmoji.setVisibility(8);
        r8.ivDetailBadgeIcon.setVisibility(0);
        r8.ivDetailBadgeIcon.setImageDrawable(r4);
        return;
    L25:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.getEmoji(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L28;
    L31:
        if (r3 == true) goto L33;
        r8.tvDetailBadgeEmoji.setVisibility(0);
        r8.ivDetailBadgeIcon.setVisibility(8);
        r8.tvDetailBadgeEmoji.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9.getEmoji(), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L33:
        r8.tvDetailBadgeEmoji.setVisibility(8);
        r8.ivDetailBadgeIcon.setVisibility(0);
        r8.ivDetailBadgeIcon.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_badge_sparkle, "drawable", "ic_proactive_badge_sparkle"));
        return;
    L28:
        if (StringsKt.isBlank(r11) == true) goto L31;
        r3 = false;
        goto L31
    }

    private final void bindDto(ActivityRecommendationDetailBinding r11, ProactiveRecommendationDto r12) {
        RunLog.INSTANCE.debug(TAG, "[DetailPage] bindDto id=" + r12.getRecommendId() + " status=" + r12.getRecommendStatus() + " sourceCount=" + r12.getSourcePackages().size());
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12.getReason(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r1 = r12.getEvidence();
        if (r1 == null) goto L5;
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r4) == false) goto L16;
        String r5 = r12.getActionContext();
        if (r5 == null) goto L15;
        r3 = r5;
    L15:
        r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L16:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.detail.c r7 = d.a(r12, p.a(r12, this.voteStore));
        bindBadge(r11, r12);
        j r8 = j.f6886a;
        AppCompatTextView r9 = r11.tvMain;
        Intrinsics.checkNotNullExpressionValue(r9, "tvMain");
        r8.b((TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin"), r12.getRecommendText());
        j r10 = j.f6886a;
        AppCompatTextView r13 = r11.tvMain;
        Intrinsics.checkNotNullExpressionValue(r13, "tvMain");
        r10.b((TextView) ZeusTransformUtils.preCheckCast(r13, TextView.class, "com.obric.memorydata.plugin"));
        com.obric.aiproactive.ui.util.l r14 = com.obric.aiproactive.ui.util.l.f6890a;
        AppCompatTextView r15 = r11.tvMain;
        Intrinsics.checkNotNullExpressionValue(r15, "tvMain");
        r14.a((TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.memorydata.plugin"));
        r11.tvScoreValue.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf((int) r12.getScore()), CharSequence.class, "com.obric.memorydata.plugin"));
        r11.tvStatusValue.setText((CharSequence) ZeusTransformUtils.preCheckCast(mapRecommendStatus(r12), CharSequence.class, "com.obric.memorydata.plugin"));
        LinearLayout r16 = r11.cardReason;
        int r17 = 8;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L19;
        int r18 = 8;
    L20:
        r16.setVisibility(r18);
        j r19 = j.f6886a;
        AppCompatTextView r20 = r11.tvReasonContent;
        Intrinsics.checkNotNullExpressionValue(r20, "tvReasonContent");
        r19.c((TextView) ZeusTransformUtils.preCheckCast(r20, TextView.class, "com.obric.memorydata.plugin"), r0);
        j r21 = j.f6886a;
        AppCompatTextView r22 = r11.tvReasonContent;
        Intrinsics.checkNotNullExpressionValue(r22, "tvReasonContent");
        r21.b((TextView) ZeusTransformUtils.preCheckCast(r22, TextView.class, "com.obric.memorydata.plugin"));
        com.obric.aiproactive.ui.util.l r23 = com.obric.aiproactive.ui.util.l.f6890a;
        AppCompatTextView r24 = r11.tvReasonContent;
        Intrinsics.checkNotNullExpressionValue(r24, "tvReasonContent");
        r23.a((TextView) ZeusTransformUtils.preCheckCast(r24, TextView.class, "com.obric.memorydata.plugin"));
        LinearLayout r25 = r11.cardEvidence;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L24;
        r17 = 0;
    L24:
        r25.setVisibility(r17);
        j r26 = j.f6886a;
        AppCompatTextView r27 = r11.tvEvidenceContent;
        Intrinsics.checkNotNullExpressionValue(r27, "tvEvidenceContent");
        r26.c((TextView) ZeusTransformUtils.preCheckCast(r27, TextView.class, "com.obric.memorydata.plugin"), r6);
        j r28 = j.f6886a;
        AppCompatTextView r29 = r11.tvEvidenceContent;
        Intrinsics.checkNotNullExpressionValue(r29, "tvEvidenceContent");
        r28.b((TextView) ZeusTransformUtils.preCheckCast(r29, TextView.class, "com.obric.memorydata.plugin"));
        com.obric.aiproactive.ui.util.l r30 = com.obric.aiproactive.ui.util.l.f6890a;
        AppCompatTextView r31 = r11.tvEvidenceContent;
        Intrinsics.checkNotNullExpressionValue(r31, "tvEvidenceContent");
        r30.a((TextView) ZeusTransformUtils.preCheckCast(r31, TextView.class, "com.obric.memorydata.plugin"));
        com.obric.aiproactive.ui.artifact.a r32 = com.obric.aiproactive.ui.artifact.a.f6542a;
        LinearLayout r33 = r11.llDetailArtifacts;
        Intrinsics.checkNotNullExpressionValue(r33, "llDetailArtifacts");
        r32.a(r33, r12.getArtifacts());
        bindExecuteInstruction(r11, r12, r7);
        bindPrimaryAction(r11, r12);
        bindSources(r11, r12);
        bindVote(r11, r12);
        bindValueRating$default(this, r11, r12, null, 4, null);
        return;
    L19:
        r18 = 0;
        goto L20
    L5:
        r2 = null;
        goto L6
    }

    private final void bindExecuteInstruction(ActivityRecommendationDetailBinding r12, ProactiveRecommendationDto r13, com.obric.aiproactive.ui.detail.c r14) {
        if (r14.a() == true) goto L5;
    L26:
        r12.llDetailActionItems.removeAllViews();
        r12.llDetailActionItems.setVisibility(8);
        RunLog.INSTANCE.debug(TAG, "[DetailPage] bindExecuteInstruction empty id=" + r13.getRecommendId());
        return;
    L5:
        if (r14.b().isEmpty() == true) goto L26;
        RunLog.INSTANCE.debug(TAG, "[DetailPage] bindExecuteInstruction id=" + r13.getRecommendId() + " count=" + r14.b().size());
        r12.llDetailActionItems.setVisibility(0);
        r12.llDetailActionItems.removeAllViews();
        LayoutInflater r15 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        int r2 = ZeusTransformUtils.getResources((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.proactive_action_button_gap, "dimen", "proactive_action_button_gap"));
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L9:
        if (r16.hasNext() == false) goto L25;
        Object r4 = r16.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        final com.obric.aiproactive.ui.detail.a r6 = (com.obric.aiproactive.ui.detail.a) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.ui.detail.a.class, "com.obric.memorydata.plugin");
        View r7 = ZeusTransformUtils.inflate(r15, ZeusTransformUtils.mapRes(R.layout.item_proactive_now_action_chip, "layout", "item_proactive_now_action_chip"), (ViewGroup) ZeusTransformUtils.preCheckCast(r12.llDetailActionItems, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r7, OButton.class, "com.obric.memorydata.plugin");
        String r9 = r6.b();
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        r8.setEnabled(r6.c());
        r8.setSelected(r6.d());
        r8.setAlpha(1.0f);
        if (r6.d() == false) goto L19;
        Activity r10 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        int r11 = R.color.ai_proactive_demo_text_disabled;
        String r17 = "ai_proactive_demo_text_disabled";
    L20:
        r8.setTextColor(r10.getColor(ZeusTransformUtils.mapRes(r11, TypedValues.Custom.S_COLOR, r17)));
        TextView r18 = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.memorydata.plugin");
        if (r3 <= 0) goto L23;
        int r19 = r2;
    L24:
        g.a(r18, r19, GravityCompat.START);
        r8.setOnClickListener(new $$Lambda$RecommendationDetailActivity$740pTzOkp6o2nAZSA4O3eCGh_Y(r6, this));
        r12.llDetailActionItems.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        TextView r20 = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.memorydata.plugin");
        LinearLayout r21 = r12.llDetailActionItems;
        Intrinsics.checkNotNullExpressionValue(r21, "llDetailActionItems");
        g.a(r20, (View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"));
        r3 = r5;
        goto L9
    L23:
        r19 = 0;
        goto L24
    L19:
        r10 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        r11 = R.color.ai_proactive_demo_text_primary;
        r17 = "ai_proactive_demo_text_primary";
        goto L20
    }

    private static final void bindExecuteInstruction$lambda$57$lambda$56(com.obric.aiproactive.ui.detail.a r1, RecommendationDetailActivity r2, View r3) {
        RecommendationDetailActivity r4 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        if (r1.c() == true) goto L5;
        return;
    L5:
        r4.reportInlineActionClick();
        r4.handleInlineAction(r1);
    }

    private final void bindPrimaryAction(ActivityRecommendationDetailBinding r1, ProactiveRecommendationDto r2) {
    }

    private final void bindScrollTracking(ActivityRecommendationDetailBinding r3) {
        r3.scrollContent.setOnTouchListener(new $$Lambda$RecommendationDetailActivity$AJtpNYMbMrT7t_8SUuS85pi2j3w(this));
        r3.scrollContent.setOnScrollChangeListener(new $$Lambda$RecommendationDetailActivity$YZ0CX30GfcrtzvqMa1v2XIjIUlE(this));
    }

    private static final boolean bindScrollTracking$lambda$14(RecommendationDetailActivity r2, View r3, MotionEvent r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        int r6 = r4.getActionMasked();
        if (r6 == 0) goto L11;
        if (r6 == 1) goto L9;
        if (r6 == 3) goto L9;
    L15:
        return false;
    L9:
        if (r5.userScrollObserved == true) goto L15;
        r5.userScrollInProgress = false;
        goto L15
    L11:
        Runnable r7 = r5.scrollIdleRunnable;
        if (r7 == null) goto L14;
        r3.removeCallbacks(r7);
    L14:
        r5.scrollIdleRunnable = null;
        r5.userScrollInProgress = true;
        r5.userScrollObserved = false;
        goto L15
    }

    private static final void bindScrollTracking$lambda$18(RecommendationDetailActivity r0, NestedScrollView r1, int r2, int r3, int r4, int r5) {
        final RecommendationDetailActivity r6 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r0, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r6.userScrollInProgress == true) goto L5;
        return;
    L5:
        r6.userScrollObserved = true;
        Runnable r7 = r6.scrollIdleRunnable;
        if (r7 == null) goto L8;
        r1.removeCallbacks(r7);
    L8:
        Runnable r8 = new $$Lambda$RecommendationDetailActivity$rQcw8ykl7F5NxdxoDO1jZAVnj2c(r6);
        r1.postDelayed(r8, 200);
        r6.scrollIdleRunnable = r8;
    }

    private static final void bindScrollTracking$lambda$18$lambda$16(RecommendationDetailActivity r2) {
        RecommendationDetailActivity r3 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        h.f6884a.b("proactive_card_detail");
        r3.scrollIdleRunnable = null;
        r3.userScrollInProgress = false;
        r3.userScrollObserved = false;
    }

    private final void bindSources(ActivityRecommendationDetailBinding r17, ProactiveRecommendationDto r18) {
        List<String> r0 = r18.getSourcePackages();
        int r5 = 1;
        String r6 = null;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L9;
        r0 = o.f6895a.a(r18.getActionContext());
    L9:
        if (r0.isEmpty() == false) goto L12;
        r17.llSourcesGroup.setVisibility(8);
        RunLog.INSTANCE.debug(TAG, "[DetailPage] bindSources empty id=" + r18.getRecommendId());
        return;
    L12:
        RunLog.INSTANCE.debug(TAG, "[DetailPage] bindSources id=" + r18.getRecommendId() + " size=" + r0.size());
        r17.llSourcesGroup.setVisibility(0);
        r17.llSources.removeAllViews();
        PackageManager r3 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getPackageManager();
        int r9 = dp(22);
        int r10 = dp(14);
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), 8), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L14:
        if (r7.hasNext() == false) goto L44;
        Object r11 = r7.next();
        int r12 = r1 + 1;
        if (r1 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
        LinearLayout r14 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r14.setOrientation(r5);
        r14.setGravity(r5);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, -2);
        if (r1 == 0) goto L21;
        r15.setMarginStart(r10);
    L21:
        r14.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ImageView r16 = new ImageView((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r16.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r9, r9), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        Object r4 = Result.m1421constructorimpl(r3.getApplicationIcon(r13));     // Catch: Throwable -> L24
    L27:
        if (Result.m1427isFailureimpl(r4) == false) goto L29;
        r4 = r6;
    L29:
        Drawable r8 = (Drawable) ZeusTransformUtils.preCheckCast(r4, Drawable.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L32;
        r8 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getDrawable(android.R.drawable.sym_def_app_icon);
    L32:
        r16.setImageDrawable(r8);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L35
        RecommendationDetailActivity r20 = (RecommendationDetailActivity) ZeusTransformUtils.preCheckCast(this, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        Object r21 = Result.m1421constructorimpl(r3.getApplicationLabel(r3.getApplicationInfo(r13, 0)).toString());     // Catch: Throwable -> L35
    L38:
        if (Result.m1427isFailureimpl(r21) == false) goto L40;
        r21 = r6;
    L40:
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L43;
        r22 = StringsKt.substringAfterLast$default(r13, '.', r6, 2, r6);
    L43:
        TextView r23 = new TextView((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-2, -2);
        r24.topMargin = dp(6);
        r23.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r24, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r23.setText((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin"));
        r23.setTextColor(-7434605);
        r23.setTextSize(11.0f);
        r23.setMaxLines(1);
        r14.addView((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"));
        r14.addView((View) ZeusTransformUtils.preCheckCast(r23, View.class, "com.obric.memorydata.plugin"));
        r17.llSources.addView((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
        r5 = 1;
        r1 = r12;
        r6 = null;
    L35:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L24:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    private final void bindValueRating(ActivityRecommendationDetailBinding r9, ProactiveRecommendationDto r10, com.obric.aiproactive.ui.feedback.j r11) {
        r9.tvValueRatingTitle.setText(ZeusTransformUtils.mapRes(R.string.proactive_value_entry_title, TypedValues.Custom.S_STRING, "proactive_value_entry_title"));
        switch(b.f6558a[com.obric.aiproactive.ui.feedback.o.a(r11).ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        Integer r12 = null;
    L13:
        renderValueQuickTabs(r9, r12);
        TextView r13 = r9.tvValueRatingStatus;
        if (r11 != null) goto L16;
        int r3 = 8;
    L17:
        r13.setVisibility(r3);
        TextView r14 = r9.tvValueRatingStatus;
        if (r11 != null) goto L20;
        Object r4 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L21:
        r14.setText((CharSequence) r4);
        OButton r15 = r9.btnValueOther;
        if (r11 != null) goto L24;
        int r5 = ZeusTransformUtils.mapRes(R.string.proactive_value_input_other_action, TypedValues.Custom.S_STRING, "proactive_value_input_other_action");
    L25:
        r15.setText(r5);
        OButton r16 = r9.btnValueOther;
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L28;
        String r17 = r8.getString(ZeusTransformUtils.mapRes(R.string.proactive_value_input_other_action, TypedValues.Custom.S_STRING, "proactive_value_input_other_action"));
    L29:
        r16.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L28:
        r17 = r8.getString(ZeusTransformUtils.mapRes(R.string.proactive_value_modify_amount_description, TypedValues.Custom.S_STRING, "proactive_value_modify_amount_description"), new Object[]{com.obric.aiproactive.ui.feedback.o.a(r11.a())});
        goto L29
    L24:
        r5 = ZeusTransformUtils.mapRes(R.string.proactive_value_modify_action, TypedValues.Custom.S_STRING, "proactive_value_modify_action");
        goto L25
    L20:
        String r6 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_value_recorded_amount, TypedValues.Custom.S_STRING, "proactive_value_recorded_amount"), new Object[]{com.obric.aiproactive.ui.feedback.o.a(r11.a())});
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        r4 = ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        goto L21
    L16:
        r3 = 0;
        goto L17
    L7:
        int r18 = 4;
    L10:
        r12 = Integer.valueOf(r18);
        goto L13
    L8:
        r18 = 3;
        goto L10
    L9:
        r18 = 2;
        goto L10
    L11:
        r12 = 1;
        goto L13
    L12:
        r12 = 0;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    static /* synthetic */ void bindValueRating$default(RecommendationDetailActivity r1, ActivityRecommendationDetailBinding r2, ProactiveRecommendationDto r3, com.obric.aiproactive.ui.feedback.j r4, int r5, Object r6) {
        RecommendationDetailActivity r7 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = r7.getValueRatingStore().a(r3.getRecommendId());
    L5:
        r7.bindValueRating(r2, r3, r4);
    }

    private final void bindValueRatingActions(ActivityRecommendationDetailBinding r5) {
        r5.valueQuickTabs.a((OTabLayoutBase.c) ZeusTransformUtils.preCheckCast(new c(this), OTabLayoutBase.c.class, "com.obric.memorydata.plugin"));
        r5.btnValueOther.setOnClickListener(new $$Lambda$RecommendationDetailActivity$z9Jg7GXItZDf0ZI18Va2HEoVxg(this));
        renderValueQuickTabs(r5, null);
    }

    private static final void bindValueRatingActions$lambda$25(RecommendationDetailActivity r1, View r2) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).showValueRatingSheet();
    }

    private final void bindVote(ActivityRecommendationDetailBinding r7, ProactiveRecommendationDto r8) {
        if (r7 == this.binding) goto L5;
        return;
    L5:
        OIconButton r9 = this.likeButton;
        if (r9 != null) goto L8;
        return;
    L8:
        OIconButton r0 = this.dislikeButton;
        if (r0 != null) goto L11;
        return;
    L11:
        ProactiveVoteStore.Vote r6 = p.a(r8, this.voteStore);
        if (r6 != null) goto L14;
        int r10 = -1;
    L16:
        if (r10 != (-1)) goto L18;
        r9.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_thumb_up, "drawable", "ic_proactive_thumb_up"));
        r0.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_thumb_down, "drawable", "ic_proactive_thumb_down"));
        r9.setBackgroundColor(0);
    L26:
        r0.setBackgroundColor(0);
        return;
    L18:
        if (r10 != 1) goto L20;
        r9.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_thumb_up_filled, "drawable", "ic_proactive_thumb_up_filled"));
        r0.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_thumb_down, "drawable", "ic_proactive_thumb_down"));
        r9.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.bg_proactive_detail_feedback_item_selected, "drawable", "bg_proactive_detail_feedback_item_selected"));
        goto L26
    L20:
        if (r10 != 2) goto L23;
        r9.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_thumb_up, "drawable", "ic_proactive_thumb_up"));
        r0.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_proactive_thumb_down_filled, "drawable", "ic_proactive_thumb_down_filled"));
        r9.setBackgroundColor(0);
        r0.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.bg_proactive_detail_feedback_item_selected, "drawable", "bg_proactive_detail_feedback_item_selected"));
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    L14:
        r10 = b.f6559b[r6.ordinal()];
        goto L16
    }

    private final String buildUserFeedback(com.obric.aiproactive.ui.feedback.d r14) {
        List r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).add("reasons=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14.a(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("、", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    L6:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).add("detail=" + r14.b());
    L8:
        ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).add("upload=" + r14.c());
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    private final int dp(int r3) {
        return (int) (r3 * ZeusTransformUtils.getResources((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().density);
    }

    private static final ProactiveFeedbackSheet feedbackSheet_delegate$lambda$5(RecommendationDetailActivity r3) {
        return new ProactiveFeedbackSheet((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"));
    }

    private final Activity getActivity() {
        return (Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin");
    }

    private final ProactiveFeedbackSheet getFeedbackSheet() {
        return (ProactiveFeedbackSheet) ZeusTransformUtils.preCheckCast(this.feedbackSheet$delegate.getValue(), ProactiveFeedbackSheet.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.aiproactive.ui.data.a getRepository() {
        return (com.obric.aiproactive.ui.data.a) ZeusTransformUtils.preCheckCast(this.repository$delegate.getValue(), com.obric.aiproactive.ui.data.a.class, "com.obric.memorydata.plugin");
    }

    private final String getSourcePage() {
        return (String) ZeusTransformUtils.preCheckCast(this.sourcePage$delegate.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.aiproactive.ui.feedback.l getValueRatingSheet() {
        return (com.obric.aiproactive.ui.feedback.l) ZeusTransformUtils.preCheckCast(this.valueRatingSheet$delegate.getValue(), com.obric.aiproactive.ui.feedback.l.class, "com.obric.memorydata.plugin");
    }

    private final n getValueRatingStore() {
        return (n) ZeusTransformUtils.preCheckCast(this.valueRatingStore$delegate.getValue(), n.class, "com.obric.memorydata.plugin");
    }

    private final BaseProactiveFeedViewModel getViewModel() {
        return (BaseProactiveFeedViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), BaseProactiveFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    private final ProactiveFeedPageViewModelFactory getViewModelFactory() {
        return (ProactiveFeedPageViewModelFactory) ZeusTransformUtils.preCheckCast(this.viewModelFactory$delegate.getValue(), ProactiveFeedPageViewModelFactory.class, "com.obric.memorydata.plugin");
    }

    private final void handleExecute(String r11) {
        ProactiveRecommendationDto r0 = this.currentDto;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r11 == null) goto L8;
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L9:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L17:
        if ((!r4) == true) goto L20;
        r12 = null;
    L20:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder().append("[DetailPage] handleExecute id=").append(r0.getRecommendId()).append(" override=");
        if (r12 != null) goto L23;
        String r7 = "";
    L24:
        IRunLog.a.a(r5, TAG, r6.append(r7).toString(), false, 4, null);
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10471(r0, r12, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L23:
        r7 = r12;
        goto L24
    L12:
        if (StringsKt.isBlank(r3) == true) goto L15;
        r4 = false;
        goto L17
    L8:
        r12 = null;
        goto L9
    }

    static /* synthetic */ void handleExecute$default(RecommendationDetailActivity r1, String r2, int r3, Object r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        r5.handleExecute(r2);
    }

    private final void handleExecuteActionAt(int r14, String r15) {
        ProactiveRecommendationDto r2 = this.currentDto;
        if (r2 != null) goto L5;
        return;
    L5:
        String r16 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        r16 = null;
    L9:
        String r3 = r16;
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r17 = new StringBuilder().append("[DetailPage] handleExecuteActionAt id=").append(r2.getRecommendId()).append(" actionIndex=").append(r14).append(" query=");
        if (r3 != null) goto L12;
        String r0 = "";
    L13:
        IRunLog.a.a(r7, TAG, r17.append(r0).toString(), false, 4, null);
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10481(this, r2, r3, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L12:
        r0 = r3;
        goto L13
    }

    private final void handleInlineAction(com.obric.aiproactive.ui.detail.a r13) {
        final ProactiveRecommendationDto r0 = this.currentDto;
        if (r0 != null) goto L6;
        return;
    L6:
        if (d.d(r0) == false) goto L8;
        return;
    L8:
        Integer r1 = r13.e();
        com.obric.aiproactive.api.b r2 = r13.f();
        String r4 = "";
        if (com.obric.aiproactive.ui.detail.b.c(r0) == false) goto L32;
        if (r1 == null) goto L32;
        if (r2 == null) goto L32;
        if (StringsKt.toLongOrNull(r0.getRecommendId()) != null) goto L15;
        return;
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[DetailPage] handleInlineAiAction id=" + r0.getRecommendId() + " actionIndex=" + r1 + " format=" + r2.d(), false, 4, null);
        if (r2.i() == false) goto L20;
        submitContinueAction(r0, r1.intValue(), r2);
        return;
    L20:
        if (r2.j() == true) goto L23;
        getViewModel().onRecommendationAdoptedFromDetail(r0.getInspirationId());
        getViewModel().markAiRecommendationActionExecuted(r0, r1.intValue(), AiProactiveCardStatus.ACKNOWLEDGED, new $$Lambda$RecommendationDetailActivity$lfEsu61Jm4cxqaLafgdyB6p_cs(this, r0));
        return;
    L23:
        int r3 = r1.intValue();
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r5) == false) goto L30;
        String r14 = r13.b();
        if (r14 == null) goto L29;
        r4 = r14;
    L29:
        r5 = r4;
    L30:
        handleExecuteActionAt(r3, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));
        return;
    L32:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r6) == false) goto L39;
        String r15 = r13.b();
        if (r15 == null) goto L38;
        r4 = r15;
    L38:
        r6 = r4;
    L39:
        handleExecute((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit handleInlineAction$lambda$58(RecommendationDetailActivity r2, ProactiveRecommendationDto r3, ProactiveRecommendationDto r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        r5.bindActionResult(r3, r4);
        return Unit.INSTANCE;
    }

    private final void handlePrimaryAction() {
        ProactiveRecommendationDto r11 = this.currentDto;
        if (r11 != null) goto L5;
        return;
    L5:
        com.obric.aiproactive.ui.model.k r0 = com.obric.aiproactive.ui.model.k.f6745a;
        String r5 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_status_adopted, TypedValues.Custom.S_STRING, "proactive_status_adopted"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        String r7 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_status_ignored, TypedValues.Custom.S_STRING, "proactive_status_ignored"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        String r8 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_execute_now, TypedValues.Custom.S_STRING, "proactive_execute_now"));
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        String r9 = ((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.proactive_known, TypedValues.Custom.S_STRING, "proactive_known"));
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        String r1 = com.obric.aiproactive.ui.model.k.a(r0, r11, null, null, null, r5, r7, r8, r9, 7, null).f();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[DetailPage] handlePrimaryAction id=" + r11.getRecommendId() + " status=" + r11.getRecommendStatus() + " hasInstruction=" + d.g(r11), false, 4, null);
        if (d.d(r11) == false) goto L12;
        return;
    L12:
        if (com.obric.aiproactive.ui.detail.b.c(r11) == false) goto L21;
        Long r2 = StringsKt.toLongOrNull(r11.getRecommendId());
        if (r2 == null) goto L26;
        long r4 = r2.longValue();
        if (com.obric.aiproactive.ui.detail.b.a(r1) == false) goto L18;
        getViewModel().onRecommendationAdoptedFromDetail(r11.getInspirationId());
        getViewModel().updateAiRecommendationCardStatus(r4, AiProactiveCardStatus.ACKNOWLEDGED);
        return;
    L18:
        handleExecute$default(this, null, 1, null);
        return;
    L26:
        return;
    L21:
        if (d.g(r11) == true) goto L24;
        getViewModel().onRecommendationAdoptedFromDetail(r11.getInspirationId());
        BaseProactiveFeedViewModel.optimisticallyUpdateRecommendStatus$default(getViewModel(), r11.getInspirationId(), 2, false, 4, null);
        updateRecommendStatusToAdopted(r11);
        return;
    L24:
        handleExecute$default(this, null, 1, null);
    }

    private final void handleVote(final ProactiveVoteStore.Vote r17) {
        final ProactiveRecommendationDto r2 = this.currentDto;
        if (r2 != null) goto L5;
        return;
    L5:
        ProactiveVoteStore.Vote r0 = p.a(r2, this.voteStore);
        if (r0 != r17) goto L10;
        String r4 = "";
    L8:
        final String r5 = r4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[DetailPage] handleVote id=" + r2.getRecommendId() + " selected=" + r0 + " vote=" + r17 + " action=" + r5, false, 4, null);
        final Long r6 = com.obric.aiproactive.ui.detail.b.b(r2);
        boolean r1 = true;
        if (r6 == null) goto L32;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L19;
        r1 = false;
    L19:
        if (r1 == false) goto L26;
        this.voteStore.b(r2.getInspirationId());
        getViewModel().notifyVoteChanged(r2.getInspirationId());
        ActivityRecommendationDetailBinding r3 = this.binding;
        if (r3 == null) goto L23;
        bindVote(r3, r2);
    L23:
        getViewModel().updateAiRecommendationFeedback(new u(r6.longValue(), null, null, null, null, "original", null, 80, null));
        return;
    L26:
        if (r17 != ProactiveVoteStore.Vote.LIKE) goto L28;
        ProactiveFeedbackSheet.Mode r7 = ProactiveFeedbackSheet.Mode.LIKE;
    L29:
        ProactiveFeedbackSheet.Mode r8 = r7;
        ProactiveFeedbackSheet.a(getFeedbackSheet(), r8, f.a(r2.getInspirationFeedbackReason(), r2.getInspirationFeedbackText(), r2.getInspirationUserFeedback(), r8, r2.getInspirationFeedbackAction()), null, new $$Lambda$RecommendationDetailActivity$sEKFGu8UPg9ZANQUIkzefHyDIc(this, r2, r17, r6, r5), 4, null);
        return;
    L28:
        r7 = ProactiveFeedbackSheet.Mode.DISLIKE;
        goto L29
    L32:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L35;
        r1 = false;
    L35:
        if (r1 == false) goto L41;
        this.voteStore.b(r2.getInspirationId());
        getViewModel().notifyVoteChanged(r2.getInspirationId());
        ActivityRecommendationDetailBinding r9 = this.binding;
        if (r9 == null) goto L39;
        bindVote(r9, r2);
    L39:
        report(r2, r5, null);
        return;
    L41:
        ProactiveFeedbackSheet r10 = getFeedbackSheet();
        if (r17 != ProactiveVoteStore.Vote.LIKE) goto L44;
        ProactiveFeedbackSheet.Mode r11 = ProactiveFeedbackSheet.Mode.LIKE;
    L45:
        ProactiveFeedbackSheet.a(r10, r11, null, null, new $$Lambda$RecommendationDetailActivity$wdDY_FSD81rvjiAs_6aDo8Ga74(this, r2, r17, r5), 6, null);
        return;
    L44:
        r11 = ProactiveFeedbackSheet.Mode.DISLIKE;
        goto L45
    L10:
        if (r17 != ProactiveVoteStore.Vote.LIKE) goto L12;
        r4 = "LIKE";
        goto L8
    L12:
        r4 = "DISLIKE";
        goto L8
    }

    private static final Unit handleVote$lambda$42(RecommendationDetailActivity r18, ProactiveRecommendationDto r19, ProactiveVoteStore.Vote r20, Long r21, String r22, com.obric.aiproactive.ui.feedback.d r23) {
        RecommendationDetailActivity r1 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r18, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r23, "result");
        r1.voteStore.a(r19.getInspirationId(), r20);
        r1.getViewModel().notifyVoteChanged(r19.getInspirationId());
        ActivityRecommendationDetailBinding r3 = r1.binding;
        if (r3 == null) goto L5;
        r1.bindVote(r3, r19);
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[DetailPage] confirmAiFeedback id=" + r21 + " action=" + r22 + " reasons=" + r23.a().size() + " detailLen=" + r23.b().length(), false, 4, null);
        h r4 = h.f6884a;
        if (r20 != ProactiveVoteStore.Vote.LIKE) goto L8;
        String r0 = "like";
    L9:
        String r6 = f.a(r23.a());
        String r7 = r23.b();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        r7 = null;
    L13:
        r4.c(r0, r6, r7, r19.getRecommendId());
        BaseProactiveFeedViewModel r2 = r1.getViewModel();
        long r5 = r21.longValue();
        String r11 = f.a(r23.a());
        String r8 = r23.b();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L16;
        String r12 = r8;
    L17:
        r2.updateAiRecommendationFeedback(new u(r5, r22, r11, r12, null, "original", null, 80, null));
        return Unit.INSTANCE;
    L16:
        r12 = null;
        goto L17
    L8:
        r0 = "dislike";
        goto L9
    }

    private static final Unit handleVote$lambda$46(RecommendationDetailActivity r5, ProactiveRecommendationDto r6, ProactiveVoteStore.Vote r7, String r8, com.obric.aiproactive.ui.feedback.d r9) {
        RecommendationDetailActivity r10 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r5, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "result");
        r10.voteStore.a(r6.getInspirationId(), r7);
        r10.getViewModel().notifyVoteChanged(r6.getInspirationId());
        ActivityRecommendationDetailBinding r0 = r10.binding;
        if (r0 == null) goto L5;
        r10.bindVote(r0, r6);
    L5:
        h r1 = h.f6884a;
        if (r7 != ProactiveVoteStore.Vote.LIKE) goto L8;
        String r11 = "like";
    L9:
        String r2 = f.a(r9.a());
        String r3 = r9.b();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        r3 = null;
    L13:
        r1.c(r11, r2, r3, r6.getRecommendId());
        r10.report(r6, r8, r10.buildUserFeedback(r9));
        return Unit.INSTANCE;
    L8:
        r11 = "dislike";
        goto L9
    }

    /* JADX INFO: renamed from: lambda$-riEAf7ZyztYkkw_q-hbUYUxsN8, reason: not valid java name */
    public static /* synthetic */ long m246lambda$riEAf7ZyztYkkw_qhbUYUxsN8() {
        return viewModelFactory_delegate$lambda$2$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$-yHlVBcyVPLVLPVdUuJ_lRsjZ6w, reason: not valid java name */
    public static /* synthetic */ ProactiveFeedbackSheet m247lambda$yHlVBcyVPLVLPVdUuJ_lRsjZ6w(RecommendationDetailActivity r0) {
        return feedbackSheet_delegate$lambda$5(r0);
    }

    public static /* synthetic */ void lambda$0SEW1kRzcLsAkpLkEso3yicV1dA(RecommendationDetailActivity r0, View r1) {
        onCreateChecked$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$740p-TzOkp6o2nAZSA4O3eCGh_Y, reason: not valid java name */
    public static /* synthetic */ void m248lambda$740pTzOkp6o2nAZSA4O3eCGh_Y(com.obric.aiproactive.ui.detail.a r0, RecommendationDetailActivity r1, View r2) {
        bindExecuteInstruction$lambda$57$lambda$56(r0, r1, r2);
    }

    public static /* synthetic */ n lambda$9E4GguVGxrpzAzGePVuhCxwYlCg(RecommendationDetailActivity r0) {
        return valueRatingStore_delegate$lambda$6(r0);
    }

    public static /* synthetic */ boolean lambda$AJtpNYMbMrT7t_8SUuS85pi2j3w(RecommendationDetailActivity r0, View r1, MotionEvent r2) {
        return bindScrollTracking$lambda$14(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$DoGIG2L-e4-_5xo1netV7yZZk4Y, reason: not valid java name */
    public static /* synthetic */ Unit m249lambda$DoGIG2Le4_5xo1netV7yZZk4Y(RecommendationDetailActivity r0, ProactiveRecommendationDto r1, com.obric.aiproactive.ui.feedback.j r2) {
        return saveQuickValueRating$lambda$28(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$HJbkfMg7ynnxBF5SD998zWTdheY(RecommendationDetailActivity r0, View r1) {
        onCreateChecked$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$JIy--Aest1g4nfOnNGh6TVz9Aug, reason: not valid java name */
    public static /* synthetic */ void m250lambda$JIyAest1g4nfOnNGh6TVz9Aug(RecommendationDetailActivity r0, View r1) {
        onCreateChecked$lambda$9(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$S-Qhqe5x-1f5-c35rst1sdp71Mw, reason: not valid java name */
    public static /* synthetic */ com.obric.aiproactive.ui.data.a m251lambda$SQhqe5x1f5c35rst1sdp71Mw() {
        return repository_delegate$lambda$0();
    }

    public static /* synthetic */ Unit lambda$W7C7hVv280N9U6FNQeVFq8i2Ods(ProactiveRecommendationDto r0, com.obric.aiproactive.ui.feedback.j r1, ProactiveValueSubmitType r2) {
        return saveQuickValueRating$lambda$27(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$YZ0CX30GfcrtzvqMa1v2XIjIUlE(RecommendationDetailActivity r0, NestedScrollView r1, int r2, int r3, int r4, int r5) {
        bindScrollTracking$lambda$18(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ String lambda$a7zIpGiZY2bDOZ8oNv_KAKPfi48(RecommendationDetailActivity r0) {
        return sourcePage_delegate$lambda$3(r0);
    }

    public static /* synthetic */ ProactiveFeedPageViewModelFactory lambda$bYtDOm1GIsJK8_01vDWlK_QDYDA(RecommendationDetailActivity r0) {
        return viewModelFactory_delegate$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$lfEsu61Jm4cxqaLafgdyB6-p_cs, reason: not valid java name */
    public static /* synthetic */ Unit m252lambda$lfEsu61Jm4cxqaLafgdyB6p_cs(RecommendationDetailActivity r0, ProactiveRecommendationDto r1, ProactiveRecommendationDto r2) {
        return handleInlineAction$lambda$58(r0, r1, r2);
    }

    public static /* synthetic */ ProactiveValueSubmitType lambda$mv2yPFcGRaKWA95ElXk9VqJ9PEk(RecommendationDetailActivity r0, ProactiveRecommendationDto r1, com.obric.aiproactive.ui.feedback.j r2) {
        return saveQuickValueRating$lambda$26(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$mywBGvweVO65WGM9h1rBYVBQkc8(RecommendationDetailActivity r0, ProactiveRecommendationDto r1, com.obric.aiproactive.ui.feedback.j r2) {
        return showValueRatingSheet$lambda$24(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$rQcw8ykl7F5NxdxoDO1jZAVnj2c(RecommendationDetailActivity r0) {
        bindScrollTracking$lambda$18$lambda$16(r0);
    }

    /* JADX INFO: renamed from: lambda$sEKFGu8UPg9ZANQUI-kzefHyDIc, reason: not valid java name */
    public static /* synthetic */ Unit m253lambda$sEKFGu8UPg9ZANQUIkzefHyDIc(RecommendationDetailActivity r0, ProactiveRecommendationDto r1, ProactiveVoteStore.Vote r2, Long r3, String r4, com.obric.aiproactive.ui.feedback.d r5) {
        return handleVote$lambda$42(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$st_77bR-BTxHtTfrYgpqx3mSkUI, reason: not valid java name */
    public static /* synthetic */ BaseProactiveFeedViewModel m254lambda$st_77bRBTxHtTfrYgpqx3mSkUI(RecommendationDetailActivity r0) {
        return viewModel_delegate$lambda$4(r0);
    }

    public static /* synthetic */ com.obric.aiproactive.ui.feedback.l lambda$tIWnjPZ4WOKfQC41m3g8uL0o0uk(RecommendationDetailActivity r0) {
        return valueRatingSheet_delegate$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$wdDY_FSD81rvjiAs_6aD-o8Ga74, reason: not valid java name */
    public static /* synthetic */ Unit m255lambda$wdDY_FSD81rvjiAs_6aDo8Ga74(RecommendationDetailActivity r0, ProactiveRecommendationDto r1, ProactiveVoteStore.Vote r2, String r3, com.obric.aiproactive.ui.feedback.d r4) {
        return handleVote$lambda$46(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$yyM6oY7oIMmDJIHOQPRVMAth4kM(RecommendationDetailActivity r0, ProactiveRecommendationDto r1) {
        return showValueRatingSheet$lambda$22(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$z9Jg7GX-ItZDf0ZI18Va2HEoVxg, reason: not valid java name */
    public static /* synthetic */ void m256lambda$z9Jg7GXItZDf0ZI18Va2HEoVxg(RecommendationDetailActivity r0, View r1) {
        bindValueRatingActions$lambda$25(r0, r1);
    }

    private final String mapRecommendStatus(ProactiveRecommendationDto r10) {
        if (com.obric.aiproactive.ui.detail.b.c(r10) == false) goto L24;
        String r11 = r10.getStatus();
        switch(r11.hashCode()) {
            case -1469323377: goto L18;
            case -1348905847: goto L14;
            case 35394935: goto L11;
            case 950753608: goto L8;
            default: goto L21;
        };
    L21:
        Activity r9 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        int r12 = ZeusTransformUtils.mapRes(R.string.proactive_placeholder, TypedValues.Custom.S_STRING, "proactive_placeholder");
    L22:
        String r13 = r9.getString(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        return r13;
    L8:
        if (r11.equals("ACKNOWLEDGED") == false) goto L21;
    L20:
        r9 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        r12 = ZeusTransformUtils.mapRes(R.string.proactive_status_adopted_detail, TypedValues.Custom.S_STRING, "proactive_status_adopted_detail");
        goto L22
    L11:
        if (r11.equals("PENDING") == false) goto L21;
        r9 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        r12 = ZeusTransformUtils.mapRes(R.string.proactive_status_recommended, TypedValues.Custom.S_STRING, "proactive_status_recommended");
        goto L22
    L14:
        if (r11.equals("DISMISSED") == false) goto L21;
        r9 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        r12 = ZeusTransformUtils.mapRes(R.string.proactive_status_ignored, TypedValues.Custom.S_STRING, "proactive_status_ignored");
        goto L22
    L18:
        if (r11.equals("EXECUTED") == true) goto L20;
    L24:
        int r0 = r10.getRecommendStatus();
        if (r0 != 0) goto L27;
        Activity r14 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        int r15 = ZeusTransformUtils.mapRes(R.string.proactive_status_not_recommended, TypedValues.Custom.S_STRING, "proactive_status_not_recommended");
    L41:
        String r16 = r14.getString(r15);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");
        return r16;
    L27:
        if (r0 != 1) goto L29;
        r14 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        r15 = ZeusTransformUtils.mapRes(R.string.proactive_status_recommended, TypedValues.Custom.S_STRING, "proactive_status_recommended");
        goto L41
    L29:
        if (r0 == 2) goto L32;
        r14 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        r15 = ZeusTransformUtils.mapRes(R.string.proactive_placeholder, TypedValues.Custom.S_STRING, "proactive_placeholder");
        goto L41
    L32:
        if (d.b(r10) == false) goto L35;
        Activity r17 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        int r18 = ZeusTransformUtils.mapRes(R.string.proactive_status_recommended, TypedValues.Custom.S_STRING, "proactive_status_recommended");
    L34:
        String r19 = r17.getString(r18);
        Intrinsics.checkNotNull(r19);
        return r19;
    L35:
        boolean r110 = d.a(r10);
        Context r20 = ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin");
        if (r110 == false) goto L38;
        r17 = (Activity) ZeusTransformUtils.preCheckCast(r20, Activity.class, "com.obric.memorydata.plugin");
        r18 = ZeusTransformUtils.mapRes(R.string.proactive_status_ignored, TypedValues.Custom.S_STRING, "proactive_status_ignored");
        goto L34
    L38:
        r17 = (Activity) ZeusTransformUtils.preCheckCast(r20, Activity.class, "com.obric.memorydata.plugin");
        r18 = ZeusTransformUtils.mapRes(R.string.proactive_status_adopted_detail, TypedValues.Custom.S_STRING, "proactive_status_adopted_detail");
        goto L34
    }

    private static final void onCreateChecked$lambda$10(RecommendationDetailActivity r1, View r2) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).handleVote(ProactiveVoteStore.Vote.LIKE);
    }

    private static final void onCreateChecked$lambda$11(RecommendationDetailActivity r1, View r2) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).handleVote(ProactiveVoteStore.Vote.DISLIKE);
    }

    private static final void onCreateChecked$lambda$9(RecommendationDetailActivity r1, View r2) {
        ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).getOnBackPressedDispatcher().onBackPressed();
    }

    private final ProactiveRecommendationDto recommendationExtra() {
        int r0 = Build.VERSION.SDK_INT;
        Intent r4 = getIntent();
        if (r0 < 33) goto L5;
        Object r5 = r4.getParcelableExtra("recommendation", ProactiveRecommendationDto.class);
    L7:
        return (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
    L5:
        r5 = r4.getParcelableExtra("recommendation");
        goto L7
    }

    private final void renderValueQuickTabs(ActivityRecommendationDetailBinding r17, Integer r18) {
        int r2 = r17.valueQuickTabs.getSelectedTabPosition();
        if (r18 != null) goto L5;
        Integer r3 = -1;
    L7:
        if (r2 == ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue()) goto L9;
    L11:
        this.suppressValueRatingTabCallback = true;
        r17.valueQuickTabs.d();
        int[] r4 = QUICK_VALUE_LABELS;
        int r5 = r4.length;
        int r7 = 0;
        int r8 = 0;
    L12:
        if (r7 >= r5) goto L28;
        int r9 = r4[r7];
        int r10 = r8 + 1;
        OTabLayout r11 = r17.valueQuickTabs;
        OTabLayoutBase.g r12 = r17.valueQuickTabs.a(0).c(r9);
        StringBuilder r13 = new StringBuilder().append(((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")).getString(r9));
        if (r18 != null) goto L17;
    L19:
        String r14 = "";
    L20:
        OTabLayoutBase.g r15 = r12.b((CharSequence) ZeusTransformUtils.preCheckCast(r13.append(r14).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (r18 != null) goto L24;
    L26:
        boolean r16 = false;
    L27:
        r11.a(r15, r16);
        r7 = r7 + 1;
        r8 = r10;
        goto L12
    L24:
        if (r8 != r18.intValue()) goto L26;
        r16 = true;
        goto L27
    L17:
        if (r8 != r18.intValue()) goto L19;
        r14 = "，已选择";
        goto L20
    L28:
        OTabLayout r6 = r17.valueQuickTabs;
        if (r18 == null) goto L31;
        boolean r19 = true;
    L32:
        r6.setShowSelectedIndicator(Boolean.valueOf(r19));
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.getIndices(QUICK_VALUE_LABELS), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r20.hasNext() == false) goto L44;
        int r21 = ((IntIterator) ZeusTransformUtils.preCheckCast(r20, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        View r22 = r17.valueQuickTabs.f(r21);
        if (r22 == null) goto L34;
        if (r18 != null) goto L40;
    L42:
        boolean r23 = false;
    L43:
        r22.setSelected(r23);
        goto L34
    L40:
        if (r21 != r18.intValue()) goto L42;
        r23 = true;
        goto L43
    L44:
        this.suppressValueRatingTabCallback = false;
        return;
    L31:
        r19 = false;
        goto L32
    L9:
        if (r17.valueQuickTabs.getTabCount() != QUICK_VALUE_LABELS.length) goto L11;
        return;
    L5:
        r3 = r18;
        goto L7
    }

    private final void report(ProactiveRecommendationDto r13, String r14, String r15) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13.getInspirationId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        String r8 = com.obric.aiproactive.ui.detail.b.a(r13, r14);
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append("[DetailPage] report id=").append(r13.getRecommendId()).append(" inspirationId=").append(r13.getInspirationId()).append(" action=").append(r14).append(" persistedAction=").append(r8).append(" userFeedback=");
        if (r15 == null) goto L8;
        int r0 = r15.length();
    L9:
        IRunLog.a.a(r1, TAG, r16.append(r0).toString(), false, 4, null);
        getViewModel().updateInspiration(new ProactiveInspirationDto(r13.getInspirationId(), r13.getTaskId(), r13.getRecommendId(), r13.getRecommendStatus(), r8, r15, r13.getCreated()));
        return;
    L8:
        r0 = 0;
        goto L9
    }

    private final void reportDetailBackClick() {
        h.f6884a.b("proactive_card_detail", "unlock_screen", "collapse_detail");
    }

    private final void reportInlineActionClick() {
        ProactiveRecommendationDto r0 = this.currentDto;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r7 = this.currentRank;
        if (r7 == null) goto L9;
        int r8 = r7.intValue();
        h.f6884a.a("proactive_card_detail", "unlock_screen", "click_button", r0.getRecommendId(), Integer.valueOf(r8));
        return;
    }

    private final void reportValueRating(ProactiveRecommendationDto r12, com.obric.aiproactive.ui.feedback.j r13) {
        Long r14 = com.obric.aiproactive.ui.detail.b.b(r12);
        if (r14 == null) goto L6;
        long r1 = r14.longValue();
        getViewModel().updateAiRecommendationFeedback(new u(r1, null, null, null, null, "original", Integer.valueOf(r13.a()), 30, null));
        return;
    }

    private static final com.obric.aiproactive.ui.data.a repository_delegate$lambda$0() {
        return new com.obric.aiproactive.ui.data.a();
    }

    private final void saveQuickValueRating(int r10) {
        final ProactiveRecommendationDto r2 = this.currentDto;
        if (r2 != null) goto L5;
        return;
    L5:
        com.obric.aiproactive.ui.feedback.j r0 = new com.obric.aiproactive.ui.feedback.j(r10, ProactiveValueAmountSource.PRESET, com.obric.aiproactive.ui.detail.b.a(r2), System.currentTimeMillis());
        if (com.obric.aiproactive.ui.feedback.o.a(ProactiveValueSubmissionTrigger.USER_SUBMIT, r0, new $$Lambda$RecommendationDetailActivity$mv2yPFcGRaKWA95ElXk9VqJ9PEk(this, r2), new $$Lambda$RecommendationDetailActivity$W7C7hVv280N9U6FNQeVFq8i2Ods(r2), new $$Lambda$RecommendationDetailActivity$DoGIG2Le4_5xo1netV7yZZk4Y(this, r2)) != null) goto L11;
        ActivityRecommendationDetailBinding r1 = this.binding;
        if (r1 == null) goto L15;
        bindValueRating$default(this, r1, r2, null, 4, null);
        return;
    L15:
        return;
    L11:
        ActivityRecommendationDetailBinding r11 = this.binding;
        if (r11 == null) goto L16;
        bindValueRating(r11, r2, r0);
        return;
    }

    private static final ProactiveValueSubmitType saveQuickValueRating$lambda$26(RecommendationDetailActivity r2, ProactiveRecommendationDto r3, com.obric.aiproactive.ui.feedback.j r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        return r5.getValueRatingStore().a(r3.getRecommendId(), r4);
    }

    private static final Unit saveQuickValueRating$lambda$27(ProactiveRecommendationDto r7, com.obric.aiproactive.ui.feedback.j r8, ProactiveValueSubmitType r9) {
        Intrinsics.checkNotNullParameter(r8, "savedRating");
        Intrinsics.checkNotNullParameter(r9, "savedSubmitType");
        h.f6884a.b(r7.getRecommendId(), r8.a(), r8.b().getWireValue(), r8.c().getWireValue(), r9.getWireValue());
        return Unit.INSTANCE;
    }

    private static final Unit saveQuickValueRating$lambda$28(RecommendationDetailActivity r2, ProactiveRecommendationDto r3, com.obric.aiproactive.ui.feedback.j r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        r5.reportValueRating(r3, r4);
        return Unit.INSTANCE;
    }

    private final void showValueRatingSheet() {
        final ProactiveRecommendationDto r0 = this.currentDto;
        if (r0 != null) goto L5;
        return;
    L5:
        ActivityRecommendationDetailBinding r1 = this.binding;
        if (r1 == null) goto L8;
        renderValueQuickTabs(r1, null);
    L8:
        getValueRatingSheet().a(r0.getRecommendId(), com.obric.aiproactive.ui.detail.b.a(r0), new $$Lambda$RecommendationDetailActivity$yyM6oY7oIMmDJIHOQPRVMAth4kM(this, r0), new $$Lambda$RecommendationDetailActivity$mywBGvweVO65WGM9h1rBYVBQkc8(this, r0));
    }

    private static final Unit showValueRatingSheet$lambda$22(RecommendationDetailActivity r6, ProactiveRecommendationDto r7) {
        RecommendationDetailActivity r0 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r6, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        ProactiveRecommendationDto r2 = r0.currentDto;
        if (r2 == null) goto L5;
        String r8 = r2.getRecommendId();
    L7:
        if (Intrinsics.areEqual(r8, r7.getRecommendId()) == false) goto L12;
        ActivityRecommendationDetailBinding r1 = r0.binding;
        if (r1 == null) goto L12;
        bindValueRating$default(r0, r1, r2, null, 4, null);
    L12:
        return Unit.INSTANCE;
    L5:
        r8 = null;
        goto L7
    }

    private static final Unit showValueRatingSheet$lambda$24(RecommendationDetailActivity r2, ProactiveRecommendationDto r3, com.obric.aiproactive.ui.feedback.j r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rating");
        ActivityRecommendationDetailBinding r0 = r5.binding;
        if (r0 == null) goto L5;
        r5.bindValueRating(r0, r3, r4);
    L5:
        r5.reportValueRating(r3, r4);
        return Unit.INSTANCE;
    }

    private static final String sourcePage_delegate$lambda$3(RecommendationDetailActivity r2) {
        String r3 = ((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).getIntent().getStringExtra(EXTRA_SOURCE_PAGE);
        if (r3 != null) goto L6;
        return "home";
    L6:
        return r3;
    }

    private final void submitContinueAction(ProactiveRecommendationDto r16, int r17, com.obric.aiproactive.api.b r18) {
        if (r18.i() == true) goto L5;
        return;
    L5:
        String r3 = r16.getRecommendId();
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10491(this, r3, r18, r17, r16, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void updateRecommendStatusToAdopted(ProactiveRecommendationDto r11) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.getInspirationId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[DetailPage] updateRecommendStatusToAdopted id=" + r11.getRecommendId() + " inspirationId=" + r11.getInspirationId(), false, 4, null);
        BaseProactiveFeedViewModel r10 = getViewModel();
        String r1 = r11.getInspirationId();
        String r2 = r11.getTaskId();
        String r3 = r11.getRecommendId();
        String r0 = r11.getInspirationFeedbackAction();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        r10.updateInspiration(new ProactiveInspirationDto(r1, r2, r3, 2, r0, r11.getInspirationUserFeedback(), r11.getCreated()));
    }

    private static final com.obric.aiproactive.ui.feedback.l valueRatingSheet_delegate$lambda$7(RecommendationDetailActivity r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r4, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        return new com.obric.aiproactive.ui.feedback.l((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), r5.getValueRatingStore());
    }

    private static final n valueRatingStore_delegate$lambda$6(RecommendationDetailActivity r3) {
        return new n((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendationDetailActivity.class, "com.obric.memorydata.plugin")).getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, 2, null);
    }

    private static final ProactiveFeedPageViewModelFactory viewModelFactory_delegate$lambda$2(RecommendationDetailActivity r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r4, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getApplicationContext(...)");
        return new ProactiveFeedPageViewModelFactory(r2, (com.obric.aiproactive.ui.data.b) ZeusTransformUtils.preCheckCast(r5.getRepository(), com.obric.aiproactive.ui.data.b.class, "com.obric.memorydata.plugin"), $$Lambda$RecommendationDetailActivity$riEAf7ZyztYkkw_qhbUYUxsN8.INSTANCE);
    }

    private static final long viewModelFactory_delegate$lambda$2$lambda$1() {
        return System.currentTimeMillis();
    }

    private static final BaseProactiveFeedViewModel viewModel_delegate$lambda$4(RecommendationDetailActivity r4) {
        RecommendationDetailActivity r5 = (RecommendationDetailActivity) ZeusTransformUtils.wrapperContextForParams(r4, RecommendationDetailActivity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5.getSourcePage(), "proactive_all") == false) goto L5;
        ViewModelProvider r0 = new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r5, ViewModelStoreOwner.class, "com.obric.memorydata.plugin"), (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(r5.getViewModelFactory(), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin"));
        GenericDeclaration r6 = AllFeedViewModel.class;
    L7:
        return (BaseProactiveFeedViewModel) ZeusTransformUtils.preCheckCast(r0.get(r6), BaseProactiveFeedViewModel.class, "com.obric.memorydata.plugin");
    L5:
        r0 = new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r5, ViewModelStoreOwner.class, "com.obric.memorydata.plugin"), (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(r5.getViewModelFactory(), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin"));
        r6 = NowFeedViewModel.class;
        goto L7
    }

    public void finish() {
        super.finish();
        com.obric.memorydata.ui.h.f13009a.d((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onCreateChecked(Bundle r13) {
        com.obric.memorydata.ui.h.f13009a.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        boolean r0 = false;
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        AiProactiveUiModeController r14 = AiProactiveUiModeController.f6869a;
        Configuration r2 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r2, "getConfiguration(...)");
        boolean r15 = !r14.b(r2);
        WindowInsetsControllerCompat r3 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        r3.setAppearanceLightStatusBars(r15);
        r3.setAppearanceLightNavigationBars(r15);
        ActivityRecommendationDetailBinding r16 = ActivityRecommendationDetailBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r16, "inflate(...)");
        this.binding = r16;
        setContentView((View) ZeusTransformUtils.preCheckCast(r16.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ONestedScrollView r4 = r16.scrollContent;
        Intrinsics.checkNotNullExpressionValue(r4, "scrollContent");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        OFloatingTitleBar r5 = r16.titleBar;
        Intrinsics.checkNotNullExpressionValue(r5, "titleBar");
        registerFloatingTitleBar(r5);
        String r6 = "";
        r16.titleBar.setCenterTitle("");
        OFloatingTitleBar.a(r16.titleBar, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$RecommendationDetailActivity$JIyAest1g4nfOnNGh6TVz9Aug(this), 2, null).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.proactive_back, TypedValues.Custom.S_STRING, "proactive_back")), CharSequence.class, "com.obric.memorydata.plugin"));
        View r7 = r16.titleBar.getEndButtonGroup().a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.item_proactive_detail_feedback_like, "layout", "item_proactive_detail_feedback_like"));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.button.OIconButton");
        this.likeButton = (OIconButton) ZeusTransformUtils.preCheckCast(r7, OIconButton.class, "com.obric.memorydata.plugin");
        View r8 = r16.titleBar.getEndButtonGroup().a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.item_proactive_detail_feedback_dislike, "layout", "item_proactive_detail_feedback_dislike"));
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.oui.button.OIconButton");
        this.dislikeButton = (OIconButton) ZeusTransformUtils.preCheckCast(r8, OIconButton.class, "com.obric.memorydata.plugin");
        OIconButton r9 = this.likeButton;
        if (r9 == null) goto L5;
        r9.setOnClickListener(new $$Lambda$RecommendationDetailActivity$0SEW1kRzcLsAkpLkEso3yicV1dA(this));
    L5:
        OIconButton r10 = this.dislikeButton;
        if (r10 == null) goto L8;
        r10.setOnClickListener(new $$Lambda$RecommendationDetailActivity$HJbkfMg7ynnxBF5SD998zWTdheY(this));
    L8:
        bindBackNavigation();
        bindScrollTracking(r16);
        bindValueRatingActions(r16);
        String r11 = getIntent().getStringExtra(EXTRA_ENTER_FROM);
        if (r11 != null) goto L11;
        r11 = "desktop_icon";
    L11:
        int r12 = getIntent().getIntExtra(EXTRA_RANK, Integer.MIN_VALUE);
        String r17 = getSourcePage();
        Integer r18 = Integer.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue() != Integer.MIN_VALUE) goto L14;
        r0 = true;
    L14:
        if (r0 == false) goto L17;
        r18 = null;
    L17:
        com.obric.aiproactive.ui.util.f r1 = com.obric.aiproactive.ui.util.n.a(r11, r17, r18);
        this.currentRank = r1.b();
        ProactiveRecommendationDto r19 = recommendationExtra();
        String r20 = getIntent().getStringExtra(EXTRA_INSPIRATION_ID);
        if (r20 == null) goto L20;
        String r21 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L21:
        if (r21 != null) goto L23;
        r21 = "";
    L23:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r22) == false) goto L32;
        if (r19 == null) goto L27;
        String r23 = r19.getInspirationId();
    L28:
        if (r23 == null) goto L31;
        r6 = r23;
    L31:
        r22 = r6;
        goto L32
    L27:
        r23 = null;
    L32:
        String r24 = (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L36;
        this.currentDto = r19;
        bindDto(r16, r19);
    L36:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L39;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[DetailPage] finish: blank inspirationId", null, 4, null);
        finish();
        return;
    L39:
        getViewModel().startIfNeeded();
        getViewModel().selectInspiration(r24);
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        h.f6884a.b("proactive_card_detail", r1.a(), r11, "click");
        return;
    L20:
        r21 = null;
        goto L21
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        ActivityRecommendationDetailBinding r0 = this.binding;
        if (r0 == null) goto L8;
        Runnable r2 = this.scrollIdleRunnable;
        if (r2 == null) goto L7;
        r0.scrollContent.removeCallbacks(r2);
    L7:
        r0.scrollContent.setOnTouchListener(null);
        r0.scrollContent.setOnScrollChangeListener(null);
    L8:
        this.scrollIdleRunnable = null;
        this.userScrollInProgress = false;
        this.userScrollObserved = false;
        this.likeButton = null;
        this.dislikeButton = null;
        this.currentDto = null;
        this.binding = null;
        super.onDestroy();
    }
}
