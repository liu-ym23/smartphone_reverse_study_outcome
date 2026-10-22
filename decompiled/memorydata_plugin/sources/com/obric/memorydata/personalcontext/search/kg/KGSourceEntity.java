package com.obric.memorydata.personalcontext.search.kg;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/kg/KGSourceEntity;", "", "entityType", "", OaidModel.KEY_ID, "", "<init>", "(IJ)V", "getEntityType", "()I", "getId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KGSourceEntity {
    private final int entityType;
    private final long id;

    public KGSourceEntity(int r1, long r2) {
        this.entityType = r1;
        this.id = r2;
    }

    public static /* synthetic */ KGSourceEntity copy$default(KGSourceEntity r0, int r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.entityType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.id;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.entityType;
    }

    public final long component2() {
        return this.id;
    }

    public final KGSourceEntity copy(int r1, long r2) {
        return new KGSourceEntity(r1, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, KGSourceEntity.class) == true) goto L8;
        return false;
    L8:
        KGSourceEntity r8 = (KGSourceEntity) ZeusTransformUtils.preCheckCast(r7, KGSourceEntity.class, "com.obric.memorydata.plugin");
        if (this.entityType == r8.entityType) goto L12;
        return false;
    L12:
        if (this.id == r8.id) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return (Integer.hashCode(this.entityType) * 31) + Long.hashCode(this.id);
    }

    public String toString() {
        return "KGSourceEntity(entityType=" + this.entityType + ", id=" + this.id + ')';
    }
}
