package com.ss.android.lark.core.keyboard;

import android.view.View;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.integrator.im.message.d;
import com.ss.android.lark.keyboard.dependency.a;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import d5b.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lqb.b;
import m6b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@ClaymoreImpl(a.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J,\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/core/keyboard/KeyboardAssemblerModuleDependencyImpl;", "Lcom/ss/android/lark/keyboard/dependency/KeyboardAssemblerModuleDependency;", "<init>", "()V", "registerPushChatRelation", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "chatId", BuildConfig.FLAVOR, "subscriptionKey", "Lcom/bytedance/lark/pb/im/v1/SubscribeChatEventRequest$SubscriptionKey;", "listener", "Lcom/ss/android/lark/chat/service/IPushChatRelationListener;", "unregisterPushChatRelation", "getLocationPanelItemConfig", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/plus/PanelItemConfig;", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "host", "Lcom/ss/android/lark/chat/entity/keyboard/ISupportForItem;", "clickView", "Landroid/view/View;", "componentType", "Lcom/ss/android/lark/chat/entity/ComponentType;", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardAssemblerModuleDependencyImpl implements a {
    public KeyboardAssemblerModuleDependencyImpl() {
    }

    public void unregisterPushChatRelation(Object r2, String r3, SubscribeChatEventRequest.SubscriptionKey r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "subscriptionKey");
        ChatAppContainerV1.a.V().unregisterPushChatRelation(r2, r3, r4);
    }

    public eya.a getLocationPanelItemConfig(Chat r2, c r3, final View r4, ComponentType r5) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "clickView");
        if (r2.isThread() == false) goto L5;
        return null;
    L5:
        if (r5 == ComponentType.REPLY_IN_THREAD) goto L11;
        new b(d.a);
        final com.ss.android.lark.locationmessage.message.b r6 = new com.ss.android.lark.locationmessage.message.b(r2);
        r6.a = r3;
        return new eya.a(new AnonymousClass1(r6, r4));
    L11:
        return null;
    }

    public void registerPushChatRelation(Object r2, String r3, SubscribeChatEventRequest.SubscriptionKey r4, o r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "subscriptionKey");
        Intrinsics.checkNotNullParameter(r5, "listener");
        ChatAppContainerV1.a.V().registerPushChatRelation(r2, r3, r4, r5);
    }
}
