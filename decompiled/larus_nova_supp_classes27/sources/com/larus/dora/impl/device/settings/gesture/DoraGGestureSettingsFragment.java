package com.larus.dora.impl.device.settings.gesture;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.UIUtils;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextDescView;
import com.larus.dora.impl.databinding.LarusDoraPageGestureDoraGSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.util.DoraVideoType;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010(\u001a\u00020#H\u0016J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000fH\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010,\u001a\u00020\u00112\b\b\u0001\u0010-\u001a\u00020\u0011H\u0002J\u000f\u0010.\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020#H\u0002J\u0017\u00101\u001a\u0004\u0018\u00010#2\u0006\u00102\u001a\u00020\rH\u0002¢\u0006\u0002\u00103J\u000f\u00104\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010/J\u000f\u00105\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010/J\u0010\u00106\u001a\u00020#2\u0006\u0010$\u001a\u000207H\u0002J\u000f\u00108\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010/J\u0017\u00109\u001a\u0004\u0018\u00010#2\u0006\u0010:\u001a\u00020\rH\u0002¢\u0006\u0002\u00103J\u0017\u0010;\u001a\u0004\u0018\u00010#2\u0006\u0010<\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020@H\u0002JA\u0010A\u001a\u0004\u0018\u00010#2\u0006\u0010B\u001a\u00020\r2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020@0D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020@0DH\u0002¢\u0006\u0002\u0010GJ%\u0010H\u001a\u0004\u0018\u00010#2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020@0D2\u0006\u0010J\u001a\u00020KH\u0002¢\u0006\u0002\u0010LJ \u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u000fH\u0002J\u0018\u0010Q\u001a\u00020#2\u0006\u00102\u001a\u00020\r2\u0006\u0010R\u001a\u00020\rH\u0002J\n\u0010S\u001a\u0004\u0018\u00010TH\u0002J\b\u0010U\u001a\u00020#H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018¨\u0006W"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageGestureDoraGSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "lastSwitchSide", "Lcom/larus/dora/impl/device/settings/gesture/LastSwitchSide;", "isDarkMode", "", "isFirst", "", "Ljava/lang/Integer;", "source", "", "tabPolicy", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureTabPolicy;", "getTabPolicy", "()Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureTabPolicy;", "tabPolicy$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroy", "getCurrentPageName", "getPageMaskView", "onResume", "onDoraConnectStateChanged", "isConnected", "updateFirstFrame", "getColor", "colorRes", "setListener", "()Lkotlin/Unit;", "showOtaTooLowToast", "switchSideUI", "lastSide", "(Lcom/larus/dora/impl/device/settings/gesture/LastSwitchSide;)Lkotlin/Unit;", "resetSwitchDividerLayout", "applyTabPolicy", "adaptDescView", "Lcom/larus/bmhome/view/item/ItemTextDescView;", "adaptGroupTitle", "clickToSwitchSide", "switchSide", "switchMiddleButtonItemVisible", "isMiddleButton", "(Z)Lkotlin/Unit;", "gotoGestureOptionsPage", "settings", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "updateItems", "side", "mediaList", "", "callingList", "aiList", "(Lcom/larus/dora/impl/device/settings/gesture/LastSwitchSide;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lkotlin/Unit;", "updateItemsByStatus", "list", "status", "", "(Ljava/util/List;B)Lkotlin/Unit;", "resolveItemBackgroundRes", "index", "listSize", "hasFixedLeadingItem", "setupVideoPlayer", "curSide", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupBackPressedCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGGestureSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDoraPageGestureDoraGSettingsBinding f;
    public final Lazy g;
    public LastSwitchSide h;
    public final boolean i;
    public Integer j;
    public final Lazy k;

    public static final class a {
    }

    public /* synthetic */ class b {
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
        LarusDoraPageGestureDoraGSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k;
    }

    public final DoraGGestureSettingsViewModel Z90() {
        return (DoraGGestureSettingsViewModel) this.g.getValue();
    }

    public final s aa0() {
        return (s) this.k.getValue();
    }

    public final void ba0() {
        LarusDoraPageGestureDoraGSettingsBinding r0 = this.f;
        if (r0 == null) goto L6;
        r0.l.setVisibility(8);
        r0.n.setVisibility(8);
        r0.m.setVisibility(8);
        r0.r.setTextColor(Y90(2131103143));
        r0.t.setTextColor(Y90(2131103143));
        r0.s.setTextColor(Y90(2131103143));
        Unit r1 = Unit.INSTANCE;
        return;
    }

    public DoraGGestureSettingsFragment() {
        final Function0<Fragment> r0 = new DoraGGestureSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGGestureSettingsViewModel.class), new DoraGGestureSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraGGestureSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = LastSwitchSide.BUTTON;
        boolean r1 = v19.h.a;
        this.i = v19.h.a(null);
        this.k = LazyKt.lazy(new com.larus.dora.impl.device.settings.gesture.b());
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        LarusDoraPageGestureDoraGSettingsBinding r0 = this.f;
        if (r0 == null) goto L6;
        r0.y.f();
        r0.y.setFirstFrameRenderedListener(null);
        return;
    }

    public final void onResume() {
        super.onResume();
        Z90().load(this.h);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r3) {
        super.V90(r3);
        g49.d.d("DoraGGestureSettingsFragment", "onDoraConnectStateChanged: " + r3);
        if (r3 == false) goto L6;
        Z90().load(this.h);
        return;
    }

    public final void W90(ItemTextDescView r4) {
        r4.getTextView().setTextSize(0, i5.q());
        r4.getDescView().setTextColor(Y90(2131103143));
        r4.getDescView().setTextSize(0, i5.q());
    }

    public final void X90(LastSwitchSide r7) {
        LarusDoraPageGestureDoraGSettingsBinding r0 = this.f;
        if (r0 == null) goto L61;
        LastSwitchSide r1 = aa0().b(r7);
        if (r1 == r7) goto L8;
    L59:
        Unit r8 = Unit.INSTANCE;
        return;
    L8:
        if (r0.y.a() == true) goto L59;
        LastSwitchSide r9 = this.h;
        int[] r2 = b.a;
        int r10 = r2[r9.ordinal()];
        boolean r5 = true;
        if (r10 == 1) goto L34;
        if (r10 == 2) goto L25;
        if (r10 != 3) goto L24;
        int r11 = r2[r1.ordinal()];
        if (r11 == 1) goto L22;
        if (r11 == 2) goto L21;
        if (r11 != 3) goto L20;
        DoraVideoType r12 = DoraVideoType.UNKNOWN;
    L44:
        if (r12 == DoraVideoType.UNKNOWN) goto L56;
        DoraResourceUtil r3 = DoraResourceUtil.a;
        final String r13 = DoraResourceUtil.h(r12.fileName(DoraSKU.BLACK, this.i), "com_flow_dora_gesture_channel");
        if (r13.length() == 0) goto L50;
        r5 = false;
    L50:
        if (r5 == false) goto L52;
        g49.d.d("DoraGGestureSettingsFragment", "cur path is empty, show first frame image");
        ea0(r1);
        goto L56
    L52:
        final LarusDoraPageGestureDoraGSettingsBinding r4 = this.f;
        if (r4 == null) goto L56;
        r4.y.post(new j(r4, r13));
    L56:
        if (r1 != LastSwitchSide.BUTTON) goto L58;
        W90(r0.c);
    L58:
        this.h = r1;
        DoraGGestureSettingsRepository r14 = DoraGGestureSettingsRepository.a;
        DoraGGestureSettingsRepository.k(r1);
        Z90().load(this.h);
        goto L59
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r12 = DoraVideoType.DORA_G_GESTURE_M_2_R;
        goto L44
    L22:
        r12 = DoraVideoType.DORA_G_GESTURE_M_2_L;
        goto L44
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        int r15 = r2[r1.ordinal()];
        if (r15 == 1) goto L33;
        if (r15 == 2) goto L32;
        if (r15 != 3) goto L31;
        r12 = DoraVideoType.DORA_G_GESTURE_R_2_M;
        goto L44
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        r12 = DoraVideoType.UNKNOWN;
        goto L44
    L33:
        r12 = DoraVideoType.DORA_G_GESTURE_L;
        goto L44
    L34:
        int r16 = r2[r1.ordinal()];
        if (r16 == 1) goto L42;
        if (r16 == 2) goto L41;
        if (r16 != 3) goto L40;
        r12 = DoraVideoType.DORA_G_GESTURE_L_2_M;
        goto L44
    L40:
        throw new NoWhenBranchMatchedException();
    L41:
        r12 = DoraVideoType.DORA_G_GESTURE_R;
        goto L44
    L42:
        r12 = DoraVideoType.UNKNOWN;
        goto L44
    }

    public final int Y90(int r2) {
        return ContextCompat.getColor(requireContext(), r2);
    }

    public final Unit ca0(boolean r5) {
        LarusDoraPageGestureDoraGSettingsBinding r0 = this.f;
        if (r0 == null) goto L19;
        boolean r2 = true;
        if (r5 == false) goto L13;
        if (r0.v.getVisibility() == 0) goto L10;
        r2 = false;
    L10:
        if (r2 == false) goto L21;
        r0.v.setVisibility(8);
        r0.u.setVisibility(0);
    L21:
        return Unit.INSTANCE;
    L13:
        if (r0.u.getVisibility() == 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L21;
        r0.u.setVisibility(8);
        r0.v.setVisibility(0);
        goto L21
    L19:
        return null;
    }

    public final Unit da0(LastSwitchSide r6) {
        LarusDoraPageGestureDoraGSettingsBinding r0 = this.f;
        if (r0 == null) goto L15;
        LastSwitchSide r7 = aa0().b(r6);
        int r8 = b.a[r7.ordinal()];
        if (r8 != 1) goto L7;
        ba0();
        r0.l.setVisibility(0);
        r0.r.setTextColor(Y90(2131103136));
        return ca0(false);
    L7:
        if (r8 != 2) goto L9;
        ba0();
        r0.n.setVisibility(0);
        r0.t.setTextColor(Y90(2131103136));
        return ca0(false);
    L9:
        if (r8 != 3) goto L12;
        ba0();
        r0.m.setVisibility(0);
        r0.s.setTextColor(Y90(2131103136));
        ca0(true);
        W90(r0.c);
        return Unit.INSTANCE;
    L12:
        throw new NoWhenBranchMatchedException();
    L15:
        return null;
    }

    public final void ea0(LastSwitchSide r4) {
        int r5 = b.a[r4.ordinal()];
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L15;
        if (r5 != 3) goto L13;
        if (this.i == false) goto L11;
        String r6 = "larus_dora_g_first_frame_m_dark";
    L22:
        LarusDoraPageGestureDoraGSettingsBinding r0 = this.f;
        if (r0 == null) goto L26;
        ImageView r1 = r0.z;
        com.larus.dora.impl.util.u r2 = com.larus.dora.impl.util.u.a;
        Context r3 = requireContext();
        r2.getClass();
        r1.setImageDrawable(com.larus.dora.impl.util.u.c(r3, r6));
        return;
    L26:
        return;
    L11:
        r6 = "larus_dora_g_first_frame_m";
        goto L22
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        if (this.i == false) goto L17;
        r6 = "larus_dora_g_first_frame_l_dark";
        goto L22
    L17:
        r6 = "larus_dora_g_first_frame_l";
        goto L22
    L19:
        if (this.i == false) goto L21;
        r6 = "larus_dora_g_first_frame_r_dark";
        goto L22
    L21:
        r6 = "larus_dora_g_first_frame_r";
        goto L22
    }

    public final Unit fa0(List<DoraGGestureSettings> r12, byte r13) {
        LarusDoraPageGestureDoraGSettingsBinding r0 = this.f;
        if (r0 == null) goto L50;
        g49.d.d("DoraGGestureSettingsFragment", "updateItemsByStatus: status=" + r13 + ", itemCount=" + r12.size());
        if (r12.isEmpty() == true) goto L46;
        Context r2 = getContext();
        if (r2 == null) goto L46;
        if (r13 != 6) goto L13;
        ItemGroup r1 = r0.i;
    L19:
        r1.removeAllViews();
        int r4 = 0;
        if (r13 == 2) goto L24;
        if (r13 == 4) goto L24;
        boolean r5 = false;
    L25:
        int r6 = r12.size();
        Iterator<T> r14 = r12.iterator();
    L27:
        if (r14.hasNext() == false) goto L46;
        int r7 = r4 + 1;
        final DoraGGestureSettings r8 = (DoraGGestureSettings) r14.next();
        if (r5 == true) goto L31;
        if (r6 != 1) goto L35;
        int r9 = 2131239210;
    L41:
        final ItemTextArrow r10 = new ItemTextArrow(r2);
        r10.setText(r8.d());
        r10.setTextFontWeight(500);
        r10.Z5(r8.c(), null);
        r10.setTag(r8);
        r10.post(new c(r10));
        r10.setBackgroundResource(r9);
        e1.d(r10, new d(this, r8));
        if (r13 != 1) goto L44;
        r10.getSubTextView().setMinWidth((int) UIUtils.dip2Px(r2, 200.0f));
    L44:
        r1.addView(r10, new ViewGroup.LayoutParams(-1, -1));
        r4 = r7;
        goto L27
    L35:
        if (r4 != 0) goto L38;
        r9 = 2131239212;
        goto L41
    L38:
        if (r4 != (r6 - 1)) goto L40;
    L39:
        r9 = 2131239215;
    L40:
        r9 = 2131239218;
        goto L41
    L31:
        if (r4 != (r6 - 1)) goto L40;
    L24:
        r5 = true;
        goto L25
    L13:
        if (r13 != 1) goto L15;
        r1 = r0.e;
        goto L19
    L15:
        if (r13 != 2) goto L17;
        r1 = r0.g;
        goto L19
    L17:
        if (r13 != 4) goto L46;
        r1 = r0.b;
    L46:
        return Unit.INSTANCE;
    L50:
        return null;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        Bundle r14 = getArguments();
        if (r14 != null) goto L5;
    L10:
        Integer r15 = null;
    L11:
        this.j = r15;
        Bundle r16 = getArguments();
        if (r16 != null) goto L14;
    L19:
        String r17 = null;
    L21:
        if (this.j != null) goto L25;
        if (r17 != null) goto L25;
        DoraGGestureSettingsRepository r18 = DoraGGestureSettingsRepository.a;
        LastSwitchSide r110 = DoraGGestureSettingsRepository.f();
    L26:
        LastSwitchSide r0 = aa0().b(r110);
        this.h = r0;
        if (r0 == r110) goto L29;
        DoraGGestureSettingsRepository r111 = DoraGGestureSettingsRepository.a;
        DoraGGestureSettingsRepository.k(r0);
    L29:
        final LarusDoraPageGestureDoraGSettingsBinding r112 = this.f;
        if (r112 == null) goto L45;
        LinearLayoutCompat r1 = r112.o;
        int r2 = 8;
        if (aa0().a(LastSwitchSide.LEFT) == false) goto L34;
        int r3 = 0;
    L35:
        r1.setVisibility(r3);
        LinearLayoutCompat r4 = r112.p;
        if (aa0().a(LastSwitchSide.BUTTON) == false) goto L38;
        int r5 = 0;
    L39:
        r4.setVisibility(r5);
        LinearLayoutCompat r6 = r112.q;
        if (aa0().a(LastSwitchSide.RIGHT) == false) goto L42;
        r2 = 0;
    L42:
        r6.setVisibility(r2);
        Unit r7 = Unit.INSTANCE;
        ea0(this.h);
        r112.y.setFirstFrameRenderedListener(new e(r112));
        W90(r112.w);
        da0(this.h);
        LarusDoraPageGestureDoraGSettingsBinding r113 = this.f;
        if (r113 == null) goto L45;
        r113.j.setPadding(i5.q(), 0, 0, i5.n0());
        r113.f.setPadding(i5.q(), 0, 0, i5.n0());
        r113.h.setPadding(i5.q(), 0, 0, i5.n0());
        r113.d.setPadding(i5.q(), 0, 0, i5.n0());
        goto L45
    L38:
        r5 = 8;
        goto L39
    L34:
        r3 = 8;
    L45:
        LarusDoraPageGestureDoraGSettingsBinding r114 = this.f;
        if (r114 == null) goto L48;
        NovaTitleBarEx r8 = r114.x;
        NovaTitleBarEx.Y5(r8, getString(2131902997), null, null, 6);
        NovaTitleBarEx.b6(r8, 2131240517, false, null, null, new i(this), 14);
    L48:
        LarusDoraPageGestureDoraGSettingsBinding r115 = this.f;
        if (r115 == null) goto L51;
        Lifecycle.State r9 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGGestureSettingsFragment$setListener$lambda$12$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r9, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGGestureSettingsFragment$setListener$lambda$12$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r9, null, this), 3, null);
        e1.d(r115.o, new f(this));
        e1.d(r115.q, new g(this));
        e1.d(r115.p, new h(this));
        Unit r116 = Unit.INSTANCE;
    L51:
        FragmentActivity r117 = getActivity();
        if (r117 == null) goto L57;
        OnBackPressedDispatcher r118 = r117.getOnBackPressedDispatcher();
        if (r118 == null) goto L58;
        r118.addCallback(getViewLifecycleOwner(), new DoraGGestureSettingsFragment$setupBackPressedCallback$1(this));
        return;
    L58:
        return;
    L57:
        return;
    L25:
        r110 = LastSwitchSide.LEFT;
        goto L26
    L14:
        if (r16.containsKey("source") == true) goto L17;
        r16 = null;
    L17:
        if (r16 == null) goto L19;
        r17 = r16.getString("source");
        goto L21
    L5:
        if (r14.containsKey("is_first") == true) goto L8;
        r14 = null;
    L8:
        if (r14 == null) goto L10;
        r15 = Integer.valueOf(r14.getInt("is_first"));
        goto L11
    }

    public final View onCreateView(LayoutInflater r31, ViewGroup r32, Bundle r33) {
        Intrinsics.checkNotNullParameter(r31, "inflater");
        ConstraintLayout r0 = r31.inflate(2131562266, r32, false);
        int r1 = 2131365020;
        ItemGroup r5 = ViewBindings.findChildViewById(r0, 2131365020);
        if (r5 == null) goto L61;
        r1 = 2131365049;
        ItemTextDescView r6 = ViewBindings.findChildViewById(r0, 2131365049);
        if (r6 == null) goto L61;
        r1 = 2131369609;
        ItemGroupTitle r7 = ViewBindings.findChildViewById(r0, 2131369609);
        if (r7 == null) goto L61;
        r1 = 2131369610;
        ItemGroup r8 = ViewBindings.findChildViewById(r0, 2131369610);
        if (r8 == null) goto L61;
        r1 = 2131369611;
        ItemGroupTitle r9 = ViewBindings.findChildViewById(r0, 2131369611);
        if (r9 == null) goto L61;
        r1 = 2131369614;
        ItemGroup r10 = ViewBindings.findChildViewById(r0, 2131369614);
        if (r10 == null) goto L61;
        r1 = 2131369615;
        ItemGroupTitle r11 = ViewBindings.findChildViewById(r0, 2131369615);
        if (r11 == null) goto L61;
        r1 = 2131369616;
        ItemGroup r12 = ViewBindings.findChildViewById(r0, 2131369616);
        if (r12 == null) goto L61;
        r1 = 2131369617;
        ItemGroupTitle r13 = ViewBindings.findChildViewById(r0, 2131369617);
        if (r13 == null) goto L61;
        r1 = 2131369962;
        View r14 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r14 == null) goto L61;
        r1 = 2131373637;
        if (ViewBindings.findChildViewById(r0, 2131373637) == null) goto L61;
        r1 = 2131373638;
        View r15 = ViewBindings.findChildViewById(r0, 2131373638);
        if (r15 == null) goto L61;
        r1 = 2131373639;
        View r16 = ViewBindings.findChildViewById(r0, 2131373639);
        if (r16 == null) goto L61;
        r1 = 2131373640;
        View r17 = ViewBindings.findChildViewById(r0, 2131373640);
        if (r17 == null) goto L61;
        r1 = 2131373641;
        LinearLayoutCompat r18 = ViewBindings.findChildViewById(r0, 2131373641);
        if (r18 == null) goto L61;
        r1 = 2131373642;
        LinearLayoutCompat r110 = ViewBindings.findChildViewById(r0, 2131373642);
        if (r110 == null) goto L61;
        r1 = 2131373643;
        LinearLayoutCompat r20 = ViewBindings.findChildViewById(r0, 2131373643);
        if (r20 == null) goto L61;
        r1 = 2131373644;
        AppCompatTextView r21 = ViewBindings.findChildViewById(r0, 2131373644);
        if (r21 == null) goto L61;
        r1 = 2131373645;
        AppCompatTextView r22 = ViewBindings.findChildViewById(r0, 2131373645);
        if (r22 == null) goto L61;
        r1 = 2131373646;
        AppCompatTextView r23 = ViewBindings.findChildViewById(r0, 2131373646);
        if (r23 == null) goto L61;
        r1 = 2131373647;
        if (ViewBindings.findChildViewById(r0, 2131373647) == null) goto L61;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L61;
        r1 = 2131385242;
        LinearLayout r24 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131385242);
        if (r24 == null) goto L61;
        r1 = 2131385244;
        LinearLayout r25 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131385244);
        if (r25 == null) goto L61;
        r1 = 2131388183;
        ItemTextDescView r26 = ViewBindings.findChildViewById(r0, 2131388183);
        if (r26 == null) goto L61;
        r1 = 2131388772;
        NovaTitleBarEx r27 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r27 == null) goto L61;
        r1 = 2131392404;
        DoraMovieView r28 = (DoraMovieView) ViewBindings.findChildViewById(r0, 2131392404);
        if (r28 == null) goto L61;
        r1 = 2131392406;
        ImageView r210 = (ImageView) ViewBindings.findChildViewById(r0, 2131392406);
        if (r210 == null) goto L61;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageGestureDoraGSettingsBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r210);
        return r2;
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
