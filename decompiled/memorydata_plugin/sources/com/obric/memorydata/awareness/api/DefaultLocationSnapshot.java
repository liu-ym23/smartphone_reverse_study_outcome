package com.obric.memorydata.awareness.api;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/awareness/api/DefaultLocationSnapshot;", "Lcom/obric/memorydata/awareness/api/ILocationSnapshot;", "<init>", "()V", "getLocation", "", "", "effectiveTimeInterval", "", "getCachedLocation", "isRequesting", "", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultLocationSnapshot implements ILocationSnapshot {
    public static final DefaultLocationSnapshot INSTANCE = null;

    static {
        INSTANCE = new DefaultLocationSnapshot();
    }

    private DefaultLocationSnapshot() {
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public List<Double> getCachedLocation(long r1) {
        return null;
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public List<Double> getLocation(long r1) {
        return null;
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public boolean isRequesting() {
        return false;
    }
}
