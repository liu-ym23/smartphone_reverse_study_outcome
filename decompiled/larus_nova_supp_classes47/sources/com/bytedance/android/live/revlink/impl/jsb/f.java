package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.GetAnchorLinkInfoResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;
import w20.i9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends wy0.b<i9, GetAnchorLinkInfoResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public f(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(i9.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r2, CallContext r3) {
        i9 r4 = (i9) r2;
        Intrinsics.checkNotNullParameter(r4, "param");
        Intrinsics.checkNotNullParameter(r3, "callContext");
        GetAnchorLinkInfoResultModel r5 = new GetAnchorLinkInfoResultModel();
        r5.a(GetAnchorLinkInfoResultModel.Code.Success);
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = r0.Do();
    L6:
        if (r1 == null) goto L11;
        JSONObject r6 = r1.hn(CollectionsKt.toList(r4.getData()));
        if (r6 == null) goto L11;
        String r7 = r6.toString();
        if (r7 == null) goto L11;
    L12:
        r5.b(r7);
        finishWithResult(r5);
        return;
    L11:
        r7 = "";
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
