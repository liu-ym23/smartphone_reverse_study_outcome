package com.obric.memorydata.sdk.realtime;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/IMActionContext;", "Lcom/obric/memorydata/sdk/realtime/ActionContext;", "type", "", "packageName", "", "activityName", "bitmap", "Landroid/graphics/Bitmap;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "getType", "()I", "getPackageName", "()Ljava/lang/String;", "getActivityName", "getBitmap", "()Landroid/graphics/Bitmap;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "component1", "component2", "component3", "component4", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IMActionContext extends ActionContext {
    public static final CREATOR CREATOR = null;
    private final String activityName;
    private final Bitmap bitmap;
    private final String packageName;
    private final int type;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/IMActionContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/realtime/IMActionContext;", "<init>", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/realtime/IMActionContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<IMActionContext> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IMActionContext createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "source");
            String r3 = r9.readString();
            Intrinsics.checkNotNull(r3);
            String r4 = r9.readString();
            Intrinsics.checkNotNull(r4);
            Parcelable r10 = r9.readParcelable(Bitmap.class.getClassLoader());
            Intrinsics.checkNotNull(r10);
            return new IMActionContext(0, r3, r4, (Bitmap) r10, 1, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IMActionContext[] newArray(int r1) {
            return newArray(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IMActionContext createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IMActionContext[] newArray(int r1) {
            return new IMActionContext[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ IMActionContext copy$default(IMActionContext r0, int r1, String r2, String r3, Bitmap r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.packageName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.activityName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.bitmap;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.activityName;
    }

    public final Bitmap component4() {
        return this.bitmap;
    }

    public final IMActionContext copy(int r2, String r3, String r4, Bitmap r5) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "activityName");
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        return new IMActionContext(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IMActionContext) == true) goto L8;
        return false;
    L8:
        IMActionContext r6 = (IMActionContext) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.activityName, r6.activityName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bitmap, r6.bitmap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.type * 31) + this.packageName.hashCode()) * 31) + this.activityName.hashCode()) * 31) + this.bitmap.hashCode();
    }

    public String toString() {
        return "IMActionContext(type=" + this.type + ", packageName=" + this.packageName + ", activityName=" + this.activityName + ", bitmap=" + this.bitmap + ')';
    }

    public String getActivityName() {
        return this.activityName;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getType() {
        return this.type;
    }

    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        super.writeToParcelBase(r2, r3);
        r2.writeString(getPackageName());
        r2.writeString(getActivityName());
        r2.writeParcelable(this.bitmap, r3);
    }

    public IMActionContext(int r2, String r3, String r4, Bitmap r5) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "activityName");
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        this.type = r2;
        this.packageName = r3;
        this.activityName = r4;
        this.bitmap = r5;
    }

    public /* synthetic */ IMActionContext(int r1, String r2, String r3, Bitmap r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L5;
        r1 = 4;
    L5:
        this(r1, r2, r3, r4);
    }
}
