package com.larus.xbridge.custom;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "flow.longPressServiceBotCard", owner = "huangweijie")
public final class f1 extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "flow.longPressServiceBotCard")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = LynxAccessibilityModule.MSG_CONTENT, required = true)
        String getContent();

        @XBridgeParamField(isGetter = true, keyPath = "longPressPositionX", required = true)
        Integer getLongPressPositionX();

        @XBridgeParamField(isGetter = true, keyPath = "longPressPositionY", required = true)
        Integer getLongPressPositionY();

        @XBridgeParamField(isGetter = true, keyPath = "messageId", required = true)
        String getMessageId();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public f1() {
        this.a = "flow.longPressServiceBotCard";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r8, XBaseParamModel r9, CompletionBlock r10) {
        b r11 = (b) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        Activity r0 = r8.getOwnerActivity();
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[handle] ");
        r2.append(r11);
        r2.append(", activity=");
        if (r0 == null) goto L5;
        String r4 = r0.getLocalClassName();
    L6:
        r2.append(r4);
        r2.append(' ');
        r2.append(r8.getEngineView());
        r1.i("FlowLongPressServiceBotCardMethod", r2.toString());
        cf8.b r3 = new cf8.b(r11.getMessageId(), r11.getContent(), r11.getLongPressPositionX(), r11.getLongPressPositionY());
        i2 r12 = i2.a;
        View r13 = r8.getEngineView();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.DATA_KEY);
        if (r0 == null) goto L15;
        if (r13 == null) goto L15;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L12
        Result.constructor-impl(Boolean.valueOf(r13.performHapticFeedback(0)));     // Catch: Throwable -> L12
    L14:
        IAIChatService.a.o7().a(r0, r13, r3);
    L16:
        CompletionBlock.DefaultImpls.onSuccess$default(r10, ne7.e.b(c.class), null, 2, null);
        return;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        r1.w("ServiceBotCardLongPressHandler", "long press ignored because context or anchor view is missing");
        goto L16
    L5:
        r4 = null;
        goto L6
    }
}
