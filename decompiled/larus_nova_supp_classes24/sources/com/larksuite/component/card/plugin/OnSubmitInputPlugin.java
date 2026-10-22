package com.larksuite.component.card.plugin;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/card/plugin/OnSubmitInputPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "submitInputAsync", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/OnSubmitInputPlugin$SubmitInputApiRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/CallbackProcessResponse;", "Companion", "SubmitInputApiRequest", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OnSubmitInputPlugin extends OPPlugin {
    public static final String API_SUBMIT_INPUT_ACTION = "onSubmitInput";
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR>\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/card/plugin/OnSubmitInputPlugin$SubmitInputApiRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "confirm", "Lcom/larksuite/component/card/plugin/Confirm;", "getConfirm", "()Lcom/larksuite/component/card/plugin/Confirm;", "setConfirm", "(Lcom/larksuite/component/card/plugin/Confirm;)V", "elementID", "", "getElementID", "()Ljava/lang/String;", "setElementID", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "actionID", "getActionID", "setActionID", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SubmitInputApiRequest extends LKBaseRequestModel {

        @JSONField(name = "actionID")
        private String actionID;

        @JSONField(name = "confirm")
        private Confirm confirm;

        @JSONField(name = "elementID")
        @LKRequiredParam
        private String elementID;

        @JSONField(name = "params")
        private HashMap<String, String> params;

        @JSONField(name = "tag")
        private String tag;

        public SubmitInputApiRequest() {
        }

        public final String getActionID() {
            return this.actionID;
        }

        public final Confirm getConfirm() {
            return this.confirm;
        }

        public final String getElementID() {
            return this.elementID;
        }

        public final HashMap<String, String> getParams() {
            return this.params;
        }

        public final String getTag() {
            return this.tag;
        }

        public final void setActionID(String r1) {
            this.actionID = r1;
        }

        public final void setConfirm(Confirm r1) {
            this.confirm = r1;
        }

        public final void setElementID(String r1) {
            this.elementID = r1;
        }

        public final void setParams(HashMap<String, String> r1) {
            this.params = r1;
        }

        public final void setTag(String r1) {
            this.tag = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SubmitInputApiRequest a;
        public final /* synthetic */ LKEvent b;
        public final /* synthetic */ j18.f<CallbackProcessResponse> c;

        public b(SubmitInputApiRequest r1, LKEvent r2, j18.f<CallbackProcessResponse> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (this.a.getActionID() == null) goto L30;
            LKEvent r1 = this.b;
            SubmitInputApiRequest r2 = this.a;
            j18.f<CallbackProcessResponse> r4 = this.c;
            Object r3 = r1.h;
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
            ILynxContainerContext r5 = ((ILynxBridgeContext) r3).getContainerContext();
            Object r7 = null;
            if (r5 == null) goto L9;
            Map r6 = r5.getBizExtra();
            if (r6 == null) goto L9;
            Object r8 = r6.get("card_share_data");
        L11:
            if ((r8 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L13;
            com.larksuite.component.card.cardcontainer.c r9 = (com.larksuite.component.card.cardcontainer.c) r8;
        L14:
            if (r9 == null) goto L16;
            r9.b.getCardID();
            com.larksuite.component.card.monitor.a.b(r9.b.getVersion(), "interaction", r2.getTag(), r9.c.getMonitorData(), r9.b.getCardID(), null, r9.b.isStreamingMode(), null, 160);
        L16:
            HashMap<String, String> r10 = r2.getParams();
            if (r10 == null) goto L31;
            int r11 = k.a;
            Confirm r12 = r2.getConfirm();
            String r13 = r2.getActionID();
            String r20 = r2.getElementID();
            Intrinsics.checkNotNullParameter(r1, "lkEvent");
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r4, "invokeCallback");
            Intrinsics.checkNotNullParameter("input", "componentTag");
            Ref.ObjectRef r14 = new Ref.ObjectRef();
            Ref.ObjectRef r15 = new Ref.ObjectRef();
            Ref.ObjectRef r16 = new Ref.ObjectRef();
            Object r17 = r1.h;
            if ((r17 instanceof ILynxBridgeContext) == false) goto L26;
            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
            ILynxBridgeContext r19 = (ILynxBridgeContext) r17;
            r14.element = r19;
            ILynxContainerContext r21 = r19.getContainerContext();
            if (r21 == null) goto L25;
            Map r22 = r21.getBizExtra();
            if (r22 == null) goto L25;
            r7 = r22.get("card_share_data");
        L25:
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.larksuite.component.card.cardcontainer.UniversalCardShareData");
            com.larksuite.component.card.cardcontainer.c r23 = (com.larksuite.component.card.cardcontainer.c) r7;
            r15.element = r23;
            r16.element = r23.c.getRenderTrace().subTrace();
        L26:
            if (r12 == null) goto L28;
            Log.d("MsgCardPluginUtils", "show confirm, actionId: " + r13);
            new UDDialogBuilder(r1.getContext()).titleBold(true).title(String.valueOf(r12.getTitle())).message(String.valueOf(r12.getText())).addActionButton(2131391778, r1.getContext().getText(2131891541), new i(r13, r4)).addActionButton(2131391777, r1.getContext().getText(2131891623), new j(r4, r14, r20, r15, r13, r10, r16)).cancelOnTouchOutside(false).show();
            return;
        L28:
            r4.callback(new CallbackProcessResponse());
            k.b((ILynxBridgeContext) r14.element, "", r20, (com.larksuite.component.card.cardcontainer.c) r15.element, r13, r10, (OPTrace) r16.element, false, "input");
            return;
        L31:
            return;
        L13:
            r9 = null;
        L9:
            r8 = null;
            goto L11
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

    public OnSubmitInputPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {API_SUBMIT_INPUT_ACTION})
    public final void submitInputAsync(LKEvent r2, SubmitInputApiRequest r3, j18.f<CallbackProcessResponse> r4) {
        Intrinsics.checkNotNullParameter(r2, "lkEvent");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "invokeCallback");
        mz7.b.a(new b(r3, r2, r4));
    }
}
