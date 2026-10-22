package v6;

import androidx.collection.LruCache;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Regex a = null;
    public static final LruCache<String, Boolean> b = null;
    public static Set<Integer> c;

    static {
        a = new Regex("\"rit\":(\\d+)");
        b = new LruCache(5);
    }

    public static Set a() {
        if (c != null) goto L12;
        b r0 = c.a.get();
        if (r0 == null) goto L9;
        List<Integer> r1 = r0.a();
        if (r1 == null) goto L9;
        Set<Integer> r10 = CollectionsKt.toSet(r1);
    L10:
        c = r10;
    L9:
        r10 = null;
    L12:
        return c;
    }

    public static boolean b(String r10) {
        boolean r0 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == true) goto L50;
        Set r12 = a();
        if (r12 != null) goto L13;
    L16:
        boolean r13 = true;
    L17:
        if (r13 == true) goto L50;
        LruCache<String, Boolean> r14 = b;
        Boolean r15 = (Boolean) r14.get(r10);
        if (r15 != null) goto L49;
        if (r10 != null) goto L23;
    L26:
        boolean r16 = true;
    L27:
        Integer r17 = null;
        if (r16 == true) goto L39;
        MatchResult r18 = Regex.find$default(a, r10, 0, 2, null);
        if (r18 == null) goto L39;
        MatchGroupCollection r19 = r18.getGroups();
        if (r19 == null) goto L39;
        MatchGroup r20 = r19.get(1);
        if (r20 == null) goto L39;
        String r21 = r20.getValue();
        if (r21 == null) goto L39;
        r17 = StringsKt.toIntOrNull(r21);
    L39:
        if (r17 == null) goto L46;
        Set r22 = a();
        if (r22 == null) goto L46;
        if (r22.contains(r17) != true) goto L46;
    L47:
        r14.put(r10, Boolean.valueOf(r0));
        return r0;
    L46:
        r0 = false;
        goto L47
    L23:
        if (r10.length() == 0) goto L26;
        r16 = false;
        goto L27
    L49:
        return r15.booleanValue();
    L13:
        if (r12.isEmpty() == true) goto L16;
        r13 = false;
    L50:
        return false;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }
}
