package com.obric.aiproactive.ui.entry;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.ui.list.ProactiveListAdapter;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n*\u0001\u0019\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020&H\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u00020&2\u0006\u00100\u001a\u000201H\u0014J \u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0014J\b\u00106\u001a\u00020&H\u0014J&\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u00152\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u0010-\u001a\u00020.H\u0014J\u0018\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0014J\b\u0010?\u001a\u00020\u0015H\u0014J\b\u0010@\u001a\u00020&H\u0014J\b\u0010A\u001a\u00020&H\u0016J\b\u0010B\u001a\u00020&H\u0016J\u0018\u0010C\u001a\u00020&2\u0006\u0010-\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0002J \u0010D\u001a\u0004\u0018\u00010E2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u0010F\u001a\u00020\tH\u0002J\u0010\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020\tH\u0002J\b\u0010I\u001a\u00020&H\u0002J\b\u0010J\u001a\u00020&H\u0002J\b\u0010K\u001a\u00020&H\u0002J\b\u0010L\u001a\u00020&H\u0002J\b\u0010M\u001a\u00020&H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\"8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006O"}, d2 = {"Lcom/obric/aiproactive/ui/entry/AllFeedPageFragment;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedPageFragment;", "<init>", "()V", "pageType", "Lcom/obric/aiproactive/api/PageType;", "getPageType", "()Lcom/obric/aiproactive/api/PageType;", "backgroundResId", "", "getBackgroundResId", "()I", "adapterMode", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;", "getAdapterMode", "()Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;", "latestAllState", "Lcom/obric/aiproactive/ui/model/AllPageUiState;", "latestStartupState", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;", "calendarChangeReceiverRegistered", "", "historyTopInsetApplied", "historyInitialAnchorResetRequested", "calendarChangeReceiver", "com/obric/aiproactive/ui/entry/AllFeedPageFragment$calendarChangeReceiver$1", "Lcom/obric/aiproactive/ui/entry/AllFeedPageFragment$calendarChangeReceiver$1;", "allViewModel", "Lcom/obric/aiproactive/ui/entry/AllFeedViewModel;", "getAllViewModel", "()Lcom/obric/aiproactive/ui/entry/AllFeedViewModel;", "allViewModel$delegate", "Lkotlin/Lazy;", "baseViewModel", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "getBaseViewModel", "()Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateHistoryRecyclerTopInset", "observePageState", "adapter", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter;", "onDayHeaderClick", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$DayHeader;", "onRecyclerScrolled", "dy", "layoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "onPageEntered", "renderPageState", "loading", "items", "", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "resolveBottomPadding", "bottomHandleHeight", "extraBottom", "useDefaultEmptyState", "onTipKnown", "onResume", "onPause", "maybeLoadNextDayPage", "findDayKeyForPaging", "", "lastVisiblePosition", "resetHistoryInitialAnchorIfNeeded", "itemCount", "requestHistoryInitialAnchorReset", "observeStartupCoordinator", "tryHandleStartupInspirationFallback", "registerCalendarChangeReceiverIfNeeded", "unregisterCalendarChangeReceiverIfNeeded", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AllFeedPageFragment extends BaseProactiveFeedPageFragment {
    public static final a Companion = null;
    private static final int HISTORY_CONTENT_TOP_SPACING_DP = 28;
    private final ProactiveListAdapter.Mode adapterMode;
    private final Lazy allViewModel$delegate;
    private final int backgroundResId;
    private final b calendarChangeReceiver;
    private boolean calendarChangeReceiverRegistered;
    private boolean historyInitialAnchorResetRequested;
    private boolean historyTopInsetApplied;
    private com.obric.aiproactive.ui.model.f latestAllState;
    private ac latestStartupState;
    private final PageType pageType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/entry/AllFeedPageFragment$Companion;", "", "<init>", "()V", "HISTORY_CONTENT_TOP_SPACING_DP", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/ui/entry/AllFeedPageFragment$calendarChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AllFeedPageFragment f6566a;

        b(AllFeedPageFragment r1) {
            this.f6566a = r1;
        }

        public void onReceive(Context r7, Intent r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L5;
            String r10 = r8.getAction();
        L6:
            if (r10 == null) goto L20;
            int r0 = r10.hashCode();
            if (r0 == 502473491) goto L16;
            if (r0 == 1041332296) goto L13;
            return;
        L13:
            if (r10.equals("android.intent.action.DATE_CHANGED") == false) goto L21;
        L18:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f6566a.getLogTag(), "[Fragment] onCalendarContextChanged action=" + r8.getAction(), false, 4, null);
            AllFeedPageFragment.access$getAllViewModel(this.f6566a).onCalendarContextChanged();
            return;
        L21:
            return;
        L16:
            if (r10.equals("android.intent.action.TIMEZONE_CHANGED") == true) goto L18;
            return;
        L20:
            return;
        L5:
            r10 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.AllFeedPageFragment$observePageState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.AllFeedPageFragment$observePageState$1", f = "AllFeedPageFragment.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProactiveListAdapter $adapter;
        int label;
        final /* synthetic */ AllFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.AllFeedPageFragment$observePageState$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/aiproactive/ui/model/AllPageUiState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.AllFeedPageFragment$observePageState$1$1", f = "AllFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C02941 extends SuspendLambda implements Function2<com.obric.aiproactive.ui.model.f, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProactiveListAdapter $adapter;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AllFeedPageFragment this$0;

            C02941(AllFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super C02941> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$adapter = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                C02941 r0 = new C02941(this.this$0, this.$adapter, r6);
                r0.L$0 = r4;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(com.obric.aiproactive.ui.model.f r3, Continuation<? super Unit> r4) {
                return ((C02941) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C02941.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(com.obric.aiproactive.ui.model.f r3, Continuation<? super Unit> r4) {
                return invoke2((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                com.obric.aiproactive.ui.model.f r5 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
                AllFeedPageFragment.access$setLatestAllState$p(this.this$0, r5);
                this.this$0.renderPageState(r5.b(), r5.c(), this.$adapter);
                AllFeedPageFragment.access$tryHandleStartupInspirationFallback(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(AllFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$adapter = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(AllFeedPageFragment.access$getAllViewModel(this.this$0).getAllUiState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C02941(this.this$0, this.$adapter, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r9, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.AllFeedPageFragment$observeStartupCoordinator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.AllFeedPageFragment$observeStartupCoordinator$1", f = "AllFeedPageFragment.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    static final class C10501 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AllFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.AllFeedPageFragment$observeStartupCoordinator$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.AllFeedPageFragment$observeStartupCoordinator$1$1", f = "AllFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C02951 extends SuspendLambda implements Function2<ac, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AllFeedPageFragment this$0;

            C02951(AllFeedPageFragment r3, Continuation<? super C02951> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C02951 r0 = new C02951(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(ac r3, Continuation<? super Unit> r4) {
                return ((C02951) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C02951.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(ac r3, Continuation<? super Unit> r4) {
                return invoke2((ac) ZeusTransformUtils.preCheckCast(r3, ac.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                ac r4 = (ac) ZeusTransformUtils.preCheckCast(this.L$0, ac.class, "com.obric.memorydata.plugin");
                AllFeedPageFragment.access$setLatestStartupState$p(this.this$0, r4);
                AllFeedPageFragment.access$tryHandleStartupInspirationFallback(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C10501(AllFeedPageFragment r3, Continuation<? super C10501> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10501(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10501) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10501.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getStartupCoordinatorViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C02951(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AllFeedPageFragment() {
        this.pageType = PageType.ALL;
        this.backgroundResId = ZeusTransformUtils.mapRes(R.drawable.bg_proactive_page_all, "drawable", "bg_proactive_page_all");
        this.adapterMode = ProactiveListAdapter.Mode.ALL;
        this.latestAllState = new com.obric.aiproactive.ui.model.f(0, true, null, false, null, null, null, null, 253, null);
        this.latestStartupState = new ac(0, null, null, 7, null);
        this.calendarChangeReceiver = new b(this);
        this.allViewModel$delegate = LazyKt.lazy(new $$Lambda$AllFeedPageFragment$iwwBGMIZ4VG7sAvrdKKpIiAFdJU(this));
    }

    public static final /* synthetic */ AllFeedViewModel access$getAllViewModel(AllFeedPageFragment r0) {
        return r0.getAllViewModel();
    }

    public static final /* synthetic */ void access$setLatestAllState$p(AllFeedPageFragment r0, com.obric.aiproactive.ui.model.f r1) {
        r0.latestAllState = r1;
    }

    public static final /* synthetic */ void access$setLatestStartupState$p(AllFeedPageFragment r0, ac r1) {
        r0.latestStartupState = r1;
    }

    public static final /* synthetic */ void access$tryHandleStartupInspirationFallback(AllFeedPageFragment r0) {
        r0.tryHandleStartupInspirationFallback();
    }

    private static final AllFeedViewModel allViewModel_delegate$lambda$0(AllFeedPageFragment r4) {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireActivity(...)");
        return (AllFeedViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r1, ViewModelStoreOwner.class, "com.obric.memorydata.plugin"), (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(r4.getViewModelFactory(), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin")).get(AllFeedViewModel.class), AllFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    private final String findDayKeyForPaging(List<? extends com.obric.aiproactive.ui.model.j> r6, int r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r8 = r7;
    L4:
        if ((-1) >= r8) goto L12;
        com.obric.aiproactive.ui.model.j r1 = (com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r5.get(r8), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiproactive.ui.model.j.f.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiproactive.ui.model.j.a.class) == true) goto L10;
        r8 = r8 - 1;
        goto L4
    L10:
        return null;
    L7:
        String r9 = ((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r1, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).c();
    L13:
        if (r9 != null) goto L15;
        return null;
    L15:
        int r10 = r7 + 1;
        int r2 = r5.size();
    L16:
        if (r10 >= r2) goto L27;
        com.obric.aiproactive.ui.model.j r3 = (com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r5.get(r10), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiproactive.ui.model.j.a.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiproactive.ui.model.j.f.class) == true) goto L23;
        r10 = r10 + 1;
        goto L16
    L23:
        if (Intrinsics.areEqual(((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).c(), r9) == false) goto L25;
        return null;
    L25:
        return r9;
    L19:
        return r9;
    L27:
        return r9;
    L12:
        r9 = null;
        goto L13
    }

    private final AllFeedViewModel getAllViewModel() {
        return (AllFeedViewModel) ZeusTransformUtils.preCheckCast(this.allViewModel$delegate.getValue(), AllFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$EYpVpwEOuw8iUf9LKLcFPI1d7tU(AllFeedPageFragment r0) {
        resetHistoryInitialAnchorIfNeeded$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$Mz9Hc0p_Q6ceI4dtTplBsCtaD7M(AllFeedPageFragment r0, View r1) {
        updateHistoryRecyclerTopInset$lambda$1(r0, r1);
    }

    public static /* synthetic */ AllFeedViewModel lambda$iwwBGMIZ4VG7sAvrdKKpIiAFdJU(AllFeedPageFragment r0) {
        return allViewModel_delegate$lambda$0(r0);
    }

    private final void maybeLoadNextDayPage(ProactiveListAdapter r5, LinearLayoutManager r6) {
        List<com.obric.aiproactive.ui.model.j> r7 = r5.b();
        int r8 = r6.p();
        if (r8 == (-1)) goto L16;
        boolean r0 = false;
        if (r8 >= 0) goto L7;
    L9:
        if (r0 == false) goto L17;
        String r9 = findDayKeyForPaging(r7, r8);
        if (r9 != null) goto L14;
        return;
    L14:
        RunLog.INSTANCE.debug(getLogTag(), "[Fragment] maybeLoadNextDayPage dayKey=" + r9 + " lastVisible=" + r8);
        getAllViewModel().loadNextPageForDay(r9);
        return;
    L17:
        return;
    L7:
        if (r8 >= ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).size()) goto L9;
        r0 = true;
        goto L9
    }

    private final void observeStartupCoordinator() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10501(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void registerCalendarChangeReceiverIfNeeded() {
        if (this.calendarChangeReceiverRegistered == false) goto L5;
        return;
    L5:
        if (isAdded() == false) goto L14;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext(...)");
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.DATE_CHANGED");
        r2.addAction("android.intent.action.TIMEZONE_CHANGED");
        if (Build.VERSION.SDK_INT < 33) goto L10;
        ZeusTransformUtils.registerReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.calendarChangeReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r2, 4, "com.obric.memorydata.plugin");
    L11:
        this.calendarChangeReceiverRegistered = true;
        return;
    L10:
        ZeusTransformUtils.registerReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.calendarChangeReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r2, "com.obric.memorydata.plugin");
        goto L11
    }

    private final void requestHistoryInitialAnchorReset() {
        if (ZeusTransformUtils.instanceOf((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), ProactiveHistoryActivity.class) == false) goto L6;
        this.historyInitialAnchorResetRequested = true;
        return;
    }

    private final void resetHistoryInitialAnchorIfNeeded(int r4) {
        if (this.historyTopInsetApplied == true) goto L6;
        return;
    L6:
        if (com.obric.aiproactive.ui.entry.a.a(ZeusTransformUtils.instanceOf((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), ProactiveHistoryActivity.class), this.historyInitialAnchorResetRequested, r4) == true) goto L8;
        return;
    L8:
        this.historyInitialAnchorResetRequested = false;
        getBinding().recyclerView.post(new $$Lambda$AllFeedPageFragment$EYpVpwEOuw8iUf9LKLcFPI1d7tU(this));
    }

    private static final void resetHistoryInitialAnchorIfNeeded$lambda$2(AllFeedPageFragment r2) {
        r2.getBinding().recyclerView.stopScroll();
        r2.getBinding().recyclerView.clearFocus();
        RecyclerView.h r3 = r2.getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r3, LinearLayoutManager.class) == false) goto L5;
        LinearLayoutManager r4 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r3, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L9;
        r4.b(0, 0);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void tryHandleStartupInspirationFallback() {
        if (this.latestAllState.b() == false) goto L6;
        return;
    L6:
        if (this.latestStartupState.c() == StartupInspirationStage.WAITING_ALL) goto L8;
        return;
    L8:
        String r0 = LocalDate.now().format(c.a());
        List<ProactiveRecommendationDto> r1 = (List) ZeusTransformUtils.preCheckCast(this.latestAllState.g().get(r0), List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
        r1 = CollectionsKt.emptyList();
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[StartupFlow] tryHandleAll requestId=" + this.latestStartupState.a() + " inspirationId=" + this.latestStartupState.b() + " batchId=" + this.latestAllState.a() + " todayDayKey=" + r0 + " todaySize=" + r1.size(), false, 4, null);
        ae r2 = getStartupCoordinatorViewModel().resolveFromAllToday(this.latestAllState.a(), r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[StartupFlow] tryHandleAll decision=" + r2.getClass().getSimpleName() + " requestId=" + this.latestStartupState.a(), false, 4, null);
        handleStartupDecision(r2);
    }

    private final void unregisterCalendarChangeReceiverIfNeeded() {
        if (this.calendarChangeReceiverRegistered == true) goto L5;
        return;
    L5:
        if (isAdded() == false) goto L16;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        AllFeedPageFragment r2 = (AllFeedPageFragment) ZeusTransformUtils.preCheckCast(this, AllFeedPageFragment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r2.calendarChangeReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        this.calendarChangeReceiverRegistered = false;
        return;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void updateHistoryRecyclerTopInset() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, ProactiveHistoryActivity.class) == false) goto L5;
        ProactiveHistoryActivity r1 = (ProactiveHistoryActivity) ZeusTransformUtils.preCheckCast(r0, ProactiveHistoryActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        final View r2 = r1.findViewById(ZeusTransformUtils.mapRes(R.id.btn_back_container, OaidModel.KEY_ID, "btn_back_container"));
        if (r2 != null) goto L11;
        return;
    L11:
        r2.post(new $$Lambda$AllFeedPageFragment$Mz9Hc0p_Q6ceI4dtTplBsCtaD7M(this, r2));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void updateHistoryRecyclerTopInset$lambda$1(AllFeedPageFragment r5, View r6) {
        if (r5.isAdded() == true) goto L5;
        return;
    L5:
        int r7 = r6.getBottom() + ((int) (28 * ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDisplayMetrics().density));
        int r1 = 0;
        r5.getBinding().recyclerView.setClipToPadding(false);
        r5.getBinding().recyclerView.setPadding(r5.getBinding().recyclerView.getPaddingLeft(), r7, r5.getBinding().recyclerView.getPaddingRight(), r5.getBinding().recyclerView.getPaddingBottom());
        r5.historyTopInsetApplied = true;
        RecyclerView.Adapter r8 = r5.getBinding().recyclerView.getAdapter();
        if (r8 == null) goto L8;
        r1 = r8.d();
    L8:
        r5.resetHistoryInitialAnchorIfNeeded(r1);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public ProactiveListAdapter.Mode getAdapterMode() {
        return this.adapterMode;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public int getBackgroundResId() {
        return this.backgroundResId;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public BaseProactiveFeedViewModel getBaseViewModel() {
        return (BaseProactiveFeedViewModel) ZeusTransformUtils.preCheckCast(getAllViewModel(), BaseProactiveFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public PageType getPageType() {
        return this.pageType;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void observePageState(ProactiveListAdapter r10) {
        Intrinsics.checkNotNullParameter(r10, "adapter");
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void onDayHeaderClick(com.obric.aiproactive.ui.model.j.a r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] onDayHeaderClick dayKey=" + r8.b() + " date=" + r8.c(), false, 4, null);
        if (r8.f() == false) goto L5;
        String r0 = "collapse_menu";
    L6:
        com.obric.aiproactive.ui.util.h.f6884a.b("proactive_all", "unlock_screen", r0);
        getAllViewModel().toggleDay(r8.b());
        return;
    L5:
        r0 = "show_menu";
        goto L6
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void onPageEntered() {
        requestHistoryInitialAnchorReset();
        getAllViewModel().onAllPageEntered();
        tryHandleStartupInspirationFallback();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        unregisterCalendarChangeReceiverIfNeeded();
        super.onPause();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void onRecyclerScrolled(int r2, ProactiveListAdapter r3, LinearLayoutManager r4) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "layoutManager");
        if (r2 >= 0) goto L5;
        return;
    L5:
        maybeLoadNextDayPage(r3, r4);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        registerCalendarChangeReceiverIfNeeded();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void onTipKnown() {
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        getBinding().appBar.setVisibility(8);
        getBinding().collapsingToolbar.setVisibility(8);
        getBinding().avatarContainer.setVisibility(8);
        getBinding().videoContainer.setVisibility(8);
        getBinding().topBlurView.setVisibility(8);
        getBinding().topCutOff.setVisibility(8);
        getBinding().btnHistoryContainer.setVisibility(8);
        getBinding().btnMoreContainer.setVisibility(8);
        getBinding().btnWakeUp.setVisibility(8);
        getBinding().emptyContainer.setVisibility(8);
        getBinding().tvLoading.setVisibility(8);
        if (ZeusTransformUtils.instanceOf((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), ProactiveHistoryActivity.class) == false) goto L5;
        getBinding().root.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.bg_ai_proactive_demo_page, "drawable", "bg_ai_proactive_demo_page"));
        RecyclerView r6 = getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(r6, "recyclerView");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        requestHistoryInitialAnchorReset();
        getBinding().recyclerView.setSaveEnabled(false);
        getBinding().recyclerView.setFocusable(false);
        getBinding().recyclerView.setDescendantFocusability(393216);
        updateHistoryRecyclerTopInset();
    L5:
        observeStartupCoordinator();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void renderPageState(boolean r3, List<? extends com.obric.aiproactive.ui.model.j> r4, ProactiveListAdapter r5) {
        List<? extends com.obric.aiproactive.ui.model.j> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "items");
        Intrinsics.checkNotNullParameter(r5, "adapter");
        super.renderPageState(r3, r6, r5);
        resetHistoryInitialAnchorIfNeeded(r6.size());
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public int resolveBottomPadding(int r1, int r2) {
        return 0;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public boolean useDefaultEmptyState() {
        return false;
    }
}
