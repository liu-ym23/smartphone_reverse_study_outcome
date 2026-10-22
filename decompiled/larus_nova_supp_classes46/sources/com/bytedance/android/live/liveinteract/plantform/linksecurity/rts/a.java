package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import am3.g;
import android.util.Base64;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.model.LinkMicRtsMessage;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.model.LinkmicRtsKickOutContent;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.model.LinkmicRtsUpdateLinkStatusContent;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.user.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements fg6.a {
    public final CopyOnWriteArrayList<c> a;
    public final dn0.c b;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a$a, reason: collision with other inner class name */
    public static final class C0059a {
    }

    public interface b {
        void c();
    }

    public interface c {
        void onReceiveAedStateMessage(String r1);

        void onReceiveKickOutMsg(LinkmicRtsKickOutContent r1);

        void onReceiveUpdateLinkStatusMsg(LinkmicRtsUpdateLinkStatusContent r1);

        void onRoomRtsMessage(String r1);
    }

    static {
    }

    public a(dn0.c r1) {
        this.b = r1;
        this.a = new CopyOnWriteArrayList();
    }

    public final void J3(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        if (vm2.d.N() == true) goto L7;
        ALogger.w("RTSHandler", "call handleRtsRoomMessage can not handle rts: setting no support");
        return;
    L7:
        if (Intrinsics.areEqual(r5, "LinkmicRtsServer") == true) goto L61;
        Iterator<c> r7 = this.a.iterator();
    L58:
        if (r7.hasNext() == false) goto L67;
        r7.next().onRoomRtsMessage(r6);
        goto L58
    L67:
        return;
    L61:
        byte[] r8 = Base64.decode(r6, 0);     // Catch: Exception -> L55
        am3.c r9 = ((IMiddlewareNetworkService) k.n(IMiddlewareNetworkService.class)).getProtoDecoder(LinkMicRtsMessage.class);     // Catch: Exception -> L55
        if (r9 == null) goto L12;
        g r1 = new g();     // Catch: Exception -> L55
        r1.k(new am3.b(r8));     // Catch: Exception -> L55
        LinkMicRtsMessage r10 = (LinkMicRtsMessage) r9.decode(r1);     // Catch: Exception -> L55
    L14:
        String r11 = "";
        if (r10 == null) goto L18;
        String r2 = r10.toString();     // Catch: Exception -> L55
        if (r2 == null) goto L18;
    L19:
        ALogger.i("RTSHandler", "handleRtsRoomMessage message = ".concat(r2));     // Catch: Exception -> L55
        e r0 = k.n(IMiddlewareUserService.class).user();     // Catch: Exception -> L55
        if (r0 == null) goto L25;
        IBaseUser r3 = r0.b();     // Catch: Exception -> L55
        if (r3 == null) goto L25;
        String r4 = r3.getIdString();     // Catch: Exception -> L55
        if (r4 == null) goto L25;
    L26:
        if (r10 == null) goto L29;
        List<Long> r12 = r10.getMockFilterUidList();     // Catch: Exception -> L55
        if (r12 == null) goto L29;
    L31:
        if (CollectionsKt.contains(r12, StringsKt.toLongOrNull(r4)) == false) goto L34;
        ALogger.w("RTSHandler", "call handleRtsRoomMessage can not handle rts: user in filter list");     // Catch: Exception -> L55
        return;
    L34:
        if (r10 != null) goto L36;
        return;
    L36:
        if (r10.getMessageType() != 1) goto L64;
        LinkmicRtsUpdateLinkStatusContent r13 = r10.getUpdateLinkStatusContent();     // Catch: Exception -> L55
        if (r13 != null) goto L40;
    L50:
        Iterator<c> r14 = this.a.iterator();     // Catch: Exception -> L55
    L52:
        if (r14.hasNext() == false) goto L66;
        c r15 = r14.next();     // Catch: Exception -> L55
        LinkmicRtsUpdateLinkStatusContent r16 = r10.getUpdateLinkStatusContent();     // Catch: Exception -> L55
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L55
        r15.onReceiveUpdateLinkStatusMsg(r16);     // Catch: Exception -> L55
        goto L52
    L66:
        return;
    L40:
        if (r13.getNeedAck() != true) goto L50;
        dn0.c r17 = this.b;     // Catch: Exception -> L55
        if (r17 == null) goto L50;
        LinkmicRtsUpdateLinkStatusContent r18 = r10.getUpdateLinkStatusContent();     // Catch: Exception -> L55
        if (r18 == null) goto L49;
        String r19 = r18.getAckMessage();     // Catch: Exception -> L55
        if (r19 == null) goto L49;
        r11 = r19;
    L49:
        r17.Z(r4, r11, AckFromSource.LINK_MULTI_RTS);     // Catch: Exception -> L55
        goto L50
    L64:
        return;
    L29:
        r12 = new ArrayList();     // Catch: Exception -> L55
    L25:
        r4 = "";
    L18:
        r2 = "";
        goto L19
    L12:
        r10 = null;
    L55:
        ALogger.e("RTSHandler", "call handleRtsRoomMessage parse err.");
    }

    public final void a(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "from");
        Intrinsics.checkNotNullParameter(r7, MultiLinkOpenSource.MESSAGE);
        if (vm2.d.N() == true) goto L7;
        ALogger.w("RTSHandler", "call handleRtsUserMessage can not handle rts: setting no support");
        return;
    L7:
        if (Intrinsics.areEqual(r6, "LinkmicRtsServer") == true) goto L67;
        Iterator<c> r8 = this.a.iterator();
    L64:
        if (r8.hasNext() == false) goto L73;
        r8.next().onReceiveAedStateMessage(r7);
        goto L64
    L73:
        return;
    L67:
        byte[] r9 = Base64.decode(r7, 0);     // Catch: Exception -> L61
        am3.c r10 = ((IMiddlewareNetworkService) k.n(IMiddlewareNetworkService.class)).getProtoDecoder(LinkMicRtsMessage.class);     // Catch: Exception -> L61
        String r1 = null;
        if (r10 == null) goto L12;
        g r3 = new g();     // Catch: Exception -> L61
        r3.k(new am3.b(r9));     // Catch: Exception -> L61
        LinkMicRtsMessage r11 = (LinkMicRtsMessage) r10.decode(r3);     // Catch: Exception -> L61
    L14:
        String r12 = "";
        if (r11 == null) goto L18;
        String r4 = r11.toString();     // Catch: Exception -> L61
        if (r4 == null) goto L18;
    L19:
        ALogger.i("RTSHandler", "handleRtsUserMessage message = ".concat(r4));     // Catch: Exception -> L61
        e r0 = k.n(IMiddlewareUserService.class).user();     // Catch: Exception -> L61
        if (r0 == null) goto L24;
        IBaseUser r2 = r0.b();     // Catch: Exception -> L61
        if (r2 == null) goto L24;
        r1 = r2.getIdString();     // Catch: Exception -> L61
    L24:
        if (r11 == null) goto L28;
        List<Long> r5 = r11.getMockFilterUidList();     // Catch: Exception -> L61
        if (r5 == null) goto L28;
        List r13 = v.b(r5);     // Catch: Exception -> L61
    L30:
        if (CollectionsKt.contains(r13, r1) == false) goto L33;
        ALogger.w("RTSHandler", "call handleRtsUserMessage can not handle rts: user in filter list");     // Catch: Exception -> L61
        return;
    L33:
        if (r11 != null) goto L35;
        return;
    L35:
        if (r11.getMessageType() != 2) goto L70;
        LinkmicRtsKickOutContent r14 = r11.getKickOutContent();     // Catch: Exception -> L61
        if (r14 != null) goto L39;
    L56:
        Iterator<c> r15 = this.a.iterator();     // Catch: Exception -> L61
    L58:
        if (r15.hasNext() == false) goto L72;
        c r16 = r15.next();     // Catch: Exception -> L61
        LinkmicRtsKickOutContent r17 = r11.getKickOutContent();     // Catch: Exception -> L61
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L61
        r16.onReceiveKickOutMsg(r17);     // Catch: Exception -> L61
        goto L58
    L72:
        return;
    L39:
        if (r14.getNeedAck() != true) goto L56;
        dn0.c r18 = this.b;     // Catch: Exception -> L61
        if (r18 == null) goto L56;
        e r19 = k.n(IMiddlewareUserService.class).user();     // Catch: Exception -> L61
        if (r19 == null) goto L48;
        IBaseUser r20 = r19.b();     // Catch: Exception -> L61
        if (r20 == null) goto L48;
        String r21 = r20.getIdString();     // Catch: Exception -> L61
        if (r21 == null) goto L48;
    L49:
        LinkmicRtsKickOutContent r22 = r11.getKickOutContent();     // Catch: Exception -> L61
        if (r22 == null) goto L55;
        String r23 = r22.getAckMessage();     // Catch: Exception -> L61
        if (r23 == null) goto L55;
        r12 = r23;
    L55:
        r18.Z(r21, r12, AckFromSource.LINK_MULTI_RTS);     // Catch: Exception -> L61
    L48:
        r21 = "";
        goto L49
    L70:
        return;
    L28:
        r13 = CollectionsKt.emptyList();     // Catch: Exception -> L61
    L18:
        r4 = "";
        goto L19
    L12:
        r11 = null;
    L61:
        ALogger.e("RTSHandler", "call handleRtsUserMessage parse err.");
    }
}
