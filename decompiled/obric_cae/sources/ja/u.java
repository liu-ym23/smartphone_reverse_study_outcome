package ja;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8808a = null;

        /* JADX INFO: renamed from: ja.u$a$a, reason: collision with other inner class name */
        public class C0104a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f8809b;

            public C0104a(Method r8) {
                this.f8809b = r8;
            }

            @Override // ja.u.a
            public final boolean a(Object r8, AccessibleObject r10) {
                return ((Boolean) this.f8809b.invoke(r10, new Object[]{r8})).booleanValue();
            L4:
                e = move-exception;
                throw new RuntimeException("Failed invoking canAccess", e);
            }
        }

        public class b extends a {
            @Override // ja.u.a
            public final boolean a(Object r8, AccessibleObject r10) {
                return true;
            }
        }

        static {
            if (q.f8782a < 9) goto L5;
            boolean r8 = true;
        L6:
            if (r8 == true) goto L15;
        L9:
            a r10 = null;
        L10:
            if (r10 != null) goto L12;
            r10 = new b();
        L12:
            f8808a = r10;
            return;
        L15:
            r10 = new C0104a(AccessibleObject.class.getDeclaredMethod("canAccess", new Class[]{Object.class}));     // Catch: NoSuchMethodException -> L14
        L5:
            r8 = false;
            goto L6
        }

        public abstract boolean a(Object r8, AccessibleObject r10);
    }

    public static ha.y.a a(Class r8, List r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ha.y.a r12 = ((ha.y) r11.next()).a();
        if (r12 == ha.y.a.f8008b) goto L4;
        return r12;
    L9:
        return ha.y.a.f8007a;
    }
}
