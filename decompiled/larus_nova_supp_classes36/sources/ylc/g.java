package ylc;

import android.text.TextUtils;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import com.ss.ugc.live.sdk.message.wrsc.data.WebcastRoomDataSyncKeyValue;
import com.ss.ugc.live.sdk.message.wrsc.data.WebcastRoomDataSyncMessage;
import com.ss.ugc.live.sdk.msg.data.HeartbeatPacket;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.dispatch.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends bmc.c<f> {
    public final int a;
    public final ylc.a b;
    public final e c;
    public final vlc.c d;
    public final String e;

    public static final class a {
    }

    static {
    }

    @Override // bmc.a
    public final void x40() {
    }

    @Override // bmc.a
    public final int dB() {
        return this.a;
    }

    @Override // bmc.a
    public final String kM() {
        return this.e;
    }

    @Override // bmc.a
    public final void O40(HeartbeatPacket.Builder r8) {
        Intrinsics.checkNotNullParameter(r8, "packetBuilder");
        e r0 = this.c;
        r0.getClass();
        ArrayList r1 = new ArrayList();
        LimitedSizeHashMap<String, Long> r2 = r0.d;
        ArrayList r3 = new ArrayList(r2.size());
        Iterator<Map.Entry<String, Long>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, Long> r5 = r4.next();
        r3.add(new HeartbeatPacket.WrdsKeyVersion(r5.getKey(), r5.getValue()));
        goto L4
    L6:
        r1.addAll(r3);
        LimitedSizeHashMap<String, Long> r6 = r0.e;
        ArrayList r7 = new ArrayList(r6.size());
        Iterator<Map.Entry<String, Long>> r9 = r6.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        Map.Entry<String, Long> r10 = r9.next();
        r7.add(new HeartbeatPacket.WrdsKeyVersion(r10.getKey(), r10.getValue()));
        goto L8
    L10:
        r1.addAll(r7);
        r8.wrdsKeyVersions(r1).roomID(Long.valueOf(this.c.f));
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.f
    public final tlc.d a(SdkMessage r14) {
        Intrinsics.checkNotNullParameter(r14, "sdkMessage");
        if (TextUtils.equals(this.e, r14.method) == true) goto L5;
        return null;
    L5:
        WebcastRoomDataSyncMessage r0 = (WebcastRoomDataSyncMessage) WebcastRoomDataSyncMessage.ADAPTER.decode(r14.payload);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.d, "wrds message received, key with value: " + zlc.a.a(r0));
        LinkedHashMap r2 = new LinkedHashMap();
        WebcastRoomDataSyncKeyValue r8 = new WebcastRoomDataSyncKeyValue.Builder().payload(r0.payload).bizLogID(r0.bizLogID).version(r0.version).msgID(r14.msg_id).m1667build();
        String r3 = r0.syncKey;
        boolean r10 = true;
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L34;
        if (r8 == null) goto L34;
        com.ss.ugc.live.sdk.message.wrsc.data.a r12 = new com.ss.ugc.live.sdk.message.wrsc.data.a(r0.roomID.longValue(), r3, r8, this.b.a(r3, r8));
        long r5 = r12.f;
        if (r5 == this.c.f) goto L32;
        Set<Long> r15 = j.a;
        Intrinsics.checkNotNullParameter(r12, "dataSync");
        if (((CopyOnWriteArraySet) j.a).contains(Long.valueOf(r5)) == false) goto L28;
        Intrinsics.checkNotNullParameter(r12, "dataSync");
        String r1 = j.a(r12.g, null);
        ConcurrentHashMap r6 = (ConcurrentHashMap) j.c;
        Map r7 = (Map) r6.get(Long.valueOf(r5));
        if (r7 != null) goto L23;
        r7 = new ConcurrentHashMap();
        r6.put(Long.valueOf(r5), r7);
    L23:
        tlc.c r9 = (tlc.c) r7.get(r1);
        if (r9 != null) goto L26;
    L29:
        r7.put(r1, r12);
    L30:
        vlc.c r11 = this.d;
        StringBuilder r13 = new StringBuilder("receive preload wrds: ");
        Intrinsics.checkNotNullParameter(r12, "dataSync");
        r13.append(j.a(r12.g, null));
        r13.append('_');
        r13.append(r12.f);
        r13.append(", preload: ");
        r13.append(r10);
        com.ss.ugc.live.sdk.msg.utils.a.c(r11, r13.toString());
        return null;
    L26:
        if (r12.a > r9.getWRDSVersion()) goto L29;
    L28:
        r10 = false;
        goto L30
    L32:
        r2.put(r3, r12);
    L34:
        return new f(this.a, r14, r0, r2);
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    @Override // bmc.c
    public final void b(tlc.d r23) {
        f r1 = (f) r23;
        Intrinsics.checkNotNullParameter(r1, INotificationHitPoint.NoticeType.MESSAGE);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.d, "wrds message update and notify, key with value: " + zlc.a.b(r1));
        e r3 = this.c;
        vlc.c r4 = this.d;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "logger");
        if (r3.a.isEmpty() == false) goto L8;
        r3.a.putAll(r1.h);
        Iterator r2 = ((LinkedHashMap) r3.a).entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L45;
        Map.Entry r5 = (Map.Entry) r2.next();
        ((com.ss.ugc.live.sdk.message.wrsc.data.a) r5.getValue()).getClass();
        r3.g((com.ss.ugc.live.sdk.message.wrsc.data.a) r5.getValue());
        goto L6
    L45:
        return;
    L8:
        Iterator<Map.Entry<String, com.ss.ugc.live.sdk.message.wrsc.data.a>> r6 = r1.h.entrySet().iterator();
        vlc.c r7 = r4;
    L10:
        if (r6.hasNext() == false) goto L50;
        Map.Entry<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r8 = r6.next();
        com.ss.ugc.live.sdk.message.wrsc.data.a r9 = r8.getValue();
        com.ss.ugc.live.sdk.message.wrsc.data.a r10 = (com.ss.ugc.live.sdk.message.wrsc.data.a) ((LinkedHashMap) r3.a).get(r8.getKey());
        if (r10 != null) goto L14;
    L17:
        boolean r11 = true;
    L19:
        if (r11 == false) goto L29;
        r3.a.put(r8.getKey(), r9);
        r9.getClass();
        r3.g(r9);
        JSONObject r12 = new JSONObject();
        r12.put(TabAppInfo.IMAGE_JSON_KEY, r9.g);
        JSONObject r0 = new JSONObject();
        if (r10 == null) goto L23;
        long r13 = r10.a;
    L24:
        r0.put("previous_version", r13);
        r0.put("receive_version", r9.a);
        r0.put("msg_id", r9.b);
        r0.put("bizLogId", r9.c);
        r0.put("room_id", r3.f);
        r3.h.e("wrds_version_update", r12, null, r0);
        StringBuilder r14 = new StringBuilder("wrds key: ");
        r14.append(r8.getKey());
        r14.append(" update, previous version: ");
        if (r10 == null) goto L27;
        Long r15 = Long.valueOf(r10.a);
    L28:
        r14.append(r15);
        r14.append(", update version: ");
        r14.append(r9.a);
        com.ss.ugc.live.sdk.msg.utils.a.c(r4, r14.toString());
        r7 = r4;
    L44:
        r6 = r6;
        r4 = r4;
        goto L10
    L27:
        r15 = null;
        goto L28
    L23:
        r13 = -1;
        goto L24
    L29:
        r4 = r4;
        JSONObject r16 = new JSONObject();
        r16.put(TabAppInfo.IMAGE_JSON_KEY, r9.g);
        long r17 = r9.a;
        if (r10 != null) goto L32;
    L34:
        boolean r18 = false;
    L35:
        r16.put("version_equal", r18);
        JSONObject r19 = new JSONObject();
        if (r10 == null) goto L38;
        long r110 = r10.a;
    L39:
        r19.put("previous_version", r110);
        r19.put("receive_version", r9.a);
        r19.put("msg_id", r9.b);
        r19.put("bizLogId", r9.c);
        r19.put("room_id", r3.f);
        r3.h.e("wrds_version_error", r16, null, r19);
        StringBuilder r20 = new StringBuilder("wrds key: ");
        r20.append(r8.getKey());
        r20.append(" no need update, previous version: ");
        if (r10 == null) goto L42;
        Long r111 = Long.valueOf(r10.a);
    L43:
        r20.append(r111);
        r20.append(", update version: ");
        r20.append(r9.a);
        com.ss.ugc.live.sdk.msg.utils.a.c(r7, r20.toString());
        goto L44
    L42:
        r111 = null;
        goto L43
    L38:
        r110 = -1;
        goto L39
    L32:
        if (r17 != r10.a) goto L34;
        r18 = true;
        goto L35
    L14:
        if (r9.a > r10.a) goto L17;
        r11 = false;
        goto L19
    }

    public g(int r2, com.bytedance.android.livesdk.wrds.a r3, e r4, vlc.c r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "wrdsDecoder");
        Intrinsics.checkNotNullParameter(r4, "manager");
        Intrinsics.checkNotNullParameter(r5, "logger");
        Intrinsics.checkNotNullParameter(r6, "wrdsMessageMethod");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
