package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProSlmPersonalInfoEntity;", "", OaidModel.KEY_ID, "", "data", "", "<init>", "(JLjava/lang/String;)V", "getId", "()J", "getData", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryProSlmPersonalInfoEntity {
    private final String data;
    private final long id;

    public AutoMemoryProSlmPersonalInfoEntity() {
        this(0, null, 3, null);
    }

    public AutoMemoryProSlmPersonalInfoEntity(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        this.id = r2;
        this.data = r4;
    }

    public /* synthetic */ AutoMemoryProSlmPersonalInfoEntity(long r1, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r1, r3);
    }

    public static /* synthetic */ AutoMemoryProSlmPersonalInfoEntity copy$default(AutoMemoryProSlmPersonalInfoEntity r0, long r1, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.data;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.data;
    }

    public final AutoMemoryProSlmPersonalInfoEntity copy(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        return new AutoMemoryProSlmPersonalInfoEntity(r1, r3);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AutoMemoryProSlmPersonalInfoEntity.class) == true) goto L8;
        return false;
    L8:
        AutoMemoryProSlmPersonalInfoEntity r10 = (AutoMemoryProSlmPersonalInfoEntity) ZeusTransformUtils.preCheckCast(r9, AutoMemoryProSlmPersonalInfoEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r10.data) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getData() {
        return this.data;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "AutoMemoryProSlmPersonalInfoEntity(id=" + this.id + ", data=" + this.data + ')';
    }
}
