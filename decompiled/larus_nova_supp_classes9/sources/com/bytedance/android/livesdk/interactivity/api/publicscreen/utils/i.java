package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public static e2 a(long r3, User r5, String r6) {
        e2 r0 = new e2();
        MessageType r1 = MessageType.CHAT;
        r0.setMessageMethod(r1.getWsMethod());
        CommonMessageData r2 = new CommonMessageData();
        r2.roomId = r3;
        r2.messageId = -1;
        r2.showMsg = true;
        r2.method = r1.getWsMethod();
        r0.setBaseMessage(r2);
        r0.setContent(r6);
        r0.setUserInfo(r5);
        return r0;
    }
}
