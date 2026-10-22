package com.bytedance.android.anniex.base.monitor;

import bolts.Task;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MonitorCenter {
    public static final MonitorCenter c = null;
    public final Lazy a;
    public final ConcurrentHashMap<String, b> b;

    public static final class a {
    }

    public static final class b {
        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            r11.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            r11.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L17;
            return false;
        L17:
            r11.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "MonitorBindData(container=null, listener=null, dataMap=null, extraMap=null)";
        }
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ MonitorCenter a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map<String, String> c;
        public final /* synthetic */ Map<String, String> d;

        public c(MonitorCenter r1, String r10, Map<String, String> r11, Map<String, String> r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            if (this.a.b.get(this.b) == null) goto L5;
            this.a.getClass();
            throw null;
        L5:
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
        c = new MonitorCenter();
    }

    public MonitorCenter() {
        this.a = LazyKt.lazy(MonitorCenter$gson$2.INSTANCE);
        this.b = new ConcurrentHashMap();
    }

    public final void a(String r10, Map<String, String> r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r11, "event");
        if (r10 != null) goto L5;
        return;
    L5:
        Task.callInBackground(new c(this, r10, r11, r12));
    }
}
