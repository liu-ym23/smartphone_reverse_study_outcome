package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jb\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0006J\u0013\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006/"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationFromIM;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "creationId", "", "creationType", "", "privateStatus", "prompt", "refContent", "awemeAnchor", "materialId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreationId", "()Ljava/lang/String;", "getCreationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivateStatus", "getPrompt", "getRefContent", "getAwemeAnchor", "getMaterialId", "isValid", "", "isVideo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/api/creation/UserCreationFromIM;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UserCreationFromIM implements Parcelable, Serializable {
    public static final Parcelable.Creator<UserCreationFromIM> CREATOR = null;

    @SerializedName("aweme_anchor")
    private final String awemeAnchor;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("creation_type")
    private final Integer creationType;

    @SerializedName("material_id")
    private final String materialId;

    @SerializedName("private_status")
    private final Integer privateStatus;

    @SerializedName("prompt")
    private final String prompt;

    @SerializedName("ref_content")
    private final String refContent;

    public static final class a implements Parcelable.Creator<UserCreationFromIM> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationFromIM createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Integer r4 = null;
        L7:
            if (r10.readInt() != 0) goto L9;
            Integer r5 = null;
        L11:
            return new UserCreationFromIM(r2, r4, r5, r10.readString(), r10.readString(), r10.readString(), r10.readString());
        L9:
            r5 = Integer.valueOf(r10.readInt());
            goto L11
        L5:
            r4 = Integer.valueOf(r10.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationFromIM[] newArray(int r1) {
            return new UserCreationFromIM[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public UserCreationFromIM() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ UserCreationFromIM copy$default(UserCreationFromIM r5, String r6, Integer r7, Integer r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.creationId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.creationType;
    L8:
        Integer r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.privateStatus;
    L11:
        Integer r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.prompt;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.refContent;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.awemeAnchor;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.materialId;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.creationId;
    }

    public final Integer component2() {
        return this.creationType;
    }

    public final Integer component3() {
        return this.privateStatus;
    }

    public final String component4() {
        return this.prompt;
    }

    public final String component5() {
        return this.refContent;
    }

    public final String component6() {
        return this.awemeAnchor;
    }

    public final String component7() {
        return this.materialId;
    }

    public final UserCreationFromIM copy(String r10, @UserCreationType Integer r11, Integer r12, String r13, String r14, String r15, String r16) {
        return new UserCreationFromIM(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationFromIM) == true) goto L8;
        return false;
    L8:
        UserCreationFromIM r6 = (UserCreationFromIM) r5;
        if (Intrinsics.areEqual(this.creationId, r6.creationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationType, r6.creationType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.privateStatus, r6.privateStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refContent, r6.refContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.awemeAnchor, r6.awemeAnchor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.materialId, r6.materialId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.creationId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.creationType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.privateStatus;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.prompt;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.refContent;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.awemeAnchor;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.materialId;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final boolean isValid() {
        return true;
    }

    public String toString() {
        return "UserCreationFromIM(creationId=" + this.creationId + ", creationType=" + this.creationType + ", privateStatus=" + this.privateStatus + ", prompt=" + this.prompt + ", refContent=" + this.refContent + ", awemeAnchor=" + this.awemeAnchor + ", materialId=" + this.materialId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.creationId);
        Integer r5 = this.creationType;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.privateStatus;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.prompt);
        r3.writeString(this.refContent);
        r3.writeString(this.awemeAnchor);
        r3.writeString(this.materialId);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    public final boolean isVideo() {
        Integer r0 = this.creationType;
        if (r0 != null) goto L6;
    L7:
        Integer r1 = this.creationType;
        if (r1 != null) goto L11;
    L12:
        Integer r2 = this.creationType;
        if (r2 != null) goto L16;
    L17:
        Integer r3 = this.creationType;
        if (r3 != null) goto L21;
    L22:
        Integer r4 = this.creationType;
        if (r4 != null) goto L26;
    L28:
        return false;
    L26:
        if (r4.intValue() != 12) goto L28;
    L29:
        return true;
    L21:
        if (r3.intValue() == 10) goto L29;
    L16:
        if (r2.intValue() == 11) goto L29;
    L11:
        if (r1.intValue() == 6) goto L29;
    L6:
        if (r0.intValue() == 7) goto L29;
        goto L7
    }

    public final String getAwemeAnchor() {
        return this.awemeAnchor;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final Integer getCreationType() {
        return this.creationType;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final Integer getPrivateStatus() {
        return this.privateStatus;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getRefContent() {
        return this.refContent;
    }

    public UserCreationFromIM(String r1, @UserCreationType Integer r2, Integer r3, String r4, String r5, String r6, String r7) {
        this.creationId = r1;
        this.creationType = r2;
        this.privateStatus = r3;
        this.prompt = r4;
        this.refContent = r5;
        this.awemeAnchor = r6;
        this.materialId = r7;
    }

    public /* synthetic */ UserCreationFromIM(String r7, Integer r8, Integer r9, String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        Integer r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Integer r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        String r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
