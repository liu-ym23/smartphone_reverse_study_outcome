package o;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class c implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f11368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f11369b;

    class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f11370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f11371b;

        a(c r10, Object r11) {
            this.f11371b = r10;
            this.f11370a = r11;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) {
            c.a(this.f11371b).invoke(r10, r11, r12);     // Catch: Throwable -> L4
        L18:
            return r11.invoke(this.f11370a, r12);
        L8:
            th = move-exception;
            if ((th instanceof InvocationTargetException) == false) goto L15;
            Throwable r13 = th.getTargetException();
            if (r13 == null) goto L14;
            throw r13;
        L14:
            throw th;
        L15:
            throw th;
        L4:
            th = move-exception;
            e0.a.a("APM-Battery", "hookServiceImpl invoke failed: " + th.getMessage());
            goto L18
        }
    }

    public c(Object r10, b r11) {
        this.f11368a = r10;
        this.f11369b = r11;
    }

    static /* synthetic */ b a(c r10) {
        return r10.f11369b;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r10, Method r11, Object[] r12) {
    L11:
        th = move-exception;
        e0.a.a("APM-Battery", "ServiceFetcher getService hook failed: " + th.getMessage());
    L14:
        return r11.invoke(this.f11368a, r12);
    L3:
        if ("getService".equals(r11.getName()) == false) goto L14;
        Object r13 = r11.invoke(this.f11368a, r12);     // Catch: Throwable -> L11
        Field r14 = r13.getClass().getDeclaredField("mService");     // Catch: Throwable -> L11
        r14.setAccessible(true);     // Catch: Throwable -> L11
        Object r15 = r14.get(r13);     // Catch: Throwable -> L11
        String r16 = r15.getClass().getName();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r16) == false) goto L7;
    L10:
        return r13;
    L7:
        if (r16.startsWith(this.f11369b.c()) == false) goto L10;
        r14.set(r13, Proxy.newProxyInstance(r15.getClass().getClassLoader(), new Class[]{Class.forName(this.f11369b.c())}, new a(this, r15)));     // Catch: Throwable -> L11
        goto L10
    }
}
