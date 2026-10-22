package com.ss.android.lark.chat.entity.chatter;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Map<String, Chatter> a;
    public final Map<String, Map<String, ChatChatter>> b;

    public final Map<String, ChatChatter> c() {
        HashMap r0 = new HashMap();
        Iterator r1 = ((HashMap) this.b).values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.putAll((Map) r1.next());
        goto L4
    L6:
        return r0;
    }

    public a() {
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public final Map<String, ChatChatter> a() {
        Map<String, ChatChatter> r0 = c();
        Iterator r1 = ((HashMap) this.a).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        HashMap r4 = (HashMap) r0;
        if (((ChatChatter) r4.get(r2.getKey())) != null) goto L4;
        r4.put((String) r2.getKey(), new ChatChatter((Chatter) r2.getValue()));
        goto L4
    L8:
        return r0;
    }

    public final void d(Chatter r5) {
        String r0 = r5.getId();
        if ((r5 instanceof ChatChatter) == false) goto L10;
        ChatChatter r6 = (ChatChatter) r5;
        Map<String, Chatter> r1 = this.a;
        HashMap r2 = (HashMap) r1;
        r2.put(r0, r6.chatter);
        String r3 = r6.getChatId();
        if (TextUtils.isEmpty(r3) == true) goto L12;
        Map r4 = (Map) ((HashMap) this.b).get(r3);
        if (r4 != null) goto L9;
        r4 = new HashMap();
        ((HashMap) this.b).put(r3, r4);
    L9:
        r4.put(r0, r6);
        return;
    L12:
        return;
    L10:
        ((HashMap) this.a).put(r0, r5);
    }

    public final ChatChatter b(String r3, String r4) {
        Map r0 = (Map) ((HashMap) this.b).get(r3);
        if (r0 != null) goto L5;
    L8:
        Chatter r5 = (Chatter) ((HashMap) this.a).get(r4);
        if (r5 == null) goto L12;
        ChatChatter r1 = new ChatChatter(r5);
        r1.setChatId(r3);
        return r1;
    L12:
        return null;
    L5:
        if (r0.containsKey(r4) == false) goto L8;
        return (ChatChatter) r0.get(r4);
    }
}
