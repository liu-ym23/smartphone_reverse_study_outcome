package com.larksuite.component.card.plugin;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.JsonObject;
import com.larksuite.component.card.component.table.TableDetailActivity;
import com.larksuite.component.card.component.table.TableDetailContainerActivity;
import com.larksuite.component.card.navigation.UniversalCardLargeScreenAdapt;
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
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowTableDetailPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "showCardChartAsync", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/ShowTableDetailPlugin$CardTableDetailApiRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "Companion", "CardTableDetailApiRequest", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ShowTableDetailPlugin extends OPPlugin {
    public static final a Companion = null;
    private static final String TAG = "ShowMsgCardToastPlugin";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowTableDetailPlugin$CardTableDetailApiRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "element", "", "getElement", "()Ljava/lang/String;", "setElement", "(Ljava/lang/String;)V", "isTranslateElement", "", "()Z", "setTranslateElement", "(Z)V", "currentLine", "", "getCurrentLine", "()Ljava/lang/Number;", "setCurrentLine", "(Ljava/lang/Number;)V", "currentPosition", "getCurrentPosition", "setCurrentPosition", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardTableDetailApiRequest extends LKBaseRequestModel {

        @JSONField(name = "currentLine")
        @LKRequiredParam
        private Number currentLine;

        @JSONField(name = "currentPosition")
        private Number currentPosition;

        @JSONField(name = "elementID")
        @LKRequiredParam
        private String element;

        @JSONField(name = "isTranslateElement")
        @LKRequiredParam
        private boolean isTranslateElement;

        public CardTableDetailApiRequest() {
            this.currentLine = 0;
            this.currentPosition = 0;
        }

        public final Number getCurrentLine() {
            return this.currentLine;
        }

        public final Number getCurrentPosition() {
            return this.currentPosition;
        }

        public final String getElement() {
            return this.element;
        }

        public final boolean isTranslateElement() {
            return this.isTranslateElement;
        }

        public final void setCurrentLine(Number r1) {
            this.currentLine = r1;
        }

        public final void setCurrentPosition(Number r1) {
            this.currentPosition = r1;
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

    public ShowTableDetailPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"showCardTableDetail"})
    public final void showCardChartAsync(LKEvent r11, CardTableDetailApiRequest r12, j18.f<LKBaseResponseModel> r13) {
        Intrinsics.checkNotNullParameter(r11, "lkEvent");
        Intrinsics.checkNotNullParameter(r12, "request");
        Intrinsics.checkNotNullParameter(r13, "invokeCallback");
        Object r14 = r11.h;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r15 = ((ILynxBridgeContext) r14).getContainerContext();
        final com.suite.lark.component.navroute.forseti.g r1 = null;
        if (r15 == null) goto L7;
        Map r16 = r15.getBizExtra();
        if (r16 == null) goto L7;
        Object r17 = r16.get("card_share_data");
    L9:
        if ((r17 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L11;
        final com.larksuite.component.card.cardcontainer.c r19 = (com.larksuite.component.card.cardcontainer.c) r17;
    L12:
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = "";
        boolean r3 = false;
        if (r19 == null) goto L15;
        CardDataUtils r4 = CardDataUtils.a;
        CardConfig r5 = r19.d;
        CardContext r6 = r19.c;
        CardData r7 = r19.b;
        r4.getClass();
        JsonObject r8 = CardDataUtils.j(r5, r6, r7, false);
        r2.element = com.larksuite.component.card.utils.j.a(r19.d, r19.getContext());
    L16:
        if (r8 != null) goto L18;
        return;
    L18:
        if (r19 != null) goto L50;
    L24:
        OPTrace r9 = null;
    L25:
        if (r9 == null) goto L27;
        r8.getAsJsonObject("context").addProperty("traceID", r9.getTracingID());     // Catch: Exception -> L44
    L27:
        JsonObject r10 = new JsonObject();     // Catch: Exception -> L44
        r10.addProperty("elementID", r12.getElement());     // Catch: Exception -> L44
        r10.addProperty("isTranslateElement", Boolean.valueOf(r12.isTranslateElement()));     // Catch: Exception -> L44
        JsonObject r20 = new JsonObject();     // Catch: Exception -> L44
        r20.addProperty("currentLine", r12.getCurrentLine());     // Catch: Exception -> L44
        r20.addProperty("currentPosition", r12.getCurrentPosition());     // Catch: Exception -> L44
        r10.add("detailProps", r20);     // Catch: Exception -> L44
        JsonObject r110 = r8.getAsJsonObject("config");     // Catch: Exception -> L44
        r110.add("targetElement", r10);     // Catch: Exception -> L44
        r8.add("config", r110);     // Catch: Exception -> L44
        final String r111 = r8.toString();     // Catch: Exception -> L44
        if (UniversalCardLargeScreenAdapt.b() == false) goto L46;
        Context r0 = r11.getContext();     // Catch: Exception -> L44
        if (r0 != null) goto L32;
    L34:
        if (r19 == null) goto L40;
        CardContext r21 = r19.c;     // Catch: Exception -> L44
        if (r21 == null) goto L40;
        Fragment r22 = r21.getFragment();     // Catch: Exception -> L44
        if (r22 == null) goto L40;
        r1 = com.suite.lark.component.navroute.forseti.f.b(r22);     // Catch: Exception -> L44
    L40:
        if (r3 == false) goto L43;
        if (r1 == null) goto L43;
        Log.i(TAG, "route to detail page using forseti");     // Catch: Exception -> L44
        mz7.b.a(new ShowTableDetailPlugin$showCardChartAsync$2$3(r1, r2, r111, r19));     // Catch: Exception -> L44
        return;
    L43:
        Log.i(TAG, "route to detail page using container activity");     // Catch: Exception -> L44
        TableDetailContainerActivity.a r23 = TableDetailContainerActivity.b;     // Catch: Exception -> L44
        Context r112 = r11.getContext();     // Catch: Exception -> L44
        String r24 = (String) r2.element;     // Catch: Exception -> L44
        r23.getClass();     // Catch: Exception -> L44
        TableDetailContainerActivity.a.a(r112, r24, r111, r19);     // Catch: Exception -> L44
        return;
    L32:
        if (ForsetiConfig.a(r0) != true) goto L34;
        r3 = true;
        goto L34
    L46:
        Log.i(TAG, "route to detail page, large screen adapt disabled");     // Catch: Exception -> L44
        WeakReference<com.larksuite.component.card.cardcontainer.c> r25 = TableDetailActivity.b;     // Catch: Exception -> L44
        TableDetailActivity.b = new WeakReference(r19);     // Catch: Exception -> L44
        TableDetailActivity.c = r111;     // Catch: Exception -> L44
        Intent r113 = new Intent(r11.getContext(), TableDetailActivity.class);     // Catch: Exception -> L44
        r113.putExtra("global_props", (String) r2.element);     // Catch: Exception -> L44
        r11.getContext().startActivity(r113);     // Catch: Exception -> L44
        return;
    L50:
        CardContext r26 = r19.c;     // Catch: Exception -> L44
        if (r26 == null) goto L24;
        OPTrace r27 = r26.getRenderTrace();     // Catch: Exception -> L44
        if (r27 == null) goto L24;
        r9 = r27.subTrace();     // Catch: Exception -> L44
    L44:
        e = move-exception;
        Log.e(TAG, e);
        return;
    L15:
        r8 = null;
        goto L16
    L11:
        r19 = null;
    L7:
        r17 = null;
        goto L9
    }
}
