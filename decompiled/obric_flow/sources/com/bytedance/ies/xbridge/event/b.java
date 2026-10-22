package com.bytedance.ies.xbridge.event;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.utils.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6326a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f6327b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f6328c = null;

    static {
        f6326a = LazyKt.lazy(EventCenter$eventQueue$2.f6320a);
        f6327b = LazyKt.lazy(EventCenter$eventSubscribers$2.f6321a);
        f6328c = LazyKt.lazy(EventCenter$nativeSubscribers$2.f6322a);
    }

    public static final void a(a r10) {
        long r5 = System.currentTimeMillis();
        ConcurrentSkipListSet r11 = new ConcurrentSkipListSet();
        Lazy r12 = f6326a;
        Iterator r13 = ((CopyOnWriteArrayList) r12.getValue()).iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        a r14 = (a) r13.next();
        if (Math.abs(r5 - r14.f6324b) <= 300000) goto L4;
        r11.add(r14);
        goto L4
    L8:
        Iterator r15 = r11.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        a r16 = (a) r15.next();
        ((CopyOnWriteArrayList) r12.getValue()).remove(r16);
        goto L10
    L12:
        ((CopyOnWriteArrayList) r12.getValue()).add(r10);
        CopyOnWriteArrayList r17 = (CopyOnWriteArrayList) ((ConcurrentHashMap) f6327b.getValue()).get(r10.f6323a);
        if (r17 == null) goto L18;
        Iterator r18 = r17.iterator();
    L16:
        if (r18.hasNext() == false) goto L26;
        b(r10, (e) r18.next());
        goto L16
    L26:
        return;
    }

    public static void b(a r10, e r11) {
        HashMap r5 = r10.f6325c;
        String r12 = r10.f6323a;
        if (r5 != null) goto L10;
        x0 r13 = r11.f6333c;
        Intrinsics.checkNotNullParameter(r12, "eventName");
        ((d) r13.f10812a).a(new c(r12, null));
        String r14 = "Publish Event:" + r12 + " no params";
        Intrinsics.checkNotNullParameter(r14, "msg");
        LinkedHashMap r15 = ne.b.f20228a;
        Intrinsics.checkNotNullParameter(ne.a.class, NotificationCompat.CATEGORY_SERVICE);
        if (ne.b.f20228a.get(ne.a.class) != null) goto L9;
        Log.i("BDXBridgeKit", r14);
        return;
    L9:
        throw new ClassCastException();
    L10:
        x0 r16 = r11.f6333c;
        Intrinsics.checkNotNull(r5);
        ug.e r17 = new ug.e(k.l(r5));
        Intrinsics.checkNotNullParameter(r12, "eventName");
        ((d) r16.f10812a).a(new c(r12, r17));
        String r18 = "Publish Event:" + r12 + " mapParams != null";
        Intrinsics.checkNotNullParameter(r18, "msg");
        LinkedHashMap r19 = ne.b.f20228a;
        Intrinsics.checkNotNullParameter(ne.a.class, NotificationCompat.CATEGORY_SERVICE);
        if (ne.b.f20228a.get(ne.a.class) != null) goto L15;
        Log.i("BDXBridgeKit", r18);
        return;
    L15:
        throw new ClassCastException();
    }

    public static final void c(d r5) {
        Intrinsics.checkNotNullParameter("pageReady", "eventName");
        Intrinsics.checkNotNullParameter(r5, "subscriber");
        Lazy r10 = f6328c;
        ConcurrentHashMap r11 = (ConcurrentHashMap) ((ConcurrentHashMap) r10.getValue()).get(r5);
        if (r11 == null) goto L14;
        e r12 = (e) r11.get("pageReady");
        if (r12 == null) goto L11;
        CopyOnWriteArrayList r13 = (CopyOnWriteArrayList) ((ConcurrentHashMap) f6327b.getValue()).get("pageReady");
        if (r13 == null) goto L9;
        r13.remove(r12);
    L9:
        e r14 = (e) r11.remove("pageReady");
    L11:
        if (r11.isEmpty() == false) goto L15;
        ((ConcurrentHashMap) r10.getValue()).remove(r5);
        return;
    L15:
        return;
    }

    public static final void d(String r5, d r10, long r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, "subscriber");
        Intrinsics.checkNotNullParameter(r12, "containerId");
        e r13 = new e(r12, r11, new x0(r10));
        Lazy r14 = f6328c;
        if (((ConcurrentHashMap) r14.getValue()).get(r10) != null) goto L5;
        ((ConcurrentHashMap) r14.getValue()).put(r10, new ConcurrentHashMap());
    L5:
        ConcurrentHashMap r15 = (ConcurrentHashMap) ((ConcurrentHashMap) r14.getValue()).get(r10);
        if (r15 == null) goto L8;
        e r16 = (e) r15.put(r5, r13);
    L8:
        Lazy r17 = f6327b;
        CopyOnWriteArrayList r18 = (CopyOnWriteArrayList) ((ConcurrentHashMap) r17.getValue()).get(r5);
        if (r18 != null) goto L12;
        r18 = new CopyOnWriteArrayList();
        ((ConcurrentHashMap) r17.getValue()).put(r5, r18);
    L12:
        if (r18.contains(r13) == false) goto L14;
        r18.set(r18.indexOf(r13), r13);
    L15:
        ((ConcurrentHashMap) r17.getValue()).put(r5, r18);
        Iterator r19 = ((CopyOnWriteArrayList) f6326a.getValue()).iterator();
    L17:
        if (r19.hasNext() == false) goto L23;
        a r20 = (a) r19.next();
        if (Intrinsics.areEqual(r20.f6323a, r5) == false) goto L17;
        if (r13.f6332b > r20.f6324b) goto L17;
        b(r20, r13);
        goto L17
    L23:
        return;
    L14:
        r18.add(r13);
        goto L15
    }
}
