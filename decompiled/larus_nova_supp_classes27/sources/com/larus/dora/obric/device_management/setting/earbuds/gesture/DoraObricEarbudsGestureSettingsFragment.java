package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsViewModel;
import com.larus.dora.impl.device.settings.gesture.c0;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.dora.impl.device.settings.gesture.widget.DoraGestureGuidanceMaskView;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.image.OImage;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\rH\u0002J\b\u0010,\u001a\u00020\rH\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u00020$H\u0002J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\u000fH\u0002J\b\u00107\u001a\u00020\rH\u0002J\f\u00108\u001a\u00020$*\u000209H\u0002J \u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0002J\b\u0010>\u001a\u00020$H\u0002J\u0012\u0010?\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010B\u001a\u00020\r2\u0006\u0010;\u001a\u00020(H\u0002J.\u0010C\u001a\u00020\r2\u0006\u0010;\u001a\u00020(2\u0006\u0010D\u001a\u00020(2\u0006\u0010=\u001a\u00020\u001b2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020$0FH\u0002J\u0010\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020\u000fH\u0002J\u0010\u0010I\u001a\u00020$2\u0006\u0010H\u001a\u00020\u000fH\u0002J\u0018\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u001bH\u0002J\f\u0010M\u001a\u00020$*\u00020\u0015H\u0002J\f\u0010N\u001a\u00020$*\u00020\u0015H\u0002J\u0010\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u001bH\u0002J\b\u0010Q\u001a\u00020\u001bH\u0002J\b\u0010R\u001a\u00020\u001bH\u0002J\b\u0010S\u001a\u00020\u001bH\u0002J\f\u0010T\u001a\u00020$*\u00020UH\u0002J\f\u0010V\u001a\u00020$*\u00020UH\u0002J\f\u0010W\u001a\u00020$*\u00020UH\u0002J\u0010\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020\rH\u0002J\f\u0010Z\u001a\u00020\u001b*\u00020\u001bH\u0002J\f\u0010[\u001a\u00020\u001b*\u00020\\H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/gesture/DoraObricEarbudsGestureSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "contentContainer", "Landroid/widget/LinearLayout;", "pageMaskView", "Landroid/view/View;", "isSupportSimulInterpret", "", "isSupportOta3p5", "isWakeupGestureSupported", "wakeupSection", "wakeupSectionSpacer", "wakeupLeftItem", "Lcom/obric/oui/lisitem/OCardListItem;", "wakeupRightItem", "mediaRightItem", "doraGestureGuidanceMask", "Lcom/larus/dora/impl/device/settings/gesture/widget/DoraGestureGuidanceMaskView;", "isFirst", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "renderContent", "state", "Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsState$Success;", "setupBackPressedCallback", "finishWithResult", "setSimultaneousInterpretGuideMask", "showGuideMask", "targetItem", "buildWakeupGestureSection", "shouldShowSeparateWakeupItems", "buildGesturePreviewHeader", "setGesturePreviewImage", "Lcom/obric/oui/image/OImage;", "buildWakeupGestureItem", "title", "side", "position", "updateWakeupGestureVisibility", "updateWakeupGestureDisplay", "sideType", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupSideType;", "buildSectionTitle", "buildClickableItem", "value", "onClick", "Lkotlin/Function0;", "gotoMediaGestureSettingsPage", "isLeft", "gotoCallingGestureSettingsPage", "resolveCardPosition", "index", "size", "applyCardStyle", "resetCardContainerMargins", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "applySectionTitleTextStyle", "applyPreviewHintTextStyle", "relaxClipForShadow", "target", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsGestureSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int r = 0;
    public final Lazy f;
    public LinearLayout g;
    public View h;
    public boolean i;
    public boolean j;
    public boolean k;
    public View l;
    public View m;
    public OCardListItem n;
    public OCardListItem o;
    public DoraGestureGuidanceMaskView p;
    public int q;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsGestureSettingsFragment a;

        public b(DoraObricEarbudsGestureSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r18, Continuation r110) {
            c0 r0 = (c0) r18;
            if (Intrinsics.areEqual(r0, c0.a.a) == true) goto L99;
            if (Intrinsics.areEqual(r0, c0.b.a) == true) goto L99;
            if ((r0 instanceof c0.c) == false) goto L96;
            final DoraObricEarbudsGestureSettingsFragment r2 = this.a;
            c0.c r1 = (c0.c) r0;
            LinearLayout r3 = r2.g;
            if (r3 == null) goto L99;
            r3.removeAllViews();
            LinearLayout r4 = new LinearLayout(r2.requireContext());
            r4.setOrientation(1);
            r4.setClipChildren(false);
            r4.setClipToPadding(false);
            r4.setGravity(1);
            r4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            View r7 = LayoutInflater.from(r4.getContext()).inflate(2131562233, r4, false);
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.image.OImage");
            OImage r8 = (OImage) r7;
            r8.setScaleType(ImageView.ScaleType.FIT_CENTER);
            r8.setAdjustViewBounds(false);
            DoraDevice r10 = DoraAdapterExtKt.h(kj4.a.g());
            if (r10 == null) goto L14;
            Integer r11 = Integer.valueOf(r10.sku);
        L15:
            DoraSKU r12 = DoraSKU.a.b(DoraSKU.Companion, r11);
            DoraResourceUtil r13 = DoraResourceUtil.a;
            r8.setImageBitmap(DoraResourceUtil.c(DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE.fileName(r12)));
            LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(r2.Z90(214), r2.Z90(178));
            r14.gravity = 1;
            r14.topMargin = r2.Z90(8);
            Unit r15 = Unit.INSTANCE;
            r4.addView(r8, r14);
            OTextView r9 = new OTextView(r4.getContext(), null, 0, 14);
            r9.setText(r2.getString(2131903055));
            r9.setGravity(17);
            r9.setTextColor(ContextCompat.getColor(r2.requireContext(), 2131104359));
            r9.setTextSize(2, 14.0f);
            TextViewCompat.setLineHeight(r9, r2.aa0(18.0f));
            r9.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
            LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
            r16.gravity = 1;
            r16.topMargin = r2.Z90(10);
            r16.bottomMargin = r2.Z90(18);
            r4.addView(r9, r16);
            r3.addView(r4);
            Context r5 = r2.requireContext();
            r2.n = null;
            LinearLayout r17 = new LinearLayout(r5);
            r17.setOrientation(1);
            r17.setClipChildren(false);
            r17.setClipToPadding(false);
            r17.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            r17.addView(r2.Y90(r2.getString(2131904055)));
            String r6 = r2.getString(2131904049);
            final OCardListItem r20 = new OCardListItem(r2.requireContext(), null, 6, 0);
            r20.setCardType(0);
            OCardListItem.h(r20, 0);
            r20.setShowCardBg(true);
            r20.p(false);
            r20.setTitle(r6);
            r20.s(true);
            r20.q(false);
            r20.setDefaultCustomEndView(3);
            r20.m(true);
            r20.setDefaultTailIcon(0);
            r20.r(true);
            GestureWakeupType r111 = GestureWakeupRepository.f(GestureWakeupRepository.a, null, 1);
            if (r111 == null) goto L18;
            int r112 = j0.a;
            String r113 = j0.d(r111.getTitleResId());
        L20:
            if (r113 != null) goto L22;
            r113 = "";
        L22:
            r20.k(r113, -1);
            r2.W90(r20);
            r20.o(false);
            r20.setOnContentClickListener(new j(r20, r2));
            r2.n = r20;
            r17.addView(r20);
            r3.addView(r17);
            r2.l = r17;
            View r21 = new View(r2.requireContext());
            r21.setLayoutParams(new LinearLayout.LayoutParams(-1, r2.Z90(16)));
            r3.addView(r21);
            r2.m = r21;
            r2.ba0();
            r3.addView(r2.Y90(r2.getString(2131903031)));
            List r22 = CollectionsKt.listOf(new Triple[]{new Triple(r2.getString(2131903015), GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK, Boolean.TRUE), new Triple(r2.getString(2131903016), GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK, Boolean.FALSE)});
            Iterator<T> r23 = r22.iterator();
            int r24 = 0;
        L24:
            if (r23.hasNext() == false) goto L48;
            T r114 = r23.next();
            int r115 = r24 + 1;
            if (r24 >= 0) goto L28;
            CollectionsKt.throwIndexOverflow();
        L28:
            Triple r116 = (Triple) r114;
            String r25 = (String) r116.component1();
            GestureSettingsKey r117 = (GestureSettingsKey) r116.component2();
            final boolean r118 = ((Boolean) r116.component3()).booleanValue();
            Byte r26 = r1.a.get(r117);
            if (r26 == null) goto L31;
            byte r27 = r26.byteValue();
            GestureSettingsRepository r119 = GestureSettingsRepository.a;
            Byte r28 = Byte.valueOf(r27);
            r119.getClass();
            String r30 = GestureSettingsRepository.i(r28);
        L32:
            if (r30 != null) goto L34;
            r30 = "";
        L34:
            int r120 = r22.size();
            if (r120 > 1) goto L37;
            int r31 = 0;
        L43:
            View r32 = r2.X90(r25, r30, r31, new com.larus.dora.obric.device_management.setting.earbuds.gesture.c(r2, r118));
            if (r118 == true) goto L46;
            r2.o = r32;
        L46:
            r3.addView(r32);
            r24 = r115;
            goto L24
        L37:
            if (r24 != 0) goto L40;
            r31 = 1;
            goto L43
        L40:
            if (r24 != (r120 - 1)) goto L42;
            r31 = 3;
            goto L43
        L42:
            r31 = 2;
            goto L43
        L31:
            r30 = null;
            goto L32
        L48:
            if (r2.q != 0) goto L50;
        L73:
            View r33 = new View(r2.requireContext());
            r33.setLayoutParams(new LinearLayout.LayoutParams(-1, r2.Z90(16)));
            r3.addView(r33);
            r3.addView(r2.Y90(r2.getString(2131903004)));
            List r34 = CollectionsKt.listOf(new Triple[]{new Triple(r2.getString(2131903015), GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK, Boolean.TRUE), new Triple(r2.getString(2131903016), GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK, Boolean.FALSE)});
            Iterator<T> r35 = r34.iterator();
            int r36 = 0;
        L75:
            if (r35.hasNext() == false) goto L99;
            T r121 = r35.next();
            int r122 = r36 + 1;
            if (r36 >= 0) goto L79;
            CollectionsKt.throwIndexOverflow();
        L79:
            Triple r123 = (Triple) r121;
            String r124 = (String) r123.component1();
            GestureSettingsKey r125 = (GestureSettingsKey) r123.component2();
            final boolean r126 = ((Boolean) r123.component3()).booleanValue();
            Byte r37 = r1.a.get(r125);
            if (r37 == null) goto L82;
            byte r38 = r37.byteValue();
            GestureSettingsRepository r127 = GestureSettingsRepository.a;
            Byte r40 = Byte.valueOf(r38);
            r127.getClass();
            String r41 = GestureSettingsRepository.i(r40);
        L83:
            if (r41 != null) goto L85;
            r41 = "";
        L85:
            int r128 = r34.size();
            if (r128 > 1) goto L88;
            int r42 = 0;
        L94:
            r3.addView(r2.X90(r124, r41, r42, new e(r2, r126)));
            r36 = r122;
            goto L75
        L88:
            if (r36 != 0) goto L91;
            r42 = 1;
            goto L94
        L91:
            if (r36 != (r128 - 1)) goto L93;
            r42 = 3;
            goto L94
        L93:
            r42 = 2;
            goto L94
        L82:
            r41 = null;
            goto L83
        L50:
            if (r2.i == false) goto L73;
            if (r2.p != null) goto L69;
            Window r43 = r2.requireActivity().getWindow();
            if (r43 == null) goto L61;
            View r44 = r43.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L63;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r45 = ThreadMethodProxy.currentThread();
            if (r45 == com.larus.home.impl.utils.c.a) goto L63;
            com.larus.home.impl.utils.c.a(r45, "getDecorView");
        L63:
            if ((r44 instanceof ViewGroup) == false) goto L65;
            ViewGroup r46 = (ViewGroup) r44;
        L66:
            if (r46 == null) goto L69;
            DoraGestureGuidanceMaskView r47 = new DoraGestureGuidanceMaskView(r2.requireContext(), null, 6, 0);
            boolean r48 = v19.h.a;
            r47.setDarkMode(v19.h.a(null));
            r47.setClickable(false);
            r47.setFocusable(true);
            r47.setVisibility(8);
            r2.p = r47;
            r46.addView(r47, new FrameLayout.LayoutParams(-1, -1));
            goto L69
        L65:
            r46 = null;
            goto L66
        L61:
            r44 = null;
        L69:
            OCardListItem r50 = r2.o;
            if (r50 == null) goto L72;
            r50.post(new com.larus.dora.obric.device_management.setting.earbuds.gesture.d(r2));
        L72:
            r2.q = 0;
            goto L73
        L18:
            r113 = null;
            goto L20
        L14:
            r11 = null;
            goto L15
        L96:
            throw new NoWhenBranchMatchedException();
        L99:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsGestureSettingsFragment a;

        public c(DoraObricEarbudsGestureSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            DoraObricEarbudsGestureSettingsFragment r4 = this.a;
            r4.k = r3;
            r4.ba0();
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsGestureSettingsFragment a;

        public d(DoraObricEarbudsGestureSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.dora.impl.device.settings.gesture.wakeup.h r5 = (com.larus.dora.impl.device.settings.gesture.wakeup.h) r3;
            DoraObricEarbudsGestureSettingsFragment r6 = this.a;
            int r0 = DoraObricEarbudsGestureSettingsFragment.r;
            r6.getClass();
            if (r5 == null) goto L17;
            GestureWakeupType r1 = r5.getType();
            if (r1 == null) goto L17;
            int r2 = j0.a;
            String r7 = j0.d(r1.getTitleResId());
            int r8 = r5.b;
            if (r8 != 0) goto L11;
        L13:
            OCardListItem r9 = r6.n;
            if (r9 == null) goto L17;
            int r10 = OCardListItem.I;
            r9.k(r7, -1);
            goto L17
        L11:
            if (r8 == 1) goto L13;
        L17:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "gesture_setting";
    }

    public final void onDestroyView() {
        this.g = null;
        DoraGestureGuidanceMaskView r1 = this.p;
        if (r1 == null) goto L10;
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L7;
        ViewGroup r3 = (ViewGroup) r2;
    L8:
        if (r3 == null) goto L10;
        r3.removeView(r1);
        goto L10
    L7:
        r3 = null;
    L10:
        this.p = null;
        this.o = null;
        this.h = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void ba0() {
        View r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        if (this.k == false) goto L8;
        int r1 = 0;
    L9:
        r0.setVisibility(r1);
        View r3 = this.m;
        if (r3 != null) goto L12;
        return;
    L12:
        if (this.k == true) goto L15;
        r2 = 8;
    L15:
        r3.setVisibility(r2);
        return;
    L8:
        r1 = 8;
        goto L9
    }

    public DoraObricEarbudsGestureSettingsFragment() {
        final Function0<Fragment> r0 = new DoraObricEarbudsGestureSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GestureSettingsViewModel.class), new DoraObricEarbudsGestureSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsGestureSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.h;
    }

    public final void W90(OCardListItem r7) {
        ViewGroup.LayoutParams r0 = r7.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L7:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r7.getCardContainer().setLayoutParams(r1);
    L9:
        r7.getContentContainer().setPadding(0, 0, Z90(4), 0);
        r7.getTitleContainer().setGravity(16);
        r7.getTitleContainer().setPadding(Z90(12), Z90(8), Z90(8), Z90(8));
        OTextView r2 = r7.getTitleView();
        r2.setGravity(8388611);
        r2.setMaxLines(1);
        r2.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r2.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r2, aa0(22.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r7.o(false);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final View Y90(String r8) {
        OSectionTitleBar r0 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131367728);
        if (r1 == null) goto L5;
        r1.setPadding(Z90(20), Z90(8), Z90(12), Z90(8));
    L5:
        r0.setTitleText(r8);
        r0.setTitleTextSize(12.0f);
        r0.setTitleTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        TextView r2 = (TextView) r0.findViewById(2131388792);
        if (r2 == null) goto L8;
        r2.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r2.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r2, aa0(16.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    L8:
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r0;
    }

    public final int Z90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final int aa0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        Bundle r1 = getArguments();
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.getInt("is_first");
    L6:
        this.q = r3;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L13;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L13;
        if (r5.j0() != true) goto L13;
        boolean r6 = true;
    L14:
        this.i = r6;
        if (r4 == null) goto L21;
        DeviceService r7 = r4.device();
        if (r7 == null) goto L21;
        if (r7.q0(null) != true) goto L21;
        r2 = true;
    L21:
        this.j = r2;
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new h(this), 2, null);
        Lifecycle.State r8 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r8, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r8, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r8, null, this), 3, null);
        return;
    L13:
        r6 = false;
        goto L14
    L5:
        r3 = 0;
        goto L6
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        Context r15 = requireContext();
        LinearLayout r16 = new LinearLayout(r15);
        r16.setOrientation(1);
        r16.setClipChildren(true);
        r16.setClipToPadding(true);
        r16.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        OFloatingTitleBar r0 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r0);
        r0.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r0.setCenterTitle(getString(2131902423));
        r0.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r3 = (TextView) r0.findViewById(2131365427);
        if (r3 == null) goto L5;
        r3.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r3.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r3, aa0(22.0f));
        r3.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r0.R(false);
        final View r4 = OFloatingTitleBar.k(r0, null, 6);
        r4.setOnClickListener(new f(this));
        r0.post(new g(this, r4));
        r16.addView(r0, new LinearLayout.LayoutParams(-1, -2));
        Context r1 = requireContext();
        LinearLayout r5 = new LinearLayout(r1);
        r5.setOrientation(1);
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        r5.setPadding(Z90(12), 0, Z90(12), Z90(16));
        this.g = r5;
        NestedScrollView r6 = new NestedScrollView(r1);
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        r6.setOverScrollMode(2);
        r6.setFillViewport(true);
        r6.setPadding(0, Z90(8), 0, 0);
        r6.addView(this.g, new ViewGroup.LayoutParams(-1, -2));
        r16.addView(r6, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r2 = new FrameLayout(r15);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r2.addView(r16, new FrameLayout.LayoutParams(-1, -1));
        View r17 = new View(r15);
        r17.setBackgroundColor(ContextCompat.getColor(r15, 2131103066));
        r17.setClickable(true);
        r17.setFocusable(true);
        r2.addView(r17, new FrameLayout.LayoutParams(-1, -1));
        this.h = r17;
        return r2;
    }

    public final OCardListItem X90(String r6, String r7, int r8, final Function0 r9) {
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r8);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        r0.q(false);
        r0.setDefaultCustomEndView(3);
        r0.m(true);
        r0.k(r7, -1);
        r0.setDefaultTailIcon(0);
        r0.r(true);
        W90(r0);
        r0.setOnContentClickListener(new i(r0, r9));
        return r0;
    }
}
