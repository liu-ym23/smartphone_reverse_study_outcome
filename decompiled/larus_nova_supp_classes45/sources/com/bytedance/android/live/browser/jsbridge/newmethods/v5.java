package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v5 {
    public static final ExecutorService a = null;

    @XBridgeMethod(biz = "webcast", name = "getStorage")
    public static class a extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public a() {
        }

        public final Object invoke(Object r7, CallContext r8) throws Exception {
            JSONObject r9 = (JSONObject) r7;
            JSONObject r0 = new JSONObject();
            String r1 = r9.optString("fileName", "");
            if (TextUtils.isEmpty(r1) == false) goto L5;
            ExecutorService r2 = v5.a;
            SharedPreferences r11 = r8.getContext().getSharedPreferences("js_kv_methods_20191113", 0);
        L7:
            if (TextUtils.equals(r9.optString("type", ""), "all") == false) goto L20;
            Map<String, ?> r12 = r11.getAll();
            JSONObject r3 = new JSONObject();
            if (r12 != null) goto L11;
        L19:
            r0.put("value", r3);
        L21:
            r0.put("code", 1);
            return r0;
        L11:
            if (r12.isEmpty() == true) goto L19;
            Iterator<String> r13 = r12.keySet().iterator();
        L14:
            if (r13.hasNext() == false) goto L19;
            String r4 = r13.next();
            if (r4 == null) goto L14;
            r3.put(r4.toString(), r11.getString(r4.toString(), ""));
            goto L14
        L20:
            r0.put("value", r11.getString(r9.optString("key"), ""));
            goto L21
        L5:
            ExecutorService r5 = v5.a;
            r11 = r8.getContext().getSharedPreferences(r1, 0);
            goto L7
        }
    }

    @XBridgeMethod(biz = "webcast", name = "removeStorage")
    public static class b extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public b() {
        }

        public final Object invoke(Object r3, CallContext r4) throws Exception {
            JSONObject r5 = (JSONObject) r3;
            boolean r0 = TextUtils.equals(r5.optString("type", ""), "all");
            JSONObject r1 = new JSONObject();
            if (r0 == false) goto L5;
            v5.a(r4).clear().apply();
        L6:
            r1.put("code", 1);
            return r1;
        L5:
            String r6 = r5.optString("key");
            v5.a(r4).remove(r6).apply();
            goto L6
        }
    }

    @XBridgeMethod(biz = "webcast", name = "setStorage")
    public static class c extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public c() {
        }

        public final Object invoke(Object r3, CallContext r4) throws Exception {
            JSONObject r5 = (JSONObject) r3;
            String r0 = r5.optString("key");
            String r6 = r5.optString("value");
            v5.a(r4).putString(r0, r6).apply();
            JSONObject r7 = new JSONObject();
            r7.put("code", 1);
            return r7;
        }
    }

    public static class d extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
        public final void onTerminate() {
        }

        public d() {
        }

        public final void invoke(Object r4, final CallContext r5) throws Exception {
            JSONObject r6 = (JSONObject) r4;
            final String r0 = r6.optString("key");
            final String r7 = r6.optString("value");
            v5.a.submit(new w5(this, r5, r0, r7));
        }
    }

    static {
        a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ods/KVMethods"));
    }

    public static SharedPreferences.Editor a(CallContext r2) {
        return r2.getContext().getSharedPreferences("js_kv_methods_20191113", 0).edit();
    }
}
