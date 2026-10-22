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
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.view.DoraQueryTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 V2\u00020\u0001:\u0003TUVB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u0014H\u0002J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u000eH\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u000eH\u0002J\f\u00101\u001a\u00020\u001c*\u000202H\u0002J\f\u00103\u001a\u00020\u001c*\u000204H\u0002J\f\u00105\u001a\u00020\u001c*\u000204H\u0002J\u0010\u00106\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0018\u00109\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020!H\u0002J\b\u0010;\u001a\u00020\u0012H\u0002J\b\u0010<\u001a\u00020\u0012H\u0002J\u0018\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0018\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DH\u0002J\u0018\u0010F\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010G\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010H\u001a\u00020!H\u0002J\n\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0010\u0010K\u001a\u00020!2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u0005H\u0002J\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0012\u0010O\u001a\u00020\u00122\b\b\u0001\u0010P\u001a\u00020\u0012H\u0002J\f\u0010Q\u001a\u00020\u0012*\u00020\u0012H\u0002J\f\u0010R\u001a\u00020\u0012*\u00020SH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreDetailFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "carouselIndicator", "Lcom/obric/oui/indicator/OCarouselIndicator;", "detailAdapter", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreDetailFragment$DetailPagerAdapter;", "pageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "pageInfos", "", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesIntroductionPageInfo;", "targetMac", "", "currentPageIndex", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDoraConnectStateChanged", "isConnected", "", "getCurrentPageName", "logEnterPage", "onDestroyView", "buildContentView", "buildCarouselIndicatorContainer", "setupPager", "buildBackButton", "renderPage", "root", "Landroid/widget/FrameLayout;", "pageInfo", "buildBackgroundImage", "buildOverlay", "buildTextContent", "buildDisplayTitleBar", "applyDisplayTitleBarStyle", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "applyDisplayTitleTextStyle", "Landroid/widget/TextView;", "applyDisplaySubtitleTextStyle", "buildDescription", "buildQueryContainer", "buildQueries", "buildActionButton", "isVisible", "getButtonBottomMarginDp", "getContentBottomMarginDp", "setupButtonAction", "button", "Lcom/obric/oui/button/OButton;", "reportActionButtonClick", "openOnboardingAction", "url", "buttonInfo", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesIntroductionButton;", "resolveActionButtonText", "appendActionQuery", "isActionEnabled", "isActionDeviceConnected", "resolveActionDevice", "Lcom/bytedance/dora/device/DoraDevice;", "shouldShowActionButton", "setupCarouselIndicator", "pager", "readPageInfos", "color", "resId", "dp", "sp", "", "DetailPagerAdapter", "DetailPageHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGlassesExploreDetailFragment extends DoraBaseFragment {
    public static final /* synthetic */ int m = 0;
    public ViewPager2 f;
    public OCarouselIndicator g;
    public c h;
    public DoraObricGlassesExploreDetailFragment$setupPager$1 i;
    public List<a1> j;
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
        public final /* synthetic */ DoraObricGlassesExploreDetailFragment a;

        public final int getItemCount() {
            return this.a.j.size();
        }

        public c(DoraObricGlassesExploreDetailFragment r1) {
            this.a = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r27, int r28) {
            b r0 = (b) r27;
            Intrinsics.checkNotNullParameter(r0, "holder");
            final DoraObricGlassesExploreDetailFragment r2 = this.a;
            FrameLayout r1 = r0.a;
            final a1 r3 = (a1) ListProtector.get(r2.j, r28);
            r1.removeAllViews();
            SimpleDraweeView r4 = new SimpleDraweeView(r2.requireContext());
            r4.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            z0 r5 = r3.b;
            String r6 = null;
            if (r5 == null) goto L5;
            String r7 = r5.a;
        L6:
            int r8 = 0;
            if (r5 == null) goto L9;
            int r9 = r5.b;
        L11:
            if (r7 != null) goto L13;
        L16:
            boolean r10 = true;
        L17:
            if (r10 == true) goto L19;
            ImageLoaderKt.u(r4, r7, "dora_obric_glasses_explore_detail");
        L21:
            r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r1.addView(r4);
            View r11 = new View(r2.requireContext());
            r11.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r2.W90(2131106535), r2.W90(2131103293), r2.W90(2131103294)}));
            r11.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r1.addView(r11);
            y0 r12 = r3.e;
            if (r12 == null) goto L41;
            String r13 = r12.c;
            if (r13 != null) goto L27;
        L30:
            boolean r14 = true;
        L31:
            if (r14 == true) goto L41;
            DoraDevice r15 = r2.Y90();
            if (r15 != null) goto L36;
        L38:
            boolean r16 = false;
        L39:
            if (r16 == false) goto L41;
            boolean r17 = true;
        L42:
            LinearLayout r18 = new LinearLayout(r2.requireContext());
            r18.setOrientation(1);
            r18.setGravity(1);
            FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-1, -2, 80);
            com.larus.utils.i0.a.getClass();
            r110.bottomMargin = com.larus.utils.i0.e() + r2.X90(132);
            r18.setLayoutParams(r110);
            View r111 = new OFloatingTitleBar(r2.requireContext(), null, 6, 0);
            r111.setTitleType(0);
            r111.R(false);
            String r112 = r3.a;
            if (r112 != null) goto L45;
            r112 = "";
        L45:
            r111.setCenterTitle(r112);
            r111.setCenterTitleColor(r2.W90(2131105312));
            List<String> r113 = r3.c;
            if (r113 == null) goto L58;
            ArrayList r114 = new ArrayList();
            Iterator<T> r115 = r113.iterator();
        L49:
            if (r115.hasNext() == false) goto L57;
            Object r20 = r115.next();
            if (((String) r20).length() <= 0) goto L53;
            boolean r116 = true;
        L54:
            if (r116 == false) goto L49;
            r114.add(r20);
            goto L49
        L53:
            r116 = false;
            goto L54
        L57:
            String r21 = CollectionsKt.joinToString$default(r114, "\n", null, null, 0, null, null, 62, null);
        L59:
            if (r21 != null) goto L61;
            r21 = "";
        L61:
            r111.setCenterSubtitle(r21);
            r111.setCenterSubTitleColor(r2.W90(2131105316));
            OTextView r117 = r111.getCenterTitleView();
            r117.setTextAppearance(2131953760);
            r117.setTextColor(r2.W90(2131105312));
            r117.setGravity(17);
            r117.setMaxLines(Integer.MAX_VALUE);
            r117.setEllipsize(null);
            Resources r118 = r2.getResources();
            TextViewCompat.setLineHeight(r117, (int) ((32.0f * WindowDisplayMetricsOverride.apply(r118, r118.getDisplayMetrics()).scaledDensity) + 0.5f));
            ViewGroup.LayoutParams r119 = r117.getLayoutParams();
            if (r119 == null) goto L141;
            LinearLayout.LayoutParams r120 = (LinearLayout.LayoutParams) r119;
            r120.topMargin = 0;
            r117.setLayoutParams(r120);
            OTextView r121 = r111.getCenterSubtitleView();
            r121.setTextAppearance(2131953509);
            r121.setTextColor(r2.W90(2131105316));
            r121.setGravity(8388611);
            r121.setMaxLines(Integer.MAX_VALUE);
            r121.setEllipsize(null);
            Resources r22 = r2.getResources();
            TextViewCompat.setLineHeight(r121, (int) ((21.0f * WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics()).scaledDensity) + 0.5f));
            ViewGroup.LayoutParams r23 = r121.getLayoutParams();
            if (r23 == null) goto L139;
            LinearLayout.LayoutParams r24 = (LinearLayout.LayoutParams) r23;
            r24.topMargin = r2.X90(8);
            r121.setLayoutParams(r24);
            r18.addView(r111);
            LinearLayout r25 = new LinearLayout(r2.requireContext());
            r25.setOrientation(1);
            r25.setGravity(1);
            r25.setPadding(r2.X90(32), 0, r2.X90(32), 0);
            List<String> r122 = r3.d;
            if (r122 != null) goto L68;
            r122 = CollectionsKt.emptyList();
        L68:
            ArrayList r123 = new ArrayList();
            Iterator<T> r124 = r122.iterator();
        L70:
            if (r124.hasNext() == false) goto L80;
            String r125 = (String) r124.next();
            if (r125.length() <= 0) goto L74;
            boolean r126 = true;
        L75:
            if (r126 == true) goto L78;
            r125 = null;
        L78:
            if (r125 == null) goto L70;
            r123.add(r125);
            goto L70
        L74:
            r126 = false;
            goto L75
        L80:
            ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
            Iterator r128 = r123.iterator();
            int r129 = 0;
        L82:
            if (r128.hasNext() == false) goto L91;
            Object r130 = r128.next();
            int r131 = r129 + 1;
            if (r129 >= 0) goto L86;
            CollectionsKt.throwIndexOverflow();
        L86:
            DoraQueryTextView r132 = new DoraQueryTextView(r2.requireContext(), null, 6, 0);
            r132.setPadding(0, 0, 0, 0);
            r132.setText((String) r130);
            r132.setTextColor(r2.W90(2131104815));
            r132.setTextSize(16);
            r132.setTextFontWeight(500);
            r132.setStartImage(2131240593);
            r132.b(r2.X90(16), r2.X90(16));
            r132.setImageVisible(true);
            LinearLayout.LayoutParams r133 = new LinearLayout.LayoutParams(-2, -2);
            r133.gravity = 1;
            if (r129 == CollectionsKt.getLastIndex(r123)) goto L90;
            r133.bottomMargin = r2.X90(8);
        L90:
            r132.setLayoutParams(r133);
            r127.add(r132);
            r129 = r131;
            goto L82
        L91:
            Iterator r26 = r127.iterator();
        L93:
            if (r26.hasNext() == false) goto L95;
            r25.addView((View) r26.next());
            goto L93
        L95:
            LinearLayout.LayoutParams r30 = new LinearLayout.LayoutParams(-1, -2);
            r30.topMargin = r2.X90(24);
            r25.setLayoutParams(r30);
            r18.addView(r25);
            r1.addView(r18);
            y0 r31 = r3.e;
            View r32 = vma.e.a(r2.requireContext(), 2131952832, new d0());
            OButton r33 = (OButton) r32;
            if (r31 == null) goto L126;
            IDoraService r134 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r134 == null) goto L114;
            DoraObricGlassesExploreActionStateType r135 = r31.e;
            if (r135 != null) goto L103;
            int r136 = -1;
        L105:
            if (r136 == (-1)) goto L114;
            if (r136 != 1) goto L109;
            boolean r137 = r134.device().f0();
        L115:
            if (r137 == false) goto L123;
            String r138 = r31.b;
            if (r138 == null) goto L123;
            if ((!StringsKt.isBlank(r138)) == false) goto L121;
            r6 = r138;
        L121:
            if (r6 != null) goto L126;
        L123:
            r6 = r31.a;
            if (r6 != null) goto L126;
            r6 = "";
            goto L126
        L109:
            if (r136 != 2) goto L112;
            r137 = r134.g1().b();
            goto L115
        L112:
            throw new NoWhenBranchMatchedException();
        L103:
            r136 = d.a[r135.ordinal()];
        L114:
            r137 = false;
        L126:
            if (r6 != null) goto L128;
            r6 = "";
        L128:
            r33.setText(r6);
            r33.setAllCaps(false);
            if (r17 == true) goto L132;
            r8 = 4;
        L132:
            r33.setVisibility(r8);
            r33.setEnabled(r17);
            r33.setClickable(r17);
            if (r17 == false) goto L136;
            if (r31 == null) goto L136;
            com.larus.utils.e1.d(r33, new g0(r2, r3));
        L136:
            FrameLayout.LayoutParams r34 = new FrameLayout.LayoutParams(-1, r2.X90(48), 80);
            r34.setMarginStart(r2.X90(24));
            r34.setMarginEnd(r2.X90(24));
            com.larus.utils.i0.a.getClass();
            r34.bottomMargin = com.larus.utils.i0.e() + r2.X90(60);
            r33.setLayoutParams(r34);
            r1.addView(r32);
            return;
        L139:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        L141:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        L58:
            r21 = null;
            goto L59
        L36:
            if (kj4.a.g().getDoraLinkState(r15) != 2) goto L38;
            r16 = true;
            goto L39
        L27:
            if (StringsKt.isBlank(r13) == true) goto L30;
            r14 = false;
        L41:
            r17 = false;
            goto L42
        L19:
            if (r9 == 0) goto L21;
            r4.setActualImageResource(r9);
            goto L21
        L13:
            if (StringsKt.isBlank(r7) == true) goto L16;
            r10 = false;
            goto L17
        L9:
            r9 = 0;
            goto L11
        L5:
            r7 = null;
            goto L6
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
            int[] r0 = new int[DoraObricGlassesExploreActionStateType.values().length];
            r0[DoraObricGlassesExploreActionStateType.NATURAL_WAKE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DoraObricGlassesExploreActionStateType.DIARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final String k() {
        return "dora_glasses_feature_introduction_detail";
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

    public final void onDestroyView() {
        DoraObricGlassesExploreDetailFragment$setupPager$1 r0 = this.i;
        ViewPager2 r1 = this.f;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        r1.unregisterOnPageChangeCallback(r0);
    L6:
        this.i = null;
        ViewPager2 r2 = this.f;
        if (r2 == null) goto L9;
        r2.setAdapter(null);
    L9:
        this.h = null;
        this.g = null;
        this.f = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricGlassesExploreDetailFragment() {
        this.j = CollectionsKt.emptyList();
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
        r3 = "dora_glasses_feature_introduction_detail";
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

    public final void onResume() {
        super.onResume();
        c r0 = this.h;
        if (r0 == null) goto L10;
        int r1 = r0.getItemCount();
        if (r1 <= 0) goto L11;
        c r2 = this.h;
        if (r2 == null) goto L12;
        r2.notifyItemRangeChanged(0, r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r3) {
        super.V90(r3);
        c r4 = this.h;
        if (r4 == null) goto L10;
        int r5 = r4.getItemCount();
        if (r5 <= 0) goto L11;
        c r0 = this.h;
        if (r0 == null) goto L12;
        r0.notifyItemRangeChanged(0, r5);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final int W90(int r2) {
        return ContextCompat.getColor(requireContext(), r2);
    }

    public final int X90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreDetailFragment$setupPager$1] */
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        if (this.j.isEmpty() == false) goto L7;
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
        r5.setOffscreenPageLimit(2);
        r5.setCurrentItem(this.l, false);
        OCarouselIndicator r7 = this.g;
        if (r7 == null) goto L13;
        r7.l(r5, this.j.size());
    L13:
        ?? r8 = new DoraObricGlassesExploreDetailFragment$setupPager$1(this);
        r5.registerOnPageChangeCallback(r8);
        this.i = r8;
        return;
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Bundle r9 = getArguments();
        String r10 = null;
        if (r9 == null) goto L5;
        String r11 = r9.getString("arg_page_infos");
    L6:
        i0 r12 = new i0();
        s0 r0 = s0.a;
        Type r13 = r12.getType();
        r0.getClass();
        List<a1> r14 = (List) s0.a(r11, r13);
        if (r14 != null) goto L9;
        r14 = CollectionsKt.emptyList();
    L9:
        this.j = r14;
        Bundle r15 = getArguments();
        if (r15 == null) goto L12;
        r10 = r15.getString("mac");
    L12:
        this.k = r10;
        Bundle r16 = getArguments();
        if (r16 == null) goto L15;
        int r17 = r16.getInt("arg_initial_index");
    L16:
        this.l = RangesKt.coerceIn(r17, 0, RangesKt.coerceAtLeast(CollectionsKt.getLastIndex(this.j), 0));
        FrameLayout r18 = new FrameLayout(requireContext());
        r18.setBackgroundColor(W90(2131103292));
        r18.setClipChildren(false);
        r18.setClipToPadding(false);
        ViewPager2 r20 = new ViewPager2(r18.getContext());
        r20.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f = r20;
        r18.addView(r20);
        FrameLayout r21 = new FrameLayout(requireContext());
        View r1 = LayoutInflater.from(r21.getContext()).inflate(2131562235, r21, false);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.indicator.OCarouselIndicator");
        OCarouselIndicator r2 = (OCarouselIndicator) r1;
        r2.setDotsClickable(false);
        r2.setMaxVisibleDots(5);
        r2.setVisibility(8);
        r2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        this.g = r2;
        r21.addView(r2);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, X90(48), 81);
        com.larus.utils.i0.a.getClass();
        r3.bottomMargin = com.larus.utils.i0.e();
        r21.setLayoutParams(r3);
        r18.addView(r21);
        View r22 = vma.e.a(requireContext(), 2131952921, new e0());
        OIconButtonFloating r4 = (OIconButtonFloating) r22;
        r4.setIcon(2131244126);
        r4.setOnClickListener(new f0(this));
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2, 8388659);
        r5.setMarginStart(X90(12));
        r5.topMargin = com.larus.utils.i0.g() + X90(8);
        r4.setLayoutParams(r5);
        r18.addView(r22);
        return r18;
    L15:
        r17 = 0;
        goto L16
    L5:
        r11 = null;
        goto L6
    }
}
