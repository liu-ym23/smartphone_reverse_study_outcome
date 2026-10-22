package com.bytedance.android.live.browser.schema.core;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RedirectRule {
    public final com.bytedance.android.live.browser.schema.core.strategy.c a;
    public final String b;
    public final List<RedirectRule> c;

    public final com.bytedance.android.live.schema.api.a a(JSONObject r6, final Function1<? super RedirectRule, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "output");
        if (r7 == null) goto L5;
        Unit r0 = (Unit) r7.invoke(this);
    L5:
        Object r1 = null;
        if (this.a.a(r6) == false) goto L38;
        String r2 = this.b;
        if (r2 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L16;
        if (r2 != null) goto L40;
        return null;
    L40:
        return new com.bytedance.android.live.schema.api.a(r2);
    L16:
        final JSONArray r3 = new JSONArray();
        r6.put("state", r3);
        List<RedirectRule> r8 = this.c;
        if (r8 == null) goto L41;
        Sequence r9 = CollectionsKt.asSequence(r8);
        if (r9 == null) goto L42;
        Sequence r11 = SequencesKt.mapIndexed(r9, new RedirectRule$getFinalSchemaInfo$2(r3, r7));
        if (r11 == null) goto L43;
        Iterator r12 = r11.iterator();
    L24:
        if (r12.hasNext() == false) goto L32;
        Object r13 = r12.next();
        if (((com.bytedance.android.live.schema.api.a) r13) == null) goto L28;
        boolean r5 = true;
    L29:
        if (r5 == false) goto L24;
        r1 = r13;
        goto L32
    L28:
        r5 = false;
    L32:
        return (com.bytedance.android.live.schema.api.a) r1;
    L43:
        return null;
    L42:
        return null;
    L41:
        return null;
    L10:
        if (this.c != null) goto L12;
        r4 = true;
        goto L13
    L38:
        return null;
    }

    public RedirectRule(com.bytedance.android.live.browser.schema.core.strategy.c r2, String r3, List<RedirectRule> r4) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
