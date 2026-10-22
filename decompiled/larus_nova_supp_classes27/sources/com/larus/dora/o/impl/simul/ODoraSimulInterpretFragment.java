package com.larus.dora.o.impl.simul;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.o.impl.databinding.DoraOFragmentSimulInterpretBinding;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalVertical;
import com.obric.oui.button.OButton;
import com.obric.oui.divider.ODivider;
import com.obric.oui.header.HeaderInfoView;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0007*\u0001P\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010+\u001a\u00020\u0010H\u0002J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0010H\u0002J\b\u00101\u001a\u00020$H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u001a\u00103\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u00020\u0010H\u0002J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020$H\u0002J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020\u0016H\u0002J\u0010\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0016H\u0002J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020$2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010?\u001a\u00020=2\u0006\u0010:\u001a\u00020\u0016H\u0002J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020$H\u0002J\u0010\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\u0010H\u0002J\b\u0010D\u001a\u00020$H\u0002J\u0010\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020\u0010H\u0002J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020$H\u0002J\u0010\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020\u0010H\u0002J\b\u0010T\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)R\u0010\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Q¨\u0006V"}, d2 = {"Lcom/larus/dora/o/impl/simul/ODoraSimulInterpretFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentSimulInterpretBinding;", "viewModel", "Lcom/larus/dora/o/impl/simul/ODoraSimulInterpretViewModel;", "getViewModel", "()Lcom/larus/dora/o/impl/simul/ODoraSimulInterpretViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "topAdapter", "Lcom/larus/dora/o/impl/simul/OSimulSubtitleAdapter;", "bottomAdapter", "userDraggingTop", "", "userDraggingBottom", "modeTab", "Lcom/obric/oui/tab/OTabLayout;", "suppressTabEvent", "currentSliderPercent", "", "dragStartPercent", "sliderAnimator", "Landroid/animation/ValueAnimator;", "topCardFlipped", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "deviceForm", "Lcom/larus/dora/o/impl/simul/OSimulDeviceForm;", "getDeviceForm", "()Lcom/larus/dora/o/impl/simul/OSimulDeviceForm;", "deviceForm$delegate", "isConference", "setupBottomActionBar", "setupContentTopInset", "setupTitleBar", "setupModeTab", "onModeSwitch", "applyDeviceForm", "applyModeContent", "applyConferenceLayout", "resetSlider", "setupSubtitleLists", "setupControls", "setupSliderHandle", "contentHeight", "applySliderPercent", "percent", "levelPercent", "level", "Lcom/larus/dora/o/impl/simul/ODoraSimulInterpretFragment$Companion$SliderLevel;", "animateSliderTo", "getNearestSliderLevel", "scrollBothToLatest", "startSimulInterpret", "showLanguageDialog", "forTop", "observeViewModel", "renderTranslatingState", "translating", "dp", "", "value", "languageButtonText", "", "text", "", "setupWearStateWatch", "wearStateListener", "com/larus/dora/o/impl/simul/ODoraSimulInterpretFragment$wearStateListener$1", "Lcom/larus/dora/o/impl/simul/ODoraSimulInterpretFragment$wearStateListener$1;", "onWearStateChanged", "wearing", "onDestroyView", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODoraSimulInterpretFragment extends Fragment {
    public static final /* synthetic */ int q = 0;
    public DoraOFragmentSimulInterpretBinding d;
    public final Lazy e;
    public final OSimulSubtitleAdapter f;
    public final OSimulSubtitleAdapter g;
    public boolean h;
    public boolean i;
    public boolean j;
    public float k;
    public float l;
    public ValueAnimator m;
    public boolean n;
    public final Lazy o;
    public final b p;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/o/impl/simul/ODoraSimulInterpretFragment$Companion$SliderLevel;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "MIDDLE", "BOTTOM", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum SliderLevel extends Enum<SliderLevel> {
            public static final SliderLevel BOTTOM = null;
            public static final SliderLevel MIDDLE = null;
            public static final SliderLevel TOP = null;
            public static final /* synthetic */ SliderLevel[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<SliderLevel> getEntries() {
                return b;
            }

            static {
                SliderLevel r0 = new SliderLevel("TOP", 0);
                TOP = r0;
                SliderLevel r1 = new SliderLevel("MIDDLE", 1);
                MIDDLE = r1;
                SliderLevel r3 = new SliderLevel("BOTTOM", 2);
                BOTTOM = r3;
                SliderLevel[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
            }

            public static SliderLevel[] values() {
                return (SliderLevel[]) a.clone();
            }

            public static SliderLevel valueOf(String r1) {
                return (SliderLevel) r27.a.a(SliderLevel.class, r1);
            }

            public SliderLevel(String r1, int r2) {
                super(r1, r2);
            }
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Companion.SliderLevel.values().length];
            r0[Companion.SliderLevel.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[Companion.SliderLevel.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[Companion.SliderLevel.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[OSimulDeviceForm.values().length];
            r1[OSimulDeviceForm.EARPHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[OSimulDeviceForm.GLASSES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[OSimulDeviceForm.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    public static final class b implements h49.m {
        public final /* synthetic */ ODoraSimulInterpretFragment a;

        public b(ODoraSimulInterpretFragment r1) {
            this.a = r1;
        }

        @Override // h49.m
        public final void a(boolean r2, boolean r3) {
            ODoraSimulInterpretFragment r0 = this.a;
            if (r2 == false) goto L6;
            if (r3 == false) goto L6;
            boolean r4 = true;
        L7:
            ODoraSimulInterpretFragment.T90(r0, r4);
            return;
        L6:
            r4 = false;
            goto L7
        }
    }

    static {
    }

    public final OSimulDeviceForm Y90() {
        return (OSimulDeviceForm) this.o.getValue();
    }

    public final ODoraSimulInterpretViewModel Z90() {
        return (ODoraSimulInterpretViewModel) this.e.getValue();
    }

    public ODoraSimulInterpretFragment() {
        final Function0<Fragment> r0 = new ODoraSimulInterpretFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ODoraSimulInterpretViewModel.class), new ODoraSimulInterpretFragment$special$$inlined$viewModels$default$2(r0), new ODoraSimulInterpretFragment$special$$inlined$viewModels$default$3(r0, this));
        this.f = new OSimulSubtitleAdapter(false);
        this.g = new OSimulSubtitleAdapter(true);
        this.k = 0.5f;
        this.l = 0.5f;
        this.o = LazyKt.lazy(new n(this));
        this.p = new b(this);
    }

    public final boolean aa0() {
        if (Y90().getSupportConference() == true) goto L5;
    L7:
        return false;
    L5:
        if (DoraConfig.f() == false) goto L7;
        return true;
    }

    public final void da0() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        IDoraAVLinkService r1 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r1 == null) goto L9;
        r1.D0(r0, null, null);
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L7;
        r1.c(this.p);
    L7:
        ValueAnimator r2 = this.m;
        if (r2 == null) goto L10;
        r2.cancel();
    L10:
        this.m = null;
        this.d = null;
    }

    public static float ba0(Companion.SliderLevel r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return 0.25f;
    L5:
        if (r2 != 2) goto L7;
        return 0.5f;
    L7:
        if (r2 != 3) goto L10;
        return 0.75f;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void V90(boolean r6) {
        DoraOFragmentSimulInterpretBinding r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Y90() != OSimulDeviceForm.UNKNOWN) goto L9;
        return;
    L9:
        if (Y90().getSupportConference() == true) goto L12;
        r0.q.setIcon(2131233959);
        r0.q.setTitle(getString(2131902676));
        r0.q.setSubtitle(getString(Y90().getIntroRes()));
        U90(false, true);
        return;
    L12:
        int r1 = 2131233966;
        if (r6 == false) goto L15;
        r0.q.setIcon(2131233966);
        r0.q.setTitle(getString(2131904089));
        r0.q.setSubtitle(getString(2131903467));
    L16:
        ImageView r2 = r0.j;
        if (r6 == true) goto L20;
        r1 = Y90().getTopIconRes();
    L20:
        r2.setImageResource(r1);
        U90(r6, true);
        return;
    L15:
        r0.q.setIcon(2131233959);
        r0.q.setTitle(getString(2131904090));
        r0.q.setSubtitle(getString(2131903468));
        goto L16
    }

    public final void W90(float r4) {
        DoraOFragmentSimulInterpretBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        float r5 = RangesKt.coerceIn(r4, ba0(Companion.SliderLevel.TOP), ba0(Companion.SliderLevel.BOTTOM));
        this.k = r5;
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(r0.C);
        r1.setGuidelinePercent(r0.o.getId(), r5);
        r1.applyTo(r0.C);
    }

    public final int X90(int r3) {
        Resources r0 = getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3) + 0.5f);
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.dora.o.impl.simul.f] */
    public final void ca0(boolean r20) {
        Context r1 = getContext();
        if (r1 != null) goto L5;
        return;
    L5:
        final b0 r8 = new b0(r1, Z90().allLanguages(), (w88.j) Z90().getTopLanguage().getValue(), (w88.j) Z90().getBottomLanguage().getValue(), r20, Y90(), new f(this));
        final OSheet r0 = r8.h;
        OSheet.HeightMode r2 = OSheet.HeightMode.FULL_HEIGHT;
        r0.getClass();
        OSheetBase.DefaultImpls.q(r0, r2);
        OSheetBase.DefaultImpls.o(r0, OSheet.Header.ONLY_TITLE, null, r0.getContext().getString(2131904002), r0.getContext().getString(2131909399), false, null, null, 16134);
        LinearLayout r3 = new LinearLayout(r8.a);
        r3.setOrientation(1);
        r3.setPadding(r8.c(12), r8.c(16), r8.c(12), 0);
        LinearLayout r6 = null;
        View r4 = LayoutInflater.from(r8.a).inflate(2131560163, null);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r5 = (LinearLayout) r4;
        r8.i = r5.findViewById(2131377140);
        r8.j = r5.findViewById(2131377139);
        OButton r7 = r5.findViewById(2131377141);
        Button r10 = r8.i;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topSide");
        r10 = null;
    L8:
        r10.setOnClickListener(new x(r8));
        Button r11 = r8.j;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSide");
        r11 = null;
    L11:
        r11.setOnClickListener(new y(r8));
        r7.setOnClickListener(new z(r8));
        r3.addView(r5, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r9 = new LinearLayout(r8.a);
        r9.setOrientation(1);
        r8.k = r9;
        ScrollView r12 = new ScrollView(r8.a);
        r12.setVerticalScrollBarEnabled(false);
        LinearLayout r13 = r8.k;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
    L15:
        r12.addView(r6, new FrameLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-1, -1);
        r14.topMargin = r8.c(16);
        r14.bottomMargin = r8.c(16);
        Unit r15 = Unit.INSTANCE;
        r3.addView(r12, r14);
        r8.e();
        r8.d();
        OSheetBase.DefaultImpls.j(r0, r3);
        OSheetBase.DefaultImpls.k(r0, r0.getContext().getString(2131901991), false, new v(r0), r0.getContext().getString(2131901992), true, new w(r8, r0));
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L19:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        return;
    L14:
        r6 = r13;
        goto L15
    }

    public static final CharSequence S90(ODoraSimulInterpretFragment r11, String r12) {
        Context r0 = r11.getContext();
        if (r0 != null) goto L6;
        return r12;
    L6:
        if (r12.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L17;
        Drawable r5 = ContextCompat.getDrawable(r0, 2131233963);
        if (r5 == null) goto L18;
        int r2 = r11.X90(16);
        InsetDrawable r3 = new InsetDrawable(r5, r11.X90(2), 0, 0, 0);
        r3.setBounds(0, 0, r11.X90(2) + r2, r2);
        SpannableStringBuilder r13 = new SpannableStringBuilder(r12);
        r13.append("\u200b");
        r13.setSpan(new b0.a(r3), r13.length() - 1, r13.length(), 33);
        return r13;
    L18:
        return r12;
    L17:
        return r12;
    L8:
        r1 = false;
        goto L9
    }

    public static final void T90(ODoraSimulInterpretFragment r3, boolean r4) {
        r3.getClass();
        FLogger.a.i("ODoraSimulInterpretFragment", "wear state changed: wearing=" + r4 + ", form=" + r3.Y90());
    }

    public final void U90(boolean r13, boolean r14) {
        DoraOFragmentSimulInterpretBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 8;
        if (Y90().getAdjustAreaSize() == true) goto L9;
        r0.w.setVisibility(0);
        r0.u.setVisibility(8);
        return;
    L9:
        boolean r1 = ((Boolean) Z90().isTranslating().getValue()).booleanValue();
        if (r13 == false) goto L15;
        r0.w.setVisibility(8);
        r0.u.setVisibility(8);
        r0.n.setVisibility(8);
        if (this.n == false) goto L14;
        this.n = false;
        r0.x.setRotation(0.0f);
    L14:
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(r0.C);
        r3.clear(r0.b.getId(), 3);
        r3.connect(r0.b.getId(), 3, 0, 3);
        r3.applyTo(r0.C);
    L23:
        if (r13 == true) goto L27;
        if (r14 == false) goto L28;
        W90(ba0((Companion.SliderLevel) Companion.SliderLevel.getEntries().get(RangesKt.coerceIn(DoraConfig.a.getInt("key_si_slider_level", 0), 0, Companion.SliderLevel.getEntries().size() - 1))));
        return;
    L28:
        return;
    L27:
        return;
    L15:
        r0.w.setVisibility(0);
        OSimulSliderHandleView r5 = r0.u;
        if (r1 == false) goto L18;
        int r6 = 0;
    L19:
        r5.setVisibility(r6);
        OButton r7 = r0.n;
        if (r1 == false) goto L22;
        r2 = 0;
    L22:
        r7.setVisibility(r2);
        ConstraintSet r4 = new ConstraintSet();
        r4.clone(r0.C);
        r4.clear(r0.b.getId(), 3);
        int r8 = r0.b.getId();
        int r9 = r0.o.getId();
        Resources r10 = getResources();
        r4.connect(r8, 3, r9, 4, (int) ((WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density * 2) + 0.5f));
        r4.applyTo(r0.C);
        goto L23
    L18:
        r6 = 8;
        goto L19
    }

    public final void onViewCreated(View r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r24, "view");
        super.onViewCreated(r24, r25);
        DoraOFragmentSimulInterpretBinding r1 = this.d;
        boolean r3 = false;
        if (r1 == null) goto L13;
        HeaderInfoView r2 = r1.q;
        if (r2 == null) goto L13;
        OImageAppIcon r4 = r2.getIconView();
        if (r4 == null) goto L13;
        r4.setClipToMask(false);
        r4.setStrokeColor(0);
        cma.b r5 = r4.a;
        if (r5 == null) goto L12;
        r5.c = null;
    L12:
        r4.l();
    L13:
        DoraOFragmentSimulInterpretBinding r6 = this.d;
        if (r6 == null) goto L18;
        final OFloatingTitleBar r7 = r6.t;
        if (r7 == null) goto L18;
        OFloatingTitleBar.k(r7, new o(this), 2);
        r7.h(2131246836, -1, new com.larus.dora.o.impl.simul.b(r7));
    L18:
        DoraOFragmentSimulInterpretBinding r8 = this.d;
        int r9 = 8;
        if (r8 == null) goto L25;
        OBottomActionBarNormalVertical r10 = r8.d;
        View r11 = r8.v;
        LinearLayout r12 = r8.D;
        r10.removeView(r11);
        r10.removeView(r12);
        r10.setButtons(CollectionsKt.listOf(new View[]{r11, r12}));
        ODivider r13 = r10.c;
        if (r13 == null) goto L25;
        r13.setVisibility(8);
    L25:
        final DoraOFragmentSimulInterpretBinding r14 = this.d;
        if (r14 == null) goto L29;
        final int r15 = X90(56) + X90(16);
        ViewCompat.setOnApplyWindowInsetsListener(r14.a, new c(r14, r15));
    L29:
        DoraOFragmentSimulInterpretBinding r16 = this.d;
        if (r16 == null) goto L38;
        OFloatingTitleBar r17 = r16.t;
        if (r17 == null) goto L38;
        if (Y90().getSupportConference() == true) goto L37;
        FLogger.a.i("ODoraSimulInterpretFragment", "setupModeTab skipped: form=" + Y90());
        goto L38
    L37:
        OTabLayout r18 = LayoutInflater.from(requireContext()).inflate(2131560165, r17.getCenterButtonGroup(), false);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.oui.tab.OTabLayout");
        OTabLayout r20 = r18;
        r20.setTabMaxWidth(X90(160));
        r20.setTabMode(0);
        r20.setTabPaddingStart(X90(12));
        r20.setTabPaddingEnd(X90(12));
        OTabLayoutBase.i r21 = r20.s(0);
        r21.a(2131904090);
        r20.h(r21);
        OTabLayoutBase.i r22 = r20.s(0);
        r22.a(2131904089);
        r20.h(r22);
        r20.setOnTabSelectedListener(new t(this));
        this.j = true;
        r20.v(aa0() ? 1 : 0);
        this.j = false;
        r17.setCenterCustomView(r20);
    L38:
        DoraOFragmentSimulInterpretBinding r23 = this.d;
        if (r23 == null) goto L43;
        RecyclerView r26 = r23.B;
        if (r26 == null) goto L43;
        r26.setLayoutManager(new LinearLayoutManager(r26.getContext()));
        r26.setAdapter(this.f);
        r26.addOnScrollListener(new ODoraSimulInterpretFragment$setupSubtitleLists$1$1(this));
    L43:
        DoraOFragmentSimulInterpretBinding r27 = this.d;
        if (r27 == null) goto L48;
        RecyclerView r28 = r27.h;
        if (r28 == null) goto L48;
        r28.setLayoutManager(new LinearLayoutManager(r28.getContext()));
        r28.setAdapter(this.g);
        r28.addOnScrollListener(new ODoraSimulInterpretFragment$setupSubtitleLists$2$1(this));
    L48:
        DoraOFragmentSimulInterpretBinding r30 = this.d;
        if (r30 == null) goto L53;
        OButton r31 = r30.v;
        if (r31 == null) goto L53;
        r31.setOnClickListener(new com.larus.dora.o.impl.simul.a(this));
    L53:
        DoraOFragmentSimulInterpretBinding r32 = this.d;
        if (r32 == null) goto L58;
        OButton r33 = r32.m;
        if (r33 == null) goto L58;
        r33.setOnClickListener(new g());
    L58:
        DoraOFragmentSimulInterpretBinding r34 = this.d;
        if (r34 == null) goto L63;
        OButton r35 = r34.n;
        if (r35 == null) goto L63;
        r35.setOnClickListener(new h(this));
    L63:
        DoraOFragmentSimulInterpretBinding r36 = this.d;
        if (r36 == null) goto L68;
        OButton r37 = r36.z;
        if (r37 == null) goto L68;
        r37.setOnClickListener(new i(this));
    L68:
        DoraOFragmentSimulInterpretBinding r38 = this.d;
        if (r38 == null) goto L73;
        OButton r40 = r38.e;
        if (r40 == null) goto L73;
        r40.setOnClickListener(new j(this));
    L73:
        DoraOFragmentSimulInterpretBinding r41 = this.d;
        if (r41 == null) goto L78;
        OSimulSliderHandleView r42 = r41.u;
        if (r42 == null) goto L78;
        r42.setOnDragStart(new k(this));
        r42.setOnDrag(new l(this));
        r42.setOnDragEnd(new m(this));
    L78:
        DoraOFragmentSimulInterpretBinding r43 = this.d;
        if (r43 != null) goto L82;
    L94:
        IDoraService r44 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r44 == null) goto L112;
        DeviceService r45 = r44.device();
        if (r45 == null) goto L112;
        int r46 = a.b[Y90().ordinal()];
        if (r46 == 1) goto L109;
        if (r46 != 2) goto L103;
        r45.d(this.p);
        goto L112
    L103:
        if (r46 == 3) goto L112;
        throw new NoWhenBranchMatchedException();
    L109:
        if (r45.f() == false) goto L111;
        r45.d(this.p);
        goto L112
    L111:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODoraSimulInterpretFragment$setupWearStateWatch$1(this, null), 3, null);
    L112:
        V90(aa0());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODoraSimulInterpretFragment$observeViewModel$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODoraSimulInterpretFragment$observeViewModel$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODoraSimulInterpretFragment$observeViewModel$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODoraSimulInterpretFragment$observeViewModel$4(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODoraSimulInterpretFragment$observeViewModel$5(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODoraSimulInterpretFragment$observeViewModel$6(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODoraSimulInterpretFragment$observeViewModel$7(this, null), 3, null);
        Z90().bind();
        Bundle r47 = getArguments();
        if (r47 != null) goto L115;
    L117:
        if (r3 == false) goto L120;
        da0();
        return;
    L120:
        return;
    L115:
        if (r47.getBoolean(DoraObricDeviceHomeViewModel.PARAM_AUTO_START) != true) goto L117;
        r3 = true;
        goto L117
    L82:
        if (Y90() != OSimulDeviceForm.UNKNOWN) goto L84;
        FLogger.a.e("ODoraSimulInterpretFragment", "unknown device form, mask page");
        r43.s.setVisibility(0);
        goto L94
    L84:
        r43.s.setVisibility(8);
        r43.j.setImageResource(Y90().getTopIconRes());
        r43.i.setImageResource(Y90().getBottomIconRes());
        if (Y90() != OSimulDeviceForm.EARPHONE) goto L87;
        boolean r48 = true;
    L88:
        ImageView r50 = r43.k;
        if (r48 == false) goto L91;
        r9 = 0;
    L91:
        r50.setVisibility(r9);
        if (r48 == false) goto L94;
        r43.k.setOnClickListener(new d(this));
        goto L94
    L87:
        r48 = false;
        goto L88
    }

    public final View onCreateView(LayoutInflater r35, ViewGroup r36, Bundle r37) {
        Intrinsics.checkNotNullParameter(r35, "inflater");
        ConstraintLayout r0 = r35.inflate(2131560149, r36, false);
        int r1 = 2131364433;
        OUILinearLayout r5 = ViewBindings.findChildViewById(r0, 2131364433);
        if (r5 == null) goto L67;
        r1 = 2131364434;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r0, 2131364434);
        if (r6 == null) goto L67;
        r1 = 2131364443;
        OBottomActionBarNormalVertical r7 = ViewBindings.findChildViewById(r0, 2131364443);
        if (r7 == null) goto L67;
        r1 = 2131364478;
        OButton r8 = ViewBindings.findChildViewById(r0, 2131364478);
        if (r8 == null) goto L67;
        r1 = 2131364479;
        OButton r9 = ViewBindings.findChildViewById(r0, 2131364479);
        if (r9 == null) goto L67;
        r1 = 2131364482;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131364482);
        if (r10 == null) goto L67;
        r1 = 2131364530;
        RecyclerView r11 = ViewBindings.findChildViewById(r0, 2131364530);
        if (r11 == null) goto L67;
        r1 = 2131365176;
        if (ViewBindings.findChildViewById(r0, 2131365176) == null) goto L67;
        r1 = 2131365177;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r0, 2131365177);
        if (r12 == null) goto L67;
        r1 = 2131365204;
        if (ViewBindings.findChildViewById(r0, 2131365204) == null) goto L67;
        r1 = 2131365205;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r0, 2131365205);
        if (r13 == null) goto L67;
        r1 = 2131365234;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r0, 2131365234);
        if (r14 == null) goto L67;
        r1 = 2131365235;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131365235);
        if (r15 == null) goto L67;
        r1 = 2131371623;
        OButton r16 = ViewBindings.findChildViewById(r0, 2131371623);
        if (r16 == null) goto L67;
        r1 = 2131372914;
        OButton r17 = ViewBindings.findChildViewById(r0, 2131372914);
        if (r17 == null) goto L67;
        r1 = 2131374166;
        Guideline r18 = ViewBindings.findChildViewById(r0, 2131374166);
        if (r18 == null) goto L67;
        r1 = 2131378198;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r0, 2131378198);
        if (r110 == null) goto L67;
        r1 = 2131380240;
        HeaderInfoView r20 = ViewBindings.findChildViewById(r0, 2131380240);
        if (r20 == null) goto L67;
        r1 = 2131381462;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131381462);
        if (r21 == null) goto L67;
        r1 = 2131381804;
        View r22 = ViewBindings.findChildViewById(r0, 2131381804);
        if (r22 == null) goto L67;
        r1 = 2131386528;
        OFloatingTitleBar r23 = ViewBindings.findChildViewById(r0, 2131386528);
        if (r23 == null) goto L67;
        r1 = 2131386891;
        OSimulSliderHandleView r24 = (OSimulSliderHandleView) ViewBindings.findChildViewById(r0, 2131386891);
        if (r24 == null) goto L67;
        r1 = 2131387208;
        OButton r25 = ViewBindings.findChildViewById(r0, 2131387208);
        if (r25 == null) goto L67;
        r1 = 2131389134;
        OUILinearLayout r26 = ViewBindings.findChildViewById(r0, 2131389134);
        if (r26 == null) goto L67;
        r1 = 2131389135;
        LinearLayout r27 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131389135);
        if (r27 == null) goto L67;
        r1 = 2131389136;
        ImageView r28 = (ImageView) ViewBindings.findChildViewById(r0, 2131389136);
        if (r28 == null) goto L67;
        r1 = 2131389175;
        OButton r210 = ViewBindings.findChildViewById(r0, 2131389175);
        if (r210 == null) goto L67;
        r1 = 2131389176;
        OButton r30 = ViewBindings.findChildViewById(r0, 2131389176);
        if (r30 == null) goto L67;
        r1 = 2131389229;
        RecyclerView r31 = ViewBindings.findChildViewById(r0, 2131389229);
        if (r31 == null) goto L67;
        r1 = 2131389337;
        ConstraintLayout r32 = ViewBindings.findChildViewById(r0, 2131389337);
        if (r32 == null) goto L67;
        r1 = 2131389351;
        LinearLayout r33 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131389351);
        if (r33 == null) goto L67;
        ConstraintLayout r2 = r0;
        this.d = new DoraOFragmentSimulInterpretBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33);
        return r2;
    L67:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
