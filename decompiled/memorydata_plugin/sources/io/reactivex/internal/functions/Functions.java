package io.reactivex.internal.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class Functions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final io.reactivex.b.h<Object, Object> f16716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f16717b = null;
    public static final io.reactivex.b.a c = null;
    static final io.reactivex.b.g<Object> d = null;
    public static final io.reactivex.b.g<Throwable> e = null;
    public static final io.reactivex.b.g<Throwable> f = null;
    public static final io.reactivex.b.i g = null;
    static final io.reactivex.b.j<Object> h = null;
    static final io.reactivex.b.j<Object> i = null;
    static final Callable<Object> j = null;
    static final Comparator<Object> k = null;
    public static final io.reactivex.b.g<org.a.d> l = null;

    static final enum HashSetCallable extends Enum<HashSetCallable> implements Callable<Set<Object>> {
        private static final /* synthetic */ HashSetCallable[] $VALUES = null;
        public static final HashSetCallable INSTANCE = null;

        static {
            HashSetCallable r0 = new HashSetCallable("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new HashSetCallable[]{r0};
        }

        private HashSetCallable(String r1, int r2) {
            super(r1, r2);
        }

        public static HashSetCallable valueOf(String r2) {
            return (HashSetCallable) ZeusTransformUtils.preCheckCast(Enum.valueOf(HashSetCallable.class, r2), HashSetCallable.class, "com.obric.memorydata.plugin");
        }

        public static HashSetCallable[] values() {
            return (HashSetCallable[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HashSetCallable[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Set<Object> call() {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Set<Object> call2() {
            return new HashSet();
        }
    }

    static final enum NaturalComparator extends Enum<NaturalComparator> implements Comparator<Object> {
        private static final /* synthetic */ NaturalComparator[] $VALUES = null;
        public static final NaturalComparator INSTANCE = null;

        static {
            NaturalComparator r0 = new NaturalComparator("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new NaturalComparator[]{r0};
        }

        private NaturalComparator(String r1, int r2) {
            super(r1, r2);
        }

        public static NaturalComparator valueOf(String r2) {
            return (NaturalComparator) ZeusTransformUtils.preCheckCast(Enum.valueOf(NaturalComparator.class, r2), NaturalComparator.class, "com.obric.memorydata.plugin");
        }

        public static NaturalComparator[] values() {
            return (NaturalComparator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NaturalComparator[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public int compare(Object r2, Object r3) {
            return ((Comparable) ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo(r3);
        }
    }

    static final class a implements io.reactivex.b.a {
        a() {
        }

        @Override // io.reactivex.b.a
        public void a() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class b implements io.reactivex.b.g<Object> {
        b() {
        }

        @Override // io.reactivex.b.g
        public void accept(Object r1) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class c implements io.reactivex.b.i {
        c() {
        }
    }

    static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class e implements io.reactivex.b.g<Throwable> {
        e() {
        }

        public void a(Throwable r1) {
            io.reactivex.d.a.a(r1);
        }

        @Override // io.reactivex.b.g
        public /* synthetic */ void accept(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class f implements io.reactivex.b.j<Object> {
        f() {
        }

        @Override // io.reactivex.b.j
        public boolean test(Object r1) {
            return false;
        }
    }

    static final class g implements io.reactivex.b.h<Object, Object> {
        g() {
        }

        @Override // io.reactivex.b.h
        public Object apply(Object r1) {
            return r1;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class h implements io.reactivex.b.g<org.a.d> {
        h() {
        }

        public void a(org.a.d r3) {
            ((org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin")).request(Long.MAX_VALUE);
        }

        @Override // io.reactivex.b.g
        public /* synthetic */ void accept(org.a.d r3) {
            a((org.a.d) ZeusTransformUtils.preCheckCast(r3, org.a.d.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object r2, Object r3) {
            return ((Comparable) ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo(r3);
        }
    }

    static final class j implements Callable<Object> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class k implements io.reactivex.b.g<Throwable> {
        k() {
        }

        public void a(Throwable r1) {
            io.reactivex.d.a.a(new OnErrorNotImplementedException(r1));
        }

        @Override // io.reactivex.b.g
        public /* synthetic */ void accept(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class l implements io.reactivex.b.j<Object> {
        l() {
        }

        @Override // io.reactivex.b.j
        public boolean test(Object r1) {
            return true;
        }
    }

    static {
        f16716a = new g();
        f16717b = new d();
        c = new a();
        d = new b();
        e = new e();
        f = new k();
        g = new c();
        h = new l();
        i = new f();
        j = new j();
        k = new i();
        l = new h();
    }
}
