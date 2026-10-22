package p00;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class d {

    @SerializedName("is_not_block_create_global")
    public boolean allowCreateLive;

    @SerializedName("disable_info")
    public c disableInfo;

    @SerializedName("anchor_fans_info")
    public a mAnchorFansInfo;

    @SerializedName("anchor_info_bar_data")
    public b mAnchorInfoBarData;

    @SerializedName("anchor_prompt_type")
    public int mAnchorPromptType;

    @SerializedName("auto_cover")
    public long mAutoCover;

    @SerializedName("block_prompt")
    public String mBlockMsgTitle;

    @SerializedName("block_schema_locale")
    public String mBlockSchema;

    @SerializedName("block_status")
    public int mBlockStatus;

    @SerializedName("live_scenario")
    public p00.a mBroadcastConfig;

    @SerializedName("cover")
    public k mCover;

    @SerializedName("cover_audit_status")
    public long mCoverAuditStatus;

    @SerializedName("never_go_live_flag")
    public int mIsFirstBroadcastFlag;

    @SerializedName("new_anchor_flag")
    public int mNewAnchorFlag;

    @SerializedName("go_live_prompt")
    public String mPrompt;

    @SerializedName("title")
    public String mTitle;

    @SerializedName("trial_live_info")
    public f mTrialLiveInfo;

    @SerializedName("mobile_game_tab")
    public C0259d mobileGameTab;

    @SerializedName("pc_live_permission_apply_button_text")
    public String pcLivePermissionApplyButtonText;

    @SerializedName("pc_live_permission_apply_status")
    public int pcLivePermissionApplyStatus;

    @SerializedName("push_stream_info")
    public e pushStreamInfo;

    @SerializedName("auto_un_block_prompts")
    public String unblockPrompt;

    @SerializedName("un_block_time")
    public long unblockTime;

    public static class a {

        @SerializedName("avatar_type")
        public int mAvatarType;

        @SerializedName("avatars")
        public List<k> mLivingFriendAvatars;

        @SerializedName("living_friend_count")
        public int mLivingFriendCount;

        @SerializedName("online_fans_count")
        public int mOnlineFansCount;

        @SerializedName("online_friend_count")
        public int mOnlineFriendCount;

        public a() {
        }
    }

    public static class b {

        @SerializedName("icon")
        public k mIcon;

        @SerializedName("jump_text")
        public String mJumpText;

        @SerializedName("title")
        public String mTitle;

        @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
        public String mUrl;

        public b() {
        }
    }

    public static class c {

        @SerializedName("disable_edit_cover")
        public boolean disableEditCover;

        @SerializedName("disable_edit_cover_toast")
        public String disableEditCoverToast;

        @SerializedName("disable_edit_title")
        public boolean disableEditTitle;

        @SerializedName("disable_edit_title_toast")
        public String disableEditTitleToast;

        public c() {
        }
    }

    /* JADX INFO: renamed from: p00.d$d, reason: collision with other inner class name */
    public static class C0259d {

        @SerializedName("is_accepted")
        public boolean isAccepted;

        @SerializedName("is_mobile_game_anchor")
        public boolean isMobileGameAnchor;

        @SerializedName("nickname")
        public String nickName;

        @SerializedName("schema")
        public String schema;

        public C0259d() {
        }
    }

    public static class e {

        @SerializedName("default_resolution_key")
        public String defaultResolutionKey;

        @SerializedName("resolutions")
        public List<a> resolutions;

        public static class a {

            @SerializedName("key")
            public String key;

            @SerializedName("text")
            public String text;

            public a() {
            }
        }

        public e() {
        }
    }

    public static class f {

        @SerializedName("current_times")
        public int mCurrentTime;

        @SerializedName("enable_trial_live")
        public boolean mEnableTrialLive;

        @SerializedName("prompts")
        public String mPrompt;

        @SerializedName("remain_times")
        public int mRemainTimes;

        @SerializedName("total_times")
        public int mTotalTimes;

        public f() {
        }
    }

    public d() {
        this.pcLivePermissionApplyButtonText = "";
        this.allowCreateLive = false;
    }
}
