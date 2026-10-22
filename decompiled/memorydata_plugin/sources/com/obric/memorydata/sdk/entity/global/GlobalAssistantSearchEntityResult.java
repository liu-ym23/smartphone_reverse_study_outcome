package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;", "Landroid/os/Parcelable;", "entityList", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "recallTotalCount", "", "<init>", "(Ljava/util/List;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getEntityList", "()Ljava/util/List;", "getRecallTotalCount", "()I", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalAssistantSearchEntityResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<AppEntity> entityList;
    private final int recallTotalCount;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<GlobalAssistantSearchEntityResult> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public GlobalAssistantSearchEntityResult a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new GlobalAssistantSearchEntityResult(r1);
        }

        public GlobalAssistantSearchEntityResult[] a(int r1) {
            return new GlobalAssistantSearchEntityResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalAssistantSearchEntityResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalAssistantSearchEntityResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalAssistantSearchEntityResult(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        ArrayList r0 = r4.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(AppEntity.CREATOR, Parcelable.Creator.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L5;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L6:
        this(r1, r4.readInt());
        return;
    L5:
        r1 = CollectionsKt.emptyList();
        goto L6
    }

    public GlobalAssistantSearchEntityResult(List<? extends AppEntity> r3, int r4) {
        List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "entityList");
        this.entityList = r5;
        this.recallTotalCount = r4;
    }

    public /* synthetic */ GlobalAssistantSearchEntityResult(List r2, int r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = r6.size();
    L5:
        this(r6, r3);
    }

    public static /* synthetic */ GlobalAssistantSearchEntityResult copy$default(GlobalAssistantSearchEntityResult r1, List r2, int r3, int r4, Object r5) {
        List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.entityList;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.recallTotalCount;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<AppEntity> component1() {
        return this.entityList;
    }

    public final int component2() {
        return this.recallTotalCount;
    }

    public final GlobalAssistantSearchEntityResult copy(List<? extends AppEntity> r2, int r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entityList");
        return new GlobalAssistantSearchEntityResult(r1, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalAssistantSearchEntityResult.class) == true) goto L8;
        return false;
    L8:
        GlobalAssistantSearchEntityResult r6 = (GlobalAssistantSearchEntityResult) ZeusTransformUtils.preCheckCast(r5, GlobalAssistantSearchEntityResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.entityList, r6.entityList) == true) goto L12;
        return false;
    L12:
        if (this.recallTotalCount == r6.recallTotalCount) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<AppEntity> getEntityList() {
        return this.entityList;
    }

    public final int getRecallTotalCount() {
        return this.recallTotalCount;
    }

    public int hashCode() {
        return (this.entityList.hashCode() * 31) + Integer.hashCode(this.recallTotalCount);
    }

    public String toString() {
        return "GlobalAssistantSearchEntityResult(entityList=" + this.entityList + ", recallTotalCount=" + this.recallTotalCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeTypedList(this.entityList);
        r1.writeInt(this.recallTotalCount);
    }
}
