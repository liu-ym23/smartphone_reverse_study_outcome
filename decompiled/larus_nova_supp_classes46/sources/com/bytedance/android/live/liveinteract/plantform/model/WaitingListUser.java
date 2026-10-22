package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.UserHighScoreSongTag;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 Ç\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002È\u0001B\t¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003J\u0013\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\f\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010+\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\"\u0010.\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\"\u00101\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R$\u00105\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R*\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bA\u0010\u001a\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR\"\u0010D\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bD\u0010\u001a\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u001eR$\u0010G\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bG\u00106\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R\"\u0010J\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bJ\u0010#\u001a\u0004\bK\u0010%\"\u0004\bL\u0010'R\"\u0010M\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bM\u0010#\u001a\u0004\bN\u0010%\"\u0004\bO\u0010'R\"\u0010P\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bP\u0010\r\u001a\u0004\bQ\u0010\u000e\"\u0004\bR\u0010\u0010R\"\u0010S\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bS\u0010\r\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010R$\u0010U\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bU\u00106\u001a\u0004\bV\u00108\"\u0004\bW\u0010:R$\u0010X\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bX\u00106\u001a\u0004\bY\u00108\"\u0004\bZ\u0010:R$\u0010[\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b[\u00106\u001a\u0004\b\\\u00108\"\u0004\b]\u0010:R\"\u0010^\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b^\u0010\u001a\u001a\u0004\b_\u0010\u001c\"\u0004\b`\u0010\u001eR\"\u0010a\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\ba\u0010\u001a\u001a\u0004\bb\u0010\u001c\"\u0004\bc\u0010\u001eR\"\u0010d\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bd\u0010\r\u001a\u0004\bd\u0010\u000e\"\u0004\be\u0010\u0010R\"\u0010f\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bf\u0010\u001a\u001a\u0004\bg\u0010\u001c\"\u0004\bh\u0010\u001eR\"\u0010i\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bi\u0010\r\u001a\u0004\bi\u0010\u000e\"\u0004\bj\u0010\u0010R$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR$\u0010r\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010\u0013\u001a\u0004\bs\u0010\u0015\"\u0004\bt\u0010\u0017R\"\u0010u\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bu\u0010#\u001a\u0004\bv\u0010%\"\u0004\bw\u0010'R\"\u0010x\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bx\u0010\u001a\u001a\u0004\by\u0010\u001c\"\u0004\bz\u0010\u001eR&\u0010|\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R,\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R&\u0010\u0089\u0001\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010\r\u001a\u0005\b\u008a\u0001\u0010\u000e\"\u0005\b\u008b\u0001\u0010\u0010R/\u0010\u008d\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010<\u001a\u0005\b\u008e\u0001\u0010>\"\u0005\b\u008f\u0001\u0010@R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010\u001a\u001a\u0005\b\u0098\u0001\u0010\u001c\"\u0005\b\u0099\u0001\u0010\u001eR&\u0010\u009a\u0001\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010\r\u001a\u0005\b\u009a\u0001\u0010\u000e\"\u0005\b\u009b\u0001\u0010\u0010R&\u0010\u009c\u0001\u001a\u0002048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u00106\u001a\u0005\b\u009d\u0001\u00108\"\u0005\b\u009e\u0001\u0010:R,\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R,\u0010©\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b§\u0001\u0010\u0015\"\u0005\b¨\u0001\u0010\u0017R<\u0010¬\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00032\u0011\u0010¦\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bª\u0001\u0010>\"\u0005\b«\u0001\u0010@R0\u0010²\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010\u00ad\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R,\u0010µ\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b³\u0001\u0010\u0015\"\u0005\b´\u0001\u0010\u0017R0\u0010»\u0001\u001a\u0005\u0018\u00010¶\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¶\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R0\u0010Á\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¼\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R0\u0010Ä\u0001\u001a\u0005\u0018\u00010\u0090\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010\u0090\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÂ\u0001\u0010\u0094\u0001\"\u0006\bÃ\u0001\u0010\u0096\u0001¨\u0006É\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", PbRequest.SwitchType.OTHER, "", "isSameKtvMusic", "", "equals", "", "hashCode", "isHasApplied", "Z", "()Z", "setHasApplied", "(Z)V", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "linkmicId", "J", "getLinkmicId", "()J", "setLinkmicId", "(J)V", "modifyTime", "getModifyTime", "setModifyTime", "mLinkStatus", "I", "getMLinkStatus", "()I", "setMLinkStatus", "(I)V", "mLinkType", "getMLinkType", "setMLinkType", "mRoleType", "getMRoleType", "setMRoleType", "userPosition", "getUserPosition", "setUserPosition", "silenceStatus", "getSilenceStatus", "setSilenceStatus", "", "linkmicIdStr", "Ljava/lang/String;", "getLinkmicIdStr", "()Ljava/lang/String;", "setLinkmicIdStr", "(Ljava/lang/String;)V", "songList", "Ljava/util/List;", "getSongList", "()Ljava/util/List;", "setSongList", "(Ljava/util/List;)V", "appId", "getAppId", "setAppId", "clientVersion", "getClientVersion", "setClientVersion", "devicePlatform", "getDevicePlatform", "setDevicePlatform", "listUserType", "getListUserType", "setListUserType", "listUserFromType", "getListUserFromType", "setListUserFromType", "hasExpired", "getHasExpired", "setHasExpired", "isMutualFollow", "setMutualFollow", "applyReason", "getApplyReason", "setApplyReason", "last7DaysGiftCountTxt", "getLast7DaysGiftCountTxt", "setLast7DaysGiftCountTxt", "fanTicket", "getFanTicket", "setFanTicket", "offset", "getOffset", "setOffset", "rank", "getRank", "setRank", "isAddPrice", "setAddPrice", "addPriceTime", "getAddPriceTime", "setAddPriceTime", "isAnonymous", "setAnonymous", "Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;", "micPosTag", "Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;", "getMicPosTag", "()Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;", "setMicPosTag", "(Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;)V", "invitor", "getInvitor", "setInvitor", "applyType", "getApplyType", "setApplyType", "paidAmount", "getPaidAmount", "setPaidAmount", "Lcom/bytedance/android/live/liveinteract/plantform/model/TeamFightJoinTeamInfo;", "joinTeamFightInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/TeamFightJoinTeamInfo;", "getJoinTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/TeamFightJoinTeamInfo;", "setJoinTeamFightInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/TeamFightJoinTeamInfo;)V", "Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "userHighScoreSongTag", "Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "getUserHighScoreSongTag", "()Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "setUserHighScoreSongTag", "(Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;)V", "alreadyInvited", "getAlreadyInvited", "setAlreadyInvited", "Lcom/bytedance/android/live/liveinteract/plantform/model/v;", "tags", "getTags", "setTags", "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "eventInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "getEventInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "setEventInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/c0;)V", "orderedSongCount", "getOrderedSongCount", "setOrderedSongCount", "isActive", "setActive", "buttonText", "getButtonText", "setButtonText", "Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "tag", "Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "getTag", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "setTag", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;)V", "value", "getUserFlex", "setUserFlex", "userFlex", "getSongListFlex", "setSongListFlex", "songListFlex", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "getMicPosTagFlex", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "setMicPosTagFlex", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g0;)V", "micPosTagFlex", "getInvitorFlex", "setInvitorFlex", "invitorFlex", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamFightInfoFlex", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "setJoinTeamFightInfoFlex", "(Lcom/bytedance/android/live/liveinteract/plantform/model/j0;)V", "joinTeamFightInfoFlex", "Lcom/bytedance/android/livesdk/message/model/fc;", "getUserHighScoreSongTagFlex", "()Lcom/bytedance/android/livesdk/message/model/fc;", "setUserHighScoreSongTagFlex", "(Lcom/bytedance/android/livesdk/message/model/fc;)V", "userHighScoreSongTagFlex", "getEventInfoFlex", "setEventInfoFlex", "eventInfoFlex", "<init>", "()V", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WaitingListUser extends FlexModelBase<n0> implements n0, vh7.h {
    public static final a Companion = null;
    private static final int HASH_CODE_37 = 37;

    @SerializedName("add_price_time_ms")
    protected long addPriceTime;

    @IgnoreProtoFieldCheck
    @SerializedName("already_invited")
    protected boolean alreadyInvited;

    @SerializedName("app_id")
    protected long appId;

    @SerializedName("application_reason")
    protected String applyReason;

    @SerializedName("apply_type")
    protected int applyType;

    @SerializedName("button_text")
    protected String buttonText;

    @SerializedName("client_version")
    protected long clientVersion;

    @SerializedName("device_platform")
    protected String devicePlatform;

    @SerializedName("event_info")
    protected c0 eventInfo;

    @SerializedName("fan_ticket")
    protected String fanTicket;

    @SerializedName("application_has_expired")
    protected boolean hasExpired;

    @SerializedName("invitor")
    protected IBaseUser invitor;

    @SerializedName("is_active")
    protected boolean isActive;

    @SerializedName("is_add_price")
    protected boolean isAddPrice;

    @SerializedName("is_anonymous")
    protected boolean isAnonymous;
    private transient boolean isHasApplied;

    @SerializedName("is_mutual_following")
    protected boolean isMutualFollow;

    @SerializedName("join_teamfight_info")
    protected TeamFightJoinTeamInfo joinTeamFightInfo;

    @SerializedName("last_7_days_gift_count_text")
    protected String last7DaysGiftCountTxt;

    @SerializedName("linkmic_id")
    protected long linkmicId;

    @SerializedName("linkmic_id_str")
    protected String linkmicIdStr;

    @SerializedName("list_user_from_type")
    protected int listUserFromType;

    @SerializedName("list_user_type")
    protected int listUserType;

    @SerializedName("link_status")
    protected int mLinkStatus;

    @SerializedName("link_type")
    protected int mLinkType;

    @SerializedName("role_type")
    protected int mRoleType;

    @SerializedName("mic_pos_tag_info")
    protected MicPosTagInfo micPosTag;

    @SerializedName("modify_time")
    protected long modifyTime;

    @SerializedName("offset")
    protected long offset;

    @SerializedName("order_song_count")
    protected long orderedSongCount;

    @SerializedName("paid_amount")
    protected long paidAmount;

    @SerializedName("rank")
    protected long rank;

    @SerializedName("silence_status")
    protected int silenceStatus;

    @SerializedName("song_list")
    protected List<KtvMusic> songList;

    @SerializedName("tag")
    protected ListUserTag tag;

    @SerializedName("tags")
    protected List<? extends v> tags;

    @SerializedName("user")
    protected IBaseUser user;

    @SerializedName("high_score_song_tag")
    protected UserHighScoreSongTag userHighScoreSongTag;

    @SerializedName("user_position")
    protected int userPosition;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public WaitingListUser() {
        super(n0.class);
        this.linkmicIdStr = "";
        this.devicePlatform = "";
        this.buttonText = "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public c0 getEventInfoFlex() {
        return getEventInfo();
    }

    public int hashCode() {
        int r1 = 1231;
        if (isHasApplied() == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 37;
        IBaseUser r3 = this.user;
        int r4 = 0;
        if (r3 == null) goto L9;
        int r5 = r3.hashCode();
    L10:
        long r6 = getLinkmicId();
        int r7 = (((r2 + r5) * 37) + ((int) (r6 ^ (r6 >>> 32)))) * 37;
        long r8 = getModifyTime();
        int r9 = (((((((((((r7 + ((int) (r8 ^ (r8 >>> 32)))) * 37) + getMLinkStatus()) * 37) + getMLinkType()) * 37) + getMRoleType()) * 37) + getUserPosition()) * 37) + getSilenceStatus()) * 37;
        String r10 = getLinkmicIdStr();
        if (r10 == null) goto L13;
        int r11 = r10.hashCode();
    L14:
        int r12 = (r9 + r11) * 37;
        List<KtvMusic> r13 = this.songList;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (r12 + r14) * 37;
        long r16 = getAppId();
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 37;
        long r18 = getClientVersion();
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 37;
        String r20 = getDevicePlatform();
        if (r20 == null) goto L21;
        int r21 = r20.hashCode();
    L22:
        int r22 = (((((r19 + r21) * 37) + getListUserType()) * 37) + getListUserFromType()) * 37;
        if (getHasExpired() == false) goto L25;
        int r23 = 1231;
    L26:
        int r24 = (r22 + r23) * 37;
        if (isMutualFollow() == false) goto L29;
        int r25 = 1231;
    L30:
        int r26 = (r24 + r25) * 37;
        String r27 = getApplyReason();
        if (r27 == null) goto L33;
        int r28 = r27.hashCode();
    L34:
        int r29 = (r26 + r28) * 37;
        String r30 = getLast7DaysGiftCountTxt();
        if (r30 == null) goto L37;
        int r31 = r30.hashCode();
    L38:
        int r32 = (r29 + r31) * 37;
        String r33 = getFanTicket();
        if (r33 == null) goto L41;
        int r34 = r33.hashCode();
    L42:
        int r35 = (r32 + r34) * 37;
        long r36 = getOffset();
        int r37 = (r35 + ((int) (r36 ^ (r36 >>> 32)))) * 37;
        long r38 = getRank();
        int r39 = (r37 + ((int) (r38 ^ (r38 >>> 32)))) * 37;
        if (isAddPrice() == false) goto L45;
        int r40 = 1231;
    L46:
        int r41 = (r39 + r40) * 37;
        long r42 = getAddPriceTime();
        int r43 = (r41 + ((int) (r42 ^ (r42 >>> 32)))) * 37;
        if (isAnonymous() == true) goto L50;
        r1 = 1237;
    L50:
        int r44 = (r43 + r1) * 37;
        MicPosTagInfo r45 = this.micPosTag;
        if (r45 == null) goto L53;
        int r46 = r45.hashCode();
    L54:
        int r47 = (r44 + r46) * 37;
        IBaseUser r48 = this.invitor;
        if (r48 == null) goto L57;
        int r49 = r48.hashCode();
    L58:
        int r50 = (((r47 + r49) * 37) + getApplyType()) * 37;
        TeamFightJoinTeamInfo r51 = this.joinTeamFightInfo;
        if (r51 == null) goto L62;
        r4 = r51.hashCode();
    L62:
        return r50 + r4;
    L57:
        r49 = 0;
        goto L58
    L53:
        r46 = 0;
        goto L54
    L45:
        r40 = 1237;
        goto L46
    L41:
        r34 = 0;
        goto L42
    L37:
        r31 = 0;
        goto L38
    L33:
        r28 = 0;
        goto L34
    L29:
        r25 = 1237;
        goto L30
    L25:
        r23 = 1237;
        goto L26
    L21:
        r21 = 0;
        goto L22
    L17:
        r14 = 0;
        goto L18
    L13:
        r11 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getAddPriceTime() {
        return this.addPriceTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean getAlreadyInvited() {
        return this.alreadyInvited;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getAppId() {
        return this.appId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getApplyReason() {
        return this.applyReason;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getApplyType() {
        return this.applyType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getButtonText() {
        return this.buttonText;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getClientVersion() {
        return this.clientVersion;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getDevicePlatform() {
        return this.devicePlatform;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public c0 getEventInfo() {
        return this.eventInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getFanTicket() {
        return this.fanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean getHasExpired() {
        return this.hasExpired;
    }

    public final IBaseUser getInvitor() {
        return this.invitor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public IBaseUser getInvitorFlex() {
        return this.invitor;
    }

    public final TeamFightJoinTeamInfo getJoinTeamFightInfo() {
        return this.joinTeamFightInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public j0 getJoinTeamFightInfoFlex() {
        return this.joinTeamFightInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getLast7DaysGiftCountTxt() {
        return this.last7DaysGiftCountTxt;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getLinkmicId() {
        return this.linkmicId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getLinkmicIdStr() {
        return this.linkmicIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getListUserFromType() {
        return this.listUserFromType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getListUserType() {
        return this.listUserType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getMLinkStatus() {
        return this.mLinkStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getMLinkType() {
        return this.mLinkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getMRoleType() {
        return this.mRoleType;
    }

    public final MicPosTagInfo getMicPosTag() {
        return this.micPosTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public g0 getMicPosTagFlex() {
        return this.micPosTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getModifyTime() {
        return this.modifyTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getOffset() {
        return this.offset;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getOrderedSongCount() {
        return this.orderedSongCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getPaidAmount() {
        return this.paidAmount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getRank() {
        return this.rank;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getSilenceStatus() {
        return this.silenceStatus;
    }

    public final List<KtvMusic> getSongList() {
        return this.songList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public List<KtvMusic> getSongListFlex() {
        return this.songList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public ListUserTag getTag() {
        return this.tag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public List<v> getTags() {
        return this.tags;
    }

    public final IBaseUser getUser() {
        return this.user;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public IBaseUser getUserFlex() {
        return this.user;
    }

    public final UserHighScoreSongTag getUserHighScoreSongTag() {
        return this.userHighScoreSongTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public fc getUserHighScoreSongTagFlex() {
        return this.userHighScoreSongTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getUserPosition() {
        return this.userPosition;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isAddPrice() {
        return this.isAddPrice;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isHasApplied() {
        return this.isHasApplied;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isMutualFollow() {
        return this.isMutualFollow;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v31, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v39, types: [com.bytedance.android.live.liveinteract.plantform.model.c0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v43, types: [com.bytedance.android.live.liveinteract.plantform.model.ListUserTag, java.lang.Object] */
    public WaitingListUser(am3.g r5) {
        super(n0.class);
        this.songList = new ArrayList();
        this.tags = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L47;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L46;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L40;
            case 8: goto L39;
            case 9: goto L38;
            case 10: goto L36;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L33;
            case 14: goto L32;
            case 15: goto L31;
            case 16: goto L30;
            case 17: goto L29;
            case 18: goto L28;
            case 19: goto L27;
            case 20: goto L26;
            case 21: goto L25;
            case 22: goto L24;
            case 23: goto L23;
            case 24: goto L22;
            case 25: goto L7;
            case 26: goto L21;
            case 27: goto L20;
            case 28: goto L19;
            case 29: goto L18;
            case 30: goto L17;
            case 31: goto L16;
            case 32: goto L15;
            case 33: goto L14;
            case 34: goto L13;
            case 35: goto L12;
            case 36: goto L11;
            case 37: goto L10;
            case 38: goto L9;
            case 39: goto L8;
            default: goto L7;
        };
    L8:
        this.tag = vh7.f.a(r5, ListUserTag.class);
        goto L3
    L9:
        this.buttonText = am3.h.c(r5);
        goto L3
    L10:
        this.isActive = am3.h.a(r5);
        goto L3
    L11:
        this.eventInfo = vh7.f.a(r5, c0.class);
        goto L3
    L12:
        List<? extends v> r4 = this.tags;
        Object r6 = vh7.f.a(r5, v.class);
    L37:
        r4.add(r6);
        goto L3
    L13:
        this.orderedSongCount = r5.j();
        goto L3
    L14:
        this.alreadyInvited = am3.h.a(r5);
        goto L3
    L15:
        this.userHighScoreSongTag = new UserHighScoreSongTag(r5);
        goto L3
    L16:
        this.applyType = r5.i();
        goto L3
    L17:
        this.invitor = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L18:
        this.joinTeamFightInfo = q1.a(r5);
        goto L3
    L19:
        this.paidAmount = r5.j();
        goto L3
    L20:
        this.isAnonymous = am3.h.a(r5);
        goto L3
    L21:
        this.micPosTag = new MicPosTagInfo(r5);
        goto L3
    L22:
        this.addPriceTime = r5.j();
        goto L3
    L23:
        this.isAddPrice = am3.h.a(r5);
        goto L3
    L24:
        this.rank = r5.j();
        goto L3
    L25:
        this.offset = r5.j();
        goto L3
    L26:
        this.fanTicket = am3.h.c(r5);
        goto L3
    L27:
        this.last7DaysGiftCountTxt = am3.h.c(r5);
        goto L3
    L28:
        this.applyReason = am3.h.c(r5);
        goto L3
    L29:
        this.isMutualFollow = am3.h.a(r5);
        goto L3
    L30:
        this.hasExpired = am3.h.a(r5);
        goto L3
    L31:
        this.listUserFromType = r5.i();
        goto L3
    L32:
        this.listUserType = r5.i();
        goto L3
    L33:
        this.devicePlatform = am3.h.c(r5);
        goto L3
    L34:
        this.clientVersion = r5.j();
        goto L3
    L35:
        this.appId = r5.j();
        goto L3
    L36:
        r4 = this.songList;
        r6 = new KtvMusic(r5);
        goto L37
    L38:
        this.linkmicIdStr = am3.h.c(r5);
        goto L3
    L39:
        this.silenceStatus = r5.i();
        goto L3
    L40:
        this.userPosition = (int) r5.j();
        goto L3
    L41:
        this.mRoleType = r5.i();
        goto L3
    L42:
        this.mLinkType = r5.i();
        goto L3
    L43:
        this.mLinkStatus = r5.i();
        goto L3
    L44:
        this.modifyTime = r5.j();
        goto L3
    L45:
        this.linkmicId = r5.j();
        goto L3
    L46:
        this.user = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L47:
        r5.d(r0);
        setThreadSafe(true);
        if (this.linkmicIdStr != null) goto L51;
        this.linkmicIdStr = "";
    L51:
        if (this.devicePlatform != null) goto L54;
        this.devicePlatform = "";
    L54:
        if (this.buttonText != null) goto L136;
        this.buttonText = "";
        return;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if ((!Intrinsics.areEqual(WaitingListUser.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r8 == null) goto L105;
        n0 r9 = (n0) r8;
        if (isHasApplied() == r9.isHasApplied()) goto L16;
    L19:
        IBaseUser r1 = this.user;
        if (r1 != null) goto L22;
    L77:
        MicPosTagInfo r3 = this.micPosTag;
        if (r3 != null) goto L80;
    L85:
        IBaseUser r4 = this.invitor;
        if (r4 == null) goto L97;
        Intrinsics.checkNotNull(r4);
        if (Intrinsics.areEqual(r4, r9.getInvitorFlex()) == false) goto L97;
        if (getApplyType() != r9.getApplyType()) goto L97;
        if (getPaidAmount() != r9.getPaidAmount()) goto L97;
        if (this.joinTeamFightInfo != null) goto L97;
        if (r9.getJoinTeamFightInfoFlex() != null) goto L97;
        return true;
    L97:
        TeamFightJoinTeamInfo r5 = this.joinTeamFightInfo;
        if (r5 != null) goto L100;
    L102:
        return false;
    L100:
        if (Intrinsics.areEqual(r5, r9.getJoinTeamFightInfoFlex()) == false) goto L102;
        return true;
    L80:
        if (Intrinsics.areEqual(r3, r9.getMicPosTagFlex()) == false) goto L85;
        if (this.invitor != null) goto L85;
        if (r9.getInvitorFlex() != null) goto L85;
        return true;
    L22:
        if (Intrinsics.areEqual(r1, r9.getUserFlex()) == false) goto L77;
        if (getLinkmicId() != r9.getLinkmicId()) goto L77;
        if (getModifyTime() != r9.getModifyTime()) goto L77;
        if (getMLinkStatus() != r9.getMLinkStatus()) goto L77;
        if (getMLinkType() != r9.getMLinkType()) goto L77;
        if (getMRoleType() != r9.getMRoleType()) goto L77;
        if (getUserPosition() != r9.getUserPosition()) goto L77;
        if (getSilenceStatus() != r9.getSilenceStatus()) goto L77;
        if (Intrinsics.areEqual(getLinkmicIdStr(), r9.getLinkmicIdStr()) == false) goto L77;
        if (isSameKtvMusic(r9.getSongListFlex()) == false) goto L77;
        if (getOrderedSongCount() != r9.getOrderedSongCount()) goto L77;
        if (getAppId() != r9.getAppId()) goto L77;
        if (getClientVersion() != r9.getClientVersion()) goto L77;
        if (Intrinsics.areEqual(getDevicePlatform(), r9.getDevicePlatform()) == false) goto L77;
        if (getListUserType() != r9.getListUserType()) goto L77;
        if (getListUserFromType() != r9.getListUserFromType()) goto L77;
        if (getHasExpired() != r9.getHasExpired()) goto L77;
        if (isMutualFollow() != r9.isMutualFollow()) goto L77;
        if (TextUtils.equals(getApplyReason(), r9.getApplyReason()) == false) goto L77;
        if (TextUtils.equals(getLast7DaysGiftCountTxt(), r9.getLast7DaysGiftCountTxt()) == false) goto L77;
        if (TextUtils.equals(getFanTicket(), r9.getFanTicket()) == false) goto L77;
        if (getOffset() != r9.getOffset()) goto L77;
        if (getRank() != r9.getRank()) goto L77;
        if (isAddPrice() != r9.isAddPrice()) goto L77;
        if (getAddPriceTime() != r9.getAddPriceTime()) goto L77;
        if (isAnonymous() != r9.isAnonymous()) goto L77;
        if (this.micPosTag != null) goto L77;
        if (r9.getMicPosTagFlex() != null) goto L77;
        return true;
    L16:
        if (this.user != null) goto L19;
        if (r9.getUserFlex() != null) goto L19;
        return true;
    L105:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.IWaitingListUser");
    L8:
        r2 = null;
        goto L10
    }

    public final boolean isSameKtvMusic(List<KtvMusic> r7) {
        List<KtvMusic> r0 = this.songList;
        if (r0 != null) goto L7;
        if (r7 != null) goto L7;
        return true;
    L7:
        if (r0 == null) goto L17;
        if (r7 == null) goto L17;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.size();
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L16;
        List<KtvMusic> r4 = this.songList;
        Intrinsics.checkNotNull(r4);
        if (((KtvMusic) ListProtector.get(r4, r3)).isSameKtvMusic((KtvMusic) ListProtector.get(r7, r3)) == false) goto L14;
        r3 = r3 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L17:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setActive(boolean r1) {
        this.isActive = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAddPrice(boolean r1) {
        this.isAddPrice = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAddPriceTime(long r1) {
        this.addPriceTime = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAlreadyInvited(boolean r1) {
        this.alreadyInvited = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAppId(long r1) {
        this.appId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setApplyReason(String r1) {
        this.applyReason = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setApplyType(int r1) {
        this.applyType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setButtonText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.buttonText = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setClientVersion(long r1) {
        this.clientVersion = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setDevicePlatform(String r1) {
        this.devicePlatform = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setEventInfo(c0 r1) {
        this.eventInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setEventInfoFlex(c0 r1) {
        setEventInfo((ListUserEventInfo) r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setFanTicket(String r1) {
        this.fanTicket = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setHasApplied(boolean r1) {
        this.isHasApplied = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setHasExpired(boolean r1) {
        this.hasExpired = r1;
    }

    public final void setInvitor(IBaseUser r1) {
        this.invitor = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setInvitorFlex(IBaseUser r2) {
        if (r2 == null) goto L6;
        this.invitor = r2;
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    }

    public final void setJoinTeamFightInfo(TeamFightJoinTeamInfo r1) {
        this.joinTeamFightInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setJoinTeamFightInfoFlex(j0 r2) {
        if ((r2 instanceof TeamFightJoinTeamInfo) == true) goto L5;
        r2 = null;
    L5:
        this.joinTeamFightInfo = (TeamFightJoinTeamInfo) r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setLast7DaysGiftCountTxt(String r1) {
        this.last7DaysGiftCountTxt = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setLinkmicId(long r1) {
        this.linkmicId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setLinkmicIdStr(String r1) {
        this.linkmicIdStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setListUserFromType(int r1) {
        this.listUserFromType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setListUserType(int r1) {
        this.listUserType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMLinkStatus(int r1) {
        this.mLinkStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMLinkType(int r1) {
        this.mLinkType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMRoleType(int r1) {
        this.mRoleType = r1;
    }

    public final void setMicPosTag(MicPosTagInfo r1) {
        this.micPosTag = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMicPosTagFlex(g0 r2) {
        if (r2 == null) goto L6;
        this.micPosTag = (MicPosTagInfo) r2;
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setModifyTime(long r1) {
        this.modifyTime = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMutualFollow(boolean r1) {
        this.isMutualFollow = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setOffset(long r1) {
        this.offset = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setOrderedSongCount(long r1) {
        this.orderedSongCount = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setPaidAmount(long r1) {
        this.paidAmount = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setRank(long r1) {
        this.rank = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setSilenceStatus(int r1) {
        this.silenceStatus = r1;
    }

    public final void setSongList(List<KtvMusic> r1) {
        this.songList = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setSongListFlex(List<KtvMusic> r1) {
        this.songList = KotlinTypeUtilsKt.castElementType(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setTag(ListUserTag r1) {
        this.tag = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setTags(List<? extends v> r1) {
        this.tags = r1;
    }

    public final void setUser(IBaseUser r1) {
        this.user = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setUserFlex(IBaseUser r1) {
        this.user = r1;
    }

    public final void setUserHighScoreSongTag(UserHighScoreSongTag r1) {
        this.userHighScoreSongTag = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setUserHighScoreSongTagFlex(fc r2) {
        if ((r2 instanceof UserHighScoreSongTag) == true) goto L5;
        r2 = null;
    L5:
        this.userHighScoreSongTag = (UserHighScoreSongTag) r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setUserPosition(int r1) {
        this.userPosition = r1;
    }
}
