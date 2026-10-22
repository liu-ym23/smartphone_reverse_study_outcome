package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", "Landroid/os/Parcelable;", "events", "", "", "entityList", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getEvents", "()Ljava/util/List;", "getEntityList", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveRecommendationSearchResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<ProactiveMemoryEntity> entityList;
    private final List<String> events;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveRecommendationSearchResult> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public ProactiveRecommendationSearchResult a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ProactiveRecommendationSearchResult(r1);
        }

        public ProactiveRecommendationSearchResult[] a(int r1) {
            return new ProactiveRecommendationSearchResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveRecommendationSearchResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveRecommendationSearchResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public ProactiveRecommendationSearchResult(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        ArrayList<String> r0 = r5.createStringArrayList();
        Intrinsics.checkNotNull(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        ArrayList r6 = r5.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(ProactiveMemoryEntity.CREATOR, Parcelable.Creator.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r6);
        this(r1, (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"));
    }

    public ProactiveRecommendationSearchResult(List<String> r3, List<ProactiveMemoryEntity> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<ProactiveMemoryEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "events");
        Intrinsics.checkNotNullParameter(r6, "entityList");
        this.events = r5;
        this.entityList = r6;
    }

    public static /* synthetic */ ProactiveRecommendationSearchResult copy$default(ProactiveRecommendationSearchResult r1, List r2, List r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<ProactiveMemoryEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.events;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.entityList;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<String> component1() {
        return this.events;
    }

    public final List<ProactiveMemoryEntity> component2() {
        return this.entityList;
    }

    public final ProactiveRecommendationSearchResult copy(List<String> r2, List<ProactiveMemoryEntity> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "events");
        Intrinsics.checkNotNullParameter(r4, "entityList");
        return new ProactiveRecommendationSearchResult(r1, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProactiveRecommendationSearchResult.class) == true) goto L8;
        return false;
    L8:
        ProactiveRecommendationSearchResult r6 = (ProactiveRecommendationSearchResult) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationSearchResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.events, r6.events) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityList, r6.entityList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<ProactiveMemoryEntity> getEntityList() {
        return this.entityList;
    }

    public final List<String> getEvents() {
        return this.events;
    }

    public int hashCode() {
        return (this.events.hashCode() * 31) + this.entityList.hashCode();
    }

    public String toString() {
        return "ProactiveRecommendationSearchResult(events=" + this.events + ", entityList=" + this.entityList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeStringList(this.events);
        r1.writeTypedList(this.entityList);
    }
}
