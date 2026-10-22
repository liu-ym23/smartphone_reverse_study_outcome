package com.obric.memorydata.personalcontext.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AgentRuntimeContextReader$get$1 extends FunctionReferenceImpl implements Function0<List<? extends a.b>> {
    AgentRuntimeContextReader$get$1(Object r8) {
        super(0, r8, a.class, "readMediaSessions", "readMediaSessions()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends a.b> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends a.b> invoke2() {
        return a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.memorydata.plugin"));
    }
}
