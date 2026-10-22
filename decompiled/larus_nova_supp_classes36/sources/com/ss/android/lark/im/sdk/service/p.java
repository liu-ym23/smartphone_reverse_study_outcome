package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.chat.service.impl.RecallInterceptCallback;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$pullFollowingMessages$1;
import com.ss.android.lark.mergeforward.ParseMergeForwardDataUtils$wrapCallback$1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface p {
    void B8(String r1, boolean r2, RecallInterceptCallback r3);

    void Fe(List<String> r1, IGetDataCallback<Map<String, Message>> r2);

    void Jc(String r1, List<String> r2, IGetDataCallback<Message> r3);

    Executor P0();

    void Q5(String r1);

    void W2(String r1, int r2, FlowMessageSelectPlugin$pullFollowingMessages$1 r3);

    Map<String, MessageInfo> W5(List<String> r1);

    void X3(Message r1, IGetDataCallback<String> r2);

    void Z8(List r1, ParseMergeForwardDataUtils$wrapCallback$1 r2);

    void a7(p0 r1, MonitorMessageSendCallback r2);

    void ac(String r1);

    void e8(b r1, IGetDataCallback<List<MessageInfo>> r2);

    void f1(String r1, SendStatus r2);

    ChatMessageResponse fd(String r1, List<Integer> r2);

    void ib(MessageParams r1, MonitorMessageSendCallback r2);

    Map<String, Message> ie(List<String> r1);

    void j6(a0 r1);

    void k7(List<String> r1, IGetDataCallback<Map<String, Message>> r2);

    void l9(Message.b r1, IGetDataCallback<String> r2);

    void m5(Message r1, boolean r2, MessageFoldDetail r3);

    void mb(String r1);

    MessageInfo p(String r1);

    void p2(Message.b r1, IGetDataCallback<String> r2);

    void sendImages(String r1, List<String> r2, boolean r3, IGetDataCallback<String> r4);

    void sendMessage(MessageParams<?, ?> r1, IGetDataCallback<String> r2);

    Map<String, Message> ta(List<String> r1);

    ChatMessageResponse x2(a r1);

    void yb(z r1);

    Message za(String r1);
}
