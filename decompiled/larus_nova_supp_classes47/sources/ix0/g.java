package ix0;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final <T> T a(a r3, d<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$fromRemoteObject");
        Intrinsics.checkNotNullParameter(r4, "remoteObj");
        Intrinsics.checkNotNullParameter(r4, "$this$toObjectToken");
        Map<String, String> r5 = r4.getObjToken();
        String r1 = null;
        if (r5 == null) goto L5;
        String r6 = r5.get("_obj_id");
    L7:
        if ((r6 instanceof String) == false) goto L10;
        r1 = r6;
    L10:
        if (r1 == null) goto L14;
        return (T) r3.e1(new b(r1));
    L14:
        throw new IllegalArgumentException("not a valid RemoteObject");
    L5:
        r6 = null;
        goto L7
    }

    public static final <T, R extends d<T>> R b(a r2, T r3, Function0<? extends R> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$toRemoteObject");
        Intrinsics.checkNotNullParameter(r3, "obj");
        Intrinsics.checkNotNullParameter(r4, "ctor");
        b<T> r5 = r2.f1(r3);
        Intrinsics.checkNotNullParameter(r5, "$this$toRemoteObject");
        Intrinsics.checkNotNullParameter(r4, "ctor");
        R r6 = (R) r4.invoke();
        r6.P6(MapsKt.mapOf(TuplesKt.to("_obj_id", r5.a)));
        return r6;
    }
}
