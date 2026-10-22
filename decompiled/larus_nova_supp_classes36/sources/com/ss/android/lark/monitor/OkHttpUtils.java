package com.ss.android.lark.monitor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class OkHttpUtils {
    public OkHttpUtils() {
    }

    public static void insertToOkHttpClientBuilder(List<Interceptor> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        boolean r0 = false;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r1 >= r5.size()) goto L14;
        if ((ListProtector.get(r5, r1) instanceof evc.i) == false) goto L11;
        r2 = r1;
    L11:
        if ((ListProtector.get(r5, r1) instanceof OkHttpMonitorInterceptor) == true) goto L12;
        r1 = r1 + 1;
        goto L6
    L12:
        r0 = true;
    L14:
        if (r0 == true) goto L19;
        ListProtector.add(r5, r2 + 1, new OkHttpMonitorInterceptor());
        return;
    }
}
