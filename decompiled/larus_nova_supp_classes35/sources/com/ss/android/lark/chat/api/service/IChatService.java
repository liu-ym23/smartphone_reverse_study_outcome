package com.ss.android.lark.chat.api.service;

import ccb.d;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.b;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.integrator.im.impl.IIMApiImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IChatService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChatChatterScene {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Condition {
        public static final int NON_DEPARTMENT = 2;
        public static final int NO_LIMIT = 1;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecallChatterSource {
        public static final int GROUP_MANAGE = 1;
        public static final int RECALL_FROM_INVITER = 2;
    }

    void Ac(String r1, UIGetDataCallback r2);

    void Dc(String r1, Iterable r2, Iterable r3, IGetDataCallback r4);

    b I0(String r1);

    void L9(String r1, String r2, IIMApiImpl.peakFeedCard.1 r3);

    d M2(String r1, String r2, String r3, boolean r4);

    ImageHistoryResponse Ne(String r1, String r2, ImageHistoryResponse.Direction r3, int r4);

    void U6(String r1, IGetDataCallback<Boolean> r2);

    boolean checkLoginUserExistedInLocalChat(Chat r1);

    void f2(List<GroupRecallEntity> r1, String r2, IGetDataCallback<List<GroupRecallEntity>> r3);

    Chat getChatById(String r1);

    Chat getLocalChat(String r1);

    Chat getP2pChatByChatterId(String r1);

    void getP2pChatCreatedByChatterId(String r1, IGetDataCallback<Chat> r2);

    void h3(String r1, String r2, boolean r3, ChatNameRenderer$doTranslate$1 r4);

    void t8(String r1, int r2, int r3);

    void t9(String r1, String r2, UIGetDataCallback r3);

    void u2(List<String> r1, List<String> r2, SubscribeChatEventRequest.SubscriptionKey r3);

    void y3(String r1, ChatNameRenderer$doHideTranslate$1 r2);

    ImageHistoryResponse ze(String r1, String r2, ImageHistoryResponse.Direction r3);
}
