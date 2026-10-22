package com.obric.assistant.network.restrict;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.obric.assistant.ObricNetworkInterceptConfig;
import com.obric.assistant.t1;
import hm9.s;
import hm9.x;
import hm9.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j implements x {
    public final x a;
    public final ArrayList<String> b;
    public final ArrayList<String> c;
    public final int d;
    public final int e;
    public final int f;

    public j(z r2) {
        this.a = r2;
        t1 r3 = t1.a;
        ObricNetworkInterceptConfig r0 = r3.getObricPowerLockConfig().getObricNetworkInterceptConfig();
        if (r0 == null) goto L6;
        ArrayList<String> r1 = r0.getObricNetworkHostWhiteList();
        if (r1 == null) goto L6;
    L7:
        this.b = r1;
        ObricNetworkInterceptConfig r4 = r3.getObricPowerLockConfig().getObricNetworkInterceptConfig();
        if (r4 == null) goto L11;
        ArrayList<String> r5 = r4.getObricNetworkPathWhiteList();
        if (r5 == null) goto L11;
    L12:
        this.c = r5;
        this.d = 1;
        this.e = 2;
        this.f = 3;
        return;
    L11:
        r5 = new ArrayList();
    L6:
        r1 = new ArrayList();
        goto L7
    }

    public final SsResponse<?> a(Interceptor.Chain r12, s r13) {
        if (r12 == null) goto L8;
        Request r1 = r12.request();
        if (r1 == null) goto L8;
        String r2 = r1.getHost();
        if (r2 == null) goto L8;
    L9:
        if (r12 == null) goto L14;
        Request r3 = r12.request();
        if (r3 == null) goto L14;
        String r4 = r3.getPath();
        if (r4 == null) goto L14;
    L15:
        if (r12 == null) goto L20;
        Request r5 = r12.request();
        if (r5 == null) goto L20;
        String r6 = r5.getHost();
        if (r6 == null) goto L20;
    L21:
        if (r12 == null) goto L26;
        Request r7 = r12.request();
        if (r7 == null) goto L26;
        String r8 = r7.getPath();
        if (r8 == null) goto L26;
    L27:
        ArrayList<String> r9 = this.b;
        boolean r10 = true;
        if ((r9 instanceof Collection) == true) goto L30;
    L32:
        Iterator<T> r11 = r9.iterator();
    L34:
        if (r11.hasNext() == false) goto L41;
        String r14 = (String) r11.next();
        if (r14 != null) goto L39;
        r14 = "";
    L39:
        if (StringsKt.contains$default(r6, r14, false, 2, null) == false) goto L34;
        boolean r15 = true;
    L42:
        if (r15 == false) goto L44;
        int r0 = this.e;
    L63:
        if (r0 == this.f) goto L71;
        if (r13 == null) goto L66;
        r13.e(r2, r4, Integer.valueOf(r0));
    L66:
        if (r13 == null) goto L68;
        s.b(r13, "BackgroundNetworkInterceptor#ObricNetworkWhitelistHandler", "[ObricNetworkWhitelistHandler]No need continue process current path or host is in white list " + r4 + ' ' + r2 + ",\n path allow list  :" + this.c + "\n host allow list  :" + this.b + '\n');
    L68:
        if (r12 != null) goto L70;
        return null;
    L70:
        return r12.proceed(r12.request());
    L71:
        if (r13 == null) goto L73;
        s.b(r13, "BackgroundNetworkInterceptor#ObricNetworkWhitelistHandler", "[WhitelistHandler]No need continue just block this request " + r4 + "  " + r2 + ",\n path allow list  :" + this.c + "\n host allow list  :" + this.b + '\n');
    L73:
        x r16 = this.a;
        if (r16 != null) goto L76;
        return null;
    L76:
        return r16.a(r12, r13);
    L44:
        ArrayList<String> r17 = this.c;
        if ((r17 instanceof Collection) == true) goto L47;
    L49:
        Iterator<T> r18 = r17.iterator();
    L51:
        if (r18.hasNext() == false) goto L58;
        String r19 = (String) r18.next();
        if (r19 != null) goto L56;
        r19 = "";
    L56:
        if (StringsKt.contains$default(r8, r19, false, 2, null) == false) goto L51;
    L59:
        if (r10 == false) goto L61;
        r0 = this.d;
        goto L63
    L61:
        r0 = this.f;
    L58:
        r10 = false;
        goto L59
    L47:
        if (r17.isEmpty() == false) goto L49;
    L41:
        r15 = false;
        goto L42
    L30:
        if (r9.isEmpty() == false) goto L32;
    L26:
        r8 = "";
    L20:
        r6 = "";
    L14:
        r4 = "";
    L8:
        r2 = "";
        goto L9
    }
}
