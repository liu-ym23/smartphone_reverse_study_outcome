package com.obric.assistant.common.spi;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\n\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0012H\u0016J\u001c\u0010)\u001a\u00020\u00052\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+H\u0016J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020-H\u0016J\b\u00101\u001a\u00020!H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020!H\u0016J\b\u00104\u001a\u00020!H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\bH\u0016¨\u00067"}, d2 = {"Lcom/obric/assistant/common/spi/DefaultObricUIService;", "Lcom/obric/assistant/common/spi/IObricUIService;", "<init>", "()V", "changeFontSizeToSP", NameKeys.UnloadStrategy_No_Strategy, "textViews", NameKeys.UnloadStrategy_No_Strategy, "Landroid/widget/TextView;", "([Landroid/widget/TextView;)V", "toSPBasedPixelSize", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "dpBasedPixelSize", NameKeys.UnloadStrategy_No_Strategy, "setChatRootBottomPadding", "chatRoot", "Landroid/view/View;", "navigationBarHeight", "getNavigationBarHeightFallback", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Ljava/lang/Integer;", "getMentionPanelMaxHeight", "panelView", "currentMaxHeight", "(Landroid/view/View;I)Ljava/lang/Integer;", "onSideBarContentViewCreated", "contentView", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isWindowLandscape", NameKeys.UnloadStrategy_No_Strategy, "actionMenuEntrance", "enableActionBarMenuFocusable", "enableInterceptSwitchMenuView", "enableInterceptSwitchMenuOutsideTouch", "applyResourceBarStyle", "viewType", "itemView", "setTagForBottomMenuIcon", "iconMap", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Landroid/widget/ImageView;", "applySuggestedActionBarStyle", "textView", "iconView", "disableSwDpOffline", "onEnterSelectMode", "isWindowHost", "isMultiTaskNewChatNavEntryEnabledWhenEnterprise", "setupInputPanelHeader", "Companion", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricUIService implements IObricUIService {

    public static final class a {
    }

    static {
    }

    public DefaultObricUIService() {
    }

    public final int b(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "chatRoot");
        return r3;
    }

    public final void ia(Map<String, ? extends ImageView> r2) {
        Intrinsics.checkNotNullParameter(r2, "iconMap");
    }

    public final boolean ja(View r2) {
        Intrinsics.checkNotNullParameter(r2, "actionMenuEntrance");
        return false;
    }

    public final Integer ka(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return null;
    }

    public final boolean la() {
        return false;
    }

    public final boolean ma() {
        return true;
    }

    public final void na(TextView... r2) {
        Intrinsics.checkNotNullParameter(r2, "textViews");
    }

    public final void oa(TextView r2, AppCompatImageView r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        Intrinsics.checkNotNullParameter(r3, "iconView");
    }

    public final void pa() {
    }

    public final void qa(ConstraintLayout r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "contentView");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
    }

    public final boolean ra() {
        return false;
    }

    public final boolean sa() {
        return true;
    }

    public final void ta(int r1, View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
    }

    public final int ua(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r3;
    }

    public final float va(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r3;
    }

    public final void wa(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
    }

    public final void xa(boolean r1) {
    }
}
