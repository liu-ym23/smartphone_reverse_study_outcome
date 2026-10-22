package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", "<init>", "(JJLjava/lang/String;)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9206b;
    private final String c;

    public i(long r2, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "rawDbColumn");
        this.f9205a = r2;
        this.f9206b = r4;
        this.c = r6;
    }

    public long a() {
        return this.f9205a;
    }

    public long b() {
        return this.f9206b;
    }

    public String c() {
        return this.c;
    }
}
