package com.bytedance.android.live.profit.dress.config;

import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class DressResource {
    public final Map<String, a<?>> a;
    public final BehaviorSubject<w<DressResource>> b;

    public static abstract class a<T> {

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.dress.config.DressResource$a$a, reason: collision with other inner class name */
        public static final class C0018a<T> extends a<T> {
            public C0018a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d<T> extends a<T> {
            public final T a;
            public final boolean b;

            public d(T r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public a() {
        }
    }

    public final boolean a() {
        Map<String, a<?>> r0 = this.a;
        if (r0.isEmpty() == true) goto L19;
        Iterator<Map.Entry<String, a<?>>> r1 = r0.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L20;
        a<?> r2 = r1.next().getValue();
        Intrinsics.checkNotNullParameter(r2, "$this$isFromLocal");
        if ((r2 instanceof a.d) == false) goto L11;
        Boolean r3 = Boolean.valueOf(((a.d) r2).b);
    L13:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L7;
        return false;
    L11:
        r3 = null;
        goto L13
    L20:
        return true;
    L19:
        return true;
    }

    public final boolean b() {
        Map<String, a<?>> r0 = this.a;
        if (r0.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, a<?>>> r1 = r0.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L24;
        a<?> r2 = r1.next().getValue();
        Intrinsics.checkNotNullParameter(r2, "$this$isFinished");
        if ((r2 instanceof a.d) == false) goto L12;
    L13:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L7;
        return false;
    L12:
        if ((r2 instanceof a.C0018a) == true) goto L13;
        r3 = false;
        goto L15
    L24:
        return true;
    L23:
        return true;
    }

    public final String c() {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, a<?>>> r1 = this.a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Map.Entry<String, a<?>> r2 = r1.next();
        String r3 = r2.getKey();
        a<?> r4 = r2.getValue();
        r0.append(r3 + '#');
        if ((r4 instanceof a.C0018a) == false) goto L8;
        String r5 = String.valueOf(r4);
    L9:
        r0.append(r5 + ',');
        goto L4
    L8:
        r5 = Reflection.getOrCreateKotlinClass(r4.getClass()).getSimpleName();
        goto L9
    L11:
        return r0.toString();
    }

    public DressResource() {
        this.a = MapsKt.withDefaultMutable(new LinkedHashMap(), DressResource$contents$1.INSTANCE);
        int r0 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.b = BehaviorSubject.create();
    }
}
