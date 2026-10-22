package com.obric.aiproactive.impl.bridge;

import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class OkHttpRemoteArtifactTransport$toRemoteArtifactResponse$1 extends FunctionReferenceImpl implements Function0<Unit> {
    OkHttpRemoteArtifactTransport$toRemoteArtifactResponse$1(Object r8) {
        super(0, r8, Response.class, IslandSession.REOPEN_VALUE_CLOSE, "close()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((Response) ZeusTransformUtils.preCheckCast(this.receiver, Response.class, "com.obric.memorydata.plugin")).close();
    }
}
