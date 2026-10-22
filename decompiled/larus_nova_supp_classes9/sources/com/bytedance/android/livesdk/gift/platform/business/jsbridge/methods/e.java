package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.a1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends a<JsonObject, LiveGetGiftCommonInitDataResultModel> {
    public final com.bytedance.android.scope.j a;

    public e(com.bytedance.android.scope.j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter((JsonObject) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        LiveGetGiftCommonInitDataResultModel r6 = new LiveGetGiftCommonInitDataResultModel();
        r6.b(LiveGetGiftCommonInitDataResultModel.Code.Success);
        i12.e r7 = i12.o.b();
        Number r0 = null;
        if (r7 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r8 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(a1.class));
    L6:
        a1 r9 = (a1) r8;
        r6.c(new LiveGetGiftCommonInitDataResultModel.a());
        LiveGetGiftCommonInitDataResultModel.a r1 = r6.a();
        if (r1 == null) goto L12;
        if (r9 == null) goto L10;
        Number r2 = r9.a();
    L11:
        r1.a(r2);
        goto L12
    L10:
        r2 = null;
    L12:
        LiveGetGiftCommonInitDataResultModel.a r3 = r6.a();
        if (r3 == null) goto L17;
        if (r9 == null) goto L16;
        r0 = a1.c();
    L16:
        r3.b(r0);
    L17:
        return r6;
    L5:
        r8 = null;
        goto L6
    }
}
