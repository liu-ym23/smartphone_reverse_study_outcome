package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0002)*B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J1\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u001dHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006+"}, d2 = {"Lcom/obric/aiproactive/api/AiRuleItemDto;", "Landroid/os/Parcelable;", OaidModel.KEY_ID, "", Params.CONTENT, "type", "Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;", "isSelected", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getId", "()Ljava/lang/String;", "getContent", "setContent", "(Ljava/lang/String;)V", "getType", "()Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;", "setType", "(Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;)V", "()Z", "setSelected", "(Z)V", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "RuleType", "CREATOR", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiRuleItemDto implements Parcelable {
    public static final a CREATOR = null;
    private String content;
    private final String id;
    private boolean isSelected;
    private RuleType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;", "", "<init>", "(Ljava/lang/String;I)V", "CUSTOM", "AI_GENERATED", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum RuleType extends Enum<RuleType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ RuleType[] $VALUES = null;
        public static final RuleType AI_GENERATED = null;
        public static final RuleType CUSTOM = null;

        private static final /* synthetic */ RuleType[] $values() {
            return new RuleType[]{CUSTOM, AI_GENERATED};
        }

        static {
            CUSTOM = new RuleType("CUSTOM", 0);
            AI_GENERATED = new RuleType("AI_GENERATED", 1);
            RuleType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private RuleType(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<RuleType> getEntries() {
            return $ENTRIES;
        }

        public static RuleType valueOf(String r2) {
            return (RuleType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RuleType.class, r2), RuleType.class, "com.obric.memorydata.plugin");
        }

        public static RuleType[] values() {
            return (RuleType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RuleType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/api/AiRuleItemDto$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/aiproactive/api/AiRuleItemDto;", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<AiRuleItemDto> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public AiRuleItemDto a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AiRuleItemDto(r1);
        }

        public AiRuleItemDto[] a(int r1) {
            return new AiRuleItemDto[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AiRuleItemDto createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AiRuleItemDto[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public AiRuleItemDto(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        String r0 = r4.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r4.readString();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        String r3 = r4.readString();
        if (r3 != null) goto L12;
        r3 = "CUSTOM";
    L12:
        RuleType r5 = RuleType.valueOf(r3);
        if (r4.readByte() == 0) goto L15;
        boolean r6 = true;
    L16:
        this(r0, r1, r5, r6);
        return;
    L15:
        r6 = false;
        goto L16
    }

    public AiRuleItemDto(String r2, String r3, RuleType r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r4, "type");
        this.id = r2;
        this.content = r3;
        this.type = r4;
        this.isSelected = r5;
    }

    public /* synthetic */ AiRuleItemDto(String r1, String r2, RuleType r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ AiRuleItemDto copy$default(AiRuleItemDto r0, String r1, String r2, RuleType r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.type;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isSelected;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.content;
    }

    public final RuleType component3() {
        return this.type;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    public final AiRuleItemDto copy(String r1, String r2, RuleType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r3, "type");
        return new AiRuleItemDto(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AiRuleItemDto.class) == true) goto L8;
        return false;
    L8:
        AiRuleItemDto r6 = (AiRuleItemDto) ZeusTransformUtils.preCheckCast(r5, AiRuleItemDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (this.type == r6.type) goto L18;
        return false;
    L18:
        if (this.isSelected == r6.isSelected) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final RuleType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.content.hashCode()) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isSelected);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setSelected(boolean r1) {
        this.isSelected = r1;
    }

    public final void setType(RuleType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public String toString() {
        return "AiRuleItemDto(id=" + this.id + ", content=" + this.content + ", type=" + this.type + ", isSelected=" + this.isSelected + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.id);
        r1.writeString(this.content);
        r1.writeString(this.type.name());
        r1.writeByte(this.isSelected ? 1 : 0);
    }
}
