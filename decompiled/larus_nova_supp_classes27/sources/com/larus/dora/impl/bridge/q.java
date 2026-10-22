package com.larus.dora.impl.bridge;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
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
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.health.openCalendar")
public final class q extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.health.openCalendar")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "date", required = true)
        String getDate();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public q() {
        this.a = "dora.health.openCalendar";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r3, XBaseParamModel r4, CompletionBlock r5) {
        b r6 = (b) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        String r7 = r6.getDate();
        if (r7 == null) goto L5;
        String r8 = StringsKt.trim(r7).toString();
    L6:
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        if (r8.length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        r5.onFailure(-3, "date is required", ne7.e.b(c.class));
        return;
    L14:
        Intent r1 = new Intent("com.larus.dora.health.OPEN_CALENDAR");
        r1.putExtra("date", r8);
        gd9.i r2 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r2);
        LocalBroadcastManager.getInstance(r2.getApplication()).sendBroadcast(r1);
        FLogger.a.i("DoraHealthOpenCalendarMethod", "dora.health.openCalendar date=".concat(r8));
        CompletionBlock.DefaultImpls.onSuccess$default(r5, ne7.e.b(c.class), null, 2, null);
        return;
    L11:
        r0 = false;
        goto L12
    L5:
        r8 = null;
        goto L6
    }
}
