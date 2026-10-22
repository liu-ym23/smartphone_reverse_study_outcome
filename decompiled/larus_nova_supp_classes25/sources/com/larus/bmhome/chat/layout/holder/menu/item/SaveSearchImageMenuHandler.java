package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.utils.p1;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.service.ICreationMetadataService;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.b2;
import tx9.c2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SaveSearchImageMenuHandler extends a {
    public SaveSearchImageMenuHandler() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.SAVE_SEARCH_IMAGE.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r18, View r19, ef8.b r20) {
        Intrinsics.checkNotNullParameter(r18, "item");
        Intrinsics.checkNotNullParameter(r19, "view");
        Intrinsics.checkNotNullParameter(r20, "menuContext");
        if (r20.g != null) goto L6;
        return false;
    L6:
        if (r18.getId() != MenuActionType.SAVE_SEARCH_IMAGE.getType()) goto L42;
        JSONObject r1 = r20.l;
        if (r1 == null) goto L10;
        String r2 = r1.optString("creation_task_id");
    L11:
        df8.a r5 = r20.f;
        if (r5 == null) goto L14;
        Integer r6 = Integer.valueOf(r5.a);
    L15:
        UserCreationFromIM r7 = ICreationMetadataService.a.I(r20.a, r2, String.valueOf(r6));
        if (r7 == null) goto L18;
        String r8 = r7.getCreationId();
    L19:
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        JSONObject r10 = new JSONObject();
        r10.putOpt("pic_id", r20.g.getItemId());
        r10.put("click_method", "overview_long_press");
        r10.put("click_from", "click_download");
        r10.put("enter_picture_method", "chat");
        r10.put("message_id", r20.a.getMessageId());
        com.larus.bmhome.chat.api.q0.a r11 = r20.b;
        if (r11 == null) goto L24;
        com.larus.bmhome.chat.component.cvs.y r12 = r11.u0();
        if (r12 == null) goto L24;
        String r13 = r12.getBotId();
    L25:
        r10.putOpt("bot_id", r13);
        r10.put("conversation_id", r20.a.getConversationId());
        r10.put("creation_id", r8);
        JSONObject r14 = r20.l;
        if (r14 == null) goto L30;
        Object r15 = r14.opt("_mixed_richmedia_download_trace");
        if (r15 == null) goto L30;
        r10.put("_mixed_richmedia_download_trace", r15);
    L30:
        Iterator r16 = c2.a.iterator();
    L32:
        if (r16.hasNext() == false) goto L38;
        String r17 = (String) r16.next();
        JSONObject r110 = r20.l;
        if (r110 == null) goto L32;
        Object r111 = r110.opt(r17);
        if (r111 == null) goto L32;
        r10.putOpt(r17, r111);
        goto L32
    L38:
        b2.f(r10, true);
        Unit r21 = Unit.INSTANCE;
        r9.reportEvent("picture_download", r10);
        Context r112 = r19.getContext();
        if (r112 != null) goto L41;
        return true;
    L41:
        Lazy r3 = p1.a;
        p1.b(false, r20.g, r112, null, null, new SaveSearchImageMenuHandler$handleAction$2(r8, r2, r20, null), 24);
    L24:
        r13 = null;
        goto L25
    L18:
        r8 = null;
        goto L19
    L14:
        r6 = null;
        goto L15
    L10:
        r2 = null;
    L42:
        return false;
    }
}
