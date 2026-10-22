package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/SmsCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "categoryType", "", "categoryName", Params.CONTENT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getCategoryType", "getContent", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<SmsCondition> CREATOR = null;
    private final String categoryName;
    private final String categoryType;
    private final String content;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<SmsCondition> {
        public a() {
        }

        public final SmsCondition a(Parcel r5) {
            int r4 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            SmsCondition r0 = new SmsCondition(r5.readString(), r5.readString(), r5.readString());
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = a.class.getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r1) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r4) goto L7;
            com.obric.b.a.a(r5, r2);
            r3 = r3 + 1;
            goto L5
        L7:
            return r0;
        }

        public final SmsCondition[] a(int r1) {
            return new SmsCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SmsCondition createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SmsCondition[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public SmsCondition(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "categoryType");
        Intrinsics.checkNotNullParameter(r3, "categoryName");
        this.categoryType = r2;
        this.categoryName = r3;
        this.content = r4;
    }

    public /* synthetic */ SmsCondition(String r1, String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ SmsCondition copy$default(SmsCondition r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.categoryType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.categoryName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.content;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.categoryType;
    }

    public final String component2() {
        return this.categoryName;
    }

    public final String component3() {
        return this.content;
    }

    public final SmsCondition copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "categoryType");
        Intrinsics.checkNotNullParameter(r2, "categoryName");
        return new SmsCondition(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SmsCondition.class) == true) goto L8;
        return false;
    L8:
        SmsCondition r6 = (SmsCondition) ZeusTransformUtils.preCheckCast(r5, SmsCondition.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.categoryType, r6.categoryType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.categoryName, r6.categoryName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getCategoryType() {
        return this.categoryType;
    }

    public final String getContent() {
        return this.content;
    }

    public int hashCode() {
        int r0 = ((this.categoryType.hashCode() * 31) + this.categoryName.hashCode()) * 31;
        String r2 = this.content;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SmsCondition(categoryType=" + this.categoryType + ", categoryName=" + this.categoryName + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.categoryType);
        r1.writeString(this.categoryName);
        r1.writeString(this.content);
    }
}
