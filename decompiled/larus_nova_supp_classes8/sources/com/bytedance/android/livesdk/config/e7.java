package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class e7 {

    @SerializedName("big_crown_animation")
    public String bigCrownAnimation;

    @SerializedName("big_poop_animation")
    public String bigPoopAnimation;

    @SerializedName("end_animation")
    public String endAnimation;

    @SerializedName("loki_sticker_id_map")
    public Map<String, String> lokiStickerIDMap;

    @SerializedName("seat_crown_animation")
    public String seatCrownAnimation;

    @SerializedName("seat_heart_break_animation")
    public String seatHeartBreakAnimation;

    @SerializedName("small_crown_animation")
    public String smallCrownAnimation;

    @SerializedName("small_poop_animation")
    public String smallPoopAnimation;

    @SerializedName("start_animation")
    public String startAnimation;

    @SerializedName("video_talk_background")
    public String videoTalkBackground;

    @SerializedName("voice_chat_background")
    public String voiceChatBackground;

    public e7() {
        this.startAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/guest_battle_start.webp";
        this.endAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/guest_battle_end.webp";
        this.smallCrownAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/guest_battle_small_crown.webp";
        this.smallPoopAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/live_guest_battle_loser_appear_anim.webp";
        this.bigCrownAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/guest_battle_big_crown.webp";
        this.bigPoopAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/live_guest_battle_loser_last_minute_anim.webp";
        this.seatCrownAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/guest_battle_seat_crown.webp";
        this.seatHeartBreakAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_guest_battle_broken_heart.webp";
        this.voiceChatBackground = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/guest_battle_voicechat_background.png";
        this.videoTalkBackground = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/guest_battle_videotalk_background.png";
        this.lokiStickerIDMap = null;
    }
}
