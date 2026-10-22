package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.location.AbsStopLocationUpdateMethodIDL;
import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements f3.h<AbsStopLocationUpdateMethodIDL.a> {
    public final /* synthetic */ f3.h<AbsStopLocationUpdateMethodIDL.a> a;

    public k(f3.h<AbsStopLocationUpdateMethodIDL.a> r1) {
        this.a = r1;
    }

    @Override // f3.h
    public final void a(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.a.a(r10, r11);
    }

    @Override // f3.h
    public final void b(ResultModel r10, String r11) {
        AbsStopLocationUpdateMethodIDL.a r12 = (AbsStopLocationUpdateMethodIDL.a) r10;
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_StopLocationUpdateMethod", "call success");
        this.a.b(r12, r11);
    }

    @Override // f3.h
    public final void c(String r10, int r11, f3.a r12, JsonObject r13) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        if (r12 != null) goto L5;
        r12 = f3.a.f;
    L5:
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_StopLocationUpdateMethod", "call failed, errNo=" + r12.a + ", msg=" + r10);
        this.a.c(r10, r11, r12, r13);
    }
}
