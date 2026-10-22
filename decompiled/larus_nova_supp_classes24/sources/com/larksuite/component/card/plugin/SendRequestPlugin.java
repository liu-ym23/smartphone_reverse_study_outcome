package com.larksuite.component.card.plugin;

import android.content.Context;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.card.action.UniversalCardActionManager;
import com.larksuite.component.card.action.UniversalCardActionManager$requestAction2$1;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.context.BizContext;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/card/plugin/SendRequestPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "sendRequest", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/SendRequestPlugin$Request;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/CallbackProcessResponse;", "Companion", "Request", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SendRequestPlugin extends OPPlugin {
    public static final a Companion = null;
    public static final String TAG = "SendRequestPlugin";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR>\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/plugin/SendRequestPlugin$Request;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "name", "getName", "setName", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "elementID", "getElementID", "setElementID", "version", "getVersion", "setVersion", "isTranslateElement", "setTranslateElement", "actionId", "getActionId", "setActionId", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Request extends LKBaseRequestModel {

        @JSONField(name = "actionID")
        @LKRequiredParam
        private String actionId;

        @JSONField(name = "elementID")
        @LKRequiredParam
        private String elementID;

        @JSONField(name = "isTranslateElement")
        private String isTranslateElement;

        @JSONField(name = "name")
        private String name;

        @JSONField(name = "params")
        private HashMap<String, String> params;

        @JSONField(name = "tag")
        @LKRequiredParam
        private String tag;

        @JSONField(name = "version")
        private String version;

        public Request() {
        }

        public final String getActionId() {
            return this.actionId;
        }

        public final String getElementID() {
            return this.elementID;
        }

        public final String getName() {
            return this.name;
        }

        public final HashMap<String, String> getParams() {
            return this.params;
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getVersion() {
            return this.version;
        }

        public final String isTranslateElement() {
            return this.isTranslateElement;
        }

        public final void setActionId(String r1) {
            this.actionId = r1;
        }

        public final void setElementID(String r1) {
            this.elementID = r1;
        }

        public final void setName(String r1) {
            this.name = r1;
        }

        public final void setParams(HashMap<String, String> r1) {
            this.params = r1;
        }

        public final void setTag(String r1) {
            this.tag = r1;
        }

        public final void setTranslateElement(String r1) {
            this.isTranslateElement = r1;
        }

        public final void setVersion(String r1) {
            this.version = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SendRequestPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"msgCardSendRequest"})
    public final void sendRequest(LKEvent r22, Request r23, final j18.f<CallbackProcessResponse> r24) {
        Intrinsics.checkNotNullParameter(r22, "lkEvent");
        Intrinsics.checkNotNullParameter(r23, "request");
        Intrinsics.checkNotNullParameter(r24, "invokeCallback");
        String r4 = r23.getTag();
        if (r4 != null) goto L6;
        r4 = "button";
    L6:
        HashMap<String, String> r10 = r23.getParams();
        String r19 = null;
        if (r10 == null) goto L36;
        int r5 = k.a;
        String r11 = r23.getActionId();
        String r6 = r23.getElementID();
        String r17 = r23.getVersion();
        Intrinsics.checkNotNullParameter(r22, "lkEvent");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r24, "invokeCallback");
        Intrinsics.checkNotNullParameter(r4, "componentTag");
        Object r1 = r22.h;
        if ((r1 instanceof ILynxBridgeContext) == false) goto L17;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r2 = ((ILynxBridgeContext) r1).getContainerContext();
        if (r2 == null) goto L15;
        Map r3 = r2.getBizExtra();
        if (r3 == null) goto L15;
        Object r7 = r3.get("card_share_data");
    L16:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.larksuite.component.card.cardcontainer.UniversalCardShareData");
        com.larksuite.component.card.cardcontainer.c r8 = (com.larksuite.component.card.cardcontainer.c) r7;
        OPTrace r14 = r8.c.getRenderTrace().subTrace();
    L18:
        final Context r15 = r22.getContext();
        if (r8 != null) goto L21;
        Log.w("MsgCardPluginUtils", "select msgId is null");
        goto L36
    L21:
        dz7.a.C0100a.C0101a r9 = new dz7.a.C0100a.C0101a();
        Intrinsics.checkNotNullParameter(r4, "elementTag");
        r9.a = r4;
        r9.b = r6;
        BizContext r12 = r8.c.getBizContext();
        Intrinsics.checkNotNullParameter(r12, "bizContext");
        r9.c = r12;
        dz7.a r13 = r9.a();
        String r16 = r8.b.getCardID();
        ActionInfo r110 = r8.b.getActionInfo();
        if (r110 == null) goto L24;
        Integer r111 = Integer.valueOf(r110.getSourceType());
    L25:
        ActionInfo r112 = r8.b.getActionInfo();
        if (r112 == null) goto L28;
        String r113 = r112.getSourceId();
    L29:
        dz7.b r20 = k.a(r16, r10, r11, r8, false, r14, r111, r113, r17);
        HashMap r114 = new HashMap();
        if (r6 != null) goto L32;
        r6 = "";
    L32:
        r114.put("elementID", r6);
        r114.put("eventName", "ActionFinish");
        final com.larksuite.component.card.action.f r115 = new com.larksuite.component.card.action.f(r20, r13, r114, r8.c.getMonitorData());
        CardActionService r21 = r8.c.getDependency().getCardActionService();
        if (r21 == null) goto L36;
        final UniversalCardActionManager r116 = (UniversalCardActionManager) UniversalCardActionManager.b.getValue();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r21, "cardActionService");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r115, "requestEntity");
        Intrinsics.checkNotNullParameter(r24, "invokeCallback");
        Log.i("LynxCardActionManager", "event rust request start: " + r115.c + " contentVersion: " + r115.a.d + " msgId: " + r115.a.a);
        final long r25 = System.currentTimeMillis();
        r21.sendRequest(r115.b, r115.a, new UniversalCardActionManager$requestAction2$1(r115, r24, r25, r116, r15));
        goto L36
    L28:
        r113 = null;
        goto L29
    L24:
        r111 = null;
    L15:
        r7 = null;
        goto L16
    L17:
        r8 = null;
        r14 = null;
    L36:
        Object r0 = r22.h;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r26 = ((ILynxBridgeContext) r0).getContainerContext();
        if (r26 == null) goto L41;
        Map r27 = r26.getBizExtra();
        if (r27 == null) goto L41;
        Object r29 = r27.get("card_share_data");
    L43:
        if ((r29 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L45;
        com.larksuite.component.card.cardcontainer.c r30 = (com.larksuite.component.card.cardcontainer.c) r29;
    L46:
        StringBuilder r31 = new StringBuilder("request Action cardId:");
        if (r30 == null) goto L51;
        CardData r32 = r30.b;
        if (r32 == null) goto L51;
        String r33 = r32.getCardID();
    L52:
        r31.append(r33);
        r31.append(" version:");
        r31.append(r23.getVersion());
        r31.append("contentVersion: ");
        if (r30 == null) goto L57;
        CardData r34 = r30.b;
        if (r34 == null) goto L57;
        String r35 = r34.getVersion();
    L58:
        r31.append(r35);
        Log.i(TAG, r31.toString());
        if (r30 == null) goto L63;
        CardData r36 = r30.b;
        if (r36 == null) goto L63;
        String r37 = r36.getCardID();
    L64:
        String r38 = r23.getTag();
        if (r30 == null) goto L69;
        CardContext r39 = r30.c;
        if (r39 == null) goto L69;
        UniversalCardMonitorData r40 = r39.getMonitorData();
    L70:
        if (r30 == null) goto L74;
        CardData r41 = r30.b;
        if (r41 == null) goto L74;
        r19 = r41.getCardID();
    L74:
        String r42 = r19;
        if (r30 == null) goto L79;
        CardData r43 = r30.b;
        if (r43 == null) goto L79;
        boolean r44 = r43.isStreamingMode();
    L80:
        com.larksuite.component.card.monitor.a.b(r37, "interaction", r38, r40, r42, null, r44, null, 160);
        return;
    L79:
        r44 = false;
    L69:
        r40 = null;
    L63:
        r37 = null;
    L57:
        r35 = null;
    L51:
        r33 = null;
        goto L52
    L45:
        r30 = null;
    L41:
        r29 = null;
        goto L43
    }
}
