package oi;

import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {
    public e() {
    }

    @Override // oi.a
    public final String a() {
        return "RemotePermissionConfigLoader";
    }

    @Override // oi.a
    public final JSONObject c() {
        if (this.f20582a == null) goto L54;
        JSONObject r5 = new JSONObject();
    L11:
        e = move-exception;
        e.printStackTrace();
    L20:
        String r10 = r5.toString();
        if (this.f20582a == null) goto L40;
        Charset r11 = Charsets.UTF_8;
        if (r10 == null) goto L39;
        byte[] r12 = r10.getBytes(r11);
        new LinkedHashMap().put("Content-Type", "application/json");
        if (com.bytedance.ttnet.utils.d.c(wl.a.class, "https://jsb.snssdk.com/src/server/v2/package") != null) goto L37;
        if (r12 == null) goto L35;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L29
        throw null;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Object r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        if (Result.m130isFailureimpl(r15) == false) goto L33;
        r15 = null;
    L33:
        String r16 = (String) r15;
    L41:
        if (r16 == null) goto L54;
        JSONObject r17 = new JSONObject(r16);     // Catch: Exception -> L45
        int r18 = r17.optInt(NotificationCompat.CATEGORY_STATUS);     // Catch: Exception -> L45
        if (r18 != 0) goto L47;
        JSONObject r19 = r17.optJSONObject("data");     // Catch: Exception -> L45
    L48:
        d(r19);     // Catch: Exception -> L45
        return r17;
    L47:
        ki.a.a("RemotePermissionConfigLoader: load failed, status=" + r18);     // Catch: Exception -> L45
        r19 = null;
    L45:
        e = move-exception;
        String r20 = e.getMessage();
        if (r20 != null) goto L53;
        r20 = "unknown";
    L53:
        ki.a.a("RemotePermissionConfigLoader: load failed, e=".concat(r20));
        e.printStackTrace();
        Unit r110 = Unit.INSTANCE;
        goto L54
    L35:
        throw new NullPointerException("bytes");
    L37:
        throw new ClassCastException();
    L39:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L40:
        r16 = null;
        goto L41
    L6:
        if (this.f20582a == null) goto L20;
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L11
        r21.put(WsConstants.KEY_APP_ID, 0);     // Catch: JSONException -> L11
        r21.put("app_version", k5.d.f18606k);     // Catch: JSONException -> L11
        r21.put("os", 0);     // Catch: JSONException -> L11
        r21.put(WsConstants.KEY_DEVICE_ID, k5.d.f18610o);     // Catch: JSONException -> L11
        JSONArray r22 = new JSONArray();     // Catch: JSONException -> L11
        JSONObject r23 = new JSONObject();     // Catch: JSONException -> L11
        r23.put(LynxMonitorService.KEY_CHANNEL, "_jsb_auth");     // Catch: JSONException -> L11
        r23.put("local_version", 0);     // Catch: JSONException -> L11
        r22.put(r23);     // Catch: JSONException -> L11
        Iterator r24 = CollectionsKt.emptyList().iterator();     // Catch: JSONException -> L11
    L9:
        if (r24.hasNext() == false) goto L13;
        String r25 = (String) r24.next();     // Catch: JSONException -> L11
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L11
        r26.put(LynxMonitorService.KEY_CHANNEL, "_jsb_auth." + r25);     // Catch: JSONException -> L11
        r26.put("local_version", 0);     // Catch: JSONException -> L11
        r22.put(r26);     // Catch: JSONException -> L11
        goto L9
    L13:
        JSONObject r27 = new JSONObject();     // Catch: JSONException -> L11
        ul.d r28 = jm.c.f18359c;     // Catch: JSONException -> L11
        if (r28 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("geckoConfigs");     // Catch: JSONException -> L11
        r28 = null;
    L17:
        r27.put(((ul.c) CollectionsKt.first(r28.getAppConfigs())).getAccessKey(p.a()), r22);     // Catch: JSONException -> L11
        r5.put("common", r21);     // Catch: JSONException -> L11
        r5.put("deployment", r27);     // Catch: JSONException -> L11
    L54:
        return null;
    }

    public final void d(JSONObject r10) {
        if (r10 == null) goto L35;
        Iterator<String> r5 = null;
        if (this.f20582a == null) goto L6;
        Intrinsics.checkNotNullParameter(new f9.a(17), "localStorage");
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", STGroup.DICT_KEY);
        String r11 = wl.b.f22870a.getString("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", null);
    L8:
        if (r11 != null) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L29;
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNullParameter(r11, "config");
        if (r11 == null) goto L16;
        JSONObject r13 = new JSONObject(r11);
    L17:
        JSONObject r14 = r13.optJSONObject("packages");
        if (r14 == null) goto L29;
        JSONObject r15 = r10.optJSONObject("packages");
        if (r15 == null) goto L23;
        r5 = r15.keys();
    L23:
        if (r5 == null) goto L27;
        if (r5.hasNext() != true) goto L27;
        String r16 = r5.next();
        r14.put(r16, r15.getJSONArray(r16));
    L27:
        r10 = r13;
        goto L29
    L16:
        r13 = new JSONObject();
    L29:
        if (this.f20582a == null) goto L36;
        String r17 = r10.toString();
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r17, "value");
        wl.b.f22870a.storeString("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", r17);
        return;
    L36:
        return;
    L10:
        r12 = StringsKt.isBlank(r11);
        goto L11
    L6:
        r11 = null;
        goto L8
    }
}
