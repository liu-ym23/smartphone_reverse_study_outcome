package com.larus.platform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"Jv\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0006\u00101\u001a\u000202J\u0013\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000202HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000202R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"¨\u0006?"}, d2 = {"Lcom/larus/platform/model/EditPos;", "Landroid/os/Parcelable;", "name", "", "modelDescription", "humanDescription", "iconUri", "modelType", "voiceType", "delete", "botLanguage", "firstMet", "bioEdit", "<init>", "(ZZZZZZZZLjava/lang/Boolean;Ljava/lang/Boolean;)V", "getName", "()Z", "setName", "(Z)V", "getModelDescription", "setModelDescription", "getHumanDescription", "setHumanDescription", "getIconUri", "setIconUri", "getModelType", "setModelType", "getVoiceType", "setVoiceType", "getDelete", "setDelete", "getBotLanguage", "setBotLanguage", "getFirstMet", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBioEdit", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ZZZZZZZZLjava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/platform/model/EditPos;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class EditPos implements Parcelable {
    public static final Parcelable.Creator<EditPos> CREATOR = null;

    @SerializedName("user_edit_bio")
    private final Boolean bioEdit;

    @SerializedName("bot_language")
    private boolean botLanguage;

    @SerializedName("delete")
    private boolean delete;

    @SerializedName("first_met")
    private final Boolean firstMet;

    @SerializedName("description_for_human")
    private boolean humanDescription;

    @SerializedName("icon_uri")
    private boolean iconUri;

    @SerializedName("description_for_model")
    private boolean modelDescription;

    @SerializedName("model_type")
    private boolean modelType;

    @SerializedName("name")
    private boolean name;

    @SerializedName("voice_type")
    private boolean voiceType;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<EditPos> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final EditPos createFromParcel(Parcel r15) {
            Intrinsics.checkNotNullParameter(r15, "parcel");
            boolean r2 = false;
            if (r15.readInt() == 0) goto L5;
            boolean r4 = true;
        L7:
            if (r15.readInt() == 0) goto L9;
            boolean r5 = true;
        L11:
            if (r15.readInt() == 0) goto L13;
            boolean r6 = true;
        L15:
            if (r15.readInt() == 0) goto L17;
            boolean r7 = true;
        L19:
            if (r15.readInt() == 0) goto L21;
            boolean r8 = true;
        L23:
            if (r15.readInt() == 0) goto L25;
            boolean r9 = true;
        L27:
            if (r15.readInt() == 0) goto L29;
            boolean r10 = true;
        L31:
            if (r15.readInt() == 0) goto L33;
            boolean r11 = true;
        L35:
            if (r15.readInt() != 0) goto L38;
            Boolean r13 = null;
        L43:
            if (r15.readInt() != 0) goto L46;
            Boolean r16 = null;
        L50:
            return new EditPos(r4, r5, r6, r7, r8, r9, r10, r11, r13, r16);
        L46:
            if (r15.readInt() == 0) goto L48;
            r2 = true;
        L48:
            r16 = Boolean.valueOf(r2);
            goto L50
        L38:
            if (r15.readInt() == 0) goto L40;
            boolean r1 = true;
        L41:
            r13 = Boolean.valueOf(r1);
            goto L43
        L40:
            r1 = false;
            goto L41
        L33:
            r11 = false;
            goto L35
        L29:
            r10 = false;
            goto L31
        L25:
            r9 = false;
            goto L27
        L21:
            r8 = false;
            goto L23
        L17:
            r7 = false;
            goto L19
        L13:
            r6 = false;
            goto L15
        L9:
            r5 = false;
            goto L11
        L5:
            r4 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final EditPos[] newArray(int r1) {
            return new EditPos[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public EditPos() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EditPos) == true) goto L8;
        return false;
    L8:
        EditPos r6 = (EditPos) r5;
        if (this.name == r6.name) goto L12;
        return false;
    L12:
        if (this.modelDescription == r6.modelDescription) goto L15;
        return false;
    L15:
        if (this.humanDescription == r6.humanDescription) goto L18;
        return false;
    L18:
        if (this.iconUri == r6.iconUri) goto L21;
        return false;
    L21:
        if (this.modelType == r6.modelType) goto L24;
        return false;
    L24:
        if (this.voiceType == r6.voiceType) goto L27;
        return false;
    L27:
        if (this.delete == r6.delete) goto L30;
        return false;
    L30:
        if (this.botLanguage == r6.botLanguage) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.firstMet, r6.firstMet) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bioEdit, r6.bioEdit) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.name == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.modelDescription == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.humanDescription == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.iconUri == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.modelType == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.voiceType == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.delete == false) goto L29;
        int r13 = 1231;
    L30:
        int r14 = (r12 + r13) * 31;
        if (this.botLanguage == true) goto L34;
        r1 = 1237;
    L34:
        int r15 = (r14 + r1) * 31;
        Boolean r16 = this.firstMet;
        int r17 = 0;
        if (r16 != null) goto L37;
        int r18 = 0;
    L38:
        int r19 = (r15 + r18) * 31;
        Boolean r20 = this.bioEdit;
        if (r20 == null) goto L43;
        r17 = r20.hashCode();
    L43:
        return r19 + r17;
    L37:
        r18 = r16.hashCode();
        goto L38
    L29:
        r13 = 1237;
        goto L30
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "EditPos(name=" + this.name + ", modelDescription=" + this.modelDescription + ", humanDescription=" + this.humanDescription + ", iconUri=" + this.iconUri + ", modelType=" + this.modelType + ", voiceType=" + this.voiceType + ", delete=" + this.delete + ", botLanguage=" + this.botLanguage + ", firstMet=" + this.firstMet + ", bioEdit=" + this.bioEdit + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.name ? 1 : 0);
        r3.writeInt(this.modelDescription ? 1 : 0);
        r3.writeInt(this.humanDescription ? 1 : 0);
        r3.writeInt(this.iconUri ? 1 : 0);
        r3.writeInt(this.modelType ? 1 : 0);
        r3.writeInt(this.voiceType ? 1 : 0);
        r3.writeInt(this.delete ? 1 : 0);
        r3.writeInt(this.botLanguage ? 1 : 0);
        Boolean r5 = this.firstMet;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Boolean r6 = this.bioEdit;
        if (r6 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.booleanValue() ? 1 : 0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.booleanValue() ? 1 : 0);
        goto L6
    }

    public final Boolean a() {
        return this.bioEdit;
    }

    public final boolean b() {
        return this.botLanguage;
    }

    public final boolean c() {
        return this.delete;
    }

    public final Boolean d() {
        return this.firstMet;
    }

    public final boolean e() {
        return this.humanDescription;
    }

    public final boolean g() {
        return this.iconUri;
    }

    public final boolean h() {
        return this.modelDescription;
    }

    public final boolean i() {
        return this.name;
    }

    public final boolean j() {
        return this.voiceType;
    }

    public /* synthetic */ EditPos(int r12) {
        this(false, false, false, false, false, false, false, false, null, null);
    }

    public EditPos(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, Boolean r9, Boolean r10) {
        this.name = r1;
        this.modelDescription = r2;
        this.humanDescription = r3;
        this.iconUri = r4;
        this.modelType = r5;
        this.voiceType = r6;
        this.delete = r7;
        this.botLanguage = r8;
        this.firstMet = r9;
        this.bioEdit = r10;
    }
}
