package com.obric.memorydata.memory.utils;

import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.ip;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemoryUtils$queryMemoryEntityByUUID$2 extends FunctionReferenceImpl implements Function1<String, ip> {
    MemoryUtils$queryMemoryEntityByUUID$2(Object r8) {
        super(1, r8, SemanticMemoryDao.class, "queryByUUID", "queryByUUID(Ljava/lang/String;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ip invoke2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return (ip) ZeusTransformUtils.preCheckCast(((SemanticMemoryDao) ZeusTransformUtils.preCheckCast(this.receiver, SemanticMemoryDao.class, "com.obric.memorydata.plugin")).queryByUUID(r3), ip.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ ip invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
