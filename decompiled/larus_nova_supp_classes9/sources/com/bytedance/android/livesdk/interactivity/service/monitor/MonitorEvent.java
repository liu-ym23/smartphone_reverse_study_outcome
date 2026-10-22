package com.bytedance.android.livesdk.interactivity.service.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MonitorEvent {
    public final List<String> a;
    public final Map<String, h> b;
    public final Map<String, c> c;
    public final Map<String, com.bytedance.android.livesdk.interactivity.service.monitor.a> d;
    public final Lazy e;
    public final List<g> f;
    public final EventName g;
    public final UploadMode h;
    public final long i;

    public static final class a {
    }

    public static final class b {
        public final List<String> a;
        public final List<String> b;
        public final Map<String, String> c;
        public final List<String> d;
        public final List<String> e;
        public final List<g> f;
        public final EventName g;
        public final UploadMode h;
        public final long i;

        public final MonitorEvent f() {
            MonitorEvent r0 = new MonitorEvent(this.g, this.h, this.i);
            List<String> r1 = r0.a;
            ArrayList r2 = (ArrayList) r1;
            r2.addAll(this.a);
            List<g> r3 = r0.f;
            ArrayList r4 = (ArrayList) r3;
            r4.addAll(this.f);
            Iterator r5 = ((LinkedHashMap) this.c).entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Map.Entry r6 = (Map.Entry) r5.next();
            String r7 = (String) r6.getValue();
            if (r7 == null) goto L4;
            Map<String, c> r8 = r0.c;
            Object r9 = r6.getKey();
            String r10 = (String) r9;
            r8.put(r10, new c((String) r6.getKey(), r7));
            goto L4
        L8:
            return r0;
        }

        public final void a(g r2) {
            Intrinsics.checkNotNullParameter(r2, "alarm");
            ((ArrayList) this.f).add(r2);
        }

        public /* synthetic */ b(EventName r3, UploadMode r4) {
            this(r3, r4, 0);
        }

        public final void b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "nodeName");
            if (((ArrayList) this.e).contains(r2) == false) goto L5;
            return;
        L5:
            ((ArrayList) this.e).add(r2);
            if (r3 == false) goto L9;
            ((ArrayList) this.a).add(r2);
            return;
        }

        public final void d(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "indiName");
            if (((ArrayList) this.d).contains(r2) == false) goto L5;
            return;
        L5:
            ((ArrayList) this.d).add(r2);
            if (r3 == false) goto L9;
            ((ArrayList) this.a).add(r2);
            return;
        }

        public final void e(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "itemName");
            if (((ArrayList) this.b).contains(r2) == false) goto L5;
            return;
        L5:
            ((ArrayList) this.b).add(r2);
            if (r3 == false) goto L9;
            ((ArrayList) this.a).add(r2);
            return;
        }

        public b(EventName r2, UploadMode r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "uploadMode");
            this.g = r2;
            this.h = r3;
            this.i = r4;
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new LinkedHashMap();
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.f = new ArrayList();
        }

        public final void c(String r2, boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "descName");
            if (this.c.containsKey(r2) == false) goto L5;
            return;
        L5:
            this.c.put(r2, r4);
            if (r3 == false) goto L9;
            ((ArrayList) this.a).add(r2);
            return;
        }
    }

    static {
    }

    public final Map<String, com.bytedance.android.livesdk.interactivity.service.monitor.b> b() {
        return (Map) this.e.getValue();
    }

    public final void d() {
        ((LinkedHashMap) this.b).clear();
        ((LinkedHashMap) this.c).clear();
        ((LinkedHashMap) this.d).clear();
        b().clear();
    }

    public final Map<String, String> a(boolean r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        if (((ArrayList) this.a).contains(r2.getKey()) == false) goto L4;
        r0.put(((h) r2.getValue()).a, String.valueOf(((h) r2.getValue()).b));
        goto L4
    L8:
        Iterator r3 = ((LinkedHashMap) this.c).entrySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (((ArrayList) this.a).contains(r4.getKey()) == false) goto L10;
        r0.put(((c) r4.getValue()).a, ((c) r4.getValue()).b);
        goto L10
    L14:
        Iterator r5 = ((LinkedHashMap) this.d).entrySet().iterator();
    L16:
        if (r5.hasNext() == false) goto L29;
        Map.Entry r6 = (Map.Entry) r5.next();
        if (((ArrayList) this.a).contains(r6.getKey()) == false) goto L16;
        Object r7 = r6.getValue();
        if (((com.bytedance.android.livesdk.interactivity.service.monitor.a) r7).c <= 0) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L26;
        r7 = null;
    L26:
        com.bytedance.android.livesdk.interactivity.service.monitor.a r9 = (com.bytedance.android.livesdk.interactivity.service.monitor.a) r7;
        if (r9 == null) goto L16;
        r0.put(((com.bytedance.android.livesdk.interactivity.service.monitor.a) r6.getValue()).a, String.valueOf(r9.b / r9.c));
        goto L16
    L22:
        r8 = false;
        goto L23
    L29:
        Iterator<Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.monitor.b>> r11 = b().entrySet().iterator();
    L31:
        if (r11.hasNext() == false) goto L35;
        Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.monitor.b> r13 = r11.next();
        if (((ArrayList) this.a).contains(r13.getKey()) == false) goto L31;
        r0.put(r13.getValue().a, r13.getValue().b);
        goto L31
    L35:
        if (r10 == false) goto L40;
        Iterator r14 = ((ArrayList) this.f).iterator();
    L38:
        if (r14.hasNext() == false) goto L40;
        ((g) r14.next()).a(this);
    L40:
        return r0;
    }

    public final Long c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        h r4 = (h) ((LinkedHashMap) this.b).get(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r4.b);
    }

    public MonitorEvent(EventName r2, UploadMode r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "uploadMode");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.a = new ArrayList();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(MonitorEvent$constantNodeStore$2.INSTANCE);
        this.f = new ArrayList();
    }
}
