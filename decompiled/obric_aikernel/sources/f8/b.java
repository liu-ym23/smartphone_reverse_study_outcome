package f8;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final <T> a<T> a(a<T> r10, Function3<? super Integer, ? super String, ? super JSONObject, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        if (r10.b() != 0) goto L5;
    L10:
        return r10;
    L5:
        if (r10.b() == 1) goto L10;
        Integer r12 = Integer.valueOf(r10.b());
        String r13 = r10.c();
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        r11.invoke(r12, r13, r10.d());
        goto L10
    }

    public static final <T> a<T> b(a<T> r10, Function3<? super Boolean, ? super T, ? super JSONObject, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        if (r10.b() != 0) goto L5;
    L6:
        r11.invoke(Boolean.valueOf(r10.e()), r10.a(), r10.d());
    L7:
        return r10;
    L5:
        if (r10.b() != 1) goto L7;
        goto L6
    }
}
