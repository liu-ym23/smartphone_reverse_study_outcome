package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u008e\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u00061"}, d2 = {"Lcom/larus/bot/impl/bean/GenBotImageRequest;", "Ljava/io/Serializable;", "botName", "", "botDescriptionForHuman", "bgImgPromptEn", "referenceBgImgUri", "referenceBgImStyle", "referenceBgImPrompt", "bgImgDrawStyleStarlingKey", "", "userBotGenderStarlingKey", "userBotTypeStarlingKey", "onlyGenImagePrompt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBotName", "()Ljava/lang/String;", "getBotDescriptionForHuman", "getBgImgPromptEn", "getReferenceBgImgUri", "getReferenceBgImStyle", "getReferenceBgImPrompt", "getBgImgDrawStyleStarlingKey", "()Ljava/util/List;", "getUserBotGenderStarlingKey", "getUserBotTypeStarlingKey", "getOnlyGenImagePrompt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bot/impl/bean/GenBotImageRequest;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenBotImageRequest implements Serializable {

    @SerializedName("bg_img_draw_style_starling_key")
    private final List<String> bgImgDrawStyleStarlingKey;

    @SerializedName("bg_img_prompt_en")
    private final String bgImgPromptEn;

    @SerializedName("bot_description_for_human")
    private final String botDescriptionForHuman;

    @SerializedName("bot_name")
    private final String botName;

    @SerializedName("only_gen_image_prompt")
    private final Boolean onlyGenImagePrompt;

    @SerializedName("reference_bg_img_prompt")
    private final String referenceBgImPrompt;

    @SerializedName("reference_bg_img_style")
    private final String referenceBgImStyle;

    @SerializedName("reference_bg_img_uri")
    private final String referenceBgImgUri;

    @SerializedName("user_bot_gender_starling_key")
    private final String userBotGenderStarlingKey;

    @SerializedName("user_bot_type_starling_key")
    private final String userBotTypeStarlingKey;

    public GenBotImageRequest() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GenBotImageRequest copy$default(GenBotImageRequest r11, String r12, String r13, String r14, String r15, String r16, String r17, List r18, String r19, String r20, Boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.botName;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.botDescriptionForHuman;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.bgImgPromptEn;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.referenceBgImgUri;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.referenceBgImStyle;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.referenceBgImPrompt;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = r11.bgImgDrawStyleStarlingKey;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.userBotGenderStarlingKey;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.userBotTypeStarlingKey;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Boolean r1 = r11.onlyGenImagePrompt;
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
        return this.botName;
    }

    public final Boolean component10() {
        return this.onlyGenImagePrompt;
    }

    public final String component2() {
        return this.botDescriptionForHuman;
    }

    public final String component3() {
        return this.bgImgPromptEn;
    }

    public final String component4() {
        return this.referenceBgImgUri;
    }

    public final String component5() {
        return this.referenceBgImStyle;
    }

    public final String component6() {
        return this.referenceBgImPrompt;
    }

    public final List<String> component7() {
        return this.bgImgDrawStyleStarlingKey;
    }

    public final String component8() {
        return this.userBotGenderStarlingKey;
    }

    public final String component9() {
        return this.userBotTypeStarlingKey;
    }

    public final GenBotImageRequest copy(String r13, String r14, String r15, String r16, String r17, String r18, List<String> r19, String r20, String r21, Boolean r22) {
        return new GenBotImageRequest(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GenBotImageRequest) == true) goto L8;
        return false;
    L8:
        GenBotImageRequest r6 = (GenBotImageRequest) r5;
        if (Intrinsics.areEqual(this.botName, r6.botName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botDescriptionForHuman, r6.botDescriptionForHuman) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImgPromptEn, r6.bgImgPromptEn) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.referenceBgImgUri, r6.referenceBgImgUri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.referenceBgImStyle, r6.referenceBgImStyle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.referenceBgImPrompt, r6.referenceBgImPrompt) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bgImgDrawStyleStarlingKey, r6.bgImgDrawStyleStarlingKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.userBotGenderStarlingKey, r6.userBotGenderStarlingKey) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.userBotTypeStarlingKey, r6.userBotTypeStarlingKey) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.onlyGenImagePrompt, r6.onlyGenImagePrompt) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.botName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.botDescriptionForHuman;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.bgImgPromptEn;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.referenceBgImgUri;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.referenceBgImStyle;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.referenceBgImPrompt;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.bgImgDrawStyleStarlingKey;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.userBotGenderStarlingKey;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.userBotTypeStarlingKey;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.onlyGenImagePrompt;
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
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GenBotImageRequest(botName=" + this.botName + ", botDescriptionForHuman=" + this.botDescriptionForHuman + ", bgImgPromptEn=" + this.bgImgPromptEn + ", referenceBgImgUri=" + this.referenceBgImgUri + ", referenceBgImStyle=" + this.referenceBgImStyle + ", referenceBgImPrompt=" + this.referenceBgImPrompt + ", bgImgDrawStyleStarlingKey=" + this.bgImgDrawStyleStarlingKey + ", userBotGenderStarlingKey=" + this.userBotGenderStarlingKey + ", userBotTypeStarlingKey=" + this.userBotTypeStarlingKey + ", onlyGenImagePrompt=" + this.onlyGenImagePrompt + ')';
    }

    public final List<String> getBgImgDrawStyleStarlingKey() {
        return this.bgImgDrawStyleStarlingKey;
    }

    public final String getBgImgPromptEn() {
        return this.bgImgPromptEn;
    }

    public final String getBotDescriptionForHuman() {
        return this.botDescriptionForHuman;
    }

    public final String getBotName() {
        return this.botName;
    }

    public final Boolean getOnlyGenImagePrompt() {
        return this.onlyGenImagePrompt;
    }

    public final String getReferenceBgImPrompt() {
        return this.referenceBgImPrompt;
    }

    public final String getReferenceBgImStyle() {
        return this.referenceBgImStyle;
    }

    public final String getReferenceBgImgUri() {
        return this.referenceBgImgUri;
    }

    public final String getUserBotGenderStarlingKey() {
        return this.userBotGenderStarlingKey;
    }

    public final String getUserBotTypeStarlingKey() {
        return this.userBotTypeStarlingKey;
    }

    public GenBotImageRequest(String r1, String r2, String r3, String r4, String r5, String r6, List<String> r7, String r8, String r9, Boolean r10) {
        this.botName = r1;
        this.botDescriptionForHuman = r2;
        this.bgImgPromptEn = r3;
        this.referenceBgImgUri = r4;
        this.referenceBgImStyle = r5;
        this.referenceBgImPrompt = r6;
        this.bgImgDrawStyleStarlingKey = r7;
        this.userBotGenderStarlingKey = r8;
        this.userBotTypeStarlingKey = r9;
        this.onlyGenImagePrompt = r10;
    }

    public /* synthetic */ GenBotImageRequest(String r12, String r13, String r14, String r15, String r16, String r17, List r18, String r19, String r20, Boolean r21, int r22, DefaultConstructorMarker r23) {
        Boolean r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = null;
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
        List r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
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
