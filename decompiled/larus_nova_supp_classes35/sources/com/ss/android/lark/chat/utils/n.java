package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.sticker.StickerInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n {
    public static String a(StickerContent r2) {
        if (r2 == null) goto L5;
        StickerInfo r3 = r2.getStickerInfo();
        if (r3 == null) goto L9;
        String r4 = r3.getDescription();
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return UIUtils.getString(ChatCoreModule.a().getContext(), 2131892241);
    L15:
        return "[" + r4 + "]";
    L9:
        return UIUtils.getString(ChatCoreModule.a().getContext(), 2131892241);
    L5:
        return UIUtils.getString(ChatCoreModule.a().getContext(), 2131892241);
    }
}
