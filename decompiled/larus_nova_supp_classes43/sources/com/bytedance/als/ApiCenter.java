package com.bytedance.als;

import androidx.lifecycle.ViewModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "use ObjectContainer instead")
public final class ApiCenter {
    public static final /* synthetic */ int c = 0;
    public final Map<Class<?>, Object> a;
    public final ApiCenter b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/als/ApiCenter$ApiCenterCompatViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "apiCenter", "Lcom/bytedance/als/ApiCenter;", "getApiCenter", "als_release"}, k = 1, mv = {1, 4, 1})
    public static final class ApiCenterCompatViewModel extends ViewModel {
        private final ApiCenter apiCenter;

        public ApiCenterCompatViewModel() {
            this.apiCenter = new ApiCenter(0);
        }

        public final ApiCenter getApiCenter() {
            return this.apiCenter;
        }
    }

    public static final class a {
    }

    static {
    }

    public ApiCenter(int r1) {
        this.b = null;
        this.a = new HashMap();
    }

    public final synchronized <T extends b> T a(Class<T> r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "clazz");     // Catch: Throwable -> L30
        Object r0 = ((HashMap) this.a).get(r10);     // Catch: Throwable -> L30
        if (r0 == null) goto L8;
        T r1 = (T) r0;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r1;
    L8:
        Iterator r11 = ((HashMap) this.a).keySet().iterator();     // Catch: Throwable -> L30
    L10:
        if (r11.hasNext() == false) goto L14;
        Object r12 = r11.next();     // Catch: Throwable -> L30
        if (b(r10, (Class) r12) == false) goto L10;
    L15:
        Class r13 = (Class) r12;     // Catch: Throwable -> L30
        ApiCenter r14 = this.b;     // Catch: Throwable -> L30
        if (r13 == null) goto L24;
        Object r15 = ((HashMap) this.a).get(r13);     // Catch: Throwable -> L30
        if (r15 == null) goto L23;
        T r16 = (T) r15;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r16;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Throwable -> L30
    L24:
        if (r14 == null) goto L29;
        T r17 = (T) r14.a(r10);
        monitor-exit(this);
        return r17;
    L29:
        throw new IllegalStateException("not found " + r10);     // Catch: Throwable -> L30
    L14:
        r12 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public static boolean b(Class r10, Class r11) {
        if (r10.isInterface() == false) goto L15;
        Class<?>[] r12 = r11.getInterfaces();
        int r0 = r12.length;
        int r13 = 0;
    L5:
        if (r13 >= r0) goto L13;
        Class<?> r14 = r12[r13];
        if (Intrinsics.areEqual(r14, r10) == true) goto L8;
        if (b(r10, r14) == true) goto L11;
        r13 = r13 + 1;
        goto L5
    L11:
        return true;
    L8:
        return true;
    L13:
        return false;
    L15:
        if ((!Intrinsics.areEqual(r11, Object.class)) == false) goto L24;
        if (Intrinsics.areEqual(r11, r10) == true) goto L18;
        r11 = r11.getSuperclass();
        if (r11 != null) goto L15;
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L18:
        return true;
    L24:
        return false;
    }
}
