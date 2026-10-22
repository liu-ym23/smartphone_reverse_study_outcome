package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;", "Landroid/os/Parcelable;", "kgRelation", "", "", "<init>", "(Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getKgRelation", "()Ljava/util/List;", "writeToParcel", "", "flags", "", "describeContents", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class GlobalAssistantSearchKgResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<String> kgRelation;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalAssistantSearchKgResult copy$default(GlobalAssistantSearchKgResult r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.kgRelation;
    L6:
        return r0.copy(r1);
    }

    public final List<String> component1() {
        return this.kgRelation;
    }

    public final GlobalAssistantSearchKgResult copy(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "kgRelation");
        return new GlobalAssistantSearchKgResult(r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof GlobalAssistantSearchKgResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.kgRelation, ((GlobalAssistantSearchKgResult) r4).kgRelation) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.kgRelation.hashCode();
    }

    public String toString() {
        return "GlobalAssistantSearchKgResult(kgRelation=" + this.kgRelation + ')';
    }

    public final List<String> getKgRelation() {
        return this.kgRelation;
    }

    public GlobalAssistantSearchKgResult(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        List r3 = r2.createStringArrayList();
        if (r3 != null) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        this(r3);
    }

    public GlobalAssistantSearchKgResult(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "kgRelation");
        this.kgRelation = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeStringList(this.kgRelation);
    }
}
