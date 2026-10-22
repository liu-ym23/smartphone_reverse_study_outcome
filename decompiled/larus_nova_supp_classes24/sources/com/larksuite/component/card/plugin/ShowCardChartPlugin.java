package com.larksuite.component.card.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.JsonObject;
import com.larksuite.component.card.component.chart.CardElementActivity;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.Contexts;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowCardChartPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "showCardChartAsync", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/ShowCardChartPlugin$MsgCardChartApiRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "Companion", "MsgCardChartApiRequest", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ShowCardChartPlugin extends OPPlugin {
    public static final a Companion = null;
    private static final String TAG = "ShowMsgCardToastPlugin";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowCardChartPlugin$MsgCardChartApiRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "element", "", "getElement", "()Ljava/lang/String;", "setElement", "(Ljava/lang/String;)V", "isTranslateElement", "", "()Z", "setTranslateElement", "(Z)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MsgCardChartApiRequest extends LKBaseRequestModel {

        @JSONField(name = "elementID")
        @LKRequiredParam
        private String element;

        @JSONField(name = "isTranslateElement")
        @LKRequiredParam
        private boolean isTranslateElement;

        public MsgCardChartApiRequest() {
        }

        public final String getElement() {
            return this.element;
        }

        public final boolean isTranslateElement() {
            return this.isTranslateElement;
        }

        public final void setElement(String r1) {
            this.element = r1;
        }

        public final void setTranslateElement(boolean r1) {
            this.isTranslateElement = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShowCardChartPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"showCardChartDetail"})
    public final void showCardChartAsync(LKEvent r8, MsgCardChartApiRequest r9, j18.f<LKBaseResponseModel> r10) {
        Intrinsics.checkNotNullParameter(r8, "lkEvent");
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "invokeCallback");
        Object r11 = r8.h;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r12 = ((ILynxBridgeContext) r11).getContainerContext();
        OPTrace r1 = null;
        if (r12 == null) goto L7;
        Map r13 = r12.getBizExtra();
        if (r13 == null) goto L7;
        Object r14 = r13.get("card_share_data");
    L9:
        if ((r14 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L11;
        com.larksuite.component.card.cardcontainer.c r15 = (com.larksuite.component.card.cardcontainer.c) r14;
    L13:
        if (r15 == null) goto L15;
        CardDataUtils r3 = CardDataUtils.a;
        CardConfig r4 = r15.d;
        CardContext r5 = r15.c;
        CardData r6 = r15.b;
        r3.getClass();
        JsonObject r7 = CardDataUtils.j(r4, r5, r6, false);
        String r16 = com.larksuite.component.card.utils.j.a(r15.d, r15.getContext());
    L16:
        if (r7 == null) goto L37;
        if (r15 != null) goto L35;
    L25:
        if (r1 == null) goto L27;
        r7.getAsJsonObject("context").addProperty("traceID", r1.getTracingID());     // Catch: Exception -> L23
    L27:
        JsonObject r17 = new JsonObject();     // Catch: Exception -> L23
        r17.addProperty("elementID", r9.getElement());     // Catch: Exception -> L23
        r17.addProperty("isTranslateElement", Boolean.valueOf(r9.isTranslateElement()));     // Catch: Exception -> L23
        JsonObject r19 = r7.getAsJsonObject("config");     // Catch: Exception -> L23
        r19.add("targetElement", r17);     // Catch: Exception -> L23
        r7.add("config", r19);     // Catch: Exception -> L23
        Intent r20 = new Intent(r8.getContext(), CardElementActivity.class);     // Catch: Exception -> L23
        String r110 = CardElementActivity.d;     // Catch: Exception -> L23
        CardElementActivity.d = r7.toString();     // Catch: Exception -> L23
        r20.putExtra("global_props", r16);     // Catch: Exception -> L23
        r8.getContext().startActivity(r20);     // Catch: Exception -> L23
        if (Build.VERSION.SDK_INT > 34) goto L30;
        return;
    L30:
        if ((r8.getContext() instanceof Activity) == false) goto L39;
        Contexts.requireActivity(r8.getContext()).overridePendingTransition(0, 0);     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        Log.e(TAG, e);
        return;
    L39:
        return;
    L35:
        CardContext r111 = r15.c;     // Catch: Exception -> L23
        if (r111 == null) goto L25;
        OPTrace r112 = r111.getRenderTrace();     // Catch: Exception -> L23
        if (r112 == null) goto L25;
        r1 = r112.subTrace();     // Catch: Exception -> L23
        goto L25
    L37:
        return;
    L15:
        r16 = "";
        r7 = null;
        goto L16
    L11:
        r15 = null;
    L7:
        r14 = null;
        goto L9
    }
}
