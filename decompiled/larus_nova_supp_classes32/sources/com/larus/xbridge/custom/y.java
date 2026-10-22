package com.larus.xbridge.custom;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoDbTable;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y extends bx7.c {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.saveMsgExportFile";
    }

    public y() {
    }

    public static String g(Context r3, Uri r4) {
        String r0 = r4.getScheme();
        if (r0 == null) goto L18;
        int r1 = r0.hashCode();
        if (r1 == 3143036) goto L14;
        if (r1 == 951530617) goto L10;
        return null;
    L10:
        if (r0.equals(LynxAccessibilityModule.MSG_CONTENT) == true) goto L12;
        return null;
    L12:
        return r3.getContentResolver().getType(r4);
    L14:
        if (r0.equals("file") == false) goto L22;
        String r5 = MimeTypeMap.getFileExtensionFromUrl(r4.toString());
        FLogger.a.d("AppSaveFileMethod", "extension: " + r5);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(r5);
    L22:
        return null;
    L18:
        return null;
    }

    public static final Object f(y r7, String r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1) == false) goto L7;
        AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1 r0 = (AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        WatermarkPerfLogger.a r11 = (WatermarkPerfLogger.a) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L43:
        com.larus.platform.service.watermark.g.c r12 = (com.larus.platform.service.watermark.g) r10;     // Catch: Throwable -> L14
        if ((r12 instanceof com.larus.platform.service.watermark.g.c) == false) goto L46;
        com.larus.platform.service.watermark.g.c r13 = r12;     // Catch: Throwable -> L14
    L47:
        if (r13 == null) goto L49;
        String r14 = r13.a;     // Catch: Throwable -> L14
    L50:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L14
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 != null) goto L65;
        String r5 = (String) r15;
        r11.a("applyWatermarkToFileAsLocal");
        if (r5 == null) goto L61;
        WatermarkPerfLogger.Result r17 = WatermarkPerfLogger.Result.SUCCESS;
    L62:
        if (r5 != null) goto L64;
        r4 = "no_ready_local_file";
    L64:
        r11.b(r17, r4);
        return r5;
    L61:
        r17 = WatermarkPerfLogger.Result.FAIL;
        goto L62
    L65:
        FLogger.a.w("AppSaveFileMethod", "applyDownloadFileWatermark failed: " + r16);
        r11.b(WatermarkPerfLogger.Result.FAIL, r16.getClass().getSimpleName());
    L67:
        return null;
    L49:
        r14 = null;
        goto L50
    L46:
        r13 = null;
    L14:
        Throwable th = th;
        WatermarkPerfLogger.a r6 = r11;
    L55:
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        r11 = r6;
        goto L56
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        DownloadWatermarkService r19 = DownloadWatermarkService.a;
        r19.getClass();
        if (DownloadWatermarkService.d() == true) goto L22;
        r19 = null;
    L22:
        ex7.d r20 = ((bx7.c) r7).a;
        if (r20 == null) goto L25;
        Context r21 = (Context) r20.a(Context.class);
    L26:
        int r22 = WatermarkPerfLogger.a;
        if (r19 != null) goto L29;
        WatermarkPerfLogger.Version r23 = WatermarkPerfLogger.Version.PERSONAL;
    L30:
        DownloadWatermarkScene r24 = DownloadWatermarkScene.MESSAGE_EXPORT_FILE;
        r6 = WatermarkPerfLogger.a("app_save_msg_export_file", r23, r24);
        if (r19 != null) goto L33;
        WatermarkPerfLogger.Path r25 = WatermarkPerfLogger.Path.NONE;
    L34:
        r6.c(r25);
        if (r19 != null) goto L37;
        r6.b(WatermarkPerfLogger.Result.SUCCESS, null);
        goto L67
    L37:
        if (r21 != null) goto L70;
        r6.b(WatermarkPerfLogger.Result.FAIL, "context_null");
        goto L67
    L70:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L53
        Uri r27 = Uri.fromFile(new PolarisFileWrapper(r8));     // Catch: Throwable -> L53
        Intrinsics.checkNotNull(r27);     // Catch: Throwable -> L53
        com.larus.platform.service.watermark.a r28 = new com.larus.platform.service.watermark.a(r8, g(r21, r27), r24);     // Catch: Throwable -> L53
        r0.L$0 = r6;     // Catch: Throwable -> L53
        r0.label = 1;     // Catch: Throwable -> L53
        r10 = r19.a(r28, r0);     // Catch: Throwable -> L53
        if (r10 == r2) goto L73;
        r11 = r6;
        goto L43
    L73:
        return r2;
    L53:
        th = move-exception;
        th = th;
        goto L55
    L33:
        r25 = WatermarkPerfLogger.Path.B_FILE;
        goto L34
    L29:
        r23 = WatermarkPerfLogger.Version.ENTERPRISE;
        goto L30
    L25:
        r21 = null;
    L7:
        r0 = new AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1(r7, r9);
        goto L8
    }

    public final void a(dx7.b r11, ux7.d.d r12, IvyBridgePlatformType r13) {
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "type");
        FlowFileProtectionService r14 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r14 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L25;
        com.larus.platform.service.o r15 = com.larus.platform.service.o.a;
        JSONObject r3 = new JSONObject();
        r3.put("action", "export_file");
        r3.put("entry", "message_export_bridge");
        r3.put("channel", "local_export");
        r3.put("content_type", "file");
        Unit r4 = Unit.INSTANCE;
        r15.reportEvent("flow_enterprise_file_egress_block", r3);
        String r16 = r14.H0();
        if (r16 != null) goto L12;
    L23:
        bx7.c.c(this, r12, 0, "blocked by enterprise file security", 8);
        return;
    L12:
        if ((!StringsKt.isBlank(r16)) == true) goto L15;
        r16 = null;
    L15:
        String r5 = r16;
        if (r5 == null) goto L23;
        t19.s r1 = t19.s.a;
        ex7.d r17 = ((bx7.c) this).a;
        if (r17 == null) goto L21;
        Context r18 = (Context) r17.a(Context.class);
        if (r18 == null) goto L21;
    L22:
        t19.s.j(r1, r18, r5, null, false, 28);
    L21:
        r18 = AppHost.a.getApplication();
        goto L22
    L25:
        String r6 = r11.getString(LynxAccessibilityModule.MSG_CONTENT);
        String r7 = r11.getString(EasyGoDbTable.Server.NAME);
        FLogger.a.d("AppSaveFileMethod", "fileName: " + r7);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new z(CoroutineExceptionHandler.Key))), null, null, new AppSaveMsgExportFileMethod$handle$4(this, r6, r7, r12, r11, null), 3, null);
        return;
    L5:
        if (r14.I0() != true) goto L7;
        r2 = true;
        goto L8
    }
}
