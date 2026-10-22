package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "old data flow")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010+\u001a\u00020\u0003HÆ\u0003Jj\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020/J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020/HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006;"}, d2 = {"Lcom/larus/bmhome/chat/resp/EditPos;", "Landroid/os/Parcelable;", "name", "", "modelDescription", "humanDescription", "iconUri", "modelType", "voiceType", "delete", "firstMet", "botLanguage", "<init>", "(ZZZZZZZLjava/lang/Boolean;Z)V", "getName", "()Z", "setName", "(Z)V", "getModelDescription", "setModelDescription", "getHumanDescription", "setHumanDescription", "getIconUri", "setIconUri", "getModelType", "setModelType", "getVoiceType", "setVoiceType", "getDelete", "setDelete", "getFirstMet", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBotLanguage", "setBotLanguage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZZZZZZZLjava/lang/Boolean;Z)Lcom/larus/bmhome/chat/resp/EditPos;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class EditPos implements Parcelable {
    public static final Parcelable.Creator<EditPos> CREATOR = null;

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

    public static final class a implements Parcelable.Creator<EditPos> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EditPos createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            if (r13.readInt() == 0) goto L5;
            boolean r4 = true;
        L7:
            if (r13.readInt() == 0) goto L9;
            boolean r5 = true;
        L11:
            if (r13.readInt() == 0) goto L13;
            boolean r6 = true;
        L15:
            if (r13.readInt() == 0) goto L17;
            boolean r7 = true;
        L19:
            if (r13.readInt() == 0) goto L21;
            boolean r8 = true;
        L23:
            if (r13.readInt() == 0) goto L25;
            boolean r9 = true;
        L27:
            if (r13.readInt() == 0) goto L29;
            boolean r10 = true;
        L31:
            if (r13.readInt() != 0) goto L35;
            Boolean r1 = null;
        L33:
            Boolean r11 = r1;
            if (r13.readInt() == 0) goto L42;
            boolean r14 = true;
        L44:
            return new EditPos(r4, r5, r6, r7, r8, r9, r10, r11, r14);
        L42:
            r14 = false;
            goto L44
        L35:
            if (r13.readInt() == 0) goto L37;
            boolean r2 = true;
        L38:
            r1 = Boolean.valueOf(r2);
            goto L33
        L37:
            r2 = false;
            goto L38
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
        CREATOR = new a();
    }

    public EditPos() {
        this(false, false, false, false, false, false, false, null, false);
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
        if (Intrinsics.areEqual(this.firstMet, r6.firstMet) == true) goto L33;
        return false;
    L33:
        if (this.botLanguage == r6.botLanguage) goto L35;
        return false;
    L35:
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
        Boolean r15 = this.firstMet;
        if (r15 != null) goto L33;
        int r16 = 0;
    L34:
        int r17 = (r14 + r16) * 31;
        if (this.botLanguage == true) goto L39;
        r1 = 1237;
    L39:
        return r17 + r1;
    L33:
        r16 = r15.hashCode();
        goto L34
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
        return "EditPos(name=" + this.name + ", modelDescription=" + this.modelDescription + ", humanDescription=" + this.humanDescription + ", iconUri=" + this.iconUri + ", modelType=" + this.modelType + ", voiceType=" + this.voiceType + ", delete=" + this.delete + ", firstMet=" + this.firstMet + ", botLanguage=" + this.botLanguage + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v22 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeInt(this.name ? 1 : 0);
        r2.writeInt(this.modelDescription ? 1 : 0);
        r2.writeInt(this.humanDescription ? 1 : 0);
        r2.writeInt(this.iconUri ? 1 : 0);
        r2.writeInt(this.modelType ? 1 : 0);
        r2.writeInt(this.voiceType ? 1 : 0);
        r2.writeInt(this.delete ? 1 : 0);
        Boolean r4 = this.firstMet;
        if (r4 != null) goto L6;
        ?? r5 = 0;
    L5:
        r2.writeInt(r5);
        r2.writeInt(this.botLanguage ? 1 : 0);
        return;
    L6:
        r2.writeInt(1);
        r5 = r4.booleanValue();
        goto L5
    }

    public EditPos(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, Boolean r8, boolean r9) {
        this.name = r1;
        this.modelDescription = r2;
        this.humanDescription = r3;
        this.iconUri = r4;
        this.modelType = r5;
        this.voiceType = r6;
        this.delete = r7;
        this.firstMet = r8;
        this.botLanguage = r9;
    }
}
