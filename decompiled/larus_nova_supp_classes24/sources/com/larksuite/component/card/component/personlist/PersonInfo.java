package com.larksuite.component.card.component.personlist;

import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0010¨\u0006("}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonInfo;", "Landroid/os/Parcelable;", "id", "", "type", "avatarKey", "tag", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "getAvatarKey", "setAvatarKey", "(Ljava/lang/String;)V", "getTag", "()Ljava/util/List;", "getContent", "setContent", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonInfo implements Parcelable {
    public static final Parcelable.Creator<PersonInfo> CREATOR = null;
    private String avatarKey;
    private String content;
    private final String id;
    private final List<String> tag;
    private final String type;

    public static final class a implements Parcelable.Creator<PersonInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersonInfo createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            return new PersonInfo(r8.readString(), r8.readString(), r8.readString(), r8.createStringArrayList(), r8.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PersonInfo[] newArray(int r1) {
            return new PersonInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonInfo copy$default(PersonInfo r3, String r4, String r5, String r6, List r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.id;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.type;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.avatarKey;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.tag;
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.content;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final List<String> component4() {
        return this.tag;
    }

    public final String component5() {
        return this.content;
    }

    public final PersonInfo copy(String r8, String r9, String r10, List<String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "type");
        return new PersonInfo(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PersonInfo) == true) goto L8;
        return false;
    L8:
        PersonInfo r6 = (PersonInfo) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.type.hashCode()) * 31;
        String r4 = this.avatarKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.tag;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.content;
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

    public String toString() {
        return "PersonInfo(id=" + this.id + ", type=" + this.type + ", avatarKey=" + this.avatarKey + ", tag=" + this.tag + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.id);
        r1.writeString(this.type);
        r1.writeString(this.avatarKey);
        r1.writeStringList(this.tag);
        r1.writeString(this.content);
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getTag() {
        return this.tag;
    }

    public final String getType() {
        return this.type;
    }

    public final void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public PersonInfo(String r2, String r3, String r4, List<String> r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.id = r2;
        this.type = r3;
        this.avatarKey = r4;
        this.tag = r5;
        this.content = r6;
    }

    public /* synthetic */ PersonInfo(String r8, String r9, String r10, List r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        List r5 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        String r6 = null;
    L14:
        this(r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
