package com.bytedance.vmsdk.registry;

import com.bytedance.sdk.xbridge.cn.platform.lynx.i;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class JavaScriptRegistry {
    HashMap<Class<? extends a>, a> mFunctionMap;
    HashMap<Class<? extends b>, b> mModuleMap;

    public JavaScriptRegistry() {
        this.mModuleMap = new HashMap();
        this.mFunctionMap = new HashMap();
    }

    private static char commonTypeToChar(Class r5) {
        if (r5 != Boolean.TYPE) goto L7;
        return 'z';
    L7:
        if (r5 != Boolean.class) goto L11;
        return 'Z';
    L11:
        if (r5 != Integer.TYPE) goto L15;
        return 'i';
    L15:
        if (r5 != Integer.class) goto L19;
        return 'I';
    L19:
        if (r5 != Short.TYPE) goto L23;
        return 's';
    L23:
        if (r5 != Short.class) goto L27;
        return 'S';
    L27:
        if (r5 != Double.TYPE) goto L31;
        return 'd';
    L31:
        if (r5 != Double.class) goto L35;
        return 'D';
    L35:
        if (r5 != Float.TYPE) goto L39;
        return 'f';
    L39:
        if (r5 != Float.class) goto L43;
        return 'F';
    L43:
        if (r5 != String.class) goto L47;
        return 'T';
    L47:
        if (r5 != Byte.TYPE) goto L51;
        return 'b';
    L51:
        if (r5 != Byte.class) goto L55;
        return 'B';
    L55:
        if (r5 != Long.TYPE) goto L59;
        return 'l';
    L59:
        if (r5 != Long.class) goto L63;
        return 'L';
    L63:
        if (r5 != byte[].class) goto L66;
        return 'a';
    L66:
        return 0;
    }

    public static char returnTypeToChar(Class r5) {
        char r10 = commonTypeToChar(r5);
        if (r10 == 0) goto L6;
        return r10;
    L6:
        if (r5 != Void.TYPE) goto L10;
        return 'v';
    L10:
        if (r5 != WritableMap.class) goto L14;
        return 'M';
    L14:
        if (r5 != WritableArray.class) goto L18;
        return 'A';
    L18:
        throw new RuntimeException("Got unknown return class: ".concat(r5.getSimpleName()));
    }

    public <T extends a> T getJavaScriptFunction(JsWorker r5, Class<? extends a> r10) {
        T r11 = (T) this.mFunctionMap.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        T r12 = (T) Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new c(r5));
        this.mFunctionMap.put(r10, r12);
        return r12;
    }

    public <T extends b> T getJavaScriptModule(JsWorker r5, Class<? extends b> r10) {
        if (this.mModuleMap.get(r10) != null) goto L11;
        if (Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new i(r5, r10)) != null) goto L9;
        this.mModuleMap.put(r10, null);
        return null;
    L9:
        throw new ClassCastException();
    L11:
        throw new ClassCastException();
    }
}
