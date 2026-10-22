package kotlinx.coroutines.channels;

import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@JvmInline
public final class g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f10318b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f10319c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f10320a;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final Throwable f10321a;

        public a(Throwable r10) {
            this.f10321a = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof a) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.f10321a, ((a) r10).f10321a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            Throwable r10 = this.f10321a;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.hashCode();
        }

        @Override // kotlinx.coroutines.channels.g.c
        public String toString() {
            return "Closed(" + this.f10321a + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final <E> Object a(Throwable r10) {
            return g.c(new a(r10));
        }

        public final <E> Object b() {
            return g.c(g.a());
        }

        public final <E> Object c(E r10) {
            return g.c(r10);
        }
    }

    public static class c {
        public c() {
        }

        public String toString() {
            return "Failed";
        }
    }

    static {
        f10318b = new b(null);
        f10319c = new c();
    }

    @PublishedApi
    private /* synthetic */ g(Object r10) {
        this.f10320a = r10;
    }

    public static final /* synthetic */ c a() {
        return f10319c;
    }

    public static final /* synthetic */ g b(Object r10) {
        return new g(r10);
    }

    @PublishedApi
    public static <T> Object c(Object r10) {
        return r10;
    }

    public static boolean d(Object r10, Object r11) {
        if ((r11 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10, ((g) r11).k()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static final Throwable e(Object r10) {
        if ((r10 instanceof a) == false) goto L5;
        a r11 = (a) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.f10321a;
    L5:
        r11 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T f(Object r10) {
        if ((r10 instanceof c) == false) goto L7;
        return null;
    L7:
        return r10;
    }

    public static int g(Object r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.hashCode();
    }

    public static final boolean h(Object r10) {
        return r10 instanceof a;
    }

    public static final boolean i(Object r10) {
        return !(r10 instanceof c);
    }

    public static String j(Object r10) {
        if ((r10 instanceof a) == false) goto L6;
        return ((a) r10).toString();
    L6:
        return "Value(" + r10 + ')';
    }

    public boolean equals(Object r10) {
        return d(this.f10320a, r10);
    }

    public int hashCode() {
        return g(this.f10320a);
    }

    public final /* synthetic */ Object k() {
        return this.f10320a;
    }

    public String toString() {
        return j(this.f10320a);
    }
}
