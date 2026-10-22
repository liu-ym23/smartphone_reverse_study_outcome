package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007HÆ\u0003Ja\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R(\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006*"}, d2 = {"Lcom/larus/bot/impl/bean/BotEnrichRespData;", "", "botName", "", "descriptionForHuman", "prologue", "suggests", "", "voiceId", "data", "Lcom/larus/bot/impl/bean/EnrichBotData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getBotName", "()Ljava/lang/String;", "setBotName", "(Ljava/lang/String;)V", "getDescriptionForHuman", "setDescriptionForHuman", "getPrologue", "setPrologue", "getSuggests", "()Ljava/util/List;", "setSuggests", "(Ljava/util/List;)V", "getVoiceId", "setVoiceId", "getData", "setData", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEnrichRespData {

    @SerializedName("bot_name")
    private String botName;

    @SerializedName("data")
    private List<EnrichBotData> data;

    @SerializedName("description_for_human")
    private String descriptionForHuman;

    @SerializedName("prologue")
    private String prologue;

    @SerializedName("suggest")
    private List<String> suggests;

    @SerializedName("voice_id")
    private String voiceId;

    public BotEnrichRespData() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotEnrichRespData copy$default(BotEnrichRespData r4, String r5, String r6, String r7, List r8, String r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.botName;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.descriptionForHuman;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.prologue;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.suggests;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.voiceId;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.data;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.botName;
    }

    public final String component2() {
        return this.descriptionForHuman;
    }

    public final String component3() {
        return this.prologue;
    }

    public final List<String> component4() {
        return this.suggests;
    }

    public final String component5() {
        return this.voiceId;
    }

    public final List<EnrichBotData> component6() {
        return this.data;
    }

    public final BotEnrichRespData copy(String r9, String r10, String r11, List<String> r12, String r13, List<EnrichBotData> r14) {
        return new BotEnrichRespData(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotEnrichRespData) == true) goto L8;
        return false;
    L8:
        BotEnrichRespData r6 = (BotEnrichRespData) r5;
        if (Intrinsics.areEqual(this.botName, r6.botName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.descriptionForHuman, r6.descriptionForHuman) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.prologue, r6.prologue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.suggests, r6.suggests) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.voiceId, r6.voiceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.botName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.descriptionForHuman;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.prologue;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.suggests;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.voiceId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<EnrichBotData> r16 = this.data;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "BotEnrichRespData(botName=" + this.botName + ", descriptionForHuman=" + this.descriptionForHuman + ", prologue=" + this.prologue + ", suggests=" + this.suggests + ", voiceId=" + this.voiceId + ", data=" + this.data + ')';
    }

    public final String getBotName() {
        return this.botName;
    }

    public final List<EnrichBotData> getData() {
        return this.data;
    }

    public final String getDescriptionForHuman() {
        return this.descriptionForHuman;
    }

    public final String getPrologue() {
        return this.prologue;
    }

    public final List<String> getSuggests() {
        return this.suggests;
    }

    public final String getVoiceId() {
        return this.voiceId;
    }

    public final void setBotName(String r1) {
        this.botName = r1;
    }

    public final void setData(List<EnrichBotData> r1) {
        this.data = r1;
    }

    public final void setDescriptionForHuman(String r1) {
        this.descriptionForHuman = r1;
    }

    public final void setPrologue(String r1) {
        this.prologue = r1;
    }

    public final void setSuggests(List<String> r1) {
        this.suggests = r1;
    }

    public final void setVoiceId(String r1) {
        this.voiceId = r1;
    }

    public BotEnrichRespData(String r1, String r2, String r3, List<String> r4, String r5, List<EnrichBotData> r6) {
        this.botName = r1;
        this.descriptionForHuman = r2;
        this.prologue = r3;
        this.suggests = r4;
        this.voiceId = r5;
        this.data = r6;
    }

    public /* synthetic */ BotEnrichRespData(String r5, String r6, String r7, List r8, String r9, List r10, int r11, DefaultConstructorMarker r12) {
        String r0 = "";
        if ((r11 & 1) == 0) goto L5;
        String r13 = "";
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r11 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r11 & 8) == 0) goto L17;
        List r3 = null;
    L19:
        if ((r11 & 16) != 0) goto L23;
        r0 = r9;
    L23:
        if ((r11 & 32) == 0) goto L25;
        r10 = CollectionsKt.emptyList();
    L25:
        this(r13, r1, r2, r3, r0, r10);
        return;
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
        r13 = r5;
        goto L7
    }
}
