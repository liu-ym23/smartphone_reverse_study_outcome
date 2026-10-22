package com.bytedance.android.live.liveinteract.api.utils;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final Map<String, Integer> a = null;

    static {
        HashMap r0 = new HashMap();
        a = r0;
        r0.put("rtc_turn_on", 10001);
        r0.put("rtc_turn_on_success", 10002);
        r0.put("rtc_turn_on_failed", 10003);
        r0.put("rtc_turn_off", 10004);
        r0.put("rtc_turn_off_success", 10005);
        r0.put("rtc_turn_off_failed", 10006);
        r0.put("rtc_first_frame", 10007);
        r0.put("rtc_user_leave", 10008);
        r0.put("rtc_user_join", 10009);
        r0.put("rtc_on_error", 10010);
        r0.put("rtc_mix_stream", 10011);
        r0.put("rtc_mix_sei", 10012);
        r0.put("rtc_mute_other", 10013);
        r0.put("rtc_switch_audio", 10014);
        r0.put("rtc_first_audio_frame", 10015);
        r0.put("rtc_mute_allremote", 10016);
        r0.put("rtc_mute_audio", 10017);
        r0.put("rtc_unmute_audio", 10018);
        r0.put("sei_too_long", 10019);
        r0.put("rtc_start_time_out", 10020);
        r0.put("rtc_stop_time_out", 10021);
        r0.put("join_channel_success", 20001);
        r0.put("join_channel_failed", 20002);
        r0.put("leave_channel_success", 20003);
        r0.put("leave_channel_failed", 20004);
        r0.put("finish_link_mic_success", 20005);
        r0.put("finish_link_mic_failed", 20006);
        r0.put("start_link_mic_success", 20007);
        r0.put("start_link_mic_failed", 20008);
        r0.put("guest_reply_success", 20007);
        r0.put("guest_reply_failed", 20008);
        r0.put("guest_apply_success", 20009);
        r0.put("guest_apply_failed", 20010);
        r0.put("guest_receive_kickout_msg", 2011);
        r0.put("guest_receive_permit_msg", 20012);
        r0.put("guest_receive_invite_msg", 20013);
        r0.put("kickout_audience_success", 20014);
        r0.put("kickout_audience_failed", 20015);
        r0.put("silence_audience_success", 20016);
        r0.put("silence_audience_failed", 20017);
        r0.put("unsilence_audience_success", 20018);
        r0.put("unsilence_audience_failed", 20019);
        r0.put("permit_audience_success", 20020);
        r0.put("permit_audience_failed", 20021);
        r0.put("invite_audience_success", 20022);
        r0.put("invite_audience_failed", 20023);
        r0.put("anchor_receive_auto_join_msg", 20024);
        r0.put("anchor_receive_reply_msg", 20025);
        r0.put("anchor_receive_admin_agree_msg", 20026);
        r0.put("anchor_continue_room_linkmic", 20027);
        r0.put("pk_first_frame_log_time_error", 20028);
        r0.put("self_mute_state_error", 20029);
        r0.put("self_not_on_seat", 20030);
        r0.put("kickout_when_rtc_user_lost", 20031);
        r0.put("on_pause_mute_error", 20032);
        r0.put("self_silence_but_unmute", 20033);
        r0.put("reset_mute_when_list_silence", 20034);
        r0.put("reset_mute_when_list_silence_failed", 20035);
        r0.put("rtc_switch_audio_mute", 20036);
        r0.put("rtc_switch_audio_unmute", 20037);
        r0.put("rtc_mute_allremote_audio", 20038);
        r0.put("rtc_unmute_allremote_audio", 20039);
        r0.put("audience_link_settings_error", 20040);
        r0.put("live_core_single_view", 20041);
        r0.put("video_state_conflict", 20042);
    }

    public static int a(String r2, int r3, boolean r4) {
        Map<String, Integer> r0 = a;
        if (((HashMap) r0).containsKey(r2) == false) goto L10;
        int r5 = ((Integer) ((HashMap) r0).get(r2)).intValue() + (r3 * 100000);
        if (r4 == false) goto L7;
        int r6 = 1000000;
    L9:
        return r5 + r6;
    L7:
        r6 = 2000000;
        goto L9
    L10:
        return 0;
    }
}
