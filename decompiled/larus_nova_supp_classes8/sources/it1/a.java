package it1;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.livesdk.chatroom.helper.EnterRoomTimeTracer;
import com.bytedance.android.livesdk.chatroom.helper.f;
import com.bytedance.android.livesdk.chatroom.utils.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static String d(SparseArray<EnterRoomTimeTracer.a> r11) {
        if (r11 != null) goto L5;
        return "";
    L5:
        StringBuilder r1 = new StringBuilder("taskType:+0,timeStep:");
        r1.append(System.currentTimeMillis());
        r1.append(",from_type:");
        String r2 = k1.c();
        r2.getClass();
        byte r4 = -1;
        switch(r2.hashCode()) {
            case -1271119582: goto L17;
            case 1207523109: goto L13;
            case 1691937916: goto L9;
            default: goto L20;
        };
    L20:
        switch(r4) {
            case 0: goto L27;
            case 1: goto L24;
            case 2: goto L22;
            default: goto L21;
        };
    L21:
        String r3 = k1.c();
    L28:
        r1.append(r3);
        r1.append("\n");
        StringBuilder r0 = new StringBuilder(r1.toString());
        EnterRoomTimeTracer.EventName r5 = EnterRoomTimeTracer.EventName.start_enter_room;
        EnterRoomTimeTracer.EventName r6 = EnterRoomTimeTracer.EventName.playing;
        r0.append(b(r11, "total_duration", r5, r6));
        EnterRoomTimeTracer.EventName r7 = EnterRoomTimeTracer.EventName.start_setup;
        r0.append(b(r11, "param_build", r5, r7));
        r0.append(b(r11, "feed_request", EnterRoomTimeTracer.EventName.start_request_feed, EnterRoomTimeTracer.EventName.end_request_feed));
        EnterRoomTimeTracer.EventName r8 = EnterRoomTimeTracer.EventName.end_setup;
        r0.append(b(r11, "start_page", r7, r8));
        EnterRoomTimeTracer.EventName r9 = EnterRoomTimeTracer.EventName.room_container_build;
        r0.append(b(r11, "page_init", r8, r9));
        EnterRoomTimeTracer.EventName r10 = EnterRoomTimeTracer.EventName.play_container_build;
        r0.append(b(r11, "room_container_build", r9, r10));
        EnterRoomTimeTracer.EventName r12 = EnterRoomTimeTracer.EventName.play_container_end;
        r0.append(b(r11, "play_container_build", r10, r12));
        r0.append(b(r11, "wait_playing", r12, r6));
        EnterRoomTimeTracer.EventName r13 = EnterRoomTimeTracer.EventName.start_pull_stream;
        EnterRoomTimeTracer.EventName r14 = EnterRoomTimeTracer.EventName.stream_start;
        r0.append(b(r11, "invoke", r13, r14));
        EnterRoomTimeTracer.EventName r15 = EnterRoomTimeTracer.EventName.stream_first_frame_render_end;
        r0.append(b(r11, "stream_duration", r14, r15));
        EnterRoomTimeTracer.EventName r16 = EnterRoomTimeTracer.EventName.stream_sdk_dns_analysis_end;
        r0.append(b(r11, "sdk_dns_analysis", r14, r16));
        EnterRoomTimeTracer.EventName r17 = EnterRoomTimeTracer.EventName.stream_player_dns_analysis_end;
        r0.append(b(r11, "player_dns_analysis", r16, r17));
        EnterRoomTimeTracer.EventName r18 = EnterRoomTimeTracer.EventName.stream_tcp_connect_end;
        r0.append(b(r11, "tcp_connect", r17, r18));
        EnterRoomTimeTracer.EventName r19 = EnterRoomTimeTracer.EventName.stream_tcp_first_package_end;
        r0.append(b(r11, "tcp_first_package", r18, r19));
        EnterRoomTimeTracer.EventName r20 = EnterRoomTimeTracer.EventName.stream_first_video_package_end;
        r0.append(b(r11, "first_video_package", r19, r20));
        EnterRoomTimeTracer.EventName r21 = EnterRoomTimeTracer.EventName.stream_first_video_frame_decode_end;
        r0.append(b(r11, "first_video_decode", r20, r21));
        r0.append(b(r11, "first_frame_render", r21, r15));
        EnterRoomTimeTracer.EventName r22 = EnterRoomTimeTracer.EventName.first_frame;
        r0.append(b(r11, "callback", r15, r22));
        long r23 = a(r11, EnterRoomTimeTracer.EventName.stream_video_device_wait_start, EnterRoomTimeTracer.EventName.stream_video_device_wait_end);
        r0.append(c("first_frame_view", a(r11, r14, r15) - r23));
        r0.append(c("video_device_wait", r23));
        r0.append(b(r11, "find_stream_info", EnterRoomTimeTracer.EventName.stream_find_stream_info_start, EnterRoomTimeTracer.EventName.stream_find_stream_info_end));
        r0.append(b(r11, "finger_scroll", r13, r5));
        r0.append(b(r11, "first_frame_wait_playing", r22, r6));
        return r0.toString() + "\n";
    L22:
        r3 = "PREVIEW";
        goto L28
    L27:
        r3 = "ATTENTION";
        goto L28
    L24:
        if ("click".equals(f.C) == false) goto L26;
        r3 = "LIVE_BTN";
        goto L28
    L26:
        r3 = "SLIDE";
        goto L28
    L9:
        if (r2.equals("homepage_hot") == false) goto L20;
        r4 = 2;
        goto L20
    L13:
        if (r2.equals("live_merge") == false) goto L20;
        r4 = 1;
        goto L20
    L17:
        if (r2.equals("homepage_follow") == false) goto L20;
        r4 = 0;
        goto L20
    }

    public static String c(String r1, long r2) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return "";
    L7:
        return r1 + " : " + r2 + ",";
    }

    public static long a(SparseArray<EnterRoomTimeTracer.a> r4, EnterRoomTimeTracer.EventName r5, EnterRoomTimeTracer.EventName r6) {
        EnterRoomTimeTracer.a r7 = r4.get(r5.ordinal());
        EnterRoomTimeTracer.a r8 = r4.get(r6.ordinal());
        if (r7 == null) goto L12;
        if (r8 == null) goto L14;
        long r9 = r7.b;
        if (r9 <= 0) goto L15;
        long r2 = r8.b;
        if (r2 > 0) goto L11;
        return -1;
    L11:
        return r2 - r9;
    L15:
        return -1;
    L14:
        return -1;
    L12:
        return -1;
    }

    public static String b(SparseArray<EnterRoomTimeTracer.a> r1, String r2, EnterRoomTimeTracer.EventName r3, EnterRoomTimeTracer.EventName r4) {
        if (r1 != null) goto L4;
        return "";
    L4:
        if (r1.get(EnterRoomTimeTracer.EventName.start_enter_room.ordinal()) != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return "";
    L8:
        if (r1.get(r3.ordinal()) != null) goto L10;
        return "";
    L10:
        if (r1.get(r4.ordinal()) != null) goto L13;
        return "";
    L13:
        return r2 + " : " + a(r1, r3, r4) + ",";
    }
}
