package com.obric.assistant.chat.api;

import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final LinkedHashMap<String, String> a;

    public d() {
        this.a = new LinkedHashMap();
    }

    public final void a(Iterable<String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "aliasIds");
        Intrinsics.checkNotNullParameter(r4, "targetId");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        Iterator<String> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L15;
        String r0 = r5.next();
        if (StringsKt.isBlank(r0) == true) goto L7;
        if (Intrinsics.areEqual(r0, r4) == true) goto L7;
        this.a.remove(r0);
        this.a.put(r0, r4);
    L15:
        if (this.a.size() <= 200) goto L20;
        String r6 = (String) CollectionsKt.firstOrNull(this.a.keySet());
        if (r6 == null) goto L18;
        this.a.remove(r6);
        goto L15
    L18:
        return;
    }
}
