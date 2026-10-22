package com.obric.memorydata.database.dao;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/dao/SemanticRetractionReason;", "", "<init>", "()V", "USER_DELETE", "", "CONFLICT_DISCARD", "SYSTEM_DELETE", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "", "getAll", "()Ljava/util/Set;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticRetractionReason {
    public static final String CONFLICT_DISCARD = "conflict_discard";
    public static final SemanticRetractionReason INSTANCE = null;
    public static final String SYSTEM_DELETE = "system_delete";
    public static final String USER_DELETE = "user_delete";
    private static final Set<String> all = null;

    static {
        INSTANCE = new SemanticRetractionReason();
        all = SetsKt.setOf(new String[]{USER_DELETE, CONFLICT_DISCARD, SYSTEM_DELETE});
    }

    private SemanticRetractionReason() {
    }

    public final Set<String> getAll() {
        return all;
    }
}
