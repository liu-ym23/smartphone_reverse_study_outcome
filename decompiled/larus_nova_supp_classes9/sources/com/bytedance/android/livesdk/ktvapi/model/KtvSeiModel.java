package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0002\u0010\u001aJ\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\tHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\tHÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\t\u0010V\u001a\u00020\tHÆ\u0003J\t\u0010W\u001a\u00020\fHÆ\u0003J\t\u0010X\u001a\u00020\fHÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J»\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\tHÆ\u0001J\u0013\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\tHÖ\u0001J\t\u0010_\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001e\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001e\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\u001e\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R\u001e\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&¨\u0006`"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/KtvSeiModel;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "idStr", BuildConfig.FLAVOR, "anchorId", "anchorIdStr", "cmd", BuildConfig.FLAVOR, "lyricsType", "playTime", BuildConfig.FLAVOR, "duration", "lyricsInfo", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/ktvapi/model/SeiLyricsInfo;", "lyricsOffset", "senderUserId", "senderUserIdStr", "musicPlayStatus", "orderInfo", "Lcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;", "state", "lyricUrl", "needFilterSelf", "(JLjava/lang/String;JLjava/lang/String;IIFFLjava/util/List;IJLjava/lang/String;ILcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;ILjava/lang/String;I)V", "getAnchorId", "()J", "setAnchorId", "(J)V", "getAnchorIdStr", "()Ljava/lang/String;", "setAnchorIdStr", "(Ljava/lang/String;)V", "getCmd", "()I", "setCmd", "(I)V", "getDuration", "()F", "setDuration", "(F)V", "getId", "setId", "getIdStr", "setIdStr", "getLyricUrl", "setLyricUrl", "getLyricsInfo", "()Ljava/util/List;", "setLyricsInfo", "(Ljava/util/List;)V", "getLyricsOffset", "setLyricsOffset", "getLyricsType", "setLyricsType", "getMusicPlayStatus", "setMusicPlayStatus", "getNeedFilterSelf", "setNeedFilterSelf", "getOrderInfo", "()Lcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;", "setOrderInfo", "(Lcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;)V", "getPlayTime", "setPlayTime", "getSenderUserId", "setSenderUserId", "getSenderUserIdStr", "setSenderUserIdStr", "getState", "setState", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvSeiModel {

    @SerializedName("anchor_id")
    private long anchorId;

    @SerializedName("anchor_id_str")
    private String anchorIdStr;

    @SerializedName("cmd")
    private int cmd;

    @SerializedName("duration")
    private float duration;

    @SerializedName("id")
    private long id;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("lyric_url")
    private String lyricUrl;

    @SerializedName("lyricsInfo")
    private List<SeiLyricsInfo> lyricsInfo;

    @SerializedName("lyrics_offset")
    private int lyricsOffset;

    @SerializedName("lyrics_type")
    private int lyricsType;

    @SerializedName("music_play_status")
    private int musicPlayStatus;

    @SerializedName("need_filter_self")
    private int needFilterSelf;

    @SerializedName("order_info")
    private OrderSongSeiModel orderInfo;

    @SerializedName("play_time")
    private float playTime;

    @SerializedName("sender_user_id")
    private long senderUserId;

    @SerializedName("sender_user_id_str")
    private String senderUserIdStr;

    @SerializedName("state")
    private int state;

    public KtvSeiModel() {
        this(0, null, 0, null, 0, 0, 0.0f, 0.0f, null, 0, 0, null, 0, null, 0, null, 0, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KtvSeiModel copy$default(KtvSeiModel r17, long r18, String r20, long r21, String r23, int r24, int r25, float r26, float r27, List r28, int r29, long r30, String r33, int r34, OrderSongSeiModel r35, int r36, String r37, int r38, int r39, Object r310) {
        if ((r39 & 1) == 0) goto L5;
        long r2 = r17.id;
    L7:
        if ((r39 & 2) == 0) goto L9;
        String r4 = r17.idStr;
    L11:
        if ((r39 & 4) == 0) goto L13;
        long r5 = r17.anchorId;
    L15:
        if ((r39 & 8) == 0) goto L17;
        String r7 = r17.anchorIdStr;
    L19:
        if ((r39 & 16) == 0) goto L21;
        int r8 = r17.cmd;
    L23:
        if ((r39 & 32) == 0) goto L25;
        int r9 = r17.lyricsType;
    L27:
        if ((r39 & 64) == 0) goto L29;
        float r10 = r17.playTime;
    L31:
        if ((r39 & 128) == 0) goto L33;
        float r11 = r17.duration;
    L35:
        if ((r39 & 256) == 0) goto L37;
        List r13 = r17.lyricsInfo;
    L39:
        if ((r39 & 512) == 0) goto L41;
        int r14 = r17.lyricsOffset;
    L43:
        if ((r39 & 1024) == 0) goto L45;
        long r15 = r17.senderUserId;
    L46:
        long r31 = r15;
        if ((r39 & 2048) == 0) goto L49;
        String r16 = r17.senderUserIdStr;
    L51:
        if ((r39 & 4096) == 0) goto L53;
        int r19 = r17.musicPlayStatus;
    L54:
        int r311 = r19;
        if ((r39 & 8192) == 0) goto L57;
        OrderSongSeiModel r110 = r17.orderInfo;
    L58:
        OrderSongSeiModel r312 = r110;
        if ((r39 & 16384) == 0) goto L61;
        int r111 = r17.state;
    L62:
        int r313 = r111;
        if ((r39 & 32768) == 0) goto L65;
        String r112 = r17.lyricUrl;
    L67:
        if ((r39 & 65536) == 0) goto L69;
        int r1 = r17.needFilterSelf;
    L71:
        return r17.copy(r2, r4, r5, r7, r8, r9, r10, r11, r13, r14, r31, r16, r311, r312, r313, r112, r1);
    L69:
        r1 = r38;
        goto L71
    L65:
        r112 = r37;
        goto L67
    L61:
        r111 = r36;
        goto L62
    L57:
        r110 = r35;
        goto L58
    L53:
        r19 = r34;
        goto L54
    L49:
        r16 = r33;
        goto L51
    L45:
        r15 = r30;
        goto L46
    L41:
        r14 = r29;
        goto L43
    L37:
        r13 = r28;
        goto L39
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.lyricsOffset;
    }

    public final long component11() {
        return this.senderUserId;
    }

    public final String component12() {
        return this.senderUserIdStr;
    }

    public final int component13() {
        return this.musicPlayStatus;
    }

    public final OrderSongSeiModel component14() {
        return this.orderInfo;
    }

    public final int component15() {
        return this.state;
    }

    public final String component16() {
        return this.lyricUrl;
    }

    public final int component17() {
        return this.needFilterSelf;
    }

    public final String component2() {
        return this.idStr;
    }

    public final long component3() {
        return this.anchorId;
    }

    public final String component4() {
        return this.anchorIdStr;
    }

    public final int component5() {
        return this.cmd;
    }

    public final int component6() {
        return this.lyricsType;
    }

    public final float component7() {
        return this.playTime;
    }

    public final float component8() {
        return this.duration;
    }

    public final List<SeiLyricsInfo> component9() {
        return this.lyricsInfo;
    }

    public final KtvSeiModel copy(long r23, String r25, long r26, String r28, int r29, int r30, float r31, float r33, List<SeiLyricsInfo> r34, int r35, long r36, String r37, int r38, OrderSongSeiModel r39, int r40, String r41, int r43) {
        Intrinsics.checkNotNullParameter(r25, "idStr");
        Intrinsics.checkNotNullParameter(r28, "anchorIdStr");
        Intrinsics.checkNotNullParameter(r34, "lyricsInfo");
        Intrinsics.checkNotNullParameter(r37, "senderUserIdStr");
        Intrinsics.checkNotNullParameter(r41, "lyricUrl");
        return new KtvSeiModel(r23, r25, r26, r28, r29, r30, r31, r33, r34, r35, r36, r37, r38, r39, r40, r41, r43);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof KtvSeiModel) == false) goto L40;
        KtvSeiModel r7 = (KtvSeiModel) r6;
        if (this.id == r7.id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.idStr, r7.idStr) == true) goto L10;
        return false;
    L10:
        if (this.anchorId == r7.anchorId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorIdStr, r7.anchorIdStr) == true) goto L14;
        return false;
    L14:
        if (this.cmd == r7.cmd) goto L16;
        return false;
    L16:
        if (this.lyricsType == r7.lyricsType) goto L18;
        return false;
    L18:
        if (Float.compare(this.playTime, r7.playTime) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.duration, r7.duration) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.lyricsInfo, r7.lyricsInfo) == true) goto L24;
        return false;
    L24:
        if (this.lyricsOffset == r7.lyricsOffset) goto L26;
        return false;
    L26:
        if (this.senderUserId == r7.senderUserId) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.senderUserIdStr, r7.senderUserIdStr) == true) goto L30;
        return false;
    L30:
        if (this.musicPlayStatus == r7.musicPlayStatus) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.orderInfo, r7.orderInfo) == true) goto L34;
        return false;
    L34:
        if (this.state == r7.state) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lyricUrl, r7.lyricUrl) == true) goto L38;
        return false;
    L38:
        if (this.needFilterSelf == r7.needFilterSelf) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.idStr;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        long r5 = this.anchorId;
        int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.anchorIdStr;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (((((((((r6 + r8) * 31) + this.cmd) * 31) + this.lyricsType) * 31) + Float.floatToIntBits(this.playTime)) * 31) + Float.floatToIntBits(this.duration)) * 31;
        List<SeiLyricsInfo> r10 = this.lyricsInfo;
        if (r10 == null) goto L13;
        int r11 = r10.hashCode();
    L14:
        int r13 = (((r9 + r11) * 31) + this.lyricsOffset) * 31;
        long r14 = this.senderUserId;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        String r16 = this.senderUserIdStr;
        if (r16 == null) goto L17;
        int r17 = r16.hashCode();
    L18:
        int r18 = (((r15 + r17) * 31) + this.musicPlayStatus) * 31;
        OrderSongSeiModel r19 = this.orderInfo;
        if (r19 == null) goto L21;
        int r20 = r19.hashCode();
    L22:
        int r21 = (((r18 + r20) * 31) + this.state) * 31;
        String r23 = this.lyricUrl;
        if (r23 == null) goto L26;
        r3 = r23.hashCode();
    L26:
        return ((r21 + r3) * 31) + this.needFilterSelf;
    L21:
        r20 = 0;
        goto L22
    L17:
        r17 = 0;
        goto L18
    L13:
        r11 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public String toString() {
        return "KtvSeiModel(id=" + this.id + ", idStr=" + this.idStr + ", anchorId=" + this.anchorId + ", anchorIdStr=" + this.anchorIdStr + ", cmd=" + this.cmd + ", lyricsType=" + this.lyricsType + ", playTime=" + this.playTime + ", duration=" + this.duration + ", lyricsInfo=" + this.lyricsInfo + ", lyricsOffset=" + this.lyricsOffset + ", senderUserId=" + this.senderUserId + ", senderUserIdStr=" + this.senderUserIdStr + ", musicPlayStatus=" + this.musicPlayStatus + ", orderInfo=" + this.orderInfo + ", state=" + this.state + ", lyricUrl=" + this.lyricUrl + ", needFilterSelf=" + this.needFilterSelf + ")";
    }

    public final long getAnchorId() {
        return this.anchorId;
    }

    public final String getAnchorIdStr() {
        return this.anchorIdStr;
    }

    public final int getCmd() {
        return this.cmd;
    }

    public final float getDuration() {
        return this.duration;
    }

    public final long getId() {
        return this.id;
    }

    public final String getIdStr() {
        return this.idStr;
    }

    public final String getLyricUrl() {
        return this.lyricUrl;
    }

    public final List<SeiLyricsInfo> getLyricsInfo() {
        return this.lyricsInfo;
    }

    public final int getLyricsOffset() {
        return this.lyricsOffset;
    }

    public final int getLyricsType() {
        return this.lyricsType;
    }

    public final int getMusicPlayStatus() {
        return this.musicPlayStatus;
    }

    public final int getNeedFilterSelf() {
        return this.needFilterSelf;
    }

    public final OrderSongSeiModel getOrderInfo() {
        return this.orderInfo;
    }

    public final float getPlayTime() {
        return this.playTime;
    }

    public final long getSenderUserId() {
        return this.senderUserId;
    }

    public final String getSenderUserIdStr() {
        return this.senderUserIdStr;
    }

    public final int getState() {
        return this.state;
    }

    public final void setAnchorId(long r1) {
        this.anchorId = r1;
    }

    public final void setAnchorIdStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorIdStr = r2;
    }

    public final void setCmd(int r1) {
        this.cmd = r1;
    }

    public final void setDuration(float r1) {
        this.duration = r1;
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public final void setIdStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.idStr = r2;
    }

    public final void setLyricUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lyricUrl = r2;
    }

    public final void setLyricsInfo(List<SeiLyricsInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lyricsInfo = r2;
    }

    public final void setLyricsOffset(int r1) {
        this.lyricsOffset = r1;
    }

    public final void setLyricsType(int r1) {
        this.lyricsType = r1;
    }

    public final void setMusicPlayStatus(int r1) {
        this.musicPlayStatus = r1;
    }

    public final void setNeedFilterSelf(int r1) {
        this.needFilterSelf = r1;
    }

    public final void setOrderInfo(OrderSongSeiModel r1) {
        this.orderInfo = r1;
    }

    public final void setPlayTime(float r1) {
        this.playTime = r1;
    }

    public final void setSenderUserId(long r1) {
        this.senderUserId = r1;
    }

    public final void setSenderUserIdStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.senderUserIdStr = r2;
    }

    public final void setState(int r1) {
        this.state = r1;
    }

    public KtvSeiModel(long r9, String r11, long r13, String r14, int r15, int r16, float r17, float r18, List<SeiLyricsInfo> r19, int r20, long r21, String r23, int r24, OrderSongSeiModel r25, int r26, String r27, int r28) {
        Intrinsics.checkNotNullParameter(r11, "idStr");
        Intrinsics.checkNotNullParameter(r14, "anchorIdStr");
        Intrinsics.checkNotNullParameter(r19, "lyricsInfo");
        Intrinsics.checkNotNullParameter(r23, "senderUserIdStr");
        Intrinsics.checkNotNullParameter(r27, "lyricUrl");
        this.id = r9;
        this.idStr = r11;
        this.anchorId = r13;
        this.anchorIdStr = r14;
        this.cmd = r15;
        this.lyricsType = r16;
        this.playTime = r17;
        this.duration = r18;
        this.lyricsInfo = r19;
        this.lyricsOffset = r20;
        this.senderUserId = r21;
        this.senderUserIdStr = r23;
        this.musicPlayStatus = r24;
        this.orderInfo = r25;
        this.state = r26;
        this.lyricUrl = r27;
        this.needFilterSelf = r28;
    }

    public /* synthetic */ KtvSeiModel(long r23, String r24, long r25, String r27, int r28, int r29, float r30, float r31, List r33, int r34, long r35, String r36, int r37, OrderSongSeiModel r38, int r39, String r40, int r41, int r43, DefaultConstructorMarker r44) {
        if ((r43 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r43 & 2) == 0) goto L9;
        String r1 = BuildConfig.FLAVOR;
    L11:
        if ((r43 & 4) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r43 & 8) == 0) goto L17;
        String r9 = BuildConfig.FLAVOR;
    L19:
        if ((r43 & 16) == 0) goto L21;
        int r10 = KtvCommand.NOTHING.getValue();
    L23:
        if ((r43 & 32) == 0) goto L25;
        int r11 = LyricsType.UNKNOWN.getValue();
    L26:
        float r13 = 0.0f;
        if ((r43 & 64) == 0) goto L29;
        float r14 = 0.0f;
    L31:
        if ((r43 & 128) != 0) goto L35;
        r13 = r31;
    L35:
        if ((r43 & 256) == 0) goto L37;
        List r15 = CollectionsKt.emptyList();
    L38:
        int r16 = 0;
        if ((r43 & 512) == 0) goto L41;
        int r17 = 0;
    L43:
        if ((r43 & 1024) == 0) goto L45;
        long r18 = 0;
    L47:
        if ((r43 & 2048) == 0) goto L49;
        String r2 = BuildConfig.FLAVOR;
    L51:
        if ((r43 & 4096) == 0) goto L53;
        int r3 = MusicPlayStatus.UNKNOWN.getValue();
    L55:
        if ((r43 & 8192) == 0) goto L57;
        OrderSongSeiModel r6 = null;
    L58:
        OrderSongSeiModel r45 = r6;
        if ((r43 & 16384) == 0) goto L61;
        int r8 = KtvRoomStatus.UNKNOWN.getValue();
    L63:
        if ((r43 & 32768) == 0) goto L65;
        String r19 = BuildConfig.FLAVOR;
    L67:
        if ((r43 & 65536) != 0) goto L70;
        r16 = r41;
    L70:
        this(r4, r1, r7, r9, r10, r11, r14, r13, r15, r17, r18, r2, r3, r45, r8, r19, r16);
        return;
    L65:
        r19 = r40;
        goto L67
    L61:
        r8 = r39;
        goto L63
    L57:
        r6 = r38;
        goto L58
    L53:
        r3 = r37;
        goto L55
    L49:
        r2 = r36;
        goto L51
    L45:
        r18 = r35;
        goto L47
    L41:
        r17 = r34;
        goto L43
    L37:
        r15 = r33;
        goto L38
    L29:
        r14 = r30;
        goto L31
    L25:
        r11 = r29;
        goto L26
    L21:
        r10 = r28;
        goto L23
    L17:
        r9 = r27;
        goto L19
    L13:
        r7 = r25;
        goto L15
    L9:
        r1 = r24;
        goto L11
    L5:
        r4 = r23;
        goto L7
    }
}
