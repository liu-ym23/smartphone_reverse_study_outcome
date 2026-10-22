package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.databinding.MemoryCalendarTabFragmentLayoutBinding;
import com.obric.memorydata.memory.databinding.MemoryCalendarTopLayoutBinding;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
import okhttp3.HttpUrl;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001d\b&\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001VB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020 H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0015H\u0002J\u0012\u00100\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010 H\u0002J\u0010\u00101\u001a\u00020\u00152\u0006\u0010-\u001a\u00020$H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u0010-\u001a\u00020 H\u0002J\b\u00103\u001a\u00020(H\u0016J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u0015H\u0002J\u0010\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u0010H\u0002J\b\u00108\u001a\u00020(H\u0002J\u0012\u00109\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u00010\u0015H\u0004J\u0012\u0010;\u001a\u00020(2\b\u0010<\u001a\u0004\u0018\u00010\u0015H\u0004J\u0018\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u0010H\u0002J\n\u0010@\u001a\u0004\u0018\u00010AH\u0014J\b\u0010B\u001a\u00020\u0015H&J\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020 H\u0002J\"\u0010E\u001a\u00020(2\b\u0010F\u001a\u0004\u0018\u00010A2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0004J\b\u0010K\u001a\u00020LH\u0004J\b\u0010M\u001a\u00020(H\u0016J\u0010\u0010N\u001a\u00020(2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020AH&J\n\u0010Q\u001a\u0004\u0018\u00010AH&J\u0010\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0SH&J\b\u0010T\u001a\u00020(H&J \u0010U\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH&R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006W"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment;", "Lcom/obric/memorydata/memory/ui/list/AbstractMemoryTabFragment;", "Lcom/obric/memorydata/memory/ui/list/MemoryNestedViewPagerHost;", "Lcom/obric/memorydata/ui/FloatingTitleBarOwner;", "Lcom/obric/memorydata/memory/ui/MemoryFloatingTitleBarOwner;", "<init>", "()V", "memoryCalendarAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarAdapter;", "binding", "Lcom/obric/memorydata/memory/databinding/MemoryCalendarTabFragmentLayoutBinding;", "getBinding", "()Lcom/obric/memorydata/memory/databinding/MemoryCalendarTabFragmentLayoutBinding;", "setBinding", "(Lcom/obric/memorydata/memory/databinding/MemoryCalendarTabFragmentLayoutBinding;)V", "isRecyclerViewFirstScroll", "", "headerLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "showTodayAction", "normalTitle", "", "normalSubtitle", "editSelectedCount", "", "editSelectAllText", "getCurrentFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "dateChangeReceiver", "com/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment$dateChangeReceiver$1", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment$dateChangeReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "applyStatusBarTop", "top", "setupHeaderLayoutRefresh", "bottomInRoot", "view", "dumpHeaderDiag", InfoRequestQPSOptTraceLogger.REASON, "viewDiag", "childDiag", "clipChain", "onResume", "toggleSelectText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "toggleTodayView", "visible", "setupTitleBar", "setNormalTitleBarTitle", "title", "setNormalTitleBarSubtitle", "subtitle", "applyTitleBarState", "editMode", "animate", "getSelectDate", "Ljava/time/LocalDate;", "getCurrentBottomTab", "setupCalendarView", "parent", "updateCalendarAdapterOnSelectDateChange", "selectDate", "layoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "getMemoryListContainer", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "resetNestedViewPagerScroll", "setupDayNumberText", "setCurrentDate", "date", "getCurrentDate", "getCurrentDateStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "refreshCalendar", "setupCalendarDateData", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MemoryCalendarTabFragment extends AbstractMemoryTabFragment implements ac, com.obric.memorydata.ui.b {
    private static final a Companion = null;
    private static final String DIAG_PREFIX = "[HeaderCoordDiag][Calendar]";
    private static final String TAG = "MemoryCalendarTabFragment";
    protected MemoryCalendarTabFragmentLayoutBinding binding;
    private final b dateChangeReceiver;
    private String editSelectAllText;
    private int editSelectedCount;
    private View.OnLayoutChangeListener headerLayoutListener;
    private boolean isRecyclerViewFirstScroll;
    private m memoryCalendarAdapter;
    private String normalSubtitle;
    private String normalTitle;
    private boolean showTodayAction;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "DIAG_PREFIX", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment$dateChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryCalendarTabFragment f11026a;

        b(MemoryCalendarTabFragment r1) {
            this.f11026a = r1;
        }

        public void onReceive(Context r7, Intent r8) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r8, MemorySourceLinkType.INTENT);
            String r9 = r8.getAction();
            if (r9 != null) goto L5;
            return;
        L5:
            if (r9.hashCode() == 1041332296) goto L8;
            return;
        L8:
            if (r9.equals("android.intent.action.DATE_CHANGED") == false) goto L15;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryCalendarTabFragment.TAG, "onReceive date changed", false, 4, null);
            m r6 = MemoryCalendarTabFragment.access$getMemoryCalendarAdapter$p(this.f11026a);
            if (r6 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
            r6 = null;
        L12:
            LocalDate r10 = LocalDate.now();
            Intrinsics.checkNotNullExpressionValue(r10, "now(...)");
            r6.b(r10);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment$setupCalendarView$5", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "newState", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f11027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MemoryCalendarTabFragment f11028b;

        c(LinearLayoutManager r1, MemoryCalendarTabFragment r2) {
            this.f11027a = r1;
            this.f11028b = r2;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "recyclerView");
            super.a(r9, r10);
            if (r10 != 0) goto L44;
            int r11 = this.f11027a.o();
            int r12 = (this.f11027a.p() - this.f11027a.o()) / 2;
            m r13 = MemoryCalendarTabFragment.access$getMemoryCalendarAdapter$p(this.f11028b);
            Object r0 = null;
            if (r13 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
            r13 = null;
        L7:
            p r14 = r13.b(r11);
            LocalDate r15 = this.f11028b.getCurrentDate();
            if (r14 == null) goto L45;
            if (r15 == null) goto L46;
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r14.a(), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L13;
        L15:
            Iterator r2 = r1.iterator();
        L17:
            if (r2.hasNext() == false) goto L14;
            if (Intrinsics.areEqual(((n) ZeusTransformUtils.preCheckCast(r2.next(), n.class, "com.obric.memorydata.plugin")).a(), r15) == false) goto L17;
            boolean r3 = true;
        L21:
            RunLog.INSTANCE.debug(MemoryCalendarTabFragment.TAG, "CalendarList scroll to center week, isCurrentWeek: " + r3);
            if (r3 == true) goto L47;
            Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L25:
            if (r16.hasNext() == false) goto L32;
            Object r4 = r16.next();
            if (((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin")).a().getDayOfWeek().getValue() != r15.getDayOfWeek().getValue()) goto L29;
            boolean r5 = true;
        L30:
            if (r5 == false) goto L25;
            r0 = r4;
            goto L32
        L29:
            r5 = false;
        L32:
            n r17 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L48;
            RunLog.INSTANCE.debug(MemoryCalendarTabFragment.TAG, "CalendarList scroll to center week, targetDay: " + r17);
            this.f11028b.setCurrentDate(r17.a());
            return;
        L48:
            return;
        L47:
            return;
        L14:
            r3 = false;
            goto L21
        L13:
            if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
        L46:
            return;
        L45:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupCalendarView$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupCalendarView$3", f = "MemoryCalendarTabFragment.kt", i = {}, l = {425}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ MemoryCalendarTopLayoutBinding $calendarView;
        int label;
        final /* synthetic */ MemoryCalendarTabFragment this$0;

        AnonymousClass3(MemoryCalendarTabFragment r3, MemoryCalendarTopLayoutBinding r4, Continuation<? super AnonymousClass3> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$calendarView = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, this.$calendarView, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = this.this$0.getShareViewModel().getSelectionManager().b();
            final MemoryCalendarTopLayoutBinding r3 = this.$calendarView;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupCalendarView$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupCalendarView$4", f = "MemoryCalendarTabFragment.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryCalendarTabFragment this$0;

        AnonymousClass4(MemoryCalendarTabFragment r3, Continuation<? super AnonymousClass4> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<SelectionStateManager.SelectAllState> r7 = this.this$0.getShareViewModel().getSelectionManager().c();
            final MemoryCalendarTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super SelectionStateManager.SelectAllState> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupTitleBar$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupTitleBar$1", f = "MemoryCalendarTabFragment.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryCalendarTabFragment this$0;

        AnonymousClass1(MemoryCalendarTabFragment r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        private static final boolean invokeSuspend$lambda$0(LocalDate r0, LocalDate r1) {
            return Intrinsics.areEqual(r0, r1);
        }

        public static /* synthetic */ boolean lambda$pUHR_qHPyVuAlMdn2Wre3A0g8ms(LocalDate r0, LocalDate r1) {
            return invokeSuspend$lambda$0(r0, r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getCurrentDateStateFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryCalendarTabFragment$setupTitleBar$1$pUHR_qHPyVuAlMdn2Wre3A0g8ms.INSTANCE);
            final MemoryCalendarTabFragment r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05691(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupTitleBar$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupTitleBar$2", f = "MemoryCalendarTabFragment.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryCalendarTabFragment this$0;

        AnonymousClass2(MemoryCalendarTabFragment r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = this.this$0.getShareViewModel().getSelectionManager().b();
            final MemoryCalendarTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupTitleBar$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment$setupTitleBar$3", f = "MemoryCalendarTabFragment.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    static final class C11593 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryCalendarTabFragment this$0;

        C11593(MemoryCalendarTabFragment r3, Continuation<? super C11593> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11593(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11593) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11593.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<Integer> r7 = this.this$0.getShareViewModel().getSelectionManager().f();
            final MemoryCalendarTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Integer> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryCalendarTabFragment() {
        this.isRecyclerViewFirstScroll = true;
        this.editSelectAllText = "";
        this.dateChangeReceiver = new b(this);
    }

    public static final /* synthetic */ void access$applyTitleBarState(MemoryCalendarTabFragment r0, boolean r1, boolean r2) {
        r0.applyTitleBarState(r1, r2);
    }

    public static final /* synthetic */ m access$getMemoryCalendarAdapter$p(MemoryCalendarTabFragment r0) {
        return r0.memoryCalendarAdapter;
    }

    public static final /* synthetic */ void access$setEditSelectedCount$p(MemoryCalendarTabFragment r0, int r1) {
        r0.editSelectedCount = r1;
    }

    public static final /* synthetic */ void access$toggleSelectText(MemoryCalendarTabFragment r0, String r1) {
        r0.toggleSelectText(r1);
    }

    public static final /* synthetic */ void access$toggleTodayView(MemoryCalendarTabFragment r0, boolean r1) {
        r0.toggleTodayView(r1);
    }

    private final void applyStatusBarTop(final int r5) {
        getBinding().titleBarContainer.setPadding(getBinding().titleBarContainer.getPaddingLeft(), r5, getBinding().titleBarContainer.getPaddingRight(), getBinding().titleBarContainer.getPaddingBottom());
        getBinding().getRoot().post(new $$Lambda$MemoryCalendarTabFragment$XdHPndq8erPDDpmab8XRItlSEbc(this, r5));
    }

    private static final void applyStatusBarTop$lambda$3(MemoryCalendarTabFragment r2, int r3) {
        r2.dumpHeaderDiag("applyStatusBarTop(" + r3 + ").post");
    }

    private final void applyTitleBarState(final boolean r7, boolean r8) {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, MemoryListActivity.class) == false) goto L5;
        MemoryListActivity r1 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r0, MemoryListActivity.class, "com.obric.memorydata.plugin");
    L6:
        OFloatingTitleBar r2 = getBinding().viewTitleNormal;
        boolean r3 = true;
        if (r8 == false) goto L15;
        if (r1 == null) goto L12;
        OFloatingTitleBar r5 = getBinding().viewTitleNormal;
        Intrinsics.checkNotNullExpressionValue(r5, "viewTitleNormal");
        if (r1.handles(r5) != true) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
    L16:
        r2.a(r3, new $$Lambda$MemoryCalendarTabFragment$UHSQBbrJiPlJJQgxpE4FAquTZ8(r7, this));
        OFloatingTitleBar r9 = getBinding().viewTitleNormal;
        Intrinsics.checkNotNullExpressionValue(r9, "viewTitleNormal");
        com.obric.memorydata.ui.custom.a.a(r9);
        if (r1 == null) goto L20;
        OFloatingTitleBar r10 = getBinding().viewTitleNormal;
        Intrinsics.checkNotNullExpressionValue(r10, "viewTitleNormal");
        r1.syncCurrentFloatingTitleBar(r10, r8);
        return;
    L20:
        return;
    L12:
        r6 = false;
    L15:
        r3 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    private static final Unit applyTitleBarState$lambda$16(boolean r8, final MemoryCalendarTabFragment r9, final OFloatingTitleBar r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$batchSet");
        if (r8 == false) goto L5;
        String r2 = null;
    L6:
        r10.setStartTitle(r2);
        if (r8 == false) goto L9;
        String r3 = null;
    L10:
        r10.setStartSubtitle(r3);
        if (r8 == false) goto L13;
        String r4 = r9.getString(ZeusTransformUtils.mapRes(R.string.memory_multi_select_selected_count, TypedValues.Custom.S_STRING, "memory_multi_select_selected_count"), new Object[]{Integer.valueOf(r9.editSelectedCount)});
    L14:
        r10.setCenterTitle(r4);
        r10.setCenterSubtitle(null);
        if (r8 == false) goto L17;
        int r5 = R.style.OFloatingTitleBar_Action_PrimaryLight_Text;
        String r6 = "OFloatingTitleBar_Action_PrimaryLight_Text";
    L18:
        r10.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(r5, "style", r6));
        OFloatingTitleBar.a(r10, false, 1, null);
        OFloatingTitleBar.b(r10, false, 1, null);
        OFloatingTitleBar.d(r10, false, 1, null);
        OFloatingTitleBar.c(r10, false, 1, null);
        if (r8 == false) goto L22;
        OFloatingTitleBar.a(r10, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_close, "drawable", "o_floating_title_bar_icon_close"), 0, new $$Lambda$MemoryCalendarTabFragment$FrOy1QPYLxqtiY_52kdQiriCPa8(r9), 2, null);
        OFloatingTitleBar.a(r10, r9.editSelectAllText, 0, new $$Lambda$MemoryCalendarTabFragment$2CYxsTvdsabkLP7RcTuqHDA2PsU(r9), 2, null);
    L26:
        return Unit.INSTANCE;
    L22:
        if (r9.showTodayAction == false) goto L24;
        OFloatingTitleBar.c(r10, ZeusTransformUtils.mapRes(R.drawable.today_memory_icon, "drawable", "today_memory_icon"), 0, new $$Lambda$MemoryCalendarTabFragment$qxHuqahwXfB8pzNhzMfKekEQWAA(r9), 2, null);
    L24:
        OFloatingTitleBar.b(r10, ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_search, "drawable", "ic_memory_list_search"), 0, new $$Lambda$MemoryCalendarTabFragment$8mV23vbnj6KznaGcwvIlDl2AFYs(r10), 2, null);
        OFloatingTitleBar.b(r10, ZeusTransformUtils.mapRes(R.drawable.ic_memory_detail_operation, "drawable", "ic_memory_detail_operation"), 0, new $$Lambda$MemoryCalendarTabFragment$m6010tFKflr9S777rWZCopUelqI(r9), 2, null);
        goto L26
    L17:
        r5 = R.style.OFloatingTitleBar_Action_Standard;
        r6 = "OFloatingTitleBar_Action_Standard";
        goto L18
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = r9.normalSubtitle;
        goto L10
    L5:
        r2 = r9.normalTitle;
        goto L6
    }

    private static final void applyTitleBarState$lambda$16$lambda$11(MemoryCalendarTabFragment r0, View r1) {
        r0.getShareViewModel().getSelectionManager().j();
    }

    private static final void applyTitleBarState$lambda$16$lambda$12(MemoryCalendarTabFragment r0, View r1) {
        r0.getShareViewModel().getSelectionManager().l();
    }

    private static final void applyTitleBarState$lambda$16$lambda$13(MemoryCalendarTabFragment r6, View r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onClick today button", false, 4, null);
        LocalDate r8 = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(r8, "now(...)");
        r6.setCurrentDate(r8);
    }

    private static final void applyTitleBarState$lambda$16$lambda$14(OFloatingTitleBar r2, View r3) {
        MemorySearchActivity.a r4 = MemorySearchActivity.Companion;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");
        r4.a(r5);
    }

    private static final void applyTitleBarState$lambda$16$lambda$15(MemoryCalendarTabFragment r0, View r1) {
        Intrinsics.checkNotNull(r1);
        r0.showPopupMenu(r1);
    }

    private final int bottomInRoot(View r3) {
        if (r3.getHeight() > 0) goto L5;
        return 0;
    L5:
        if (r3.isShown() == false) goto L11;
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        getBinding().getRoot().getLocationInWindow(r1);
        r3.getLocationInWindow(r0);
        return (r0[1] - r1[1]) + r3.getHeight();
    L11:
        return 0;
    }

    private final String childDiag(ViewGroup r6) {
        if (r6.getChildCount() != 0) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r5 = new StringBuilder();
        r5.append("[");
        int r0 = Math.min(r6.getChildCount(), 6);
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L12;
        if (r1 <= 0) goto L10;
        r5.append(";");
    L10:
        View r2 = r6.getChildAt(r1);
        r5.append(r1).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r2.getClass().getSimpleName()).append(" l=").append(r2.getLeft()).append(" t=").append(r2.getTop()).append(" r=").append(r2.getRight()).append(" b=").append(r2.getBottom()).append(" size=").append(r2.getWidth()).append("x").append(r2.getHeight());
        r1 = r1 + 1;
        goto L7
    L12:
        if (r6.getChildCount() <= r0) goto L14;
        r5.append(";...").append(r6.getChildCount());
    L14:
        r5.append("]");
        String r7 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    private final String clipChain(View r5) {
        StringBuilder r4 = new StringBuilder();
        int r0 = 0;
    L3:
        if (r5 == null) goto L16;
        if (r0 >= 8) goto L16;
        if (r0 <= 0) goto L8;
        r4.append(" <- ");
    L8:
        r4.append(r5.getClass().getSimpleName());
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L11;
        r4.append("(clipChildren=").append(((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).getClipChildren()).append(",clipToPadding=").append(((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).getClipToPadding()).append(")");
    L11:
        ViewParent r6 = r5.getParent();
        if (ZeusTransformUtils.instanceOf(r6, View.class) == false) goto L14;
        r5 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
    L15:
        r0 = r0 + 1;
        goto L3
    L14:
        r5 = null;
    L16:
        String r7 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    private final void dumpHeaderDiag(String r11) {
        if (this.binding != null) goto L6;
        return;
    L6:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L8;
        return;
    L8:
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder();
        r1.append("[HeaderCoordDiag][Calendar] dump[").append(r11).append("] bottomTab=").append(getCurrentBottomTab()).append(" root=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"))).append(" titleContainer=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().titleBarContainer, View.class, "com.obric.memorydata.plugin"))).append(" titleNormal=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().viewTitleNormal, View.class, "com.obric.memorydata.plugin"))).append(" titleNormalInner=").append(viewDiag(getBinding().viewTitleNormal.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container")))).append(" titleNormalStart=").append(viewDiag(getBinding().viewTitleNormal.findViewById(ZeusTransformUtils.mapRes(R.id.start_title_container, OaidModel.KEY_ID, "start_title_container")))).append(" calendarBar=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().calendarBarContainer.getRoot(), View.class, "com.obric.memorydata.plugin"))).append(" weekDay=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().calendarBarContainer.memoryCalendarWeekDay, View.class, "com.obric.memorydata.plugin"))).append(" dateList=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().calendarBarContainer.memoryCalendarTopDateList, View.class, "com.obric.memorydata.plugin"))).append(" pager=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().memoryListContainer, View.class, "com.obric.memorydata.plugin"))).append(" operation=");
        StringBuilder r12 = r1.append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().memoryOperationContainer, View.class, "com.obric.memorydata.plugin"))).append(" visibleContentBottom=");
        int r5 = 0;
        OFloatingTitleBar r3 = getBinding().viewTitleNormal;
        Intrinsics.checkNotNullExpressionValue(r3, "viewTitleNormal");
        ConstraintLayout r7 = getBinding().calendarBarContainer.getRoot();
        Intrinsics.checkNotNullExpressionValue(r7, "getRoot(...)");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Integer[]{Integer.valueOf(getBinding().titleBarContainer.getHeight()), Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"))), Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin")))}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L17;
        Object r8 = r6.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L10;
        r4.add(r8);
        goto L10
    L14:
        r9 = false;
        goto L15
    L17:
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L20;
        r5 = r10.intValue();
    L20:
        StringBuilder r13 = r12.append(r5).append(" dateChildren=");
        RecyclerView r14 = getBinding().calendarBarContainer.memoryCalendarTopDateList;
        Intrinsics.checkNotNullExpressionValue(r14, "memoryCalendarTopDateList");
        StringBuilder r15 = r13.append(childDiag((ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.memorydata.plugin"))).append(" clipChain=");
        ConstraintLayout r16 = getBinding().calendarBarContainer.getRoot();
        Intrinsics.checkNotNullExpressionValue(r16, "getRoot(...)");
        r15.append(clipChain((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin")));
        r0.debug(TAG, r1.toString());
    }

    public static /* synthetic */ void lambda$2CYxsTvdsabkLP7RcTuqHDA2PsU(MemoryCalendarTabFragment r0, View r1) {
        applyTitleBarState$lambda$16$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$2tMhkOxU0Yk-ihCZhsQ1pBrfInU, reason: not valid java name */
    public static /* synthetic */ void m880lambda$2tMhkOxU0YkihCZhsQ1pBrfInU(MemoryCalendarTabFragment r0, View r1) {
        setupTitleBar$lambda$10(r0, r1);
    }

    public static /* synthetic */ void lambda$8mV23vbnj6KznaGcwvIlDl2AFYs(OFloatingTitleBar r0, View r1) {
        applyTitleBarState$lambda$16$lambda$14(r0, r1);
    }

    public static /* synthetic */ void lambda$FrOy1QPYLxqtiY_52kdQiriCPa8(MemoryCalendarTabFragment r0, View r1) {
        applyTitleBarState$lambda$16$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$UHSQBb-rJiPlJJQgxpE4FAquTZ8, reason: not valid java name */
    public static /* synthetic */ Unit m881lambda$UHSQBbrJiPlJJQgxpE4FAquTZ8(boolean r0, MemoryCalendarTabFragment r1, OFloatingTitleBar r2) {
        return applyTitleBarState$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$XdHPndq8erPDDpmab8XRItlSEbc(MemoryCalendarTabFragment r0, int r1) {
        applyStatusBarTop$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit lambda$Zww4bK1ZBNVCt2rdsVMTnSfthyU(MemoryCalendarTabFragment r0, LocalDate r1) {
        return setupCalendarView$lambda$17(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$aH6bKDudBIFD7--7HfT3wXHR_n8, reason: not valid java name */
    public static /* synthetic */ void m882lambda$aH6bKDudBIFD77HfT3wXHR_n8(MemoryCalendarTabFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        setupHeaderLayoutRefresh$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void lambda$bnT1DKhzjC5tVet38NdAnFfGAQg(MemoryCalendarTabFragment r0) {
        setupHeaderLayoutRefresh$lambda$5(r0);
    }

    public static /* synthetic */ void lambda$m6010tFKflr9S777rWZCopUelqI(MemoryCalendarTabFragment r0, View r1) {
        applyTitleBarState$lambda$16$lambda$15(r0, r1);
    }

    public static /* synthetic */ void lambda$qxHuqahwXfB8pzNhzMfKekEQWAA(MemoryCalendarTabFragment r0, View r1) {
        applyTitleBarState$lambda$16$lambda$13(r0, r1);
    }

    public static /* synthetic */ void lambda$tZ98CszGxxslB7MjRRlPU6Uft_k(View r0) {
        setupCalendarView$lambda$18(r0);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$uz6bK6zr6gZuG2BO1Zp6nuTHVks(MemoryCalendarTabFragment r0, View r1, WindowInsetsCompat r2) {
        return onCreateView$lambda$0(r0, r1, r2);
    }

    private static final WindowInsetsCompat onCreateView$lambda$0(MemoryCalendarTabFragment r1, View r2, WindowInsetsCompat r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "insets");
        r1.applyStatusBarTop(r3.getInsets(WindowInsetsCompat.Type.statusBars()).top);
        return r3;
    }

    private final void setupCalendarView(View r13) {
        MemoryCalendarTopLayoutBinding r14 = MemoryCalendarTopLayoutBinding.bind(r13);
        Intrinsics.checkNotNullExpressionValue(r14, "bind(...)");
        LinearLayoutManager r0 = new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 0, false);
        r14.memoryCalendarTopDateList.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r0, RecyclerView.h.class, "com.obric.memorydata.plugin"));
        new com.obric.oui.orecyclerview.widget.w().a(r14.memoryCalendarTopDateList);
        this.memoryCalendarAdapter = new m(this, new $$Lambda$MemoryCalendarTabFragment$Zww4bK1ZBNVCt2rdsVMTnSfthyU(this));
        RecyclerView r1 = r14.memoryCalendarTopDateList;
        m r3 = this.memoryCalendarAdapter;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
        r3 = null;
    L5:
        r1.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r3, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        m r2 = this.memoryCalendarAdapter;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
        r2 = null;
    L8:
        RecyclerView r4 = r14.memoryCalendarTopDateList;
        Intrinsics.checkNotNullExpressionValue(r4, "memoryCalendarTopDateList");
        setupCalendarDateData(r2, r0, r4);
        r14.memoryCalendarTopDateList.setItemAnimator(null);
        r14.memoryCalendarTopDateListDisableMask.setOnClickListener($$Lambda$MemoryCalendarTabFragment$tZ98CszGxxslB7MjRRlPU6Uft_k.INSTANCE);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r14.memoryCalendarTopDateList.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new c(r0, this), RecyclerView.m.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit setupCalendarView$lambda$17(MemoryCalendarTabFragment r3, LocalDate r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r3.setCurrentDate(r4);
    L6:
        return Unit.INSTANCE;
    }

    private static final void setupCalendarView$lambda$18(View r6) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "click disable mask", false, 4, null);
    }

    private final void setupHeaderLayoutRefresh() {
        View.OnLayoutChangeListener r0 = new $$Lambda$MemoryCalendarTabFragment$aH6bKDudBIFD77HfT3wXHR_n8(this);
        this.headerLayoutListener = r0;
        getBinding().titleBarContainer.addOnLayoutChangeListener(r0);
        getBinding().viewTitleNormal.addOnLayoutChangeListener(r0);
        getBinding().calendarBarContainer.getRoot().addOnLayoutChangeListener(r0);
        getBinding().memoryListContainer.addOnLayoutChangeListener(r0);
        getBinding().getRoot().post(new $$Lambda$MemoryCalendarTabFragment$bnT1DKhzjC5tVet38NdAnFfGAQg(this));
    }

    private static final void setupHeaderLayoutRefresh$lambda$4(MemoryCalendarTabFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r0.dumpHeaderDiag("onHeaderLayout");
    }

    private static final void setupHeaderLayoutRefresh$lambda$5(MemoryCalendarTabFragment r1) {
        r1.dumpHeaderDiag("onCreateView.post");
    }

    private final void setupTitleBar() {
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.memory_list_all_selected_text, TypedValues.Custom.S_STRING, "memory_list_all_selected_text"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        this.editSelectAllText = r0;
        setupDayNumberText(getBinding());
        applyTitleBarState(((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), false);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        OBottomActionBarFloating r1 = getBinding().memoryOperationContainer;
        Intrinsics.checkNotNullExpressionValue(r1, "memoryOperationContainer");
        an.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11593(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        getBinding().memoryDelete.setOnClickListener(new $$Lambda$MemoryCalendarTabFragment$2tMhkOxU0YkihCZhsQ1pBrfInU(this));
    }

    private static final void setupTitleBar$lambda$10(MemoryCalendarTabFragment r2, View r3) {
        RunLog.INSTANCE.debug(TAG, "删除");
        r2.showDeleteDialog();
    }

    private final void toggleSelectText(String r3) {
        this.editSelectAllText = r3;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        applyTitleBarState(true, true);
        return;
    }

    private final void toggleTodayView(boolean r3) {
        this.showTodayAction = r3;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        applyTitleBarState(false, true);
        return;
    }

    private final String viewDiag(View r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        int[] r0 = new int[2];
        int[] r9 = new int[2];
        r10.getLocationInWindow(r0);
        r10.getLocationOnScreen(r9);
        ViewGroup.LayoutParams r1 = r10.getLayoutParams();
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L10:
        if (r2 == null) goto L12;
        String r4 = " margin=" + r2.leftMargin + ',' + r2.topMargin + ',' + r2.rightMargin + ',' + r2.bottomMargin;
    L13:
        String r5 = "";
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        ViewParent r6 = r10.getParent();
        if (ZeusTransformUtils.instanceOf(r6, View.class) == false) goto L19;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
    L20:
        if (r7 == null) goto L27;
        Class<?> r8 = r7.getClass();
        if (r8 == null) goto L27;
        String r11 = r8.getSimpleName();
        if (r11 == null) goto L27;
        r3 = r11;
    L33:
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.class) == false) goto L35;
        r5 = ",clipChildren=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin")).getClipChildren() + ",clipToPadding=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin")).getClipToPadding() + ",childCount=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L35:
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.getClass().getSimpleName()).append("@win=").append(r0[0]).append(',').append(r0[1]).append(" screen=").append(r9[0]).append(',').append(r9[1]).append(" size=").append(r10.getWidth()).append('x').append(r10.getHeight()).append(" top=").append(r10.getTop()).append(" bottom=").append(r10.getBottom()).append(" padding=").append(r10.getPaddingLeft()).append(',').append(r10.getPaddingTop()).append(',').append(r10.getPaddingRight());
        r12.append(',').append(r10.getPaddingBottom()).append(r4).append(" visible=").append(r10.getVisibility()).append(" alpha=").append(r10.getAlpha()).append(" tx=").append(r10.getTranslationX()).append(" ty=").append(r10.getTranslationY()).append(" parent=").append(r3).append(r5);
        return r12.toString();
    L27:
        ViewParent r13 = r10.getParent();
        if (r13 == null) goto L33;
        Class<?> r14 = r13.getClass();
        if (r14 == null) goto L33;
        r3 = r14.getSimpleName();
        goto L33
    L19:
        r7 = null;
        goto L20
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    }

    public final MemoryCalendarTabFragmentLayoutBinding getBinding() {
        MemoryCalendarTabFragmentLayoutBinding r0 = this.binding;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public abstract String getCurrentBottomTab();

    public abstract LocalDate getCurrentDate();

    public abstract kotlinx.coroutines.flow.ar<LocalDate> getCurrentDateStateFlow();

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        if (this.binding != null) goto L7;
        return null;
    L7:
        return getBinding().viewTitleNormal;
    }

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBarActionHost getCurrentFloatingTitleBarActionHost() {
        return com.obric.memorydata.ui.b.a.a(this);
    }

    public final ViewPager2 getMemoryListContainer() {
        ViewPager2 r1 = getBinding().memoryListContainer;
        Intrinsics.checkNotNullExpressionValue(r1, "memoryListContainer");
        return r1;
    }

    @Override // com.obric.memorydata.memory.ui.list.AbstractMemoryTabFragment
    public LocalDate getSelectDate() {
        return getCurrentDate();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        MemoryCalendarTabFragmentLayoutBinding r6 = MemoryCalendarTabFragmentLayoutBinding.inflate(r3, r4, false);
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        setBinding(r6);
        getBinding().viewTitleNormal.setFloatingTransitionEnabled(true);
        int r7 = com.obric.memorydata.memory.ui.b.f10769a.a();
        if (r7 <= 0) goto L5;
        applyStatusBarTop(r7);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryCalendarTabFragment$uz6bK6zr6gZuG2BO1Zp6nuTHVks(this));
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"));
        this.isRecyclerViewFirstScroll = true;
        setupTitleBar();
        ConstraintLayout r8 = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(r8, "getRoot(...)");
        setupCalendarView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        setupHeaderLayoutRefresh();
        IntentFilter r9 = new IntentFilter();
        r9.addAction("android.intent.action.DATE_CHANGED");
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L9;
        ZeusTransformUtils.registerReceiver(r10, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.dateChangeReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r9, "com.obric.memorydata.plugin");
    L9:
        return (View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"), null);
        View.OnLayoutChangeListener r0 = this.headerLayoutListener;
        if (r0 == null) goto L5;
        getBinding().titleBarContainer.removeOnLayoutChangeListener(r0);
        getBinding().viewTitleNormal.removeOnLayoutChangeListener(r0);
        getBinding().calendarBarContainer.getRoot().removeOnLayoutChangeListener(r0);
        getBinding().memoryListContainer.removeOnLayoutChangeListener(r0);
    L5:
        this.headerLayoutListener = null;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        ZeusTransformUtils.unregisterReceiver(r1, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.dateChangeReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    L8:
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LocalDate r0 = LocalDate.now();
        m r1 = this.memoryCalendarAdapter;
        m r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
        r1 = null;
    L5:
        Intrinsics.checkNotNull(r0);
        if (r1.c(r0) == false) goto L12;
        m r4 = this.memoryCalendarAdapter;
        if (r4 != null) goto L10;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
    L11:
        r2.b(r0);
        return;
    L10:
        r2 = r4;
        goto L11
    L12:
        m r3 = this.memoryCalendarAdapter;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
        r3 = null;
    L16:
        if (r3.b() == false) goto L21;
        refreshCalendar();
        r4 = this.memoryCalendarAdapter;
        if (r4 != null) goto L10;
    }

    public abstract void refreshCalendar();

    @Override // com.obric.memorydata.memory.ui.list.ac
    public void resetNestedViewPagerScroll() {
        if (this.binding == null) goto L6;
        ViewPager2 r1 = getBinding().memoryListContainer;
        Intrinsics.checkNotNullExpressionValue(r1, "memoryListContainer");
        com.obric.memorydata.memory.ui.m.a(r1);
        return;
    }

    public final void setBinding(MemoryCalendarTabFragmentLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.binding = r2;
    }

    public abstract void setCurrentDate(LocalDate r1);

    public final void setNormalTitleBarSubtitle(String r3) {
        this.normalSubtitle = r3;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        applyTitleBarState(false, true);
        return;
    }

    public final void setNormalTitleBarTitle(String r3) {
        this.normalTitle = r3;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        applyTitleBarState(false, true);
        return;
    }

    public abstract void setupCalendarDateData(m r1, LinearLayoutManager r2, RecyclerView r3);

    public abstract void setupDayNumberText(MemoryCalendarTabFragmentLayoutBinding r1);

    public final void updateCalendarAdapterOnSelectDateChange(LocalDate r5, LinearLayoutManager r6, RecyclerView r7) {
        Intrinsics.checkNotNullParameter(r6, "layoutManager");
        Intrinsics.checkNotNullParameter(r7, "recyclerView");
        if (r5 != null) goto L5;
        return;
    L5:
        m r8 = this.memoryCalendarAdapter;
        m r0 = null;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
        r8 = null;
    L8:
        int r9 = r8.c();
        m r2 = this.memoryCalendarAdapter;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
    L12:
        Integer r10 = r0.a(r5);
        if (r10 != null) goto L15;
        return;
    L15:
        if (r10.intValue() < 0) goto L30;
        boolean r1 = !this.isRecyclerViewFirstScroll;
        if (r1 == true) goto L19;
    L23:
        int r11 = r10.intValue();
        if (r1 == false) goto L26;
        r7.smoothScrollToPosition(r11);
    L27:
        this.isRecyclerViewFirstScroll = false;
        return;
    L26:
        r7.scrollToPosition(r11);
        goto L27
    L19:
        if (r9 == (-1)) goto L23;
        if (Math.abs(r10.intValue() - r9) <= 1) goto L23;
        r1 = false;
        goto L23
    L30:
        return;
    L11:
        r0 = r2;
        goto L12
    }
}
