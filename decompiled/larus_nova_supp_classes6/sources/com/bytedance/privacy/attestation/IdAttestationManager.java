package com.bytedance.privacy.attestation;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.obric.sva.sdk.data.ISmModel;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import k67.b;
import k67.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IdAttestationManager {
    private static final long CACHE_ENTRY_LIFETIME_MS = 0;
    public static final String TAG = null;
    private static final Map<String, a> attestationCacheMap = null;
    private static volatile IdAttestationManager idAttestationManager;

    public IdAttestationManager() {
    }

    static {
        TAG = "IdAttestationManager";
        attestationCacheMap = new ConcurrentHashMap();
        CACHE_ENTRY_LIFETIME_MS = TimeUnit.DAYS.toMillis(1);
    }

    private Bundle buildKeyBundle() {
        Bundle r0 = new Bundle();
        j67.a.b().o();
        j67.a.b().keyAlgorithmEcc();
        r0.putInt("key_algorithm", 2);
        j67.a.b().i();
        r0.putInt("key_length", ISmModel.VERSION_0100);
        j67.a.b().u();
        j67.a.b().purposeAttestKey();
        r0.putInt("key_purpose", 64);
        return r0;
    }

    public static IdAttestationManager getInstance() {
        if (idAttestationManager != null) goto L15;
        monitor-enter(IdAttestationManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (idAttestationManager != null) goto L9;
        idAttestationManager = new IdAttestationManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IdAttestationManager.class);     // Catch: Throwable -> L11
    L15:
        return idAttestationManager;
    }

    private String getUDID() {
        String r0 = AccountApi.INSTANCE.getUDID();
        if (r0.length() == 64) goto L6;
        b.c(TAG, "Invalid UDID length: " + r0.length());
        return "";
    L6:
        return r0;
    }

    public static /* synthetic */ long access$000() {
        return CACHE_ENTRY_LIFETIME_MS;
    }

    private Bundle buildAttestBundle(Context r4, String r5, AttestationConfig r6) throws BdPrivacyException {
        Bundle r0 = new Bundle();
        j67.a.b().g();
        r0.putString("attest_appid", r5);
    L37:
        e = move-exception;
        throw new BdPrivacyException("PseudoManager not initialized", -13, e);
    L4:
        if (r6.isIdRequested(AttestationConfig.IdType.RPDID) == false) goto L13;
        String r1 = PrivacySdk.getPseudoManager().getPseudoDID(r4, r5);     // Catch: IllegalStateException -> L37
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        j67.a.b().c();     // Catch: IllegalStateException -> L37
        r0.putString("attest_rpdid", r1);     // Catch: IllegalStateException -> L37
    L11:
        throw new BdPrivacyException("Get RPDID failed", -10);     // Catch: IllegalStateException -> L37
    L13:
        if (r6.isIdRequested(AttestationConfig.IdType.RPUID) == false) goto L22;
        String r7 = PrivacySdk.getPseudoManager().getPseudoUID(r4, r5);     // Catch: IllegalStateException -> L37
        if (r7 == null) goto L20;
        if (r7.isEmpty() == true) goto L20;
        j67.a.b().a();     // Catch: IllegalStateException -> L37
        r0.putString("attest_rpuid", r7);     // Catch: IllegalStateException -> L37
    L20:
        throw new BdPrivacyException("Get RPUID failed", -11);     // Catch: IllegalStateException -> L37
    L22:
        if (r6.isIdRequested(AttestationConfig.IdType.UDID) == false) goto L31;
        String r8 = getUDID();     // Catch: IllegalStateException -> L37
        if (r8.isEmpty() == true) goto L29;
        j67.a.b().j();     // Catch: IllegalStateException -> L37
        r0.putString("attest_udid", r8);     // Catch: IllegalStateException -> L37
        goto L31
    L29:
        throw new BdPrivacyException("Get UDID failed", -12);     // Catch: IllegalStateException -> L37
    L31:
        if (r6.isDevHealthStatusRequired() == false) goto L34;
        j67.a.b().q();     // Catch: IllegalStateException -> L37
        r0.putBoolean("device_health_status_required", true);     // Catch: IllegalStateException -> L37
    L34:
        if (r6.getCustomInfo() == null) goto L36;
        j67.a.b().d();
        r0.putString("attest_custom_info", r6.getCustomInfo());
    L36:
        return r0;
    }

    private String getIDAttestation(Context r15, String r16, String r17, AttestationConfig r18) throws BdPrivacyException {
        validateInput(r15, r16, r17, r18);
        String r10 = TAG;
        b.e(r10, "Entering cache check...");
        Map<String, a> r11 = attestationCacheMap;
        a r2 = r11.get(r17);
        if (r2 != null) goto L5;
    L8:
        if (r2 != null) goto L10;
        b.e(r10, "Attestation cache miss for keyAlias: " + r17);
    L11:
        b.e(r10, "Exiting cache check, moving to network flow");
        String r12 = r17.intern();
        monitor-enter(r12);
        a r3 = r11.get(r17);     // Catch: Throwable -> L40
        if (r3 != null) goto L16;
    L20:
        b.a(r10, r18.toString());     // Catch: Throwable -> L40
        Bundle r6 = buildAttestBundle(r15, r16, r18);     // Catch: Throwable -> L31
        Bundle r5 = buildKeyBundle();     // Catch: Throwable -> L31
        String r4 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L31
        if (r4.isEmpty() == true) goto L39;
        d67.a.d().getClass();     // Catch: Throwable -> L31
        d67.a.a(r15, r17);     // Catch: Throwable -> L31
        d67.a.d().getClass();     // Catch: Throwable -> L31
        List r1 = d67.a.c(r15, r16, r4, r17, r5, r6);     // Catch: Throwable -> L31
        if (r1.isEmpty() == true) goto L37;
        String r7 = k67.a.a(r1, 3);     // Catch: Throwable -> L31 Exception -> L33
        r11.put(r17, new a(r7));     // Catch: Throwable -> L31
        b.e(r10, "Successfully gen attestation and stored in cache for keyAlias: ".concat(r17));     // Catch: Throwable -> L31
        d67.a.d().getClass();     // Catch: Throwable -> L31
        d67.a.a(r15, r17);     // Catch: Throwable -> L31
        monitor-exit(r12);     // Catch: Throwable -> L31
        return r7;
    L33:
        e = move-exception;
        b.b(TAG, "certsToPemString unexpected error: " + e.getMessage());     // Catch: Throwable -> L31
        throw new BdPrivacyException(e.getMessage(), -100, e);     // Catch: Throwable -> L31
    L37:
        throw new BdPrivacyException("Get id attest cert chain failed", -9);     // Catch: Throwable -> L31
    L39:
        throw new BdPrivacyException("Get device id failed", -4);     // Catch: Throwable -> L31
    L16:
        if (r3.a() == true) goto L20;
        b.e(r10, "Cache hit after wait for keyAlias: ".concat(r17));     // Catch: Throwable -> L40
        String r0 = r3.a;     // Catch: Throwable -> L40
        monitor-exit(r12);     // Catch: Throwable -> L40
        return r0;
    L31:
        th = th;
    L42:
        monitor-exit(r12);     // Catch: Throwable -> L31
        throw th;
    L40:
        th = th;
        goto L42
    L10:
        b.e(r10, "Attestation cache expired for keyAlias: " + r17);
        goto L11
    L5:
        if (r2.a() == true) goto L8;
        b.e(r10, "Cache hit, returning cert chain for keyAlias: " + r17);
        return r2.a;
    }

    private void validateInput(Context r2, String r3, String r4, AttestationConfig r5) throws BdPrivacyException {
        c.b("context", r2);
        c.b("config", r5);
        c.a("appId", r3, 128);
        j67.a.b().s();
        c.a("keyAlias", r4, 128);
    }

    public String getIDAttestationString(Context r11, String r12, String r13, AttestationConfig r14) throws BdPrivacyException {
        if (r11 == null) goto L5;
        String r5 = r11.getPackageName();
    L6:
        long r3 = SystemClock.elapsedRealtime();
        String r15 = getIDAttestation(r11, r12, r13, r14);     // Catch: Throwable -> L17 BdPrivacyException -> L19
        long r6 = SystemClock.elapsedRealtime() - r3;
        if (r12 == null) goto L11;
        String r4 = r12;
    L12:
        if (r14 != null) goto L15;
        r14 = new AttestationConfig.Builder().build();
    L15:
        a.a(0, r5, r4, r6, r14);
        return r15;
    L11:
        r4 = "";
        goto L12
    L17:
        th = move-exception;
        long r7 = SystemClock.elapsedRealtime() - r3;
        if (r12 == null) goto L25;
        String r8 = r12;
    L26:
        if (r14 != null) goto L29;
        r14 = new AttestationConfig.Builder().build();
    L29:
        a.a(0, r5, r8, r7, r14);
        throw th;
    L25:
        r8 = "";
    L19:
        e = move-exception;
        e.getErrorCode();     // Catch: Throwable -> L17
        b.c(TAG, "getIDAttestationString failed: " + e.getMessage());     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L5:
        r5 = "";
        goto L6
    }
}
