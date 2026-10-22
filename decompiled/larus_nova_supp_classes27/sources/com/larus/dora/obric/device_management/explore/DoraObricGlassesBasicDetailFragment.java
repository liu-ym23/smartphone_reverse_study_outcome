package com.larus.dora.obric.device_management.explore;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u008f\u00012\u00020\u0001:\b\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J$\u0010)\u001a\u00020\u00152\b\b\u0001\u0010*\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020+H\u0002J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u0010-\u001a\u00020+H\u0002J$\u00102\u001a\u00020\u00152\b\b\u0001\u0010*\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020+H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001012\u0006\u0010-\u001a\u00020+H\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0012\u00106\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020+H\u0002J\u0012\u00107\u001a\u0004\u0018\u0001012\u0006\u0010-\u001a\u00020+H\u0002J\b\u00108\u001a\u00020\u001dH\u0002J.\u00109\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0001\u0010*\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020+2\b\b\u0001\u0010:\u001a\u00020+H\u0002J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020+H\u0002J\u0012\u0010>\u001a\u0004\u0018\u0001012\u0006\u0010-\u001a\u00020+H\u0002J\u0012\u0010?\u001a\u0004\u0018\u0001012\u0006\u0010-\u001a\u00020+H\u0002J \u0010@\u001a\u00020\u00152\b\b\u0001\u0010*\u001a\u00020+2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\tH\u0002J\u0012\u0010C\u001a\u00020\u00152\b\b\u0001\u0010*\u001a\u00020+H\u0002J\u0016\u0010D\u001a\u00020\u00152\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\tH\u0002J\u0018\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020+H\u0002J \u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020+H\u0002J\u0010\u0010J\u001a\u00020\u00152\u0006\u0010K\u001a\u00020!H\u0002J\u0010\u0010L\u001a\u00020\u00152\u0006\u0010M\u001a\u00020BH\u0002J$\u0010N\u001a\u00020\u00152\b\u0010O\u001a\u0004\u0018\u00010/2\b\u0010P\u001a\u0004\u0018\u0001012\u0006\u0010Q\u001a\u00020!H\u0002J:\u0010R\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\b\b\u0003\u0010:\u001a\u00020+2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010U\u001a\u0004\u0018\u000101H\u0002J6\u0010V\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\b\u0010O\u001a\u0004\u0018\u00010/2\b\u0010P\u001a\u0004\u0018\u0001012\b\b\u0001\u0010W\u001a\u00020+H\u0002J\u001e\u0010X\u001a\u00020\u00152\n\b\u0002\u0010P\u001a\u0004\u0018\u0001012\b\b\u0001\u0010:\u001a\u00020+H\u0002J&\u0010Y\u001a\u00020\u00152\b\u0010O\u001a\u0004\u0018\u00010/2\b\u0010P\u001a\u0004\u0018\u0001012\b\b\u0001\u0010W\u001a\u00020+H\u0002J\u0010\u0010Z\u001a\u00020\u00152\u0006\u0010[\u001a\u00020\u0013H\u0002J\u0012\u0010\\\u001a\u00020\u00152\b\u0010P\u001a\u0004\u0018\u000101H\u0002J\u001a\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`2\b\b\u0001\u0010W\u001a\u00020+H\u0002J@\u0010a\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010b\u001a\u00020^2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00152\b\u0010O\u001a\u0004\u0018\u00010/2\b\b\u0002\u0010Q\u001a\u00020!2\u0006\u0010d\u001a\u00020!H\u0002J\u0012\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020\u0007H\u0002J\u0010\u0010h\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u0007H\u0002J\u0010\u0010i\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u0007H\u0002J\u0010\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\nH\u0002J\u0010\u0010m\u001a\u00020\u001d2\u0006\u0010l\u001a\u00020\nH\u0002J\u0010\u0010n\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020`H\u0002J\u0012\u0010o\u001a\u00020\u001d2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002J\u0018\u0010r\u001a\u00020!2\u0006\u0010s\u001a\u00020\u00072\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010t\u001a\u00020\u001d2\u0006\u0010l\u001a\u00020\nH\u0002J\u0018\u0010u\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00072\u0006\u0010p\u001a\u00020qH\u0002J\b\u0010v\u001a\u00020!H\u0002J\n\u0010w\u001a\u0004\u0018\u00010xH\u0002J\u000e\u0010y\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\n\u0010z\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020}H\u0002J\u0010\u0010~\u001a\u00020!2\u0006\u0010l\u001a\u00020\nH\u0002J\b\u0010\u007f\u001a\u00020+H\u0002J\u0012\u0010\u0080\u0001\u001a\u00020\u00152\u0007\u0010\u0081\u0001\u001a\u00020+H\u0002J\t\u0010\u0082\u0001\u001a\u00020+H\u0002J\t\u0010\u0083\u0001\u001a\u00020+H\u0002J\n\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J\t\u0010\u0086\u0001\u001a\u00020+H\u0002J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0002J\n\u0010\u0089\u0001\u001a\u00030\u0088\u0001H\u0002J\u0014\u0010\u008a\u0001\u001a\u00020+2\t\b\u0001\u0010\u008b\u0001\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicDetailFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "contentContainer", "Landroid/widget/LinearLayout;", "targetMac", "", "basicItems", "", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicItem;", "selectedItemKey", "selectedItemTitle", "lightGuideCallbacks", "", "Lkotlin/Pair;", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "detailLottieViews", "Lcom/airbnb/lottie/LottieAnimationView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDoraConnectStateChanged", "isConnected", "", "onDestroyView", "getCurrentPageName", "buildContentView", "buildTitleBar", "renderItems", "renderMediaDetail", "renderCameraDetail", "buildCameraDetailCard", "titleRes", "", "descriptionRes", "index", "resolveCameraDetailLottie", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesLottieResource;", "resolveCameraDetailImage", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource;", "buildMediaDetailCard", "resolveMediaDetailLottie", "resolveMediaDetailImage", "renderConnectDetailCards", "resolveConnectDetailLottie", "resolveConnectDetailImage", "releaseDetailLotties", "renderSingleIllustrationDetailCard", "imageResId", "renderVolumeDetail", "renderLightGuidePage", "resolveLightGuideLottie", "resolveLightGuideImage", "resolveSelectedDetailImage", "buildLightGuideSection", "pages", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicDetailFragment$LightGuidePage;", "buildLightGuideSectionTitle", "buildLightGuideCarousel", "buildLightGuideIndicator", "pageCount", "selectedPosition", "updateLightGuideIndicator", "indicator", "buildLightGuideIndicatorDot", "selected", "buildLightGuidePageContent", "page", "buildLightGuidePageLottieMedia", "lottie", "image", "manualPlay", "buildIllustrationDetailCard", "title", "description", "detailImage", "buildLottieDetailCard", "coverImageResId", "buildDetailCardMedia", "buildDetailCardLottieMedia", "buildDetailCardLottiePlayButton", "lottieView", "buildDetailImageMedia", "buildDetailCardLottieCoverView", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "bindDetailLottie", "coverView", "playButton", "showFallbackCover", "resolveDetailLottieFile", "Ljava/io/File;", "localPath", "buildDetailCardTitle", "buildDetailCardDescription", "buildBasicItem", "Lcom/obric/oui/lisitem/OCardListItem;", "item", "openBasicDetail", "applyDetailEnterAnim", "openAction", "action", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreAction;", "openOnboardingAction", "url", "reportClick", "appendActionQuery", "isActionDeviceConnected", "resolveActionDevice", "Lcom/bytedance/dora/device/DoraDevice;", "readBasicItems", "resolveSelectedBasicItem", "resolvePageTitle", "resolveDetailPageType", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicDetailFragment$BasicDetailPageType;", "canOpenBasicDetail", "resolveContentTopPaddingDp", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolveCardBackgroundColor", "buildTopRoundedDetailMediaBackground", "Landroid/graphics/drawable/GradientDrawable;", "resolveDetailMediaBackgroundColor", "buildFixedDetailMediaLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "buildFixedDetailCardLayoutParams", "color", "resId", "LightGuidePage", "LightGuidePagerAdapter", "BasicDetailPageType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGlassesBasicDetailFragment extends DoraBaseFragment {
    public static final Set<String> m = null;
    public LinearLayout f;
    public String g;
    public List<y> h;
    public String i;
    public String j;
    public final List<Pair<ViewPager2, ViewPager2.OnPageChangeCallback>> k;
    public final List<LottieAnimationView> l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesBasicDetailFragment$BasicDetailPageType;", "", "<init>", "(Ljava/lang/String;I)V", "LIST", "CONNECT", "MEDIA", "CAMERA", "VOLUME", "LIGHT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BasicDetailPageType extends Enum<BasicDetailPageType> {
        public static final BasicDetailPageType CAMERA = null;
        public static final BasicDetailPageType CONNECT = null;
        public static final BasicDetailPageType LIGHT = null;
        public static final BasicDetailPageType LIST = null;
        public static final BasicDetailPageType MEDIA = null;
        public static final BasicDetailPageType VOLUME = null;
        public static final /* synthetic */ BasicDetailPageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BasicDetailPageType> getEntries() {
            return b;
        }

        static {
            BasicDetailPageType r0 = new BasicDetailPageType("LIST", 0);
            LIST = r0;
            BasicDetailPageType r1 = new BasicDetailPageType("CONNECT", 1);
            CONNECT = r1;
            BasicDetailPageType r3 = new BasicDetailPageType("MEDIA", 2);
            MEDIA = r3;
            BasicDetailPageType r5 = new BasicDetailPageType("CAMERA", 3);
            CAMERA = r5;
            BasicDetailPageType r7 = new BasicDetailPageType("VOLUME", 4);
            VOLUME = r7;
            BasicDetailPageType r9 = new BasicDetailPageType("LIGHT", 5);
            LIGHT = r9;
            BasicDetailPageType[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static BasicDetailPageType[] values() {
            return (BasicDetailPageType[]) a.clone();
        }

        public static BasicDetailPageType valueOf(String r1) {
            return (BasicDetailPageType) r27.a.a(BasicDetailPageType.class, r1);
        }

        public BasicDetailPageType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final boolean b;
        public final b1 c;
        public final DoraObricGlassesImageResource d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            b1 r3 = this.c;
            int r4 = 0;
            if (r3 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r2 + r5) * 31;
            DoraObricGlassesImageResource r7 = this.d;
            if (r7 == null) goto L15;
            r4 = r7.hashCode();
        L15:
            return r6 + r4;
        L9:
            r5 = r3.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "LightGuidePage(titleRes=" + this.a + ", manualPlay=" + this.b + ", lottie=" + this.c + ", image=" + this.d + ')';
        }

        public b(int r1, boolean r2, b1 r3, DoraObricGlassesImageResource r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public final class c extends RecyclerView.Adapter<a> {
        public final List<b> a;
        public final /* synthetic */ DoraObricGlassesBasicDetailFragment b;

        public final class a extends RecyclerView.ViewHolder {
            public final FrameLayout a;
            public final /* synthetic */ c b;

            public a(c r2, FrameLayout r3) {
                Intrinsics.checkNotNullParameter(r3, "container");
                this.b = r2;
                super(r3);
                this.a = r3;
            }
        }

        public final int getItemCount() {
            return this.a.size();
        }

        public c(DoraObricGlassesBasicDetailFragment r2, List<b> r3) {
            Intrinsics.checkNotNullParameter(r3, "pages");
            this.b = r2;
            this.a = r3;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r110) {
            a r0 = (a) r18;
            Intrinsics.checkNotNullParameter(r0, "holder");
            b r2 = (b) ListProtector.get(this.a, r110);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r2, "page");
            r0.a.removeAllViews();
            FrameLayout r3 = r0.a;
            DoraObricGlassesBasicDetailFragment r1 = r0.b.b;
            Set<String> r4 = DoraObricGlassesBasicDetailFragment.m;
            r1.getClass();
            LinearLayout r11 = new LinearLayout(r1.requireContext());
            r11.setOrientation(1);
            r11.setGravity(1);
            b1 r8 = r2.c;
            DoraObricGlassesImageResource r13 = r2.d;
            boolean r9 = r2.b;
            Context r14 = r1.requireContext();
            LottieAnimationView r15 = new LottieAnimationView(r14);
            r15.setRepeatMode(1);
            if (r9 == false) goto L5;
            int r5 = 0;
        L6:
            r15.setRepeatCount(r5);
            r15.setScaleType(ImageView.ScaleType.FIT_CENTER);
            r15.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ((ArrayList) r1.l).add(r15);
            View r6 = r1.Z90(r14);
            if (r9 == false) goto L9;
            View r7 = r1.ba0(r15);
        L10:
            View r10 = r7;
            r1.W90(r15, r6, r10, r8, r9, false);
            FrameLayout r12 = new FrameLayout(r14);
            r12.setClipToOutline(true);
            r12.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            r12.setBackground(r1.ka0());
            r12.addView(r1.da0(r13));
            r12.addView(r15);
            r12.addView(r6);
            if (r10 == null) goto L13;
            r12.addView(r10);
        L13:
            r12.setLayoutParams(DoraObricGlassesBasicDetailFragment.fa0());
            r11.addView(r12);
            TextView r16 = new TextView(r11.getContext());
            r16.setText(r1.getString(r2.a));
            r16.setGravity(17);
            r16.setTextSize(16.0f);
            r16.setTextColor(r1.la0(2131104350));
            TextViewCompat.setLineHeight(r16, c7.e(Float.valueOf(22.0f)));
            r16.setPadding(c7.b(20), c7.b(4), c7.b(20), 0);
            r16.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            r11.addView(r16);
            r11.setLayoutParams(new FrameLayout.LayoutParams(-1, c7.b(218)));
            r3.addView(r11);
            return;
        L9:
            r7 = null;
            goto L10
        L5:
            r5 = -1;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            FrameLayout r4 = new FrameLayout(r2.getContext());
            r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new a(this, r4);
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BasicDetailPageType.values().length];
            r0[BasicDetailPageType.CONNECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[BasicDetailPageType.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[BasicDetailPageType.CAMERA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[BasicDetailPageType.VOLUME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[BasicDetailPageType.LIGHT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[BasicDetailPageType.LIST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public final String k() {
        return "dora_glasses_basic_operation_detail";
    }

    static {
        m = SetsKt.setOf(new String[]{"media", "camera", "volume", "connect", "light"});
    }

    public static LinearLayout.LayoutParams ea0() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(c7.b(336), -2);
        r0.gravity = 1;
        return r0;
    }

    public static LinearLayout.LayoutParams fa0() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(c7.b(336), c7.b(192));
        r0.gravity = 1;
        return r0;
    }

    public final GradientDrawable ka0() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadii(new float[]{c7.b(20), c7.b(20), c7.b(20), c7.b(20), 0.0f, 0.0f, 0.0f, 0.0f});
        r0.setColor(la0(2131103057));
        return r0;
    }

    public final void ma0() {
        Iterator<T> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LottieAnimationView r1 = (LottieAnimationView) r0.next();
        r1.cancelAnimation();
        r1.removeAllAnimatorListeners();
        goto L4
    L6:
        ((ArrayList) this.l).clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v8 */
    public final void na0() {
        LinearLayout r1 = this.f;
        if (r1 != null) goto L5;
        return;
    L5:
        ma0();
        r1.removeAllViews();
        int r3 = 20;
        AttributeSet r4 = null;
        int r5 = 6;
        int r6 = 2;
        ?? r9 = 1;
        switch(d.a[ra0().ordinal()]) {
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        Iterator<T> r2 = this.h.iterator();
        int r11 = 0;
    L11:
        if (r2.hasNext() == false) goto L65;
        Object r12 = r2.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        final y r14 = (y) r12;
        if (r14.g == null) goto L26;
        DoraDevice r15 = oa0();
        if (r15 != null) goto L21;
    L23:
        boolean r16 = false;
    L24:
        if (r16 == false) goto L26;
        final boolean r17 = true;
    L27:
        boolean r7 = m.contains(r14.a);
        OCardListItem r18 = new OCardListItem(requireContext(), r4, r5, 0);
        r18.setCardType(0);
        OCardListItem.h(r18, 0);
        r18.setShowCardBg(r9);
        r18.p(false);
        r18.setTitle(r14.b);
        r18.s(r9);
        r18.setSubTitle(r14.c);
        r18.q(r9);
        r18.m(false);
        r18.setDefaultTailIcon(0);
        if (r17 == true) goto L32;
        if (r7 == true) goto L32;
        boolean r8 = false;
    L33:
        r18.r(r8);
        r18.getTitleView().setMaxLines(r9);
        r18.getSubTitleView().setMaxLines(3);
        FrameLayout r10 = r18.getCardContainer();
        GradientDrawable r20 = new GradientDrawable();
        r20.setShape(0);
        r20.setCornerRadius(c7.b(Integer.valueOf(r3)));
        r20.setColor(pa0());
        r10.setBackground(r20);
        r18.getContentContainer().setPadding(c7.b(16), c7.b(16), c7.b(16), c7.b(16));
        if (r17 == true) goto L36;
        if (r7 == true) goto L36;
    L37:
        r18.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r1.addView(r18);
        if (r11 == CollectionsKt.getLastIndex(this.h)) goto L40;
        r1.addView(ja0(12));
    L40:
        r11 = r13;
        r3 = 20;
        r4 = null;
        r5 = 6;
        r6 = 2;
        r9 = 1;
    L36:
        r18.setOnContentClickListener(new t(this, r14, r17));
    L32:
        r8 = true;
        goto L33
    L21:
        if (kj4.a.g().getDoraLinkState(r15) != r6) goto L23;
        r16 = true;
    L26:
        r17 = false;
        goto L27
    L65:
        return;
    L41:
        List<b> r21 = CollectionsKt.listOf(new b[]{new b(2131903512, false, sa0(0), ua0(0)), new b(2131903513, false, sa0(1), ua0(1)), new b(2131903514, false, sa0(2), ua0(2))});
        List<b> r22 = CollectionsKt.listOf(new b[]{new b(2131903519, true, sa0(3), ua0(3)), new b(2131903520, true, sa0(4), ua0(4)), new b(2131903516, true, sa0(5), ua0(5)), new b(2131903518, true, sa0(6), ua0(6)), new b(2131903517, true, sa0(7), ua0(7))});
        r1.addView(ga0(2131903521, r21));
        r1.addView(ja0(16));
        r1.addView(ga0(2131903522, r22));
        return;
    L42:
        String r23 = getString(2131903563);
        String r24 = getString(2131903531);
        y r25 = ta0();
        if (r25 == null) goto L45;
        b1 r26 = r25.d;
    L46:
        DoraObricGlassesImageResource r27 = ua0(0);
        LinearLayout r28 = new LinearLayout(requireContext());
        r28.setOrientation(1);
        GradientDrawable r30 = new GradientDrawable();
        r30.setShape(0);
        r30.setCornerRadius(c7.b(20));
        r30.setColor(pa0());
        r28.setBackground(r30);
        if (r26 == null) goto L49;
        View r31 = aa0(r26, r27);
    L53:
        r28.addView(r31);
        LinearLayout r32 = new LinearLayout(r28.getContext());
        r32.setOrientation(1);
        r32.setGravity(1);
        r32.setPadding(c7.b(20), c7.b(4), c7.b(20), c7.b(20));
        r32.addView(ca0(r23));
        r32.addView(ja0(8));
        r32.addView(Y90(r24));
        r28.addView(r32);
        r28.setLayoutParams(ea0());
        r1.addView(r28);
        return;
    L49:
        Context r33 = requireContext();
        if (r27 == null) goto L52;
        FrameLayout r34 = new FrameLayout(r33);
        r34.setClipToOutline(true);
        r34.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r34.setBackground(ka0());
        r34.addView(da0(r27));
        r34.setLayoutParams(fa0());
        r31 = r34;
        goto L53
    L52:
        FrameLayout r35 = new FrameLayout(r33);
        r35.setBackground(ka0());
        r35.setLayoutParams(fa0());
        r31 = r35;
        goto L53
    L45:
        r26 = null;
        goto L46
    L54:
        r1.addView(X90(2131903509, 2131903508, 0));
        r1.addView(ja0(16));
        r1.addView(X90(2131903511, 2131903510, 1));
        return;
    L55:
        r1.addView(ia0(2131903528, 2131903527, 0));
        r1.addView(ja0(16));
        r1.addView(ia0(2131903526, 2131903525, 1));
        r1.addView(ja0(16));
        r1.addView(ia0(2131903530, 2131903529, 2));
        return;
    L56:
        r1.addView(ha0(getString(2131903536), getString(2131903535), qa0(0), ua0(0)));
        r1.addView(ja0(16));
        r1.addView(ha0(getString(2131903534), getString(2131903533), qa0(1), ua0(1)));
        r1.addView(ja0(16));
        r1.addView(ha0(getString(2131903538), getString(2131903537), qa0(2), ua0(2)));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final DoraDevice oa0() {
        String r0 = this.g;
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

    public final BasicDetailPageType ra0() {
        String r0 = this.i;
        if (r0 == null) goto L27;
        switch(r0.hashCode()) {
            case -1367751899: goto L23;
            case -810883302: goto L19;
            case 102970646: goto L15;
            case 103772132: goto L11;
            case 951351530: goto L8;
            default: goto L27;
        };
    L8:
        if (r0.equals("connect") == false) goto L27;
        return BasicDetailPageType.CONNECT;
    L11:
        if (r0.equals("media") == false) goto L27;
        return BasicDetailPageType.MEDIA;
    L15:
        if (r0.equals("light") == false) goto L27;
        return BasicDetailPageType.LIGHT;
    L19:
        if (r0.equals("volume") == false) goto L27;
        return BasicDetailPageType.VOLUME;
    L23:
        if (r0.equals("camera") == false) goto L27;
        return BasicDetailPageType.CAMERA;
    L27:
        return BasicDetailPageType.LIST;
    }

    public final y ta0() {
        String r0 = this.i;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        Iterator<T> r2 = this.h.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((y) r3).a, r0) == false) goto L7;
        r1 = r3;
    L12:
        return (y) r1;
    }

    public DoraObricGlassesBasicDetailFragment() {
        this.h = CollectionsKt.emptyList();
        this.k = new ArrayList();
        this.l = new ArrayList();
    }

    public final void onDestroyView() {
        ma0();
        Iterator<T> r0 = this.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Pair r1 = (Pair) r0.next();
        ((ViewPager2) r1.component1()).unregisterOnPageChangeCallback((ViewPager2.OnPageChangeCallback) r1.component2());
        goto L4
    L6:
        ((ArrayList) this.k).clear();
        this.f = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final int pa0() {
        return v19.c.a(2130970532, requireContext(), 2131102539);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        na0();
    }

    public final View Y90(String r3) {
        TextView r0 = new TextView(requireContext());
        r0.setText(r3);
        r0.setGravity(8388611);
        r0.setTextSize(12.0f);
        r0.setTextColor(la0(2131104359));
        TextViewCompat.setLineHeight(r0, c7.e(Float.valueOf(16.0f)));
        r0.setMaxWidth(c7.b(296));
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        return r0;
    }

    public final AppCompatImageView Z90(Context r4) {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -1);
        AppCompatImageView r1 = new AppCompatImageView(r4);
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        r5.setColor(la0(2131103057));
        r1.setBackground(r5);
        r1.setScaleType(ImageView.ScaleType.FIT_XY);
        r1.setVisibility(8);
        r1.setLayoutParams(r0);
        return r1;
    }

    public final View ba0(final LottieAnimationView r7) {
        final FrameLayout r0 = new FrameLayout(requireContext());
        r0.setVisibility(8);
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(1);
        r1.setColor(-83886081);
        r0.setBackground(r1);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(c7.b(48), c7.b(48));
        r2.gravity = 17;
        r0.setLayoutParams(r2);
        r0.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        ViewCompat.setElevation(r0, c7.b(10));
        AppCompatImageView r3 = new AppCompatImageView(r0.getContext());
        r3.setImageResource(2131240597);
        r3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(c7.b(24), c7.b(24));
        r4.gravity = 17;
        r3.setLayoutParams(r4);
        r0.addView(r3);
        r0.setOnClickListener(new u(r0, r7));
        return r0;
    }

    public final View ca0(String r4) {
        TextView r0 = new TextView(requireContext());
        r0.setText(r4);
        r0.setGravity(17);
        r0.setTextSize(16.0f);
        r0.setTextColor(la0(2131104350));
        TextViewCompat.setLineHeight(r0, c7.e(Float.valueOf(22.0f)));
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r0;
    }

    public final SimpleDraweeView da0(DoraObricGlassesImageResource r4) {
        SimpleDraweeView r0 = new SimpleDraweeView(requireContext());
        r0.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        if ((r4 instanceof DoraObricGlassesImageResource.RemoteUrl) == false) goto L8;
        DoraObricGlassesImageResource.RemoteUrl r5 = (DoraObricGlassesImageResource.RemoteUrl) r4;
        if ((!StringsKt.isBlank(r5.getUrl())) == false) goto L14;
        ImageLoaderKt.u(r0, r5.getUrl(), "dora_obric_glasses_basic_detail");
    L14:
        GradientDrawable r6 = new GradientDrawable();
        r6.setShape(0);
        r6.setColor(la0(2131103057));
        r0.setBackground(r6);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r0;
    L8:
        if ((r4 instanceof DoraObricGlassesImageResource.Apk) == false) goto L11;
        r0.setActualImageResource(((DoraObricGlassesImageResource.Apk) r4).getResId());
        goto L14
    L11:
        if ((r4 instanceof DoraObricGlassesImageResource.FileUri) == false) goto L13;
        r0.setImageURI(((DoraObricGlassesImageResource.FileUri) r4).getUri());
        goto L14
    L13:
        if (r4 == null) goto L14;
        throw new NoWhenBranchMatchedException();
    }

    public final View ja0(int r4) {
        View r0 = new View(requireContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, c7.b(Integer.valueOf(r4))));
        return r0;
    }

    public final int la0(int r2) {
        return ContextCompat.getColor(requireContext(), r2);
    }

    public final b1 qa0(int r3) {
        y r0 = ta0();
        if (r0 != null) goto L6;
        return null;
    L6:
        b1 r4 = (b1) CollectionsKt.getOrNull(r0.e, r3);
        if (r4 == null) goto L9;
        return r4;
    L9:
        return r0.d;
    }

    public final b1 sa0(int r3) {
        y r0 = ta0();
        if (r0 != null) goto L6;
        return null;
    L6:
        b1 r4 = (b1) CollectionsKt.getOrNull(r0.e, r3);
        if (r4 == null) goto L9;
        return r4;
    L9:
        return r0.d;
    }

    public final DoraObricGlassesImageResource ua0(int r3) {
        y r0 = ta0();
        if (r0 != null) goto L6;
        return null;
    L6:
        DoraObricGlassesImageResource r4 = (DoraObricGlassesImageResource) CollectionsKt.getOrNull(r0.f, r3);
        if (r4 == null) goto L9;
        return r4;
    L9:
        return (DoraObricGlassesImageResource) CollectionsKt.firstOrNull(r0.f);
    }

    public final View aa0(b1 r13, DoraObricGlassesImageResource r14) {
        Context r0 = requireContext();
        LottieAnimationView r8 = new LottieAnimationView(r0);
        r8.setRepeatMode(1);
        r8.setRepeatCount(0);
        r8.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ((ArrayList) this.l).add(r8);
        View r10 = Z90(r0);
        View r11 = ba0(r8);
        W90(r8, r10, r11, r13, true, false);
        FrameLayout r15 = new FrameLayout(r0);
        r15.setClipToOutline(true);
        r15.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r15.setBackground(ka0());
        r15.addView(da0(r14));
        r15.addView(r8);
        r15.addView(r10);
        r15.addView(r11);
        r15.setLayoutParams(fa0());
        return r15;
    }

    public final View ga0(int r13, final List<b> r14) {
        LinearLayout r0 = new LinearLayout(requireContext());
        r0.setOrientation(1);
        TextView r2 = new TextView(requireContext());
        r2.setText(getString(r13));
        r2.setTextSize(12.0f);
        r2.setTextColor(la0(2131104359));
        TextViewCompat.setLineHeight(r2, c7.e(Float.valueOf(32.0f)));
        r2.setPadding(c7.b(20), 0, 0, 0);
        r2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r0.addView(r2);
        int r3 = 8;
        r0.addView(ja0(8));
        int r4 = r14.size();
        final LinearLayout r7 = new LinearLayout(requireContext());
        r7.setOrientation(0);
        r7.setGravity(17);
        r7.setPadding(c7.b(4), c7.b(4), c7.b(4), c7.b(4));
        va0(r7, r4, 0);
        final ViewPager2 r5 = new ViewPager2(requireContext());
        r5.setAdapter(new c(this, r14));
        r5.setOffscreenPageLimit(1);
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, c7.b(218)));
        ViewPager2.OnPageChangeCallback r8 = new DoraObricGlassesBasicDetailFragment$buildLightGuideCarousel$callback$1(this, r7, r14);
        r5.registerOnPageChangeCallback(r8);
        ((ArrayList) this.k).add(TuplesKt.to(r5, r8));
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-2, -2);
        r9.gravity = 1;
        r9.topMargin = c7.b(16);
        r9.bottomMargin = c7.b(20);
        r7.setLayoutParams(r9);
        if (r14.size() <= 1) goto L5;
        r3 = 0;
    L5:
        r7.setVisibility(r3);
        r7.post(new s(this, r7, r14, r5));
        LinearLayout r15 = new LinearLayout(requireContext());
        r15.setOrientation(1);
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setCornerRadius(c7.b(20));
        r1.setColor(pa0());
        r15.setBackground(r1);
        r15.addView(r5);
        r15.addView(r7);
        r15.setPadding(0, 0, 0, 0);
        r15.setLayoutParams(ea0());
        r0.addView(r15);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r0;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        na0();
    }

    public final View X90(int r4, int r5, int r6) {
        String r7 = getString(r4);
        String r8 = getString(r5);
        y r0 = ta0();
        DoraObricGlassesImageResource r1 = null;
        if (r0 != null) goto L5;
        b1 r2 = null;
    L6:
        y r3 = ta0();
        if (r3 == null) goto L11;
        r1 = (DoraObricGlassesImageResource) CollectionsKt.getOrNull(r3.f, r6);
    L11:
        return ha0(r7, r8, r2, r1);
    L5:
        r2 = (b1) CollectionsKt.getOrNull(r0.e, r6);
        goto L6
    }

    public final View ia0(int r4, int r5, int r6) {
        String r7 = getString(r4);
        String r8 = getString(r5);
        y r0 = ta0();
        DoraObricGlassesImageResource r1 = null;
        if (r0 != null) goto L5;
        b1 r2 = null;
    L6:
        y r3 = ta0();
        if (r3 == null) goto L11;
        r1 = (DoraObricGlassesImageResource) CollectionsKt.getOrNull(r3.f, r6);
    L11:
        return ha0(r7, r8, r2, r1);
    L5:
        r2 = (b1) CollectionsKt.getOrNull(r0.e, r6);
        goto L6
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        Bundle r12 = getArguments();
        if (r12 == null) goto L5;
        String r13 = r12.getString("mac");
    L6:
        this.g = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L9;
        String r15 = r14.getString("arg_basic_items");
    L10:
        x r16 = new x();
        s0 r0 = s0.a;
        Type r17 = r16.getType();
        r0.getClass();
        List<y> r18 = (List) s0.a(r15, r17);
        if (r18 != null) goto L13;
        r18 = CollectionsKt.emptyList();
    L13:
        this.h = r18;
        Bundle r20 = getArguments();
        if (r20 == null) goto L16;
        String r21 = r20.getString("arg_selected_item_key");
    L17:
        this.i = r21;
        Bundle r22 = getArguments();
        if (r22 == null) goto L20;
        String r23 = r22.getString("arg_selected_item_title");
    L21:
        this.j = r23;
        Context r24 = requireContext();
        NestedScrollView r110 = new ONestedScrollView(r24, null, 6, 0);
        r110.setFillViewport(true);
        r110.setClipChildren(true);
        r110.setClipToPadding(false);
        r110.setOverScrollMode(2);
        int r4 = c7.b(12);
        if (ra0() == BasicDetailPageType.LIST) goto L24;
        int r5 = 16;
    L25:
        int r6 = c7.b(Integer.valueOf(r5));
        int r3 = c7.b(12);
        com.larus.utils.i0.a.getClass();
        r110.setPadding(r4, r6, r3, com.larus.utils.i0.e() + c7.b(24));
        LinearLayout r7 = new LinearLayout(r24);
        r7.setOrientation(1);
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        this.f = r7;
        r110.addView(r7, new ViewGroup.LayoutParams(-1, -2));
        final OFloatingTitleBar r8 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.setBackgroundColor(la0(2131103059));
        String r25 = this.i;
        if (Intrinsics.areEqual(r25, "media") == false) goto L29;
        Integer r26 = 2131903559;
    L32:
        if (r26 == null) goto L35;
        String r27 = getString(r26.intValue());
        if (r27 == null) goto L35;
    L43:
        r8.setCenterTitle(r27);
        r8.setCenterTitleColor(la0(2131104350));
        r8.getCenterTitleView().setTextColor(la0(2131104350));
        r8.R(false);
        OFloatingTitleBar.k(r8, null, 6).setOnClickListener(new q(this));
        ViewCompat.setOnApplyWindowInsetsListener(r8, new r(r8));
        ViewCompat.requestApplyInsets(r8);
        return com.larus.dora.obric.utils.c.c(r24, r8, r110, la0(2131103059), null);
    L35:
        r27 = this.j;
        if (r27 != null) goto L38;
    L40:
        r27 = null;
    L41:
        if (r27 != null) goto L43;
        r27 = getString(2131903606);
        goto L43
    L38:
        if ((true ^ StringsKt.isBlank(r27)) == false) goto L40;
    L29:
        if (Intrinsics.areEqual(r25, "light") == false) goto L31;
        r26 = 2131903515;
        goto L32
    L31:
        r26 = null;
        goto L32
    L24:
        r5 = 8;
        goto L25
    L20:
        r23 = null;
        goto L21
    L16:
        r21 = null;
        goto L17
    L9:
        r15 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    public final void va0(LinearLayout r9, int r10, int r11) {
        r9.removeAllViews();
        int r1 = 0;
    L3:
        if (r1 >= r10) goto L13;
        if (r1 != r11) goto L7;
        boolean r3 = true;
    L8:
        int r4 = la0(2131104350);
        if (r3 == true) goto L12;
        r4 = ColorUtils.setAlphaComponent(r4, 38);
    L12:
        FrameLayout r5 = new FrameLayout(requireContext());
        r5.setLayoutParams(new LinearLayout.LayoutParams(c7.b(8), c7.b(8)));
        View r6 = new View(r5.getContext());
        GradientDrawable r7 = new GradientDrawable();
        r7.setShape(1);
        r7.setColor(r4);
        r6.setBackground(r7);
        r6.setLayoutParams(new FrameLayout.LayoutParams(c7.b(4), c7.b(4), 17));
        r5.addView(r6);
        r9.addView(r5);
        r1 = r1 + 1;
        goto L3
    L7:
        r3 = false;
        goto L8
    }

    public final View ha0(String r6, String r7, b1 r8, DoraObricGlassesImageResource r9) {
        LinearLayout r0 = new LinearLayout(requireContext());
        r0.setOrientation(1);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        r2.setCornerRadius(c7.b(20));
        r2.setColor(pa0());
        r0.setBackground(r2);
        r0.addView(aa0(r8, r9));
        LinearLayout r10 = new LinearLayout(r0.getContext());
        r10.setOrientation(1);
        r10.setGravity(1);
        r10.setPadding(c7.b(20), c7.b(4), c7.b(20), c7.b(20));
        r10.addView(ca0(r6));
        r10.addView(ja0(8));
        r10.addView(Y90(r7));
        r0.addView(r10);
        r0.setLayoutParams(ea0());
        return r0;
    }

    public final void W90(LottieAnimationView r15, AppCompatImageView r16, View r17, b1 r18, boolean r110, boolean r20) {
        boolean r2 = false;
        if (r20 == false) goto L5;
        int r4 = 0;
    L6:
        r16.setVisibility(r4);
        if (r17 == null) goto L10;
        r17.setVisibility(8);
    L10:
        if (r18 == null) goto L16;
        String r0 = r18.a;
        if (r0 == null) goto L16;
        if ((!StringsKt.isBlank(r0)) == false) goto L16;
        String r5 = r0;
    L17:
        if (r5 != null) goto L19;
    L22:
        boolean r1 = true;
    L24:
        if (r1 == false) goto L27;
        g49.d.e("DoraObricGlassesBasicDetailFragment", "skip media detail lottie because resource is empty");
        return;
    L27:
        File r3 = new PolarisFileWrapper(r5);
        if (r3.isFile() == true) goto L30;
    L32:
        if (r2 == false) goto L34;
        File r8 = r3;
    L35:
        if (r8 != null) goto L38;
        g49.d.e("DoraObricGlassesBasicDetailFragment", "skip media detail lottie because json file is invalid: path=" + r5);
        return;
    L38:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGlassesBasicDetailFragment$bindDetailLottie$1(r16, r20, r15, r5, r8, r110, r17, null), 3, null);
        return;
    L34:
        r8 = null;
        goto L35
    L30:
        if (StringsKt.endsWith(r5, ".json", true) == false) goto L32;
        r2 = true;
        goto L32
    L19:
        if (StringsKt.isBlank(r5) == true) goto L22;
        r1 = false;
    L16:
        r5 = null;
        goto L17
    L5:
        r4 = 8;
        goto L6
    }
}
