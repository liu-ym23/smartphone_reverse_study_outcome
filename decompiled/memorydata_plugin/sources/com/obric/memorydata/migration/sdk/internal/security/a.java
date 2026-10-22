package com.obric.memorydata.migration.sdk.internal.security;

import android.util.Base64;
import com.bytedance.crypto.pake.JpakeSession;
import com.bytedance.crypto.pake.JpakeWireCodec;
import com.bytedance.crypto.pake.PakeRole;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ6\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/security/JpakeKeyAgreement;", "", "<init>", "()V", "derivePassword", "", "pairingCode", "senderUidHash", "receiverNonce32", "", "senderNonce32", "negotiateAsAlice", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "password", "sendFrame", "Lkotlin/Function1;", "", "recvFrame", "Lkotlin/Function0;", "negotiateAsBob", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11953a = null;

    static {
        f11953a = new a();
    }

    private a() {
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence b(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$8TL6cjTl3kya2YdQJaDsAnsXJyU(byte r0) {
        return b(r0);
    }

    public static /* synthetic */ CharSequence lambda$vLQKX_dlqkEXvapkSEMJp7OCbQ4(byte r0) {
        return a(r0);
    }

    public final z<byte[]> a(String r12, Function1<? super String, Unit> r13, Function0<String> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Function0 r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "password");
        Intrinsics.checkNotNullParameter(r15, "sendFrame");
        Intrinsics.checkNotNullParameter(r16, "recvFrame");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        t.f11981a.a("jpake: alice begin");     // Catch: Throwable -> L16
        JpakeSession r17 = JpakeSession.newSession(PakeRole.ALICE, r12, 32);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r17, "newSession(...)");     // Catch: Throwable -> L16
        JpakeSession.Round1Msg r18 = r17.generateRound1Payload();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r18, "generateRound1Payload(...)");     // Catch: Throwable -> L16
        String r19 = JpakeWireCodec.encodeRound1(r18);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r19, "encodeRound1(...)");     // Catch: Throwable -> L16
        r15.invoke(r19);     // Catch: Throwable -> L16
        r17.receiveRound1Payload(JpakeWireCodec.decodeRound1((String) ZeusTransformUtils.preCheckCast(r16.invoke(), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L16
        t.f11981a.a("jpake: alice round1 exchanged");     // Catch: Throwable -> L16
        JpakeSession.Round2Msg r110 = r17.generateRound2Payload();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r110, "generateRound2Payload(...)");     // Catch: Throwable -> L16
        String r111 = JpakeWireCodec.encodeRound2(r110);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r111, "encodeRound2(...)");     // Catch: Throwable -> L16
        r15.invoke(r111);     // Catch: Throwable -> L16
        r17.receiveRound2Payload(JpakeWireCodec.decodeRound2((String) ZeusTransformUtils.preCheckCast(r16.invoke(), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L16
        t.f11981a.a("jpake: alice round2 exchanged");     // Catch: Throwable -> L16
        r17.deriveSharedKey();     // Catch: Throwable -> L16
        if (r17.verifyKeyConfirmMsg(JpakeWireCodec.decodeKeyConfirm((String) ZeusTransformUtils.preCheckCast(r16.invoke(), String.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        t.a(t.f11981a, "jpake: alice key confirmation failed", null, 2, null);     // Catch: Throwable -> L16
        Object r112 = ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "J-PAKE 密钥确认失败", null, 4, null)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L13:
        Object r113 = Result.m1421constructorimpl((z) r112);     // Catch: Throwable -> L16
    L18:
        Throwable r114 = Result.m1424exceptionOrNullimpl(r113);
        if (r114 == null) goto L23;
        t.f11981a.a("jpake: alice failed", r114);
        r113 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "J-PAKE 协商失败: " + r114.getMessage(), r114)), z.class, "com.obric.memorydata.plugin");
    L23:
        return (z) ZeusTransformUtils.preCheckCast(r113, z.class, "com.obric.memorydata.plugin");
    L7:
        JpakeSession.KeyConfirmMsg r115 = r17.generateKeyConfirmMsg();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r115, "generateKeyConfirmMsg(...)");     // Catch: Throwable -> L16
        String r116 = JpakeWireCodec.encodeKeyConfirm(r115);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r116, "encodeKeyConfirm(...)");     // Catch: Throwable -> L16
        r15.invoke(r116);     // Catch: Throwable -> L16
        byte[] r117 = r17.getDataKey();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r117, "getDataKey(...)");     // Catch: Throwable -> L16
        if (r117.length != 32) goto L10;
        boolean r118 = true;
    L11:
        if (r118 == false) goto L15;
        byte[] r119 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r117);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r119, "digest(...)");     // Catch: Throwable -> L16
        byte[] r2 = Arrays.copyOf(r119, 4);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r2, "copyOf(...)");     // Catch: Throwable -> L16
        t.f11981a.a("jpake: alice confirmed, dataKey sha256[0..4)=" + ArraysKt.joinToString$default(r2, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$vLQKX_dlqkEXvapkSEMJp7OCbQ4.INSTANCE, 30, null));     // Catch: Throwable -> L16
        r112 = ZeusTransformUtils.preCheckCast(new z.b(r117), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        goto L13
    L15:
        throw new IllegalStateException(("invalid dataKey size=" + r117.length).toString());     // Catch: Throwable -> L16
    L10:
        r118 = false;
    L16:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r113 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final String a(String r3, String r4, byte[] r5, byte[] r6) {
        Intrinsics.checkNotNullParameter(r3, "pairingCode");
        Intrinsics.checkNotNullParameter(r4, "senderUidHash");
        Intrinsics.checkNotNullParameter(r5, "receiverNonce32");
        Intrinsics.checkNotNullParameter(r6, "senderNonce32");
        byte[] r2 = "memory_migration_jpake_v1".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r2, "getBytes(...)");
        byte[] r7 = r3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r7, "getBytes(...)");
        byte[] r8 = ArraysKt.plus(r2, r7);
        byte[] r9 = r4.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r9, "getBytes(...)");
        byte[] r10 = ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(r8, r9), r5), r6);
        String r11 = Base64.encodeToString(MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r10), 2);
        Intrinsics.checkNotNullExpressionValue(r11, "encodeToString(...)");
        return r11;
    }

    public final z<byte[]> b(String r12, Function1<? super String, Unit> r13, Function0<String> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Function0 r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "password");
        Intrinsics.checkNotNullParameter(r15, "sendFrame");
        Intrinsics.checkNotNullParameter(r16, "recvFrame");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        t.f11981a.a("jpake: bob begin");     // Catch: Throwable -> L16
        JpakeSession r17 = JpakeSession.newSession(PakeRole.BOB, r12, 32);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r17, "newSession(...)");     // Catch: Throwable -> L16
        JpakeSession.Round1Msg r18 = JpakeWireCodec.decodeRound1((String) ZeusTransformUtils.preCheckCast(r16.invoke(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        JpakeSession.Round1Msg r2 = r17.generateRound1Payload();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r2, "generateRound1Payload(...)");     // Catch: Throwable -> L16
        r17.receiveRound1Payload(r18);     // Catch: Throwable -> L16
        String r19 = JpakeWireCodec.encodeRound1(r2);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r19, "encodeRound1(...)");     // Catch: Throwable -> L16
        r15.invoke(r19);     // Catch: Throwable -> L16
        t.f11981a.a("jpake: bob round1 exchanged");     // Catch: Throwable -> L16
        JpakeSession.Round2Msg r110 = JpakeWireCodec.decodeRound2((String) ZeusTransformUtils.preCheckCast(r16.invoke(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        JpakeSession.Round2Msg r3 = r17.generateRound2Payload();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r3, "generateRound2Payload(...)");     // Catch: Throwable -> L16
        r17.receiveRound2Payload(r110);     // Catch: Throwable -> L16
        String r111 = JpakeWireCodec.encodeRound2(r3);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r111, "encodeRound2(...)");     // Catch: Throwable -> L16
        r15.invoke(r111);     // Catch: Throwable -> L16
        t.f11981a.a("jpake: bob round2 exchanged");     // Catch: Throwable -> L16
        r17.deriveSharedKey();     // Catch: Throwable -> L16
        JpakeSession.KeyConfirmMsg r112 = r17.generateKeyConfirmMsg();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r112, "generateKeyConfirmMsg(...)");     // Catch: Throwable -> L16
        String r113 = JpakeWireCodec.encodeKeyConfirm(r112);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r113, "encodeKeyConfirm(...)");     // Catch: Throwable -> L16
        r15.invoke(r113);     // Catch: Throwable -> L16
        if (r17.verifyKeyConfirmMsg(JpakeWireCodec.decodeKeyConfirm((String) ZeusTransformUtils.preCheckCast(r16.invoke(), String.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        t.a(t.f11981a, "jpake: bob key confirmation failed", null, 2, null);     // Catch: Throwable -> L16
        Object r114 = ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "J-PAKE 密钥确认失败", null, 4, null)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L13:
        Object r115 = Result.m1421constructorimpl((z) r114);     // Catch: Throwable -> L16
    L18:
        Throwable r116 = Result.m1424exceptionOrNullimpl(r115);
        if (r116 == null) goto L23;
        t.f11981a.a("jpake: bob failed", r116);
        r115 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "J-PAKE 协商失败: " + r116.getMessage(), r116)), z.class, "com.obric.memorydata.plugin");
    L23:
        return (z) ZeusTransformUtils.preCheckCast(r115, z.class, "com.obric.memorydata.plugin");
    L7:
        byte[] r117 = r17.getDataKey();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r117, "getDataKey(...)");     // Catch: Throwable -> L16
        if (r117.length != 32) goto L10;
        boolean r118 = true;
    L11:
        if (r118 == false) goto L15;
        byte[] r119 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r117);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r119, "digest(...)");     // Catch: Throwable -> L16
        byte[] r4 = Arrays.copyOf(r119, 4);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(...)");     // Catch: Throwable -> L16
        t.f11981a.a("jpake: bob confirmed, dataKey sha256[0..4)=" + ArraysKt.joinToString$default(r4, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$8TL6cjTl3kya2YdQJaDsAnsXJyU.INSTANCE, 30, null));     // Catch: Throwable -> L16
        r114 = ZeusTransformUtils.preCheckCast(new z.b(r117), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        goto L13
    L15:
        throw new IllegalStateException(("invalid dataKey size=" + r117.length).toString());     // Catch: Throwable -> L16
    L10:
        r118 = false;
    L16:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r115 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
