package com.larus.dora.obric.device_management.setting.g.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.impl.databinding.LarusDoraPageObricGGestureSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsViewModel;
import com.larus.dora.impl.device.settings.gesture.LastSwitchSide;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.j0;
import com.larus.dora.impl.util.u;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 l2\u00020\u0001:\u0002klB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020/H\u0016J\n\u00100\u001a\u0004\u0018\u00010 H\u0016J\b\u00101\u001a\u00020(H\u0002J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0002J\u0010\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u000fH\u0002J\u0010\u00107\u001a\u00020(2\u0006\u00106\u001a\u00020\u000fH\u0002J\u0010\u00108\u001a\u00020(2\u0006\u00106\u001a\u00020\u000fH\u0002J:\u00109\u001a\u00020(2\u0006\u00106\u001a\u00020\u000f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020@0;2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\u0010\u0010B\u001a\u00020(2\u0006\u00106\u001a\u00020\u000fH\u0002J(\u0010C\u001a\u00020(2\u0006\u0010#\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010/2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020@0;H\u0002J\n\u0010G\u001a\u0004\u0018\u00010/H\u0002J\u0010\u0010H\u001a\u00020 2\u0006\u0010E\u001a\u00020/H\u0002J\u0018\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020\u0011H\u0002J\u0014\u0010L\u001a\u00020(*\u00020M2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020<H\u0002J\u0010\u0010R\u001a\u00020(2\u0006\u00106\u001a\u00020\u000fH\u0002J\u0018\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u000fH\u0002J\u0018\u0010V\u001a\u00020(2\u0006\u0010W\u001a\u00020/2\u0006\u0010U\u001a\u00020\u000fH\u0002J\b\u0010X\u001a\u00020\u0016H\u0002J\u0010\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020/H\u0002J\u001a\u0010[\u001a\u00020/2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010Z\u001a\u00020/H\u0002J\b\u0010^\u001a\u00020(H\u0002J\b\u0010_\u001a\u00020(H\u0002J\u0010\u0010`\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u000fH\u0002J\u0010\u0010a\u001a\u00020/2\u0006\u00106\u001a\u00020\u000fH\u0002J\u0018\u0010b\u001a\u00020\u00112\u0006\u0010c\u001a\u00020\u00112\u0006\u0010d\u001a\u00020\u0011H\u0002J\u0010\u0010e\u001a\u00020 2\u0006\u0010f\u001a\u00020\u0011H\u0002J\b\u0010g\u001a\u00020\u0011H\u0002J\b\u0010h\u001a\u00020\u0011H\u0002J\u0014\u0010i\u001a\u00020(*\u00020M2\u0006\u0010K\u001a\u00020\u0011H\u0002J\f\u0010j\u001a\u00020\u0011*\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001d¨\u0006m"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/gesture/DoraObricGGestureSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageObricGGestureSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "isDarkMode", "", "lastSwitchSide", "Lcom/larus/dora/impl/device/settings/gesture/LastSwitchSide;", "targetProductId", "", "getTargetProductId", "()Ljava/lang/Integer;", "targetProductId$delegate", "gestureResourceDeviceType", "Lcom/larus/dora/impl/resource/DoraResourceDeviceType;", "getGestureResourceDeviceType", "()Lcom/larus/dora/impl/resource/DoraResourceDeviceType;", "gestureResourceDeviceType$delegate", "tabPolicy", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureTabPolicy;", "getTabPolicy", "()Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureTabPolicy;", "tabPolicy$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "onDoraConnectStateChanged", "isConnected", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "setupTab", "setupVideoCover", "observeGestureState", "switchSideUI", "side", "setSelectedTab", "clickToSwitchSide", "updateItems", "mediaList", "", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "callingList", "aiList", "buildDynamicOrPlaceholderRows", "Lcom/larus/dora/obric/device_management/setting/g/gesture/DoraObricGGestureSettingsFragment$GestureRow;", "settingsList", "renderDefaultItems", "addSection", "Landroid/widget/LinearLayout;", "title", "rows", "buttonSectionTitle", "buildSectionTitle", "buildGestureItem", "row", "position", "bindEndDetail", "Lcom/obric/oui/lisitem/OCardListItem;", "text", "", "gotoGestureOptionsPage", "settings", "updateFirstFrame", "setupVideoPlayer", "lastSide", "curSide", "setupGestureVideo", "videoPath", "resolveGestureResourceDeviceType", "logG2GestureVideoCandidates", "resourceName", "describeResourceFile", "directory", "Ljava/io/File;", "setupBackPressedCallback", "finishWithResult", "tabPositionForSide", "titleForSide", "resolveCardPosition", "index", "size", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolveSectionTitleColor", "applyCardStyle", "dp", "GestureRow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGGestureSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int m = 0;
    public LarusDoraPageObricGGestureSettingsBinding f;
    public final Lazy g;
    public final boolean h;
    public LastSwitchSide i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;

    public static final class a {
    }

    public interface b {

        public static final class a implements b {
            public final DoraGGestureSettings a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Dynamic(settings=" + this.a + ')';
            }

            public a(DoraGGestureSettings r2) {
                Intrinsics.checkNotNullParameter(r2, "settings");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.gesture.DoraObricGGestureSettingsFragment$b$b, reason: collision with other inner class name */
        public static final class C0107b implements b {
            public final String a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0107b) == true) goto L8;
                return false;
            L8:
                C0107b r6 = (C0107b) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Fixed(title=" + this.a + ", desc=" + this.b + ')';
            }

            public C0107b(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "title");
                Intrinsics.checkNotNullParameter(r3, "desc");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class c implements b {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Placeholder(title=" + this.a + ')';
            }

            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "title");
                this.a = r2;
            }
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LastSwitchSide.values().length];
            r0[LastSwitchSide.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LastSwitchSide.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LastSwitchSide.BUTTON.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final String k() {
        return "gesture_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageObricGGestureSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final DoraGGestureSettingsViewModel ba0() {
        return (DoraGGestureSettingsViewModel) this.g.getValue();
    }

    public final void onDestroyView() {
        LarusDoraPageObricGGestureSettingsBinding r0 = this.f;
        if (r0 == null) goto L7;
        DoraMovieView r1 = r0.h;
        if (r1 == null) goto L7;
        r1.f();
    L7:
        LarusDoraPageObricGGestureSettingsBinding r2 = this.f;
        if (r2 == null) goto L12;
        DoraMovieView r3 = r2.h;
        if (r3 == null) goto L12;
        r3.setFirstFrameRenderedListener(null);
    L12:
        this.f = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricGGestureSettingsFragment() {
        final Function0<Fragment> r0 = new DoraObricGGestureSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGGestureSettingsViewModel.class), new DoraObricGGestureSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricGGestureSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        boolean r1 = v19.h.a;
        this.h = v19.h.a(null);
        this.i = LastSwitchSide.BUTTON;
        this.j = LazyKt.lazy(new n(this));
        this.k = LazyKt.lazy(new o(this));
        this.l = LazyKt.lazy(new p(this));
    }

    public final void onResume() {
        super.onResume();
        ba0().load(this.i);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r3) {
        super.V90(r3);
        g49.d.d("DoraObricGGestureSettingsFragment", "onDoraConnectStateChanged: " + r3);
        if (r3 == false) goto L6;
        ba0().load(this.i);
        return;
    }

    public final List<b> Y90(List<DoraGGestureSettings> r4) {
        if ((!r4.isEmpty()) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L12;
        List<DoraGGestureSettings> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L14;
        r0.add(new b.a((DoraGGestureSettings) r6.next()));
        goto L9
    L14:
        return r0;
    L12:
        return CollectionsKt.listOf(new b.c(getString(2131903041)));
    }

    public final int aa0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void da0(LastSwitchSide r6) {
        this.i = r6;
        LarusDoraPageObricGGestureSettingsBinding r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L16;
        OTabSegmentedLayout r2 = r0.e;
        if (r2 == null) goto L16;
        LastSwitchSide r3 = ((com.larus.dora.impl.device.settings.gesture.s) this.l.getValue()).b(r6);
        com.larus.dora.impl.device.settings.gesture.s r4 = (com.larus.dora.impl.device.settings.gesture.s) this.l.getValue();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "side");
        int r5 = RangesKt.coerceAtLeast(r4.a.indexOf(r4.b(r3)), 0);
        if (r2.getCurrentTab() == r5) goto L16;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        r2.setCurrentTab(r5);     // Catch: Throwable -> L11
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L16;
        g49.d.c("DoraObricGGestureSettingsFragment", "setSelectedTab failed: side=" + r6, r9);
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        LarusDoraPageObricGGestureSettingsBinding r11 = this.f;
        if (r11 != null) goto L19;
        return;
    L19:
        if (r6 != LastSwitchSide.BUTTON) goto L21;
        boolean r12 = true;
    L22:
        LinearLayout r13 = r11.c;
        if ((!r12) == false) goto L25;
        int r14 = 0;
    L26:
        r13.setVisibility(r14);
        LinearLayout r15 = r11.b;
        if (r12 == true) goto L30;
        r1 = 8;
    L30:
        r15.setVisibility(r1);
        return;
    L25:
        r14 = 8;
        goto L26
    L21:
        r12 = false;
        goto L22
    }

    public final void ea0(LastSwitchSide r7) {
        int r8 = c.a[r7.ordinal()];
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L15;
        if (r8 != 3) goto L13;
        if (this.h == false) goto L11;
        String r9 = "larus_dora_g_first_frame_m_dark";
    L22:
        String r3 = r9;
        LarusDoraPageObricGGestureSettingsBinding r10 = this.f;
        if (r10 == null) goto L32;
        ImageView r11 = r10.g;
        if (r11 == null) goto L33;
        r11.setVisibility(0);
        if (((DoraResourceDeviceType) this.k.getValue()) != DoraResourceDeviceType.G1) goto L29;
        u r0 = u.a;
        Context r1 = requireContext();
        r0.getClass();
        Drawable r2 = u.c(r1, r3);
    L30:
        r11.setImageDrawable(r2);
        return;
    L29:
        r2 = j0.f(j0.a, requireContext(), DoraResourceDeviceType.G2, r3, null, 24);
        goto L30
    L33:
        return;
    L32:
        return;
    L11:
        r9 = "larus_dora_g_first_frame_m";
        goto L22
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        if (this.h == false) goto L17;
        r9 = "larus_dora_g_first_frame_l_dark";
        goto L22
    L17:
        r9 = "larus_dora_g_first_frame_l";
        goto L22
    L19:
        if (this.h == false) goto L21;
        r9 = "larus_dora_g_first_frame_r_dark";
        goto L22
    L21:
        r9 = "larus_dora_g_first_frame_r";
        goto L22
    }

    public static String Z90(PolarisFileWrapper r2, String r3) {
        if (r2 != null) goto L5;
        return "disabled";
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2, r3);
        return "path=" + r0.getAbsolutePath() + ", exists=" + r0.exists() + ", isFile=" + r0.isFile() + ", length=" + r0.length();
    }

    public final void X90(OCardListItem r4, CharSequence r5) {
        r4.setDefaultCustomEndView(3);
        r4.k(r5, aa0(BaiduNaviStatus.WRONG_AK_PARAM));
        OTextView r0 = r4.getEndDetail();
        boolean r1 = true;
        if (r0 == null) goto L6;
        r0.setMaxLines(1);
        r0.setGravity(8388613);
    L6:
        if (((String) r5).length() > 0) goto L9;
        r1 = false;
    L9:
        r4.m(r1);
    }

    public final void ca0(final String r3, LastSwitchSide r4) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        g49.d.d("DoraObricGGestureSettingsFragment", "setupVideoPlayer: empty video path, fallback first frame");
        ea0(r4);
        return;
    L9:
        final LarusDoraPageObricGGestureSettingsBinding r5 = this.f;
        if (r5 == null) goto L13;
        r5.g.setVisibility(8);
        r5.h.post(new r(r3, r5));
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        Bundle r15 = getArguments();
        if (r15 != null) goto L5;
    L7:
        boolean r16 = false;
    L8:
        if (r16 == true) goto L18;
        Bundle r17 = getArguments();
        if (r17 != null) goto L12;
    L14:
        boolean r18 = false;
    L15:
        if (r18 == true) goto L18;
        DoraGGestureSettingsRepository r110 = DoraGGestureSettingsRepository.a;
        LastSwitchSide r111 = DoraGGestureSettingsRepository.f();
    L19:
        LastSwitchSide r1 = ((com.larus.dora.impl.device.settings.gesture.s) this.l.getValue()).b(r111);
        this.i = r1;
        if (r1 == r111) goto L22;
        DoraGGestureSettingsRepository r112 = DoraGGestureSettingsRepository.a;
        DoraGGestureSettingsRepository.k(r1);
    L22:
        LarusDoraPageObricGGestureSettingsBinding r113 = this.f;
        String r2 = null;
        if (r113 == null) goto L27;
        OFloatingTitleBar r114 = r113.f;
        if (r114 == null) goto L27;
        com.larus.dora.obric.utils.c.a(r114);
        r114.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r114.setCenterTitle(getString(2131902423));
        r114.R(false);
        OFloatingTitleBar.k(r114, null, 6).setOnClickListener(new q(this));
    L27:
        LarusDoraPageObricGGestureSettingsBinding r115 = this.f;
        if (r115 == null) goto L60;
        OTabSegmentedLayout r116 = r115.e;
        if (r116 == null) goto L60;
        List<LastSwitchSide> r3 = ((com.larus.dora.impl.device.settings.gesture.s) this.l.getValue()).a;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L33:
        if (r5.hasNext() == false) goto L45;
        int r6 = c.a[((LastSwitchSide) r5.next()).ordinal()];
        if (r6 == 1) goto L43;
        if (r6 != 2) goto L38;
        String r7 = getString(2131903047);
    L44:
        r4.add(r7);
        goto L33
    L38:
        if (r6 != 3) goto L41;
        r7 = getString(2131902357);
        goto L44
    L41:
        throw new NoWhenBranchMatchedException();
    L43:
        r7 = getString(2131903027);
        goto L44
    L45:
        String[] r8 = (String[]) r4.toArray(new String[0]);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L48
        r116.e(r8, null);     // Catch: Throwable -> L48
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L48
    L50:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L53;
        g49.d.c("DoraObricGGestureSettingsFragment", "setupTab failed", r11);
    L53:
        Iterator<T> r12 = r3.iterator();
        int r20 = 0;
    L55:
        if (r12.hasNext() == false) goto L60;
        Object r21 = r12.next();
        int r22 = r20 + 1;
        if (r20 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        final LastSwitchSide r23 = (LastSwitchSide) r21;
        e1.d((View) CollectionsKt.getOrNull(r116.getTabList(), r20), new l(r23, this));
        r20 = r22;
    L48:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L60:
        ea0(this.i);
        LarusDoraPageObricGGestureSettingsBinding r117 = this.f;
        if (r117 == null) goto L65;
        DoraMovieView r118 = r117.h;
        if (r118 == null) goto L65;
        r118.setFirstFrameRenderedListener(new m(this));
    L65:
        Lifecycle.State r119 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGGestureSettingsFragment$observeGestureState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r119, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGGestureSettingsFragment$observeGestureState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r119, null, this), 3, null);
        FragmentActivity r120 = getActivity();
        if (r120 == null) goto L70;
        OnBackPressedDispatcher r121 = r120.getOnBackPressedDispatcher();
        if (r121 == null) goto L70;
        r121.addCallback(getViewLifecycleOwner(), new DoraObricGGestureSettingsFragment$setupBackPressedCallback$1(this));
    L70:
        da0(this.i);
        LastSwitchSide r122 = this.i;
        LarusDoraPageObricGGestureSettingsBinding r25 = this.f;
        if (r25 != null) goto L73;
        return;
    L73:
        if (r122 != LastSwitchSide.BUTTON) goto L79;
        r25.b.removeAllViews();
        LinearLayout r123 = r25.b;
        if (((DoraResourceDeviceType) this.k.getValue()) == DoraResourceDeviceType.G2) goto L78;
        r2 = getString(2131902358);
    L78:
        W90(r123, r2, CollectionsKt.listOf(new b[]{new b.C0107b(getString(2131903009), getString(2131902366)), new b.c(getString(2131903041))}));
        return;
    L79:
        r25.c.removeAllViews();
        W90(r25.c, getString(2131903008), CollectionsKt.listOf(new b[]{new b.C0107b(getString(2131903009), getString(2131903011)), new b.c(getString(2131903041))}));
        return;
    L12:
        if (r17.containsKey("source") != true) goto L14;
        r18 = true;
    L18:
        r111 = LastSwitchSide.LEFT;
        goto L19
    L5:
        if (r15.containsKey("is_first") != true) goto L7;
        r16 = true;
        goto L8
    }

    public final void W90(LinearLayout r22, String r23, List<? extends b> r24) {
        int r5 = 16;
        if (r22.getChildCount() <= 0) goto L5;
        View r3 = new View(requireContext());
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, aa0(16)));
        r22.addView(r3);
    L5:
        int r6 = 6;
        AttributeSet r7 = null;
        if (r23 == null) goto L11;
        OSectionTitleBar r10 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r11 = (LinearLayout) r10.findViewById(2131367728);
        if (r11 == null) goto L10;
        r11.setPadding(aa0(20), aa0(8), aa0(8), aa0(8));
    L10:
        r10.setTitleText(r23);
        r10.setTitleTextSize(12.0f);
        r10.setTitleTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r10.setLayoutParams(new LinearLayout.LayoutParams(-1, aa0(32)));
        r22.addView(r10);
    L11:
        Iterator<T> r2 = r24.iterator();
        int r4 = 0;
    L13:
        if (r2.hasNext() == false) goto L65;
        Object r12 = r2.next();
        int r13 = r4 + 1;
        if (r4 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        b r14 = (b) r12;
        int r15 = r24.size();
        if (r15 > 1) goto L20;
        int r8 = 0;
    L26:
        OCardListItem r16 = new OCardListItem(requireContext(), r7, r6, 0);
        r16.setCardType(0);
        OCardListItem.h(r16, r8);
        r16.setShowCardBg(true);
        ViewGroup.LayoutParams r17 = r16.getCardContainer().getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
    L30:
        if (r18 == null) goto L32;
        r18.setMarginStart(0);
        r18.setMarginEnd(0);
        r18.leftMargin = 0;
        r18.rightMargin = 0;
        r16.getCardContainer().setLayoutParams(r18);
    L32:
        r16.getCardContainer().setPadding(aa0(8), aa0(8), aa0(8), aa0(8));
        r16.getTitleContainer().setGravity(r5);
        OTextView r9 = r16.getTitleView();
        r9.setGravity(8388611);
        r9.setMaxLines(1);
        r9.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r16.o(false);
        Iterator r20 = CollectionsKt.listOf(new Drawable[]{r16.getCardContainer().getBackground(), r16.getContentContainer().getBackground()}).iterator();
    L34:
        if (r20.hasNext() == false) goto L53;
        Drawable r21 = (Drawable) r20.next();
        if ((r21 instanceof GradientDrawable) == false) goto L38;
        GradientDrawable r25 = (GradientDrawable) r21;
    L39:
        if (r25 == null) goto L34;
        float r110 = aa0(20);
        if (r8 != 0) goto L44;
        float[] r26 = {r110, r110, r110, r110, r110, r110, r110, r110};
    L50:
        if (r26 == null) goto L34;
        r25.setCornerRadii(r26);
        goto L34
    L44:
        if (r8 == 1) goto L48;
        if (r8 == 3) goto L47;
        r26 = null;
        goto L50
    L47:
        r26 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r110, r110, r110, r110};
        goto L50
    L48:
        r26 = new float[]{r110, r110, r110, r110, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L50
    L38:
        r25 = null;
        goto L39
    L53:
        r16.p(false);
        if ((r14 instanceof b.C0107b) == false) goto L57;
        b.C0107b r111 = (b.C0107b) r14;
        r16.setTitle(r111.a);
        r16.s(true);
        r16.setSubTitle("");
        r16.q(false);
        X90(r16, r111.b);
        r16.r(false);
    L62:
        r22.addView(r16);
        r4 = r13;
        r5 = 16;
        r6 = 6;
        r7 = null;
        goto L13
    L57:
        if ((r14 instanceof b.c) == false) goto L60;
        r16.setTitle(((b.c) r14).a);
        r16.s(true);
        r16.setSubTitle("");
        r16.q(false);
        r16.m(false);
        r16.setDefaultTailIcon(0);
        r16.r(true);
        goto L62
    L60:
        if ((r14 instanceof b.a) == false) goto L64;
        final DoraGGestureSettings r27 = ((b.a) r14).a;
        r16.setTitle(r27.d());
        r16.s(true);
        r16.setSubTitle("");
        r16.q(false);
        X90(r16, r27.c());
        r16.setDefaultTailIcon(0);
        r16.r(true);
        r16.setTag(r27);
        r16.setOnContentClickListener(new k(this, r27));
        goto L62
    L64:
        throw new NoWhenBranchMatchedException();
    L29:
        r18 = null;
        goto L30
    L20:
        if (r4 != 0) goto L23;
        r8 = 1;
        goto L26
    L23:
        if (r4 != (r15 - 1)) goto L25;
        r8 = 3;
        goto L26
    L25:
        r8 = 2;
        goto L26
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562282, r11, false);
        int r14 = 2131369831;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131369831);
        if (r2 == null) goto L25;
        r14 = 2131369832;
        if (((LinearLayout) ViewBindings.findChildViewById(r13, 2131369832)) == null) goto L25;
        r14 = 2131369833;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131369833);
        if (r3 == null) goto L25;
        r14 = 2131369843;
        View r4 = ViewBindings.findChildViewById(r13, 2131369843);
        if (r4 == null) goto L25;
        r14 = 2131369844;
        if (ViewBindings.findChildViewById(r13, 2131369844) == null) goto L25;
        r14 = 2131369845;
        if (((ScrollView) ViewBindings.findChildViewById(r13, 2131369845)) == null) goto L25;
        r14 = 2131369846;
        OTabSegmentedLayout r5 = ViewBindings.findChildViewById(r13, 2131369846);
        if (r5 == null) goto L25;
        r14 = 2131369847;
        OFloatingTitleBar r6 = ViewBindings.findChildViewById(r13, 2131369847);
        if (r6 == null) goto L25;
        r14 = 2131369848;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r13, 2131369848);
        if (r7 == null) goto L25;
        r14 = 2131369849;
        DoraMovieView r8 = (DoraMovieView) ViewBindings.findChildViewById(r13, 2131369849);
        if (r8 == null) goto L25;
        ConstraintLayout r15 = r13;
        this.f = new LarusDoraPageObricGGestureSettingsBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
