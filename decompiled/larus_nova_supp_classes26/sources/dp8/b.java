package dp8;

import android.util.LruCache;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static Pair<String, CreationMsgContentData> a;
    public static final LruCache<String, CreationMsgContentData> b = null;

    static {
        b = new LruCache(30);
    }

    public static CreationMsgContentData a(String r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "parseCallback");
        if (r2 != null) goto L5;
        return null;
    L5:
        Pair<String, CreationMsgContentData> r1 = a;
        if (r1 == null) goto L8;
        String r4 = (String) r1.getFirst();
    L10:
        if (Intrinsics.areEqual(r2, r4) == false) goto L15;
        Pair<String, CreationMsgContentData> r5 = a;
        if (r5 != null) goto L14;
        return null;
    L14:
        return (CreationMsgContentData) r5.getSecond();
    L15:
        LruCache<String, CreationMsgContentData> r0 = b;
        CreationMsgContentData r6 = r0.get(r2);
        if (r6 != null) goto L20;
        r6 = (CreationMsgContentData) r3.invoke(r2);
        if (r6 == null) goto L20;
        r0.put(r2, r6);
    L20:
        a = TuplesKt.to(r2, r6);
        return r6;
    L8:
        r4 = null;
        goto L10
    }
}
