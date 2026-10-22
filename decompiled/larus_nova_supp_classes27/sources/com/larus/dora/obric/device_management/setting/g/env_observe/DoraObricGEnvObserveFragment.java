package com.larus.dora.obric.device_management.setting.g.env_observe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel;
import com.larus.dora.impl.device.settings.lab.env.y;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceModeEntryProduct;
import com.larus.dora.obric.device_management.device_home.c2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020'H\u0002J,\u00103\u001a\u00020\u00142\u0006\u00102\u001a\u00020'2\u0006\u00104\u001a\u00020.2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020#06H\u0002J&\u00107\u001a\u00020\u00142\u0006\u00102\u001a\u00020'2\u0006\u00104\u001a\u00020.2\f\u00108\u001a\b\u0012\u0004\u0012\u00020#09H\u0002J\u0010\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020?H\u0002J\u0010\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020DH\u0002J\"\u0010E\u001a\u00020#2\b\u0010F\u001a\u0004\u0018\u00010\u00102\u0006\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\u0018H\u0002J\u0010\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020'H\u0002J\u0014\u0010K\u001a\u00020#*\u00020\u00142\u0006\u00104\u001a\u00020.H\u0002J\f\u0010L\u001a\u00020#*\u00020\u0014H\u0002J\u0010\u0010M\u001a\u00020.2\u0006\u00104\u001a\u00020.H\u0002J\u0010\u0010N\u001a\u00020.2\u0006\u00104\u001a\u00020.H\u0002J\u001c\u0010O\u001a\u00020#*\u00020P2\u0006\u00104\u001a\u00020.2\u0006\u0010Q\u001a\u00020.H\u0002J\f\u0010R\u001a\u00020#*\u00020SH\u0002J\f\u0010T\u001a\u00020#*\u00020UH\u0002J\f\u0010V\u001a\u00020#*\u00020WH\u0002J\f\u0010X\u001a\u00020#*\u00020WH\u0002J\u0010\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020.H\u0002J\b\u0010[\u001a\u00020.H\u0002J\b\u0010\\\u001a\u00020.H\u0002J\b\u0010]\u001a\u00020.H\u0002J\f\u0010^\u001a\u00020.*\u00020.H\u0002J\f\u0010_\u001a\u00020.*\u00020`H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/env_observe/DoraObricGEnvObserveFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "timeSection", "Landroid/view/View;", "lightSection", "timeSectionGap", "lightSectionGap", "envObserveSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "timeSwitch", "lightSwitch", "timeSwitchItem", "Lcom/obric/oui/lisitem/OCardListItem;", "startTimeItem", "endTimeItem", "envObserveCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "timeCheckedChangeListener", "lightCheckedChangeListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "buildTitleBar", "buildScrollContent", "buildEnvObserveCard", "buildTimeSection", "buildLightSection", "resolveLightTitleResId", "", "resolveProduct", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeEntryProduct;", "buildSectionTitle", "title", "buildSwitchItem", "position", "onSwitchCreated", "Lkotlin/Function1;", "buildTimeItem", "onClick", "Lkotlin/Function0;", "handleState", "envState", "Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveState;", "updateTimeItemsVisibility", "timeEnabled", "", "setEnvDependentViewsVisible", "visible", "updateTimeTexts", "state", "Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveState$State;", "bindSwitch", "targetSwitch", "checked", "listener", "showTimerSheet", "type", "applyCardStyle", "resetCardContainerMargins", "sectionTopPadding", "sectionBottomPadding", "applySectionCornerRadii", "Landroid/graphics/drawable/GradientDrawable;", "radiusDp", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "applyDropIconStyle", "Landroid/widget/ImageView;", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "applySectionTitleTextStyle", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGEnvObserveFragment extends DoraBaseFragment {
    public static final /* synthetic */ int t = 0;
    public final Lazy f;
    public View g;
    public View h;
    public View i;
    public View j;
    public OSwitch k;
    public OSwitch l;
    public OSwitch m;
    public OCardListItem n;
    public OCardListItem o;
    public OCardListItem p;
    public final e q;
    public final f r;
    public final g s;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraObricGEnvObserveLightTitle.values().length];
            r0[DoraObricGEnvObserveLightTitle.WHITE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DoraObricGEnvObserveLightTitle.YELLOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public /* synthetic */ class c implements FlowCollector, FunctionAdapter {
        public final /* synthetic */ DoraObricGEnvObserveFragment a;

        public c(DoraObricGEnvObserveFragment r1) {
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
            return new AdaptedFunctionReference(2, this.a, DoraObricGEnvObserveFragment.class, "handleState", "handleState(Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveState;)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object emit(Object r8, Continuation r9) {
            y r10 = (y) r8;
            DoraObricGEnvObserveFragment r11 = this.a;
            int r0 = DoraObricGEnvObserveFragment.t;
            r11.getClass();
            if (Intrinsics.areEqual(r10, y.a.a) == false) goto L5;
            g49.d.d("DoraObricGEnvObserveFragment", "env observe state is empty");
        L34:
            Unit r12 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return r12;
        L5:
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.env.EnvObserveState.State");
            y.b r13 = (y.b) r10;
            g49.d.d("DoraObricGEnvObserveFragment", "env enable: " + r13.a + ", time enable: " + r13.b + ", start time: " + r13.c + ", end time: " + r13.d);
            r11.fa0(r13.a);
            boolean r1 = r13.b;
            OCardListItem r2 = r11.n;
            if (r2 == null) goto L8;
            OCardListItem.h(r2, r1 ? 1 : 0);
            r11.W90(r2, r1 ? 1 : 0);
        L8:
            OCardListItem r3 = r11.o;
            int r4 = 8;
            if (r3 == null) goto L14;
            if (r1 == false) goto L12;
            int r5 = 0;
        L13:
            r3.setVisibility(r5);
            goto L14
        L12:
            r5 = 8;
        L14:
            OCardListItem r6 = r11.p;
            if (r6 == null) goto L19;
            if (r1 == false) goto L18;
            r4 = 0;
        L18:
            r6.setVisibility(r4);
        L19:
            OCardListItem r7 = r11.o;
            if (r7 == null) goto L25;
            r7.k(r13.c, r11.da0(96));
            OTextView r14 = r7.getEndDetail();
            if (r14 == null) goto L24;
            r14.setTextSize(2, 14.0f);
            TextViewCompat.setLineHeight(r14, r11.ha0(18.0f));
        L24:
            r11.X90(r7.getTailIconView());
        L25:
            OCardListItem r15 = r11.p;
            if (r15 == null) goto L31;
            r15.k(r13.d, r11.da0(96));
            OTextView r16 = r15.getEndDetail();
            if (r16 == null) goto L30;
            r16.setTextSize(2, 14.0f);
            TextViewCompat.setLineHeight(r16, r11.ha0(18.0f));
        L30:
            r11.X90(r15.getTailIconView());
        L31:
            DoraObricGEnvObserveFragment.Z90(r11.k, r13.a, r11.q);
            DoraObricGEnvObserveFragment.Z90(r11.l, r13.b, r11.r);
            DoraObricGEnvObserveFragment.Z90(r11.m, r13.e, r11.s);
            if (r13.f == true) goto L34;
            s r17 = s.a;
            Context r18 = r11.getContext();
            String r20 = r11.getString(2131903992);
            r17.getClass();
            s.c(r18, r20);
            goto L34
        }
    }

    static {
    }

    public final String k() {
        return "env_observe";
    }

    public final void onDestroyView() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final EnvObserveViewModel ea0() {
        return (EnvObserveViewModel) this.f.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.obric.device_management.setting.g.env_observe.e] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.obric.device_management.setting.g.env_observe.f] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.dora.obric.device_management.setting.g.env_observe.g] */
    public DoraObricGEnvObserveFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EnvObserveViewModel.class), new DoraObricGEnvObserveFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGEnvObserveFragment$special$$inlined$activityViewModels$default$2(this));
        this.q = new e(this);
        this.r = new f(this);
        this.s = new g(this);
    }

    public final void X90(ImageView r4) {
        r4.setImageTintList(ContextCompat.getColorStateList(r4.getContext(), 2131104363));
        r4.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 == null) goto L5;
        r0.width = da0(20);
        r0.height = da0(20);
    L6:
        r4.setLayoutParams(r0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final View aa0(String r8) {
        OSectionTitleBar r0 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131367728);
        if (r1 == null) goto L5;
        r1.setPadding(da0(20), da0(8), da0(12), da0(8));
    L5:
        r0.setTitleText(r8);
        r0.setTitleTextSize(12.0f);
        r0.setTitleTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        TextView r2 = (TextView) r0.findViewById(2131388792);
        if (r2 == null) goto L8;
        r2.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r2, ha0(16.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    L8:
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, da0(32)));
        return r0;
    }

    public final int da0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void fa0(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 0;
    L5:
        View r0 = this.g;
        if (r0 == null) goto L8;
        r0.setVisibility(r3);
    L8:
        View r1 = this.h;
        if (r1 == null) goto L11;
        r1.setVisibility(r3);
    L11:
        View r4 = this.i;
        if (r4 == null) goto L14;
        r4.setVisibility(r3);
    L14:
        View r5 = this.j;
        if (r5 == null) goto L18;
        r5.setVisibility(r3);
        return;
    L18:
        return;
    L4:
        r3 = 8;
        goto L5
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.dora.obric.device_management.setting.g.env_observe.c] */
    public final void ga0(final String r8) {
        Context r1 = getContext();
        if (r1 == null) goto L13;
        OSheet r9 = new q(r1, r8, ea0().startTimerInt(), ea0().endTimerInt(), new com.larus.dora.obric.device_management.setting.g.env_observe.c(r8, this)).e;
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        return;
    }

    public final int ha0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final void W90(OCardListItem r10, int r11) {
        ViewGroup.LayoutParams r0 = r10.getCardContainer().getLayoutParams();
        GradientDrawable r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L7:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r10.getCardContainer().setLayoutParams(r1);
    L9:
        FrameLayout r3 = r10.getCardContainer();
        int r4 = da0(8);
        if (r11 == 0) goto L13;
        if (r11 == 1) goto L13;
        int r6 = 0;
    L14:
        int r7 = da0(8);
        if (r11 != 0) goto L17;
    L19:
        int r8 = da0(8);
    L20:
        r3.setPadding(r4, r6, r7, r8);
        r10.getContentContainer().setPadding(0, 0, da0(4), 0);
        r10.getTitleContainer().setGravity(16);
        r10.getTitleContainer().setPadding(da0(12), da0(5), da0(8), da0(5));
        OTextView r5 = r10.getTitleView();
        r5.setGravity(8388611);
        r5.setMaxLines(1);
        r5.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r5.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r5, ha0(22.0f));
        r5.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r10.o(false);
        Drawable r9 = r10.getCardContainer().getBackground();
        if ((r9 instanceof GradientDrawable) == false) goto L23;
        GradientDrawable r12 = (GradientDrawable) r9;
    L24:
        if (r12 == null) goto L26;
        Y90(r12, r11, 20);
    L26:
        Drawable r13 = r10.getContentContainer().getBackground();
        if ((r13 instanceof GradientDrawable) == false) goto L29;
        r2 = (GradientDrawable) r13;
    L29:
        if (r2 == null) goto L32;
        Y90(r2, r11, 12);
        return;
    L32:
        return;
    L23:
        r12 = null;
        goto L24
    L17:
        if (r11 == 3) goto L19;
        r8 = 0;
    L13:
        r6 = da0(8);
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        EnvObserveViewModel r10 = ea0();
        Bundle r11 = getArguments();
        if (r11 == null) goto L5;
        String r12 = r11.getString("mac");
    L6:
        r10.updateCurrentDoraDeviceMac(r12);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGEnvObserveFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static void Z90(OSwitch r1, boolean r2, CompoundButton.OnCheckedChangeListener r3) {
        if (r1 == null) goto L4;
        r1.setOnCheckedChangeListener(null);
    L4:
        if (r1 == null) goto L6;
        r1.setChecked(r2);
    L6:
        if (r1 == null) goto L9;
        r1.setOnCheckedChangeListener(r3);
        return;
    }

    public final void Y90(GradientDrawable r11, int r12, int r13) {
        float r14 = da0(r13);
        int r0 = 0;
        if (r12 != 0) goto L5;
        float[] r15 = new float[8];
    L11:
        if (r0 >= 8) goto L13;
        r15[r0] = r14;
        r0 = r0 + 1;
    L13:
        r11.setCornerRadii(r15);
        return;
    L5:
        if (r12 == 1) goto L9;
        if (r12 == 3) goto L8;
        r15 = new float[8];
        goto L13
    L8:
        r15 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r14, r14, r14, r14};
        goto L13
    L9:
        r15 = new float[]{r14, r14, r14, r14, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L13
    }

    public final OCardListItem ba0(String r6, int r7, Function1<? super OSwitch, Unit> r8) {
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r7);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        r0.q(false);
        r0.setDefaultCustomEndView(1);
        r0.m(true);
        r0.r(false);
        OSwitch r9 = r0.getEndSwitch();
        if (r9 == null) goto L5;
        r8.invoke(r9);
    L5:
        r0.setOnContentClickListener(new com.larus.dora.obric.device_management.setting.g.env_observe.b(r0));
        W90(r0, r7);
        return r0;
    }

    public final OCardListItem ca0(String r6, int r7, final Function0<Unit> r8) {
        OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r7);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        r0.q(false);
        r0.setDefaultCustomEndView(3);
        r0.m(true);
        r0.k("", da0(96));
        OTextView r9 = r0.getEndDetail();
        if (r9 == null) goto L5;
        r9.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r9, ha0(18.0f));
    L5:
        r0.setTailIcon(2131245082);
        X90(r0.getTailIconView());
        r0.r(true);
        r0.setOnContentClickListener(new l(r8));
        W90(r0, r7);
        return r0;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        OFloatingTitleBar r2 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r2.setCenterTitle(getString(2131903497));
        TextView r9 = (TextView) r2.findViewById(2131365427);
        if (r9 == null) goto L5;
        r9.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r9.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r9, ha0(22.0f));
        r9.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r2.R(false);
        OFloatingTitleBar.k(r2, null, 6).setOnClickListener(new h(this));
        Context r5 = requireContext();
        LinearLayout r10 = new LinearLayout(r5);
        r10.setOrientation(1);
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        r10.setPadding(da0(12), 0, da0(12), da0(24));
        r10.addView(ba0(getString(2131903497), 0, new com.larus.dora.obric.device_management.setting.g.env_observe.a(this)));
        View r3 = new View(requireContext());
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, da0(16)));
        r10.addView(r3);
        this.i = r3;
        LinearLayout r4 = new LinearLayout(requireContext());
        r4.setOrientation(1);
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
        r4.addView(aa0(getString(2131902546)));
        OCardListItem r12 = ba0(getString(2131903498), 1, new i(this));
        r4.addView(r12);
        this.n = r12;
        OCardListItem r13 = ca0(getString(2131902557), 2, new j(this));
        r4.addView(r13);
        this.o = r13;
        OCardListItem r7 = ca0(getString(2131902554), 3, new k(this));
        r4.addView(r7);
        this.p = r7;
        r10.addView(r4);
        this.g = r4;
        View r6 = new View(requireContext());
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, da0(16)));
        r10.addView(r6);
        this.j = r6;
        LinearLayout r8 = new LinearLayout(requireContext());
        r8.setOrientation(1);
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.addView(aa0(getString(2131902534)));
        int r11 = m.a;
        Bundle r14 = getArguments();
        if (r14 == null) goto L8;
        int r15 = r14.getInt("product_id", -1);
    L9:
        int r16 = c2.a;
        Integer r20 = Integer.valueOf(r15);
        if (r20.intValue() == (-1)) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == true) goto L16;
        r20 = null;
    L16:
        DoraObricDeviceModeEntryProduct r21 = c2.a(r20, null);
        if (r21 == DoraObricDeviceModeEntryProduct.UNSUPPORTED) goto L19;
        boolean r112 = true;
    L20:
        if (r112 == true) goto L23;
        r21 = null;
    L23:
        if (r21 != null) goto L25;
        r21 = DoraObricDeviceModeEntryProduct.G1;
    L25:
        Intrinsics.checkNotNullParameter(r21, "product");
        if (r21 != DoraObricDeviceModeEntryProduct.G1) goto L28;
        DoraObricGEnvObserveLightTitle r22 = DoraObricGEnvObserveLightTitle.WHITE;
    L29:
        int r23 = b.a[r22.ordinal()];
        if (r23 == 1) goto L35;
        if (r23 != 2) goto L34;
        int r24 = 2131903500;
    L36:
        r8.addView(ba0(getString(r24), 0, new d(this)));
        r10.addView(r8);
        this.h = r8;
        fa0(false);
        NestedScrollView r25 = new NestedScrollView(r5);
        r25.setClipChildren(true);
        r25.setClipToPadding(false);
        r25.setOverScrollMode(2);
        r25.setFillViewport(true);
        r25.setPadding(0, da0(16), 0, 0);
        r25.addView(r10, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r1, r2, r25, v19.c.a(2130970531, requireContext(), 2131102535), null);
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        r24 = 2131902558;
        goto L36
    L28:
        r22 = DoraObricGEnvObserveLightTitle.YELLOW;
        goto L29
    L19:
        r112 = false;
        goto L20
    L12:
        r111 = false;
        goto L13
    L8:
        r15 = -1;
        goto L9
    }
}
