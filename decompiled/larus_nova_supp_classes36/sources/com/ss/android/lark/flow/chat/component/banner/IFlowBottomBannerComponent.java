package com.ss.android.lark.flow.chat.component.banner;

import android.view.View;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowBanner;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.scaffold.IComponent;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/flow/chat/component/banner/IFlowBottomBannerComponent;", "Lcom/ss/android/lark/scaffold/IComponent;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowBanner;", "getRootView", "Landroid/view/View;", "addBannerSizeChangeListener", "", "listener", "Lcom/ss/android/lark/widget/listener/OnSizeChangeListener;", "removeBannerSizeChangeListener", "setBannerVisibility", "showBanner", "", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface IFlowBottomBannerComponent extends IComponent, ChatWindowBanner {
    View getRootView();

    void hO(boolean r1);
}
