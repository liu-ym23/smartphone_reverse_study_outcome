package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u008f\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0098\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010=J\t\u0010>\u001a\u00020?HÖ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\u0010\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0EH\u0016J\t\u0010F\u001a\u00020?HÖ\u0001J\b\u0010G\u001a\u00020AH\u0016J\u0012\u0010H\u001a\u00020\u00012\b\u0010I\u001a\u0004\u0018\u00010CH\u0016J\t\u0010J\u001a\u00020\u0007HÖ\u0001J\u0019\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020?HÖ\u0001R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006P"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "name", "", "telephones", "", "Lcom/obric/capabilitykit/common/intent/Telephone;", "company", "note", "email", "identifyCard", "gender", "birthday", "relationship", "address", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getBirthday", "setBirthday", "getCompany", "setCompany", "getEmail", "setEmail", "getGender", "setGender", "getIdentifyCard", "setIdentifyCard", "getName", "setName", "getNote", "setNote", "getRelationship", "setRelationship", "getTarget", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getTelephones", "()[Lcom/obric/capabilitykit/common/intent/Telephone;", "setTelephones", "([Lcom/obric/capabilitykit/common/intent/Telephone;)V", "[Lcom/obric/capabilitykit/common/intent/Telephone;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Telephone;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ContactsUpdateParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<ContactsUpdateParams> CREATOR = null;
    private String address;
    private String birthday;
    private String company;
    private String email;
    private String gender;
    private String identifyCard;
    private String name;
    private String note;
    private String relationship;
    private ContactEntity target;
    private Telephone[] telephones;

    static {
        CREATOR = new a();
    }

    public ContactsUpdateParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ ContactsUpdateParams copy$default(ContactsUpdateParams r12, ContactEntity r13, String r14, Telephone[] r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        ContactEntity r2 = r12.target;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.name;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Telephone[] r4 = r12.telephones;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.company;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.note;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.email;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.identifyCard;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.gender;
    L35:
        if ((r24 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = r12.birthday;
    L39:
        if ((r24 & ISmModel.VERSION_0200) == 0) goto L41;
        String r11 = r12.relationship;
    L43:
        if ((r24 & ISmModel.VERSION_0400) == 0) goto L45;
        String r1 = r12.address;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final ContactEntity component1() {
        return this.target;
    }

    public final String component10() {
        return this.relationship;
    }

    public final String component11() {
        return this.address;
    }

    public final String component2() {
        return this.name;
    }

    public final Telephone[] component3() {
        return this.telephones;
    }

    public final String component4() {
        return this.company;
    }

    public final String component5() {
        return this.note;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.identifyCard;
    }

    public final String component8() {
        return this.gender;
    }

    public final String component9() {
        return this.birthday;
    }

    public final ContactsUpdateParams copy(ContactEntity r14, String r15, Telephone[] r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        return new ContactsUpdateParams(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactsUpdateParams) == true) goto L8;
        return false;
    L8:
        ContactsUpdateParams r6 = (ContactsUpdateParams) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.telephones, r6.telephones) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.company, r6.company) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.note, r6.note) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.email, r6.email) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.identifyCard, r6.identifyCard) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.gender, r6.gender) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.birthday, r6.birthday) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.relationship, r6.relationship) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.address, r6.address) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        ContactEntity r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Telephone[] r7 = this.telephones;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.company;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.note;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.email;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.identifyCard;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.gender;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.birthday;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.relationship;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.address;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
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
        r8 = Arrays.hashCode(r7);
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactsUpdateParams(target=" + this.target + ", name=" + this.name + ", telephones=" + Arrays.toString(this.telephones) + ", company=" + this.company + ", note=" + this.note + ", email=" + this.email + ", identifyCard=" + this.identifyCard + ", gender=" + this.gender + ", birthday=" + this.birthday + ", relationship=" + this.relationship + ", address=" + this.address + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeParcelable(this.target, r6);
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

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.target);
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
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

    public final ContactEntity getTarget() {
        return this.target;
    }

    public final Telephone[] getTelephones() {
        return this.telephones;
    }

    public IntentParams mergeParams(Object r14) {
        if ((r14 instanceof ContactsUpdateParams) == true) goto L5;
        return this;
    L5:
        ContactEntity r0 = this.target;
        if (r0 != null) goto L8;
        r0 = ((ContactsUpdateParams) r14).target;
    L8:
        ContactEntity r2 = r0;
        String r1 = this.name;
        if (r1 != null) goto L11;
        r1 = ((ContactsUpdateParams) r14).name;
    L11:
        String r3 = r1;
        Telephone[] r4 = this.telephones;
        if (r4 != null) goto L14;
        r4 = ((ContactsUpdateParams) r14).telephones;
    L14:
        Telephone[] r5 = r4;
        String r6 = this.company;
        if (r6 != null) goto L17;
        r6 = ((ContactsUpdateParams) r14).company;
    L17:
        String r7 = r6;
        String r8 = this.note;
        if (r8 != null) goto L20;
        r8 = ((ContactsUpdateParams) r14).note;
    L20:
        String r9 = r8;
        String r10 = this.email;
        if (r10 != null) goto L23;
        r10 = ((ContactsUpdateParams) r14).email;
    L23:
        String r11 = r10;
        String r12 = this.identifyCard;
        if (r12 != null) goto L26;
        r12 = ((ContactsUpdateParams) r14).identifyCard;
    L26:
        String r13 = r12;
        String r15 = this.gender;
        if (r15 != null) goto L29;
        r15 = ((ContactsUpdateParams) r14).gender;
    L29:
        String r16 = r15;
        String r17 = this.birthday;
        if (r17 != null) goto L32;
        r17 = ((ContactsUpdateParams) r14).birthday;
    L32:
        String r18 = r17;
        String r19 = this.relationship;
        if (r19 != null) goto L35;
        r19 = ((ContactsUpdateParams) r14).relationship;
    L35:
        String r110 = r19;
        String r20 = this.address;
        if (r20 != null) goto L38;
        String r111 = ((ContactsUpdateParams) r14).address;
    L40:
        return new ContactsUpdateParams(r2, r3, r5, r7, r9, r11, r13, r16, r18, r110, r111);
    L38:
        r111 = r20;
        goto L40
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

    public final void setTarget(ContactEntity r1) {
        this.target = r1;
    }

    public final void setTelephones(Telephone[] r1) {
        this.telephones = r1;
    }

    public ContactsUpdateParams(ContactEntity r1, String r2, Telephone[] r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        this.target = r1;
        this.name = r2;
        this.telephones = r3;
        this.company = r4;
        this.note = r5;
        this.email = r6;
        this.identifyCard = r7;
        this.gender = r8;
        this.birthday = r9;
        this.relationship = r10;
        this.address = r11;
    }

    public /* synthetic */ ContactsUpdateParams(ContactEntity r13, String r14, Telephone[] r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        String r2 = null;
        if ((r24 & 1) == 0) goto L5;
        ContactEntity r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Telephone[] r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r24 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r24 & ISmModel.VERSION_0200) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r24 & ISmModel.VERSION_0400) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
