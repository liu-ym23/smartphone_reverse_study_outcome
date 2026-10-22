package com.ss.android.lark.chameleon.bridge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.ReflectUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BridgeUtil {
    private static final Gson GSON = null;
    private static final String TAG = "BridgeUtil";

    public BridgeUtil() {
    }

    static {
        GSON = new GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void handleJSMsg(String r5, JSHandler<T> r6, CallBackFunction r7) {
        Class r0 = ReflectUtils.getGenericClass(r6);
        if (r0 != null) goto L5;
        r0 = ReflectUtils.getGenericInterfaceClass(r6);
    L5:
        Object r1 = null;
        if (r0 != null) goto L17;
        r6.handle(null, r7);
        return;
    L17:
    L13:
        th = move-exception;
        Log.e(TAG, "handleJSMsg PARSE_DATA_ERR  data： " + r5 + "    clazz： " + r0 + "  e: " + th);
    L15:
        r6.handle(r1, r7);
        return;
    L9:
        if (r0.equals(String.class) == false) goto L11;
        Object r8 = r5;
    L12:
        r1 = r8;
        goto L15
    L11:
        r8 = GSON.fromJson(r5, r0);     // Catch: Throwable -> L13
        goto L12
    }
}
