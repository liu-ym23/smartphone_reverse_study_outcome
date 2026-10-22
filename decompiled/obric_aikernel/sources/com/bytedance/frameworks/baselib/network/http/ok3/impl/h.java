package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.apm6.util.constant.NetConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes.dex */
public class h implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f1693a;

    public interface a {
        void a(String r10, String r11, Map<String, List<String>> r12, String r13);
    }

    static {
    }

    public h() {
    }

    @Override // okhttp3.t
    public z a(t.a r10) {
        x r11 = r10.a();
        if (r11 != null) goto L5;
    L9:
        boolean r12 = false;
    L10:
        ArrayList r13 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r14 = r11.e().h().entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L20;
        String r15 = r14.next().getKey();
        if (r15.equals("x-tt-bypass-dp") == false) goto L17;
        if (r12 == false) goto L17;
    L18:
        r13.add(r15);
    L17:
        if (r15.startsWith("x-metasec") == false) goto L12;
    L20:
        if (r13.size() <= 0) goto L27;
        x.a r16 = r11.h();
        Iterator r17 = r13.iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        r16.h((String) r17.next());
        goto L23
    L25:
        r11 = r16.b();
    L27:
        if (f1693a == null) goto L30;
        f1693a.a(r11.g(), r11.l().toString(), r11.e().h(), "");
    L30:
        return r10.b(r11);
    L5:
        if (r11.e() == null) goto L9;
        if (r11.e().b("x-metasec-bypass-ttnet-features") == null) goto L9;
        r12 = NetConst.ENCRYPT_VERISON_CODE.equals(r11.e().b("x-metasec-bypass-ttnet-features"));
        goto L10
    }
}
