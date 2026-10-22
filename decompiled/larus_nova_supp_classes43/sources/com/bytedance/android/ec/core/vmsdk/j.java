package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ p a;
    public final /* synthetic */ p.d b;

    public /* synthetic */ j(p r1, p.d r10) {
        this.a = r1;
        this.b = r10;
    }

    public final Object invoke(Object r11) {
        p r0 = this.a;
        p.d r1 = this.b;
        Response r12 = (Response) r11;
        r0.getClass();
        if (r12 == null) goto L26;
        byte[] r10 = r12.j();
        if (r10 == null) goto L25;
        String r13 = r12.c();
        if (r10.length > 0) goto L29;
    L16:
        String r14 = null;
    L17:
        if (r14 == null) goto L25;
        if (r14.isEmpty() == true) goto L25;
        String r15 = r12.g(r12.u);
        ResourceFrom r16 = r12.u;
        if (r16 != ResourceFrom.GECKO) goto L23;
        boolean r17 = true;
    L24:
        r1.a(r14, r15, null, r17, r12.g(r16), r12.B);
    L28:
        return null;
    L23:
        r17 = false;
        goto L24
    L29:
        if (r13 != null) goto L11;
    L12:
        r13 = "utf-8";
    L13:
        r14 = new String(r10, r13);     // Catch: Exception -> L15
        goto L17
    L11:
        if (r13.isEmpty() == false) goto L13;
    L25:
        String r18 = r12.s.toString();
    L27:
        r1.a(null, null, r18, false, "", 0);
        goto L28
    L26:
        r18 = null;
        goto L27
    }
}
