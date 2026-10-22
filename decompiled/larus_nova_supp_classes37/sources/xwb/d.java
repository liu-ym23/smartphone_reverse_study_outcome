package xwb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.ss.android.lark.officewebview.bridge.Status;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements j {
    public final /* synthetic */ String a;
    public final /* synthetic */ a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    @Override // xwb.j
    public final void a(Status r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "status");
        String r2 = this.a;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        int r10 = h.a;
        h.b(this.b.a, 10005, this.c + " 's callbackId isNullOrEmpty!", this.c);
        return;
    L11:
        this.b.i.getClass();
        e r4 = this.b.i;
        String r5 = this.a;
        String r6 = this.d;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r8, "status");
        Intrinsics.checkNotNullParameter(r5, "callbackId");
        Intrinsics.checkNotNullParameter(r6, "extraStr");
        HashMap r1 = new HashMap();
        r1.put("callbackID", this.a);
        r1.put("data", r9);
        r1.put("callbackType", r8.getStatus());
        this.b.getClass();
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L14
    L17:
        if ((r9 instanceof JSONObject) == false) goto L23;
        JSONObject r12 = (JSONObject) ((ConcurrentHashMap) this.b.h).get(this.c);
        if (r12 == null) goto L22;
        r11 = r12;
    L22:
        r1.put("extra", r11);
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        String r14 = String.format("LarkWebViewJavaScriptBridge.nativeCallBack(%s);", Arrays.copyOf(new Object[]{new JSONObject(r1).toString()}, 1));
    L39:
        com.ss.android.lark.officesdk.utils.di.j.a("CML_TAG_JSBridge", "evaluateJavascript for jsapi callback, script = " + r14);
        this.b.a.evaluateJavascript(r14, null);
        return;
    L23:
        com.alibaba.fastjson.JSONObject r15 = (JSONObject) ((ConcurrentHashMap) this.b.h).get(this.c);
        if (r15 != null) goto L29;
        String r16 = r11.toString();
        if (r16 != null) goto L28;
        r16 = "";
    L28:
        r15 = JSON.parseObject(r16);
    L29:
        r1.put("extra", r15);
        String r17 = new com.alibaba.fastjson.JSONObject(r1).toJSONString();
        g r18 = this.b.e;
        Intrinsics.checkNotNull(r17);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r17, "result");
    L36:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("BridgeInfoPrinter", "Failed to printLengthInfo, ", th);
    L38:
        StringCompanionObject r19 = StringCompanionObject.INSTANCE;
        r14 = String.format("LarkWebViewJavaScriptBridge.nativeCallBack(%s);", Arrays.copyOf(new Object[]{r17}, 1));
        goto L39
    L31:
        if (TextUtils.isEmpty(r17) == true) goto L38;
        if (r17.length() <= 2097152) goto L38;
        g.a(r1, "param before serialize ");     // Catch: Throwable -> L36
        g.a(r17, "param after serialize ");     // Catch: Throwable -> L36
    L14:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("CML_TAG_JSBridge", e);
        r11 = new JSONObject();
        goto L17
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public d(String r1, a r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        System.currentTimeMillis();
    }
}
