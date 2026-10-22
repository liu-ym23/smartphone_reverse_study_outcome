package com.larus.e_commerce.impl.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/larus/e_commerce/impl/order/OrderSchemaInfoData;", "Landroid/os/Parcelable;", "schemaInfoList", "", "Lcom/larus/e_commerce/impl/order/OrderSchemaData;", "<init>", "(Ljava/util/List;)V", "getSchemaInfoList", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderSchemaInfoData implements Parcelable {
    public static final Parcelable.Creator<OrderSchemaInfoData> CREATOR = null;

    @SerializedName("schema_info_list")
    private final List<OrderSchemaData> schemaInfoList;

    public static final class a implements Parcelable.Creator<OrderSchemaInfoData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OrderSchemaInfoData createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            ArrayList r1 = null;
            if (r6.readInt() == 0) goto L14;
            int r0 = r6.readInt();
            ArrayList r2 = new ArrayList(r0);
            int r3 = 0;
        L6:
            if (r3 == r0) goto L12;
            if (r6.readInt() != 0) goto L10;
            OrderSchemaData r4 = null;
        L11:
            r2.add(r4);
            r3 = r3 + 1;
            goto L6
        L10:
            r4 = OrderSchemaData.CREATOR.createFromParcel(r6);
            goto L11
        L12:
            r1 = r2;
        L14:
            return new OrderSchemaInfoData(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final OrderSchemaInfoData[] newArray(int r1) {
            return new OrderSchemaInfoData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof OrderSchemaInfoData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.schemaInfoList, ((OrderSchemaInfoData) r4).schemaInfoList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<OrderSchemaData> r0 = this.schemaInfoList;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "OrderSchemaInfoData(schemaInfoList=" + this.schemaInfoList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<OrderSchemaData> r0 = this.schemaInfoList;
        if (r0 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<OrderSchemaData> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L19;
        OrderSchemaData r3 = r1.next();
        if (r3 == null) goto L10;
        r5.writeInt(1);
        r3.writeToParcel(r5, r6);
        goto L7
    L10:
        r5.writeInt(0);
        goto L7
    }

    public OrderSchemaInfoData() {
        this(CollectionsKt.emptyList());
    }

    public final List<OrderSchemaData> a() {
        return this.schemaInfoList;
    }

    public OrderSchemaInfoData(List<OrderSchemaData> r1) {
        this.schemaInfoList = r1;
    }
}
