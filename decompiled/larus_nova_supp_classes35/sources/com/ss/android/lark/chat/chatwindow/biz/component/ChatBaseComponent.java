package com.ss.android.lark.chat.chatwindow.biz.component;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.framework.larkwidget.c;
import com.ss.android.lark.scaffold.Component;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "Replace with dependency injection")
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0004J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0004¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0004R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/scaffold/Component;", "<init>", "()V", "chatComponentDependency", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent$ChatComponentDependency;", "getChatComponentDependency", "()Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent$ChatComponentDependency;", "chatComponentDependency$delegate", "Lkotlin/Lazy;", "chatWindowViewModel", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "getChatWindowViewModel", "()Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "chatWindowViewModel$delegate", "getChatWindowInitDataLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getChatLiveData", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getFragment", "Landroidx/fragment/app/Fragment;", "getFragmentContainerWidth", BuildConfig.FLAVOR, "()Ljava/lang/Integer;", "requireFragment", "exitChat", BuildConfig.FLAVOR, "Companion", "ChatComponentDependency", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ChatBaseComponent extends Component {
    public static final /* synthetic */ int k = 0;
    public final Lazy i;
    public final Lazy j;

    public interface a extends c {
        ChatWindowOpenViewModel c();

        Fragment getFragment();

        void h();
    }

    public static final class b {
    }

    static {
    }

    public final MutableLiveData C0() {
        return ((ChatWindowOpenViewModel) this.j.getValue()).getChat();
    }

    public final MutableLiveData D0() {
        return ((ChatWindowOpenViewModel) this.j.getValue()).getInitData();
    }

    public final Fragment getFragment() {
        return ((a) this.i.getValue()).getFragment();
    }

    public final void h() {
        ((a) this.i.getValue()).h();
    }

    public ChatBaseComponent() {
        this.i = LazyKt.lazy(new ChatBaseComponent$chatComponentDependency$2(this));
        this.j = LazyKt.lazy(new ChatBaseComponent$chatWindowViewModel$2(this));
    }
}
