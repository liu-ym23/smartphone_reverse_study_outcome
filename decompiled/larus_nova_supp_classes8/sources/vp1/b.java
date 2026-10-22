package vp1;

import am2.x;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.livesdk.chatroom.replay_api.service.out.ICameraSwitchTimeExternalService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements ICameraSwitchTimeExternalService, o {
    public Map<String, String> a;
    public boolean b;
    public long c;
    public final SparseArray<C0424b> d;

    public static final class a {
    }

    /* JADX INFO: renamed from: vp1.b$b, reason: collision with other inner class name */
    public static final class C0424b {
        public final String a;
        public final long b;

        public final String toString() {
            return "Event: " + this.a + " : " + this.b + '\n';
        }

        public C0424b(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void startTrace() {
        this.b = false;
        this.d.clear();
        this.c = 0;
        this.a = null;
        this.b = true;
        this.c = System.currentTimeMillis();
        c(ICameraSwitchTimeExternalService.EventName.start_switch_stream);
    }

    public final void a() {
        if (this.b == true) goto L5;
        return;
    L5:
        ICameraSwitchTimeExternalService.EventName r0 = ICameraSwitchTimeExternalService.EventName.start_switch_stream;
        long r1 = g(r0, ICameraSwitchTimeExternalService.EventName.playing);
        if (r1 >= 0) goto L9;
        this.b = false;
        this.d.clear();
        this.c = 0;
        this.a = null;
        this.b = false;
        return;
    L9:
        HashMap r7 = new HashMap();
        this.a = r7;
        ICameraSwitchTimeExternalService.EventName r8 = ICameraSwitchTimeExternalService.EventName.start_pull_stream;
        r7.put("duration_before_pull", String.valueOf(g(r0, r8)));
        ICameraSwitchTimeExternalService.EventName r2 = ICameraSwitchTimeExternalService.EventName.stream_start;
        r7.put("duration_invoke", String.valueOf(g(r8, r2)));
        ICameraSwitchTimeExternalService.EventName r9 = ICameraSwitchTimeExternalService.EventName.stream_first_frame_render_end;
        r7.put("duration_stream_duration", String.valueOf(g(r2, r9)));
        ICameraSwitchTimeExternalService.EventName r10 = ICameraSwitchTimeExternalService.EventName.stream_sdk_dns_analysis_end;
        r7.put("duration_sdk_dns_analysis", String.valueOf(g(r2, r10)));
        ICameraSwitchTimeExternalService.EventName r3 = ICameraSwitchTimeExternalService.EventName.stream_player_dns_analysis_end;
        r7.put("duration_player_dns_analysis", String.valueOf(g(r10, r3)));
        ICameraSwitchTimeExternalService.EventName r11 = ICameraSwitchTimeExternalService.EventName.stream_tcp_connect_end;
        r7.put("duration_tcp_connect", String.valueOf(g(r3, r11)));
        ICameraSwitchTimeExternalService.EventName r4 = ICameraSwitchTimeExternalService.EventName.stream_tcp_first_package_end;
        r7.put("duration_tcp_first_package", String.valueOf(g(r11, r4)));
        ICameraSwitchTimeExternalService.EventName r12 = ICameraSwitchTimeExternalService.EventName.stream_first_video_package_end;
        r7.put("duration_first_video_package", String.valueOf(g(r4, r12)));
        ICameraSwitchTimeExternalService.EventName r5 = ICameraSwitchTimeExternalService.EventName.stream_first_video_frame_decode_end;
        r7.put("duration_first_video_decode", String.valueOf(g(r12, r5)));
        r7.put("duration_first_frame_render", String.valueOf(g(r5, r9)));
        r7.put("duration_callback", String.valueOf(g(r9, ICameraSwitchTimeExternalService.EventName.first_frame)));
        Map<String, String> r6 = this.a;
        if (r6 != null) goto L12;
        this.b = false;
    L20:
        r7.put("duration", String.valueOf(r1));
        JSONObject r13 = r.l().getPlayerStatsLog();
        if (r13 == null) goto L23;
        r7.put("stream_cdn_ip", r13.optString("cdn_ip:"));
        r7.put("stream_cdn_play_url", r13.optString("url:"));
    L23:
        r.l().sendLog("livesdk_machine_change_duration", r7, new Object[]{IRoom.class, new x()});
        this.b = false;
        this.d.clear();
        this.c = 0;
        this.a = null;
        return;
    L12:
        int r14 = this.d.size();
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L20;
        C0424b r16 = this.d.valueAt(r15);
        if (r16 == null) goto L19;
        if (TextUtils.isEmpty(r16.a) == true) goto L19;
        ((HashMap) r6).put(r16.a, String.valueOf(r16.b));
    L19:
        r15 = r15 + 1;
        goto L13
    }

    public b() {
        this.d = new SparseArray();
    }

    public final void c(ICameraSwitchTimeExternalService.EventName r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        f(r3, System.currentTimeMillis());
    }

    public final void d(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        f(ICameraSwitchTimeExternalService.EventName.stream_start, r4.optLong("start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_sdk_dns_analysis_end, r4.optLong("sdk_dns_analysis_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_prepare_block_end, r4.optLong("prepare_block_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_player_dns_analysis_end, r4.optLong("player_dns_analysis_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_tfo_fall_back_time, r4.optLong("tfo_fall_back_time"));
        f(ICameraSwitchTimeExternalService.EventName.stream_tcp_connect_end, r4.optLong("tcp_connect_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_tcp_first_package_end, r4.optLong("tcp_first_package_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_video_package_end, r4.optLong("first_video_package_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_audio_package_end, r4.optLong("first_audio_package_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_video_frame_decode_end, r4.optLong("first_video_frame_decode_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_audio_frame_decode_end, r4.optLong("first_audio_frame_decode_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_frame_from_player_core, r4.optLong("first_frame_from_player_core"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_frame_render_end, r4.optLong("first_frame_render_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_video_device_open_start, r4.optLong("video_device_open_start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_video_device_open_end, r4.optLong("video_device_open_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_audio_device_open_start, r4.optLong("audio_device_open_start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_audio_device_open_end, r4.optLong("audio_device_open_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_prepare_end, r4.optLong("prepare_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_set_surface_time, r4.optLong("set_surface_time"));
        f(ICameraSwitchTimeExternalService.EventName.stream_video_device_wait_start, r4.optLong("video_device_wait_start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_video_device_wait_end, r4.optLong("video_device_wait_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_find_stream_info_start, r4.optLong("find_stream_info_start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_find_stream_info_end, r4.optLong("find_stream_info_end"));
    }

    public final void f(ICameraSwitchTimeExternalService.EventName r4, long r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.b == true) goto L8;
        return;
    L8:
        if (r5 > 0) goto L10;
        return;
    L10:
        if (r5 >= this.c) goto L13;
        return;
    L13:
        if (this.d.get(r4.ordinal()) == null) goto L15;
        return;
    L15:
        this.d.put(r4.ordinal(), new C0424b(r4.toString(), r5));
    }

    public final long g(ICameraSwitchTimeExternalService.EventName r10, ICameraSwitchTimeExternalService.EventName r11) {
        C0424b r12 = this.d.get(r10.ordinal());
        C0424b r13 = this.d.get(r11.ordinal());
        if (r12 == null) goto L13;
        if (r13 == null) goto L13;
        long r0 = r12.b;
        if (r0 <= 0) goto L13;
        long r14 = r13.b;
        if (r14 <= 0) goto L13;
        if ((r14 - r0) > 3600000) goto L13;
        return Math.max(r14 - r0, 0);
    L13:
        return -1;
    }
}
