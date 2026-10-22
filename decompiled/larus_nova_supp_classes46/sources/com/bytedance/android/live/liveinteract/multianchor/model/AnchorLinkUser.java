package com.bytedance.android.live.liveinteract.multianchor.model;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MatchEffect;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\t¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R$\u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010+\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R$\u00106\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0013\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R\"\u00109\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010+\u001a\u0004\b@\u0010-\"\u0004\bA\u0010/R$\u0010B\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0013\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R$\u0010E\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0013\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010%\u001a\u0004\bI\u0010'\"\u0004\bJ\u0010)R$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010`\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010[\u001a\u0004\ba\u0010]\"\u0004\bb\u0010_R$\u0010c\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bc\u0010\u001c\u001a\u0004\bd\u0010\u001e\"\u0004\be\u0010 R$\u0010g\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010n\u001a\u0004\u0018\u00010m8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010u\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR*\u0010\u0081\u0001\u001a\u0004\u0018\u00010{2\b\u0010|\u001a\u0004\u0018\u00010{8V@VX\u0096\u000e¢\u0006\r\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u0004\u0018\u00010{8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010~R2\u0010\u0088\u0001\u001a\u00070\u0011j\u0003`\u0084\u00012\f\u0010\u0085\u0001\u001a\u00070\u0011j\u0003`\u0084\u00018V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010<\"\u0005\b\u0087\u0001\u0010>R,\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010\u001e\"\u0005\b\u008a\u0001\u0010 R\u0013\u0010\u008d\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u001eR,\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010\u001e\"\u0005\b\u008f\u0001\u0010 R(\u0010\u0093\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010'\"\u0005\b\u0092\u0001\u0010)R(\u0010\u0096\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010'\"\u0005\b\u0095\u0001\u0010)R(\u0010\u0099\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010'\"\u0005\b\u0098\u0001\u0010)R(\u0010\u009c\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u0010'\"\u0005\b\u009b\u0001\u0010)R2\u0010\u009f\u0001\u001a\u00070\u0011j\u0003`\u0084\u00012\f\u0010\u0085\u0001\u001a\u00070\u0011j\u0003`\u0084\u00018V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009d\u0001\u0010<\"\u0005\b\u009e\u0001\u0010>R(\u0010¢\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b \u0001\u0010'\"\u0005\b¡\u0001\u0010)R2\u0010¥\u0001\u001a\u00070\u0011j\u0003`\u0084\u00012\f\u0010\u0085\u0001\u001a\u00070\u0011j\u0003`\u0084\u00018V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b£\u0001\u0010<\"\u0005\b¤\u0001\u0010>R2\u0010¦\u0001\u001a\u00070\u0011j\u0003`\u0084\u00012\f\u0010\u0085\u0001\u001a\u00070\u0011j\u0003`\u0084\u00018V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¦\u0001\u0010<\"\u0005\b§\u0001\u0010>R(\u0010ª\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010'\"\u0005\b©\u0001\u0010)R0\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00012\n\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R0\u0010²\u0001\u001a\u0005\u0018\u00010±\u00012\n\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R(\u0010¹\u0001\u001a\u00020Y2\u0007\u0010\u0085\u0001\u001a\u00020Y8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b·\u0001\u0010]\"\u0005\b¸\u0001\u0010_R(\u0010º\u0001\u001a\u00020Y2\u0007\u0010\u0085\u0001\u001a\u00020Y8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bº\u0001\u0010]\"\u0005\b»\u0001\u0010_R0\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R0\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R,\u0010È\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010È\u0001\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÉ\u0001\u0010\u001e\"\u0005\bÊ\u0001\u0010 R\u0017\u0010Î\u0001\u001a\u0005\u0018\u00010Ë\u00018F¢\u0006\b\u001a\u0006\bÌ\u0001\u0010Í\u0001¨\u0006Ñ\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "", "getPkRole", "getAnchorAuthRole", "", "toString", "toSimpleString", "Lcom/bytedance/android/live/base/model/user/User;", "mUser", "Lcom/bytedance/android/live/base/model/user/User;", "getMUser", "()Lcom/bytedance/android/live/base/model/user/User;", "setMUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "", "kSongUid", "Ljava/lang/Long;", "getKSongUid", "()Ljava/lang/Long;", "setKSongUid", "(Ljava/lang/Long;)V", "mLinkmicId", "getMLinkmicId", "setMLinkmicId", "mLinkmicIdStr", "Ljava/lang/String;", "getMLinkmicIdStr", "()Ljava/lang/String;", "setMLinkmicIdStr", "(Ljava/lang/String;)V", "mLinkmicUniqueIdStr", "getMLinkmicUniqueIdStr", "setMLinkmicUniqueIdStr", "mStatus", "I", "getMStatus", "()I", "setMStatus", "(I)V", "mLinkType", "Ljava/lang/Integer;", "getMLinkType", "()Ljava/lang/Integer;", "setMLinkType", "(Ljava/lang/Integer;)V", "mUserPosition", "getMUserPosition", "setMUserPosition", "mSilenceStatus", "getMSilenceStatus", "setMSilenceStatus", "mModifyTime", "getMModifyTime", "setMModifyTime", "mLinkerId", "J", "getMLinkerId", "()J", "setMLinkerId", "(J)V", "mRoleType", "getMRoleType", "setMRoleType", "mMcStatus", "getMMcStatus", "setMMcStatus", "mIsBackground", "getMIsBackground", "setMIsBackground", "mApplyType", "getMApplyType", "setMApplyType", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MatchEffect;", "mMatchEffect", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MatchEffect;", "getMMatchEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MatchEffect;", "setMMatchEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MatchEffect;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CityEffect;", "mCityEffect", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CityEffect;", "getMCityEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CityEffect;", "setMCityEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CityEffect;)V", "", "mShowCityEffect", "Z", "getMShowCityEffect", "()Z", "setMShowCityEffect", "(Z)V", "mIsJoinUser", "getMIsJoinUser", "setMIsJoinUser", "extra", "getExtra", "setExtra", "Lcom/bytedance/android/live/liveinteract/multianchor/model/ListUserContent;", "mContent", "Lcom/bytedance/android/live/liveinteract/multianchor/model/ListUserContent;", "getMContent", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/ListUserContent;", "setMContent", "(Lcom/bytedance/android/live/liveinteract/multianchor/model/ListUserContent;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "micPosTagInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "getMicPosTagInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "setMicPosTagInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g0;)V", "Lcom/bytedance/android/live/liveinteract/multianchor/model/ListUserExtra;", "mListUserExtra", "Lcom/bytedance/android/live/liveinteract/multianchor/model/ListUserExtra;", "getMListUserExtra", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/ListUserExtra;", "setMListUserExtra", "(Lcom/bytedance/android/live/liveinteract/multianchor/model/ListUserExtra;)V", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "iBaseUser", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "getBaseUser", "baseUser", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "value", "getLinkMicId", "setLinkMicId", "linkMicId", "getLinkMicIdStr", "setLinkMicIdStr", "linkMicIdStr", "getLinkmicIdStr", "linkmicIdStr", "getLinkMicUniqueIdStr", "setLinkMicUniqueIdStr", "linkMicUniqueIdStr", "getStatus", "setStatus", "status", "getLinkType", "setLinkType", "linkType", "getUserPosition", "setUserPosition", "userPosition", "getSilenceStatus", "setSilenceStatus", "silenceStatus", "getModifyTime", "setModifyTime", "modifyTime", "getRoleType", "setRoleType", "roleType", "getMcStatus", "setMcStatus", "mcStatus", "isBackground", "setBackground", "getApplyType", "setApplyType", "applyType", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "matchEffect", "getMatchEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "setMatchEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "cityEffect", "getCityEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "setCityEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;)V", "getShowCityEffect", "setShowCityEffect", "showCityEffect", "isJoinUser", "setJoinUser", "Lcom/bytedance/android/livesdk/link/model/bridge/k1;", "content", "getContent", "()Lcom/bytedance/android/livesdk/link/model/bridge/k1;", "setContent", "(Lcom/bytedance/android/livesdk/link/model/bridge/k1;)V", "Lcom/bytedance/android/live/liveinteract/multianchor/model/c;", "listUserExtra", "getListUserExtra", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/c;", "setListUserExtra", "(Lcom/bytedance/android/live/liveinteract/multianchor/model/c;)V", "interactId", "getInteractId", "setInteractId", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkMicIdInfo;", "getAnchorLinkMicIdInfo", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkMicIdInfo;", "anchorLinkMicIdInfo", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkUser extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.k> implements com.bytedance.android.live.liveinteract.plantform.base.h, com.bytedance.android.livesdk.link.model.bridge.k, vh7.h {

    @SerializedName("extra")
    protected String extra;

    @SerializedName("k_song_uid")
    protected Long kSongUid;
    private transient int mApplyType;
    private transient CityEffect mCityEffect;

    @SerializedName("content")
    protected ListUserContent mContent;

    @SerializedName("is_background")
    protected Long mIsBackground;
    private transient boolean mIsJoinUser;

    @SerializedName("link_type")
    protected Integer mLinkType;

    @SerializedName("linker_id")
    protected long mLinkerId;

    @SerializedName("linkmic_id")
    protected Long mLinkmicId;

    @SerializedName("linkmic_id_str")
    protected String mLinkmicIdStr;

    @SerializedName("linkmic_unique_id")
    protected String mLinkmicUniqueIdStr;

    @IgnoreProtoFieldCheck
    private transient ListUserExtra mListUserExtra;
    private transient MatchEffect mMatchEffect;

    @SerializedName("mc_status")
    protected Long mMcStatus;

    @SerializedName("modify_time")
    protected Long mModifyTime;

    @SerializedName("role_type")
    protected Integer mRoleType;
    private transient boolean mShowCityEffect;

    @SerializedName("silence_status")
    protected Integer mSilenceStatus;

    @SerializedName("link_status")
    protected int mStatus;

    @SerializedName("user")
    protected User mUser;

    @SerializedName("user_position")
    protected int mUserPosition;

    @SerializedName("mic_pos_tag_info")
    protected g0 micPosTagInfo;

    public AnchorLinkUser() {
        super(com.bytedance.android.livesdk.link.model.bridge.k.class);
        this.kSongUid = 0L;
        this.mLinkmicId = 0L;
        this.mLinkmicUniqueIdStr = "";
        this.mLinkType = 0;
        this.mSilenceStatus = 0;
        this.mModifyTime = 0L;
        this.mRoleType = 0;
        this.mMcStatus = 0L;
        this.mIsBackground = 0L;
    }

    public int getAnchorAuthRole() {
        ListUserContent r0 = this.mContent;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.linkmicContent == null) goto L8;
        ListUserContent r1 = this.mContent;
        Intrinsics.checkNotNull(r1);
        return r1.linkmicContent.anchorAuthRole;
    L8:
        return ListUserLinkmicContent.AnchorAuthRole.AnchorAuthRoleGeneral.ordinal();
    }

    public final AnchorLinkMicIdInfo getAnchorLinkMicIdInfo() {
        ListUserContent r0 = this.mContent;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        if (r0.linkmicContent == null) goto L7;
        ListUserContent r1 = this.mContent;
        Intrinsics.checkNotNull(r1);
        return r1.linkmicContent.mAnchorLinkMicIdInfo;
    L7:
        return null;
    }

    public String getInteractId() {
        if (TextUtils.isEmpty(this.mLinkmicIdStr) == false) goto L6;
        return String.valueOf(getLinkMicId());
    L6:
        return this.mLinkmicIdStr;
    }

    public long getLinkMicId() {
        return this.mLinkmicId.longValue();
    }

    public int getLinkType() {
        return this.mLinkType.intValue();
    }

    public long getMcStatus() {
        return this.mMcStatus.longValue();
    }

    public long getModifyTime() {
        return this.mModifyTime.longValue();
    }

    public int getPkRole() {
        ListUserContent r0 = this.mContent;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        if (r0.linkmicContent == null) goto L7;
        ListUserContent r1 = this.mContent;
        Intrinsics.checkNotNull(r1);
        return r1.linkmicContent.role;
    L7:
        return 0;
    }

    public int getRoleType() {
        return this.mRoleType.intValue();
    }

    public int getSilenceStatus() {
        return this.mSilenceStatus.intValue();
    }

    public long isBackground() {
        return this.mIsBackground.longValue();
    }

    public String toSimpleString() {
        StringBuilder r0 = new StringBuilder("LinkUser{uid=");
        User r1 = this.mUser;
        if (r1 == null) goto L5;
        String r2 = r1.getIdString();
    L6:
        r0.append(r2);
        r0.append(",room=");
        User r3 = this.mUser;
        if (r3 == null) goto L9;
        long r4 = r3.getLiveRoomId();
    L10:
        r0.append(r4);
        r0.append(",link_id='");
        r0.append(this.mLinkmicIdStr);
        r0.append("',status=");
        r0.append(getStatus());
        r0.append('}');
        return r0.toString();
    L9:
        r4 = -1;
        goto L10
    L5:
        r2 = "0";
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AnchorLinkUser{mLinkmicId=");
        r0.append(getLinkMicId());
        r0.append(", nickName=");
        User r1 = this.mUser;
        if (r1 == null) goto L5;
        String r2 = r1.getNickName();
    L6:
        r0.append(r2);
        r0.append(", mLinkType=");
        r0.append(getLinkType());
        r0.append(", mSilenceStatus=");
        r0.append(getSilenceStatus());
        r0.append(", mLinkmicIdStr='");
        r0.append(this.mLinkmicIdStr);
        r0.append("', mRoleType=");
        r0.append(getRoleType());
        r0.append(", isBackground=");
        r0.append(isBackground());
        r0.append('}');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public int getApplyType() {
        return this.mApplyType;
    }

    public IBaseUser getBaseUser() {
        return this.mUser;
    }

    public ICityEffect getCityEffect() {
        return this.mCityEffect;
    }

    public k1 getContent() {
        return this.mContent;
    }

    public String getExtra() {
        return this.extra;
    }

    public Long getKSongUid() {
        return this.kSongUid;
    }

    public String getLinkMicIdStr() {
        return this.mLinkmicIdStr;
    }

    public String getLinkMicUniqueIdStr() {
        return this.mLinkmicUniqueIdStr;
    }

    public final String getLinkmicIdStr() {
        return this.mLinkmicIdStr;
    }

    public c getListUserExtra() {
        return this.mListUserExtra;
    }

    public final int getMApplyType() {
        return this.mApplyType;
    }

    public final CityEffect getMCityEffect() {
        return this.mCityEffect;
    }

    public final ListUserContent getMContent() {
        return this.mContent;
    }

    public final Long getMIsBackground() {
        return this.mIsBackground;
    }

    public final boolean getMIsJoinUser() {
        return this.mIsJoinUser;
    }

    public final Integer getMLinkType() {
        return this.mLinkType;
    }

    public final long getMLinkerId() {
        return this.mLinkerId;
    }

    public final Long getMLinkmicId() {
        return this.mLinkmicId;
    }

    public final String getMLinkmicIdStr() {
        return this.mLinkmicIdStr;
    }

    public final String getMLinkmicUniqueIdStr() {
        return this.mLinkmicUniqueIdStr;
    }

    public final ListUserExtra getMListUserExtra() {
        return this.mListUserExtra;
    }

    public final MatchEffect getMMatchEffect() {
        return this.mMatchEffect;
    }

    public final Long getMMcStatus() {
        return this.mMcStatus;
    }

    public final Long getMModifyTime() {
        return this.mModifyTime;
    }

    public final Integer getMRoleType() {
        return this.mRoleType;
    }

    public final boolean getMShowCityEffect() {
        return this.mShowCityEffect;
    }

    public final Integer getMSilenceStatus() {
        return this.mSilenceStatus;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final User getMUser() {
        return this.mUser;
    }

    public final int getMUserPosition() {
        return this.mUserPosition;
    }

    public IMatchEffect getMatchEffect() {
        return this.mMatchEffect;
    }

    public g0 getMicPosTagInfo() {
        return this.micPosTagInfo;
    }

    public boolean getShowCityEffect() {
        return this.mShowCityEffect;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public IBaseUser getUser() {
        return this.mUser;
    }

    public int getUserPosition() {
        return this.mUserPosition;
    }

    public boolean isJoinUser() {
        return this.mIsJoinUser;
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [com.bytedance.android.live.liveinteract.plantform.model.g0, java.lang.Object] */
    public AnchorLinkUser(am3.g r7) {
        super(com.bytedance.android.livesdk.link.model.bridge.k.class);
        setThreadSafe(false);
        long r2 = r7.c();
    L3:
        int r0 = r7.f();
        if (r0 == (-1)) goto L32;
        am3.g.a r4 = decodeExtensionFields(r0, r7);
        if (r0 != 15) goto L8;
        this.micPosTagInfo = vh7.f.a(r7, g0.class);
        goto L3
    L8:
        if (r0 != 200) goto L10;
        this.extra = am3.h.c(r7);
        goto L3
    L10:
        if (r0 != 17) goto L12;
        this.mLinkmicUniqueIdStr = am3.h.c(r7);
        goto L3
    L12:
        if (r0 != 18) goto L13;
        this.kSongUid = Long.valueOf(r7.j());
        goto L3
    L13:
        switch(r0) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            default: goto L14;
        };
    L15:
        this.mIsBackground = Long.valueOf(r7.j());
        goto L3
    L16:
        this.mMcStatus = Long.valueOf(r7.j());
        goto L3
    L17:
        this.mContent = j.a(r7);
        goto L3
    L18:
        this.mRoleType = Integer.valueOf(r7.i());
        goto L3
    L19:
        this.mLinkerId = r7.j();
        goto L3
    L20:
        this.mModifyTime = Long.valueOf(r7.j());
        goto L3
    L21:
        this.mSilenceStatus = Integer.valueOf(r7.i());
        goto L3
    L22:
        this.mUserPosition = r7.i();
        goto L3
    L23:
        this.mLinkType = Integer.valueOf(r7.i());
        goto L3
    L24:
        this.mStatus = r7.i();
        goto L3
    L25:
        this.mLinkmicIdStr = am3.h.c(r7);
        goto L3
    L26:
        this.mLinkmicId = Long.valueOf(r7.j());
        goto L3
    L27:
        this.mUser = new User(r7);
        goto L3
    L14:
        am3.h.d(r4, r7);
        goto L3
    L32:
        r7.d(r2);
        setThreadSafe(true);
        if (this.kSongUid != null) goto L36;
        this.kSongUid = 0L;
    L36:
        if (this.mLinkmicId != null) goto L39;
        this.mLinkmicId = 0L;
    L39:
        if (this.mLinkmicUniqueIdStr != null) goto L42;
        this.mLinkmicUniqueIdStr = "";
    L42:
        if (this.mLinkType != null) goto L45;
        this.mLinkType = 0;
    L45:
        if (this.mSilenceStatus != null) goto L48;
        this.mSilenceStatus = 0;
    L48:
        if (this.mModifyTime != null) goto L51;
        this.mModifyTime = 0L;
    L51:
        if (this.mRoleType != null) goto L54;
        this.mRoleType = 0;
    L54:
        if (this.mMcStatus != null) goto L57;
        this.mMcStatus = 0L;
    L57:
        if (this.mIsBackground != null) goto L102;
        this.mIsBackground = 0L;
        return;
    }

    public void setApplyType(int r1) {
        this.mApplyType = r1;
    }

    public void setBackground(long r1) {
        this.mIsBackground = Long.valueOf(r1);
    }

    public void setCityEffect(ICityEffect r2) {
        if ((r2 instanceof CityEffect) == true) goto L5;
        r2 = null;
    L5:
        this.mCityEffect = (CityEffect) r2;
    }

    public void setContent(k1 r2) {
        if ((r2 instanceof ListUserContent) == true) goto L5;
        r2 = null;
    L5:
        this.mContent = (ListUserContent) r2;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setInteractId(String r1) {
        this.mLinkmicIdStr = r1;
    }

    public void setJoinUser(boolean r1) {
        this.mIsJoinUser = r1;
    }

    public void setKSongUid(Long r1) {
        this.kSongUid = r1;
    }

    public void setLinkMicId(long r1) {
        this.mLinkmicId = Long.valueOf(r1);
    }

    public void setLinkMicIdStr(String r1) {
        this.mLinkmicIdStr = r1;
    }

    public void setLinkMicUniqueIdStr(String r1) {
        this.mLinkmicUniqueIdStr = r1;
    }

    public void setLinkType(int r1) {
        this.mLinkType = Integer.valueOf(r1);
    }

    public void setListUserExtra(c r2) {
        vh7.c r3 = jm2.a.d(r2);
        if ((r3 instanceof ListUserExtra) == true) goto L5;
        r3 = null;
    L5:
        this.mListUserExtra = (ListUserExtra) r3;
    }

    public final void setMApplyType(int r1) {
        this.mApplyType = r1;
    }

    public final void setMCityEffect(CityEffect r1) {
        this.mCityEffect = r1;
    }

    public final void setMContent(ListUserContent r1) {
        this.mContent = r1;
    }

    public final void setMIsBackground(Long r1) {
        this.mIsBackground = r1;
    }

    public final void setMIsJoinUser(boolean r1) {
        this.mIsJoinUser = r1;
    }

    public final void setMLinkType(Integer r1) {
        this.mLinkType = r1;
    }

    public final void setMLinkerId(long r1) {
        this.mLinkerId = r1;
    }

    public final void setMLinkmicId(Long r1) {
        this.mLinkmicId = r1;
    }

    public final void setMLinkmicIdStr(String r1) {
        this.mLinkmicIdStr = r1;
    }

    public final void setMLinkmicUniqueIdStr(String r1) {
        this.mLinkmicUniqueIdStr = r1;
    }

    public final void setMListUserExtra(ListUserExtra r1) {
        this.mListUserExtra = r1;
    }

    public final void setMMatchEffect(MatchEffect r1) {
        this.mMatchEffect = r1;
    }

    public final void setMMcStatus(Long r1) {
        this.mMcStatus = r1;
    }

    public final void setMModifyTime(Long r1) {
        this.mModifyTime = r1;
    }

    public final void setMRoleType(Integer r1) {
        this.mRoleType = r1;
    }

    public final void setMShowCityEffect(boolean r1) {
        this.mShowCityEffect = r1;
    }

    public final void setMSilenceStatus(Integer r1) {
        this.mSilenceStatus = r1;
    }

    public final void setMStatus(int r1) {
        this.mStatus = r1;
    }

    public final void setMUser(User r1) {
        this.mUser = r1;
    }

    public final void setMUserPosition(int r1) {
        this.mUserPosition = r1;
    }

    public void setMatchEffect(IMatchEffect r2) {
        if ((r2 instanceof MatchEffect) == true) goto L5;
        r2 = null;
    L5:
        this.mMatchEffect = (MatchEffect) r2;
    }

    public void setMcStatus(long r1) {
        this.mMcStatus = Long.valueOf(r1);
    }

    public void setMicPosTagInfo(g0 r1) {
        this.micPosTagInfo = r1;
    }

    public void setModifyTime(long r1) {
        this.mModifyTime = Long.valueOf(r1);
    }

    public void setRoleType(int r1) {
        this.mRoleType = Integer.valueOf(r1);
    }

    public void setShowCityEffect(boolean r1) {
        this.mShowCityEffect = r1;
    }

    public void setSilenceStatus(int r1) {
        this.mSilenceStatus = Integer.valueOf(r1);
    }

    public void setStatus(int r1) {
        this.mStatus = r1;
    }

    public void setUser(IBaseUser r2) {
        if ((r2 instanceof User) == true) goto L5;
        r2 = null;
    L5:
        this.mUser = (User) r2;
    }

    public void setUserPosition(int r1) {
        this.mUserPosition = r1;
    }
}
