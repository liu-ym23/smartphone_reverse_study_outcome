package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.mdeditor.link.b
    public final List<b.a> a(int r5, int r6, CharSequence r7) {
        Intrinsics.checkNotNullParameter(r7, "text");
        String r8 = r7.subSequence(r5, r6).toString();
        ArrayList r9 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.a(r8, r9);
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        com.ss.android.lark.keyboard.edittext2.utils.b.a r0 = (com.ss.android.lark.keyboard.edittext2.utils.b.a) r11.next();
        String r3 = r0.a;
        r10.add(new b.a(new n(r3, r3), r0.b + r5, r0.c + r5));
        goto L4
    L6:
        return r10;
    }
}
