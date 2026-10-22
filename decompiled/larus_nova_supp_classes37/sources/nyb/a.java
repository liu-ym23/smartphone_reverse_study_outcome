package nyb;

import com.bytedance.lark.pb.basic.v1.ChatMailSetting;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.parser.internal.h;
import com.ss.android.lark.parser.internal.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements IChatParser {
    public a() {
    }

    public final Chat getChat(com.bytedance.lark.pb.basic.v1.Chat r2) {
        return h.a(r2, null);
    }

    public final List<Chat> getChatList(List<com.bytedance.lark.pb.basic.v1.Chat> r4) {
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L10;
        Iterator<com.bytedance.lark.pb.basic.v1.Chat> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Chat r1 = h.a(r5.next(), null);
        if (r1 == null) goto L6;
        r0.add(r1);
    L10:
        return r0;
    }

    public final Map<String, Chat> getChatMap(Map<String, com.bytedance.lark.pb.basic.v1.Chat> r2) {
        return h.d(r2, null, null);
    }

    public final Chatter getChatter(com.bytedance.lark.pb.basic.v1.Chatter r1) {
        return j.a(r1);
    }

    public final Map<String, Chatter> parseChatterMapFromEntity(Entity r2) {
        return new HashMap(j.b(r2, null).a);
    }

    public final Chat getChat(com.bytedance.lark.pb.basic.v1.Chat r1, Map<String, ChatMailSetting> r2) {
        return h.a(r1, r2);
    }
}
