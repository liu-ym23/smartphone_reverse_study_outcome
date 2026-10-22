package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b4.h {
    public final /* synthetic */ f3.h<AbsAppletRequestMethodIDL.b> a;

    public a(f3.h<AbsAppletRequestMethodIDL.b> r1) {
        this.a = r1;
    }

    @Override // b4.h
    public final void b(Object r10, Map<String, String> r11, Integer r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "responseHeader");
        f3.h<AbsAppletRequestMethodIDL.b> r0 = this.a;
        BaseModel r1 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.b.class));
        AbsAppletRequestMethodIDL.b r14 = (AbsAppletRequestMethodIDL.b) r1;
        if (r12 != null) goto L6;
        r12 = -1;
    L6:
        r14.setHttpCode(r12);
        r14.setClientCode(Integer.valueOf(r13));
        r14.setHeader(r11);
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        r14.setResponse(r10);
        f3.h.a.b(r0, (ResultModel) r1);
    }

    @Override // b4.h
    public final void c(Integer r10, Map<String, String> r11, Throwable r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "throwable");
        if (r10 == null) goto L5;
        int r14 = r10.intValue();
    L6:
        f3.h<AbsAppletRequestMethodIDL.b> r0 = this.a;
        String r15 = "Request failed, httpCode: " + r14 + ", clientCode:" + r13 + ", message: " + r12.getMessage();
        AbsAppletRequestMethodIDL.b r1 = (AbsAppletRequestMethodIDL.b) k3.a.b(Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.b.class));
        r1.setHttpCode(Integer.valueOf(r14));
        r1.setClientCode(Integer.valueOf(r13));
        r1.setHeader(r11);
        Unit r16 = Unit.INSTANCE;
        f3.h.a.a(r0, r15, null, r1.toJson(), 6);
        return;
    L5:
        r14 = -408;
        goto L6
    }

    @Override // b4.h
    public final void a(String r10, Map<String, String> r11, Throwable r12, Integer r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "base64Body");
        Intrinsics.checkNotNullParameter(r11, "responseHeader");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        f3.h<AbsAppletRequestMethodIDL.b> r15 = this.a;
        BaseModel r0 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.b.class));
        AbsAppletRequestMethodIDL.b r1 = (AbsAppletRequestMethodIDL.b) r0;
        if (r13 != null) goto L6;
        r13 = -1;
    L6:
        r1.setHttpCode(r13);
        r1.setClientCode(Integer.valueOf(r14));
        r1.setHeader(r11);
        r1.setResponse(r10);
        r1.setResponseType("base64");
        f3.h.a.b(r15, (ResultModel) r0);
    }
}
