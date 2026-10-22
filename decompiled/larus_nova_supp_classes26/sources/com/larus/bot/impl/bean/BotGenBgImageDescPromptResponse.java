package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/bean/BotGenBgImageDescPromptResponse;", "Ljava/io/Serializable;", "bgImgPrompt", "", "bgImgPromptEn", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBgImgPrompt", "()Ljava/lang/String;", "getBgImgPromptEn", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotGenBgImageDescPromptResponse implements Serializable {

    @SerializedName("bg_img_prompt")
    private final String bgImgPrompt;

    @SerializedName("bg_img_prompt_en")
    private final String bgImgPromptEn;

    public BotGenBgImageDescPromptResponse() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ BotGenBgImageDescPromptResponse copy$default(BotGenBgImageDescPromptResponse r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.bgImgPrompt;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.bgImgPromptEn;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.bgImgPrompt;
    }

    public final String component2() {
        return this.bgImgPromptEn;
    }

    public final BotGenBgImageDescPromptResponse copy(String r2, String r3) {
        return new BotGenBgImageDescPromptResponse(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotGenBgImageDescPromptResponse) == true) goto L8;
        return false;
    L8:
        BotGenBgImageDescPromptResponse r6 = (BotGenBgImageDescPromptResponse) r5;
        if (Intrinsics.areEqual(this.bgImgPrompt, r6.bgImgPrompt) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgImgPromptEn, r6.bgImgPromptEn) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.bgImgPrompt;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.bgImgPromptEn;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BotGenBgImageDescPromptResponse(bgImgPrompt=" + this.bgImgPrompt + ", bgImgPromptEn=" + this.bgImgPromptEn + ')';
    }

    public final String getBgImgPrompt() {
        return this.bgImgPrompt;
    }

    public final String getBgImgPromptEn() {
        return this.bgImgPromptEn;
    }

    public BotGenBgImageDescPromptResponse(String r1, String r2) {
        this.bgImgPrompt = r1;
        this.bgImgPromptEn = r2;
    }

    public /* synthetic */ BotGenBgImageDescPromptResponse(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
