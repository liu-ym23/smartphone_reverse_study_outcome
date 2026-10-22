package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.utils.p1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.SearchImageInfo;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z0 extends a {
    public z0() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.SHARE_SEARCH_IMAGE.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r84, View r85, ef8.b r86) {
        Intrinsics.checkNotNullParameter(r84, "item");
        Intrinsics.checkNotNullParameter(r85, "view");
        Intrinsics.checkNotNullParameter(r86, "menuContext");
        if (r86.g != null) goto L7;
        return false;
    L7:
        if (x0.a(r86) == false) goto L9;
        return true;
    L9:
        SearchImageInfo r5 = r86.g;
        ShareServiceDelegate r1 = ShareServiceDelegate.b;
        JSONObject r4 = new JSONObject();
        r4.putOpt("pic_id", r5.getItemId());
        r4.put("click_method", "overview_long_press");
        r4.put("enter_picture_method", "chat");
        r4.put("message_id", r86.a.getMessageId());
        BotModel r6 = r86.a();
        if (r6 == null) goto L12;
        String r7 = r6.getBotId();
    L13:
        r4.put("bot_id", r7);
        r4.put("conversation_id", r86.a.getConversationId());
        r1.w(r4);
        com.larus.bmhome.share.panel.h r8 = new com.larus.bmhome.share.panel.h(r86.c(), r86.a(), null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -4, -1, 1023);
        Context r9 = r85.getContext();
        if (r9 == null) goto L16;
        Lazy r2 = p1.a;
        p1.b(true, r5, r9, r8, r86.d, null, 32);
    L16:
        return true;
    L12:
        r7 = null;
        goto L13
    }
}
