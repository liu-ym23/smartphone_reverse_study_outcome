package com.obric.memorydata.recommend.settings;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$J\u0014\u0010%\u001a\u00020!*\u00020\"2\u0006\u0010&\u001a\u00020'H\u0003J \u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020'H\u0002J\b\u00102\u001a\u00020!H\u0002J\u0006\u00103\u001a\u00020!J\u0006\u00104\u001a\u00020!J\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u000fH\u0002J\b\u00107\u001a\u00020!H\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\n \u0013*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0018\u0010\u001c\u001a\n \u0013*\u0004\u0018\u00010\u001d0\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0018\u0010\u001f\u001a\n \u0013*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/memorydata/recommend/settings/HeaderViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "activity", "Landroidx/activity/ComponentActivity;", "viewModel", "Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "getViewModel", "()Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "hasBind", "", "dialog", "Lcom/obric/oui/sheet/OInsetSheet;", "bannerCard", "kotlin.jvm.PlatformType", "Landroid/view/View;", "bannerTouchHost", "Lcom/obric/memorydata/ui/banner/OBannerTouchHost;", "indicator", "Lcom/obric/oui/indicator/OCarouselIndicator;", "screenObservationMemorySwitch", "Lcom/obric/oui/lisitem/OCardListItem;", "Lcom/obric/oui/lisitem/OCardListItem;", "screenObservationDisabledStatusTips", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "recommendMemory", "setPageSpacing", "", "Landroidx/viewpager2/widget/ViewPager2;", "pageMargin", "", "setupPageSpacingTouchHandling", "pageMarginPx", "", "isTouchInValidPageArea", "viewPager", "event", "Landroid/view/MotionEvent;", "banner", "Lcom/obric/oui/banner/OBanner;", "getBanner", "()Lcom/obric/oui/banner/OBanner;", "proactiveMemoryCheckListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "showDisableMemoryDialog", "bindView", "refreshThemeBackground", "updateMemorySwitchStatus", "check", "updateProactiveMemoryStatusText", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f12609b;
    private final OCardListItem t;
    private final TextView u;
    private final CompoundButton.OnCheckedChangeListener v;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/settings/HeaderViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "OUI_BANNER_MATERIAL_EDGE_INSET_PX", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12608a = new a(null);
    }

    private final ScreenObservationCategoryViewModel a() {
        return (ScreenObservationCategoryViewModel) ZeusTransformUtils.preCheckCast(this.f12609b.getValue(), ScreenObservationCategoryViewModel.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ScreenObservationCategoryViewModel a(j r0) {
        return r0.a();
    }

    public static final /* synthetic */ void a(j r0, boolean r1) {
        r0.a(r1);
    }

    private final void a(boolean r3) {
        OSwitch r0 = this.t.getEndSwitch();
        if (r0 == null) goto L6;
        r0.setOnCheckedChangeListener(null);
        r0.setChecked(r3);
        r0.setOnCheckedChangeListener(this.v);
        return;
    }

    private final void b() {
        if (com.obric.memorydata.recommend.feature.a.f12505a.e() == false) goto L11;
        String r0 = com.obric.memorydata.recommend.feature.a.f12505a.f();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        this.u.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.screen_observation_temporary_disabled, TypedValues.Custom.S_STRING, "screen_observation_temporary_disabled"), new Object[]{r0}), CharSequence.class, "com.obric.memorydata.plugin"));
        this.u.setVisibility(0);
        return;
    L7:
        r1 = false;
    L11:
        this.u.setVisibility(8);
    }

    public static final /* synthetic */ void b(j r0) {
        r0.b();
    }
}
