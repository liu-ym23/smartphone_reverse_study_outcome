package com.larus.settings.provider.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0001QB¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u0019\u0010\u001dJ\u0018\u00108\u001a\u0002092\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0003H\u0016J\b\u0010;\u001a\u00020\u0003H\u0016J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J¶\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u0003HÖ\u0001J\t\u0010P\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b7\u0010\"¨\u0006R"}, d2 = {"Lcom/larus/settings/provider/creation/CreationUpdateDialogItemConfig;", "Landroid/os/Parcelable;", "instructionType", "", "uniqueId", "", "enterAlbum", "", "prompt", "", "mediaConfig", "Lcom/larus/settings/provider/creation/MediaConfig;", "titleConfig", "Lcom/larus/settings/provider/creation/TitleConfig;", "descriptionConfig", "Lcom/larus/settings/provider/creation/DescriptionConfig;", "backgroundConfig", "Lcom/larus/settings/provider/creation/BackgroundConfig;", "buttonConfig", "Lcom/larus/settings/provider/creation/ButtonConfig;", "imageUrl", "title", "content", "buttonText", "defaultModelId", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/settings/provider/creation/MediaConfig;Lcom/larus/settings/provider/creation/TitleConfig;Lcom/larus/settings/provider/creation/DescriptionConfig;Lcom/larus/settings/provider/creation/BackgroundConfig;Lcom/larus/settings/provider/creation/ButtonConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getInstructionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUniqueId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnterAlbum", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPrompt", "()Ljava/lang/String;", "getMediaConfig", "()Lcom/larus/settings/provider/creation/MediaConfig;", "getTitleConfig", "()Lcom/larus/settings/provider/creation/TitleConfig;", "getDescriptionConfig", "()Lcom/larus/settings/provider/creation/DescriptionConfig;", "getBackgroundConfig", "()Lcom/larus/settings/provider/creation/BackgroundConfig;", "getButtonConfig", "()Lcom/larus/settings/provider/creation/ButtonConfig;", "getImageUrl", "getTitle", "getContent", "getButtonText", "getDefaultModelId", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/settings/provider/creation/MediaConfig;Lcom/larus/settings/provider/creation/TitleConfig;Lcom/larus/settings/provider/creation/DescriptionConfig;Lcom/larus/settings/provider/creation/BackgroundConfig;Lcom/larus/settings/provider/creation/ButtonConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/settings/provider/creation/CreationUpdateDialogItemConfig;", "equals", "other", "", "hashCode", "toString", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationUpdateDialogItemConfig implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("background_config")
    private final BackgroundConfig backgroundConfig;

    @SerializedName("button_config")
    private final ButtonConfig buttonConfig;

    @SerializedName("button_text")
    private final String buttonText;

    @SerializedName("content")
    private final String content;

    @SerializedName("default_model_id")
    private final Long defaultModelId;

    @SerializedName("description_config")
    private final DescriptionConfig descriptionConfig;

    @SerializedName("enter_album")
    private final Boolean enterAlbum;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("instruction_type")
    private final Integer instructionType;

    @SerializedName("media_config")
    private final MediaConfig mediaConfig;

    @SerializedName("default_prompt")
    private final String prompt;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_config")
    private final TitleConfig titleConfig;

    @SerializedName("unique_id")
    private final Long uniqueId;

    public static final class a implements Parcelable.Creator<CreationUpdateDialogItemConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationUpdateDialogItemConfig createFromParcel(Parcel r19) {
            Intrinsics.checkNotNullParameter(r19, "parcel");
            Intrinsics.checkNotNullParameter(r19, "parcel");
            Object r1 = r19.readValue(Integer.TYPE.getClassLoader());
            if ((r1 instanceof Integer) == false) goto L5;
            Integer r2 = (Integer) r1;
        L6:
            Class r3 = Long.TYPE;
            Object r4 = r19.readValue(r3.getClassLoader());
            if ((r4 instanceof Long) == false) goto L9;
            Long r5 = (Long) r4;
        L10:
            Object r6 = r19.readValue(Boolean.TYPE.getClassLoader());
            if ((r6 instanceof Boolean) == false) goto L13;
            Boolean r7 = (Boolean) r6;
        L14:
            String r8 = r19.readString();
            MediaConfig r9 = (MediaConfig) r19.readParcelable(MediaConfig.class.getClassLoader());
            TitleConfig r10 = (TitleConfig) r19.readParcelable(TitleConfig.class.getClassLoader());
            DescriptionConfig r11 = (DescriptionConfig) r19.readParcelable(DescriptionConfig.class.getClassLoader());
            BackgroundConfig r12 = (BackgroundConfig) r19.readParcelable(BackgroundConfig.class.getClassLoader());
            ButtonConfig r13 = (ButtonConfig) r19.readParcelable(ButtonConfig.class.getClassLoader());
            String r14 = r19.readString();
            String r15 = r19.readString();
            String r16 = r19.readString();
            String r17 = r19.readString();
            Object r0 = r19.readValue(r3.getClassLoader());
            if ((r0 instanceof Long) == false) goto L17;
            Long r18 = (Long) r0;
        L19:
            return new CreationUpdateDialogItemConfig(r2, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
        L17:
            r18 = null;
            goto L19
        L13:
            r7 = null;
            goto L14
        L9:
            r5 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreationUpdateDialogItemConfig[] newArray(int r1) {
            return new CreationUpdateDialogItemConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CreationUpdateDialogItemConfig() {
        this(-1, -1L, Boolean.FALSE, null, null, null, null, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationUpdateDialogItemConfig) == true) goto L8;
        return false;
    L8:
        CreationUpdateDialogItemConfig r6 = (CreationUpdateDialogItemConfig) r5;
        if (Intrinsics.areEqual(this.instructionType, r6.instructionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uniqueId, r6.uniqueId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterAlbum, r6.enterAlbum) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mediaConfig, r6.mediaConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.titleConfig, r6.titleConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.descriptionConfig, r6.descriptionConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.backgroundConfig, r6.backgroundConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.buttonConfig, r6.buttonConfig) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.imageUrl, r6.imageUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.buttonText, r6.buttonText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.defaultModelId, r6.defaultModelId) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.instructionType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.uniqueId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.enterAlbum;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.prompt;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        MediaConfig r13 = this.mediaConfig;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        TitleConfig r16 = this.titleConfig;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        DescriptionConfig r19 = this.descriptionConfig;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        BackgroundConfig r22 = this.backgroundConfig;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        ButtonConfig r25 = this.buttonConfig;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.imageUrl;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.title;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.content;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.buttonText;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Long r40 = this.defaultModelId;
        if (r40 == null) goto L59;
        r1 = r40.hashCode();
    L59:
        return r39 + r1;
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
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
        return "CreationUpdateDialogItemConfig(instructionType=" + this.instructionType + ", uniqueId=" + this.uniqueId + ", enterAlbum=" + this.enterAlbum + ", prompt=" + this.prompt + ", mediaConfig=" + this.mediaConfig + ", titleConfig=" + this.titleConfig + ", descriptionConfig=" + this.descriptionConfig + ", backgroundConfig=" + this.backgroundConfig + ", buttonConfig=" + this.buttonConfig + ", imageUrl=" + this.imageUrl + ", title=" + this.title + ", content=" + this.content + ", buttonText=" + this.buttonText + ", defaultModelId=" + this.defaultModelId + ')';
    }

    public final BackgroundConfig a() {
        return this.backgroundConfig;
    }

    public final ButtonConfig b() {
        return this.buttonConfig;
    }

    public final DescriptionConfig c() {
        return this.descriptionConfig;
    }

    public final String d() {
        return this.imageUrl;
    }

    public final Integer e() {
        return this.instructionType;
    }

    public final MediaConfig g() {
        return this.mediaConfig;
    }

    public final TitleConfig h() {
        return this.titleConfig;
    }

    public final Long i() {
        return this.uniqueId;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeValue(this.instructionType);
        r2.writeValue(this.uniqueId);
        r2.writeValue(this.enterAlbum);
        r2.writeString(this.prompt);
        r2.writeParcelable(this.mediaConfig, r3);
        r2.writeParcelable(this.titleConfig, r3);
        r2.writeParcelable(this.descriptionConfig, r3);
        r2.writeParcelable(this.backgroundConfig, r3);
        r2.writeParcelable(this.buttonConfig, r3);
        r2.writeString(this.imageUrl);
        r2.writeString(this.title);
        r2.writeString(this.content);
        r2.writeString(this.buttonText);
        r2.writeValue(this.defaultModelId);
    }

    public CreationUpdateDialogItemConfig(Integer r1, Long r2, Boolean r3, String r4, MediaConfig r5, TitleConfig r6, DescriptionConfig r7, BackgroundConfig r8, ButtonConfig r9, String r10, String r11, String r12, String r13, Long r14) {
        this.instructionType = r1;
        this.uniqueId = r2;
        this.enterAlbum = r3;
        this.prompt = r4;
        this.mediaConfig = r5;
        this.titleConfig = r6;
        this.descriptionConfig = r7;
        this.backgroundConfig = r8;
        this.buttonConfig = r9;
        this.imageUrl = r10;
        this.title = r11;
        this.content = r12;
        this.buttonText = r13;
        this.defaultModelId = r14;
    }
}
