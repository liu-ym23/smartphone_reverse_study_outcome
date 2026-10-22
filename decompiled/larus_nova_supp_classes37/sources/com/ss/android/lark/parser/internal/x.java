package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.MergeForwardContent;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class x {
    public static Reaction a(Message.Reaction r4) {
        String r1 = r4.type;
        int r2 = r4.chatter_count.intValue();
        List r3 = r4.chatter_ids;
        if (r2 > 0) goto L11;
        if (r3 != null) goto L7;
    L9:
        r2 = 0;
        goto L11
    L7:
        if (r3.isEmpty() == true) goto L9;
        r2 = r3.size();
    L11:
        return new Reaction(r1, r2, r4.chatter_ids);
    }

    public static List<Reaction> b(List<Message.Reaction> r2) {
        ArrayList r0 = new ArrayList();
        if (r2 == null) goto L8;
        Iterator<Message.Reaction> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r0.add(a(r3.next()));
    L8:
        return r0;
    }

    public static Map<String, List<Reaction>> c(Map<String, MergeForwardContent.MessageReaction> r8) {
        HashMap r0 = new HashMap();
        if (CollectionUtils.isEmpty(r8) == false) goto L5;
        return r0;
    L5:
        Iterator<MergeForwardContent.MessageReaction> r9 = r8.values().iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        MergeForwardContent.MessageReaction r1 = r9.next();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.reactions.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        MergeForwardContent.Reaction r4 = (MergeForwardContent.Reaction) r3.next();
        r2.add(new Reaction(r4.type, r4.count.intValue(), r4.chatter_ids));
        goto L10
    L12:
        r0.put(r1.message_id, r2);
        goto L7
    L13:
        return r0;
    }
}
