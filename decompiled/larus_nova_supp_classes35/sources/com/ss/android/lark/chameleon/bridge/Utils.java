package com.ss.android.lark.chameleon.bridge;

import com.google.gson.Gson;
import com.ss.android.lark.chameleon.util.JsonUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/Utils;", BuildConfig.FLAVOR, "()V", "sGson", "Lcom/google/gson/Gson;", "combineRequestContent", BuildConfig.FLAVOR, "T", "functionName", "functionParam", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;", "getGenericClass", "Ljava/lang/Class;", "obj", "getGenericInterfaceClass", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Utils {
    public static final Utils INSTANCE = null;
    private static final Gson sGson = null;

    private Utils() {
    }

    static {
        INSTANCE = new Utils();
        sGson = new Gson();
    }

    private final Class<?> getGenericInterfaceClass(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Class<?> r6 = r5.getClass();
    L6:
        boolean r1 = true;
        if (r6 == null) goto L14;
        if (r6.getGenericInterfaces().length != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        r6 = r6.getSuperclass();
        goto L6
    L11:
        r3 = false;
    L14:
        if (r6 != null) goto L16;
        return null;
    L16:
        Type[] r7 = r6.getGenericInterfaces();
        if (r7.length > 0) goto L19;
    L18:
        Type[] r8 = null;
    L22:
        if (r8 != null) goto L24;
        return null;
    L24:
        if (r8.length == 0) goto L27;
        r1 = false;
    L27:
        if (r1 == true) goto L37;
        Type r9 = r8[0];
        if ((r9 instanceof Class) == true) goto L32;
        return null;
    L32:
        return (Class) r9;
    L37:
        return null;
    L19:
        Type r10 = r7[0];
        if ((r10 instanceof ParameterizedType) == false) goto L18;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        r8 = ((ParameterizedType) r10).getActualTypeArguments();
        goto L22
    }

    public final Class<?> getGenericClass(Object r5) {
        Class<?> r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        Type r1 = r5.getClass().getGenericSuperclass();
        if ((r1 instanceof ParameterizedType) == false) goto L16;
        Type[] r2 = ((ParameterizedType) r1).getActualTypeArguments();
        if (r2.length != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L16;
        Type r4 = r2[0];
        if ((r4 instanceof Class) == false) goto L16;
        r0 = (Class) r4;
        goto L16
    L10:
        r3 = false;
    L16:
        if (r0 == null) goto L18;
        return r0;
    L18:
        return getGenericInterfaceClass(r5);
    }

    public final <T> String combineRequestContent(String r2, T r3) {
        return new Regex("\n").replace(r2 + '(' + JsonUtils.INSTANCE.toJsonString(r3) + ')', "\\\\n");
    }
}
