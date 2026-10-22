package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b´\u0001\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u0012\u0012\u0007\u0010Ô\u0001\u001a\u00020\u0002¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J.\u0010\n\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u000bJ\t\u0010\u000e\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0011\u001a\u00020\rH\u0096\u0001J\t\u0010\u0012\u001a\u00020\rH\u0096\u0001J\t\u0010\u0013\u001a\u00020\rH\u0096\u0001J\t\u0010\u0014\u001a\u00020\rH\u0096\u0001J\t\u0010\u0015\u001a\u00020\rH\u0096\u0001J\t\u0010\u0016\u001a\u00020\rH\u0096\u0001J\t\u0010\u0017\u001a\u00020\rH\u0096\u0001J\t\u0010\u0018\u001a\u00020\rH\u0096\u0001J\t\u0010\u0019\u001a\u00020\rH\u0096\u0001J\t\u0010\u001a\u001a\u00020\rH\u0096\u0001J\t\u0010\u001b\u001a\u00020\rH\u0096\u0001J\t\u0010\u001c\u001a\u00020\rH\u0096\u0001J\t\u0010\u001d\u001a\u00020\rH\u0096\u0001J\t\u0010\u001e\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0005H\u0096\u0001J\t\u0010 \u001a\u00020\rH\u0096\u0001J\u000b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001J\u000b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0001J\t\u0010%\u001a\u00020\rH\u0096\u0001J\t\u0010&\u001a\u00020\rH\u0096\u0001J\t\u0010'\u001a\u00020\rH\u0096\u0001J\t\u0010(\u001a\u00020\rH\u0096\u0001J\t\u0010)\u001a\u00020\rH\u0096\u0001J\t\u0010*\u001a\u00020\rH\u0096\u0001J\t\u0010+\u001a\u00020\rH\u0096\u0001J\t\u0010,\u001a\u00020\rH\u0096\u0001J\t\u0010-\u001a\u00020\rH\u0096\u0001J\t\u0010.\u001a\u00020\rH\u0096\u0001J\t\u0010/\u001a\u00020\rH\u0096\u0001J\t\u00100\u001a\u00020\rH\u0096\u0001J\t\u00101\u001a\u00020\rH\u0096\u0001J\t\u00102\u001a\u00020\rH\u0096\u0001J\t\u00103\u001a\u00020\rH\u0096\u0001J\t\u00104\u001a\u00020\rH\u0096\u0001J\t\u00105\u001a\u00020\rH\u0096\u0001J\t\u00106\u001a\u00020\rH\u0096\u0001J\t\u00107\u001a\u00020\rH\u0096\u0001J\t\u00108\u001a\u00020\rH\u0096\u0001J\t\u00109\u001a\u00020\rH\u0096\u0001J\t\u0010:\u001a\u00020\rH\u0096\u0001J\t\u0010;\u001a\u00020\rH\u0096\u0001J\t\u0010<\u001a\u00020\rH\u0096\u0001J\t\u0010=\u001a\u00020\rH\u0096\u0001J\t\u0010>\u001a\u00020\rH\u0096\u0001J\t\u0010?\u001a\u00020\rH\u0096\u0001J\t\u0010@\u001a\u00020\rH\u0096\u0001J\t\u0010A\u001a\u00020\rH\u0096\u0001J\t\u0010B\u001a\u00020\rH\u0096\u0001J\t\u0010C\u001a\u00020\rH\u0096\u0001J\t\u0010D\u001a\u00020\rH\u0096\u0001J\t\u0010E\u001a\u00020\rH\u0096\u0001J\t\u0010F\u001a\u00020\rH\u0096\u0001J\t\u0010G\u001a\u00020\rH\u0096\u0001J\t\u0010H\u001a\u00020\rH\u0096\u0001J\t\u0010I\u001a\u00020\rH\u0096\u0001J\u0013\u0010K\u001a\u00020\u00102\b\u0010J\u001a\u0004\u0018\u00010#H\u0096\u0001R$\u0010Q\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010T\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PR$\u0010W\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bU\u0010N\"\u0004\bV\u0010PR$\u0010Z\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bX\u0010N\"\u0004\bY\u0010PR$\u0010]\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010N\"\u0004\b\\\u0010PR$\u0010`\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b^\u0010N\"\u0004\b_\u0010PR$\u0010c\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\ba\u0010N\"\u0004\bb\u0010PR$\u0010f\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bd\u0010N\"\u0004\be\u0010PR\u001c\u0010i\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bg\u0010N\"\u0004\bh\u0010PR\u001c\u0010l\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bj\u0010N\"\u0004\bk\u0010PR\u001c\u0010o\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bm\u0010N\"\u0004\bn\u0010PR\u001c\u0010r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bp\u0010N\"\u0004\bq\u0010PR\u001c\u0010u\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bs\u0010N\"\u0004\bt\u0010PR\u001c\u0010x\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bv\u0010N\"\u0004\bw\u0010PR\u001c\u0010{\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\by\u0010N\"\u0004\bz\u0010PR\u001c\u0010~\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b|\u0010N\"\u0004\b}\u0010PR\u001e\u0010\u0081\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\r\u001a\u0004\b\u007f\u0010N\"\u0005\b\u0080\u0001\u0010PR\u001f\u0010\u0084\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010N\"\u0005\b\u0083\u0001\u0010PR\u001f\u0010\u0087\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u0010N\"\u0005\b\u0086\u0001\u0010PR!\u0010\u008c\u0001\u001a\u00020\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R!\u0010\u008f\u0001\u001a\u00020\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u008d\u0001\u0010\u0089\u0001\"\u0006\b\u008e\u0001\u0010\u008b\u0001R!\u0010\u0092\u0001\u001a\u00020\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0090\u0001\u0010\u0089\u0001\"\u0006\b\u0091\u0001\u0010\u008b\u0001R!\u0010\u0095\u0001\u001a\u00020\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0093\u0001\u0010\u0089\u0001\"\u0006\b\u0094\u0001\u0010\u008b\u0001R!\u0010\u0098\u0001\u001a\u00020\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0096\u0001\u0010\u0089\u0001\"\u0006\b\u0097\u0001\u0010\u008b\u0001R!\u0010\u009b\u0001\u001a\u00020\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0099\u0001\u0010\u0089\u0001\"\u0006\b\u009a\u0001\u0010\u008b\u0001R\u001e\u0010\u001f\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b\u009c\u0001\u0010N\"\u0005\b\u009d\u0001\u0010PR\u001f\u0010 \u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b\u009e\u0001\u0010N\"\u0005\b\u009f\u0001\u0010PR\u001f\u0010£\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b¡\u0001\u0010N\"\u0005\b¢\u0001\u0010PR\u001f\u0010¦\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b¤\u0001\u0010N\"\u0005\b¥\u0001\u0010PR\u001f\u0010©\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b§\u0001\u0010N\"\u0005\b¨\u0001\u0010PR\u001f\u0010¬\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bª\u0001\u0010N\"\u0005\b«\u0001\u0010PR\u001f\u0010¯\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b\u00ad\u0001\u0010N\"\u0005\b®\u0001\u0010PR\u001f\u0010²\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b°\u0001\u0010N\"\u0005\b±\u0001\u0010PR\u001f\u0010µ\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b³\u0001\u0010N\"\u0005\b´\u0001\u0010PR\u001f\u0010¸\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b¶\u0001\u0010N\"\u0005\b·\u0001\u0010PR\u001f\u0010»\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b¹\u0001\u0010N\"\u0005\bº\u0001\u0010PR\u001f\u0010¾\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b¼\u0001\u0010N\"\u0005\b½\u0001\u0010PR\u001f\u0010Á\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b¿\u0001\u0010N\"\u0005\bÀ\u0001\u0010PR\u001f\u0010Ä\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bÂ\u0001\u0010N\"\u0005\bÃ\u0001\u0010PR\u001f\u0010Ç\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bÅ\u0001\u0010N\"\u0005\bÆ\u0001\u0010PR\u001f\u0010Ê\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bÈ\u0001\u0010N\"\u0005\bÉ\u0001\u0010PR\u001f\u0010Í\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bË\u0001\u0010N\"\u0005\bÌ\u0001\u0010PR\u001f\u0010Ð\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bÎ\u0001\u0010N\"\u0005\bÏ\u0001\u0010PR\u001f\u0010Ó\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bÑ\u0001\u0010N\"\u0005\bÒ\u0001\u0010P¨\u0006×\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/model/ICommunityRoomAuthStatusExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "Lcom/bytedance/android/livesdk/interactivity/service/model/c;", "Lvh7/e;", BuildConfig.FLAVOR, "adminPinCommentAction", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", BuildConfig.FLAVOR, "enableBanner", "enable", BuildConfig.FLAVOR, "enableBulletStyle", "enableCastScreen", "enableChatMentionV2", "enableFansClub", "enableHourRank", "enableInteractionGift", "enableLandscapeQuickRecord", "enableLandscapeQuickShot", "enableLandscapeScreenShare", "enableOperateTopic", "enableTempShortTouch", "enableVSFansClub", "enableVerticalRank", "enableVerticalScreenShare", "enableVideoShare", "enableVsWelcomeDanmu", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$IOffReason;", "getOffReason", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$IRoomAuthSpecialStyle;", "getRoomAuthSpecialStyle", "isAnchorColdMessageTiled", "isChatGuideEmojiEnable", "isChatGuideImageEnable", "isDisableSelectionAlbum", "isDisableShare", "isEnableAIClone", "isEnableAnchorChannel", "isEnableAnchorChatDynamicSlideSpeed", "isEnableAudienceOpPanel", "isEnableChatDynamicSlideSpeed", "isEnableChatOperate", "isEnableDouPlus", "isEnableFirstFetchHistory", "isEnableFusionEmoji", "isEnableInteractivtyShare", "isEnableLandscapeChat", "isEnableLoadMoreHistory", "isEnableMarkUser", "isEnablePinHighlight", "isEnablePreviewDanmaku", "isEnableRecordScreen", "isEnableRoomContributor", "isEnableSecretChat", "isEnableShowLikeCount", "isEnableStableTopic", "isEnableSwitchLandscape", "isEnableUpRightStatsFloatingLayer", "isEnableWorldSquare", "isFrequentChatEnable", "isLandscapeDynamicSpeedStrategyEnable", "isMessageBreak", "isOrderSongOpened", "isPSSelectedMessageEnable", "isPanelECServiceEnable", "isPublicScreenMessageHeatStrategyEnable", "isShopFansClubMode", "isVSRoomEnableSeek", "roomAuthSpecialStyle", "setRoomAuthSpecialStyle", "value", "getWordAssociation", "()J", "setWordAssociation", "(J)V", "wordAssociation", "getEnableEmojiExpose", "setEnableEmojiExpose", "enableEmojiExpose", "getEnableChatReply", "setEnableChatReply", "enableChatReply", "getEnableChatMention", "setEnableChatMention", "enableChatMention", "getAudioChatToText", "setAudioChatToText", "audioChatToText", "getEnableAudioComment", "setEnableAudioComment", "enableAudioComment", "getFixedChat", "setFixedChat", "fixedChat", "getMyLiveEntrance", "setMyLiveEntrance", "myLiveEntrance", "getCastScreen", "setCastScreen", "castScreen", "getCastScreenExplicit", "setCastScreenExplicit", "castScreenExplicit", "getCollect", "setCollect", "collect", "getCommerceCard", "setCommerceCard", "commerceCard", "getCommonCard", "setCommonCard", "commonCard", "getDanmakuDefault", "setDanmakuDefault", "danmakuDefault", "getDenounce", "setDenounce", "denounce", "getDislike", "setDislike", "dislike", "getDownloadVideo", "setDownloadVideo", "downloadVideo", "getEcomFansClubAuth", "setEcomFansClubAuth", "ecomFansClubAuth", "getEnableAdminPinComment", "setEnableAdminPinComment", "enableAdminPinComment", "getEnableChat", "()Z", "setEnableChat", "(Z)V", "enableChat", "getEnableDanmaku", "setEnableDanmaku", "enableDanmaku", "getEnableDigg", "setEnableDigg", "enableDigg", "getEnableGift", "setEnableGift", "enableGift", "getEnablePoi", "setEnablePoi", "enablePoi", "getEnableUserCard", "setEnableUserCard", "enableUserCard", "getEnableVideoShare", "setEnableVideoShare", "getFansClubAuth", "setFansClubAuth", "fansClubAuth", "getGamePointsPlaying", "setGamePointsPlaying", "gamePointsPlaying", "getHighlightAreaContainer", "setHighlightAreaContainer", "highlightAreaContainer", "getMoreAnchor", "setMoreAnchor", "moreAnchor", "getMultiplierPlayback", "setMultiplierPlayback", "multiplierPlayback", "getPadPlay", "setPadPlay", "padPlay", "getPcPlay", "setPcPlay", "pcPlay", "getPlayerRankList", "setPlayerRankList", "playerRankList", "getPoster", "setPoster", "poster", "getProjectionBtn", "setProjectionBtn", "projectionBtn", "getQuizGamePointsPlaying", "setQuizGamePointsPlaying", "quizGamePointsPlaying", "getRecordScreen", "setRecordScreen", "recordScreen", "getShowShare", "setShowShare", "showShare", "getStreamAdaptation", "setStreamAdaptation", "streamAdaptation", "getTimedShutdown", "setTimedShutdown", "timedShutdown", "getUgcVSReplayDelete", "setUgcVSReplayDelete", "ugcVSReplayDelete", "getUgcVsReplayVisibility", "setUgcVsReplayVisibility", "ugcVsReplayVisibility", "getVideoAmplificationType", "setVideoAmplificationType", "videoAmplificationType", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;)V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ICommunityRoomAuthStatusExtensionImpl extends ModelExtensionBase<IRoomAuthStatus, c> implements c, IRoomAuthStatus {
    private final /* synthetic */ IRoomAuthStatus $$delegate_0;

    public long adminPinCommentAction() {
        return this.$$delegate_0.adminPinCommentAction();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public <R extends vh7.e<IRoomAuthStatus>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public <R extends vh7.e<IRoomAuthStatus>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    public void enableBanner(long r2) {
        this.$$delegate_0.enableBanner(r2);
    }

    public boolean enableBanner() {
        return this.$$delegate_0.enableBanner();
    }

    public boolean enableBulletStyle() {
        return this.$$delegate_0.enableBulletStyle();
    }

    public boolean enableCastScreen() {
        return this.$$delegate_0.enableCastScreen();
    }

    public boolean enableChatMentionV2() {
        return this.$$delegate_0.enableChatMentionV2();
    }

    public boolean enableFansClub() {
        return this.$$delegate_0.enableFansClub();
    }

    public boolean enableHourRank() {
        return this.$$delegate_0.enableHourRank();
    }

    public boolean enableInteractionGift() {
        return this.$$delegate_0.enableInteractionGift();
    }

    public boolean enableLandscapeQuickRecord() {
        return this.$$delegate_0.enableLandscapeQuickRecord();
    }

    public boolean enableLandscapeQuickShot() {
        return this.$$delegate_0.enableLandscapeQuickShot();
    }

    public boolean enableLandscapeScreenShare() {
        return this.$$delegate_0.enableLandscapeScreenShare();
    }

    public boolean enableOperateTopic() {
        return this.$$delegate_0.enableOperateTopic();
    }

    public boolean enableTempShortTouch() {
        return this.$$delegate_0.enableTempShortTouch();
    }

    public boolean enableVSFansClub() {
        return this.$$delegate_0.enableVSFansClub();
    }

    public boolean enableVerticalRank() {
        return this.$$delegate_0.enableVerticalRank();
    }

    public boolean enableVerticalScreenShare() {
        return this.$$delegate_0.enableVerticalScreenShare();
    }

    public void enableVideoShare(long r2) {
        this.$$delegate_0.enableVideoShare(r2);
    }

    public boolean enableVsWelcomeDanmu() {
        return this.$$delegate_0.enableVsWelcomeDanmu();
    }

    public long getCastScreen() {
        return this.$$delegate_0.getCastScreen();
    }

    public long getCastScreenExplicit() {
        return this.$$delegate_0.getCastScreenExplicit();
    }

    public long getCollect() {
        return this.$$delegate_0.getCollect();
    }

    public long getCommerceCard() {
        return this.$$delegate_0.getCommerceCard();
    }

    public long getCommonCard() {
        return this.$$delegate_0.getCommonCard();
    }

    public long getDanmakuDefault() {
        return this.$$delegate_0.getDanmakuDefault();
    }

    public long getDenounce() {
        return this.$$delegate_0.getDenounce();
    }

    public long getDislike() {
        return this.$$delegate_0.getDislike();
    }

    public long getDownloadVideo() {
        return this.$$delegate_0.getDownloadVideo();
    }

    public long getEcomFansClubAuth() {
        return this.$$delegate_0.getEcomFansClubAuth();
    }

    public long getEnableAdminPinComment() {
        return this.$$delegate_0.getEnableAdminPinComment();
    }

    public boolean getEnableChat() {
        return this.$$delegate_0.getEnableChat();
    }

    public boolean getEnableDanmaku() {
        return this.$$delegate_0.getEnableDanmaku();
    }

    public boolean getEnableDigg() {
        return this.$$delegate_0.getEnableDigg();
    }

    public boolean getEnableGift() {
        return this.$$delegate_0.getEnableGift();
    }

    public boolean getEnablePoi() {
        return this.$$delegate_0.getEnablePoi();
    }

    public boolean getEnableUserCard() {
        return this.$$delegate_0.getEnableUserCard();
    }

    public long getEnableVideoShare() {
        return this.$$delegate_0.getEnableVideoShare();
    }

    public long getFansClubAuth() {
        return this.$$delegate_0.getFansClubAuth();
    }

    public long getGamePointsPlaying() {
        return this.$$delegate_0.getGamePointsPlaying();
    }

    public long getHighlightAreaContainer() {
        return this.$$delegate_0.getHighlightAreaContainer();
    }

    public long getMoreAnchor() {
        return this.$$delegate_0.getMoreAnchor();
    }

    public long getMultiplierPlayback() {
        return this.$$delegate_0.getMultiplierPlayback();
    }

    public IRoomAuthStatus.IOffReason getOffReason() {
        return this.$$delegate_0.getOffReason();
    }

    public long getPadPlay() {
        return this.$$delegate_0.getPadPlay();
    }

    public long getPcPlay() {
        return this.$$delegate_0.getPcPlay();
    }

    public long getPlayerRankList() {
        return this.$$delegate_0.getPlayerRankList();
    }

    public long getPoster() {
        return this.$$delegate_0.getPoster();
    }

    public long getProjectionBtn() {
        return this.$$delegate_0.getProjectionBtn();
    }

    public long getQuizGamePointsPlaying() {
        return this.$$delegate_0.getQuizGamePointsPlaying();
    }

    public long getRecordScreen() {
        return this.$$delegate_0.getRecordScreen();
    }

    public IRoomAuthStatus.IRoomAuthSpecialStyle getRoomAuthSpecialStyle() {
        return this.$$delegate_0.getRoomAuthSpecialStyle();
    }

    public long getShowShare() {
        return this.$$delegate_0.getShowShare();
    }

    public long getStreamAdaptation() {
        return this.$$delegate_0.getStreamAdaptation();
    }

    public long getTimedShutdown() {
        return this.$$delegate_0.getTimedShutdown();
    }

    public long getUgcVSReplayDelete() {
        return this.$$delegate_0.getUgcVSReplayDelete();
    }

    public long getUgcVsReplayVisibility() {
        return this.$$delegate_0.getUgcVsReplayVisibility();
    }

    public long getVideoAmplificationType() {
        return this.$$delegate_0.getVideoAmplificationType();
    }

    public boolean isAnchorColdMessageTiled() {
        return this.$$delegate_0.isAnchorColdMessageTiled();
    }

    public boolean isChatGuideEmojiEnable() {
        return this.$$delegate_0.isChatGuideEmojiEnable();
    }

    public boolean isChatGuideImageEnable() {
        return this.$$delegate_0.isChatGuideImageEnable();
    }

    public boolean isDisableSelectionAlbum() {
        return this.$$delegate_0.isDisableSelectionAlbum();
    }

    public boolean isDisableShare() {
        return this.$$delegate_0.isDisableShare();
    }

    public boolean isEnableAIClone() {
        return this.$$delegate_0.isEnableAIClone();
    }

    public boolean isEnableAnchorChannel() {
        return this.$$delegate_0.isEnableAnchorChannel();
    }

    public boolean isEnableAnchorChatDynamicSlideSpeed() {
        return this.$$delegate_0.isEnableAnchorChatDynamicSlideSpeed();
    }

    public boolean isEnableAudienceOpPanel() {
        return this.$$delegate_0.isEnableAudienceOpPanel();
    }

    public boolean isEnableChatDynamicSlideSpeed() {
        return this.$$delegate_0.isEnableChatDynamicSlideSpeed();
    }

    public boolean isEnableChatOperate() {
        return this.$$delegate_0.isEnableChatOperate();
    }

    public boolean isEnableDouPlus() {
        return this.$$delegate_0.isEnableDouPlus();
    }

    public boolean isEnableFirstFetchHistory() {
        return this.$$delegate_0.isEnableFirstFetchHistory();
    }

    public boolean isEnableFusionEmoji() {
        return this.$$delegate_0.isEnableFusionEmoji();
    }

    public boolean isEnableInteractivtyShare() {
        return this.$$delegate_0.isEnableInteractivtyShare();
    }

    public boolean isEnableLandscapeChat() {
        return this.$$delegate_0.isEnableLandscapeChat();
    }

    public boolean isEnableLoadMoreHistory() {
        return this.$$delegate_0.isEnableLoadMoreHistory();
    }

    public boolean isEnableMarkUser() {
        return this.$$delegate_0.isEnableMarkUser();
    }

    public boolean isEnablePinHighlight() {
        return this.$$delegate_0.isEnablePinHighlight();
    }

    public boolean isEnablePreviewDanmaku() {
        return this.$$delegate_0.isEnablePreviewDanmaku();
    }

    public boolean isEnableRecordScreen() {
        return this.$$delegate_0.isEnableRecordScreen();
    }

    public boolean isEnableRoomContributor() {
        return this.$$delegate_0.isEnableRoomContributor();
    }

    public boolean isEnableSecretChat() {
        return this.$$delegate_0.isEnableSecretChat();
    }

    public boolean isEnableShowLikeCount() {
        return this.$$delegate_0.isEnableShowLikeCount();
    }

    public boolean isEnableStableTopic() {
        return this.$$delegate_0.isEnableStableTopic();
    }

    public boolean isEnableSwitchLandscape() {
        return this.$$delegate_0.isEnableSwitchLandscape();
    }

    public boolean isEnableUpRightStatsFloatingLayer() {
        return this.$$delegate_0.isEnableUpRightStatsFloatingLayer();
    }

    public boolean isEnableWorldSquare() {
        return this.$$delegate_0.isEnableWorldSquare();
    }

    public boolean isFrequentChatEnable() {
        return this.$$delegate_0.isFrequentChatEnable();
    }

    public boolean isLandscapeDynamicSpeedStrategyEnable() {
        return this.$$delegate_0.isLandscapeDynamicSpeedStrategyEnable();
    }

    public boolean isMessageBreak() {
        return this.$$delegate_0.isMessageBreak();
    }

    public boolean isOrderSongOpened() {
        return this.$$delegate_0.isOrderSongOpened();
    }

    public boolean isPSSelectedMessageEnable() {
        return this.$$delegate_0.isPSSelectedMessageEnable();
    }

    public boolean isPanelECServiceEnable() {
        return this.$$delegate_0.isPanelECServiceEnable();
    }

    public boolean isPublicScreenMessageHeatStrategyEnable() {
        return this.$$delegate_0.isPublicScreenMessageHeatStrategyEnable();
    }

    public boolean isShopFansClubMode() {
        return this.$$delegate_0.isShopFansClubMode();
    }

    public boolean isVSRoomEnableSeek() {
        return this.$$delegate_0.isVSRoomEnableSeek();
    }

    public void setCastScreen(long r2) {
        this.$$delegate_0.setCastScreen(r2);
    }

    public void setCastScreenExplicit(long r2) {
        this.$$delegate_0.setCastScreenExplicit(r2);
    }

    public void setCollect(long r2) {
        this.$$delegate_0.setCollect(r2);
    }

    public void setCommerceCard(long r2) {
        this.$$delegate_0.setCommerceCard(r2);
    }

    public void setCommonCard(long r2) {
        this.$$delegate_0.setCommonCard(r2);
    }

    public void setDanmakuDefault(long r2) {
        this.$$delegate_0.setDanmakuDefault(r2);
    }

    public void setDenounce(long r2) {
        this.$$delegate_0.setDenounce(r2);
    }

    public void setDislike(long r2) {
        this.$$delegate_0.setDislike(r2);
    }

    public void setDownloadVideo(long r2) {
        this.$$delegate_0.setDownloadVideo(r2);
    }

    public void setEcomFansClubAuth(long r2) {
        this.$$delegate_0.setEcomFansClubAuth(r2);
    }

    public void setEnableAdminPinComment(long r2) {
        this.$$delegate_0.setEnableAdminPinComment(r2);
    }

    public void setEnableChat(boolean r2) {
        this.$$delegate_0.setEnableChat(r2);
    }

    public void setEnableDanmaku(boolean r2) {
        this.$$delegate_0.setEnableDanmaku(r2);
    }

    public void setEnableDigg(boolean r2) {
        this.$$delegate_0.setEnableDigg(r2);
    }

    public void setEnableGift(boolean r2) {
        this.$$delegate_0.setEnableGift(r2);
    }

    public void setEnablePoi(boolean r2) {
        this.$$delegate_0.setEnablePoi(r2);
    }

    public void setEnableUserCard(boolean r2) {
        this.$$delegate_0.setEnableUserCard(r2);
    }

    public void setEnableVideoShare(long r2) {
        this.$$delegate_0.setEnableVideoShare(r2);
    }

    public void setFansClubAuth(long r2) {
        this.$$delegate_0.setFansClubAuth(r2);
    }

    public void setGamePointsPlaying(long r2) {
        this.$$delegate_0.setGamePointsPlaying(r2);
    }

    public void setHighlightAreaContainer(long r2) {
        this.$$delegate_0.setHighlightAreaContainer(r2);
    }

    public void setMoreAnchor(long r2) {
        this.$$delegate_0.setMoreAnchor(r2);
    }

    public void setMultiplierPlayback(long r2) {
        this.$$delegate_0.setMultiplierPlayback(r2);
    }

    public void setPadPlay(long r2) {
        this.$$delegate_0.setPadPlay(r2);
    }

    public void setPcPlay(long r2) {
        this.$$delegate_0.setPcPlay(r2);
    }

    public void setPlayerRankList(long r2) {
        this.$$delegate_0.setPlayerRankList(r2);
    }

    public void setPoster(long r2) {
        this.$$delegate_0.setPoster(r2);
    }

    public void setProjectionBtn(long r2) {
        this.$$delegate_0.setProjectionBtn(r2);
    }

    public void setQuizGamePointsPlaying(long r2) {
        this.$$delegate_0.setQuizGamePointsPlaying(r2);
    }

    public void setRecordScreen(long r2) {
        this.$$delegate_0.setRecordScreen(r2);
    }

    public void setRoomAuthSpecialStyle(IRoomAuthStatus.IRoomAuthSpecialStyle r2) {
        this.$$delegate_0.setRoomAuthSpecialStyle(r2);
    }

    public void setShowShare(long r2) {
        this.$$delegate_0.setShowShare(r2);
    }

    public void setStreamAdaptation(long r2) {
        this.$$delegate_0.setStreamAdaptation(r2);
    }

    public void setTimedShutdown(long r2) {
        this.$$delegate_0.setTimedShutdown(r2);
    }

    public void setUgcVSReplayDelete(long r2) {
        this.$$delegate_0.setUgcVSReplayDelete(r2);
    }

    public void setUgcVsReplayVisibility(long r2) {
        this.$$delegate_0.setUgcVsReplayVisibility(r2);
    }

    public void setVideoAmplificationType(long r2) {
        this.$$delegate_0.setVideoAmplificationType(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public long getAudioChatToText() {
        return ((Number) get(89, c.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public long getEnableAudioComment() {
        return ((Number) get(23, c.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public long getEnableChatMention() {
        return ((Number) get(117, c.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public long getEnableChatReply() {
        return ((Number) get(116, c.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public long getEnableEmojiExpose() {
        return ((Number) get(58, c.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public long getFixedChat() {
        return ((Number) get(103, c.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public long getMyLiveEntrance() {
        return ((Number) get(127, c.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public long getWordAssociation() {
        return ((Number) get(82, c.class, 0L)).longValue();
    }

    public ICommunityRoomAuthStatusExtensionImpl(IRoomAuthStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public void setAudioChatToText(long r3) {
        set(89, "AudioChatTotext", c.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public void setEnableAudioComment(long r3) {
        set(23, "AudioChat", c.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public void setEnableChatMention(long r3) {
        set(117, "ChatMention", c.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public void setEnableChatReply(long r3) {
        set(116, "ChatReply", c.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public void setEnableEmojiExpose(long r3) {
        set(58, "EmojiOutside", c.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public void setFixedChat(long r3) {
        set(103, "FixedChat", c.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public void setMyLiveEntrance(long r3) {
        set(127, "MyLiveEntrance", c.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.c
    public void setWordAssociation(long r3) {
        set(82, "WordAssociation", c.class, Long.valueOf(r3));
    }
}
