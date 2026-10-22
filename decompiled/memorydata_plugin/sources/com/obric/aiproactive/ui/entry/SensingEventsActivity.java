package com.obric.aiproactive.ui.entry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.obric.aiproactive.ui.databinding.ActivitySensingEventsBinding;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.bduploader.BDObjectUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u000e\u0010 \u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0002J\n\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u000e\u0010-\u001a\u0004\u0018\u00010+*\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsActivity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "<init>", "()V", "binding", "Lcom/obric/aiproactive/ui/databinding/ActivitySensingEventsBinding;", "repository", "Lcom/obric/aiproactive/ui/data/DefaultProactiveRepository;", "getRepository", "()Lcom/obric/aiproactive/ui/data/DefaultProactiveRepository;", "repository$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/obric/aiproactive/ui/list/SensingEventAdapter;", "pageCoordinator", "Lcom/obric/aiproactive/ui/entry/SensingEventsPageCoordinator;", "collapseReportGate", "Lcom/obric/aiproactive/ui/entry/SensingEventsCollapseReportGate;", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "finish", "configureWindow", "configureInsets", "configureList", "configureBackNavigation", "collectTodayEventsAcrossDayChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderSnapshot", "totalCount", "", "rows", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;", "postScrollToTop", "postRestore", "anchor", "Lcom/obric/aiproactive/ui/entry/SensingEventsScrollAnchor;", "currentScrollAnchor", "readScrollAnchor", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SensingEventsActivity extends BaseProactiveActivity {
    public static final a Companion = null;
    private static final String STATE_SCROLL_OFFSET = "sensing_events_scroll_offset";
    private static final String STATE_SCROLL_POSITION = "sensing_events_scroll_position";
    private final com.obric.aiproactive.ui.list.i adapter;
    private ActivitySensingEventsBinding binding;
    private final w collapseReportGate;
    private final y pageCoordinator;
    private final Lazy repository$delegate;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsActivity$Companion;", "", "<init>", "()V", "STATE_SCROLL_POSITION", "", "STATE_SCROLL_OFFSET", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "enterFrom", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Intent a(Context r2, String r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r3, "enterFrom");
            Intent r4 = new Intent(r1, SensingEventsActivity.class);
            r4.putExtra("enter_from", r3);
            return r4;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/obric/aiproactive/ui/entry/SensingEventsActivity$configureList$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiproactive.ui.util.q f6593a;

        b(com.obric.aiproactive.ui.util.q r1) {
            this.f6593a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void a(boolean r1) {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public boolean a(RecyclerView r2, MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "rv");
            Intrinsics.checkNotNullParameter(r3, "event");
            int r4 = r3.getActionMasked();
            if (r4 != 0) goto L5;
            this.f6593a.a();
            return false;
        L5:
            if (r4 != 1) goto L7;
        L9:
            this.f6593a.c();
            return false;
        L7:
            if (r4 == 3) goto L9;
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void b(RecyclerView r1, MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r1, "rv");
            Intrinsics.checkNotNullParameter(r2, "event");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/obric/aiproactive/ui/entry/SensingEventsActivity$configureList$2", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiproactive.ui.util.q f6594a;

        c(com.obric.aiproactive.ui.util.q r1) {
            this.f6594a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            if (r3 == 0) goto L6;
            return;
        L6:
            if (this.f6594a.d() == true) goto L8;
            return;
        L8:
            com.obric.aiproactive.ui.util.h.f6884a.b("events");
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            if (r3 != 0) goto L5;
            if (r4 != 0) goto L5;
            return;
        L5:
            this.f6594a.b();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.SensingEventsActivity$collectTodayEventsAcrossDayChanges$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.SensingEventsActivity", f = "SensingEventsActivity.kt", i = {0, 0, 0}, l = {221}, m = "collectTodayEventsAcrossDayChanges", n = {"this", "dayCollectorCoordinator", "shouldResubscribeForDayChange"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SensingEventsActivity this$0;

        AnonymousClass1(SensingEventsActivity r3, Continuation<? super AnonymousClass1> r4) {
            SensingEventsActivity r5 = (SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SensingEventsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return SensingEventsActivity.access$collectTodayEventsAcrossDayChanges(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.SensingEventsActivity$collectTodayEventsAcrossDayChanges$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.SensingEventsActivity$collectTodayEventsAcrossDayChanges$3", f = "SensingEventsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>>, Continuation<? super Boolean>, Object> {
        final /* synthetic */ x $dayCollectorCoordinator;
        final /* synthetic */ Ref.BooleanRef $shouldResubscribeForDayChange;
        int label;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.SensingEventsActivity$collectTodayEventsAcrossDayChanges$3$a */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6595a = null;

            static {
                int[] r0 = new int[SensingEventsDayEmissionDecision.values().length];
                r0[SensingEventsDayEmissionDecision.DELIVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[SensingEventsDayEmissionDecision.RESTART.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[SensingEventsDayEmissionDecision.IGNORE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f6595a = r0;
            }
        }

        AnonymousClass3(x r3, Ref.BooleanRef r4, Continuation<? super AnonymousClass3> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$dayCollectorCoordinator = r3;
            this.$shouldResubscribeForDayChange = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.$dayCollectorCoordinator, this.$shouldResubscribeForDayChange, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>> r3, Continuation<? super Boolean> r4) {
            return invoke2((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<Integer, ? extends List<com.obric.aiproactive.api.p>> r3, Continuation<? super Boolean> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r5);
            int r6 = a.f6595a[this.$dayCollectorCoordinator.b(n.a(0, null, 3, null)).ordinal()];
            boolean r0 = false;
            if (r6 != 1) goto L7;
            r0 = true;
        L15:
            return Boxing.boxBoolean(r0);
        L7:
            if (r6 == 2) goto L12;
            if (r6 == 3) goto L15;
            throw new NoWhenBranchMatchedException();
        L12:
            this.$shouldResubscribeForDayChange.element = true;
            goto L15
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.SensingEventsActivity$collectTodayEventsAcrossDayChanges$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.SensingEventsActivity$collectTodayEventsAcrossDayChanges$4", f = "SensingEventsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SensingEventsActivity this$0;

        AnonymousClass4(SensingEventsActivity r3, Continuation<? super AnonymousClass4> r4) {
            SensingEventsActivity r5 = (SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SensingEventsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass4 r0 = new AnonymousClass4(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>> r3, Continuation<? super Unit> r4) {
            return invoke2((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<Integer, ? extends List<com.obric.aiproactive.api.p>> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(this.L$0, Pair.class, "com.obric.memorydata.plugin");
            int r0 = ((Number) ZeusTransformUtils.preCheckCast(r5.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
            List r6 = (List) ZeusTransformUtils.preCheckCast(r5.component2(), List.class, "com.obric.memorydata.plugin");
            SensingEventsActivity.access$renderSnapshot(this.this$0, r0, r6);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.SensingEventsActivity$onCreateChecked$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.SensingEventsActivity$onCreateChecked$2", f = "SensingEventsActivity.kt", i = {}, l = {BDObjectUploader.KeyIsEnableGatewayForObject}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SensingEventsActivity this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.SensingEventsActivity$onCreateChecked$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.SensingEventsActivity$onCreateChecked$2$1", f = "SensingEventsActivity.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SensingEventsActivity this$0;

            AnonymousClass1(SensingEventsActivity r3, Continuation<? super AnonymousClass1> r4) {
                SensingEventsActivity r5 = (SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SensingEventsActivity.class, "com.obric.memorydata.plugin");
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

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, kotlin.Unit] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L10;
                ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
            L15:
                SensingEventsActivity.access$getPageCoordinator$p(this.this$0).b();
                AnonymousClass1 this = Unit.INSTANCE;
                return this;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r5);
                SensingEventsActivity.access$getPageCoordinator$p(this.this$0).a();
                SensingEventsActivity r6 = this.this$0;     // Catch: Throwable -> L7
                Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                this.label = 1;     // Catch: Throwable -> L7
                if (SensingEventsActivity.access$collectTodayEventsAcrossDayChanges(r6, r2) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                SensingEventsActivity.access$getPageCoordinator$p(this.this$0).b();
                throw th;
            }
        }

        AnonymousClass2(SensingEventsActivity r3, Continuation<? super AnonymousClass2> r4) {
            SensingEventsActivity r5 = (SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SensingEventsActivity.class, "com.obric.memorydata.plugin");
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

    static {
        Companion = new a(null);
    }

    public SensingEventsActivity() {
        this.repository$delegate = LazyKt.lazy($$Lambda$SensingEventsActivity$betgDAC_igiWgTH7lB76FvBkzgg.INSTANCE);
        this.adapter = new com.obric.aiproactive.ui.list.i(n.b(System.currentTimeMillis(), null, 2, null).a());
        this.pageCoordinator = new y();
        this.collapseReportGate = new w($$Lambda$SensingEventsActivity$xRLZa73Xus1Iepj367plWXzHiNY.INSTANCE);
    }

    public static final /* synthetic */ Object access$collectTodayEventsAcrossDayChanges(SensingEventsActivity r2, Continuation r3) {
        return ((SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SensingEventsActivity.class, "com.obric.memorydata.plugin")).collectTodayEventsAcrossDayChanges((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ w access$getCollapseReportGate$p(SensingEventsActivity r2) {
        return ((SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SensingEventsActivity.class, "com.obric.memorydata.plugin")).collapseReportGate;
    }

    public static final /* synthetic */ y access$getPageCoordinator$p(SensingEventsActivity r2) {
        return ((SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SensingEventsActivity.class, "com.obric.memorydata.plugin")).pageCoordinator;
    }

    public static final /* synthetic */ void access$renderSnapshot(SensingEventsActivity r2, int r3, List r4) {
        ((SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SensingEventsActivity.class, "com.obric.memorydata.plugin")).renderSnapshot(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit collapseReportGate$lambda$1() {
        com.obric.aiproactive.ui.util.h.f6884a.b("events", "unlock_screen", "collapse_detail");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c0 -> B:26:0x00c3). Please report as a decompilation issue!!! */
    private final Object collectTodayEventsAcrossDayChanges(Continuation<? super Unit> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r12, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Ref.BooleanRef r10 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r0.L$2, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        x r4 = (x) ZeusTransformUtils.preCheckCast(r0.L$1, x.class, "com.obric.memorydata.plugin");
        SensingEventsActivity r5 = (SensingEventsActivity) ZeusTransformUtils.preCheckCast(r0.L$0, SensingEventsActivity.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
        SensingEventsActivity r14 = r5;
    L26:
        r4.a();
    L20:
        if (r10.element == false) goto L32;
        r10.element = false;
        if (r4.a(n.a(0, null, 3, null)) == false) goto L30;
        kotlinx.coroutines.flow.i r6 = kotlinx.coroutines.flow.k.d(r14.getRepository().b(), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r4, r10, null), Function2.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        Function2 r7 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r14, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r0.L$0 = r14;     // Catch: Throwable -> L14
        r0.L$1 = r4;     // Catch: Throwable -> L14
        r0.L$2 = r10;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        if (kotlinx.coroutines.flow.k.a(r6, r7, r0) != r2) goto L26;
        return r2;
    L30:
        throw new IllegalStateException("Only one sensing-events day collector may be active".toString());
    L32:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        r4.a();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        x r15 = new x();
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = true;
        r14 = this;
        r10 = r8;
        r4 = r15;
    L7:
        r0 = new AnonymousClass1(this, r12);
        goto L8
    }

    private final void configureBackNavigation() {
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"), (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(new C10661(this), OnBackPressedCallback.class, "com.obric.memorydata.plugin"));
    }

    private final void configureInsets() {
        ActivitySensingEventsBinding r0 = this.binding;
        ActivitySensingEventsBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        final int r2 = r0.rvSensingEvents.getPaddingBottom();
        ActivitySensingEventsBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r3.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$SensingEventsActivity$T_K1QT9FhkkvID1HynTp6Py9kM8(this, r2));
        ActivitySensingEventsBinding r6 = this.binding;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r1.getRoot(), View.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r1 = r6;
        goto L12
    }

    private static final WindowInsetsCompat configureInsets$lambda$6(SensingEventsActivity r5, int r6, View r7, WindowInsetsCompat r8) {
        SensingEventsActivity r9 = (SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r5, SensingEventsActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<unused var>");
        Intrinsics.checkNotNullParameter(r8, "insets");
        int r10 = r8.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        ActivitySensingEventsBinding r0 = r9.binding;
        ActivitySensingEventsBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r2 = r0.rvSensingEvents;
        ActivitySensingEventsBinding r3 = r9.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        int r4 = r3.rvSensingEvents.getPaddingLeft();
        ActivitySensingEventsBinding r11 = r9.binding;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L11:
        int r12 = r11.rvSensingEvents.getPaddingTop();
        ActivitySensingEventsBinding r13 = r9.binding;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r2.setPadding(r4, r12, r1.rvSensingEvents.getPaddingRight(), r6 + r10);
        return r8;
    L14:
        r1 = r13;
        goto L15
    }

    private final void configureList() {
        ActivitySensingEventsBinding r0 = this.binding;
        ActivitySensingEventsBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.rvSensingEvents.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        ActivitySensingEventsBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        r1.rvSensingEvents.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(this.adapter, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        ActivitySensingEventsBinding r3 = this.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.rvSensingEvents.setItemAnimator(null);
        ActivitySensingEventsBinding r4 = this.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        r4.rvSensingEvents.setDescendantFocusability(393216);
        ActivitySensingEventsBinding r5 = this.binding;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        r5.rvSensingEvents.setFocusable(false);
        com.obric.aiproactive.ui.util.q r6 = new com.obric.aiproactive.ui.util.q();
        ActivitySensingEventsBinding r7 = this.binding;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        r7.rvSensingEvents.addOnItemTouchListener((RecyclerView.l) ZeusTransformUtils.preCheckCast(new b(r6), RecyclerView.l.class, "com.obric.memorydata.plugin"));
        ActivitySensingEventsBinding r8 = this.binding;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r2.rvSensingEvents.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new c(r6), RecyclerView.m.class, "com.obric.memorydata.plugin"));
        return;
    L23:
        r2 = r8;
        goto L24
    }

    private final void configureWindow() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Configuration r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r1, "getConfiguration(...)");
        boolean r2 = !r0.b(r1);
        WindowInsetsControllerCompat r3 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        r3.setAppearanceLightStatusBars(r2);
        r3.setAppearanceLightNavigationBars(r2);
    }

    private final aa currentScrollAnchor() {
        ActivitySensingEventsBinding r0 = this.binding;
        ActivitySensingEventsBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView.h r1 = r0.rvSensingEvents.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayoutManager.class) == false) goto L8;
        LinearLayoutManager r3 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r1, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L9:
        if (r3 != null) goto L11;
        return null;
    L11:
        Integer r4 = Integer.valueOf(r3.o());
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() != (-1)) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L18;
        r4 = null;
    L18:
        if (r4 == null) goto L28;
        int r6 = r4.intValue();
        View r7 = r3.c(r6);
        if (r7 != null) goto L22;
        return null;
    L22:
        int r8 = r7.getTop();
        ActivitySensingEventsBinding r9 = this.binding;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L27:
        return new aa(r6, r8 - r2.rvSensingEvents.getPaddingTop());
    L25:
        r2 = r9;
        goto L27
    L28:
        return null;
    L14:
        r5 = false;
        goto L15
    L8:
        r3 = null;
        goto L9
    }

    private final com.obric.aiproactive.ui.data.a getRepository() {
        return (com.obric.aiproactive.ui.data.a) ZeusTransformUtils.preCheckCast(this.repository$delegate.getValue(), com.obric.aiproactive.ui.data.a.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$7vRFzlgLi6UyhgufetN7b_0z-Qs, reason: not valid java name */
    public static /* synthetic */ void m292lambda$7vRFzlgLi6UyhgufetN7b_0zQs(SensingEventsActivity r0, View r1) {
        onCreateChecked$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$T_K1QT9FhkkvID1HynTp6Py9kM8(SensingEventsActivity r0, int r1, View r2, WindowInsetsCompat r3) {
        return configureInsets$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$ZplttuAHWQQ_hybj76GFxS7Jm9E(SensingEventsActivity r0, aa r1) {
        postRestore$lambda$9(r0, r1);
    }

    public static /* synthetic */ com.obric.aiproactive.ui.data.a lambda$betgDAC_igiWgTH7lB76FvBkzgg() {
        return repository_delegate$lambda$0();
    }

    public static /* synthetic */ Unit lambda$xRLZa73Xus1Iepj367plWXzHiNY() {
        return collapseReportGate$lambda$1();
    }

    public static /* synthetic */ void lambda$zAvjUMpJzGuuBI2dlFteT80ofPQ(SensingEventsActivity r0) {
        postScrollToTop$lambda$8(r0);
    }

    private static final void onCreateChecked$lambda$3$lambda$2(SensingEventsActivity r1, View r2) {
        ((SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r1, SensingEventsActivity.class, "com.obric.memorydata.plugin")).getOnBackPressedDispatcher().onBackPressed();
    }

    private final void postRestore(final aa r3) {
        ActivitySensingEventsBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.rvSensingEvents.post(new $$Lambda$SensingEventsActivity$ZplttuAHWQQ_hybj76GFxS7Jm9E(this, r3));
    }

    private static final void postRestore$lambda$9(SensingEventsActivity r6, aa r7) {
        SensingEventsActivity r8 = (SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r6, SensingEventsActivity.class, "com.obric.memorydata.plugin");
        if (r8.isFinishing() == false) goto L5;
        return;
    L5:
        if (r8.isDestroyed() == true) goto L26;
        ActivitySensingEventsBinding r0 = r8.binding;
        ActivitySensingEventsBinding r3 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L10:
        r0.rvSensingEvents.stopScroll();
        int r1 = RangesKt.coerceIn(r7.a(), 0, r8.adapter.d() - 1);
        ActivitySensingEventsBinding r4 = r8.binding;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L13:
        RecyclerView.h r5 = r4.rvSensingEvents.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r5, LinearLayoutManager.class) == false) goto L16;
        LinearLayoutManager r2 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r5, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L17:
        if (r2 == null) goto L25;
        ActivitySensingEventsBinding r9 = r8.binding;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r2.b(r1, r3.rvSensingEvents.getPaddingTop() + r7.b());
        return;
    L21:
        r3 = r9;
        goto L22
    L25:
        return;
    L16:
        r2 = null;
        goto L17
    }

    private final void postScrollToTop() {
        ActivitySensingEventsBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.rvSensingEvents.post(new $$Lambda$SensingEventsActivity$zAvjUMpJzGuuBI2dlFteT80ofPQ(this));
    }

    private static final void postScrollToTop$lambda$8(SensingEventsActivity r5) {
        SensingEventsActivity r6 = (SensingEventsActivity) ZeusTransformUtils.wrapperContextForParams(r5, SensingEventsActivity.class, "com.obric.memorydata.plugin");
        if (r6.isFinishing() == false) goto L5;
        return;
    L5:
        if (r6.isDestroyed() == true) goto L26;
        ActivitySensingEventsBinding r0 = r6.binding;
        ActivitySensingEventsBinding r3 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L10:
        r0.rvSensingEvents.stopScroll();
        ActivitySensingEventsBinding r1 = r6.binding;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L13:
        RecyclerView.h r2 = r1.rvSensingEvents.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r2, LinearLayoutManager.class) == false) goto L16;
        LinearLayoutManager r4 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r2, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L17:
        if (r4 == null) goto L25;
        ActivitySensingEventsBinding r7 = r6.binding;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r4.b(0, r3.rvSensingEvents.getPaddingTop());
        return;
    L21:
        r3 = r7;
        goto L22
    L25:
        return;
    L16:
        r4 = null;
        goto L17
    }

    private final aa readScrollAnchor(Bundle r4) {
        if (r4.containsKey(STATE_SCROLL_POSITION) == true) goto L5;
        return null;
    L5:
        if (r4.containsKey(STATE_SCROLL_OFFSET) == false) goto L13;
        int r3 = r4.getInt(STATE_SCROLL_POSITION, -1);
        if (r3 != (-1)) goto L11;
        return null;
    L11:
        return new aa(r3, r4.getInt(STATE_SCROLL_OFFSET));
    L13:
        return null;
    }

    private final void renderSnapshot(int r10, List<com.obric.aiproactive.api.p> r11) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        ab r12 = this.pageCoordinator.c();
        if (Intrinsics.areEqual(r12, ab.a.f6598a) == false) goto L5;
        return;
    L5:
        q r13 = n.a(r2, r10, System.currentTimeMillis(), null, 8, null);
        this.adapter.a(r13.a());
        if (Intrinsics.areEqual(r12, ab.a.f6598a) == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r12, ab.b.f6599a) == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r12, ab.d.f6601a) == false) goto L16;
        if (n.a(r13.a().size()) == false) goto L21;
        postScrollToTop();
        return;
    L21:
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r12, ab.c.class) == false) goto L19;
        postRestore(((ab.c) ZeusTransformUtils.preCheckCast(r12, ab.c.class, "com.obric.memorydata.plugin")).a());
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    private static final com.obric.aiproactive.ui.data.a repository_delegate$lambda$0() {
        return new com.obric.aiproactive.ui.data.a();
    }

    public void finish() {
        super.finish();
        if (this.pageCoordinator.e() == false) goto L6;
        com.obric.memorydata.ui.h.f13009a.c((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        return;
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
    public void onCreateChecked(Bundle r11) {
        y r0 = this.pageCoordinator;
        if (r11 != null) goto L5;
        boolean r1 = true;
    L7:
        if (r11 == null) goto L9;
        aa r12 = readScrollAnchor(r11);
    L10:
        r0.a(r1, r12);
        configureWindow();
        ActivitySensingEventsBinding r13 = ActivitySensingEventsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r13, "inflate(...)");
        this.binding = r13;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L13:
        setContentView((View) ZeusTransformUtils.preCheckCast(r13.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivitySensingEventsBinding r14 = this.binding;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L16:
        OFloatingTitleBar r4 = r14.titleBar;
        r4.setCenterTitle(getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_sensing_events_title, TypedValues.Custom.S_STRING, "ai_proactive_sensing_events_title")));
        OFloatingTitleBar.a(r4, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$SensingEventsActivity$7vRFzlgLi6UyhgufetN7b_0zQs(this), 2, null).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.proactive_back, TypedValues.Custom.S_STRING, "proactive_back")), CharSequence.class, "com.obric.memorydata.plugin"));
        configureInsets();
        configureList();
        configureBackNavigation();
        if (this.pageCoordinator.d() == false) goto L23;
        com.obric.aiproactive.ui.util.h r15 = com.obric.aiproactive.ui.util.h.f6884a;
        Intent r2 = getIntent();
        if (r2 == null) goto L21;
        String r3 = r2.getStringExtra("enter_from");
    L22:
        r15.b("events", "home", com.obric.aiproactive.ui.util.n.a(r3), "click");
        goto L23
    L21:
        r3 = null;
    L23:
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L9:
        r12 = null;
        goto L10
    L5:
        r1 = false;
        goto L7
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "outState");
        if (this.binding == null) goto L7;
        aa r0 = currentScrollAnchor();
        if (r0 == null) goto L7;
        r4.putInt(STATE_SCROLL_POSITION, r0.a());
        r4.putInt(STATE_SCROLL_OFFSET, r0.b());
    L7:
        super.onSaveInstanceState(r4);
    }
}
