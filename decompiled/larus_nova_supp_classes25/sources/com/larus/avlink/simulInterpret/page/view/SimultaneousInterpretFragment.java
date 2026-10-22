package com.larus.avlink.simulInterpret.page.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LayoutFragmentBinding;
import com.larus.avlink.n1;
import com.larus.avlink.simulInterpret.page.model.AREA;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.avlink.simulInterpret.page.model.SimultaneousInterpretState;
import com.larus.avlink.simulInterpret.page.model.SimultaneousInterpretViewModel;
import com.larus.avlink.simulInterpret.page.model.SliderLevel;
import com.larus.avlink.simulInterpret.page.ui.BottomControlView;
import com.larus.avlink.simulInterpret.page.ui.BottomTranslatePanelView;
import com.larus.avlink.simulInterpret.page.ui.OnboardingPanelView;
import com.larus.avlink.simulInterpret.page.ui.SliderTouchView;
import com.larus.avlink.simulInterpret.page.ui.TitleView;
import com.larus.avlink.simulInterpret.page.ui.TopTranslatePanelView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.j0;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u00104\u001a\u00020\u001dH\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u0007H\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\u0018\u00108\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u0007H\u0002J\u0018\u0010:\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u0007H\u0002J\u0018\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u0007H\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u000fH\u0002J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u000fH\u0002J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u0007H\u0002J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u0007H\u0002J\u0010\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\tH\u0002J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020F2\u0006\u0010C\u001a\u00020\tH\u0002J\u0010\u0010H\u001a\u00020\t2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u0007H\u0002J\b\u0010K\u001a\u00020\u001dH\u0002J\b\u0010L\u001a\u00020\u001dH\u0002J\b\u0010M\u001a\u00020\u001dH\u0002J\b\u0010N\u001a\u00020\u000fH\u0002J\b\u0010O\u001a\u00020\u001dH\u0016J\b\u0010P\u001a\u00020\u0007H\u0016J\b\u0010Q\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/view/SimultaneousInterpretFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "enterFrom", "", "autoStart", "", "currentSliderOffset", "", "dragStartSliderOffset", "hasSliderOffset", "sliderAnimator", "Landroid/animation/ValueAnimator;", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "binding", "Lcom/larus/avlink/impl/databinding/LayoutFragmentBinding;", "topAdapter", "Lcom/larus/avlink/simulInterpret/page/view/TranslationResultAdapter;", "bottomAdapter", "viewModel", "Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretViewModel;", "getViewModel", "()Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "onBudsCallback", "Lkotlin/Function1;", "", "wearStateListener", "Lcom/larus/dora/api/wrapper/WearStateListener;", "translationStateListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onStop", "onDestroyView", "initDarkMode", "initSubscribers", "setViewListeners", "startTranslation", "tryStartSi", "updateEndButtonSubTextVisibility", "reportFlipClick", "needRotate", "reportEndClick", "initTitleView", "isConferenceEnable", "initOnboardingView", "initTopTranslationView", "type", "initBottomTranslationView", "initBottomControlView", "adjustTranslatingView", "isConference", "adjustInitialView", "updateSliderOffset", "offset", "animateSliderTo", "level", "Lcom/larus/avlink/simulInterpret/page/model/SliderLevel;", "getNearestSliderLevel", "getSliderOffset", "updateTranslationConferenceMode", "isConferenceMode", "showMaskView", "hideMaskView", "endSi", "getDoraDeviceType", "onResume", "autoLogEnterPage", "getCurrentPageName", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SimultaneousInterpretFragment extends TraceFragment {
    public static final /* synthetic */ int s = 0;
    public String e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public ValueAnimator j;
    public DoraDeviceType k;
    public LayoutFragmentBinding l;
    public TranslationResultAdapter m;
    public TranslationResultAdapter n;
    public final com.larus.ui.arch.vm.internal.l o;
    public final c0 p;
    public final f q;
    public final com.larus.avlink.simulInterpret.page.view.b r;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DoraDeviceType.values().length];
            r0[DoraDeviceType.DEVICE_G.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            a = r0;
            int[] r1 = new int[SliderLevel.values().length];
            r1[SliderLevel.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L14:
            r1[SliderLevel.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L20:
            r1[SliderLevel.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L8:
            b = r1;
        }
    }

    public static final class c implements Function0<LifecycleOwner> {
        public final /* synthetic */ Fragment a;

        public c(Fragment r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class d implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ Fragment a;

        public d(Fragment r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class e implements Function0<ViewModelProvider.Factory> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public static final class f implements h49.m {
        public final /* synthetic */ SimultaneousInterpretFragment a;

        public f(SimultaneousInterpretFragment r1) {
            this.a = r1;
        }

        public final void a(boolean r7, boolean r8) {
            n1.d("SIFragment", "onWearStateChanged -> leftOn: " + r7 + ", rightOn: " + r8);
            if (r7 == false) goto L6;
            if (r8 == false) goto L6;
            SimultaneousInterpretFragment r9 = this.a;
            int r10 = SimultaneousInterpretFragment.s;
            r9.Y90();
            return;
        L6:
            SimultaneousInterpretFragment r11 = this.a;
            int r12 = SimultaneousInterpretFragment.s;
            r11.Z90();
            if (ha8.d.a == true) goto L11;
            t19.s r0 = t19.s.a;
            Context r1 = this.a.requireContext();
            int r13 = j0.a;
            t19.s.j(r0, r1, j0.d(2131902484), null, false, 28);
            return;
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "interpretation";
    }

    public final SimultaneousInterpretViewModel X90() {
        return (SimultaneousInterpretViewModel) this.o.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.avlink.simulInterpret.page.view.c0] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.avlink.simulInterpret.page.view.b] */
    public SimultaneousInterpretFragment() {
        this.e = "";
        this.o = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(SimultaneousInterpretViewModel.class), Reflection.getOrCreateKotlinClass(SimultaneousInterpretState.class), new c(this), new d(this), e.a);
        this.p = new c0(this);
        this.q = new f(this);
        this.r = new com.larus.avlink.simulInterpret.page.view.b(this);
    }

    public final void V90() {
        X90().setRotatedStatus(false);
        TranslationResultAdapter r0 = this.m;
        TranslationResultAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topAdapter");
        r0 = null;
    L5:
        r0.getClass();
        r0.d = CollectionsKt.emptyList();
        r0.notifyDataSetChanged();
        TranslationResultAdapter r2 = this.n;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomAdapter");
    L9:
        r1.getClass();
        r1.d = CollectionsKt.emptyList();
        r1.notifyDataSetChanged();
        X90().clear();
        X90().updateScreenMode(com.larus.avlink.simulInterpret.page.model.b.C0027b.a);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void Y90() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SimultaneousInterpretFragment$hideMaskView$1(this, null), 2, null);
    }

    public final void Z90() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SimultaneousInterpretFragment$showMaskView$1(this, null), 2, null);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        n1.d("SIFragment", "set listener null");
        ValueAnimator r0 = this.j;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        DoraDeviceType r1 = null;
        this.j = null;
        boolean r2 = ha8.d.a;
        com.larus.avlink.simulInterpret.page.view.b r3 = this.r;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ha8.d.g.remove(r3);
        ha8.d.e = null;
        ha8.d.f = null;
        ha8.d.i = null;
        ha8.d.j = null;
        DoraDeviceType r4 = this.k;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r4 = null;
    L9:
        if (r4 != DoraDeviceType.DEVICE_LITE) goto L11;
        ha8.d.h = null;
    L11:
        DoraDeviceType r5 = this.k;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
    L16:
        if (r1 != DoraDeviceType.DEVICE_G) goto L23;
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L24;
        DeviceService r7 = r6.device();
        if (r7 == null) goto L25;
        r7.c(this.q);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L14:
        r1 = r5;
        goto L16
    }

    public final void onResume() {
        super.onResume();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        r0.t0();
    L5:
        DoraDeviceType r1 = this.k;
        Integer r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r1 = null;
    L8:
        DoraDeviceType r3 = DoraDeviceType.DEVICE_LITE;
        boolean r4 = false;
        if (r1 != r3) goto L36;
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L17;
        DeviceService r6 = r5.device();
        if (r6 == null) goto L17;
        if (r6.Z() != true) goto L17;
        boolean r7 = true;
    L18:
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L25;
        DeviceService r9 = r8.device();
        if (r9 == null) goto L25;
        if (r9.h0() != true) goto L25;
        boolean r10 = true;
    L26:
        Pair r11 = TuplesKt.to(Boolean.valueOf(r7), Boolean.valueOf(r10));
        Boolean r12 = Boolean.TRUE;
        if (Intrinsics.areEqual(r11, TuplesKt.to(r12, r12)) == false) goto L29;
        String r13 = getString(2131903356);
    L47:
        Intrinsics.checkNotNull(r13);
        LayoutFragmentBinding r14 = this.l;
        if (r14 == null) goto L52;
        BottomControlView r15 = r14.c;
        if (r15 == null) goto L52;
        r15.setStartSubTextStart(r13);
    L52:
        DoraDeviceType r16 = this.k;
        if (r16 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r16 = null;
    L55:
        if (r16 != r3) goto L66;
        IDoraService r17 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r17 == null) goto L63;
        DeviceService r18 = r17.device();
        if (r18 == null) goto L63;
        if (r18.G() != true) goto L63;
        r4 = true;
    L63:
        if (r4 == false) goto L65;
        Y90();
        goto L66
    L65:
        Z90();
        t19.s r19 = t19.s.a;
        Context r20 = requireContext();
        int r21 = j0.a;
        t19.s.j(r19, r20, j0.d(2131903324), null, false, 28);
    L66:
        DoraDeviceType r22 = this.k;
        if (r22 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r22 = null;
    L70:
        if (r22 != DoraDeviceType.DEVICE_G) goto L82;
        IDoraService r23 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r23 == null) goto L74;
        r2 = Integer.valueOf(r23.d0());
    L74:
        n1.d("SIFragment", "wear count is " + r2 + " in resume");
        if (r2 != null) goto L78;
    L80:
        Y90();
        return;
    L78:
        if (r2.intValue() != 0) goto L80;
        Z90();
        t19.s r24 = t19.s.a;
        Context r25 = requireContext();
        int r26 = j0.a;
        t19.s.j(r24, r25, j0.d(2131902484), null, false, 28);
        return;
    L82:
        return;
    L29:
        Boolean r27 = Boolean.FALSE;
        if (Intrinsics.areEqual(r11, TuplesKt.to(r12, r27)) == false) goto L33;
        r13 = getString(2131903357);
        goto L47
    L33:
        if (Intrinsics.areEqual(r11, TuplesKt.to(r27, r12)) == false) goto L35;
        r13 = getString(2131903358);
        goto L47
    L35:
        Intrinsics.areEqual(r11, TuplesKt.to(r27, r27));
    L46:
        r13 = "";
    L25:
        r10 = false;
    L17:
        r7 = false;
        goto L18
    L36:
        IDoraService r28 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r28 == null) goto L43;
        DeviceService r29 = r28.device();
        if (r29 == null) goto L43;
        if (r29.i0() != true) goto L43;
        boolean r30 = true;
    L44:
        if (r30 == false) goto L46;
        r13 = getString(2131902978);
    L43:
        r30 = false;
        goto L44
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
    }

    public final int W90(SliderLevel r5) {
        LayoutFragmentBinding r0 = this.l;
        if (r0 == null) goto L7;
        ConstraintLayout r1 = r0.b;
        if (r1 == null) goto L7;
        int r2 = r1.getHeight();
    L8:
        if (r2 > 0) goto L10;
        return 0;
    L10:
        int r3 = r2 / 2;
        int r6 = b.b[r5.ordinal()];
        if (r6 == 1) goto L20;
        if (r6 != 2) goto L15;
        return r3;
    L15:
        if (r6 != 3) goto L18;
        return r2 - RangesKt.coerceAtMost(c7.b(142), r3);
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        return RangesKt.coerceAtMost(c7.b(142), r3);
    L7:
        r2 = 0;
        goto L8
    }

    public final void aa0(int r4) {
        LayoutFragmentBinding r0 = this.l;
        if (r0 == null) goto L6;
        int r5 = RangesKt.coerceIn(r4, W90(SliderLevel.TOP), W90(SliderLevel.BOTTOM));
        this.g = r5;
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(r0.b);
        r1.setGuidelineBegin(r0.g.getId(), r5);
        r1.applyTo(r0.b);
        return;
    }

    public final void ba0(boolean r10) {
        n1.d("SIFragment", "updateTranslationConferenceMode -> isConferenceMode: " + r10);
        LayoutFragmentBinding r0 = this.l;
        if (r0 == null) goto L19;
        boolean r2 = true;
        if (r10 == true) goto L7;
    L12:
        r0.m.setVisibility(0);
        ConstraintSet r11 = new ConstraintSet();
        r11.clone(r0.b);
        r11.clear(r0.d.getId(), 3);
        r11.connect(r0.d.getId(), 3, r0.g.getId(), 4);
        r11.setMargin(r0.d.getId(), 3, c7.b(2));
        r11.applyTo(r0.b);
        if (r0.i.getVisibility() == 8) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L21;
        n1.d("SIFragment", "updateTranslationConferenceMode, FaceToFace Translating");
        r0.k.setVisibility(0);
        return;
    L21:
        return;
    L7:
        if (r0.i.getVisibility() != 8) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        n1.d("SIFragment", "updateTranslationConferenceMode, Conference Translating");
        r0.m.setVisibility(8);
        r0.k.setVisibility(8);
        ConstraintSet r13 = new ConstraintSet();
        r13.clone(r0.b);
        r13.clear(r0.d.getId(), 3);
        r13.connect(r0.d.getId(), 3, r0.b.getId(), 3);
        r13.setMargin(r0.d.getId(), 3, 0);
        r13.applyTo(r0.b);
        return;
    L9:
        r12 = false;
        goto L10
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        String r5 = r4.getString("enter_from");
    L6:
        this.e = r5;
        Bundle r6 = getArguments();
        boolean r0 = false;
        if (r6 != null) goto L9;
    L11:
        this.f = r0;
        return;
    L9:
        if (r6.getBoolean("auto_start", false) != true) goto L11;
        r0 = true;
        goto L11
    L5:
        r5 = null;
        goto L6
    }

    public static final void U90(SimultaneousInterpretFragment r5, boolean r6) {
        LayoutFragmentBinding r0 = r5.l;
        if (r0 == null) goto L5;
        ConstraintSet r2 = new ConstraintSet();
        r2.clone(r0.e);
        r2.constrainHeight(r0.b.getId(), 0);
        r2.connect(r0.b.getId(), 4, 0, 4);
        r2.applyTo(r0.e);
    L5:
        DoraDeviceType r1 = r5.k;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r1 = null;
    L9:
        if (r1 != DoraDeviceType.DEVICE_G) goto L21;
        r5.ba0(r6);
        LayoutFragmentBinding r7 = r5.l;
        if (r7 == null) goto L22;
        ConstraintLayout r8 = r7.b;
        if (r8 != null) goto L15;
        return;
    L15:
        if (r8.isLaidOut() == true) goto L17;
    L19:
        r8.addOnLayoutChangeListener(new e0(r5));
        return;
    L17:
        if (r8.isLayoutRequested() == true) goto L19;
        r5.aa0(r5.W90((SliderLevel) SliderLevel.getEntries().get(DoraConfig.a.getInt("key_si_slider_level", 0))));
        return;
    L22:
        return;
    }

    /* JADX WARN: Type inference failed for: r15v1, types: [com.larus.avlink.simulInterpret.page.view.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v3, types: [com.larus.avlink.simulInterpret.page.view.e, java.lang.Object] */
    public final void onViewCreated(View r38, Bundle r39) {
        Intrinsics.checkNotNullParameter(r38, "view");
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r2 = true;
        if (r1 == null) goto L9;
        DeviceService r3 = r1.device();
        if (r3 == null) goto L9;
        if (r3.b0() != true) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        DoraDeviceType r5 = DoraDeviceType.DEVICE_LITE;
    L24:
        if (r5 != DoraDeviceType.UNKNOWN) goto L26;
        Z90();
    L26:
        this.k = r5;
        boolean r6 = DoraConfig.f();
        X90().loadHistoryResult();
        DoraDeviceType r7 = this.k;
        DeviceService r8 = null;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r7 = null;
    L29:
        DoraDeviceType r9 = DoraDeviceType.DEVICE_LITE;
        if (r7 != r9) goto L48;
        LayoutFragmentBinding r10 = this.l;
        if (r10 == null) goto L36;
        ImageView r11 = r10.h;
        if (r11 == null) goto L36;
        r11.setVisibility(0);
    L36:
        boolean r12 = v19.h.a;
        if (v19.h.a(null) == false) goto L43;
        LayoutFragmentBinding r13 = this.l;
        if (r13 == null) goto L53;
        ImageView r14 = r13.h;
        if (r14 == null) goto L53;
        r14.setImageResource(2131238073);
    L53:
        ComponentViewModel.onEach$default(X90(), SimultaneousInterpretFragment$initSubscribers$1.INSTANCE, null, new SimultaneousInterpretFragment$initSubscribers$2(this, null), 2, null);
        ComponentViewModel.onEach$default(X90(), SimultaneousInterpretFragment$initSubscribers$3.INSTANCE, null, new SimultaneousInterpretFragment$initSubscribers$4(this, null), 2, null);
        ComponentViewModel.onEach$default(X90(), SimultaneousInterpretFragment$initSubscribers$5.INSTANCE, null, new SimultaneousInterpretFragment$initSubscribers$6(this, null), 2, null);
        ComponentViewModel.onEach$default(X90(), SimultaneousInterpretFragment$initSubscribers$7.INSTANCE, null, new SimultaneousInterpretFragment$initSubscribers$8(this, null), 2, null);
        ComponentViewModel.onEach$default(X90(), SimultaneousInterpretFragment$initSubscribers$9.INSTANCE, null, new SimultaneousInterpretFragment$initSubscribers$10(this, null), 2, null);
        ComponentViewModel.onEach$default(X90(), SimultaneousInterpretFragment$initSubscribers$11.INSTANCE, null, new SimultaneousInterpretFragment$initSubscribers$12(this, null), 2, null);
        ComponentViewModel.onEach$default(X90(), SimultaneousInterpretFragment$initSubscribers$13.INSTANCE, null, new SimultaneousInterpretFragment$initSubscribers$14(this, null), 2, null);
        boolean r15 = ha8.d.a;
        com.larus.avlink.simulInterpret.page.view.b r16 = this.r;
        Intrinsics.checkNotNullParameter(r16, "listener");
        ha8.d.g.add(r16);
        DoraDeviceType r17 = this.k;
        if (r17 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r17 = null;
    L56:
        if (r17 != r9) goto L58;
        ha8.d.h = this.p;
    L58:
        DoraDeviceType r18 = this.k;
        if (r18 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r18 = null;
    L62:
        if (r18 != DoraDeviceType.DEVICE_G) goto L68;
        IDoraService r19 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r19 == null) goto L68;
        DeviceService r20 = r19.device();
        if (r20 == null) goto L68;
        r20.d(this.q);
    L68:
        ha8.d.e = new com.larus.avlink.simulInterpret.page.view.a(this);
        ha8.d.f = new l(this);
        ha8.d.i = new v(this);
        ha8.d.j = new w(this);
        final DoraDeviceType r21 = this.k;
        if (r21 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r21 = null;
    L71:
        LayoutFragmentBinding r22 = this.l;
        if (r22 == null) goto L76;
        final TitleView r23 = r22.l;
        if (r23 == null) goto L76;
        r23.setOnBackButtonClick(new com.larus.avlink.simulInterpret.page.view.f(this));
        r23.setOnSettingIconClick(new i(r23, this));
        r23.setOnSwitchButtonClick(new j(this, r21));
    L76:
        LayoutFragmentBinding r24 = this.l;
        if (r24 == null) goto L81;
        OnboardingPanelView r25 = r24.i;
        if (r25 == null) goto L81;
        r25.setOnSetShortcutClick(new k(this));
    L81:
        LayoutFragmentBinding r26 = this.l;
        if (r26 == null) goto L86;
        ImageView r27 = r26.h;
        if (r27 == null) goto L86;
        r27.setOnClickListener(new m(this));
    L86:
        LayoutFragmentBinding r28 = this.l;
        if (r28 == null) goto L91;
        SliderTouchView r29 = r28.k;
        if (r29 == null) goto L91;
        r29.setOnDragStart(new n(this));
        r29.setOnDrag(new o(this));
        r29.setOnDragEnd(new p(this));
    L91:
        LayoutFragmentBinding r30 = this.l;
        if (r30 == null) goto L96;
        BottomControlView r31 = r30.c;
        if (r31 == null) goto L96;
        r31.setOnStartTranslationClick(new q(this));
        r31.setOnEndTranslationClick(new r(this));
        r31.setOnMuteClick(new g(this));
        r31.setOnFlipScreenClick(new h(this));
    L96:
        DoraDeviceType r32 = this.k;
        if (r32 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r32 = null;
    L99:
        LayoutFragmentBinding r33 = this.l;
        if (r33 == null) goto L116;
        TitleView r34 = r33.l;
        if (r34 == null) goto L116;
        Intrinsics.checkNotNullParameter(r32, "deviceType");
        if (TitleView.a.a[r32.ordinal()] != 1) goto L115;
        r34.a.b.setVisibility(0);
        r34.a.h.setVisibility(8);
        r34.S5(r6);
        r34.c = r6;
        ConstraintLayout r35 = r34.a.b;
        if (r35.isLaidOut() == true) goto L108;
    L114:
        r35.addOnLayoutChangeListener(new com.larus.avlink.simulInterpret.page.ui.x(r34, r6));
        goto L116
    L108:
        if (r35.isLayoutRequested() == true) goto L114;
        ConstraintLayout.LayoutParams r36 = r34.a.e.getLayoutParams();
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r37 = r36;
        if (r6 == false) goto L112;
        r37.setMarginStart(r34.a.d.getLeft());
        ((ViewGroup.MarginLayoutParams) r37).width = r34.a.d.getWidth();
    L113:
        r34.a.e.setLayoutParams(r37);
        goto L116
    L112:
        r37.setMarginStart(r34.a.c.getLeft());
        ((ViewGroup.MarginLayoutParams) r37).width = r34.a.c.getWidth();
        goto L113
    L115:
        r34.a.b.setVisibility(8);
        r34.a.h.setVisibility(0);
    L116:
        DoraDeviceType r40 = this.k;
        if (r40 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r40 = null;
    L120:
        if (b.a[r40.ordinal()] != 1) goto L126;
        LayoutFragmentBinding r41 = this.l;
        if (r41 == null) goto L131;
        OnboardingPanelView r42 = r41.i;
        if (r42 == null) goto L131;
        r42.R5(r6);
    L131:
        DoraDeviceType r43 = this.k;
        if (r43 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r43 = null;
    L134:
        LayoutFragmentBinding r44 = this.l;
        if (r44 == null) goto L139;
        TopTranslatePanelView r45 = r44.m;
        if (r45 == null) goto L139;
        r45.T5(r43, r6);
    L139:
        TranslationResultAdapter r46 = new TranslationResultAdapter(requireContext(), AREA.TOP, r43);
        this.m = r46;
        LayoutFragmentBinding r47 = this.l;
        if (r47 == null) goto L144;
        TopTranslatePanelView r48 = r47.m;
        if (r48 == null) goto L144;
        Intrinsics.checkNotNullParameter(r46, "topAdapter");
        r46.registerAdapterDataObserver(r48.h);
        RecyclerView r49 = r48.a.k;
        r49.setLayoutManager(new LinearLayoutManager(r49.getContext()));
        r49.setAdapter(r46);
        r49.addOnScrollListener(r48.i);
    L144:
        LayoutFragmentBinding r50 = this.l;
        if (r50 == null) goto L149;
        final TopTranslatePanelView r51 = r50.m;
        if (r51 == null) goto L149;
        FragmentManager r110 = getParentFragmentManager();
        Function0<com.larus.avlink.simulInterpret.page.model.a> r111 = new com.larus.avlink.simulInterpret.page.view.c(this);
        Function0<com.larus.avlink.simulInterpret.page.model.a> r112 = new com.larus.avlink.simulInterpret.page.view.d(this);
        final ?? r113 = new com.larus.avlink.simulInterpret.page.view.e(this);
        Intrinsics.checkNotNullParameter(r110, "fragmentManager");
        Intrinsics.checkNotNullParameter(r111, "getCurrentLanguage");
        Intrinsics.checkNotNullParameter(r112, "getOtherSideLanguage");
        Intrinsics.checkNotNullParameter(r113, "selectedListener");
        r51.b = r110;
        r51.c = r111;
        r51.d = r112;
        r51.a.g.setOnClickListener(new com.larus.avlink.simulInterpret.page.ui.y(r51, r113));
    L149:
        DoraDeviceType r52 = this.k;
        if (r52 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r52 = null;
    L152:
        LayoutFragmentBinding r114 = this.l;
        if (r114 == null) goto L157;
        BottomTranslatePanelView r115 = r114.d;
        if (r115 == null) goto L157;
        r115.setIcon(r52);
    L157:
        TranslationResultAdapter r116 = new TranslationResultAdapter(requireContext(), AREA.BOTTOM, r52);
        this.n = r116;
        LayoutFragmentBinding r53 = this.l;
        if (r53 == null) goto L162;
        BottomTranslatePanelView r54 = r53.d;
        if (r54 == null) goto L162;
        Intrinsics.checkNotNullParameter(r116, "bottomAdapter");
        r116.registerAdapterDataObserver(r54.h);
        RecyclerView r117 = r54.a.j;
        r117.setLayoutManager(new LinearLayoutManager(r117.getContext()));
        r117.setAdapter(r116);
        r117.addOnScrollListener(r54.i);
    L162:
        LayoutFragmentBinding r55 = this.l;
        if (r55 == null) goto L167;
        final BottomTranslatePanelView r56 = r55.d;
        if (r56 == null) goto L167;
        FragmentManager r118 = getParentFragmentManager();
        Function0<com.larus.avlink.simulInterpret.page.model.a> r119 = new z(this);
        Function0<com.larus.avlink.simulInterpret.page.model.a> r120 = new a0(this);
        final ?? r121 = new b0(this);
        Intrinsics.checkNotNullParameter(r118, "fragmentManager");
        Intrinsics.checkNotNullParameter(r119, "getCurrentLanguage");
        Intrinsics.checkNotNullParameter(r120, "getOtherSideLanguage");
        Intrinsics.checkNotNullParameter(r121, "selectedListener");
        r56.b = r118;
        r56.c = r119;
        r56.d = r120;
        r56.a.f.setOnClickListener(new com.larus.avlink.simulInterpret.page.ui.f(r56, r121));
    L167:
        DoraDeviceType r57 = this.k;
        if (r57 != null) goto L170;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r57 = null;
    L170:
        LayoutFragmentBinding r58 = this.l;
        if (r58 == null) goto L182;
        BottomControlView r59 = r58.c;
        if (r59 == null) goto L182;
        Intrinsics.checkNotNullParameter(r57, "deviceType");
        ImageView r60 = r59.a.c;
        if (r57.isShowMuteIcon() == false) goto L177;
        int r61 = 0;
    L178:
        r60.setVisibility(r61);
        if (r57 != r9) goto L181;
        r59.a.e.setVisibility(0);
        goto L182
    L181:
        r59.a.e.setVisibility(8);
        goto L182
    L177:
        r61 = 8;
    L182:
        IDoraService r62 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r62 == null) goto L185;
        r8 = r62.device();
    L185:
        if (r8 != null) goto L187;
    L189:
        boolean r63 = false;
    L190:
        if (r8 != null) goto L192;
    L194:
        boolean r64 = false;
    L195:
        LayoutFragmentBinding r65 = this.l;
        if (r65 == null) goto L205;
        BottomControlView r66 = r65.c;
        if (r66 == null) goto L205;
        if (r63 == true) goto L203;
        if (r64 == true) goto L203;
        r2 = false;
    L203:
        r66.setSubTextEndVisible(r2);
    L205:
        if (o0.d(this.e) == false) goto L208;
        n1.d("SIFragment", "enter from " + this.e);
    L208:
        if (this.f == true) goto L210;
        return;
    L210:
        if (ha8.d.a == true) goto L214;
        this.f = false;
        int r67 = ha8.b.a;
        ha8.b.b(requireContext(), "SIFragment", new x(this), new y(this));
        return;
    L214:
        return;
    L192:
        if (r8.n0("conversation") != true) goto L194;
        r64 = true;
        goto L195
    L187:
        if (r8.b0() != true) goto L189;
        r63 = true;
        goto L190
    L126:
        LayoutFragmentBinding r68 = this.l;
        if (r68 == null) goto L131;
        OnboardingPanelView r69 = r68.i;
        if (r69 == null) goto L131;
        r69.setShortcutText(r40);
        goto L131
    L43:
        LayoutFragmentBinding r70 = this.l;
        if (r70 == null) goto L53;
        ImageView r71 = r70.h;
        if (r71 == null) goto L53;
        r71.setImageResource(2131238072);
        goto L53
    L48:
        LayoutFragmentBinding r72 = this.l;
        if (r72 == null) goto L53;
        ImageView r73 = r72.h;
        if (r73 == null) goto L53;
        r73.setVisibility(8);
        goto L53
    L12:
        IDoraService r74 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r74 == null) goto L19;
        DeviceService r75 = r74.device();
        if (r75 == null) goto L19;
        if (r75.M() != true) goto L19;
        boolean r76 = true;
    L20:
        if (r76 == false) goto L22;
        r5 = DoraDeviceType.DEVICE_G;
        goto L24
    L22:
        r5 = DoraDeviceType.UNKNOWN;
    L19:
        r76 = false;
    L9:
        r4 = false;
        goto L10
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        ConstraintLayout r0 = r18.inflate(2131563329, r19, false);
        int r1 = 2131362517;
        ConstraintLayout r5 = ViewBindings.findChildViewById(r0, 2131362517);
        if (r5 == null) goto L29;
        r1 = 2131364390;
        BottomControlView r6 = (BottomControlView) ViewBindings.findChildViewById(r0, 2131364390);
        if (r6 == null) goto L29;
        r1 = 2131364547;
        BottomTranslatePanelView r7 = (BottomTranslatePanelView) ViewBindings.findChildViewById(r0, 2131364547);
        if (r7 == null) goto L29;
        r1 = 2131367812;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r0, 2131367812);
        if (r8 == null) goto L29;
        r1 = 2131367850;
        NestedScrollView r9 = ViewBindings.findChildViewById(r0, 2131367850);
        if (r9 == null) goto L29;
        r1 = 2131374166;
        Guideline r10 = ViewBindings.findChildViewById(r0, 2131374166);
        if (r10 == null) goto L29;
        r1 = 2131374800;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r0, 2131374800);
        if (r11 == null) goto L29;
        r1 = 2131381461;
        OnboardingPanelView r12 = (OnboardingPanelView) ViewBindings.findChildViewById(r0, 2131381461);
        if (r12 == null) goto L29;
        r1 = 2131381804;
        View r13 = ViewBindings.findChildViewById(r0, 2131381804);
        if (r13 == null) goto L29;
        r1 = 2131386893;
        SliderTouchView r14 = (SliderTouchView) ViewBindings.findChildViewById(r0, 2131386893);
        if (r14 == null) goto L29;
        r1 = 2131388807;
        TitleView r15 = (TitleView) ViewBindings.findChildViewById(r0, 2131388807);
        if (r15 == null) goto L29;
        r1 = 2131389239;
        TopTranslatePanelView r16 = (TopTranslatePanelView) ViewBindings.findChildViewById(r0, 2131389239);
        if (r16 == null) goto L29;
        ConstraintLayout r2 = r0;
        this.l = new LayoutFragmentBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return r2;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
