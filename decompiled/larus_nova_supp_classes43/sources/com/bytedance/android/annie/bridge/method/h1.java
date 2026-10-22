package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h1<T, R> implements Function {
    public final /* synthetic */ e7.p0 a;
    public final /* synthetic */ CallContext b;

    public h1(e7.p0 r1, CallContext r10) {
        this.a = r1;
        this.b = r10;
    }

    public final Object apply(Object r10) {
        Intrinsics.checkNotNullParameter((Integer) r10, "it");
        String r1 = this.a.b();
        JsonObject r11 = this.a.c();
        if (r11 == null) goto L5;
        JSONObject r12 = tv5.a.c(r11);
    L6:
        String r13 = this.b.a();
        if (Intrinsics.areEqual(this.a.a(), "web") == false) goto L9;
        IHybridComponent.HybridType r14 = IHybridComponent.HybridType.H5;
    L10:
        IHybridComponent.HybridType r15 = r14;
        y9.m r16 = com.bytedance.android.annie.resource.n.a;
        Intrinsics.checkNotNullParameter("jsb", "source");
        Intrinsics.checkNotNullParameter(r13, "bizKey");
        Intrinsics.checkNotNullParameter(r15, "hybridType");
        return Integer.valueOf(((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).m(r1, r12, "jsb", null, null, r15, r13, !com.bytedance.android.annie.resource.n.f(r1)));
    L9:
        r14 = IHybridComponent.HybridType.LYNX;
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}
