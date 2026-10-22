package com.larus.platform.uimodel;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bG\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0001_B¥\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010I\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010L\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010O\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\t\u0010P\u001a\u00020\fHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¬\u0002\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\u00102\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\fHÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b1\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b6\u00104R\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010!R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010!R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b=\u0010*R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010!R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010!¨\u0006`"}, d2 = {"Lcom/larus/platform/uimodel/MediaEntity;", "Ljava/io/Serializable;", "media_id", "", "item_id", "media_url", "media_from", "media_account_name", "media_des", "media_source_icon", "media_cover_image", "media_width", "", "media_height", "video_model", "video_auto_play", "", "source_from", "sourceId", "start", "", "duration", "media_status", "interactive_rec_info", "author_id", "author_name", "author_avatar", "aweme_type", "scene", "hostVideoSchema", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getMedia_id", "()Ljava/lang/String;", "getItem_id", "getMedia_url", "getMedia_from", "getMedia_account_name", "getMedia_des", "getMedia_source_icon", "getMedia_cover_image", "getMedia_width", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMedia_height", "getVideo_model", "getVideo_auto_play", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSource_from", "getSourceId", "getStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration", "getMedia_status", "()I", "getInteractive_rec_info", "getAuthor_id", "getAuthor_name", "getAuthor_avatar", "getAweme_type", "getScene", "getHostVideoSchema", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/uimodel/MediaEntity;", "equals", "other", "", "hashCode", "toString", "MediaStatus", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaEntity implements Serializable {

    @SerializedName("author_avatar")
    private final String author_avatar;

    @SerializedName("author_id")
    private final String author_id;

    @SerializedName("author_name")
    private final String author_name;

    @SerializedName("aweme_type")
    private final Integer aweme_type;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("host_video_schema")
    private final String hostVideoSchema;

    @SerializedName("interactive_rec_info")
    private final String interactive_rec_info;

    @SerializedName("item_id")
    private final String item_id;

    @SerializedName("artist_name")
    private final String media_account_name;

    @SerializedName("album_image")
    private final String media_cover_image;

    @SerializedName("song_name")
    private final String media_des;

    @SerializedName("source_app_name")
    private final String media_from;

    @SerializedName("media_height")
    private final Integer media_height;

    @SerializedName("vid")
    private final String media_id;

    @SerializedName("source_app_icon")
    private final String media_source_icon;

    @SerializedName("media_status")
    private final int media_status;

    @SerializedName("media_url")
    private final String media_url;

    @SerializedName("media_width")
    private final Integer media_width;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("source_id")
    private final String sourceId;

    @SerializedName("source_from")
    private final Integer source_from;

    @SerializedName("start")
    private final Long start;

    @SerializedName("video_auto_play")
    private final Boolean video_auto_play;

    @SerializedName("video_model")
    private final String video_model;

    public MediaEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 16777215, null);
    }

    public static /* synthetic */ MediaEntity copy$default(MediaEntity r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, Integer r26, Integer r27, String r28, Boolean r29, Integer r30, String r31, Long r32, Long r33, int r34, String r35, String r36, String r37, String r38, Integer r39, String r40, String r41, int r42, Object r43) {
        if ((r42 & 1) == 0) goto L5;
        String r2 = r17.media_id;
    L7:
        if ((r42 & 2) == 0) goto L9;
        String r3 = r17.item_id;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = r17.media_url;
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r5 = r17.media_from;
    L19:
        if ((r42 & 16) == 0) goto L21;
        String r6 = r17.media_account_name;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r7 = r17.media_des;
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r8 = r17.media_source_icon;
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r9 = r17.media_cover_image;
    L35:
        if ((r42 & 256) == 0) goto L37;
        Integer r10 = r17.media_width;
    L39:
        if ((r42 & 512) == 0) goto L41;
        Integer r11 = r17.media_height;
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r12 = r17.video_model;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        Boolean r13 = r17.video_auto_play;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        Integer r14 = r17.source_from;
    L55:
        if ((r42 & 8192) == 0) goto L57;
        String r15 = r17.sourceId;
    L58:
        String r310 = r15;
        if ((r42 & 16384) == 0) goto L61;
        Long r16 = r17.start;
    L62:
        Long r311 = r16;
        if ((r42 & 32768) == 0) goto L65;
        Long r110 = r17.duration;
    L66:
        Long r312 = r110;
        if ((r42 & 65536) == 0) goto L69;
        int r111 = r17.media_status;
    L70:
        int r313 = r111;
        if ((r42 & 131072) == 0) goto L73;
        String r112 = r17.interactive_rec_info;
    L74:
        String r314 = r112;
        if ((r42 & 262144) == 0) goto L77;
        String r113 = r17.author_id;
    L78:
        String r315 = r113;
        if ((r42 & 524288) == 0) goto L81;
        String r114 = r17.author_name;
    L82:
        String r316 = r114;
        if ((r42 & 1048576) == 0) goto L85;
        String r115 = r17.author_avatar;
    L86:
        String r317 = r115;
        if ((r42 & 2097152) == 0) goto L89;
        Integer r116 = r17.aweme_type;
    L90:
        Integer r318 = r116;
        if ((r42 & 4194304) == 0) goto L93;
        String r117 = r17.scene;
    L95:
        if ((r42 & 8388608) == 0) goto L97;
        String r1 = r17.hostVideoSchema;
    L99:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r117, r1);
    L97:
        r1 = r41;
        goto L99
    L93:
        r117 = r40;
        goto L95
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.media_id;
    }

    public final Integer component10() {
        return this.media_height;
    }

    public final String component11() {
        return this.video_model;
    }

    public final Boolean component12() {
        return this.video_auto_play;
    }

    public final Integer component13() {
        return this.source_from;
    }

    public final String component14() {
        return this.sourceId;
    }

    public final Long component15() {
        return this.start;
    }

    public final Long component16() {
        return this.duration;
    }

    public final int component17() {
        return this.media_status;
    }

    public final String component18() {
        return this.interactive_rec_info;
    }

    public final String component19() {
        return this.author_id;
    }

    public final String component2() {
        return this.item_id;
    }

    public final String component20() {
        return this.author_name;
    }

    public final String component21() {
        return this.author_avatar;
    }

    public final Integer component22() {
        return this.aweme_type;
    }

    public final String component23() {
        return this.scene;
    }

    public final String component24() {
        return this.hostVideoSchema;
    }

    public final String component3() {
        return this.media_url;
    }

    public final String component4() {
        return this.media_from;
    }

    public final String component5() {
        return this.media_account_name;
    }

    public final String component6() {
        return this.media_des;
    }

    public final String component7() {
        return this.media_source_icon;
    }

    public final String component8() {
        return this.media_cover_image;
    }

    public final Integer component9() {
        return this.media_width;
    }

    public final MediaEntity copy(String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, Integer r35, Integer r36, String r37, Boolean r38, Integer r39, String r40, Long r41, Long r42, int r43, String r44, String r45, String r46, String r47, Integer r48, String r49, String r50) {
        return new MediaEntity(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MediaEntity) == true) goto L8;
        return false;
    L8:
        MediaEntity r6 = (MediaEntity) r5;
        if (Intrinsics.areEqual(this.media_id, r6.media_id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.item_id, r6.item_id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.media_url, r6.media_url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.media_from, r6.media_from) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.media_account_name, r6.media_account_name) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.media_des, r6.media_des) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.media_source_icon, r6.media_source_icon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.media_cover_image, r6.media_cover_image) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.media_width, r6.media_width) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.media_height, r6.media_height) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.video_model, r6.video_model) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.video_auto_play, r6.video_auto_play) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.source_from, r6.source_from) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.sourceId, r6.sourceId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.start, r6.start) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L57;
        return false;
    L57:
        if (this.media_status == r6.media_status) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.interactive_rec_info, r6.interactive_rec_info) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.author_id, r6.author_id) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.author_name, r6.author_name) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.author_avatar, r6.author_avatar) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.aweme_type, r6.aweme_type) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.hostVideoSchema, r6.hostVideoSchema) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        String r0 = this.media_id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.item_id;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.media_url;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.media_from;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.media_account_name;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.media_des;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.media_source_icon;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.media_cover_image;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.media_width;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.media_height;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.video_model;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.video_auto_play;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.source_from;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.sourceId;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Long r43 = this.start;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Long r46 = this.duration;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (((r45 + r47) * 31) + this.media_status) * 31;
        String r49 = this.interactive_rec_info;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.author_id;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.author_name;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.author_avatar;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        Integer r61 = this.aweme_type;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.scene;
        if (r64 != null) goto L89;
        int r65 = 0;
    L90:
        int r66 = (r63 + r65) * 31;
        String r67 = this.hostVideoSchema;
        if (r67 == null) goto L95;
        r1 = r67.hashCode();
    L95:
        return r66 + r1;
    L89:
        r65 = r64.hashCode();
        goto L90
    L85:
        r62 = r61.hashCode();
        goto L86
    L81:
        r59 = r58.hashCode();
        goto L82
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
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

    public String toString() {
        return "MediaEntity(media_id=" + this.media_id + ", item_id=" + this.item_id + ", media_url=" + this.media_url + ", media_from=" + this.media_from + ", media_account_name=" + this.media_account_name + ", media_des=" + this.media_des + ", media_source_icon=" + this.media_source_icon + ", media_cover_image=" + this.media_cover_image + ", media_width=" + this.media_width + ", media_height=" + this.media_height + ", video_model=" + this.video_model + ", video_auto_play=" + this.video_auto_play + ", source_from=" + this.source_from + ", sourceId=" + this.sourceId + ", start=" + this.start + ", duration=" + this.duration + ", media_status=" + this.media_status + ", interactive_rec_info=" + this.interactive_rec_info + ", author_id=" + this.author_id + ", author_name=" + this.author_name + ", author_avatar=" + this.author_avatar + ", aweme_type=" + this.aweme_type + ", scene=" + this.scene + ", hostVideoSchema=" + this.hostVideoSchema + ')';
    }

    public final String getAuthor_avatar() {
        return this.author_avatar;
    }

    public final String getAuthor_id() {
        return this.author_id;
    }

    public final String getAuthor_name() {
        return this.author_name;
    }

    public final Integer getAweme_type() {
        return this.aweme_type;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getHostVideoSchema() {
        return this.hostVideoSchema;
    }

    public final String getInteractive_rec_info() {
        return this.interactive_rec_info;
    }

    public final String getItem_id() {
        return this.item_id;
    }

    public final String getMedia_account_name() {
        return this.media_account_name;
    }

    public final String getMedia_cover_image() {
        return this.media_cover_image;
    }

    public final String getMedia_des() {
        return this.media_des;
    }

    public final String getMedia_from() {
        return this.media_from;
    }

    public final Integer getMedia_height() {
        return this.media_height;
    }

    public final String getMedia_id() {
        return this.media_id;
    }

    public final String getMedia_source_icon() {
        return this.media_source_icon;
    }

    public final int getMedia_status() {
        return this.media_status;
    }

    public final String getMedia_url() {
        return this.media_url;
    }

    public final Integer getMedia_width() {
        return this.media_width;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final Integer getSource_from() {
        return this.source_from;
    }

    public final Long getStart() {
        return this.start;
    }

    public final Boolean getVideo_auto_play() {
        return this.video_auto_play;
    }

    public final String getVideo_model() {
        return this.video_model;
    }

    public MediaEntity(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Integer r11, Integer r12, String r13, Boolean r14, Integer r15, String r16, Long r17, Long r18, int r19, String r20, String r21, String r22, String r23, Integer r24, String r25, String r26) {
        this.media_id = r3;
        this.item_id = r4;
        this.media_url = r5;
        this.media_from = r6;
        this.media_account_name = r7;
        this.media_des = r8;
        this.media_source_icon = r9;
        this.media_cover_image = r10;
        this.media_width = r11;
        this.media_height = r12;
        this.video_model = r13;
        this.video_auto_play = r14;
        this.source_from = r15;
        this.sourceId = r16;
        this.start = r17;
        this.duration = r18;
        this.media_status = r19;
        this.interactive_rec_info = r20;
        this.author_id = r21;
        this.author_name = r22;
        this.author_avatar = r23;
        this.aweme_type = r24;
        this.scene = r25;
        this.hostVideoSchema = r26;
    }

    public /* synthetic */ MediaEntity(String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, Integer r35, Integer r36, String r37, Boolean r38, Integer r39, String r40, Long r41, Long r42, int r43, String r44, String r45, String r46, String r47, Integer r48, String r49, String r50, int r51, DefaultConstructorMarker r52) {
        if ((r51 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r51 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r51 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r51 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r51 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r51 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r51 & 64) == 0) goto L29;
        String r8 = "";
    L31:
        if ((r51 & 128) == 0) goto L33;
        String r9 = "";
    L35:
        if ((r51 & 256) == 0) goto L37;
        Integer r10 = 0;
    L39:
        if ((r51 & 512) == 0) goto L41;
        Integer r12 = 0;
    L43:
        if ((r51 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r51 & 2048) == 0) goto L49;
        Boolean r14 = Boolean.FALSE;
    L51:
        if ((r51 & 4096) == 0) goto L53;
        Integer r15 = -1;
    L55:
        if ((r51 & 8192) == 0) goto L57;
        String r11 = "";
    L59:
        if ((r51 & 16384) == 0) goto L61;
        Long r2 = 0L;
    L63:
        if ((r51 & 32768) == 0) goto L65;
        Long r16 = -1L;
    L67:
        if ((r51 & 65536) == 0) goto L69;
        int r17 = 0;
    L70:
        String r19 = null;
        if ((r51 & 131072) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r51 & 262144) == 0) goto L77;
        String r20 = "";
    L79:
        if ((r51 & 524288) == 0) goto L81;
        String r21 = "";
    L83:
        if ((r51 & 1048576) == 0) goto L85;
        String r22 = "";
    L87:
        if ((r51 & 2097152) == 0) goto L89;
        Integer r23 = 0;
    L91:
        if ((r51 & 4194304) == 0) goto L93;
        String r24 = "";
    L95:
        if ((r51 & 8388608) != 0) goto L98;
        r19 = r50;
    L98:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r11, r2, r16, r17, r18, r20, r21, r22, r23, r24, r19);
        return;
    L93:
        r24 = r49;
        goto L95
    L89:
        r23 = r48;
        goto L91
    L85:
        r22 = r47;
        goto L87
    L81:
        r21 = r46;
        goto L83
    L77:
        r20 = r45;
        goto L79
    L73:
        r18 = r44;
        goto L75
    L69:
        r17 = r43;
        goto L70
    L65:
        r16 = r42;
        goto L67
    L61:
        r2 = r41;
        goto L63
    L57:
        r11 = r40;
        goto L59
    L53:
        r15 = r39;
        goto L55
    L49:
        r14 = r38;
        goto L51
    L45:
        r13 = r37;
        goto L47
    L41:
        r12 = r36;
        goto L43
    L37:
        r10 = r35;
        goto L39
    L33:
        r9 = r34;
        goto L35
    L29:
        r8 = r33;
        goto L31
    L25:
        r7 = r32;
        goto L27
    L21:
        r6 = r31;
        goto L23
    L17:
        r5 = r30;
        goto L19
    L13:
        r4 = r29;
        goto L15
    L9:
        r3 = r28;
        goto L11
    L5:
        r1 = r27;
        goto L7
    }
}
