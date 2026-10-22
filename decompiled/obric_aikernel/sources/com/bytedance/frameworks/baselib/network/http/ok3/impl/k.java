package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes.dex */
public class k implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f1774a;

    public interface a {
        boolean a(String r10, String r11, Map<String, List<String>> r12, String r13);
    }

    static {
    }

    public k() {
    }

    @Override // okhttp3.t
    public z a(t.a r10) {
        x r11 = r10.a();
        if (f1774a == null) goto L12;
        if ("/get_domains/v5/".equals(r11.l().d()) == false) goto L12;
        if (f1774a.a(r11.g(), r11.l().toString(), r11.e().h(), "") == true) goto L12;
        throw new IOException("TNC requsest dropped by sandbox");
    L12:
        return r10.b(r11);
    }
}
