package com.obric.memorydata.memory.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AILabProvider$call$1$enabled$4 extends FunctionReferenceImpl implements Function0<Boolean> {
    AILabProvider$call$1$enabled$4(Object r8) {
        super(0, r8, AILabProvider.class, "isRecorderProcessCaller", "isRecorderProcessCaller()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(AILabProvider.a((AILabProvider) ZeusTransformUtils.preCheckCast(this.receiver, AILabProvider.class, "com.obric.memorydata.plugin")));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
