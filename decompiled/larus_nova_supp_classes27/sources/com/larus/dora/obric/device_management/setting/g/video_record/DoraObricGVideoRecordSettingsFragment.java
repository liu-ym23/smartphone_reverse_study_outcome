package com.larus.dora.obric.device_management.setting.g.video_record;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.media.MediaSettingsViewModel;
import com.larus.dora.impl.device.settings.media.a0;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 _2\u00020\u0001:\u0003]^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u001cH\u0002J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002J\u0014\u0010*\u001a\u00020\u001c*\u00020\u00132\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0013H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0013H\u0002J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0302H\u0002J\u0014\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0302H\u0002JK\u00105\u001a\u00020\u001c\"\u0004\b\u0000\u001062\u0006\u0010.\u001a\u00020\u00132\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H603022\u0006\u00108\u001a\u0002H62\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u00020\u001c0:H\u0002¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020)H\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020)H\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020)H\u0002J&\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020 2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0FH\u0002J\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0018\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020)H\u0002J\u0010\u0010L\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010M\u001a\u00020)H\u0002J\b\u0010N\u001a\u00020)H\u0002J\b\u0010O\u001a\u00020)H\u0002J\u0014\u0010P\u001a\u00020\u001c*\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010S\u001a\u00020\u001c*\u00020T2\u0006\u0010(\u001a\u00020)2\u0006\u0010U\u001a\u00020)H\u0002J\f\u0010V\u001a\u00020\u001c*\u00020WH\u0002J\f\u0010X\u001a\u00020\u001c*\u00020YH\u0002J\f\u0010Z\u001a\u00020)*\u00020)H\u0002J\f\u0010[\u001a\u00020)*\u00020\\H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/video_record/DoraObricGVideoRecordSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/device/settings/media/MediaSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/media/MediaSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "contentContainer", "Landroid/widget/LinearLayout;", "activePopover", "Lcom/obric/oui/popover/v2/OPopover;", "pageMaskView", "Landroid/view/View;", "itemViews", "", "Lcom/larus/dora/obric/device_management/setting/g/video_record/DoraObricGVideoRecordSettingsFragment$VideoRecordSettingItem;", "Lcom/obric/oui/lisitem/OCardListItem;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "renderSettings", "buildSettingItem", "item", "position", "", "bindDropEnd", "observeVideoRecordConfig", "bindCurrentConfig", "showResolutionMenu", "anchor", "showRatioMenu", "showDurationMenu", "buildRatioOptions", "", "Lcom/larus/dora/obric/device_management/setting/g/video_record/DoraObricGVideoRecordSettingsFragment$VideoRecordMenuOption;", "buildDurationOptions", "showMenu", "T", "options", "selectedValue", "onSelected", "Lkotlin/Function1;", "(Lcom/obric/oui/lisitem/OCardListItem;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "updateResolution", "resolution", "updateRatio", "ratio", "updateDuration", "duration", "showConfirmDialog", "title", "msg", "onConfirm", "Lkotlin/Function0;", "currentVideoRecordConfig", "Lcom/larus/dora/api/model/FlowDoraVideoRecordConfig;", "resolveCardPosition", "index", "lastIndex", "titleFor", "resolveBackgroundColor", "resolveSecondaryTextColor", "resolvePrimaryTextColor", "applyCardStyle", "sectionTopPadding", "sectionBottomPadding", "applySectionCornerRadii", "Landroid/graphics/drawable/GradientDrawable;", "radiusDp", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "applyDropIconStyle", "Landroid/widget/ImageView;", "dp", "sp", "", "VideoRecordSettingItem", "VideoRecordMenuOption", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGVideoRecordSettingsFragment extends DoraBaseFragment {
    public static final List<VideoRecordSettingItem> k = null;
    public final Lazy f;
    public LinearLayout g;
    public com.obric.oui.popover.v2.c h;
    public View i;
    public final Map<VideoRecordSettingItem, OCardListItem> j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/video_record/DoraObricGVideoRecordSettingsFragment$VideoRecordSettingItem;", "", "<init>", "(Ljava/lang/String;I)V", "RESOLUTION", "RATIO", "DURATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum VideoRecordSettingItem extends Enum<VideoRecordSettingItem> {
        public static final VideoRecordSettingItem DURATION = null;
        public static final VideoRecordSettingItem RATIO = null;
        public static final VideoRecordSettingItem RESOLUTION = null;
        public static final /* synthetic */ VideoRecordSettingItem[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<VideoRecordSettingItem> getEntries() {
            return b;
        }

        static {
            VideoRecordSettingItem r0 = new VideoRecordSettingItem("RESOLUTION", 0);
            RESOLUTION = r0;
            VideoRecordSettingItem r1 = new VideoRecordSettingItem("RATIO", 1);
            RATIO = r1;
            VideoRecordSettingItem r3 = new VideoRecordSettingItem("DURATION", 2);
            DURATION = r3;
            VideoRecordSettingItem[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static VideoRecordSettingItem[] values() {
            return (VideoRecordSettingItem[]) a.clone();
        }

        public static VideoRecordSettingItem valueOf(String r1) {
            return (VideoRecordSettingItem) r27.a.a(VideoRecordSettingItem.class, r1);
        }

        public VideoRecordSettingItem(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b<T> {
        public final T a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            T r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
            String r4 = this.c;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "VideoRecordMenuOption(value=" + this.a + ", title=" + this.b + ", subTitle=" + this.c + ')';
        }

        public b(T r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "title");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VideoRecordSettingItem.values().length];
            r0[VideoRecordSettingItem.RESOLUTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[VideoRecordSettingItem.RATIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[VideoRecordSettingItem.DURATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final String k() {
        return "media_setting";
    }

    static {
        k = CollectionsKt.listOf(new VideoRecordSettingItem[]{VideoRecordSettingItem.RESOLUTION, VideoRecordSettingItem.RATIO, VideoRecordSettingItem.DURATION});
    }

    public final MediaSettingsViewModel ca0() {
        return (MediaSettingsViewModel) this.f.getValue();
    }

    public final void onDestroyView() {
        com.obric.oui.popover.v2.c r0 = this.h;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.h = null;
        this.g = null;
        this.i = null;
        ((LinkedHashMap) this.j).clear();
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricGVideoRecordSettingsFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaSettingsViewModel.class), new DoraObricGVideoRecordSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGVideoRecordSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.j = new LinkedHashMap();
    }

    public final void Z90() {
        FlowDoraVideoRecordConfig r0 = aa0();
        if (r0 != null) goto L5;
        return;
    L5:
        g49.d.d("DoraObricGVideoRecordSettingsFragment", "bind video record config = " + r0);
        OCardListItem r1 = (OCardListItem) ((LinkedHashMap) this.j).get(VideoRecordSettingItem.RESOLUTION);
        if (r1 == null) goto L8;
        r1.k(ca0().getVideoQualityTxt(r0), ba0(96));
    L8:
        OCardListItem r2 = (OCardListItem) ((LinkedHashMap) this.j).get(VideoRecordSettingItem.RATIO);
        if (r2 == null) goto L11;
        r2.k(ca0().getVideoAspectRatioTxt(Integer.valueOf(r0.c)), ba0(96));
    L11:
        OCardListItem r3 = (OCardListItem) ((LinkedHashMap) this.j).get(VideoRecordSettingItem.DURATION);
        if (r3 == null) goto L14;
        r3.k(ca0().getVideoDurationTxtByDur(r0.a), ba0(96));
    L14:
        Iterator<T> r4 = k.iterator();
    L16:
        if (r4.hasNext() == false) goto L23;
        OCardListItem r5 = (OCardListItem) ((LinkedHashMap) this.j).get((VideoRecordSettingItem) r4.next());
        if (r5 == null) goto L16;
        OTextView r6 = r5.getEndDetail();
        if (r6 == null) goto L22;
        Y90(r6);
    L22:
        W90(r5.getTailIconView());
        goto L16
    }

    public final FlowDoraVideoRecordConfig aa0() {
        Object r0 = ca0().getMediaVideoRecordConfig().getValue();
        if ((r0 instanceof a0.a) == false) goto L5;
        a0.a r1 = (a0.a) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.a;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.i;
    }

    public final void W90(ImageView r4) {
        r4.setImageTintList(ContextCompat.getColorStateList(r4.getContext(), 2131104363));
        r4.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 == null) goto L5;
        r0.width = ba0(20);
        r0.height = ba0(20);
    L6:
        r4.setLayoutParams(r0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void Y90(OTextView r4) {
        r4.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r4.setTextSize(2, 14.0f);
        Resources r0 = getResources();
        TextViewCompat.setLineHeight(r4, (int) TypedValue.applyDimension(2, 18.0f, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
    }

    public final int ba0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final String fa0(VideoRecordSettingItem r2) {
        int r3 = c.a[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return getString(2131902675);
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return getString(2131902690);
    L13:
        return getString(2131902692);
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        LinearLayout r16 = this.g;
        if (r16 == null) goto L55;
        ((LinkedHashMap) this.j).clear();
        r16.removeAllViews();
        if (ca0().isSupportVideoCfg() == false) goto L53;
        Iterator<T> r0 = k.iterator();
        int r2 = 0;
    L9:
        if (r0.hasNext() == false) goto L54;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        final VideoRecordSettingItem r5 = (VideoRecordSettingItem) r3;
        int r6 = CollectionsKt.getLastIndex(k);
        if (r6 != 0) goto L16;
        int r7 = 0;
    L21:
        final OCardListItem r8 = new OCardListItem(requireContext(), null, 6, 0);
        this.j.put(r5, r8);
        r8.setCardType(0);
        OCardListItem.h(r8, r7);
        r8.setShowCardBg(true);
        r8.p(false);
        r8.setTitle(fa0(r5));
        r8.s(true);
        r8.q(false);
        r8.setDefaultCustomEndView(3);
        r8.m(true);
        r8.k("", ba0(96));
        OTextView r9 = r8.getEndDetail();
        if (r9 == null) goto L24;
        Y90(r9);
    L24:
        r8.setTailIcon(2131245082);
        W90(r8.getTailIconView());
        r8.r(true);
        r8.setOnContentClickListener(new com.larus.dora.obric.device_management.setting.g.video_record.a(r5, this, r8));
        ViewGroup.LayoutParams r10 = r8.getCardContainer().getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L28:
        if (r11 == null) goto L30;
        r11.setMarginStart(0);
        r11.setMarginEnd(0);
        r11.leftMargin = 0;
        r11.rightMargin = 0;
        r8.getCardContainer().setLayoutParams(r11);
    L30:
        FrameLayout r12 = r8.getCardContainer();
        int r13 = ba0(8);
        if (r7 == 0) goto L34;
        if (r7 == 1) goto L34;
        int r17 = 0;
    L35:
        int r18 = ba0(8);
        if (r7 == 0) goto L39;
        if (r7 == 3) goto L39;
        int r20 = 0;
    L40:
        r12.setPadding(r13, r17, r18, r20);
        r8.getContentContainer().setPadding(0, 0, ba0(4), 0);
        r8.getTitleContainer().setGravity(16);
        r8.getTitleContainer().setPadding(ba0(12), ba0(5), ba0(8), ba0(5));
        OTextView r21 = r8.getTitleView();
        r21.setGravity(8388611);
        r21.setMaxLines(1);
        r21.setTextSize(2, 16.0f);
        Resources r22 = getResources();
        TextViewCompat.setLineHeight(r21, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics())));
        r21.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r8.o(false);
        Drawable r23 = r8.getCardContainer().getBackground();
        if ((r23 instanceof GradientDrawable) == false) goto L43;
        GradientDrawable r24 = (GradientDrawable) r23;
    L44:
        if (r24 == null) goto L46;
        X90(r24, r7, 20);
    L46:
        Drawable r25 = r8.getContentContainer().getBackground();
        if ((r25 instanceof GradientDrawable) == false) goto L49;
        GradientDrawable r26 = (GradientDrawable) r25;
    L50:
        if (r26 == null) goto L52;
        X90(r26, r7, 12);
    L52:
        r16.addView(r8);
        r2 = r4;
        goto L9
    L49:
        r26 = null;
        goto L50
    L43:
        r24 = null;
    L39:
        r20 = ba0(8);
    L34:
        r17 = ba0(8);
        goto L35
    L27:
        r11 = null;
        goto L28
    L16:
        if (r2 != 0) goto L18;
        r7 = 1;
        goto L21
    L18:
        if (r2 != r6) goto L20;
        r7 = 3;
        goto L21
    L20:
        r7 = 2;
    L54:
        Z90();
        goto L55
    L53:
        g49.d.d("DoraObricGVideoRecordSettingsFragment", "video record config is not supported");
    L55:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGVideoRecordSettingsFragment$observeVideoRecordConfig$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
    }

    public final void X90(GradientDrawable r11, int r12, int r13) {
        float r14 = ba0(r13);
        if (r12 != 0) goto L5;
        float[] r15 = {r14, r14, r14, r14, r14, r14, r14, r14};
    L11:
        r11.setCornerRadii(r15);
        return;
    L5:
        if (r12 == 1) goto L9;
        if (r12 == 3) goto L8;
        r15 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L11
    L8:
        r15 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r14, r14, r14, r14};
        goto L11
    L9:
        r15 = new float[]{r14, r14, r14, r14, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L11
    }

    public final void da0(String r3, String r4, final Function0<Unit> r5) {
        int r0 = j49.a.a;
        j49.a.i();
        com.obric.oui.dialog.v2.alert.g r1 = new com.obric.oui.dialog.v2.alert.g(requireContext());
        ((com.obric.oui.dialog.base.i) r1).c = true;
        r1.w = false;
        r1.j = false;
        r1.h = r3;
        r1.i = r4;
        com.obric.oui.dialog.v2.alert.g.c(r1);
        int r6 = j0.a;
        r1.e(j0.d(2131902465), new com.larus.dora.obric.device_management.setting.g.video_record.b());
        r1.h(j0.d(2131902635), new com.larus.dora.obric.device_management.setting.g.video_record.c(r5));
        com.obric.oui.dialog.v2.alert.c r7 = r1.a();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Context r13 = requireContext();
        OFloatingTitleBar r14 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r14.setClipChildren(false);
        r14.setClipToPadding(false);
        r14.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r14.setCenterTitle(getString(2131902693));
        r14.R(false);
        OFloatingTitleBar.k(r14, null, 6).setOnClickListener(new g(this));
        Context r15 = requireContext();
        LinearLayout r0 = new LinearLayout(r15);
        r0.setOrientation(1);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setPadding(ba0(12), ba0(16), ba0(12), ba0(24));
        this.g = r0;
        NestedScrollView r1 = new NestedScrollView(r15);
        r1.setClipChildren(true);
        r1.setClipToPadding(false);
        r1.setOverScrollMode(2);
        r1.setFillViewport(true);
        r1.addView(this.g, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r13, r14, r1, v19.c.a(2130970531, requireContext(), 2131102535), new d(this));
    }

    public final <T> void ea0(final OCardListItem r18, List<b<T>> r110, T r20, final Function1<? super T, Unit> r21) {
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L5;
        return;
    L5:
        com.obric.oui.popover.v2.c r2 = this.h;
        if (r2 == null) goto L8;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L8:
        OPopoverEntranceMenuView.Builder r3 = new OPopoverEntranceMenuView.Builder(requireContext());
        r3.f(OPopoverEntranceMenuView.WidthLevel.WIDTH_LEVEL_BROAD);
        r3.h = true;
        r3.e = 1;
        Iterator<T> r14 = r110.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        final b r4 = (b) r14.next();
        r3.c(0, 0, 0, r4.b, r4.c, false, true, Intrinsics.areEqual(r4.a, r20), new j(this, r21, r4));
        goto L10
    L12:
        OPopoverEntranceMenuView r5 = r3.e();
        r5.setBackgroundColor(ContextCompat.getColor(r5.getContext(), R.color.transparent));
        com.obric.oui.popover.v2.c.a r6 = new com.obric.oui.popover.v2.c.a(r1);
        Intrinsics.checkNotNullParameter(r5, "view");
        ((com.obric.oui.popover.v2.h) r6).f = r5;
        ((com.obric.oui.popover.v2.h) r6).b = true;
        ((com.obric.oui.popover.v2.h) r6).i = true;
        ((com.obric.oui.popover.v2.h) r6).k = true;
        ((com.obric.oui.popover.v2.h) r6).j = true;
        ((com.obric.oui.popover.v2.h) r6).n = true;
        ((com.obric.oui.popover.v2.h) r6).l = true;
        final com.obric.oui.popover.v2.c r7 = r6.a();
        this.h = r7;
        r18.getTailIconView().post(new k(r7, r18));
    }
}
