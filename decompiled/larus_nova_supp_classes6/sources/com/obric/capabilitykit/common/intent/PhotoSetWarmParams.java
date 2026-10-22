package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\u0010\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0#H\u0016J\t\u0010$\u001a\u00020\tHÖ\u0001J\b\u0010%\u001a\u00020\u001fH\u0016J\u0012\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010!H\u0016J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSetWarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "valueType", "", "value", "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/String;Ljava/lang/Integer;)V", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getValue", "()Ljava/lang/Integer;", "setValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getValueType", "()Ljava/lang/String;", "setValueType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoSetWarmParams;", "describeContents", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PhotoSetWarmParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoSetWarmParams> CREATOR = null;
    private PhotoEntity photo;
    private Integer value;
    private String valueType;

    static {
        CREATOR = new a();
    }

    public PhotoSetWarmParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PhotoSetWarmParams copy$default(PhotoSetWarmParams r0, PhotoEntity r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.photo;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.valueType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.value;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final String component2() {
        return this.valueType;
    }

    public final Integer component3() {
        return this.value;
    }

    public final PhotoSetWarmParams copy(PhotoEntity r2, String r3, Integer r4) {
        return new PhotoSetWarmParams(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhotoSetWarmParams) == true) goto L8;
        return false;
    L8:
        PhotoSetWarmParams r6 = (PhotoSetWarmParams) r5;
        if (Intrinsics.areEqual(this.photo, r6.photo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.valueType, r6.valueType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.value, r6.value) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        PhotoEntity r0 = this.photo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.valueType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.value;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetWarmParams(photo=" + this.photo + ", valueType=" + this.valueType + ", value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeParcelable(this.photo, r4);
        r3.writeString(this.valueType);
        Integer r5 = this.value;
        if (r5 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.photo);
    }

    public boolean isParamsCompleted() {
        if (this.photo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final Integer getValue() {
        return this.value;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof PhotoSetWarmParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity r0 = this.photo;
        if (r0 != null) goto L8;
        r0 = ((PhotoSetWarmParams) r4).photo;
    L8:
        String r1 = this.valueType;
        if (r1 != null) goto L11;
        r1 = ((PhotoSetWarmParams) r4).valueType;
    L11:
        Integer r2 = this.value;
        if (r2 != null) goto L15;
        r2 = ((PhotoSetWarmParams) r4).value;
    L15:
        return new PhotoSetWarmParams(r0, r1, r2);
    }

    public final void setPhoto(PhotoEntity r1) {
        this.photo = r1;
    }

    public final void setValue(Integer r1) {
        this.value = r1;
    }

    public final void setValueType(String r1) {
        this.valueType = r1;
    }

    public PhotoSetWarmParams(PhotoEntity r1, String r2, Integer r3) {
        this.photo = r1;
        this.valueType = r2;
        this.value = r3;
    }

    public /* synthetic */ PhotoSetWarmParams(PhotoEntity r2, String r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
