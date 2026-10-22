package androidx.room;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f2622p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f2624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Set<String>> f2625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f2627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f2628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f2629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile a1.f f2630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f2631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f2632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j.b<c, d> f2633k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MultiInstanceInvalidationClient f2634l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f2635m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f2636n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j f2637o;

    public static final class a {
        public static String a(String r8, String r10) {
            he.i.f(r8, "tableName");
            he.i.f(r10, "triggerType");
            return "`room_table_modification_trigger_" + r8 + '_' + r10 + '`';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f2638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f2639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f2640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2641d;

        public b(int r8) {
            this.f2638a = new long[r8];
            this.f2639b = new boolean[r8];
            this.f2640c = new int[r8];
        }

        public final int[] a() {
            monitor-enter(this);
        L26:
            th = move-exception;
            throw th;
        L4:
            if (this.f2641d == true) goto L8;
            monitor-exit(this);
            return null;
        L8:
            long[] r8 = this.f2638a;     // Catch: Throwable -> L26
            int r10 = r8.length;     // Catch: Throwable -> L26
            int r11 = 0;
            int r12 = 0;
        L9:
            if (r11 >= r10) goto L23;
            int r13 = r12 + 1;     // Catch: Throwable -> L26
            int r14 = 1;
            if (r8[r11] <= 0) goto L13;
            boolean r15 = true;
        L14:
            boolean[] r16 = this.f2639b;     // Catch: Throwable -> L26
            if (r15 == r16[r12]) goto L21;
            int[] r17 = this.f2640c;     // Catch: Throwable -> L26
            if (r15 == true) goto L20;
            r14 = 2;
        L20:
            r17[r12] = r14;     // Catch: Throwable -> L26
        L22:
            r16[r12] = r15;     // Catch: Throwable -> L26
            r11 = r11 + 1;     // Catch: Throwable -> L26
            r12 = r13;
            goto L9
        L21:
            this.f2640c[r12] = 0;     // Catch: Throwable -> L26
            goto L22
        L13:
            r15 = false;
            goto L14
        L23:
            this.f2641d = false;     // Catch: Throwable -> L26
            int[] r18 = (int[]) this.f2640c.clone();     // Catch: Throwable -> L26
            monitor-exit(this);
            return r18;
        }

        public final void b() {
            monitor-enter(this);
            Arrays.fill(this.f2639b, false);     // Catch: Throwable -> L6
            this.f2641d = true;     // Catch: Throwable -> L6
            xd.j r8 = xd.j.f13877a;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f2642a;

        public c(String[] r8) {
            he.i.f(r8, "tables");
            this.f2642a = r8;
        }

        public abstract void a(Set<String> r8);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f2643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f2644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f2645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f2646d;

        public d(c r8, int[] r10, String[] r11) {
            this.f2643a = r8;
            this.f2644b = r10;
            this.f2645c = r11;
            boolean r12 = true;
            if (r11.length != 0) goto L5;
            boolean r13 = true;
        L7:
            if ((!r13) == false) goto L9;
            Set<String> r14 = Collections.singleton(r11[0]);
            he.i.e(r14, "singleton(element)");
        L10:
            this.f2646d = r14;
            if (r10.length == r11.length) goto L14;
            r12 = false;
        L14:
            if (r12 == false) goto L17;
            return;
        L17:
            throw new IllegalStateException("Check failed.".toString());
        L9:
            r14 = yd.m.f14121a;
            goto L10
        L5:
            r13 = false;
            goto L7
        }

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
        public final void a(Set<Integer> r10) {
            int[] r8 = this.f2644b;
            int r11 = r8.length;
            yd.m r12 = yd.m.f14121a;
            Set<String> r13 = r12;
            if (r11 == 0) goto L17;
            int r14 = 0;
            if (r11 == 1) goto L13;
            zd.f r15 = new zd.f();
            int r16 = r8.length;
            int r17 = 0;
        L7:
            if (r14 >= r16) goto L12;
            int r18 = r17 + 1;
            if (r10.contains(Integer.valueOf(r8[r14])) == false) goto L11;
            r15.add(this.f2645c[r17]);
        L11:
            r14 = r14 + 1;
            r17 = r18;
            goto L7
        L12:
            l6.a.r(r15);
            r13 = r15;
            goto L17
        L13:
            r13 = r12;
            if (r10.contains(Integer.valueOf(r8[0])) == false) goto L17;
            r13 = this.f2646d;
        L17:
            if ((!r13.isEmpty()) == false) goto L23;
            this.f2643a.a(r13);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [androidx.room.i$c] */
        /* JADX WARN: Type inference failed for: r2v0, types: [yd.m] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Collection, java.util.Set] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Set<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v3, types: [zd.f] */
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
        public final void b(String[] r12) {
            String[] r8 = this.f2645c;
            int r10 = r8.length;
            ?? r11 = yd.m.f14121a;
            if (r10 == 0) goto L25;
            boolean r13 = false;
            if (r10 == 1) goto L16;
            r11 = new zd.f();
            int r14 = r12.length;
            int r15 = 0;
        L7:
            if (r15 >= r14) goto L15;
            String r16 = r12[r15];
            int r17 = r8.length;
            int r18 = 0;
        L9:
            if (r18 >= r17) goto L14;
            String r19 = r8[r18];
            if (ne.g.r0(r19, r16) == false) goto L13;
            r11.add(r19);
        L13:
            r18 = r18 + 1;
            goto L9
        L14:
            r15 = r15 + 1;
            goto L7
        L15:
            l6.a.r(r11);
            goto L25
        L16:
            int r20 = r12.length;
            int r21 = 0;
        L17:
            if (r21 >= r20) goto L22;
            if (ne.g.r0(r12[r21], r8[0]) == true) goto L20;
            r21 = r21 + 1;
            goto L17
        L20:
            r13 = true;
        L22:
            if (r13 == false) goto L25;
            r11 = this.f2646d;
        L25:
            if ((!r11.isEmpty()) == false) goto L34;
            this.f2643a.a(r11);
            return;
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f2647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<c> f2648c;

        public e(i r8, u r10) {
            super(r10.f2642a);
            this.f2647b = r8;
            this.f2648c = new WeakReference(r10);
        }

        @Override // androidx.room.i.c
        public final void a(Set<String> r8) {
            he.i.f(r8, "tables");
            c r10 = this.f2648c.get();
            if (r10 != null) goto L5;
            this.f2647b.d(this);
            return;
        L5:
            r10.a(r8);
        }
    }

    static {
        f2622p = new String[]{"UPDATE", HttpMethodContrants.DELETE, "INSERT"};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(r r8, HashMap r10, HashMap r11, String... r12) {
        he.i.f(r8, "database");
        this.f2623a = r8;
        this.f2624b = r10;
        this.f2625c = r11;
        int r13 = 0;
        this.f2628f = new AtomicBoolean(false);
        this.f2631i = new b(r12.length);
        this.f2632j = new h(r8);
        this.f2633k = new j.b();
        this.f2635m = new Object();
        this.f2636n = new Object();
        this.f2626d = new LinkedHashMap();
        int r14 = r12.length;
        String[] r15 = new String[r14];
    L4:
        if (r13 >= r14) goto L13;
        String r16 = r12[r13];
        Locale r17 = Locale.US;
        he.i.e(r17, "US");
        String r18 = r16.toLowerCase(r17);
        he.i.e(r18, "this as java.lang.String).toLowerCase(locale)");
        this.f2626d.put(r18, Integer.valueOf(r13));
        String r19 = this.f2624b.get(r12[r13]);
        if (r19 == null) goto L8;
        String r20 = r19.toLowerCase(r17);
        he.i.e(r20, "this as java.lang.String).toLowerCase(locale)");
    L9:
        if (r20 == null) goto L12;
        r18 = r20;
    L12:
        r15[r13] = r18;
        r13 = r13 + 1;
        goto L4
    L8:
        r20 = null;
        goto L9
    L13:
        this.f2627e = r15;
        Iterator<Map.Entry<String, String>> r21 = this.f2624b.entrySet().iterator();
    L15:
        if (r21.hasNext() == false) goto L30;
        Map.Entry<String, String> r22 = r21.next();
        String r23 = r22.getValue();
        Locale r24 = Locale.US;
        he.i.e(r24, "US");
        String r25 = r23.toLowerCase(r24);
        he.i.e(r25, "this as java.lang.String).toLowerCase(locale)");
        if (this.f2626d.containsKey(r25) == false) goto L15;
        String r26 = r22.getKey().toLowerCase(r24);
        he.i.e(r26, "this as java.lang.String).toLowerCase(locale)");
        LinkedHashMap r27 = this.f2626d;
        he.i.f(r27, "<this>");
        if ((r27 instanceof yd.p) == false) goto L21;
        Object r28 = ((yd.p) r27).a();
    L29:
        r27.put(r26, r28);
        goto L15
    L21:
        Object r29 = r27.get(r25);
        if (r29 == null) goto L24;
    L28:
        r28 = r29;
        goto L29
    L24:
        if (r27.containsKey(r25) == true) goto L28;
        throw new NoSuchElementException("Key " + r25 + " is missing in the map.");
    L30:
        this.f2637o = new j(this);
    }

    public static void a(i r8) {
        Object r10 = r8.f2636n;
        monitor-enter(r10);
        r8.f2629g = false;     // Catch: Throwable -> L10
        r8.f2631i.b();     // Catch: Throwable -> L10
        a1.f r11 = r8.f2630h;     // Catch: Throwable -> L10
        if (r11 == null) goto L8;
        r11.close();     // Catch: Throwable -> L10
        xd.j r12 = xd.j.f13877a;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"RestrictedApi"})
    public final void b(c r11) {
        String[] r8 = e(r11.f2642a);
        ArrayList r10 = new ArrayList(r8.length);
        int r12 = r8.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L9;
        String r15 = r8[r14];
        LinkedHashMap r16 = this.f2626d;
        Locale r17 = Locale.US;
        he.i.e(r17, "US");
        String r18 = r15.toLowerCase(r17);
        he.i.e(r18, "this as java.lang.String).toLowerCase(locale)");
        Integer r19 = (Integer) r16.get(r18);
        if (r19 == null) goto L8;
        r10.add(Integer.valueOf(r19.intValue()));
        r14 = r14 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name ".concat(r15));
    L9:
        int[] r20 = yd.i.m1(r10);
        d r21 = new d(r11, r20, r8);
        j.b<c, d> r22 = this.f2633k;
        monitor-enter(r22);
        d r110 = this.f2633k.b(r11, r21);     // Catch: Throwable -> L33
        monitor-exit(r22);
        if (r110 != null) goto L32;
        b r111 = this.f2631i;
        int[] r23 = Arrays.copyOf(r20, r20.length);
        r111.getClass();
        he.i.f(r23, "tableIds");
        monitor-enter(r111);
        int r24 = r23.length;     // Catch: Throwable -> L29
        boolean r25 = false;
    L17:
        if (r13 >= r24) goto L22;
        int r26 = r23[r13];     // Catch: Throwable -> L29
        long[] r27 = r111.f2638a;     // Catch: Throwable -> L29
        long r28 = r27[r26];     // Catch: Throwable -> L29
        r27[r26] = 1 + r28;     // Catch: Throwable -> L29
        if (r28 != 0) goto L21;
        r25 = true;
        r111.f2641d = true;     // Catch: Throwable -> L29
    L21:
        r13 = r13 + 1;     // Catch: Throwable -> L29
        goto L17
    L22:
        xd.j r29 = xd.j.f13877a;     // Catch: Throwable -> L29
        monitor-exit(r111);
        if (r25 == false) goto L45;
        r r112 = this.f2623a;
        if (r112.isOpenInternal() == false) goto L47;
        h(r112.getOpenHelper().Z());
        return;
    L47:
        return;
    L45:
        return;
    L29:
        th = move-exception;
        throw th;
    L32:
        return;
    L33:
        th = move-exception;
        throw th;
    }

    public final boolean c() {
        if (this.f2623a.isOpenInternal() == true) goto L6;
        return false;
    L6:
        if (this.f2629g == true) goto L9;
        this.f2623a.getOpenHelper().Z();
    L9:
        if (this.f2629g == true) goto L12;
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    L12:
        return true;
    }

    @SuppressLint({"RestrictedApi"})
    public final void d(c r13) {
        he.i.f(r13, "observer");
        j.b<c, d> r8 = this.f2633k;
        monitor-enter(r8);
        d r14 = this.f2633k.c(r13);     // Catch: Throwable -> L26
        monitor-exit(r8);
        if (r14 == null) goto L25;
        b r10 = this.f2631i;
        int[] r15 = r14.f2644b;
        int[] r16 = Arrays.copyOf(r15, r15.length);
        r10.getClass();
        he.i.f(r16, "tableIds");
        monitor-enter(r10);
        int r11 = r16.length;     // Catch: Throwable -> L22
        int r12 = 0;
        boolean r17 = false;
    L10:
        if (r12 >= r11) goto L15;
        int r18 = r16[r12];     // Catch: Throwable -> L22
        long[] r19 = r10.f2638a;     // Catch: Throwable -> L22
        long r20 = r19[r18];     // Catch: Throwable -> L22
        r19[r18] = r20 - 1;     // Catch: Throwable -> L22
        if (r20 != 1) goto L14;
        r17 = true;
        r10.f2641d = true;     // Catch: Throwable -> L22
    L14:
        r12 = r12 + 1;     // Catch: Throwable -> L22
        goto L10
    L15:
        xd.j r110 = xd.j.f13877a;     // Catch: Throwable -> L22
        monitor-exit(r10);
        if (r17 == false) goto L36;
        r r111 = this.f2623a;
        if (r111.isOpenInternal() == false) goto L38;
        h(r111.getOpenHelper().Z());
        return;
    L38:
        return;
    L36:
        return;
    L22:
        th = move-exception;
        throw th;
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final String[] e(String[] r10) {
        zd.f r8 = new zd.f();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        String r13 = r10[r12];
        Locale r14 = Locale.US;
        he.i.e(r14, "US");
        String r15 = r13.toLowerCase(r14);
        he.i.e(r15, "this as java.lang.String).toLowerCase(locale)");
        Map<String, Set<String>> r16 = this.f2625c;
        if (r16.containsKey(r15) == false) goto L7;
        String r17 = r13.toLowerCase(r14);
        he.i.e(r17, "this as java.lang.String).toLowerCase(locale)");
        Set<String> r18 = r16.get(r17);
        he.i.c(r18);
        r8.addAll(r18);
    L8:
        r12 = r12 + 1;
        goto L3
    L7:
        r8.add(r13);
        goto L8
    L9:
        l6.a.r(r8);
        return (String[]) r8.toArray(new String[0]);
    }

    public final void f(a1.b r8, int r10) {
        r8.e("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r10 + ", 0)");
        String r11 = this.f2627e[r10];
        String[] r12 = f2622p;
        int r13 = 0;
    L4:
        if (r13 >= 3) goto L6;
        String r14 = r12[r13];
        String r15 = "CREATE TEMP TRIGGER IF NOT EXISTS " + a.a(r11, r14) + " AFTER " + r14 + " ON `" + r11 + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + r10 + " AND invalidated = 0; END";
        he.i.e(r15, "StringBuilder().apply(builderAction).toString()");
        r8.e(r15);
        r13 = r13 + 1;
        goto L4
    }

    public final void g() {
        MultiInstanceInvalidationClient r8 = this.f2634l;
        if (r8 != null) goto L5;
    L18:
        this.f2634l = null;
        return;
    L5:
        if (r8.f2588i.compareAndSet(false, true) == false) goto L18;
        c r10 = r8.f2585f;
        if (r10 == null) goto L16;
        r8.f2581b.d(r10);
        IMultiInstanceInvalidationService r11 = r8.f2586g;     // Catch: RemoteException -> L13
        if (r11 == null) goto L15;
        r11.G2(r8.f2587h, r8.f2584e);     // Catch: RemoteException -> L13
    L15:
        MultiInstanceInvalidationClient.b r12 = r8.f2589j;
        r8.f2583d.unbindService(r12);
    L13:
        e = move-exception;
        Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
        goto L15
    L16:
        he.i.j("observer");
        throw null;
    }

    public final void h(a1.b r14) {
        he.i.f(r14, "database");
        if (r14.j0() == false) goto L51;
        return;
    L51:
        Lock r8 = this.f2623a.getCloseLock$room_runtime_release();     // Catch: Throwable -> L44
        r8.lock();     // Catch: Throwable -> L44
        Object r10 = this.f2635m;     // Catch: Throwable -> L41
        monitor-enter(r10);     // Catch: Throwable -> L41
        int[] r11 = this.f2631i.a();     // Catch: Throwable -> L38
        if (r11 != null) goto L14;
        monitor-exit(r10);     // Catch: Throwable -> L41
        r8.unlock();     // Catch: Throwable -> L44 Throwable -> L44
        return;
    L14:
        if (r14.k0() == false) goto L16;
        r14.o();     // Catch: Throwable -> L38
    L47:
        int r12 = r11.length;     // Catch: Throwable -> L35
        int r13 = 0;
        int r15 = 0;
    L18:
        if (r13 >= r12) goto L30;
        int r16 = r11[r13];     // Catch: Throwable -> L35
        int r17 = r15 + 1;     // Catch: Throwable -> L35
        if (r16 != 1) goto L22;
        f(r14, r15);     // Catch: Throwable -> L35
    L29:
        r13 = r13 + 1;     // Catch: Throwable -> L35
        r15 = r17;
        goto L18
    L22:
        if (r16 != 2) goto L29;
        String r18 = this.f2627e[r15];     // Catch: Throwable -> L35
        String[] r19 = f2622p;     // Catch: Throwable -> L35
        int r20 = 0;
    L26:
        if (r20 >= 3) goto L29;
        String r110 = "DROP TRIGGER IF EXISTS " + a.a(r18, r19[r20]);     // Catch: Throwable -> L35
        he.i.e(r110, "StringBuilder().apply(builderAction).toString()");     // Catch: Throwable -> L35
        r14.e(r110);     // Catch: Throwable -> L35
        r20 = r20 + 1;     // Catch: Throwable -> L35
        goto L26
    L30:
        r14.m();     // Catch: Throwable -> L35
        r14.t();     // Catch: Throwable -> L38
        xd.j r111 = xd.j.f13877a;     // Catch: Throwable -> L38
        monitor-exit(r10);     // Catch: Throwable -> L41
        r8.unlock();     // Catch: Throwable -> L44 Throwable -> L44
        return;
    L35:
        th = move-exception;
        r14.t();     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L16:
        r14.c();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        r8.unlock();     // Catch: Throwable -> L44 Throwable -> L44
        throw th;     // Catch: Throwable -> L44 Throwable -> L44
    L44:
        e = move-exception;
        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
    }
}
