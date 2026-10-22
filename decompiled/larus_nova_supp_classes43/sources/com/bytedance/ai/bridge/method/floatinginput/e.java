package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import e3.g;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements g, e3.b {
    public final WeakReference<e3.d> a;
    public final ConcurrentHashMap<String, a> b;
    public final l3.e c;

    public static final class a {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r10 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r10 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Indication(send=" + this.a + ", receive=" + this.b + ')';
        }

        public a(boolean r1, boolean r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    @Override // e3.b
    public final void a() {
        this.b.clear();
        this.a.clear();
        Lazy r0 = l3.d.a;
        l3.e r1 = this.c;
        Intrinsics.checkNotNullParameter(r1, "subscriber");
        Intrinsics.checkNotNullParameter(MessageIndication.EVENT_NAME, "eventName");
        CopyOnWriteArrayList r10 = (CopyOnWriteArrayList) l3.d.a().get(MessageIndication.EVENT_NAME);
        if (r10 == null) goto L6;
        r10.remove(r1);
        return;
    }

    public e(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        this.a = new WeakReference(r10);
        this.b = new ConcurrentHashMap();
        l3.e r11 = new l3.e(this, UUID.randomUUID().toString(), null, 28);
        this.c = r11;
        l3.d.e(r11, MessageIndication.EVENT_NAME);
    }

    @Override // e3.g
    public final void b(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        if (r11 == null) goto L24;
        JsonElement r12 = r11.get("botId");
        if (r12 == null) goto L25;
        String r13 = r12.getAsString();
        if (r13 == null) goto L30;
        JsonElement r0 = r11.get("isSend");
        if (r0 == null) goto L26;
        boolean r1 = r0.getAsBoolean();
        a r14 = this.b.get(r13);
        if (r14 != null) goto L14;
        return;
    L14:
        if (r1 == true) goto L16;
    L17:
        if (r1 == false) goto L19;
        return;
    L19:
        if (r14.b == false) goto L28;
    L20:
        e3.d r15 = this.a.get();
        if (r15 == null) goto L29;
        r15.a("applet.chatEvent", r11);
        return;
    L29:
        return;
    L28:
        return;
    L16:
        if (r14.a == true) goto L20;
    L26:
        return;
    L30:
        return;
    L25:
        return;
    }

    public final void update(String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "botId");
        this.b.put(r10, new a(r11, r12));
    }
}
