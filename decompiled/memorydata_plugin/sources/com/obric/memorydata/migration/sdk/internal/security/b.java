package com.obric.memorydata.migration.sdk.internal.security;

import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rJ\u0016\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rJ\u0010\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/security/MigrationCrypto;", "", "<init>", "()V", "QR_HANDSHAKE_KEY_SEED", "", "SESSION_KEY_SIZE_BYTES", "", "QR_KEY_SIZE_BYTES", "GCM_NONCE_BYTES", "GCM_TAG_BITS", "TRANSFORMATION", "ZIP_MAGIC", "", "getZIP_MAGIC", "()[B", "ZIP_MAGIC_V2", "getZIP_MAGIC_V2", "ZIP_GCM_NONCE_BYTES", "rng", "Ljava/security/SecureRandom;", "generateRandomSessionKeyBase64", "randomBytes", "size", "hmacSha256", "key", "data", "constantTimeEquals", "", "a", "b", "encryptQrPayload", "plainJson", "decryptQrPayload", "encryptedBase64", "newZipEncryptCipher", "Ljavax/crypto/Cipher;", "key32", "nonce", "newZipDecryptCipher", "qrKey", "sizeBytes", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11954a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f11955b = null;
    private static final byte[] c = null;
    private static final SecureRandom d = null;

    static {
        f11954a = new b();
        f11955b = new byte[]{77, 73, 71, 49};
        c = new byte[]{77, 73, 71, 50};
        d = new SecureRandom();
    }

    private b() {
    }

    private final byte[] b(int r3) {
        MessageDigest r2 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        byte[] r0 = "memory_migration_qr_2025".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r0, "getBytes(...)");
        byte[] r4 = r2.digest(r0);
        Intrinsics.checkNotNull(r4);
        byte[] r5 = Arrays.copyOf(r4, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "copyOf(...)");
        return r5;
    }

    public final String a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "plainJson");
        byte[] r5 = new byte[12];
        d.nextBytes(r5);
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");
        r0.init(1, (Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(f11954a.b(32), CryptoConst.ALGORITHM_AES), Key.class, "com.obric.memorydata.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(new GCMParameterSpec(128, r5), AlgorithmParameterSpec.class, "com.obric.memorydata.plugin"));
        byte[] r7 = r6.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r7, "getBytes(...)");
        byte[] r8 = r0.doFinal(r7);
        Intrinsics.checkNotNull(r8);
        String r9 = Base64.encodeToString(ArraysKt.plus(r5, r8), 2);
        Intrinsics.checkNotNullExpressionValue(r9, "encodeToString(...)");
        return r9;
    }

    public final byte[] a() {
        return f11955b;
    }

    public final byte[] a(int r1) {
        byte[] r0 = new byte[r1];
        d.nextBytes(r0);
        return r0;
    }

    public final byte[] a(byte[] r3, byte[] r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "data");
        Mac r0 = Mac.getInstance("HmacSHA256");
        r0.init((Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r3, "HmacSHA256"), Key.class, "com.obric.memorydata.plugin"));
        byte[] r2 = r0.doFinal(r4);
        Intrinsics.checkNotNullExpressionValue(r2, "doFinal(...)");
        return r2;
    }

    public final String b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "encryptedBase64");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(Base64.decode(r8, 2));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r9) == false) goto L10;
        r9 = null;
    L10:
        byte[] r10 = (byte[]) ZeusTransformUtils.preCheckCast(r9, byte[].class, "com.obric.memorydata.plugin");
        Object r5 = "";
        if (r10 != null) goto L14;
        return "";
    L14:
        if (r10.length > 12) goto L16;
        return "";
    L16:
        byte[] r6 = ArraysKt.copyOfRange(r10, 0, 12);
        byte[] r11 = ArraysKt.copyOfRange(r10, 12, r10.length);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L19
        b r12 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Throwable -> L19
        r0.init(2, (Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r12.b(32), CryptoConst.ALGORITHM_AES), Key.class, "com.obric.memorydata.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(new GCMParameterSpec(128, r6), AlgorithmParameterSpec.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        byte[] r13 = r0.doFinal(r11);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r13, "doFinal(...)");     // Catch: Throwable -> L19
        Object r14 = Result.m1421constructorimpl(new String(r13, Charsets.UTF_8));     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r14) == true) goto L26;
        r5 = r14;
    L26:
        return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean b(byte[] r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r1, "a");
        Intrinsics.checkNotNullParameter(r2, "b");
        return MessageDigest.isEqual(r1, r2);
    }

    public final byte[] b() {
        return c;
    }

    public final String c() {
        byte[] r1 = new byte[32];
        d.nextBytes(r1);
        String r2 = Base64.encodeToString(r1, 2);
        Intrinsics.checkNotNullExpressionValue(r2, "encodeToString(...)");
        return r2;
    }

    public final Cipher c(byte[] r4, byte[] r5) {
        Intrinsics.checkNotNullParameter(r4, "key32");
        Intrinsics.checkNotNullParameter(r5, "nonce");
        Cipher r3 = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] r6 = Arrays.copyOf(r4, 32);
        Intrinsics.checkNotNullExpressionValue(r6, "copyOf(...)");
        r3.init(2, (Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r6, CryptoConst.ALGORITHM_AES), Key.class, "com.obric.memorydata.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(new GCMParameterSpec(128, r5), AlgorithmParameterSpec.class, "com.obric.memorydata.plugin"));
        r3.updateAAD(f11955b);
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
