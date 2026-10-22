package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.apm6.util.constant.NetConst;
import java.util.Iterator;
import java.util.Map;
import okhttp3.r;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes.dex */
public class j implements t {
    public j() {
    }

    @Override // okhttp3.t
    public z a(t.a r10) {
        x r11 = r10.a();
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r11.e().b("x-metasec-bypass-mssdk")) == false) goto L7;
        x.a r12 = r11.h();
        r12.h("x-metasec-bypass-mssdk");
        x r13 = r12.b();
    L6:
        return r10.b(r13);
    L7:
        Map<String, String> r14 = o2.f.Z(r11.l().toString(), r11.e().h());
        Map<String, String> r15 = null;
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r11.e().b("x-tt-oec-opaque-enable")) == false) goto L10;
        r15 = o2.f.X(r11.l().toString(), r11.e().h());
    L10:
        if (r14 != null) goto L14;
        if (r15 != null) goto L14;
        return r10.b(r11);
    L14:
        x.a r16 = new x.a();
        r16.l(r11.l());
        r16.f(r11.g(), r11.a());
        r16.j(r11.j());
        r.a r17 = r11.e().e();
        if (r14 == null) goto L20;
        Iterator<Map.Entry<String, String>> r18 = r14.entrySet().iterator();
    L18:
        if (r18.hasNext() == false) goto L20;
        Map.Entry<String, String> r19 = r18.next();
        r17.a(r19.getKey(), r19.getValue());
    L20:
        if (r15 == null) goto L25;
        Iterator<Map.Entry<String, String>> r20 = r15.entrySet().iterator();
    L23:
        if (r20.hasNext() == false) goto L25;
        Map.Entry<String, String> r21 = r20.next();
        r17.a(r21.getKey(), r21.getValue());
    L25:
        r17.g("x-tt-oec-opaque-enable");
        r16.e(r17.e());
        r13 = r16.b();
        goto L6
    }
}
