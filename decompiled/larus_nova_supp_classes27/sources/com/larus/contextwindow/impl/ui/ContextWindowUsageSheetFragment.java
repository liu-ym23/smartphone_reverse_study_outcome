package com.larus.contextwindow.impl.ui;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.api.ContextWindowUsageParts;
import com.larus.contextwindow.impl.databinding.LarusFragmentContextWindowUsageBinding;
import com.larus.contextwindow.impl.databinding.LarusItemContextWindowUsageDetailBinding;
import com.larus.contextwindow.impl.databinding.LarusLayoutContextWindowHeaderBinding;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaBarTier;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import com.larus.platform.service.o;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import v19.i5;
import v19.m7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J$\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00106\u001a\u00020,H\u0016J\b\u00107\u001a\u00020,H\u0016J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020.H\u0016J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020,2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010>\u001a\u00020,H\u0016J\u001e\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\u001f2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001f0!H\u0014J\b\u0010B\u001a\u00020,H\u0002J\b\u0010C\u001a\u00020,H\u0002J\u0018\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020#H\u0002J0\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020\u0005H\u0002J\u0010\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020QH\u0002J\u0012\u0010R\u001a\u00020,2\b\u0010S\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020#H\u0002J\u0018\u0010V\u001a\u00020,2\u0006\u0010H\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010U\u001a\u00020#H\u0002J\u0010\u0010\\\u001a\u00020[2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010]\u001a\u00020[2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010^\u001a\u00020[2\u0006\u0010X\u001a\u00020YH\u0002J\b\u0010_\u001a\u00020,H\u0002J\b\u0010`\u001a\u00020#H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/larus/contextwindow/impl/ui/ContextWindowUsageSheetFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "contextSnapshot", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "getContextSnapshot", "()Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "contextSnapshot$delegate", "Lkotlin/Lazy;", "enterFrom", "Lcom/larus/contextwindow/api/ContextWindowEnterFrom;", "getEnterFrom", "()Lcom/larus/contextwindow/api/ContextWindowEnterFrom;", "enterFrom$delegate", "usageViewModel", "Lcom/larus/contextwindow/impl/ui/ContextWindowUsageViewModel;", "getUsageViewModel", "()Lcom/larus/contextwindow/impl/ui/ContextWindowUsageViewModel;", "usageViewModel$delegate", "binding", "Lcom/larus/contextwindow/impl/databinding/LarusFragmentContextWindowUsageBinding;", "refreshPolicy", "Lcom/larus/contextwindow/impl/ui/MembershipQuotaRefreshPolicy;", "bottomSheetView", "Landroid/view/View;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "hasRenderedState", "", "renderedContextSnapshot", "renderedContextCompressing", "Ljava/lang/Boolean;", "renderedMembership", "Lcom/larus/contextwindow/impl/ui/MembershipQuotaPanelState;", "isClosing", "hasTrackedPanelShown", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onStop", "onSaveInstanceState", "outState", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroyView", "onRoundedBottomSheetReady", "bottomSheet", "behavior", "trackPanelShownOnce", "configureHeader", "renderContextUsage", "snapshot", "isCompressing", "bindContextRow", "rowBinding", "Lcom/larus/contextwindow/impl/databinding/LarusItemContextWindowUsageDetailBinding;", "titleRes", "used", "", "total", "dotColor", "renderPanelState", "state", "Lcom/larus/contextwindow/impl/ui/ContextWindowPanelState;", "renderMembership", "membership", "renderMembershipHeader", "isRefreshing", "bindMembershipRow", "Lcom/larus/contextwindow/impl/databinding/LarusItemContextWindowMembershipQuotaBinding;", "row", "Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaRow;", "membershipStatusText", "", "membershipRowTitle", "membershipResetText", "membershipValueText", "remeasureSheet", "animationsEnabled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowUsageSheetFragment extends RoundedBottomSheetDialogFragment {
    public static final /* synthetic */ int q = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public LarusFragmentContextWindowUsageBinding g;
    public MembershipQuotaRefreshPolicy h;
    public View i;
    public BottomSheetBehavior<View> j;
    public boolean k;
    public ContextWindowSnapshot l;
    public Boolean m;
    public j n;
    public boolean o;
    public boolean p;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MembershipQuotaRowKind.values().length];
            r0[MembershipQuotaRowKind.SUBSCRIPTION_TOTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MembershipQuotaRowKind.H5.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MembershipQuotaRowKind.D7.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MembershipQuotaRowKind.M1.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.ContextWindowUsageSheetFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
        public AnonymousClass1(Object r8) {
            super(1, r8, ContextWindowUsageViewModel.class, "refreshMembershipQuota", "refreshMembershipQuota(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return ((ContextWindowUsageViewModel) ((CallableReference) this).receiver).refreshMembershipQuota(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }
    }

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.ContextWindowUsageSheetFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.contextwindow.impl.ui.ContextWindowUsageSheetFragment$onViewCreated$2", f = "ContextWindowUsageSheetFragment.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextWindowUsageSheetFragment this$0;

        /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.ContextWindowUsageSheetFragment$onViewCreated$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.contextwindow.impl.ui.ContextWindowUsageSheetFragment$onViewCreated$2$1", f = "ContextWindowUsageSheetFragment.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ContextWindowUsageSheetFragment this$0;

            /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.ContextWindowUsageSheetFragment$onViewCreated$2$1$a */
            public /* synthetic */ class a implements FlowCollector, FunctionAdapter {
                public final /* synthetic */ ContextWindowUsageSheetFragment a;

                public a(ContextWindowUsageSheetFragment r1) {
                    this.a = r1;
                }

                public final boolean equals(Object r3) {
                    if ((r3 instanceof FlowCollector) == true) goto L5;
                    return false;
                L5:
                    if ((r3 instanceof FunctionAdapter) == true) goto L7;
                    return false;
                L7:
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
                }

                public final Function<?> getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, this.a, ContextWindowUsageSheetFragment.class, "renderPanelState", "renderPanelState(Lcom/larus/contextwindow/impl/ui/ContextWindowPanelState;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                public final Object emit(Object r2, Continuation r3) {
                    ContextWindowUsageSheetFragment r0 = this.a;
                    Object r4 = AnonymousClass1.access$invokeSuspend$renderPanelState(r0, (com.larus.contextwindow.impl.ui.a) r2, r3);
                    if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                    return r4;
                L6:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass1(ContextWindowUsageSheetFragment r1, Continuation<? super AnonymousClass1> r2) {
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
                ContextWindowUsageSheetFragment r6 = this.this$0;
                int r2 = ContextWindowUsageSheetFragment.q;
                i1<com.larus.contextwindow.impl.ui.a> r7 = ((ContextWindowUsageViewModel) r6.f.getValue()).getState();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }

            public static final Object access$invokeSuspend$renderPanelState(ContextWindowUsageSheetFragment r210, com.larus.contextwindow.impl.ui.a r30, Continuation r31) {
                int r3 = 1;
                boolean r4 = false;
                if (Intrinsics.areEqual(r210.l, r30.a) == true) goto L5;
            L8:
                boolean r2 = true;
            L9:
                if (r2 == false) goto L11;
                r210.Y90(r30.a, r30.b);
            L11:
                j r5 = r30.c;
                if (r210.k == true) goto L14;
            L17:
                boolean r0 = true;
            L18:
                if (r2 == true) goto L21;
                if (r0 == true) goto L21;
            L230:
                return Unit.INSTANCE;
            L21:
                if (r0 == false) goto L224;
                MembershipQuotaRefreshPolicy r1 = r210.h;
                if (r1 == null) goto L40;
                if (r5 == null) goto L26;
                Long r8 = r5.c;
            L27:
                if (r8 != null) goto L29;
            L34:
                r8 = null;
            L36:
                if (Intrinsics.areEqual(r1.e, r8) == true) goto L40;
                r1.e = r8;
                r1.b();
                goto L40
            L29:
                if (r8.longValue() <= 0) goto L31;
                boolean r9 = true;
            L32:
                if (r9 == false) goto L34;
            L31:
                r9 = false;
                goto L32
            L26:
                r8 = null;
            L40:
                if (r210.k == true) goto L42;
            L50:
                boolean r6 = false;
            L51:
                if (r6 == true) goto L53;
            L75:
                LarusFragmentContextWindowUsageBinding r7 = r210.g;
                if (r7 == null) goto L223;
                LinearLayout r10 = r7.f;
                if (r5 == null) goto L81;
                boolean r11 = true;
            L82:
                if (r11 == false) goto L84;
                int r12 = 0;
            L85:
                r10.setVisibility(r12);
                r7.i.removeAllViews();
                if (r5 == null) goto L223;
                boolean r13 = r5.b;
                LarusFragmentContextWindowUsageBinding r14 = r210.g;
                if (r14 == null) goto L111;
                ProgressBar r15 = r14.h;
                if (r13 == false) goto L94;
                int r16 = 0;
            L95:
                r15.setVisibility(r16);
                TextView r17 = r14.j;
                if (r13 == false) goto L98;
                int r18 = 0;
            L99:
                r17.setVisibility(r18);
                String r110 = r210.getString(2131906692);
                if (r13 == false) goto L102;
                String r20 = r210.getString(2131906687);
                Intrinsics.checkNotNull(r20);
            L103:
                r14.j.setText(r20);
                LinearLayout r21 = r14.g;
                if (r20.length() != 0) goto L106;
                boolean r111 = true;
            L107:
                if (r111 == true) goto L110;
                r110 = r110 + 65292 + r20;
            L110:
                r21.setContentDescription(r110);
                goto L111
            L106:
                r111 = false;
                goto L107
            L102:
                r20 = "";
                goto L103
            L98:
                r18 = 8;
                goto L99
            L94:
                r16 = 8;
            L111:
                Iterator<z29.b> r22 = r5.a.iterator();
            L113:
                if (r22.hasNext() == false) goto L223;
                z29.b r23 = r22.next();
                View r112 = r210.getLayoutInflater().inflate(2131562522, r7.i, r4);
                int r113 = 2131367887;
                MembershipQuotaProgressView r114 = (MembershipQuotaProgressView) ViewBindings.findChildViewById(r112, 2131367887);
                if (r114 == null) goto L222;
                r113 = 2131367888;
                TextView r115 = (TextView) ViewBindings.findChildViewById(r112, 2131367888);
                if (r115 == null) goto L222;
                r113 = 2131367889;
                TextView r24 = (TextView) ViewBindings.findChildViewById(r112, 2131367889);
                if (r24 == null) goto L222;
                r113 = 2131367890;
                TextView r116 = (TextView) ViewBindings.findChildViewById(r112, 2131367890);
                if (r116 == null) goto L222;
                LinearLayout r117 = (LinearLayout) r112;
                int r118 = b.a[r23.a.ordinal()];
                if (r118 == r3) goto L143;
                if (r118 == 2) goto L142;
                if (r118 != 3) goto L127;
                CharSequence r25 = r210.getString(2131900989);
            L145:
                if (r23.a == MembershipQuotaRowKind.H5) goto L147;
                String r26 = "";
            L152:
                if (r23.i == false) goto L155;
                String r27 = r210.getString(2131900994);
            L185:
                CharSequence r28 = r25;
                r24.setText(r28);
                if (r26.length() <= 0) goto L193;
                boolean r32 = true;
            L194:
                if (r32 == false) goto L196;
                String r33 = r26;
            L197:
                if (r33 == null) goto L199;
                CharSequence r34 = r33.concat(" ·");
            L200:
                if (r34 != null) goto L202;
                r34 = "";
            L202:
                r115.setText(r34);
                if (r26.length() <= 0) goto L205;
                boolean r35 = true;
            L206:
                if (r35 == false) goto L208;
                int r36 = 0;
            L209:
                r115.setVisibility(r36);
                r116.setText(r27);
                double r119 = r23.e;
                MembershipQuotaBarTier r120 = r23.f;
                boolean r37 = r23.i;
                Intrinsics.checkNotNullParameter(r120, "tier");
                if (r37 == false) goto L212;
                int r38 = 8;
            L213:
                r114.setVisibility(r38);
                r114.f = (float) RangesKt.coerceIn(r119, 0.0d, 100.0d);
                r114.g = r120;
                r114.invalidate();
                if (r26.length() != 0) goto L216;
                boolean r40 = true;
            L217:
                if (r40 == false) goto L219;
                String r41 = r210.getString(2131900992, new Object[]{r28, r27});
            L220:
                r117.setContentDescription(r41);
                r7.i.addView(r117);
                r3 = 1;
                r4 = false;
                goto L113
            L219:
                r41 = r210.getString(2131900991, new Object[]{r28, r26, r27});
                goto L220
            L216:
                r40 = false;
                goto L217
            L212:
                r38 = 0;
                goto L213
            L208:
                r36 = 8;
                goto L209
            L205:
                r35 = false;
                goto L206
            L199:
                r34 = null;
                goto L200
            L196:
                r33 = null;
                goto L197
            L193:
                r32 = false;
                goto L194
            L155:
                if (r23.h == false) goto L165;
                String r42 = r23.k;
                if (r42 != null) goto L159;
            L162:
                boolean r43 = true;
            L163:
                if (r43 == true) goto L165;
                r27 = r210.getString(2131900986, new Object[]{r23.k});
                goto L185
            L159:
                if (StringsKt.isBlank(r42) == true) goto L162;
                r43 = false;
            L165:
                String r44 = r23.j;
                if (r44 != null) goto L168;
            L171:
                boolean r45 = true;
            L172:
                if (r45 == true) goto L183;
                String r46 = r23.k;
                if (r46 != null) goto L176;
            L179:
                boolean r47 = true;
            L180:
                if (r47 == true) goto L183;
                r27 = r210.getString(2131900995, new Object[]{r23.j, r23.k});
                goto L185
            L176:
                if (StringsKt.isBlank(r46) == true) goto L179;
                r47 = false;
            L183:
                if (r23.g == false) goto L187;
                r27 = r210.getString(2131900997);
                goto L185
            L187:
                if (r23.d > 0.0d) goto L189;
                r27 = r210.getString(2131900988);
                goto L185
            L189:
                r27 = r210.getString(2131900996, new Object[]{BigDecimal.valueOf(r23.d).stripTrailingZeros().toPlainString() + '%'});
                goto L185
            L168:
                if (StringsKt.isBlank(r44) == true) goto L171;
                r45 = false;
                goto L172
            L147:
                Long r48 = r23.l;
                if (r48 == null) goto L150;
                long r50 = BigDecimal.valueOf(RangesKt.coerceAtLeast(r48.longValue() - System.currentTimeMillis(), 0)).divide(BigDecimal.valueOf(60000), 0, RoundingMode.CEILING).longValueExact();
                r26 = r210.getString(2131900990, new Object[]{r210.getString(2131900985, new Object[]{Long.valueOf(r50 / 60), Long.valueOf(r50 % 60)})});
                goto L152
            L150:
                r26 = r210.getString(2131900993);
                goto L152
            L127:
                if (r118 != 4) goto L140;
                if (r23.c == false) goto L131;
                r25 = r210.getString(2131905155);
                goto L145
            L131:
                r25 = r23.b;
                if (r25 != null) goto L134;
            L138:
                r25 = r210.getString(2131900987);
                goto L145
            L134:
                if (((StringsKt.isBlank(r25) ? 1 : 0) ^ r3) != 0) goto L137;
                r25 = null;
            L137:
                if (r25 != null) goto L145;
            L140:
                throw new NoWhenBranchMatchedException();
            L142:
                r25 = r210.getString(2131900984);
                goto L145
            L143:
                r25 = r210.getString(2131900983);
            L222:
                throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
            L84:
                r12 = 8;
                goto L85
            L81:
                r11 = false;
            L223:
                r210.n = r5;
                goto L224
            L53:
                if (Build.VERSION.SDK_INT < 26) goto L231;
                boolean r51 = ValueAnimator.areAnimatorsEnabled();
            L67:
                if (r51 == false) goto L75;
                if (r210.o == true) goto L75;
                LarusFragmentContextWindowUsageBinding r52 = r210.g;
                if (r52 == null) goto L75;
                LinearLayout r53 = r52.b;
                if (r53 == null) goto L75;
                TransitionManager.beginDelayedTransition(r53, new AutoTransition().setDuration(200));
                goto L75
            L231:
                Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L61
                if (Settings.Global.getFloat(r210.requireContext().getContentResolver(), "animator_duration_scale", 1.0f) <= 0.0f) goto L58;
                boolean r55 = true;
            L59:
                Object r56 = Result.constructor-impl(Boolean.valueOf(r55));     // Catch: Throwable -> L61
            L63:
                Boolean r57 = Boolean.TRUE;
                if (Result.isFailure-impl(r56) == false) goto L66;
                r56 = r57;
            L66:
                r51 = ((Boolean) r56).booleanValue();
                goto L67
            L58:
                r55 = false;
            L61:
                th = move-exception;
                Result.Companion r58 = Result.Companion;
                r56 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L63
            L42:
                if (r210.n == null) goto L44;
                boolean r60 = true;
            L45:
                if (r5 == null) goto L47;
                boolean r61 = true;
            L48:
                if (r60 == r61) goto L50;
                r6 = true;
                goto L51
            L47:
                r61 = false;
                goto L48
            L44:
                r60 = false;
            L224:
                r210.k = true;
                LarusFragmentContextWindowUsageBinding r62 = r210.g;
                if (r62 == null) goto L230;
                LinearLayout r63 = r62.a;
                if (r63 == null) goto L230;
                r63.post(new i(r210));
                goto L230
            L14:
                if (Intrinsics.areEqual(r210.n, r5) == false) goto L17;
                r0 = false;
                goto L18
            L5:
                if (Intrinsics.areEqual(r210.m, Boolean.valueOf(r30.b)) == false) goto L8;
                r2 = false;
                goto L9
            }
        }

        public AnonymousClass2(ContextWindowUsageSheetFragment r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

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
            LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final int S90() {
        return 2131238895;
    }

    public final void onDestroyView() {
        MembershipQuotaRefreshPolicy r0 = this.h;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.h = null;
        this.j = null;
        this.i = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.k = false;
        this.g = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void onStop() {
        MembershipQuotaRefreshPolicy r0 = this.h;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public ContextWindowUsageSheetFragment() {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.d = LazyKt.lazy(r0, new f(this));
        this.e = LazyKt.lazy(r0, new g(this));
        Function0 r1 = new h(this);
        final Function0<Fragment> r2 = new ContextWindowUsageSheetFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ContextWindowUsageViewModel.class), new ContextWindowUsageSheetFragment$special$$inlined$viewModels$default$2(r2), r1);
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
        BottomSheetDialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        boolean r2 = true;
        if (r1 == null) goto L9;
        r1.setCanceledOnTouchOutside(true);
    L9:
        Dialog r3 = getDialog();
        if (r3 == null) goto L14;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L14;
        m7.a(r4);
    L14:
        ((ContextWindowUsageViewModel) this.f.getValue()).ensureMembershipRuntimeInitialized();
        MembershipQuotaRefreshPolicy r5 = this.h;
        if (r5 == null) goto L35;
        j r6 = this.n;
        if (r6 == null) goto L19;
        Long r7 = r6.c;
    L20:
        r5.d = true;
        if (r7 != null) goto L23;
    L28:
        r7 = null;
    L29:
        r5.e = r7;
        if (r7 != null) goto L32;
    L34:
        BuildersKt.launch$default(r5.a, null, null, new MembershipQuotaRefreshPolicy$onStart$1(r5, null), 3, null);
        r5.b();
        goto L35
    L32:
        if (r7.longValue() > ((Number) r5.b.invoke()).longValue()) goto L34;
        r5.f = r7;
        goto L34
    L23:
        if (r7.longValue() > 0) goto L26;
        r2 = false;
    L26:
        if (r2 == false) goto L28;
    L19:
        r7 = null;
    L35:
        LarusFragmentContextWindowUsageBinding r8 = this.g;
        if (r8 == null) goto L41;
        LinearLayout r9 = r8.a;
        if (r9 == null) goto L42;
        r9.post(new i(this));
        return;
    L42:
        return;
    L41:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void W90(ContextWindowUsageSheetFragment r9) {
        LarusFragmentContextWindowUsageBinding r0 = r9.g;
        if (r0 == null) goto L59;
        View r1 = r9.i;
        if (r1 == null) goto L60;
        BottomSheetBehavior<View> r2 = r9.j;
        if (r2 == null) goto L61;
        Dialog r10 = r9.getDialog();
        if (r10 == null) goto L57;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L62;
        View r12 = r11.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L21;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L21;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L21:
        Integer r4 = Integer.valueOf(r1.getWidth());
        boolean r6 = false;
        if (r4.intValue() <= 0) goto L24;
        boolean r5 = true;
    L25:
        Insets r7 = null;
        if (r5 == true) goto L29;
        r4 = null;
    L29:
        if (r4 == null) goto L31;
        int r8 = r4.intValue();
    L32:
        if (r8 > 0) goto L34;
        return;
    L34:
        if (r12.getHeight() <= 0) goto L63;
        r0.a.measure(View.MeasureSpec.makeMeasureSpec(r8, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        WindowInsetsCompat r13 = ViewCompat.getRootWindowInsets(r12);
        if (r13 == null) goto L39;
        r7 = r13.getInsets(WindowInsetsCompat.Type.systemBars());
    L39:
        int r14 = r12.getHeight();
        if (r7 == null) goto L42;
        int r15 = r7.top;
    L43:
        int r16 = r14 - r15;
        if (r7 == null) goto L46;
        int r17 = r7.bottom;
    L47:
        int r18 = (r16 - r17) - i5.h();
        int r20 = c.a;
        int r21 = RangesKt.coerceAtLeast(r0.a.getMeasuredHeight(), 0);
        int r22 = RangesKt.coerceAtLeast(r18, 0);
        int r23 = Math.min(r21, r22);
        if (r21 <= r22) goto L50;
        r6 = true;
    L50:
        if (r23 <= 0) goto L64;
        ViewGroup.LayoutParams r24 = r1.getLayoutParams();
        if (r24.height == r23) goto L55;
        r24.height = r23;
        r1.setLayoutParams(r24);
    L55:
        r0.m.setNestedScrollingEnabled(r6);
        r2.setPeekHeight(r23);
        r2.setSkipCollapsed(true);
        r2.setState(3);
        return;
    L64:
        return;
    L46:
        r17 = 0;
        goto L47
    L42:
        r15 = 0;
        goto L43
    L63:
        return;
    L31:
        r8 = r12.getWidth();
        goto L32
    L24:
        r5 = false;
        goto L25
    L62:
        return;
    L57:
        return;
    L61:
        return;
    L60:
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.o = true;
        MembershipQuotaRefreshPolicy r0 = this.h;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        if (r2 == null) goto L5;
        boolean r3 = r2.getBoolean("state_panel_shown_tracked");
    L6:
        this.p = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L13
        this.o = true;     // Catch: Throwable -> L13
        MembershipQuotaRefreshPolicy r0 = this.h;     // Catch: Throwable -> L13
        if (r0 == null) goto L5;
        r0.a();     // Catch: Throwable -> L13
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L13
        d r3 = getActivity();     // Catch: Throwable -> L13
        if ((r3 instanceof d) == false) goto L8;
        d r4 = r3;     // Catch: Throwable -> L13
    L9:
        if (r4 == null) goto L11;
        r4.R();     // Catch: Throwable -> L13
    L11:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        r4 = null;
    L13:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        r3.putBoolean("state_panel_shown_tracked", this.p);
        super/*androidx.fragment.app.DialogFragment*/.onSaveInstanceState(r3);
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final void V90(View r7, BottomSheetBehavior<View> r8) {
        Intrinsics.checkNotNullParameter(r7, "bottomSheet");
        Intrinsics.checkNotNullParameter(r8, "behavior");
        this.i = r7;
        this.j = r8;
        r8.setSkipCollapsed(true);
        r8.setHideable(true);
        r8.setState(3);
        Object r9 = r7.getParent();
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r9 instanceof View) == false) goto L5;
        View r10 = (View) r9;
    L6:
        if (r10 == null) goto L8;
        ViewGroup.LayoutParams r1 = r10.getLayoutParams();
    L10:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        r2 = (ViewGroup.MarginLayoutParams) r1;
    L12:
        if (r2 != null) goto L14;
    L16:
        r7.post(new i(this));
        if (this.p == true) goto L31;
        this.p = true;
        a39.a r11 = a39.a.a;
        ContextWindowSnapshot r12 = (ContextWindowSnapshot) this.d.getValue();
        ContextWindowEnterFrom r0 = (ContextWindowEnterFrom) this.e.getValue();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "snapshot");
        Intrinsics.checkNotNullParameter(r0, "enterFrom");
        int r13 = RangesKt.coerceIn((r12.g + 5) / 10, 0, 100);
        FLogger.a.i("ContextWindowTracker", "panel shown usageSource=" + r12.h.name() + " totalSource=" + r12.i.name() + " streaming=" + r12.j + " enterFrom=" + r0.getWireValue() + " percentBucket=" + r13);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        o.a.reportEvent("context_window_show", new JSONObject().put("show_type", "open_detail").put("usage_percent", r13).put("used_token", r12.e).put("total_token", r12.f));     // Catch: Throwable -> L22
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L30;
        FLogger.a.e("ContextWindowTracker", "context window analytics failed", r15);
        return;
    L30:
        return;
    L22:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L31:
        return;
    L14:
        if (r2.topMargin == i5.h()) goto L16;
        r2.topMargin = i5.h();
        r10.setLayoutParams(r2);
        goto L16
    L8:
        r1 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    public final void Y90(ContextWindowSnapshot r16, boolean r17) {
        LarusFragmentContextWindowUsageBinding r10 = this.g;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r17 == false) goto L8;
        String r1 = getString(2131906687);
    L9:
        Intrinsics.checkNotNull(r1);
        r10.o.setText(r1);
        r10.o.setContentDescription(getString(2131900999, new Object[]{r1}));
        ProgressBar r2 = r10.c;
        int r3 = 8;
        if (r17 == false) goto L12;
        int r4 = 0;
    L13:
        r2.setVisibility(r4);
        LinearLayout r5 = r10.d;
        if ((!r17) == false) goto L16;
        r3 = 0;
    L16:
        r5.setVisibility(r3);
        ContextWindowUsageParts r6 = r16.d;
        long[] r14 = {r6.a, r6.b, r6.c, r6.d};
        ContextWindowSegmentedProgressView r7 = r10.l;
        if (r17 == false) goto L19;
        long[] r8 = new long[0];
    L20:
        long r9 = r16.f;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "parts");
        r7.f = Arrays.copyOf(r8, 4);
        r7.g = RangesKt.coerceAtLeast(r9, 0);
        r7.invalidate();
        X90(r10.k, 2131906693, r14[0], r16.f, r10.l.a(0));
        X90(r10.p, 2131906696, r14[1], r16.f, r10.l.a(1));
        X90(r10.q, 2131906697, r14[2], r16.f, r10.l.a(2));
        X90(r10.n, 2131906695, r14[3], r16.f, r10.l.a(3));
        this.l = r16;
        this.m = Boolean.valueOf(r17);
        return;
    L19:
        r8 = r14;
        goto L20
    L12:
        r4 = 8;
        goto L13
    L8:
        int r11 = x29.a.a;
        r1 = getString(2131900998, new Object[]{x29.a.a(r16.e), x29.a.a(r16.f), BigDecimal.valueOf(r16.g, 1).toPlainString() + '%'});
        goto L9
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        LarusFragmentContextWindowUsageBinding r9 = this.g;
        if (r9 == null) goto L6;
        r9.e.c.setText(2131906727);
        r9.e.b.setContentDescription(getString(2131900982));
        e1.g(r9.e.b, i5.c(), i5.c(), i5.c(), i5.c());
        r9.e.b.setOnClickListener(new e(this));
    L6:
        Y90((ContextWindowSnapshot) this.d.getValue(), ((ContextWindowSnapshot) this.d.getValue()).k);
        this.h = new MembershipQuotaRefreshPolicy(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), new AnonymousClass1((ContextWindowUsageViewModel) this.f.getValue()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public final View onCreateView(LayoutInflater r23, ViewGroup r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r23, "inflater");
        View r0 = r23.inflate(2131562370, r24, false);
        int r1 = 2131367869;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131367869);
        if (r5 == null) goto L49;
        r1 = 2131367870;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(r0, 2131367870);
        if (r6 == null) goto L49;
        r1 = 2131367871;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131367871)) == null) goto L49;
        r1 = 2131367874;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131367874);
        if (r7 == null) goto L49;
        r1 = 2131367876;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r0, 2131367876);
        if (r3 == null) goto L49;
        int r2 = 2131364513;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r3, 2131364513);
        if (r4 == null) goto L48;
        r2 = 2131364524;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r3, 2131364524);
        if (r8 == null) goto L48;
        LarusLayoutContextWindowHeaderBinding r9 = new LarusLayoutContextWindowHeaderBinding(r3, r4, r8);
        int r10 = 2131367878;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131367878);
        if (r11 == null) goto L51;
        r10 = 2131367879;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131367879);
        if (r12 == null) goto L51;
        r10 = 2131367880;
        ProgressBar r13 = (ProgressBar) ViewBindings.findChildViewById(r0, 2131367880);
        if (r13 == null) goto L51;
        r10 = 2131367881;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131367881);
        if (r14 == null) goto L51;
        r10 = 2131367882;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131367882)) == null) goto L51;
        r10 = 2131367883;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131367883);
        if (r15 == null) goto L51;
        r10 = 2131367884;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131367884)) == null) goto L51;
        r10 = 2131367885;
        View r16 = ViewBindings.findChildViewById(r0, 2131367885);
        if (r16 == null) goto L51;
        LarusItemContextWindowUsageDetailBinding r17 = LarusItemContextWindowUsageDetailBinding.a(r16);
        r10 = 2131367886;
        ContextWindowSegmentedProgressView r18 = (ContextWindowSegmentedProgressView) ViewBindings.findChildViewById(r0, 2131367886);
        if (r18 == null) goto L51;
        LinearLayout r21 = (LinearLayout) r0;
        r10 = 2131367892;
        NestedScrollView r110 = ViewBindings.findChildViewById(r0, 2131367892);
        if (r110 == null) goto L51;
        r10 = 2131367893;
        View r20 = ViewBindings.findChildViewById(r0, 2131367893);
        if (r20 == null) goto L51;
        LarusItemContextWindowUsageDetailBinding r111 = LarusItemContextWindowUsageDetailBinding.a(r20);
        r10 = 2131367894;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r0, 2131367894);
        if (r112 == null) goto L51;
        r10 = 2131367895;
        View r22 = ViewBindings.findChildViewById(r0, 2131367895);
        if (r22 == null) goto L51;
        LarusItemContextWindowUsageDetailBinding r113 = LarusItemContextWindowUsageDetailBinding.a(r22);
        r10 = 2131367897;
        View r26 = ViewBindings.findChildViewById(r0, 2131367897);
        if (r26 == null) goto L51;
        this.g = new LarusFragmentContextWindowUsageBinding(r21, r5, r6, r7, r9, r11, r12, r13, r14, r15, r17, r18, r110, r111, r112, r113, LarusItemContextWindowUsageDetailBinding.a(r26));
        return r21;
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r10)));
    L48:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r2)));
    L49:
        r10 = r1;
        goto L51
    }

    public final void X90(LarusItemContextWindowUsageDetailBinding r1, int r2, long r3, long r5, int r7) {
        String r4 = getString(r2);
        String r6 = BigDecimal.valueOf(x29.a.b(r3, r5), 1).toPlainString() + '%';
        r1.d.setText(r4);
        r1.c.setText(r6);
        ViewCompat.setBackgroundTintList(r1.b, ColorStateList.valueOf(r7));
        r1.a.setContentDescription(r4 + 65292 + r6);
    }
}
