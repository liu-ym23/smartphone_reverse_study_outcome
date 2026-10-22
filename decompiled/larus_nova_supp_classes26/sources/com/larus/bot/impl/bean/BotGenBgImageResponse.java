package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JR\u0010\u001e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/larus/bot/impl/bean/BotGenBgImageResponse;", "Ljava/io/Serializable;", "bgImgList", "", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "bgImgPrompt", "", "bgImgPromptEn", "bgImgOpen", "", "bgCategoryType", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBgImgList", "()Ljava/util/List;", "getBgImgPrompt", "()Ljava/lang/String;", "getBgImgPromptEn", "getBgImgOpen", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBgCategoryType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/bot/impl/bean/BotGenBgImageResponse;", "equals", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotGenBgImageResponse implements Serializable {

    @SerializedName("bot_category_type")
    private final Integer bgCategoryType;

    @SerializedName("bg_img_list")
    private final List<BotAvatarIconData> bgImgList;

    @SerializedName("bg_img_open")
    private final Boolean bgImgOpen;

    @SerializedName("bg_img_prompt")
    private final String bgImgPrompt;

    @SerializedName("bg_img_prompt_en")
    private final String bgImgPromptEn;

    public BotGenBgImageResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotGenBgImageResponse copy$default(BotGenBgImageResponse r3, List r4, String r5, String r6, Boolean r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.bgImgList;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.bgImgPrompt;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.bgImgPromptEn;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.bgImgOpen;
    L14:
        Boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.bgCategoryType;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<BotAvatarIconData> component1() {
        return this.bgImgList;
    }

    public final String component2() {
        return this.bgImgPrompt;
    }

    public final String component3() {
        return this.bgImgPromptEn;
    }

    public final Boolean component4() {
        return this.bgImgOpen;
    }

    public final Integer component5() {
        return this.bgCategoryType;
    }

    public final BotGenBgImageResponse copy(List<BotAvatarIconData> r8, String r9, String r10, Boolean r11, Integer r12) {
        return new BotGenBgImageResponse(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotGenBgImageResponse) == true) goto L8;
        return false;
    L8:
        BotGenBgImageResponse r6 = (BotGenBgImageResponse) r5;
        if (Intrinsics.areEqual(this.bgImgList, r6.bgImgList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgImgPrompt, r6.bgImgPrompt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImgPromptEn, r6.bgImgPromptEn) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgImgOpen, r6.bgImgOpen) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgCategoryType, r6.bgCategoryType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<BotAvatarIconData> r0 = this.bgImgList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.bgImgPrompt;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.bgImgPromptEn;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.bgImgOpen;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.bgCategoryType;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "BotGenBgImageResponse(bgImgList=" + this.bgImgList + ", bgImgPrompt=" + this.bgImgPrompt + ", bgImgPromptEn=" + this.bgImgPromptEn + ", bgImgOpen=" + this.bgImgOpen + ", bgCategoryType=" + this.bgCategoryType + ')';
    }

    public final Integer getBgCategoryType() {
        return this.bgCategoryType;
    }

    public final List<BotAvatarIconData> getBgImgList() {
        return this.bgImgList;
    }

    public final Boolean getBgImgOpen() {
        return this.bgImgOpen;
    }

    public final String getBgImgPrompt() {
        return this.bgImgPrompt;
    }

    public final String getBgImgPromptEn() {
        return this.bgImgPromptEn;
    }

    public BotGenBgImageResponse(List<BotAvatarIconData> r1, String r2, String r3, Boolean r4, Integer r5) {
        this.bgImgList = r1;
        this.bgImgPrompt = r2;
        this.bgImgPromptEn = r3;
        this.bgImgOpen = r4;
        this.bgCategoryType = r5;
    }

    public /* synthetic */ BotGenBgImageResponse(List r5, String r6, String r7, Boolean r8, Integer r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        List r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Boolean r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Integer r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
