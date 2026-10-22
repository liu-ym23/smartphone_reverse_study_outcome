package com.obric.aikernel;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.Process;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Set<String>> f4478b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Set<Integer> f4479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, ? extends Set<String>> f4480d;

    static {
        f4477a = new c();
        Locale r10 = Locale.ROOT;
        String r11 = "9F:98:5C:B3:30:DB:F5:63:C0:5A:40:44:68:CC:BF:D6:F7:E6:35:6D:19:8F:EF:75:03:A2:6F:32:A4:D1:0A:29".toLowerCase(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String r12 = "9F:98:5C:B3:30:DB:F5:63:C0:5A:40:44:68:CC:BF:D6:F7:E6:35:6D:19:8F:EF:75:03:A2:6F:32:A4:D1:0A:29".toLowerCase(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        Map<String, Set<String>> r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("com.obric.aikernel.sdk.ci", SetsKt.setOf(r11)), TuplesKt.to("com.obric.aikernel.memory_regresion", SetsKt.setOf(r12)), TuplesKt.to(IAIKernelManager.PACKAGE_NAME_ASSIST, SetsKt.setOf("ff:04:b4:7e:c9:dd:20:b7:9f:75:8a:f6:7a:18:49:26:db:00:ac:55:cf:d2:a0:1e:03:fb:a9:a1:dc:a9:de:2a"))});
        f4478b = r13;
        f4479c = SetsKt.emptySet();
        f4480d = r13;
    }

    private c() {
    }

    private final boolean c(Context r20, int r21) {
        String[] r10 = r20.getPackageManager().getPackagesForUid(r21);
        if (r10 == null) goto L25;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L35;
        String r13 = r10[r12];
        if (f4480d.containsKey(r13) == false) goto L24;
        PackageInfo r14 = r20.getPackageManager().getPackageInfo(r13, 134217728);
        if (r14 == null) goto L24;
        SigningInfo r15 = r14.signingInfo;
        if (r15 == null) goto L24;
        Signature[] r16 = r15.getApkContentsSigners();
        if (r16 == null) goto L24;
        Intrinsics.checkNotNullExpressionValue(r16, "apkContentsSigners");
        int r17 = r16.length;
        int r18 = 0;
    L15:
        if (r18 >= r17) goto L24;
        Signature r19 = r16[r18];
        byte[] r22 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r19.toByteArray());
        Intrinsics.checkNotNullExpressionValue(r22, "signBytes");
        ArrayList r110 = new ArrayList(r22.length);
        int r23 = r22.length;
        int r111 = 0;
    L17:
        if (r111 >= r23) goto L19;
        byte r112 = r22[r111];
        StringBuilder r113 = new StringBuilder();
        String r24 = Integer.toString((((byte) (r112 & (-16))) >>> 4) & 15, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r24, "toString(this, checkRadix(radix))");
        r113.append(r24);
        String r25 = Integer.toString((byte) (r112 & 15), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r25, "toString(this, checkRadix(radix))");
        r113.append(r25);
        r110.add(r113.toString());
        r111 = r111 + 1;
        goto L17
    L19:
        String r26 = CollectionsKt.joinToString$default(r110, ":", null, null, 0, null, null, 62, null);
        c r27 = f4477a;
        Intrinsics.checkNotNullExpressionValue(r13, "pkgName");
        if (r27.d(r13, r26) == true) goto L21;
        r18 = r18 + 1;
        goto L15
    L21:
        return true;
    L24:
        r12 = r12 + 1;
        goto L5
    L35:
        return false;
    L25:
        return false;
    }

    public final boolean a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return b(r10, Binder.getCallingPid(), Binder.getCallingUid());
    }

    public final boolean b(Context r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r12 != Process.myUid()) goto L9;
        AIKLog r13 = AIKLog.INSTANCE;
        String r14 = "AuthManager";
        StringBuilder r15 = new StringBuilder();
        String r16 = "checkAuth allow self calling from ";
    L5:
        r15.append(r16);
        r15.append(r11);
        r15.append('-');
        r15.append(r12);
    L6:
        r13.i(r14, r15.toString());
        return true;
    L9:
        if (f4479c.contains(Integer.valueOf(r12)) == false) goto L12;
        r13 = AIKLog.INSTANCE;
        r14 = "AuthManager";
        r15 = new StringBuilder();
        r16 = "checkAuth allow ";
        goto L5
    L12:
        if (c(r10, r12) == false) goto L20;
        monitor-enter(this);
        Set<Integer> r17 = SetsKt.mutableSetOf(new Integer[]{Integer.valueOf(r12)});     // Catch: Throwable -> L17
        r17.addAll(f4479c);     // Catch: Throwable -> L17
        f4479c = r17;     // Catch: Throwable -> L17
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        r13 = AIKLog.INSTANCE;
        r14 = "AuthManager";
        r15 = new StringBuilder();
        r15.append("checkAuth allow ");
        r15.append(r11);
        r15.append('-');
        r15.append(r12);
        r15.append(" by verify");
    L17:
        th = move-exception;
        throw th;
    L20:
        AIKLog.INSTANCE.i("AuthManager", "checkAuth disallow " + r11 + '-' + r12);
        return false;
    }

    public final boolean d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "pkgName");
        Intrinsics.checkNotNullParameter(r11, "signSha");
        Set<String> r12 = f4480d.get(r10);
        if (r12 != null) goto L5;
        r12 = SetsKt.emptySet();
    L5:
        String r13 = r11.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r12.contains(r13);
    }
}
