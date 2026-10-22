package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSchemaMonitor;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSchemaMonitor extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECSchemaMonitor() {
        this.e = "ecSchemaMonitor";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r11, ECBaseBridgeMethod.a r12) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "iReturn");
        String r10 = r11.optString("scene");     // Catch: Exception -> L32
        if (cg4.a.a(r10) == false) goto L6;
        String r13 = r10;
    L7:
        String r0 = r11.optString("params");     // Catch: Exception -> L32
        if (cg4.a.a(r0) == false) goto L10;
        String r14 = r0;
    L11:
        Context r15 = getContext();     // Catch: Exception -> L32
        if (r15 == null) goto L34;
        if (r13 == null) goto L34;
        if (r14 == null) goto L34;
        String r1 = r11.optString("contextProvider");     // Catch: Exception -> L32
        if (cg4.a.a(r1) == false) goto L18;
        String r16 = r1;
    L19:
        String r17 = r11.optString("scriptPath");     // Catch: Exception -> L32
        if (r17 == null) goto L31;
        String r18 = StringsKt.trim(r17).toString();     // Catch: Exception -> L32
        if (cg4.a.a(r18) == false) goto L24;
        String r19 = r18;
    L25:
        int r110 = ECSdk.a;     // Catch: Exception -> L32
        o r20 = (o) ECSdk.a(o.class);     // Catch: Exception -> L32
        if (r20 == null) goto L28;
        r20.a(r15, r13, r14, r16, r19);     // Catch: Exception -> L32
    L28:
        r12.onSuccess(null);     // Catch: Exception -> L32
        return;
    L24:
        r19 = null;
        goto L25
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L32
    L18:
        r16 = null;
    L34:
        r12.onFailed(0, null);
        return;
    L10:
        r14 = null;
        goto L11
    L6:
        r13 = null;
    L32:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L34
    }
}
