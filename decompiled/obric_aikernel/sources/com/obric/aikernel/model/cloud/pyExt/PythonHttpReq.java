package com.obric.aikernel.model.cloud.pyExt;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.keva.KevaImpl;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.d;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.common.CommonNetworkImpl;
import com.obric.aikernel.model.cloud.common.c;
import com.obric.aikernel.model.cloud.common.e;
import com.obric.aikernel.utils.f;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class PythonHttpReq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PythonHttpReq f4669a = null;

    static {
        f4669a = new PythonHttpReq();
    }

    private PythonHttpReq() {
    }

    private final File c(Context r10, Uri r11) {
        String r12 = UUID.randomUUID().toString() + ".tmp";     // Catch: Exception -> L11
        File r13 = new File(AppContext.INSTANCE.getContext().getCacheDir(), "uploads");     // Catch: Exception -> L11
        if (r13.exists() == true) goto L6;
        r13.mkdirs();     // Catch: Exception -> L11
    L6:
        File r14 = f.f5592a.e(r10, r11, r13, r12);     // Catch: Exception -> L11
        if (r14 != null) goto L10;
        return null;
    L10:
        return r14;
    L11:
        e = move-exception;
        AIKLog.INSTANCE.e("PythonHttpReq", "getFileFromUri failed: " + e);
        return null;
    }

    private final c d(String r10, String r11, String r12, Map<String, String> r13, String r14, Map<String, String> r15) {
        CommonNetworkImpl r16 = CommonNetworkImpl.f4638a;
        e r17 = r16.l(r16.d(r10));
        String r18 = r15.get("use_body_v2");
        if (r18 != null) goto L75;
        r18 = NetConst.NOT_ENCRYPT_VERISON_CODE;
    L75:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L23
        String r110 = r15.get(KevaImpl.PrivateConstants.FILES_DIR_NAME);     // Catch: Throwable -> L23
        if (r110 != null) goto L9;
    L20:
        Map r111 = MapsKt.emptyMap();     // Catch: Throwable -> L23
    L21:
        Object r112 = Result.m32constructorimpl(r111);     // Catch: Throwable -> L23
    L25:
        Throwable r20 = Result.m35exceptionOrNullimpl(r112);
        if (r20 == null) goto L29;
        Log.e("FileParser", "Failed to parse files from extra: " + r20.getMessage());
        r112 = MapsKt.emptyMap();
    L29:
        Map r113 = (Map) r112;
        int r21 = r12.hashCode();
        if (r21 == 102230) goto L70;
        if (r21 == 2461856) goto L39;
        if (r21 != 3446944) goto L74;
        if (r12.equals("post") == false) goto L74;
    L77:
    L66:
        e = move-exception;
        AIKLog.INSTANCE.e("PythonHttpReq", "httpReqV2 error : " + e);
        throw new IOException("invalid http method 2");
    L41:
        if (Intrinsics.areEqual(r18, NetConst.ENCRYPT_VERISON_CODE) == true) goto L43;
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Exception -> L66
        r22.put("body", r14);     // Catch: Exception -> L66
        return r17.a(r11, r22, MapsKt.emptyMap(), r13);
    L43:
        if ((!r113.isEmpty()) == false) goto L63;
        LinkedHashMap r23 = new LinkedHashMap(MapsKt.mapCapacity(r113.size()));     // Catch: Exception -> L66
        Iterator r114 = r113.entrySet().iterator();     // Catch: Exception -> L66
    L46:
        if (r114.hasNext() == false) goto L48;
        Object r115 = r114.next();     // Catch: Exception -> L66
        Object r116 = ((Map.Entry) r115).getKey();     // Catch: Exception -> L66
        PythonHttpReq r24 = f4669a;     // Catch: Exception -> L66
        Context r25 = AppContext.INSTANCE.getContext();     // Catch: Exception -> L66
        Uri r117 = Uri.parse((String) ((Map.Entry) r115).getValue());     // Catch: Exception -> L66
        Intrinsics.checkNotNullExpressionValue(r117, "parse(this)");     // Catch: Exception -> L66
        r23.put(r116, r24.c(r25, r117));     // Catch: Exception -> L66
        goto L46
    L48:
        v.a r118 = new v.a(null, 1, null).e(v.f12054i);     // Catch: Exception -> L66
        u r119 = u.f12046d.b("");     // Catch: Exception -> L66
        Iterator r120 = r23.entrySet().iterator();     // Catch: Exception -> L66
    L50:
        if (r120.hasNext() == false) goto L61;
        Map.Entry r26 = (Map.Entry) r120.next();     // Catch: Exception -> L66
        File r27 = (File) r26.getValue();     // Catch: Exception -> L66
        if (r27 == null) goto L54;
        y r28 = y.f12130a.a(r27, r119);     // Catch: Exception -> L66
    L55:
        if (r28 == null) goto L50;
        String r29 = (String) r26.getKey();     // Catch: Exception -> L66
        File r30 = (File) r26.getValue();     // Catch: Exception -> L66
        if (r30 == null) goto L59;
        String r31 = r30.getAbsolutePath();     // Catch: Exception -> L66
    L60:
        r118.a(r29, r31, r28);     // Catch: Exception -> L66
        goto L50
    L59:
        r31 = null;
        goto L60
    L54:
        r28 = null;
        goto L55
    L61:
        c r32 = r17.c(r11, r118.d(), MapsKt.emptyMap(), r13);     // Catch: Exception -> L66
        h.d(m0.a(z0.b()), null, null, new PythonHttpReq$httpReqInner$1(r23, null), 3, null);     // Catch: Exception -> L66
        return r32;
    L63:
        return r17.f(r11, r14, MapsKt.emptyMap(), r13);
    L74:
        throw new IOException("invalid http method");
    L39:
        if (r12.equals(CloudConfig.REQUEST_TYPE_POST) == false) goto L74;
    L70:
        if (r12.equals("get") == false) goto L74;
        return r17.b(r11, MapsKt.emptyMap(), r13);
    L9:
        if ((!StringsKt.isBlank(r110)) == true) goto L12;
        r110 = null;
    L12:
        if (r110 == null) goto L20;
        JSONObject r33 = new JSONObject(r110);     // Catch: Throwable -> L23
        Map r121 = MapsKt.createMapBuilder();     // Catch: Throwable -> L23
        Iterator<String> r34 = r33.keys();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r34, "jsonObj.keys()");     // Catch: Throwable -> L23
    L15:
        if (r34.hasNext() == false) goto L17;
        String r35 = r34.next();     // Catch: Throwable -> L23
        r121.put(r35, r33.get(r35).toString());     // Catch: Throwable -> L23
        goto L15
    L17:
        r111 = MapsKt.build(r121);     // Catch: Throwable -> L23
        if (r111 == null) goto L20;
    L23:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r112 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public final Object a(String r12, String r13, String r14, String r15, Map<String, String> r16, String r17, Map<String, String> r18, Continuation<? super c> r19) {
        AIKLog r10 = AIKLog.INSTANCE;
        r10.i("PythonHttpReq", "asyncExecuteRequest runCommon, body: " + r17);
        if (d.f4534a.e() == false) goto L5;
    L7:
        String r11 = r15.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        c r20 = d(r13, r14, r11, r16, r17, r18);
        r10.i("PythonHttpReq", "asyncExecuteRequest runCommon, result: " + r20);
        return r20;
    L5:
        if (com.obric.aikernel.middleware.api.appcontext.receiver.e.f4540a.d() == true) goto L7;
        r10.w("PythonHttpReq", "use network out of net window!!!, url: " + r12);
        goto L7
    }

    public final c b(String r10, String r11, String r12, String r13, Map<String, String> r14, String r15, Map<String, String> r16) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "host");
        Intrinsics.checkNotNullParameter(r12, "url_path");
        Intrinsics.checkNotNullParameter(r13, EnsureReportData.METHOD);
        Intrinsics.checkNotNullParameter(r14, "headers");
        Intrinsics.checkNotNullParameter(r15, "body");
        Intrinsics.checkNotNullParameter(r16, WsConstants.KEY_EXTRA);
        if (d.f4534a.e() == false) goto L5;
    L7:
        String r17 = r13.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return d(r11, r12, r17, r14, r15, r16);
    L5:
        if (com.obric.aikernel.middleware.api.appcontext.receiver.e.f4540a.d() == true) goto L7;
        AIKLog.INSTANCE.w("PythonHttpReq", "use network out of net window!!!, url: " + r10);
        goto L7
    }
}
