package com.obric.memorydata.observation.impl;

import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/observation/impl/RawObservationRepository;", "", "dao", "Lcom/obric/memorydata/database/dao/RawObservationDao;", "<init>", "(Lcom/obric/memorydata/database/dao/RawObservationDao;)V", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "insertAll", "", "entities", "observation_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RawObservationDao f11999a;

    public d(RawObservationDao r3) {
        RawObservationDao r4 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r3, RawObservationDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dao");
        this.f11999a = r4;
    }

    public final long insert(RawObservationEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return this.f11999a.insert(r2);
    }
}
