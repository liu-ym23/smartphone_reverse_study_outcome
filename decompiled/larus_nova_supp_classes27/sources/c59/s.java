package c59;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new r());
    }

    public static String d(Object r4) {
        if (r4 != null) goto L10;
        return null;
    L10:
        return ((Gson) a.getValue()).toJson(r4);
    L7:
        e = move-exception;
        g49.d.c("DslGsonUtil", "toJson Exception: parse " + r4.getClass().getSimpleName() + " failed", e);
        return null;
    }

    public static Object a(String r5, TypeToken r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        if (r5 != null) goto L14;
        return null;
    L14:
    L17:
        return ((Gson) a.getValue()).fromJson(r5, r6.getType());
    L7:
        e = move-exception;
        g49.d.c("DslGsonUtil", "fromJson Exception: parse " + r6.getType() + " failed", e);
        return null;
    L9:
        e = move-exception;
        g49.d.c("DslGsonUtil", "fromJson JsonSyntaxException: parse " + r6.getType() + " failed", e);
        return null;
    }

    public static Object b(String r5, Class r6) {
        Intrinsics.checkNotNullParameter(r6, "clazz");
        if (r5 != null) goto L14;
        return null;
    L14:
    L17:
        return ((Gson) a.getValue()).fromJson(r5, r6);
    L7:
        e = move-exception;
        g49.d.c("DslGsonUtil", "fromJson Exception: parse " + r6.getSimpleName() + " failed", e);
        return null;
    L9:
        e = move-exception;
        g49.d.c("DslGsonUtil", "fromJson JsonSyntaxException: parse " + r6.getSimpleName() + " failed", e);
        return null;
    }

    public static Object c(Object r5, Class r6) {
        Intrinsics.checkNotNullParameter(r6, "clazz");
        if (r5 != null) goto L14;
        return null;
    L14:
        Lazy r3 = a;     // Catch: Exception -> L7 JsonSyntaxException -> L9
    L17:
        return ((Gson) r3.getValue()).fromJson(((Gson) r3.getValue()).toJsonTree(r5), r6);
    L9:
        e = move-exception;
        g49.d.c("DslGsonUtil", "parseToTargetClass JsonSyntaxException: parse " + r6.getSimpleName() + " failed", e);
        return null;
    L7:
        e = move-exception;
        g49.d.c("DslGsonUtil", "parseToTargetClass Exception: parse " + r6.getSimpleName() + " failed", e);
        return null;
    }
}
