package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/CloseMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCloseMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloseMethod.kt\ncom/bytedance/ai/bridge/method/router/CloseMethod\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,30:1\n1863#2,2:31\n*S KotlinDebug\n*F\n+ 1 CloseMethod.kt\ncom/bytedance/ai/bridge/method/router/CloseMethod\n*L\n19#1:31,2\n*E\n"})
public final class CloseMethod extends AbsCloseMethodIDL {
    public CloseMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsCloseMethodIDL.CloseParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsCloseMethodIDL.CloseParamModel r10, o1.f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        r10.getContainerID();
        List<String> r12 = r10.getContainerIDs();
        r10.getAnimated();
        if (r12 != null) goto L5;
    L10:
        Intrinsics.checkNotNullParameter(AbsCloseMethodIDL.CloseResultModel.class, "<this>");
        r11.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsCloseMethodIDL.CloseResultModel.class), "");
        return;
    L5:
        if ((!r12.isEmpty()) != true) goto L10;
        Iterator<T> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        String r14 = (String) r13.next();
        goto L8
    }
}
