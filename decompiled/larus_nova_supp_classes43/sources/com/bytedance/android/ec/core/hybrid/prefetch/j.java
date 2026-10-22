package com.bytedance.android.ec.core.hybrid.prefetch;

import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ NativePrefetch a;
    public final /* synthetic */ String b;
    public final /* synthetic */ t c;

    public j(NativePrefetch r1, String r10, t r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        ConcurrentHashMap<String, NativePrefetch> r0 = NativePrefetchUtil.a;
        StringBuilder r1 = new StringBuilder("end post request failed, api key is ");
        r1.append(this.b);
        r1.append(", error is ");
        String r12 = null;
        if (r11 == null) goto L5;
        String r13 = r11.getMessage();
    L6:
        r1.append(r13);
        NativePrefetchUtil.k("NativePrefetch", r1.toString());
        this.a.w(this.b);
        NativePrefetch r14 = this.a;
        String r15 = this.b;
        r14.getClass();
        r14.D(new o("", 2, "net fail reason is : ".concat(String.valueOf(r11))), r15);
        int r16 = u.a;
        String r17 = this.c.a;
        if (r11 == null) goto L9;
        r12 = r11.getMessage();
    L9:
        u.a(r17, 2001, r12, this.b);
        return;
    L5:
        r13 = null;
        goto L6
    }
}
