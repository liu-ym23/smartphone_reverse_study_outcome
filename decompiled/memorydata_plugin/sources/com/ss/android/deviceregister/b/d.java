package com.ss.android.deviceregister.b;

import android.content.Context;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.common.utility.h;
import com.ss.android.deviceregister.a.u;
import com.ss.android.deviceregister.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class d extends e {
    public d(Context r3, boolean r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    public String a() {
        return this.f15187b.e();
    }

    @Override // com.ss.android.deviceregister.b.e
    public void a(String r6, String r7) {
        if (h.a(r6) == true) goto L24;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        String r1 = i();     // Catch: Exception -> L21
        if (f.f() == true) goto L19;
        String r2 = this.f15187b.e();     // Catch: Exception -> L21
        String r3 = this.f15187b.c();     // Catch: Exception -> L21
        if (h.a(r2) == true) goto L10;
        r0.put(SstLoader.KEY_UDID, r2);     // Catch: Exception -> L21
    L10:
        if (h.a(r3) == true) goto L13;
        r0.put("serial_number", r3);     // Catch: Exception -> L21
    L13:
        if (u.f() == false) goto L19;
        String[] r4 = this.f15187b.d();     // Catch: Exception -> L21
        if (r4 == null) goto L19;
        if (r4.length <= 0) goto L19;
        r0.put("sim_serial_number", Arrays.toString(r4));     // Catch: Exception -> L21
    L19:
        Object r5 = this.f15187b.a();     // Catch: Exception -> L21
        r0.put("old_id", r6);     // Catch: Exception -> L21
        r0.put("new_id", r7);     // Catch: Exception -> L21
        r0.put("openudid", r1);     // Catch: Exception -> L21
        r0.put("clientudid", r5);     // Catch: Exception -> L21
        a("did_change", r0);     // Catch: Exception -> L21
        return;
    L25:
        return;
    }

    public JSONArray b() {
        return this.f15187b.f();
    }

    public String[] c() {
        return this.f15187b.d();
    }

    public String d() {
        return this.f15187b.c();
    }
}
