package com.bytedance.ai.bridge.method.datamanager;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.lynx.tasm.t;
import com.lynx.tasm.utils.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m2.a;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AIStorageUnSubscribeMethodV2;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL$UnSubscribeStorageParam;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL$UnSubscribeStorageResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL$UnSubscribeStorageParam;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIStorageUnSubscribeMethodV2 extends AbsUnSubscribeStorageMethodIDL {
    public AIStorageUnSubscribeMethodV2() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsUnSubscribeStorageMethodIDL.UnSubscribeStorageParam) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(c r10, AbsUnSubscribeStorageMethodIDL.UnSubscribeStorageParam r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r11.getGroupId().length() != 0) goto L7;
        r12.a("no group id");
        return;
    L7:
        if (r11.isShared() == true) goto L10;
        Intrinsics.checkNotNullParameter(AbsUnSubscribeStorageMethodIDL.UnSubscribeStorageResultModal.class, "<this>");
        r12.b((ResultModel) e.c(AbsUnSubscribeStorageMethodIDL.UnSubscribeStorageResultModal.class), "");
        return;
    L10:
        a r13 = d.j(r10);
        if (r13 != null) goto L14;
        r12.a("no find AiContainer");
        return;
    L14:
        t r14 = d.g(r10, r11);
        if (r14 != null) goto L18;
        r12.a("no find ViewModel");
        return;
    L18:
        String r5 = r14.b(r11.getGroupId(), r11.getStorageId());
        m2.c r15 = new m2.c(r5, r11.getKey(), r11.isPersist(), new WeakReference(r13));
        Intrinsics.checkNotNullParameter(r15, "subscriber");
        String r16 = "unSubscribeStorageItem=" + r15;
        Intrinsics.checkNotNullParameter("AIStorageItem", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L21;
        r17.d("AIStorageItem", r16);
    L21:
        CopyOnWriteArrayList r18 = (CopyOnWriteArrayList) ((ConcurrentHashMap) ((Lazy) r14.f).getValue()).get(r5);
        if (r18 == null) goto L24;
        r18.remove(r15);
    L24:
        Intrinsics.checkNotNullParameter(AbsUnSubscribeStorageMethodIDL.UnSubscribeStorageResultModal.class, "<this>");
        r12.b((ResultModel) e.c(AbsUnSubscribeStorageMethodIDL.UnSubscribeStorageResultModal.class), "");
    }
}
