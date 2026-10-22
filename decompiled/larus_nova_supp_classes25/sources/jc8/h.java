package jc8;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final Map<Integer, List<IBlockProvider>> a = null;
    public static IBlockProvider b;

    public h() {
    }

    static {
        a = new LinkedHashMap();
        pd6.b r0 = pd6.c.a;
        List r1 = pd6.c.b(Reflection.getOrCreateKotlinClass(IBlockProvider.class));
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L25;
        IBlockProvider r3 = (IBlockProvider) r2.next();
        if (r3.N0() == BlockProviderType.UNKNOWN) goto L10;
        Iterator<T> r4 = i.a.entrySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        if (((List) ((Map.Entry) r5).getValue()).contains(r3.N0()) == false) goto L13;
    L18:
        Map.Entry r6 = (Map.Entry) r5;
        if (r6 == null) goto L7;
        int r7 = ((Number) r6.getKey()).intValue();
        List r8 = (List) r6.getValue();
        Map<Integer, List<IBlockProvider>> r9 = a;
        LinkedHashMap r10 = (LinkedHashMap) r9;
        List r11 = (List) r10.get(Integer.valueOf(r7));
        if (r11 != null) goto L24;
        r11 = CollectionsKt.emptyList();
    L24:
        List r12 = CollectionsKt.sortedWith(CollectionsKt.plus(r11, r3), new g(r8));
        r10.put(Integer.valueOf(r7), r12);
        goto L7
    L17:
        r5 = null;
        goto L18
    L10:
        b = r3;
        goto L7
    }

    public static List a(int r2) {
        Object r3 = ((LinkedHashMap) a).get(Integer.valueOf(r2));
        List r0 = (List) r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        r3 = null;
    L13:
        List r4 = (List) r3;
        if (r4 != null) goto L19;
        IBlockProvider r5 = b;
        if (r5 != null) goto L21;
        return null;
    L21:
        return CollectionsKt.listOf(r5);
    L19:
        return r4;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }
}
