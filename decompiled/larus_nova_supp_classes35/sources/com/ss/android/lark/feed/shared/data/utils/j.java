package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j {

    public class a implements y.a<Message.Reaction, Reaction> {
        public a() {
        }

        public final Object get(Object r5) {
            Message.Reaction r6 = (Message.Reaction) r5;
            String r1 = r6.type;
            int r2 = r6.chatter_count.intValue();
            List r3 = r6.chatter_ids;
            if (r2 > 0) goto L11;
            if (r3 != null) goto L7;
        L9:
            r2 = 0;
            goto L11
        L7:
            if (r3.isEmpty() == true) goto L9;
            r2 = r3.size();
        L11:
            return new Reaction(r1, r2, r6.chatter_ids);
        }
    }

    public static ArrayList<Reaction> a(List<Message.Reaction> r1) {
        return new ArrayList(y.a(r1, new a()));
    }
}
