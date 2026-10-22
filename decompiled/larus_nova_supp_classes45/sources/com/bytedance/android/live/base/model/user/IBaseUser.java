package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.model.user.api.IAnchorLevel;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u0000 ê\u00012\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u00032\u00020\u0002:\u0006ë\u0001ì\u0001í\u0001R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR*\u0010\u001b\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\n\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\"\u0010-\u001a\u00020'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\n\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00101\u001a\u00020'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\n\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\"\u00108\u001a\u0002028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\n\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010<\u001a\u0002028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\n\u001a\u0004\b9\u00104\"\u0004\b:\u00106R$\u0010@\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b?\u0010\n\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR$\u0010D\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\bC\u0010\n\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\"\u0010K\u001a\u00020E8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bJ\u0010\n\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010O\u001a\u00020E8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bN\u0010\n\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR$\u0010S\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\bR\u0010\n\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\"\u0010W\u001a\u00020E8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bV\u0010\n\u001a\u0004\bT\u0010G\"\u0004\bU\u0010IR.\u0010]\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010Xj\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`Y8&X§\u0004¢\u0006\f\u0012\u0004\b\\\u0010\n\u001a\u0004\bZ\u0010[R\"\u0010^\u001a\u00020'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b`\u0010\n\u001a\u0004\b^\u0010)\"\u0004\b_\u0010+R$\u0010d\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\bc\u0010\n\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\"\u0010h\u001a\u00020E8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bg\u0010\n\u001a\u0004\be\u0010G\"\u0004\bf\u0010IR.\u0010k\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010Xj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`Y8&X§\u0004¢\u0006\f\u0012\u0004\bj\u0010\n\u001a\u0004\bi\u0010[R$\u0010o\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\bn\u0010\n\u001a\u0004\bl\u0010\u0006\"\u0004\bm\u0010\bR$\u0010s\u001a\u0004\u0018\u00010\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\br\u0010\n\u001a\u0004\bp\u0010\u0017\"\u0004\bq\u0010\u0019R$\u0010w\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\bv\u0010\n\u001a\u0004\bt\u0010\u0006\"\u0004\bu\u0010\bR\"\u0010{\u001a\u00020E8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bz\u0010\n\u001a\u0004\bx\u0010G\"\u0004\by\u0010IR\u001d\u0010\u0080\u0001\u001a\u0004\u0018\u00010|8&X§\u0004¢\u0006\f\u0012\u0004\b\u007f\u0010\n\u001a\u0004\b}\u0010~R2\u0010\u0088\u0001\u001a\f\u0018\u00010\u0081\u0001j\u0005\u0018\u0001`\u0082\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u0087\u0001\u0010\n\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R+\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0089\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u008e\u0001\u0010\n\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R+\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0090\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u0095\u0001\u0010\n\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R+\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0097\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u009c\u0001\u0010\n\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R+\u0010¤\u0001\u001a\u0005\u0018\u00010\u009e\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b£\u0001\u0010\n\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R&\u0010¨\u0001\u001a\u00020E8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b§\u0001\u0010\n\u001a\u0005\b¥\u0001\u0010G\"\u0005\b¦\u0001\u0010IR(\u0010¬\u0001\u001a\u0004\u0018\u00010\u00148&@&X§\u000e¢\u0006\u0015\u0012\u0005\b«\u0001\u0010\n\u001a\u0005\b©\u0001\u0010\u0017\"\u0005\bª\u0001\u0010\u0019R+\u0010³\u0001\u001a\u0005\u0018\u00010\u00ad\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b²\u0001\u0010\n\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R1\u0010¶\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010Xj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`Y8&X§\u0004¢\u0006\u000e\u0012\u0005\bµ\u0001\u0010\n\u001a\u0005\b´\u0001\u0010[R&\u0010º\u0001\u001a\u00020E8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b¹\u0001\u0010\n\u001a\u0005\b·\u0001\u0010G\"\u0005\b¸\u0001\u0010IR&\u0010»\u0001\u001a\u00020'8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b½\u0001\u0010\n\u001a\u0005\b»\u0001\u0010)\"\u0005\b¼\u0001\u0010+R&\u0010Á\u0001\u001a\u0002028&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÀ\u0001\u0010\n\u001a\u0005\b¾\u0001\u00104\"\u0005\b¿\u0001\u00106R&\u0010Å\u0001\u001a\u0002028&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÄ\u0001\u0010\n\u001a\u0005\bÂ\u0001\u00104\"\u0005\bÃ\u0001\u00106R(\u0010É\u0001\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÈ\u0001\u0010\n\u001a\u0005\bÆ\u0001\u0010\u0006\"\u0005\bÇ\u0001\u0010\bR+\u0010Ð\u0001\u001a\u0005\u0018\u00010Ê\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\bÏ\u0001\u0010\n\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R+\u0010×\u0001\u001a\u0005\u0018\u00010Ñ\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\bÖ\u0001\u0010\n\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R+\u0010Þ\u0001\u001a\u0005\u0018\u00010Ø\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\bÝ\u0001\u0010\n\u001a\u0006\bÙ\u0001\u0010Ú\u0001\"\u0006\bÛ\u0001\u0010Ü\u0001R+\u0010å\u0001\u001a\u0005\u0018\u00010ß\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\bä\u0001\u0010\n\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R(\u0010é\u0001\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0015\u0012\u0005\bè\u0001\u0010\n\u001a\u0005\bæ\u0001\u0010\u0006\"\u0005\bç\u0001\u0010\b¨\u0006î\u0001"}, d2 = {"Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lvh7/c;", "", "Lcom/bytedance/android/live/base/model/user/l;", "", "getSafeNicName", "()Ljava/lang/String;", "setSafeNicName", "(Ljava/lang/String;)V", "getSafeNicName$annotations", "()V", "safeNicName", "getIdString", "setIdString", "getIdString$annotations", "idString", "getNickName", "setNickName", "getNickName$annotations", "nickName", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatarThumbKt", "()Lpy/k;", "setAvatarThumbKt", "(Lpy/k;)V", "getAvatarThumbKt$annotations", "avatarThumbKt", "Lpy/j;", "Lcom/bytedance/android/live/api/IFollowInfoKt;", "getFollowInfo", "()Lpy/j;", "getFollowInfo$annotations", "followInfo", "Lcom/bytedance/android/live/base/model/user/e;", "getBottomEntry", "()Lcom/bytedance/android/live/base/model/user/e;", "getBottomEntry$annotations", "bottomEntry", "", "getEnableShowCommerceSale", "()Z", "setEnableShowCommerceSale", "(Z)V", "getEnableShowCommerceSale$annotations", "enableShowCommerceSale", "getEnableCarManagementPermission", "setEnableCarManagementPermission", "getEnableCarManagementPermission$annotations", "enableCarManagementPermission", "", "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "getFanTicketCount$annotations", "fanTicketCount", "getShortId", "setShortId", "getShortId$annotations", "shortId", "getDisplayId", "setDisplayId", "getDisplayId$annotations", "displayId", "getCity", "setCity", "getCity$annotations", "city", "", "getGender", "()I", "setGender", "(I)V", "getGender$annotations", "gender", "getAgeRange", "setAgeRange", "getAgeRange$annotations", "ageRange", "getSignature", "setSignature", "getSignature$annotations", "signature", "getLevel", "setLevel", "getLevel$annotations", "level", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTopFans", "()Ljava/util/List;", "getTopFans$annotations", "topFans", "isVerified", "setVerified", "isVerified$annotations", "getVerifiedReason", "setVerifiedReason", "getVerifiedReason$annotations", "verifiedReason", "getLinkMicStats", "setLinkMicStats", "getLinkMicStats$annotations", "linkMicStats", "getUserBadges", "getUserBadges$annotations", "userBadges", "getSpecialId", "setSpecialId", "getSpecialId$annotations", "specialId", "getMedal", "setMedal", "getMedal$annotations", "medal", "getBackgroundImgUrl", "setBackgroundImgUrl", "getBackgroundImgUrl$annotations", "backgroundImgUrl", "getSecret", "setSecret", "getSecret$annotations", "secret", "Lpy/f;", "getBorder", "()Lpy/f;", "getBorder$annotations", "border", "Lpy/d;", "Lcom/bytedance/android/live/api/IBaseUseHonorKt;", "getUserHonor", "()Lpy/d;", "setUserHonor", "(Lpy/d;)V", "getUserHonor$annotations", "userHonor", "Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "getAnchorLevel", "()Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "setAnchorLevel", "(Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;)V", "getAnchorLevel$annotations", "anchorLevel", "Lpy/q;", "getPoiInfo", "()Lpy/q;", "setPoiInfo", "(Lpy/q;)V", "getPoiInfo$annotations", "poiInfo", "Lcom/bytedance/android/live/base/model/user/t;", "getFansClub", "()Lcom/bytedance/android/live/base/model/user/t;", "setFansClub", "(Lcom/bytedance/android/live/base/model/user/t;)V", "getFansClub$annotations", "fansClub", "Lpy/c;", "getMAuthenticationInfo", "()Lpy/c;", "setMAuthenticationInfo", "(Lpy/c;)V", "getMAuthenticationInfo$annotations", "mAuthenticationInfo", "getAdversaryUserStatus", "setAdversaryUserStatus", "getAdversaryUserStatus$annotations", "adversaryUserStatus", "getPersonalCard", "setPersonalCard", "getPersonalCard$annotations", "personalCard", "Lcom/bytedance/android/live/base/model/user/x;", "getIndustryCertification", "()Lcom/bytedance/android/live/base/model/user/x;", "setIndustryCertification", "(Lcom/bytedance/android/live/base/model/user/x;)V", "getIndustryCertification$annotations", "industryCertification", "getMediaBadgeImageList", "getMediaBadgeImageList$annotations", "mediaBadgeImageList", "getMysteryMan", "setMysteryMan", "getMysteryMan$annotations", "mysteryMan", "isAnonymous", "setAnonymous", "isAnonymous$annotations", "getUserWatchMonth", "setUserWatchMonth", "getUserWatchMonth$annotations", "userWatchMonth", "getPublicScreenOperateFreq", "setPublicScreenOperateFreq", "getPublicScreenOperateFreq$annotations", "publicScreenOperateFreq", "getWebcastUid", "setWebcastUid", "getWebcastUid$annotations", "webcastUid", "Lcom/bytedance/android/live/base/model/user/l0;", "getDressInfo", "()Lcom/bytedance/android/live/base/model/user/l0;", "setDressInfo", "(Lcom/bytedance/android/live/base/model/user/l0;)V", "getDressInfo$annotations", "dressInfo", "Lcom/bytedance/android/live/base/model/user/g0;", "getSubscribe", "()Lcom/bytedance/android/live/base/model/user/g0;", "setSubscribe", "(Lcom/bytedance/android/live/base/model/user/g0;)V", "getSubscribe$annotations", "subscribe", "Lcom/bytedance/android/live/base/model/user/d0;", "getProfileStyleParams", "()Lcom/bytedance/android/live/base/model/user/d0;", "setProfileStyleParams", "(Lcom/bytedance/android/live/base/model/user/d0;)V", "getProfileStyleParams$annotations", "profileStyleParams", "Lpy/t;", "getUserAttr", "()Lpy/t;", "setUserAttr", "(Lpy/t;)V", "getUserAttr$annotations", "userAttr", "getTelephone", "setTelephone", "getTelephone$annotations", "telephone", "Companion", "a", "DataSource", "Status", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBaseUser extends vh7.c<IBaseUser>, l {
    public static final a Companion = null;
    public static final int MYSTERY_MAN_MYSTERIOUS_MAN = 2;
    public static final int MYSTERY_MAN_NORMAL = 1;
    public static final int MYSTERY_MAN_UNKNOWN = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/base/model/user/IBaseUser$DataSource;", "", "Cache", "Net", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum DataSource extends Enum<DataSource> {
        public static final DataSource Cache = null;
        public static final DataSource Net = null;
        public static final /* synthetic */ DataSource[] a = null;

        static {
            DataSource r1 = new DataSource("Cache", 0);
            Cache = r1;
            DataSource r2 = new DataSource("Net", 1);
            Net = r2;
            a = new DataSource[]{r1, r2};
        }

        public static DataSource valueOf(String r1) {
            return (DataSource) r27.a.a(DataSource.class, r1);
        }

        public static DataSource[] values() {
            return (DataSource[]) a.clone();
        }

        public DataSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/base/model/user/IBaseUser$Status;", "", "Login", "Logout", "Update", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Status extends Enum<Status> {
        public static final Status Login = null;
        public static final Status Logout = null;
        public static final Status Update = null;
        public static final /* synthetic */ Status[] a = null;

        static {
            Status r1 = new Status("Login", 0);
            Login = r1;
            Status r2 = new Status("Logout", 1);
            Logout = r2;
            Status r3 = new Status("Update", 2);
            Update = r3;
            a = new Status[]{r1, r2, r3};
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ boolean canJumpToLiveRoom();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ boolean childrenManagerForbidCreateLiveRoom();

    /* synthetic */ boolean childrenManagerForbidWalletFunctions();

    /* synthetic */ IBaseUser cloneFrom();

    @FieldName(name = "adversary_user_status")
    int getAdversaryUserStatus();

    @FieldName(name = "age_range")
    int getAgeRange();

    /* synthetic */ py.b getAnchorInfoExt();

    @FieldName(name = "webcast_anchor_level")
    IAnchorLevel getAnchorLevel();

    /* synthetic */ py.k getAvatarLarge();

    /* synthetic */ py.k getAvatarMedium();

    @FieldName(name = "avatar_thumb")
    py.k getAvatarThumbKt();

    /* synthetic */ String getAvatarUrl();

    @FieldName(name = "bg_img_url")
    String getBackgroundImgUrl();

    /* synthetic */ List<py.k> getBadgeImageList();

    /* synthetic */ List<py.k> getBadgeImageListV2();

    /* synthetic */ List<py.k> getBadgeImageListV2Ext();

    @FieldName(name = "border")
    py.f getBorder();

    @FieldName(name = "bottom_entry")
    e getBottomEntry();

    /* synthetic */ String getCastSecUid();

    @FieldName(name = "city")
    String getCity();

    /* synthetic */ int getCommerceUserLevel();

    /* synthetic */ j getCommonVipInfo();

    @FieldName(name = "display_id")
    String getDisplayId();

    @Override // com.bytedance.android.live.base.model.user.l
    @FieldName(name = "user_dress_info")
    l0 getDressInfo();

    @FieldName(name = "with_car_management_permission")
    boolean getEnableCarManagementPermission();

    @FieldName(name = "with_commerce_permission")
    boolean getEnableShowCommerceSale();

    /* synthetic */ String getEncryptedId();

    /* synthetic */ int getEnterprise();

    @FieldName(name = "ticket_count")
    long getFanTicketCount();

    @FieldName(name = "fans_club")
    t getFansClub();

    @FieldName(name = "follow_info")
    py.j getFollowInfo();

    /* synthetic */ py.j getFollowInfoExt();

    @FieldName(name = "gender")
    int getGender();

    /* synthetic */ String getIdStrKt();

    @Override // com.bytedance.android.live.base.model.user.l
    @FieldName(name = "user_open_id")
    String getIdString();

    @FieldName(name = "industry_certification")
    x getIndustryCertification();

    @FieldName(name = "level")
    int getLevel();

    @FieldName(name = "link_mic_stats")
    int getLinkMicStats();

    /* synthetic */ long getLiveRoomId();

    /* synthetic */ String getLocationCity();

    /* synthetic */ String getLogPb();

    @FieldName(name = "authentication_info")
    py.c getMAuthenticationInfo();

    @FieldName(name = "medal")
    py.k getMedal();

    @FieldName(name = "media_badge_image_list")
    List<py.k> getMediaBadgeImageList();

    @FieldName(name = "mystery_man")
    int getMysteryMan();

    /* synthetic */ List<py.k> getNewUserBadges();

    @FieldName(name = "nickname")
    String getNickName();

    /* synthetic */ py.o getOwnRoom();

    /* synthetic */ long getPayScores();

    @FieldName(name = "personal_card")
    py.k getPersonalCard();

    @FieldName(name = "poi_info")
    py.q getPoiInfo();

    @FieldName(name = "profile_style_params")
    d0 getProfileStyleParams();

    /* synthetic */ String getProperNickName(boolean r1);

    @FieldName(name = "public_area_oper_freq")
    long getPublicScreenOperateFreq();

    /* synthetic */ String getRealNickName();

    /* synthetic */ String getRelationship();

    /* synthetic */ String getRemarkNameOrNickname();

    /* synthetic */ String getRemarkNameOrRealNickName();

    /* synthetic */ String getRequestId();

    /* synthetic */ boolean getRoomAutoGiftThanks();

    @FieldName(name = "desensitized_nickname")
    String getSafeNicName();

    /* synthetic */ int getSearchType();

    @FieldName(name = "secret")
    int getSecret();

    @FieldName(name = "short_id")
    long getShortId();

    @FieldName(name = "signature")
    String getSignature();

    @FieldName(name = "special_id")
    String getSpecialId();

    @FieldName(name = "subscribe")
    g0 getSubscribe();

    @FieldName(name = "telephone")
    String getTelephone();

    @FieldName(name = "top_fans")
    List<IBaseUser> getTopFans();

    @FieldName(name = "user_attr")
    py.t getUserAttr();

    /* synthetic */ py.t getUserAttrExt();

    /* synthetic */ py.t getUserAttrFlex();

    @FieldName(name = "real_time_icons")
    List<py.k> getUserBadges();

    @FieldName(name = "pay_grade")
    py.d getUserHonor();

    /* synthetic */ String getUserId();

    /* synthetic */ o0 getUserIdCompat();

    @FieldName(name = "watch_duration_month")
    long getUserWatchMonth();

    /* synthetic */ boolean getUserWatchMonthValid();

    @FieldName(name = "verified_reason")
    String getVerifiedReason();

    @FieldName(name = "webcast_uid")
    String getWebcastUid();

    @FieldName(name = "is_anonymous")
    boolean isAnonymous();

    /* synthetic */ boolean isEnableShowFansClubReverse();

    /* synthetic */ boolean isEnterpriseVerify();

    /* synthetic */ boolean isFollowing();

    /* synthetic */ boolean isMysteryMan();

    /* synthetic */ boolean isSubscriber();

    /* synthetic */ boolean isVcdAdversaryContentAuthorized();

    /* synthetic */ boolean isVcdAdversaryRelationAuthorized();

    /* synthetic */ boolean isVcdContentAuthorized();

    /* synthetic */ boolean isVcdRelationAuthorized();

    @FieldName(name = "verified")
    boolean isVerified();

    /* synthetic */ boolean isWithCommercePermission();

    @FieldName(name = "adversary_user_status#setter")
    void setAdversaryUserStatus(int r1);

    @FieldName(name = "age_range#setter")
    void setAgeRange(int r1);

    /* synthetic */ void setAnchorInfoExt(py.b r1);

    @FieldName(name = "webcast_anchor_level#setter")
    void setAnchorLevel(IAnchorLevel r1);

    @FieldName(name = "is_anonymous#setter")
    void setAnonymous(boolean r1);

    /* synthetic */ void setAvatarLargeImplicit(py.k r1);

    /* synthetic */ void setAvatarMediumImplicit(py.k r1);

    /* synthetic */ void setAvatarThumbImplicit(py.k r1);

    @FieldName(name = "avatar_thumb#setter")
    void setAvatarThumbKt(py.k r1);

    /* synthetic */ void setAvatarUrl(String r1);

    @FieldName(name = "bg_img_url#setter")
    void setBackgroundImgUrl(String r1);

    /* synthetic */ void setBadgeImageListV2(List<? extends py.k> r1);

    /* synthetic */ void setCastSecUid(String r1);

    @FieldName(name = "city#setter")
    void setCity(String r1);

    /* synthetic */ void setCommerceUserLevel(int r1);

    /* synthetic */ void setCommonVipInfo(j r1);

    @FieldName(name = "display_id#setter")
    void setDisplayId(String r1);

    @FieldName(name = "user_dress_info#setter")
    void setDressInfo(l0 r1);

    @FieldName(name = "with_car_management_permission#setter")
    void setEnableCarManagementPermission(boolean r1);

    @FieldName(name = "with_commerce_permission#setter")
    void setEnableShowCommerceSale(boolean r1);

    /* synthetic */ void setEnterprise(int r1);

    @FieldName(name = "ticket_count#setter")
    void setFanTicketCount(long r1);

    @FieldName(name = "fans_club#setter")
    void setFansClub(t r1);

    /* synthetic */ void setFollowInfoExt(py.j r1);

    /* synthetic */ void setFollowStatus(int r1);

    @FieldName(name = "gender#setter")
    void setGender(int r1);

    @FieldName(name = "user_open_id#setter")
    void setIdString(String r1);

    @FieldName(name = "industry_certification#setter")
    void setIndustryCertification(x r1);

    @FieldName(name = "level#setter")
    void setLevel(int r1);

    @FieldName(name = "link_mic_stats#setter")
    void setLinkMicStats(int r1);

    /* synthetic */ void setLogPb(String r1);

    @FieldName(name = "authentication_info#setter")
    void setMAuthenticationInfo(py.c r1);

    @FieldName(name = "medal#setter")
    void setMedal(py.k r1);

    @FieldName(name = "mystery_man#setter")
    void setMysteryMan(int r1);

    @FieldName(name = "nickname#setter")
    void setNickName(String r1);

    @FieldName(name = "personal_card#setter")
    void setPersonalCard(py.k r1);

    @FieldName(name = "poi_info#setter")
    void setPoiInfo(py.q r1);

    @FieldName(name = "profile_style_params#setter")
    void setProfileStyleParams(d0 r1);

    @FieldName(name = "public_area_oper_freq#setter")
    void setPublicScreenOperateFreq(long r1);

    /* synthetic */ void setRequestId(String r1);

    @FieldName(name = "desensitized_nickname#setter")
    void setSafeNicName(String r1);

    /* synthetic */ void setSearchType(int r1);

    @FieldName(name = "secret#setter")
    void setSecret(int r1);

    @FieldName(name = "short_id#setter")
    void setShortId(long r1);

    /* synthetic */ void setShouldUseRealName(boolean r1);

    @FieldName(name = "signature#setter")
    void setSignature(String r1);

    @FieldName(name = "special_id#setter")
    void setSpecialId(String r1);

    @FieldName(name = "subscribe#setter")
    void setSubscribe(g0 r1);

    @FieldName(name = "telephone#setter")
    void setTelephone(String r1);

    @FieldName(name = "user_attr#setter")
    void setUserAttr(py.t r1);

    /* synthetic */ void setUserAttrExt(py.t r1);

    @FieldName(name = "pay_grade#setter")
    void setUserHonor(py.d r1);

    @FieldName(name = "watch_duration_month#setter")
    void setUserWatchMonth(long r1);

    /* synthetic */ void setUserWatchMonthValid(boolean r1);

    /* synthetic */ void setVcdAdversaryAuthorizeState(boolean r1, boolean r2);

    @FieldName(name = "verified#setter")
    void setVerified(boolean r1);

    @FieldName(name = "verified_reason#setter")
    void setVerifiedReason(String r1);

    @FieldName(name = "webcast_uid#setter")
    void setWebcastUid(String r1);

    /* synthetic */ void setWithCommercePermission(boolean r1);
}
