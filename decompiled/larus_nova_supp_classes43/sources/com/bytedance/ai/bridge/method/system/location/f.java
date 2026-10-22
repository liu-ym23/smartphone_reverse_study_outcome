package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.location.AbsStartLocationUpdateMethodIDL;
import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements f3.h<AbsStartLocationUpdateMethodIDL.a> {
    public final /* synthetic */ f3.h<AbsStartLocationUpdateMethodIDL.a> a;
    public final /* synthetic */ LocationUpdateManager b;
    public final /* synthetic */ int c;

    @Override // f3.h
    public final void a(String r1, Object r10) {
        Intrinsics.checkNotNullParameter(r1, "key");
    }

    @Override // f3.h
    public final void b(ResultModel r10, String r11) {
        AbsStartLocationUpdateMethodIDL.a r12 = (AbsStartLocationUpdateMethodIDL.a) r10;
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.b(r12, r11);
    }

    public f(j r1, LocationUpdateManager r10, int r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // f3.h
    public final void c(String r10, int r11, f3.a r12, JsonObject r13) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        this.b.d(this.c);
        this.a.c(r10, r11, r12, r13);
    }
}
