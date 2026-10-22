package com.larus.bmhome.chat.markdown.richtext;

import android.content.res.Resources;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e extends a0 {
    public final Resources a;

    public final Collection<String> c() {
        return CollectionsKt.listOf(new String[]{"at", "mention"});
    }

    public e(Resources r2) {
        Intrinsics.checkNotNullParameter(r2, "resources");
        this.a = r2;
    }

    public final void a(lsc.m r10, v r11, tsc.l r12) {
        Intrinsics.checkNotNullParameter(r10, "visitor");
        Intrinsics.checkNotNullParameter(r11, "renderer");
        Intrinsics.checkNotNullParameter(r12, "tag");
        if (r12.isClosed() == true) goto L5;
        return;
    L5:
        if (r12.start() >= 0) goto L7;
        return;
    L7:
        if (r12.end() <= r12.start()) goto L47;
        Regex r13 = n.a;
        Map r14 = r12.b();
        Intrinsics.checkNotNullParameter(r14, "attrs");
        Pair r0 = n.j(r14);
        String r1 = (String) r0.component1();
        String r2 = (String) r0.component2();
        p r3 = null;
        if (r1 != null) goto L13;
        if (r2 != null) goto L13;
    L41:
        if (r3 != null) goto L43;
        return;
    L43:
        r10.builder().setSpan(new d(this.a, r3), r12.start(), r12.end(), 33);
        return;
    L13:
        String r4 = (String) r14.get("avatar_key");
        if (r4 == null) goto L41;
        boolean r5 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L41;
        String r15 = (String) r14.get("entity_id");
        if (r15 == null) goto L41;
        Long r6 = StringsKt.toLongOrNull(r15);
        if (r6 == null) goto L26;
        long r7 = r6.longValue();
    L28:
        if (r7 > 0) goto L31;
        r5 = false;
    L31:
        if (r5 == true) goto L34;
        r15 = null;
    L34:
        if (r15 == null) goto L41;
        if (r2 == null) goto L39;
        String r8 = "GROUP";
    L40:
        r3 = new p(r8, r4, r15);
        goto L41
    L39:
        r8 = "CONTACT";
        goto L40
    L26:
        r7 = 0;
        goto L28
    }
}
