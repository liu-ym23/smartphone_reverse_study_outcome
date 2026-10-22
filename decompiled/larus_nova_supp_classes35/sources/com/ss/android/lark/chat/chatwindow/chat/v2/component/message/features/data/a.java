package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.message.audit.e;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.MessageListRendererFeature$initPullToRefresh$1$onLoadMoreBegin$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.MessageListRendererFeature$initPullToRefresh$1$onRefreshBegin$1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Collection;
import java.util.List;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a, e {
    MutableLiveData Da();

    List<f5b.b> Fa(Collection<String> r1);

    int Fe();

    void H5(String r1);

    void Jf(MessageListRendererFeature$initPullToRefresh$1$onLoadMoreBegin$1 r1);

    MutableLiveData Kn();

    ChatChatter N0();

    void N3();

    void addSticker(String r1);

    ChatChatter an();

    void b7();

    boolean canLoadMore();

    boolean canLoadPre();

    void cancelUploadMediaMsg(String r1, String r2);

    void executeMessage(Runnable r1);

    IMessageListViewModel f();

    void g(List<? extends c<?>> r1);

    void g6(int r1);

    Chat getCurrentChat();

    MessageInfo getMessageInfoById(String r1);

    s2b.e getUIModel();

    void retrySendMessage(String r1);

    void rm(String r1, String r2);

    void xl(MessageListRendererFeature$initPullToRefresh$1$onRefreshBegin$1 r1);

    List<String> y0(int r1);

    void z6(boolean r1);
}
