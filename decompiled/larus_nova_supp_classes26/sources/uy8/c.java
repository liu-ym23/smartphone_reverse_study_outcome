package uy8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final Set<String> a = null;

    static {
        new JSONArray();
        new JSONArray();
        a = SetsKt.setOf(new String[]{"attachment_panel", "camera_album"});
    }

    public static final Set<String> a(JSONArray r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r0 = r4.length();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1.add(r4.opt(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        Intrinsics.checkNotNullParameter(r1, "values");
        ArrayList r5 = new ArrayList();
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        Object r6 = r3.next();
        if ((r6 instanceof String) == false) goto L7;
        r5.add(r6);
        goto L7
    L12:
        return CollectionsKt.toSet(CollectionsKt.toCollection(r5, new LinkedHashSet()));
    }
}
