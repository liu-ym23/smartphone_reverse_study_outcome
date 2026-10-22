package com.obric.capabilitykit.version;

import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/capabilitykit/version/EntityVersionData;", "", "selfVersion", "", "appEntityVersion", "(II)V", "getAppEntityVersion", "()I", "setAppEntityVersion", "(I)V", "getSelfVersion", "setSelfVersion", "compareTo", "other", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EntityVersionData implements Comparable<EntityVersionData> {

    @SerializedName("appEntityVersion")
    private int appEntityVersion;

    @SerializedName("selfVersion")
    private int selfVersion;

    public EntityVersionData() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    public EntityVersionData(int r1, int r2) {
        this.selfVersion = r1;
        this.appEntityVersion = r2;
    }

    public /* synthetic */ EntityVersionData(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = -1;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ EntityVersionData copy$default(EntityVersionData r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.selfVersion;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.appEntityVersion;
    L9:
        return r0.copy(r1, r2);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(EntityVersionData r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        int r0 = Intrinsics.compare(this.appEntityVersion, r3.appEntityVersion);
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return Intrinsics.compare(this.selfVersion, r3.selfVersion);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(EntityVersionData r1) {
        return compareTo2(r1);
    }

    public final int component1() {
        return this.selfVersion;
    }

    public final int component2() {
        return this.appEntityVersion;
    }

    public final EntityVersionData copy(int r2, int r3) {
        return new EntityVersionData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EntityVersionData) == true) goto L8;
        return false;
    L8:
        EntityVersionData r6 = (EntityVersionData) r5;
        if (this.selfVersion == r6.selfVersion) goto L12;
        return false;
    L12:
        if (this.appEntityVersion == r6.appEntityVersion) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getAppEntityVersion() {
        return this.appEntityVersion;
    }

    public final int getSelfVersion() {
        return this.selfVersion;
    }

    public int hashCode() {
        return (this.selfVersion * 31) + this.appEntityVersion;
    }

    public final void setAppEntityVersion(int r1) {
        this.appEntityVersion = r1;
    }

    public final void setSelfVersion(int r1) {
        this.selfVersion = r1;
    }

    public String toString() {
        return "EntityVersionData(selfVersion=" + this.selfVersion + ", appEntityVersion=" + this.appEntityVersion + ')';
    }
}
