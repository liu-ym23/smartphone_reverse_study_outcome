package cy9;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static volatile WeakReference<Object> a;
    public static volatile c b;
    public static volatile a c;
    public static volatile b d;

    public static final class a {
        public final Function0<Unit> a;
        public final Function0<Unit> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "DetailOwnerActions(onSetPrivate=" + this.a + ", onDelete=" + this.b + ')';
        }

        public a(Function0<Unit> r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "onSetPrivate");
            Intrinsics.checkNotNullParameter(r3, "onDelete");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final Function0<Unit> a;
        public final Function0<Unit> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ProfileUserActions(onBlock=" + this.a + ", onReport=" + this.b + ')';
        }

        public b(Function0<Unit> r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "onBlock");
            Intrinsics.checkNotNullParameter(r3, "onReport");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public static void b() {
        WeakReference<Object> r0 = a;
        if (r0 == null) goto L5;
        Object r1 = r0.get();
    L7:
        if ((r1 instanceof LifecycleOwner) == false) goto L9;
        LifecycleOwner r2 = (LifecycleOwner) r1;
    L10:
        c r3 = b;
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
        r2.getLifecycle().removeObserver(r3);
    L14:
        b = null;
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public static a c() {
        WeakReference<Object> r0 = a;
        if (r0 == null) goto L5;
        Object r1 = r0.get();
    L6:
        if (r1 != null) goto L9;
        b();
        a = null;
        c = null;
        d = null;
        return null;
    L9:
        return c;
    L5:
        r1 = null;
        goto L6
    }

    public static b d() {
        WeakReference<Object> r0 = a;
        if (r0 == null) goto L5;
        Object r1 = r0.get();
    L6:
        if (r1 != null) goto L9;
        b();
        a = null;
        c = null;
        d = null;
        return null;
    L9:
        return d;
    L5:
        r1 = null;
        goto L6
    }

    public static void a(final Object r2) {
        b();
        a = new WeakReference(r2);
        if ((r2 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r0 = (LifecycleOwner) r2;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        LifecycleObserver r1 = new c(r2);
        r0.getLifecycle().addObserver(r1);
        b = r1;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static void e(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        WeakReference<Object> r0 = a;
        if (r0 == null) goto L5;
        Object r1 = r0.get();
    L6:
        if (r1 == r2) goto L12;
        WeakReference<Object> r3 = a;
        if (r3 == null) goto L10;
        Object r4 = r3.get();
    L11:
        if (r4 == null) goto L12;
        return;
    L10:
        r4 = null;
    L12:
        b();
        a = null;
        c = null;
        d = null;
        return;
    L5:
        r1 = null;
        goto L6
    }
}
