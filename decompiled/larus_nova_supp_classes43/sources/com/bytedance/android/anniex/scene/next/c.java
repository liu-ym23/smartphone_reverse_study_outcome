package com.bytedance.android.anniex.scene.next;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends d {
    public c() {
    }

    @Override // com.bytedance.android.anniex.scene.next.d
    public final boolean a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "firstValue");
        Intrinsics.checkNotNullParameter(r12, "predictValue");
        List r13 = StringsKt.split$default(r11, new String[]{","}, false, 0, 6, null);
        ArrayList r1 = new ArrayList();
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Object r10 = r14.next();
        if ((true ^ StringsKt.isBlank((String) r10)) == false) goto L4;
        r1.add(r10);
        goto L4
    L8:
        Set r15 = CollectionsKt.toSet(r1);
        List r16 = StringsKt.split$default(r12, new String[]{","}, false, 0, 6, null);
        ArrayList r0 = new ArrayList();
        Iterator r17 = r16.iterator();
    L10:
        if (r17.hasNext() == false) goto L14;
        Object r18 = r17.next();
        if ((!StringsKt.isBlank((String) r18)) == false) goto L10;
        r0.add(r18);
        goto L10
    L14:
        Set r19 = CollectionsKt.toSet(r0);
        if (r15.isEmpty() == true) goto L17;
    L19:
        Set r110 = r15;
        Set r111 = r19;
        if ((((double) CollectionsKt.intersect(r110, r111).size()) / ((double) CollectionsKt.union(r110, r111).size())) > ((Number) SwitchCenter.n.getValue()).doubleValue()) goto L34;
        return false;
    L34:
        return true;
    L17:
        if (r19.isEmpty() == false) goto L19;
        return false;
    }

    @Override // com.bytedance.android.anniex.scene.next.d
    public final boolean b(List<String> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "firstValue");
        Intrinsics.checkNotNullParameter(r11, "predictValue");
        List<String> r12 = r10;
        if ((r12 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L13;
        if (a((String) r13.next(), r11) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r12.isEmpty() == false) goto L7;
        goto L7
    }
}
