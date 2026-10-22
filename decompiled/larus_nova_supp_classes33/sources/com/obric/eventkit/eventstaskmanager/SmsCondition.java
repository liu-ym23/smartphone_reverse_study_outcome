package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/SmsCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "categoryType", "", "categoryName", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getCategoryType", "getContent", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<SmsCondition> CREATOR = null;
    private final String categoryName;
    private final String categoryType;
    private final String content;

    public static final class a implements Parcelable.Creator<SmsCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SmsCondition createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            SmsCondition r1 = new SmsCondition(r6.readString(), r6.readString(), r6.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r3 = a.class.getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r2) goto L5;
            r4 = r4 + 1;
        L5:
            if (r4 > r0) goto L7;
            joa.a.d(r6, r3);
            r4 = r4 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final SmsCondition[] newArray(int r1) {
            return new SmsCondition[r1];
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

    public final SmsCondition copy(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "categoryType");
        Intrinsics.checkNotNullParameter(r3, "categoryName");
        return new SmsCondition(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SmsCondition) == true) goto L8;
        return false;
    L8:
        SmsCondition r6 = (SmsCondition) r5;
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
        String r1 = this.content;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
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
