package com.ss.android.lark.maintab.export.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.e;
import com.ss.android.lark.widget.tab.NavigationTabItemView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vqb.b;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\b\u0016\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020%J$\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u00132\u0006\u0010,\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010.\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u001bJ\u0010\u00100\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u00010\u0015J\u0006\u00102\u001a\u00020%J\u001c\u00103\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u00132\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020\u0017H\u0016J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\tH\u0016J)\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u00010\t2\b\u00109\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010:J\u0010\u00106\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0015H\u0016J\u0017\u0010<\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\tH\u0016J\b\u0010@\u001a\u00020%H\u0016J\b\u0010A\u001a\u00020\u0017H\u0016J\u0018\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H\u0016J\u0018\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u0013H\u0016J\u0006\u0010H\u001a\u00020%J\u0006\u0010I\u001a\u00020%J\b\u0010J\u001a\u00020%H\u0002J\b\u0010K\u001a\u00020%H\u0014J\b\u0010L\u001a\u00020%H\u0014J\u0010\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020\tH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/ss/android/lark/maintab/export/view/NavTabBarView;", "Lcom/ss/android/lark/widget/tab/NavigationTabItemView;", "Lcom/ss/android/lark/maintab/export/ITabBadgeController;", "Lcom/ss/android/lark/maintab/export/view/ITabBarViewAction;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "redDotView", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "badgeHelper", "Lcom/ss/android/lark/maintab/export/TabBadgeHelper;", "currentConfig", "Lcom/ss/android/lark/maintab/export/TabBarConfig;", "baselineLogo", "Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "baselineTitle", "", "hasAppearanceApplied", "", "badgeAnchorView", "Landroid/widget/Space;", "defaultIcon", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDefaultIcon", "()Landroid/graphics/drawable/Drawable;", "defaultIcon$delegate", "Lkotlin/Lazy;", "loadingView", "Lcom/airbnb/lottie/LottieAnimationView;", "isBadgeShouldShow", "addBadgeAnchor", "", "addDeleteIcon", "listener", "Landroid/view/View$OnClickListener;", "removeDeleteIcon", "bind", "logo", "remoteName", "config", "applyAppearanceIcon", "icon", "applyAppearanceTitle", "title", "restoreBaseline", "bindIcon", "setRemindInNav", "isRemind", "showBadge", "count", "textColor", "bgColorRes", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "text", "showRedDotBadge", "(Ljava/lang/Integer;)V", "showIconBadge", "iconRes", "hideBadge", "isBadgeShow", "updateTabName", "oldName", "newName", "updateLogo", "oldLogo", "newLogo", "startLoadingAnim", "stopLoadingAnim", "makeRedDotHide", "onAttachedToWindow", "onDetachedFromWindow", "initLoadingView", "animationRes", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class NavTabBarView extends NavigationTabItemView {
    public final e g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public NavTabBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NavTabBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Drawable getDefaultIcon() {
        return (Drawable) this.h.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    public void setRemindInNav(boolean r1) {
        this.g.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NavTabBarView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        Intrinsics.checkNotNullParameter(r4, "context");
        UDBadgeView r7 = new UDBadgeView(r4, null, 0, 2131953819);
        String r8 = r7.h;
        if (r8 == null) goto L5;
        r7.setText(r8);
    L5:
        Drawable r9 = r7.m;
        if (r9 == null) goto L8;
        r7.setIcon(r9);
    L8:
        r7.b();
        this.g = new e(r4, r7);
        Space r10 = new Space(r4);
        this.h = LazyKt.lazy(NavTabBarView$defaultIcon$2.INSTANCE);
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-2, -2);
        r11.bottomToTop = 2131377467;
        r11.startToEnd = 2131377467;
        ((ViewGroup.MarginLayoutParams) r11).bottomMargin = d.a(4);
        r11.setMarginStart(d.a(4));
        r10.setId(2131375857);
        addView(r10, r11);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-2, -2);
        r12.topToTop = 2131375857;
        r12.endToEnd = 2131375857;
        r7.setVisibility(8);
        addView(r7, r12);
        if (b.a().enableFgMainTabContainer() == false) goto L11;
        int r13 = 2131100566;
    L12:
        setIconBgColor(r13);
        return;
    L11:
        r13 = 2131108731;
        goto L12
    }

    public /* synthetic */ NavTabBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
