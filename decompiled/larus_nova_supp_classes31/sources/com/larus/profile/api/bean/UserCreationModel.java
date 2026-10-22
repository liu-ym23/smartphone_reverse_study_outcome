package com.larus.profile.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0003J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/larus/profile/api/bean/UserCreationModel;", "Landroid/os/Parcelable;", "dataType", "", "creationList", "", "Lcom/larus/platform/api/creation/UserCreation;", "modelId", "", "<init>", "(ILjava/util/List;Ljava/lang/String;)V", "getDataType", "()I", "getCreationList", "()Ljava/util/List;", "setCreationList", "(Ljava/util/List;)V", "getModelId", "()Ljava/lang/String;", "setModelId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UserCreationModel implements Parcelable {
    public static final Parcelable.Creator<UserCreationModel> CREATOR = null;

    @SerializedName("creation_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<UserCreation> creationList;

    @SerializedName("data_type")
    private final int dataType;

    @SerializedName("model_id")
    private String modelId;

    public static final class a implements Parcelable.Creator<UserCreationModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationModel createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            int r0 = r6.readInt();
            if (r6.readInt() != 0) goto L5;
            ArrayList r1 = null;
        L10:
            return new UserCreationModel(r0, r1, r6.readString());
        L5:
            int r2 = r6.readInt();
            ArrayList r3 = new ArrayList(r2);
            int r4 = 0;
        L6:
            if (r4 == r2) goto L8;
            r3.add(r6.readParcelable(UserCreationModel.class.getClassLoader()));
            r4 = r4 + 1;
            goto L6
        L8:
            r1 = r3;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationModel[] newArray(int r1) {
            return new UserCreationModel[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserCreationModel() {
        int r2 = 0;
        Object[] r0 = 0 == true ? 1 : 0;
        this(r2, null, r0, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationModel) == true) goto L8;
        return false;
    L8:
        UserCreationModel r6 = (UserCreationModel) r5;
        if (this.dataType == r6.dataType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationList, r6.creationList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelId, r6.modelId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.dataType * 31;
        List<UserCreation> r1 = this.creationList;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.modelId;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserCreationModel(dataType=" + this.dataType + ", creationList=" + this.creationList + ", modelId=" + this.modelId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.dataType);
        List<UserCreation> r0 = this.creationList;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L9:
        r3.writeString(this.modelId);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.size());
        Iterator<UserCreation> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r3.writeParcelable(r1.next(), r4);
        goto L7
    }

    public final List<UserCreation> b() {
        return this.creationList;
    }

    public final int c() {
        return this.dataType;
    }

    public final String d() {
        return this.modelId;
    }

    public final void e(List<UserCreation> r1) {
        this.creationList = r1;
    }

    public final void g(String r1) {
        this.modelId = r1;
    }

    public static UserCreationModel a(UserCreationModel r2, List r3) {
        int r0 = r2.dataType;
        String r1 = r2.modelId;
        r2.getClass();
        return new UserCreationModel(r0, r3, r1);
    }

    public UserCreationModel(int r1, List<UserCreation> r2, String r3) {
        this.dataType = r1;
        this.creationList = r2;
        this.modelId = r3;
    }

    public /* synthetic */ UserCreationModel(int r2, List r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = new ArrayList();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
