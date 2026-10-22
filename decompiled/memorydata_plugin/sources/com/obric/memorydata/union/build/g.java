package com.obric.memorydata.union.build;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.JsonObject;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bJ/\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/union/build/MemoryProductionPoisonHasher;", "", "<init>", "()V", "hasExplicitMetadata", "", "poisonLabel", "", "poisonLabelVersion", "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "hashEpisodic", "", "title", Params.CONTENT, "hashSemantic", "tagPath", "keyPhrase", "applyMetadata", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "contentHash", "(Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f13090a = null;

    static {
        f13090a = new g();
    }

    private g() {
    }

    public final String a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        com.obric.memorydata.personalcontext.poison.a r0 = com.obric.memorydata.personalcontext.poison.a.f12244a;
        JsonObject r1 = new JsonObject();
        r1.addProperty("title", r3);
        r1.addProperty(MemoryListActivity.JUMP_FROM_DETAIL, r4);
        Unit r2 = Unit.INSTANCE;
        String r5 = r0.a(EntityType.MEMORY_COMMON_TEXT, r1);
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalArgumentException("Missing poison hash fields for MEMORY_COMMON_TEXT".toString());
    }

    public final void a(com.obric.memorydata.database.entity.d r1, Integer r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        Intrinsics.checkNotNullParameter(r4, "contentHash");
        r1.setPoisonLabel(r2);
        r1.setPoisonLabelVersion(r3);
        r1.setContentHash(r4);
    }

    public final boolean a(Integer r1, Integer r2) {
        if (r1 != null) goto L6;
        if (r2 != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final String b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tagPath");
        Intrinsics.checkNotNullParameter(r4, "keyPhrase");
        com.obric.memorydata.personalcontext.poison.a r2 = com.obric.memorydata.personalcontext.poison.a.f12244a;
        JsonObject r0 = new JsonObject();
        r0.addProperty(LocationMonitorConst.TAG, r3);
        r0.addProperty("infoValue", r4);
        Unit r5 = Unit.INSTANCE;
        String r6 = r2.a(EntityType.MEMORY_INFO_COMMON, r0);
        if (r6 == null) goto L6;
        return r6;
    L6:
        throw new IllegalArgumentException("Missing poison hash fields for MEMORY_INFO_COMMON".toString());
    }
}
