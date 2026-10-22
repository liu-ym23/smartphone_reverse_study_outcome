package com.obric.aikernel.middleware.impl.ttnet;

import android.content.Context;
import com.bytedance.ttnet.TTNetInit;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.bytedance.ttnet.d {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public c() {
    }

    @Override // com.bytedance.ttnet.d
    public void a(Context r10, JSONObject r11) {
    }

    @Override // com.bytedance.ttnet.d
    public void b(Context r10, Map<String, ?> r11) {
    }

    @Override // com.bytedance.ttnet.d
    public void c(String r10, JSONObject r11) {
        com.bytedance.apm.c.e(r10, r11);
    }

    @Override // com.bytedance.ttnet.d
    public void d(Context r10, String r11, String r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r12, "labelName");
        Intrinsics.checkNotNullParameter(r13, "extraJson");
        AIKLog.INSTANCE.e("TTNetDepend", "event: " + r11 + " label: " + r12 + " json: " + r13);
    }

    @Override // com.bytedance.ttnet.d
    public void e(String r10) {
    }

    @Override // com.bytedance.ttnet.d
    public String[] f() {
        return new String[]{"tnc3-bjlgy.snssdk.com", "tnc3-alisc1.snssdk.com", "tnc3-aliec2.snssdk.com"};
    }

    @Override // com.bytedance.ttnet.d
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.ttnet.d
    public int getAppId() {
        return AppContext.INSTANCE.getAid();
    }

    @Override // com.bytedance.ttnet.d
    public Context getContext() {
        return AppContext.INSTANCE.getContext();
    }

    @Override // com.bytedance.ttnet.d
    public String h(Context r10, String r11, String r12) {
        return "";
    }

    @Override // com.bytedance.ttnet.d
    public int i(Context r10, String r11, int r12) {
        return 0;
    }

    @Override // com.bytedance.ttnet.d
    public Map<String, String> j() {
        HashMap r10 = new HashMap();
        r10.put("httpdns", "dig.bdurl.net");
        r10.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r10.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r10;
    }

    @Override // com.bytedance.ttnet.d
    public String k() {
        return null;
    }

    @Override // com.bytedance.ttnet.d
    public String l() {
        return "snssdk.com";
    }

    @Override // com.bytedance.ttnet.d
    public ArrayList<String> m() {
        return null;
    }

    @Override // com.bytedance.ttnet.d
    public void onColdStartFinish() {
    }
}
