package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsRequestMethodIDL;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements b4.h {
    public final /* synthetic */ f3.h<AbsRequestMethodIDL.b> a;
    public final /* synthetic */ RequestMethod b;

    public j(f3.h<AbsRequestMethodIDL.b> r1, RequestMethod r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // b4.h
    public final void b(Object r10, Map<String, String> r11, Integer r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "responseHeader");
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        StringBuilder r0 = new StringBuilder("call success, statusCode=");
        int r1 = -1;
        if (r12 == null) goto L5;
        int r15 = r12.intValue();
    L6:
        r0.append(r15);
        r14.d("AISDK_JSB_RequestMethod", r0.toString());
        f3.h<AbsRequestMethodIDL.b> r16 = this.a;
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.b.class, "<this>");
        BaseModel r17 = k3.c.a(AbsRequestMethodIDL.b.class);
        AbsRequestMethodIDL.b r18 = (AbsRequestMethodIDL.b) r17;
        if (r12 == null) goto L9;
        r1 = r12.intValue();
    L9:
        r18.setStatusCode(r1);
        r18.setHeader(r11);
        r18.setData(r10);
        f3.h.a.b(r16, (ResultModel) r17);
        return;
    L5:
        r15 = -1;
        goto L6
    }

    @Override // b4.h
    public final void c(Integer r10, Map<String, String> r11, Throwable r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "throwable");
        RequestMethod r14 = this.b;
        int r0 = RequestMethod.b;
        r14.getClass();
        int r1 = -408;
        if ((r12 instanceof NetworkNotAvailabeException) == false) goto L5;
        f3.a r15 = f3.a.x;
    L11:
        StringBuilder r16 = new StringBuilder("Request failed, httpCode: ");
        if (r10 == null) goto L14;
        int r17 = r10.intValue();
    L15:
        r16.append(r17);
        r16.append(", message: ");
        r16.append(r12.getMessage());
        String r18 = r16.toString();
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_RequestMethod", "call failed, errNo=" + r15.a + ", msg=" + r15.b + ", errorType=" + r12.getClass().getSimpleName());
        f3.h<AbsRequestMethodIDL.b> r19 = this.a;
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.b.class, "<this>");
        AbsRequestMethodIDL.b r20 = (AbsRequestMethodIDL.b) k3.c.a(AbsRequestMethodIDL.b.class);
        if (r10 == null) goto L18;
        r1 = r10.intValue();
    L18:
        r20.setStatusCode(r1);
        r20.setHeader(r11);
        Unit r21 = Unit.INSTANCE;
        f3.h.a.a(r19, r18, r15, r20.toJson(), 2);
        return;
    L14:
        r17 = -408;
        goto L15
    L5:
        if (r10 != null) goto L8;
    L10:
        r15 = f3.a.y;
        goto L11
    L8:
        if (r10.intValue() != (-408)) goto L10;
        r15 = f3.a.w;
        goto L11
    }

    @Override // b4.h
    public final void a(String r10, Map<String, String> r11, Throwable r12, Integer r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "base64Body");
        Intrinsics.checkNotNullParameter(r11, "responseHeader");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        com.bytedance.ai.utils.g r15 = com.bytedance.ai.utils.g.a;
        StringBuilder r16 = new StringBuilder("call success, statusCode=");
        int r0 = -1;
        if (r13 == null) goto L5;
        int r1 = r13.intValue();
    L6:
        r16.append(r1);
        r16.append(", responseType=base64");
        r15.d("AISDK_JSB_RequestMethod", r16.toString());
        f3.h<AbsRequestMethodIDL.b> r17 = this.a;
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.b.class, "<this>");
        BaseModel r18 = k3.c.a(AbsRequestMethodIDL.b.class);
        AbsRequestMethodIDL.b r19 = (AbsRequestMethodIDL.b) r18;
        if (r13 == null) goto L9;
        r0 = r13.intValue();
    L9:
        r19.setStatusCode(r0);
        r19.setHeader(r11);
        r19.setData(r10);
        f3.h.a.b(r17, (ResultModel) r18);
        return;
    L5:
        r1 = -1;
        goto L6
    }
}
