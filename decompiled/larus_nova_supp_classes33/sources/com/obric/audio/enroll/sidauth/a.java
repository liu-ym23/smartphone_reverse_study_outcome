package com.obric.audio.enroll.sidauth;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SidAuthService;
import com.mammon.audiosdk.structures.SAMICoreSidAuthCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRegisterResult;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRequest;
import com.mammon.audiosdk.structures.SAMICoreSidAuthResult;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final a a = null;
    public static final AtomicBoolean b = null;
    public static final Object c = null;

    /* JADX INFO: renamed from: com.obric.audio.enroll.sidauth.a$a, reason: collision with other inner class name */
    public static final class C0029a {
        public final int a;
        public final SAMICoreSidAuthResult b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0029a) == true) goto L8;
            return false;
        L8:
            C0029a r6 = (C0029a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            SAMICoreSidAuthResult r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "AuthCallResult(ret=" + this.a + ", result=" + this.b + ", failReason=" + this.c + ')';
        }

        public C0029a(int r3, SAMICoreSidAuthResult r4, String r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = null;
        L8:
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new AtomicBoolean(false);
        c = new Object();
    }

    public static SAMICoreSidAuthCreateParameter b() {
        SAMICoreSidAuthCreateParameter r0 = new SAMICoreSidAuthCreateParameter();
        nia.a.a.getClass();
        r0.modelPath = nia.a.l().a;
        r0.dbPath = nia.a.g;
        r0.uid = nia.a.g() + '-' + obricDeviceManagerDelegate.b.getUuid();
        r0.sidModelMd5 = nia.a.l().c;
        r0.appId = String.valueOf(AppHost.a.getAppId());
        r0.sidAuthEncKeyInfo = nia.a.e(nia.a.l().b);
        return r0;
    }

    public static void c() {
        boolean r4 = true;
        if (b.compareAndSet(false, true) == true) goto L62;
        FLogger.a.i("SidAuthBatchExecutor", "checkAndFlushIfReady skip: flush in progress");
        return;
    L62:
        g.a.getClass();     // Catch: Throwable -> L51
        PolarisFileWrapper r2 = g.c();     // Catch: Throwable -> L51
        if (r2 != null) goto L60;
    L18:
        int r3 = 0;
    L20:
        if (r3 > 0) goto L24;
        FLogger.a.i("SidAuthBatchExecutor", "checkAndFlushIfReady skip: no pending");     // Catch: Throwable -> L51
        b.set(false);
        return;
    L24:
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L51
        b.a.getClass();     // Catch: Throwable -> L51
        long r8 = b.a();     // Catch: Throwable -> L51
        long r7 = r6 - r8;     // Catch: Throwable -> L51
        if (r3 < 5) goto L27;
        boolean r10 = true;
    L29:
        if (r8 > 0) goto L31;
    L33:
        boolean r11 = false;
    L34:
        if (r8 > 0) goto L37;
        if (r3 < 1) goto L37;
    L38:
        if (r10 == true) goto L44;
        if (r11 == true) goto L44;
        if (r4 == true) goto L44;
        FLogger.a.i("SidAuthBatchExecutor", "checkAndFlushIfReady skip: not yet pending=" + r3 + " elapsedMs=" + r7 + " lastAttemptMs=" + r8);     // Catch: Throwable -> L51
        b.set(false);
        return;
    L44:
        if (r10 == false) goto L46;
        String r0 = "count";
    L49:
        h(r0);     // Catch: Throwable -> L51
    L53:
        b.set(false);
        return;
    L46:
        if (r11 == false) goto L48;
        r0 = "timeout";
        goto L49
    L48:
        r0 = "first_ever";
    L37:
        r4 = false;
        goto L38
    L31:
        if (r7 < 3600000) goto L33;
        r11 = true;
        goto L34
    L27:
        r10 = false;
        goto L29
    L60:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(r2.listFiles(new d()));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = null;
    L16:
        File[] r12 = (File[]) r5;     // Catch: Throwable -> L51
        if (r12 == null) goto L18;
        r3 = r12.length;     // Catch: Throwable -> L51
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L51
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        FLogger.a.e("SidAuthBatchExecutor", "checkAndFlushIfReady unexpected: " + th.getMessage(), th);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        b.set(false);
        throw th;
    }

    public static void h(String r29) {
        String r1 = r29;
        g.a.getClass();
        PolarisFileWrapper r2 = g.c();
        int r3 = 1;
        if (r2 != null) goto L254;
        List r0 = CollectionsKt.emptyList();
    L5:
        List r4 = r0;
        if (r4.isEmpty() == false) goto L115;
        FLogger.a.i("SidAuthBatchExecutor", "flushBatch skip: pending empty after scan reason=".concat(r1));
        b r5 = b.a;
        long r6 = System.currentTimeMillis();
        r5.getClass();
        b.b(r6);
        return;
    L115:
        long r7 = SystemClock.elapsedRealtime();
        b r8 = b.a;
        long r9 = System.currentTimeMillis();
        r8.getClass();
        b.b(r9);
        FLogger.a.i("SidAuthBatchExecutor", "flushBatch start pending=" + r4.size() + " reason=" + r1);
        Context r10 = AppHost.a.getApplication().getApplicationContext();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L118
        nia.a r12 = nia.a.a;     // Catch: Throwable -> L118
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L118
        r12.i(r10);     // Catch: Throwable -> L118
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L118
    L120:
        nia.a.a.getClass();
        if (nia.a.l().f == true) goto L125;
        FLogger.a.w("SidAuthBatchExecutor", "flushBatch skip: auth model not ready, keep pending");
        return;
    L125:
        if (nia.a.b() == true) goto L128;
        FLogger.a.w("SidAuthBatchExecutor", "flushBatch skip: qnn runtime not ready, keep pending");
        return;
    L128:
        Object r13 = c;
        monitor-enter(r13);
        SidAuthService r14 = new SidAuthService();     // Catch: Throwable -> L141
        a.getClass();     // Catch: Throwable -> L237
        int r15 = r14.createHandle(b());     // Catch: Throwable -> L237
        if (r15 == 0) goto L279;
        FLogger.a.e("SidAuthBatchExecutor", "flushBatch createHandle failed ret=" + r15);     // Catch: Throwable -> L141
        Result.constructor-impl(Integer.valueOf(r14.releaseHandle()));     // Catch: Throwable -> L136
    L138:
        a.getClass();     // Catch: Throwable -> L141
        g(r4, "createHandle ret=" + r15, r7, r1);     // Catch: Throwable -> L141
        monitor-exit(r13);
        return;
    L136:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L141
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
        goto L138
    L279:
        String r17 = nia.a.l().d;     // Catch: Throwable -> L228
        m.a.getClass();     // Catch: Throwable -> L228
        String r18 = m.b();     // Catch: Throwable -> L228
        if (r17.length() != 0) goto L146;
        boolean r19 = true;
    L147:
        if (r19 == false) goto L256;
    L154:
        boolean r110 = true;
    L155:
        if (r110 == true) goto L186;
        FLogger r20 = FLogger.a;     // Catch: Throwable -> L152
        r20.i("SidAuthBatchExecutor", "flushBatch need register: currentVersion=" + r17 + " registeredVersion=" + r18);     // Catch: Throwable -> L152
        int r21 = j(r14);     // Catch: Throwable -> L152
        if (r21 == 0) goto L179;
        r20.e("SidAuthBatchExecutor", "flushBatch register failed ret=" + r21 + ", dispatchFail all pending");     // Catch: Throwable -> L152
        int r22 = c.a;     // Catch: Throwable -> L152
        if (r21 != 220014) goto L161;
        boolean r24 = true;
    L162:
        if (r24 == false) goto L164;
        m.a();     // Catch: Throwable -> L152
        r20.i("SidAuthBatchExecutor", "flushBatch register audio unavailable, dispatch save=0 all pending ret=" + r21);     // Catch: Throwable -> L152
    L164:
        Iterator r23 = r4.iterator();     // Catch: Throwable -> L152
        int r111 = 0;
    L295:
    L177:
        Throwable th = th;
        int r25 = 0;
    L184:
        r4 = r4;
        int r112 = r111;
    L185:
        Throwable r26 = th;
    L289:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L233
        Result.constructor-impl(Integer.valueOf(r14.releaseHandle()));     // Catch: Throwable -> L233
    L235:
        long r113 = SystemClock.elapsedRealtime() - r7;     // Catch: Throwable -> L141
        FLogger.a.i("SidAuthBatchExecutor", "flushBatch done total=" + r4.size() + " success=" + r25 + " failed=" + r112 + " totalCostMs=" + r113 + " reason=" + r1);     // Catch: Throwable -> L141
        throw r26;     // Catch: Throwable -> L141
    L233:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L141
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
        goto L235
    L167:
        if (r23.hasNext() == false) goto L281;
        g.a r30 = (g.a) r23.next();     // Catch: Throwable -> L177
        a r31 = a;     // Catch: Throwable -> L177
        long r114 = r30.a;     // Catch: Throwable -> L177
        String r115 = c.a("flush register", r21);     // Catch: Throwable -> L177
        r31.getClass();     // Catch: Throwable -> L177
        e(r114, r115);     // Catch: Throwable -> L177
        g.a.delete(r30);     // Catch: Throwable -> L177
        r111 = r111 + 1;
        goto L295
    L281:
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L172
        Result.constructor-impl(Integer.valueOf(r14.releaseHandle()));     // Catch: Throwable -> L172
    L174:
        long r33 = SystemClock.elapsedRealtime() - r7;     // Catch: Throwable -> L141
        FLogger.a.i("SidAuthBatchExecutor", "flushBatch done total=" + r4.size() + " success=0 failed=" + r111 + " totalCostMs=" + r33 + " reason=" + r1);     // Catch: Throwable -> L141
        monitor-exit(r13);
        return;
    L172:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L141
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
    L152:
        th = th;
        r25 = 0;
    L183:
        r111 = 0;
        goto L184
    L161:
        r24 = false;
        goto L162
    L179:
        r25 = 0;
        m.c(r17);     // Catch: Throwable -> L182
    L276:
        Iterator r35 = r4.iterator();     // Catch: Throwable -> L226
        r112 = 0;
    L274:
        if (r35.hasNext() == false) goto L216;
        g.a r116 = (g.a) r35.next();     // Catch: Throwable -> L213
        a r36 = a;     // Catch: Throwable -> L213
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L194
        r36.getClass();     // Catch: Throwable -> L194
        Object r37 = Result.constructor-impl(Boolean.valueOf(i(r14, r116, r17)));     // Catch: Throwable -> L194
    L196:
        Throwable r118 = Result.exceptionOrNull-impl(r37);     // Catch: Throwable -> L213
        if (r118 == null) goto L203;
        FLogger r119 = FLogger.a;     // Catch: Throwable -> L213
        StringBuilder r120 = new StringBuilder();     // Catch: Throwable -> L213
        r120.append("flushBatch item unexpected wkrId=");     // Catch: Throwable -> L213
        r4 = r4;
        r120.append(r116.a);     // Catch: Throwable -> L201
        r120.append(": ");     // Catch: Throwable -> L201
        r120.append(r118.getMessage());     // Catch: Throwable -> L201
        r119.e("SidAuthBatchExecutor", r120.toString(), r118);     // Catch: Throwable -> L201
        a r38 = a;     // Catch: Throwable -> L201
        long r121 = r116.a;     // Catch: Throwable -> L201
        String r39 = "flush item unexpected " + r118.getClass().getSimpleName();     // Catch: Throwable -> L201
        r38.getClass();     // Catch: Throwable -> L201
        e(r121, r39);     // Catch: Throwable -> L201
    L204:
        Boolean r40 = Boolean.FALSE;     // Catch: Throwable -> L201
        if (Result.isFailure-impl(r37) == false) goto L208;
        r37 = r40;
    L208:
        if (((Boolean) r37).booleanValue() == false) goto L210;
        r25 = r25 + 1;     // Catch: Throwable -> L201
    L211:
        g.a.delete(r116);     // Catch: Throwable -> L201
        r1 = r29;
        r4 = r4;
        r17 = r17;
        goto L274
    L210:
        r112 = r112 + 1;     // Catch: Throwable -> L201
    L201:
        th = th;
    L215:
        r1 = r29;
        goto L185
    L203:
        r4 = r4;
        goto L204
    L194:
        th = move-exception;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L213
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L213
    L213:
        th = th;
        r4 = r4;
        goto L215
    L216:
        List r41 = r4;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L219
        Result.constructor-impl(Integer.valueOf(r14.releaseHandle()));     // Catch: Throwable -> L219
    L221:
        long r43 = SystemClock.elapsedRealtime() - r7;     // Catch: Throwable -> L141
        FLogger.a.i("SidAuthBatchExecutor", "flushBatch done total=" + r41.size() + " success=" + r25 + " failed=" + r112 + " totalCostMs=" + r43 + " reason=" + r29);     // Catch: Throwable -> L141
        Unit r44 = Unit.INSTANCE;     // Catch: Throwable -> L141
        monitor-exit(r13);
        return;
    L219:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L141
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
    L224:
        th = th;
        r4 = r4;
    L226:
        th = th;
    L230:
        r26 = th;
        r112 = 0;
    L182:
        th = th;
        goto L183
    L186:
        r25 = 0;
        goto L276
    L256:
        if (Intrinsics.areEqual(r17, r18) == true) goto L154;
        r110 = false;
        goto L155
    L146:
        r19 = false;
    L228:
        th = th;
        r25 = 0;
        goto L230
    L237:
        th = move-exception;
        FLogger.a.e("SidAuthBatchExecutor", "flushBatch createHandle exception: " + th.getMessage(), th);     // Catch: Throwable -> L141
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L241
        Result.constructor-impl(Integer.valueOf(r14.releaseHandle()));     // Catch: Throwable -> L241
    L243:
        a.getClass();     // Catch: Throwable -> L141
        g(r4, "createHandle exception", r7, r1);     // Catch: Throwable -> L141
        return;
    L241:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L141
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
    L141:
        th = move-exception;
        throw th;
    L118:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L120
    L254:
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L8
        Object r50 = Result.constructor-impl(r2.listFiles(new e()));     // Catch: Throwable -> L8
    L10:
        Charset r51 = null;
        if (Result.isFailure-impl(r50) == false) goto L13;
        r50 = null;
    L13:
        File[] r52 = (File[]) r50;
        if (r52 != null) goto L17;
        r0 = CollectionsKt.emptyList();
        goto L5
    L17:
        if (r52.length != 0) goto L19;
        boolean r53 = true;
    L20:
        if (r53 == false) goto L22;
        r0 = CollectionsKt.emptyList();
        goto L5
    L22:
        long r54 = System.currentTimeMillis();
        ArrayList r55 = new ArrayList();
        int r123 = r52.length;
        int r124 = 0;
    L23:
        if (r124 >= r123) goto L110;
        File r125 = r52[r124];
        Intrinsics.checkNotNull(r125);
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L27
        Object r57 = Result.constructor-impl(FilesKt.readText$default(r125, r51, r3, r51));     // Catch: Throwable -> L27
    L29:
        Throwable r126 = Result.exceptionOrNull-impl(r57);
        if (r126 == null) goto L33;
        FLogger.a.e("SidAuthPendingStore", "read meta failed name=" + r125.getName() + ": " + r126.getMessage());
    L33:
        if (Result.isFailure-impl(r57) == false) goto L35;
        r57 = null;
    L35:
        String r58 = (String) r57;
        if (r58 != null) goto L39;
    L43:
        r52 = r52;
        int r210 = r123;
        int r211 = r124;
        String r127 = "SidAuthPendingStore";
        File r212 = r125;
        g.a r59 = null;
    L87:
        if (r59 != null) goto L99;
        Result.constructor-impl(Boolean.valueOf(r212.delete()));     // Catch: Throwable -> L90
    L92:
        PolarisFileWrapper r60 = new PolarisFileWrapper(r2, FilesKt.getNameWithoutExtension(r212) + ".pcm");
        if (r60.exists() == false) goto L109;
        Result.constructor-impl(Boolean.valueOf(r60.delete()));     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L109:
        r124 = r211 + 1;
        r123 = r210;
        r52 = r52;
        r3 = 1;
        r51 = null;
    L90:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L92
    L99:
        if (r59.g.exists() == true) goto L106;
        FLogger.a.w(r127, "pcm missing for meta=" + r212.getName() + ", drop");
        Result.constructor-impl(Boolean.valueOf(r212.delete()));     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        Result.Companion r63 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L109
    L106:
        if ((r54 - r59.f) <= 86400000) goto L108;
        FLogger.a.w(r127, "pending expired wkrId=" + r59.a + " ageMs=" + (r54 - r59.f) + ", drop");
        g.b(r59);
        goto L109
    L108:
        r55.add(r59);
        goto L109
    L39:
        if (r58.length() != 0) goto L41;
        boolean r64 = true;
    L42:
        if (r64 == true) goto L43;
        JSONObject r65 = new JSONObject(r58);     // Catch: Throwable -> L77
        String r66 = r65.optString("audioFile");     // Catch: Throwable -> L77
        if (r66 != null) goto L47;
    L50:
        boolean r67 = true;
    L51:
        if (r67 == false) goto L54;
        r52 = r52;
        r210 = r123;
        r211 = r124;
        r127 = "SidAuthPendingStore";
        String r68 = ": ";
        r212 = r125;
    L67:
        g.a r69 = null;
    L291:
        Object r70 = Result.constructor-impl(r69);     // Catch: Throwable -> L70
    L80:
        Throwable r71 = Result.exceptionOrNull-impl(r70);
        if (r71 == null) goto L84;
        FLogger.a.e(r127, "parseMeta failed name=" + r212.getName() + r68 + r71.getMessage());
    L84:
        if (Result.isFailure-impl(r70) == false) goto L86;
        r70 = null;
    L86:
        r59 = (g.a) r70;
    L70:
        th = th;
    L79:
        Result.Companion r72 = Result.Companion;
        r70 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    L54:
        r210 = r123;
        r211 = r124;
        r52 = r52;
        r68 = ": ";
        r127 = "SidAuthPendingStore";
        r212 = r125;
        r69 = new g.a(r65.optLong("wkrId", 0), r65.optInt("audioBytes", 0), r65.optLong("audioDurationMs", 0), r65.optBoolean("isContinuousTalk", false), r65.optInt("asrTextLen", 0), r65.optLong("createTsMs", 0), new PolarisFileWrapper(r66), r212);     // Catch: Throwable -> L70
        if (r69.a != 0) goto L62;
    L64:
        boolean r128 = false;
    L65:
        if (r128 == false) goto L67;
    L62:
        if (r69.f <= 0) goto L64;
        r128 = true;
    L72:
        th = th;
        r52 = r52;
        r68 = ": ";
        r212 = r125;
        r127 = "SidAuthPendingStore";
    L74:
        th = th;
    L76:
        r127 = "SidAuthPendingStore";
        r68 = ": ";
        r212 = r125;
        goto L79
    L47:
        if (r66.length() == 0) goto L50;
        r67 = false;
    L77:
        th = th;
        r210 = r123;
        r211 = r124;
        goto L76
    L41:
        r64 = false;
    L27:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r57 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L110:
        r0 = CollectionsKt.sortedWith(r55, new i());
        goto L5
    L19:
        r53 = false;
    L8:
        th = move-exception;
        Result.Companion r73 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static int j(SidAuthService r5) {
        SAMICoreSidAuthRegisterResult r1 = new SAMICoreSidAuthRegisterResult();
        int r6 = r5.register(r1);     // Catch: Throwable -> L12
        if (r6 != 0) goto L10;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("register success sidId=");
        r3.append(r1.sidId);
        r3.append(" voiceFingerId=");
        r3.append(r1.voiceFingerId);
        r3.append(" embedJsonLen=");
        String r4 = r1.embedJson;
        if (r4 == null) goto L8;
        int r7 = r4.length();
    L9:
        r3.append(r7);
        r2.i("SidAuthBatchExecutor", r3.toString());
    L11:
        return r6;
    L8:
        r7 = 0;
        goto L9
    L10:
        FLogger.a.e("SidAuthBatchExecutor", "register failed ret=" + r6);
    L12:
        th = move-exception;
        FLogger.a.e("SidAuthBatchExecutor", "register exception: " + th.getMessage(), th);
        return Integer.MIN_VALUE;
    }

    public static ContentProviderClient d(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static void e(long r4, String r6) {
        FLogger.a.i("SidAuthBatchExecutor", "dispatchFail wkrId=" + r4 + " reason=" + r6);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        f(r4, 0);     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L13;
        FLogger.a.e("SidAuthBatchExecutor", "dispatchFail send failed wkrId=" + r4 + ": " + r9.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.StringBuilder] */
    public static void f(long r10, int r12) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Boolean.valueOf(ObricEnrollInteropDelegate.b.b()));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L10;
        FLogger r6 = FLogger.a;
        ContentProviderClient r7 = new StringBuilder("isVoiceWakeupEnabled failed: ");
        r7.append(r5.getMessage());
        r6.e("SidAuthBatchExecutor", r7.toString());
    L10:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L14;
        r4 = r8;
    L14:
        if (((Boolean) r4).booleanValue() == true) goto L17;
        FLogger.a.i("SidAuthBatchExecutor", "dispatchSaveAdaptiveEmbedding skip: wakeup disabled wkrId=" + r10 + " save=" + r12);
        return;
    L17:
        Unit r9 = null;
        ContentProviderClient r11 = d(AppHost.a.getApplication().getContentResolver(), com.obric.assistant.voice.k.a);     // Catch: Throwable -> L39 Exception -> L41
        if (r11 != null) goto L26;
        FLogger.a.e("SidAuthBatchExecutor", "dispatchSaveAdaptiveEmbedding failed: provider client null wkrId=" + r10);     // Catch: Exception -> L37 Throwable -> L56
        Result.constructor-impl(null);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L26:
        Bundle r1 = new Bundle();     // Catch: Exception -> L37 Throwable -> L56
        r1.putLong("wkrId", r10);     // Catch: Exception -> L37 Throwable -> L56
        r1.putInt("save", r12);     // Catch: Exception -> L37 Throwable -> L56
        Bundle r2 = r11.call("sid-auth-save-adaptive-embedding", null, r1);     // Catch: Exception -> L37 Throwable -> L56
        FLogger r14 = FLogger.a;     // Catch: Exception -> L37 Throwable -> L56
        StringBuilder r15 = new StringBuilder("dispatchSaveAdaptiveEmbedding wkrId=");     // Catch: Exception -> L37 Throwable -> L56
        r15.append(r10);     // Catch: Exception -> L37 Throwable -> L56
        r15.append(" save=");     // Catch: Exception -> L37 Throwable -> L56
        r15.append(r12);     // Catch: Exception -> L37 Throwable -> L56
        r15.append(" providerRet=");     // Catch: Exception -> L37 Throwable -> L56
        if (r2 == null) goto L29;
        Integer r16 = Integer.valueOf(r2.getInt("ret", Integer.MIN_VALUE));     // Catch: Exception -> L37 Throwable -> L56
    L30:
        r15.append(r16);     // Catch: Exception -> L37 Throwable -> L56
        r14.i("SidAuthBatchExecutor", r15.toString());     // Catch: Exception -> L37 Throwable -> L56
        if (Build.VERSION.SDK_INT < 24) goto L34;
        r11.close();     // Catch: Throwable -> L53
    L35:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
        return;
    L34:
        r11.release();     // Catch: Throwable -> L53
        goto L35
    L29:
        r16 = null;
    L37:
        e = e;
    L43:
        FLogger.a.e("SidAuthBatchExecutor", "dispatchSaveAdaptiveEmbedding exception wkrId=" + r10 + ": " + e.getMessage());     // Catch: Throwable -> L56
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L53
        if (r11 != null) goto L47;
    L51:
        Result.constructor-impl(r9);     // Catch: Throwable -> L53
        return;
    L47:
        if (Build.VERSION.SDK_INT < 24) goto L49;
        r11.close();     // Catch: Throwable -> L53
    L50:
        r9 = Unit.INSTANCE;     // Catch: Throwable -> L53
        goto L51
    L49:
        r11.release();     // Catch: Throwable -> L53
        goto L50
    L53:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L41:
        e = e;
        r11 = null;
    L39:
        th = th;
        r7 = 0;
    L70:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L66
        if (r7 != 0) goto L60;
    L64:
        Result.constructor-impl(r9);     // Catch: Throwable -> L66
    L68:
        throw th;
    L60:
        if (Build.VERSION.SDK_INT < 24) goto L62;
        r7.close();     // Catch: Throwable -> L66
    L63:
        r9 = Unit.INSTANCE;     // Catch: Throwable -> L66
        goto L64
    L62:
        r7.release();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L56:
        th = th;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static C0029a a(SidAuthService r5, byte[] r6, String r7) {
        SAMICoreSidAuthRequest r1 = new SAMICoreSidAuthRequest();
        r1.testAudio = r6;
        r1.threshold = 2.0d;
        SAMICoreSidAuthResult r8 = new SAMICoreSidAuthResult();
        int r9 = r5.auth(r1, r8);     // Catch: Throwable -> L9
        if (r9 == 0) goto L8;
        FLogger.a.e("SidAuthBatchExecutor", "authOnce failed attempt=" + r7 + " ret=" + r9);
        return new C0029a(r9, null, "auth ret=" + r9 + " attempt=" + r7, 2);
    L8:
        return new C0029a(r9, r8, null, 4);
    L9:
        th = move-exception;
        FLogger.a.e("SidAuthBatchExecutor", "authOnce exception attempt=" + r7 + ": " + th.getMessage(), th);
        return new C0029a(Integer.MIN_VALUE, null, "auth exception attempt=".concat(r7), 2);
    }

    public static boolean i(SidAuthService r18, g.a r19, String r20) {
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r19, "item");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(FilesKt.readBytes(r19.g));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r1);
        if (r3 == null) goto L10;
        FLogger.a.e("SidAuthPendingStore", "read pending pcm failed wkrId=" + r19.a + ": " + r3.getMessage());
    L10:
        byte[] r6 = null;
        r6 = null;
        Object r7 = null;
        if (Result.isFailure-impl(r1) == false) goto L13;
        r1 = null;
    L13:
        byte[] r2 = (byte[]) r1;
        if (r2 == null) goto L35;
        if (r2.length != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L85;
        FLogger.a.e("SidAuthPendingStore", "pending pcm empty wkrId=" + r19.a);
        goto L35
    L85:
        Object r4 = Result.constructor-impl(LocalDataCrypto.getInstance().bytesXcrypt(2, "ChaCha20", "com.larus.nova", r2));     // Catch: Throwable -> L24
    L26:
        Throwable r9 = Result.exceptionOrNull-impl(r4);
        if (r9 == null) goto L30;
        FLogger.a.e("SidAuthPendingStore", "decrypt pending pcm failed wkrId=" + r19.a + ": " + r9.getMessage());
    L30:
        if (Result.isFailure-impl(r4) == true) goto L33;
        r7 = r4;
    L33:
        r6 = (byte[]) r7;
    L24:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L19:
        r8 = false;
    L35:
        if (r6 != null) goto L37;
    L81:
        FLogger.a.e("SidAuthBatchExecutor", "flushOneItem decrypt failed wkrId=" + r19.a);
        e(r19.a, "decrypt failed");
        return false;
    L37:
        if (r6.length != 0) goto L39;
        boolean r5 = true;
    L40:
        if (r5 == true) goto L81;
        long r11 = SystemClock.elapsedRealtime();
        FLogger r12 = FLogger.a;
        r12.i("SidAuthBatchExecutor", "batchAuthOnce start wkrId=" + r19.a + " audioBytes=" + r19.b + " audioDurationMs=" + r19.c);
        C0029a r13 = a(r18, r6, "batch_first");
        int r14 = r13.a;
        if (r14 != 220012) goto L45;
    L48:
        boolean r15 = true;
    L49:
        if (r15 == false) goto L68;
        r12.i("SidAuthBatchExecutor", "batchAuthOnce ret=" + r13.a + " triggers register retry wkrId=" + r19.a);
        int r16 = j(r18);
        if (r16 == 0) goto L60;
        long r17 = r19.a;
        String r21 = c.a("batch register retry", r16);
        if (r16 != 220014) goto L55;
        boolean r22 = true;
    L56:
        if (r22 == false) goto L58;
        m.a.getClass();
        m.a();
        r12.i("SidAuthBatchExecutor", "register audio unavailable, dispatch save=0 wkrId=" + r17 + " reason=" + r21);
    L58:
        e(r17, r21);
        return false;
    L55:
        r22 = false;
        goto L56
    L60:
        r13 = a(r18, r6, "batch_retry_after_register");
        if (r13.a != 0) goto L68;
        if (r20.length() <= 0) goto L65;
        boolean r23 = true;
    L66:
        if (r23 == false) goto L68;
        m.a.getClass();
        m.c(r20);
        goto L68
    L65:
        r23 = false;
    L68:
        long r110 = SystemClock.elapsedRealtime() - r11;
        long r24 = RangesKt.coerceAtLeast(r19.c, 1);
        double r111 = r110 / r24;
        if (r13.a == 0) goto L75;
        r12.i("SidAuthBatchExecutor", "batchAuthOnce done wkrId=" + r19.a + " ret=" + r13.a + " costMs=" + r110 + " audioDurationMs=" + r24 + " rtf=" + String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(r111)}, 1)));
        long r25 = r19.a;
        String r26 = r13.c;
        if (r26 != null) goto L73;
        r26 = "batch auth ret=" + r13.a;
    L73:
        e(r25, r26);
        return false;
    L75:
        SAMICoreSidAuthResult r27 = r13.b;
        if (r27 != null) goto L79;
        r12.i("SidAuthBatchExecutor", "batchAuthOnce done wkrId=" + r19.a + " result=null costMs=" + r110 + " audioDurationMs=" + r24 + " rtf=" + String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(r111)}, 1)));
        e(r19.a, "batch auth result null");
        return false;
    L79:
        boolean r112 = r27.sv;
        r12.i("SidAuthBatchExecutor", "batchAuthOnce done wkrId=" + r19.a + " ret=OK sv=" + r27.sv + " score=" + r27.score + " costMs=" + r110 + " audioDurationMs=" + r24 + " rtf=" + String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(r111)}, 1)) + " -> save=" + (r112 ? 1 : 0));
        f(r19.a, r112 ? 1 : 0);
        return true;
    L45:
        if (r14 == 220013) goto L48;
        r15 = false;
        goto L49
    L39:
        r5 = false;
    L5:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void g(List r6, String r7, long r8, String r10) {
        Iterator r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        g.a r1 = (g.a) r0.next();
        e(r1.a, "flush clear reason=" + r7);
        g.a.delete(r1);
        goto L4
    L6:
        g.a.getClass();
        g.a();
        long r2 = SystemClock.elapsedRealtime() - r8;
        FLogger.a.w("SidAuthBatchExecutor", "flushBatch done total=" + r6.size() + " success=0 failed=" + r6.size() + " totalCostMs=" + r2 + " reason=" + r10 + " clearReason=" + r7);
    }
}
