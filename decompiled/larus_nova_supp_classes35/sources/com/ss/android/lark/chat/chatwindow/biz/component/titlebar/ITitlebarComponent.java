package com.ss.android.lark.chat.chatwindow.biz.component.titlebar;

import android.view.View;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowTitleBar;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin;
import com.ss.android.lark.scaffold.IComponent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0007BCDEFGHJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0019\u001a\u0004\u0018\u00010\bH&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\bH&J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001fH&J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001fH&J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001fH&J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H&J\u0010\u0010,\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H&J\u0010\u0010-\u001a\u00020\n2\u0006\u0010*\u001a\u00020.H&J\u0010\u0010/\u001a\u00020\n2\u0006\u0010*\u001a\u00020.H&J\u0010\u00100\u001a\u00020\n2\u0006\u0010*\u001a\u000201H&J\u0010\u00102\u001a\u00020\n2\u0006\u0010*\u001a\u000201H&J\u0010\u00103\u001a\u00020\n2\u0006\u0010*\u001a\u000204H&J\u0010\u00105\u001a\u00020\n2\u0006\u0010*\u001a\u000204H&J\u0010\u00106\u001a\u00020\n2\u0006\u0010*\u001a\u000207H&J\u0010\u00108\u001a\u00020\n2\u0006\u0010*\u001a\u000207H&J\u0010\u00109\u001a\u00020\n2\u0006\u0010*\u001a\u00020:H&J\u0010\u0010;\u001a\u00020\n2\u0006\u0010*\u001a\u00020:H&J\b\u0010<\u001a\u00020\u001fH&J\b\u0010=\u001a\u00020\u001fH&J\u0012\u0010>\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010?H\u0016J\n\u0010@\u001a\u0004\u0018\u00010?H\u0016J\b\u0010A\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006IÀ\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent;", "Lcom/ss/android/lark/scaffold/IComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$ITitleBarComponentCallbacks;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar;", "getTitleView", "Landroid/view/View;", "getTitleWrapper", "Landroid/widget/FrameLayout;", "hideTitle", BuildConfig.FLAVOR, "showTitle", "hideAllTitleBar", "showAllTitleBar", "registerCenterTag", "provider", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/binder/IBinderOut$ICenterBinderOut$ICenterTagProvider;", "unRegisterCenterTag", "id", BuildConfig.FLAVOR, "changeTheme", "theme", "Lcom/ss/android/lark/chat/entity/theme/TitleTheme;", "getTabContainerWrapper", "getWidgetContainerWrapper", "getPinContainerWrapper", "getPinDivider", "addTouchDelegate", "centerLayout", "setTitleColor", "color", BuildConfig.FLAVOR, "triggerTabHeightChanged", "tabHeight", "triggerWidgetHeightChanged", "widgetHeight", "triggerWidgetStatusChanged", "isFold", BuildConfig.FLAVOR, "triggerPinStatusChanged", "pinHeight", "addTabVisibilityListener", "listener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$ITabVisibilityListener;", "removeTabVisibilityListener", "addWidgetVisibilityListener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$IWidgetVisibilityListener;", "removeWidgetVisibilityListener", "addWidgetStatusChangeListener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$IWidgetStatusChangeListener;", "removeWidgetStatusChangeListener", "addPinVisibilityListener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$IPinVisibilityChangeListener;", "removePinVisibilityListener", "addTitleThemeChangeListener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$ITitleBarThemeChangeListener;", "removeTitleThemeChangeListener", "addTitleVisibilityChangeListener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$ITitleBarVisibilityChangeListener;", "removeTitleVisibilityChangeListener", "getTitleAreaHeight", "getTabHeight", "setTitleBarContentProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/providers/TitleBarContentProvider;", "getTitleBarContentProvider", "updateTitle", "ITitleBarComponentCallbacks", "ITabVisibilityListener", "ITitleBarThemeChangeListener", "ITitleBarVisibilityChangeListener", "IWidgetVisibilityListener", "IWidgetStatusChangeListener", "IPinVisibilityChangeListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITitlebarComponent extends IComponent, oxa.c<Object>, ChatWindowTitleBar {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setTitleBarContentProvider(ITitlebarComponent r0, i4b.a r1) {
        }

        public static void $default$updateTitle(ITitlebarComponent r0) {
        }
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
        void a();
    }

    public interface e {
    }

    public interface f {
    }

    void La();

    void OY(a r1);

    void PA(c r1);

    void Yr(c r1);

    View getTitleView();

    void kq(b r1);

    void n3();

    void pR(e r1);

    void sm(f r1);

    void updateTitle();

    int w3();

    void xD(ReplyInThreadTitleBarPlugin.onCreate.2 r1);

    int z4();
}
