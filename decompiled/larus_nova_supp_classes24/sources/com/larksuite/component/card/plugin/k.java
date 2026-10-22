package com.larksuite.component.card.plugin;

import com.lark.kmp.server.pb.improto.Packet;
import com.larksuite.component.card.action.UniversalCardActionManager;
import com.larksuite.component.card.action.UniversalCardActionManager$requestAction$1;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel;
import com.larksuite.component.card.protocol.context.BizContext;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.larksuite.framework.apiplugin.LKEvent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(LKEvent r2, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel r3, j18.f r4) {
        Intrinsics.checkNotNullParameter(r2, "lkEvent");
        Intrinsics.checkNotNullParameter(r3, "selectParams");
        Intrinsics.checkNotNullParameter(r4, "invokeCallback");
        Object r5 = r2.h;
        Object r1 = null;
        if ((r5 instanceof ILynxBridgeContext) == false) goto L10;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r6 = ((ILynxBridgeContext) r5).getContainerContext();
        if (r6 == null) goto L9;
        Map r7 = r6.getBizExtra();
        if (r7 == null) goto L9;
        r1 = r7.get("card_share_data");
    L9:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larksuite.component.card.cardcontainer.UniversalCardShareData");
        r1 = (com.larksuite.component.card.cardcontainer.c) r1;
    L10:
        if (r1 != null) goto L12;
        Log.w("MsgCardPluginUtils", "select msgId is null");
        return;
    L12:
        r4.callback(r3);
    }

    public static dz7.b a(String r15, Map r16, String r17, com.larksuite.component.card.cardcontainer.c r19, boolean r110, OPTrace r20, Integer r21, String r22, String r23) {
        if (r17 == null) goto L5;
        String r5 = r17;
    L6:
        boolean r7 = r19.c.getCardActionDependencyData().isEphemeralCard();
        if (r21 == null) goto L9;
        int r10 = r21.intValue();
    L10:
        OPTrace r1 = gyb.a.a().subTrace();
        if (r20 == null) goto L13;
        OPTrace r9 = r20;
    L15:
        return new dz7.b(r15, r16, r5, r19.b.getVersion(), r7, r110, r9, r10, r22, r23, r19.b.isStreamingMode(), r19.b.getActionDataSource());
    L13:
        r9 = r1;
        goto L15
    L9:
        r10 = 0;
        goto L10
    L5:
        r5 = "";
        goto L6
    }

    public static void b(final ILynxBridgeContext r19, String r110, String r20, com.larksuite.component.card.cardcontainer.c r21, String r22, Map r23, OPTrace r24, boolean r25, String r26) {
        String r2 = r20;
        if (r21 != null) goto L6;
        Log.w("MsgCardPluginUtils", "select msgId is null");
        return;
    L6:
        Lazy<UniversalCardActionManager> r13 = UniversalCardActionManager.b;
        UniversalCardActionManager r4 = (UniversalCardActionManager) r13.getValue();
        HashMap r5 = new HashMap();
        HashMap r6 = new HashMap();
        String r7 = (String) r23.get("selected_option");
        if (r7 == null) goto L9;
        r6.put("select_value", r7);
    L9:
        if (r110 == null) goto L11;
        r6.put("select_text", r110);
    L11:
        r5.put("params", r6);
        if (r2 != null) goto L14;
        String r8 = "";
    L15:
        r5.put("elementID", r8);
        r5.put("eventName", "ActionStart");
        Unit r9 = Unit.INSTANCE;
        r4.getClass();
        Intrinsics.checkNotNullParameter("updateCardState", "eventName");
        Log.i("LynxCardActionManager", "send event to lynx eventName: updateCardState code:200 msg:update element state success");
        r5.put("error_code", Integer.valueOf(Packet.DEFAULT_STATUS));
        r5.put("error_msg", "update element state success");
        if (r19 == null) goto L18;
        r19.sendGlobalEventToJS("updateCardState", r5);
    L18:
        dz7.a.C0100a.C0101a r10 = new dz7.a.C0100a.C0101a();
        Intrinsics.checkNotNullParameter(r26, "elementTag");
        r10.a = r26;
        r10.b = r2;
        BizContext r3 = r21.c.getBizContext();
        Intrinsics.checkNotNullParameter(r3, "bizContext");
        r10.c = r3;
        dz7.a r11 = r10.a();
        String r12 = r21.b.getCardID();
        ActionInfo r14 = r21.b.getActionInfo();
        if (r14 == null) goto L21;
        Integer r15 = Integer.valueOf(r14.getSourceType());
    L22:
        ActionInfo r16 = r21.b.getActionInfo();
        if (r16 == null) goto L25;
        String r17 = r16.getSourceId();
    L26:
        dz7.b r27 = a(r12, r23, r22, r21, r25, r24, r15, r17, "");
        HashMap r29 = new HashMap();
        if (r2 != null) goto L29;
        r2 = "";
    L29:
        r29.put("elementID", r2);
        r29.put("eventName", "ActionFinish");
        final com.larksuite.component.card.action.f r30 = new com.larksuite.component.card.action.f(r27, r11, r29, r21.c.getMonitorData());
        CardActionService r0 = r21.c.getDependency().getCardActionService();
        if (r0 == null) goto L33;
        final UniversalCardActionManager r31 = (UniversalCardActionManager) r13.getValue();
        r31.getClass();
        Intrinsics.checkNotNullParameter(r0, "cardActionService");
        Intrinsics.checkNotNullParameter(r30, "requestEntity");
        Log.i("LynxCardActionManager", "event rust request start: " + r30.c + " contentVersion: " + r30.a.d + " msgId: " + r30.a.a);
        final long r32 = System.currentTimeMillis();
        r0.sendRequest(r30.b, r30.a, new UniversalCardActionManager$requestAction$1(r30, r32, r31, r19));
        return;
    L33:
        return;
    L25:
        r17 = null;
        goto L26
    L21:
        r15 = null;
        goto L22
    L14:
        r8 = r2;
        goto L15
    }
}
