package com.bytedance.android.live.multilink.impl;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.config.ub1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.model.PlayerFirstFrameInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkSeiIndicator {
    public final ub1 a;
    public Disposable b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public HashMap<String, String> h;
    public boolean i;
    public boolean j;
    public long k;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/MultiLinkSeiIndicator$Source;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "LINK_END", "LEAVE_ROOM", "SWITCH_RESOLUTION", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Source extends Enum<Source> {
        public static final Source LEAVE_ROOM = null;
        public static final Source LINK_END = null;
        public static final Source SWITCH_RESOLUTION = null;
        public static final /* synthetic */ Source[] a = null;
        private final String type;

        static {
            Source r1 = new Source("LINK_END", 0, "link_end");
            LINK_END = r1;
            Source r2 = new Source("LEAVE_ROOM", 1, "leave_room");
            LEAVE_ROOM = r2;
            Source r3 = new Source("SWITCH_RESOLUTION", 2, "switch_resolution");
            SWITCH_RESOLUTION = r3;
            a = new Source[]{r1, r2, r3};
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public Source(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final HashMap<String, String> a() {
        ILivePlatformPlayerProxy r0 = hs0.a.b.curRoomPlayer();
        if (r0 == null) goto L5;
        ILivePlayerClient r1 = r0.player();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        HashMap<String, String> r2 = new HashMap();
        JSONObject r3 = r1.getStatsLog();
        String r4 = r1.getCurrentResolution();
        if (r3 == null) goto L14;
        r2.put("stream_cdn_ip", r3.optString("cdn_ip:"));
        r2.put("stream_cdn_play_url", r3.optString("url:"));
        if (r4 != null) goto L13;
        r4 = r3.optString("resolution:");
    L13:
        r2.put("resolution", r4);
        r2.put("download_speed", r3.optString("download_Speed:"));
        r2.put("domain", r3.optString("domain:"));
        r2.put("play_protocol", r3.optString("play_protocol:"));
        r2.put("play_format", r3.optString("play_format:"));
        r2.put("codec_type", r3.optString("Codec_Type:"));
        r2.put("codec_name", r3.optString("Codec_Name:"));
    L14:
        String r5 = (String) r1.getEventHub().getPlayerMediaError().getValue();
        if (r5 != null) goto L17;
    L21:
        Boolean r6 = (Boolean) r1.getEventHub().getPlayPrepared().getValue();
        if (r6 != null) goto L24;
        r6 = Boolean.FALSE;
    L24:
        String r7 = "1";
        if (r6.booleanValue() == false) goto L27;
        String r8 = "1";
    L28:
        r2.put("play_prepared", r8);
        if (r1.isPlaying() == false) goto L31;
        String r9 = "1";
    L32:
        r2.put("is_playing", r9);
        Boolean r10 = (Boolean) r1.getEventHub().getFirstFrame().getValue();
        if (r10 != null) goto L36;
        r10 = Boolean.FALSE;
    L36:
        if (r10.booleanValue() == false) goto L38;
        String r11 = "1";
    L39:
        r2.put("first_frame", r11);
        if (this.i == true) goto L43;
        r7 = "0";
    L43:
        r2.put("is_background", r7);
        IRoom r12 = je0.d.e(null);
        if (r12 == null) goto L46;
        r2.put("room_id", String.valueOf(r12.getRoomId()));
    L46:
        r2.put("scene", String.valueOf(je0.d.f()));
        r2.put("ui_layout", String.valueOf(je0.d.h()));
        return r2;
    L38:
        r11 = "0";
        goto L39
    L31:
        r9 = "0";
        goto L32
    L27:
        r8 = "0";
        goto L28
    L17:
        if (StringsKt.isBlank(r5) == true) goto L21;
        JSONObject r13 = new JSONObject(r5);     // Catch: Exception -> L20
        r2.put("pull_stream_error_code", r13.optString("error_code"));     // Catch: Exception -> L20
        r2.put("pull_stream_error_reason", r13.optString("error_description"));     // Catch: Exception -> L20
        goto L21
    L5:
        r1 = null;
        goto L6
    }

    public MultiLinkSeiIndicator() {
        this.a = (ub1) vm2.h.G5.getValue(null, vm2.h.a[343(0x157, float:4.8E-43)]);
        this.c = -1;
        this.d = -1;
        this.j = true;
    }

    public final void c(String r12) {
        Intrinsics.checkNotNullParameter(r12, "seiString");
        if (this.a.b() == true) goto L6;
        return;
    L6:
        if (this.g > 0) goto L8;
        return;
    L8:
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r12) == false) goto L53;
        Disposable r0 = this.b;
        if (r0 == null) goto L14;
        r0.dispose();
    L14:
        if (this.j == false) goto L52;
        ILivePlatformPlayerProxy r1 = hs0.a.b.curRoomPlayer();
        PlayerFirstFrameInfo r3 = null;
        if (r1 == null) goto L18;
        ILivePlayerClient r2 = r1.player();
    L19:
        if (r2 == null) goto L23;
        LivePlayerClientContext r4 = r2.context();
        if (r4 == null) goto L23;
        r3 = r4.getFirstFrameInfo();
    L23:
        if (r3 == null) goto L52;
        long r5 = r3.getTs();
        long r6 = System.currentTimeMillis();
        String r7 = r3.getSei();
        if (r7 != null) goto L27;
    L37:
        boolean r8 = true;
    L38:
        long r9 = this.k;
        long r10 = r6 - r9;
        long r11 = r9 - r5;
        HashMap r13 = new HashMap();
        HashMap<String, String> r14 = a();
        if (r14 == null) goto L41;
        r13.putAll(r14);
    L41:
        r13.put("current_mode", String.valueOf(this.g));
        if (r8 == false) goto L44;
        String r15 = "1";
    L45:
        r13.put("is_first", r15);
        r13.put("biz_to_sei_duration", String.valueOf(r10));
        r13.put("firstsei_to_biz_duration", String.valueOf(r11));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_multi_link_first_biz_sei", r13, new Object[]{IRoom.class});
        if (this.a.c() == false) goto L52;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r13, "logMap");
        JSONObject r16 = new JSONObject();
        Iterator r17 = r13.entrySet().iterator();
    L49:
        if (r17.hasNext() == false) goto L51;
        Map.Entry r18 = (Map.Entry) r17.next();
        r16.put((String) r18.getKey(), r18.getValue());
        goto L49
    L51:
        nd0.c.o(nd0.c.a, LinkMonitorData.MultiLinkFirstBizSei, r16, 0, null, true, 12);
        goto L52
    L44:
        r15 = "0";
        goto L45
    L27:
        if (r7.length() <= 0) goto L29;
        boolean r19 = true;
    L30:
        if (r19 != true) goto L37;
        String r20 = r3.getSei();
        if (r20 == null) goto L37;
        if (r20.equals(r12) == true) goto L37;
        r8 = false;
        goto L38
    L29:
        r19 = false;
        goto L30
    L18:
        r2 = null;
    L52:
        this.j = false;
        com.bytedance.android.livesdk.log.b0 r21 = com.bytedance.android.livesdk.log.b0.o();
        String r22 = "onSei mode=" + this.g + ' ' + r12;
        r21.getClass();
        com.bytedance.android.live.core.log.g.i("MultiLinkSeiIndicator", r22);
    L53:
        LiveSeiUtil.i.getClass();
        JSONObject r110 = LiveSeiUtil.c(r12);
        if (r110.has("sei_index") == false) goto L68;
        Integer r111 = StringsKt.toIntOrNull(r110.optString("sei_index"));
        if (r111 == null) goto L69;
        int r112 = r111.intValue();
        if (this.c >= 0) goto L60;
        this.c = r112;
        this.d = r112;
        this.h = a();
        return;
    L60:
        int r23 = this.d;
        if (r112 <= r23) goto L71;
        int r24 = (r112 - r23) - 1;
        if (r24 <= 0) goto L65;
        this.f = r24;
    L65:
        this.e += r24;
        this.d = r112;
        return;
    L71:
        return;
    L69:
        return;
    }

    public final void b(int r9, Source r10) {
        if (this.d > 0) goto L5;
        return;
    L5:
        if (this.c <= 0) goto L31;
        HashMap r0 = new HashMap();
        HashMap<String, String> r1 = this.h;
        if (r1 == null) goto L9;
        r0.putAll(r1);
    L13:
        if (r10 != Source.SWITCH_RESOLUTION) goto L17;
        int r2 = this.f;
        if (r2 <= 0) goto L17;
        this.e -= r2;
        this.f = 0;
    L17:
        r0.put("current_mode", String.valueOf(r9));
        r0.put("source", r10.getType());
        int r11 = this.d - this.c;
        r0.put("expected_sei_count", String.valueOf(r11));
        int r12 = r11 - this.e;
        r0.put("received_sei_count", String.valueOf(r12));
        if (r11 <= 0) goto L20;
        String r13 = String.valueOf((r12 * 1.0f) / r11);
    L21:
        r0.put("arrival_rate", r13);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_multi_link_sei_arrival_rate", r0, new Object[]{IRoom.class});
        if (this.a.c() == false) goto L32;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "logMap");
        JSONObject r3 = new JSONObject();
        Iterator r14 = r0.entrySet().iterator();
    L25:
        if (r14.hasNext() == false) goto L27;
        Map.Entry r15 = (Map.Entry) r14.next();
        r3.put((String) r15.getKey(), r15.getValue());
        goto L25
    L27:
        nd0.c.o(nd0.c.a, LinkMonitorData.MultiLinkSeiArrivalRate, r3, 0, null, true, 12);
        return;
    L32:
        return;
    L20:
        r13 = "";
        goto L21
    L9:
        HashMap<String, String> r4 = a();
        if (r4 == null) goto L13;
        r0.putAll(r4);
        goto L13
    }
}
