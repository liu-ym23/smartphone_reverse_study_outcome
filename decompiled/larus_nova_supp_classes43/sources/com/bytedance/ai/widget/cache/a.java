package com.bytedance.ai.widget.cache;

import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.utils.g;
import com.lynx.tasm.TemplateBundle;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final ConcurrentHashMap<String, Widget> a = null;
    public static final ConcurrentHashMap<String, TemplateBundle> b = null;
    public static volatile boolean c;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static void a() {
        g.a.d("FixedWidgetCachePool", "clear: ");
        Iterator<T> r0 = a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Widget) r0.next()).g();
        goto L4
    L6:
        a.clear();
        b.clear();
    }

    public static String b(String r10, String r11, String r12) {
        String[] r0 = new String[3];
        r0[0] = r10;
        r0[1] = r11;
        if (r12 != null) goto L5;
    L7:
        r12 = null;
    L8:
        r0[2] = r12;
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r0), ":", null, null, 0, null, null, 62, null);
    L5:
        if ((true ^ StringsKt.isBlank(r12)) == false) goto L7;
        goto L7
    }
}
