package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowBanner;
import com.ss.android.lark.scaffold.IComponent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0012J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/banner/IBannerComponent;", "Lcom/ss/android/lark/scaffold/IComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowBanner$IBannerComponentCallbacks;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowBanner;", "getRootView", "Landroid/view/View;", "addBannerSizeChangeListener", BuildConfig.FLAVOR, "listener", "Lcom/ss/android/lark/widget/listener/OnSizeChangeListener;", "removeBannerSizeChangeListener", "addBannerVisibilityListener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/banner/IBannerComponent$IBannerVisibilityListener;", "removeBannerVisibilityListener", "setBannerVisibility", "showBanner", BuildConfig.FLAVOR, "IBannerVisibilityListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBannerComponent extends IComponent, oxa.c<ChatWindowBanner.a>, ChatWindowBanner {

    public interface a {
        void a(int r1);

        void b(int r1);

        void c();
    }

    void jx(a r1);
}
