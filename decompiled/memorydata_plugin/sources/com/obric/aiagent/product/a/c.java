package com.obric.aiagent.product.a;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/product/utils/SystemProperties;", "", "<init>", "()V", "sysPropGet", "Ljava/lang/reflect/Method;", "sysPropGetLong", "sysPropGetInt", "sysPropSet", "get", "", ActivityLifecycle.NAME, "default_value", "getLong", "", "defaultValue", "getInt", "", "set", "", EventBody.KEY_VALUE, "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f5968b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        f5967a = new c();
        Iterator r1 = ArrayIteratorKt.iterator(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethods());     // Catch: ClassNotFoundException -> L27
    L4:
        if (r1.hasNext() == false) goto L57;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r1.next(), Method.class, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L27
        String r3 = r2.getName();     // Catch: ClassNotFoundException -> L27
        if (r3 == null) goto L4;
        switch(r3.hashCode()) {
            case -1249359687: goto L23;
            case -75354382: goto L19;
            case 102230: goto L16;
            case 113762: goto L12;
            default: goto L4;
        };     // Catch: ClassNotFoundException -> L27
    L12:
        if (r3.equals("set") == false) goto L4;
        e = r2;     // Catch: ClassNotFoundException -> L27
        goto L4
    L16:
        if (r3.equals("get") == false) goto L4;
        f5968b = r2;     // Catch: ClassNotFoundException -> L27
        goto L4
    L19:
        if (r3.equals("getLong") == false) goto L4;
        c = r2;     // Catch: ClassNotFoundException -> L27
        goto L4
    L23:
        if (r3.equals("getInt") == false) goto L4;
        d = r2;     // Catch: ClassNotFoundException -> L27
        goto L4
    L57:
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
    }

    private c() {
    }

    public final String a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "default_value");
        Method r3 = f5968b;
        if (r3 != null) goto L5;
        return r5;
    L5:
        Object r0 = null;
        if (r3 != null) goto L21;
    L15:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.String");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 IllegalArgumentException -> L13
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L11:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r5;
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L21:
        r0 = r3.invoke(null, new Object[]{r4, r5});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 IllegalArgumentException -> L13
        goto L15
    }
}
