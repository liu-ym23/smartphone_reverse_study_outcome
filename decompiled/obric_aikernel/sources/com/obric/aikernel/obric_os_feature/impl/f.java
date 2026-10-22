package com.obric.aikernel.obric_os_feature.impl;

import android.os.IBinder;
import com.obric.aikernel.core.log.AIKLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f4744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Object f4745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f4746c;

    static {
        f4744a = new f();
    }

    private f() {
    }

    private final Object a() {
        Object r10 = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"poweradvisor"});     // Catch: Exception -> L15
        if ((r10 instanceof IBinder) == false) goto L6;
        IBinder r11 = (IBinder) r10;     // Catch: Exception -> L15
    L7:
        if (r11 != null) goto L10;
        AIKLog.INSTANCE.e("PowerAdvisor", "服务不是IBinder类型");     // Catch: Exception -> L15
        return null;
    L10:
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L15
        String r13 = String.format("android.os.IPowerAdvisor%sStub", Arrays.copyOf(new Object[]{"$"}, 1));     // Catch: Exception -> L15
        Intrinsics.checkNotNullExpressionValue(r13, "format(format, *args)");     // Catch: Exception -> L15
        Object r14 = Class.forName(r13).getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r11});     // Catch: Exception -> L15
        if (r14 != null) goto L19;
        AIKLog.INSTANCE.e("PowerAdvisor", "转换服务实例失败");     // Catch: Exception -> L15
        return null;
    L19:
        return r14;
    L6:
        r11 = null;
    L15:
        e = move-exception;
        AIKLog.INSTANCE.e("PowerAdvisor", "获取服务失败", e);
        return null;
    }

    private final Method b(Object r10) {
        Method r11 = r10.getClass().getMethod("updateAiModelInfo", new Class[]{Map.class});     // Catch: Exception -> L4
        r11.setAccessible(true);     // Catch: Exception -> L4
        return r11;
    L4:
        e = move-exception;
        AIKLog.INSTANCE.e("PowerAdvisor", "获取更新方法失败", e);
        return null;
    }

    public final void c(Map<String, String[]> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelInfo");
    L21:
        e = move-exception;
        AIKLog.INSTANCE.e("PowerAdvisor", "更新失败", e);
        return;
    L4:
        if (f4745b != null) goto L6;
    L7:
        Object r11 = a();     // Catch: Exception -> L21
        if (r11 != null) goto L10;
        return;
    L10:
        Method r12 = b(r11);     // Catch: Exception -> L21
        if (r12 != null) goto L13;
        return;
    L13:
        f4745b = r11;     // Catch: Exception -> L21
        f4746c = r12;     // Catch: Exception -> L21
    L25:
        Method r13 = f4746c;     // Catch: Exception -> L18
        if (r13 == null) goto L27;
        r13.invoke(f4745b, new Object[]{r10});     // Catch: Exception -> L18
    L28:
        return;
    L27:
        return;
    L18:
        e = move-exception;
        AIKLog.INSTANCE.e("PowerAdvisor", "调用失败，清空缓存", e);     // Catch: Exception -> L21
        return;
    L6:
        if (f4746c != null) goto L25;
        goto L7
    }
}
