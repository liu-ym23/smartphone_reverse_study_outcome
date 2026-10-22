package ac2;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.interactivity.service.uplink.FrontierTransformConfig;
import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import com.bytedance.android.livesdkapi.ws.host.LiveHostWsMessageBridge;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 implements lmc.h, OnLiveWsMessageReceiveListener {
    public com.ss.ugc.live.sdk.msg.network.m a;

    public static final class a {
    }

    static {
    }

    public final void f() {
        this.a = null;
        LiveHostWsMessageBridge.getInstance().unregisterUplinkListener(this);
    }

    public final boolean g() {
        int r0 = k.a;
        return true;
    }

    public final boolean c() {
        return LiveHostWsMessageBridge.getInstance().isWSConnected();
    }

    public final void e(tlc.f r7) {
        Iterator r0 = r7.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((com.ss.ugc.live.sdk.msg.network.d) r1).a, "im_uplink_service_id") == false) goto L4;
    L9:
        com.ss.ugc.live.sdk.msg.network.d r2 = (com.ss.ugc.live.sdk.msg.network.d) r1;
        if (r2 == null) goto L14;
        String r3 = r2.b;
        if (r3 == null) goto L14;
        int r4 = CastIntegerProtector.parseInt(r3);
    L15:
        LiveWsMessage.Builder r5 = LiveWsMessage.Builder.create(2345234).setLogId(r7.g).setSeqId(r7.h);
        FrontierTransformConfig r6 = x.a;
        Integer r8 = r6.getConfigMap().get(Integer.valueOf(r4));
        if (r8 == null) goto L18;
        int r9 = r8.intValue();
    L19:
        LiveWsMessage.Builder r10 = r5.setService(r9).setMethod(1).setPayload(r7.e).setPayloadType(r7.c).setPayloadEncoding(r7.d).setFrom(4);
        List r11 = r7.f;
        if (r11 == null) goto L42;
        Iterator r13 = r11.iterator();
    L23:
        if (r13.hasNext() == false) goto L42;
        com.ss.ugc.live.sdk.msg.network.d r14 = (com.ss.ugc.live.sdk.msg.network.d) r13.next();
        String r15 = r14.a;
        if (r15 != null) goto L27;
    L30:
        boolean r16 = true;
    L31:
        if (r16 == true) goto L23;
        String r17 = r14.b;
        if (r17 != null) goto L35;
    L38:
        boolean r18 = true;
    L39:
        if (r18 == true) goto L23;
        r10.addMsgHeader(r14.a, r14.b);
        goto L23
    L35:
        if (r17.length() == 0) goto L38;
        r18 = false;
        goto L39
    L27:
        if (r15.length() == 0) goto L30;
        r16 = false;
    L42:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L51;
        HostBoeParams r19 = jc1.k.n(IMiddleWareHostContext.class).getHostBoeParams();
        if (r19 == null) goto L51;
        if (r19.getBoeEnable() == false) goto L49;
        r10.addMsgHeader("X-Tt-Env", r19.getBoeLane());
        goto L51
    L49:
        if (r19.getPpeEnable() == false) goto L51;
        r10.addMsgHeader("X-Tt-Env", r19.getPpeLane());
        r10.addMsgHeader("x-use-ppe", "1");
    L51:
        LiveHostWsMessageBridge.getInstance().sendMsg(r10.build(), null);
        return;
    L18:
        r9 = r6.getDefaultValue();
    L14:
        r4 = 0;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    public final void h(com.ss.ugc.live.sdk.msg.network.m r1) {
        this.a = r1;
        LiveHostWsMessageBridge.getInstance().registerUplinkListener(this);
    }

    public final void onReceiveMsg(LiveWsMessage r4) {
        com.ss.ugc.live.sdk.msg.network.m r0 = this.a;
        if (r0 != null) goto L12;
        return;
    L12:
        tlc.f r5 = bc2.d.b(r4);     // Catch: Exception -> L11
        if (r5 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r5.c, PayloadItemType.PAYLOAD_TYPE_UPLINK.getType()) == false) goto L15;
        bc2.c.b("host ws uplink packet received");     // Catch: Exception -> L11
        r0.i(r5);     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    public final void onReceiveConnectEvent(LiveWsConnectState r1, JSONObject r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        int r3 = b0.a[r1.ordinal()];
        if (r3 != 1) goto L7;
        com.ss.ugc.live.sdk.msg.network.m r4 = this.a;
        if (r4 == null) goto L20;
        r4.a();
        return;
    L20:
        return;
    L7:
        if (r3 != 2) goto L9;
    L11:
        com.ss.ugc.live.sdk.msg.network.m r5 = this.a;
        if (r5 == null) goto L18;
        r5.b("host frontier ws disconnect");
        return;
    L18:
        return;
    L9:
        if (r3 == 3) goto L11;
    }
}
