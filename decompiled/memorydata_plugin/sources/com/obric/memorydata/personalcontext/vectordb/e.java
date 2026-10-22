package com.obric.memorydata.personalcontext.vectordb;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.dejavu.library.IndexMetricType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/VectorDbIndexConfigs;", "", "<init>", "()V", "DEFAULT_SEARCH_PROBE", "", "DEFAULT_DOWNGRADE_LIMIT", "DEFAULT_UPGRADE_LIMIT", "defaultInnerProduct", "Lcom/obric/dejavu/library/DbIndexConfig;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12410a = null;

    static {
        f12410a = new e();
    }

    private e() {
    }

    public final com.obric.dejavu.library.a a() {
        return new com.obric.dejavu.library.a(null, IndexMetricType.InnerProduct, 16, 25000, LocationInfoConst.HALF_MINUTES, 0, 0, 0, 0, false, 993, null);
    }
}
