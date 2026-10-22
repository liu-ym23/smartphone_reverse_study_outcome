package com.larus.bmhome.chat.markdown.code.share;

import android.content.Context;
import android.webkit.MimeTypeMap;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.o;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.platform.service.watermark.a;
import com.larus.platform.service.watermark.g;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CodeShareHelper {
    public static final CodeShareHelper a = null;

    static {
        a = new CodeShareHelper();
    }

    public CodeShareHelper() {
    }

    public static final Object a(CodeShareHelper r8, String r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof CodeShareHelper$applyCodeExportWatermark$1) == false) goto L7;
        CodeShareHelper$applyCodeExportWatermark$1 r0 = (CodeShareHelper$applyCodeExportWatermark$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        String r3 = null;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        WatermarkPerfLogger.a r13 = (WatermarkPerfLogger.a) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
    L38:
        if ((r11 instanceof g.c) == false) goto L40;
        g.c r14 = (g.c) r11;     // Catch: Throwable -> L14
    L41:
        if (r14 == null) goto L43;
        String r15 = r14.a;     // Catch: Throwable -> L14
    L44:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L14
    L49:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 != null) goto L58;
        String r18 = (String) r16;
        r13.a("applyWatermarkToFileAsLocal");
        if (r18 == null) goto L54;
        WatermarkPerfLogger.Result r19 = WatermarkPerfLogger.Result.SUCCESS;
    L55:
        if (r18 != null) goto L57;
        r3 = "no_ready_local_file";
    L57:
        r13.b(r19, r3);
        return r18;
    L54:
        r19 = WatermarkPerfLogger.Result.FAIL;
        goto L55
    L58:
        FLogger.a.w("CodeShareHelper", "applyCodeExportWatermark failed: " + r17);
        r13.b(WatermarkPerfLogger.Result.FAIL, r17.getClass().getSimpleName());
    L60:
        return null;
    L43:
        r15 = null;
        goto L44
    L40:
        r14 = null;
    L14:
        th = th;
        WatermarkPerfLogger.a r4 = r13;
    L48:
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        r13 = r4;
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        DownloadWatermarkService r21 = DownloadWatermarkService.a;
        r21.getClass();
        if (DownloadWatermarkService.d() == true) goto L22;
        r21 = null;
    L22:
        int r5 = WatermarkPerfLogger.a;
        if (r21 != null) goto L25;
        WatermarkPerfLogger.Version r6 = WatermarkPerfLogger.Version.PERSONAL;
    L26:
        DownloadWatermarkScene r7 = DownloadWatermarkScene.MESSAGE_EXPORT_CODE;
        r4 = WatermarkPerfLogger.a("code_share_export", r6, r7);
        if (r21 != null) goto L29;
        WatermarkPerfLogger.Path r22 = WatermarkPerfLogger.Path.NONE;
    L30:
        r4.c(r22);
        if (r21 != null) goto L63;
        r4.b(WatermarkPerfLogger.Result.SUCCESS, null);
        goto L60
    L63:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L47
        a r24 = new a(r9, MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast(r9, '.', "").toLowerCase(Locale.ROOT)), r7);     // Catch: Throwable -> L47
        r0.L$0 = r4;     // Catch: Throwable -> L47
        r0.label = 1;     // Catch: Throwable -> L47
        r11 = r21.a(r24, r0);     // Catch: Throwable -> L47
        if (r11 == r12) goto L66;
        r13 = r4;
        goto L38
    L66:
        return r12;
    L47:
        th = th;
        goto L48
    L29:
        r22 = WatermarkPerfLogger.Path.B_FILE;
        goto L30
    L25:
        r6 = WatermarkPerfLogger.Version.ENTERPRISE;
    L7:
        r0 = new CodeShareHelper$applyCodeExportWatermark$1(r8, r10);
        goto L8
    }

    public static void b(Context r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "code");
        Intrinsics.checkNotNullParameter(r14, "language");
        FlowFileProtectionService r3 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r3 != null) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (r5 == false) goto L19;
        o r0 = o.a;
        JSONObject r2 = new JSONObject();
        r2.put("action", "share");
        r2.put("entry", "code_share_export");
        r2.put("channel", "export_file");
        r2.put("content_type", "file");
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("flow_enterprise_file_egress_block", r2);
        String r1 = r3.A0();
        if (r1 != null) goto L13;
        return;
    L13:
        if ((!StringsKt.isBlank(r1)) == false) goto L15;
        String r4 = r1;
    L16:
        if (r4 == null) goto L22;
        s.j(s.a, r12, r4, null, false, 28);
        return;
    L22:
        return;
    L15:
        r4 = null;
        goto L16
    L19:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CodeShareHelper$shareCode$4(r12, r13, r14, null), 3, null);
        return;
    L5:
        if (r3.I0() != true) goto L7;
        r5 = true;
        goto L9
    }
}
