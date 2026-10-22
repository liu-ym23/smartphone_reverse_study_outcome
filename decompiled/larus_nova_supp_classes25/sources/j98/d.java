package j98;

import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final List<String> a = null;
    public static final List<String> b = null;

    static {
        a = CollectionsKt.listOf(new String[]{"文笔流畅", "文笔优美", "逻辑清晰", "详略得当"});
        b = CollectionsKt.listOf(new String[]{"文笔粗糙", "语句不通", "逻辑不清", "详略不当"});
    }

    public static final List<String> b(Map<String, ? extends List<String>> r5, int r6) {
        if (r5 != null) goto L10;
        if (r6 == 1) goto L9;
        if (r6 == 2) goto L35;
        return CollectionsKt.emptyList();
    L35:
        return b;
    L9:
        return a;
    L10:
        List<String> r7 = r5.get(String.valueOf(r6));
        if (r7 != null) goto L13;
        r7 = CollectionsKt.emptyList();
    L13:
        ArrayList r2 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L15:
        if (r8.hasNext() == false) goto L19;
        Object r3 = r8.next();
        if (o0.d((String) r3) == false) goto L15;
        r2.add(r3);
        goto L15
    L19:
        boolean r9 = r2.isEmpty();
        List<String> r4 = r2;
        if (r9 == false) goto L28;
        if (r6 == 1) goto L25;
        if (r6 == 2) goto L24;
        List<String> r10 = CollectionsKt.emptyList();
    L26:
        r4 = r10;
        goto L28
    L24:
        r10 = b;
        goto L26
    L25:
        r10 = a;
    L28:
        return CollectionsKt.filterNotNull(r4);
    }

    public static final String a(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r2, "diaryId");
        return r1 + '_' + r2 + '_' + r3;
    }
}
