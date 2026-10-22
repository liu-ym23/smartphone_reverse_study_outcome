package com.larksuite.component.card.plugin;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel;
import com.larksuite.component.card.plugin.model.MsgCardShowOverflowPluginModel$OptionsItemModel;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/plugin/MsgCardShowOverflowPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", MsgCardShowOverflowPlugin.MSG_CARD_SHOW_OVERFLOW, "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/model/MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/CallbackProcessResponse;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MsgCardShowOverflowPlugin extends OPPlugin {
    public static final a Companion = null;
    public static final String ELEMENT_TAG = "overflow";
    public static final String MSG_CARD_SHOW_OVERFLOW = "msgCardShowOverflow";
    private static final String TAG = "MsgCardShowOverflowPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LKEvent a;
        public final /* synthetic */ List<String> b;
        public final /* synthetic */ MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel c;
        public final /* synthetic */ j18.f<CallbackProcessResponse> d;

        public static final class a implements UDListDialogController.OnItemClickListener {
            public final /* synthetic */ MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel a;
            public final /* synthetic */ j18.f<CallbackProcessResponse> b;
            public final /* synthetic */ LKEvent c;

            @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
            public final void onItemClick(int r12) {
                ArrayList<MsgCardShowOverflowPluginModel$OptionsItemModel> r0 = this.a.options;
                if (r0 != null) goto L5;
                return;
            L5:
                MsgCardShowOverflowPluginModel$OptionsItemModel r13 = (MsgCardShowOverflowPluginModel$OptionsItemModel) ListProtector.get(r0, r12);
                CallbackProcessResponse r1 = new CallbackProcessResponse();
                r1.getActions().addAll(r13.actions);
                this.b.callback(r1);
                Object r14 = this.c.h;
                com.larksuite.component.card.cardcontainer.c r2 = null;
                if ((r14 instanceof ILynxBridgeContext) == false) goto L16;
                Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
                ILynxContainerContext r15 = ((ILynxBridgeContext) r14).getContainerContext();
                if (r15 == null) goto L12;
                Map r16 = r15.getBizExtra();
                if (r16 == null) goto L12;
                Object r17 = r16.get("card_share_data");
            L14:
                if ((r17 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L16;
                r2 = (com.larksuite.component.card.cardcontainer.c) r17;
            L12:
                r17 = null;
            L16:
                if (r2 == null) goto L23;
                CardData r19 = r2.b;
                if (r19 == null) goto L24;
                String r6 = r19.getCardID();
                if (r6 == null) goto L25;
                com.larksuite.component.card.monitor.a.b(r2.b.getVersion(), "interaction", "overflow", r2.c.getMonitorData(), r6, null, r2.b.isStreamingMode(), null, 160);
                return;
            L25:
                return;
            L24:
                return;
            }

            public a(MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel r1, j18.f<CallbackProcessResponse> r2, LKEvent r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public b(LKEvent r1, List<String> r2, MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel r3, j18.f<CallbackProcessResponse> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            ((UDActionPanelBuilder) new UDActionPanelBuilder(this.a.getContext()).items(this.b).itemClickListener(new a(this.c, this.d, this.a)).addActionButton(2131391775, 2131891960, null)).show();
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

    public MsgCardShowOverflowPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {MSG_CARD_SHOW_OVERFLOW})
    public final void msgCardShowOverflow(LKEvent r4, MsgCardShowOverflowPluginModel$MsgCardShowOverflowRequestModel r5, j18.f<CallbackProcessResponse> r6) {
        Intrinsics.checkNotNullParameter(r4, "lkEvent");
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "invokeCallback");
        ArrayList r0 = new ArrayList();
        Iterator<MsgCardShowOverflowPluginModel$OptionsItemModel> r1 = r5.options.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().text);
        goto L4
    L6:
        mz7.b.a(new b(r4, r0, r5, r6));
    }
}
