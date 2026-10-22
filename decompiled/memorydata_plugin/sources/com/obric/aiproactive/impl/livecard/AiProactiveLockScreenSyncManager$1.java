package com.obric.aiproactive.impl.livecard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AiProactiveLockScreenSyncManager$1 extends FunctionReferenceImpl implements Function1<g, Unit> {
    public static final AiProactiveLockScreenSyncManager$1 INSTANCE = null;

    static {
        INSTANCE = new AiProactiveLockScreenSyncManager$1();
    }

    AiProactiveLockScreenSyncManager$1() {
        super(1, f.class, "syncAiProactiveLockScreenPayload", "syncAiProactiveLockScreenPayload(Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenSyncPayload;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(g r3) {
        invoke2((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(g r1) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        f.a(r1);
    }
}
