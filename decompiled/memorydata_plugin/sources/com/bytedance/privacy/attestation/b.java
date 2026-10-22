package com.bytedance.privacy.attestation;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.e.c;
import com.bytedance.privacy.e.d;
import com.bytedance.privacy.e.e;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2998a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f2999b;
    private static final Map<String, a> c = null;
    private static final long d = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f3001b;

        public a(String r3) {
            this.f3000a = r3;
            this.f3001b = SystemClock.elapsedRealtime();
        }

        public boolean a() {
            c.a(b.f2998a, "isExpired current:" + SystemClock.elapsedRealtime() + ",elapsedRealtimeMs:" + this.f3001b);
            if ((SystemClock.elapsedRealtime() - this.f3001b) < b.b()) goto L5;
            return true;
        L5:
            return false;
        }

        public String b() {
            return this.f3000a;
        }
    }

    static {
        c = new ConcurrentHashMap();
        d = TimeUnit.DAYS.toMillis(1);
    }

    public b() {
    }

    private Bundle a(Context r4, String r5, AttestationConfig r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        r0.putString(com.bytedance.privacy.d.a.i(), r5);
    L35:
        e = move-exception;
        throw new BdPrivacyException("PseudoManager not initialized", -13, e);
    L4:
        if (r6.a(AttestationConfig.IdType.RPDID) == false) goto L13;
        String r1 = PrivacySdk.getPseudoManager().getPseudoDID(r7, r5);     // Catch: IllegalStateException -> L35
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.putString(com.bytedance.privacy.d.a.j(), r1);     // Catch: IllegalStateException -> L35
    L11:
        throw new BdPrivacyException("Get RPDID failed", -10);     // Catch: IllegalStateException -> L35
    L13:
        if (r6.a(AttestationConfig.IdType.RPUID) == false) goto L22;
        String r8 = PrivacySdk.getPseudoManager().getPseudoUID(r7, r5);     // Catch: IllegalStateException -> L35
        if (r8 == null) goto L20;
        if (r8.isEmpty() == true) goto L20;
        r0.putString(com.bytedance.privacy.d.a.k(), r8);     // Catch: IllegalStateException -> L35
    L20:
        throw new BdPrivacyException("Get RPUID failed", -11);     // Catch: IllegalStateException -> L35
    L22:
        if (r6.a(AttestationConfig.IdType.UDID) == false) goto L29;
        String r3 = d();     // Catch: IllegalStateException -> L35
        if (r3.isEmpty() == true) goto L27;
        r0.putString(com.bytedance.privacy.d.a.l(), r3);     // Catch: IllegalStateException -> L35
        goto L29
    L27:
        throw new BdPrivacyException("Get UDID failed", -12);     // Catch: IllegalStateException -> L35
    L29:
        if (r6.b() == false) goto L32;
        r0.putBoolean(com.bytedance.privacy.d.a.h(), true);     // Catch: IllegalStateException -> L35
    L32:
        if (r6.a() == null) goto L34;
        r0.putString(com.bytedance.privacy.d.a.m(), r6.a());
    L34:
        return r0;
    }

    public static b a() {
        if (f2999b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2999b != null) goto L9;
        f2999b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2999b;
    }

    static /* synthetic */ long b() {
        return d;
    }

    private String b(Context r10, String r11, String r12, AttestationConfig r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        c(r14, r11, r12, r13);
        if (e.a() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        String r1 = f2998a;
        if (r0 == true) goto L20;
        c.b(r1, "Entering cache check...");
        a r2 = (a) ZeusTransformUtils.preCheckCast(c.get(r12), a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L13;
    L16:
        if (r2 != null) goto L18;
        StringBuilder r3 = new StringBuilder();
        String r4 = "Attestation cache miss for keyAlias: ";
    L19:
        c.b(r1, r3.append(r4).append(r12).toString());
        String r5 = "Exiting cache check, moving to network flow";
    L21:
        c.b(r1, r5);
        String r7 = r12.intern();
        monitor-enter(r7);
        Map<String, a> r8 = c;     // Catch: Throwable -> L49
        a r6 = (a) ZeusTransformUtils.preCheckCast(r8.get(r12), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        if (r0 == true) goto L31;
        if (r6 == null) goto L31;
        if (r6.a() == true) goto L31;
        c.b(f2998a, "Cache hit after wait for keyAlias: " + r12);     // Catch: Throwable -> L49
        String r9 = r6.b();     // Catch: Throwable -> L49
        monitor-exit(r7);     // Catch: Throwable -> L49
        return r9;
    L31:
        Bundle r15 = a(r14, r11, r13);     // Catch: Throwable -> L49
        Bundle r16 = c();     // Catch: Throwable -> L49
        String r17 = com.bytedance.privacy.pseudoid.a.a.f3079a.d();     // Catch: Throwable -> L49
        if (r17.isEmpty() == true) goto L48;
        com.bytedance.privacy.b.a.a().a(r14, r12);     // Catch: Throwable -> L49
        List<Certificate> r18 = com.bytedance.privacy.b.a.a().a(r14, r11, r17, r12, r16, r15);     // Catch: Throwable -> L49
        if (r18 == null) goto L46;
        if (r18.isEmpty() == true) goto L46;
        String r19 = com.bytedance.privacy.e.a.a(r18, 3);     // Catch: Exception -> L42 Throwable -> L49
        r8.put(r12, new a(r19));     // Catch: Throwable -> L49
        c.b(f2998a, "Successfully gen attestation and stored in cache for keyAlias: " + r12);     // Catch: Throwable -> L49
        com.bytedance.privacy.b.a.a().a(r14, r12);     // Catch: Throwable -> L49
        monitor-exit(r7);     // Catch: Throwable -> L49
        return r19;
    L42:
        e = move-exception;
        c.a(f2998a, "certsToPemString unexpected error: " + e.getMessage(), e);     // Catch: Throwable -> L49
        throw new BdPrivacyException(e.getMessage(), -100, e);     // Catch: Throwable -> L49
    L46:
        throw new BdPrivacyException("Get id attest cert chain failed", -9);     // Catch: Throwable -> L49
    L48:
        throw new BdPrivacyException("Get device id failed", -4);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    L18:
        r3 = new StringBuilder();
        r4 = "Attestation cache expired for keyAlias: ";
        goto L19
    L13:
        if (r2.a() == true) goto L16;
        c.b(r1, "Cache hit, returning cert chain for keyAlias: " + r12);
        return r2.b();
    L20:
        r5 = "Debug mode with force cloud fetch, skipping cache check";
        goto L21
    L5:
        if (e.a(2) == false) goto L7;
        r0 = true;
        goto L8
    }

    private Bundle c() {
        Bundle r2 = new Bundle();
        r2.putInt(com.bytedance.privacy.d.a.a(), com.bytedance.privacy.d.a.d());
        r2.putInt(com.bytedance.privacy.d.a.b(), 256);
        r2.putInt(com.bytedance.privacy.d.a.c(), com.bytedance.privacy.d.a.e());
        return r2;
    }

    private void c(Context r2, String r3, String r4, AttestationConfig r5) {
        d.a("context", (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        d.a("config", r5);
        d.a("appId", r3, 128);
        d.a("keyAlias", r4, com.bytedance.privacy.d.a.n());
    }

    private String d() {
        String r3 = com.bytedance.privacy.pseudoid.a.a.f3079a.e();
        if (r3.length() == 64) goto L6;
        c.d(f2998a, "Invalid UDID length: " + r3.length());
        return "";
    L6:
        return r3;
    }

    public String a(Context r10, String r11, String r12, AttestationConfig r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L5;
        String r4 = r14.getPackageName();
    L6:
        long r1 = SystemClock.elapsedRealtime();
        String r9 = b(r14, r11, r12, r13);     // Catch: Throwable -> L17 BdPrivacyException -> L19
        long r6 = SystemClock.elapsedRealtime() - r1;
        if (r11 == null) goto L11;
        String r5 = r11;
    L12:
        if (r13 != null) goto L15;
        r13 = new AttestationConfig.a().a();
    L15:
        com.bytedance.privacy.attestation.a.a(0, 0, r4, r5, r6, r13);
        return r9;
    L11:
        r5 = "";
        goto L12
    L19:
        e = move-exception;
        int r15 = e.getErrorCode();     // Catch: Throwable -> L17
        c.d(f2998a, "getIDAttestationString failed: " + e.getMessage());     // Catch: Throwable -> L23
        throw e;     // Catch: Throwable -> L23
    L23:
        th = th;
    L24:
        long r7 = SystemClock.elapsedRealtime() - r1;
        if (r11 == null) goto L27;
        String r8 = r11;
    L28:
        if (r13 != null) goto L31;
        r13 = new AttestationConfig.a().a();
    L31:
        com.bytedance.privacy.attestation.a.a(r15, 0, r4, r8, r7, r13);
        throw th;
    L27:
        r8 = "";
    L17:
        th = th;
        r15 = 0;
        goto L24
    L5:
        r4 = "";
        goto L6
    }
}
