package com.obric.memorydata.database.index;

import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.entity.AutoMemoryProIndex_Impl;
import com.obric.memorydata.database.entity.EpisodicMemoryIndex_Impl;
import com.obric.memorydata.database.entity.EpisodicTopicMemoryIndex_Impl;
import com.obric.memorydata.database.entity.LifeLogIndex_Impl;
import com.obric.memorydata.database.entity.RawAlarmIndex_Impl;
import com.obric.memorydata.database.entity.RawAlbumIndex_Impl;
import com.obric.memorydata.database.entity.RawAuditoryRecordingEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawAuditoryRecordingTextEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawBrowserBookmarkEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawCallHistoryIndex_Impl;
import com.obric.memorydata.database.entity.RawCommonPhotoIndex_Impl;
import com.obric.memorydata.database.entity.RawCommonVideoFrameIndex_Impl;
import com.obric.memorydata.database.entity.RawContactIndex_Impl;
import com.obric.memorydata.database.entity.RawCountdownIndex_Impl;
import com.obric.memorydata.database.entity.RawDoubaoAccountIndex_Impl;
import com.obric.memorydata.database.entity.RawFileEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawFileTextEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawICSProtocolIndex_Impl;
import com.obric.memorydata.database.entity.RawMemoryEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawMemoryLocationIndex_Impl;
import com.obric.memorydata.database.entity.RawMessageIndex_Impl;
import com.obric.memorydata.database.entity.RawMetaLocationIndex_Impl;
import com.obric.memorydata.database.entity.RawMetaTagIndex_Impl;
import com.obric.memorydata.database.entity.RawNoteIndex_Impl;
import com.obric.memorydata.database.entity.RawNoteRecordingEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawNoteRecordingTextEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawPhotoFaceIndex_Impl;
import com.obric.memorydata.database.entity.RawPhotoIndex_Impl;
import com.obric.memorydata.database.entity.RawRecordingEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawRecordingTextEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawScheduleEntityIndex_Impl;
import com.obric.memorydata.database.entity.RawUserProfileIndex_Impl;
import com.obric.memorydata.database.entity.RawVideoFrameIndex_Impl;
import com.obric.memorydata.database.entity.SemanticMemoryIndex_Impl;
import com.obric.memorydata.database.entity.bl;
import com.obric.memorydata.database.entity.hg;
import com.obric.memorydata.database.entity.ht;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/index/EntityIndexEngineImpl;", "Lcom/obric/memorydata/database/index/EntityIndexEngine;", "<init>", "()V", "executeIndexPendingTask", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "updateField", "", "getNeedUpdateColumns", "", "oldEntity", "newEntity", "getAllColumns", "getKeywordColumnMap", "", "getContentTimeColumns", "assignmentAssociateField", "", "changeColumns", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityIndexEngineImpl extends EntityIndexEngine {
    public EntityIndexEngineImpl() {
        getEntityIndexImplMap().putAll(MapsKt.mapOf(new Pair[]{TuplesKt.to(501, new RawRecordingEntityIndex_Impl()), TuplesKt.to(Integer.valueOf(NetError.ERR_UNSAFE_REDIRECT), new RawCommonPhotoIndex_Impl()), TuplesKt.to(201, new RawContactIndex_Impl()), TuplesKt.to(401, new RawScheduleEntityIndex_Impl()), TuplesKt.to(Integer.valueOf(EntityType.LIFE_LOG), new LifeLogIndex_Impl()), TuplesKt.to(601, new RawNoteIndex_Impl()), TuplesKt.to(302, new RawAlbumIndex_Impl()), TuplesKt.to(Integer.valueOf(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED), new AutoMemoryProIndex_Impl()), TuplesKt.to(-314, new EpisodicTopicMemoryIndex_Impl()), TuplesKt.to(-305, new RawMemoryLocationIndex_Impl()), TuplesKt.to(Integer.valueOf(EntityType.FILE), new RawFileEntityIndex_Impl()), TuplesKt.to(-313, new RawAuditoryRecordingTextEntityIndex_Impl()), TuplesKt.to(402, new RawICSProtocolIndex_Impl()), TuplesKt.to(-304, new ht((e) ZeusTransformUtils.preCheckCast(new RawVideoFrameIndex_Impl(), e.class, "com.obric.memorydata.plugin"))), TuplesKt.to(-306, new bl((e) ZeusTransformUtils.preCheckCast(new EpisodicMemoryIndex_Impl(), e.class, "com.obric.memorydata.plugin"))), TuplesKt.to(-307, new RawNoteRecordingEntityIndex_Impl()), TuplesKt.to(Integer.valueOf(NetError.ERR_TOO_MANY_REDIRECTS), new RawNoteRecordingTextEntityIndex_Impl()), TuplesKt.to(Integer.valueOf(NetError.ERR_UNSAFE_PORT), new RawCommonVideoFrameIndex_Impl()), TuplesKt.to(202, new RawCallHistoryIndex_Impl()), TuplesKt.to(902, new RawBrowserBookmarkEntityIndex_Impl()), TuplesKt.to(701, new RawAlarmIndex_Impl()), TuplesKt.to(Integer.valueOf(NetError.ERR_INVALID_REDIRECT), new RawMemoryEntityIndex_Impl()), TuplesKt.to(Integer.valueOf(NetError.ERR_DISALLOWED_URL_SCHEME), new RawMetaLocationIndex_Impl()), TuplesKt.to(301, new hg((e) ZeusTransformUtils.preCheckCast(new RawPhotoIndex_Impl(), e.class, "com.obric.memorydata.plugin"))), TuplesKt.to(101, new RawMessageIndex_Impl()), TuplesKt.to(Integer.valueOf(NetError.ERR_CACHE_READ_FAILURE), new SemanticMemoryIndex_Impl()), TuplesKt.to(-309, new RawRecordingTextEntityIndex_Impl()), TuplesKt.to(702, new RawCountdownIndex_Impl()), TuplesKt.to(303, new RawPhotoFaceIndex_Impl()), TuplesKt.to(-308, new RawFileTextEntityIndex_Impl()), TuplesKt.to(Integer.valueOf(EntityType.USER_PROFILE), new RawUserProfileIndex_Impl()), TuplesKt.to(Integer.valueOf(EntityType.DOUBAO_ACCOUNT), new RawDoubaoAccountIndex_Impl()), TuplesKt.to(Integer.valueOf(NetError.ERR_UNKNOWN_URL_SCHEME), new RawMetaTagIndex_Impl()), TuplesKt.to(502, new RawAuditoryRecordingEntityIndex_Impl())}));
    }

    @Override // com.obric.memorydata.database.index.EntityIndexEngine
    public void assignmentAssociateField(com.obric.memorydata.database.entity.d r3, com.obric.memorydata.database.entity.d r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
        Intrinsics.checkNotNullParameter(r6, "changeColumns");
        e r2 = (e) ZeusTransformUtils.preCheckCast(getEntityIndexImplMap().get(Integer.valueOf(r4.getType())), e.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.assignmentAssociateField(r3, r4, r6);
        return;
    }

    @Override // com.obric.memorydata.database.index.EntityIndexEngine
    public boolean executeIndexPendingTask(com.obric.memorydata.database.entity.d r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter(r4, "updateField");
        e r2 = (e) ZeusTransformUtils.preCheckCast(getEntityIndexImplMap().get(Integer.valueOf(r3.getType())), e.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.executeIndexPendingTask(r3, r4);
    }

    @Override // com.obric.memorydata.database.index.EntityIndexEngine
    public Set<String> getAllColumns(com.obric.memorydata.database.entity.d r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        e r1 = (e) ZeusTransformUtils.preCheckCast(getEntityIndexImplMap().get(Integer.valueOf(r2.getType())), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        Set<String> r3 = r1.getAllColumns();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.EntityIndexEngine
    public Map<String, String> getContentTimeColumns(com.obric.memorydata.database.entity.d r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        e r1 = (e) ZeusTransformUtils.preCheckCast(getEntityIndexImplMap().get(Integer.valueOf(r2.getType())), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        Map<String, String> r3 = r1.getContentTimeColumns();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return MapsKt.emptyMap();
    }

    @Override // com.obric.memorydata.database.index.EntityIndexEngine
    public Map<String, String> getKeywordColumnMap(com.obric.memorydata.database.entity.d r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        e r1 = (e) ZeusTransformUtils.preCheckCast(getEntityIndexImplMap().get(Integer.valueOf(r2.getType())), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        Map<String, String> r3 = r1.getKeywordColumnMap();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return MapsKt.emptyMap();
    }

    @Override // com.obric.memorydata.database.index.EntityIndexEngine
    public Set<String> getNeedUpdateColumns(com.obric.memorydata.database.entity.d r3, com.obric.memorydata.database.entity.d r4) {
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
        e r2 = (e) ZeusTransformUtils.preCheckCast(getEntityIndexImplMap().get(Integer.valueOf(r4.getType())), e.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        Set<String> r5 = r2.getNeedUpdateColumns(r3, r4);
        if (r5 == null) goto L7;
        return r5;
    L7:
        return (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }
}
