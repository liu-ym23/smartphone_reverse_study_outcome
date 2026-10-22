package m6b;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface d {
    void K6(String r1, SubscribeChatEventRequest.SubscriptionKey r2);

    void V(Object r1, String r2);

    void W1(Object r1, String r2, aqb.a r3);

    void registerPushChatRelation(Object r1, String r2, SubscribeChatEventRequest.SubscriptionKey r3, o r4);

    void unregisterPushChatRelation(Object r1, String r2, SubscribeChatEventRequest.SubscriptionKey r3);

    void z9(String r1, SubscribeChatEventRequest.SubscriptionKey r2);
}
