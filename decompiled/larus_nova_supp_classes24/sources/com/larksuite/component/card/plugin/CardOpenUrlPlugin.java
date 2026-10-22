package com.larksuite.component.card.plugin;

import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.plugin.model.UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlRequestModel;
import com.larksuite.component.card.plugin.model.UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlResponseModel;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.context.action.CardOpenUrlService;
import com.larksuite.component.card.protocol.data.action.CardActionDependencyData;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/plugin/CardOpenUrlPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "cardOpenUrl", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/model/UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/model/UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlResponseModel;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardOpenUrlPlugin extends OPPlugin {
    public static final a Companion = null;
    private static final String TAG = "CardOpenUrlPlugin";
    public static final String UNIVERSAL_CARD_OPEN_URL = "msgCardOpenUrl";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlRequestModel a;
        public final /* synthetic */ LKEvent b;
        public final /* synthetic */ com.larksuite.component.card.cardcontainer.c c;
        public final /* synthetic */ Ref.BooleanRef d;
        public final /* synthetic */ Ref.ObjectRef<String> e;

        public b(UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlRequestModel r1, LKEvent r2, com.larksuite.component.card.cardcontainer.c r3, Ref.BooleanRef r4, Ref.ObjectRef<String> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            com.larksuite.component.card.plugin.a.a(this.a.url, this.b.getContext(), this.c.b.getCardID(), this.d.element, (String) this.e.element, this.c.c.getRenderTrace().subTrace(), this.c.c.getMonitorData(), this.a.tag, this.c.b.isStreamingMode(), this.c.c.getCardActionDependencyData().getOpenUrlExtraParams());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public CardOpenUrlPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LKPluginFunction(async = true, eventName = {UNIVERSAL_CARD_OPEN_URL})
    public final void cardOpenUrl(LKEvent r21, UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlRequestModel r22, j18.f<UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlResponseModel> r23) {
        UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlRequestModel r0 = null;
        if (r21 == null) goto L5;
        Object r3 = r21.h;
    L7:
        if ((r3 instanceof ILynxBridgeContext) == false) goto L74;
        ILynxContainerContext r4 = ((ILynxBridgeContext) r3).getContainerContext();
        if (r4 == null) goto L13;
        Map r5 = r4.getBizExtra();
        if (r5 == null) goto L13;
        Object r6 = r5.get("card_share_data");
    L15:
        if ((r6 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L17;
        com.larksuite.component.card.cardcontainer.c r7 = (com.larksuite.component.card.cardcontainer.c) r6;
    L18:
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = "";
        if (r7 == null) goto L25;
        CardContext r10 = r7.c;
        if (r10 == null) goto L25;
        CardActionDependencyData r11 = r10.getCardActionDependencyData();
        if (r11 == null) goto L25;
        r8.element = r11.getCardSceneIsGroup();
    L25:
        if (r7 == null) goto L33;
        CardContext r12 = r7.c;
        if (r12 == null) goto L33;
        CardActionDependencyData r13 = r12.getCardActionDependencyData();
        if (r13 == null) goto L33;
        String r14 = r13.getSelectPersonCurrentChatId();
        if (r14 == null) goto L33;
        r9.element = r14;
    L33:
        int r15 = com.larksuite.component.card.monitor.a.a;
        if (r7 == null) goto L38;
        CardData r16 = r7.b;
        if (r16 == null) goto L38;
        String r17 = r16.getVersion();
    L39:
        if (r22 == null) goto L41;
        String r19 = r22.tag;
    L42:
        if (r22 == null) goto L44;
        String r20 = r22.url;
    L45:
        if (r7 == null) goto L49;
        CardContext r110 = r7.c;
        if (r110 == null) goto L49;
        UniversalCardMonitorData r111 = r110.getMonitorData();
    L50:
        if (r7 == null) goto L54;
        CardData r112 = r7.b;
        if (r112 == null) goto L54;
        String r113 = r112.getCardID();
    L55:
        com.larksuite.component.card.monitor.a.c(r17, r19, r20, r111, r113);
        if (r22 == null) goto L74;
        boolean r24 = false;
        if (r22.url == null) goto L60;
        boolean r25 = true;
    L61:
        if (r25 == false) goto L63;
        r0 = r22;
    L63:
        if (r0 == null) goto L74;
        if (r7 == null) goto L74;
        CardOpenUrlService r26 = r7.c.getDependency().getOpenUrlService();
        if (r26 == null) goto L68;
        r24 = r26.interceptOpenUrl(r22.url, r21.getContext(), r7.b.getCardID(), r8.element, (String) r9.element, r7.c.getRenderTrace().subTrace(), r7.c.getMonitorData(), r22.tag, r7.b.isStreamingMode(), r7.c.getCardActionDependencyData().getOpenUrlExtraParams());
    L68:
        if (r24 == false) goto L71;
        Log.i(TAG, "intercepted by service，bizType=" + r7.c.getMonitorData().getBusinessType() + ", cardID=" + r7.b.getCardID());
        goto L74
    L71:
        if (idb.f.a().isEnable("universalcard.open_url.thread.fix.disable") == true) goto L73;
        mz7.b.a(new b(r22, r21, r7, r8, r9));
        goto L74
    L73:
        com.larksuite.component.card.plugin.a.a(r22.url, r21.getContext(), r7.b.getCardID(), r8.element, (String) r9.element, r7.c.getRenderTrace().subTrace(), r7.c.getMonitorData(), r22.tag, r7.b.isStreamingMode(), r7.c.getCardActionDependencyData().getOpenUrlExtraParams());
        goto L74
    L60:
        r25 = false;
    L54:
        r113 = null;
    L49:
        r111 = null;
        goto L50
    L44:
        r20 = null;
        goto L45
    L41:
        r19 = null;
    L38:
        r17 = null;
        goto L39
    L17:
        r7 = null;
    L13:
        r6 = null;
    L74:
        if (r23 == 0) goto L77;
        r23.callback(new UniversalCardOpenUrlPluginModel$UniversalCardOpenUrlResponseModel());
        return;
    L77:
        return;
    L5:
        r3 = null;
        goto L7
    }
}
