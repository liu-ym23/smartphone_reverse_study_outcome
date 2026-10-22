package com.byted.mgl.merge.service.api.aweme;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.bdp.serviceapi.hostimpl.account.model.BdpUserInfo;
import com.bytedance.bdp.serviceapi.hostimpl.aweme.model.AwemeAccountInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpAwemeService extends IBdpService {

    public interface AuthResultCallBack {
        void onUserAuthorized(String r1);

        void onUserDenied(boolean r1);
    }

    public static class AuthTickerRequestResult {
        public final ScopesData normalScopesData;
        public final String ticket;

        public boolean canSkipConfirm() {
            return this.normalScopesData.canSkipConfirm;
        }

        public AuthTickerRequestResult(ScopesData r1, String r10) {
            this.normalScopesData = r1;
            this.ticket = r10;
        }
    }

    public static class AwemeOfficialAccountInfo {
        public final String mAvatar;
        public final boolean mHasFollowed;
        public final String mName;

        public AwemeOfficialAccountInfo(String r1, String r10, boolean r11) {
            this.mName = r1;
            this.mAvatar = r10;
            this.mHasFollowed = r11;
        }
    }

    public interface FetchBulletContentCallBack {
        void onFailed();

        void onSuccess(int r1, Map<String, ?> r10);
    }

    public interface FollowStatusListener {
        void onFollow(int r1);
    }

    public interface GetAwemeAccountInfoListener {
        void onResponse(AwemeAccountInfo r1);
    }

    public interface GetAwemeOfficialAccountInfoListener {
        void onResponse(AwemeOfficialAccountInfo r1);
    }

    public static final enum IMUserMock extends Enum<IMUserMock> {
        private static final /* synthetic */ IMUserMock[] $VALUES = null;
        public static final IMUserMock AVATAR_SMALL = null;
        public static final IMUserMock IS_FREQUENCY_CONTROL = null;
        public static final IMUserMock IS_FRIEND = null;
        public static final IMUserMock NICK_NAME = null;
        public static final IMUserMock SEC_UID = null;
        String value;

        static {
            IMUserMock r0 = new IMUserMock("NICK_NAME", 0, a.KEY_SHOPPING_GUIDE_NAME);
            NICK_NAME = r0;
            IMUserMock r1 = new IMUserMock("AVATAR_SMALL", 1, "avatar_url");
            AVATAR_SMALL = r1;
            IMUserMock r10 = new IMUserMock("SEC_UID", 2, "sec_uid");
            SEC_UID = r10;
            IMUserMock r11 = new IMUserMock("IS_FRIEND", 3, "is_friend");
            IS_FRIEND = r11;
            IMUserMock r12 = new IMUserMock("IS_FREQUENCY_CONTROL", 4, "is_frequency_control");
            IS_FREQUENCY_CONTROL = r12;
            $VALUES = new IMUserMock[]{r0, r1, r10, r11, r12};
        }

        public static IMUserMock[] values() {
            return (IMUserMock[]) $VALUES.clone();
        }

        public String value() {
            return this.value;
        }

        public static IMUserMock valueOf(String r1) {
            return (IMUserMock) r27.a.a(IMUserMock.class, r1);
        }

        private IMUserMock(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    public interface IOperateSceneListener {
        public static final int FAIL = -1;
        public static final int SUCCEED = 0;

        void onResult(int r1, String r10);
    }

    public interface JoinFansGroupListener {
        void onError(int r1, String r10);

        void onSuccess();
    }

    public static class ScopesData {
        final boolean canSkipConfirm;
        public final List<String> scopeNames;

        public ScopesData(List<String> r1, boolean r10) {
            this.scopeNames = r1;
            this.canSkipConfirm = r10;
        }
    }

    public interface UserInfoCallback {
        void onResult(String r1, String r10, String r11);
    }

    void checkFollowAwemeState(String r1, String r10, FollowAwemeCallback r11);

    JSONArray fetchAwemeFriendsList(String r1, int r10);

    void fetchBulletContent(int r1, int r10, Map<String, ?> r11, FetchBulletContentCallBack r12);

    void followAwemeAccountWithOutJump(String r1, String r10, int r11, int r12, int r13, String r14, int r15, String r16, FollowStatusListener r17, String r18);

    void followDesignateAwemeUser(Activity r1, String r10, FollowDesignateAwemeUserCallback r11);

    void getAwemeAccountInfo(String r1, String r10, GetAwemeAccountInfoListener r11);

    void getAwemeOfficialAccountInfo(String r1, String r10, GetAwemeOfficialAccountInfoListener r11);

    boolean getChatGroupInfo(String r1, GroupInfoCallback r10, BdpUserInfo r11);

    String getGameDetailSchema(String r1);

    void getUserInfo(String r1, UserInfoCallback r10);

    boolean hasAwemeImpl();

    boolean hasPOILocationPermission(Context r1);

    boolean isAwemeTeenMode();

    Boolean isColdBoot();

    boolean isPad();

    boolean isSupportAwemeAuthAbility();

    boolean joinChatGroup(Activity r1, String r10, boolean r11, JoinChatGroupCallback r12);

    boolean joinConversation(Map<String, String> r1, JoinConversationCallback r10, Activity r11, BdpUserInfo r12);

    void joinFansGroup(String r1, String r10, String r11, JoinFansGroupListener r12);

    void openAwemeUserProfile(Activity r1, String r10, String r11, boolean r12, boolean r13, OpenAwemeUserProfileCallback r14);

    void openCardProfilePanel(Activity r1, String r10, String r11, OnProfileCardOpenCallback r12);

    void operateScene(String r1, String r10, JSONObject r11, IOperateSceneListener r12);

    void rateAwemeOrder(Activity r1, String r10, RateAwemeOrderCallback r11);

    void requestAuth(FragmentActivity r1, String r10, AuthResultCallBack r11);

    void requestAuthCode(String r1, List<String> r10, String r11, RequestAuthCodeListener r12);

    void requestAuthScopeInfo(String r1, AuthTickerRequestResult r10, RequestAuthInfoListener r11);

    void requestAuthTicket(String r1, List<String> r10, RequestAuthTicketListener r11);

    void requestLynxPayment(Activity r1, String r10, int r11, String r12, String r13, String r14, RequestLynxPaymentCallback r15);

    void sendAuthorLiveCastingPageChanged(String r1, String r10);

    void setIsCanShowShareFlow(boolean r1);

    void showAuth(FragmentActivity r1, String r10, AuthResultCallBack r11);

    void showInvitePanel(Activity r1, HashMap<String, String> r10, HashMap<String, String> r11, OnInvitePanelCallback r12);

    Boolean skipRealNameAuth();

    void tryShowEntranceBubble(String r1, String r10, AwemeHomePageCaptionListener r11);

    void tryShowEntranceCaption(String r1, AwemeHomePageCaptionListener r10);

    void tryShowEntranceGuideAnim(String r1, String r10, AwemeHomePageSideBarEntryAnimListener r11);
}
