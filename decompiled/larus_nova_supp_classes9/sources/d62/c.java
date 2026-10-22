package d62;

import android.text.TextUtils;
import com.ss.ugc.live.sdk.message.wrsc.data.Common;
import com.ss.ugc.live.sdk.message.wrsc.data.WebcastRoomDataSyncKeyValue;
import com.ss.ugc.live.sdk.message.wrsc.data.WebcastRoomDataSyncMessage;
import com.ss.ugc.live.sdk.msg.data.HeartbeatPacket;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import ylc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends bmc.c<f> {
    public final int a;
    public final ylc.a b;
    public final d62.a c;
    public final vlc.c d;
    public final String e;

    public static final class a {
    }

    static {
    }

    public final void O40(HeartbeatPacket.Builder r2) {
        Intrinsics.checkNotNullParameter(r2, "packetBuilder");
    }

    public final String kM() {
        return "WebcastRoomDataSyncMessage";
    }

    public final void x40() {
    }

    public final int dB() {
        return this.a;
    }

    public final d a(SdkMessage r11) {
        Intrinsics.checkNotNullParameter(r11, "sdkMessage");
        Long r1 = null;
        if (TextUtils.equals(this.e, r11.method) == true) goto L5;
        return null;
    L5:
        WebcastRoomDataSyncMessage r0 = (WebcastRoomDataSyncMessage) WebcastRoomDataSyncMessage.ADAPTER.decode(r11.payload);
        vlc.c r2 = this.d;
        StringBuilder r3 = new StringBuilder("wrds message received, key with value: ");
        r3.append(zlc.a.a(r0));
        r3.append(", channelId[");
        Common r4 = r0.common;
        if (r4 == null) goto L8;
        r1 = r4.channel_id;
    L8:
        r3.append(r1);
        r3.append("], messageId[");
        r3.append(r0.common.msg_id);
        r3.append(']');
        com.ss.ugc.live.sdk.msg.utils.a.c(r2, r3.toString());
        LinkedHashMap r5 = new LinkedHashMap();
        WebcastRoomDataSyncKeyValue r7 = new WebcastRoomDataSyncKeyValue.Builder().payload(r0.payload).bizLogID(r0.bizLogID).version(r0.version).msgID(r11.msg_id).build();
        String r6 = r0.syncKey;
        if (r6 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == true) goto L19;
        if (r7 == null) goto L19;
        Object r9 = this.b.a(r6, r7);
        r5.put(r6, new com.ss.ugc.live.sdk.message.wrsc.data.a(r0.roomID.longValue(), r6, r7, r9));
    L19:
        return new f(this.a, r11, r0, r5);
    L11:
        if (r6.length() == 0) goto L14;
        r8 = false;
        goto L15
    }

    public final void b(d r5) {
        f r6 = (f) r5;
        Intrinsics.checkNotNullParameter(r6, "message");
        com.ss.ugc.live.sdk.msg.utils.a.c(this.d, "wrds message update and notify, key with value: " + zlc.a.b(r6) + ", channelId[" + r6.b + "], messageId[" + r6.getMessageId() + ']');
        this.c.a(r6, this.d);
    }

    public c(int r3, com.bytedance.android.livesdk.wrds.a r4, b r5, com.bytedance.android.livesdk.interactivity.base.im.b r6) {
        Intrinsics.checkNotNullParameter(r4, "wrdsDecoder");
        Intrinsics.checkNotNullParameter(r5, "wrdsConsumer");
        Intrinsics.checkNotNullParameter(r6, "logger");
        Intrinsics.checkNotNullParameter("WebcastRoomDataSyncMessage", "wrdsMessageMethod");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = "WebcastRoomDataSyncMessage";
    }
}
