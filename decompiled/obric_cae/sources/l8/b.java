package l8;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import defpackage.c;
import java.security.cert.Certificate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f9181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f9182b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f9183c = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Certificate> f9184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9185b;

        public a(List<Certificate> r8) {
            this.f9184a = r8;
            this.f9185b = System.currentTimeMillis();
        }
    }

    static {
        f9182b = new ConcurrentHashMap();
        f9183c = TimeUnit.DAYS.toMillis(1);
    }

    public b() {
    }

    public static Bundle a(Context r8, l8.a r10) {
        Bundle r11 = new Bundle();
        r11.putString("attest_appid", "ocean_location");
        l8.a.b[] r12 = l8.a.b.f9180a;     // Catch: IllegalStateException -> L43
        boolean[] r13 = r10.f9176a;     // Catch: IllegalStateException -> L43
        if (r13[1] == false) goto L13;
        k8.a.a().getClass();     // Catch: IllegalStateException -> L43
        String r14 = q8.a.a(r8);     // Catch: IllegalStateException -> L43
        if (r14 == null) goto L11;
        if (r14.isEmpty() == true) goto L11;
        r11.putString("attest_rpdid", r14);     // Catch: IllegalStateException -> L43
    L11:
        throw new n8.a("Get RPDID failed");     // Catch: IllegalStateException -> L43
    L13:
        if (r13[2] == false) goto L22;
        k8.a.a().getClass();     // Catch: IllegalStateException -> L43
        String r15 = q8.a.c(r8);     // Catch: IllegalStateException -> L43
        if (r15 == null) goto L20;
        if (r15.isEmpty() == true) goto L20;
        r11.putString("attest_rpuid", r15);     // Catch: IllegalStateException -> L43
    L20:
        throw new n8.a("Get RPUID failed");     // Catch: IllegalStateException -> L43
    L22:
        if (r13[0] == false) goto L39;
        m8.a r16 = l6.a.f9154w;     // Catch: IllegalStateException -> L43
        if (r16 == null) goto L26;
        String r17 = r16.onGetUDID();     // Catch: IllegalStateException -> L43
    L27:
        String r18 = "";
        if (r17 != null) goto L31;
        r17 = "";
    L31:
        if (r17.length() == 64) goto L33;
        Log.e("b", "Invalid UDID length: " + r17.length());     // Catch: IllegalStateException -> L43
    L35:
        if (r18.isEmpty() == true) goto L38;
        r11.putString("attest_udid", r18);     // Catch: IllegalStateException -> L43
        goto L39
    L38:
        throw new n8.a("Get UDID failed");     // Catch: IllegalStateException -> L43
    L33:
        r18 = r17;
        goto L35
    L26:
        r17 = null;
    L39:
        String r19 = r10.f9177b;
        if (r19 == null) goto L42;
        r11.putString("attest_custom_info", r19);
    L42:
        return r11;
    L43:
        e = move-exception;
        throw new n8.a("PseudoManager not initialized", e);
    }

    public static List b(Context r12, l8.a r13) {
        c.y(r12, "context");
        c.x("appId", "ocean_location");
        c.x("keyAlias", "ocean_location_attestation");
        Log.i("b", "Entering cache check...");
        ConcurrentHashMap r8 = f9182b;
        a r10 = (a) r8.get("ocean_location_attestation");
        boolean r11 = true;
        if (r10 != null) goto L5;
    L11:
        if (r10 != null) goto L13;
        String r14 = "b";
        String r15 = "Attestation cache miss for keyAlias: ";
    L14:
        Log.i(r14, r15.concat("ocean_location_attestation"));
        Log.i("b", "Exiting cache check, moving to network flow");
        String r16 = "ocean_location_attestation".intern();
        monitor-enter(r16);
        a r17 = (a) r8.get("ocean_location_attestation");     // Catch: Throwable -> L26
        if (r17 != null) goto L19;
    L28:
        r13.toString();     // Catch: Throwable -> L26
        Bundle r18 = a(r12, r13);     // Catch: Throwable -> L26
        Bundle r19 = new Bundle();     // Catch: Throwable -> L26
        r19.putInt("key_algorithm", 2);     // Catch: Throwable -> L26
        r19.putInt("key_length", 256);     // Catch: Throwable -> L26
        r19.putInt("key_purpose", 64);     // Catch: Throwable -> L26
        m8.a r20 = l6.a.f9154w;     // Catch: Throwable -> L26
        if (r20 == null) goto L31;
        String r21 = r20.onGetDeviceId();     // Catch: Throwable -> L26
    L32:
        if (r21 != null) goto L35;
        r21 = "";
    L35:
        if (r21.isEmpty() == true) goto L44;
        o8.a.d().getClass();     // Catch: Throwable -> L26
        List r110 = o8.a.c(r12, r21, r19, r18);     // Catch: Throwable -> L26
        if (r110.isEmpty() == true) goto L42;
        r8.put("ocean_location_attestation", new a(r110));     // Catch: Throwable -> L26
        Log.i("b", "Successfully gen attestation and stored in cache for keyAlias: ".concat("ocean_location_attestation"));     // Catch: Throwable -> L26
        o8.a.d().getClass();     // Catch: Throwable -> L26
        o8.a.a(r12, "ocean_location_attestation");     // Catch: Throwable -> L26
        monitor-exit(r16);     // Catch: Throwable -> L26
        return r110;
    L42:
        throw new n8.a("Get id attest cert chain failed");     // Catch: Throwable -> L26
    L44:
        throw new n8.a("Get device id failed");     // Catch: Throwable -> L26
    L31:
        r21 = null;
        goto L32
    L19:
        if ((System.currentTimeMillis() - r17.f9185b) >= f9183c) goto L22;
        r11 = false;
    L22:
        if (r11 == true) goto L28;
        Log.i("b", "Cache hit after wait for keyAlias: ".concat("ocean_location_attestation"));     // Catch: Throwable -> L26
        List<Certificate> r111 = r17.f9184a;     // Catch: Throwable -> L26
        monitor-exit(r16);     // Catch: Throwable -> L26
        return r111;
    L26:
        th = move-exception;
        throw th;
    L13:
        r14 = "b";
        r15 = "Attestation cache expired for keyAlias: ";
        goto L14
    L5:
        if ((System.currentTimeMillis() - r10.f9185b) < f9183c) goto L7;
        boolean r22 = true;
    L8:
        if (r22 == true) goto L11;
        Log.i("b", "Cache hit, returning cert chain for keyAlias: ".concat("ocean_location_attestation"));
        return r10.f9184a;
    L7:
        r22 = false;
        goto L8
    }

    public static String c(Context r8, l8.a r10) {
        return t8.a.a(b(r8, r10));
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new n8.a("Failed to convert cert to pem", e);
    }

    public static b d() {
        if (f9181a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9181a != null) goto L9;
        f9181a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f9181a;
    }
}
