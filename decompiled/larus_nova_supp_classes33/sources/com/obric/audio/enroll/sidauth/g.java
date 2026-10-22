package com.obric.audio.enroll.sidauth;

import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import java.io.File;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public static final g a = null;

    public static final class a {
        public final long a;
        public final int b;
        public final long c;
        public final boolean d;
        public final int e;
        public final long f;
        public final File g;
        public final File h;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
            long r3 = this.c;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            if (this.d == false) goto L5;
            int r4 = 1231;
        L6:
            int r5 = (((r2 + r4) * 31) + this.e) * 31;
            long r6 = this.f;
            return ((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        L5:
            r4 = 1237;
            goto L6
        }

        public final String toString() {
            return "PendingItem(wkrId=" + this.a + ", audioBytes=" + this.b + ", audioDurationMs=" + this.c + ", isContinuousTalk=" + this.d + ", asrTextLen=" + this.e + ", createTsMs=" + this.f + ", pcmFile=" + this.g + ", metaFile=" + this.h + ')';
        }

        public a(long r2, int r4, long r5, boolean r7, int r8, long r9, PolarisFileWrapper r11, File r12) {
            Intrinsics.checkNotNullParameter(r11, "pcmFile");
            Intrinsics.checkNotNullParameter(r12, "metaFile");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r11;
            this.h = r12;
        }
    }

    static {
        a = new g();
    }

    public g() {
    }

    public static PolarisFileWrapper c() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(AppHost.a.getApplication().getFilesDir());     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        FLogger.a.e("SidAuthPendingStore", "get filesDir failed: " + r2.getMessage());
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        File r3 = (File) r1;
        if (r3 != null) goto L15;
        return null;
    L15:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r3, "sidauth_pending");
        if (r4.exists() == false) goto L18;
    L21:
        return r4;
    L18:
        if (r4.mkdirs() == true) goto L21;
        FLogger.a.e("SidAuthPendingStore", "mkdirs failed: " + r4.getAbsolutePath());
        return null;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static void a() {
        PolarisFileWrapper r0 = c();
        if (r0 != null) goto L38;
        return;
    L38:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(r0.listFiles());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        File[] r3 = (File[]) r2;
        if (r3 != null) goto L15;
        return;
    L15:
        int r4 = r3.length;
        int r5 = 0;
        int r6 = 0;
    L16:
        if (r5 >= r4) goto L34;
        File r7 = r3[r5];
        if (r7.isFile() == false) goto L33;
        if (StringsKt.endsWith$default(r7.getName(), ".pcm", false, 2, null) == false) goto L22;
    L36:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L25
        Object r9 = Result.constructor-impl(Boolean.valueOf(r7.delete()));     // Catch: Throwable -> L25
    L27:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L31;
        r9 = r10;
    L31:
        if (((Boolean) r9).booleanValue() == false) goto L33;
        r6 = r6 + 1;
    L25:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L22:
        if (StringsKt.endsWith$default(r7.getName(), ".json", false, 2, null) == true) goto L36;
    L33:
        r5 = r5 + 1;
        goto L16
    L34:
        FLogger.a.i("SidAuthPendingStore", "clearAll deletedFiles=" + r6);
        return;
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static void b(a r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Result.constructor-impl(Boolean.valueOf(r2.g.delete()));     // Catch: Throwable -> L4
    L13:
        Result.constructor-impl(Boolean.valueOf(r2.h.delete()));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void delete(a r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        b(r2);
    }

    public static a d(long r19, byte[] r21, long r22, boolean r24, int r25) {
        Intrinsics.checkNotNullParameter(r21, "pcm");
        if (r19 != 0) goto L5;
    L105:
        FLogger.a.i("SidAuthPendingStore", "persist skip: invalid wkrId=" + r19 + " or empty pcm");
        return null;
    L5:
        if (r21.length != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L105;
        if (r21.length <= 320000) goto L13;
        FLogger r5 = FLogger.a;
        StringBuilder r11 = new StringBuilder("persist truncate pcm wkrId=");
        r11.append(r19);
        r11.append(" originalBytes=");
        r11.append(r21.length);
        r11.append(" originalDurationMs=");
        long r12 = r22;
        r11.append(r12);
        r11.append(" -> maxBytes=320000 maxDurationMs=10000");
        r5.i("SidAuthPendingStore", r11.toString());
        byte[] r6 = ArraysKt.copyOfRange(r21, 0, 320000);
    L15:
        if (r21.length <= 320000) goto L17;
        long r10 = ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS;
    L18:
        PolarisFileWrapper r13 = c();
        if (r13 != null) goto L109;
        return null;
    L109:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        nia.a.a.i(AppHost.a.getApplication().getApplicationContext());     // Catch: Throwable -> L23
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L119:
        Object r1 = Result.constructor-impl(LocalDataCrypto.getInstance().bytesXcrypt(1, "ChaCha20", "com.larus.nova", r6));     // Catch: Throwable -> L27
    L29:
        Throwable r14 = Result.exceptionOrNull-impl(r1);
        if (r14 == null) goto L33;
        FLogger.a.e("SidAuthPendingStore", "encrypt failed wkrId=" + r19 + ": " + r14.getMessage());
    L33:
        if (Result.isFailure-impl(r1) == false) goto L35;
        r1 = null;
    L35:
        byte[] r2 = (byte[]) r1;
        if (r2 != null) goto L39;
        return null;
    L39:
        if (r2.length != 0) goto L41;
        boolean r9 = true;
    L42:
        if (r9 == false) goto L45;
        FLogger.a.e("SidAuthPendingStore", "encrypt returned empty wkrId=" + r19);
        return null;
    L45:
        long r7 = System.currentTimeMillis();
        StringBuilder r15 = new StringBuilder();
        r15.append(r7);
        r15.append('_');
        r15.append(r19);
        String r16 = r15.toString();
        PolarisFileWrapper r17 = new PolarisFileWrapper(r13, r16 + ".pcm");
        PolarisFileWrapper r18 = new PolarisFileWrapper(r13, r16 + ".json");
        FilesKt.writeBytes(r17, r2);     // Catch: Throwable -> L52
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L52
        r3.put("wkrId", r19);     // Catch: Throwable -> L52
        r3.put("audioFile", r17.getAbsolutePath());     // Catch: Throwable -> L52
        r3.put("audioBytes", r6.length);     // Catch: Throwable -> L52
        r3.put("audioDurationMs", r10);     // Catch: Throwable -> L52
        boolean r8 = r24;
        long r110 = r10;
        long r20 = r7;
        r3.put("isContinuousTalk", r8);     // Catch: Throwable -> L50
        r3.put("asrTextLen", r25);     // Catch: Throwable -> L50
        r3.put("createTsMs", r20);     // Catch: Throwable -> L50
        FilesKt.writeText$default(r18, r3.toString(), null, 2, null);     // Catch: Throwable -> L50
        Object r23 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L50
    L55:
        Throwable r111 = Result.exceptionOrNull-impl(r23);
        if (r111 == null) goto L59;
        FLogger.a.e("SidAuthPendingStore", "write pending file failed wkrId=" + r19 + ": " + r111.getMessage());
    L59:
        Boolean r26 = Boolean.FALSE;
        if (Result.isFailure-impl(r23) == false) goto L63;
        r23 = r26;
    L63:
        if (((Boolean) r23).booleanValue() == false) goto L115;
        FLogger r27 = FLogger.a;
        StringBuilder r28 = new StringBuilder("persist success wkrId=");
        r28.append(r19);
        r28.append(" audioBytes=");
        r28.append(r6.length);
        r28.append(" audioDurationMs=");
        long r112 = r110;
        r28.append(r112);
        r28.append(" isContinuousTalk=");
        r28.append(r8);
        r28.append(" asrTextLen=");
        r28.append(r25);
        r28.append(" pcm=");
        r28.append(r17.getName());
        r27.i("SidAuthPendingStore", r28.toString());
        Object r29 = Result.constructor-impl(r13.listFiles(new f()));     // Catch: Throwable -> L77
    L80:
        if (Result.isFailure-impl(r29) == false) goto L82;
        Object r30 = null;
    L83:
        File[] r31 = (File[]) r30;
        if (r31 == null) goto L104;
        if (r31.length <= 20) goto L104;
        List r32 = ArraysKt.sortedWith(r31, new h());
        int r33 = r32.size() - 20;
        int r113 = 0;
    L90:
        if (r113 >= r33) goto L104;
        File r114 = (File) ListProtector.get(r32, r113);
        List r210 = r32;
        StringBuilder r34 = new StringBuilder();
        Intrinsics.checkNotNull(r114);
        r34.append(FilesKt.getNameWithoutExtension(r114));
        r34.append(".pcm");
        PolarisFileWrapper r35 = new PolarisFileWrapper(r13, r34.toString());
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L94
        Result.constructor-impl(Boolean.valueOf(r114.delete()));     // Catch: Throwable -> L94
    L97:
        if (r35.exists() == false) goto L102;
        Result.constructor-impl(Boolean.valueOf(r35.delete()));     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L102:
        FLogger.a.w("SidAuthPendingStore", "enforceCapacity drop old pending name=" + FilesKt.getNameWithoutExtension(r114));
        r113 = r113 + 1;
        r32 = r210;
    L94:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L104:
        return new a(r19, r6.length, r112, r24, r25, r20, r17, r18);
    L82:
        r30 = r29;
    L77:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    L115:
        Result.constructor-impl(Boolean.valueOf(r17.delete()));     // Catch: Throwable -> L66
    L123:
        Result.constructor-impl(Boolean.valueOf(r18.delete()));     // Catch: Throwable -> L70
        return null;
    L70:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    L66:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L50:
        th = th;
    L54:
        Result.Companion r115 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L52:
        th = th;
        r8 = r24;
        r110 = r10;
        r20 = r7;
        goto L54
    L41:
        r9 = false;
    L27:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L119
    L17:
        r10 = r12;
        goto L18
    L13:
        r12 = r22;
        r6 = r21;
        goto L15
    L7:
        r4 = false;
        goto L8
    }
}
