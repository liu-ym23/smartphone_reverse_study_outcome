package com.lynx.jsbridge.jsi;

import androidx.annotation.RestrictTo;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.CalledByNative;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LynxJSIObjectHub {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile LynxJSIObjectHub f9917b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f9918a;

    public LynxJSIObjectHub() {
        this.f9918a = new ConcurrentHashMap();
    }

    @CalledByNative
    private static ILynxJSIObjectDescriptor getJSIObjectDescriptor(ILynxJSIObject r5) {
        if (f9917b == null) goto L5;
    L15:
        LynxJSIObjectHub r10 = f9917b;
        String r11 = r5.getClass().getName();
        ILynxJSIObjectDescriptor r12 = (ILynxJSIObjectDescriptor) r10.f9918a.get(r11);
        if (r12 == null) goto L25;
        return r12;
    L25:
        ILynxJSIObjectDescriptor r13 = (ILynxJSIObjectDescriptor) Class.forName(r11.concat("$$Descriptor")).newInstance();     // Catch: Exception -> L19
    L21:
        if (r13 == null) goto L23;
        r10.f9918a.put(r11, r13);
    L23:
        return r13;
    L19:
        e = move-exception;
        LynxLog.b(4, "LynxJSIObjectHub", "getJSIObjectDescriptor failed, error: " + e + ", className: " + r11);
        r13 = null;
        goto L21
    L5:
        monitor-enter(LynxJSIObjectHub.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f9917b != null) goto L11;
        f9917b = new LynxJSIObjectHub();     // Catch: Throwable -> L9
    L11:
        monitor-exit(LynxJSIObjectHub.class);     // Catch: Throwable -> L9
        goto L15
    }

    @CalledByNative
    private static int getJSIObjectFieldType(Object r5) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        if ((r5 instanceof ILynxJSIObject) == false) goto L10;
        return 1;
    L10:
        if ((r5 instanceof String) == false) goto L14;
        return 2;
    L14:
        if ((r5 instanceof boolean[]) == false) goto L18;
        return 4;
    L18:
        if ((r5 instanceof int[]) == false) goto L22;
        return 5;
    L22:
        if ((r5 instanceof long[]) == false) goto L26;
        return 6;
    L26:
        if ((r5 instanceof float[]) == false) goto L30;
        return 7;
    L30:
        if ((r5 instanceof double[]) == false) goto L34;
        return 8;
    L34:
        if (r5.getClass().isArray() == false) goto L38;
        return 3;
    L38:
        if ((r5 instanceof List) == false) goto L42;
        return 9;
    L42:
        if ((r5 instanceof Boolean) == false) goto L46;
        return 10;
    L46:
        if ((r5 instanceof Integer) == false) goto L50;
        return 11;
    L50:
        if ((r5 instanceof Long) == false) goto L54;
        return 12;
    L54:
        if ((r5 instanceof Float) == false) goto L58;
        return 13;
    L58:
        if ((r5 instanceof Double) == false) goto L61;
        return 14;
    L61:
        return 0;
    }
}
