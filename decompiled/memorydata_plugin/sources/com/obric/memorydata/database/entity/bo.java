package com.obric.memorydata.database.entity;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.index.ExtractTime;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/entity/EpisodicMemoryWithRelevant;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", SlardarSettingsConstants.PERF_KEY_MEMORY, "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "relevantData", "Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "<init>", "(Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;)V", "getMemory", "()Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "getRelevantData", "()Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bo extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EpisodicMemoryEntity f8936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final es f8937b;

    public bo(EpisodicMemoryEntity r20, es r21) {
        Intrinsics.checkNotNullParameter(r20, SlardarSettingsConstants.PERF_KEY_MEMORY);
        super(r20.getId(), r20.getEntityId(), r20.getCreateTime(), r20.getModifyTime(), r20.getType(), r20.getTimestamp(), r20.getPackageName(), r20.getHashCodeValue(), r20.getUuid(), null, null, null, 3584, null);
        this.f8936a = r20;
        this.f8937b = r21;
    }

    public final RawMemoryEntity a() {
        es r0 = this.f8937b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return bi.a(this.f8936a, r0);
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        RawMemoryEntity r0 = a();
        if (r0 == null) goto L7;
        return r0.convertToAppEntity();
    L7:
        return this.f8936a.convertToAppEntity();
    }

    @Override // com.obric.memorydata.database.entity.d
    public b convertToContentTimeEntity(String r2, ExtractTime r3) {
        Intrinsics.checkNotNullParameter(r2, "column");
        Intrinsics.checkNotNullParameter(r3, "extractTime");
        return this.f8936a.convertToContentTimeEntity(r2, r3);
    }

    @Override // com.obric.memorydata.database.entity.d
    public AbstractFakeAppEntity convertToFakeAppEntity() {
        return (AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(this.f8936a.convertToFakeAppEntity(), AbstractFakeAppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "column");
        return this.f8936a.convertToImageVectorCopilotEntity(r2);
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return this.f8936a.convertToRawHistoryEntity();
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "column");
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return this.f8936a.convertToTextVectorCopilotEntity(r2, r3);
    }
}
