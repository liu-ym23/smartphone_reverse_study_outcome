package com.ss.android.lark.keyboard.dependency;

import android.view.View;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.chat.entity.chat.Chat;
import d5b.c;
import m6b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    eya.a getLocationPanelItemConfig(Chat r1, c r2, View r3, ComponentType r4);

    void registerPushChatRelation(Object r1, String r2, SubscribeChatEventRequest.SubscriptionKey r3, o r4);

    void unregisterPushChatRelation(Object r1, String r2, SubscribeChatEventRequest.SubscriptionKey r3);
}
