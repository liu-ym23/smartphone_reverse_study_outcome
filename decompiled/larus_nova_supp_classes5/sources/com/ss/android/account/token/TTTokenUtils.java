package com.ss.android.account.token;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.sdk.account.settings.common.a;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.token.o;
import gra.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TTTokenUtils {
    public static final AtomicBoolean a = null;

    public TTTokenUtils() {
    }

    static {
        a = new AtomicBoolean(false);
    }

    public static void addTokenInterceptor() {
        if (a.compareAndSet(false, true) == false) goto L11;
        RetrofitUtils.addInterceptor(b.a.a);
        a.a();
        if (a.p == true) goto L8;
        a.a();
        if (a.q == true) goto L8;
    L9:
        tb7.a.a("TTTokenUtils", "call addTokenInterceptor");
        return;
    L8:
        NetworkParams.setRetryForAccountRequestCallback(new gra.a());
        goto L9
    }

    public static List<o> a(List<Header> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L28;
        ArrayList r0 = new ArrayList();
        Iterator<Header> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L16;
        Header r1 = r5.next();
        if (r1 == null) goto L8;
        if (TextUtils.isEmpty(r1.getName()) == true) goto L8;
        if (TextUtils.isEmpty(r1.getValue()) == true) goto L8;
        r0.add(new o(r1.getName(), r1.getValue()));
        goto L8
    L16:
        return r0;
    L28:
        return null;
    }
}
