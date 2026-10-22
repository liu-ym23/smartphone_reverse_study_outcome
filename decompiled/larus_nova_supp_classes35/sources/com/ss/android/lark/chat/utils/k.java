package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k {
    public static String a(Chat r0) {
        if (r0 != null) goto L4;
        return BuildConfig.FLAVOR;
    L4:
        return r0.getName();
    }

    public static Chat.MessagePosition c(Chat r0) {
        if (r0 == null) goto L4;
        Long r1 = ChatCoreModule.a().getAppConfigDependency().a().int_value;
        if (r1 == null) goto L9;
        return Chat.MessagePosition.forNumber(r1.intValue());
    L9:
        return ChatCoreModule.a().getSettingDependency().b();
    L4:
        return Chat.MessagePosition.UNKNOWN;
    }

    public static boolean d(Chat r4) {
        if (r4 != null) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L17;
        if (r4 != null) goto L13;
    L15:
        return false;
    L13:
        if (r4.isAdmin() == false) goto L15;
        return true;
    L17:
        return true;
    L5:
        if (r4.isP2PChat() == true) goto L9;
        if (TextUtils.equals(r4.getOwnerId(), ChatCoreModule.a().getLoginDependency().getUserId()) == false) goto L9;
        r2 = true;
        goto L10
    }

    public static ChatType b(Chat r2, ChatChatter r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r3 == null) goto L10;
        if (r3.isBot() == false) goto L10;
        return ChatType.SINGLE_BOT;
    L10:
        if (r2.isP2PChat() == false) goto L13;
        return ChatType.SINGLE;
    L13:
        if (r2.isMeeting() == false) goto L16;
        return ChatType.MEETING;
    L16:
        if (r2.getType() != Chat.Type.GROUP) goto L19;
        return ChatType.GROUP;
    L19:
        if (r2.getType() != Chat.Type.TOPIC_GROUP) goto L26;
        ChatType r0 = ChatType.THREAD;
        Log.e("unknow chat type for statitics chatName = " + r2.getName());
        return r0;
    L26:
        return null;
    }
}
