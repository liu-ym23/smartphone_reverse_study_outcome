package com.bytedance.android.annie.ng;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final o8.h a;
    public final o8.f b;
    public final o8.e c;
    public final o8.g d;

    /* JADX INFO: renamed from: com.bytedance.android.annie.ng.a$a, reason: collision with other inner class name */
    public static final class C0073a {
        public final String a;
        public final o8.h b;
        public final o8.f c;
        public final o8.e d;
        public final o8.g e;

        public final void a() {
            ConcurrentHashMap<String, b> r0 = g.d;
            if (r0.get(this.a) == null) goto L6;
            Intrinsics.checkNotNull(r0.get(this.a));
            return;
        L6:
            List<String> r1 = g.f;
            if (r1.contains(this.a) == true) goto L9;
            r1.add(this.a);
        L9:
            String r10 = this.a;
            a r11 = new a(this.b, this.c, this.d, this.e);
            Intrinsics.checkNotNullParameter(r10, "bizKey");
            g.c.put(this.a, r11);
            Map<String, Map<String, h>> r12 = i.a;
            monitor-enter(r12);
            LinkedHashMap r13 = (LinkedHashMap) r12;     // Catch: Throwable -> L22
            Map r14 = (Map) r13.get(this.a);     // Catch: Throwable -> L22
            if (r14 == null) goto L14;
            Iterator r15 = r14.entrySet().iterator();     // Catch: Throwable -> L22
        L15:
            if (r15 != null) goto L17;
        L19:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r12);
            return;
        L17:
            if (r15.hasNext() == false) goto L19;
            ((h) ((Map.Entry) r15.next()).getValue()).onCallback();     // Catch: Throwable -> L22
            goto L17
        L14:
            r15 = null;
        L22:
            th = move-exception;
            throw th;
        }

        public C0073a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "bizKey");
            this.a = r10;
            this.b = new o8.h();
            this.c = new o8.f(0);
            this.d = new o8.e(0);
            this.e = new o8.g();
        }
    }

    public a(o8.h r1, o8.f r10, o8.e r11, o8.g r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
