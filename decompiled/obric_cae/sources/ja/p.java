package ja;

import com.bytedance.bdlocation.utils.json.SuperclassExclusionStrategy;
import ha.c0;
import ha.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p implements d0, Cloneable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final p f8770p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f8771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8772b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f8773m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<ha.a> f8774n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<ha.a> f8775o;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends c0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0<T> f8776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f8777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f8778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ha.j f8779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ oa.a f8780e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ p f8781f;

        public a(p r8, boolean r10, boolean r11, ha.j r12, oa.a r13) {
            this.f8781f = r8;
            this.f8777b = r10;
            this.f8778c = r11;
            this.f8779d = r12;
            this.f8780e = r13;
        }

        @Override // ha.c0
        public final T a(pa.a r8) {
            if (this.f8777b == false) goto L6;
            r8.u0();
            return null;
        L6:
            c0<T> r10 = this.f8776a;
            if (r10 != null) goto L11;
            oa.a<T> r11 = this.f8780e;
            r10 = this.f8779d.g(this.f8781f, r11);
            this.f8776a = r10;
        L11:
            return r10.a(r8);
        }

        @Override // ha.c0
        public final void b(pa.c r8, T r10) {
            if (this.f8778c == false) goto L6;
            r8.z();
            return;
        L6:
            c0<T> r11 = this.f8776a;
            if (r11 != null) goto L10;
            oa.a<T> r12 = this.f8780e;
            r11 = this.f8779d.g(this.f8781f, r12);
            this.f8776a = r11;
        L10:
            r11.b(r8, r10);
        }
    }

    static {
        f8770p = new p();
    }

    public p() {
        this.f8771a = -1.0d;
        this.f8772b = 136;
        this.f8773m = true;
        this.f8774n = Collections.emptyList();
        this.f8775o = Collections.emptyList();
    }

    public static boolean d(Class r8) {
        if (Enum.class.isAssignableFrom(r8) == false) goto L5;
        return false;
    L5:
        if ((r8.getModifiers() & 8) == 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
        return false;
    L10:
        if (r8.isAnonymousClass() == true) goto L14;
        if (r8.isLocalClass() == true) goto L14;
        return false;
    L14:
        return true;
    L7:
        r10 = false;
        goto L8
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r12, oa.a<T> r13) {
        Class<? super T> r8 = r13.getRawType();
        boolean r10 = b(r8);
        if (r10 == false) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r10 == false) goto L11;
    L14:
        boolean r14 = true;
    L15:
        if (r11 == true) goto L20;
        if (r14 == true) goto L20;
        return null;
    L20:
        return new a(this, r14, r11, r12, r13);
    L11:
        if (c(r8, false) == true) goto L14;
        r14 = false;
        goto L15
    L5:
        if (c(r8, true) == true) goto L8;
        r11 = false;
        goto L9
    }

    public final boolean b(Class<?> r8) {
        if (this.f8771a == (-1.0d)) goto L8;
        if (e((ia.c) r8.getAnnotation(ia.c.class), (ia.d) r8.getAnnotation(ia.d.class)) == true) goto L8;
        return true;
    L8:
        if (this.f8773m == true) goto L20;
        boolean r10 = false;
        if (r8.isMemberClass() == true) goto L12;
    L17:
        if (r10 == false) goto L20;
        return true;
    L12:
        if ((r8.getModifiers() & 8) == 0) goto L14;
        boolean r11 = true;
    L15:
        if (r11 == true) goto L17;
        r10 = true;
        goto L17
    L14:
        r11 = false;
    L20:
        return d(r8);
    }

    public final boolean c(Class<?> r8, boolean r10) {
        if (r10 == false) goto L4;
        List<ha.a> r11 = this.f8774n;
    L5:
        Iterator<ha.a> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        if (r12.next().shouldSkipClass(r8) == false) goto L7;
        return true;
    L12:
        return false;
    L4:
        r11 = this.f8775o;
        goto L5
    }

    public final Object clone() {
        return (p) super.clone();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final boolean e(ia.c r8, ia.d r10) {
        double r11 = this.f8771a;
        if (r8 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L19;
        if (r10 != null) goto L12;
    L15:
        boolean r13 = true;
    L16:
        if (r13 == true) goto L18;
        return false;
    L18:
        return true;
    L12:
        if (r11 < r10.value()) goto L15;
        r13 = false;
        goto L16
    L19:
        return false;
    L5:
        if (r11 >= r8.value()) goto L8;
        r12 = false;
        goto L9
    }

    public final p f(SuperclassExclusionStrategy r8, boolean r10, boolean r11) {
        p r12 = (p) super.clone();     // Catch: CloneNotSupportedException -> L8
        if (r10 == false) goto L5;
        ArrayList r13 = new ArrayList(this.f8774n);
        r12.f8774n = r13;
        r13.add(r8);
    L5:
        if (r11 == false) goto L7;
        ArrayList r14 = new ArrayList(this.f8775o);
        r12.f8775o = r14;
        r14.add(r8);
    L7:
        return r12;
    L8:
        e = move-exception;
        throw new AssertionError(e);
    }
}
