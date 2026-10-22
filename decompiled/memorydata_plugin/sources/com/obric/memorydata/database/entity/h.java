package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "<init>", "(JJLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "getText", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class h extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9172b;
    private final String c;
    private final String d;

    public h(long r2, long r4, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "rawDbColumn");
        Intrinsics.checkNotNullParameter(r7, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        super(r2, r4, r6);
        this.f9171a = r2;
        this.f9172b = r4;
        this.c = r6;
        this.d = r7;
    }

    @Override // com.obric.memorydata.database.entity.i
    public long a() {
        return this.f9171a;
    }

    @Override // com.obric.memorydata.database.entity.i
    public long b() {
        return this.f9172b;
    }

    @Override // com.obric.memorydata.database.entity.i
    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }
}
