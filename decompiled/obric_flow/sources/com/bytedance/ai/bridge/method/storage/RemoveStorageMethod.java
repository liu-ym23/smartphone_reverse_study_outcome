package com.bytedance.ai.bridge.method.storage;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.storage.AbsRemoveStorageMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.lynx.tasm.t;
import com.lynx.tasm.utils.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.a;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/storage/RemoveStorageMethod;", "Lcom/bytedance/ai/bridge/storage/AbsRemoveStorageMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/storage/AbsRemoveStorageMethodIDL$RemoveStorageParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/storage/AbsRemoveStorageMethodIDL$EmptyMessageModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/storage/AbsRemoveStorageMethodIDL$RemoveStorageParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RemoveStorageMethod extends AbsRemoveStorageMethodIDL {
    public RemoveStorageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsRemoveStorageMethodIDL.RemoveStorageParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(c r5, AbsRemoveStorageMethodIDL.RemoveStorageParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        j r12 = (j) ((a) r5).b(j.class);
        if (r12 == null) goto L5;
        String r13 = r12.b();
    L6:
        Intrinsics.checkNotNull(r13);
        String r14 = r10.getKey();
        t r15 = d.g(r5, new d2.a(r13, r14, null));
        if (r15 != null) goto L10;
        r11.a("storage internal error");
        return;
    L10:
        r15.g("default", r14, null, true);
        Intrinsics.checkNotNullParameter(AbsRemoveStorageMethodIDL.EmptyMessageModel.class, "<this>");
        r11.b((ResultModel) e.c(AbsRemoveStorageMethodIDL.EmptyMessageModel.class), "");
        return;
    L5:
        r13 = null;
        goto L6
    }
}
