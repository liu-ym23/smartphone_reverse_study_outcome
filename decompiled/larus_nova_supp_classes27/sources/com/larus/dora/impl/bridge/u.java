package com.larus.dora.impl.bridge;

import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
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
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.base.openWeb")
public final class u extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.base.openWeb")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "opened", required = BuildConfig.DEBUG)
        Boolean getOpened();

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "opened", required = BuildConfig.DEBUG)
        void setOpened(Boolean r1);
    }

    static {
    }

    public u() {
        this.a = "dora.base.openWeb";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r3, XBaseParamModel r4, CompletionBlock r5) {
        b r6 = (b) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        String r7 = r6.getUrl();
        boolean r8 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L18:
        r5.onFailure(-3, "url must be http/https", ne7.e.b(c.class));
        return;
    L11:
        if (StringsKt.startsWith(r7, "https://", true) == false) goto L13;
    L14:
        r8 = true;
    L15:
        if (r8 == false) goto L18;
        int r9 = t.a;
        Intrinsics.checkNotNullParameter(r7, "url");
        boolean r10 = t.a(new Intent("android.intent.action.VIEW", UriProtector.parse(r7)), r7);
        FLogger.a.i("DoraOpenWebMethod", "dora.base.openWeb opened=" + r10);
        c r11 = ne7.e.b(c.class);
        r11.setOpened(Boolean.valueOf(r10));
        CompletionBlock.DefaultImpls.onSuccess$default(r5, r11, null, 2, null);
        return;
    L13:
        if (StringsKt.startsWith(r7, "http://", true) == false) goto L15;
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r1 = false;
        goto L9
    }
}
