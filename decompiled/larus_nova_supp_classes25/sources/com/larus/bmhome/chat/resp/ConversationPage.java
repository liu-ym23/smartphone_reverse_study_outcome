package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "old data flow")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012JD\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0004J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/resp/ConversationPage;", "Landroid/os/Parcelable;", "pageList", "", "", "bizType", "defaultStatus", "showActionBar", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getPageList", "()Ljava/util/List;", "getBizType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultStatus", "getShowActionBar", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/resp/ConversationPage;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationPage implements Parcelable {
    public static final Parcelable.Creator<ConversationPage> CREATOR = null;

    @SerializedName("biz_type")
    private final Integer bizType;

    @SerializedName("default_status")
    private final Integer defaultStatus;

    @SerializedName("page_list")
    private final List<Integer> pageList;

    @SerializedName("show_action_bar")
    private final Boolean showActionBar;

    public static final class a implements Parcelable.Creator<ConversationPage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConversationPage createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            boolean r1 = false;
            Boolean r2 = null;
            if (r7.readInt() != 0) goto L5;
            ArrayList r3 = null;
        L9:
            if (r7.readInt() != 0) goto L11;
            Integer r0 = null;
        L13:
            if (r7.readInt() != 0) goto L15;
            Integer r4 = null;
        L17:
            if (r7.readInt() == 0) goto L24;
            if (r7.readInt() == 0) goto L22;
            r1 = true;
        L22:
            r2 = Boolean.valueOf(r1);
        L24:
            return new ConversationPage(r3, r0, r4, r2);
        L15:
            r4 = Integer.valueOf(r7.readInt());
            goto L17
        L11:
            r0 = Integer.valueOf(r7.readInt());
            goto L13
        L5:
            int r5 = r7.readInt();
            r3 = new ArrayList(r5);
            int r6 = 0;
        L6:
            if (r6 == r5) goto L9;
            r3.add(Integer.valueOf(r7.readInt()));
            r6 = r6 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ConversationPage[] newArray(int r1) {
            return new ConversationPage[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ConversationPage() {
        this(null, 0, 1, Boolean.FALSE);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ConversationPage) == true) goto L8;
        return false;
    L8:
        ConversationPage r6 = (ConversationPage) r5;
        if (Intrinsics.areEqual(this.pageList, r6.pageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizType, r6.bizType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultStatus, r6.defaultStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showActionBar, r6.showActionBar) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<Integer> r0 = this.pageList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.bizType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.defaultStatus;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.showActionBar;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationPage(pageList=" + this.pageList + ", bizType=" + this.bizType + ", defaultStatus=" + this.defaultStatus + ", showActionBar=" + this.showActionBar + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        List<Integer> r6 = this.pageList;
        if (r6 != null) goto L5;
        r4.writeInt(0);
    L9:
        Integer r7 = this.bizType;
        if (r7 != null) goto L12;
        r4.writeInt(0);
    L13:
        Integer r8 = this.defaultStatus;
        if (r8 != null) goto L16;
        r4.writeInt(0);
    L17:
        Boolean r9 = this.showActionBar;
        if (r9 != null) goto L20;
        r4.writeInt(0);
        return;
    L20:
        r4.writeInt(1);
        r4.writeInt(r9.booleanValue() ? 1 : 0);
        return;
    L16:
        r4.writeInt(1);
        r4.writeInt(r8.intValue());
        goto L17
    L12:
        r4.writeInt(1);
        r4.writeInt(r7.intValue());
        goto L13
    L5:
        r4.writeInt(1);
        r4.writeInt(r6.size());
        Iterator<Integer> r10 = r6.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r4.writeInt(r10.next().intValue());
        goto L7
    }

    public ConversationPage(List<Integer> r1, Integer r2, Integer r3, Boolean r4) {
        this.pageList = r1;
        this.bizType = r2;
        this.defaultStatus = r3;
        this.showActionBar = r4;
    }
}
