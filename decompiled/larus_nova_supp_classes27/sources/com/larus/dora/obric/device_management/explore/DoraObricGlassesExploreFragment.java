package com.larus.dora.obric.device_management.explore;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 s2\u00020\u0001:\u0002rsB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0011H\u0002J6\u0010+\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\r2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u00104\u001a\u00020.H\u0002J\u0018\u00105\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u00104\u001a\u00020.H\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\rH\u0002J\u0016\u00109\u001a\u00020\u00132\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0-H\u0002J,\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020CH\u0002J \u0010D\u001a\u00020\u00132\u0006\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020@2\u0006\u0010E\u001a\u00020FH\u0002J \u0010G\u001a\u00020\u00132\u0006\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020@2\u0006\u0010E\u001a\u00020FH\u0002J\u001a\u0010H\u001a\u00020I2\b\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u001fH\u0002J \u0010L\u001a\u00020=2\u0006\u0010>\u001a\u00020M2\u0006\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000fH\u0002J\b\u0010P\u001a\u00020\u0013H\u0002J\u0010\u0010Q\u001a\u00020\u00132\u0006\u0010>\u001a\u00020MH\u0002J\u0010\u0010R\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u001fH\u0002J\u0010\u0010T\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020;H\u0002J\u0010\u0010U\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020;H\u0002J\u0014\u0010V\u001a\u00020\u001b2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010MH\u0002J\u0010\u0010W\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020YH\u0002J\u0012\u0010Z\u001a\u00020\u001b2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\u0018\u0010]\u001a\u00020!2\u0006\u0010^\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\\H\u0002J\n\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0010\u0010a\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020MH\u0002J\u0018\u0010b\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010c\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020;H\u0002J\u0010\u0010d\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020MH\u0002J\f\u0010e\u001a\u00020\u001b*\u00020=H\u0002J\f\u0010f\u001a\u00020\u001b*\u00020=H\u0002J\u0014\u0010g\u001a\u00020\u001b*\u00020=2\u0006\u0010E\u001a\u00020FH\u0002J\f\u0010h\u001a\u00020\u001b*\u00020=H\u0002J\u0018\u0010i\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000fH\u0002J\u0010\u0010j\u001a\u00020\u00132\u0006\u0010k\u001a\u00020\u000fH\u0002J\b\u0010l\u001a\u00020\u000fH\u0002J\b\u0010m\u001a\u00020\u000fH\u0002J\b\u0010n\u001a\u00020\u000fH\u0002J\b\u0010o\u001a\u00020\u000fH\u0002J\u0012\u0010p\u001a\u00020\u000f2\b\b\u0001\u0010q\u001a\u00020\u000fH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "scrollView", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "contentContainer", "Landroid/widget/LinearLayout;", "renderGeneration", "", "lastRenderedState", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreUiState;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "autoLogEnterPage", "", "buildContentView", "buildTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "buildScrollView", "updateContentTopPadding", "insetTop", "observeState", "renderState", "state", "renderSectionsIncrementally", "sections", "", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreSection;", "generation", "sectionIndex", "renderStartTime", "", "renderFeatureSection", "section", "renderBasicSection", "buildSectionTitle", "title", "buildBasicSectionContainer", "buildCompactCardRow", "rowItems", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreItem;", "buildFeatureCard", "Lcom/obric/oui/lisitem/OCardListItem;", "item", "style", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreFragment$FeatureCardStyle;", "width", "weight", "", "buildCardImage", "onClickListener", "Landroid/view/View$OnClickListener;", "buildCardTextItem", "buildFeatureCardTitleView", "Landroidx/appcompat/widget/AppCompatTextView;", "buildFeatureCardSubtitleView", "description", "buildBasicItem", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicItem;", "index", "lastIndex", "buildBasicItemDivider", "buildBasicItemIcon", "resolveBasicItemIconRes", "itemKey", "openDetail", "openIntroductionDetail", "openBasicDetail", "applyDetailEnterAnim", "context", "Landroid/content/Context;", "openBasicAction", "action", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreAction;", "openOnboardingAction", "url", "resolveActionDevice", "Lcom/bytedance/dora/device/DoraDevice;", "openBasicItem", "appendActionQuery", "reportFeatureCardClick", "reportBasicItemClick", "applyExploreCardStyle", "applyBasicItemStyle", "bindFeatureCardClick", "resetCardContainerMargins", "resolveBasicCardPosition", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolveFeatureCardBackgroundColor", "resolveBasicItemDividerColor", "resolveBasicSectionBackgroundColor", "color", "resId", "FeatureCardStyle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGlassesExploreFragment extends DoraBaseFragment {
    public static final /* synthetic */ int k = 0;
    public final Lazy f;
    public ONestedScrollView g;
    public LinearLayout h;
    public int i;
    public w0 j;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BA\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fj\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreFragment$FeatureCardStyle;", "", "heightDp", "", "imageHeightDp", "showSubtitle", "", "titleMaxLines", "titleTextSizeSp", "", "textTopPaddingDp", "textBottomPaddingDp", "<init>", "(Ljava/lang/String;IIIZIFII)V", "getHeightDp", "()I", "getImageHeightDp", "getShowSubtitle", "()Z", "getTitleMaxLines", "getTitleTextSizeSp", "()F", "getTextTopPaddingDp", "getTextBottomPaddingDp", "HERO", "COMPACT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeatureCardStyle extends Enum<FeatureCardStyle> {
        public static final FeatureCardStyle COMPACT = null;
        public static final FeatureCardStyle HERO = null;
        public static final /* synthetic */ FeatureCardStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int heightDp;
        private final int imageHeightDp;
        private final boolean showSubtitle;
        private final int textBottomPaddingDp;
        private final int textTopPaddingDp;
        private final int titleMaxLines;
        private final float titleTextSizeSp;

        public static EnumEntries<FeatureCardStyle> getEntries() {
            return b;
        }

        static {
            FeatureCardStyle r9 = new FeatureCardStyle("HERO", 0, 252, 180, true, 1, 16, 16);
            HERO = r9;
            FeatureCardStyle r0 = new FeatureCardStyle("COMPACT", 1, 189, 135, false, 2, 8, 8);
            COMPACT = r0;
            FeatureCardStyle[] r1 = {r9, r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public static FeatureCardStyle[] values() {
            return (FeatureCardStyle[]) a.clone();
        }

        public final int getHeightDp() {
            return this.heightDp;
        }

        public final int getImageHeightDp() {
            return this.imageHeightDp;
        }

        public final boolean getShowSubtitle() {
            return this.showSubtitle;
        }

        public final int getTextBottomPaddingDp() {
            return this.textBottomPaddingDp;
        }

        public final int getTextTopPaddingDp() {
            return this.textTopPaddingDp;
        }

        public final int getTitleMaxLines() {
            return this.titleMaxLines;
        }

        public final float getTitleTextSizeSp() {
            return this.titleTextSizeSp;
        }

        public static FeatureCardStyle valueOf(String r1) {
            return (FeatureCardStyle) r27.a.a(FeatureCardStyle.class, r1);
        }

        public FeatureCardStyle(String r1, int r2, int r3, int r4, boolean r5, int r6, int r7, int r8) {
            super(r1, r2);
            this.heightDp = r3;
            this.imageHeightDp = r4;
            this.showSubtitle = r5;
            this.titleMaxLines = r6;
            this.titleTextSizeSp = 16.0f;
            this.textTopPaddingDp = r7;
            this.textBottomPaddingDp = r8;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DoraObricGlassesExploreSectionType.values().length];
            r0[DoraObricGlassesExploreSectionType.BASIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L4:
            a = r0;
            int[] r1 = new int[DoraObricGlassesExploreDetailType.values().length];
            r1[DoraObricGlassesExploreDetailType.INTRODUCTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L12:
            r1[DoraObricGlassesExploreDetailType.BASIC_LIST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L7:
            b = r1;
        }
    }

    static {
    }

    public final String k() {
        return "explore_home";
    }

    public final DoraObricGlassesExploreViewModel X90() {
        return (DoraObricGlassesExploreViewModel) this.f.getValue();
    }

    public final void onDestroyView() {
        this.i++;
        this.j = null;
        this.g = null;
        this.h = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricGlassesExploreFragment() {
        final Function0<Fragment> r0 = new DoraObricGlassesExploreFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricGlassesExploreViewModel.class), new DoraObricGlassesExploreFragment$special$$inlined$viewModels$default$2(r0), new DoraObricGlassesExploreFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final boolean S90() {
        Bundle r0 = getArguments();
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.getBoolean("embedded_device_home") != true) goto L8;
        r1 = true;
    L8:
        return !r1;
    }

    public final DoraDevice ba0() {
        String r0 = ((w0) X90().getState().getValue()).b;
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

    public final void Y90(y r7) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.router.i r1 = SmartRouter.buildRoute(r0, "//flow/dora/obric_glasses_explore_detail");
        r1.c.putExtra("arg_detail_page_type", "basic");
        s0 r2 = s0.a;
        List<y> r3 = X90().basicItems();
        r2.getClass();
        r1.c.putExtra("arg_basic_items", GsonProtectorUtils.toJson(s0.b, r3));
        Activity r4 = null;
        if (r7 == null) goto L8;
        String r5 = r7.a;
    L9:
        r1.c.putExtra("arg_selected_item_key", r5);
        if (r7 == null) goto L12;
        String r8 = r7.b;
    L13:
        r1.c.putExtra("arg_selected_item_title", r8);
        r1.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "explore_home");
        r1.c.putExtra("mac", ((w0) X90().getState().getValue()).b);
        r1.d();
        if ((r0 instanceof Activity) == false) goto L16;
        r4 = (Activity) r0;
    L16:
        if (r4 == null) goto L19;
        vja.b.a(r4, TransitionAnimStyle.Standard);
        return;
    L19:
        return;
    L12:
        r8 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    }

    public final void aa0(OCardListItem r3) {
        ViewGroup.LayoutParams r0 = r3.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r3.getCardContainer().setLayoutParams(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        Lifecycle.State r9 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGlassesExploreFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r9, null, this), 3, null);
        X90().load(requireContext(), getArguments());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.view.View, android.widget.FrameLayout, androidx.core.widget.NestedScrollView, com.obric.oui.bouncelayout.ONestedScrollView] */
    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Context r11 = requireContext();
        ?? r12 = new ONestedScrollView(requireContext(), null, 6, 0);
        this.g = r12;
        r12.setFillViewport(true);
        r12.setClipChildren(true);
        r12.setClipToPadding(false);
        r12.setPadding(c7.b(12), c7.b(88), c7.b(12), c7.b(128));
        LinearLayout r3 = new LinearLayout(r12.getContext());
        r3.setOrientation(1);
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        this.h = r3;
        r12.addView(r3, new ViewGroup.LayoutParams(-1, -2));
        final OFloatingTitleBar r13 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setStartTitle(getString(2131902572));
        r13.setMaskBlurRadius(8.0f);
        ViewCompat.setOnApplyWindowInsetsListener(r13, new l0(r13, this));
        ViewCompat.requestApplyInsets(r13);
        ConstraintLayout r0 = new ConstraintLayout(r11);
        r0.setBackgroundColor(ContextCompat.getColor(requireContext(), 2131103059));
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(0, 0);
        r14.startToStart = 0;
        r14.endToEnd = 0;
        r14.topToTop = 0;
        r14.bottomToBottom = 0;
        Unit r1 = Unit.INSTANCE;
        r0.addView(r12, r14);
        ConstraintLayout.LayoutParams r15 = new ConstraintLayout.LayoutParams(0, -2);
        r15.startToStart = 0;
        r15.endToEnd = 0;
        r15.topToTop = 0;
        r0.addView(r13, r15);
        return r0;
    }

    public final OCardListItem W90(final q0 r15, FeatureCardStyle r16, int r17, float r18) {
        View.OnClickListener r2 = new m0(this, r15);
        int r3 = c7.b(Integer.valueOf(r16.getHeightDp()));
        LinearLayout r4 = new LinearLayout(requireContext());
        r4.setOrientation(1);
        r4.setClipChildren(true);
        r4.setClipToPadding(true);
        r4.setClipToOutline(true);
        GradientDrawable r6 = new GradientDrawable();
        r6.setShape(0);
        r6.setCornerRadius(c7.b(20));
        r6.setColor(v19.c.a(2130970532, requireContext(), 2131102539));
        r4.setBackground(r6);
        r4.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        SimpleDraweeView r7 = new SimpleDraweeView(requireContext());
        r7.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        DoraObricGlassesImageResource r10 = r15.f;
        if ((r10 instanceof DoraObricGlassesImageResource.RemoteUrl) == false) goto L8;
        DoraObricGlassesImageResource.RemoteUrl r11 = (DoraObricGlassesImageResource.RemoteUrl) r10;
        if ((!StringsKt.isBlank(r11.getUrl())) == false) goto L13;
        ImageLoaderKt.u(r7, r11.getUrl(), "dora_obric_glasses_explore");
    L13:
        r7.setLayoutParams(new LinearLayout.LayoutParams(-1, c7.b(Integer.valueOf(r16.getImageHeightDp()))));
        r7.setOnClickListener(r2);
        r4.addView(r7);
        LinearLayout r8 = new LinearLayout(requireContext());
        r8.setOrientation(1);
        int r12 = 16;
        if (r16.getShowSubtitle() == false) goto L16;
        r12 = 0;
    L16:
        r8.setGravity(r12);
        r8.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r8.setPadding(c7.b(16), c7.b(16), c7.b(16), c7.b(16));
        String r13 = r15.d;
        AppCompatTextView r14 = new AppCompatTextView(requireContext());
        String r110 = "";
        if (r13 != null) goto L19;
        r13 = "";
    L19:
        r14.setText(r13);
        r14.setTextColor(ContextCompat.getColor(requireContext(), 2131104350));
        r14.setTextSize(2, r16.getTitleTextSizeSp());
        r14.setIncludeFontPadding(true);
        r14.setMaxLines(r16.getTitleMaxLines());
        r14.setEllipsize(TextUtils.TruncateAt.END);
        r8.addView(r14);
        if (r16.getShowSubtitle() == false) goto L34;
        String r111 = r15.e;
        if (r111 != null) goto L24;
    L27:
        boolean r112 = true;
    L28:
        if (r112 == true) goto L34;
        String r1 = r15.e;
        if (r1 == null) goto L33;
        r110 = r1;
    L33:
        AppCompatTextView r5 = new AppCompatTextView(requireContext());
        r5.setText(r110);
        r5.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r5.setTextSize(2, 12.0f);
        r5.setIncludeFontPadding(true);
        r5.setMaxLines(2);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-1, -2);
        r113.topMargin = c7.b(0);
        r5.setLayoutParams(r113);
        r8.addView(r5);
        goto L34
    L24:
        if (StringsKt.isBlank(r111) == true) goto L27;
        r112 = false;
    L34:
        r8.setOnClickListener(r2);
        r4.addView(r8);
        r4.setOnClickListener(r2);
        OCardListItem r9 = new OCardListItem(requireContext(), null, 6, 0);
        r9.setLayoutParams(new LinearLayout.LayoutParams(r17, r3, r18));
        r9.setCardType(2);
        OCardListItem.h(r9, 0);
        r9.setShowCardBg(true);
        r9.setCustomStartView(r4);
        r9.n(true);
        r9.m(false);
        r9.r(false);
        r9.setOnContentClickListener(r2);
        aa0(r9);
        r9.getCardContainer().setPadding(0, 0, 0, 0);
        r9.getContentContainer().setPadding(0, 0, 0, 0);
        r9.o(false);
        Iterator r20 = CollectionsKt.listOf(new Drawable[]{r9.getCardContainer().getBackground(), r9.getContentContainer().getBackground()}).iterator();
    L36:
        if (r20.hasNext() == false) goto L44;
        Drawable r21 = (Drawable) r20.next();
        if ((r21 instanceof GradientDrawable) == false) goto L40;
        GradientDrawable r22 = (GradientDrawable) r21;
    L41:
        if (r22 == null) goto L36;
        r22.setCornerRadius(c7.b(20));
        goto L36
    L40:
        r22 = null;
        goto L41
    L44:
        return r9;
    L8:
        if ((r10 instanceof DoraObricGlassesImageResource.Apk) == false) goto L11;
        r7.setImageResource(((DoraObricGlassesImageResource.Apk) r10).getResId());
        goto L13
    L11:
        if ((r10 instanceof DoraObricGlassesImageResource.FileUri) == false) goto L46;
        r7.setImageURI(((DoraObricGlassesImageResource.FileUri) r10).getUri());
        goto L13
    L46:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v7, types: [boolean, int] */
    public final void Z90(final LinearLayout r22, final List<u0> r23, final int r24, final int r25, final long r26) {
        if (r24 == this.i) goto L6;
        return;
    L6:
        if (r25 < r23.size()) goto L11;
        NestedScrollView r6 = this.g;
        if (r6 == null) goto L115;
        r6.post(new j0(r24, this, r26, r23));
        return;
    L115:
        return;
    L11:
        u0 r0 = (u0) ListProtector.get(r23, r25);
        if (r25 <= 0) goto L14;
        View r7 = new View(requireContext());
        r7.setLayoutParams(new LinearLayout.LayoutParams(-1, c7.b(16)));
        r22.addView(r7);
    L14:
        String r8 = r0.b;
        int r12 = 6;
        ?? r13 = 0;
        OSectionTitleBar r9 = new OSectionTitleBar(requireContext(), null, 6, 0);
        r9.setTitleText(r8);
        r9.setTitleStyle(2131953404);
        LinearLayout r10 = (LinearLayout) r9.findViewById(2131367728);
        if (r10 == null) goto L17;
        r10.setPadding(c7.b(16), c7.b(8), c7.b(16), c7.b(8));
    L17:
        r9.setLayoutParams(new LinearLayout.LayoutParams(-1, c7.b(40)));
        r22.addView(r9);
        if (b.a[r0.getType().ordinal()] != 1) goto L76;
        List<q0> r1 = r0.c;
        if (r1 != null) goto L22;
        r1 = CollectionsKt.emptyList();
    L22:
        ArrayList r11 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L24:
        if (r2.hasNext() == false) goto L30;
        List<y> r15 = ((q0) r2.next()).n;
        if (r15 != null) goto L28;
        r15 = CollectionsKt.emptyList();
    L28:
        CollectionsKt.addAll(r11, r15);
        goto L24
    L30:
        if (r11.isEmpty() == true) goto L101;
        LinearLayout r3 = new LinearLayout(requireContext());
        r3.setOrientation(1);
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        GradientDrawable r16 = new GradientDrawable();
        r16.setShape(0);
        r16.setCornerRadius(c7.b(20));
        r16.setColor(v19.c.a(2130970529, requireContext(), 2131102529));
        r3.setBackground(r16);
        r3.setPadding(c7.b(16), c7.b(12), c7.b(16), c7.b(12));
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Iterator r4 = r11.iterator();
        int r14 = 0;
    L34:
        if (r4.hasNext() == false) goto L75;
        Object r17 = r4.next();
        int r18 = r14 + 1;
        if (r14 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        final y r110 = (y) r17;
        int r111 = CollectionsKt.getLastIndex(r11);
        Iterator r112 = r4;
        OCardListItem r5 = new OCardListItem(requireContext(), null, r12, r13);
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r5.setCardType(r13);
        if (r111 > 0) goto L41;
        int r20 = 0;
    L46:
        OCardListItem.h(r5, r20);
        r5.setShowCardBg(r13);
        FrameLayout r21 = new FrameLayout(requireContext());
        ViewGroup.MarginLayoutParams r113 = new ViewGroup.MarginLayoutParams(c7.b(30), c7.b(30));
        r113.setMarginEnd(c7.b(12));
        r21.setLayoutParams(r113);
        AppCompatImageView r114 = new AppCompatImageView(r21.getContext());
        String r115 = r110.a;
        switch(r115.hashCode()) {
            case -1367751899: goto L67;
            case -810883302: goto L63;
            case 21116443: goto L61;
            case 102970646: goto L58;
            case 103772132: goto L54;
            case 951351530: goto L50;
            default: goto L70;
        };
    L61:
        r115.equals("onboarding");
    L70:
        int r116 = 2131240602;
    L71:
        r114.setImageResource(r116);
        r114.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        r114.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r21.addView(r114);
        r5.setCustomStartView(r21);
        r5.n(true);
        r5.p(false);
        r5.setTitle(r110.b);
        r5.s(true);
        r5.setSubTitle(r110.c);
        r5.q(true);
        r5.getTitleView().setTextColor(ContextCompat.getColor(requireContext(), 2131104350));
        r5.getTitleView().setMaxLines(1);
        r5.getSubTitleView().setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r5.getSubTitleView().setMaxLines(2);
        r5.m(false);
        r5.setDefaultTailIcon(0);
        r5.r(true);
        r5.o(false);
        aa0(r5);
        r5.getCardContainer().setBackground(null);
        r5.getContentContainer().setBackground(null);
        r5.getCardContainer().setPadding(0, 0, 0, 0);
        r5.getContentContainer().setPadding(c7.b(0), c7.b(10), c7.b(4), c7.b(10));
        r5.getTitleContainer().setPadding(0, 0, c7.b(8), 0);
        r5.setOnContentClickListener(new n0(this, r110));
        r3.addView(r5);
        if (r14 == CollectionsKt.getLastIndex(r11)) goto L74;
        View r27 = new View(requireContext());
        LinearLayout.LayoutParams r28 = new LinearLayout.LayoutParams(-1, c7.b(1));
        r28.setMarginStart(c7.b(42));
        r28.setMarginEnd(c7.b(16));
        r27.setLayoutParams(r28);
        r27.setBackgroundColor(v19.c.a(2130972086, requireContext(), 2131103159));
        r3.addView(r27);
    L74:
        r14 = r18;
        r4 = r112;
        r12 = 6;
        r13 = 0;
        goto L34
    L50:
        if (r115.equals("connect") == false) goto L70;
        r116 = 2131240599;
        goto L71
    L54:
        if (r115.equals("media") == false) goto L70;
        r116 = 2131240601;
        goto L71
    L58:
        if (r115.equals("light") == false) goto L70;
        r116 = 2131240600;
        goto L71
    L63:
        if (r115.equals("volume") == false) goto L70;
        r116 = 2131240603;
        goto L71
    L67:
        if (r115.equals("camera") == false) goto L70;
        r116 = 2131240598;
        goto L71
    L41:
        if (r14 != 0) goto L43;
        r20 = 1;
        goto L46
    L43:
        if (r14 != r111) goto L45;
        r20 = 3;
        goto L46
    L45:
        r20 = 2;
        goto L46
    L75:
        r22.addView(r3);
    L101:
        r22.post(new k0(this, r22, r23, r24, r25, r26));
        return;
    L76:
        List<q0> r30 = r0.c;
        if (r30 != null) goto L80;
        r30 = CollectionsKt.emptyList();
    L80:
        if (r30.isEmpty() == true) goto L101;
        r22.addView(W90((q0) CollectionsKt.first(r30), FeatureCardStyle.HERO, -1, 0.0f));
        Iterator r31 = CollectionsKt.chunked(CollectionsKt.drop(r30, 1), 2).iterator();
    L84:
        if (r31.hasNext() == false) goto L101;
        List r32 = (List) r31.next();
        View r33 = new View(requireContext());
        r33.setLayoutParams(new LinearLayout.LayoutParams(-1, c7.b(16)));
        r22.addView(r33);
        LinearLayout r34 = new LinearLayout(requireContext());
        r34.setOrientation(0);
        r34.setClipChildren(false);
        r34.setClipToPadding(false);
        r34.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Iterator r35 = r32.iterator();
        int r117 = 0;
    L87:
        if (r35.hasNext() == false) goto L97;
        Object r118 = r35.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L91;
        CollectionsKt.throwIndexOverflow();
    L91:
        r34.addView(W90((q0) r118, FeatureCardStyle.COMPACT, 0, 1.0f));
        if (r117 == CollectionsKt.getLastIndex(r32)) goto L95;
        View r36 = new View(r34.getContext());
        r36.setLayoutParams(new LinearLayout.LayoutParams(c7.b(8), 1));
        r34.addView(r36);
    L95:
        r117 = r119;
        goto L87
    L97:
        if (r32.size() >= 2) goto L100;
        View r37 = new View(r34.getContext());
        r37.setVisibility(4);
        r37.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        r34.addView(r37);
    L100:
        r22.addView(r34);
        goto L84
    }
}
