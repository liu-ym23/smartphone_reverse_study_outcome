package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f6858a;

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final boolean a(co.e r5) {
        Intrinsics.checkNotNullParameter(r5, "entry");
        return false;
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final Map b(co.e r10) {
        Intrinsics.checkNotNullParameter(r10, "entry");
        LinkedHashMap r5 = new LinkedHashMap();
        String r11 = r10.f1227b;
        boolean r12 = Intrinsics.areEqual(r11, "pipeline");
        HashMap r13 = r10.f1228c;
        if (r12 == false) goto L53;
        String r14 = r10.f1226a;
        if (r14 == null) goto L23;
        int r15 = r14.hashCode();
        if (r15 == (-701686520)) goto L20;
        if (r15 == 521646652) goto L17;
        if (r15 != 1904924252) goto L23;
        if (r14.equals("reloadBundleFromBts") == false) goto L23;
    L22:
        this.f6858a = r13;
        goto L23
    L17:
        if (r14.equals("reloadBundleFromNative") == false) goto L23;
    L20:
        if (r14.equals("loadBundle") == true) goto L22;
    L23:
        LinkedHashMap r16 = new LinkedHashMap();
        Number r17 = null;
        r16.putAll(com.lynx.jsbridge.a.g(null, r13));
        LinkedHashMap r18 = new LinkedHashMap();
        Object r19 = r13.get("mtsRenderStart");
        if ((r19 instanceof Number) == false) goto L26;
        Number r20 = (Number) r19;
    L27:
        Object r21 = r13.get("pipelineStart");
        if ((r21 instanceof Number) == false) goto L30;
        Number r22 = (Number) r21;
    L31:
        Object r23 = r13.get("layoutUiOperationExecuteEnd");
        if ((r23 instanceof Number) == false) goto L34;
        Number r24 = (Number) r23;
    L35:
        Object r25 = r13.get("paintEnd");
        if ((r25 instanceof Number) == false) goto L38;
        Number r26 = (Number) r25;
    L39:
        HashMap r27 = this.f6858a;
        if (r27 == null) goto L42;
        Object r28 = r27.get("paintEnd");
    L44:
        if ((r28 instanceof Number) == false) goto L46;
        r17 = (Number) r28;
    L46:
        r18.put("updateWaiting", com.lynx.jsbridge.a.c(r17, r22));
        r18.put("paintWaiting", com.lynx.jsbridge.a.c(r24, r26));
        r18.put("triggerWaiting", com.lynx.jsbridge.a.c(r22, r20));
        Object r29 = r13.get("paintEnd");
        if (r29 == null) goto L51;
        r18.put("paintEnd", (Number) r29);
        r16.putAll(r18);
        return r16;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
    L42:
        r28 = null;
        goto L44
    L38:
        r26 = null;
        goto L39
    L34:
        r24 = null;
        goto L35
    L30:
        r22 = null;
        goto L31
    L26:
        r20 = null;
        goto L27
    L53:
        if (Intrinsics.areEqual(r11, LynxMonitorService.KEY_METRIC) == false) goto L72;
        LinkedHashMap r30 = new LinkedHashMap();
        Iterator r110 = r13.entrySet().iterator();
    L56:
        if (r110.hasNext() == false) goto L71;
        Map.Entry r31 = (Map.Entry) r110.next();
        String r32 = (String) r31.getKey();
        Object r33 = r31.getValue();
        if (r32 == null) goto L70;
        if ((r33 instanceof HashMap) == false) goto L70;
        Map r34 = (Map) r33;
        Object r35 = r34.get("duration");
        if (r35 == null) goto L64;
        r30.put(r32, r35);
    L64:
        Object r36 = r34.get("startTimestampName");
        if (r36 == null) goto L67;
        r30.put(r32.concat("StartTimestampName"), r36);
    L67:
        Object r37 = r34.get("endTimestampName");
        if (r37 == null) goto L56;
        r30.put(r32.concat("EndTimestampName"), r37);
    L70:
        r30.put(r32, r33);
        goto L56
    L71:
        return r30;
    L72:
        return r5;
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final void onInitialize(Context r5) {
    }
}
