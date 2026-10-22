package com.larus.uaigc.helper;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class EnterpriseFileDownloadHelper {
    public static final EnterpriseFileDownloadHelper a = null;

    static {
        a = new EnterpriseFileDownloadHelper();
    }

    public EnterpriseFileDownloadHelper() {
    }

    public static String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r3), "mime_type"));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        String r2 = (String) r1;
        if (r2 == null) goto L14;
        return r2;
    L14:
        return StringsKt.substringAfterLast(StringsKt.substringBefore$default(StringsKt.substringBefore$default(r3, '#', null, 2, null), '?', null, 2, null), '.', "").toLowerCase(Locale.ROOT);
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final Object c(e0 r17, Continuation<? super String> r18) {
        e0 r1 = r17;
        if ((r18 instanceof EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1) == false) goto L7;
        EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1 r3 = (EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1) r18;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        String r15 = null;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L55:
        return r2;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (e0) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L19:
        dm9.a.b r6 = (dm9.a) r2;
        boolean r7 = r6 instanceof dm9.a.b;
        if (r7 == false) goto L62;
        dm9.a.b r8 = r6;
        if (r8.a.isSuccess() == false) goto L62;
        q0 r9 = (q0) r8.a.getData();
        if (r9 == null) goto L29;
        String r10 = r9.b();
        if (r10 == null) goto L29;
        String r12 = r10.toLowerCase(Locale.ROOT);
    L30:
        boolean r11 = false;
        if (Intrinsics.areEqual(r12, "ready") == false) goto L44;
        String r14 = r9.a();
        if (r14 != null) goto L35;
    L36:
        r11 = true;
    L37:
        if (r11 == false) goto L40;
        r14 = r15;
    L40:
        if (r14 == null) goto L80;
        DownloadWatermarkService.a.getClass();
        DownloadWatermarkService.f(r14);
        return r14;
    L80:
        return r1.a;
    L35:
        if (r14.length() != 0) goto L37;
    L44:
        if (Intrinsics.areEqual(r12, "processing") == false) goto L56;
        String r16 = r9.c();
        if (r16 != null) goto L48;
    L49:
        r11 = true;
    L50:
        if (r11 == false) goto L52;
        FLogger.a.e("EnterpriseFileDownloadHelper", "watermarkDownload missing taskId, context=" + r1);
        return r1.a;
    L52:
        r3.L$0 = r15;
        r3.label = 2;
        r2 = b(r16, r1, r3);
        if (r2 != r13) goto L55;
        return r13;
    L48:
        if (r16.length() != 0) goto L50;
    L56:
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("watermarkDownload unexpected status=");
        if (r9 == null) goto L59;
        String r110 = r9.b();
    L60:
        r20.append(r110);
        r20.append(", context=");
        r20.append(r1);
        r19.e("EnterpriseFileDownloadHelper", r20.toString());
        return r1.a;
    L59:
        r110 = r15;
    L29:
        r12 = r15;
    L62:
        if (r7 == false) goto L64;
        dm9.a.b r111 = r6;
    L65:
        if (r111 == null) goto L69;
        BizResponse r21 = r111.a;
        if (r21 == null) goto L69;
        Object r112 = Boxing.boxLong(r21.getCode());
    L70:
        if (r7 == false) goto L72;
        dm9.a.b r22 = r6;
    L73:
        if (r22 == null) goto L77;
        BizResponse r23 = r22.a;
        if (r23 == null) goto L77;
        r15 = r23.getMsg();
    L77:
        FLogger.a.e("EnterpriseFileDownloadHelper", "watermarkDownload failed, code=" + r112 + ", msg=" + r15 + ", context=" + r1);
        return r1.a;
    L72:
        r22 = r15;
    L69:
        r112 = r15;
        goto L70
    L64:
        r111 = r15;
        goto L65
    L16:
        ResultKt.throwOnFailure(r2);
        EnterpriseFileWatermarkApi.a r24 = EnterpriseFileWatermarkApi.a;
        EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$result$1 r25 = new EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$result$1(r1, r15);
        r3.L$0 = r1;
        r3.label = 1;
        r24.getClass();
        FlowHttpConnection r26 = FlowHttpConnection.a;
        r2 = FlowHttpConnection.g("Social", EnterpriseFileWatermarkApi.class, r25, true, "/alice/resource/watermark_download", null, null, r3, 224);
        if (r2 != r13) goto L19;
        return r13;
    L7:
        r3 = new EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1(this, r18);
        goto L8
    }

    public final Object d(e0 r3, Continuation<? super String> r4) {
        if (com.larus.platform.service.n0.a.b() == true) goto L11;
        if (z2.a.enableCreationFileWatermark() == true) goto L7;
        FLogger.a.i("EnterpriseFileDownloadHelper", "file watermark disable, skip redundant resolve");
        return r3.a;
    L7:
        return c(r3, r4);
    L11:
        return c(r3, r4);
    }

    public final Object b(String r26, e0 r27, Continuation<? super String> r28) {
        if ((r28 instanceof EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1) == false) goto L7;
        EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1 r1 = (EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1) r28;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        int r7 = 1;
        Continuation r8 = null;
        String r9 = "EnterpriseFileDownloadHelper";
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        int r5 = r1.I$1;
        long r10 = r1.J$0;
        int r12 = r1.I$0;
        e0 r13 = (e0) r1.L$1;
        String r14 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Object r6 = r3;
        String r11 = r14;
        EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1 r15 = r1;
        int r16 = r12;
        e0 r17 = r13;
        String r18 = "EnterpriseFileDownloadHelper";
        long r19 = r10;
        int r110 = r5;
    L64:
        int r111 = r110 + 1;
        Object r20 = r6;
        r7 = 1;
        r8 = null;
    L17:
        if (r111 >= r16) goto L83;
        EnterpriseFileWatermarkApi.a r21 = EnterpriseFileWatermarkApi.a;
        EnterpriseFileDownloadHelper$pollFinalDownloadUrl$2$result$1 r112 = new EnterpriseFileDownloadHelper$pollFinalDownloadUrl$2$result$1(r11, r8);
        r15.L$0 = r11;
        r15.L$1 = r17;
        r15.I$0 = r16;
        r15.J$0 = r19;
        r15.I$1 = r111;
        r15.I$2 = r111;
        r15.label = r7;
        r21.getClass();
        FlowHttpConnection r22 = FlowHttpConnection.a;
        long r23 = r19;
        String r24 = r18;
        int r25 = r16;
        int r113 = r111;
        Object r29 = FlowHttpConnection.g("Social", EnterpriseFileWatermarkApi.class, r112, true, "/alice/resource/watermark_task", null, null, r15, 224);
        if (r29 != r20) goto L21;
        return r20;
    L21:
        String r114 = r11;
        e0 r115 = r17;
        r1 = r15;
        r3 = r20;
        int r116 = r25;
        r0 = r29;
        int r30 = r113;
        r110 = r30;
        r19 = r23;
        r9 = r24;
    L22:
        dm9.a.b r31 = (dm9.a) r0;
        boolean r32 = r31 instanceof dm9.a.b;
        if (r32 == false) goto L65;
        dm9.a.b r33 = r31;
        if (r33.a.isSuccess() == false) goto L65;
        r0 r34 = (r0) r33.a.getData();
        if (r34 == null) goto L32;
        String r35 = r34.b();
        if (r35 == null) goto L32;
        String r36 = r35.toLowerCase(Locale.ROOT);
    L34:
        if (Intrinsics.areEqual(r36, "ready") == false) goto L50;
        String r37 = r34.a();
        if (r37 != null) goto L38;
    L41:
        boolean r38 = true;
    L42:
        if (r38 == true) goto L44;
        String r39 = r37;
    L45:
        if (r39 == null) goto L48;
        DownloadWatermarkService.a.getClass();
        DownloadWatermarkService.f(r39);
        return r39;
    L48:
        return r115.a;
    L44:
        r39 = null;
        goto L45
    L38:
        if (r37.length() == 0) goto L41;
        r38 = false;
        goto L42
    L50:
        if (Intrinsics.areEqual(r36, "processing") == true) goto L58;
        FLogger r40 = FLogger.a;
        StringBuilder r41 = new StringBuilder("watermarkTask unexpected status=");
        if (r34 == null) goto L54;
        String r42 = r34.b();
    L55:
        r41.append(r42);
        r41.append(", taskId=");
        r41.append(r114);
        r40.e(r9, r41.toString());
        return r115.a;
    L54:
        r42 = null;
        goto L55
    L58:
        if (r30 >= (r116 - 1)) goto L85;
        r1.L$0 = r114;
        r1.L$1 = r115;
        r1.I$0 = r116;
        r1.J$0 = r19;
        r1.I$1 = r110;
        r1.label = 2;
        if (DelayKt.delay(r19, r1) != r3) goto L63;
        return r3;
    L63:
        r6 = r3;
        r11 = r114;
        r15 = r1;
        r17 = r115;
        r16 = r116;
        r18 = r9;
        goto L64
    L85:
        r6 = r3;
        r11 = r114;
        r15 = r1;
        r17 = r115;
        r16 = r116;
        r18 = r9;
    L32:
        r36 = null;
    L65:
        if (r32 == false) goto L67;
        dm9.a.b r43 = r31;
    L68:
        if (r43 == null) goto L72;
        BizResponse r44 = r43.a;
        if (r44 == null) goto L72;
        Long r45 = Boxing.boxLong(r44.getCode());
    L73:
        if (r32 == false) goto L75;
        dm9.a.b r46 = r31;
    L76:
        if (r46 == null) goto L80;
        BizResponse r47 = r46.a;
        if (r47 == null) goto L80;
        String r48 = r47.getMsg();
    L81:
        FLogger.a.e(r9, "watermarkTask failed, code=" + r45 + ", msg=" + r48 + ", taskId=" + r114);
        return r115.a;
    L80:
        r48 = null;
        goto L81
    L75:
        r46 = null;
    L72:
        r45 = null;
        goto L73
    L67:
        r43 = null;
        goto L68
    L83:
        FLogger.a.e(r18, "watermarkTask reach max poll count(" + r16 + "), taskId=" + r11 + ", context=" + r17);
        return r17.a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r30 = r1.I$2;
        r110 = r1.I$1;
        r19 = r1.J$0;
        r116 = r1.I$0;
        r115 = (e0) r1.L$1;
        r114 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        goto L22
    L16:
        ResultKt.throwOnFailure(r0);
        z2 r49 = z2.a;
        int r50 = r49.getWatermarkPollMaxCount();
        long r117 = r49.getWatermarkPollInterval();
        r11 = r26;
        r16 = r50;
        r18 = "EnterpriseFileDownloadHelper";
        r19 = r117;
        r111 = 0;
        r20 = r3;
        r15 = r1;
        r17 = r27;
    L7:
        r1 = new EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1(this, r28);
        goto L8
    }
}
