package h41;

import com.google.gson.Gson;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final Map<String, String> a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toEventTrackingInfo");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Gson r1 = l97.a.a;     // Catch: Throwable -> L5
        KTypeProjection.Companion r2 = KTypeProjection.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl((Map) r1.fromJson(r5, TypesJVMKt.getJavaType(Reflection.typeOf(Map.class, r2.invariant(Reflection.typeOf(String.class)), r2.invariant(Reflection.typeOf(String.class))))));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r6) == false) goto L11;
        r6 = null;
    L11:
        return (Map) r6;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
