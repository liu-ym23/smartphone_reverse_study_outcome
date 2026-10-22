package com.obric.datatransfer.server;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.datatransfer.logger.TransferLogger;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class DefaultTransferVerifier implements f {
    public final Map<Integer, Long> a;
    public final Map<Integer, Long> b;
    public final AtomicBoolean c;
    public final TransferLogger d;
    public final DefaultTransferVerifier$receiver$1 e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.datatransfer.server.DefaultTransferVerifier$receiver$1] */
    public DefaultTransferVerifier() {
        this.a = Collections.synchronizedMap(new HashMap());
        this.b = Collections.synchronizedMap(new HashMap());
        this.c = new AtomicBoolean(false);
        com.obric.datatransfer.logger.a r0 = TransferLogger.b;
        this.d = TransferLogger.a.a("DefaultTransferVerifier");
        this.e = new DefaultTransferVerifier$receiver$1(this);
    }

    @Override // com.obric.datatransfer.server.f
    public final boolean a(Context r23) {
        Context r2 = r23;
        String r3 = "context";
        Intrinsics.checkNotNullParameter(r2, "context");
        Throwable r6 = null;
        if (this.c.compareAndSet(false, true) == false) goto L35;
        IntentFilter r14 = new IntentFilter();
        r14.addAction("android.intent.action.PACKAGE_ADDED");
        r14.addAction("android.intent.action.PACKAGE_REMOVED");
        r14.addAction("android.intent.action.PACKAGE_REPLACED");
        r14.addDataScheme("package");
        Context r0 = r23.getApplicationContext();
        DefaultTransferVerifier$receiver$1 r15 = this.e;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L149;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L149:
    L30:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r15, r14);
        goto L35
    L34:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L21;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r14) == false) goto L21;
        int r7 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r15, r14, 0, null, null, 2, r0).result;     // Catch: Exception -> L30
        if (r7 != 1) goto L14;
        r0.registerReceiver(r15, r14);     // Catch: Exception -> L30
    L148:
        goto L35
    L14:
        if (r7 != 2) goto L16;
        new Intent();     // Catch: Exception -> L30
        goto L148
    L16:
        if (r7 == 3) goto L148;
        r0.registerReceiver(r15, r14);     // Catch: Exception -> L30
    L21:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L24;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L30
        r0.registerReceiver(r15, r14, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L30
        goto L148
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L26;
    L28:
        r0.registerReceiver(r15, r14);     // Catch: Exception -> L30
        goto L148
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r14) == false) goto L28;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L30
        ContextCompat.registerReceiver(r0, r15, r14, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L30
    L35:
        int r8 = Binder.getCallingUid();
        long r9 = System.currentTimeMillis();
        TransferLogger.a(this.d, "verify: uid " + r8 + " is calling");
        Long r1 = this.a.get(Integer.valueOf(r8));
        if (r1 != null) goto L38;
    L42:
        Long r4 = this.b.get(Integer.valueOf(r8));
        if (r4 != null) goto L45;
    L49:
        String[] r10 = r23.getPackageManager().getPackagesForUid(r8);
        if (r10 != null) goto L52;
        return false;
    L52:
        int r11 = r10.length;
        int r12 = 0;
    L53:
        if (r12 >= r11) goto L144;
        String r13 = r10[r12];
        if (Intrinsics.areEqual(r13, r23.getPackageName()) == false) goto L57;
        TransferLogger.a(this.d, "checkPermission: " + r13 + " is same as " + r23.getPackageName());
        String r20 = r3;
        int r18 = r11;
    L136:
        boolean r16 = true;
    L140:
        if (r16 == true) goto L141;
        r12 = r12 + 1;
        r2 = r23;
        r11 = r18;
        r3 = r20;
        r6 = null;
        goto L53
    L141:
        this.a.put(Integer.valueOf(r8), Long.valueOf(r9));
        return true;
    L57:
        PackageManager r5 = r23.getPackageManager();
        int r17 = Build.VERSION.SDK_INT;     // Catch: Exception -> L72
        if (r17 < 33) goto L65;
        PackageInfo r19 = r5.getPackageInfo(r13, PackageManager.PackageInfoFlags.of(134217728));     // Catch: Exception -> L72
        if (r19.signingInfo.hasMultipleSigners() == false) goto L63;
        List r21 = ArraysKt.toList(r19.signingInfo.getApkContentsSigners());     // Catch: Exception -> L72
    L75:
        if (r21.isEmpty() == false) goto L77;
        this.d.d("signatures is null or empty for " + r13, r6);
        r20 = r3;
        r18 = r11;
    L139:
        r16 = false;
        goto L140
    L77:
        String r22 = "SHA-256";
        MessageDigest r110 = MessageDigest.getInstance("SHA-256");
        Iterator r24 = r21.iterator();
    L79:
        if (r24.hasNext() == false) goto L138;
        byte[] r25 = r110.digest(((Signature) r24.next()).toByteArray());
        StringBuilder r26 = new StringBuilder();
        Iterator r111 = r24;
        int r27 = r25.length;
        r18 = r11;
        MessageDigest r112 = r110;
        int r113 = 0;
    L81:
        if (r113 >= r27) goto L86;
        String r114 = Integer.toHexString(r25[r113] & 255);
        int r28 = r27;
        byte[] r29 = r25;
        if (r114.length() != 1) goto L85;
        r26.append('0');
    L85:
        r26.append(r114);
        r113 = r113 + 1;
        r27 = r28;
        r25 = r29;
        goto L81
    L86:
        String r30 = r26.toString();
        Integer r31 = d.a;
        Intrinsics.checkNotNullParameter(r2, r3);
        Intrinsics.checkNotNullParameter(r13, "packageName");
        Intrinsics.checkNotNullParameter(r30, "hexString");
        Integer r32 = d.a;     // Catch: Exception -> L110
        if (r32 == null) goto L90;
        r20 = r3;
        String r210 = r22;
        Integer r33 = r32;
    L114:
        if (r33 == null) goto L132;
        Map<String, Integer> r34 = d.b.get(r13);
        if (r34 == null) goto L119;
        Integer r35 = r34.get(r30);
    L120:
        if (r35 == null) goto L132;
        if (r33.intValue() != 1) goto L128;
        if (r35.intValue() != 1) goto L132;
    L133:
        boolean r36 = true;
    L134:
        if (r36 == true) goto L135;
        r2 = r23;
        r24 = r111;
        r11 = r18;
        r110 = r112;
        r3 = r20;
        r22 = r210;
        goto L79
    L135:
        TransferLogger.a(this.d, "checkPermission: " + r13 + " is valid with hash " + r30);
        goto L136
    L128:
        if (r35.intValue() == 0) goto L133;
        if (r35.intValue() != 1) goto L132;
    L119:
        r35 = null;
    L132:
        r36 = false;
        goto L134
    L90:
        List r37 = d.a(r23.getPackageManager(), r23.getPackageName());     // Catch: Exception -> L110
        if (r37.isEmpty() == false) goto L93;
        r20 = r3;
        r210 = r22;
    L113:
        r33 = null;
        goto L114
    L93:
        byte[] r38 = ((Signature) ListProtector.get(r37, 0)).toByteArray();     // Catch: Exception -> L110
        MessageDigest r39 = MessageDigest.getInstance(r22);     // Catch: Exception -> L110
        r39.update(r38);     // Catch: Exception -> L110
        byte[] r40 = r39.digest();     // Catch: Exception -> L110
        StringBuilder r41 = new StringBuilder();     // Catch: Exception -> L110
        int r115 = r40.length;     // Catch: Exception -> L110
        int r116 = 0;
    L94:
        if (r116 >= r115) goto L104;
        String r42 = Integer.toHexString(r40[r116] & 255);     // Catch: Exception -> L110
        r20 = r3;
        r210 = r22;
        if (r42.length() != 1) goto L103;
        r41.append('0');     // Catch: Exception -> L146
    L103:
        r41.append(r42);     // Catch: Exception -> L146
        r116 = r116 + 1;     // Catch: Exception -> L146
        r3 = r20;
        r22 = r210;
    L111:
        r210 = r22;
        goto L113
    L104:
        r20 = r3;
        r210 = r22;
        if (Intrinsics.areEqual(r41.toString(), "c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8") == false) goto L107;
        int r43 = 0;
    L108:
        d.a = Integer.valueOf(r43);     // Catch: Exception -> L146
        r33 = Integer.valueOf(r43);     // Catch: Exception -> L146
        goto L114
    L107:
        r43 = 1;
    L110:
        r20 = r3;
        goto L111
    L138:
        r20 = r3;
        r18 = r11;
        this.d.d("checkPermission: " + r13 + " is not valid with any hash", null);
        goto L139
    L63:
        r21 = ArraysKt.toList(r19.signingInfo.getSigningCertificateHistory());     // Catch: Exception -> L72
        goto L75
    L65:
        if (r17 < 28) goto L70;
        PackageInfo r44 = r5.getPackageInfo(r13, 134217728);     // Catch: Exception -> L72
        if (r44.signingInfo.hasMultipleSigners() == false) goto L69;
        r21 = ArraysKt.toList(r44.signingInfo.getApkContentsSigners());     // Catch: Exception -> L72
        goto L75
    L69:
        r21 = ArraysKt.toList(r44.signingInfo.getSigningCertificateHistory());     // Catch: Exception -> L72
        goto L75
    L70:
        r21 = ArraysKt.toList(r5.getPackageInfo(r13, 64).signatures);     // Catch: Exception -> L72
    L72:
        e = move-exception;
        e.printStackTrace();
        r21 = CollectionsKt.emptyList();
        goto L75
    L144:
        this.d.b("verify: refused " + ArraysKt.joinToString$default(r10, null, null, null, 0, null, null, 63, null), null);
        this.b.put(Integer.valueOf(r8), Long.valueOf(r9));
        return false;
    L45:
        if ((r9 - r4.longValue()) >= 5000) goto L48;
        TransferLogger.a(this.d, "verify: uid " + r8 + " is disallowed (cached)");
        return false;
    L48:
        Long r45 = this.b.remove(Integer.valueOf(r8));
        goto L49
    L38:
        if ((r9 - r1.longValue()) >= 5000) goto L41;
        TransferLogger.a(this.d, "verify: uid " + r8 + " is already verified (cached)");
        return true;
    L41:
        Long r46 = this.a.remove(Integer.valueOf(r8));
        goto L42
    }
}
