package com.bytedance.ai.bridge.method.storage;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.storage.AbsSetStorageMethodIDL;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/storage/SetStorageMethod;", "Lcom/bytedance/ai/bridge/storage/AbsSetStorageMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/storage/AbsSetStorageMethodIDL$SetStorageParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/storage/AbsSetStorageMethodIDL$EmptyMessageModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/storage/AbsSetStorageMethodIDL$SetStorageParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetStorageMethod extends AbsSetStorageMethodIDL {
    public SetStorageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSetStorageMethodIDL.SetStorageParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(c r10, AbsSetStorageMethodIDL.SetStorageParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        j r5 = (j) ((a) r10).b(j.class);
        if (r5 == null) goto L5;
        String r13 = r5.b();
    L6:
        Intrinsics.checkNotNull(r13);
        String r14 = r11.getKey();
        String r15 = r11.getData();
        t r16 = d.g(r10, new d2.a(r13, r14, r15));
        if (r16 != null) goto L10;
        r12.a("storage internal error");
        return;
    L10:
        r16.d("default", r14, r15, true, null);
        Intrinsics.checkNotNullParameter(AbsSetStorageMethodIDL.EmptyMessageModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsSetStorageMethodIDL.EmptyMessageModel.class), "");
        return;
    L5:
        r13 = null;
        goto L6
    }
}
