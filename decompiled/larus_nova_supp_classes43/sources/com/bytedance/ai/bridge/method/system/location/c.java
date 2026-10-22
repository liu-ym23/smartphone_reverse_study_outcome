package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements r4.c {
    public final /* synthetic */ f3.h<AbsGetLocationMethodIDL.b> a;

    public c(f3.h<AbsGetLocationMethodIDL.b> r1) {
        this.a = r1;
    }

    @Override // r4.c
    public final void b(r4.d r10) {
        Intrinsics.checkNotNullParameter(r10, "locationResult");
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_GetLocationMethod", "call success");
        f3.h<AbsGetLocationMethodIDL.b> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.b.class, "<this>");
        BaseModel r1 = k3.c.a(AbsGetLocationMethodIDL.b.class);
        AbsGetLocationMethodIDL.b r11 = (AbsGetLocationMethodIDL.b) r1;
        r11.setTimestamp(r10.c);
        r11.setLatitude(Double.valueOf(r10.a));
        r11.setLongitude(Double.valueOf(r10.b));
        r11.setSpeed(r10.d);
        r11.setAccuracy(r10.e);
        Boolean r12 = r10.f;
        if (r12 == null) goto L5;
        r11.setLightLocation(Boolean.valueOf(r12.booleanValue()));
    L5:
        f3.h.a.b(r0, (ResultModel) r1);
    }

    @Override // r4.c
    public final void a(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r1 = new StringBuilder("call failed, errNo=");
        f3.a r12 = f3.a.f;
        r1.append(r12.a);
        r1.append(", msg=");
        r1.append(r10);
        r1.append(", errorCode: ");
        r1.append(r11);
        r0.e("AISDK_JSB_GetLocationMethod", r1.toString());
        f3.h<AbsGetLocationMethodIDL.b> r13 = this.a;
        JsonObject r14 = new JsonObject();
        r14.addProperty("errMsg", r10);
        r14.addProperty("errCode", Integer.valueOf(r11));
        Unit r15 = Unit.INSTANCE;
        f3.h.a.a(r13, r10, r12, r14, 2);
    }
}
