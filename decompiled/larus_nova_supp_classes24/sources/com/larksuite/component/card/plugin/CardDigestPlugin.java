package com.larksuite.component.card.plugin;

import com.larksuite.component.card.plugin.model.SetMsgCardSummaryPluginModel$SetMsgCardSummaryRequestModel;
import com.larksuite.component.card.plugin.model.SetMsgCardSummaryPluginModel$SetMsgCardSummaryResponseModel;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/plugin/CardDigestPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", CardDigestPlugin.SET_MSG_CARD_SUMMARY, "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/model/SetMsgCardSummaryPluginModel$SetMsgCardSummaryRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/model/SetMsgCardSummaryPluginModel$SetMsgCardSummaryResponseModel;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardDigestPlugin extends OPPlugin {
    public static final a Companion = null;
    public static final String SET_MSG_CARD_SUMMARY = "setMsgCardSummary";
    private static final String TAG = "UpdateMsgCardDigestPlug";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CardDigestPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LKPluginFunction(async = true, eventName = {SET_MSG_CARD_SUMMARY})
    public final void setMsgCardSummary(LKEvent r3, SetMsgCardSummaryPluginModel$SetMsgCardSummaryRequestModel r4, j18.f<SetMsgCardSummaryPluginModel$SetMsgCardSummaryResponseModel> r5) {
        com.larksuite.component.card.cardcontainer.c r0 = null;
        if (r3 == null) goto L5;
        Object r6 = r3.h;
    L7:
        if ((r6 instanceof ILynxBridgeContext) == false) goto L25;
        ILynxContainerContext r7 = ((ILynxBridgeContext) r6).getContainerContext();
        if (r7 == null) goto L13;
        Map r8 = r7.getBizExtra();
        if (r8 == null) goto L13;
        Object r9 = r8.get("card_share_data");
    L15:
        if ((r9 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L17;
        r0 = (com.larksuite.component.card.cardcontainer.c) r9;
    L17:
        if (r4 == null) goto L25;
        Log.i(TAG, "summary:");
        if (r0 == null) goto L25;
        CardContext r10 = r0.c;
        if (r10 == null) goto L25;
        ICardDependency r11 = r10.getDependency();
        if (r11 == null) goto L25;
        r11.setMsgCardSummary(r4.summary, r4.translateSummary);
    L13:
        r9 = null;
    L25:
        if (r5 == 0) goto L28;
        r5.callback(new SetMsgCardSummaryPluginModel$SetMsgCardSummaryResponseModel());
        return;
    L28:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
