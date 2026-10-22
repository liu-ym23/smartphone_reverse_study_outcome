package com.bytedance.ai.bridge.method.resource;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;
import n1.c;
import o1.f;
import t2.b;
import u0.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/resource/UpdatePackageMethod;", "Lcom/bytedance/ai/bridge/method/resource/AbsUpdatePackageMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/resource/AbsUpdatePackageMethodIDL$UpdatePackageParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/resource/AbsUpdatePackageMethodIDL$UpdatePackageResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/resource/AbsUpdatePackageMethodIDL$UpdatePackageParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UpdatePackageMethod extends AbsUpdatePackageMethodIDL {
    public UpdatePackageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsUpdatePackageMethodIDL.UpdatePackageParamModel) r10, r11);
    }

    public void handle(c r10, AbsUpdatePackageMethodIDL.UpdatePackageParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        a r13 = s0.a.f21800c;
        if (r13 != null) goto L5;
    L15:
        r12.a("AISDK is NOT initialized");
        Unit r14 = Unit.INSTANCE;
        return;
    L5:
        if (r13.f22200k == false) goto L7;
    L11:
        Object r15 = BuildersKt.launch$default(h0.a(b.f22089a), null, null, new UpdatePackageMethod$handle$1$1(r11, r12, null), 3, null);
    L12:
        if (r15 == null) goto L15;
        return;
    L7:
        if (r13.f22201l == true) goto L11;
        if (CollectionsKt.listOf(new String[]{"inhouse", "auto_test"}).contains(r13.f22197h) == true) goto L11;
        r12.a("current bridge is not allowed in release mode");
        r15 = Unit.INSTANCE;
        goto L12
    }
}
