package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.video.AuthorInfo;
import com.larus.bmhome.video.InteractInfo;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B§\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\n\u0010S\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010T\u001a\u0004\u0018\u00010\u0003J\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0VJ\u0006\u0010W\u001a\u00020\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010i\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010l\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010p\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J®\u0002\u0010t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010uJ\u0013\u0010v\u001a\u00020\u00182\b\u0010w\u001a\u0004\u0018\u00010xHÖ\u0003J\t\u0010y\u001a\u00020\rHÖ\u0001J\t\u0010z\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b0\u0010,R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b1\u0010,R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b3\u0010,R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b4\u0010,R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\"R\"\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR2\u0010K\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010Lj\f\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u0001`NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010X\u001a\u00020YX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[¨\u0006{"}, d2 = {"Lcom/larus/bmhome/chat/search/VideoInfo;", "Lcom/larus/im/bean/message/ItemData;", "cardId", "", "itemId", "description", "imageUrl", "hostPageUrl", "hostVideoSchema", "sourceApp", "iconUrl", "iconUrlV2", "sourceFrom", "", "imageUri", "sceneId", "width", "height", "videoFirstFrameImage", "videoFirstFrameImageWidth", "videoFirstFrameImageHeight", "videoFirstFrameImageUri", "interactiveRecInfo", "needFillEdge", "", "authorInfo", "Lcom/larus/bmhome/video/AuthorInfo;", "interactionInfo", "Lcom/larus/bmhome/video/InteractInfo;", "appJumpUrl", "searchId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/video/AuthorInfo;Lcom/larus/bmhome/video/InteractInfo;Ljava/lang/String;Ljava/lang/String;)V", "getCardId", "()Ljava/lang/String;", "getItemId", "getDescription", "getImageUrl", "getHostPageUrl", "getHostVideoSchema", "getSourceApp", "getIconUrl", "getIconUrlV2", "getSourceFrom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageUri", "getSceneId", "getWidth", "getHeight", "getVideoFirstFrameImage", "getVideoFirstFrameImageWidth", "getVideoFirstFrameImageHeight", "getVideoFirstFrameImageUri", "getInteractiveRecInfo", "getNeedFillEdge", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAuthorInfo", "()Lcom/larus/bmhome/video/AuthorInfo;", "getInteractionInfo", "()Lcom/larus/bmhome/video/InteractInfo;", "getAppJumpUrl", "getSearchId", "videoInfoList", "", "getVideoInfoList", "()Ljava/util/List;", "setVideoInfoList", "(Ljava/util/List;)V", "videoIndex", "getVideoIndex", "()I", "setVideoIndex", "(I)V", "preloadMediaEntityList", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "getPreloadMediaEntityList", "()Ljava/util/ArrayList;", "setPreloadMediaEntityList", "(Ljava/util/ArrayList;)V", "getId", "getIconUrlCompat", "getFirstFrameSize", "Lkotlin/Pair;", "getFirstFrameImage", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/video/AuthorInfo;Lcom/larus/bmhome/video/InteractInfo;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/search/VideoInfo;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VideoInfo extends ItemData {
    public transient List<VideoInfo> a;

    @SerializedName("app_jump_url")
    private final String appJumpUrl;

    @SerializedName("author_info")
    private final AuthorInfo authorInfo;
    public transient int b;
    public transient ArrayList<MediaEntity> c;

    @SerializedName("id")
    private final String cardId;
    public final transient ItemType d;

    @SerializedName("video_captions")
    private final String description;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("host_page_url")
    private final String hostPageUrl;

    @SerializedName("host_video_schema")
    private final String hostVideoSchema;

    @SerializedName("source_app_icon")
    private final String iconUrl;

    @SerializedName("source_app_icon_v2")
    private final String iconUrlV2;

    @SerializedName("image_uri")
    private final String imageUri;

    @SerializedName("album_image")
    private final String imageUrl;

    @SerializedName("interaction_info")
    private final InteractInfo interactionInfo;

    @SerializedName("interactive_rec_info")
    private final String interactiveRecInfo;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("need_fill_edge")
    private final Boolean needFillEdge;

    @SerializedName("scene_id")
    private final String sceneId;

    @SerializedName("search_id")
    private final String searchId;

    @SerializedName("source_app_name")
    private final String sourceApp;

    @SerializedName("source_from")
    private final Integer sourceFrom;

    @SerializedName("video_first_frame_image")
    private final String videoFirstFrameImage;

    @SerializedName("video_first_frame_image_height")
    private final Integer videoFirstFrameImageHeight;

    @SerializedName("video_first_frame_image_uri")
    private final String videoFirstFrameImageUri;

    @SerializedName("video_first_frame_image_width")
    private final Integer videoFirstFrameImageWidth;

    @SerializedName("width")
    private final Integer width;

    public VideoInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
    }

    public static /* synthetic */ VideoInfo copy$default(VideoInfo r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, Integer r27, String r28, String r29, Integer r30, Integer r31, String r32, Integer r33, Integer r34, String r35, String r36, Boolean r37, AuthorInfo r38, InteractInfo r39, String r40, String r41, int r42, Object r43) {
        if ((r42 & 1) == 0) goto L5;
        String r2 = r17.cardId;
    L7:
        if ((r42 & 2) == 0) goto L9;
        String r3 = r17.itemId;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = r17.description;
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r5 = r17.imageUrl;
    L19:
        if ((r42 & 16) == 0) goto L21;
        String r6 = r17.hostPageUrl;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r7 = r17.hostVideoSchema;
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r8 = r17.sourceApp;
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r9 = r17.iconUrl;
    L35:
        if ((r42 & 256) == 0) goto L37;
        String r10 = r17.iconUrlV2;
    L39:
        if ((r42 & 512) == 0) goto L41;
        Integer r11 = r17.sourceFrom;
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r12 = r17.imageUri;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r13 = r17.sceneId;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        Integer r14 = r17.width;
    L55:
        if ((r42 & 8192) == 0) goto L57;
        Integer r15 = r17.height;
    L58:
        Integer r310 = r15;
        if ((r42 & 16384) == 0) goto L61;
        String r16 = r17.videoFirstFrameImage;
    L62:
        String r311 = r16;
        if ((r42 & 32768) == 0) goto L65;
        Integer r110 = r17.videoFirstFrameImageWidth;
    L66:
        Integer r312 = r110;
        if ((r42 & 65536) == 0) goto L69;
        Integer r111 = r17.videoFirstFrameImageHeight;
    L70:
        Integer r313 = r111;
        if ((r42 & 131072) == 0) goto L73;
        String r112 = r17.videoFirstFrameImageUri;
    L74:
        String r314 = r112;
        if ((r42 & 262144) == 0) goto L77;
        String r113 = r17.interactiveRecInfo;
    L78:
        String r315 = r113;
        if ((r42 & 524288) == 0) goto L81;
        Boolean r114 = r17.needFillEdge;
    L82:
        Boolean r316 = r114;
        if ((r42 & 1048576) == 0) goto L85;
        AuthorInfo r115 = r17.authorInfo;
    L86:
        AuthorInfo r317 = r115;
        if ((r42 & 2097152) == 0) goto L89;
        InteractInfo r116 = r17.interactionInfo;
    L90:
        InteractInfo r318 = r116;
        if ((r42 & 4194304) == 0) goto L93;
        String r117 = r17.appJumpUrl;
    L95:
        if ((r42 & 8388608) == 0) goto L97;
        String r1 = r17.searchId;
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
        return this.cardId;
    }

    public final Integer component10() {
        return this.sourceFrom;
    }

    public final String component11() {
        return this.imageUri;
    }

    public final String component12() {
        return this.sceneId;
    }

    public final Integer component13() {
        return this.width;
    }

    public final Integer component14() {
        return this.height;
    }

    public final String component15() {
        return this.videoFirstFrameImage;
    }

    public final Integer component16() {
        return this.videoFirstFrameImageWidth;
    }

    public final Integer component17() {
        return this.videoFirstFrameImageHeight;
    }

    public final String component18() {
        return this.videoFirstFrameImageUri;
    }

    public final String component19() {
        return this.interactiveRecInfo;
    }

    public final String component2() {
        return this.itemId;
    }

    public final Boolean component20() {
        return this.needFillEdge;
    }

    public final AuthorInfo component21() {
        return this.authorInfo;
    }

    public final InteractInfo component22() {
        return this.interactionInfo;
    }

    public final String component23() {
        return this.appJumpUrl;
    }

    public final String component24() {
        return this.searchId;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final String component5() {
        return this.hostPageUrl;
    }

    public final String component6() {
        return this.hostVideoSchema;
    }

    public final String component7() {
        return this.sourceApp;
    }

    public final String component8() {
        return this.iconUrl;
    }

    public final String component9() {
        return this.iconUrlV2;
    }

    public final VideoInfo copy(String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, Integer r36, String r37, String r38, Integer r39, Integer r40, String r41, Integer r42, Integer r43, String r44, String r45, Boolean r46, AuthorInfo r47, InteractInfo r48, String r49, String r50) {
        return new VideoInfo(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoInfo) == true) goto L8;
        return false;
    L8:
        VideoInfo r6 = (VideoInfo) r5;
        if (Intrinsics.areEqual(this.cardId, r6.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemId, r6.itemId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUrl, r6.imageUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hostPageUrl, r6.hostPageUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hostVideoSchema, r6.hostVideoSchema) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sourceApp, r6.sourceApp) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconUrlV2, r6.iconUrlV2) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sourceFrom, r6.sourceFrom) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.imageUri, r6.imageUri) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.sceneId, r6.sceneId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.videoFirstFrameImage, r6.videoFirstFrameImage) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.videoFirstFrameImageWidth, r6.videoFirstFrameImageWidth) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.videoFirstFrameImageHeight, r6.videoFirstFrameImageHeight) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.videoFirstFrameImageUri, r6.videoFirstFrameImageUri) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.interactiveRecInfo, r6.interactiveRecInfo) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.needFillEdge, r6.needFillEdge) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.authorInfo, r6.authorInfo) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.interactionInfo, r6.interactionInfo) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.appJumpUrl, r6.appJumpUrl) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.searchId, r6.searchId) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        String r0 = this.cardId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.itemId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.description;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.imageUrl;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.hostPageUrl;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.hostVideoSchema;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.sourceApp;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.iconUrl;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.iconUrlV2;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.sourceFrom;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.imageUri;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.sceneId;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.width;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Integer r40 = this.height;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.videoFirstFrameImage;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Integer r46 = this.videoFirstFrameImageWidth;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Integer r49 = this.videoFirstFrameImageHeight;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.videoFirstFrameImageUri;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.interactiveRecInfo;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        Boolean r58 = this.needFillEdge;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        AuthorInfo r61 = this.authorInfo;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        InteractInfo r64 = this.interactionInfo;
        if (r64 != null) goto L89;
        int r65 = 0;
    L90:
        int r66 = (r63 + r65) * 31;
        String r67 = this.appJumpUrl;
        if (r67 != null) goto L93;
        int r68 = 0;
    L94:
        int r69 = (r66 + r68) * 31;
        String r70 = this.searchId;
        if (r70 == null) goto L99;
        r1 = r70.hashCode();
    L99:
        return r69 + r1;
    L93:
        r68 = r67.hashCode();
        goto L94
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
        return "VideoInfo(cardId=" + this.cardId + ", itemId=" + this.itemId + ", description=" + this.description + ", imageUrl=" + this.imageUrl + ", hostPageUrl=" + this.hostPageUrl + ", hostVideoSchema=" + this.hostVideoSchema + ", sourceApp=" + this.sourceApp + ", iconUrl=" + this.iconUrl + ", iconUrlV2=" + this.iconUrlV2 + ", sourceFrom=" + this.sourceFrom + ", imageUri=" + this.imageUri + ", sceneId=" + this.sceneId + ", width=" + this.width + ", height=" + this.height + ", videoFirstFrameImage=" + this.videoFirstFrameImage + ", videoFirstFrameImageWidth=" + this.videoFirstFrameImageWidth + ", videoFirstFrameImageHeight=" + this.videoFirstFrameImageHeight + ", videoFirstFrameImageUri=" + this.videoFirstFrameImageUri + ", interactiveRecInfo=" + this.interactiveRecInfo + ", needFillEdge=" + this.needFillEdge + ", authorInfo=" + this.authorInfo + ", interactionInfo=" + this.interactionInfo + ", appJumpUrl=" + this.appJumpUrl + ", searchId=" + this.searchId + ')';
    }

    public final String getFirstFrameImage() {
        if (o0.d(this.videoFirstFrameImage) == false) goto L7;
        String r0 = this.videoFirstFrameImage;
        if (r0 != null) goto L11;
        return "";
    L11:
        return r0;
    L7:
        r0 = this.imageUrl;
        if (r0 != null) goto L11;
        return "";
    }

    public final Pair<Integer, Integer> getFirstFrameSize() {
        Integer r0 = this.videoFirstFrameImageWidth;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        Integer r3 = this.videoFirstFrameImageHeight;
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        if (r2 <= 0) goto L14;
        if (r4 <= 0) goto L14;
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r4));
    L14:
        Integer r5 = this.width;
        if (r5 == null) goto L17;
        int r6 = r5.intValue();
    L18:
        Integer r7 = this.height;
        if (r7 == null) goto L21;
        r1 = r7.intValue();
    L21:
        if (r6 <= 0) goto L26;
        if (r1 <= 0) goto L26;
        return TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r1));
    L26:
        return TuplesKt.to(10, 10);
    L17:
        r6 = 0;
        goto L18
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String getIconUrlCompat() {
        String r0 = this.iconUrlV2;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return this.iconUrl;
    L12:
        return this.iconUrlV2;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String getAppJumpUrl() {
        return this.appJumpUrl;
    }

    public final AuthorInfo getAuthorInfo() {
        return this.authorInfo;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getHostPageUrl() {
        return this.hostPageUrl;
    }

    public final String getHostVideoSchema() {
        return this.hostVideoSchema;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconUrlV2() {
        return this.iconUrlV2;
    }

    public String getId() {
        return this.itemId;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final InteractInfo getInteractionInfo() {
        return this.interactionInfo;
    }

    public final String getInteractiveRecInfo() {
        return this.interactiveRecInfo;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Boolean getNeedFillEdge() {
        return this.needFillEdge;
    }

    public final ArrayList<MediaEntity> getPreloadMediaEntityList() {
        return this.c;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public ItemType getSearchItemType() {
        return this.d;
    }

    public final String getSourceApp() {
        return this.sourceApp;
    }

    public final Integer getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getVideoFirstFrameImage() {
        return this.videoFirstFrameImage;
    }

    public final Integer getVideoFirstFrameImageHeight() {
        return this.videoFirstFrameImageHeight;
    }

    public final String getVideoFirstFrameImageUri() {
        return this.videoFirstFrameImageUri;
    }

    public final Integer getVideoFirstFrameImageWidth() {
        return this.videoFirstFrameImageWidth;
    }

    public final int getVideoIndex() {
        return this.b;
    }

    public final List<VideoInfo> getVideoInfoList() {
        return this.a;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setPreloadMediaEntityList(ArrayList<MediaEntity> r1) {
        this.c = r1;
    }

    public final void setVideoIndex(int r1) {
        this.b = r1;
    }

    public final void setVideoInfoList(List<VideoInfo> r1) {
        this.a = r1;
    }

    public VideoInfo(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, Integer r12, String r13, String r14, Integer r15, Integer r16, String r17, Integer r18, Integer r19, String r20, String r21, Boolean r22, AuthorInfo r23, InteractInfo r24, String r25, String r26) {
        this.cardId = r3;
        this.itemId = r4;
        this.description = r5;
        this.imageUrl = r6;
        this.hostPageUrl = r7;
        this.hostVideoSchema = r8;
        this.sourceApp = r9;
        this.iconUrl = r10;
        this.iconUrlV2 = r11;
        this.sourceFrom = r12;
        this.imageUri = r13;
        this.sceneId = r14;
        this.width = r15;
        this.height = r16;
        this.videoFirstFrameImage = r17;
        this.videoFirstFrameImageWidth = r18;
        this.videoFirstFrameImageHeight = r19;
        this.videoFirstFrameImageUri = r20;
        this.interactiveRecInfo = r21;
        this.needFillEdge = r22;
        this.authorInfo = r23;
        this.interactionInfo = r24;
        this.appJumpUrl = r25;
        this.searchId = r26;
        this.d = ItemType.TYPE_CARD_VIDEO;
    }

    public /* synthetic */ VideoInfo(String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, Integer r35, String r36, String r37, Integer r38, Integer r39, String r40, Integer r41, Integer r42, String r43, String r44, Boolean r45, AuthorInfo r46, InteractInfo r47, String r48, String r49, int r50, DefaultConstructorMarker r51) {
        if ((r50 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r50 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r50 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r50 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r50 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r50 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r50 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r50 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r50 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r50 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r50 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r50 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r50 & 4096) == 0) goto L53;
        Integer r14 = null;
    L55:
        if ((r50 & 8192) == 0) goto L57;
        Integer r15 = null;
    L59:
        if ((r50 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r50 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r50 & 65536) == 0) goto L69;
        Integer r17 = null;
    L71:
        if ((r50 & 131072) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r50 & 262144) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r50 & 524288) == 0) goto L81;
        Boolean r20 = Boolean.FALSE;
    L83:
        if ((r50 & 1048576) == 0) goto L85;
        AuthorInfo r21 = null;
    L87:
        if ((r50 & 2097152) == 0) goto L89;
        InteractInfo r22 = null;
    L91:
        if ((r50 & 4194304) == 0) goto L93;
        String r23 = null;
    L95:
        if ((r50 & 8388608) == 0) goto L97;
        String r0 = null;
    L98:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r23, r0);
        return;
    L97:
        r0 = r49;
        goto L98
    L93:
        r23 = r48;
        goto L95
    L89:
        r22 = r47;
        goto L91
    L85:
        r21 = r46;
        goto L87
    L81:
        r20 = r45;
        goto L83
    L77:
        r19 = r44;
        goto L79
    L73:
        r18 = r43;
        goto L75
    L69:
        r17 = r42;
        goto L71
    L65:
        r16 = r41;
        goto L67
    L61:
        r2 = r40;
        goto L63
    L57:
        r15 = r39;
        goto L59
    L53:
        r14 = r38;
        goto L55
    L49:
        r13 = r37;
        goto L51
    L45:
        r12 = r36;
        goto L47
    L41:
        r11 = r35;
        goto L43
    L37:
        r10 = r34;
        goto L39
    L33:
        r9 = r33;
        goto L35
    L29:
        r8 = r32;
        goto L31
    L25:
        r7 = r31;
        goto L27
    L21:
        r6 = r30;
        goto L23
    L17:
        r5 = r29;
        goto L19
    L13:
        r4 = r28;
        goto L15
    L9:
        r3 = r27;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }
}
