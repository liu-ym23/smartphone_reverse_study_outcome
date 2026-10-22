package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class i implements m6b.d {
    public final Map<Object, m6b.c> a;
    public final a2 b;

    public class a implements a2.a {
        public final /* synthetic */ IChatService a;

        public a(IChatService r1) {
            this.a = r1;
        }
    }

    @Inject
    public i(IChatService r3) {
        this.a = new ConcurrentHashMap(16);
        this.b = new a2(new a(r3));
    }

    @Override // m6b.d
    public final void K6(String r7, SubscribeChatEventRequest.SubscriptionKey r8) {
        a2 r0 = this.b;
        r0.getClass();
        if (r7 == null) goto L21;
        Map<String, Integer> r2 = a2.b;
        monitor-enter(r2);
        Integer r3 = (Integer) ((ConcurrentHashMap) r2).get(r7);     // Catch: Throwable -> L16
        if (r3 != null) goto L10;
    L11:
        r3 = 0;     // Catch: Throwable -> L16
    L12:
        Integer r4 = Integer.valueOf(r3.intValue() + 1);     // Catch: Throwable -> L16
        Log.i("PushChatSubscribeCenter", "subscribe chatid: " + r7 + "  count: " + r4);     // Catch: Throwable -> L16
        ((ConcurrentHashMap) r2).put(r7, r4);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        r0.a(r8);
        return;
    L10:
        if (r3.intValue() > 0) goto L12;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // m6b.d
    public final void V(Object r2, String r3) {
        m6b.c r0 = (m6b.c) ((ConcurrentHashMap) this.a).remove(r2);
        if (r0 != null) goto L5;
        Log.w("ChatSubscribeService", "subscriber unregister is empty，key: " + r2);
        return;
    L5:
        r0.b(r3);
    }

    @Override // m6b.d
    public final void z9(String r7, SubscribeChatEventRequest.SubscriptionKey r8) {
        a2 r0 = this.b;
        r0.getClass();
        if (r7 == null) goto L22;
        Map<String, Integer> r2 = a2.b;
        monitor-enter(r2);
        Integer r3 = (Integer) ((ConcurrentHashMap) r2).get(r7);     // Catch: Throwable -> L17
        if (r3 != null) goto L10;
        r3 = 0;     // Catch: Throwable -> L17
    L10:
        Integer r4 = Integer.valueOf(r3.intValue() - 1);     // Catch: Throwable -> L17
        if (r4.intValue() > 0) goto L13;
        r4 = 0;     // Catch: Throwable -> L17
    L13:
        Log.i("PushChatSubscribeCenter", "unSubscribe chatid: " + r7 + "  count: " + r4);     // Catch: Throwable -> L17
        ((ConcurrentHashMap) r2).put(r7, r4);     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        r0.a(r8);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // m6b.d
    public final void W1(Object r4, String r5, aqb.a r6) {
        m6b.c r0 = (m6b.c) ((ConcurrentHashMap) this.a).get(r4);
        if (r0 == null) goto L5;
    L14:
        r0.c(r5, r6);
        return;
    L5:
        monitor-enter(i.class);
        r0 = (m6b.c) ((ConcurrentHashMap) this.a).get(r4);     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new h(this);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.a).put(r4, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // m6b.d
    public final void unregisterPushChatRelation(Object r2, String r3, SubscribeChatEventRequest.SubscriptionKey r4) {
        m6b.c r0 = (m6b.c) ((ConcurrentHashMap) this.a).remove(r2);
        if (r0 != null) goto L5;
        Log.w("ChatSubscribeService", "subscriber unregister is empty，key: " + r2);
        return;
    L5:
        r0.d(r3, r4);
    }

    @Override // m6b.d
    public final void registerPushChatRelation(Object r4, String r5, SubscribeChatEventRequest.SubscriptionKey r6, m6b.o r7) {
        m6b.c r0 = (m6b.c) ((ConcurrentHashMap) this.a).get(r4);
        if (r0 == null) goto L5;
    L14:
        r0.a(r5, r6, r7);
        return;
    L5:
        monitor-enter(i.class);
        r0 = (m6b.c) ((ConcurrentHashMap) this.a).get(r4);     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new h(this);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.a).put(r4, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
