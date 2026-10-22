package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    static /* synthetic */ class a {
    }

    private static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4261a = null;

        class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Method f4262b;

            a(Method r10) {
                this.f4262b = r10;
                super(null);
            }

            @Override // com.google.gson.internal.i.b
            public boolean a(AccessibleObject r10, Object r11) {
                return ((Boolean) this.f4262b.invoke(r10, new Object[]{r11})).booleanValue();
            L4:
                e = move-exception;
                throw new RuntimeException("Failed invoking canAccess", e);
            }
        }

        /* JADX INFO: renamed from: com.google.gson.internal.i$b$b, reason: collision with other inner class name */
        class C0092b extends b {
            C0092b() {
                super(null);
            }

            @Override // com.google.gson.internal.i.b
            public boolean a(AccessibleObject r10, Object r11) {
                return true;
            }
        }

        static {
            if (d.d() == true) goto L12;
        L6:
            b r10 = null;
        L7:
            if (r10 != null) goto L9;
            r10 = new C0092b();
        L9:
            f4261a = r10;
            return;
        L12:
            r10 = new a(AccessibleObject.class.getDeclaredMethod("canAccess", new Class[]{Object.class}));     // Catch: NoSuchMethodException -> L11
            goto L7
        }

        private b() {
        }

        /* synthetic */ b(a r10) {
            this();
        }

        public abstract boolean a(AccessibleObject r10, Object r11);
    }

    public static boolean a(AccessibleObject r10, Object r11) {
        return b.f4261a.a(r10, r11);
    }

    public static ReflectionAccessFilter.FilterResult b(List<ReflectionAccessFilter> r10, Class<?> r11) {
        Iterator<ReflectionAccessFilter> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        ReflectionAccessFilter.FilterResult r13 = r12.next().a(r11);
        if (r13 == ReflectionAccessFilter.FilterResult.INDECISIVE) goto L4;
        return r13;
    L9:
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }
}
