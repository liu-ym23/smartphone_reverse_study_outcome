package py;

import com.bytedance.android.live.base.model.user.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v {
    public static final boolean a(String r1) {
        o0.a.getClass();
        return o0.a.b(r1);
    }

    public static final List<String> b(List<Long> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$transformToString");
        List<Long> r4 = r3;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(String.valueOf(((Number) r5.next()).longValue()));
        goto L4
    L6:
        return r0;
    }
}
