package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0015\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000fH&¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponentInner;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "cancelAnim", BuildConfig.FLAVOR, "allowScrollMessageListOnChangeKeyboard", BuildConfig.FLAVOR, "handleActivityResult", "requestCode", BuildConfig.FLAVOR, "resultCode", Keys.API_RETURN_KEY_DATA, "Landroid/content/Intent;", "getClickHandler", "T", "()Ljava/lang/Object;", "tryShowMessageMenuByView", "messageId", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "getViewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListViewModel;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMessageListComponentInner extends IMessageListComponent {
    a4b.b Hq();

    void XE();

    RecyclerView getRecyclerView();

    boolean pI();
}
