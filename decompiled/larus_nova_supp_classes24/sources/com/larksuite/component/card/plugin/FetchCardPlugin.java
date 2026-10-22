package com.larksuite.component.card.plugin;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.FetchUniversalCardRequest;
import com.bytedance.lark.pb.openplatform.v1.FetchUniversalCardResponse;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.sdk.SdkSender;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0003\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/plugin/FetchCardPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "fetchCard", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/FetchCardPlugin$FetchCardProfileRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "Companion", "FetchCardProfileRequest", "FetchCardProfileResponse", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FetchCardPlugin extends OPPlugin {
    public static final a Companion = null;
    public static final int SERVER_ERROR = 599;
    public static final String TAG = "FetchCardPlugin";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/card/plugin/FetchCardPlugin$FetchCardProfileRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class FetchCardProfileRequest extends LKBaseRequestModel {
        public FetchCardProfileRequest() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/card/plugin/FetchCardPlugin$FetchCardProfileResponse;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class FetchCardProfileResponse extends LKBaseResponseModel {
        public FetchCardProfileResponse() {
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements SdkSender.IParser {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object parse(byte[] r2) {
            return (FetchUniversalCardResponse) FetchUniversalCardResponse.ADAPTER.decode(r2);
        }
    }

    static {
        Companion = new a();
    }

    public FetchCardPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"universalCardFetchCard"})
    public final void fetchCard(LKEvent r3, FetchCardProfileRequest r4, final j18.f<LKBaseResponseModel> r5) {
        Intrinsics.checkNotNullParameter(r3, "lkEvent");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "invokeCallback");
        Object r6 = r3.h;
        com.larksuite.component.card.cardcontainer.c r0 = null;
        if ((r6 instanceof ILynxBridgeContext) == false) goto L5;
        ILynxBridgeContext r7 = (ILynxBridgeContext) r6;
    L6:
        if (r7 == null) goto L12;
        ILynxContainerContext r8 = r7.getContainerContext();
        if (r8 == null) goto L12;
        Map r9 = r8.getBizExtra();
        if (r9 == null) goto L12;
        Object r10 = r9.get("card_share_data");
    L14:
        if ((r10 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L17;
        r0 = (com.larksuite.component.card.cardcontainer.c) r10;
    L17:
        if (r0 != null) goto L20;
        Log.e(TAG, "get cardShareData error");
        FetchCardProfileResponse r11 = new FetchCardProfileResponse();
        r11.setApiErrNo(o18.a.e);
        r5.callback(r11);
        return;
    L20:
        FetchUniversalCardRequest.Builder r12 = new FetchUniversalCardRequest.Builder().host_card_id(r0.b.getHostCardId()).biz_id(r0.c.getBizContext().getBizId()).biz_type(r0.c.getBizContext().getBizType());
        Log.i(TAG, "start fetch card");
        SdkSender.asynSendRequestNonWrap(Command.REQUEST_UNIVERSAL_CARD, r12, new AnonymousClass1(r5), b.a);
        return;
    L12:
        r10 = null;
        goto L14
    L5:
        r7 = null;
        goto L6
    }
}
