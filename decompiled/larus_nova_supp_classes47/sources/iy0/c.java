package iy0;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.api.IAnchorLevel;
import com.bytedance.android.live.base.model.user.d0;
import com.bytedance.android.live.base.model.user.g0;
import com.bytedance.android.live.base.model.user.j;
import com.bytedance.android.live.base.model.user.l0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.t;
import com.bytedance.android.live.base.model.user.x;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import py.f;
import py.k;
import py.o;
import py.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Liy0/c;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "", "getId", "()J", "setId", "(J)V", "getId$annotations", "()V", "id", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface c extends vh7.e<IBaseUser>, IBaseUser {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ boolean canJumpToLiveRoom();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ boolean childrenManagerForbidCreateLiveRoom();

    /* synthetic */ boolean childrenManagerForbidWalletFunctions();

    /* synthetic */ IBaseUser cloneFrom();

    @FieldName(name = "adversary_user_status")
    /* synthetic */ int getAdversaryUserStatus();

    @FieldName(name = "age_range")
    /* synthetic */ int getAgeRange();

    /* synthetic */ py.b getAnchorInfoExt();

    @FieldName(name = "webcast_anchor_level")
    /* synthetic */ IAnchorLevel getAnchorLevel();

    /* synthetic */ k getAvatarLarge();

    /* synthetic */ k getAvatarMedium();

    @FieldName(name = "avatar_thumb")
    /* synthetic */ k getAvatarThumbKt();

    /* synthetic */ String getAvatarUrl();

    @FieldName(name = "bg_img_url")
    /* synthetic */ String getBackgroundImgUrl();

    /* synthetic */ List<k> getBadgeImageList();

    /* synthetic */ List<k> getBadgeImageListV2();

    /* synthetic */ List<k> getBadgeImageListV2Ext();

    @FieldName(name = "border")
    /* synthetic */ f getBorder();

    @FieldName(name = "bottom_entry")
    /* synthetic */ com.bytedance.android.live.base.model.user.e getBottomEntry();

    /* synthetic */ String getCastSecUid();

    @FieldName(name = "city")
    /* synthetic */ String getCity();

    /* synthetic */ int getCommerceUserLevel();

    /* synthetic */ j getCommonVipInfo();

    @FieldName(name = "display_id")
    /* synthetic */ String getDisplayId();

    @FieldName(name = "user_dress_info")
    /* synthetic */ l0 getDressInfo();

    @FieldName(name = "with_car_management_permission")
    /* synthetic */ boolean getEnableCarManagementPermission();

    @FieldName(name = "with_commerce_permission")
    /* synthetic */ boolean getEnableShowCommerceSale();

    /* synthetic */ String getEncryptedId();

    /* synthetic */ int getEnterprise();

    @FieldName(name = "ticket_count")
    /* synthetic */ long getFanTicketCount();

    @FieldName(name = "fans_club")
    /* synthetic */ t getFansClub();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "follow_info")
    /* synthetic */ py.j getFollowInfo();

    /* synthetic */ py.j getFollowInfoExt();

    @FieldName(name = "gender")
    /* synthetic */ int getGender();

    @FieldName(name = "id")
    long getId();

    /* synthetic */ String getIdStrKt();

    @FieldName(name = "user_open_id")
    /* synthetic */ String getIdString();

    @FieldName(name = "industry_certification")
    /* synthetic */ x getIndustryCertification();

    @FieldName(name = "level")
    /* synthetic */ int getLevel();

    @FieldName(name = "link_mic_stats")
    /* synthetic */ int getLinkMicStats();

    /* synthetic */ long getLiveRoomId();

    /* synthetic */ String getLocationCity();

    /* synthetic */ String getLogPb();

    @FieldName(name = "authentication_info")
    /* synthetic */ py.c getMAuthenticationInfo();

    @FieldName(name = "medal")
    /* synthetic */ k getMedal();

    @FieldName(name = "media_badge_image_list")
    /* synthetic */ List<k> getMediaBadgeImageList();

    @FieldName(name = "mystery_man")
    /* synthetic */ int getMysteryMan();

    /* synthetic */ List<k> getNewUserBadges();

    @FieldName(name = "nickname")
    /* synthetic */ String getNickName();

    /* synthetic */ o getOwnRoom();

    /* synthetic */ long getPayScores();

    @FieldName(name = "personal_card")
    /* synthetic */ k getPersonalCard();

    @FieldName(name = "poi_info")
    /* synthetic */ q getPoiInfo();

    @FieldName(name = "profile_style_params")
    /* synthetic */ d0 getProfileStyleParams();

    /* synthetic */ String getProperNickName(boolean r1);

    @FieldName(name = "public_area_oper_freq")
    /* synthetic */ long getPublicScreenOperateFreq();

    /* synthetic */ String getRealNickName();

    /* synthetic */ String getRelationship();

    /* synthetic */ String getRemarkNameOrNickname();

    /* synthetic */ String getRemarkNameOrRealNickName();

    /* synthetic */ String getRequestId();

    /* synthetic */ boolean getRoomAutoGiftThanks();

    @FieldName(name = "desensitized_nickname")
    /* synthetic */ String getSafeNicName();

    /* synthetic */ int getSearchType();

    @FieldName(name = "secret")
    /* synthetic */ int getSecret();

    @FieldName(name = "short_id")
    /* synthetic */ long getShortId();

    @FieldName(name = "signature")
    /* synthetic */ String getSignature();

    @FieldName(name = "special_id")
    /* synthetic */ String getSpecialId();

    @FieldName(name = "subscribe")
    /* synthetic */ g0 getSubscribe();

    @FieldName(name = "telephone")
    /* synthetic */ String getTelephone();

    @FieldName(name = "top_fans")
    /* synthetic */ List<IBaseUser> getTopFans();

    @FieldName(name = "user_attr")
    /* synthetic */ py.t getUserAttr();

    /* synthetic */ py.t getUserAttrExt();

    /* synthetic */ py.t getUserAttrFlex();

    @FieldName(name = "real_time_icons")
    /* synthetic */ List<k> getUserBadges();

    @FieldName(name = "pay_grade")
    /* synthetic */ py.d getUserHonor();

    /* synthetic */ String getUserId();

    /* synthetic */ o0 getUserIdCompat();

    @FieldName(name = "watch_duration_month")
    /* synthetic */ long getUserWatchMonth();

    /* synthetic */ boolean getUserWatchMonthValid();

    @FieldName(name = "verified_reason")
    /* synthetic */ String getVerifiedReason();

    @FieldName(name = "webcast_uid")
    /* synthetic */ String getWebcastUid();

    @FieldName(name = "is_anonymous")
    /* synthetic */ boolean isAnonymous();

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
    /* synthetic */ boolean isVerified();

    /* synthetic */ boolean isWithCommercePermission();

    @FieldName(name = "adversary_user_status#setter")
    /* synthetic */ void setAdversaryUserStatus(int r1);

    @FieldName(name = "age_range#setter")
    /* synthetic */ void setAgeRange(int r1);

    /* synthetic */ void setAnchorInfoExt(py.b r1);

    @FieldName(name = "webcast_anchor_level#setter")
    /* synthetic */ void setAnchorLevel(IAnchorLevel r1);

    @FieldName(name = "is_anonymous#setter")
    /* synthetic */ void setAnonymous(boolean r1);

    /* synthetic */ void setAvatarLargeImplicit(k r1);

    /* synthetic */ void setAvatarMediumImplicit(k r1);

    /* synthetic */ void setAvatarThumbImplicit(k r1);

    @FieldName(name = "avatar_thumb#setter")
    /* synthetic */ void setAvatarThumbKt(k r1);

    /* synthetic */ void setAvatarUrl(String r1);

    @FieldName(name = "bg_img_url#setter")
    /* synthetic */ void setBackgroundImgUrl(String r1);

    /* synthetic */ void setBadgeImageListV2(List<? extends k> r1);

    /* synthetic */ void setCastSecUid(String r1);

    @FieldName(name = "city#setter")
    /* synthetic */ void setCity(String r1);

    /* synthetic */ void setCommerceUserLevel(int r1);

    /* synthetic */ void setCommonVipInfo(j r1);

    @FieldName(name = "display_id#setter")
    /* synthetic */ void setDisplayId(String r1);

    @FieldName(name = "user_dress_info#setter")
    /* synthetic */ void setDressInfo(l0 r1);

    @FieldName(name = "with_car_management_permission#setter")
    /* synthetic */ void setEnableCarManagementPermission(boolean r1);

    @FieldName(name = "with_commerce_permission#setter")
    /* synthetic */ void setEnableShowCommerceSale(boolean r1);

    /* synthetic */ void setEnterprise(int r1);

    @FieldName(name = "ticket_count#setter")
    /* synthetic */ void setFanTicketCount(long r1);

    @FieldName(name = "fans_club#setter")
    /* synthetic */ void setFansClub(t r1);

    /* synthetic */ void setFollowInfoExt(py.j r1);

    /* synthetic */ void setFollowStatus(int r1);

    @FieldName(name = "gender#setter")
    /* synthetic */ void setGender(int r1);

    @FieldName(name = "id#setter")
    void setId(long r1);

    @FieldName(name = "user_open_id#setter")
    /* synthetic */ void setIdString(String r1);

    @FieldName(name = "industry_certification#setter")
    /* synthetic */ void setIndustryCertification(x r1);

    @FieldName(name = "level#setter")
    /* synthetic */ void setLevel(int r1);

    @FieldName(name = "link_mic_stats#setter")
    /* synthetic */ void setLinkMicStats(int r1);

    /* synthetic */ void setLogPb(String r1);

    @FieldName(name = "authentication_info#setter")
    /* synthetic */ void setMAuthenticationInfo(py.c r1);

    @FieldName(name = "medal#setter")
    /* synthetic */ void setMedal(k r1);

    @FieldName(name = "mystery_man#setter")
    /* synthetic */ void setMysteryMan(int r1);

    @FieldName(name = "nickname#setter")
    /* synthetic */ void setNickName(String r1);

    @FieldName(name = "personal_card#setter")
    /* synthetic */ void setPersonalCard(k r1);

    @FieldName(name = "poi_info#setter")
    /* synthetic */ void setPoiInfo(q r1);

    @FieldName(name = "profile_style_params#setter")
    /* synthetic */ void setProfileStyleParams(d0 r1);

    @FieldName(name = "public_area_oper_freq#setter")
    /* synthetic */ void setPublicScreenOperateFreq(long r1);

    /* synthetic */ void setRequestId(String r1);

    @FieldName(name = "desensitized_nickname#setter")
    /* synthetic */ void setSafeNicName(String r1);

    /* synthetic */ void setSearchType(int r1);

    @FieldName(name = "secret#setter")
    /* synthetic */ void setSecret(int r1);

    @FieldName(name = "short_id#setter")
    /* synthetic */ void setShortId(long r1);

    /* synthetic */ void setShouldUseRealName(boolean r1);

    @FieldName(name = "signature#setter")
    /* synthetic */ void setSignature(String r1);

    @FieldName(name = "special_id#setter")
    /* synthetic */ void setSpecialId(String r1);

    @FieldName(name = "subscribe#setter")
    /* synthetic */ void setSubscribe(g0 r1);

    @FieldName(name = "telephone#setter")
    /* synthetic */ void setTelephone(String r1);

    @FieldName(name = "user_attr#setter")
    /* synthetic */ void setUserAttr(py.t r1);

    /* synthetic */ void setUserAttrExt(py.t r1);

    @FieldName(name = "pay_grade#setter")
    /* synthetic */ void setUserHonor(py.d r1);

    @FieldName(name = "watch_duration_month#setter")
    /* synthetic */ void setUserWatchMonth(long r1);

    /* synthetic */ void setUserWatchMonthValid(boolean r1);

    /* synthetic */ void setVcdAdversaryAuthorizeState(boolean r1, boolean r2);

    @FieldName(name = "verified#setter")
    /* synthetic */ void setVerified(boolean r1);

    @FieldName(name = "verified_reason#setter")
    /* synthetic */ void setVerifiedReason(String r1);

    @FieldName(name = "webcast_uid#setter")
    /* synthetic */ void setWebcastUid(String r1);

    /* synthetic */ void setWithCommercePermission(boolean r1);
}
