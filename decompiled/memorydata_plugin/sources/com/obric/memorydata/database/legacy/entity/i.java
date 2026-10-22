package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/EpisodicMemoryHistoryEntityOld;", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", OaidModel.KEY_ID, "", "episodicMemoryEntity", "Lcom/obric/memorydata/database/legacy/entity/EpisodicMemoryEntityOld;", "<init>", "(JLcom/obric/memorydata/database/legacy/entity/EpisodicMemoryEntityOld;)V", "getId", "()J", "setId", "(J)V", "getEpisodicMemoryEntity", "()Lcom/obric/memorydata/database/legacy/entity/EpisodicMemoryEntityOld;", "getRawDbEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getHistoryDbId", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i extends com.obric.memorydata.database.entity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9521b;
    private final EpisodicMemoryEntityOld c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/EpisodicMemoryHistoryEntityOld$Companion;", "", "<init>", "()V", "PREFIX_TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9520a = new a(null);
    }

    public i(long r2, EpisodicMemoryEntityOld r4) {
        Intrinsics.checkNotNullParameter(r4, "episodicMemoryEntity");
        this.f9521b = r2;
        this.c = r4;
    }

    public final long a() {
        return this.f9521b;
    }

    public final EpisodicMemoryEntityOld b() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.c
    public long getHistoryDbId() {
        return this.f9521b;
    }

    @Override // com.obric.memorydata.database.entity.c
    public com.obric.memorydata.database.entity.d getRawDbEntity() {
        return (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(this.c, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    }
}
