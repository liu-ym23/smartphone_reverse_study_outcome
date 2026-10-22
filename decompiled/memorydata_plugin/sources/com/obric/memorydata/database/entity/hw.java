package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/database/entity/RecordingHistoryEntity;", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", OaidModel.KEY_ID, "", "recordingEntity", "Lcom/obric/memorydata/database/entity/RawRecordingEntity;", "<init>", "(JLcom/obric/memorydata/database/entity/RawRecordingEntity;)V", "getId", "()J", "setId", "(J)V", "getRecordingEntity", "()Lcom/obric/memorydata/database/entity/RawRecordingEntity;", "getRawDbEntity", "getHistoryDbId", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hw extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9200b;
    private final hh c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/entity/RecordingHistoryEntity$Companion;", "", "<init>", "()V", "PREFIX_TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9199a = new a(null);
    }

    public hw(long r2, hh r4) {
        Intrinsics.checkNotNullParameter(r4, "recordingEntity");
        this.f9200b = r2;
        this.c = r4;
    }

    public /* synthetic */ hw(long r1, hh r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1, r3);
    }

    public final long a() {
        return this.f9200b;
    }

    public final hh b() {
        return this.c;
    }

    public hh c() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.c
    public long getHistoryDbId() {
        return this.f9200b;
    }

    @Override // com.obric.memorydata.database.entity.c
    public /* synthetic */ d getRawDbEntity() {
        return (d) ZeusTransformUtils.preCheckCast(c(), d.class, "com.obric.memorydata.plugin");
    }
}
