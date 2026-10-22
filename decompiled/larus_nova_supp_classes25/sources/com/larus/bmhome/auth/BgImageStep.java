package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010Jj\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0004\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u0010R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\f\u0010\u0010¨\u0006+"}, d2 = {"Lcom/larus/bmhome/auth/BgImageStep;", "Landroid/os/Parcelable;", "botGenAddImageSetting", "", "isAiImageWorkflow", "bgImageOpenMode", "", "isImageGuide", "isStepGenByCharacterBot", "showBotType", "", "", "isIndependentVoiceSetting", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;)V", "getBotGenAddImageSetting", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBgImageOpenMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowBotType", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/bmhome/auth/BgImageStep;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BgImageStep implements Parcelable {
    public static final Parcelable.Creator<BgImageStep> CREATOR = null;

    @SerializedName("bg_image_open_mode")
    private final Integer bgImageOpenMode;

    @SerializedName("bot_gen_add_image_setting")
    private final Boolean botGenAddImageSetting;

    @SerializedName("is_ai_image_workflow")
    private final Boolean isAiImageWorkflow;

    @SerializedName("is_image_guide")
    private final Boolean isImageGuide;

    @SerializedName("is_independent_voice_setting")
    private final Boolean isIndependentVoiceSetting;

    @SerializedName("is_step_gen_by_character_bot")
    private final Boolean isStepGenByCharacterBot;

    @SerializedName("show_bot_type")
    private final List<String> showBotType;

    public static final class a implements Parcelable.Creator<BgImageStep> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageStep createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            boolean r2 = false;
            if (r12.readInt() != 0) goto L6;
            Boolean r5 = null;
        L11:
            if (r12.readInt() != 0) goto L14;
            Boolean r6 = null;
        L19:
            if (r12.readInt() != 0) goto L21;
            Integer r7 = null;
        L23:
            if (r12.readInt() != 0) goto L26;
            Boolean r8 = null;
        L31:
            if (r12.readInt() != 0) goto L34;
            Boolean r9 = null;
        L38:
            ArrayList<String> r10 = r12.createStringArrayList();
            if (r12.readInt() != 0) goto L42;
            Boolean r13 = null;
        L46:
            return new BgImageStep(r5, r6, r7, r8, r9, r10, r13);
        L42:
            if (r12.readInt() == 0) goto L44;
            r2 = true;
        L44:
            r13 = Boolean.valueOf(r2);
            goto L46
        L34:
            if (r12.readInt() == 0) goto L36;
            boolean r1 = true;
        L37:
            r9 = Boolean.valueOf(r1);
            goto L38
        L36:
            r1 = false;
            goto L37
        L26:
            if (r12.readInt() == 0) goto L28;
            boolean r3 = true;
        L29:
            r8 = Boolean.valueOf(r3);
            goto L31
        L28:
            r3 = false;
            goto L29
        L21:
            r7 = Integer.valueOf(r12.readInt());
            goto L23
        L14:
            if (r12.readInt() == 0) goto L16;
            boolean r4 = true;
        L17:
            r6 = Boolean.valueOf(r4);
            goto L19
        L16:
            r4 = false;
            goto L17
        L6:
            if (r12.readInt() == 0) goto L8;
            boolean r11 = true;
        L9:
            r5 = Boolean.valueOf(r11);
            goto L11
        L8:
            r11 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageStep[] newArray(int r1) {
            return new BgImageStep[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BgImageStep() {
        this(null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BgImageStep) == true) goto L8;
        return false;
    L8:
        BgImageStep r6 = (BgImageStep) r5;
        if (Intrinsics.areEqual(this.botGenAddImageSetting, r6.botGenAddImageSetting) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAiImageWorkflow, r6.isAiImageWorkflow) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImageOpenMode, r6.bgImageOpenMode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isImageGuide, r6.isImageGuide) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isStepGenByCharacterBot, r6.isStepGenByCharacterBot) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showBotType, r6.showBotType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isIndependentVoiceSetting, r6.isIndependentVoiceSetting) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.botGenAddImageSetting;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isAiImageWorkflow;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.bgImageOpenMode;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isImageGuide;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.isStepGenByCharacterBot;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.showBotType;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.isIndependentVoiceSetting;
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

    public final String toString() {
        return "BgImageStep(botGenAddImageSetting=" + this.botGenAddImageSetting + ", isAiImageWorkflow=" + this.isAiImageWorkflow + ", bgImageOpenMode=" + this.bgImageOpenMode + ", isImageGuide=" + this.isImageGuide + ", isStepGenByCharacterBot=" + this.isStepGenByCharacterBot + ", showBotType=" + this.showBotType + ", isIndependentVoiceSetting=" + this.isIndependentVoiceSetting + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        Boolean r5 = this.botGenAddImageSetting;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Boolean r6 = this.isAiImageWorkflow;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        Integer r7 = this.bgImageOpenMode;
        if (r7 != null) goto L13;
        r3.writeInt(0);
    L14:
        Boolean r8 = this.isImageGuide;
        if (r8 != null) goto L17;
        r3.writeInt(0);
    L18:
        Boolean r9 = this.isStepGenByCharacterBot;
        if (r9 != null) goto L21;
        r3.writeInt(0);
    L22:
        r3.writeStringList(this.showBotType);
        Boolean r10 = this.isIndependentVoiceSetting;
        if (r10 != null) goto L25;
        r3.writeInt(0);
        return;
    L25:
        r3.writeInt(1);
        r3.writeInt(r10.booleanValue() ? 1 : 0);
        return;
    L21:
        r3.writeInt(1);
        r3.writeInt(r9.booleanValue() ? 1 : 0);
        goto L22
    L17:
        r3.writeInt(1);
        r3.writeInt(r8.booleanValue() ? 1 : 0);
        goto L18
    L13:
        r3.writeInt(1);
        r3.writeInt(r7.intValue());
        goto L14
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.booleanValue() ? 1 : 0);
        goto L6
    }

    public BgImageStep(Boolean r1, Boolean r2, Integer r3, Boolean r4, Boolean r5, List<String> r6, Boolean r7) {
        this.botGenAddImageSetting = r1;
        this.isAiImageWorkflow = r2;
        this.bgImageOpenMode = r3;
        this.isImageGuide = r4;
        this.isStepGenByCharacterBot = r5;
        this.showBotType = r6;
        this.isIndependentVoiceSetting = r7;
    }
}
