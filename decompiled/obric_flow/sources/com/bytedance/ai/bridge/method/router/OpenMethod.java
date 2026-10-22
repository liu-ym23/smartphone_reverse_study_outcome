package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenMethod extends AbsOpenMethodIDL {
    public OpenMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsOpenMethodIDL.OpenParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsOpenMethodIDL.OpenParamModel r10, o1.f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (((n1.a) r5).d() == null) goto L5;
    L8:
        String r12 = r10.getSchema();
        boolean r13 = r10.getReplace();
        boolean r14 = r10.getUseSysBrowser();
        String r15 = r10.getReplaceType();
        if (r12.length() != 0) goto L12;
        r11.a("schema should not be empty");
        return;
    L12:
        MapsKt.mapOf(TuplesKt.to(AbsOpenMethodIDL.PARAM_KEY_USE_SYS_BROWSER, Boolean.valueOf(r14)));
        if (r13 == true) goto L16;
        r11.a("Failed to open schema: ".concat(r12));
        return;
    L16:
        int r16 = r15.hashCode();
        if (r16 != (-1465864472)) goto L19;
        r15.equals(AbsOpenMethodIDL.OpenParamModel.OPEN_REPLACE_TYPE_ONLY_CLOSE_AFTER_OPEN_SUCCEED);
    L27:
        r11.a("Failed to open schema: ".concat(r12));
        return;
    L19:
        if (r16 != 169053298) goto L21;
        String r17 = AbsOpenMethodIDL.OpenParamModel.OPEN_REPLACE_TYPE_ALWAYS_CLOSE_BEFORE_OPEN;
    L24:
        r15.equals(r17);
        goto L27
    L21:
        if (r16 != 2116215581) goto L27;
        r17 = AbsOpenMethodIDL.OpenParamModel.OPEN_REPLACE_TYPE_ALWAYS_CLOSE_AFTER_OPEN;
        goto L24
    L5:
        if (s0.c.b() != null) goto L8;
        r11.a("context not provided in host");
    }
}
