package com.larus.business.multitask_management.impl.sheet;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.business.multitask_management.impl.component.DiscoverServicesFeature;
import com.larus.business.multitask_management.impl.component.OngoingTaskListAdapter;
import com.larus.business.multitask_management.impl.component.OngoingTasksFeature;
import com.larus.business.multitask_management.impl.component.PinnedServicesFeature;
import com.larus.business.multitask_management.impl.component.RecentServicesFeature;
import com.larus.business.multitask_management.impl.view.MtmQuickAccessScreenMenu;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.multitask_management.api.IMultiTaskHostAbility;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.j3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import org.json.JSONException;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020(H\u0016J7\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010\u00032\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002¢\u0006\u0002\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MultiTaskManagementSheetComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "disallowParentInterceptOnTouchDown", "", "enableCardShadow", "<init>", "(ZZ)V", "pinnedServicesAbility", "Lcom/larus/business/multitask_management/impl/component/IPinnedServicesAbility;", "getPinnedServicesAbility", "()Lcom/larus/business/multitask_management/impl/component/IPinnedServicesAbility;", "pinnedServicesAbility$delegate", "Lkotlin/Lazy;", "ongoingTasksAbility", "Lcom/larus/business/multitask_management/impl/component/IOngoingTasksAbility;", "getOngoingTasksAbility", "()Lcom/larus/business/multitask_management/impl/component/IOngoingTasksAbility;", "ongoingTasksAbility$delegate", "recentServicesAbility", "Lcom/larus/business/multitask_management/impl/component/IRecentServicesAbility;", "getRecentServicesAbility", "()Lcom/larus/business/multitask_management/impl/component/IRecentServicesAbility;", "recentServicesAbility$delegate", "discoverServicesAbility", "Lcom/larus/business/multitask_management/impl/component/IDiscoverServicesAbility;", "getDiscoverServicesAbility", "()Lcom/larus/business/multitask_management/impl/component/IDiscoverServicesAbility;", "discoverServicesAbility$delegate", "pinnedAdapter", "Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter;", "ongoingAdapter", "Lcom/larus/business/multitask_management/impl/component/OngoingTaskListAdapter;", "recentAdapter", "discoverAdapter", "screenMenu", "Lcom/larus/bmhome/view/screenmenu/ScreenMenu;", "language", "", "refreshRecent", "onViewCreated", "", "view", "Landroid/view/View;", "onResume", "showQuickAccessMenu", "anchorView", "pinned", "node", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "enterMethod", "bindingAdapterPosition", "", "(Landroid/view/View;Ljava/lang/Boolean;Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;Ljava/lang/String;I)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskManagementSheetComponent extends BaseContentWidget {
    public static final /* synthetic */ int z = 0;
    public final boolean m;
    public final boolean n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public MtmServiceSectionAdapter s;
    public OngoingTaskListAdapter t;
    public MtmServiceSectionAdapter u;
    public MtmServiceSectionAdapter v;
    public x0 w;
    public String x;
    public boolean y;

    public static final class a {
    }

    public static final class b implements Function0<com.larus.business.multitask_management.impl.component.c> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.business.multitask_management.impl.component.c.class));
        }
    }

    public static final class c implements Function0<com.larus.business.multitask_management.impl.component.b> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.business.multitask_management.impl.component.b.class));
        }
    }

    public static final class d implements Function0<com.larus.business.multitask_management.impl.component.d> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.business.multitask_management.impl.component.d.class));
        }
    }

    public static final class e implements Function0<com.larus.business.multitask_management.impl.component.a> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.business.multitask_management.impl.component.a.class));
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$6", f = "MultiTaskManagementSheetComponent.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcatAdapter $concatAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $discoverAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $discoverHeaderAdapter;
        final /* synthetic */ MtmEmptyStateAdapter $emptyStateAdapter;
        final /* synthetic */ Ref.BooleanRef $hasDiscover;
        final /* synthetic */ Ref.BooleanRef $hasOngoing;
        final /* synthetic */ Ref.BooleanRef $hasPinned;
        final /* synthetic */ Ref.BooleanRef $hasRecent;
        final /* synthetic */ boolean $hideOngoingTasks;
        final /* synthetic */ boolean $hidePinnedServices;
        final /* synthetic */ OngoingTaskListAdapter $ongoingAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $ongoingHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $pinnedAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $pinnedHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $recentAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $recentHeaderAdapter;
        int label;
        final /* synthetic */ MultiTaskManagementSheetComponent this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$6$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MtmServiceSectionAdapter a;
            public final /* synthetic */ Ref.BooleanRef b;
            public final /* synthetic */ ConcatAdapter c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ MtmSectionHeaderAdapter e;
            public final /* synthetic */ Ref.BooleanRef f;
            public final /* synthetic */ boolean g;
            public final /* synthetic */ MtmSectionHeaderAdapter h;
            public final /* synthetic */ OngoingTaskListAdapter i;
            public final /* synthetic */ Ref.BooleanRef j;
            public final /* synthetic */ MtmSectionHeaderAdapter k;
            public final /* synthetic */ MtmServiceSectionAdapter l;
            public final /* synthetic */ MtmEmptyStateAdapter m;
            public final /* synthetic */ Ref.BooleanRef n;
            public final /* synthetic */ MtmSectionHeaderAdapter o;
            public final /* synthetic */ MtmServiceSectionAdapter p;

            public a(MtmServiceSectionAdapter r3, Ref.BooleanRef r4, ConcatAdapter r5, boolean r6, MtmSectionHeaderAdapter r7, Ref.BooleanRef r8, boolean r9, MtmSectionHeaderAdapter r10, OngoingTaskListAdapter r11, Ref.BooleanRef r12, MtmSectionHeaderAdapter r13, MtmServiceSectionAdapter r14, MtmEmptyStateAdapter r15, Ref.BooleanRef r16, MtmSectionHeaderAdapter r17, MtmServiceSectionAdapter r18) {
                this.a = r3;
                this.b = r4;
                this.c = r5;
                this.d = r6;
                this.e = r7;
                this.f = r8;
                this.g = r9;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                this.k = r13;
                this.l = r14;
                this.m = r15;
                this.n = r16;
                this.o = r17;
                this.p = r18;
            }

            public final Object emit(Object r19, Continuation r20) {
                com.larus.business.multitask_management.impl.component.i r1 = (com.larus.business.multitask_management.impl.component.i) r19;
                this.a.A2(r1.a, r1.b, r1.c);
                boolean r2 = !r1.a.isEmpty();
                Ref.BooleanRef r3 = this.b;
                if (r2 == r3.element) goto L6;
                r3.element = r2;
                MultiTaskManagementSheetComponent.m3(this.c, r3, this.d, this.e, this.a, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass6(MultiTaskManagementSheetComponent r4, MtmServiceSectionAdapter r5, Ref.BooleanRef r6, ConcatAdapter r7, boolean r8, MtmSectionHeaderAdapter r9, Ref.BooleanRef r10, boolean r11, MtmSectionHeaderAdapter r12, OngoingTaskListAdapter r13, Ref.BooleanRef r14, MtmSectionHeaderAdapter r15, MtmServiceSectionAdapter r16, MtmEmptyStateAdapter r17, Ref.BooleanRef r18, MtmSectionHeaderAdapter r19, MtmServiceSectionAdapter r20, Continuation<? super AnonymousClass6> r21) {
            this.this$0 = r4;
            this.$pinnedAdapter = r5;
            this.$hasPinned = r6;
            this.$concatAdapter = r7;
            this.$hidePinnedServices = r8;
            this.$pinnedHeaderAdapter = r9;
            this.$hasOngoing = r10;
            this.$hideOngoingTasks = r11;
            this.$ongoingHeaderAdapter = r12;
            this.$ongoingAdapter = r13;
            this.$hasRecent = r14;
            this.$recentHeaderAdapter = r15;
            this.$recentAdapter = r16;
            this.$emptyStateAdapter = r17;
            this.$hasDiscover = r18;
            this.$discoverHeaderAdapter = r19;
            this.$discoverAdapter = r20;
            super(2, r21);
        }

        public final Continuation<Unit> create(Object r22, Continuation<?> r23) {
            return new AnonymousClass6(this.this$0, this.$pinnedAdapter, this.$hasPinned, this.$concatAdapter, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter, r23);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L6;
            ResultKt.throwOnFailure(r23);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r23);
            MultiTaskManagementSheetComponent r3 = this.this$0;
            int r4 = MultiTaskManagementSheetComponent.z;
            com.larus.business.multitask_management.impl.component.c r5 = r3.Y2();
            if (r5 == null) goto L18;
            StateFlowImpl r6 = r5.HO();
            if (r6 == null) goto L18;
            a r15 = new a(this.$pinnedAdapter, this.$hasPinned, this.$concatAdapter, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter);
            this.label = 1;
            if (r6.collect(r15, this) != r1) goto L16;
            return r1;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$7", f = "MultiTaskManagementSheetComponent.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcatAdapter $concatAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $discoverAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $discoverHeaderAdapter;
        final /* synthetic */ MtmEmptyStateAdapter $emptyStateAdapter;
        final /* synthetic */ Ref.BooleanRef $hasDiscover;
        final /* synthetic */ Ref.BooleanRef $hasOngoing;
        final /* synthetic */ Ref.BooleanRef $hasPinned;
        final /* synthetic */ Ref.BooleanRef $hasRecent;
        final /* synthetic */ boolean $hideOngoingTasks;
        final /* synthetic */ boolean $hidePinnedServices;
        final /* synthetic */ OngoingTaskListAdapter $ongoingAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $ongoingHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $pinnedAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $pinnedHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $recentAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $recentHeaderAdapter;
        int label;
        final /* synthetic */ MultiTaskManagementSheetComponent this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$7$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ OngoingTaskListAdapter a;
            public final /* synthetic */ Ref.BooleanRef b;
            public final /* synthetic */ ConcatAdapter c;
            public final /* synthetic */ Ref.BooleanRef d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ MtmSectionHeaderAdapter f;
            public final /* synthetic */ MtmServiceSectionAdapter g;
            public final /* synthetic */ boolean h;
            public final /* synthetic */ MtmSectionHeaderAdapter i;
            public final /* synthetic */ Ref.BooleanRef j;
            public final /* synthetic */ MtmSectionHeaderAdapter k;
            public final /* synthetic */ MtmServiceSectionAdapter l;
            public final /* synthetic */ MtmEmptyStateAdapter m;
            public final /* synthetic */ Ref.BooleanRef n;
            public final /* synthetic */ MtmSectionHeaderAdapter o;
            public final /* synthetic */ MtmServiceSectionAdapter p;

            public a(OngoingTaskListAdapter r3, Ref.BooleanRef r4, ConcatAdapter r5, Ref.BooleanRef r6, boolean r7, MtmSectionHeaderAdapter r8, MtmServiceSectionAdapter r9, boolean r10, MtmSectionHeaderAdapter r11, Ref.BooleanRef r12, MtmSectionHeaderAdapter r13, MtmServiceSectionAdapter r14, MtmEmptyStateAdapter r15, Ref.BooleanRef r16, MtmSectionHeaderAdapter r17, MtmServiceSectionAdapter r18) {
                this.a = r3;
                this.b = r4;
                this.c = r5;
                this.d = r6;
                this.e = r7;
                this.f = r8;
                this.g = r9;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                this.k = r13;
                this.l = r14;
                this.m = r15;
                this.n = r16;
                this.o = r17;
                this.p = r18;
            }

            public final Object emit(Object r19, Continuation r20) {
                List<kl9.u> r1 = (List) r19;
                this.a.C2(r1);
                boolean r2 = !r1.isEmpty();
                Ref.BooleanRef r7 = this.b;
                if (r2 == r7.element) goto L6;
                r7.element = r2;
                MultiTaskManagementSheetComponent.m3(this.c, this.d, this.e, this.f, this.g, r7, this.h, this.i, this.a, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass7(MultiTaskManagementSheetComponent r4, OngoingTaskListAdapter r5, Ref.BooleanRef r6, ConcatAdapter r7, Ref.BooleanRef r8, boolean r9, MtmSectionHeaderAdapter r10, MtmServiceSectionAdapter r11, boolean r12, MtmSectionHeaderAdapter r13, Ref.BooleanRef r14, MtmSectionHeaderAdapter r15, MtmServiceSectionAdapter r16, MtmEmptyStateAdapter r17, Ref.BooleanRef r18, MtmSectionHeaderAdapter r19, MtmServiceSectionAdapter r20, Continuation<? super AnonymousClass7> r21) {
            this.this$0 = r4;
            this.$ongoingAdapter = r5;
            this.$hasOngoing = r6;
            this.$concatAdapter = r7;
            this.$hasPinned = r8;
            this.$hidePinnedServices = r9;
            this.$pinnedHeaderAdapter = r10;
            this.$pinnedAdapter = r11;
            this.$hideOngoingTasks = r12;
            this.$ongoingHeaderAdapter = r13;
            this.$hasRecent = r14;
            this.$recentHeaderAdapter = r15;
            this.$recentAdapter = r16;
            this.$emptyStateAdapter = r17;
            this.$hasDiscover = r18;
            this.$discoverHeaderAdapter = r19;
            this.$discoverAdapter = r20;
            super(2, r21);
        }

        public final Continuation<Unit> create(Object r22, Continuation<?> r23) {
            return new AnonymousClass7(this.this$0, this.$ongoingAdapter, this.$hasOngoing, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter, r23);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L6;
            ResultKt.throwOnFailure(r23);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r23);
            MultiTaskManagementSheetComponent r3 = this.this$0;
            int r4 = MultiTaskManagementSheetComponent.z;
            com.larus.business.multitask_management.impl.component.b r5 = (com.larus.business.multitask_management.impl.component.b) r3.p.getValue();
            if (r5 == null) goto L18;
            i1<List<kl9.u>> r6 = r5.jc();
            if (r6 == null) goto L18;
            a r15 = new a(this.$ongoingAdapter, this.$hasOngoing, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter);
            this.label = 1;
            if (r6.collect(r15, this) != r1) goto L16;
            return r1;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$8", f = "MultiTaskManagementSheetComponent.kt", i = {}, l = {466}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcatAdapter $concatAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $discoverAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $discoverHeaderAdapter;
        final /* synthetic */ MtmEmptyStateAdapter $emptyStateAdapter;
        final /* synthetic */ Ref.BooleanRef $hasDiscover;
        final /* synthetic */ Ref.BooleanRef $hasOngoing;
        final /* synthetic */ Ref.BooleanRef $hasPinned;
        final /* synthetic */ Ref.BooleanRef $hasRecent;
        final /* synthetic */ boolean $hideOngoingTasks;
        final /* synthetic */ boolean $hidePinnedServices;
        final /* synthetic */ OngoingTaskListAdapter $ongoingAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $ongoingHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $pinnedAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $pinnedHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $recentAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $recentHeaderAdapter;
        int label;
        final /* synthetic */ MultiTaskManagementSheetComponent this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$8$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MtmServiceSectionAdapter a;
            public final /* synthetic */ Ref.BooleanRef b;
            public final /* synthetic */ ConcatAdapter c;
            public final /* synthetic */ Ref.BooleanRef d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ MtmSectionHeaderAdapter f;
            public final /* synthetic */ MtmServiceSectionAdapter g;
            public final /* synthetic */ Ref.BooleanRef h;
            public final /* synthetic */ boolean i;
            public final /* synthetic */ MtmSectionHeaderAdapter j;
            public final /* synthetic */ OngoingTaskListAdapter k;
            public final /* synthetic */ MtmSectionHeaderAdapter l;
            public final /* synthetic */ MtmEmptyStateAdapter m;
            public final /* synthetic */ Ref.BooleanRef n;
            public final /* synthetic */ MtmSectionHeaderAdapter o;
            public final /* synthetic */ MtmServiceSectionAdapter p;

            public a(MtmServiceSectionAdapter r3, Ref.BooleanRef r4, ConcatAdapter r5, Ref.BooleanRef r6, boolean r7, MtmSectionHeaderAdapter r8, MtmServiceSectionAdapter r9, Ref.BooleanRef r10, boolean r11, MtmSectionHeaderAdapter r12, OngoingTaskListAdapter r13, MtmSectionHeaderAdapter r14, MtmEmptyStateAdapter r15, Ref.BooleanRef r16, MtmSectionHeaderAdapter r17, MtmServiceSectionAdapter r18) {
                this.a = r3;
                this.b = r4;
                this.c = r5;
                this.d = r6;
                this.e = r7;
                this.f = r8;
                this.g = r9;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                this.k = r13;
                this.l = r14;
                this.m = r15;
                this.n = r16;
                this.o = r17;
                this.p = r18;
            }

            public final Object emit(Object r19, Continuation r20) {
                com.larus.business.multitask_management.impl.component.i r1 = (com.larus.business.multitask_management.impl.component.i) r19;
                this.a.A2(r1.a, r1.b, r1.c);
                boolean r2 = !r1.a.isEmpty();
                Ref.BooleanRef r11 = this.b;
                if (r2 == r11.element) goto L6;
                r11.element = r2;
                MultiTaskManagementSheetComponent.m3(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, r11, this.l, this.a, this.m, this.n, this.o, this.p);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass8(MultiTaskManagementSheetComponent r4, MtmServiceSectionAdapter r5, Ref.BooleanRef r6, ConcatAdapter r7, Ref.BooleanRef r8, boolean r9, MtmSectionHeaderAdapter r10, MtmServiceSectionAdapter r11, Ref.BooleanRef r12, boolean r13, MtmSectionHeaderAdapter r14, OngoingTaskListAdapter r15, MtmSectionHeaderAdapter r16, MtmEmptyStateAdapter r17, Ref.BooleanRef r18, MtmSectionHeaderAdapter r19, MtmServiceSectionAdapter r20, Continuation<? super AnonymousClass8> r21) {
            this.this$0 = r4;
            this.$recentAdapter = r5;
            this.$hasRecent = r6;
            this.$concatAdapter = r7;
            this.$hasPinned = r8;
            this.$hidePinnedServices = r9;
            this.$pinnedHeaderAdapter = r10;
            this.$pinnedAdapter = r11;
            this.$hasOngoing = r12;
            this.$hideOngoingTasks = r13;
            this.$ongoingHeaderAdapter = r14;
            this.$ongoingAdapter = r15;
            this.$recentHeaderAdapter = r16;
            this.$emptyStateAdapter = r17;
            this.$hasDiscover = r18;
            this.$discoverHeaderAdapter = r19;
            this.$discoverAdapter = r20;
            super(2, r21);
        }

        public final Continuation<Unit> create(Object r22, Continuation<?> r23) {
            return new AnonymousClass8(this.this$0, this.$recentAdapter, this.$hasRecent, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$recentHeaderAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter, r23);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L6;
            ResultKt.throwOnFailure(r23);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r23);
            MultiTaskManagementSheetComponent r3 = this.this$0;
            int r4 = MultiTaskManagementSheetComponent.z;
            com.larus.business.multitask_management.impl.component.d r5 = r3.h3();
            if (r5 == null) goto L18;
            StateFlowImpl r6 = r5.vl();
            if (r6 == null) goto L18;
            a r15 = new a(this.$recentAdapter, this.$hasRecent, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$recentHeaderAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter);
            this.label = 1;
            if (r6.collect(r15, this) != r1) goto L16;
            return r1;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$9", f = "MultiTaskManagementSheetComponent.kt", i = {}, l = {477}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcatAdapter $concatAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $discoverAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $discoverHeaderAdapter;
        final /* synthetic */ MtmEmptyStateAdapter $emptyStateAdapter;
        final /* synthetic */ Ref.BooleanRef $hasDiscover;
        final /* synthetic */ Ref.BooleanRef $hasOngoing;
        final /* synthetic */ Ref.BooleanRef $hasPinned;
        final /* synthetic */ Ref.BooleanRef $hasRecent;
        final /* synthetic */ boolean $hideOngoingTasks;
        final /* synthetic */ boolean $hidePinnedServices;
        final /* synthetic */ OngoingTaskListAdapter $ongoingAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $ongoingHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $pinnedAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $pinnedHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $recentAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $recentHeaderAdapter;
        int label;
        final /* synthetic */ MultiTaskManagementSheetComponent this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$9$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MtmServiceSectionAdapter a;
            public final /* synthetic */ Ref.BooleanRef b;
            public final /* synthetic */ ConcatAdapter c;
            public final /* synthetic */ Ref.BooleanRef d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ MtmSectionHeaderAdapter f;
            public final /* synthetic */ MtmServiceSectionAdapter g;
            public final /* synthetic */ Ref.BooleanRef h;
            public final /* synthetic */ boolean i;
            public final /* synthetic */ MtmSectionHeaderAdapter j;
            public final /* synthetic */ OngoingTaskListAdapter k;
            public final /* synthetic */ Ref.BooleanRef l;
            public final /* synthetic */ MtmSectionHeaderAdapter m;
            public final /* synthetic */ MtmServiceSectionAdapter n;
            public final /* synthetic */ MtmEmptyStateAdapter o;
            public final /* synthetic */ MtmSectionHeaderAdapter p;

            public a(MtmServiceSectionAdapter r3, Ref.BooleanRef r4, ConcatAdapter r5, Ref.BooleanRef r6, boolean r7, MtmSectionHeaderAdapter r8, MtmServiceSectionAdapter r9, Ref.BooleanRef r10, boolean r11, MtmSectionHeaderAdapter r12, OngoingTaskListAdapter r13, Ref.BooleanRef r14, MtmSectionHeaderAdapter r15, MtmServiceSectionAdapter r16, MtmEmptyStateAdapter r17, MtmSectionHeaderAdapter r18) {
                this.a = r3;
                this.b = r4;
                this.c = r5;
                this.d = r6;
                this.e = r7;
                this.f = r8;
                this.g = r9;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                this.k = r13;
                this.l = r14;
                this.m = r15;
                this.n = r16;
                this.o = r17;
                this.p = r18;
            }

            public final Object emit(Object r19, Continuation r20) {
                com.larus.business.multitask_management.impl.component.i r1 = (com.larus.business.multitask_management.impl.component.i) r19;
                this.a.A2(r1.a, r1.b, r1.c);
                boolean r2 = !r1.a.isEmpty();
                Ref.BooleanRef r15 = this.b;
                if (r2 == r15.element) goto L6;
                r15.element = r2;
                MultiTaskManagementSheetComponent.m3(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, r15, this.p, this.a);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass9(MultiTaskManagementSheetComponent r4, MtmServiceSectionAdapter r5, Ref.BooleanRef r6, ConcatAdapter r7, Ref.BooleanRef r8, boolean r9, MtmSectionHeaderAdapter r10, MtmServiceSectionAdapter r11, Ref.BooleanRef r12, boolean r13, MtmSectionHeaderAdapter r14, OngoingTaskListAdapter r15, Ref.BooleanRef r16, MtmSectionHeaderAdapter r17, MtmServiceSectionAdapter r18, MtmEmptyStateAdapter r19, MtmSectionHeaderAdapter r20, Continuation<? super AnonymousClass9> r21) {
            this.this$0 = r4;
            this.$discoverAdapter = r5;
            this.$hasDiscover = r6;
            this.$concatAdapter = r7;
            this.$hasPinned = r8;
            this.$hidePinnedServices = r9;
            this.$pinnedHeaderAdapter = r10;
            this.$pinnedAdapter = r11;
            this.$hasOngoing = r12;
            this.$hideOngoingTasks = r13;
            this.$ongoingHeaderAdapter = r14;
            this.$ongoingAdapter = r15;
            this.$hasRecent = r16;
            this.$recentHeaderAdapter = r17;
            this.$recentAdapter = r18;
            this.$emptyStateAdapter = r19;
            this.$discoverHeaderAdapter = r20;
            super(2, r21);
        }

        public final Continuation<Unit> create(Object r22, Continuation<?> r23) {
            return new AnonymousClass9(this.this$0, this.$discoverAdapter, this.$hasDiscover, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$discoverHeaderAdapter, r23);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L6;
            ResultKt.throwOnFailure(r23);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r23);
            MultiTaskManagementSheetComponent r3 = this.this$0;
            int r4 = MultiTaskManagementSheetComponent.z;
            com.larus.business.multitask_management.impl.component.a r5 = (com.larus.business.multitask_management.impl.component.a) r3.r.getValue();
            if (r5 == null) goto L18;
            StateFlowImpl r6 = r5.Ng();
            if (r6 == null) goto L18;
            a r15 = new a(this.$discoverAdapter, this.$hasDiscover, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$discoverHeaderAdapter);
            this.label = 1;
            if (r6.collect(r15, this) != r1) goto L16;
            return r1;
        L18:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public MultiTaskManagementSheetComponent() {
        this(0);
    }

    public final com.larus.business.multitask_management.impl.component.c Y2() {
        return (com.larus.business.multitask_management.impl.component.c) this.o.getValue();
    }

    public final com.larus.business.multitask_management.impl.component.d h3() {
        return (com.larus.business.multitask_management.impl.component.d) this.q.getValue();
    }

    public final void onResume() {
        IMultiTaskHostAbility r0 = (IMultiTaskHostAbility) ServiceManager.get().getService(IMultiTaskHostAbility.class);
        if (r0 == null) goto L5;
        String r1 = r0.getLanguage();
    L6:
        String r2 = this.x;
        if (r2 == null) goto L20;
        if (Intrinsics.areEqual(r2, r1) == true) goto L20;
        FLogger.a.i("multitask-MultiTaskManagementSheetComponent", "refresh by language: " + this.x + " -> " + r1);
        com.larus.business.multitask_management.impl.component.c r3 = Y2();
        if (r3 == null) goto L13;
        r3.J(false);
    L13:
        com.larus.business.multitask_management.impl.component.d r4 = h3();
        if (r4 == null) goto L16;
        r4.J(false);
    L16:
        com.larus.business.multitask_management.impl.component.a r5 = (com.larus.business.multitask_management.impl.component.a) this.r.getValue();
        if (r5 == null) goto L24;
        r5.J(false);
    L24:
        this.x = r1;
        this.y = false;
        return;
    L20:
        if (this.y == false) goto L24;
        com.larus.business.multitask_management.impl.component.d r6 = h3();
        if (r6 == null) goto L24;
        r6.J(false);
        goto L24
    L5:
        r1 = null;
        goto L6
    }

    public /* synthetic */ MultiTaskManagementSheetComponent(int r2) {
        this(true, false);
    }

    public final void onViewCreated(View r92) {
        Intrinsics.checkNotNullParameter(r92, "view");
        RecyclerView r1 = r92.findViewById(2131380395);
        if ((r1 instanceof RecyclerView) == false) goto L5;
        RecyclerView r2 = r1;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        final View r3 = r92.findViewById(2131380413);
        j3 r4 = z2.a.getMultiTaskEntranceConfig();
        boolean r63 = r4.e();
        boolean r67 = r4.a();
        x0 r5 = new x0();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r5.d(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        this.w = r5;
        com.larus.business.multitask_management.impl.component.j r6 = PinnedServicesFeature.t.a(r92.getContext());
        com.larus.business.multitask_management.impl.component.c r7 = Y2();
        if (r7 == null) goto L16;
        StateFlowImpl r8 = r7.HO();
        if (r8 == null) goto L16;
        com.larus.business.multitask_management.impl.component.i r9 = (com.larus.business.multitask_management.impl.component.i) r8.getValue();
        if (r9 == null) goto L16;
        List<ll9.t> r10 = r9.a;
        if (r10 == null) goto L16;
    L17:
        MtmSectionHeaderAdapter r12 = new MtmSectionHeaderAdapter(r6.a, r6.e);
        final MtmServiceSectionAdapter r11 = new MtmServiceSectionAdapter("multitask-PinnedServicesFeature", r10, r6, true, 6, this.n, new r(this), new x(this));
        this.s = r11;
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        r13.element = !r10.isEmpty();
        com.larus.business.multitask_management.impl.component.j r14 = OngoingTasksFeature.i.a(r92.getContext());
        com.larus.business.multitask_management.impl.component.b r15 = (com.larus.business.multitask_management.impl.component.b) this.p.getValue();
        if (r15 == null) goto L23;
        i1<List<kl9.u>> r16 = r15.jc();
        if (r16 == null) goto L23;
        List r17 = (List) r16.getValue();
        if (r17 == null) goto L23;
    L24:
        MtmSectionHeaderAdapter r18 = new MtmSectionHeaderAdapter(r14.a, r14.e);
        final OngoingTaskListAdapter r19 = new OngoingTaskListAdapter(r17, false, true, 3, this.n, new y(this));
        r19.h = true;
        r19.g = 1.0f;
        this.t = r19;
        Ref.BooleanRef r20 = new Ref.BooleanRef();
        r20.element = !r17.isEmpty();
        com.larus.business.multitask_management.impl.component.j r21 = RecentServicesFeature.r.a(r92.getContext());
        com.larus.business.multitask_management.impl.component.d r110 = h3();
        if (r110 == null) goto L32;
        StateFlowImpl r111 = r110.vl();
        if (r111 == null) goto L32;
        com.larus.business.multitask_management.impl.component.i r112 = (com.larus.business.multitask_management.impl.component.i) r111.getValue();
        if (r112 == null) goto L32;
        List<ll9.t> r113 = r112.a;
        if (r113 == null) goto L32;
    L33:
        MtmSectionHeaderAdapter r114 = new MtmSectionHeaderAdapter(r21.a, r21.e);
        final MtmServiceSectionAdapter r22 = new MtmServiceSectionAdapter("multitask-RecentServicesFeature", r113, r21, true, 8, this.n, new z(this), new a0(this));
        this.u = r22;
        Ref.BooleanRef r23 = new Ref.BooleanRef();
        r23.element = !r113.isEmpty();
        com.larus.business.multitask_management.impl.component.j r0 = DiscoverServicesFeature.r.a(r92.getContext());
        com.larus.business.multitask_management.impl.component.a r24 = (com.larus.business.multitask_management.impl.component.a) this.r.getValue();
        if (r24 == null) goto L41;
        StateFlowImpl r25 = r24.Ng();
        if (r25 == null) goto L41;
        com.larus.business.multitask_management.impl.component.i r26 = (com.larus.business.multitask_management.impl.component.i) r25.getValue();
        if (r26 == null) goto L41;
        List<ll9.t> r27 = r26.a;
        if (r27 == null) goto L41;
    L42:
        MtmSectionHeaderAdapter r28 = new MtmSectionHeaderAdapter(r0.a, r0.e);
        final RecyclerView r115 = r2;
        final MtmServiceSectionAdapter r116 = new MtmServiceSectionAdapter("multitask-DiscoverServicesFeature", r27, r0, false, Integer.MAX_VALUE, this.n, new b0(this), new c0(this));
        this.v = r116;
        Ref.BooleanRef r29 = new Ref.BooleanRef();
        r29.element = !r27.isEmpty();
        MtmEmptyStateAdapter r30 = new MtmEmptyStateAdapter(getContext().getString(2131899752));
        final ConcatAdapter r117 = new ConcatAdapter(new RecyclerView.Adapter[0]);
        m3(r117, r13, r63, r12, r11, r20, r67, r18, r19, r23, r114, r22, r30, r29, r28, r116);
        GridLayoutManager r31 = new GridLayoutManager(r92.getContext(), 2);
        r31.setSpanSizeLookup(new MtmConcatSpanSizeLookup(r117));
        r115.setLayoutManager(r31);
        r115.setAdapter(r117);
        r115.setItemAnimator(null);
        r115.addOnItemTouchListener(new AnonymousClass1(this));
        r115.addItemDecoration(new MtmSheetItemDecoration(r14.g));
        y6.d(r115, new d0(r117), null, null, new e0(r19, r11, r22, r116), 13);
        r115.addOnScrollListener(new AnonymousClass4(r3, r115));
        r115.post(new f0(r3, r115));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass6(this, r11, r13, r117, r63, r12, r20, r67, r18, r19, r23, r114, r22, r30, r29, r28, r116, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass7(this, r19, r20, r117, r13, r63, r12, r11, r67, r18, r23, r114, r22, r30, r29, r28, r116, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass8(this, r22, r23, r117, r13, r63, r12, r11, r20, r67, r18, r19, r114, r30, r29, r28, r116, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass9(this, r116, r29, r117, r13, r63, r12, r11, r20, r67, r18, r19, r23, r114, r22, r30, r28, null), 3, null);
        return;
    L41:
        r27 = CollectionsKt.emptyList();
    L32:
        r113 = CollectionsKt.emptyList();
    L23:
        r17 = CollectionsKt.emptyList();
    L16:
        r10 = CollectionsKt.emptyList();
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    public MultiTaskManagementSheetComponent(boolean r1, boolean r2) {
        this.m = r1;
        this.n = r2;
        this.o = LazyKt.lazy(new b(this));
        this.p = LazyKt.lazy(new c(this));
        this.q = LazyKt.lazy(new d(this));
        this.r = LazyKt.lazy(new e(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.business.multitask_management.impl.sheet.t] */
    public final void p3(final View r17, Boolean r18, final ll9.t r19, final String r20, final int r21) {
        final x0 r11 = this.w;
        if (r11 != null) goto L5;
        return;
    L5:
        String r1 = String.valueOf(r19.a.getValue());
        String r2 = r19.c;
        String r3 = r19.b;
        Integer r4 = Integer.valueOf(r21 + 1);
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "params");
        r5.put("current_page", "multi_task_manage");     // Catch: JSONException -> L20
        r5.put("enter_method", r20);     // Catch: JSONException -> L11
        if (r1 == null) goto L13;
        r5.put("node_type", r1);     // Catch: JSONException -> L11
    L13:
        if (r2 == null) goto L15;
        r5.put("node_title", r2);     // Catch: JSONException -> L11
    L15:
        if (r3 == null) goto L17;
        r5.put("reference_id", r3);     // Catch: JSONException -> L11
    L17:
        if (r4 == null) goto L23;
        r5.put("index", r4.toString());     // Catch: JSONException -> L11
    L23:
        TrackParams r0 = new TrackParams().merge(r5);
        by7.a r6 = new by7.a("long_press_service");
        r6.a.merge(r0);
        r6.b();
        r17.setPressed(false);
        r17.invalidate();
        Bitmap r13 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r17.getWidth(), 1), RangesKt.coerceAtLeast(r17.getHeight(), 1), Bitmap.Config.ARGB_8888);
        r17.draw(new Canvas(r13));
        r11.i(new s(this, r17));
        final MtmQuickAccessScreenMenu r14 = new MtmQuickAccessScreenMenu(r17.getContext());
        if (r18 != null) goto L30;
        com.larus.business.multitask_management.impl.component.c r15 = Y2();
        if (r15 == 0) goto L28;
        Boolean r7 = Boolean.valueOf(r15.w90(r19, new t(r14, r20, r19, r21, this, r11)));
    L29:
        final Boolean r8 = r7;
    L31:
        r11.j(r17, false, r13, new u(r14, r8, r20, r19, r21, this, r11));
        return;
    L28:
        r7 = null;
        goto L29
    L30:
        r8 = r18;
    L11:
        e = e;
    L22:
        FLogger.a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobLongPressService " + e.getLocalizedMessage());
    L20:
        e = e;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.larus.business.multitask_management.impl.sheet.w, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.larus.business.multitask_management.impl.sheet.v, java.lang.Object] */
    public static final void z3(MtmQuickAccessScreenMenu r8, final String r9, final ll9.t r10, final int r11, final MultiTaskManagementSheetComponent r12, final x0 r13, boolean r14) {
        if (r14 == false) goto L5;
        final ?? r15 = new v(r9, r10, r11, r12, r13);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r15, "onClick");
        r8.a.d.setText(r8.getContext().getString(2131899757));
        r8.a.c.setImageResource(v19.c.b(2130972074, null, 2131243086));
        e1.d(r8.a.b, new com.larus.business.multitask_management.impl.view.g(r15));
        return;
    L5:
        final ?? r16 = new w(r9, r10, r11, r12, r13);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r16, "onClick");
        r8.a.d.setText(r8.getContext().getString(2131899756));
        r8.a.c.setImageResource(v19.c.b(2130972073, null, 2131243079));
        e1.d(r8.a.b, new com.larus.business.multitask_management.impl.view.h(r16));
    }

    public static final void m3(ConcatAdapter r7, Ref.BooleanRef r8, boolean r9, MtmSectionHeaderAdapter r10, MtmServiceSectionAdapter r11, Ref.BooleanRef r12, boolean r13, MtmSectionHeaderAdapter r14, OngoingTaskListAdapter r15, Ref.BooleanRef r16, MtmSectionHeaderAdapter r17, MtmServiceSectionAdapter r18, MtmEmptyStateAdapter r19, Ref.BooleanRef r20, MtmSectionHeaderAdapter r21, MtmServiceSectionAdapter r22) {
        List r4 = CollectionsKt.createListBuilder();
        if (r8.element == false) goto L7;
        if (r9 == true) goto L7;
        r4.add(r10);
        r4.add(r11);
    L7:
        if (r12.element == false) goto L11;
        if (r13 == true) goto L11;
        r4.add(r14);
        r4.add(r15);
    L11:
        if (r16.element == false) goto L13;
        r4.add(r17);
        r4.add(r18);
    L13:
        boolean r5 = false;
        if (r8.element == false) goto L17;
        if (r9 == true) goto L17;
        boolean r1 = true;
    L19:
        if (r12.element == false) goto L22;
        if (r13 == true) goto L22;
        r5 = true;
    L22:
        if (r1 == true) goto L28;
        if (r5 == true) goto L28;
        if (r16.element == true) goto L28;
        r4.add(r19);
    L28:
        if (r20.element == false) goto L30;
        r4.add(r21);
        r4.add(r22);
    L30:
        List r2 = CollectionsKt.build(r4);
        Iterator r3 = CollectionsKt.toList(r7.getAdapters()).iterator();
    L32:
        if (r3.hasNext() == false) goto L34;
        r7.removeAdapter((RecyclerView.Adapter) r3.next());
        goto L32
    L34:
        Iterator r6 = r2.iterator();
    L36:
        if (r6.hasNext() == false) goto L38;
        RecyclerView.Adapter r23 = (RecyclerView.Adapter) r6.next();
        com.larus.common_ui.widget.concat_adapter.a r24 = r7.a;
        r24.a(((ArrayList) r24.e).size(), r23);
        goto L36
    L38:
        return;
    L17:
        r1 = false;
        goto L19
    }
}
