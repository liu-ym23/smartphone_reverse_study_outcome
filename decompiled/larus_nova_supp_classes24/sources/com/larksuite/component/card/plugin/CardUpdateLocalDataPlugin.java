package com.larksuite.component.card.plugin;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0003\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0007¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/plugin/CardUpdateLocalDataPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", CardUpdateLocalDataPlugin.MSG_CARD_UPDATE_LOCAL_DATA, "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/CardUpdateLocalDataPlugin$MsgCardUpdateLocalDataRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/CardUpdateLocalDataPlugin$CardUpdateLocalDataResponse;", "Companion", "MsgCardUpdateLocalDataRequestModel", "CardUpdateLocalDataResponse", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardUpdateLocalDataPlugin extends OPPlugin {
    public static final a Companion = null;
    public static final String MSG_CARD_UPDATE_LOCAL_DATA = "msgCardUpdateLocalData";
    public static final String TAG = "UniversalCardUpdateLocalDataPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/larksuite/component/card/plugin/CardUpdateLocalDataPlugin$CardUpdateLocalDataResponse;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "cardVersion", "", "getCardVersion", "()Ljava/lang/String;", "setCardVersion", "(Ljava/lang/String;)V", "data", "getData", "setData", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardUpdateLocalDataResponse extends LKBaseResponseModel {

        @JSONField(name = "cardVersion")
        @LKRequiredParam
        private String cardVersion;

        @JSONField(name = "data")
        @LKRequiredParam
        private String data;

        public CardUpdateLocalDataResponse() {
        }

        public final String getCardVersion() {
            return this.cardVersion;
        }

        public final String getData() {
            return this.data;
        }

        public final void setCardVersion(String r1) {
            this.cardVersion = r1;
        }

        public final void setData(String r1) {
            this.data = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/plugin/CardUpdateLocalDataPlugin$MsgCardUpdateLocalDataRequestModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "cardID", "", "getCardID", "()Ljava/lang/String;", "setCardID", "(Ljava/lang/String;)V", "cardVersion", "getCardVersion", "setCardVersion", "tag", "getTag", "setTag", "elementID", "getElementID", "setElementID", "name", "getName", "setName", "data", "getData", "setData", "needPush", "", "getNeedPush", "()Z", "setNeedPush", "(Z)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MsgCardUpdateLocalDataRequestModel extends LKBaseRequestModel {

        @JSONField(name = "cardID")
        @LKRequiredParam
        private String cardID;

        @JSONField(name = "cardVersion")
        private String cardVersion;

        @JSONField(name = "data")
        private String data;

        @JSONField(name = "elementID")
        private String elementID;

        @JSONField(name = "name")
        private String name;

        @JSONField(name = "needPush")
        private boolean needPush;

        @JSONField(name = "tag")
        private String tag;

        public MsgCardUpdateLocalDataRequestModel() {
        }

        public final String getCardID() {
            return this.cardID;
        }

        public final String getCardVersion() {
            return this.cardVersion;
        }

        public final String getData() {
            return this.data;
        }

        public final String getElementID() {
            return this.elementID;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getNeedPush() {
            return this.needPush;
        }

        public final String getTag() {
            return this.tag;
        }

        public final void setCardID(String r1) {
            this.cardID = r1;
        }

        public final void setCardVersion(String r1) {
            this.cardVersion = r1;
        }

        public final void setData(String r1) {
            this.data = r1;
        }

        public final void setElementID(String r1) {
            this.elementID = r1;
        }

        public final void setName(String r1) {
            this.name = r1;
        }

        public final void setNeedPush(boolean r1) {
            this.needPush = r1;
        }

        public final void setTag(String r1) {
            this.tag = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CardUpdateLocalDataPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {MSG_CARD_UPDATE_LOCAL_DATA})
    public final void msgCardUpdateLocalData(LKEvent r10, MsgCardUpdateLocalDataRequestModel r11, final j18.f<CardUpdateLocalDataResponse> r12) {
        String r0 = null;
        if (r11 == null) goto L5;
        String r1 = r11.getCardID();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        Log.i(TAG, "update local data is card id is null");
        return;
    L16:
        if (r10 == null) goto L18;
        Object r3 = r10.h;
    L20:
        if ((r3 instanceof ILynxBridgeContext) == false) goto L49;
        Object r13 = r10.h;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r14 = ((ILynxBridgeContext) r13).getContainerContext();
        if (r14 == null) goto L26;
        Map r15 = r14.getBizExtra();
        if (r15 == null) goto L26;
        Object r16 = r15.get("card_share_data");
    L28:
        if ((r16 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L30;
        com.larksuite.component.card.cardcontainer.c r17 = (com.larksuite.component.card.cardcontainer.c) r16;
    L31:
        if (r17 == null) goto L51;
        CardContext r4 = r17.c;
        if (r4 == null) goto L52;
        ICardDependency r5 = r4.getDependency();
        if (r5 == null) goto L53;
        if (r11 == null) goto L38;
        String r6 = r11.getCardID();
    L39:
        if (r11 == null) goto L41;
        String r7 = r11.getCardVersion();
    L42:
        if (r11 == null) goto L44;
        String r8 = r11.getData();
    L45:
        Boolean r9 = Boolean.FALSE;
        ActionInfo r19 = r17.b.getActionInfo();
        if (r19 == null) goto L48;
        r0 = r19.getSourceId();
    L48:
        r5.updateCardLocalCache(r6, r7, r8, r9, r0, new AnonymousClass1(r12));
        return;
    L44:
        r8 = null;
        goto L45
    L41:
        r7 = null;
        goto L42
    L38:
        r6 = null;
        goto L39
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L30:
        r17 = null;
    L26:
        r16 = null;
        goto L28
    L49:
        Log.w(TAG, "lkEvent?.findServiceContext is not ILynxBridgeContext");
        return;
    L18:
        r3 = null;
        goto L20
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
