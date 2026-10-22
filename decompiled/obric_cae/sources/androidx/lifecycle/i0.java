package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f2166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0.a f2168c;

    public static class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static a f2169c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Application f2170b;

        /* JADX INFO: renamed from: androidx.lifecycle.i0$a$a, reason: collision with other inner class name */
        public static final class C0017a {

            /* JADX INFO: renamed from: androidx.lifecycle.i0$a$a$a, reason: collision with other inner class name */
            public static final class C0018a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0018a f2171a = null;

                static {
                    f2171a = new C0018a();
                }
            }

            public static a a(Application r8) {
                he.i.f(r8, "application");
                if (a.f2169c != null) goto L5;
                a.f2169c = new a(r8);
            L5:
                a r10 = a.f2169c;
                he.i.c(r10);
                return r10;
            }
        }

        public a() {
            this(null);
        }

        @Override // androidx.lifecycle.i0.c, androidx.lifecycle.i0.b
        public final <T extends h0> T a(Class<T> r8) {
            Application r10 = this.f2170b;
            if (r10 == null) goto L7;
            return (T) c(r8, r10);
        L7:
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.i0.b
        public final h0 b(Class r8, t0.d r10) {
            if (this.f2170b != null) goto L14;
            C0017a.C0018a r11 = C0017a.C0018a.f2171a;
            Application r12 = (Application) r10.f12206a.get(r11);
            if (r12 == null) goto L9;
            return c(r8, r12);
        L9:
            if (androidx.lifecycle.a.class.isAssignableFrom(r8) == true) goto L13;
            return super.a(r8);
        L13:
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        L14:
            return a(r8);
        }

        public final <T extends h0> T c(Class<T> r8, Application r10) {
            if (androidx.lifecycle.a.class.isAssignableFrom(r8) == false) goto L20;
            T r11 = r8.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{r10});     // Catch: InvocationTargetException -> L7 InstantiationException -> L10 IllegalAccessException -> L13 NoSuchMethodException -> L16
            he.i.e(r11, "{\n                try {\n…          }\n            }");
            return r11;
        L13:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r8, e);
        L10:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r8, e);
        L16:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r8, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r8, e);
        L20:
            return (T) super.a(r8);
        }

        public a(Application r8) {
            this.f2170b = r8;
        }
    }

    public interface b {
        default <T extends h0> T a(Class<T> r8) {
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default h0 b(Class r8, t0.d r10) {
            return a(r8);
        }
    }

    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static c f2172a;

        @Override // androidx.lifecycle.i0.b
        public <T extends h0> T a(Class<T> r8) {
            T r10 = r8.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: IllegalAccessException -> L5 InstantiationException -> L8 NoSuchMethodException -> L11
            he.i.e(r10, "{\n                modelC…wInstance()\n            }");     // Catch: IllegalAccessException -> L5 InstantiationException -> L8 NoSuchMethodException -> L11
            return r10;
        L5:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r8, e);
        L8:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r8, e);
        L11:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r8, e);
        }
    }

    public static class d {
        public d() {
        }

        public void c(h0 r8) {
        }
    }

    public i0(k0 r8, b r10) {
        he.i.f(r8, "store");
        he.i.f(r10, "factory");
        this(r8, r10, t0.a.C0158a.f12207b);
    }

    public final <T extends h0> T a(Class<T> r8) {
        String r10 = r8.getCanonicalName();
        if (r10 == null) goto L7;
        return (T) b(r8, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(r10));
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final h0 b(Class r8, String r10) {
        he.i.f(r10, "key");
        k0 r11 = this.f2166a;
        h0 r12 = r11.b(r10);
        boolean r13 = r8.isInstance(r12);
        b r14 = this.f2167b;
        if (r13 == true) goto L5;
        t0.d r15 = new t0.d(this.f2168c);
        j0 r16 = j0.f2174a;
        r15.f12206a.put(r16, r10);
        h0 r17 = r14.b(r8, r15);     // Catch: AbstractMethodError -> L15
    L16:
        he.i.f(r17, "viewModel");
        h0 r18 = (h0) r11.f2175a.put(r10, r17);
        if (r18 == null) goto L19;
        r18.b();
    L19:
        return r17;
    L15:
        r17 = r14.a(r8);
        goto L16
    L5:
        if ((r14 instanceof d) == false) goto L7;
        d r19 = (d) r14;
    L8:
        if (r19 == null) goto L10;
        he.i.c(r12);
        r19.c(r12);
    L10:
        he.i.d(r12, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return r12;
    L7:
        r19 = null;
        goto L8
    }

    public i0(k0 r8, b r10, t0.a r11) {
        he.i.f(r8, "store");
        he.i.f(r10, "factory");
        he.i.f(r11, "defaultCreationExtras");
        this.f2166a = r8;
        this.f2167b = r10;
        this.f2168c = r11;
    }
}
