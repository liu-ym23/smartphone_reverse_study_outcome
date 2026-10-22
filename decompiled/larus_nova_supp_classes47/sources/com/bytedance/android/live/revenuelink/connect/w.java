package com.bytedance.android.live.revenuelink.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenuelink.withroom.LinkStoreService;
import com.bytedance.android.livesdk.link.model.a7;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdk.link.model.bridge.t1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.badger.collect.impl.constants.Constants;
import fr2.g0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w extends y50.b implements o {
    public final com.bytedance.android.live.revenuelink.withroom.a b;
    public final IRoomBase c;

    public static final class a {
    }

    static {
    }

    public final void b(JSONObject r7) {
        com.bytedance.android.live.revenuelink.withroom.a r0 = this.b;
        if (r0 == null) goto L7;
        g r1 = r0.getAnchorConnectUtils();
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.getChannelId());
    L8:
        y50.b.a.c(r7, "channel_id", r2.longValue());
        com.bytedance.android.live.revenuelink.withroom.a r3 = this.b;
        if (r3 == null) goto L17;
        f r4 = r3.Z0();
        if (r4 == null) goto L17;
        LiveData<ey.f> r5 = r4.connectState();
        if (r5 == null) goto L17;
        ey.f r6 = (ey.f) r5.getValue();
        if (r6 == null) goto L17;
        y50.b.a.d(r7, "connect_state", r6.toString());
    L17:
        IRoomBase r8 = this.c;
        if (r8 == null) goto L20;
        String r9 = r8.getIdStr();
    L21:
        y50.b.a.d(r7, "room_id", r9);
        if (r8 == null) goto L26;
        IBaseUser r10 = r8.getOwnerKt();
        if (r10 == null) goto L26;
        String r12 = r10.getIdString();
    L27:
        y50.b.a.d(r7, "anchor_id", r12);
        com.bytedance.android.live.revenuelink.withroom.a r13 = this.b;
        if (r13 == null) goto L57;
        com.bytedance.android.live.revenuelink.rtc.f r14 = r13.m0();
        if (r14 == null) goto L58;
        com.bytedance.android.live.revenuelink.rtc.i r15 = r14.getRtcManager();
        if (r15 == null) goto L59;
        y50.b.a.d(r7, "rtc_users", r15.L().toString());
        if ((!r15.L0().isEmpty()) == false) goto L60;
        List<vc0.a> r16 = r15.L0();
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L37:
        if (r18.hasNext() == false) goto L52;
        vc0.a r19 = (vc0.a) r18.next();
        Object r20 = r19.b;
        if ((r20 instanceof xh6.c) == true) goto L41;
        xh6.c r22 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.g.class), r19.a);
        if ((r22 instanceof fr2.g) == true) goto L47;
        r22 = null;
    L47:
        fr2.g r23 = (fr2.g) r22;
    L48:
        if (r23 == null) goto L50;
        String r24 = r23.getRoomId();
    L51:
        r17.add(r24);
        goto L37
    L50:
        r24 = null;
        goto L51
    L41:
        if ((r20 instanceof fr2.g) == true) goto L43;
        r20 = null;
    L43:
        r23 = (fr2.g) r20;
        goto L48
    L52:
        y50.b.a.d(r7, "forward_rooms", r17.toString());
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L26:
        r12 = null;
        goto L27
    L20:
        r9 = null;
    L7:
        r2 = null;
        goto L8
    }

    public w(LinkStoreService r2, IRoomBase r3) {
        Intrinsics.checkNotNullParameter(r2, "storeService");
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.o
    public final void a(long r20, String r22, String r23, long r24, a7 r26, Throwable r27) {
        Intrinsics.checkNotNullParameter(r22, "reqSrc");
        com.bytedance.android.live.revenuelink.withroom.a r7 = this.b;
        if (r7 == null) goto L9;
        com.bytedance.android.live.revenuelink.f r8 = r7.getRevenueLinkTraceMonitor();
        if (r8 == null) goto L9;
        if (r8.X("linkmic/get_cross_room_rtc_info/") != true) goto L9;
        return;
    L9:
        JSONObject r9 = new JSONObject();
        LiveTracingMonitorKt.EventModule r12 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
        y50.b.a.c(r9, "channelId", r20);
        y50.b.a.c(r9, Constants.Keys.duration, r24);
        y50.b.a.c(r9, "req_channel_id", r20);
        y50.b.a.d(r9, "req_src", r22);
        y50.b.a.d(r9, "error_msg", r23);
        Throwable r15 = null;
        if (r26 == null) goto L14;
        s1 r10 = r26.getMultiChannel();
        if (r10 == null) goto L14;
        String r13 = t1.a(r10);
    L15:
        y50.b.a.d(r9, "resp_multi_channel_info", r13);
        if (r26 == null) goto L20;
        b2 r14 = r26.getPreRtcInfo();
        if (r14 == null) goto L20;
        String r16 = c2.a(r14);
    L21:
        y50.b.a.d(r9, "resp_pre_rtc_info", r16);
        b(r9);
        String r17 = "";
        if (r27 == null) goto L45;
        HashMap r2 = new HashMap();
        r2.put("server_api_name", "linkmic/get_cross_room_rtc_info/");
        r2.put("android_event_key", "get_cross_room_rtc_info_failed");
        y50.b.a.d(r9, "exception_info", r27.toString());
        jy0.b.c("ttlive_anchor_link_multi_channel", "get_cross_room_rtc_info_failed: " + r9, null, 4);
        boolean r3 = r27 instanceof ApiServerException;
        if (r3 == true) goto L26;
        Throwable r4 = null;
    L27:
        ApiServerException r5 = (ApiServerException) r4;
        if (r5 == null) goto L30;
        int r6 = r5.getErrorCode();
    L31:
        if (r3 == false) goto L34;
        r15 = r27;
    L34:
        ApiServerException r18 = (ApiServerException) r15;
        if (r18 == null) goto L40;
        String r19 = r18.getErrorMsg();
        if (r19 == null) goto L40;
        r17 = r19;
    L40:
        com.bytedance.android.live.revenuelink.withroom.a r25 = this.b;
        if (r25 == null) goto L108;
        com.bytedance.android.live.revenuelink.f r28 = r25.getRevenueLinkTraceMonitor();
        if (r28 == null) goto L109;
        r28.c0("get_cross_room_rtc_info_failed", r12, r6, r17, r2, r9);
        return;
    L109:
        return;
    L108:
        return;
    L30:
        r6 = -1;
        goto L31
    L26:
        r4 = r27;
        goto L27
    L45:
        HashMap r29 = new HashMap();
        r29.put("server_api_name", "linkmic/get_cross_room_rtc_info/");
        r29.put("android_event_key", "get_cross_room_rtc_info_success");
        jy0.b.f("ttlive_anchor_link_multi_channel", "get_cross_room_rtc_info_success: " + r9, null, 4);
        int r110 = r9.optInt("error_code");
        String r111 = r9.optString("error_msg");
        com.bytedance.android.live.revenuelink.withroom.a r112 = this.b;
        if (r112 == null) goto L51;
        com.bytedance.android.live.revenuelink.f r113 = r112.getRevenueLinkTraceMonitor();
        if (r113 == null) goto L51;
        r113.c0("get_cross_room_rtc_info_success", r12, r110, r111, r29, r9);
    L51:
        if (r26 == null) goto L111;
        s1 r30 = r26.getMultiChannel();
        if (r30 != null) goto L55;
        return;
    L55:
        if (r30.getUseMultiChannel() != true) goto L113;
        s1 r32 = r26.getMultiChannel();
        Intrinsics.checkNotNullParameter(r22, "reqSrc");
        if (r32 == null) goto L119;
        com.bytedance.android.live.revenuelink.withroom.a r33 = this.b;
        if (r33 == null) goto L114;
        com.bytedance.android.live.revenuelink.rtc.f r34 = r33.m0();
        if (r34 == null) goto L115;
        com.bytedance.android.live.revenuelink.rtc.i r35 = r34.getRtcManager();
        if (r35 == null) goto L120;
        List<vc0.a> r36 = r35.L0();
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator<T> r38 = r36.iterator();
    L68:
        if (r38.hasNext() == false) goto L84;
        vc0.a r114 = (vc0.a) r38.next();
        Object r115 = r114.b;
        if ((r115 instanceof xh6.c) == true) goto L72;
        xh6.c r116 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.g.class), r114.a);
        if ((r116 instanceof fr2.g) == true) goto L78;
        r116 = null;
    L78:
        fr2.g r117 = (fr2.g) r116;
    L79:
        if (r117 == null) goto L82;
        String r118 = r117.getRoomId();
        if (r118 == null) goto L82;
    L83:
        r37.add(r118);
    L82:
        r118 = "";
        goto L83
    L72:
        if ((r115 instanceof fr2.g) == true) goto L74;
        r115 = null;
    L74:
        r117 = (fr2.g) r115;
        goto L79
    L84:
        List r39 = CollectionsKt.sorted(r37);
        Map r40 = r32.getChannelMap();
        if (r40 == null) goto L95;
        Set r42 = r40.keySet();
        if (r42 == null) goto L95;
        Sequence r43 = CollectionsKt.asSequence(r42);
        if (r43 == null) goto L95;
        Sequence r44 = SequencesKt.map(r43, MultiChannelMonitor$checkForwardListCorrected$newForwardList$1.INSTANCE);
        if (r44 == null) goto L95;
        Sequence r45 = SequencesKt.sorted(r44);
        if (r45 == null) goto L95;
        List r119 = SequencesKt.toList(r45);
    L97:
        if ((!Intrinsics.areEqual(r39, r119)) == false) goto L103;
        JSONObject r46 = new JSONObject();
        y50.b.a.d(r46, "req_src", r22);
        y50.b.a.d(r46, "error_msg", r23);
        y50.b.a.d(r46, "new_forward", String.valueOf(r119));
        b(r46);
        LiveTracingMonitorKt.EventModule r1 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
        HashMap r47 = new HashMap();
        r47.put("android_event_key", "forward_list_corrected");
        jy0.b.f("ttlive_anchor_link_multi_channel", "forward_list_corrected: " + r46, null, 4);
        int r48 = r46.optInt("error_code");
        String r49 = r46.optString("error_msg");
        com.bytedance.android.live.revenuelink.withroom.a r50 = this.b;
        if (r50 == null) goto L116;
        com.bytedance.android.live.revenuelink.f r52 = r50.getRevenueLinkTraceMonitor();
        if (r52 == null) goto L117;
        r52.c0("forward_list_corrected", r1, r48, r49, r47, r46);
        return;
    L117:
        return;
    L116:
        return;
    L103:
        jy0.b.d(r13, "forwardList is consistent with local data");
        return;
    L95:
        r119 = null;
        goto L97
    L120:
        return;
    L115:
        return;
    L114:
        return;
    L119:
        return;
    L113:
        return;
    L111:
        return;
    L20:
        r16 = null;
    L14:
        r13 = null;
        goto L15
    }
}
