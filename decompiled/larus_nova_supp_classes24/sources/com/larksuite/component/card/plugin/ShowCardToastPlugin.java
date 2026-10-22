package com.larksuite.component.card.plugin;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowCardToastPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "showMsgCardToastAsync", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/ShowCardToastPlugin$MsgCardToastApiRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "getStringIdFromMap", "", "i18nId", "", "Companion", "MsgCardToastApiRequest", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ShowCardToastPlugin extends OPPlugin {
    private static final String CARD_FORWARD_CLICK_TOAST = "Lark_Legacy_forwardCardToast";
    public static final a Companion = null;
    private static final String TAG = "ShowMsgCardToastPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowCardToastPlugin$MsgCardToastApiRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textType", "getTextType", "setTextType", "tag", "getTag", "setTag", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MsgCardToastApiRequest extends LKBaseRequestModel {

        @JSONField(name = "tag")
        private String tag;

        @JSONField(name = "text")
        @LKRequiredParam
        private String text;

        @JSONField(name = "textType")
        @LKRequiredParam
        private String textType;

        public MsgCardToastApiRequest() {
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTextType() {
            return this.textType;
        }

        public final void setTag(String r1) {
            this.tag = r1;
        }

        public final void setText(String r1) {
            this.text = r1;
        }

        public final void setTextType(String r1) {
            this.textType = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MsgCardToastApiRequest a;
        public final /* synthetic */ LKEvent b;
        public final /* synthetic */ ShowCardToastPlugin c;

        public b(MsgCardToastApiRequest r1, LKEvent r2, ShowCardToastPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            if (TextUtils.isEmpty(this.a.getText()) == false) goto L7;
            Log.e(ShowCardToastPlugin.TAG, "toast text is empty");
            return;
        L7:
            if (TextUtils.isEmpty(this.a.getTextType()) == false) goto L10;
            Log.e(ShowCardToastPlugin.TAG, "toast textType is empty");
            return;
        L10:
            Object r3 = null;
            if (Intrinsics.areEqual(this.a.getTextType(), "i18n_id") == false) goto L63;
            Log.i(ShowCardToastPlugin.TAG, "show toast with i18n_id");
            String r1 = this.a.getText();
            int r4 = 0;
            if (r1 == null) goto L58;
            ShowCardToastPlugin r5 = this.c;
            LKEvent r6 = this.b;
            MsgCardToastApiRequest r7 = this.a;
            int r8 = ShowCardToastPlugin.access$getStringIdFromMap(r5, r1);
            if (Intrinsics.areEqual(r1, ShowCardToastPlugin.CARD_FORWARD_CLICK_TOAST) == false) goto L57;
            Object r2 = r6.h;
            if ((r2 instanceof ILynxBridgeContext) == false) goto L27;
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
            ILynxContainerContext r9 = ((ILynxBridgeContext) r2).getContainerContext();
            if (r9 == null) goto L23;
            Map r10 = r9.getBizExtra();
            if (r10 == null) goto L23;
            Object r11 = r10.get("card_share_data");
        L25:
            if ((r11 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L27;
            com.larksuite.component.card.cardcontainer.c r12 = (com.larksuite.component.card.cardcontainer.c) r11;
        L28:
            StringBuilder r13 = new StringBuilder();
            if (r12 == null) goto L33;
            CardData r14 = r12.b;
            if (r14 == null) goto L33;
            String r15 = r14.getCardID();
        L34:
            r13.append(r15);
            r13.append('#');
            if (r12 == null) goto L39;
            CardData r16 = r12.b;
            if (r16 == null) goto L39;
            String r17 = r16.getVersion();
        L40:
            r13.append(r17);
            String r19 = r13.toString();
            String r110 = r7.getTag();
            if (r12 == null) goto L45;
            CardContext r20 = r12.c;
            if (r20 == null) goto L45;
            UniversalCardMonitorData r111 = r20.getMonitorData();
        L46:
            if (r12 == null) goto L50;
            CardData r21 = r12.b;
            if (r21 == null) goto L50;
            r3 = r21.getCardID();
        L50:
            String r112 = r3;
            if (r12 == null) goto L55;
            CardData r22 = r12.b;
            if (r22 == null) goto L55;
            boolean r113 = r22.isStreamingMode();
        L56:
            com.larksuite.component.card.monitor.a.b(r19, "interaction", r110, r111, r112, null, r113, null, 160);
        L55:
            r113 = false;
        L45:
            r111 = null;
        L39:
            r17 = null;
        L33:
            r15 = null;
        L23:
            r11 = null;
        L27:
            r12 = null;
        L57:
            r4 = r8;
        L58:
            if (r4 != 0) goto L61;
            Log.e(ShowCardToastPlugin.TAG, "toast text string id: " + this.a.getText() + " not exist");
            return;
        L61:
            LKUIToast.show(this.b.getContext().getApplicationContext(), r4);
            return;
        L63:
            if (Intrinsics.areEqual(this.a.getTextType(), "content") == false) goto L70;
            StringBuilder r23 = new StringBuilder("show toast with content, length: ");
            String r24 = this.a.getText();
            if (r24 == null) goto L67;
            r3 = Integer.valueOf(r24.length());
        L67:
            r23.append(r3);
            Log.i(ShowCardToastPlugin.TAG, r23.toString());
            LKUIToast.show(this.b.getContext().getApplicationContext(), this.a.getText());
            return;
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

    public ShowCardToastPlugin() {
    }

    private final int getStringIdFromMap(String r2) {
        if (Intrinsics.areEqual(r2, CARD_FORWARD_CLICK_TOAST) == false) goto L5;
        return 2131892336;
    L5:
        return 0;
    }

    public static final /* synthetic */ int access$getStringIdFromMap(ShowCardToastPlugin r0, String r1) {
        return r0.getStringIdFromMap(r1);
    }

    @LKPluginFunction(async = true, eventName = {"showMsgCardToast"})
    public final void showMsgCardToastAsync(LKEvent r2, MsgCardToastApiRequest r3, j18.f<LKBaseResponseModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "lkEvent");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "invokeCallback");
        mz7.b.a(new b(r3, r2, this));
    }
}
