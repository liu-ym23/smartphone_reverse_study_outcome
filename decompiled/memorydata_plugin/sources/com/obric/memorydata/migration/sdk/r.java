package com.obric.memorydata.migration.sdk;

import android.content.Context;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\n¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationKit;", "", "<init>", "()V", "parseQrPayloadOrNull", "Lcom/obric/memorydata/migration/sdk/QrPayload;", "qrText", "", "formatBytesForUi", "bytes", "", "formatProgressBytesForUi", "Lkotlin/Pair;", "currentBytes", "totalBytes", "formatMb1dpForUi", "mb", "", "formatMbForUi", "formatGbForUi", "gb", "defaultPublicResourceRestoreDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "verifyPrecondition", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "receiverUid", "receiverAppVersionCode", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f11979a = null;

    static {
        f11979a = new r();
    }

    private r() {
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String a(long r3, double r5) {
        double r2 = Math.floor((RangesKt.coerceAtLeast(r3, 0) / r5) * 10.0d) / 10.0d;
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        String r6 = String.format(Locale.ROOT, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r2)}, 1));
        Intrinsics.checkNotNullExpressionValue(r6, "format(...)");
        return r6 + "MB";
    }

    private static final int b(long r0) {
        return String.valueOf(r0).length();
    }

    private final String b(long r3, double r5) {
        if (r3 > 0) goto L7;
        return "0MB";
    L7:
        return new StringBuilder().append((long) (r3 / r5)).append("MB").toString();
    }

    private static final long c(long r2) {
        return r2 / ((long) 10);
    }

    private final String c(long r3, double r5) {
        if (r3 > 0) goto L6;
        return "0GB";
    L6:
        String r2 = String.format(Locale.ROOT, "%.1f", new Object[]{Double.valueOf(r3 / r5)});
        Intrinsics.checkNotNull(r2);
        if (StringsKt.endsWith$default(r2, ".0", false, 2, null) == false) goto L10;
        r2 = StringsKt.dropLast(r2, 2);
    L10:
        return r2 + "GB";
    }

    public static /* synthetic */ CharSequence lambda$B_W109JfSx28v_Yk0w1H3tO8JJg(byte r0) {
        return a(r0);
    }

    public final QrPayload a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "qrText");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r r2 = (r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(y.f11988a.a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r4) == false) goto L11;
        r4 = null;
    L11:
        return (QrPayload) ZeusTransformUtils.preCheckCast(r4, QrPayload.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final z<QrPayload> a(String r25, String r26, long r27) {
        Intrinsics.checkNotNullParameter(r25, "qrText");
        Intrinsics.checkNotNullParameter(r26, "receiverUid");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        r r8 = (r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r0 = Result.m1421constructorimpl(y.f11988a.a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin")).toString()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r0) == false) goto L10;
        r0 = null;
    L10:
        QrPayload r9 = (QrPayload) ZeusTransformUtils.preCheckCast(r0, QrPayload.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L15;
        r r1 = (r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.memorydata.plugin");
        t.a(t.f11981a, "precondition: qr decode failed", null, 2, null);
        Object r2 = new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "二维码无效", null, 4, null));
    L14:
        return (z) ZeusTransformUtils.preCheckCast(r2, z.class, "com.obric.memorydata.plugin");
    L15:
        t r3 = t.f11981a;
        StringBuilder r10 = new StringBuilder().append("precondition: qr decoded, protocol=");
        String r11 = r9.getProtocolVersion();
        String r12 = "";
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        StringBuilder r13 = r10.append(r11).append(", senderAppVersionCode=").append(r9.getSenderAppVersionCode()).append(", receiverAppVersionCode=").append(r27).append(", endpointCount=");
        List<String> r14 = r9.getEndpoints();
        if (r14 != null) goto L21;
        r14 = CollectionsKt.emptyList();
    L21:
        r3.a(r13.append(r14.size()).toString());
        String r4 = r9.getSenderUidHash();
        if (r4 == null) goto L24;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L25:
        if (r5 != null) goto L27;
        String r15 = "";
    L28:
        String r6 = r9.getSenderUidSaltBase64();
        if (r6 == null) goto L31;
        String r16 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L32:
        if (r16 != null) goto L35;
        r16 = "";
    L35:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L37;
    L108:
        t.a(t.f11981a, "precondition: uid proof missing, hashPresent=" + (!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"))) + ", saltPresent=" + (!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"))), null, 2, null);
        r2 = new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "二维码无效", null, 4, null));
        goto L14
    L37:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L108;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L41
        r r18 = (r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        Object r19 = Result.m1421constructorimpl(Base64.decode(r16, 2));     // Catch: Throwable -> L41
    L44:
        if (Result.m1427isFailureimpl(r19) == false) goto L46;
        r19 = null;
    L46:
        byte[] r20 = (byte[]) ZeusTransformUtils.preCheckCast(r19, byte[].class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L50;
        r r21 = (r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.memorydata.plugin");
        t.a(t.f11981a, "precondition: uid salt decode failed", null, 2, null);
        r2 = new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "二维码无效", null, 4, null));
        goto L14
    L50:
        if (r20.length == 16) goto L52;
        t.a(t.f11981a, "precondition: invalid uid salt size=" + r20.length, null, 2, null);
        r2 = new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "二维码无效", null, 4, null));
        goto L14
    L52:
        MessageDigest r22 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        byte[] r23 = r26.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r23, "getBytes(...)");
        byte[] r110 = r22.digest(ArraysKt.plus(r20, r23));
        Intrinsics.checkNotNullExpressionValue(r110, "digest(...)");
        if (StringsKt.equals(r15, ArraysKt.joinToString$default(r110, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$r$B_W109JfSx28v_Yk0w1H3tO8JJg.INSTANCE, 30, null), true) == true) goto L55;
        t.a(t.f11981a, "precondition: uid mismatch", null, 2, null);
        r2 = new z.a(new o(MigrationErrorCode.UID_MISMATCH, "账号不一致", null, 4, null));
        goto L14
    L55:
        int r24 = b(r9.getSenderAppVersionCode());
        int r28 = b(r27);
        long r111 = r9.getSenderAppVersionCode();
        if (r24 <= r28) goto L58;
        r111 = r111 / ((long) 10);
    L58:
        if (r28 <= r24) goto L60;
        long r29 = r27 / ((long) 10);
    L61:
        long r30 = c(r111);
        long r31 = c(r29);
        t.f11981a.a("verifyPrecondition: receiver=" + r27 + " sender=" + r9.getSenderAppVersionCode() + " compare=" + r31 + '/' + r30);
        if (r31 >= r30) goto L65;
        t.a(t.f11981a, "precondition: receiver version too low, receiverCompare=" + r31 + ", senderCompare=" + r30, null, 2, null);
        r2 = new z.a(new o(MigrationErrorCode.VERSION_TOO_LOW, "新设备版本过低，请升级后重试", null, 4, null));
        goto L14
    L65:
        if (MigrationSecurityProtocol.Companion.a(r9.getProtocolVersion()) != null) goto L71;
        t r32 = t.f11981a;
        StringBuilder r33 = new StringBuilder().append("precondition: unsupported protocol=");
        String r34 = r9.getProtocolVersion();
        if (r34 == null) goto L70;
        r12 = r34;
    L70:
        t.a(r32, r33.append(r12).toString(), null, 2, null);
        r2 = new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "迁移协议版本不兼容，请升级两台设备后重试", null, 4, null));
        goto L14
    L71:
        boolean r35 = false;
        if (r9.getServerPort() <= 0) goto L95;
        Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(r9.getEndpoints(), Collection.class, "com.obric.memorydata.plugin");
        if (r36 != null) goto L76;
    L79:
        boolean r37 = true;
    L80:
        if (r37 == true) goto L95;
        CharSequence r38 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.getPairingCode(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r38 != null) goto L84;
    L87:
        boolean r39 = true;
    L88:
        if (r39 == true) goto L95;
        t r40 = t.f11981a;
        StringBuilder r41 = new StringBuilder().append("precondition: success, protocol=");
        String r42 = r9.getProtocolVersion();
        if (r42 == null) goto L94;
        r12 = r42;
    L94:
        r40.a(r41.append(r12).toString());
        r2 = new z.b(r9);
        goto L14
    L84:
        if (StringsKt.isBlank(r38) == true) goto L87;
        r39 = false;
        goto L88
    L76:
        if (r36.isEmpty() == true) goto L79;
        r37 = false;
    L95:
        t r43 = t.f11981a;
        StringBuilder r44 = new StringBuilder().append("precondition: invalid network request, portValid=");
        if (r9.getServerPort() <= 0) goto L98;
        boolean r45 = true;
    L99:
        StringBuilder r46 = r44.append(r45).append(", endpointCount=");
        List<String> r47 = r9.getEndpoints();
        if (r47 != null) goto L102;
        r47 = CollectionsKt.emptyList();
    L102:
        StringBuilder r48 = r46.append(r47.size()).append(", pairingCodePresent=");
        CharSequence r49 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.getPairingCode(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r49 != null) goto L105;
    L106:
        r35 = true;
    L107:
        t.a(r43, r48.append(!r35).toString(), null, 2, null);
        r2 = new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "旧机未获取到可用局域网地址，请确保两台设备在同一 Wi-Fi/热点", null, 4, null));
        goto L14
    L105:
        if (StringsKt.isBlank(r49) == false) goto L107;
    L98:
        r45 = false;
        goto L99
    L60:
        r29 = r27;
    L41:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L44
    L31:
        r16 = null;
        goto L32
    L27:
        r15 = r5;
        goto L28
    L24:
        r5 = null;
    L5:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final File a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        File r3 = new File(r1.getFilesDir(), "migration_public_media");
        r3.mkdirs();
        return r3;
    }

    public final String a(long r5) {
        if (r5 >= 1.073741824E9d) goto L6;
        return b(r5, 1048576.0d);
    L6:
        return c(r5, 1.073741824E9d);
    }

    public final Pair<String, String> a(long r9, long r11) {
        long r12 = RangesKt.coerceAtLeast(r11, 0);
        if (r12 <= 0) goto L5;
        long r10 = RangesKt.coerceIn(r9, 0, r12);
    L7:
        if (r12 < 1.073741824E9d) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        String r13 = c(r10, 1.073741824E9d);
        String r8 = c(r12, 1.073741824E9d);
    L14:
        return TuplesKt.to(r13, r8);
    L12:
        r13 = a(r10, 1048576.0d);
        r8 = b(r12, 1048576.0d);
        goto L14
    L9:
        r0 = false;
        goto L10
    L5:
        r10 = RangesKt.coerceAtLeast(r9, 0);
        goto L7
    }
}
