package com.larus.common.mssdk.impl;

import android.os.SystemClock;
import com.bytedance.ttcnpa.TTCNPA;
import com.bytedance.ttcnpa.TtCnpaManager;
import com.bytedance.ttcnpa.TtCnpaResult;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ SecurityServiceImpl e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ i(String r1, String r2, String r3, Function1 r4, SecurityServiceImpl r5, String r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v26, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final Object invoke() {
        final String r14 = this.a;
        String r15 = this.b;
        TtCnpaResult r13 = this.c;
        Function1 r12 = this.d;
        SecurityServiceImpl r11 = this.e;
        TtCnpaResult r9 = this.f;
        boolean r0 = this.g;
        int r2 = SecurityServiceImpl.l;
        long r16 = SystemClock.elapsedRealtime();
        final TtCnpaResult r18 = Result.Companion;     // Catch: Throwable -> L96
        FLogger r8 = FLogger.a;     // Catch: Throwable -> L96
        r8.d("SecurityService", "checkAndFixAIGCMetaData start for message token:" + r14 + " input:" + r15 + " downloadUrl:" + r13);     // Catch: Throwable -> L96
        TtCnpaResult r1 = TTCNPA.a;     // Catch: Throwable -> L96
        r1.getClass();     // Catch: Throwable -> L96
        Intrinsics.checkNotNullParameter(r15, "filePath");     // Catch: Throwable -> L96
        TtCnpaManager r6 = null;
        TtCnpaResult r110 = TTCNPA.b(null);     // Catch: Throwable -> L96
        if (r110 != null) goto L10;
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L96
        long r23 = SystemClock.uptimeMillis();     // Catch: Throwable -> L96
        TtCnpaManager r111 = TTCNPA.e;     // Catch: Throwable -> L96
        if (r111 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTtCnpaManager");     // Catch: Throwable -> L96
    L9:
        TtCnpaResult r7 = r6.d(r15);     // Catch: Throwable -> L96
        final TtCnpaResult r25 = r7;
        TTCNPA.d("cnpa_read", null, r22, r23, r25);     // Catch: Throwable -> L96
        r110 = r7;
        goto L10
    L8:
        r6 = r111;
    L10:
        StringBuilder r10 = new StringBuilder("checkAndFixAIGCMetaData read result: errorCode=");     // Catch: Throwable -> L96
        TtCnpaResult r20 = r1;
        r10.append(r110.getErrorCode());     // Catch: Throwable -> L96
        r10.append(", errorDesc=");     // Catch: Throwable -> L96
        r10.append(r110.getErrorDesc());     // Catch: Throwable -> L96
        r8.i("SecurityService", r10.toString());     // Catch: Throwable -> L96
        boolean r21 = false;
        if (r110.getErrorCode() == 0) goto L13;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == true) goto L23;
        boolean r4 = true;
    L24:
        final String r17 = StringsKt.substringAfterLast(r15, '.', "");     // Catch: Throwable -> L96
        e10 r24 = e10.a;     // Catch: Throwable -> L96
        List r5 = e10.t().c();     // Catch: Throwable -> L96
        if (r5 == null) goto L30;
        final SecurityServiceImpl r26 = "";
        if (r5.contains(r17) != true) goto L31;
        final ?? r27 = 1;
    L32:
        if (r27 == 0) goto L128;
        r8.i("SecurityService", "checkAndFixAIGCMetaData skipped because mediaType " + r17 + " is in ignoreFileTypes.");     // Catch: Throwable -> L35
        r12.invoke(Boolean.TRUE);     // Catch: Throwable -> L35
        r20 = r9;
        ?? r28 = r12;
        r18 = r13;
        r15 = r15;
        SecurityServiceImpl r210 = r26;
        String r112 = "SecurityService";
        r26 = r11;
    L88:
        Object r30 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L90
        ?? r31 = r28;
    L99:
        Throwable r32 = Result.exceptionOrNull-impl(r30);
        if (r32 == null) goto L106;
        long r33 = SystemClock.elapsedRealtime() - r16;
        FLogger.a.e(r112, "checkAndFixAIGCMetaData failed to initiate after " + r33 + "ms scenario=" + r14, r32);
        String r34 = StringsKt.substringAfterLast(r15, '.', r210);
        Intrinsics.checkNotNull(r14);
        String r35 = r32.getMessage();
        if (r35 != null) goto L104;
        r35 = "Exception";
    L104:
        r26.getClass();
        SecurityServiceImpl.Q(r14, r34, r20, true, false, -1, -1, r35, "", r18);
        r31.invoke(Boolean.TRUE);
    L106:
        return Unit.INSTANCE;
    L90:
        th = th;
    L98:
        Result.Companion r36 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        r31 = r28;
    L35:
        th = th;
        r20 = r9;
        r28 = r12;
        r18 = r13;
        r15 = r15;
        r210 = r26;
        r112 = "SecurityService";
        r26 = r11;
        goto L98
    L128:
        if (r4 == true) goto L109;
        r20 = r9;
        r28 = r12;
        r18 = r13;
        r210 = r26;
        r26 = r11;
        r8.i("SecurityService", "checkAndFixAIGCMetaData token:" + r14 + " readCode=" + r110.getErrorCode());     // Catch: Throwable -> L92
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L92
        long r37 = r110.getErrorCode();     // Catch: Throwable -> L92
        String r38 = r110.getErrorDesc();     // Catch: Throwable -> L92
        r26.getClass();     // Catch: Throwable -> L92
        r15 = r15;
        r112 = "SecurityService";
        SecurityServiceImpl.Q(r14, r17, r20, false, true, r37, 0, r38, "", r18);     // Catch: Throwable -> L90
        r28.invoke(Boolean.TRUE);     // Catch: Throwable -> L90
        r28 = r28;
    L92:
        th = th;
        r15 = r15;
        r112 = "SecurityService";
        goto L98
    L109:
        r8.i("SecurityService", "checkAndFixAIGCMetaData no metadata found (manifest missing or invalid), writing manifest and uploading applog. token:" + r14 + " mediatype: " + r17);     // Catch: Throwable -> L81
        r27 = "auto_test";
        if (Intrinsics.areEqual(AppHost.a.getBuildChannel(), "auto_test") == true) goto L126;
        String r211 = "SecurityService";
        r25 = r9;
        r27 = r12;
        r18 = r13;
        r210 = r26;
        r26 = r11;
        if (r0 == false) goto L62;
        final TtCnpaResult r40 = r110;
        TtCnpaResult r113 = r25;
        r20.a(r15, r15, r113, new SecurityServiceImpl$b(r26, r14, r17, r25, r40, r18, r27));     // Catch: Throwable -> L58
        r27 = r27;
    L57:
        r20 = r113;
        ?? r41 = r27;
    L78:
        r15 = r15;
        r112 = r211;
        r28 = r41;
        goto L88
    L62:
        r13 = r25;
        Intrinsics.checkNotNullParameter(r15, "inputFilePath");     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter(r15, "outputFilePath");     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter("1", "labelValue");     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter(r13, "pId");     // Catch: Throwable -> L79
        TtCnpaResult r42 = TTCNPA.b(null);     // Catch: Throwable -> L79
        if (r42 != null) goto L73;
        r42 = TTCNPA.e(r15, r15, "1", r13, true, false, false, null);     // Catch: Throwable -> L58
    L73:
        if (r42.getErrorCode() != 0) goto L75;
        r21 = true;
    L75:
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L79
        long r43 = r110.getErrorCode();     // Catch: Throwable -> L79
        long r114 = r42.getErrorCode();     // Catch: Throwable -> L79
        String r44 = r110.getErrorDesc();     // Catch: Throwable -> L79
        String r115 = r42.getErrorDesc();     // Catch: Throwable -> L79
        r26.getClass();     // Catch: Throwable -> L79
        r20 = r13;
        SecurityServiceImpl.Q(r14, r17, r13, true, r21, r43, r114, r44, r115, r18);     // Catch: Throwable -> L94
        r27.invoke(Boolean.valueOf(r21));     // Catch: Throwable -> L94
        r41 = r27;
    L79:
        th = th;
    L68:
        r20 = r13;
    L69:
        r28 = r27;
    L70:
        r112 = r211;
    L58:
        th = th;
        goto L68
    L126:
        r8.i("SecurityService", "checkAndFixAIGCMetaData skipped writing manifest because channel is autotest.");     // Catch: Throwable -> L50
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L50
        long r212 = r110.getErrorCode();     // Catch: Throwable -> L50
        String r45 = r110.getErrorDesc();     // Catch: Throwable -> L50
        r11.getClass();     // Catch: Throwable -> L47
        r25 = r9;
        r211 = "SecurityService";
        r210 = r26;
        r26 = r11;
        Function1 r46 = r12;
        r18 = r13;
        SecurityServiceImpl.Q(r14, r17, r9, true, false, r212, -1, r45, "skipped_in_autotest", r13);     // Catch: Throwable -> L45
        r46.invoke(Boolean.TRUE);     // Catch: Throwable -> L60
        r113 = r25;
        r27 = r46;
    L45:
        th = th;
        Function1 r47 = r46;
    L49:
        r20 = r25;
        r28 = r47;
    L47:
        th = th;
        r211 = "SecurityService";
        r25 = r9;
        r47 = r12;
        r18 = r13;
        r210 = r26;
        r26 = r11;
    L50:
        th = th;
        r211 = "SecurityService";
        r27 = r12;
        r18 = r13;
        r210 = r26;
        r26 = r11;
        r20 = r9;
    L60:
        th = th;
        r13 = r25;
    L81:
        th = th;
        r211 = "SecurityService";
        r20 = r9;
        r27 = r12;
        r18 = r13;
        r210 = r26;
        r26 = r11;
    L94:
        th = th;
    L31:
        r27 = 0;
        goto L32
    L30:
        r26 = "";
        goto L31
    L23:
        r4 = false;
        goto L24
    L13:
        if (r110.getResultManifest() == null) goto L20;
        if (r110.getResultManifest().getProduceId().length() <= 0) goto L17;
        boolean r48 = true;
    L18:
        if (r48 == false) goto L20;
        r3 = true;
        goto L21
    L17:
        r48 = false;
    L96:
        th = th;
        r20 = r9;
        r210 = "";
        r26 = r11;
        r28 = r12;
        r18 = r13;
        r15 = r15;
        r112 = "SecurityService";
        goto L98
    }
}
