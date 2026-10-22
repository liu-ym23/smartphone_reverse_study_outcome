package com.bytedance.ai.bridge.method.router;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenMethod extends AbsOpenMethodIDL {
    public OpenMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r17, ParamModel r18, f3.h r19) {
        AbsOpenMethodIDL.b r10 = (AbsOpenMethodIDL.b) r18;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        Activity r11 = r17.getOwnerActivity();
        if (r11 != null) goto L7;
        r11 = f2.k.b();
        if (r11 != null) goto L7;
        f3.h.a.a(r19, "context not provided in host", null, null, 14);
        return;
    L7:
        String r12 = r10.getSchema();
        boolean r13 = r10.getReplace();
        boolean r14 = r10.getUseSysBrowser();
        String r15 = r10.getReplaceType();
        boolean r16 = true;
        boolean r110 = false;
        if (r12.length() != 0) goto L10;
        boolean r20 = true;
    L11:
        if (r20 == false) goto L13;
        f3.h.a.a(r19, "schema should not be empty", null, null, 14);
        return;
    L13:
        Map<String, ? extends Object> r21 = MapsKt.mapOf(TuplesKt.to("useSysBrowser", Boolean.valueOf(r14)));
        r4.j r22 = r4.a.j;
        if (r13 == true) goto L20;
        if (r22 == null) goto L17;
        r110 = r22.openSchema(r17, r12, r21, r11);
    L17:
        if (r110 == false) goto L19;
        Intrinsics.checkNotNullParameter(AbsOpenMethodIDL.c.class, "<this>");
        r19.b((ResultModel) k3.c.a(AbsOpenMethodIDL.c.class), "");
        return;
    L19:
        f3.h.a.a(r19, "Failed to open schema: ".concat(r12), null, null, 14);
        return;
    L20:
        int r23 = r15.hashCode();
        if (r23 == (-1465864472)) goto L43;
        if (r23 == 169053298) goto L36;
        if (r23 == 2116215581) goto L28;
    L52:
        r16 = false;
    L53:
        if (r16 == false) goto L55;
        Intrinsics.checkNotNullParameter(AbsOpenMethodIDL.c.class, "<this>");
        r19.b((ResultModel) k3.c.a(AbsOpenMethodIDL.c.class), "");
        return;
    L55:
        f3.h.a.a(r19, "Failed to open schema: ".concat(r12), null, null, 14);
        return;
    L28:
        if (r15.equals("alwaysCloseAfterOpen") == false) goto L52;
        if (r22 == null) goto L32;
        r16 = r22.openSchema(r17, r12, r21, r11);
    L33:
        if (r22 == null) goto L53;
        r22.closeView(r17, null, false);
        goto L53
    L32:
        r16 = false;
        goto L33
    L36:
        if (r15.equals("alwaysCloseBeforeOpen") == false) goto L52;
        if (r22 == null) goto L40;
        r22.closeView(r17, null, false);
    L40:
        if (r22 == null) goto L52;
        r16 = r22.openSchema(r17, r12, r21, r11);
        goto L53
    L43:
        if (r15.equals("onlyCloseAfterOpenSucceed") == false) goto L52;
        if (r22 != null) goto L47;
    L49:
        boolean r24 = false;
    L50:
        if (r24 == false) goto L52;
        r4.j.a.a(r22, r17);
        goto L53
    L47:
        if (r22.openSchema(r17, r12, r21, r11) != true) goto L49;
        r24 = true;
        goto L50
    L10:
        r20 = false;
        goto L11
    }
}
