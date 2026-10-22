package mt0;

import com.bytedance.android.live.profile.model.CompareOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static b a(List r7, Map r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r7, "newData");
        Intrinsics.checkNotNullParameter(r8, "loadedItemInfo");
        Intrinsics.checkNotNullParameter(r9, "getType");
        LinkedHashMap r0 = new LinkedHashMap();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Object r3 = r10.next();
        Object r4 = r9.invoke(r3);
        r0.put(r4, r3);
        if (r8.containsKey(r4) == false) goto L7;
        if (r8.containsKey(r4) == false) goto L4;
        r2.add(r4);
        goto L4
    L7:
        r1.add(r4);
        goto L4
    L11:
        ArrayList r12 = new ArrayList(r0.size());
        Iterator r13 = r0.entrySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L22;
        Map.Entry r5 = (Map.Entry) r13.next();
        Object r6 = r5.getKey();
        Object r14 = r5.getValue();
        Object r15 = r5.getKey();
        if (r1.contains(r15) == false) goto L18;
        CompareOperation r16 = CompareOperation.Create;
    L21:
        r12.add(new a(r6, r14, r16));
        goto L13
    L18:
        if (r2.contains(r15) == false) goto L20;
        r16 = CompareOperation.Update;
        goto L21
    L20:
        r16 = CompareOperation.Remove;
        goto L21
    L22:
        ArrayList r17 = new ArrayList(r8.size());
        Iterator r18 = ((LinkedHashMap) r8).entrySet().iterator();
    L24:
        if (r18.hasNext() == false) goto L27;
        r17.add(((Map.Entry) r18.next()).getKey());
        goto L24
    L27:
        return new b(r12, CollectionsKt.minus(r17, CollectionsKt.toSet(r2)));
    }
}
