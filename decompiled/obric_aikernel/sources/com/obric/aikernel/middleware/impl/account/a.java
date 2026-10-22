package com.obric.aikernel.middleware.impl.account;

import android.text.TextUtils;
import com.bytedance.retrofit2.a0;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n4.b;
import n4.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements q4.a {
    public a() {
    }

    @Override // q4.a
    public a0<?> a(q4.a.InterfaceC0283a r10) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        c r11 = r10.a();
        String r12 = new URI(r11.G()).getHost();
        Intrinsics.checkNotNullExpressionValue(r12, "URI(request.url).host");
        Locale r13 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r13, "getDefault()");
        String r14 = r12.toLowerCase(r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toLowerCase(locale)");
        ArrayList r15 = new ArrayList();
        List<b> r16 = r11.v();
        Intrinsics.checkNotNullExpressionValue(r16, "request.headers");
        r15.addAll(r16);
        Iterator<T> r17 = com.obric.aikernel.middleware.api.account.OAccountInitManager.INSTANCE.addTokenHost().iterator();
        Map<String, String> r18 = null;
    L4:
        if (r17.hasNext() == false) goto L8;
        String r19 = ((String) r17.next()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r19, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (StringsKt.endsWith$default(r14, r19, false, 2, null) == false) goto L4;
        r18 = com.obric.aikernel.middleware.api.account.OAccountInitManager.INSTANCE.xttTokenMap();
        goto L4
    L8:
        if (r18 != null) goto L10;
    L19:
        a0<?> r20 = r10.c(r11.O().b(r15).a());
        Intrinsics.checkNotNullExpressionValue(r20, "chain.proceed(request.ne…headers(headers).build())");
        return r20;
    L10:
        if (r18.isEmpty() == true) goto L19;
        Iterator<Map.Entry<String, String>> r21 = r18.entrySet().iterator();
    L13:
        if (r21.hasNext() == false) goto L19;
        Map.Entry<String, String> r22 = r21.next();
        if (TextUtils.isEmpty(r22.getKey()) == true) goto L13;
        if (TextUtils.isEmpty(r22.getValue()) == true) goto L13;
        r15.add(new b(r22.getKey(), r22.getValue()));
        goto L13
    }
}
