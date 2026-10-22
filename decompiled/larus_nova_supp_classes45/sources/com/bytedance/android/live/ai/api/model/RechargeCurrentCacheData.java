package com.bytedance.android.live.ai.api.model;

import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0003\b\u0081\u0001\b\u0087\b\u0018\u00002\u00020\u0001B±\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005¢\u0006\u0002\u0010#J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0007HÆ\u0003J\t\u0010g\u001a\u00020\u0007HÆ\u0003J\t\u0010h\u001a\u00020\u0007HÆ\u0003J\t\u0010i\u001a\u00020\u0007HÆ\u0003J\t\u0010j\u001a\u00020\u0007HÆ\u0003J\t\u0010k\u001a\u00020\u0007HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\u0005HÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\t\u0010v\u001a\u00020\u0005HÆ\u0003J\t\u0010w\u001a\u00020\u0005HÆ\u0003J\t\u0010x\u001a\u00020\u0005HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0007HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0007HÆ\u0003J\t\u0010~\u001a\u00020\u0007HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0007HÆ\u0003J¶\u0002\u0010\u0083\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u0005HÆ\u0001J\u0015\u0010\u0084\u0001\u001a\u00020\u00032\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010\u0087\u0001\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010%\"\u0004\b;\u0010'R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010%\"\u0004\bA\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010B\"\u0004\bC\u0010DR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010%\"\u0004\bF\u0010'R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010/\"\u0004\bH\u00101R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010/\"\u0004\bJ\u00101R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010/\"\u0004\bL\u00101R\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010/\"\u0004\bN\u00101R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010/\"\u0004\bP\u00101R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010/\"\u0004\bR\u00101R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010/\"\u0004\bT\u00101R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010/\"\u0004\bV\u00101R\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010/\"\u0004\bX\u00101R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010/\"\u0004\bZ\u00101R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010/\"\u0004\b\\\u00101R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010%\"\u0004\b^\u0010'R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010%\"\u0004\b`\u0010'R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010%\"\u0004\bb\u0010'R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010%\"\u0004\bd\u0010'¨\u0006\u0088\u0001"}, d2 = {"Lcom/bytedance/android/live/ai/api/model/RechargeCurrentCacheData;", "", "isFollowed", "", "curMoneyPaid", "", "eventModuleCode", "", "liveTypeCode", "payMethodCode", "anchorTypeCode", "chargeSceneCode", "chargeReasonCode", "interactFunctionCode", "requestPageCode", "roomLayoutCode", "streamingTypeCode", "enterFromMergeCode", "enterMethodCode", "actionTypeCode", "livesdkCommentScreenMessageMonitor", "livesdkGiftEffectShow", "livesdkRedPackageShow", "livesdkAudienceLiveMessage", "livesdkSendGift", "livesdkRechargeClick", "livesdkRechargeShow", "livesdkRechargeSuccess", "livesdkRechargeCustomizedNext", "livesdkLike", "livesdkRechargeBannerClick", "curWatchDuration", "curRankDuration", "curSentGiftMoney", "curSentGiftCnt", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIIIIIIIIII)V", "getActionTypeCode", "()Ljava/lang/String;", "setActionTypeCode", "(Ljava/lang/String;)V", "getAnchorTypeCode", "setAnchorTypeCode", "getChargeReasonCode", "setChargeReasonCode", "getChargeSceneCode", "setChargeSceneCode", "getCurMoneyPaid", "()I", "setCurMoneyPaid", "(I)V", "getCurRankDuration", "setCurRankDuration", "getCurSentGiftCnt", "setCurSentGiftCnt", "getCurSentGiftMoney", "setCurSentGiftMoney", "getCurWatchDuration", "setCurWatchDuration", "getEnterFromMergeCode", "setEnterFromMergeCode", "getEnterMethodCode", "setEnterMethodCode", "getEventModuleCode", "setEventModuleCode", "getInteractFunctionCode", "setInteractFunctionCode", "()Z", "setFollowed", "(Z)V", "getLiveTypeCode", "setLiveTypeCode", "getLivesdkAudienceLiveMessage", "setLivesdkAudienceLiveMessage", "getLivesdkCommentScreenMessageMonitor", "setLivesdkCommentScreenMessageMonitor", "getLivesdkGiftEffectShow", "setLivesdkGiftEffectShow", "getLivesdkLike", "setLivesdkLike", "getLivesdkRechargeBannerClick", "setLivesdkRechargeBannerClick", "getLivesdkRechargeClick", "setLivesdkRechargeClick", "getLivesdkRechargeCustomizedNext", "setLivesdkRechargeCustomizedNext", "getLivesdkRechargeShow", "setLivesdkRechargeShow", "getLivesdkRechargeSuccess", "setLivesdkRechargeSuccess", "getLivesdkRedPackageShow", "setLivesdkRedPackageShow", "getLivesdkSendGift", "setLivesdkSendGift", "getPayMethodCode", "setPayMethodCode", "getRequestPageCode", "setRequestPageCode", "getRoomLayoutCode", "setRoomLayoutCode", "getStreamingTypeCode", "setStreamingTypeCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeCurrentCacheData {
    private String actionTypeCode;
    private String anchorTypeCode;
    private String chargeReasonCode;
    private String chargeSceneCode;
    private int curMoneyPaid;
    private int curRankDuration;
    private int curSentGiftCnt;
    private int curSentGiftMoney;
    private int curWatchDuration;
    private String enterFromMergeCode;
    private String enterMethodCode;
    private String eventModuleCode;
    private String interactFunctionCode;
    private boolean isFollowed;
    private String liveTypeCode;
    private int livesdkAudienceLiveMessage;
    private int livesdkCommentScreenMessageMonitor;
    private int livesdkGiftEffectShow;
    private int livesdkLike;
    private int livesdkRechargeBannerClick;
    private int livesdkRechargeClick;
    private int livesdkRechargeCustomizedNext;
    private int livesdkRechargeShow;
    private int livesdkRechargeSuccess;
    private int livesdkRedPackageShow;
    private int livesdkSendGift;
    private String payMethodCode;
    private String requestPageCode;
    private String roomLayoutCode;
    private String streamingTypeCode;

    public RechargeCurrentCacheData() {
        this(false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1073741823, null);
    }

    public static /* synthetic */ RechargeCurrentCacheData copy$default(RechargeCurrentCacheData r17, boolean r18, int r19, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r210, String r31, String r32, String r33, int r34, int r35, int r36, int r37, int r38, int r39, int r310, int r41, int r42, int r43, int r44, int r45, int r46, int r47, int r48, int r49, Object r410) {
        if ((r49 & 1) == 0) goto L5;
        boolean r2 = r17.isFollowed;
    L7:
        if ((r49 & 2) == 0) goto L9;
        int r3 = r17.curMoneyPaid;
    L11:
        if ((r49 & 4) == 0) goto L13;
        String r4 = r17.eventModuleCode;
    L15:
        if ((r49 & 8) == 0) goto L17;
        String r5 = r17.liveTypeCode;
    L19:
        if ((r49 & 16) == 0) goto L21;
        String r6 = r17.payMethodCode;
    L23:
        if ((r49 & 32) == 0) goto L25;
        String r7 = r17.anchorTypeCode;
    L27:
        if ((r49 & 64) == 0) goto L29;
        String r8 = r17.chargeSceneCode;
    L31:
        if ((r49 & 128) == 0) goto L33;
        String r9 = r17.chargeReasonCode;
    L35:
        if ((r49 & 256) == 0) goto L37;
        String r11 = r17.interactFunctionCode;
    L39:
        if ((r49 & 512) == 0) goto L41;
        String r12 = r17.requestPageCode;
    L43:
        if ((r49 & RomUtils.SZ) == 0) goto L45;
        String r13 = r17.roomLayoutCode;
    L47:
        if ((r49 & 2048) == 0) goto L49;
        String r14 = r17.streamingTypeCode;
    L51:
        if ((r49 & 4096) == 0) goto L53;
        String r15 = r17.enterFromMergeCode;
    L55:
        if ((r49 & IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0) goto L57;
        String r16 = r17.enterMethodCode;
    L58:
        String r311 = r16;
        if ((r49 & 16384) == 0) goto L61;
        String r110 = r17.actionTypeCode;
    L62:
        String r312 = r110;
        if ((r49 & 32768) == 0) goto L65;
        int r111 = r17.livesdkCommentScreenMessageMonitor;
    L66:
        int r313 = r111;
        if ((r49 & 65536) == 0) goto L69;
        int r112 = r17.livesdkGiftEffectShow;
    L70:
        int r314 = r112;
        if ((r49 & 131072) == 0) goto L73;
        int r113 = r17.livesdkRedPackageShow;
    L74:
        int r315 = r113;
        if ((r49 & 262144) == 0) goto L77;
        int r114 = r17.livesdkAudienceLiveMessage;
    L78:
        int r316 = r114;
        if ((r49 & 524288) == 0) goto L81;
        int r115 = r17.livesdkSendGift;
    L82:
        int r317 = r115;
        if ((r49 & 1048576) == 0) goto L85;
        int r116 = r17.livesdkRechargeClick;
    L86:
        int r318 = r116;
        if ((r49 & 2097152) == 0) goto L89;
        int r117 = r17.livesdkRechargeShow;
    L90:
        int r319 = r117;
        if ((r49 & 4194304) == 0) goto L93;
        int r118 = r17.livesdkRechargeSuccess;
    L94:
        int r411 = r118;
        if ((r49 & 8388608) == 0) goto L97;
        int r119 = r17.livesdkRechargeCustomizedNext;
    L98:
        int r412 = r119;
        if ((r49 & 16777216) == 0) goto L101;
        int r120 = r17.livesdkLike;
    L102:
        int r413 = r120;
        if ((r49 & 33554432) == 0) goto L105;
        int r121 = r17.livesdkRechargeBannerClick;
    L106:
        int r414 = r121;
        if ((r49 & 67108864) == 0) goto L109;
        int r122 = r17.curWatchDuration;
    L110:
        int r415 = r122;
        if ((r49 & 134217728) == 0) goto L113;
        int r123 = r17.curRankDuration;
    L114:
        int r416 = r123;
        if ((r49 & 268435456) == 0) goto L117;
        int r124 = r17.curSentGiftMoney;
    L119:
        if ((r49 & 536870912) == 0) goto L121;
        int r1 = r17.curSentGiftCnt;
    L123:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r311, r312, r313, r314, r315, r316, r317, r318, r319, r411, r412, r413, r414, r415, r416, r124, r1);
    L121:
        r1 = r48;
        goto L123
    L117:
        r124 = r47;
        goto L119
    L113:
        r123 = r46;
        goto L114
    L109:
        r122 = r45;
        goto L110
    L105:
        r121 = r44;
        goto L106
    L101:
        r120 = r43;
        goto L102
    L97:
        r119 = r42;
        goto L98
    L93:
        r118 = r41;
        goto L94
    L89:
        r117 = r310;
        goto L90
    L85:
        r116 = r39;
        goto L86
    L81:
        r115 = r38;
        goto L82
    L77:
        r114 = r37;
        goto L78
    L73:
        r113 = r36;
        goto L74
    L69:
        r112 = r35;
        goto L70
    L65:
        r111 = r34;
        goto L66
    L61:
        r110 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L55
    L49:
        r14 = r210;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final boolean component1() {
        return this.isFollowed;
    }

    public final String component10() {
        return this.requestPageCode;
    }

    public final String component11() {
        return this.roomLayoutCode;
    }

    public final String component12() {
        return this.streamingTypeCode;
    }

    public final String component13() {
        return this.enterFromMergeCode;
    }

    public final String component14() {
        return this.enterMethodCode;
    }

    public final String component15() {
        return this.actionTypeCode;
    }

    public final int component16() {
        return this.livesdkCommentScreenMessageMonitor;
    }

    public final int component17() {
        return this.livesdkGiftEffectShow;
    }

    public final int component18() {
        return this.livesdkRedPackageShow;
    }

    public final int component19() {
        return this.livesdkAudienceLiveMessage;
    }

    public final int component2() {
        return this.curMoneyPaid;
    }

    public final int component20() {
        return this.livesdkSendGift;
    }

    public final int component21() {
        return this.livesdkRechargeClick;
    }

    public final int component22() {
        return this.livesdkRechargeShow;
    }

    public final int component23() {
        return this.livesdkRechargeSuccess;
    }

    public final int component24() {
        return this.livesdkRechargeCustomizedNext;
    }

    public final int component25() {
        return this.livesdkLike;
    }

    public final int component26() {
        return this.livesdkRechargeBannerClick;
    }

    public final int component27() {
        return this.curWatchDuration;
    }

    public final int component28() {
        return this.curRankDuration;
    }

    public final int component29() {
        return this.curSentGiftMoney;
    }

    public final String component3() {
        return this.eventModuleCode;
    }

    public final int component30() {
        return this.curSentGiftCnt;
    }

    public final String component4() {
        return this.liveTypeCode;
    }

    public final String component5() {
        return this.payMethodCode;
    }

    public final String component6() {
        return this.anchorTypeCode;
    }

    public final String component7() {
        return this.chargeSceneCode;
    }

    public final String component8() {
        return this.chargeReasonCode;
    }

    public final String component9() {
        return this.interactFunctionCode;
    }

    public final RechargeCurrentCacheData copy(boolean r33, int r34, String r35, String r36, String r37, String r38, String r39, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, int r49, int r410, int r51, int r52, int r53, int r54, int r55, int r56, int r57, int r58, int r59, int r510, int r61, int r62, int r63) {
        Intrinsics.checkNotNullParameter(r35, "eventModuleCode");
        Intrinsics.checkNotNullParameter(r36, "liveTypeCode");
        Intrinsics.checkNotNullParameter(r37, "payMethodCode");
        Intrinsics.checkNotNullParameter(r38, "anchorTypeCode");
        Intrinsics.checkNotNullParameter(r39, "chargeSceneCode");
        Intrinsics.checkNotNullParameter(r41, "chargeReasonCode");
        Intrinsics.checkNotNullParameter(r42, "interactFunctionCode");
        Intrinsics.checkNotNullParameter(r43, "requestPageCode");
        Intrinsics.checkNotNullParameter(r44, "roomLayoutCode");
        Intrinsics.checkNotNullParameter(r45, "streamingTypeCode");
        Intrinsics.checkNotNullParameter(r46, "enterFromMergeCode");
        Intrinsics.checkNotNullParameter(r47, "enterMethodCode");
        Intrinsics.checkNotNullParameter(r48, "actionTypeCode");
        return new RechargeCurrentCacheData(r33, r34, r35, r36, r37, r38, r39, r41, r42, r43, r44, r45, r46, r47, r48, r49, r410, r51, r52, r53, r54, r55, r56, r57, r58, r59, r510, r61, r62, r63);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RechargeCurrentCacheData) == false) goto L66;
        RechargeCurrentCacheData r4 = (RechargeCurrentCacheData) r3;
        if (this.isFollowed == r4.isFollowed) goto L8;
        return false;
    L8:
        if (this.curMoneyPaid == r4.curMoneyPaid) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventModuleCode, r4.eventModuleCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveTypeCode, r4.liveTypeCode) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.payMethodCode, r4.payMethodCode) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.anchorTypeCode, r4.anchorTypeCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chargeSceneCode, r4.chargeSceneCode) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.chargeReasonCode, r4.chargeReasonCode) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.interactFunctionCode, r4.interactFunctionCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.requestPageCode, r4.requestPageCode) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.roomLayoutCode, r4.roomLayoutCode) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.streamingTypeCode, r4.streamingTypeCode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enterFromMergeCode, r4.enterFromMergeCode) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.enterMethodCode, r4.enterMethodCode) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.actionTypeCode, r4.actionTypeCode) == true) goto L36;
        return false;
    L36:
        if (this.livesdkCommentScreenMessageMonitor == r4.livesdkCommentScreenMessageMonitor) goto L38;
        return false;
    L38:
        if (this.livesdkGiftEffectShow == r4.livesdkGiftEffectShow) goto L40;
        return false;
    L40:
        if (this.livesdkRedPackageShow == r4.livesdkRedPackageShow) goto L42;
        return false;
    L42:
        if (this.livesdkAudienceLiveMessage == r4.livesdkAudienceLiveMessage) goto L44;
        return false;
    L44:
        if (this.livesdkSendGift == r4.livesdkSendGift) goto L46;
        return false;
    L46:
        if (this.livesdkRechargeClick == r4.livesdkRechargeClick) goto L48;
        return false;
    L48:
        if (this.livesdkRechargeShow == r4.livesdkRechargeShow) goto L50;
        return false;
    L50:
        if (this.livesdkRechargeSuccess == r4.livesdkRechargeSuccess) goto L52;
        return false;
    L52:
        if (this.livesdkRechargeCustomizedNext == r4.livesdkRechargeCustomizedNext) goto L54;
        return false;
    L54:
        if (this.livesdkLike == r4.livesdkLike) goto L56;
        return false;
    L56:
        if (this.livesdkRechargeBannerClick == r4.livesdkRechargeBannerClick) goto L58;
        return false;
    L58:
        if (this.curWatchDuration == r4.curWatchDuration) goto L60;
        return false;
    L60:
        if (this.curRankDuration == r4.curRankDuration) goto L62;
        return false;
    L62:
        if (this.curSentGiftMoney == r4.curSentGiftMoney) goto L64;
        return false;
    L64:
        if (this.curSentGiftCnt == r4.curSentGiftCnt) goto L100;
        return false;
    L100:
        return true;
    L66:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    public int hashCode() {
        boolean r0 = this.isFollowed;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.curMoneyPaid) * 31;
        String r3 = this.eventModuleCode;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        String r7 = this.liveTypeCode;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r11 = this.payMethodCode;
        if (r11 == null) goto L16;
        int r12 = r11.hashCode();
    L17:
        int r13 = (r9 + r12) * 31;
        String r14 = this.anchorTypeCode;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        String r17 = this.chargeSceneCode;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        String r21 = this.chargeReasonCode;
        if (r21 == null) goto L28;
        int r22 = r21.hashCode();
    L29:
        int r23 = (r19 + r22) * 31;
        String r24 = this.interactFunctionCode;
        if (r24 == null) goto L32;
        int r25 = r24.hashCode();
    L33:
        int r26 = (r23 + r25) * 31;
        String r27 = this.requestPageCode;
        if (r27 == null) goto L36;
        int r28 = r27.hashCode();
    L37:
        int r29 = (r26 + r28) * 31;
        String r31 = this.roomLayoutCode;
        if (r31 == null) goto L40;
        int r32 = r31.hashCode();
    L41:
        int r33 = (r29 + r32) * 31;
        String r34 = this.streamingTypeCode;
        if (r34 == null) goto L44;
        int r35 = r34.hashCode();
    L45:
        int r36 = (r33 + r35) * 31;
        String r37 = this.enterFromMergeCode;
        if (r37 == null) goto L48;
        int r38 = r37.hashCode();
    L49:
        int r39 = (r36 + r38) * 31;
        String r41 = this.enterMethodCode;
        if (r41 == null) goto L52;
        int r42 = r41.hashCode();
    L53:
        int r43 = (r39 + r42) * 31;
        String r44 = this.actionTypeCode;
        if (r44 == null) goto L57;
        r4 = r44.hashCode();
    L57:
        return ((((((((((((((((((((((((((((((r43 + r4) * 31) + this.livesdkCommentScreenMessageMonitor) * 31) + this.livesdkGiftEffectShow) * 31) + this.livesdkRedPackageShow) * 31) + this.livesdkAudienceLiveMessage) * 31) + this.livesdkSendGift) * 31) + this.livesdkRechargeClick) * 31) + this.livesdkRechargeShow) * 31) + this.livesdkRechargeSuccess) * 31) + this.livesdkRechargeCustomizedNext) * 31) + this.livesdkLike) * 31) + this.livesdkRechargeBannerClick) * 31) + this.curWatchDuration) * 31) + this.curRankDuration) * 31) + this.curSentGiftMoney) * 31) + this.curSentGiftCnt;
    L52:
        r42 = 0;
        goto L53
    L48:
        r38 = 0;
        goto L49
    L44:
        r35 = 0;
        goto L45
    L40:
        r32 = 0;
        goto L41
    L36:
        r28 = 0;
        goto L37
    L32:
        r25 = 0;
        goto L33
    L28:
        r22 = 0;
        goto L29
    L24:
        r18 = 0;
        goto L25
    L20:
        r15 = 0;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public String toString() {
        return "RechargeCurrentCacheData(isFollowed=" + this.isFollowed + ", curMoneyPaid=" + this.curMoneyPaid + ", eventModuleCode=" + this.eventModuleCode + ", liveTypeCode=" + this.liveTypeCode + ", payMethodCode=" + this.payMethodCode + ", anchorTypeCode=" + this.anchorTypeCode + ", chargeSceneCode=" + this.chargeSceneCode + ", chargeReasonCode=" + this.chargeReasonCode + ", interactFunctionCode=" + this.interactFunctionCode + ", requestPageCode=" + this.requestPageCode + ", roomLayoutCode=" + this.roomLayoutCode + ", streamingTypeCode=" + this.streamingTypeCode + ", enterFromMergeCode=" + this.enterFromMergeCode + ", enterMethodCode=" + this.enterMethodCode + ", actionTypeCode=" + this.actionTypeCode + ", livesdkCommentScreenMessageMonitor=" + this.livesdkCommentScreenMessageMonitor + ", livesdkGiftEffectShow=" + this.livesdkGiftEffectShow + ", livesdkRedPackageShow=" + this.livesdkRedPackageShow + ", livesdkAudienceLiveMessage=" + this.livesdkAudienceLiveMessage + ", livesdkSendGift=" + this.livesdkSendGift + ", livesdkRechargeClick=" + this.livesdkRechargeClick + ", livesdkRechargeShow=" + this.livesdkRechargeShow + ", livesdkRechargeSuccess=" + this.livesdkRechargeSuccess + ", livesdkRechargeCustomizedNext=" + this.livesdkRechargeCustomizedNext + ", livesdkLike=" + this.livesdkLike + ", livesdkRechargeBannerClick=" + this.livesdkRechargeBannerClick + ", curWatchDuration=" + this.curWatchDuration + ", curRankDuration=" + this.curRankDuration + ", curSentGiftMoney=" + this.curSentGiftMoney + ", curSentGiftCnt=" + this.curSentGiftCnt + ")";
    }

    public final String getActionTypeCode() {
        return this.actionTypeCode;
    }

    public final String getAnchorTypeCode() {
        return this.anchorTypeCode;
    }

    public final String getChargeReasonCode() {
        return this.chargeReasonCode;
    }

    public final String getChargeSceneCode() {
        return this.chargeSceneCode;
    }

    public final int getCurMoneyPaid() {
        return this.curMoneyPaid;
    }

    public final int getCurRankDuration() {
        return this.curRankDuration;
    }

    public final int getCurSentGiftCnt() {
        return this.curSentGiftCnt;
    }

    public final int getCurSentGiftMoney() {
        return this.curSentGiftMoney;
    }

    public final int getCurWatchDuration() {
        return this.curWatchDuration;
    }

    public final String getEnterFromMergeCode() {
        return this.enterFromMergeCode;
    }

    public final String getEnterMethodCode() {
        return this.enterMethodCode;
    }

    public final String getEventModuleCode() {
        return this.eventModuleCode;
    }

    public final String getInteractFunctionCode() {
        return this.interactFunctionCode;
    }

    public final String getLiveTypeCode() {
        return this.liveTypeCode;
    }

    public final int getLivesdkAudienceLiveMessage() {
        return this.livesdkAudienceLiveMessage;
    }

    public final int getLivesdkCommentScreenMessageMonitor() {
        return this.livesdkCommentScreenMessageMonitor;
    }

    public final int getLivesdkGiftEffectShow() {
        return this.livesdkGiftEffectShow;
    }

    public final int getLivesdkLike() {
        return this.livesdkLike;
    }

    public final int getLivesdkRechargeBannerClick() {
        return this.livesdkRechargeBannerClick;
    }

    public final int getLivesdkRechargeClick() {
        return this.livesdkRechargeClick;
    }

    public final int getLivesdkRechargeCustomizedNext() {
        return this.livesdkRechargeCustomizedNext;
    }

    public final int getLivesdkRechargeShow() {
        return this.livesdkRechargeShow;
    }

    public final int getLivesdkRechargeSuccess() {
        return this.livesdkRechargeSuccess;
    }

    public final int getLivesdkRedPackageShow() {
        return this.livesdkRedPackageShow;
    }

    public final int getLivesdkSendGift() {
        return this.livesdkSendGift;
    }

    public final String getPayMethodCode() {
        return this.payMethodCode;
    }

    public final String getRequestPageCode() {
        return this.requestPageCode;
    }

    public final String getRoomLayoutCode() {
        return this.roomLayoutCode;
    }

    public final String getStreamingTypeCode() {
        return this.streamingTypeCode;
    }

    public final boolean isFollowed() {
        return this.isFollowed;
    }

    public final void setActionTypeCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.actionTypeCode = r2;
    }

    public final void setAnchorTypeCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorTypeCode = r2;
    }

    public final void setChargeReasonCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chargeReasonCode = r2;
    }

    public final void setChargeSceneCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chargeSceneCode = r2;
    }

    public final void setCurMoneyPaid(int r1) {
        this.curMoneyPaid = r1;
    }

    public final void setCurRankDuration(int r1) {
        this.curRankDuration = r1;
    }

    public final void setCurSentGiftCnt(int r1) {
        this.curSentGiftCnt = r1;
    }

    public final void setCurSentGiftMoney(int r1) {
        this.curSentGiftMoney = r1;
    }

    public final void setCurWatchDuration(int r1) {
        this.curWatchDuration = r1;
    }

    public final void setEnterFromMergeCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterFromMergeCode = r2;
    }

    public final void setEnterMethodCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterMethodCode = r2;
    }

    public final void setEventModuleCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.eventModuleCode = r2;
    }

    public final void setFollowed(boolean r1) {
        this.isFollowed = r1;
    }

    public final void setInteractFunctionCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.interactFunctionCode = r2;
    }

    public final void setLiveTypeCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.liveTypeCode = r2;
    }

    public final void setLivesdkAudienceLiveMessage(int r1) {
        this.livesdkAudienceLiveMessage = r1;
    }

    public final void setLivesdkCommentScreenMessageMonitor(int r1) {
        this.livesdkCommentScreenMessageMonitor = r1;
    }

    public final void setLivesdkGiftEffectShow(int r1) {
        this.livesdkGiftEffectShow = r1;
    }

    public final void setLivesdkLike(int r1) {
        this.livesdkLike = r1;
    }

    public final void setLivesdkRechargeBannerClick(int r1) {
        this.livesdkRechargeBannerClick = r1;
    }

    public final void setLivesdkRechargeClick(int r1) {
        this.livesdkRechargeClick = r1;
    }

    public final void setLivesdkRechargeCustomizedNext(int r1) {
        this.livesdkRechargeCustomizedNext = r1;
    }

    public final void setLivesdkRechargeShow(int r1) {
        this.livesdkRechargeShow = r1;
    }

    public final void setLivesdkRechargeSuccess(int r1) {
        this.livesdkRechargeSuccess = r1;
    }

    public final void setLivesdkRedPackageShow(int r1) {
        this.livesdkRedPackageShow = r1;
    }

    public final void setLivesdkSendGift(int r1) {
        this.livesdkSendGift = r1;
    }

    public final void setPayMethodCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.payMethodCode = r2;
    }

    public final void setRequestPageCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.requestPageCode = r2;
    }

    public final void setRoomLayoutCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.roomLayoutCode = r2;
    }

    public final void setStreamingTypeCode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.streamingTypeCode = r2;
    }

    public RechargeCurrentCacheData(boolean r16, int r17, String r18, String r19, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r210, String r31, int r32, int r33, int r34, int r35, int r36, int r37, int r38, int r39, int r310, int r41, int r42, int r43, int r44, int r45, int r46) {
        Intrinsics.checkNotNullParameter(r18, "eventModuleCode");
        Intrinsics.checkNotNullParameter(r19, "liveTypeCode");
        Intrinsics.checkNotNullParameter(r21, "payMethodCode");
        Intrinsics.checkNotNullParameter(r22, "anchorTypeCode");
        Intrinsics.checkNotNullParameter(r23, "chargeSceneCode");
        Intrinsics.checkNotNullParameter(r24, "chargeReasonCode");
        Intrinsics.checkNotNullParameter(r25, "interactFunctionCode");
        Intrinsics.checkNotNullParameter(r26, "requestPageCode");
        Intrinsics.checkNotNullParameter(r27, "roomLayoutCode");
        Intrinsics.checkNotNullParameter(r28, "streamingTypeCode");
        Intrinsics.checkNotNullParameter(r29, "enterFromMergeCode");
        Intrinsics.checkNotNullParameter(r210, "enterMethodCode");
        Intrinsics.checkNotNullParameter(r31, "actionTypeCode");
        this.isFollowed = r16;
        this.curMoneyPaid = r17;
        this.eventModuleCode = r18;
        this.liveTypeCode = r19;
        this.payMethodCode = r21;
        this.anchorTypeCode = r22;
        this.chargeSceneCode = r23;
        this.chargeReasonCode = r24;
        this.interactFunctionCode = r25;
        this.requestPageCode = r26;
        this.roomLayoutCode = r27;
        this.streamingTypeCode = r28;
        this.enterFromMergeCode = r29;
        this.enterMethodCode = r210;
        this.actionTypeCode = r31;
        this.livesdkCommentScreenMessageMonitor = r32;
        this.livesdkGiftEffectShow = r33;
        this.livesdkRedPackageShow = r34;
        this.livesdkAudienceLiveMessage = r35;
        this.livesdkSendGift = r36;
        this.livesdkRechargeClick = r37;
        this.livesdkRechargeShow = r38;
        this.livesdkRechargeSuccess = r39;
        this.livesdkRechargeCustomizedNext = r310;
        this.livesdkLike = r41;
        this.livesdkRechargeBannerClick = r42;
        this.curWatchDuration = r43;
        this.curRankDuration = r44;
        this.curSentGiftMoney = r45;
        this.curSentGiftCnt = r46;
    }

    public /* synthetic */ RechargeCurrentCacheData(boolean r32, int r33, String r34, String r35, String r36, String r37, String r38, String r39, String r41, String r42, String r43, String r44, String r45, String r46, String r47, int r48, int r49, int r410, int r51, int r52, int r53, int r54, int r55, int r56, int r57, int r58, int r59, int r510, int r61, int r62, int r63, DefaultConstructorMarker r64) {
        if ((r63 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r63 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r63 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r63 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r63 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r63 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r63 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r63 & 128) == 0) goto L33;
        String r11 = "";
    L35:
        if ((r63 & 256) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r63 & 512) == 0) goto L41;
        String r13 = "";
    L43:
        if ((r63 & RomUtils.SZ) == 0) goto L45;
        String r14 = "";
    L47:
        if ((r63 & 2048) == 0) goto L49;
        String r15 = "";
    L51:
        if ((r63 & 4096) == 0) goto L53;
        String r16 = "";
    L55:
        if ((r63 & IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0) goto L57;
        String r2 = "";
    L59:
        if ((r63 & 16384) == 0) goto L61;
        String r5 = "";
    L63:
        if ((r63 & 32768) == 0) goto L65;
        int r17 = 0;
    L67:
        if ((r63 & 65536) == 0) goto L69;
        int r18 = 0;
    L71:
        if ((r63 & 131072) == 0) goto L73;
        int r19 = 0;
    L75:
        if ((r63 & 262144) == 0) goto L77;
        int r110 = 0;
    L79:
        if ((r63 & 524288) == 0) goto L81;
        int r21 = 0;
    L83:
        if ((r63 & 1048576) == 0) goto L85;
        int r22 = 0;
    L87:
        if ((r63 & 2097152) == 0) goto L89;
        int r23 = 0;
    L91:
        if ((r63 & 4194304) == 0) goto L93;
        int r24 = 0;
    L95:
        if ((r63 & 8388608) == 0) goto L97;
        int r25 = 0;
    L99:
        if ((r63 & 16777216) == 0) goto L101;
        int r26 = 0;
    L103:
        if ((r63 & 33554432) == 0) goto L105;
        int r27 = 0;
    L107:
        if ((r63 & 67108864) == 0) goto L109;
        int r28 = 0;
    L111:
        if ((r63 & 134217728) == 0) goto L113;
        int r29 = 0;
    L115:
        if ((r63 & 268435456) == 0) goto L117;
        int r210 = 0;
    L119:
        if ((r63 & 536870912) == 0) goto L121;
        int r0 = 0;
    L122:
        this(r1, r3, r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r2, r5, r17, r18, r19, r110, r21, r22, r23, r24, r25, r26, r27, r28, r29, r210, r0);
        return;
    L121:
        r0 = r62;
        goto L122
    L117:
        r210 = r61;
        goto L119
    L113:
        r29 = r510;
        goto L115
    L109:
        r28 = r59;
        goto L111
    L105:
        r27 = r58;
        goto L107
    L101:
        r26 = r57;
        goto L103
    L97:
        r25 = r56;
        goto L99
    L93:
        r24 = r55;
        goto L95
    L89:
        r23 = r54;
        goto L91
    L85:
        r22 = r53;
        goto L87
    L81:
        r21 = r52;
        goto L83
    L77:
        r110 = r51;
        goto L79
    L73:
        r19 = r410;
        goto L75
    L69:
        r18 = r49;
        goto L71
    L65:
        r17 = r48;
        goto L67
    L61:
        r5 = r47;
        goto L63
    L57:
        r2 = r46;
        goto L59
    L53:
        r16 = r45;
        goto L55
    L49:
        r15 = r44;
        goto L51
    L45:
        r14 = r43;
        goto L47
    L41:
        r13 = r42;
        goto L43
    L37:
        r12 = r41;
        goto L39
    L33:
        r11 = r39;
        goto L35
    L29:
        r9 = r38;
        goto L31
    L25:
        r8 = r37;
        goto L27
    L21:
        r7 = r36;
        goto L23
    L17:
        r6 = r35;
        goto L19
    L13:
        r4 = r34;
        goto L15
    L9:
        r3 = r33;
        goto L11
    L5:
        r1 = r32;
        goto L7
    }
}
