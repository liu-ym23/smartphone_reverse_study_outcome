package com.larksuite.component.card.plugin;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.card.protocol.context.StreamingState;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0003\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/plugin/UpdateStreamingStatePlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "updateStreamingState", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/UpdateStreamingStatePlugin$UpdateStreamingStateRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "UpdateStreamingStateRequest", "StreamingPhaseConsts", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UpdateStreamingStatePlugin extends OPPlugin {
    public static final a Companion = null;
    private static final String TAG = "UpdateStreamingStatePlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/plugin/UpdateStreamingStatePlugin$UpdateStreamingStateRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "streamingPhase", "", "getStreamingPhase", "()Ljava/lang/String;", "setStreamingPhase", "(Ljava/lang/String;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class UpdateStreamingStateRequest extends LKBaseRequestModel {

        @JSONField(name = "streamingPhase")
        private String streamingPhase;

        public UpdateStreamingStateRequest() {
        }

        public final String getStreamingPhase() {
            return this.streamingPhase;
        }

        public final void setStreamingPhase(String r1) {
            this.streamingPhase = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ com.larksuite.component.card.cardcontainer.c a;
        public final /* synthetic */ StreamingState.StreamingPhase b;

        public b(com.larksuite.component.card.cardcontainer.c r1, StreamingState.StreamingPhase r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.getDependency().updateStreamingState(this.b);     // Catch: Throwable -> L4
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

    public UpdateStreamingStatePlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"universalCardUpdateStreamingState"})
    public final void updateStreamingState(LKEvent r4, UpdateStreamingStateRequest r5, j18.f<LKBaseResponseModel> r6) {
        Intrinsics.checkNotNullParameter(r4, "lkEvent");
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "invokeCallback");
        Log.i(TAG, "updateStreamingState: " + r5.getStreamingPhase());
        Object r7 = r4.h;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r8 = ((ILynxBridgeContext) r7).getContainerContext();
        StreamingState.StreamingPhase r0 = null;
        if (r8 == null) goto L7;
        Map r9 = r8.getBizExtra();
        if (r9 == null) goto L7;
        Object r10 = r9.get("card_share_data");
    L9:
        if ((r10 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L11;
        com.larksuite.component.card.cardcontainer.c r11 = (com.larksuite.component.card.cardcontainer.c) r10;
    L12:
        if (r11 != null) goto L15;
        Log.e(TAG, "shareData is null");
        LKBaseResponseModel r12 = new LKBaseResponseModel();
        r12.setApiErrNo(o18.a.e);
        r6.callback(r12);
        return;
    L15:
        String r13 = r5.getStreamingPhase();
        if (r13 != null) goto L18;
    L27:
        Log.e(TAG, "streamingPhase is null");
        LKBaseResponseModel r14 = new LKBaseResponseModel();
        r14.setApiErrNo(o18.a.e);
        r6.callback(r14);
        return;
    L18:
        if (Intrinsics.areEqual(r13, "idle") == false) goto L21;
        r0 = StreamingState.StreamingPhase.IDLE;
    L23:
        if (r0 == null) goto L27;
        mz7.b.a(new b(r11, r0));
        r6.callback(new LKBaseResponseModel());
        return;
    L21:
        if (Intrinsics.areEqual(r13, "inStreaming") == false) goto L23;
        r0 = StreamingState.StreamingPhase.IN_STREAMING;
        goto L23
    L11:
        r11 = null;
    L7:
        r10 = null;
        goto L9
    }
}
