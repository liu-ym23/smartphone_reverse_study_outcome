package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0083\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0010J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u008c\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u000207HÖ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u000207HÖ\u0001J\u0012\u0010=\u001a\u00020\u00012\b\u0010>\u001a\u0004\u0018\u00010;H\u0016J\t\u0010?\u001a\u00020\u0004HÖ\u0001J\u0019\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u000207HÖ\u0001R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "name", "", "telephones", "", "Lcom/obric/capabilitykit/common/intent/Telephone;", "company", "note", "email", "identifyCard", "gender", "birthday", "relationship", "address", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getBirthday", "setBirthday", "getCompany", "setCompany", "getEmail", "setEmail", "getGender", "setGender", "getIdentifyCard", "setIdentifyCard", "getName", "setName", "getNote", "setNote", "getRelationship", "setRelationship", "getTelephones", "()[Lcom/obric/capabilitykit/common/intent/Telephone;", "setTelephones", "([Lcom/obric/capabilitykit/common/intent/Telephone;)V", "[Lcom/obric/capabilitykit/common/intent/Telephone;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ContactsCreateParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ContactsCreateParams> CREATOR = null;
    private String address;
    private String birthday;
    private String company;
    private String email;
    private String gender;
    private String identifyCard;
    private String name;
    private String note;
    private String relationship;
    private Telephone[] telephones;

    static {
        CREATOR = new a();
    }

    public ContactsCreateParams() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ ContactsCreateParams copy$default(ContactsCreateParams r11, String r12, Telephone[] r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.name;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Telephone[] r3 = r11.telephones;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.company;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.note;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.email;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.identifyCard;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.gender;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.birthday;
    L35:
        if ((r22 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = r11.relationship;
    L39:
        if ((r22 & ISmModel.VERSION_0200) == 0) goto L41;
        String r1 = r11.address;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.address;
    }

    public final Telephone[] component2() {
        return this.telephones;
    }

    public final String component3() {
        return this.company;
    }

    public final String component4() {
        return this.note;
    }

    public final String component5() {
        return this.email;
    }

    public final String component6() {
        return this.identifyCard;
    }

    public final String component7() {
        return this.gender;
    }

    public final String component8() {
        return this.birthday;
    }

    public final String component9() {
        return this.relationship;
    }

    public final ContactsCreateParams copy(String r13, Telephone[] r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        return new ContactsCreateParams(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactsCreateParams) == true) goto L8;
        return false;
    L8:
        ContactsCreateParams r6 = (ContactsCreateParams) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.telephones, r6.telephones) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.company, r6.company) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.note, r6.note) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.email, r6.email) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.identifyCard, r6.identifyCard) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.gender, r6.gender) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.birthday, r6.birthday) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.relationship, r6.relationship) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.address, r6.address) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Telephone[] r4 = this.telephones;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.company;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.note;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.email;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.identifyCard;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.gender;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.birthday;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.relationship;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.address;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = Arrays.hashCode(r4);
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "ContactsCreateParams(name=" + this.name + ", telephones=" + Arrays.toString(this.telephones) + ", company=" + this.company + ", note=" + this.note + ", email=" + this.email + ", identifyCard=" + this.identifyCard + ", gender=" + this.gender + ", birthday=" + this.birthday + ", relationship=" + this.relationship + ", address=" + this.address + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeString(this.name);
        Telephone[] r1 = this.telephones;
        if (r1 != null) goto L5;
        r5.writeInt(0);
    L8:
        r5.writeString(this.company);
        r5.writeString(this.note);
        r5.writeString(this.email);
        r5.writeString(this.identifyCard);
        r5.writeString(this.gender);
        r5.writeString(this.birthday);
        r5.writeString(this.relationship);
        r5.writeString(this.address);
        return;
    L5:
        r5.writeInt(1);
        int r2 = r1.length;
        r5.writeInt(r2);
    L6:
        if (r0 == r2) goto L8;
        r1[r0].writeToParcel(r5, r6);
        r0 = r0 + 1;
        goto L6
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCompany() {
        return this.company;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getIdentifyCard() {
        return this.identifyCard;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getRelationship() {
        return this.relationship;
    }

    public final Telephone[] getTelephones() {
        return this.telephones;
    }

    public IntentParams mergeParams(Object r13) {
        if ((r13 instanceof ContactsCreateParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.name;
        if (r0 != null) goto L8;
        r0 = ((ContactsCreateParams) r13).name;
    L8:
        String r2 = r0;
        Telephone[] r1 = this.telephones;
        if (r1 != null) goto L11;
        r1 = ((ContactsCreateParams) r13).telephones;
    L11:
        Telephone[] r3 = r1;
        String r4 = this.company;
        if (r4 != null) goto L14;
        r4 = ((ContactsCreateParams) r13).company;
    L14:
        String r5 = r4;
        String r6 = this.note;
        if (r6 != null) goto L17;
        r6 = ((ContactsCreateParams) r13).note;
    L17:
        String r7 = r6;
        String r8 = this.email;
        if (r8 != null) goto L20;
        r8 = ((ContactsCreateParams) r13).email;
    L20:
        String r9 = r8;
        String r10 = this.identifyCard;
        if (r10 != null) goto L23;
        r10 = ((ContactsCreateParams) r13).identifyCard;
    L23:
        String r11 = r10;
        String r12 = this.gender;
        if (r12 != null) goto L26;
        r12 = ((ContactsCreateParams) r13).gender;
    L26:
        String r14 = r12;
        String r15 = this.birthday;
        if (r15 != null) goto L29;
        r15 = ((ContactsCreateParams) r13).birthday;
    L29:
        String r16 = r15;
        String r17 = this.relationship;
        if (r17 != null) goto L32;
        r17 = ((ContactsCreateParams) r13).relationship;
    L32:
        String r18 = r17;
        String r19 = this.address;
        if (r19 != null) goto L35;
        String r110 = ((ContactsCreateParams) r13).address;
    L37:
        return new ContactsCreateParams(r2, r3, r5, r7, r9, r11, r14, r16, r18, r110);
    L35:
        r110 = r19;
        goto L37
    }

    public final void setAddress(String r1) {
        this.address = r1;
    }

    public final void setBirthday(String r1) {
        this.birthday = r1;
    }

    public final void setCompany(String r1) {
        this.company = r1;
    }

    public final void setEmail(String r1) {
        this.email = r1;
    }

    public final void setGender(String r1) {
        this.gender = r1;
    }

    public final void setIdentifyCard(String r1) {
        this.identifyCard = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setNote(String r1) {
        this.note = r1;
    }

    public final void setRelationship(String r1) {
        this.relationship = r1;
    }

    public final void setTelephones(Telephone[] r1) {
        this.telephones = r1;
    }

    public ContactsCreateParams(String r1, Telephone[] r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        this.name = r1;
        this.telephones = r2;
        this.company = r3;
        this.note = r4;
        this.email = r5;
        this.identifyCard = r6;
        this.gender = r7;
        this.birthday = r8;
        this.relationship = r9;
        this.address = r10;
    }

    public /* synthetic */ ContactsCreateParams(String r12, Telephone[] r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
        String r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Telephone[] r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r22 & ISmModel.VERSION_0200) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
