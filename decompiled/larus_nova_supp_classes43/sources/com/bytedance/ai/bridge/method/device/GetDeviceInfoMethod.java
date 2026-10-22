package com.bytedance.ai.bridge.method.device;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.deviceInfo.AbsGetDeviceInfoMethodIDL;
import com.bytedance.ai.utils.b;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import e3.d;
import e3.e;
import f3.h;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import t3.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/GetDeviceInfoMethod;", "Lcom/bytedance/ai/bridge/device/deviceInfo/AbsGetDeviceInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/device/deviceInfo/AbsGetDeviceInfoMethodIDL$GetDeviceInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/deviceInfo/AbsGetDeviceInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetDeviceInfoMethod extends AbsGetDeviceInfoMethodIDL {
    public final boolean b;

    public GetDeviceInfoMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a.c b(d r12, AbsGetDeviceInfoMethodIDL.a r13) {
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Context r14 = e.b(r12);
        Intrinsics.checkNotNullParameter(AbsGetDeviceInfoMethodIDL.b.class, "<this>");
        BaseModel r15 = c.a(AbsGetDeviceInfoMethodIDL.b.class);
        AbsGetDeviceInfoMethodIDL.b r0 = (AbsGetDeviceInfoMethodIDL.b) r15;
        p0.a.getClass();
        boolean r10 = false;
        String r11 = null;
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L17:
        String[] r1 = Build.SUPPORTED_ABIS;
        int r16 = r1.length;
        int r17 = 0;
    L18:
        if (r17 >= r16) goto L23;
        String r18 = r1[r17];
        Intrinsics.checkNotNull(r18);
        if ((!StringsKt.isBlank(r18)) == true) goto L24;
        r17 = r17 + 1;
    L24:
        r0.setAbi(r18);
        p0.a.getClass();
        String[] r19 = Build.SUPPORTED_ABIS;
        int r20 = r19.length;
        int r21 = 0;
    L25:
        if (r21 >= r20) goto L30;
        String r22 = r19[r21];
        Intrinsics.checkNotNull(r22);
        if ((!StringsKt.isBlank(r22)) == true) goto L31;
        r21 = r21 + 1;
    L31:
        r0.setDeviceAbi(r22);
        p0.a.getClass();
        int r23 = b.a;
        Object r24 = ((LinkedHashMap) b.a(CollectionsKt.listOf("flow_device_model_score"))).get("flow_device_model_score");
        if ((r24 instanceof Map) == false) goto L35;
        Double r25 = p0.a(((Map) r24).get("overall_score"));
    L54:
        double r26 = -1.0d;
        if (r25 == null) goto L63;
        double r27 = r25.doubleValue();
        if (r27 != (-1.0d)) goto L59;
        boolean r28 = true;
    L60:
        if (r28 == true) goto L63;
        r26 = 3.0d * r27;
        goto L63
    L59:
        r28 = false;
    L63:
        r0.setBenchmarkLevel(r26);
        String r29 = Build.BRAND;
        String r30 = "";
        if (r29 != null) goto L66;
        r29 = "";
    L66:
        r0.setBrand(r29);
        String r31 = Build.MODEL;
        if (r31 != null) goto L69;
        r31 = "";
    L69:
        r0.setModel(r31);
        p0.a.getClass();
        String r32 = Build.VERSION.RELEASE;
        if (r32 != null) goto L73;
        r32 = "";
    L73:
        if (r32.length() != 0) goto L75;
        boolean r33 = true;
    L76:
        if (r33 == false) goto L78;
        String r34 = "Android";
    L79:
        r0.setSystem(r34);
        r0.setPlatform("android");
        r0.setCpuType(Build.HARDWARE);
        if (r14 == null) goto L162;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L97
        Object r110 = r14.getSystemService(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L97
        if ((r110 instanceof ActivityManager) == false) goto L84;
        ActivityManager r111 = (ActivityManager) r110;     // Catch: Throwable -> L97
    L85:
        ActivityManager.MemoryInfo r36 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L97
        if (r111 == null) goto L88;
        r111.getMemoryInfo(r36);     // Catch: Throwable -> L97
    L88:
        Long r112 = Long.valueOf(r36.totalMem);     // Catch: Throwable -> L97
        if (r112.longValue() <= 0) goto L91;
        boolean r37 = true;
    L92:
        if (r37 == true) goto L95;
        r112 = null;
    L95:
        Object r113 = Result.constructor-impl(r112);     // Catch: Throwable -> L97
    L100:
        if (Result.isFailure-impl(r113) == false) goto L102;
        r113 = null;
    L102:
        Long r114 = (Long) r113;
        if (r114 == null) goto L162;
    L147:
        if (r114 == null) goto L149;
        r11 = String.valueOf(r114.longValue() / 1048576);
    L149:
        if (r11 == null) goto L152;
        r30 = r11;
    L152:
        r0.setMemorySize(r30);
        return new com.bytedance.ai.bridge.core.a.c(r15);
    L91:
        r37 = false;
        goto L92
    L84:
        r111 = null;
    L97:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
    L162:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L141
        PolarisFileWrapper r116 = new PolarisFileWrapper("/proc/meminfo");     // Catch: Throwable -> L141
        Reader r39 = new InputStreamReader(new PolarisFileInputStreamWrapper(r116), Charsets.UTF_8);     // Catch: Throwable -> L141
        if ((r39 instanceof BufferedReader) == false) goto L108;
        BufferedReader r40 = (BufferedReader) r39;     // Catch: Throwable -> L141
    L154:
        Iterator r117 = TextStreamsKt.lineSequence(r40).iterator();     // Catch: Throwable -> L136
    L111:
        if (r117.hasNext() == false) goto L115;
        Object r41 = r117.next();     // Catch: Throwable -> L136
        if (StringsKt.startsWith$default((String) r41, "MemTotal:", false, 2, null) == false) goto L111;
    L116:
        String r42 = (String) r41;     // Catch: Throwable -> L136
        if (r42 == null) goto L133;
        List r118 = new Regex("\\s+").split(r42, 0);     // Catch: Throwable -> L136
        if (r118 == null) goto L133;
        String r119 = (String) CollectionsKt.getOrNull(r118, 1);     // Catch: Throwable -> L136
        if (r119 == null) goto L133;
        Long r120 = StringsKt.toLongOrNull(r119);     // Catch: Throwable -> L136
        if (r120 == null) goto L133;
        if (r120.longValue() <= 0) goto L127;
        r10 = true;
    L127:
        if (r10 == true) goto L130;
        r120 = null;
    L130:
        if (r120 == null) goto L133;
        Long r121 = Long.valueOf(r120.longValue() * 1024);     // Catch: Throwable -> L136
    L134:
        CloseableKt.closeFinally(r40, null);     // Catch: Throwable -> L141
        Object r122 = Result.constructor-impl(r121);     // Catch: Throwable -> L141
    L144:
        if (Result.isFailure-impl(r122) == false) goto L146;
        r122 = null;
    L146:
        r114 = (Long) r122;
        goto L147
    L133:
        r121 = null;
        goto L134
    L115:
        r41 = null;
    L136:
        th = move-exception;
        throw th;     // Catch: Throwable -> L138
    L138:
        th = move-exception;
        CloseableKt.closeFinally(r40, th);     // Catch: Throwable -> L141
        throw th;     // Catch: Throwable -> L141
    L108:
        r40 = new BufferedReader(r39, 8192);     // Catch: Throwable -> L141
    L141:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r122 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L144
    L78:
        r34 = "Android ".concat(r32);
        goto L79
    L75:
        r33 = false;
        goto L76
    L35:
        if ((r24 instanceof JSONObject) == false) goto L38;
        r25 = p0.a(((JSONObject) r24).opt("overall_score"));
        goto L54
    L38:
        if ((r24 instanceof JsonObject) == false) goto L41;
        r25 = p0.a(((JsonObject) r24).get("overall_score"));
        goto L54
    L41:
        if ((r24 instanceof String) == false) goto L53;
        String r44 = (String) r24;
        Double r45 = StringsKt.toDoubleOrNull(r44);
        if (r45 == null) goto L160;
        r25 = r45;
        goto L54
    L160:
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L46
        Object r47 = Result.constructor-impl(p0.a(new JSONObject(r44).opt("overall_score")));     // Catch: Throwable -> L46
    L49:
        if (Result.isFailure-impl(r47) == false) goto L51;
        r47 = null;
    L51:
        r25 = (Double) r47;
    L46:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r47 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L53:
        r25 = p0.a(r24);
        goto L54
    L30:
        r22 = null;
        goto L31
    L23:
        r18 = null;
        goto L24
    L5:
        if (Process.is64Bit() == false) goto L7;
        String[] r49 = Build.SUPPORTED_64_BIT_ABIS;
    L8:
        Intrinsics.checkNotNull(r49);
        int r50 = r49.length;
        int r51 = 0;
    L9:
        if (r51 >= r50) goto L14;
        r18 = r49[r51];
        Intrinsics.checkNotNull(r18);
        if ((!StringsKt.isBlank(r18)) == true) goto L15;
        r51 = r51 + 1;
    L15:
        if (r18 == null) goto L17;
    L14:
        r18 = null;
        goto L15
    L7:
        r49 = Build.SUPPORTED_32_BIT_ABIS;
        goto L8
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetDeviceInfoMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetDeviceInfoMethodIDL.a r13 = (AbsGetDeviceInfoMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
