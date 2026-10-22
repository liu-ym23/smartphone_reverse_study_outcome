package gm;

import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.service.IAutoRegisterAnimaXService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.utils.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f17104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f17105c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f17106a;

    static {
        f17105c = new String[]{"com.lynx.animax.service.AnimaXFrescoImageService", "com.lynx.animax.monitor.common.AnimaXCommonMonitorService"};
    }

    public a() {
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        this.f17106a = r5;
        r5.put(b.f17107b, new ConcurrentHashMap());
        String[] r10 = f17105c;
        int r11 = 0;
    L4:
        if (r11 >= 2) goto L15;
        String r12 = r10[r11];
        Class<?> r13 = Class.forName(r12);     // Catch: Exception -> L9
        if (IAutoRegisterAnimaXService.class.isAssignableFrom(r13) == true) goto L11;
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "AnimaXServiceCenter", "Class " + r12 + " does not implement IAutoRegisterAnimaXService");     // Catch: Exception -> L9
    L14:
        r11 = r11 + 1;
        goto L4
    L11:
        IAutoRegisterAnimaXService r14 = (IAutoRegisterAnimaXService) r13.getDeclaredConstructor(null).newInstance(null);     // Catch: Exception -> L9
        c(r14.getAutoRegisterServiceScope(), r14.getServiceClass(), r14);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        StringBuilder r15 = e.b("Failed to auto-register service ", r12, ": ");
        r15.append(e.toString());
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXServiceCenter", r15.toString());
        goto L14
    }

    public static a b() {
        if (f17104b != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f17104b != null) goto L11;
        f17104b = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f17104b;
    }

    public final IAnimaXService a(b r5, Class r10) {
        Map r11 = (Map) this.f17106a.get(r5);
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.containsKey(r10) == true) goto L7;
        return null;
    L7:
        return (IAnimaXService) r11.get(r10);
    }

    public final void c(b r5, Class r10, IAnimaXService r11) {
        ConcurrentHashMap r12 = this.f17106a;
        Map r13 = (Map) r12.get(r5);
        if (r13 != null) goto L5;
        r13 = new ConcurrentHashMap();
        r12.put(r5, r13);
    L5:
        boolean r14 = r13.containsKey(r10);
        if (r14 == true) goto L8;
        r13.put(r10, r11);
    L8:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXServiceCenter", String.format("Register service %s with instance %s in scope %s, result: %s", new Object[]{r10.getSimpleName(), r11, r5, Boolean.valueOf(!r14)}));
    }
}
