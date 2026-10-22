package com.larus.bmhome.view.screenmenu;

import androidx.core.content.ContextCompat;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(CommonMenu r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L6;
        r1.f = ContextCompat.getDrawable(r1.getContext(), 2131243041);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<ot8.a> b(List<? extends ot8.a> r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == true) goto L5;
        return r1;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return r1;
    L7:
        if (r3 != null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == true) goto L19;
        List r4 = CollectionsKt.createListBuilder(r1.size() + 1);
        r4.add(new s0(r3));
        r4.addAll(r1);
        return CollectionsKt.build(r4);
    L19:
        return r1;
    L9:
        if (StringsKt.isBlank(r3) == true) goto L12;
        r0 = false;
        goto L13
    }
}
