package com.ss.android.lark.maintab.export;

import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J\b\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\u0006H\u0017J\b\u0010\u000e\u001a\u00020\u0006H\u0017J\b\u0010\u000f\u001a\u00020\u0006H\u0017J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016¨\u0006+"}, d2 = {"Lcom/ss/android/lark/maintab/export/BaseTabFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/maintab/export/ITabAction;", "<init>", "()V", "needHandleBackPress", "", "tabScreenStyle", "Lcom/ss/android/lark/maintab/export/TabScreenStyle;", "hostActivity", "Landroidx/fragment/app/FragmentActivity;", "forsetiPlaceHolderFragment", "Lcom/ss/android/lark/api/ui/ForsetiPlaceHolderFragment;", "alwaysShowPlaceHolderFragment", "draggingEnabled", "isDynamicSplit", "forsetiExtensionModel", "Lcom/ss/android/lark/maintab/export/model/TabForsetiExtensionModel;", "onBind", "", "tabAppInfo", "Lcom/ss/android/lark/maintab/export/TabAppInfo;", "titleController", "Lcom/ss/android/lark/maintab/export/ITitleController;", "menuController", "Lcom/ss/android/lark/maintab/export/IMenuController;", "onPageSelect", "tabSite", "Lcom/ss/android/lark/maintab/export/TabSite;", "tabIndex", "", "onPageUnSelect", "execCommand", "bundle", "Landroid/os/Bundle;", "getTabTitleConfig", "Lcom/ss/android/lark/maintab/export/ITabTitleConfig;", "onSingleClick", "onLongClick", "onTabDoubleClickedListener", "onUpdateTabInfo", "processNewIntent", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class BaseTabFragment extends BaseFragment implements b {

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.maintab.export.b
    public void t40(TabAppInfo r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "tabAppInfo");
        Intrinsics.checkNotNullParameter(r3, "titleController");
        Intrinsics.checkNotNullParameter(null, "menuController");
    }

    public BaseTabFragment() {
    }
}
