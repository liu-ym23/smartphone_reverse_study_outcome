package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.c;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.entity.fq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/dao/CallHistoryHistoryEntity;", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", OaidModel.KEY_ID, "", "callHistoryEntity", "Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;", "<init>", "(JLcom/obric/memorydata/database/entity/RawCallHistoryEntity;)V", "getId", "()J", "setId", "(J)V", "getCallHistoryEntity", "()Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;", "getRawDbEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getHistoryDbId", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CallHistoryHistoryEntity extends c {
    public static final Companion Companion = null;
    public static final String PREFIX_TAG = "call_";
    private final fq callHistoryEntity;
    private long id;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/CallHistoryHistoryEntity$Companion;", "", "<init>", "()V", "PREFIX_TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CallHistoryHistoryEntity(long r2, fq r4) {
        Intrinsics.checkNotNullParameter(r4, "callHistoryEntity");
        this.id = r2;
        this.callHistoryEntity = r4;
    }

    public /* synthetic */ CallHistoryHistoryEntity(long r1, fq r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1, r3);
    }

    public final fq getCallHistoryEntity() {
        return this.callHistoryEntity;
    }

    @Override // com.obric.memorydata.database.entity.c
    public long getHistoryDbId() {
        return this.id;
    }

    public final long getId() {
        return this.id;
    }

    @Override // com.obric.memorydata.database.entity.c
    public d getRawDbEntity() {
        return (d) ZeusTransformUtils.preCheckCast(this.callHistoryEntity, d.class, "com.obric.memorydata.plugin");
    }

    public final void setId(long r1) {
        this.id = r1;
    }
}
