package com.ss.android.lark.chat.preview.components;

import com.ss.android.lark.chat.preview.entity.component.property.LinearLayoutProperty;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.tangram.base.style.TCStyle;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends q6c.d<r6c.a, LinearLayoutProperty> {
    public final s6c.a c() {
        String r1 = ((q6c.a) this).b;
        LinearLayoutProperty r2 = ((LinearLayoutProperty) ((q6c.d) this).e).clone();
        TCStyle r3 = ((q6c.b) this).c;
        if (r3 == null) goto L5;
        TCStyle r4 = r3.clone();
    L6:
        i r0 = new i(r1, r2, r4);
        ArrayList r5 = ((q6c.b) this).d;
        if (r5 == null) goto L13;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r6.add(((q6c.a) r7.next()).c());
        goto L10
    L12:
        ArrayList r8 = new ArrayList(r6);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        ((s6c.a) r0).i = r8;
    L13:
        ((s6c.a) r0).h = false;
        return r0;
    L5:
        r4 = null;
        goto L6
    }

    public h(LinearLayoutProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
    }
}
