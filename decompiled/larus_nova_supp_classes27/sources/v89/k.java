package v89;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.JSModuleWrapper;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.impl.redirect.FlowTransferModule;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ Function2 c;

    public /* synthetic */ k(Context r1, Uri r2, i r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, v89.n] */
    public final Object invoke(Object r11) {
        Context r0 = this.a;
        Uri r1 = this.b;
        final Function2 r2 = this.c;
        String r12 = (String) r11;
        Intrinsics.checkNotNullParameter(r12, "filePath");
        boolean r4 = false;
        if (r12.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        Lazy r6 = p.a;
        if (r3 == false) goto L9;
        FLogger.a.e("FlowTransferRedirect", "[fetchJs] load failed, fallback");
        ((Handler) p.a.getValue()).post(new l(r2));
        return Unit.INSTANCE;
    L9:
        FLogger.a.i("FlowTransferRedirect", "[fetchJs] load success, filePath=".concat(r12));
        FlowTransferModule r5 = null;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L12
        Object r13 = Result.constructor-impl(FilesKt.readText$default(new PolarisFileWrapper(r12), null, 1, null));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r13) == false) goto L17;
        r13 = null;
    L17:
        String r14 = (String) r13;
        if (r14 != null) goto L20;
    L21:
        r4 = true;
    L22:
        if (r4 == false) goto L24;
        FLogger.a.e("FlowTransferRedirect", "[fetchJs] read file failed, fallback");
        ((Handler) p.a.getValue()).post(new m(r2));
        return Unit.INSTANCE;
    L24:
        FLogger r8 = FLogger.a;
        r8.i("FlowTransferRedirect", "[jsWorker] run start");
        JsWorker r9 = b.a;
        final ?? r10 = new n(r2);
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r14, "jsContent");
        Intrinsics.checkNotNullParameter(r1, "uri");
        Intrinsics.checkNotNullParameter(r10, "onOpenSchema");
        if (JsWorker.isIsInitialised() == true) goto L30;
        if (JsWorker.initialize() == true) goto L30;
        r8.e("FlowTransferJsWorker", "[run] JsWorker init failed");
        r10.invoke(null, "js_worker_init_failed");
    L69:
        return Unit.INSTANCE;
    L30:
        if (b.a != null) goto L38;
        r8.i("FlowTransferJsWorker", "[createWorker] start");
        if (JsWorker.isIsInitialised() == false) goto L34;
    L36:
        Context r15 = r0.getApplicationContext();
        com.bytedance.vmsdk.worker.a.a r16 = new com.bytedance.vmsdk.worker.a.a();
        r16.a = JsWorker.EngineType.QUICKJS;
        r16.f = new JSModuleManager(r15);
        r16.c = null;
        r16.b = "flow_transfer_interceptor";
        r16.d = AppHost.a.isDebugChannel();
        JsWorker r17 = new JsWorker(new com.bytedance.vmsdk.worker.a(r16));
        r17.registerModule(FlowTransferModule.MODULE_NAME, FlowTransferModule.class, null);
        r8.i("FlowTransferJsWorker", "[createWorker] done");
    L37:
        b.a = r17;
        goto L38
    L34:
        if (JsWorker.initialize() == true) goto L36;
        r8.e("FlowTransferJsWorker", "[createWorker] JsWorker init failed");
        r17 = null;
    L38:
        JsWorker r18 = b.a;
        if (r18 != null) goto L41;
        r8.e("FlowTransferJsWorker", "[run] createWorker failed");
        r10.invoke(null, "js_worker_create_failed");
        goto L69
    L41:
        JSModuleManager r20 = r18.getModuleManager();
        if (r20 == null) goto L46;
        JSModuleWrapper r21 = r20.a(FlowTransferModule.MODULE_NAME);
        if (r21 == null) goto L46;
        JSModule r22 = r21.getModule();
    L48:
        if ((r22 instanceof FlowTransferModule) == false) goto L50;
        r5 = (FlowTransferModule) r22;
    L50:
        if (r5 == null) goto L52;
        r5.setOnOpenSchema(new a(r10));
    L52:
        JavaOnlyMap r23 = new JavaOnlyMap();
        r23.put("isAndroid", Boolean.TRUE);
        Boolean r24 = Boolean.FALSE;
        r23.put("isInAweme", r24);
        r23.put("isInAwemeLite", r24);
        r23.put("appVersion", AppHost.a.getVersionName());
        JavaOnlyMap r25 = new JavaOnlyMap();
        Iterator r26 = UriProtector.getQueryParameterNames(r1).iterator();
    L54:
        if (r26.hasNext() == false) goto L56;
        String r27 = (String) r26.next();
        r25.put(r27, UriProtector.getQueryParameter(r1, r27));
        goto L54
    L56:
        String r28 = UriProtector.getQueryParameter(r1, "url");
        if (r28 != null) goto L70;
    L67:
        r23.put("query", r25);
        r18.setGlobalProperties(r23);
        FLogger.a.i("FlowTransferJsWorker", "[run] evaluateJavaScript");
        r18.evaluateJavaScript(r14);
        goto L69
    L70:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L64
        Uri r31 = UriProtector.parse(r28);     // Catch: Throwable -> L64
        Iterator r32 = UriProtector.getQueryParameterNames(r31).iterator();     // Catch: Throwable -> L64
    L60:
        if (r32.hasNext() == false) goto L62;
        String r33 = (String) r32.next();     // Catch: Throwable -> L64
        r25.put(r33, UriProtector.getQueryParameter(r31, r33));     // Catch: Throwable -> L64
        goto L60
    L62:
        Object r34 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L64
    L66:
        Result.box-impl(r34);
    L64:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
    L46:
        r22 = null;
        goto L48
    L20:
        if (r14.length() != 0) goto L22;
    L12:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r3 = false;
        goto L6
    }
}
