package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j1<Key, Source, Target> {
    public final Map<Key, m6b.k<Source, Target>> a;
    public final a<Key, Source> b;

    public interface a<Key, Source> {
        Message.Type a(Object r1);
    }

    public j1(a<Key, Source> r2) {
        this.a = new HashMap();
        this.b = r2;
    }

    public final void a(Message.Type r2, m6b.k r3) {
        ((HashMap) this.a).put(r2, r3);
    }
}
