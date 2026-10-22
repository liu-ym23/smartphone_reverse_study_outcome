package com.obric.memorydata.memory.utils;

import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemoryUtils$queryMemoryEntityByUUID$1 extends FunctionReferenceImpl implements Function1<String, EpisodicMemoryEntity> {
    MemoryUtils$queryMemoryEntityByUUID$1(Object r8) {
        super(1, r8, EpisodicMemoryDao.class, "queryByUUID", "queryByUUID(Ljava/lang/String;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final EpisodicMemoryEntity invoke2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(((EpisodicMemoryDao) ZeusTransformUtils.preCheckCast(this.receiver, EpisodicMemoryDao.class, "com.obric.memorydata.plugin")).queryByUUID(r3), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ EpisodicMemoryEntity invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
