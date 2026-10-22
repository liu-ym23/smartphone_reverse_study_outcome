package com.obric.aiproactive.ui.progress;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.ui.databinding.ActivityAgentRunDetailBinding;
import com.obric.aiproactive.ui.entry.BaseProactiveActivity;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n*\u0001%\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020(H\u0014J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020+H\u0016J\u0012\u0010/\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u00101\u001a\u00020+H\u0002J\u0012\u00102\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020-H\u0014J\u0016\u00108\u001a\u00020+2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u001eH\u0002J\u0018\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020(H\u0002J\u0012\u0010>\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010?\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020(H\u0002J\u0010\u0010D\u001a\u00020+2\u0006\u0010E\u001a\u00020(H\u0002J\b\u0010F\u001a\u00020+H\u0002J\u001a\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020(2\b\b\u0002\u0010I\u001a\u00020(H\u0002J\b\u0010J\u001a\u00020+H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006L"}, d2 = {"Lcom/obric/aiproactive/ui/progress/ProactiveAgentRunActivity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "<init>", "()V", "binding", "Lcom/obric/aiproactive/ui/databinding/ActivityAgentRunDetailBinding;", "repository", "Lcom/obric/aiproactive/ui/data/DefaultProactiveRepository;", "getRepository", "()Lcom/obric/aiproactive/ui/data/DefaultProactiveRepository;", "repository$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/obric/aiproactive/ui/progress/AgentRunStepAdapter;", "mobileUsePlayerProviderClient", "Lcom/obric/aiproactive/ui/progress/MobileUsePlayerProviderClient;", "getMobileUsePlayerProviderClient", "()Lcom/obric/aiproactive/ui/progress/MobileUsePlayerProviderClient;", "mobileUsePlayerProviderClient$delegate", "mobileUseNavigationGate", "Lcom/obric/aiproactive/ui/progress/MobileUseNavigationGate;", "Lcom/obric/aiproactive/ui/progress/MobileUsePlayerTarget;", "mobileUseResolutionJob", "Lkotlinx/coroutines/Job;", "mobileUseLaunchJob", "latestRun", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "latestControlState", "Lcom/obric/aiproactive/api/AiProactiveAgentRunControlState;", "latestRecommendations", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "stoppingExecutionId", "", "expansionPolicyState", "Lcom/obric/aiproactive/ui/progress/AgentRunExpansionPolicyState;", "headerTicker", "com/obric/aiproactive/ui/progress/ProactiveAgentRunActivity$headerTicker$1", "Lcom/obric/aiproactive/ui/progress/ProactiveAgentRunActivity$headerTicker$1;", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "renderRun", "run", "renderRecommendations", "resolveMobileUsePlayer", "openMobileUsePlayer", "rowBinding", "Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;", "onSaveInstanceState", "outState", "reconcileAutomaticExpansion", "steps", "Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "onUserExpansionChanged", "stepId", "expanded", "renderHeader", "renderControls", "bindStatusAction", "action", "Lcom/obric/aiproactive/ui/progress/AgentRunStatusAction;", "stopping", "updateRunListBottomPadding", "showControls", "stopRun", "setControlsEnabled", "enabled", "statusActionVisible", "onDestroy", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveAgentRunActivity extends BaseProactiveActivity {
    public static final a Companion = null;
    public static final String EXTRA_EXECUTION_ID = "ai_proactive_agent_execution_id";
    public static final long HEADER_TICK_INTERVAL_MS = 1000;
    public static final int RUN_LIST_BOTTOM_PADDING_DP = 32;
    public static final int RUN_LIST_CONTROL_BOTTOM_PADDING_DP = 80;
    public static final String STATE_AUTO_EXPANDED_STEP_IDS = "ai_proactive_agent_run_auto_expanded_steps";
    public static final String STATE_AUTO_HANDLED_STEP_IDS = "ai_proactive_agent_run_auto_handled_steps";
    public static final String STATE_EXPANDED_STEP_IDS = "ai_proactive_agent_run_expanded_steps";
    public static final String STATE_MANUALLY_CONTROLLED_STEP_IDS = "ai_proactive_agent_run_manually_controlled_steps";
    public static final int STATUS_ACTION_ICON_GAP_DP = 6;
    private final h adapter;
    private ActivityAgentRunDetailBinding binding;
    private f expansionPolicyState;
    private final c headerTicker;
    private com.obric.aiproactive.api.e latestControlState;
    private List<ProactiveRecommendationDto> latestRecommendations;
    private com.obric.aiproactive.api.g latestRun;
    private bx mobileUseLaunchJob;
    private final u<y> mobileUseNavigationGate;
    private final Lazy mobileUsePlayerProviderClient$delegate;
    private bx mobileUseResolutionJob;
    private final Lazy repository$delegate;
    private String stoppingExecutionId;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/ui/progress/ProactiveAgentRunActivity$Companion;", "", "<init>", "()V", "EXTRA_EXECUTION_ID", "", "HEADER_TICK_INTERVAL_MS", "", "RUN_LIST_BOTTOM_PADDING_DP", "", "RUN_LIST_CONTROL_BOTTOM_PADDING_DP", "STATUS_ACTION_ICON_GAP_DP", "STATE_EXPANDED_STEP_IDS", "STATE_AUTO_EXPANDED_STEP_IDS", "STATE_AUTO_HANDLED_STEP_IDS", "STATE_MANUALLY_CONTROLLED_STEP_IDS", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6791a = null;

        static {
            int[] r0 = new int[AgentRunStatusAction.values().length];
            r0[AgentRunStatusAction.STOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[AgentRunStatusAction.COMPLETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[AgentRunStatusAction.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[AgentRunStatusAction.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[AgentRunStatusAction.HIDDEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f6791a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/aiproactive/ui/progress/ProactiveAgentRunActivity$headerTicker$1", "Ljava/lang/Runnable;", "run", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProactiveAgentRunActivity f6792a;

        c(ProactiveAgentRunActivity r3) {
            this.f6792a = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ProactiveAgentRunActivity.access$getBinding$p(this.f6792a) != null) goto L5;
            return;
        L5:
            com.obric.aiproactive.api.g r0 = ProactiveAgentRunActivity.access$getLatestRun$p(this.f6792a);
            if (r0 != null) goto L8;
            return;
        L8:
            ProactiveAgentRunActivity.access$renderHeader(this.f6792a, r0);
            if (Intrinsics.areEqual(r0.c(), "running") == false) goto L11;
        L12:
            ActivityAgentRunDetailBinding r1 = ProactiveAgentRunActivity.access$getBinding$p(this.f6792a);
            if (r1 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r1 = null;
        L15:
            r1.titleBar.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), 1000);
            return;
        L11:
            if (Intrinsics.areEqual(r0.c(), "waiting") == true) goto L12;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5", f = "ProactiveAgentRunActivity.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ProactiveAgentRunActivity this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1", f = "ProactiveAgentRunActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProactiveAgentRunActivity this$0;

            /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1$1", f = "ProactiveAgentRunActivity.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
            static final class C03111 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ ProactiveAgentRunActivity this$0;

                /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                /* synthetic */ class C03121 extends AdaptedFunctionReference implements SuspendFunction, Function2<com.obric.aiproactive.api.g, Continuation<? super Unit>, Object> {
                    C03121(Object r8) {
                        super(2, r8, ProactiveAgentRunActivity.class, "renderRun", "renderRun(Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;)V", 4);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(com.obric.aiproactive.api.g r3, Continuation<? super Unit> r4) {
                        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                        return C03111.access$invokeSuspend$renderRun((ProactiveAgentRunActivity) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin"), r3, r5);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Object invoke(com.obric.aiproactive.api.g r3, Continuation<? super Unit> r4) {
                        return invoke2((com.obric.aiproactive.api.g) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.g.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                    }
                }

                C03111(ProactiveAgentRunActivity r3, Continuation<? super C03111> r4) {
                    ProactiveAgentRunActivity r5 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r5;
                    super(2, r6);
                }

                public static final /* synthetic */ Object access$invokeSuspend$renderRun(ProactiveAgentRunActivity r2, com.obric.aiproactive.api.g r3, Continuation r4) {
                    return invokeSuspend$renderRun((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin"), r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                private static final /* synthetic */ Object invokeSuspend$renderRun(ProactiveAgentRunActivity r2, com.obric.aiproactive.api.g r3, Continuation r4) {
                    ProactiveAgentRunActivity r5 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    ProactiveAgentRunActivity.access$renderRun(r5, r3);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                    return (Continuation) ZeusTransformUtils.preCheckCast(new C03111(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                    return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                    return ((C03111) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C03111.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r6) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    ResultKt.throwOnFailure(r6);
                L19:
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r6);
                    String r7 = this.this$0.getIntent().getStringExtra(ProactiveAgentRunActivity.EXTRA_EXECUTION_ID);
                    if (r7 != null) goto L12;
                    r7 = "";
                L12:
                    if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L14;
                    kotlinx.coroutines.flow.i<com.obric.aiproactive.api.g> r8 = ProactiveAgentRunActivity.access$getRepository(this.this$0).c();
                L15:
                    Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C03121(this.this$0), Function2.class, "com.obric.memorydata.plugin");
                    Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                    this.label = 1;
                    if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L19;
                    return r0;
                L14:
                    r8 = ProactiveAgentRunActivity.access$getRepository(this.this$0).a(r7);
                    goto L15
                }
            }

            /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1$2", f = "ProactiveAgentRunActivity.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ ProactiveAgentRunActivity this$0;

                /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1$2$1, reason: invalid class name and collision with other inner class name */
                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "recommendations", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$onCreateChecked$5$1$2$1", f = "ProactiveAgentRunActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C03131 extends SuspendLambda implements Function2<List<? extends ProactiveRecommendationDto>, Continuation<? super Unit>, Object> {
                    /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ ProactiveAgentRunActivity this$0;

                    C03131(ProactiveAgentRunActivity r3, Continuation<? super C03131> r4) {
                        ProactiveAgentRunActivity r5 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
                        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                        this.this$0 = r5;
                        super(2, r6);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                        C03131 r0 = new C03131(this.this$0, r5);
                        r0.L$0 = r3;
                        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Object invoke(List<? extends ProactiveRecommendationDto> r3, Continuation<? super Unit> r4) {
                        return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(List<ProactiveRecommendationDto> r3, Continuation<? super Unit> r4) {
                        return ((C03131) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C03131.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object r3) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) goto L7;
                        ResultKt.throwOnFailure(r3);
                        List r4 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
                        ProactiveAgentRunActivity.access$setLatestRecommendations$p(this.this$0, r4);
                        ProactiveAgentRunActivity.access$renderRecommendations(this.this$0);
                        return Unit.INSTANCE;
                    L7:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                AnonymousClass2(ProactiveAgentRunActivity r3, Continuation<? super AnonymousClass2> r4) {
                    ProactiveAgentRunActivity r5 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
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
                public final Object invokeSuspend(Object r6) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    ResultKt.throwOnFailure(r6);
                L12:
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r6);
                    kotlinx.coroutines.flow.i<List<ProactiveRecommendationDto>> r7 = ProactiveAgentRunActivity.access$getRepository(this.this$0).e();
                    Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C03131(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
                    Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                    this.label = 1;
                    if (kotlinx.coroutines.flow.k.a(r7, r2, r3) != r0) goto L12;
                    return r0;
                }
            }

            AnonymousClass1(ProactiveAgentRunActivity r3, Continuation<? super AnonymousClass1> r4) {
                ProactiveAgentRunActivity r5 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
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
            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r10);
                al r11 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
                kotlinx.coroutines.i.a(r11, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C03111(this.this$0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
                kotlinx.coroutines.i.a(r11, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass5(ProactiveAgentRunActivity r3, Continuation<? super AnonymousClass5> r4) {
            ProactiveAgentRunActivity r5 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
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

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$openMobileUsePlayer$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$openMobileUsePlayer$1", f = "ProactiveAgentRunActivity.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ t $attempt;
        int label;
        final /* synthetic */ ProactiveAgentRunActivity this$0;

        AnonymousClass1(t r3, ProactiveAgentRunActivity r4, Continuation<? super AnonymousClass1> r5) {
            ProactiveAgentRunActivity r6 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r4, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$attempt = r3;
            this.this$0 = r6;
            super(2, r7);
        }

        private static final void invokeSuspend$lambda$0(ProactiveAgentRunActivity r2) {
            ProactiveAgentRunActivity r3 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
            ProactiveAgentRunActivity.access$resolveMobileUsePlayer(r3, ProactiveAgentRunActivity.access$getLatestRun$p(r3));
        }

        /* JADX INFO: renamed from: lambda$7NovQAu-Zn3GPsQXi_jvz-tTdYI, reason: not valid java name */
        public static /* synthetic */ void m335lambda$7NovQAuZn3GPsQXi_jvztTdYI(ProactiveAgentRunActivity r0) {
            invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$attempt, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            ActivityAgentRunDetailBinding r5 = null;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
        L25:
            y r9 = (y) ZeusTransformUtils.preCheckCast(r8, y.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (w.a(this.$attempt.a(), ProactiveAgentRunActivity.access$getLatestRun$p(this.this$0)) == true) goto L33;
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).b(this.$attempt);
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a(this.$attempt);
            ProactiveAgentRunActivity.access$getAdapter$p(this.this$0).a(ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a());
            ActivityAgentRunDetailBinding r2 = ProactiveAgentRunActivity.access$getBinding$p(this.this$0);
            if (r2 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L32:
            RecyclerView r3 = r5.recyclerSteps;
            final ProactiveAgentRunActivity r7 = this.this$0;
            Runnable r4 = new $$Lambda$ProactiveAgentRunActivity$openMobileUsePlayer$1$7NovQAuZn3GPsQXi_jvztTdYI(r7);
        L20:
            r3.post(r4);
            return r10;
        L31:
            r5 = r2;
            goto L32
        L33:
            y r11 = (y) ZeusTransformUtils.preCheckCast(ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a(this.$attempt, r9), y.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (r11 != null) goto L57;
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a(this.$attempt.a());     // Catch: Throwable -> L7
            r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).b(this.$attempt);
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a(this.$attempt);
            ProactiveAgentRunActivity.access$getAdapter$p(this.this$0).a(ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a());
            ActivityAgentRunDetailBinding r6 = ProactiveAgentRunActivity.access$getBinding$p(this.this$0);
            if (r6 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L40:
            r3 = r5.recyclerSteps;
            final ProactiveAgentRunActivity r12 = this.this$0;
            r4 = new $$Lambda$ProactiveAgentRunActivity$openMobileUsePlayer$1$7NovQAuZn3GPsQXi_jvztTdYI(r12);
            goto L20
        L39:
            r5 = r6;
            goto L40
        L57:
            r11.a().send();     // Catch: Throwable -> L7 PendingIntent.CanceledException -> L43
        L44:
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).b(this.$attempt);
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a(this.$attempt);
            ProactiveAgentRunActivity.access$getAdapter$p(this.this$0).a(ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a());
            ActivityAgentRunDetailBinding r13 = ProactiveAgentRunActivity.access$getBinding$p(this.this$0);
            if (r13 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L48:
            RecyclerView r14 = r5.recyclerSteps;
            final ProactiveAgentRunActivity r15 = this.this$0;
            r14.post(new $$Lambda$ProactiveAgentRunActivity$openMobileUsePlayer$1$7NovQAuZn3GPsQXi_jvztTdYI(r15));
            return Unit.INSTANCE;
        L47:
            r5 = r13;
            goto L48
        L43:
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a(this.$attempt.a());     // Catch: Throwable -> L7
            goto L44
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r8);
            if (w.a(this.$attempt.a(), ProactiveAgentRunActivity.access$getLatestRun$p(this.this$0)) == true) goto L22;
            r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).b(this.$attempt);
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a(this.$attempt);
            ProactiveAgentRunActivity.access$getAdapter$p(this.this$0).a(ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a());
            ActivityAgentRunDetailBinding r16 = ProactiveAgentRunActivity.access$getBinding$p(this.this$0);
            if (r16 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L19:
            r3 = r5.recyclerSteps;
            final ProactiveAgentRunActivity r17 = this.this$0;
            r4 = new $$Lambda$ProactiveAgentRunActivity$openMobileUsePlayer$1$7NovQAuZn3GPsQXi_jvztTdYI(r17);
            goto L20
        L18:
            r5 = r16;
            goto L19
        L22:
            CoroutineContext r18 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            Function2 r19 = (Function2) ZeusTransformUtils.preCheckCast(new ProactiveAgentRunActivity$openMobileUsePlayer$1$freshTarget$1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            Continuation r20 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r8 = kotlinx.coroutines.i.a(r18, r19, r20);     // Catch: Throwable -> L7
            if (r8 != r0) goto L25;
            return r0;
        L7:
            th = move-exception;
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).b(this.$attempt);
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a(this.$attempt);
            ProactiveAgentRunActivity.access$getAdapter$p(this.this$0).a(ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a());
            ActivityAgentRunDetailBinding r21 = ProactiveAgentRunActivity.access$getBinding$p(this.this$0);
            if (r21 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L54:
            RecyclerView r22 = r5.recyclerSteps;
            final ProactiveAgentRunActivity r23 = this.this$0;
            r22.post(new $$Lambda$ProactiveAgentRunActivity$openMobileUsePlayer$1$7NovQAuZn3GPsQXi_jvztTdYI(r23));
            throw th;
        L53:
            r5 = r21;
            goto L54
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$resolveMobileUsePlayer$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$resolveMobileUsePlayer$1", f = "ProactiveAgentRunActivity.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
    static final class C10681 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ z $currentBinding;
        int label;
        final /* synthetic */ ProactiveAgentRunActivity this$0;

        C10681(ProactiveAgentRunActivity r3, z r4, Continuation<? super C10681> r5) {
            ProactiveAgentRunActivity r6 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$currentBinding = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10681(this.this$0, this.$currentBinding, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10681) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10681.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            y r8 = (y) ZeusTransformUtils.preCheckCast(r7, y.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(w.a(ProactiveAgentRunActivity.access$getLatestRun$p(this.this$0)), this.$currentBinding) == false) goto L14;
            ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).update(this.$currentBinding, r8);
            ProactiveAgentRunActivity.access$getAdapter$p(this.this$0).a(ProactiveAgentRunActivity.access$getMobileUseNavigationGate$p(this.this$0).a());
            return Unit.INSTANCE;
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new ProactiveAgentRunActivity$resolveMobileUsePlayer$1$target$1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r7 = kotlinx.coroutines.i.a(r9, r2, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$stopRun$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity$stopRun$1", f = "ProactiveAgentRunActivity.kt", i = {}, l = {457}, m = "invokeSuspend", n = {}, s = {})
    static final class C10691 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $executionId;
        int label;
        final /* synthetic */ ProactiveAgentRunActivity this$0;

        C10691(ProactiveAgentRunActivity r3, String r4, Continuation<? super C10691> r5) {
            ProactiveAgentRunActivity r6 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$executionId = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10691(this.this$0, this.$executionId, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10691) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10691.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L18;
            ProactiveAgentRunActivity.access$setStoppingExecutionId$p(this.this$0, null);
            ActivityAgentRunDetailBinding r14 = ProactiveAgentRunActivity.access$getBinding$p(this.this$0);
            if (r14 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r14 = null;
        L16:
            r14.btnStop.setText(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_run_stop, TypedValues.Custom.S_STRING, "ai_proactive_agent_run_stop"));
            ProactiveAgentRunActivity.setControlsEnabled$default(this.this$0, true, false, 2, null);
            com.obric.oui.toast.a.C0786a r6 = com.obric.oui.toast.a.f14807a;
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin");
            String r8 = this.this$0.getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_run_stop_failed, TypedValues.Custom.S_STRING, "ai_proactive_agent_run_stop_failed"));
            Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
            com.obric.oui.toast.a.C0786a.a(r6, r7, r8, 0, 4, null);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            com.obric.aiproactive.ui.data.a r15 = ProactiveAgentRunActivity.access$getRepository(this.this$0);
            String r2 = this.$executionId;
            Continuation<? super Boolean> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r13 = r15.a(r2, r4);
            if (r13 != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public ProactiveAgentRunActivity() {
        this.repository$delegate = LazyKt.lazy($$Lambda$ProactiveAgentRunActivity$qcnot3heWXUFtBTyPX97jYmJRFM.INSTANCE);
        this.adapter = new h((Function1) ZeusTransformUtils.preCheckCast(new ProactiveAgentRunActivity$adapter$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new ProactiveAgentRunActivity$adapter$2(this), Function2.class, "com.obric.memorydata.plugin"));
        this.mobileUsePlayerProviderClient$delegate = LazyKt.lazy(new $$Lambda$ProactiveAgentRunActivity$ez_TDPb974Devqo8JlDMHeBEAKc(this));
        this.mobileUseNavigationGate = new u();
        this.latestControlState = new com.obric.aiproactive.api.e(null, false, 3, null);
        this.latestRecommendations = CollectionsKt.emptyList();
        this.expansionPolicyState = new f(null, null, null, 7, null);
        this.headerTicker = new c(this);
    }

    public static final /* synthetic */ h access$getAdapter$p(ProactiveAgentRunActivity r2) {
        return ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).adapter;
    }

    public static final /* synthetic */ ActivityAgentRunDetailBinding access$getBinding$p(ProactiveAgentRunActivity r2) {
        return ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ com.obric.aiproactive.api.g access$getLatestRun$p(ProactiveAgentRunActivity r2) {
        return ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).latestRun;
    }

    public static final /* synthetic */ u access$getMobileUseNavigationGate$p(ProactiveAgentRunActivity r2) {
        return ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).mobileUseNavigationGate;
    }

    public static final /* synthetic */ v access$getMobileUsePlayerProviderClient(ProactiveAgentRunActivity r2) {
        return ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).getMobileUsePlayerProviderClient();
    }

    public static final /* synthetic */ com.obric.aiproactive.ui.data.a access$getRepository(ProactiveAgentRunActivity r2) {
        return ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).getRepository();
    }

    public static final /* synthetic */ void access$onUserExpansionChanged(ProactiveAgentRunActivity r2, String r3, boolean r4) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).onUserExpansionChanged(r3, r4);
    }

    public static final /* synthetic */ void access$openMobileUsePlayer(ProactiveAgentRunActivity r2, z r3) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).openMobileUsePlayer(r3);
    }

    public static final /* synthetic */ void access$renderHeader(ProactiveAgentRunActivity r2, com.obric.aiproactive.api.g r3) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).renderHeader(r3);
    }

    public static final /* synthetic */ void access$renderRecommendations(ProactiveAgentRunActivity r2) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).renderRecommendations();
    }

    public static final /* synthetic */ void access$renderRun(ProactiveAgentRunActivity r2, com.obric.aiproactive.api.g r3) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).renderRun(r3);
    }

    public static final /* synthetic */ void access$resolveMobileUsePlayer(ProactiveAgentRunActivity r2, com.obric.aiproactive.api.g r3) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).resolveMobileUsePlayer(r3);
    }

    public static final /* synthetic */ void access$setLatestRecommendations$p(ProactiveAgentRunActivity r2, List r3) {
        ProactiveAgentRunActivity r4 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
        r4.latestRecommendations = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setStoppingExecutionId$p(ProactiveAgentRunActivity r2, String r3) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).stoppingExecutionId = r3;
    }

    private final void bindStatusAction(AgentRunStatusAction r8, boolean r9) {
        int r0 = b.f6791a[r8.ordinal()];
        boolean r1 = true;
        if (r0 == 1) goto L19;
        if (r0 != 2) goto L7;
        ac r2 = new ac(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_run_completed, TypedValues.Custom.S_STRING, "ai_proactive_agent_run_completed"), ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_checkmark_circle, "drawable", "oui_icon_oic_checkmark_circle"), ZeusTransformUtils.mapRes(R.color.ai_proactive_agent_success, TypedValues.Custom.S_COLOR, "ai_proactive_agent_success"));
    L23:
        ActivityAgentRunDetailBinding r7 = this.binding;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L26:
        OButton r10 = r7.btnStop;
        r10.setText(r2.a());
        int r3 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2.c());
        r10.setTextColor(r3);
        Drawable r4 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2.b());
        if (r4 == null) goto L29;
        Drawable r5 = r4.mutate();
    L30:
        if (r5 == null) goto L32;
        DrawableCompat.setTint(r5, r3);
    L32:
        r10.setCompoundDrawablesRelativeWithIntrinsicBounds(r5, null, null, null);
        r10.setCompoundDrawableTintList(ColorStateList.valueOf(r3));
        r10.setCompoundDrawablePadding((int) (6 * ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getDisplayMetrics().density));
        if (r8 != AgentRunStatusAction.STOP) goto L36;
        if (r9 == true) goto L36;
    L37:
        r10.setClickable(r1);
        r10.setFocusable(r10.isClickable());
        return;
    L36:
        r1 = false;
        goto L37
    L29:
        r5 = null;
        goto L30
    L7:
        if (r0 != 3) goto L9;
        r2 = new ac(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_run_failed, TypedValues.Custom.S_STRING, "ai_proactive_agent_run_failed"), ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_xmark_circle, "drawable", "oui_icon_oic_xmark_circle"), ZeusTransformUtils.mapRes(R.color.ai_proactive_agent_error, TypedValues.Custom.S_COLOR, "ai_proactive_agent_error"));
        goto L23
    L9:
        if (r0 != 4) goto L11;
        r2 = new ac(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_run_stopped, TypedValues.Custom.S_STRING, "ai_proactive_agent_run_stopped"), ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_minus_circle, "drawable", "oui_icon_oic_minus_circle"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_secondary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_secondary"));
        goto L23
    L11:
        if (r0 != 5) goto L14;
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L19:
        if (r9 == false) goto L21;
        int r6 = R.string.ai_proactive_agent_run_stopping;
        String r11 = "ai_proactive_agent_run_stopping";
    L22:
        r2 = new ac(ZeusTransformUtils.mapRes(r6, TypedValues.Custom.S_STRING, r11), ZeusTransformUtils.mapRes(R.drawable.oui_icon_oic_square_circle, "drawable", "oui_icon_oic_square_circle"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_primary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_primary"));
        goto L23
    L21:
        r6 = R.string.ai_proactive_agent_run_stop;
        r11 = "ai_proactive_agent_run_stop";
        goto L22
    }

    private final v getMobileUsePlayerProviderClient() {
        return (v) ZeusTransformUtils.preCheckCast(this.mobileUsePlayerProviderClient$delegate.getValue(), v.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.aiproactive.ui.data.a getRepository() {
        return (com.obric.aiproactive.ui.data.a) ZeusTransformUtils.preCheckCast(this.repository$delegate.getValue(), com.obric.aiproactive.ui.data.a.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$YRzsPXLEW4oYuVQ5SbJFJKlMND4(ProactiveAgentRunActivity r0, View r1) {
        onCreateChecked$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ v lambda$ez_TDPb974Devqo8JlDMHeBEAKc(ProactiveAgentRunActivity r0) {
        return mobileUsePlayerProviderClient_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$gTMLEpa_Qzr-DPw9gLwRzU8W_JE, reason: not valid java name */
    public static /* synthetic */ void m334lambda$gTMLEpa_QzrDPw9gLwRzU8W_JE(ProactiveAgentRunActivity r0, View r1) {
        onCreateChecked$lambda$6(r0, r1);
    }

    public static /* synthetic */ com.obric.aiproactive.ui.data.a lambda$qcnot3heWXUFtBTyPX97jYmJRFM() {
        return repository_delegate$lambda$0();
    }

    private static final v mobileUsePlayerProviderClient_delegate$lambda$1(ProactiveAgentRunActivity r3) {
        return new v((Context) ZeusTransformUtils.preCheckCast((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private static final void onCreateChecked$lambda$4$lambda$3(ProactiveAgentRunActivity r1, View r2) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r1, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).getOnBackPressedDispatcher().onBackPressed();
    }

    private static final void onCreateChecked$lambda$6(ProactiveAgentRunActivity r1, View r2) {
        ((ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r1, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin")).stopRun();
    }

    private final void onUserExpansionChanged(String r2, boolean r3) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        this.expansionPolicyState = this.expansionPolicyState.a(r2);
    }

    private final void openMobileUsePlayer(z r10) {
        z r0 = w.a(this.latestRun);
        t r11 = this.mobileUseNavigationGate.a(r10, r0);
        if (r11 != null) goto L5;
        return;
    L5:
        this.adapter.a(null);
        this.mobileUseLaunchJob = kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r11, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void reconcileAutomaticExpansion(List<n> r6) {
        d r7 = e.a((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"), this.adapter.a(), this.expansionPolicyState);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        this.adapter.a(r2, false);
        goto L4
    L6:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        this.adapter.a(r3, true);
        goto L8
    L10:
        this.expansionPolicyState = r7.c();
    }

    private final void renderControls(com.obric.aiproactive.api.g r9) {
        int r1 = 8;
        boolean r2 = false;
        ActivityAgentRunDetailBinding r3 = null;
        if (r9 != null) goto L11;
        ProactiveAgentRunActivity r8 = (ProactiveAgentRunActivity) ZeusTransformUtils.preCheckCast(this, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
        r8.latestControlState = new com.obric.aiproactive.api.e(null, false, 3, null);
        r8.stoppingExecutionId = null;
        ActivityAgentRunDetailBinding r10 = r8.binding;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L8:
        r3.runControls.setVisibility(8);
        r8.updateRunListBottomPadding(false);
        return;
    L7:
        r3 = r10;
        goto L8
    L11:
        if (Intrinsics.areEqual(r9.c(), "running") == false) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
    L21:
        this.latestControlState = getRepository().a(r9);
        com.obric.aiproactive.ui.progress.b r5 = aa.a(r9.c(), this.latestControlState.a());
        ActivityAgentRunDetailBinding r6 = this.binding;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L24:
        LinearLayout r7 = r6.runControls;
        if (r5.a() == false) goto L27;
        int r11 = 0;
    L28:
        r7.setVisibility(r11);
        updateRunListBottomPadding(r5.a());
        if (r5.a() == true) goto L31;
        return;
    L31:
        ActivityAgentRunDetailBinding r12 = this.binding;
        if (r12 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L35:
        OButton r0 = r3.btnStop;
        if (r5.b() == AgentRunStatusAction.HIDDEN) goto L39;
        r1 = 0;
    L39:
        r0.setVisibility(r1);
        boolean r13 = Intrinsics.areEqual(this.stoppingExecutionId, r9.a());
        boolean r14 = !r13;
        if (r5.b() == AgentRunStatusAction.HIDDEN) goto L42;
        r2 = true;
    L42:
        setControlsEnabled(r14, r2);
        bindStatusAction(r5.b(), r13);
        return;
    L34:
        r3 = r12;
        goto L35
    L27:
        r11 = 8;
        goto L28
    L19:
        if (Intrinsics.areEqual(this.stoppingExecutionId, r9.a()) == false) goto L21;
        this.stoppingExecutionId = null;
        goto L21
    L13:
        if (Intrinsics.areEqual(r9.c(), "waiting") == true) goto L16;
        r4 = false;
        goto L17
    }

    private final void renderHeader(com.obric.aiproactive.api.g r6) {
        ActivityAgentRunDetailBinding r0 = null;
        if (r6 != null) goto L14;
        ActivityAgentRunDetailBinding r7 = this.binding;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L7:
        r7.titleBar.setCenterTitle(getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_run_detail_title, TypedValues.Custom.S_STRING, "ai_proactive_agent_run_detail_title")));
        ActivityAgentRunDetailBinding r5 = this.binding;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        OFloatingTitleBar r8 = r0.titleBar;
        String r9 = "";
    L12:
        r8.setCenterSubtitle(r9);
        return;
    L10:
        r0 = r5;
        goto L11
    L14:
        g r10 = aa.a(r6, System.currentTimeMillis());
        ActivityAgentRunDetailBinding r2 = this.binding;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L17:
        r2.titleBar.setCenterTitle(r10.a());
        ActivityAgentRunDetailBinding r11 = this.binding;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r8 = r0.titleBar;
        r9 = r10.b();
        goto L12
    L20:
        r0 = r11;
        goto L21
    }

    private final void renderRecommendations() {
        com.obric.aiproactive.api.g r0 = this.latestRun;
        if (r0 != null) goto L5;
    L8:
        List<String> r1 = CollectionsKt.emptyList();
    L9:
        this.adapter.b(r1);
        if (r0 == null) goto L12;
        List<com.obric.aiproactive.api.j> r2 = com.obric.aiproactive.ui.model.k.f6745a.b(this.latestRecommendations, r0.b());
    L13:
        if (r2 != null) goto L15;
        r2 = CollectionsKt.emptyList();
    L15:
        this.adapter.c(r2);
        return;
    L12:
        r2 = null;
        goto L13
    L5:
        if (r0.f() <= 0) goto L8;
        r1 = com.obric.aiproactive.ui.model.k.f6745a.a(this.latestRecommendations, r0.b());
        goto L9
    }

    private final void renderRun(com.obric.aiproactive.api.g r8) {
        this.latestRun = r8;
        ActivityAgentRunDetailBinding r0 = null;
        if (r8 == null) goto L5;
        List<n> r1 = m.a(r8);
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        this.adapter.a(r1);
        reconcileAutomaticExpansion(r1);
        renderRecommendations();
        resolveMobileUsePlayer(r8);
        ActivityAgentRunDetailBinding r2 = this.binding;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L11:
        RecyclerView r3 = r2.recyclerSteps;
        int r5 = 8;
        if (r1.isEmpty() == false) goto L14;
        int r4 = 8;
    L15:
        r3.setVisibility(r4);
        ActivityAgentRunDetailBinding r6 = this.binding;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L18:
        OTextView r7 = r6.tvEmpty;
        if (r1.isEmpty() == false) goto L21;
        r5 = 0;
    L21:
        r7.setVisibility(r5);
        renderControls(r8);
        renderHeader(r8);
        ActivityAgentRunDetailBinding r9 = this.binding;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L24:
        r9.titleBar.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.headerTicker, Runnable.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L27;
        String r10 = r8.c();
    L29:
        if (Intrinsics.areEqual(r10, "running") == true) goto L35;
        if (r8 == null) goto L32;
        String r11 = r8.c();
    L34:
        if (Intrinsics.areEqual(r11, "waiting") == true) goto L35;
        return;
    L32:
        r11 = null;
    L35:
        ActivityAgentRunDetailBinding r12 = this.binding;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L39:
        r0.titleBar.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this.headerTicker, Runnable.class, "com.obric.memorydata.plugin"), 1000);
        return;
    L38:
        r0 = r12;
        goto L39
    L27:
        r10 = null;
        goto L29
    L14:
        r4 = 0;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    private static final com.obric.aiproactive.ui.data.a repository_delegate$lambda$0() {
        return new com.obric.aiproactive.ui.data.a();
    }

    private final void resolveMobileUsePlayer(com.obric.aiproactive.api.g r10) {
        bx r0 = this.mobileUseLaunchJob;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        bx r2 = this.mobileUseResolutionJob;
        if (r2 == null) goto L12;
        bx.a.a(r2, null, 1, null);
    L12:
        z r11 = w.a(r10);
        this.mobileUseNavigationGate.update(r11, null);
        this.adapter.a(null);
        if (r11 != null) goto L15;
        return;
    L15:
        this.mobileUseResolutionJob = kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10681(this, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (r0.a() != true) goto L7;
        r1 = true;
        goto L7
    }

    private final void setControlsEnabled(boolean r5, boolean r6) {
        ActivityAgentRunDetailBinding r0 = this.binding;
        ActivityAgentRunDetailBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        boolean r3 = true;
        r0.btnStop.setEnabled(true);
        ActivityAgentRunDetailBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        OButton r4 = r2.btnStop;
        if (r5 == false) goto L14;
        if (r6 == false) goto L14;
        if (this.latestControlState.a() == false) goto L14;
    L15:
        r4.setClickable(r3);
        ActivityAgentRunDetailBinding r7 = this.binding;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L18:
        OButton r8 = r7.btnStop;
        ActivityAgentRunDetailBinding r9 = this.binding;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r8.setFocusable(r1.btnStop.isClickable());
        return;
    L21:
        r1 = r9;
    L14:
        r3 = false;
        goto L15
    }

    static /* synthetic */ void setControlsEnabled$default(ProactiveAgentRunActivity r1, boolean r2, boolean r3, int r4, Object r5) {
        ProactiveAgentRunActivity r6 = (ProactiveAgentRunActivity) ZeusTransformUtils.wrapperContextForParams(r1, ProactiveAgentRunActivity.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r6.setControlsEnabled(r2, r3);
    }

    private final void stopRun() {
        com.obric.aiproactive.api.g r0 = this.latestRun;
        if (r0 == null) goto L5;
        String r1 = r0.a();
    L6:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
        return;
    L11:
        this.stoppingExecutionId = r1;
        ActivityAgentRunDetailBinding r2 = this.binding;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L14:
        r2.btnStop.setText(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_run_stopping, TypedValues.Custom.S_STRING, "ai_proactive_agent_run_stopping"));
        setControlsEnabled$default(this, false, false, 2, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10691(this, r1, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void updateRunListBottomPadding(boolean r6) {
        if (r6 == false) goto L4;
        int r7 = 80;
    L5:
        int r8 = (int) (r7 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        ActivityAgentRunDetailBinding r0 = this.binding;
        ActivityAgentRunDetailBinding r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        if (r0.recyclerSteps.getPaddingBottom() != r8) goto L11;
        return;
    L11:
        ActivityAgentRunDetailBinding r2 = this.binding;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L14:
        RecyclerView r3 = r2.recyclerSteps;
        ActivityAgentRunDetailBinding r4 = this.binding;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L17:
        int r5 = r4.recyclerSteps.getPaddingLeft();
        ActivityAgentRunDetailBinding r9 = this.binding;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L20:
        int r10 = r9.recyclerSteps.getPaddingTop();
        ActivityAgentRunDetailBinding r11 = this.binding;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r3.setPadding(r5, r10, r1.recyclerSteps.getPaddingRight(), r8);
        return;
    L23:
        r1 = r11;
        goto L24
    L4:
        r7 = 32;
        goto L5
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
    public void onCreateChecked(Bundle r12) {
        com.obric.memorydata.ui.h.f13009a.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Configuration r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r3, "getConfiguration(...)");
        boolean r1 = !r0.b(r3);
        WindowInsetsControllerCompat r4 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        r4.setAppearanceLightStatusBars(r1);
        r4.setAppearanceLightNavigationBars(r1);
        ActivityAgentRunDetailBinding r2 = ActivityAgentRunDetailBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r2, "inflate(...)");
        this.binding = r2;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityAgentRunDetailBinding r5 = this.binding;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L8:
        RecyclerView r6 = r5.recyclerSteps;
        Intrinsics.checkNotNullExpressionValue(r6, "recyclerSteps");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 0);
        ActivityAgentRunDetailBinding r7 = this.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        OFloatingTitleBar r8 = r7.titleBar;
        Intrinsics.checkNotNullExpressionValue(r8, "titleBar");
        registerFloatingTitleBar(r8);
        ActivityAgentRunDetailBinding r9 = this.binding;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L14:
        OFloatingTitleBar r10 = r9.titleBar;
        r10.setCenterTitle(getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_run_detail_title, TypedValues.Custom.S_STRING, "ai_proactive_agent_run_detail_title")));
        OFloatingTitleBar.a(r10, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$ProactiveAgentRunActivity$YRzsPXLEW4oYuVQ5SbJFJKlMND4(this), 2, null).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.proactive_back, TypedValues.Custom.S_STRING, "proactive_back")), CharSequence.class, "com.obric.memorydata.plugin"));
        ActivityAgentRunDetailBinding r11 = this.binding;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L17:
        r11.recyclerSteps.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        ActivityAgentRunDetailBinding r13 = this.binding;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L20:
        r13.recyclerSteps.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(this.adapter, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        if (r12 == null) goto L37;
        ArrayList<String> r14 = r12.getStringArrayList(STATE_EXPANDED_STEP_IDS);
        if (r14 == null) goto L37;
        Set<String> r15 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
        this.adapter.a(r15);
        List r16 = (List) ZeusTransformUtils.preCheckCast(r12.getStringArrayList(STATE_AUTO_EXPANDED_STEP_IDS), List.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L27;
        r16 = CollectionsKt.emptyList();
    L27:
        Set r17 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"));
        List r18 = (List) ZeusTransformUtils.preCheckCast(r12.getStringArrayList(STATE_AUTO_HANDLED_STEP_IDS), List.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L30;
        r18 = CollectionsKt.emptyList();
    L30:
        Set r19 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin"));
        if (r12.containsKey(STATE_MANUALLY_CONTROLLED_STEP_IDS) == false) goto L36;
        List r110 = (List) ZeusTransformUtils.preCheckCast(r12.getStringArrayList(STATE_MANUALLY_CONTROLLED_STEP_IDS), List.class, "com.obric.memorydata.plugin");
        if (r110 != null) goto L35;
        r110 = CollectionsKt.emptyList();
    L35:
        r15 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin"));
    L36:
        this.expansionPolicyState = new f(r17, r19, r15);
    L37:
        ActivityAgentRunDetailBinding r111 = this.binding;
        if (r111 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L40:
        r111.recyclerSteps.setItemAnimator(null);
        ActivityAgentRunDetailBinding r112 = this.binding;
        if (r112 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L43:
        r112.btnStop.setOnClickListener(new $$Lambda$ProactiveAgentRunActivity$gTMLEpa_QzrDPw9gLwRzU8W_JE(this));
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        ActivityAgentRunDetailBinding r0 = this.binding;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        r0.titleBar.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.headerTicker, Runnable.class, "com.obric.memorydata.plugin"));
    L7:
        bx r1 = this.mobileUseResolutionJob;
        if (r1 == null) goto L10;
        bx.a.a(r1, null, 1, null);
    L10:
        bx r2 = this.mobileUseLaunchJob;
        if (r2 == null) goto L13;
        bx.a.a(r2, null, 1, null);
    L13:
        this.mobileUseNavigationGate.b();
        this.adapter.a(null);
        this.latestRun = null;
        this.latestControlState = new com.obric.aiproactive.api.e(null, false, 3, null);
        this.latestRecommendations = CollectionsKt.emptyList();
        this.stoppingExecutionId = null;
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outState");
        r5.putStringArrayList(STATE_EXPANDED_STEP_IDS, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.adapter.a(), Collection.class, "com.obric.memorydata.plugin")));
        r5.putStringArrayList(STATE_AUTO_EXPANDED_STEP_IDS, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.expansionPolicyState.a(), Collection.class, "com.obric.memorydata.plugin")));
        r5.putStringArrayList(STATE_AUTO_HANDLED_STEP_IDS, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.expansionPolicyState.b(), Collection.class, "com.obric.memorydata.plugin")));
        r5.putStringArrayList(STATE_MANUALLY_CONTROLLED_STEP_IDS, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.expansionPolicyState.c(), Collection.class, "com.obric.memorydata.plugin")));
        super.onSaveInstanceState(r5);
    }
}
