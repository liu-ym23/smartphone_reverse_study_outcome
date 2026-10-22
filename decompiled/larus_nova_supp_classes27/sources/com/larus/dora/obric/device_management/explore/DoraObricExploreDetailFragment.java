package com.larus.dora.obric.device_management.explore;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import com.larus.dora.impl.view.DoraQueryTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 M2\u00020\u0001:\u0003KLMB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0002J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\fH\u0002J\b\u0010+\u001a\u00020\u0013H\u0002J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\fH\u0002J\f\u0010/\u001a\u00020\u001b*\u000200H\u0002J\f\u00101\u001a\u00020\u001b*\u000202H\u0002J\f\u00103\u001a\u00020\u001b*\u000202H\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\fH\u0002J\u0010\u00105\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\fH\u0002J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010)\u001a\u00020\fH\u0002J\u0010\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\u0011H\u0002J\u0010\u0010;\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u001fH\u0002J\u0018\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>2\u0006\u00108\u001a\u000209H\u0002J\b\u0010?\u001a\u00020\u001fH\u0002J\n\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\fH\u0002J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u0005H\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0012\u0010F\u001a\u00020\u00112\b\b\u0001\u0010G\u001a\u00020\u0011H\u0002J\f\u0010H\u001a\u00020\u0011*\u00020\u0011H\u0002J\f\u0010I\u001a\u00020\u0011*\u00020JH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricExploreDetailFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "carouselIndicator", "Lcom/obric/oui/indicator/OCarouselIndicator;", "detailAdapter", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreDetailFragment$DetailPagerAdapter;", "pageInfos", "", "Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;", "productFillName", "", "targetMac", "currentPageIndex", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDoraConnectStateChanged", "isConnected", "", "getCurrentPageName", "logEnterPage", "buildContentView", "buildCarouselIndicatorContainer", "setupPager", "buildBackButton", "renderPage", "root", "Landroid/widget/FrameLayout;", "pageInfo", "buildBackgroundImage", "buildOverlay", "buildTextContent", "showActionButton", "buildDisplayTitleBar", "applyDisplayTitleBarStyle", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "applyDisplayTitleTextStyle", "Landroid/widget/TextView;", "applyDisplaySubtitleTextStyle", "buildDescription", "buildQueryContainer", "buildQueries", "buildActionButton", "buttonInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslButton;", "getButtonBottomMarginDp", "getContentBottomMarginDp", "setupButtonAction", "button", "Lcom/obric/oui/button/OButton;", "isActionDeviceConnected", "resolveActionDevice", "Lcom/bytedance/dora/device/DoraDevice;", "shouldShowActionButton", "setupCarouselIndicator", "pager", "readPageInfos", "color", "resId", "dp", "sp", "", "DetailPagerAdapter", "DetailPageHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricExploreDetailFragment extends DoraBaseFragment {
    public static final /* synthetic */ int m = 0;
    public ViewPager2 f;
    public OCarouselIndicator g;
    public c h;
    public List<c59.q> i;
    public String j;
    public String k;
    public int l;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final FrameLayout a;

        public b(FrameLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            super(r2);
            this.a = r2;
        }
    }

    public final class c extends RecyclerView.Adapter<b> {
        public final /* synthetic */ DoraObricExploreDetailFragment a;

        public final int getItemCount() {
            return this.a.i.size();
        }

        public c(DoraObricExploreDetailFragment r1) {
            this.a = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r27, int r28) {
            b r0 = (b) r27;
            Intrinsics.checkNotNullParameter(r0, "holder");
            final DoraObricExploreDetailFragment r2 = this.a;
            FrameLayout r1 = r0.a;
            c59.q r3 = (c59.q) ListProtector.get(r2.i, r28);
            r1.removeAllViews();
            SimpleDraweeView r4 = new SimpleDraweeView(r2.requireContext());
            r4.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            String r7 = null;
            c59.p.e(r4, r3.c(), MapsKt.mapOf(TuplesKt.to("product", r2.j)), null, 4);
            r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r1.addView(r4);
            View r5 = new View(r2.requireContext());
            r5.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r2.W90(2131106535), r2.W90(2131103293), r2.W90(2131103294)}));
            r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r1.addView(r5);
            c59.h r6 = r3.a();
            if (r6 != null) goto L6;
        L16:
            boolean r8 = false;
        L17:
            LinearLayout r9 = new LinearLayout(r2.requireContext());
            r9.setOrientation(1);
            r9.setGravity(1);
            FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, -2, 80);
            com.larus.utils.i0.a.getClass();
            int r14 = com.larus.utils.i0.e();
            if (r8 == false) goto L20;
            int r15 = 124;
        L21:
            r10.bottomMargin = r14 + r2.X90(r15);
            r9.setLayoutParams(r10);
            OFloatingTitleBar r11 = new OFloatingTitleBar(r2.requireContext(), null, 6, 0);
            r11.setTitleType(0);
            r11.R(false);
            c59.t r16 = r3.e();
            if (r16 == null) goto L24;
            String r17 = c59.p.b(r16);
        L26:
            if (r17 != null) goto L28;
            r17 = "";
        L28:
            r11.setCenterTitle(r17);
            r11.setCenterTitleColor(r2.W90(2131105312));
            List<c59.t> r12 = r3.b();
            if (r12 == null) goto L48;
            ArrayList r13 = new ArrayList();
            Iterator<T> r18 = r12.iterator();
        L32:
            if (r18.hasNext() == false) goto L47;
            Object r110 = r18.next();
            c59.t r111 = (c59.t) r110;
            if (r111 == null) goto L36;
            String r112 = c59.p.b(r111);
        L37:
            if (r112 != null) goto L39;
        L42:
            boolean r113 = true;
        L44:
            if ((!r113) == false) goto L32;
            r13.add(r110);
            goto L32
        L39:
            if (r112.length() == 0) goto L42;
            r113 = false;
            goto L44
        L36:
            r112 = null;
            goto L37
        L47:
            String r20 = CollectionsKt.joinToString$default(r13, "\n", null, null, 0, null, new com.larus.dora.obric.device_management.explore.c(), 30, null);
        L49:
            if (r20 != null) goto L51;
            r20 = "";
        L51:
            r11.setCenterSubtitle(r20);
            r11.setCenterSubTitleColor(r2.W90(2131105316));
            FrameLayout r114 = (FrameLayout) r11.findViewById(2131388812);
            if (r114 == null) goto L54;
            r114.setMinimumHeight(0);
            r114.setPadding(r2.X90(24), r2.X90(24), r2.X90(24), r2.X90(24));
        L54:
            LinearLayout r21 = (LinearLayout) r11.findViewById(2131365428);
            if (r21 == null) goto L57;
            r21.setGravity(1);
        L57:
            OTextView r22 = r11.getCenterTitleView();
            r22.setTextAppearance(2131953760);
            r22.setTextColor(r2.W90(2131105312));
            r22.setGravity(17);
            r22.setMaxLines(Integer.MAX_VALUE);
            r22.setEllipsize(null);
            Resources r115 = r2.getResources();
            TextViewCompat.setLineHeight(r22, (int) ((32.0f * WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).scaledDensity) + 0.5f));
            ViewGroup.LayoutParams r116 = r22.getLayoutParams();
            if (r116 == null) goto L107;
            LinearLayout.LayoutParams r117 = (LinearLayout.LayoutParams) r116;
            r117.topMargin = 0;
            r22.setLayoutParams(r117);
            OTextView r23 = r11.getCenterSubtitleView();
            r23.setTextAppearance(2131953509);
            r23.setTextColor(r2.W90(2131105316));
            r23.setGravity(8388611);
            r23.setMaxLines(Integer.MAX_VALUE);
            r23.setEllipsize(null);
            Resources r24 = r2.getResources();
            TextViewCompat.setLineHeight(r23, (int) ((21.0f * WindowDisplayMetricsOverride.apply(r24, r24.getDisplayMetrics()).scaledDensity) + 0.5f));
            ViewGroup.LayoutParams r25 = r23.getLayoutParams();
            if (r25 == null) goto L105;
            LinearLayout.LayoutParams r26 = (LinearLayout.LayoutParams) r25;
            r26.topMargin = r2.X90(4);
            r23.setLayoutParams(r26);
            r9.addView(r11);
            LinearLayout r30 = new LinearLayout(r2.requireContext());
            r30.setOrientation(1);
            r30.setGravity(1);
            r30.setPadding(r2.X90(32), 0, r2.X90(32), 0);
            List<c59.t> r31 = r3.d();
            if (r31 != null) goto L64;
            r31 = CollectionsKt.emptyList();
        L64:
            ArrayList r32 = new ArrayList();
            Iterator<T> r33 = r31.iterator();
        L66:
            if (r33.hasNext() == false) goto L80;
            c59.t r118 = (c59.t) r33.next();
            if (r118 == null) goto L77;
            String r119 = c59.p.b(r118);
            if (r119 == null) goto L77;
            if (r119.length() <= 0) goto L74;
            boolean r120 = true;
        L75:
            if (r120 == false) goto L77;
        L78:
            if (r119 == null) goto L66;
            r32.add(r119);
            goto L66
        L74:
            r120 = false;
        L77:
            r119 = null;
            goto L78
        L80:
            ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
            Iterator r121 = r32.iterator();
            int r122 = 0;
        L82:
            if (r121.hasNext() == false) goto L90;
            Object r123 = r121.next();
            int r124 = r122 + 1;
            if (r122 >= 0) goto L86;
            CollectionsKt.throwIndexOverflow();
        L86:
            Iterator r125 = r121;
            DoraQueryTextView r126 = new DoraQueryTextView(r2.requireContext(), null, 6, 0);
            r126.setPadding(0, 0, 0, 0);
            r126.setText((String) r123);
            r126.setTextColor(r2.W90(2131104815));
            r126.setTextSize(16);
            r126.setTextFontWeight(500);
            r126.setStartImage(2131240593);
            r126.b(r2.X90(16), r2.X90(16));
            r126.setImageVisible(true);
            LinearLayout.LayoutParams r127 = new LinearLayout.LayoutParams(-2, -2);
            r127.gravity = 1;
            if (r122 == CollectionsKt.getLastIndex(r32)) goto L89;
            r127.bottomMargin = r2.X90(8);
        L89:
            r126.setLayoutParams(r127);
            r34.add(r126);
            r122 = r124;
            r121 = r125;
            goto L82
        L90:
            Iterator r35 = r34.iterator();
        L92:
            if (r35.hasNext() == false) goto L94;
            r30.addView((View) r35.next());
            goto L92
        L94:
            r30.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            r9.addView(r30);
            r1.addView(r9);
            final c59.h r36 = r3.a();
            if (r8 == false) goto L120;
            if (r36 == null) goto L121;
            View r37 = vma.e.a(r2.requireContext(), 2131952832, new com.larus.dora.obric.device_management.explore.d());
            OButton r38 = (OButton) r37;
            c59.t r40 = r36.b();
            if (r40 == null) goto L100;
            r7 = c59.p.b(r40);
        L100:
            if (r7 != null) goto L102;
            r7 = "";
        L102:
            r38.setText(r7);
            r38.setAllCaps(false);
            com.larus.utils.e1.d(r38, new e(r36, r2));
            FrameLayout.LayoutParams r41 = new FrameLayout.LayoutParams(-1, r2.X90(48), 80);
            r41.setMarginStart(r2.X90(24));
            r41.setMarginEnd(r2.X90(24));
            com.larus.utils.i0.a.getClass();
            r41.bottomMargin = com.larus.utils.i0.e() + r2.X90(60);
            r38.setLayoutParams(r41);
            r1.addView(r37);
            return;
        L121:
            return;
        L120:
            return;
        L105:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        L107:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        L48:
            r20 = null;
            goto L49
        L24:
            r17 = null;
            goto L26
        L20:
            r15 = 64;
            goto L21
        L6:
            if (Intrinsics.areEqual(r6.c(), Boolean.TRUE) == true) goto L16;
            DoraDevice r42 = r2.Y90();
            if (r42 != null) goto L11;
        L13:
            boolean r43 = false;
        L14:
            if (r43 == false) goto L16;
            r8 = true;
            goto L17
        L11:
            if (kj4.a.g().getDoraLinkState(r42) != 2) goto L13;
            r43 = true;
            goto L14
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            FrameLayout r4 = new FrameLayout(r2.getContext());
            r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new b(r4);
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DslActionType.values().length];
            r0[DslActionType.INTERNAL_JUMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public final String k() {
        return "dora_feature_introduction_detail";
    }

    public final DoraDevice Y90() {
        String r0 = this.k;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L20;
        Iterator r2 = DoraAdapterExtKt.k(kj4.a.g()).iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((DoraDevice) r3).mac, r0) == false) goto L12;
    L18:
        return (DoraDevice) r3;
    L16:
        r3 = null;
        goto L18
    L20:
        return DoraAdapterExtKt.h(kj4.a.g());
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public DoraObricExploreDetailFragment() {
        this.i = CollectionsKt.emptyList();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void T90() {
        Bundle r0 = getArguments();
        String r2 = null;
        if (r0 == null) goto L5;
        String r1 = r0.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
    L6:
        String r3 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        Bundle r4 = getArguments();
        if (r4 == null) goto L12;
        r2 = r4.getString("current_page");
    L12:
        if (r2 == null) goto L16;
        r3 = r2;
    L16:
        if (r3.length() != 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        r3 = "dora_feature_introduction_detail";
    L21:
        DoraBuryPointManager.a.L("enter_page", MapsKt.mapOf(new Pair[]{TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r1), TuplesKt.to("current_page", r3), TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON)}));
        return;
    L18:
        r5 = false;
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        c r2 = this.h;
        if (r2 == null) goto L6;
        r2.notifyDataSetChanged();
        return;
    }

    public final int W90(int r2) {
        return ContextCompat.getColor(requireContext(), r2);
    }

    public final int X90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        if (this.i.isEmpty() == false) goto L7;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L15;
        r4.finish();
        return;
    L15:
        return;
    L7:
        ViewPager2 r5 = this.f;
        if (r5 == null) goto L17;
        c r6 = new c(this);
        this.h = r6;
        r5.setAdapter(r6);
        r5.setOffscreenPageLimit(1);
        r5.setCurrentItem(this.l, false);
        OCarouselIndicator r7 = this.g;
        if (r7 == null) goto L13;
        r7.l(r5, this.i.size());
    L13:
        r5.registerOnPageChangeCallback(new DoraObricExploreDetailFragment$setupPager$1(this));
        return;
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Bundle r9 = getArguments();
        String r10 = null;
        if (r9 == null) goto L5;
        String r11 = r9.getString("arg_page_infos");
    L6:
        List<c59.q> r12 = (List) c59.s.a(r11, new f());
        if (r12 != null) goto L9;
        r12 = CollectionsKt.emptyList();
    L9:
        this.i = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L12;
        String r14 = r13.getString("arg_product_fill_name");
    L13:
        this.j = r14;
        Bundle r15 = getArguments();
        if (r15 == null) goto L16;
        r10 = r15.getString("mac");
    L16:
        this.k = r10;
        Bundle r16 = getArguments();
        if (r16 == null) goto L19;
        int r17 = r16.getInt("arg_initial_index");
    L20:
        this.l = RangesKt.coerceIn(r17, 0, RangesKt.coerceAtLeast(CollectionsKt.getLastIndex(this.i), 0));
        FrameLayout r18 = new FrameLayout(requireContext());
        r18.setBackgroundColor(W90(2131103292));
        r18.setClipChildren(false);
        r18.setClipToPadding(false);
        ViewPager2 r20 = new ViewPager2(r18.getContext());
        r20.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f = r20;
        r18.addView(r20);
        FrameLayout r21 = new FrameLayout(requireContext());
        View r0 = LayoutInflater.from(r21.getContext()).inflate(2131562235, r21, false);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.oui.indicator.OCarouselIndicator");
        OCarouselIndicator r1 = (OCarouselIndicator) r0;
        r1.setDotsClickable(false);
        r1.setMaxVisibleDots(5);
        r1.setVisibility(8);
        r1.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        this.g = r1;
        r21.addView(r1);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, X90(48), 81);
        com.larus.utils.i0.a.getClass();
        r2.bottomMargin = com.larus.utils.i0.e();
        r21.setLayoutParams(r2);
        r18.addView(r21);
        View r22 = vma.e.a(requireContext(), 2131952921, new com.larus.dora.obric.device_management.explore.a());
        OIconButtonFloating r3 = (OIconButtonFloating) r22;
        r3.setIcon(2131244126);
        r3.setOnClickListener(new com.larus.dora.obric.device_management.explore.b(this));
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2, 8388659);
        r4.setMarginStart(X90(12));
        r4.topMargin = com.larus.utils.i0.g() + X90(8);
        r3.setLayoutParams(r4);
        r18.addView(r22);
        return r18;
    L19:
        r17 = 0;
        goto L20
    L12:
        r14 = null;
        goto L13
    L5:
        r11 = null;
        goto L6
    }
}
