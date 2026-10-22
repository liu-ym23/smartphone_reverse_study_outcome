package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/config/rb1;", "", "", "beInvitedDialogOpt", "Z", "d", "()Z", "setBeInvitedDialogOpt", "(Z)V", "eventInfoUseFixedTextConfig", "e", "setEventInfoUseFixedTextConfig", "waitingListItemTagFade", "i", "setWaitingListItemTagFade", "fastMatchRecommendRoomOpt", "f", "setFastMatchRecommendRoomOpt", "applyWaitingDialogLynxOpt", "a", "setApplyWaitingDialogLynxOpt", "", "applyWaitingDialogSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setApplyWaitingDialogSchema", "(Ljava/lang/String;)V", "fastMatchRecommendRoomSchema", "g", "setFastMatchRecommendRoomSchema", "", "applyWaitingDialogShowRecommendRoomApplyCount", "I", "c", "()I", "setApplyWaitingDialogShowRecommendRoomApplyCount", "(I)V", "lynxApplyWaitingDialogLifecycleOpt", "h", "setLynxApplyWaitingDialogLifecycleOpt", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class rb1 {

    @SerializedName("apply_waiting_dialog_lynx_opt")
    private boolean applyWaitingDialogLynxOpt;

    @SerializedName("apply_waiting_dialog_schema")
    private String applyWaitingDialogSchema;

    @SerializedName("apply_waiting_dialog_show_recommend_room_apply_count")
    private int applyWaitingDialogShowRecommendRoomApplyCount;

    @SerializedName("be_invited_dialog_opt")
    private boolean beInvitedDialogOpt;

    @SerializedName("event_info_use_fixed_text_config")
    private boolean eventInfoUseFixedTextConfig;

    @SerializedName("fast_match_opt")
    private boolean fastMatchRecommendRoomOpt;

    @SerializedName("fast_match_recommend_room_schema")
    private String fastMatchRecommendRoomSchema;

    @SerializedName("lynx_apply_waiting_dialog_lifecycle_opt")
    private boolean lynxApplyWaitingDialogLifecycleOpt;

    @SerializedName("waiting_list_item_tag_fade")
    private boolean waitingListItemTagFade;

    public rb1() {
        this.eventInfoUseFixedTextConfig = true;
        this.waitingListItemTagFade = true;
        this.applyWaitingDialogSchema = "sslocal://webcast_lynxview?type=popup&gravity=bottom&height=444&url=https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/linkmic_recommend_room_douyin/pages/apply_waiting_dialog/template.js&enable_latch=1&business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
        this.fastMatchRecommendRoomSchema = "sslocal://webcast_lynxview?type=popup&rate_height=484&gravity=bottom&web_bg_color=%23ffffffff&radius=12&url=https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/linkmic_recommend_room_douyin/pages/fast_match_recommend_room_list_panel/template.js&enable_latch=1&business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
        this.applyWaitingDialogShowRecommendRoomApplyCount = 3;
        this.lynxApplyWaitingDialogLifecycleOpt = true;
    }

    public final boolean a() {
        return this.applyWaitingDialogLynxOpt;
    }

    public final String b() {
        return this.applyWaitingDialogSchema;
    }

    public final int c() {
        return this.applyWaitingDialogShowRecommendRoomApplyCount;
    }

    public final boolean d() {
        return this.beInvitedDialogOpt;
    }

    public final boolean e() {
        return this.eventInfoUseFixedTextConfig;
    }

    public final boolean f() {
        return this.fastMatchRecommendRoomOpt;
    }

    public final String g() {
        return this.fastMatchRecommendRoomSchema;
    }

    public final boolean h() {
        return this.lynxApplyWaitingDialogLifecycleOpt;
    }

    public final boolean i() {
        return this.waitingListItemTagFade;
    }
}
