package com.ss.android.lark.featuregating;

import android.content.Context;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.storage.kv.flash.d;
import java.util.concurrent.ConcurrentHashMap;
import jdb.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final a d = null;
    public static b e;
    public final com.ss.android.lark.storage.kv.flash.c a;
    public final ConcurrentHashMap<String, c> b;
    public final ConcurrentHashMap<String, Boolean> c;

    public static final class a {
        @JvmStatic
        public final b a() {
            LarkAppContext.Companion.getClass();
            return b(LarkAppContext.access$getInstance$cp().getContext());
        }

        public a() {
        }

        @JvmStatic
        public final synchronized b b(Context r2) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r2, "context");     // Catch: Throwable -> L9
            b r0 = b.e;     // Catch: Throwable -> L9
            if (r0 != null) goto L6;
            r0 = new b(r2);     // Catch: Throwable -> L9
        L6:
            b.e = r0;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r0;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.featuregating.b$b, reason: collision with other inner class name */
    public static final class C0197b implements c {
        public final String a;
        public final e b;

        @Override // com.ss.android.lark.featuregating.b.c
        public final boolean isEnable(String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            return this.b.B0(this.a, r3);
        }

        public C0197b(String r2, e r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "service");
            this.a = r2;
            this.b = r3;
        }
    }

    public interface c {
        boolean isEnable(String r1);
    }

    static {
        d = new a();
    }

    public b(Context r8) {
        d r0 = com.ss.android.lark.storage.kv.flash.c.b;
        Intrinsics.checkNotNullParameter(r8, "context");
        com.ss.android.lark.storage.kv.flash.c.a r1 = new com.ss.android.lark.storage.kv.flash.c.a(r8);
        String r9 = r1.b;
        Intrinsics.checkNotNullParameter(r9, "space");
        Intrinsics.checkNotNullParameter("flash_fg", "domain");
        r1.c = r9;
        r1.d = "flash_fg";
        com.ss.android.lark.featuregating.a r10 = new com.ss.android.lark.featuregating.a();
        Intrinsics.checkNotNullParameter(r10, "source");
        com.ss.android.lark.storage.kv.flash.a r2 = r1.e;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "source");
        String[] r3 = r10.a();
        int r4 = r3.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L9;
        String r6 = r3[r5];
        if (((com.ss.android.lark.storage.kv.flash.e) r2.a.put(r6, r10)) != null) goto L8;
        r5 = r5 + 1;
        goto L3
    L8:
        throw new IllegalStateException("multi source contains duplicate keys, key:" + r6);
    L9:
        this.a = r1.a();
        this.b = new ConcurrentHashMap(10);
        this.c = new ConcurrentHashMap(10);
    }

    @JvmStatic
    public static final synchronized b b(Context r2) {
        monitor-enter(b.class);
        b r3 = d.b(r2);     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "fgKey");
        ConcurrentHashMap<String, Boolean> r0 = this.c;
        Boolean r1 = r0.get(r4);
        if (r1 != null) goto L9;
        r1 = Boolean.valueOf(this.a.a(r4, false));
        Boolean r5 = r0.putIfAbsent(r4, r1);
        if (r5 == null) goto L9;
        r1 = r5;
    L9:
        return r1.booleanValue();
    }
}
