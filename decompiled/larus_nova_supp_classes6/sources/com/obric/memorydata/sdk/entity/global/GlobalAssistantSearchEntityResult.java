package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;", "Landroid/os/Parcelable;", "entityList", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "recallTotalCount", "", "<init>", "(Ljava/util/List;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getEntityList", "()Ljava/util/List;", "getRecallTotalCount", "()I", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class GlobalAssistantSearchEntityResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<AppEntity> entityList;
    private final int recallTotalCount;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalAssistantSearchEntityResult copy$default(GlobalAssistantSearchEntityResult r0, List r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.entityList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.recallTotalCount;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<AppEntity> component1() {
        return this.entityList;
    }

    public final int component2() {
        return this.recallTotalCount;
    }

    public final GlobalAssistantSearchEntityResult copy(List<? extends AppEntity> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "entityList");
        return new GlobalAssistantSearchEntityResult(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GlobalAssistantSearchEntityResult) == true) goto L8;
        return false;
    L8:
        GlobalAssistantSearchEntityResult r6 = (GlobalAssistantSearchEntityResult) r5;
        if (Intrinsics.areEqual(this.entityList, r6.entityList) == true) goto L12;
        return false;
    L12:
        if (this.recallTotalCount == r6.recallTotalCount) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.entityList.hashCode() * 31) + this.recallTotalCount;
    }

    public String toString() {
        return "GlobalAssistantSearchEntityResult(entityList=" + this.entityList + ", recallTotalCount=" + this.recallTotalCount + ')';
    }

    public final List<AppEntity> getEntityList() {
        return this.entityList;
    }

    public final int getRecallTotalCount() {
        return this.recallTotalCount;
    }

    public GlobalAssistantSearchEntityResult(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        List r0 = r2.createTypedArrayList(AppEntity.CREATOR);
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        this(r0, r2.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalAssistantSearchEntityResult(List<? extends AppEntity> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "entityList");
        this.entityList = r2;
        this.recallTotalCount = r3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeTypedList(this.entityList);
        r1.writeInt(this.recallTotalCount);
    }

    public /* synthetic */ GlobalAssistantSearchEntityResult(List r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r1.size();
    L5:
        this(r1, r2);
    }
}
