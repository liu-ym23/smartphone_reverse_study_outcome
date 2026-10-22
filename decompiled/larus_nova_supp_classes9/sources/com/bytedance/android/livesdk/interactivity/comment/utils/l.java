package com.bytedance.android.livesdk.interactivity.comment.utils;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public static final v0 a(long r2, com.bytedance.android.livesdk.chatroom.model.v0 r4) {
        Intrinsics.checkNotNullParameter(r4, "chatResult");
        v0 r0 = vh7.f.c(v0.class);
        m0 r1 = vh7.f.c(m0.class);
        r1.setRoomId(r2);
        r1.setShowMsg(true);
        r1.setMessageId(r4.getMsgId());
        r1.setMethod("WebcastEmojiChatMessage");
        r1.setDisplayText(r4.getDisplayText());
        Unit r3 = Unit.INSTANCE;
        r0.setBaseMessage(r1);
        r0.setEmojiContent(r4.getDisplayText());
        r0.setDefaultContent(r4.getContent());
        r0.setUserInfo(r4.getUser());
        r0.setMessageMethod("WebcastEmojiChatMessage");
        MessageIdentity r5 = new MessageIdentity();
        r5.setShowIdentity(r4.getShowIdentity());
        r5.setIdentityLabel(r4.getIdentityLabel());
        r0.setMessageIdentity(r5);
        return r0;
    }
}
