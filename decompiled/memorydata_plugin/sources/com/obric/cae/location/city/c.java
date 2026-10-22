package com.obric.cae.location.city;

import android.content.Context;
import android.location.Address;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f7051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7052b;
    public final ConcurrentHashMap<Integer, a> c;
    public final AtomicLong d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.obric.cae.libs.location.a f7054b;
        public final IBinder.DeathRecipient c;
        public volatile String d;
        public volatile String e;
        public volatile String f;
        public volatile String g;

        public a(int r3, com.obric.cae.libs.location.a r4, IBinder.DeathRecipient r5) {
            com.obric.cae.libs.location.a r6 = (com.obric.cae.libs.location.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.location.a.class, "com.obric.memorydata.plugin");
            IBinder.DeathRecipient r7 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");
            this.f7053a = r3;
            this.f7054b = r6;
            this.c = r7;
        }
    }

    public c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.c = new ConcurrentHashMap();
        this.d = new AtomicLong(0);
        this.f7052b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public static synchronized c a(Context r3) {
        monitor-enter(c.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (f7051a != null) goto L7;
        f7051a = new c(r4);     // Catch: Throwable -> L10
    L7:
        c r5 = f7051a;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void b(int r1) {
        this.c.remove(Integer.valueOf(r1));
    }

    public static /* synthetic */ void lambda$jAH0huev72qMEXoB4PTEiEvYYd0(c r0, int r1) {
        r0.b(r1);
    }

    public void a() {
        d.a(this.f7052b).a();
        b.a(this.f7052b).a();
    }

    public void a(int r2) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.c.remove(Integer.valueOf(r2)), a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        r1.f7054b.asBinder().unlinkToDeath(r1.c, 0);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public void a(final int r5, int r6, com.obric.cae.libs.location.a r7) {
        com.obric.cae.libs.location.a r8 = (com.obric.cae.libs.location.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.cae.libs.location.a.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        IBinder r0 = r8.asBinder();
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.c.remove(Integer.valueOf(r5)), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L15;
    L8:
        IBinder.DeathRecipient r2 = new $$Lambda$c$jAH0huev72qMEXoB4PTEiEvYYd0(this, r5);
        r0.linkToDeath(r2, 0);     // Catch: RemoteException -> L11
        a r3 = new a(r6, r8, r2);     // Catch: RemoteException -> L11
        this.c.put(Integer.valueOf(r5), r3);     // Catch: RemoteException -> L11
        a(r3, r5);     // Catch: RemoteException -> L11
        return;
    L11:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-city", "registerCityCallback linkToDeath failed: " + e.getMessage());
        return;
    L15:
        r1.f7054b.asBinder().unlinkToDeath(r1.c, 0);     // Catch: Throwable -> L14
        goto L8
    }

    public final void a(int r6, a r7, Address r8, String r9, String r10, String r11, String r12) {
        monitor-enter(r7);
        int r1 = r7.f7053a;     // Catch: Throwable -> L44
        if (r1 != 1) goto L7;
        String r2 = r7.d;     // Catch: Throwable -> L44
        if (r2 != null) goto L30;
        if (r9 != null) goto L29;
    L28:
        boolean r3 = true;
    L31:
        boolean r4 = !r3;     // Catch: Throwable -> L44
        if (r4 == false) goto L34;
        r7.d = r9;     // Catch: Throwable -> L44
        r7.e = r10;     // Catch: Throwable -> L44
        r7.f = r11;     // Catch: Throwable -> L44
        r7.g = r12;     // Catch: Throwable -> L44
    L34:
        monitor-exit(r7);     // Catch: Throwable -> L44
        if (r4 == true) goto L52;
        return;
    L52:
        r7.f7054b.a(r8);     // Catch: Throwable -> L39 RemoteException -> L41
        com.obric.cae.log.a.d("StarLocation-city", "notifyCityChanged: pid=" + r6 + ", address=" + r8);     // Catch: Throwable -> L39 RemoteException -> L41
    L55:
        return;
    L41:
        this.c.remove(Integer.valueOf(r6));
        r7.f7054b.asBinder().unlinkToDeath(r7.c, 0);     // Catch: Throwable -> L47
        return;
    L56:
        return;
    L39:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-city", "failed for pid=" + r6, th);
        return;
    L29:
        r3 = false;
        goto L31
    L30:
        r3 = r2.equals(r9);     // Catch: Throwable -> L44
        goto L31
    L7:
        if (r1 != 2) goto L9;
        String r5 = r7.e;     // Catch: Throwable -> L44
        if (r5 != null) goto L24;
        if (r10 != null) goto L29;
    L24:
        r3 = r5.equals(r10);     // Catch: Throwable -> L44
        goto L31
    L9:
        if (r1 == 3) goto L15;
        String r13 = r7.g;     // Catch: Throwable -> L44
        if (r13 != null) goto L14;
        if (r12 != null) goto L29;
    L14:
        r3 = r13.equals(r12);     // Catch: Throwable -> L44
        goto L31
    L15:
        String r14 = r7.f;     // Catch: Throwable -> L44
        if (r14 != null) goto L19;
        if (r11 != null) goto L29;
    L19:
        r3 = r14.equals(r11);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    public void a(Address r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        String r8 = r14.getAdminArea();
        String r9 = r14.getSubAdminArea();
        String r10 = r14.getLocality();
        String r11 = r14.getSubLocality();
        Iterator<Map.Entry<Integer, a>> r12 = this.c.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin");
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0.getValue(), a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        if (r2.f7054b == null) goto L6;
        a(r1.intValue(), r2, r14, r8, r9, r10, r11);
        goto L6
    }

    public void a(Address r10, long r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r1 = r10.getAdminArea();
        String r2 = r10.getSubAdminArea();
        String r3 = r10.getLocality();
        String r4 = r10.getSubLocality();
        if (TextUtils.isEmpty(r1) == false) goto L42;
        if (TextUtils.isEmpty(r2) == false) goto L42;
        if (TextUtils.isEmpty(r3) == false) goto L42;
        if (TextUtils.isEmpty(r4) == false) goto L42;
        com.obric.cae.log.a.d("StarLocation-city", "skip: city fields are empty");
        return;
    L42:
        com.obric.cae.location.database.c.C0354c r0 = com.obric.cae.location.database.c.a(this.f7052b, 0).a(r1, r2, r3, r4, r11);     // Catch: Throwable -> L37
        if (r0.f7079a == true) goto L21;
        com.obric.cae.log.a.j("StarLocation-city", "switch city storage returned failed");
        return;
    L21:
        if (r0.f7080b == true) goto L23;
    L29:
        b.a(this.f7052b).a(r10);
        long r5 = this.d.getAndSet(r11);
        if (r0.f7080b == false) goto L32;
    L35:
        a(r10);
        d.a(this.f7052b).a(r10);
        return;
    L32:
        if ((r11 - r5) >= 5000) goto L35;
        com.obric.cae.log.a.b("StarLocation-city", "debounce: skip due to consecutive calls within 5s");
        return;
    L23:
        if (TextUtils.isEmpty(r0.e) == true) goto L29;
        com.obric.cae.location.geosdk.poi.a.a(this.f7052b, 0).i();     // Catch: Throwable -> L26
        b.a(this.f7052b).a(r0.e, r0.c);
        d.a(this.f7052b).a(r0.e, r0.c);
    L26:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-city", "reload aoi boards after city switch failed", th);
        return;
    L37:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-city", "switch city storage failed", th);
    }

    public final void a(a r11, int r12) {
        com.obric.cae.location.database.c.b r0 = com.obric.cae.location.database.c.a(this.f7052b, 0).b();
        if (r0 != null) goto L5;
    L14:
        Address r1 = null;
    L15:
        Address r5 = r1;
        if (r5 != null) goto L19;
        com.obric.cae.log.a.d("StarLocation-city", "skip current city notify for pid=" + r12 + ": no cached city");
        return;
    L19:
        a(r12, r11, r5, r5.getAdminArea(), r5.getSubAdminArea(), r5.getLocality(), r5.getSubLocality());
        return;
    L5:
        if (TextUtils.isEmpty(r0.f7077a) == true) goto L7;
    L13:
        r1 = new Address(Locale.getDefault());
        r1.setAdminArea(r0.f7077a);
        r1.setSubAdminArea(r0.f7078b);
        r1.setLocality(r0.c);
        r1.setSubLocality(r0.d);
        goto L15
    L7:
        if (TextUtils.isEmpty(r0.f7078b) == false) goto L13;
        if (TextUtils.isEmpty(r0.c) == false) goto L13;
        if (TextUtils.isEmpty(r0.d) == false) goto L13;
        goto L13
    }

    public void b() {
        d.a(this.f7052b).b();
        b.a(this.f7052b).b();
    }

    public Address c() {
        com.obric.cae.location.database.c.b r2 = com.obric.cae.location.database.c.a(this.f7052b, 0).b();
        if (r2 != null) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r2.f7077a) == true) goto L7;
    L13:
        Address r0 = new Address(Locale.getDefault());
        r0.setAdminArea(r2.f7077a);
        r0.setSubAdminArea(r2.f7078b);
        r0.setLocality(r2.c);
        r0.setSubLocality(r2.d);
        return r0;
    L7:
        if (TextUtils.isEmpty(r2.f7078b) == false) goto L13;
        if (TextUtils.isEmpty(r2.c) == false) goto L13;
        if (TextUtils.isEmpty(r2.d) == false) goto L13;
        goto L13
    }
}
