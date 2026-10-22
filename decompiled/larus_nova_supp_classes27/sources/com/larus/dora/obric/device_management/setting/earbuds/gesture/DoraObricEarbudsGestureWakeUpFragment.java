package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupViewModel;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010+\u001a\u00020\rH\u0002J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020%H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00102\u001a\u00020\u0012H\u0002J\u0018\u00106\u001a\u00020%2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0012H\u0002J\u0010\u00107\u001a\u00020%2\u0006\u00102\u001a\u00020\u0012H\u0002J\b\u00108\u001a\u00020%H\u0002J\b\u00109\u001a\u00020%H\u0002J.\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020%0?H\u0002J\u0018\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0010\u0010C\u001a\u00020\r2\u0006\u0010;\u001a\u00020)H\u0002J\f\u0010D\u001a\u00020%*\u00020\u0013H\u0002J\f\u0010E\u001a\u00020%*\u00020\u0013H\u0002J\b\u0010F\u001a\u00020\u000bH\u0002J\b\u0010G\u001a\u00020\u000bH\u0002J\b\u0010H\u001a\u00020\u000bH\u0002J\b\u0010I\u001a\u00020\u000bH\u0002J\f\u0010J\u001a\u00020%*\u00020\u0018H\u0002J\f\u0010K\u001a\u00020%*\u00020\u0018H\u0002J\u0010\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020\rH\u0002J\f\u0010N\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010O\u001a\u00020\u000b*\u00020PH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/gesture/DoraObricEarbudsGestureWakeUpFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel;", "model$delegate", "Lkotlin/Lazy;", "side", "", "pageMaskView", "Landroid/view/View;", "optionContainer", "Landroid/widget/LinearLayout;", "optionViews", "Ljava/util/LinkedHashMap;", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupType;", "Lcom/obric/oui/lisitem/OCardListItem;", "Lkotlin/collections/LinkedHashMap;", "hintSectionTitle", "hintGroup", "hintText", "Landroid/widget/TextView;", "hintVideo", "Lcom/larus/dora/impl/view/DoraMovieView;", "hintPlayIcon", "Landroid/widget/ImageView;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildHintVideoCard", "buildHintText", "initHintVideo", "updateHintVideo", "type", "releaseHintVideo", "setupOptions", "onOptionClicked", "updateSelectItemView", "updateSelectionMark", "observeState", "observeActions", "buildOptionCard", "title", "subtitle", "position", "onClick", "Lkotlin/Function0;", "resolveCardPosition", "index", "size", "buildSectionTitle", "applyCardStyle", "resetCardContainerMargins", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "resolveCardBackgroundColor", "applyTitleBarTextStyle", "applySectionTitleTextStyle", "relaxClipForShadow", "target", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsGestureWakeUpFragment extends DoraBaseFragment {
    public static final /* synthetic */ int p = 0;
    public final Lazy f;
    public int g;
    public View h;
    public LinearLayout i;
    public final LinkedHashMap<GestureWakeupType, OCardListItem> j;
    public OSectionTitleBar k;
    public View l;
    public TextView m;
    public DoraMovieView n;
    public ImageView o;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GestureWakeupType.values().length];
            r0[GestureWakeupType.CLOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[GestureWakeupType.RADIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[GestureWakeupType.RADIO_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final String k() {
        return "";
    }

    public final GestureWakeupViewModel Y90() {
        return (GestureWakeupViewModel) this.f.getValue();
    }

    public final void Z90() {
        DoraMovieView r0 = this.n;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        DoraMovieView r1 = this.n;
        if (r1 == null) goto L9;
        r1.f();
        return;
    }

    public DoraObricEarbudsGestureWakeUpFragment() {
        final Function0<Fragment> r0 = new DoraObricEarbudsGestureWakeUpFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GestureWakeupViewModel.class), new DoraObricEarbudsGestureWakeUpFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsGestureWakeUpFragment$special$$inlined$viewModels$default$3(r0, this));
        this.j = new LinkedHashMap();
    }

    public final void onDestroyView() {
        Z90();
        this.j.clear();
        this.h = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.h;
    }

    public final int X90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void aa0(GestureWakeupType r4) {
        Iterator<Map.Entry<GestureWakeupType, OCardListItem>> r0 = this.j.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<GestureWakeupType, OCardListItem> r1 = r0.next();
        GestureWakeupType r2 = r1.getKey();
        OCardListItem r3 = r1.getValue();
        if (r2 != r4) goto L8;
        boolean r5 = true;
    L9:
        r3.m(r5);
        goto L4
    L8:
        r5 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [com.larus.dora.obric.device_management.setting.earbuds.gesture.r] */
    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r17, r18);
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        int r2 = r1.getInt("device_side");
    L6:
        this.g = r2;
        LinearLayout r3 = this.i;
        int r4 = 1;
        if (r3 == null) goto L42;
        Context r5 = requireContext();
        List<GestureWakeupType> r6 = Y90().getGestureWakeupTypes();
        r3.removeAllViews();
        this.j.clear();
        Iterator<T> r7 = r6.iterator();
        int r8 = 0;
    L11:
        if (r7.hasNext() == false) goto L42;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        final GestureWakeupType r11 = (GestureWakeupType) r9;
        String r12 = r5.getString(r11.getTitleResId());
        if (r11.getSubtitleResId() <= 0) goto L18;
        String r13 = r5.getString(r11.getSubtitleResId());
    L19:
        Intrinsics.checkNotNull(r13);
        int r14 = r6.size();
        if (r14 > r4) goto L22;
        int r15 = 0;
    L28:
        final ?? r16 = new r(this, r11);
        final OCardListItem r110 = new OCardListItem(requireContext(), null, 6, 0);
        r110.setCardType(0);
        OCardListItem.h(r110, r15);
        r110.setShowCardBg(true);
        r110.p(false);
        r110.setTitle(r12);
        r110.s(true);
        if (r13.length() != 0) goto L31;
        boolean r20 = true;
    L32:
        if (r20 == false) goto L34;
        r110.q(false);
    L35:
        r110.setDefaultCustomEndView(2);
        r110.m(false);
        r110.r(false);
        ViewGroup.LayoutParams r21 = r110.getCardContainer().getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
    L39:
        if (r22 == null) goto L41;
        r22.setMarginStart(0);
        r22.setMarginEnd(0);
        r22.leftMargin = 0;
        r22.rightMargin = 0;
        r110.getCardContainer().setLayoutParams(r22);
    L41:
        r110.getContentContainer().setPadding(0, 0, X90(4), 0);
        r110.getTitleContainer().setGravity(16);
        r110.getTitleContainer().setPadding(X90(12), X90(10), X90(8), X90(10));
        OTextView r23 = r110.getTitleView();
        r23.setGravity(8388611);
        r23.setMaxLines(1);
        r23.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r23.setTextSize(2, 16.0f);
        Resources r24 = getResources();
        TextViewCompat.setLineHeight(r23, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r24, r24.getDisplayMetrics())));
        r23.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r110.o(false);
        r110.setOnContentClickListener(new s(r110, r16));
        this.j.put(r11, r110);
        r3.addView(r110);
        r8 = r10;
        r4 = 1;
        goto L11
    L38:
        r22 = null;
        goto L39
    L34:
        r110.setSubTitle(r13);
        r110.getSubTitleView().setMaxLines(5);
        r110.q(true);
        goto L35
    L31:
        r20 = false;
        goto L32
    L22:
        if (r8 != 0) goto L25;
        r15 = 1;
        goto L28
    L25:
        if (r8 != (r14 - 1)) goto L27;
        r15 = 3;
        goto L28
    L27:
        r15 = 2;
        goto L28
    L18:
        r13 = "";
    L42:
        final DoraMovieView r25 = this.n;
        if (r25 == null) goto L49;
        final ImageView r26 = this.o;
        if (r26 == null) goto L49;
        r25.setLooping(Boolean.TRUE);
        r25.setPauseInFirst(true);
        r25.setMediaPlayerStartListener(new p(r26));
        e1.d(r25, new q(r25, r26));
    L49:
        Lifecycle.State r27 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureWakeUpFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r27, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureWakeUpFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r27, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureWakeUpFragment$observeActions$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r27, null, this), 3, null);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public static final void W90(final DoraObricEarbudsGestureWakeUpFragment r6, int r7, GestureWakeupType r8) {
        if (r7 != 0) goto L4;
    L6:
        r6.aa0(r8);
        final DoraMovieView r9 = r6.n;
        if (r9 == null) goto L39;
        View r0 = r6.l;
        if (r0 == null) goto L40;
        OSectionTitleBar r1 = r6.k;
        if (r1 == null) goto L41;
        TextView r2 = r6.m;
        if (r2 == null) goto L42;
        int r3 = b.a[r8.ordinal()];
        if (r3 != 1) goto L21;
        r1.setVisibility(8);
        r0.setVisibility(8);
        r2.setVisibility(8);
        return;
    L21:
        if (r3 != 2) goto L23;
    L29:
        r1.setVisibility(0);
        r0.setVisibility(0);
        r2.setVisibility(0);
        if (r8 != GestureWakeupType.RADIO) goto L32;
        String r10 = r6.getString(2131904054);
    L33:
        r2.setText(r10);
        r9.post(new l(r6, r9));
        return;
    L32:
        r10 = r6.getString(2131903943);
        goto L33
    L23:
        if (r3 == 3) goto L29;
        if (r3 != 4) goto L28;
        r1.setVisibility(0);
        r0.setVisibility(0);
        r2.setVisibility(0);
        r2.setText(r6.getString(2131904051));
        r9.post(new m(r6, r9));
        return;
    L28:
        throw new NoWhenBranchMatchedException();
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L4:
        if (r7 == r6.g) goto L6;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        LinearLayout r2 = new LinearLayout(r1);
        r2.setOrientation(1);
        r2.setClipChildren(true);
        r2.setClipToPadding(true);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        OFloatingTitleBar r4 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r4);
        r4.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        int r7 = j0.a;
        r4.setCenterTitle(j0.d(2131904055));
        r4.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r8 = (TextView) r4.findViewById(2131365427);
        if (r8 == null) goto L5;
        r8.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r8.setTextSize(2, 16.0f);
        Resources r5 = getResources();
        TextViewCompat.setLineHeight(r8, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())));
        r8.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r4.R(false);
        final View r6 = OFloatingTitleBar.k(r4, null, 6);
        r6.setOnClickListener(new n(this));
        r4.post(new o(this, r6));
        r2.addView(r4, new LinearLayout.LayoutParams(-1, -2));
        Context r9 = requireContext();
        LinearLayout r10 = new LinearLayout(r9);
        r10.setOrientation(1);
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        r10.setPadding(X90(12), 0, X90(12), X90(16));
        LinearLayout r11 = new LinearLayout(r9);
        r11.setOrientation(1);
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
        this.i = r11;
        r10.addView(r11);
        String r12 = j0.d(2131904048);
        OSectionTitleBar r13 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r14 = (LinearLayout) r13.findViewById(2131367728);
        if (r14 == null) goto L8;
        r14.setPadding(X90(20), X90(8), X90(12), X90(8));
    L8:
        r13.setTitleText(r12);
        r13.setTitleTextSize(12.0f);
        r13.setTitleTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        TextView r15 = (TextView) r13.findViewById(2131388792);
        if (r15 == null) goto L11;
        r15.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r15.setTextSize(2, 12.0f);
        Resources r3 = getResources();
        TextViewCompat.setLineHeight(r15, (int) TypedValue.applyDimension(2, 16.0f, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        r15.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    L11:
        r13.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams r16 = r13.getLayoutParams();
        if ((r16 instanceof LinearLayout.LayoutParams) == false) goto L14;
        LinearLayout.LayoutParams r20 = (LinearLayout.LayoutParams) r16;
    L15:
        if (r20 == null) goto L17;
        r20.topMargin = X90(16);
    L17:
        r13.setVisibility(8);
        r10.addView(r13);
        this.k = r13;
        Context r21 = requireContext();
        GradientDrawable r22 = new GradientDrawable();
        r22.setShape(0);
        r22.setCornerRadius(X90(20));
        r22.setColor(v19.c.a(2130970532, requireContext(), 2131102539));
        FrameLayout r23 = new FrameLayout(r21);
        r23.setBackground(r22);
        r23.setClipToOutline(true);
        r23.setLayoutParams(new LinearLayout.LayoutParams(-1, X90(252)));
        DoraMovieView r111 = new DoraMovieView(r21);
        r111.setClipToOutline(true);
        r23.addView(r111, new FrameLayout.LayoutParams(-1, -1, 17));
        this.n = r111;
        ImageView r24 = new ImageView(r21);
        r24.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r24.setImageResource(2131240528);
        r24.setVisibility(8);
        r23.addView(r24, new FrameLayout.LayoutParams(X90(48), X90(48), 17));
        this.o = r24;
        r23.setVisibility(8);
        r10.addView(r23);
        this.l = r23;
        TextView r25 = new TextView(requireContext());
        r25.setGravity(17);
        r25.setTextAlignment(4);
        r25.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r25.setTextSize(2, 13.0f);
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(-2, -2);
        r26.gravity = 1;
        r26.setMarginStart(X90(16));
        r26.setMarginEnd(X90(16));
        r26.topMargin = X90(8);
        r25.setLayoutParams(r26);
        r25.setVisibility(8);
        r10.addView(r25);
        this.m = r25;
        NestedScrollView r27 = new NestedScrollView(r9);
        r27.setClipChildren(false);
        r27.setClipToPadding(false);
        r27.setOverScrollMode(2);
        r27.setFillViewport(true);
        r27.setPadding(0, X90(16), 0, 0);
        r27.addView(r10, new ViewGroup.LayoutParams(-1, -2));
        r2.addView(r27, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r28 = new FrameLayout(r1);
        r28.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r28.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        View r30 = new View(r1);
        r30.setBackgroundColor(ContextCompat.getColor(r1, 2131103066));
        r30.setClickable(true);
        r30.setFocusable(true);
        r28.addView(r30, new FrameLayout.LayoutParams(-1, -1));
        this.h = r30;
        return r28;
    L14:
        r20 = null;
        goto L15
    }
}
