package com.obric.memorydata.memory.review.trace;

import com.obric.memorydata.middleware.api.bridge.AuditoryBridgeAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemoryTraceReportHotwordsReader$1 extends FunctionReferenceImpl implements Function1<String, String> {
    MemoryTraceReportHotwordsReader$1(Object r8) {
        super(1, r8, AuditoryBridgeAPI.class, "getCachedHotwords", "getCachedHotwords(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ String invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return ((AuditoryBridgeAPI) ZeusTransformUtils.preCheckCast(this.receiver, AuditoryBridgeAPI.class, "com.obric.memorydata.plugin")).getCachedHotwords(r3);
    }
}
