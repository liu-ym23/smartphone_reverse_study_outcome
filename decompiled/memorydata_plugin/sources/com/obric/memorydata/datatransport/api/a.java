package com.obric.memorydata.datatransport.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/datatransport/api/DataTransportExportTables;", "", "<init>", "()V", "GLOBAL_EXPORT_TABLE_LIST", "", "", "getGLOBAL_EXPORT_TABLE_LIST", "()Ljava/util/List;", "USER_EXPORT_TABLE_LIST", "getUSER_EXPORT_TABLE_LIST", "EXPORT_TABLE_LIST", "getEXPORT_TABLE_LIST", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f9724b = null;
    private static final List<String> c = null;
    private static final List<String> d = null;

    static {
        f9723a = new a();
        List<String> r0 = CollectionsKt.listOf(new String[]{"RawContactEntity", "RawCallHistoryEntity", "RawMessageEntity", "RawNoteEntity", "RawPhotoEntity", "RawMetaLocationEntity", "RawVideoFrameEntity", "RawAlbumEntity", "RawRecordingEntity", "RawRecordingTextEntity", "RawFileEntity", "RawFileTextEntity", "RawScheduleEntity", "RawAlarmEntity", "RawCountdownEntity", "MemoryProcessOutputEvent", "MemoryProcessOperationRecord", "MemoryProcessTriggerState", "MemoryProcessSourceEvent", "MemoryProcessConsumerSubscription"});
        f9724b = r0;
        List<String> r1 = CollectionsKt.listOf(new String[]{"ShortMemory", "MemoryBaseRequirement", "MemoryBaseScene", "AgentWatermark", "MemoryReviewFeedback", "UnionSemanticMemory", "ProactiveSemanticRelevantData", "UnionSemanticMemorySnapShot", "AutoMemoryProSnapShot", "AutoMemorySemanticRelevantData", "AutoMemoryEpisodicRelevantData", "UnionSemanticTypeSummary", "MemoryProcessUserInsight", "UnionUserInsight", "UnionUserPersona", "AutoMemoryPro", "AutoMemoryProRawSource", "MemoryRule"});
        c = r1;
        d = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }

    public final List<String> a() {
        return f9724b;
    }

    public final List<String> b() {
        return c;
    }

    public final List<String> c() {
        return d;
    }
}
