package com.obric.memorydata.database.legacy.backup.a;

import com.obric.memorydata.database.backup.appentity.FakeAutoMemoryProEntity;
import com.obric.memorydata.database.backup.appentity.FakeEpisodicMemoryAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeEpisodicTopicMemoryAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeLifelogAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeUnionSemanticMemoryAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeUserProfileAppEntity;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.LifelogEntity;
import com.obric.memorydata.database.entity.bp;
import com.obric.memorydata.database.entity.hn;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.legacy.entity.AutoMemoryProEntityOld;
import com.obric.memorydata.database.legacy.entity.EpisodicMemoryEntityOld;
import com.obric.memorydata.database.legacy.entity.LifelogEntityOld;
import com.obric.memorydata.database.legacy.entity.ac;
import com.obric.memorydata.database.legacy.entity.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0000\u001a\f\u0010\u0000\u001a\u00020\t*\u00020\nH\u0000\u001a\f\u0010\u0000\u001a\u00020\u000b*\u00020\fH\u0000¨\u0006\r"}, d2 = {"toFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/FakeEpisodicMemoryAppEntity;", "Lcom/obric/memorydata/database/legacy/entity/EpisodicMemoryEntityOld;", "Lcom/obric/memorydata/database/backup/appentity/FakeEpisodicTopicMemoryAppEntity;", "Lcom/obric/memorydata/database/legacy/entity/EpisodicTopicMemoryEntityOld;", "Lcom/obric/memorydata/database/backup/appentity/FakeLifelogAppEntity;", "Lcom/obric/memorydata/database/legacy/entity/LifelogEntityOld;", "Lcom/obric/memorydata/database/backup/appentity/FakeAutoMemoryProEntity;", "Lcom/obric/memorydata/database/legacy/entity/AutoMemoryProEntityOld;", "Lcom/obric/memorydata/database/backup/appentity/FakeUserProfileAppEntity;", "Lcom/obric/memorydata/database/legacy/entity/RawUserProfileEntityOld;", "Lcom/obric/memorydata/database/backup/appentity/FakeUnionSemanticMemoryAppEntity;", "Lcom/obric/memorydata/database/legacy/entity/UnionSemanticMemoryEntityOld;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class x {
    public static final FakeAutoMemoryProEntity a(AutoMemoryProEntityOld r31) {
        Intrinsics.checkNotNullParameter(r31, "<this>");
        String r27 = null;
        return new FakeAutoMemoryProEntity(new AutoMemoryProEntity(r31.getId(), r31.getEntityId(), r31.getCreateTime(), r31.getModifyTime(), r31.getType(), r31.getPackageName(), r31.getHashCodeValue(), r31.getUuid(), r31.getRuleId(), r31.getTimestamp(), r31.getTitle(), r31.getContent(), r31.getSubtitle(), r31.getReason(), r31.getLogId(), r31.getTraceId(), r31.getPackageNames(), r31.getEpisodicIds(), r31.getSemanticIds(), r27, r31.getFullContent(), 524288, null));
    }

    public static final FakeEpisodicMemoryAppEntity a(EpisodicMemoryEntityOld r53) {
        Intrinsics.checkNotNullParameter(r53, "<this>");
        return new FakeEpisodicMemoryAppEntity(new EpisodicMemoryEntity(r53.getId(), r53.getActionTimestamp(), r53.getUid(), r53.getTitle(), r53.getContent(), r53.getContentWithTime(), r53.getFullContent(), r53.getObservation(), r53.getLocation(), r53.getAppNames(), r53.getCategory(), r53.getProfileType(), r53.getProfileTag(), r53.getTagOther(), r53.getLogId(), r53.getUsedForPortrait(), r53.getUseLocation(), r53.getUseForUserKeyword(), r53.getStartTimestamp(), r53.getEndTimestamp(), r53.getUseForTopic(), r53.getEntityId(), r53.getCreateTime(), r53.getModifyTime(), r53.getType(), r53.getTimestamp(), r53.getPackageName(), r53.getHashCodeValue(), r53.getUuid(), r53.getUserEdit(), r53.getProductType(), null, null, null, null, null, null, null, null, Integer.MIN_VALUE, 127, null));
    }

    public static final FakeEpisodicTopicMemoryAppEntity a(com.obric.memorydata.database.legacy.entity.k r19) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        return new FakeEpisodicTopicMemoryAppEntity(new bp(r19.getId(), r19.a(), r19.b(), r19.c(), r19.getEntityId(), r19.getCreateTime(), r19.getModifyTime(), r19.getType(), r19.getTimestamp(), r19.getPackageName(), r19.getHashCodeValue(), r19.getUuid()));
    }

    public static final FakeLifelogAppEntity a(LifelogEntityOld r19) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        return new FakeLifelogAppEntity(new LifelogEntity(r19.getId(), r19.getEntityId(), r19.getCreateTime(), r19.getModifyTime(), r19.getType(), r19.getTimestamp(), r19.getPackageName(), r19.getHashCodeValue(), r19.getUuid(), r19.getLifelog(), r19.getFullContent()));
    }

    public static final FakeUnionSemanticMemoryAppEntity a(ac r43) {
        Intrinsics.checkNotNullParameter(r43, "<this>");
        return new FakeUnionSemanticMemoryAppEntity(new ip(r43.getId(), r43.getEntityId(), r43.getCreateTime(), r43.getModifyTime(), r43.getType(), r43.getTimestamp(), r43.getPackageName(), r43.getHashCodeValue(), r43.getUuid(), r43.a(), r43.b(), r43.c(), r43.d(), r43.e(), r43.f(), r43.g(), r43.h(), r43.i(), r43.j(), r43.k(), r43.l(), r43.m(), null, null, null, null, 0, null, 0, null, null, 0, -4194304, null));
    }

    public static final FakeUserProfileAppEntity a(y r20) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        return new FakeUserProfileAppEntity(new hn(r20.getId(), r20.getEntityId(), r20.getCreateTime(), r20.getModifyTime(), r20.getType(), r20.getTimestamp(), r20.getPackageName(), r20.getHashCodeValue(), r20.getUuid(), r20.a(), r20.b(), r20.c(), r20.d()));
    }
}
