package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/awareness/api/LocationSnapshot;", "Lcom/obric/memorydata/awareness/api/ILocationSnapshot;", "<init>", "()V", "getCachedLocation", "", "", "effectiveTimeInterval", "", "getLocation", "isRequesting", "", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationSnapshot implements ILocationSnapshot {
    public static final LocationSnapshot INSTANCE = null;
    private final /* synthetic */ ILocationSnapshot $$delegate_0;

    static {
        INSTANCE = new LocationSnapshot();
    }

    private LocationSnapshot() {
        ILocationSnapshot r0 = (ILocationSnapshot) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ILocationSnapshot.class)), ILocationSnapshot.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (ILocationSnapshot) ZeusTransformUtils.preCheckCast(DefaultLocationSnapshot.INSTANCE, ILocationSnapshot.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public List<Double> getCachedLocation(long r1) {
        return this.$$delegate_0.getCachedLocation(r1);
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public List<Double> getLocation(long r1) {
        return this.$$delegate_0.getLocation(r1);
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public boolean isRequesting() {
        return this.$$delegate_0.isRequesting();
    }
}
