package com.larksuite.component.card.component.personlist.avatar;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SimpleUserLoader {
    public static final Lazy<SimpleUserLoader> d = null;
    public final Map<String, wy7.c> a;
    public final Map<String, ArrayList<WeakReference<com.larksuite.component.card.component.personlist.avatar.b>>> b;
    public final Map<String, ArrayList<WeakReference<c>>> c;

    public static final class a {
        public static SimpleUserLoader a() {
            return (SimpleUserLoader) SimpleUserLoader.d.getValue();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ArrayList<String> a;
        public final /* synthetic */ SimpleUserLoader b;
        public final /* synthetic */ Map<String, wy7.c> c;
        public final /* synthetic */ f d;

        public static final class a implements Runnable {
            public final /* synthetic */ SimpleUserLoader a;
            public final /* synthetic */ Map<String, wy7.c> b;
            public final /* synthetic */ Map<String, wy7.c> c;
            public final /* synthetic */ f d;

            public a(SimpleUserLoader r1, Map<String, wy7.c> r2, Map<String, wy7.c> r3, f r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.putAll(this.b);     // Catch: Throwable -> L4
                this.c.putAll(this.b);     // Catch: Throwable -> L4
                this.a.a(this.c, this.d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader$b$b, reason: collision with other inner class name */
        public static final class RunnableC0020b implements Runnable {
            public final /* synthetic */ SimpleUserLoader a;
            public final /* synthetic */ Map<String, wy7.c> b;
            public final /* synthetic */ f c;

            public RunnableC0020b(SimpleUserLoader r1, Map<String, wy7.c> r2, f r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SimpleUserLoader r0 = this.a;     // Catch: Throwable -> L4
                Map<String, wy7.c> r1 = this.b;     // Catch: Throwable -> L4
                f r2 = this.c;     // Catch: Throwable -> L4
                Lazy<SimpleUserLoader> r3 = SimpleUserLoader.d;     // Catch: Throwable -> L4
                r0.a(r1, r2);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(ArrayList<String> r1, SimpleUserLoader r2, Map<String, wy7.c> r3, f r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            yy7.a r0 = ty7.a.a();     // Catch: Exception -> L10
            if (r0 == null) goto L5;
            Map<String, wy7.c> r1 = r0.getChatterByIds(this.a);     // Catch: Exception -> L10
        L6:
            if (r1 == null) goto L8;
            mz7.b.a(new a(this.b, r1, this.c, this.d));     // Catch: Exception -> L10
            return;
        L8:
            mz7.b.a(new RunnableC0020b(this.b, this.c, this.d));     // Catch: Exception -> L10
            return;
        L5:
            r1 = null;
        L10:
            e = move-exception;
            Log.w("SimpleUserLoader", "loadUserIfNeed submit task is exception", e);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SimpleUserLoader$Companion$instance$2.INSTANCE);
    }

    public SimpleUserLoader() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public final void a(Map<String, wy7.c> r4, f r5) {
        if (r5 == null) goto L4;
        r5.a(r4);
    L4:
        Iterator<Map.Entry<String, wy7.c>> r6 = r4.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        Map.Entry<String, wy7.c> r7 = r6.next();
        String r0 = r7.getKey();
        wy7.c r8 = r7.getValue();
        Intrinsics.checkNotNullParameter(r0, "userId");
        Intrinsics.checkNotNullParameter(r8, "userInfo");
        ArrayList r1 = (ArrayList) ((LinkedHashMap) this.c).get(r0);
        if (r1 == null) goto L6;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L6;
        c r3 = (c) ((WeakReference) r2.next()).get();
        if (r3 == null) goto L11;
        r3.a(r0, r8);
        goto L11
    }

    public final void b(List<String> r5, f r6) {
        Intrinsics.checkNotNullParameter(r5, "userIds");
        LinkedHashMap r0 = new LinkedHashMap();
        ArrayList r1 = new ArrayList();
        Iterator r7 = ((ArrayList) r5).iterator();
    L4:
        if (r7.hasNext() == false) goto L22;
        String r2 = (String) r7.next();
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L4;
        if (this.a.containsKey(r2) == false) goto L20;
        if (((LinkedHashMap) this.a).get(r2) == null) goto L20;
        wy7.c r4 = (wy7.c) ((LinkedHashMap) this.a).get(r2);
        if (r4 == null) goto L4;
        r0.put(r2, r4);
    L20:
        r1.add(r2);
        goto L4
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    L22:
        if (r1.isEmpty() == false) goto L24;
        a(r0, r6);
        return;
    L24:
        CoreThreadPool.getDefault().getCachedThreadPool().submit(new b(r1, this, r0, r6));
    }

    public final void c(String r3, com.larksuite.component.card.component.personlist.avatar.b r4) {
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        Intrinsics.checkNotNullParameter(r4, "listener");
        ArrayList<WeakReference<com.larksuite.component.card.component.personlist.avatar.b>> r0 = (ArrayList) ((LinkedHashMap) this.b).get(r3);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        this.b.put(r3, r0);
    L5:
        r0.add(new WeakReference(r4));
    }
}
