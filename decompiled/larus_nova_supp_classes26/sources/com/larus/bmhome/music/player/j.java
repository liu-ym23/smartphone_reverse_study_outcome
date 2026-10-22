package com.larus.bmhome.music.player;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bH\b\u0086\b\u0018\u0000 i2\u00020\u0001:\u0001iB«\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0003\u0010#\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010R\u001a\u00020\rHÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010U\u001a\u00020\u0012HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010]\u001a\u00020\rHÆ\u0003J\t\u0010^\u001a\u00020\rHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\t\u0010`\u001a\u00020\rHÆ\u0003J\t\u0010a\u001a\u00020\rHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\"HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u00ad\u0002\u0010d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0003\u0010#\u001a\u00020\u0003HÆ\u0001J\u0013\u0010e\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010g\u001a\u00020\tHÖ\u0001J\t\u0010h\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0016\u0010\u0017\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00101R\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b?\u00101R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010\u001f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00101\"\u0004\bC\u0010DR\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00101\"\u0004\bF\u0010DR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010'¨\u0006j"}, d2 = {"Lcom/larus/bmhome/music/player/MusicPlayerData;", "", "messageId", "", "conversationId", "botId", "showFrom", "sourceId", "sourceFrom", "", "videoModel", "vid", "autoPlay", "", "autoPlayMulti", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updateSyncTime", "", "playerEngineKey", "musicAppletMobContext", "Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "currentPage", "detailPage", "chatType", "title", "chunkUrl", "isTemplate", "compatMusicCardMob", "playList", "Lcom/larus/im/bean/message/block/player/ICreationPlayList;", "clickFromNext", "clickFromPrevious", "message", "Lcom/larus/im/bean/message/Message;", "mediaScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLkotlinx/coroutines/CoroutineScope;JLjava/lang/String;Lcom/larus/bmhome/music/mob/MusicAppletMobContext;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/larus/im/bean/message/block/player/ICreationPlayList;ZZLcom/larus/im/bean/message/Message;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getConversationId", "getBotId", "getShowFrom", "getSourceId", "getSourceFrom", "()I", "getVideoModel", "getVid", "getAutoPlay", "()Z", "getAutoPlayMulti", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getUpdateSyncTime", "()J", "getPlayerEngineKey", "getMusicAppletMobContext", "()Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "getCurrentPage", "getDetailPage", "getChatType", "getTitle", "getChunkUrl", "getCompatMusicCardMob", "getPlayList", "()Lcom/larus/im/bean/message/block/player/ICreationPlayList;", "getClickFromNext", "setClickFromNext", "(Z)V", "getClickFromPrevious", "setClickFromPrevious", "getMessage", "()Lcom/larus/im/bean/message/Message;", "getMediaScene", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "other", "hashCode", "toString", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {
    public final transient CoroutineScope a;

    @SerializedName("auto_play")
    private final boolean autoPlay;

    @SerializedName("auto_play_multi")
    private final boolean autoPlayMulti;
    public final transient long b;

    @SerializedName("bot_id")
    private final String botId;
    public final transient String c;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName("chunk_uri")
    private final String chunkUrl;

    @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("current_page")
    private final String currentPage;
    public final transient kr8.o d;

    @SerializedName("detail_page")
    private final boolean detailPage;
    public final transient boolean e;
    public final transient boolean f;
    public final transient ad9.b g;
    public transient boolean h;
    public transient boolean i;
    public final transient Message j;
    public final transient String k;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("show_from")
    private final String showFrom;

    @SerializedName("source_from")
    private final int sourceFrom;

    @SerializedName("source_id")
    private final String sourceId;

    @SerializedName("title")
    private final String title;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("video_model")
    private final String videoModel;

    public static final class a {
    }

    public j() {
        this(null, null, null, null, null, 0, null, null, false, false, null, 0, null, null, null, false, null, null, null, false, false, null, false, false, null, null, 67108863);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (Intrinsics.areEqual(this.messageId, r9.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r9.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botId, r9.botId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showFrom, r9.showFrom) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceId, r9.sourceId) == true) goto L24;
        return false;
    L24:
        if (this.sourceFrom == r9.sourceFrom) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.videoModel, r9.videoModel) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.vid, r9.vid) == true) goto L33;
        return false;
    L33:
        if (this.autoPlay == r9.autoPlay) goto L36;
        return false;
    L36:
        if (this.autoPlayMulti == r9.autoPlayMulti) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L42;
        return false;
    L42:
        if (this.b == r9.b) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.currentPage, r9.currentPage) == true) goto L54;
        return false;
    L54:
        if (this.detailPage == r9.detailPage) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.chatType, r9.chatType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.title, r9.title) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.chunkUrl, r9.chunkUrl) == true) goto L66;
        return false;
    L66:
        if (this.e == r9.e) goto L69;
        return false;
    L69:
        if (this.f == r9.f) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L75;
        return false;
    L75:
        if (this.h == r9.h) goto L78;
        return false;
    L78:
        if (this.i == r9.i) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L86;
        return false;
    L86:
        return true;
    }

    public final int hashCode() {
        String r0 = this.messageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.conversationId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.botId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.showFrom;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.sourceId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((r12 + r14) * 31) + this.sourceFrom) * 31;
        String r16 = this.videoModel;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.vid;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        int r22 = 1231;
        if (this.autoPlay == false) goto L33;
        int r23 = 1231;
    L34:
        int r24 = (r21 + r23) * 31;
        if (this.autoPlayMulti == false) goto L37;
        int r25 = 1231;
    L38:
        int r26 = (r24 + r25) * 31;
        CoroutineScope r27 = this.a;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        long r29 = this.b;
        int r30 = (((r26 + r28) * 31) + ((int) (r29 ^ (r29 >>> 32)))) * 31;
        String r31 = this.c;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        kr8.o r34 = this.d;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.currentPage;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        if (this.detailPage == false) goto L57;
        int r40 = 1231;
    L58:
        int r41 = (r39 + r40) * 31;
        String r42 = this.chatType;
        if (r42 != null) goto L61;
        int r43 = 0;
    L62:
        int r44 = (r41 + r43) * 31;
        String r45 = this.title;
        if (r45 != null) goto L65;
        int r46 = 0;
    L66:
        int r47 = (r44 + r46) * 31;
        String r48 = this.chunkUrl;
        if (r48 != null) goto L69;
        int r49 = 0;
    L70:
        int r50 = (r47 + r49) * 31;
        if (this.e == false) goto L73;
        int r51 = 1231;
    L74:
        int r52 = (r50 + r51) * 31;
        if (this.f == false) goto L77;
        int r53 = 1231;
    L78:
        int r54 = (r52 + r53) * 31;
        ad9.b r55 = this.g;
        if (r55 != null) goto L81;
        int r56 = 0;
    L82:
        int r57 = (r54 + r56) * 31;
        if (this.h == false) goto L85;
        int r58 = 1231;
    L86:
        int r59 = (r57 + r58) * 31;
        if (this.i == true) goto L90;
        r22 = 1237;
    L90:
        int r60 = (r59 + r22) * 31;
        Message r61 = this.j;
        if (r61 == null) goto L95;
        r1 = r61.hashCode();
    L95:
        return ((r60 + r1) * 31) + this.k.hashCode();
    L85:
        r58 = 1237;
        goto L86
    L81:
        r56 = r55.hashCode();
        goto L82
    L77:
        r53 = 1237;
        goto L78
    L73:
        r51 = 1237;
        goto L74
    L69:
        r49 = r48.hashCode();
        goto L70
    L65:
        r46 = r45.hashCode();
        goto L66
    L61:
        r43 = r42.hashCode();
        goto L62
    L57:
        r40 = 1237;
        goto L58
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
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = 1237;
        goto L38
    L33:
        r23 = 1237;
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
        return "MusicPlayerData(messageId=" + this.messageId + ", conversationId=" + this.conversationId + ", botId=" + this.botId + ", showFrom=" + this.showFrom + ", sourceId=" + this.sourceId + ", sourceFrom=" + this.sourceFrom + ", videoModel=" + this.videoModel + ", vid=" + this.vid + ", autoPlay=" + this.autoPlay + ", autoPlayMulti=" + this.autoPlayMulti + ", scope=" + this.a + ", updateSyncTime=" + this.b + ", playerEngineKey=" + this.c + ", musicAppletMobContext=" + this.d + ", currentPage=" + this.currentPage + ", detailPage=" + this.detailPage + ", chatType=" + this.chatType + ", title=" + this.title + ", chunkUrl=" + this.chunkUrl + ", isTemplate=" + this.e + ", compatMusicCardMob=" + this.f + ", playList=" + this.g + ", clickFromNext=" + this.h + ", clickFromPrevious=" + this.i + ", message=" + this.j + ", mediaScene=" + this.k + ')';
    }

    static {
        new Gson();
    }

    public final boolean b() {
        return this.autoPlay;
    }

    public final boolean c() {
        return this.autoPlayMulti;
    }

    public final String d() {
        return this.botId;
    }

    public final String e() {
        return this.chatType;
    }

    public final String f() {
        return this.chunkUrl;
    }

    public final String g() {
        return this.conversationId;
    }

    public final String h() {
        return this.currentPage;
    }

    public final boolean i() {
        return this.detailPage;
    }

    public final String j() {
        return this.messageId;
    }

    public final String k() {
        return this.showFrom;
    }

    public final int l() {
        return this.sourceFrom;
    }

    public final String m() {
        return this.sourceId;
    }

    public final String n() {
        return this.title;
    }

    public final String o() {
        return this.vid;
    }

    public final String p() {
        return this.videoModel;
    }

    public static j a(j r32, String r33, String r34, boolean r35, boolean r36, LifecycleCoroutineScope r37, long r38, kr8.o r40, String r41, boolean r42, String r43, String r44, ad9.b r45, boolean r46, boolean r47, Message r48, int r49) {
        if ((r49 & 1) == 0) goto L5;
        String r5 = r32.messageId;
    L7:
        if ((r49 & 2) == 0) goto L9;
        String r6 = r32.conversationId;
    L11:
        if ((r49 & 4) == 0) goto L13;
        String r7 = r32.botId;
    L15:
        if ((r49 & 8) == 0) goto L17;
        String r8 = r32.showFrom;
    L19:
        if ((r49 & 16) == 0) goto L21;
        String r9 = r32.sourceId;
    L23:
        if ((r49 & 32) == 0) goto L25;
        int r10 = r32.sourceFrom;
    L27:
        if ((r49 & 64) == 0) goto L29;
        String r11 = r32.videoModel;
    L31:
        if ((r49 & 128) == 0) goto L33;
        String r12 = r32.vid;
    L35:
        if ((r49 & 256) == 0) goto L37;
        boolean r13 = r32.autoPlay;
    L39:
        if ((r49 & 512) == 0) goto L41;
        boolean r14 = r32.autoPlayMulti;
    L43:
        if ((r49 & 1024) == 0) goto L45;
        LifecycleCoroutineScope r15 = r32.a;
    L47:
        if ((r49 & 2048) == 0) goto L49;
        long r17 = r32.b;
    L51:
        if ((r49 & 4096) == 0) goto L53;
        String r3 = r32.c;
    L55:
        if ((r49 & 8192) == 0) goto L57;
        kr8.o r19 = r32.d;
    L59:
        if ((r49 & 16384) == 0) goto L61;
        String r20 = r32.currentPage;
    L63:
        if ((32768 & r49) == 0) goto L65;
        boolean r21 = r32.detailPage;
    L67:
        if ((65536 & r49) == 0) goto L69;
        String r22 = r32.chatType;
    L71:
        if ((131072 & r49) == 0) goto L73;
        String r23 = r32.title;
    L75:
        if ((262144 & r49) == 0) goto L77;
        String r24 = r32.chunkUrl;
    L79:
        if ((524288 & r49) == 0) goto L81;
        boolean r25 = r32.e;
    L83:
        if ((1048576 & r49) == 0) goto L85;
        boolean r26 = r32.f;
    L87:
        if ((2097152 & r49) == 0) goto L89;
        ad9.b r27 = r32.g;
    L91:
        if ((4194304 & r49) == 0) goto L93;
        boolean r28 = r32.h;
    L95:
        if ((8388608 & r49) == 0) goto L97;
        boolean r29 = r32.i;
    L99:
        if ((16777216 & r49) == 0) goto L101;
        Message r30 = r32.j;
    L103:
        if ((r49 & 33554432) == 0) goto L105;
        String r1 = r32.k;
    L106:
        r32.getClass();
        Intrinsics.checkNotNullParameter(r1, "mediaScene");
        return new j(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r3, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r1);
    L105:
        r1 = null;
        goto L106
    L101:
        r30 = r48;
        goto L103
    L97:
        r29 = r47;
        goto L99
    L93:
        r28 = r46;
        goto L95
    L89:
        r27 = r45;
        goto L91
    L85:
        r26 = false;
        goto L87
    L81:
        r25 = false;
        goto L83
    L77:
        r24 = r44;
        goto L79
    L73:
        r23 = r43;
        goto L75
    L69:
        r22 = null;
        goto L71
    L65:
        r21 = r42;
        goto L67
    L61:
        r20 = r41;
        goto L63
    L57:
        r19 = r40;
        goto L59
    L53:
        r3 = null;
        goto L55
    L49:
        r17 = r38;
        goto L51
    L45:
        r15 = r37;
        goto L47
    L41:
        r14 = r36;
        goto L43
    L37:
        r13 = r35;
        goto L39
    L33:
        r12 = r34;
        goto L35
    L29:
        r11 = r33;
        goto L31
    L25:
        r10 = 0;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public j(String r5, String r6, String r7, String r8, String r9, int r10, String r11, String r12, boolean r13, boolean r14, CoroutineScope r15, long r16, String r18, kr8.o r19, String r20, boolean r21, String r22, String r23, String r24, boolean r25, boolean r26, ad9.b r27, boolean r28, boolean r29, Message r30, @MediaScene String r31) {
        Intrinsics.checkNotNullParameter(r31, "mediaScene");
        this.messageId = r5;
        this.conversationId = r6;
        this.botId = r7;
        this.showFrom = r8;
        this.sourceId = r9;
        this.sourceFrom = r10;
        this.videoModel = r11;
        this.vid = r12;
        this.autoPlay = r13;
        this.autoPlayMulti = r14;
        this.a = r15;
        this.b = r16;
        this.c = r18;
        this.d = r19;
        this.currentPage = r20;
        this.detailPage = r21;
        this.chatType = r22;
        this.title = r23;
        this.chunkUrl = r24;
        this.e = r25;
        this.f = r26;
        this.g = r27;
        this.h = r28;
        this.i = r29;
        this.j = r30;
        this.k = r31;
    }

    public /* synthetic */ j(String r29, String r30, String r31, String r32, String r33, int r34, String r35, String r36, boolean r37, boolean r38, CoroutineScope r39, long r40, String r42, kr8.o r43, String r44, boolean r45, String r46, String r47, String r48, boolean r49, boolean r50, ad9.b r51, boolean r52, boolean r53, Message r54, String r55, int r56) {
        if ((r56 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r56 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r56 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r56 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r56 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r56 & 32) == 0) goto L25;
        int r7 = 0;
    L27:
        if ((r56 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r56 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r56 & 256) == 0) goto L37;
        boolean r11 = false;
    L39:
        if ((r56 & 512) == 0) goto L41;
        boolean r12 = false;
    L43:
        if ((r56 & 1024) == 0) goto L45;
        CoroutineScope r13 = null;
    L47:
        if ((r56 & 2048) == 0) goto L49;
        long r15 = 500;
    L51:
        if ((r56 & 4096) == 0) goto L53;
        String r8 = null;
    L55:
        if ((r56 & 8192) == 0) goto L57;
        kr8.o r14 = null;
    L58:
        String r17 = "";
        if ((r56 & 16384) == 0) goto L61;
        String r2 = r17;
    L63:
        if ((r56 & 32768) == 0) goto L65;
        boolean r18 = false;
    L67:
        if ((r56 & 65536) == 0) goto L69;
        String r19 = r17;
    L71:
        if ((r56 & 131072) == 0) goto L73;
        String r20 = r17;
    L75:
        if ((r56 & 262144) != 0) goto L79;
        r17 = r48;
    L79:
        if ((r56 & 524288) == 0) goto L81;
        boolean r21 = false;
    L83:
        if ((r56 & 1048576) == 0) goto L85;
        boolean r22 = false;
    L87:
        if ((r56 & 2097152) == 0) goto L89;
        ad9.b r23 = null;
    L91:
        if ((r56 & 4194304) == 0) goto L93;
        boolean r24 = false;
    L95:
        if ((r56 & 8388608) == 0) goto L97;
        boolean r25 = false;
    L99:
        if ((r56 & 16777216) == 0) goto L101;
        Message r26 = null;
    L103:
        if ((r56 & 33554432) == 0) goto L105;
        String r0 = "music";
    L106:
        this(r1, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13, r15, r8, r14, r2, r18, r19, r20, r17, r21, r22, r23, r24, r25, r26, r0);
        return;
    L105:
        r0 = r55;
        goto L106
    L101:
        r26 = r54;
        goto L103
    L97:
        r25 = r53;
        goto L99
    L93:
        r24 = r52;
        goto L95
    L89:
        r23 = r51;
        goto L91
    L85:
        r22 = r50;
        goto L87
    L81:
        r21 = r49;
        goto L83
    L73:
        r20 = r47;
        goto L75
    L69:
        r19 = r46;
        goto L71
    L65:
        r18 = r45;
        goto L67
    L61:
        r2 = r44;
        goto L63
    L57:
        r14 = r43;
        goto L58
    L53:
        r8 = r42;
        goto L55
    L49:
        r15 = r40;
        goto L51
    L45:
        r13 = r39;
        goto L47
    L41:
        r12 = r38;
        goto L43
    L37:
        r11 = r37;
        goto L39
    L33:
        r10 = r36;
        goto L35
    L29:
        r9 = r35;
        goto L31
    L25:
        r7 = r34;
        goto L27
    L21:
        r6 = r33;
        goto L23
    L17:
        r5 = r32;
        goto L19
    L13:
        r4 = r31;
        goto L15
    L9:
        r3 = r30;
        goto L11
    L5:
        r1 = r29;
        goto L7
    }
}
