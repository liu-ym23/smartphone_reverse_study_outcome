package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class Functions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Runnable f9486a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zb.a f9487b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final zb.g<Object> f9488c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zb.g<Throwable> f9489d = null;

    static final enum HashSetCallable extends Enum<HashSetCallable> implements Callable<Set<Object>> {
        private static final /* synthetic */ HashSetCallable[] $VALUES = null;
        public static final HashSetCallable INSTANCE = null;

        static {
            HashSetCallable r10 = new HashSetCallable("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new HashSetCallable[]{r10};
        }

        private HashSetCallable(String r10, int r11) {
            super(r10, r11);
        }

        public static HashSetCallable valueOf(String r10) {
            return (HashSetCallable) Enum.valueOf(HashSetCallable.class, r10);
        }

        public static HashSetCallable[] values() {
            return (HashSetCallable[]) $VALUES.clone();
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
            NaturalComparator r10 = new NaturalComparator("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new NaturalComparator[]{r10};
        }

        private NaturalComparator(String r10, int r11) {
            super(r10, r11);
        }

        public static NaturalComparator valueOf(String r10) {
            return (NaturalComparator) Enum.valueOf(NaturalComparator.class, r10);
        }

        public static NaturalComparator[] values() {
            return (NaturalComparator[]) $VALUES.clone();
        }

        @Override // java.util.Comparator
        public int compare(Object r10, Object r11) {
            return ((Comparable) r10).compareTo(r11);
        }
    }

    static final class a implements zb.a {
        a() {
        }

        @Override // zb.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class b implements zb.g<Object> {
        b() {
        }

        @Override // zb.g
        public void accept(Object r10) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class c {
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

    static final class e implements zb.g<Throwable> {
        e() {
        }

        public void a(Throwable r10) {
            dc.a.n(r10);
        }

        @Override // zb.g
        public /* bridge */ /* synthetic */ void accept(Throwable r10) {
            a(r10);
        }
    }

    static final class f implements zb.i<Object> {
        f() {
        }

        @Override // zb.i
        public boolean test(Object r10) {
            return false;
        }
    }

    static final class g implements zb.h<Object, Object> {
        g() {
        }

        @Override // zb.h
        public Object apply(Object r10) {
            return r10;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class h implements zb.g<tc.d> {
        h() {
        }

        public void a(tc.d r10) {
            r10.request(Long.MAX_VALUE);
        }

        @Override // zb.g
        public /* bridge */ /* synthetic */ void accept(tc.d r10) {
            a(r10);
        }
    }

    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object r10, Object r11) {
            return ((Comparable) r10).compareTo(r11);
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

    static final class k implements zb.g<Throwable> {
        k() {
        }

        public void a(Throwable r10) {
            dc.a.n(new OnErrorNotImplementedException(r10));
        }

        @Override // zb.g
        public /* bridge */ /* synthetic */ void accept(Throwable r10) {
            a(r10);
        }
    }

    static final class l implements zb.i<Object> {
        l() {
        }

        @Override // zb.i
        public boolean test(Object r10) {
            return true;
        }
    }

    static {
        new g();
        f9486a = new d();
        f9487b = new a();
        f9488c = new b();
        new e();
        f9489d = new k();
        new c();
        new l();
        new f();
        new j();
        new i();
        new h();
    }

    public static <T> zb.g<T> a() {
        return (zb.g<T>) f9488c;
    }
}
