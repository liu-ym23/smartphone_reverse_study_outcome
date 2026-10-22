package com.obric.memorydata.union.build;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.memory.api.MemoryBuildApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bJV\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bJj\u0010\u0014\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/union/build/InlineProactiveMemoryEventParamsFactory;", "", "<init>", "()V", "semantic", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$TrackNewProactiveMemoryParams;", "sourceInfo", "", "", "memoryUuid", LocationMonitorConst.TAG, "createTime", "", "modifyTime", "isNewEntity", "", "memoryTag", "episodic", "action", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "build", "type", "", "forceAddNew", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13071a = null;

    static {
        f13071a = new d();
    }

    private d() {
    }

    static /* synthetic */ MemoryBuildApi.d a(d r14, Map r15, String r16, int r17, String r18, long r19, long r21, boolean r23, boolean r24, String r25, int r26, Object r27) {
        Map<String, ? extends Object> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        if ((r26 & 128) == 0) goto L5;
        boolean r12 = false;
    L7:
        if ((r26 & 256) == 0) goto L9;
        String r13 = null;
    L11:
        return r14.a(r3, r16, r17, r18, r19, r21, r23, r12, r13);
    L9:
        r13 = r25;
        goto L11
    L5:
        r12 = r24;
        goto L7
    }

    private final MemoryBuildApi.d a(Map<String, ? extends Object> r19, String r20, int r21, String r22, long r23, long r25, boolean r27, boolean r28, String r29) {
        Map<String, ? extends Object> r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        m.a r1 = m.f13098a.a(r0);
        return new MemoryBuildApi.d(r20, r1.h(), r1.d(), r21, r22, r23, r25, r27, r28, null, null, r29, 1536, null);
    }

    public final MemoryBuildApi.d a(Map<String, ? extends Object> r14, String r15, long r16, long r18, boolean r20, MemoryBuildApi.Action r21, String r22) {
        Map<String, ? extends Object> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "action");
        if (r21.isSnapshotAction() == false) goto L7;
        return null;
    L7:
        return a(r2, r15, EntityType.MEMORY_COMMON_TEXT, null, r16, r18, r20, true, r22);
    }

    public final MemoryBuildApi.d a(Map<String, ? extends Object> r16, String r17, String r18, long r19, long r21, boolean r23, String r24) {
        return a(this, (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin"), r17, EntityType.MEMORY_INFO_COMMON, r18, r19, r21, r23, false, r24, 128, null);
    }
}
