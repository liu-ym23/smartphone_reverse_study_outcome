package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsRequestMethodIDL;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements c2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.f f1881a;

    public g(o1.f r5) {
        this.f1881a = r5;
    }

    @Override // c2.e
    public final void a(Integer r5, LinkedHashMap r10, Throwable r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "throwable");
        String r13 = "Request failed, httpCode: " + r5.intValue() + ", message: " + r11.getMessage();
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.RequestResultModel.class, "<this>");
        BaseModel r14 = com.lynx.tasm.behavior.ui.utils.e.c(AbsRequestMethodIDL.RequestResultModel.class);
        AbsRequestMethodIDL.RequestResultModel r15 = (AbsRequestMethodIDL.RequestResultModel) r14;
        r15.setStatusCode(r5.intValue());
        r15.setHeader(r10);
        Unit r16 = Unit.INSTANCE;
        this.f1881a.c(r13, (ResultModel) r14);
    }

    @Override // c2.e
    public final void b(String r5, LinkedHashMap r10, Throwable r11, Integer r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "base64Body");
        Intrinsics.checkNotNullParameter(r10, "responseHeader");
        Intrinsics.checkNotNullParameter(r11, "throwable");
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.RequestResultModel.class, "<this>");
        BaseModel r14 = com.lynx.tasm.behavior.ui.utils.e.c(AbsRequestMethodIDL.RequestResultModel.class);
        AbsRequestMethodIDL.RequestResultModel r15 = (AbsRequestMethodIDL.RequestResultModel) r14;
        r15.setStatusCode(r12.intValue());
        r15.setHeader(r10);
        r15.setData(r5);
        o1.f r16 = this.f1881a;
        r16.b((ResultModel) r14, "");
    }

    @Override // c2.e
    public final void c(Object r5, LinkedHashMap r10, Integer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "responseHeader");
        Intrinsics.checkNotNullParameter(AbsRequestMethodIDL.RequestResultModel.class, "<this>");
        BaseModel r13 = com.lynx.tasm.behavior.ui.utils.e.c(AbsRequestMethodIDL.RequestResultModel.class);
        AbsRequestMethodIDL.RequestResultModel r14 = (AbsRequestMethodIDL.RequestResultModel) r13;
        r14.setStatusCode(r11.intValue());
        r14.setHeader(r10);
        r14.setData(r5);
        o1.f r15 = this.f1881a;
        r15.b((ResultModel) r13, "");
    }
}
