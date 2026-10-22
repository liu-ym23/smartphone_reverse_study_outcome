package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.ShelfMicroAppInfo")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "Landroid/os/Parcelable;", "", "appId", "Ljava/lang/String;", "name", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "schema", "", "anchorLiveStatus", "I", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/MicroAppLabel;", "label", "Ljava/util/List;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfMicroAppInfo implements Parcelable, h {
    public static final Parcelable.Creator<ShelfMicroAppInfo> CREATOR = null;

    @IgnoreProtoFieldCheck
    @SerializedName("anchor_live_status")
    public final int anchorLiveStatus;

    @SerializedName("app_id")
    public String appId;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("label")
    public List<MicroAppLabel> label;

    @SerializedName("name")
    public String name;

    @SerializedName("schema")
    public String schema;

    public static class a implements Parcelable.Creator<ShelfMicroAppInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfMicroAppInfo createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "in");
            String r2 = r10.readString();
            String r3 = r10.readString();
            ImageModel r4 = r10.readParcelable(ShelfMicroAppInfo.class.getClassLoader());
            String r5 = r10.readString();
            int r6 = r10.readInt();
            if (r10.readInt() == 0) goto L7;
            int r1 = r10.readInt();
            ArrayList r7 = new ArrayList(r1);
        L5:
            if (r1 == 0) goto L9;
            r7.add(MicroAppLabel.CREATOR.createFromParcel(r10));
            r1 = r1 - 1;
        L9:
            return new ShelfMicroAppInfo(r2, r3, r4, r5, r6, r7);
        L7:
            r7 = null;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfMicroAppInfo[] newArray(int r1) {
            return new ShelfMicroAppInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShelfMicroAppInfo(String r1, String r2, ImageModel r3, String r4, int r5, List<MicroAppLabel> r6) {
        this.appId = r1;
        this.name = r2;
        this.icon = r3;
        this.schema = r4;
        this.anchorLiveStatus = r5;
        this.label = r6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShelfMicroAppInfo) == false) goto L18;
        ShelfMicroAppInfo r4 = (ShelfMicroAppInfo) r3;
        if (Intrinsics.areEqual(this.appId, r4.appId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L14;
        return false;
    L14:
        if (this.anchorLiveStatus == r4.anchorLiveStatus) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.label, r4.label) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.appId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ImageModel r7 = this.icon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.schema;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (((r9 + r11) * 31) + this.anchorLiveStatus) * 31;
        List<MicroAppLabel> r13 = this.label;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShelfMicroAppInfo(appId=" + this.appId + ", name=" + this.name + ", icon=" + this.icon + ", schema=" + this.schema + ", anchorLiveStatus=" + this.anchorLiveStatus + ", label=" + this.label + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.appId);
        r3.writeString(this.name);
        r3.writeParcelable(this.icon, r4);
        r3.writeString(this.schema);
        r3.writeInt(this.anchorLiveStatus);
        List<MicroAppLabel> r5 = this.label;
        if (r5 == null) goto L8;
        r3.writeInt(1);
        r3.writeInt(r5.size());
        Iterator<MicroAppLabel> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        r6.next().writeToParcel(r3, 0);
        goto L6
    L11:
        return;
    L8:
        r3.writeInt(0);
    }

    public ShelfMicroAppInfo() {
        this.appId = null;
        this.name = null;
        this.icon = null;
        this.schema = null;
        this.label = null;
    }

    public ShelfMicroAppInfo(am3.g r5) {
        this.label = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.appId = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.name = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.icon = x.a(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.schema = am3.h.c(r5);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.label.add(new MicroAppLabel(r5));
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
        if (this.appId != null) goto L25;
        this.appId = null;
    L25:
        if (this.name != null) goto L28;
        this.name = null;
    L28:
        if (this.icon != null) goto L31;
        this.icon = null;
    L31:
        if (this.schema != null) goto L34;
        this.schema = null;
    L34:
        if (this.label.isEmpty() == false) goto L55;
        this.label = null;
        return;
    }

    public static ShelfMicroAppInfo a(ShelfMicroAppInfo r9, String r10, int r11, int r12) {
        List<MicroAppLabel> r1 = null;
        if ((r12 & 1) == 0) goto L5;
        String r3 = r9.appId;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r4 = r9.name;
    L11:
        if ((r12 & 4) == 0) goto L13;
        ImageModel r5 = r9.icon;
    L15:
        if ((r12 & 8) == 0) goto L17;
        r10 = r9.schema;
    L17:
        String r6 = r10;
        if ((r12 & 16) == 0) goto L20;
        r11 = r9.anchorLiveStatus;
    L20:
        int r7 = r11;
        if ((r12 & 32) == 0) goto L24;
        r1 = r9.label;
    L24:
        return new ShelfMicroAppInfo(r3, r4, r5, r6, r7, r1);
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public /* synthetic */ ShelfMicroAppInfo(String r10, String r11, ImageModel r12, String r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        ImageModel r5 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r15 & 16) == 0) goto L21;
        int r7 = -1;
    L22:
        this(r3, r4, r5, r6, r7, null);
        return;
    L21:
        r7 = r14;
        goto L22
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
