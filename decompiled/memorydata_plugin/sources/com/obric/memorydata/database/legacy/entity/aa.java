package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/SemanticTextCopilotOld;", "Lcom/obric/memorydata/database/entity/AbstractTextVectorCopilotEntity;", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "personalDbSplitMigrated", "", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Z)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "getText", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa extends com.obric.memorydata.database.entity.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9479b;
    private final String c;
    private final String d;
    private final boolean e;

    public aa(long r2, long r4, String r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "rawDbColumn");
        Intrinsics.checkNotNullParameter(r7, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        super(r2, r4, r6, r7);
        this.f9478a = r2;
        this.f9479b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
    }

    public /* synthetic */ aa(long r11, long r13, String r15, String r16, boolean r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r18 & 16) == 0) goto L9;
        boolean r9 = false;
    L10:
        this(r3, r13, r15, r16, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r3 = r11;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public long a() {
        return this.f9478a;
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public long b() {
        return this.f9479b;
    }

    @Override // com.obric.memorydata.database.entity.h, com.obric.memorydata.database.entity.i
    public String c() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.h
    public String d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, aa.class) == true) goto L8;
        return false;
    L8:
        aa r10 = (aa) ZeusTransformUtils.preCheckCast(r9, aa.class, "com.obric.memorydata.plugin");
        if (this.f9478a == r10.f9478a) goto L12;
        return false;
    L12:
        if (this.f9479b == r10.f9479b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f9478a) * 31) + Long.hashCode(this.f9479b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "SemanticTextCopilotOld(id=" + this.f9478a + ", rawDbId=" + this.f9479b + ", rawDbColumn=" + this.c + ", text=" + this.d + ", personalDbSplitMigrated=" + this.e + ')';
    }
}
