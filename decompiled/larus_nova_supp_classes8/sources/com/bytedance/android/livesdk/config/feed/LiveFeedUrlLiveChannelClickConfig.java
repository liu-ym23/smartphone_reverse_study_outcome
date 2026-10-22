package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedUrlLiveChannelClickConfig;", "", "liveChannel", "", "liveChannelVoice", "liveChannelFm", "liveChannelCity", "liveChannelFollow", "liveChannelChat", "liveChannelGame", "liveChannelShopping", "liveChannelMusic", "liveChannelScience", "liveChannelBook", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLiveChannel", "()Ljava/lang/String;", "setLiveChannel", "(Ljava/lang/String;)V", "getLiveChannelBook", "setLiveChannelBook", "getLiveChannelChat", "setLiveChannelChat", "getLiveChannelCity", "setLiveChannelCity", "getLiveChannelFm", "setLiveChannelFm", "getLiveChannelFollow", "setLiveChannelFollow", "getLiveChannelGame", "setLiveChannelGame", "getLiveChannelMusic", "setLiveChannelMusic", "getLiveChannelScience", "setLiveChannelScience", "getLiveChannelShopping", "setLiveChannelShopping", "getLiveChannelVoice", "setLiveChannelVoice", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedUrlLiveChannelClickConfig {

    @SerializedName("live_channel")
    private String liveChannel;

    @SerializedName("live_channel_book")
    private String liveChannelBook;

    @SerializedName("live_channel_chat")
    private String liveChannelChat;

    @SerializedName("live_channel_city")
    private String liveChannelCity;

    @SerializedName("live_channel_fm")
    private String liveChannelFm;

    @SerializedName("live_channel_follow")
    private String liveChannelFollow;

    @SerializedName("live_channel_game")
    private String liveChannelGame;

    @SerializedName("live_channel_music")
    private String liveChannelMusic;

    @SerializedName("live_channel_science")
    private String liveChannelScience;

    @SerializedName("live_channel_shopping")
    private String liveChannelShopping;

    @SerializedName("live_channel_voice")
    private String liveChannelVoice;

    public LiveFeedUrlLiveChannelClickConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ LiveFeedUrlLiveChannelClickConfig copy$default(LiveFeedUrlLiveChannelClickConfig r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.liveChannel;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.liveChannelVoice;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.liveChannelFm;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.liveChannelCity;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.liveChannelFollow;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.liveChannelChat;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.liveChannelGame;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.liveChannelShopping;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.liveChannelMusic;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = r12.liveChannelScience;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.liveChannelBook;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.liveChannel;
    }

    public final String component10() {
        return this.liveChannelScience;
    }

    public final String component11() {
        return this.liveChannelBook;
    }

    public final String component2() {
        return this.liveChannelVoice;
    }

    public final String component3() {
        return this.liveChannelFm;
    }

    public final String component4() {
        return this.liveChannelCity;
    }

    public final String component5() {
        return this.liveChannelFollow;
    }

    public final String component6() {
        return this.liveChannelChat;
    }

    public final String component7() {
        return this.liveChannelGame;
    }

    public final String component8() {
        return this.liveChannelShopping;
    }

    public final String component9() {
        return this.liveChannelMusic;
    }

    public final LiveFeedUrlLiveChannelClickConfig copy(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        return new LiveFeedUrlLiveChannelClickConfig(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveFeedUrlLiveChannelClickConfig) == false) goto L28;
        LiveFeedUrlLiveChannelClickConfig r4 = (LiveFeedUrlLiveChannelClickConfig) r3;
        if (Intrinsics.areEqual(this.liveChannel, r4.liveChannel) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveChannelVoice, r4.liveChannelVoice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.liveChannelFm, r4.liveChannelFm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveChannelCity, r4.liveChannelCity) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveChannelFollow, r4.liveChannelFollow) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.liveChannelChat, r4.liveChannelChat) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.liveChannelGame, r4.liveChannelGame) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.liveChannelShopping, r4.liveChannelShopping) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.liveChannelMusic, r4.liveChannelMusic) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liveChannelScience, r4.liveChannelScience) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.liveChannelBook, r4.liveChannelBook) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        String r0 = this.liveChannel;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.liveChannelVoice;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.liveChannelFm;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.liveChannelCity;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.liveChannelFollow;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.liveChannelChat;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.liveChannelGame;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.liveChannelShopping;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.liveChannelMusic;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.liveChannelScience;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.liveChannelBook;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        return r30 + r1;
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LiveFeedUrlLiveChannelClickConfig(liveChannel=" + this.liveChannel + ", liveChannelVoice=" + this.liveChannelVoice + ", liveChannelFm=" + this.liveChannelFm + ", liveChannelCity=" + this.liveChannelCity + ", liveChannelFollow=" + this.liveChannelFollow + ", liveChannelChat=" + this.liveChannelChat + ", liveChannelGame=" + this.liveChannelGame + ", liveChannelShopping=" + this.liveChannelShopping + ", liveChannelMusic=" + this.liveChannelMusic + ", liveChannelScience=" + this.liveChannelScience + ", liveChannelBook=" + this.liveChannelBook + ")";
    }

    public final String getLiveChannel() {
        return this.liveChannel;
    }

    public final String getLiveChannelBook() {
        return this.liveChannelBook;
    }

    public final String getLiveChannelChat() {
        return this.liveChannelChat;
    }

    public final String getLiveChannelCity() {
        return this.liveChannelCity;
    }

    public final String getLiveChannelFm() {
        return this.liveChannelFm;
    }

    public final String getLiveChannelFollow() {
        return this.liveChannelFollow;
    }

    public final String getLiveChannelGame() {
        return this.liveChannelGame;
    }

    public final String getLiveChannelMusic() {
        return this.liveChannelMusic;
    }

    public final String getLiveChannelScience() {
        return this.liveChannelScience;
    }

    public final String getLiveChannelShopping() {
        return this.liveChannelShopping;
    }

    public final String getLiveChannelVoice() {
        return this.liveChannelVoice;
    }

    public final void setLiveChannel(String r1) {
        this.liveChannel = r1;
    }

    public final void setLiveChannelBook(String r1) {
        this.liveChannelBook = r1;
    }

    public final void setLiveChannelChat(String r1) {
        this.liveChannelChat = r1;
    }

    public final void setLiveChannelCity(String r1) {
        this.liveChannelCity = r1;
    }

    public final void setLiveChannelFm(String r1) {
        this.liveChannelFm = r1;
    }

    public final void setLiveChannelFollow(String r1) {
        this.liveChannelFollow = r1;
    }

    public final void setLiveChannelGame(String r1) {
        this.liveChannelGame = r1;
    }

    public final void setLiveChannelMusic(String r1) {
        this.liveChannelMusic = r1;
    }

    public final void setLiveChannelScience(String r1) {
        this.liveChannelScience = r1;
    }

    public final void setLiveChannelShopping(String r1) {
        this.liveChannelShopping = r1;
    }

    public final void setLiveChannelVoice(String r1) {
        this.liveChannelVoice = r1;
    }

    public LiveFeedUrlLiveChannelClickConfig(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        this.liveChannel = r1;
        this.liveChannelVoice = r2;
        this.liveChannelFm = r3;
        this.liveChannelCity = r4;
        this.liveChannelFollow = r5;
        this.liveChannelChat = r6;
        this.liveChannelGame = r7;
        this.liveChannelShopping = r8;
        this.liveChannelMusic = r9;
        this.liveChannelScience = r10;
        this.liveChannelBook = r11;
    }

    public /* synthetic */ LiveFeedUrlLiveChannelClickConfig(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        String r2 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r24 & 1024) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
