package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", "Landroid/os/Parcelable;", "events", "", "", "entityList", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getEvents", "()Ljava/util/List;", "getEntityList", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ProactiveRecommendationSearchResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<ProactiveMemoryEntity> entityList;
    private final List<String> events;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProactiveRecommendationSearchResult copy$default(ProactiveRecommendationSearchResult r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.events;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.entityList;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.events;
    }

    public final List<ProactiveMemoryEntity> component2() {
        return this.entityList;
    }

    public final ProactiveRecommendationSearchResult copy(List<String> r2, List<ProactiveMemoryEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "events");
        Intrinsics.checkNotNullParameter(r3, "entityList");
        return new ProactiveRecommendationSearchResult(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ProactiveRecommendationSearchResult) == true) goto L8;
        return false;
    L8:
        ProactiveRecommendationSearchResult r6 = (ProactiveRecommendationSearchResult) r5;
        if (Intrinsics.areEqual(this.events, r6.events) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityList, r6.entityList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.events.hashCode() * 31) + this.entityList.hashCode();
    }

    public String toString() {
        return "ProactiveRecommendationSearchResult(events=" + this.events + ", entityList=" + this.entityList + ')';
    }

    public final List<ProactiveMemoryEntity> getEntityList() {
        return this.entityList;
    }

    public final List<String> getEvents() {
        return this.events;
    }

    public ProactiveRecommendationSearchResult(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        ArrayList<String> r0 = r3.createStringArrayList();
        Intrinsics.checkNotNull(r0);
        ArrayList r4 = r3.createTypedArrayList(ProactiveMemoryEntity.CREATOR);
        Intrinsics.checkNotNull(r4);
        this(r0, r4);
    }

    public ProactiveRecommendationSearchResult(List<String> r2, List<ProactiveMemoryEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "events");
        Intrinsics.checkNotNullParameter(r3, "entityList");
        this.events = r2;
        this.entityList = r3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeStringList(this.events);
        r1.writeTypedList(this.entityList);
    }
}
