package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i0 {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public final Map<String, Object> c() {
        Map<String, Object> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("chat_id", this.a), TuplesKt.to("agent_mode", Integer.valueOf(this.b)), TuplesKt.to("card_source", this.c), TuplesKt.to("card_group_id", this.d), TuplesKt.to("card_id", this.e)});
        String r1 = this.f;
        if (r1 == null) goto L5;
        r0.put("doc_id", r1);
    L5:
        String r2 = this.g;
        if (r2 == null) goto L8;
        r0.put("req_id", r2);
    L8:
        return r0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "RichMediaTraceContext(chatId=" + this.a + ", agentMode=" + this.b + ", cardSource=" + this.c + ", cardGroupId=" + this.d + ", cardId=" + this.e + ", docId=" + this.f + ", reqId=" + this.g + ')';
    }

    public final JSONObject b() {
        JSONObject r0 = new JSONObject();
        a(r0);
        return r0;
    }

    public final void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "jsonObject");
        Iterator<Map.Entry<String, Object>> r0 = c().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, Object> r1 = r0.next();
        r4.putOpt(r1.getKey(), r1.getValue());
        goto L4
    }

    public i0(String r2, int r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r4, "cardSource");
        Intrinsics.checkNotNullParameter(r5, "cardGroupId");
        Intrinsics.checkNotNullParameter(r6, "cardId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
