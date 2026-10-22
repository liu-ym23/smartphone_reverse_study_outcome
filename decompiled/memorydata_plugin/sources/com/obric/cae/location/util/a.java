package com.obric.cae.location.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f7281a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f7282b = null;

    /* JADX INFO: renamed from: com.obric.cae.location.util.a$a, reason: collision with other inner class name */
    public class C0360a implements Geocoder.GeocodeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f7283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f7284b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public C0360a(AtomicReference r1, CountDownLatch r2, String r3, String r4) {
            this.f7283a = r1;
            this.f7284b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.location.Geocoder.GeocodeListener
        public final void onError(String r4) {
            com.obric.cae.log.a.i(this.c, this.d + ": " + r4);
            this.f7284b.countDown();
        }

        @Override // android.location.Geocoder.GeocodeListener
        public final void onGeocode(List<Address> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.f7283a.set(Collections.unmodifiableList(new ArrayList(r4)));
            this.f7284b.countDown();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Address> f7285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7286b;

        public b(List<Address> r5) {
            this.f7285a = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            long r0 = System.currentTimeMillis();
            this.f7286b = a.a() + r0;
        }

        public static boolean a(b r4) {
            if (System.currentTimeMillis() <= r4.f7286b) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f7281a = TimeUnit.MINUTES.toMillis(10);
        f7282b = new ConcurrentHashMap();
    }

    public static /* synthetic */ long a() {
        return f7281a;
    }

    public static Address a(Context r9, String r10, long r11, String r13, String r14) {
        List<Address> r12 = a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), r10, 1, r11, r13, r14);
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.isEmpty() == false) goto L8;
        return null;
    L8:
        return (Address) ZeusTransformUtils.preCheckCast(r12.get(0), Address.class, "com.obric.memorydata.plugin");
    }

    public static List<Address> a(Context r9, String r10, int r11, long r12, String r14, String r15) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L9;
        StringBuilder r16 = new StringBuilder().append(r15);
        String r17 = ": context is null";
    L5:
        StringBuilder r18 = r16.append(r17);
    L6:
        com.obric.cae.log.a.i(r14, r18.toString());
        return null;
    L9:
        if (TextUtils.isEmpty(r10) == false) goto L12;
        r16 = new StringBuilder().append(r15);
        r17 = ": address is empty";
        goto L5
    L12:
        if (Geocoder.isPresent() == true) goto L14;
        r16 = new StringBuilder().append(r15);
        r17 = ": geocoder is unavailable";
        goto L5
    L14:
        String r2 = r10.trim().toLowerCase(Locale.ROOT);
        ConcurrentHashMap<String, b> r3 = f7282b;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.get(r2), b.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L17;
    L20:
        AtomicReference r5 = new AtomicReference(Collections.emptyList());
        CountDownLatch r6 = new CountDownLatch(1);
        new Geocoder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Locale.getDefault()).getFromLocationName(r10, Math.max(r11, 1), new C0360a(r5, r6, r14, r15));
    L47:
        e = move-exception;
        Thread.currentThread().interrupt();
        r18 = new StringBuilder().append(r15).append(": interrupted: ").append(e.getMessage());
        goto L6
    L22:
        if (r6.await(r12, TimeUnit.MILLISECONDS) == true) goto L25;
        com.obric.cae.log.a.i(r14, r15 + ": timeout");     // Catch: InterruptedException -> L47
        return null;
    L25:
        List<Address> r19 = (List) ZeusTransformUtils.preCheckCast(r5.get(), List.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L28;
    L46:
        r16 = new StringBuilder().append(r15);
        r17 = ": no address result";
        goto L5
    L28:
        if (r19.isEmpty() == true) goto L46;
        if (r3.size() < 64) goto L44;
        long r110 = System.currentTimeMillis();
        Iterator<String> r111 = r3.keySet().iterator();
    L35:
        if (r111.hasNext() == false) goto L41;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111.next(), String.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap<String, b> r113 = f7282b;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r113.get(r112), b.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L40;
        if (r0.f7286b > r110) goto L35;
    L40:
        r113.remove(r112);
        goto L35
    L41:
        ConcurrentHashMap<String, b> r114 = f7282b;
        if (r114.size() < 64) goto L44;
        r114.clear();
    L44:
        f7282b.put(r2, new b(r19));
        return r19;
    L17:
        if (b.a(r4) == true) goto L20;
        com.obric.cae.log.a.c(r14, r15 + ": hit geocoder cache for address=" + r10);
        return r4.f7285a;
    }
}
