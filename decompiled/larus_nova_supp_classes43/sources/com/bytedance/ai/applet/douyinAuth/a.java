package com.bytedance.ai.applet.douyinAuth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.listOf(new String[]{"user_info", "mobile", "flow_audio.luna.preference"});
    }

    public static String a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r1.add((String) r0.next());
        goto L4
    L6:
        List r11 = StringsKt.split$default(r10, new String[]{","}, false, 0, 6, null);
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r12.add(StringsKt.trim((String) r13.next()).toString());
        goto L8
    L10:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r12.iterator();
    L12:
        if (r15.hasNext() == false) goto L19;
        Object r16 = r15.next();
        if (((String) r16).length() <= 0) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == false) goto L12;
        r14.add(r16);
        goto L12
    L16:
        r17 = false;
        goto L17
    L19:
        Iterator r18 = r14.iterator();
    L21:
        if (r18.hasNext() == false) goto L24;
        r1.add((String) r18.next());
        goto L21
    L24:
        return CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null);
    }
}
