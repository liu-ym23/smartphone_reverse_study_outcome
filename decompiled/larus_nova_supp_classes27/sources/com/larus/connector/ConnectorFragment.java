package com.larus.connector;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.taskskill.ui.q;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.flowskill.impl.databinding.LarusFragmentConnectorBinding;
import com.larus.flowskill.impl.databinding.LarusItemConnectorBinding;
import com.larus.flowskill.impl.databinding.LarusLayoutTaskSkillStateBinding;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;
import t19.s;
import v19.c7;
import v19.i5;
import v19.m7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b*\u0002&)\u0018\u0000 T2\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010+\u001a\u0004\u0018\u00010\u00142\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u00142\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001e\u00106\u001a\u0002032\u0006\u00107\u001a\u00020\u00142\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0014J\u0012\u00108\u001a\u0002032\b\b\u0002\u00109\u001a\u00020\u0005H\u0002J\b\u0010:\u001a\u00020\u0005H\u0002J\b\u0010;\u001a\u00020\u0005H\u0002J\u0010\u0010<\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0014H\u0002J\u001a\u0010=\u001a\u0002032\u0006\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u0019H\u0002J\b\u0010@\u001a\u000203H\u0002J\b\u0010A\u001a\u000203H\u0002J\u0010\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u0002032\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010F\u001a\u000203H\u0002J\b\u0010G\u001a\u000203H\u0002J\u0018\u0010H\u001a\u0002032\u0006\u0010C\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0019H\u0002J\b\u0010J\u001a\u000203H\u0002J\u0016\u0010K\u001a\u0002032\f\u0010L\u001a\b\u0012\u0004\u0012\u00020D0MH\u0002J\u0018\u0010N\u001a\u0002032\u0006\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020\u0019H\u0002J\b\u0010Q\u001a\u000203H\u0016J\b\u0010R\u001a\u000203H\u0002J\b\u0010S\u001a\u000203H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00190\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*¨\u0006U"}, d2 = {"Lcom/larus/connector/ConnectorFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "observedDismissRequestVersion", "", "binding", "Lcom/larus/flowskill/impl/databinding/LarusFragmentConnectorBinding;", "headerController", "Lcom/larus/common_ui/dialog/BottomSheetHeaderController;", "stateController", "Lcom/larus/bmhome/taskskill/ui/TaskSkillStateController;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "bottomSheetView", "adapter", "Lcom/larus/connector/ConnectorAdapter;", "isRequesting", "", "hasReachedExpandedState", "connectorSectionBaseBottomMargin", "connectorSectionContentHeight", "hasReportedAddConnectorShow", "pendingEnabledStates", "", "", "shownConnectorIds", "", "connectorRepository", "Lcom/larus/connector/ConnectorListRepository;", "behaviorCallback", "com/larus/connector/ConnectorFragment$behaviorCallback$1", "Lcom/larus/connector/ConnectorFragment$behaviorCallback$1;", "stopFlingOnTouchListener", "com/larus/connector/ConnectorFragment$stopFlingOnTouchListener$1", "Lcom/larus/connector/ConnectorFragment$stopFlingOnTouchListener$1;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "onViewCreated", "view", "onRoundedBottomSheetReady", "bottomSheet", "updatePanelLayout", "listItemCount", "currentExpandedPanelHeight", "connectorItemHeight", "currentVisibleSheetHeight", "updateConnectorSectionHeight", "visibleSheetHeight", "allowShrink", "bindFixedAction", "onAddConnectorClick", "openConnectorDetail", "connector", "Lcom/larus/connector/ConnectorListEntry;", "reportConnectorShow", "loadConnectors", "observeConnectorList", "setConnectorEnabled", "enabled", "showLoading", "showConnectors", "items", "", "showLoadError", "message", "hasValidCache", "onStart", "reportAddConnectorShow", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectorFragment extends RoundedBottomSheetDialogFragment {
    public static final /* synthetic */ int t = 0;
    public long d;
    public LarusFragmentConnectorBinding e;
    public q f;
    public BottomSheetBehavior<View> g;
    public View h;
    public ConnectorAdapter i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public final Map<String, Boolean> o;
    public final Set<String> p;
    public final ConnectorListRepository q;
    public final b r;
    public final ConnectorFragment$stopFlingOnTouchListener$1 s;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ ConnectorFragment a;

        public b(ConnectorFragment r1) {
            this.a = r1;
        }

        public final void onSlide(View r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            ConnectorFragment r4 = this.a;
            int r0 = ConnectorFragment.t;
            r4.aa0(r4.X90(r2), false);
        }

        public final void onStateChanged(View r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "bottomSheet");
            if (r5 != 1) goto L5;
            return;
        L5:
            if (r5 != 2) goto L7;
            return;
        L7:
            if (r5 != 3) goto L9;
            ConnectorFragment r6 = this.a;
            r6.k = true;
            BottomSheetBehavior<View> r7 = r6.g;
            if (r7 == null) goto L38;
            r7.setSkipCollapsed(true);
        L38:
            ConnectorFragment r8 = this.a;
            r8.aa0(r8.X90(r4), true);
            return;
        L9:
            if (r5 == 4) goto L19;
            if (r5 == 5) goto L40;
            ConnectorFragment r9 = this.a;
            int r1 = ConnectorFragment.t;
            r9.aa0(r9.X90(r4), true);
            return;
        L40:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r10 = DialogFragmentLancet.sLastShowStack;
            if (r10 == null) goto L45;
            com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L45:
            return;
        L19:
            ConnectorFragment r11 = this.a;
            if (r11.k == false) goto L24;
            BottomSheetBehavior<View> r12 = r11.g;
            if (r12 == null) goto L47;
            r12.setState(5);
            return;
        L47:
            return;
        L24:
            BottomSheetBehavior<View> r13 = r11.g;
            if (r13 == null) goto L49;
            Integer r14 = Integer.valueOf(r13.getPeekHeight());
            if (r14.intValue() <= 0) goto L29;
            boolean r15 = true;
        L30:
            if (r15 == true) goto L33;
            r14 = null;
        L33:
            if (r14 == null) goto L50;
            this.a.aa0(r14.intValue(), true);
            return;
        L50:
            return;
        L29:
            r15 = false;
            goto L30
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ ConnectorFragment a;

        public c(ConnectorFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            ConnectorFragment.ca0(this.a);
        }
    }

    public static final class d implements m {
        public final /* synthetic */ ConnectorFragment a;

        public d(ConnectorFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.connector.m
        public final void a(n r15) {
            Intrinsics.checkNotNullParameter(r15, "connector");
            int r1 = u.a;
            Intrinsics.checkNotNullParameter(r15, "connector");
            Intrinsics.checkNotNullParameter("connect", "connectorAction");
            u.a(r15.a, "connect");
            ConnectorFragment r0 = this.a;
            int r2 = ConnectorFragment.t;
            r0.getClass();
            String r3 = z2.a.getActionBarConnectorConfig().c;
            if (r3 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L12;
            r3 = null;
        L12:
            if (r3 != null) goto L14;
            r3 = "sslocal://lynxview_popup?bundle=template/skill-list/template.js&hide_nav_bar=1&need_intercept_in_minor_mode=1&scene_key=skill_management&channel=flow_lynx_doubao_skill_template&use_anniex=1&loader_name=forest&enable_lynx_generic_fetcher=1&need_login_strict_mode=1&enable_prefetch=1&aid=482431&enable_securelink=1&sec_link_scene=im&gravity=bottom&height_percent=99&width_percent=100&pull_down_close=1&show_mask=1&mask_bg_color=00000036&radius=0&radius_use_dp=1&radius_top_left=24&radius_top_right=24&mix_container_type=annie&enable_pull_down_close=1&support_close_by_gesture=1&close_by_gesture=1&ninety_percent_screen=1&disable_outside_click_close=0&url=https%3A%2F%2Flf-doubao-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F11517%2Fgecko%2Fresource%2Fflow_lynx_doubao_skill_template%2Ftemplate%2Fskill-list%2Ftemplate.js%3Fenterprise_mode%3D1%26tenant_name%3DByteDance%26theme%3Dlight%26page_mode%3Ddetail_only%26display_mode%3Dnine_screen%26resource_type%3Dconnector%26resource_id%3D<RESOURCE_ID>%26skill_type%3D<SKILL_TYPE>";
        L14:
            String r16 = StringsKt.replace$default(StringsKt.replace$default(r3, "<RESOURCE_ID>", r15.a, false, 4, null), "<SKILL_TYPE>", String.valueOf(r15.h), false, 4, null);
            SmartRouter.buildRoute(r0.requireContext(), r16).d();
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r4 = false;
            goto L9
        }

        @Override // com.larus.connector.m
        public final void b(n r5) {
            Intrinsics.checkNotNullParameter(r5, "connector");
            if (this.a.p.add(r5.a) == false) goto L19;
            int r1 = u.a;
            Intrinsics.checkNotNullParameter(r5, "connector");
            String r0 = r5.a;
            String r2 = r5.b;
            boolean r3 = true;
            if (r5.e == 1) goto L8;
        L10:
            r3 = false;
        L11:
            if (r3 == true) goto L14;
            String r6 = "not_connected";
        L17:
            u.b(r0, r2, r6);
            return;
        L14:
            if (r5.g == false) goto L16;
            r6 = "on";
            goto L17
        L16:
            r6 = "off";
            goto L17
        L8:
            if (r5.f != 1) goto L10;
        }

        @Override // com.larus.connector.m
        public final void c(n r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r9, "connector");
            int r1 = u.a;
            if (r10 == false) goto L5;
            String r2 = "toggle_on";
        L6:
            Intrinsics.checkNotNullParameter(r9, "connector");
            Intrinsics.checkNotNullParameter(r2, "connectorAction");
            u.a(r9.a, r2);
            ConnectorFragment r0 = this.a;
            if (r0.o.containsKey(r9.a) == false) goto L9;
            return;
        L9:
            if (r9.g == r10) goto L17;
            Boolean r3 = Boolean.valueOf(r10);
            r0.o.put(r9.a, r3);
            r0.q.getClass();
            List<n> r4 = ConnectorListRepository.b();
            if (r4 != null) goto L14;
            r4 = CollectionsKt.emptyList();
        L14:
            r0.Z90(r4);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0.getViewLifecycleOwner()), null, null, new ConnectorFragment$setConnectorEnabled$1(r0, r9, r10, null), 3, null);
            return;
        L17:
            return;
        L5:
            r2 = "toggle_off";
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.larus.connector.ConnectorFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.connector.ConnectorFragment$onCreate$1", f = "ConnectorFragment.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ConnectorFragment this$0;

        /* JADX INFO: renamed from: com.larus.connector.ConnectorFragment$onCreate$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ConnectorFragment a;

            public a(ConnectorFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r5, Continuation r6) {
                long r7 = ((Number) r5).longValue();
                ConnectorFragment r0 = this.a;
                if (r7 <= r0.d) goto L12;
                r0.d = r7;
                r0.dismissAllowingStateLoss();     // Catch: Exception -> L7
            L7:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r8 = DialogFragmentLancet.sLastShowStack;
                if (r8 == null) goto L12;
                com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            L12:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ConnectorFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            b1 r6 = t.b;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final int S90() {
        return 2131239798;
    }

    public final void Y90() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        this.q.getClass();
        List<n> r0 = ConnectorListRepository.b();
        if (r0 != null) goto L8;
        showLoading();
    L9:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ConnectorFragment$loadConnectors$1(this, null), 3, null);
        return;
    L8:
        Z90(r0);
        goto L9
    }

    public final void onDestroyView() {
        LarusFragmentConnectorBinding r0 = this.e;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.h;
        if (r1 == null) goto L7;
        r1.removeOnItemTouchListener(this.s);
    L7:
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = 0;
        this.n = false;
        ((LinkedHashMap) this.o).clear();
        this.p.clear();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.e = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void showLoading() {
        LarusFragmentConnectorBinding r0 = this.e;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.h;
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        q r2 = this.f;
        if (r2 == null) goto L10;
        r2.a();
    L10:
        final List r3 = CollectionsKt.listOf(o.b.a);
        ConnectorAdapter r4 = this.i;
        if (r4 == null) goto L14;
        r4.submitList(r3, new i(this, r3));
        return;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.connector.ConnectorFragment$stopFlingOnTouchListener$1] */
    public ConnectorFragment() {
        this.d = ((Number) t.b.getValue()).longValue();
        this.o = new LinkedHashMap();
        this.p = new LinkedHashSet();
        this.q = ConnectorListRepository.a;
        this.r = new b(this);
        this.s = new ConnectorFragment$stopFlingOnTouchListener$1();
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final int U90() {
        return i5.E();
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L8;
        m7.a(r1);
    L8:
        if (this.n == true) goto L12;
        this.n = true;
        int r2 = u.a;
        String r3 = getString(2131906670);
        Intrinsics.checkNotNullParameter(r3, "connectorName");
        u.b("add_connector_item_custom_id", r3, "not_connected");
        return;
    }

    public static /* synthetic */ void ca0(ConnectorFragment r1) {
        ConnectorAdapter r0 = r1.i;
        if (r0 == null) goto L5;
        int r2 = r0.getItemCount();
    L6:
        r1.ba0(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final int X90(View r4) {
        Object r0 = r4.getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L7:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return RangesKt.coerceIn(r1.getHeight() - r4.getTop(), 0, r1.getHeight());
    L5:
        r1 = null;
        goto L7
    }

    public final void Z90(List<n> r7) {
        if (r7.isEmpty() == false) goto L16;
        LarusFragmentConnectorBinding r8 = this.e;
        if (r8 == null) goto L9;
        RecyclerView r9 = r8.h;
        if (r9 == null) goto L9;
        r9.setVisibility(8);
    L9:
        q r10 = this.f;
        if (r10 == null) goto L12;
        r10.a();
    L12:
        ConnectorAdapter r11 = this.i;
        if (r11 == null) goto L42;
        r11.submitList(CollectionsKt.emptyList(), new j(this));
        return;
    L42:
        return;
    L16:
        LarusFragmentConnectorBinding r0 = this.e;
        if (r0 == null) goto L21;
        RecyclerView r1 = r0.h;
        if (r1 == null) goto L21;
        r1.setVisibility(0);
    L21:
        q r2 = this.f;
        if (r2 == null) goto L24;
        r2.a();
    L24:
        List<n> r12 = r7;
        final ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L26:
        if (r13.hasNext() == false) goto L35;
        n r4 = (n) r13.next();
        Map<String, Boolean> r5 = this.o;
        LinkedHashMap r6 = (LinkedHashMap) r5;
        Boolean r14 = (Boolean) r6.get(r4.a);
        if (r14 == null) goto L31;
        r4 = n.a(r4, r14.booleanValue());
    L31:
        if (r14 == null) goto L33;
        boolean r15 = true;
    L34:
        r3.add(new o.a(r4, r15));
        goto L26
    L33:
        r15 = false;
        goto L34
    L35:
        ConnectorAdapter r16 = this.i;
        if (r16 == null) goto L43;
        r16.submitList(r3, new k(this, r3));
        return;
    }

    public final void ba0(final int r3) {
        LarusFragmentConnectorBinding r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.post(new f(this, r3));
    }

    public final void onCreate(Bundle r7) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r7);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final void V90(View r7, BottomSheetBehavior<View> r8) {
        Intrinsics.checkNotNullParameter(r7, "bottomSheet");
        Intrinsics.checkNotNullParameter(r8, "behavior");
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if (r0 == null) goto L5;
        r0.height = -1;
    L6:
        r7.setLayoutParams(r0);
        Object r1 = r7.getParent();
        if ((r1 instanceof View) == false) goto L9;
        View r2 = (View) r1;
    L10:
        if (r2 == null) goto L18;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L15:
        if (r4 == null) goto L17;
        r4.topMargin = getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
    L17:
        r2.setLayoutParams(r4);
        goto L18
    L14:
        r4 = null;
    L18:
        this.g = r8;
        this.h = r7;
        r8.setSkipCollapsed(false);
        r8.setHideable(true);
        r8.setFitToContents(true);
        r8.setBottomSheetCallback(this.r);
        r8.setState(4);
        if (r7.isLaidOut() == true) goto L21;
    L23:
        r7.addOnLayoutChangeListener(new c(this));
    L24:
        ca0(this);
        return;
    L21:
        if (r7.isLayoutRequested() == true) goto L23;
        ca0(this);
        goto L24
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public final void aa0(int r7, boolean r8) {
        if (r7 > 0) goto L4;
        return;
    L4:
        if (this.m <= 0) goto L35;
        LarusFragmentConnectorBinding r0 = this.e;
        if (r0 != null) goto L9;
        return;
    L9:
        ViewGroup.LayoutParams r1 = r0.f.getLayoutParams();
        Integer r3 = null;
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L13:
        if (r2 != null) goto L15;
        return;
    L15:
        Integer r4 = Integer.valueOf(r0.d.a.getMeasuredHeight());
        if (r4.intValue() <= 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        r3 = r4;
    L21:
        if (r3 == null) goto L23;
        int r6 = r3.intValue();
    L24:
        int r9 = Math.min(this.m, RangesKt.coerceAtLeast(((r7 - r6) - r2.topMargin) - this.l, 0));
        if (r8 == true) goto L30;
        if (r9 >= r2.height) goto L30;
        return;
    L30:
        if (r2.height != r9) goto L32;
        return;
    L32:
        r2.height = r9;
        r0.f.setLayoutParams(r2);
        return;
    L23:
        r6 = c7.b(52);
        goto L24
    L18:
        r5 = false;
        goto L19
    L12:
        r2 = null;
        goto L13
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        LarusFragmentConnectorBinding r9 = this.e;
        if (r9 == null) goto L25;
        LarusLayoutBottomSheetHeaderBinding r0 = r9.d;
        Intrinsics.checkNotNullParameter(r0, "binding");
        r0.d.setText(2131909541);
        AppCompatImageView r1 = r0.b;
        ConstraintLayout.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L24;
        ConstraintLayout.LayoutParams r3 = r2;
        r3.startToStart = -1;
        r3.endToEnd = 0;
        r1.setLayoutParams(r3);
        r0.b.setOnClickListener(new g(this));
        this.f = new q(r9.g, new h(this));
        ConnectorAdapter r4 = new ConnectorAdapter(new d(this));
        r9.h.setLayoutManager(new LinearLayoutManager(requireContext()));
        r9.h.setAdapter(r4);
        r9.h.setItemAnimator(null);
        r9.h.addOnItemTouchListener(this.s);
        this.i = r4;
        ViewGroup.LayoutParams r10 = r9.f.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L10:
        if (r11 == null) goto L12;
        int r12 = r11.bottomMargin;
    L13:
        this.l = r12;
        LarusFragmentConnectorBinding r13 = this.e;
        if (r13 == null) goto L22;
        LarusItemConnectorBinding r14 = r13.b;
        if (r14 == null) goto L22;
        r14.h.setVisibility(8);
        r14.g.setVisibility(0);
        SimpleDraweeView r5 = r14.g;
        boolean r6 = v19.h.a;
        if (v19.h.b(r14.a.getContext()) == false) goto L20;
        int r15 = 2131241086;
    L21:
        r5.setActualImageResource(r15);
        r14.k.setText(2131906670);
        r14.c.setVisibility(8);
        r14.d.setVisibility(8);
        r14.b.setVisibility(0);
        r14.e.setVisibility(8);
        r14.a.setOnClickListener(new l(this));
        goto L22
    L20:
        r15 = 2131241088;
    L22:
        this.m = getResources().getDimensionPixelSize(v19.c.b(2130971512, getContext(), 2131167393)) * 1;
        goto L25
    L12:
        r12 = 0;
        goto L13
    L9:
        r11 = null;
        goto L10
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L25:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ConnectorFragment$observeConnectorList$1(this, null), 3, null);
        Y90();
    }

    public static final void W90(ConnectorFragment r3, String r4, boolean r5) {
        r3.getClass();
        FLogger.a.e("ConnectorFragment", "[loadConnectors] onFailure, msg=" + r4);
        if (r5 == true) goto L13;
        LarusFragmentConnectorBinding r6 = r3.e;
        if (r6 == null) goto L9;
        RecyclerView r7 = r6.h;
        if (r7 == null) goto L9;
        r7.setVisibility(8);
    L9:
        q r8 = r3.f;
        if (r8 == null) goto L12;
        r8.c();
    L12:
        r3.ba0(0);
    L13:
        Context r9 = r3.getContext();
        if (r9 == null) goto L17;
        s r10 = s.a;
        String r11 = r9.getString(2131906830);
        r10.getClass();
        s.t(r9, r11);
        return;
    }

    public final View onCreateView(LayoutInflater r27, ViewGroup r28, Bundle r210) {
        Intrinsics.checkNotNullParameter(r27, "inflater");
        ConstraintLayout r0 = r27.inflate(2131562369, r28, false);
        int r1 = 2131362240;
        ConstraintLayout r2 = ViewBindings.findChildViewById(r0, 2131362240);
        if (r2 == null) goto L43;
        int r3 = 2131375714;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131375714);
        if (r7 == null) goto L41;
        r3 = 2131375715;
        if (ViewBindings.findChildViewById(r2, 2131375715) == null) goto L41;
        r3 = 2131375716;
        CustomSwitchCompat r8 = ViewBindings.findChildViewById(r2, 2131375716);
        if (r8 == null) goto L41;
        r3 = 2131375717;
        AppCompatTextView r9 = ViewBindings.findChildViewById(r2, 2131375717);
        if (r9 == null) goto L41;
        r3 = 2131375736;
        View r10 = ViewBindings.findChildViewById(r2, 2131375736);
        if (r10 == null) goto L41;
        r3 = 2131375741;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131375741);
        if (r11 == null) goto L41;
        r3 = 2131375790;
        SimpleDraweeView r12 = ViewBindings.findChildViewById(r2, 2131375790);
        if (r12 == null) goto L41;
        r3 = 2131375791;
        View r13 = ViewBindings.findChildViewById(r2, 2131375791);
        if (r13 == null) goto L41;
        r3 = 2131375792;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131375792);
        if (r14 == null) goto L41;
        r3 = 2131375793;
        View r15 = ViewBindings.findChildViewById(r2, 2131375793);
        if (r15 == null) goto L41;
        r3 = 2131375802;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r2, 2131375802);
        if (r16 == null) goto L41;
        LarusItemConnectorBinding r110 = new LarusItemConnectorBinding(r2, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r1 = 2131367688;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131367688);
        if (r20 == null) goto L43;
        r1 = 2131367689;
        View r4 = ViewBindings.findChildViewById(r0, 2131367689);
        if (r4 == null) goto L43;
        LarusLayoutBottomSheetHeaderBinding r21 = LarusLayoutBottomSheetHeaderBinding.a(r4);
        r1 = 2131367690;
        FrameLayout r22 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131367690);
        if (r22 == null) goto L43;
        r1 = 2131367691;
        ConstraintLayout r23 = ViewBindings.findChildViewById(r0, 2131367691);
        if (r23 == null) goto L43;
        r1 = 2131367692;
        View r5 = ViewBindings.findChildViewById(r0, 2131367692);
        if (r5 == null) goto L43;
        LarusLayoutTaskSkillStateBinding r24 = LarusLayoutTaskSkillStateBinding.a(r5);
        r1 = 2131384934;
        RecyclerView r25 = ViewBindings.findChildViewById(r0, 2131384934);
        if (r25 == null) goto L43;
        ConstraintLayout r6 = r0;
        this.e = new LarusFragmentConnectorBinding(r6, r110, r20, r21, r22, r23, r24, r25);
        return r6;
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r3)));
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
