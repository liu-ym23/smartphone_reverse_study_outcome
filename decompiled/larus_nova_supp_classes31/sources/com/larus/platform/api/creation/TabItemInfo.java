package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/larus/platform/api/creation/TabItemInfo;", "Landroid/os/Parcelable;", "id", "", "starlingKey", "name", "supportTextReplace", "", "displayExtra", "Lcom/larus/platform/api/creation/DisplayExtra;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/platform/api/creation/DisplayExtra;)V", "getId", "()Ljava/lang/String;", "getStarlingKey", "getName", "getSupportTextReplace", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplayExtra", "()Lcom/larus/platform/api/creation/DisplayExtra;", "getTrackerTabType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/platform/api/creation/DisplayExtra;)Lcom/larus/platform/api/creation/TabItemInfo;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TabItemInfo implements Parcelable {
    public static final Parcelable.Creator<TabItemInfo> CREATOR = null;

    @SerializedName("display_extra")
    private final DisplayExtra displayExtra;

    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;

    @SerializedName("starling_key")
    private final String starlingKey;

    @SerializedName("support_text_replace")
    private final Boolean supportTextReplace;

    public static final class a implements Parcelable.Creator<TabItemInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TabItemInfo createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r2 = r8.readString();
            String r3 = r8.readString();
            String r4 = r8.readString();
            DisplayExtra r5 = null;
            if (r8.readInt() != 0) goto L6;
            Boolean r6 = null;
        L11:
            if (r8.readInt() == 0) goto L15;
            r5 = DisplayExtra.CREATOR.createFromParcel(r8);
        L15:
            return new TabItemInfo(r2, r3, r4, r6, r5);
        L6:
            if (r8.readInt() == 0) goto L8;
            boolean r1 = true;
        L9:
            r6 = Boolean.valueOf(r1);
            goto L11
        L8:
            r1 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final TabItemInfo[] newArray(int r1) {
            return new TabItemInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public TabItemInfo() {
        this(null, null, null, null, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TabItemInfo) == true) goto L8;
        return false;
    L8:
        TabItemInfo r6 = (TabItemInfo) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.starlingKey, r6.starlingKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportTextReplace, r6.supportTextReplace) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.displayExtra, r6.displayExtra) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.starlingKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.name;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.supportTextReplace;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        DisplayExtra r13 = this.displayExtra;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "TabItemInfo(id=" + this.id + ", starlingKey=" + this.starlingKey + ", name=" + this.name + ", supportTextReplace=" + this.supportTextReplace + ", displayExtra=" + this.displayExtra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.id);
        r4.writeString(this.starlingKey);
        r4.writeString(this.name);
        Boolean r0 = this.supportTextReplace;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        DisplayExtra r1 = this.displayExtra;
        if (r1 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }

    public final DisplayExtra a() {
        return this.displayExtra;
    }

    public final String b() {
        return this.starlingKey;
    }

    public final Boolean c() {
        return this.supportTextReplace;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ TabItemInfo(String r9, String r10, String r11, Boolean r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        Boolean r6 = null;
    L18:
        this(r3, r4, r5, r6, null);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public TabItemInfo(String r1, String r2, String r3, Boolean r4, DisplayExtra r5) {
        this.id = r1;
        this.starlingKey = r2;
        this.name = r3;
        this.supportTextReplace = r4;
        this.displayExtra = r5;
    }
}
