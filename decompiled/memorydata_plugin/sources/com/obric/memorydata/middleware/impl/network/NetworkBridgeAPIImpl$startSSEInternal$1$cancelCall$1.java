package com.obric.memorydata.middleware.impl.network;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.retrofit2.Call;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class NetworkBridgeAPIImpl$startSSEInternal$1$cancelCall$1 extends FunctionReferenceImpl implements Function0<Unit> {
    NetworkBridgeAPIImpl$startSSEInternal$1$cancelCall$1(Object r8) {
        super(0, r8, Call.class, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cancel()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((Call) ZeusTransformUtils.preCheckCast(this.receiver, Call.class, "com.obric.memorydata.plugin")).cancel();
    }
}
