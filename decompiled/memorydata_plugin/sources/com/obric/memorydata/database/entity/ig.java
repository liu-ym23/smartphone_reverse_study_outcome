package com.obric.memorydata.database.entity;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.index.ExtractTime;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/obric/memorydata/database/entity/SemanticMemoryWithRelevant;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", SlardarSettingsConstants.PERF_KEY_MEMORY, "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "relevantData", "Lcom/obric/memorydata/database/entity/ProactiveSemanticRelevantData;", "<init>", "(Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;Lcom/obric/memorydata/database/entity/ProactiveSemanticRelevantData;)V", "getMemory", "()Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "getRelevantData", "()Lcom/obric/memorydata/database/entity/ProactiveSemanticRelevantData;", "toRawMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "toMemoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ig extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ip f9215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final fa f9216b;

    public ig(ip r20, fa r21) {
        Intrinsics.checkNotNullParameter(r20, SlardarSettingsConstants.PERF_KEY_MEMORY);
        super(r20.getId(), r20.getEntityId(), r20.getCreateTime(), r20.getModifyTime(), r20.getType(), r20.getTimestamp(), r20.getPackageName(), r20.getHashCodeValue(), r20.getUuid(), null, null, null, 3584, null);
        this.f9215a = r20;
        this.f9216b = r21;
    }

    public final ip a() {
        return this.f9215a;
    }

    public final fa b() {
        return this.f9216b;
    }

    public final RawMemoryEntity c() {
        ip r0 = this.f9215a;
        fa r1 = this.f9216b;
        if (r1 == null) goto L5;
        int r2 = r1.i();
    L6:
        RawMemoryEntity r3 = iq.a(r0, r2);
        fa r4 = this.f9216b;
        if (r4 == null) goto L9;
        r3.setSourceQuery(r4.c());
        r3.setSourceText(this.f9216b.d());
        r3.setScreenshot(this.f9216b.e());
        r3.setSourcePackageName(this.f9216b.g());
        r3.setSourceAppName(this.f9216b.f());
    L9:
        return r3;
    L5:
        r2 = r0.i();
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        RawMemoryEntity r0 = c();
        if (r0 == null) goto L7;
        return r0.convertToAppEntity();
    L7:
        return this.f9215a.convertToAppEntity();
    }

    @Override // com.obric.memorydata.database.entity.d
    public b convertToContentTimeEntity(String r1, ExtractTime r2) {
        Intrinsics.checkNotNullParameter(r1, "column");
        Intrinsics.checkNotNullParameter(r2, "extractTime");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AbstractFakeAppEntity convertToFakeAppEntity() {
        return this.f9215a.convertToFakeAppEntity();
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "column");
        return this.f9215a.convertToImageVectorCopilotEntity(r2);
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return this.f9215a.convertToRawHistoryEntity();
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "column");
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return this.f9215a.convertToTextVectorCopilotEntity(r2, r3);
    }

    public final MemoryEntity d() {
        String r8 = iq.b(this.f9215a.a());
        String r9 = this.f9215a.c();
        String r12 = this.f9215a.b();
        String r10 = this.f9215a.d();
        String r11 = this.f9215a.f();
        long r3 = this.f9215a.getCreateTime();
        fa r0 = this.f9216b;
        if (r0 == null) goto L5;
        int r1 = r0.i();
    L6:
        int r7 = r1;
        long r5 = this.f9215a.getModifyTime();
        InfoCommonMemoryEntity r2 = new InfoCommonMemoryEntity(this.f9215a.getEntityId(), r3, r5, r7, r8, r9, r10, r11, r12);
        fa r4 = this.f9216b;
        if (r4 == null) goto L9;
        r2.setSourceQuery(r4.c());
        r2.setSourceText(this.f9216b.d());
        r2.setScreenshot(com.obric.memorydata.personalcontext.util.f.c(this.f9216b.e()));
        r2.setDetailStatus(this.f9216b.h());
        r2.setSourcePackageName(this.f9216b.g());
        r2.setSourceAppName(this.f9216b.f());
    L9:
        r2.setUuid(this.f9215a.getUuid());
        r2.setDetail(this.f9215a.d());
        r2.set_packageName(this.f9215a.getPackageName());
        r2.setDetailStatus(0);
        r2.setEvidenceCount(this.f9215a.h());
        r2.setUserEdit(this.f9215a.g());
        fa r13 = this.f9216b;
        if (r13 == null) goto L13;
        r2.setSourceQuery(r13.c());
        r2.setSourceText(r13.d());
        r2.setScreenshot(com.obric.memorydata.personalcontext.util.f.c(r13.e()));
        r2.setDetailStatus(r13.h());
        r2.setSourcePackageName(r13.g());
        r2.setSourceAppName(r13.f());
    L13:
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r2, MemoryEntity.class, "com.obric.memorydata.plugin");
    L5:
        r1 = this.f9215a.i();
        goto L6
    }
}
