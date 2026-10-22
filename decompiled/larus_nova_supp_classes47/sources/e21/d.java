package e21;

import com.bytedance.android.livesdk.link.model.o1;
import com.bytedance.android.livesdk.link.model.z1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final o1 a(z1 r3) {
        Object r0 = null;
        if (r3 == null) goto L19;
        String r4 = r3.getBizExtraStr();
        if (r4 == null) goto L20;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Object r5 = Result.constructor-impl((o1) l97.a.a.fromJson(r4, TypesJVMKt.getJavaType(Reflection.typeOf(o1.class))));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == true) goto L16;
        r0 = r5;
    L16:
        return (o1) r0;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L20:
        return null;
    L19:
        return null;
    }
}
