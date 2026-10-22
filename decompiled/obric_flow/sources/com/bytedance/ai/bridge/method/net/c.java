package com.bytedance.ai.bridge.method.net;

import ai.j0;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements c2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.f f1872a;

    public c(o1.f r5) {
        this.f1872a = r5;
    }

    @Override // c2.e
    public final void a(Integer r5, LinkedHashMap r10, Throwable r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "throwable");
        String r13 = androidx.room.jarjarred.org.antlr.runtime.a.x(r11, j0.v("Request failed, httpCode: ", r5.intValue(), r12, ", clientCode:", ", message: "));
        KClass r14 = Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.AppletRequestResultModel.class);
        Intrinsics.checkNotNullParameter(r14, "<this>");
        BaseModel r15 = com.lynx.tasm.behavior.ui.utils.e.c(JvmClassMappingKt.getJavaClass(r14));
        AbsAppletRequestMethodIDL.AppletRequestResultModel r16 = (AbsAppletRequestMethodIDL.AppletRequestResultModel) r15;
        r16.setHttpCode(r5);
        r16.setClientCode(Integer.valueOf(r12));
        r16.setHeader(r10);
        Unit r17 = Unit.INSTANCE;
        o1.f r18 = this.f1872a;
        r18.c(r13, (ResultModel) r15);
    }

    @Override // c2.e
    public final void b(String r5, LinkedHashMap r10, Throwable r11, Integer r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "base64Body");
        Intrinsics.checkNotNullParameter(r10, "responseHeader");
        Intrinsics.checkNotNullParameter(r11, "throwable");
        KClass r14 = Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.AppletRequestResultModel.class);
        Intrinsics.checkNotNullParameter(r14, "<this>");
        BaseModel r15 = com.lynx.tasm.behavior.ui.utils.e.c(JvmClassMappingKt.getJavaClass(r14));
        AbsAppletRequestMethodIDL.AppletRequestResultModel r16 = (AbsAppletRequestMethodIDL.AppletRequestResultModel) r15;
        r16.setHttpCode(r12);
        r16.setClientCode(Integer.valueOf(r13));
        r16.setHeader(r10);
        r16.setResponse(r5);
        r16.setResponseType("base64");
        o1.f r17 = this.f1872a;
        r17.b((ResultModel) r15, "");
    }

    @Override // c2.e
    public final void c(Object r5, LinkedHashMap r10, Integer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "responseHeader");
        KClass r13 = Reflection.getOrCreateKotlinClass(AbsAppletRequestMethodIDL.AppletRequestResultModel.class);
        Intrinsics.checkNotNullParameter(r13, "<this>");
        BaseModel r14 = com.lynx.tasm.behavior.ui.utils.e.c(JvmClassMappingKt.getJavaClass(r13));
        AbsAppletRequestMethodIDL.AppletRequestResultModel r15 = (AbsAppletRequestMethodIDL.AppletRequestResultModel) r14;
        r15.setHttpCode(r11);
        r15.setClientCode(Integer.valueOf(r12));
        r15.setHeader(r10);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r15.setResponse(r5);
        o1.f r16 = this.f1872a;
        r16.b((ResultModel) r14, "");
    }
}
