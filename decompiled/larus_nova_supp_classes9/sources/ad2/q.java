package ad2;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T, R> implements Function {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final Object apply(Object r3) {
        List r4 = (List) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        List r5 = CollectionsKt.sortedWith(r4, new p());
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add((com.bytedance.android.livesdk.jsbridge.methods.upload.models.a) ((Pair) r6.next()).getSecond());
        goto L4
    L6:
        return r0;
    }
}
